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
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_forum";
    public static final String LOCAL_ACCOUNT = "local";
    private boolean aPM;
    a cSv;
    private boolean cSw = false;
    private boolean isLoading = false;
    CustomMessageListener cSx = new CustomMessageListener(2016564) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                RecentlyVisitedForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener bkM = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                RecentlyVisitedForumModel.this.aoZ();
            }
        }
    };
    com.baidu.adp.framework.listener.a cSy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.3
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
    RecentlyVisitedForumData cSu = new RecentlyVisitedForumData();

    /* loaded from: classes2.dex */
    public interface a {
        void apb();

        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void jz(int i);
    }

    public RecentlyVisitedForumModel() {
        registerTask();
        registerListener();
        aoZ();
    }

    public void a(a aVar) {
        this.cSv = aVar;
    }

    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.cSu.setForumData(linkedList);
            this.aPM = z;
            if (this.cSv != null) {
                this.cSv.b(this.cSu.getForumData(), z);
            }
        }
    }

    public void refresh() {
        if (this.cSv != null) {
            this.cSv.b(this.cSu.getForumData(), this.aPM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.cSu.a(visitedForumData);
        }
    }

    public void d(VisitedForumData visitedForumData) {
        int b;
        if (visitedForumData != null && (b = this.cSu.b(visitedForumData)) >= 0) {
            if (this.cSv != null) {
                this.cSv.jz(b);
            }
            e(visitedForumData);
        }
    }

    public void onPrimary() {
        if (this.cSv != null) {
            this.cSv.apb();
        }
        LoadData();
    }

    public void onPause() {
        if (!this.cSw) {
            apa();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cSy);
        MessageManager.getInstance().unRegisterListener(this.cSx);
        MessageManager.getInstance().unRegisterListener(this.bkM);
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
        recentlyVisitedForumRequestMessage.setForumData(this.cSu.getForumData());
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
        MessageManager.getInstance().registerListener(this.cSy);
        MessageManager.getInstance().registerListener(this.cSx);
        MessageManager.getInstance().registerListener(this.bkM);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoZ() {
        this.cSw = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData = null;
                l<String> R = com.baidu.tbadk.core.c.a.wW().R("tb.recently_visited_forum", RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                if (R != null && !ao.isEmpty(R.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(R.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (R != null) {
                        R.e(RecentlyVisitedForumModel.CACHE_KEY, "");
                    }
                    l<String> R2 = com.baidu.tbadk.core.c.a.wW().R("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (R2 != null && !ao.isEmpty(R2.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                        RecentlyVisitedForumData recentlyVisitedForumData2 = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(R2.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                        if (recentlyVisitedForumData != null) {
                            recentlyVisitedForumData.a(recentlyVisitedForumData2);
                            R2.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
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
                RecentlyVisitedForumModel.this.cSw = false;
                if (recentlyVisitedForumData != null) {
                    RecentlyVisitedForumModel.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void apa() {
        w.a(new v<Object>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.5
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                l<String> R = com.baidu.tbadk.core.c.a.wW().R("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? RecentlyVisitedForumModel.LOCAL_ACCOUNT : TbadkCoreApplication.getCurrentAccount());
                if (R != null && RecentlyVisitedForumModel.this.cSu != null) {
                    R.e(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(RecentlyVisitedForumModel.this.cSu));
                }
                return null;
            }
        }, null);
    }
}
