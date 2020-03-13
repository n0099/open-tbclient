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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.data.c;
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
/* loaded from: classes9.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private c fWA;
    RecentlyVisitedForumData fWB;
    private b fWC;
    private com.baidu.tieba.tbadkCore.d.b fWD;
    private boolean fWE;
    private boolean fWF;
    private long fWG;
    private long fWH;
    private long fWI;
    private long fWJ;
    CustomMessageListener fWo;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public void kF(boolean z) {
        this.fWE = z;
    }

    /* loaded from: classes9.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public c fWM = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fWA = null;
        this.fWC = null;
        this.fWD = null;
        this.fWE = false;
        this.fWF = false;
        this.fWG = 0L;
        this.fWH = 0L;
        this.fWI = 0L;
        this.fWJ = 0L;
        this.fWo = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.fWB = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.fWo);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long byN() {
        return this.fWJ;
    }

    public long byO() {
        return this.fWH;
    }

    public long byP() {
        return this.fWI;
    }

    public long byQ() {
        return this.fWG;
    }

    public c byR() {
        return this.fWA;
    }

    public boolean byS() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.fWA == null || this.fWA.bxJ() == null) {
            return true;
        }
        return this.fWA.bxJ().bxM();
    }

    public boolean byT() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("enter_forum_create_forum", true) && this.fWA != null && this.fWA.bxJ() != null) {
            return this.fWA.bxJ().bxL();
        }
        return false;
    }

    public void c(c cVar) {
        this.fWA = cVar;
    }

    public void a(b bVar) {
        this.fWC = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        byU();
        return true;
    }

    private void byU() {
        if (this.fWD != null) {
            this.fWD.destory();
            this.fWD = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fWo);
    }

    public void onPause() {
        byJ();
    }

    public boolean kG(boolean z) {
        return s(z, com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean s(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.fWB.getForumData());
        this.fWG = System.currentTimeMillis();
        if (this.fWD == null) {
            this.fWD = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean kH(boolean z) {
        kI(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.fWD != null) {
            this.fWD.a(z2, z3, i, str, i2, j, j2);
            this.fWD = null;
        }
        if (z || !this.fWA.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.fWM = this.fWA;
            this.fWC.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.fWM = this.fWA;
        this.fWC.a(aVar);
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
            this.fWA = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        if (this.fWA.bxI().bya().size() == 0 && !this.fWE && !this.fWF) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
            this.fWF = true;
        }
        this.fWE = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.fWA = new c();
                this.fWA.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bK(forumrecommendhttpresponsemessage.GetLikeForum());
                this.fWA.a(gVar);
                j jVar = new j();
                jVar.bL(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.fWA.a(jVar);
                this.fWA.setIsSuccess(true);
                this.fWA.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.fWA.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.fWA.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.fWA.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fWA.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.fWA = new c();
                this.fWA.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bK(forumrecommendsocketresponsemessage.GetLikeForum());
                this.fWA.a(gVar);
                j jVar = new j();
                jVar.bL(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.fWA.a(jVar);
                this.fWA.setIsSuccess(true);
                this.fWA.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.fWA.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.fWA.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.fWA.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fWA.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void kI(final boolean z) {
        new BdAsyncTask<Void, Void, c>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public c doInBackground(Void... voidArr) {
                l<byte[]> cq = com.baidu.tbadk.core.c.a.aEB().cq("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c cVar = new c();
                byte[] bArr = cq.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    cVar.setIsSuccess(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            cVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        cVar.setIsSuccess(false);
                    }
                    if (cVar.isSuccess() && !cVar.axB()) {
                        cVar.bxI().byb();
                    }
                }
                return cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(c cVar) {
                super.onPostExecute(cVar);
                a aVar = new a();
                aVar.type = 0;
                if (cVar != null && cVar.isSuccess()) {
                    aVar.isOk = true;
                    aVar.fWM = cVar;
                } else {
                    aVar.isOk = false;
                    aVar.fWM = cVar;
                }
                EnterForumModel.this.fWC.a(aVar);
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
                l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (cr == null || StringUtils.isNull(cr.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(cr.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    cr.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.fWB.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.fWB.rN(200);
                }
                EnterForumModel.this.kG(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void byJ() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (cr != null && EnterForumModel.this.fWB != null) {
                        cr.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.fWB));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.fWA != null) {
            int size = this.fWA.bxI().bya().size();
            for (int i = 0; i < size; i++) {
                if (this.fWA.bxI().bya().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.fWB.a(visitedForumData);
                    this.fWB.rN(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.fWB.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.fWB.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.fWB.getForumData().remove(i);
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
