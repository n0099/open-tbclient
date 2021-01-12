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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
    CustomMessageListener iCH;
    private d iFM;
    RecentlyVisitedForumData iFN;
    private b iFO;
    private com.baidu.tieba.tbadkCore.d.b iFP;
    private boolean iFQ;
    private boolean iFR;
    private long iFS;
    private long iFT;
    private long iFU;
    private long iFV;

    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);
    }

    public void pI(boolean z) {
        this.iFQ = z;
    }

    /* loaded from: classes2.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public d iFX = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iFM = null;
        this.iFO = null;
        this.iFP = null;
        this.iFQ = false;
        this.iFR = false;
        this.iFS = 0L;
        this.iFT = 0L;
        this.iFU = 0L;
        this.iFV = 0L;
        this.iCH = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.iFN = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.iCH);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long cvo() {
        return this.iFV;
    }

    public long cvp() {
        return this.iFT;
    }

    public long cvq() {
        return this.iFU;
    }

    public long cvr() {
        return this.iFS;
    }

    public d cvs() {
        return this.iFM;
    }

    public boolean cvt() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.iFM == null || this.iFM.ctM() == null) {
            return true;
        }
        return this.iFM.ctM().ctR();
    }

    public boolean cvu() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("enter_forum_create_forum", true) && this.iFM != null && this.iFM.ctM() != null) {
            return this.iFM.ctM().ctQ();
        }
        return false;
    }

    public void c(d dVar) {
        this.iFM = dVar;
    }

    public void a(b bVar) {
        this.iFO = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        cvv();
        return true;
    }

    private void cvv() {
        if (this.iFP != null) {
            this.iFP.destory();
            this.iFP = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iCH);
    }

    public void onPause() {
        cut();
    }

    public boolean pJ(boolean z) {
        return A(z, com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean A(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.iFN.getForumData());
        this.iFS = System.currentTimeMillis();
        if (this.iFP == null) {
            this.iFP = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean pK(boolean z) {
        pL(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.iFP != null) {
            this.iFP.a(z2, z3, i, str, i2, j, j2);
            this.iFP = null;
        }
        if (z || !this.iFM.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.iFX = this.iFM;
            this.iFO.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.iFX = this.iFM;
        this.iFO.a(aVar);
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
            this.iFM = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        this.iFQ = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.iFM = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendhttpresponsemessage.getForumPopUpInfo());
                this.iFM.a(aVar);
                this.iFM.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bu(forumrecommendhttpresponsemessage.GetLikeForum());
                this.iFM.a(gVar);
                bm bmVar = new bm();
                bmVar.bt(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.iFM.c(bmVar);
                this.iFM.setIsSuccess(true);
                this.iFM.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.iFM.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.iFM.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.iFM.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cT(forumrecommendhttpresponsemessage.getTabFeedList());
                this.iFM.a(jVar);
            } catch (Exception e) {
                this.iFM.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.iFM = new d();
                com.baidu.tieba.enterForum.a.a.a aVar = new com.baidu.tieba.enterForum.a.a.a();
                aVar.a(forumrecommendsocketresponsemessage.getForumPopupInfo());
                this.iFM.a(aVar);
                this.iFM.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bu(forumrecommendsocketresponsemessage.GetLikeForum());
                this.iFM.a(gVar);
                bm bmVar = new bm();
                bmVar.bt(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.iFM.c(bmVar);
                this.iFM.setIsSuccess(true);
                this.iFM.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.iFM.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.iFM.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.iFM.a(privateForumPopInfoData);
                j jVar = new j();
                jVar.cT(forumrecommendsocketresponsemessage.getTabFeedList());
                this.iFM.a(jVar);
            } catch (Exception e) {
                this.iFM.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void pL(final boolean z) {
        new BdAsyncTask<Void, Void, d>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: i */
            public d doInBackground(Void... voidArr) {
                l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                d dVar = new d();
                byte[] bArr = dK.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (dVar.isSuccess() && !dVar.ctO()) {
                        dVar.ctK().cuh();
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
                    aVar.iFX = dVar;
                } else {
                    aVar.isOk = false;
                    aVar.iFX = dVar;
                }
                EnterForumModel.this.iFO.a(aVar);
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
                l<String> dL = com.baidu.tbadk.core.c.a.bpZ().dL("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (dL == null || StringUtils.isNull(dL.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dL.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    dL.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.iFN.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.iFN.xq(200);
                }
                EnterForumModel.this.pJ(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void cut() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    l<String> dL = com.baidu.tbadk.core.c.a.bpZ().dL("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dL != null && EnterForumModel.this.iFN != null) {
                        dL.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.iFN));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.iFM != null) {
            int size = this.iFM.ctK().cug().size();
            for (int i = 0; i < size; i++) {
                if (this.iFM.ctK().cug().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.iFN.a(visitedForumData);
                    this.iFN.xq(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.iFN.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.iFN.getForumData().get(i2);
                if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.iFN.getForumData().remove(i);
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
