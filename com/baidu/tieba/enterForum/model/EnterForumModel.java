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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
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
    CustomMessageListener fcK;
    private c fcW;
    RecentlyVisitedForumData fcX;
    private b fcY;
    private com.baidu.tieba.tbadkCore.d.b fcZ;
    private boolean fda;
    private boolean fdb;
    private long fdc;
    private long fdd;
    private long fde;
    private long fdf;

    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);
    }

    public void jg(boolean z) {
        this.fda = z;
    }

    /* loaded from: classes4.dex */
    public class a {
        public String error = "";
        public boolean fdi = false;
        public int type = -1;
        public c fdj = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fcW = null;
        this.fcY = null;
        this.fcZ = null;
        this.fda = false;
        this.fdb = false;
        this.fdc = 0L;
        this.fdd = 0L;
        this.fde = 0L;
        this.fdf = 0L;
        this.fcK = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.fcX = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.fcK);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long beL() {
        return this.fdf;
    }

    public long beM() {
        return this.fdd;
    }

    public long beN() {
        return this.fde;
    }

    public long beO() {
        return this.fdc;
    }

    public c beP() {
        return this.fcW;
    }

    public boolean beQ() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.fcW == null || this.fcW.bdH() == null) {
            return true;
        }
        return this.fcW.bdH().bdK();
    }

    public boolean beR() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("enter_forum_create_forum", true) && this.fcW != null && this.fcW.bdH() != null) {
            return this.fcW.bdH().bdJ();
        }
        return false;
    }

    public void d(c cVar) {
        this.fcW = cVar;
    }

    public void a(b bVar) {
        this.fcY = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        beS();
        return true;
    }

    private void beS() {
        if (this.fcZ != null) {
            this.fcZ.destory();
            this.fcZ = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcK);
    }

    public void onPause() {
        beH();
    }

    public boolean jh(boolean z) {
        return n(z, com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean n(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.fcX.getForumData());
        this.fdc = System.currentTimeMillis();
        if (this.fcZ == null) {
            this.fcZ = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean ji(boolean z) {
        jj(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.fcZ != null) {
            this.fcZ.a(z2, z3, i, str, i2, j, j2);
            this.fcZ = null;
        }
        if (z || !this.fcW.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.fdi = false;
            aVar.fdj = this.fcW;
            this.fcY.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.fdi = true;
        aVar.fdj = this.fcW;
        this.fcY.a(aVar);
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
            this.fcW = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        if (this.fcW.bdF().bdY().size() == 0 && !this.fda && !this.fdb) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
            this.fdb = true;
        }
        this.fda = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.fcW = new c();
                this.fcW.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bP(forumrecommendhttpresponsemessage.GetLikeForum());
                this.fcW.a(gVar);
                j jVar = new j();
                jVar.bQ(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.fcW.a(jVar);
                this.fcW.bO(bS(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.fcW.setIsSuccess(true);
                this.fcW.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.fcW.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.fcW.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.fcW.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fcW.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bS(List<RecommendForumInfo> list) {
        if (v.isEmpty(list)) {
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
                this.fcW = new c();
                this.fcW.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bP(forumrecommendsocketresponsemessage.GetLikeForum());
                this.fcW.a(gVar);
                j jVar = new j();
                jVar.bQ(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.fcW.a(jVar);
                this.fcW.bO(bS(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.fcW.setIsSuccess(true);
                this.fcW.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.fcW.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.fcW.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.fcW.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fcW.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void jj(final boolean z) {
        new BdAsyncTask<Void, Void, c>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public c doInBackground(Void... voidArr) {
                l<byte[]> bJ = com.baidu.tbadk.core.d.a.akN().bJ("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c cVar = new c();
                byte[] bArr = bJ.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (cVar.isSuccess() && !cVar.aeb()) {
                        cVar.bdF().bdZ();
                    }
                }
                return cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public void onPostExecute(c cVar) {
                super.onPostExecute(cVar);
                a aVar = new a();
                aVar.type = 0;
                if (cVar != null && cVar.isSuccess()) {
                    aVar.fdi = true;
                    aVar.fdj = cVar;
                } else {
                    aVar.fdi = false;
                    aVar.fdj = cVar;
                }
                EnterForumModel.this.fcY.a(aVar);
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
                l<String> bK = com.baidu.tbadk.core.d.a.akN().bK("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (bK == null || StringUtils.isNull(bK.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(bK.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    bK.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.fcX.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.fcX.pw(200);
                }
                EnterForumModel.this.jh(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void beH() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            z.a(new y<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.y
                public Object doInBackground() {
                    l<String> bK = com.baidu.tbadk.core.d.a.akN().bK("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (bK != null && EnterForumModel.this.fcX != null) {
                        bK.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.fcX));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.fcW != null) {
            int size = this.fcW.bdF().bdY().size();
            for (int i = 0; i < size; i++) {
                if (this.fcW.bdF().bdY().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.fcX.a(visitedForumData);
                    this.fcX.pw(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.fcX.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.fcX.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.fcX.getForumData().remove(i);
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
