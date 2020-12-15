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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.au;
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
    CustomMessageListener ivb;
    private d iyg;
    RecentlyVisitedForumData iyh;
    private b iyi;
    private com.baidu.tieba.tbadkCore.d.b iyj;
    private boolean iyk;
    private boolean iyl;
    private long iym;
    private long iyn;
    private long iyo;
    private long iyp;

    /* loaded from: classes22.dex */
    public interface b {
        void a(a aVar);
    }

    public void pp(boolean z) {
        this.iyk = z;
    }

    /* loaded from: classes22.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d iyr = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iyg = null;
        this.iyi = null;
        this.iyj = null;
        this.iyk = false;
        this.iyl = false;
        this.iym = 0L;
        this.iyn = 0L;
        this.iyo = 0L;
        this.iyp = 0L;
        this.ivb = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.iyh = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.ivb);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cwm() {
        return this.iyp;
    }

    public long cwn() {
        return this.iyn;
    }

    public long cwo() {
        return this.iyo;
    }

    public long cwp() {
        return this.iym;
    }

    public d cwq() {
        return this.iyg;
    }

    public boolean cwr() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.iyg == null || this.iyg.cuK() == null) {
            return true;
        }
        return this.iyg.cuK().cuP();
    }

    public boolean cws() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("enter_forum_create_forum", true) && this.iyg != null && this.iyg.cuK() != null) {
            return this.iyg.cuK().cuO();
        }
        return false;
    }

    public void c(d dVar) {
        this.iyg = dVar;
    }

    public void a(b bVar) {
        this.iyi = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        cwt();
        return true;
    }

    private void cwt() {
        if (this.iyj != null) {
            this.iyj.destory();
            this.iyj = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ivb);
    }

    public void onPause() {
        cvr();
    }

    public boolean pq(boolean z) {
        return B(z, com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean B(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.iyh.getForumData());
        this.iym = System.currentTimeMillis();
        if (this.iyj == null) {
            this.iyj = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean pr(boolean z) {
        ps(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.iyj != null) {
            this.iyj.a(z2, z3, i, str, i2, j, j2);
            this.iyj = null;
        }
        if (z || !this.iyg.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.iyr = this.iyg;
            this.iyi.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.iyr = this.iyg;
        this.iyi.a(aVar);
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
            this.iyg = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.iyk = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.iyg = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.iyg.a(aVar);
                this.iyg.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bn(forumrecommendhttpresponsemessage.GetLikeForum());
                this.iyg.a(gVar);
                bl blVar = new bl();
                blVar.bm(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.iyg.c(blVar);
                this.iyg.setIsSuccess(true);
                this.iyg.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.iyg.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.iyg.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.iyg.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cM(forumrecommendhttpresponsemessage.getTabFeedList());
                this.iyg.a(jVar);
            } catch (Exception e) {
                this.iyg.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.iyg = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.iyg.a(aVar);
                this.iyg.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bn(forumrecommendsocketresponsemessage.GetLikeForum());
                this.iyg.a(gVar);
                bl blVar = new bl();
                blVar.bm(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.iyg.c(blVar);
                this.iyg.setIsSuccess(true);
                this.iyg.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.iyg.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.iyg.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.iyg.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cM(forumrecommendsocketresponsemessage.getTabFeedList());
                this.iyg.a(jVar);
            } catch (Exception e) {
                this.iyg.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void ps(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: i */
            public d doInBackground(Void... voidArr) {
                l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = dM.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (dVar.isSuccess() && !dVar.cuM()) {
                        dVar.cuI().cvf();
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
                    aVar.iyr = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.iyr = dVar;
                }
                EnterForumModel.this.iyi.a(aVar);
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
                l<String> dN = com.baidu.tbadk.core.c.a.brq().dN("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dN == null || StringUtils.isNull(dN.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dN.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dN.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.iyh.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.iyh.yJ(200);
                }
                EnterForumModel.this.pq(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void cvr() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    l<String> dN = com.baidu.tbadk.core.c.a.brq().dN("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dN != null && EnterForumModel.this.iyh != null) {
                        dN.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.iyh));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.iyg != null) {
            int size = this.iyg.cuI().cve().size();
            for (int i = 0; i < size; i++) {
                if (this.iyg.cuI().cve().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.iyh.a(visitedForumData);
                    this.iyh.yJ(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.iyh.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.iyh.getForumData().get(i2);
                if (!au.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.iyh.getForumData().remove(i);
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
