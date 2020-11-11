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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
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
/* loaded from: classes22.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    CustomMessageListener ijs;
    private com.baidu.tieba.tbadkCore.d.b imA;
    private boolean imB;
    private boolean imC;
    private long imD;
    private long imE;
    private long imF;
    private long imG;
    private d imx;
    RecentlyVisitedForumData imy;
    private b imz;

    /* loaded from: classes22.dex */
    public interface b {
        void a(a aVar);
    }

    public void oQ(boolean z) {
        this.imB = z;
    }

    /* loaded from: classes22.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d imI = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.imx = null;
        this.imz = null;
        this.imA = null;
        this.imB = false;
        this.imC = false;
        this.imD = 0L;
        this.imE = 0L;
        this.imF = 0L;
        this.imG = 0L;
        this.ijs = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.imy = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.ijs);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cst() {
        return this.imG;
    }

    public long csu() {
        return this.imE;
    }

    public long csv() {
        return this.imF;
    }

    public long csw() {
        return this.imD;
    }

    public d csx() {
        return this.imx;
    }

    public boolean csy() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.imx == null || this.imx.cqS() == null) {
            return true;
        }
        return this.imx.cqS().cqX();
    }

    public boolean csz() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("enter_forum_create_forum", true) && this.imx != null && this.imx.cqS() != null) {
            return this.imx.cqS().cqW();
        }
        return false;
    }

    public void c(d dVar) {
        this.imx = dVar;
    }

    public void a(b bVar) {
        this.imz = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        csA();
        return true;
    }

    private void csA() {
        if (this.imA != null) {
            this.imA.destory();
            this.imA = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ijs);
    }

    public void onPause() {
        crz();
    }

    public boolean oR(boolean z) {
        return B(z, com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean B(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.imy.getForumData());
        this.imD = System.currentTimeMillis();
        if (this.imA == null) {
            this.imA = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean oS(boolean z) {
        oT(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.imA != null) {
            this.imA.a(z2, z3, i, str, i2, j, j2);
            this.imA = null;
        }
        if (z || !this.imx.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.imI = this.imx;
            this.imz.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.imI = this.imx;
        this.imz.a(aVar);
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
            this.imx = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.imB = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.imx = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.imx.a(aVar);
                this.imx.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bk(forumrecommendhttpresponsemessage.GetLikeForum());
                this.imx.a(gVar);
                bj bjVar = new bj();
                bjVar.bj(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.imx.c(bjVar);
                this.imx.setIsSuccess(true);
                this.imx.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.imx.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.imx.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.imx.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cI(forumrecommendhttpresponsemessage.getTabFeedList());
                this.imx.a(jVar);
            } catch (Exception e) {
                this.imx.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.imx = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.imx.a(aVar);
                this.imx.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bk(forumrecommendsocketresponsemessage.GetLikeForum());
                this.imx.a(gVar);
                bj bjVar = new bj();
                bjVar.bj(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.imx.c(bjVar);
                this.imx.setIsSuccess(true);
                this.imx.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.imx.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.imx.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.imx.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cI(forumrecommendsocketresponsemessage.getTabFeedList());
                this.imx.a(jVar);
            } catch (Exception e) {
                this.imx.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void oT(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: i */
            public d doInBackground(Void... voidArr) {
                l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = dH.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (dVar.isSuccess() && !dVar.cqU()) {
                        dVar.cqQ().crn();
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
                    aVar.imI = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.imI = dVar;
                }
                EnterForumModel.this.imz.a(aVar);
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
                l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dI == null || StringUtils.isNull(dI.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dI.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dI.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.imy.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.imy.xG(200);
                }
                EnterForumModel.this.oR(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void crz() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dI != null && EnterForumModel.this.imy != null) {
                        dI.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.imy));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.imx != null) {
            int size = this.imx.cqQ().crm().size();
            for (int i = 0; i < size; i++) {
                if (this.imx.cqQ().crm().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.imy.a(visitedForumData);
                    this.imy.xG(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.imy.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.imy.getForumData().get(i2);
                if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.imy.getForumData().remove(i);
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
