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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
    CustomMessageListener gCa;
    private e gDS;
    RecentlyVisitedForumData gDT;
    private b gDU;
    private com.baidu.tieba.tbadkCore.d.b gDV;
    private boolean gDW;
    private boolean gDX;
    private long gDY;
    private long gDZ;
    private long gEa;
    private long gEb;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public void lN(boolean z) {
        this.gDW = z;
    }

    /* loaded from: classes9.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public e gEe = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gDS = null;
        this.gDU = null;
        this.gDV = null;
        this.gDW = false;
        this.gDX = false;
        this.gDY = 0L;
        this.gDZ = 0L;
        this.gEa = 0L;
        this.gEb = 0L;
        this.gCa = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.gDT = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.gCa);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long bIT() {
        return this.gEb;
    }

    public long bIU() {
        return this.gDZ;
    }

    public long bIV() {
        return this.gEa;
    }

    public long bIW() {
        return this.gDY;
    }

    public e bIX() {
        return this.gDS;
    }

    public boolean bIY() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.gDS == null || this.gDS.bHz() == null) {
            return true;
        }
        return this.gDS.bHz().bHD();
    }

    public boolean bIZ() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("enter_forum_create_forum", true) && this.gDS != null && this.gDS.bHz() != null) {
            return this.gDS.bHz().bHC();
        }
        return false;
    }

    public void c(e eVar) {
        this.gDS = eVar;
    }

    public void a(b bVar) {
        this.gDU = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        bJa();
        return true;
    }

    private void bJa() {
        if (this.gDV != null) {
            this.gDV.destory();
            this.gDV = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gCa);
    }

    public void onPause() {
        bIK();
    }

    public boolean lO(boolean z) {
        return t(z, com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean t(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.gDT.getForumData());
        this.gDY = System.currentTimeMillis();
        if (this.gDV == null) {
            this.gDV = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean lP(boolean z) {
        lQ(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.gDV != null) {
            this.gDV.a(z2, z3, i, str, i2, j, j2);
            this.gDV = null;
        }
        if (z || !this.gDS.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.gEe = this.gDS;
            this.gDU.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.gEe = this.gDS;
        this.gDU.a(aVar);
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
            this.gDS = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.gDW = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.gDS = new e();
                this.gDS.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                i iVar = new i();
                iVar.bT(forumrecommendhttpresponsemessage.GetLikeForum());
                this.gDS.a(iVar);
                l lVar = new l();
                lVar.bU(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.gDS.a(lVar);
                this.gDS.setIsSuccess(true);
                this.gDS.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.gDS.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.gDS.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.gDS.a(privateForumPopInfoData);
                p pVar = new p();
                pVar.bV(forumrecommendhttpresponsemessage.getTabFeedList());
                this.gDS.a(pVar);
            } catch (Exception e) {
                this.gDS.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.gDS = new e();
                this.gDS.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                i iVar = new i();
                iVar.bT(forumrecommendsocketresponsemessage.GetLikeForum());
                this.gDS.a(iVar);
                l lVar = new l();
                lVar.bU(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.gDS.a(lVar);
                this.gDS.setIsSuccess(true);
                this.gDS.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.gDS.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.gDS.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.gDS.a(privateForumPopInfoData);
                p pVar = new p();
                pVar.bV(forumrecommendsocketresponsemessage.getTabFeedList());
                this.gDS.a(pVar);
            } catch (Exception e) {
                this.gDS.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void lQ(final boolean z) {
        new BdAsyncTask<Void, Void, e>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public e doInBackground(Void... voidArr) {
                com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                e eVar = new e();
                byte[] bArr = cA.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (eVar.isSuccess() && !eVar.aFP()) {
                        eVar.bHx().bHT();
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
                    aVar.gEe = eVar;
                } else {
                    aVar.isOk = false;
                    aVar.gEe = eVar;
                }
                EnterForumModel.this.gDU.a(aVar);
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
                com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMR().cB("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (cB == null || StringUtils.isNull(cB.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(cB.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    cB.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.gDT.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.gDT.sg(200);
                }
                EnterForumModel.this.lO(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bIK() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMR().cB("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (cB != null && EnterForumModel.this.gDT != null) {
                        cB.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.gDT));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.gDS != null) {
            int size = this.gDS.bHx().bHS().size();
            for (int i = 0; i < size; i++) {
                if (this.gDS.bHx().bHS().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.gDT.a(visitedForumData);
                    this.gDT.sg(200);
                }
            }
        }
    }

    public void b(h hVar) {
        int i;
        if (hVar != null) {
            int size = this.gDT.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.gDT.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(hVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.gDT.getForumData().remove(i);
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
