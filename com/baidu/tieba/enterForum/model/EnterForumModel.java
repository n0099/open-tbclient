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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
/* loaded from: classes16.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    CustomMessageListener huO;
    private d hxW;
    RecentlyVisitedForumData hxX;
    private b hxY;
    private com.baidu.tieba.tbadkCore.d.b hxZ;
    private boolean hya;
    private boolean hyb;
    private long hyc;
    private long hyd;
    private long hye;
    private long hyf;

    /* loaded from: classes16.dex */
    public interface b {
        void a(a aVar);
    }

    public void nC(boolean z) {
        this.hya = z;
    }

    /* loaded from: classes16.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d hyh = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hxW = null;
        this.hxY = null;
        this.hxZ = null;
        this.hya = false;
        this.hyb = false;
        this.hyc = 0L;
        this.hyd = 0L;
        this.hye = 0L;
        this.hyf = 0L;
        this.huO = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.hxX = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.huO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cfX() {
        return this.hyf;
    }

    public long cfY() {
        return this.hyd;
    }

    public long cfZ() {
        return this.hye;
    }

    public long cga() {
        return this.hyc;
    }

    public d cgb() {
        return this.hxW;
    }

    public boolean cgc() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.hxW == null || this.hxW.cey() == null) {
            return true;
        }
        return this.hxW.cey().ceD();
    }

    public boolean cgd() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("enter_forum_create_forum", true) && this.hxW != null && this.hxW.cey() != null) {
            return this.hxW.cey().ceC();
        }
        return false;
    }

    public void c(d dVar) {
        this.hxW = dVar;
    }

    public void a(b bVar) {
        this.hxY = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        cge();
        return true;
    }

    private void cge() {
        if (this.hxZ != null) {
            this.hxZ.destory();
            this.hxZ = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.huO);
    }

    public void onPause() {
        cff();
    }

    public boolean nD(boolean z) {
        return y(z, com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean y(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.hxX.getForumData());
        this.hyc = System.currentTimeMillis();
        if (this.hxZ == null) {
            this.hxZ = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean nE(boolean z) {
        nF(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.hxZ != null) {
            this.hxZ.a(z2, z3, i, str, i2, j, j2);
            this.hxZ = null;
        }
        if (z || !this.hxW.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.hyh = this.hxW;
            this.hxY.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.hyh = this.hxW;
        this.hxY.a(aVar);
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
            this.hxW = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.hya = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.hxW = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.hxW.a(aVar);
                this.hxW.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aM(forumrecommendhttpresponsemessage.GetLikeForum());
                this.hxW.a(gVar);
                bj bjVar = new bj();
                bjVar.aL(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.hxW.c(bjVar);
                this.hxW.setIsSuccess(true);
                this.hxW.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.hxW.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.hxW.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.hxW.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.ci(forumrecommendhttpresponsemessage.getTabFeedList());
                this.hxW.a(jVar);
            } catch (Exception e) {
                this.hxW.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.hxW = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.hxW.a(aVar);
                this.hxW.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aM(forumrecommendsocketresponsemessage.GetLikeForum());
                this.hxW.a(gVar);
                bj bjVar = new bj();
                bjVar.aL(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.hxW.c(bjVar);
                this.hxW.setIsSuccess(true);
                this.hxW.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.hxW.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.hxW.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.hxW.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.ci(forumrecommendsocketresponsemessage.getTabFeedList());
                this.hxW.a(jVar);
            } catch (Exception e) {
                this.hxW.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void nF(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public d doInBackground(Void... voidArr) {
                l<byte[]> dv = com.baidu.tbadk.core.c.a.bhb().dv("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = dv.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (dVar.isSuccess() && !dVar.ceA()) {
                        dVar.cew().ceT();
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
                    aVar.hyh = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.hyh = dVar;
                }
                EnterForumModel.this.hxY.a(aVar);
            }
        }.execute(new Void[0]);
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                RecentlyVisitedForumData recentlyVisitedForumData2 = null;
                l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dw == null || StringUtils.isNull(dw.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dw.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dw.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.hxX.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.hxX.vV(200);
                }
                EnterForumModel.this.nD(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void cff() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dw != null && EnterForumModel.this.hxX != null) {
                        dw.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.hxX));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.hxW != null) {
            int size = this.hxW.cew().ceS().size();
            for (int i = 0; i < size; i++) {
                if (this.hxW.cew().ceS().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.hxX.a(visitedForumData);
                    this.hxX.vV(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.hxX.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.hxX.getForumData().get(i2);
                if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.hxX.getForumData().remove(i);
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
