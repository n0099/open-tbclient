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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_forum";
    public static final String LOCAL_ACCOUNT = "local";
    private boolean aTX;
    a cYT;
    private boolean cYU = false;
    private boolean isLoading = false;
    CustomMessageListener cYV = new CustomMessageListener(2016564) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                RecentlyVisitedForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener bsI = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                RecentlyVisitedForumModel.this.aqJ();
            }
        }
    };
    com.baidu.adp.framework.listener.a cYW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.3
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
    RecentlyVisitedForumData cYS = new RecentlyVisitedForumData();

    /* loaded from: classes2.dex */
    public interface a {
        void aqL();

        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void kh(int i);
    }

    public RecentlyVisitedForumModel() {
        registerTask();
        registerListener();
        aqJ();
    }

    public void a(a aVar) {
        this.cYT = aVar;
    }

    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.cYS.setForumData(linkedList);
            this.aTX = z;
            if (this.cYT != null) {
                this.cYT.b(this.cYS.getForumData(), z);
            }
        }
    }

    public void refresh() {
        if (this.cYT != null) {
            this.cYT.b(this.cYS.getForumData(), this.aTX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.cYS.a(visitedForumData);
        }
    }

    public void d(VisitedForumData visitedForumData) {
        int b;
        if (visitedForumData != null && (b = this.cYS.b(visitedForumData)) >= 0) {
            if (this.cYT != null) {
                this.cYT.kh(b);
            }
            e(visitedForumData);
        }
    }

    public void onPrimary() {
        if (this.cYT != null) {
            this.cYT.aqL();
        }
        LoadData();
    }

    public void onPause() {
        if (!this.cYU) {
            aqK();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYW);
        MessageManager.getInstance().unRegisterListener(this.cYV);
        MessageManager.getInstance().unRegisterListener(this.bsI);
    }

    private void e(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", com.baidu.adp.lib.g.b.d(visitedForumData.getForumId(), 0L));
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
        recentlyVisitedForumRequestMessage.setForumData(this.cYS.getForumData());
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
        MessageManager.getInstance().registerListener(this.cYW);
        MessageManager.getInstance().registerListener(this.cYV);
        MessageManager.getInstance().registerListener(this.bsI);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        this.cYU = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData = null;
                l<String> X = com.baidu.tbadk.core.c.a.yh().X("tb.recently_visited_forum", RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                if (X != null && !ao.isEmpty(X.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(X.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (X != null) {
                        X.e(RecentlyVisitedForumModel.CACHE_KEY, "");
                    }
                    l<String> X2 = com.baidu.tbadk.core.c.a.yh().X("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (X2 != null && !ao.isEmpty(X2.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                        RecentlyVisitedForumData recentlyVisitedForumData2 = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(X2.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                        if (recentlyVisitedForumData != null) {
                            recentlyVisitedForumData.a(recentlyVisitedForumData2);
                            X2.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
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
                RecentlyVisitedForumModel.this.cYU = false;
                if (recentlyVisitedForumData != null) {
                    RecentlyVisitedForumModel.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void aqK() {
        x.a(new w<Object>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.5
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> X = com.baidu.tbadk.core.c.a.yh().X("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? RecentlyVisitedForumModel.LOCAL_ACCOUNT : TbadkCoreApplication.getCurrentAccount());
                if (X != null && RecentlyVisitedForumModel.this.cYS != null) {
                    X.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(RecentlyVisitedForumModel.this.cYS));
                }
                return null;
            }
        }, null);
    }
}
