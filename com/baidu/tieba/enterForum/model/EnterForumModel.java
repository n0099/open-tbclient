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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
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
    CustomMessageListener hjn;
    private d hlf;
    RecentlyVisitedForumData hlg;
    private b hlh;
    private com.baidu.tieba.tbadkCore.d.b hli;
    private boolean hlj;
    private boolean hlk;
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;

    /* loaded from: classes16.dex */
    public interface b {
        void a(a aVar);
    }

    public void mY(boolean z) {
        this.hlj = z;
    }

    /* loaded from: classes16.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d hlq = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hlf = null;
        this.hlh = null;
        this.hli = null;
        this.hlj = false;
        this.hlk = false;
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        this.hjn = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.hlg = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.hjn);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long bVK() {
        return this.hlo;
    }

    public long bVL() {
        return this.hlm;
    }

    public long bVM() {
        return this.hln;
    }

    public long bVN() {
        return this.hll;
    }

    public d bVO() {
        return this.hlf;
    }

    public boolean bVP() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.hlf == null || this.hlf.bUm() == null) {
            return true;
        }
        return this.hlf.bUm().bUs();
    }

    public boolean bVQ() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("enter_forum_create_forum", true) && this.hlf != null && this.hlf.bUm() != null) {
            return this.hlf.bUm().bUr();
        }
        return false;
    }

    public void c(d dVar) {
        this.hlf = dVar;
    }

    public void a(b bVar) {
        this.hlh = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        bVR();
        return true;
    }

    private void bVR() {
        if (this.hli != null) {
            this.hli.destory();
            this.hli = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hjn);
    }

    public void onPause() {
        bVB();
    }

    public boolean mZ(boolean z) {
        return y(z, com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean y(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.hlg.getForumData());
        this.hll = System.currentTimeMillis();
        if (this.hli == null) {
            this.hli = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean na(boolean z) {
        nb(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.hli != null) {
            this.hli.a(z2, z3, i, str, i2, j, j2);
            this.hli = null;
        }
        if (z || !this.hlf.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.hlq = this.hlf;
            this.hlh.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.hlq = this.hlf;
        this.hlh.a(aVar);
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
            this.hlf = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.hlj = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.hlf = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.hlf.a(aVar);
                this.hlf.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aM(forumrecommendhttpresponsemessage.GetLikeForum());
                this.hlf.a(gVar);
                bi biVar = new bi();
                biVar.aL(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.hlf.c(biVar);
                this.hlf.setIsSuccess(true);
                this.hlf.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.hlf.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.hlf.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.hlf.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cg(forumrecommendhttpresponsemessage.getTabFeedList());
                this.hlf.a(jVar);
            } catch (Exception e) {
                this.hlf.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.hlf = new d();
                com.baidu.tieba.enterForum.b.a.a aVar = new com.baidu.tieba.enterForum.b.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.hlf.a(aVar);
                this.hlf.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aM(forumrecommendsocketresponsemessage.GetLikeForum());
                this.hlf.a(gVar);
                bi biVar = new bi();
                biVar.aL(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.hlf.c(biVar);
                this.hlf.setIsSuccess(true);
                this.hlf.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.hlf.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.hlf.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.hlf.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cg(forumrecommendsocketresponsemessage.getTabFeedList());
                this.hlf.a(jVar);
            } catch (Exception e) {
                this.hlf.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void nb(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public d doInBackground(Void... voidArr) {
                l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = df.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (dVar.isSuccess() && !dVar.bUo()) {
                        dVar.bUk().bUI();
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
                    aVar.hlq = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.hlq = dVar;
                }
                EnterForumModel.this.hlh.a(aVar);
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
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dg == null || StringUtils.isNull(dg.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dg.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dg.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.hlg.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.hlg.tG(200);
                }
                EnterForumModel.this.mZ(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bVB() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dg != null && EnterForumModel.this.hlg != null) {
                        dg.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.hlg));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.hlf != null) {
            int size = this.hlf.bUk().bUH().size();
            for (int i = 0; i < size; i++) {
                if (this.hlf.bUk().bUH().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.hlg.a(visitedForumData);
                    this.hlg.tG(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.hlg.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.hlg.getForumData().get(i2);
                if (!as.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.hlg.getForumData().remove(i);
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
