package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_forum";
    public static final String LOCAL_ACCOUNT = "local";
    private boolean aQI;
    a cTf;
    private boolean cTg = false;
    private boolean isLoading = false;
    CustomMessageListener cTh = new CustomMessageListener(2016564) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                RecentlyVisitedForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener bmR = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                RecentlyVisitedForumModel.this.aoU();
            }
        }
    };
    com.baidu.adp.framework.listener.a cTi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecentlyVisitedForumModel.this.isLoading = false;
            if (responsedMessage != null) {
                if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                    RecentlyVisitedForumModel.this.a((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                    RecentlyVisitedForumModel.this.a((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                }
            }
        }
    };
    RecentlyVisitedForumData cTe = new RecentlyVisitedForumData();

    /* loaded from: classes2.dex */
    public interface a {
        void aoW();

        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void jJ(int i);
    }

    public RecentlyVisitedForumModel() {
        registerTask();
        registerListener();
        aoU();
    }

    public void a(a aVar) {
        this.cTf = aVar;
    }

    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.cTe.setForumData(linkedList);
            this.aQI = z;
            if (this.cTf != null) {
                this.cTf.b(this.cTe.getForumData(), z);
            }
        }
    }

    public void refresh() {
        if (this.cTf != null) {
            this.cTf.b(this.cTe.getForumData(), this.aQI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.cTe.a(visitedForumData);
        }
    }

    public void d(VisitedForumData visitedForumData) {
        int b;
        if (visitedForumData != null && (b = this.cTe.b(visitedForumData)) >= 0) {
            if (this.cTf != null) {
                this.cTf.jJ(b);
            }
            e(visitedForumData);
        }
    }

    public void onPrimary() {
        if (this.cTf != null) {
            this.cTf.aoW();
        }
        LoadData();
    }

    public void onPause() {
        if (!this.cTg) {
            aoV();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cTi);
        MessageManager.getInstance().unRegisterListener(this.cTh);
        MessageManager.getInstance().unRegisterListener(this.bmR);
    }

    private void e(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", com.baidu.adp.lib.g.b.c(visitedForumData.getForumId(), 0L));
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.cTe.getForumData());
        sendMessage(recentlyVisitedForumRequestMessage);
        return true;
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

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.cTi);
        MessageManager.getInstance().registerListener(this.cTh);
        MessageManager.getInstance().registerListener(this.bmR);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoU() {
        this.cTg = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData = null;
                l<String> Q = com.baidu.tbadk.core.c.a.xb().Q("tb.recently_visited_forum", RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                if (Q != null && !ap.isEmpty(Q.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(Q.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (Q != null) {
                        Q.e(RecentlyVisitedForumModel.CACHE_KEY, "");
                    }
                    l<String> Q2 = com.baidu.tbadk.core.c.a.xb().Q("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (Q2 != null && !ap.isEmpty(Q2.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                        RecentlyVisitedForumData recentlyVisitedForumData2 = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(Q2.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                        if (recentlyVisitedForumData != null) {
                            recentlyVisitedForumData.a(recentlyVisitedForumData2);
                            Q2.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                            return recentlyVisitedForumData;
                        }
                        return recentlyVisitedForumData2;
                    }
                    return recentlyVisitedForumData;
                }
                return recentlyVisitedForumData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
                RecentlyVisitedForumModel.this.cTg = false;
                if (recentlyVisitedForumData != null) {
                    RecentlyVisitedForumModel.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void aoV() {
        v.a(new u<Object>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.5
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> Q = com.baidu.tbadk.core.c.a.xb().Q("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? RecentlyVisitedForumModel.LOCAL_ACCOUNT : TbadkCoreApplication.getCurrentAccount());
                if (Q != null && RecentlyVisitedForumModel.this.cTe != null) {
                    Q.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(RecentlyVisitedForumModel.this.cTe));
                }
                return null;
            }
        }, null);
    }
}
