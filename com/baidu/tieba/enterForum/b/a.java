package com.baidu.tieba.enterForum.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumSocketResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private RecentlyVisitedForumData iHl;
    private boolean iHm;
    private InterfaceC0721a iHn;
    private CustomMessageListener iHo;
    private com.baidu.adp.framework.listener.a iHp;
    private boolean isFromCache;
    private boolean isLoading;
    private CustomMessageListener mAccountChangeListener;

    /* renamed from: com.baidu.tieba.enterForum.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0721a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void yX(int i);
    }

    public static a cyh() {
        return b.iHr;
    }

    public void a(InterfaceC0721a interfaceC0721a) {
        this.iHn = interfaceC0721a;
    }

    public void cyi() {
        if (!this.isLoading) {
            RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
            recentlyVisitedForumRequestMessage.setForumData(this.iHl.getForumData());
            this.isLoading = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
        }
    }

    public String cyj() {
        if (this.iHl == null || this.iHl.getForumData() == null || this.iHl.getForumData().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.iHl.getForumData());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.bEn());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void cyk() {
        if (!this.iHm) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.enterForum.b.a.1
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    l<String> dM = com.baidu.tbadk.core.c.a.btS().dM("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                    if (dM != null && a.this.iHl != null) {
                        dM.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.iHl));
                    }
                    return null;
                }
            }, null);
        }
    }

    public void c(VisitedForumData visitedForumData) {
        e(visitedForumData);
    }

    public void cyl() {
        if (this.iHn != null) {
            this.iHn.b(this.iHl.getForumData(), this.isFromCache);
        }
    }

    public void onNotify() {
        if (this.iHn != null) {
            this.iHn.onNotify();
        }
    }

    private a() {
        this.iHm = false;
        this.isLoading = false;
        this.iHo = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.b.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    a.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        this.mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.enterForum.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cyn();
                }
            }
        };
        this.iHp = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.b.a.5
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.isLoading = false;
                if (responsedMessage != null) {
                    if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                        a.this.a((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
                    } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                        a.this.a((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                    }
                }
            }
        };
        this.iHl = new RecentlyVisitedForumData();
        registerListener();
        cyn();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.iHp);
        MessageManager.getInstance().registerListener(this.iHo);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static a iHr = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        if (recentlyVisitedForumHttpResponseMessage != null && recentlyVisitedForumHttpResponseMessage.getForumData() != null) {
            a(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentlyVisitedForumSocketResponseMessage recentlyVisitedForumSocketResponseMessage) {
        if (recentlyVisitedForumSocketResponseMessage != null && recentlyVisitedForumSocketResponseMessage.getForumData() != null) {
            a(recentlyVisitedForumSocketResponseMessage.getForumData(), false);
        }
    }

    public RecentlyVisitedForumData cym() {
        return this.iHl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.iHl.a(visitedForumData);
            this.iHl.yW(20);
            cyl();
            cyk();
            cyh().cyi();
        }
    }

    private void e(VisitedForumData visitedForumData) {
        int b2;
        if (visitedForumData != null && (b2 = this.iHl.b(visitedForumData)) >= 0) {
            if (this.iHn != null) {
                this.iHn.yX(b2);
            }
            f(visitedForumData);
            cyk();
        }
    }

    private void f(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1003395);
            httpMessage.addParam("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.iHl.setForumData(linkedList);
            this.iHl.yW(20);
            this.isFromCache = z;
            cyl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyn() {
        this.iHm = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dM = com.baidu.tbadk.core.c.a.btS().dM("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dM == null || at.isEmpty(dM.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dM.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dM != null) {
                        dM.setForever("recently_visited_forum", "");
                    }
                    l<String> dM2 = com.baidu.tbadk.core.c.a.btS().dM("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dM2 != null && !StringUtils.isNull(dM2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dM2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dM2.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
                            return recentlyVisitedForumData2;
                        }
                        return recentlyVisitedForumData;
                    }
                    return recentlyVisitedForumData2;
                }
                return recentlyVisitedForumData2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
                a.this.iHm = false;
                if (recentlyVisitedForumData != null) {
                    a.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
