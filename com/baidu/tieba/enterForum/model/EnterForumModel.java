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
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    CustomMessageListener fTH;
    private c fTT;
    RecentlyVisitedForumData fTU;
    private b fTV;
    private com.baidu.tieba.tbadkCore.d.b fTW;
    private boolean fTX;
    private boolean fTY;
    private long fTZ;
    private long fUa;
    private long fUb;
    private long fUc;

    /* loaded from: classes7.dex */
    public interface b {
        void a(a aVar);
    }

    public void kD(boolean z) {
        this.fTX = z;
    }

    /* loaded from: classes7.dex */
    public class a {
        public String error = "";
        public boolean isOk = false;
        public int type = -1;
        public c fUf = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fTT = null;
        this.fTV = null;
        this.fTW = null;
        this.fTX = false;
        this.fTY = false;
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        this.fTH = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    EnterForumModel.this.c((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        this.fTU = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.fTH);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long bxf() {
        return this.fUc;
    }

    public long bxg() {
        return this.fUa;
    }

    public long bxh() {
        return this.fUb;
    }

    public long bxi() {
        return this.fTZ;
    }

    public c bxj() {
        return this.fTT;
    }

    public boolean bxk() {
        if (!TbadkApplication.isLogin()) {
            return false;
        }
        if (this.fTT == null || this.fTT.bwd() == null) {
            return true;
        }
        return this.fTT.bwd().bwg();
    }

    public boolean bxl() {
        if (TbadkApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("enter_forum_create_forum", true) && this.fTT != null && this.fTT.bwd() != null) {
            return this.fTT.bwd().bwf();
        }
        return false;
    }

    public void d(c cVar) {
        this.fTT = cVar;
    }

    public void a(b bVar) {
        this.fTV = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        bxm();
        return true;
    }

    private void bxm() {
        if (this.fTW != null) {
            this.fTW.destory();
            this.fTW = null;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fTH);
    }

    public void onPause() {
        bxb();
    }

    public boolean kE(boolean z) {
        return r(z, com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean r(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.fTU.getForumData());
        this.fTZ = System.currentTimeMillis();
        if (this.fTW == null) {
            this.fTW = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean kF(boolean z) {
        kG(z);
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.fTW != null) {
            this.fTW.a(z2, z3, i, str, i2, j, j2);
            this.fTW = null;
        }
        if (z || !this.fTT.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.isOk = false;
            aVar.fUf = this.fTT;
            this.fTV.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.isOk = true;
        aVar.fUf = this.fTT;
        this.fTV.a(aVar);
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
            this.fTT = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        if (this.fTT.bwb().bwu().size() == 0 && !this.fTX && !this.fTY) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
            this.fTY = true;
        }
        this.fTX = false;
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.fTT = new c();
                this.fTT.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bL(forumrecommendhttpresponsemessage.GetLikeForum());
                this.fTT.a(gVar);
                j jVar = new j();
                jVar.bM(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.fTT.a(jVar);
                this.fTT.bK(bO(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.fTT.setIsSuccess(true);
                this.fTT.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
                this.fTT.setSortType(forumrecommendhttpresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendhttpresponsemessage.getForumCreateInfo());
                this.fTT.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendhttpresponsemessage.getPrivatePopInfo());
                this.fTT.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fTT.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bO(List<RecommendForumInfo> list) {
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
                this.fTT = new c();
                this.fTT.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bL(forumrecommendsocketresponsemessage.GetLikeForum());
                this.fTT.a(gVar);
                j jVar = new j();
                jVar.bM(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.fTT.a(jVar);
                this.fTT.bK(bO(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.fTT.setIsSuccess(true);
                this.fTT.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
                this.fTT.setSortType(forumrecommendsocketresponsemessage.getSortType().intValue());
                ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
                forumCreateInfoData.a(forumrecommendsocketresponsemessage.getForumCreateInfo());
                this.fTT.a(forumCreateInfoData);
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                privateForumPopInfoData.a(forumrecommendsocketresponsemessage.getPrivatePopInfo());
                this.fTT.a(privateForumPopInfoData);
            } catch (Exception e) {
                this.fTT.setIsSuccess(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void kG(final boolean z) {
        new BdAsyncTask<Void, Void, c>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public c doInBackground(Void... voidArr) {
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c cVar = new c();
                byte[] bArr = ch.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
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
                    if (cVar.isSuccess() && !cVar.avl()) {
                        cVar.bwb().bwv();
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
                    aVar.isOk = true;
                    aVar.fUf = cVar;
                } else {
                    aVar.isOk = false;
                    aVar.fUf = cVar;
                }
                EnterForumModel.this.fTV.a(aVar);
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
                l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (ci == null || StringUtils.isNull(ci.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(ci.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recentlyVisitedForumData = null;
                }
                if (0 != 0) {
                    recentlyVisitedForumData2.a(recentlyVisitedForumData);
                    ci.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(null));
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
                    EnterForumModel.this.fTU.setForumData(recentlyVisitedForumData.getForumData());
                    EnterForumModel.this.fTU.rG(200);
                }
                EnterForumModel.this.kE(z);
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    private void bxb() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.4
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                    if (ci != null && EnterForumModel.this.fTU != null) {
                        ci.setForever(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(EnterForumModel.this.fTU));
                    }
                    return null;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VisitedForumData visitedForumData) {
        if (visitedForumData != null && this.fTT != null) {
            int size = this.fTT.bwb().bwu().size();
            for (int i = 0; i < size; i++) {
                if (this.fTT.bwb().bwu().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.fTU.a(visitedForumData);
                    this.fTU.rG(200);
                }
            }
        }
    }

    public void b(f fVar) {
        int i;
        if (fVar != null) {
            int size = this.fTU.getForumData().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                VisitedForumData visitedForumData = this.fTU.getForumData().get(i2);
                if (!aq.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.fTU.getForumData().remove(i);
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
