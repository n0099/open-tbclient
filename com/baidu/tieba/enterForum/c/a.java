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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
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
    private RecentlyVisitedForumData ijp;
    private boolean ijq;
    private InterfaceC0713a ijr;
    private CustomMessageListener ijs;
    private com.baidu.adp.framework.listener.a ijt;
    private boolean isFromCache;
    private boolean isLoading;
    private CustomMessageListener mAccountChangeListener;

    /* renamed from: com.baidu.tieba.enterForum.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0713a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void xH(int i);
    }

    public static a crw() {
        return b.ijv;
    }

    public void a(InterfaceC0713a interfaceC0713a) {
        this.ijr = interfaceC0713a;
    }

    public void crx() {
        if (!this.isLoading) {
            RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
            recentlyVisitedForumRequestMessage.setForumData(this.ijp.getForumData());
            this.isLoading = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
        }
    }

    public String cry() {
        if (this.ijp == null || this.ijp.getForumData() == null || this.ijp.getForumData().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.ijp.getForumData());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.bzc());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void crz() {
        if (!this.ijq) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.enterForum.c.a.1
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                    if (dI != null && a.this.ijp != null) {
                        dI.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.ijp));
                    }
                    return null;
                }
            }, null);
        }
    }

    public void c(VisitedForumData visitedForumData) {
        e(visitedForumData);
    }

    public void crA() {
        if (this.ijr != null) {
            this.ijr.b(this.ijp.getForumData(), this.isFromCache);
        }
    }

    public void onNotify() {
        if (this.ijr != null) {
            this.ijr.onNotify();
        }
    }

    private a() {
        this.ijq = false;
        this.isLoading = false;
        this.ijs = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.3
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
                    a.this.crC();
                }
            }
        };
        this.ijt = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.5
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
        this.ijp = new RecentlyVisitedForumData();
        registerListener();
        crC();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.ijt);
        MessageManager.getInstance().registerListener(this.ijs);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static a ijv = new a();
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

    public RecentlyVisitedForumData crB() {
        return this.ijp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.ijp.a(visitedForumData);
            this.ijp.xG(20);
            crA();
            crz();
            crw().crx();
        }
    }

    private void e(VisitedForumData visitedForumData) {
        int b2;
        if (visitedForumData != null && (b2 = this.ijp.b(visitedForumData)) >= 0) {
            if (this.ijr != null) {
                this.ijr.xH(b2);
            }
            f(visitedForumData);
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
            this.ijp.setForumData(linkedList);
            this.ijp.xG(20);
            this.isFromCache = z;
            crA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crC() {
        this.ijq = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dI == null || at.isEmpty(dI.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dI.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dI != null) {
                        dI.setForever("recently_visited_forum", "");
                    }
                    l<String> dI2 = com.baidu.tbadk.core.c.a.boX().dI("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dI2 != null && !StringUtils.isNull(dI2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dI2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dI2.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
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
                a.this.ijq = false;
                if (recentlyVisitedForumData != null) {
                    a.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
