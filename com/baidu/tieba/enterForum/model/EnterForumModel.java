package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.data.d;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.j;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* loaded from: classes2.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    CustomMessageListener iIF;
    private d iLJ;
    RecentlyVisitedForumData iLK;
    private b iLL;
    private com.baidu.tieba.tbadkCore.d.b iLM;
    private boolean iLN;
    private boolean iLO;
    private long iLP;
    private long iLQ;
    private long iLR;
    private long iLS;

    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);
    }

    public void pS(boolean z) {
        this.iLN = z;
    }

    /* loaded from: classes2.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d iLU = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iLJ = null;
        this.iLL = null;
        this.iLM = null;
        this.iLN = false;
        this.iLO = false;
        this.iLP = 0L;
        this.iLQ = 0L;
        this.iLR = 0L;
        this.iLS = 0L;
        this.iIF = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.iLK = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.iIF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cwH() {
        return this.iLS;
    }

    public long cwI() {
        return this.iLQ;
    }

    public long cwJ() {
        return this.iLR;
    }

    public long cwK() {
        return this.iLP;
    }

    public d cwL() {
        return this.iLJ;
    }

    public boolean cwM() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.iLJ == null || this.iLJ.cvf() == null) {
            return true;
        }
        return this.iLJ.cvf().cvk();
    }

    public boolean cwN() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("enter_forum_create_forum", true) && this.iLJ != null && this.iLJ.cvf() != null) {
            return this.iLJ.cvf().cvj();
        }
        return false;
    }

    public void c(d dVar) {
        this.iLJ = dVar;
    }

    public void a(b bVar) {
        this.iLL = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        cwO();
        return true;
    }

    private void cwO() {
        if (this.iLM != null) {
            this.iLM.destory();
            this.iLM = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iIF);
    }

    public void onPause() {
        cvM();
    }

    public boolean pT(boolean z) {
        return A(z, com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean A(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.iLK.getForumData());
        this.iLP = System.currentTimeMillis();
        if (this.iLM == null) {
            this.iLM = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean pU(boolean z) {
        pV(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.iLM != null) {
            this.iLM.a(z2, z3, i, str, i2, j, j2);
            this.iLM = null;
        }
        if (z || !this.iLJ.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.iLU = this.iLJ;
            this.iLL.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.iLU = this.iLJ;
        this.iLL.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendsocketresponsemessage.getErrorString();
        }
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), errorString, false, downSize, 0L, costTime);
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        int downSize = forumrecommendhttpresponsemessage.getDownSize();
        long costTime = forumrecommendhttpresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.iLJ = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.iLN = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.iLJ = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.iLJ.a(aVar);
                this.iLJ.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bp(forumrecommendhttpresponsemessage.GetLikeForum());
                this.iLJ.a(gVar);
                bo boVar = new bo();
                boVar.bo(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.iLJ.c(boVar);
                this.iLJ.setIsSuccess(true);
                this.iLJ.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.iLJ.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.iLJ.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.iLJ.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cO(forumrecommendhttpresponsemessage.getTabFeedList());
                this.iLJ.a(jVar);
            } catch (Exception e) {
                this.iLJ.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.iLJ = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.iLJ.a(aVar);
                this.iLJ.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bp(forumrecommendsocketresponsemessage.GetLikeForum());
                this.iLJ.a(gVar);
                bo boVar = new bo();
                boVar.bo(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.iLJ.c(boVar);
                this.iLJ.setIsSuccess(true);
                this.iLJ.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.iLJ.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.iLJ.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.iLJ.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cO(forumrecommendsocketresponsemessage.getTabFeedList());
                this.iLJ.a(jVar);
            } catch (Exception e) {
                this.iLJ.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void pV(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: i */
            public d doInBackground(Void... voidArr) {
                l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = dE.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    dVar.setIsSuccess(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            dVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        dVar.setIsSuccess(false);
                    }
                    if (dVar.isSuccess() && !dVar.cvh()) {
                        dVar.cvd().cvA();
                    }
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(d dVar) {
                super.onPostExecute(dVar);
                a aVar = new a();
                aVar.type = 0;
                if (dVar != null && dVar.isSuccess()) {
                    aVar.isOk = true;
                    aVar.iLU = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.iLU = dVar;
                }
                EnterForumModel.this.iLL.a(aVar);
            }
        }.execute(new Void[0]);
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                RecentlyVisitedForumData recentlyVisitedForumData2 = null;
                l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dF == null || StringUtils.isNull(dF.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dF.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dF.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
                    return null;
                }
                return recentlyVisitedForumData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
                if (recentlyVisitedForumData != null) {
                    EnterForumModel.this.iLK.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.iLK.xA(200);
                }
                EnterForumModel.this.pT(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void cvM() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dF != null && EnterForumModel.this.iLK != null) {
                        dF.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.iLK));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.iLJ != null) {
            int size = this.iLJ.cvd().cvz().size();
            for (int i = 0; i < size; i++) {
                if (this.iLJ.cvd().cvz().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.iLK.a(visitedForumData);
                    this.iLK.xA(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.iLK.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.iLK.getForumData().get(i2);
                if (!au.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.iLK.getForumData().remove(i);
            }
        }
    }

    public List<f> a(List<f> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (f fVar : list) {
                    if (fVar != null && fVar.getName() != null && fVar.getName().equals(str)) {
                        arrayList.add(fVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f fVar2 = list.get(i);
                if (!arrayList.contains(fVar2)) {
                    arrayList.add(fVar2);
                }
            }
        }
        return arrayList;
    }
}
