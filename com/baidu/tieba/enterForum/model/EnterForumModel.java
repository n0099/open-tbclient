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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    CustomMessageListener eDE;
    private com.baidu.tieba.enterForum.data.a eDN;
    RecentlyVisitedForumData eDO;
    private b eDP;
    private com.baidu.tieba.tbadkCore.d.b eDQ;
    private boolean eDR;
    private boolean eDS;
    private long eDT;
    private long eDU;
    private long eDV;
    private long eDW;

    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);
    }

    public void iy(boolean z) {
        this.eDR = z;
    }

    /* loaded from: classes4.dex */
    public class a {
        public String error = "";
        public boolean eDZ = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.data.a eEa = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eDN = null;
        this.eDP = null;
        this.eDQ = null;
        this.eDR = false;
        this.eDS = false;
        this.eDT = 0L;
        this.eDU = 0L;
        this.eDV = 0L;
        this.eDW = 0L;
        this.eDE = new CustomMessageListener(2016564) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.eDO = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.eDE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long aWS() {
        return this.eDW;
    }

    public long aWT() {
        return this.eDU;
    }

    public long aWU() {
        return this.eDV;
    }

    public long aWV() {
        return this.eDT;
    }

    public com.baidu.tieba.enterForum.data.a aWW() {
        return this.eDN;
    }

    public boolean aWX() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.eDN == null || this.eDN.aWc() == null) {
            return true;
        }
        return this.eDN.aWc().aWg();
    }

    public boolean aWY() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_create_forum", true) && this.eDN != null && this.eDN.aWc() != null) {
            return this.eDN.aWc().aWf();
        }
        return false;
    }

    public void d(com.baidu.tieba.enterForum.data.a aVar) {
        this.eDN = aVar;
    }

    public void a(b bVar) {
        this.eDP = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        aWZ();
        return true;
    }

    private void aWZ() {
        if (this.eDQ != null) {
            this.eDQ.destory();
            this.eDQ = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDE);
    }

    public void onPause() {
        aWP();
    }

    public boolean iz(boolean z) {
        return m(z, com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean m(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.eDO.getForumData());
        this.eDT = System.currentTimeMillis();
        if (this.eDQ == null) {
            this.eDQ = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean iA(boolean z) {
        iB(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.eDQ != null) {
            this.eDQ.a(z2, z3, i, str, i2, j, j2);
            this.eDQ = null;
        }
        if (z || !this.eDN.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.eDZ = false;
            aVar.eEa = this.eDN;
            this.eDP.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.eDZ = true;
        aVar.eEa = this.eDN;
        this.eDP.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.neterror);
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
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.eDN = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        if (this.eDN.aWa().aWu().size() == 0 && !this.eDR && !this.eDS) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
            this.eDS = true;
        }
        this.eDR = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.eDN = new com.baidu.tieba.enterForum.data.a();
                this.eDN.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                e eVar = new e();
                eVar.bu(forumrecommendhttpresponsemessage.GetLikeForum());
                this.eDN.a(eVar);
                h hVar = new h();
                hVar.bv(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.eDN.a(hVar);
                this.eDN.bt(bx(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.eDN.dy(true);
                this.eDN.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.eDN.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.eDN.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.eDN.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.eDN.dy(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bx(List<RecommendForumInfo> list) {
        if (v.T(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator<RecommendForumInfo> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            RecommendForumInfo next = it.next();
            if (i2 >= 4) {
                break;
            }
            if (next != null && next.forum_id.longValue() > 0 && !StringUtils.isNull(next.forum_name)) {
                com.baidu.tieba.enterForum.multiConcern.b bVar = new com.baidu.tieba.enterForum.multiConcern.b();
                bVar.avatar = next.avatar;
                bVar.forumId = next.forum_id.longValue();
                bVar.forumName = next.forum_name;
                bVar.followNum = next.member_count.intValue();
                bVar.threadNum = next.thread_count.intValue();
                bVar.isSelected = true;
                arrayList.add(bVar);
                i2++;
            }
            i = i2;
        }
        return arrayList;
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.eDN = new com.baidu.tieba.enterForum.data.a();
                this.eDN.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                e eVar = new e();
                eVar.bu(forumrecommendsocketresponsemessage.GetLikeForum());
                this.eDN.a(eVar);
                h hVar = new h();
                hVar.bv(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.eDN.a(hVar);
                this.eDN.bt(bx(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.eDN.dy(true);
                this.eDN.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.eDN.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.eDN.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.eDN.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.eDN.dy(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void iB(final boolean z) {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.data.a>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public com.baidu.tieba.enterForum.data.a doInBackground(Void... voidArr) {
                l<byte[]> bu = com.baidu.tbadk.core.c.a.aaW().bu("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.data.a aVar = new com.baidu.tieba.enterForum.data.a();
                byte[] bArr = bu.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    aVar.dy(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            aVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        aVar.dy(false);
                    }
                    if (aVar.isSuccess() && !aVar.aWe()) {
                        aVar.aWa().aWv();
                    }
                }
                return aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public void onPostExecute(com.baidu.tieba.enterForum.data.a aVar) {
                super.onPostExecute(aVar);
                a aVar2 = new a();
                aVar2.type = 0;
                if (aVar != null && aVar.isSuccess()) {
                    aVar2.eDZ = true;
                    aVar2.eEa = aVar;
                } else {
                    aVar2.eDZ = false;
                    aVar2.eEa = aVar;
                }
                EnterForumModel.this.eDP.a(aVar2);
            }
        }.execute(new Void[0]);
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                RecentlyVisitedForumData recentlyVisitedForumData2 = null;
                l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (bv == null || StringUtils.isNull(bv.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(bv.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    bv.e(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.eDO.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.eDO.pe(200);
                }
                EnterForumModel.this.iz(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void aWP() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            aa.a(new z<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (bv != null && EnterForumModel.this.eDO != null) {
                        bv.e(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.eDO));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.eDN != null) {
            int size = this.eDN.aWa().aWu().size();
            for (int i = 0; i < size; i++) {
                if (this.eDN.aWa().aWu().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.eDO.a(visitedForumData);
                    this.eDO.pe(200);
                }
            }
        }
    }

    public void b(com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        if (dVar != null) {
            int size = this.eDO.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.eDO.getForumData().get(i2);
                if (!ap.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(dVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.eDO.getForumData().remove(i);
            }
        }
    }

    public List<com.baidu.tieba.enterForum.data.d> a(List<com.baidu.tieba.enterForum.data.d> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (com.baidu.tieba.enterForum.data.d dVar : list) {
                    if (dVar != null && dVar.getName() != null && dVar.getName().equals(str)) {
                        arrayList.add(dVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.enterForum.data.d dVar2 = list.get(i);
                if (!arrayList.contains(dVar2)) {
                    arrayList.add(dVar2);
                }
            }
        }
        return arrayList;
    }
}
