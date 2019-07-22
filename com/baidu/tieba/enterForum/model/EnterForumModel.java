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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.aa;
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
    private long eYA;
    CustomMessageListener eYf;
    private c eYr;
    RecentlyVisitedForumData eYs;
    private b eYt;
    private com.baidu.tieba.tbadkCore.d.b eYu;
    private boolean eYv;
    private boolean eYw;
    private long eYx;
    private long eYy;
    private long eYz;

    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);
    }

    public void jo(boolean z) {
        this.eYv = z;
    }

    /* loaded from: classes4.dex */
    public class a {
        public String error = "";
        public boolean eYD = false;
        public int type = -1;
        public c eYE = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eYr = null;
        this.eYt = null;
        this.eYu = null;
        this.eYv = false;
        this.eYw = false;
        this.eYx = 0L;
        this.eYy = 0L;
        this.eYz = 0L;
        this.eYA = 0L;
        this.eYf = new CustomMessageListener(2016564) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.eYs = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.eYf);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long bgj() {
        return this.eYA;
    }

    public long bgk() {
        return this.eYy;
    }

    public long bgl() {
        return this.eYz;
    }

    public long bgm() {
        return this.eYx;
    }

    public c bgn() {
        return this.eYr;
    }

    public boolean bgo() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.eYr == null || this.eYr.bfh() == null) {
            return true;
        }
        return this.eYr.bfh().bfk();
    }

    public boolean bgp() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("enter_forum_create_forum", true) && this.eYr != null && this.eYr.bfh() != null) {
            return this.eYr.bfh().bfj();
        }
        return false;
    }

    public void d(c cVar) {
        this.eYr = cVar;
    }

    public void a(b bVar) {
        this.eYt = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        bgq();
        return true;
    }

    private void bgq() {
        if (this.eYu != null) {
            this.eYu.destory();
            this.eYu = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eYf);
    }

    public void onPause() {
        bgf();
    }

    public boolean jp(boolean z) {
        return m(z, com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean m(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.eYs.getForumData());
        this.eYx = System.currentTimeMillis();
        if (this.eYu == null) {
            this.eYu = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean jq(boolean z) {
        jr(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.eYu != null) {
            this.eYu.a(z2, z3, i, str, i2, j, j2);
            this.eYu = null;
        }
        if (z || !this.eYr.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.eYD = false;
            aVar.eYE = this.eYr;
            this.eYt.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.eYD = true;
        aVar.eYE = this.eYr;
        this.eYt.a(aVar);
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
            this.eYr = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        if (this.eYr.bff().bfy().size() == 0 && !this.eYv && !this.eYw) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
            this.eYw = true;
        }
        this.eYv = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.eYr = new c();
                this.eYr.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bC(forumrecommendhttpresponsemessage.GetLikeForum());
                this.eYr.a(gVar);
                j jVar = new j();
                jVar.bD(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.eYr.a(jVar);
                this.eYr.bB(bF(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.eYr.dY(true);
                this.eYr.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.eYr.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.eYr.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.eYr.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.eYr.dY(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bF(List<RecommendForumInfo> list) {
        if (v.aa(list)) {
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
                this.eYr = new c();
                this.eYr.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bC(forumrecommendsocketresponsemessage.GetLikeForum());
                this.eYr.a(gVar);
                j jVar = new j();
                jVar.bD(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.eYr.a(jVar);
                this.eYr.bB(bF(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.eYr.dY(true);
                this.eYr.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.eYr.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.eYr.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.eYr.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.eYr.dY(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void jr(final boolean z) {
        new BdAsyncTask<Void, Void, c>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public c doInBackground(Void... voidArr) {
                l<byte[]> bD = com.baidu.tbadk.core.d.a.agF().bD("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c cVar = new c();
                byte[] bArr = bD.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    cVar.dY(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            cVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        cVar.dY(false);
                    }
                    if (cVar.isSuccess() && !cVar.Zi()) {
                        cVar.bff().bfz();
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
                    aVar.eYD = true;
                    aVar.eYE = cVar;
                } else {
                    aVar.eYD = false;
                    aVar.eYE = cVar;
                }
                EnterForumModel.this.eYt.a(aVar);
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
                l<String> bE = com.baidu.tbadk.core.d.a.agF().bE("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (bE == null || StringUtils.isNull(bE.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(bE.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    bE.f(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.eYs.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.eYs.qw(200);
                }
                EnterForumModel.this.jp(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bgf() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            aa.a(new z<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    l<String> bE = com.baidu.tbadk.core.d.a.agF().bE("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (bE != null && EnterForumModel.this.eYs != null) {
                        bE.f(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.eYs));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.eYr != null) {
            int size = this.eYr.bff().bfy().size();
            for (int i = 0; i < size; i++) {
                if (this.eYr.bff().bfy().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.eYs.a(visitedForumData);
                    this.eYs.qw(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.eYs.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.eYs.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.eYs.getForumData().remove(i);
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
