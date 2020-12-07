package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
    private boolean isFromCache;
    private boolean isLoading;
    private RecentlyVisitedForumData iuW;
    private boolean iuX;
    private InterfaceC0730a iuY;
    private CustomMessageListener iuZ;
    private com.baidu.adp.framework.listener.a iva;
    private CustomMessageListener mAccountChangeListener;

    /* renamed from: com.baidu.tieba.enterForum.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0730a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void yK(int i);
    }

    public static a cvn() {
        return b.ivc;
    }

    public void a(InterfaceC0730a interfaceC0730a) {
        this.iuY = interfaceC0730a;
    }

    public void cvo() {
        if (!this.isLoading) {
            RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
            recentlyVisitedForumRequestMessage.setForumData(this.iuW.getForumData());
            this.isLoading = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
        }
    }

    public String cvp() {
        if (this.iuW == null || this.iuW.getForumData() == null || this.iuW.getForumData().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.iuW.getForumData());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.bBS());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void cvq() {
        if (!this.iuX) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.c.a.1
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    l<String> dN = com.baidu.tbadk.core.c.a.brq().dN("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                    if (dN != null && a.this.iuW != null) {
                        dN.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.iuW));
                    }
                    return null;
                }
            }, null);
        }
    }

    public void c(VisitedForumData visitedForumData) {
        e(visitedForumData);
    }

    public void cvr() {
        if (this.iuY != null) {
            this.iuY.b(this.iuW.getForumData(), this.isFromCache);
        }
    }

    public void onNotify() {
        if (this.iuY != null) {
            this.iuY.onNotify();
        }
    }

    private a() {
        this.iuX = false;
        this.isLoading = false;
        this.iuZ = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    a.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        this.mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.enterForum.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cvt();
                }
            }
        };
        this.iva = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.5
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
        this.iuW = new RecentlyVisitedForumData();
        registerListener();
        cvt();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.iva);
        MessageManager.getInstance().registerListener(this.iuZ);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static a ivc = new a();
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

    public RecentlyVisitedForumData cvs() {
        return this.iuW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.iuW.a(visitedForumData);
            this.iuW.yJ(20);
            cvr();
            cvq();
            cvn().cvo();
        }
    }

    private void e(VisitedForumData visitedForumData) {
        int b2;
        if (visitedForumData != null && (b2 = this.iuW.b(visitedForumData)) >= 0) {
            if (this.iuY != null) {
                this.iuY.yK(b2);
            }
            f(visitedForumData);
            cvq();
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
            this.iuW.setForumData(linkedList);
            this.iuW.yJ(20);
            this.isFromCache = z;
            cvr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvt() {
        this.iuX = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dN = com.baidu.tbadk.core.c.a.brq().dN("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dN == null || au.isEmpty(dN.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dN.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dN != null) {
                        dN.setForever("recently_visited_forum", "");
                    }
                    l<String> dN2 = com.baidu.tbadk.core.c.a.brq().dN("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dN2 != null && !StringUtils.isNull(dN2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dN2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dN2.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
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
                a.this.iuX = false;
                if (recentlyVisitedForumData != null) {
                    a.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
