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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_forum";
    public static final String LOCAL_ACCOUNT = "local";
    a hjl;
    private boolean isFromCache;
    private boolean hjm = false;
    private boolean isLoading = false;
    CustomMessageListener hjn = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                RecentlyVisitedForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                RecentlyVisitedForumModel.this.bVA();
            }
        }
    };
    com.baidu.adp.framework.listener.a hjo = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.3
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
    RecentlyVisitedForumData hjk = new RecentlyVisitedForumData();

    /* loaded from: classes16.dex */
    public interface a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void tM(int i);
    }

    public RecentlyVisitedForumModel() {
        registerTask();
        registerListener();
        bVA();
    }

    public void a(a aVar) {
        this.hjl = aVar;
    }

    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.hjk.setForumData(linkedList);
            this.hjk.tG(20);
            this.isFromCache = z;
            if (this.hjl != null) {
                this.hjl.b(this.hjk.getForumData(), z);
            }
        }
    }

    public void refresh() {
        if (this.hjl != null) {
            this.hjl.b(this.hjk.getForumData(), this.isFromCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.hjk.a(visitedForumData);
            this.hjk.tG(20);
            refresh();
            onPause();
        }
    }

    public void d(VisitedForumData visitedForumData) {
        int b;
        if (visitedForumData != null && (b = this.hjk.b(visitedForumData)) >= 0) {
            if (this.hjl != null) {
                this.hjl.tM(b);
            }
            e(visitedForumData);
        }
    }

    public void onPrimary() {
        if (this.hjl != null) {
            this.hjl.onNotify();
        }
        LoadData();
    }

    public void onPause() {
        if (!this.hjm) {
            bVB();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hjo);
        MessageManager.getInstance().unRegisterListener(this.hjn);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangeListener);
    }

    private void e(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1003395);
            httpMessage.addParam("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.hjk.getForumData());
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
        MessageManager.getInstance().registerListener(this.hjo);
        MessageManager.getInstance().registerListener(this.hjn);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, 1003394, Config.GET_HISTORY_FORUM, RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.c(1003395, Config.DELETE_HISTORY_FORUM, null, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVA() {
        this.hjm = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.recently_visited_forum", RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dg == null || as.isEmpty(dg.get(RecentlyVisitedForumModel.CACHE_KEY))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dg.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dg != null) {
                        dg.setForever(RecentlyVisitedForumModel.CACHE_KEY, "");
                    }
                    l<String> dg2 = com.baidu.tbadk.core.c.a.aYG().dg("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dg2 != null && !StringUtils.isNull(dg2.get(RecentlyVisitedForumModel.CACHE_KEY))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dg2.get(RecentlyVisitedForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dg2.setForever(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
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
                RecentlyVisitedForumModel.this.hjm = false;
                if (recentlyVisitedForumData != null) {
                    RecentlyVisitedForumModel.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bVB() {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? RecentlyVisitedForumModel.LOCAL_ACCOUNT : TbadkCoreApplication.getCurrentAccount());
                if (dg != null && RecentlyVisitedForumModel.this.hjk != null) {
                    dg.setForever(RecentlyVisitedForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(RecentlyVisitedForumModel.this.hjk));
                }
                return null;
            }
        }, null);
    }
}
