package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.data.p;
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
    CustomMessageListener gQU;
    private e gSM;
    RecentlyVisitedForumData gSN;
    private b gSO;
    private com.baidu.tieba.tbadkCore.d.b gSP;
    private boolean gSQ;
    private boolean gSR;
    private long gSS;
    private long gST;
    private long gSU;
    private long gSV;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public void mi(boolean z) {
        this.gSQ = z;
    }

    /* loaded from: classes9.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public e gSX = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSM = null;
        this.gSO = null;
        this.gSP = null;
        this.gSQ = false;
        this.gSR = false;
        this.gSS = 0L;
        this.gST = 0L;
        this.gSU = 0L;
        this.gSV = 0L;
        this.gQU = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.gSN = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.gQU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long bPp() {
        return this.gSV;
    }

    public long bPq() {
        return this.gST;
    }

    public long bPr() {
        return this.gSU;
    }

    public long bPs() {
        return this.gSS;
    }

    public e bPt() {
        return this.gSM;
    }

    public boolean bPu() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.gSM == null || this.gSM.bNV() == null) {
            return true;
        }
        return this.gSM.bNV().bNZ();
    }

    public boolean bPv() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("enter_forum_create_forum", true) && this.gSM != null && this.gSM.bNV() != null) {
            return this.gSM.bNV().bNY();
        }
        return false;
    }

    public void c(e eVar) {
        this.gSM = eVar;
    }

    public void a(b bVar) {
        this.gSO = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        bPw();
        return true;
    }

    private void bPw() {
        if (this.gSP != null) {
            this.gSP.destory();
            this.gSP = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gQU);
    }

    public void onPause() {
        bPg();
    }

    public boolean mj(boolean z) {
        return w(z, com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean w(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.gSN.getForumData());
        this.gSS = System.currentTimeMillis();
        if (this.gSP == null) {
            this.gSP = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean mk(boolean z) {
        ml(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.gSP != null) {
            this.gSP.a(z2, z3, i, str, i2, j, j2);
            this.gSP = null;
        }
        if (z || !this.gSM.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.gSX = this.gSM;
            this.gSO.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.gSX = this.gSM;
        this.gSO.a(aVar);
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
            this.gSM = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.gSQ = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.gSM = new e();
                this.gSM.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                i iVar = new i();
                iVar.bQ(forumrecommendhttpresponsemessage.GetLikeForum());
                this.gSM.a(iVar);
                l lVar = new l();
                lVar.bR(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.gSM.a(lVar);
                this.gSM.setIsSuccess(true);
                this.gSM.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.gSM.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.gSM.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.gSM.a(privateForumPopInfoData);
                p pVar = new p();
                pVar.bS(forumrecommendhttpresponsemessage.getTabFeedList());
                this.gSM.a(pVar);
            } catch (Exception e) {
                this.gSM.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.gSM = new e();
                this.gSM.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                i iVar = new i();
                iVar.bQ(forumrecommendsocketresponsemessage.GetLikeForum());
                this.gSM.a(iVar);
                l lVar = new l();
                lVar.bR(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.gSM.a(lVar);
                this.gSM.setIsSuccess(true);
                this.gSM.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.gSM.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.gSM.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.gSM.a(privateForumPopInfoData);
                p pVar = new p();
                pVar.bS(forumrecommendsocketresponsemessage.getTabFeedList());
                this.gSM.a(pVar);
            } catch (Exception e) {
                this.gSM.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void ml(final boolean z) {
        new BdAsyncTask<Void, Void, e>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public e doInBackground(Void... voidArr) {
                com.baidu.adp.lib.cache.l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                e eVar = new e();
                byte[] bArr = cZ.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    eVar.setIsSuccess(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            eVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        eVar.setIsSuccess(false);
                    }
                    if (eVar.isSuccess() && !eVar.aLk()) {
                        eVar.bNT().bOp();
                    }
                }
                return eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(e eVar) {
                super.onPostExecute(eVar);
                a aVar = new a();
                aVar.type = 0;
                if (eVar != null && eVar.isSuccess()) {
                    aVar.isOk = true;
                    aVar.gSX = eVar;
                } else {
                    aVar.isOk = false;
                    aVar.gSX = eVar;
                }
                EnterForumModel.this.gSO.a(aVar);
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
                com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (da == null || StringUtils.isNull(da.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(da.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    da.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.gSN.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.gSN.sN(200);
                }
                EnterForumModel.this.mj(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bPg() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (da != null && EnterForumModel.this.gSN != null) {
                        da.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.gSN));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.gSM != null) {
            int size = this.gSM.bNT().bOo().size();
            for (int i = 0; i < size; i++) {
                if (this.gSM.bNT().bOo().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.gSN.a(visitedForumData);
                    this.gSN.sN(200);
                }
            }
        }
    }

    public void b(h hVar) {
        int i;
        if (hVar != null) {
            int size = this.gSN.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.gSN.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(hVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.gSN.getForumData().remove(i);
            }
        }
    }

    public List<h> a(List<h> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (h hVar : list) {
                    if (hVar != null && hVar.getName() != null && hVar.getName().equals(str)) {
                        arrayList.add(hVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                h hVar2 = list.get(i);
                if (!arrayList.contains(hVar2)) {
                    arrayList.add(hVar2);
                }
            }
        }
        return arrayList;
    }
}
