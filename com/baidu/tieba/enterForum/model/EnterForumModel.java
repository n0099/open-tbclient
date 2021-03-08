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
    CustomMessageListener iKo;
    private long iNA;
    private long iNB;
    private d iNs;
    RecentlyVisitedForumData iNt;
    private b iNu;
    private com.baidu.tieba.tbadkCore.d.b iNv;
    private boolean iNw;
    private boolean iNx;
    private long iNy;
    private long iNz;

    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);
    }

    public void pS(boolean z) {
        this.iNw = z;
    }

    /* loaded from: classes2.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d iND = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iNs = null;
        this.iNu = null;
        this.iNv = null;
        this.iNw = false;
        this.iNx = false;
        this.iNy = 0L;
        this.iNz = 0L;
        this.iNA = 0L;
        this.iNB = 0L;
        this.iKo = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.iNt = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.iKo);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cwN() {
        return this.iNB;
    }

    public long cwO() {
        return this.iNz;
    }

    public long cwP() {
        return this.iNA;
    }

    public long cwQ() {
        return this.iNy;
    }

    public d cwR() {
        return this.iNs;
    }

    public boolean cwS() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.iNs == null || this.iNs.cvl() == null) {
            return true;
        }
        return this.iNs.cvl().cvq();
    }

    public boolean cwT() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("enter_forum_create_forum", true) && this.iNs != null && this.iNs.cvl() != null) {
            return this.iNs.cvl().cvp();
        }
        return false;
    }

    public void c(d dVar) {
        this.iNs = dVar;
    }

    public void a(b bVar) {
        this.iNu = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        cwU();
        return true;
    }

    private void cwU() {
        if (this.iNv != null) {
            this.iNv.destory();
            this.iNv = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iKo);
    }

    public void onPause() {
        cvS();
    }

    public boolean pT(boolean z) {
        return A(z, com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean A(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.iNt.getForumData());
        this.iNy = System.currentTimeMillis();
        if (this.iNv == null) {
            this.iNv = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
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
        if (this.iNv != null) {
            this.iNv.a(z2, z3, i, str, i2, j, j2);
            this.iNv = null;
        }
        if (z || !this.iNs.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.iND = this.iNs;
            this.iNu.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.iND = this.iNs;
        this.iNu.a(aVar);
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
            this.iNs = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.iNw = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.iNs = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.iNs.a(aVar);
                this.iNs.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bp(forumrecommendhttpresponsemessage.GetLikeForum());
                this.iNs.a(gVar);
                bo boVar = new bo();
                boVar.bo(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.iNs.c(boVar);
                this.iNs.setIsSuccess(true);
                this.iNs.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.iNs.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.iNs.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.iNs.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cO(forumrecommendhttpresponsemessage.getTabFeedList());
                this.iNs.a(jVar);
            } catch (Exception e) {
                this.iNs.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.iNs = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.iNs.a(aVar);
                this.iNs.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bp(forumrecommendsocketresponsemessage.GetLikeForum());
                this.iNs.a(gVar);
                bo boVar = new bo();
                boVar.bo(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.iNs.c(boVar);
                this.iNs.setIsSuccess(true);
                this.iNs.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.iNs.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.iNs.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.iNs.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cO(forumrecommendsocketresponsemessage.getTabFeedList());
                this.iNs.a(jVar);
            } catch (Exception e) {
                this.iNs.setIsSuccess(false);
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
                l<byte[]> dE = com.baidu.tbadk.core.c.a.bqt().dE("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
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
                    if (dVar.isSuccess() && !dVar.cvn()) {
                        dVar.cvj().cvG();
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
                    aVar.iND = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.iND = dVar;
                }
                EnterForumModel.this.iNu.a(aVar);
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
                l<String> dF = com.baidu.tbadk.core.c.a.bqt().dF("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
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
                    EnterForumModel.this.iNt.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.iNt.xB(200);
                }
                EnterForumModel.this.pT(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void cvS() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    l<String> dF = com.baidu.tbadk.core.c.a.bqt().dF("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dF != null && EnterForumModel.this.iNt != null) {
                        dF.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.iNt));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.iNs != null) {
            int size = this.iNs.cvj().cvF().size();
            for (int i = 0; i < size; i++) {
                if (this.iNs.cvj().cvF().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.iNt.a(visitedForumData);
                    this.iNt.xB(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.iNt.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.iNt.getForumData().get(i2);
                if (!au.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.iNt.getForumData().remove(i);
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
