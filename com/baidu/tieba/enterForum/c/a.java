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
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes16.dex */
public class a {
    private RecentlyVisitedForumData huL;
    private boolean huM;
    private InterfaceC0668a huN;
    private CustomMessageListener huO;
    private com.baidu.adp.framework.listener.a huP;
    private boolean isFromCache;
    private boolean isLoading;
    private CustomMessageListener mAccountChangeListener;

    /* renamed from: com.baidu.tieba.enterForum.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0668a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void vW(int i);
    }

    public static a cfc() {
        return b.huR;
    }

    public void a(InterfaceC0668a interfaceC0668a) {
        this.huN = interfaceC0668a;
    }

    public void cfd() {
        if (!this.isLoading) {
            RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
            recentlyVisitedForumRequestMessage.setForumData(this.huL.getForumData());
            this.isLoading = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
        }
    }

    public String cfe() {
        if (this.huL == null || this.huL.getForumData() == null || this.huL.getForumData().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.huL.getForumData());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.brf());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void cff() {
        if (!this.huM) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.c.a.1
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                    if (dw != null && a.this.huL != null) {
                        dw.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.huL));
                    }
                    return null;
                }
            }, null);
        }
    }

    public void c(VisitedForumData visitedForumData) {
        e(visitedForumData);
    }

    public void cfg() {
        if (this.huN != null) {
            this.huN.b(this.huL.getForumData(), this.isFromCache);
        }
    }

    public void onNotify() {
        if (this.huN != null) {
            this.huN.onNotify();
        }
    }

    private a() {
        this.huM = false;
        this.isLoading = false;
        this.huO = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.3
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
                    a.this.cfh();
                }
            }
        };
        this.huP = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.5
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
        this.huL = new RecentlyVisitedForumData();
        registerTask();
        registerListener();
        cfh();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, 1003394, Config.GET_HISTORY_FORUM, RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.c(1003395, Config.DELETE_HISTORY_FORUM, null, false, false, false, false);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.huP);
        MessageManager.getInstance().registerListener(this.huO);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    /* loaded from: classes16.dex */
    private static class b {
        private static a huR = new a();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.huL.a(visitedForumData);
            this.huL.vV(20);
            cfg();
            cff();
        }
    }

    private void e(VisitedForumData visitedForumData) {
        int b2;
        if (visitedForumData != null && (b2 = this.huL.b(visitedForumData)) >= 0) {
            if (this.huN != null) {
                this.huN.vW(b2);
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
            this.huL.setForumData(linkedList);
            this.huL.vV(20);
            this.isFromCache = z;
            cfg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        this.huM = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dw == null || at.isEmpty(dw.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dw.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dw != null) {
                        dw.setForever("recently_visited_forum", "");
                    }
                    l<String> dw2 = com.baidu.tbadk.core.c.a.bhb().dw("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dw2 != null && !StringUtils.isNull(dw2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dw2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dw2.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
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
                a.this.huM = false;
                if (recentlyVisitedForumData != null) {
                    a.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
