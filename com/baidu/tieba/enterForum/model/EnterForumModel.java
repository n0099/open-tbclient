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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.k;
import d.a.m0.r.q.o1;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.n0.j0.d.g;
import d.a.n0.j0.d.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
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

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.j0.d.d f14545e;

    /* renamed from: f  reason: collision with root package name */
    public RecentlyVisitedForumData f14546f;

    /* renamed from: g  reason: collision with root package name */
    public f f14547g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e3.j0.b f14548h;

    /* renamed from: i  reason: collision with root package name */
    public long f14549i;
    public long j;
    public long k;
    public long l;
    public CustomMessageListener m;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            EnterForumModel.this.L((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, d.a.n0.j0.d.d> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.n0.j0.d.d doInBackground(Void... voidArr) {
            l<byte[]> e2 = d.a.m0.r.r.a.f().e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
            d.a.n0.j0.d.d dVar = new d.a.n0.j0.d.d();
            byte[] bArr = e2.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
            if (bArr != null) {
                dVar.m(true);
                try {
                    ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                    if (forumRecommendResIdl.data != null) {
                        dVar.j(forumRecommendResIdl.data);
                    }
                } catch (Exception unused) {
                    dVar.m(false);
                }
                if (dVar.i() && !dVar.a()) {
                    dVar.e().a();
                }
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.n0.j0.d.d dVar) {
            super.onPostExecute(dVar);
            e eVar = new e(EnterForumModel.this);
            eVar.f14557c = 0;
            if (dVar != null && dVar.i()) {
                eVar.f14556b = true;
                eVar.f14558d = dVar;
            } else {
                eVar.f14556b = false;
                eVar.f14558d = dVar;
            }
            EnterForumModel.this.f14547g.a(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f14552a;

        public c(boolean z) {
            this.f14552a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
            if (h2 == null || StringUtils.isNull(h2.get(EnterForumModel.CACHE_KEY))) {
                return null;
            }
            try {
                return (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            if (recentlyVisitedForumData != null) {
                EnterForumModel.this.f14546f.B(recentlyVisitedForumData.y());
                EnterForumModel.this.f14546f.C(200);
            }
            EnterForumModel.this.H(this.f14552a);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Object> {
        public d() {
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            RecentlyVisitedForumData recentlyVisitedForumData;
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
            if (h2 != null && (recentlyVisitedForumData = EnterForumModel.this.f14546f) != null) {
                h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public String f14555a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f14556b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f14557c = -1;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.j0.d.d f14558d = null;

        public e(EnterForumModel enterForumModel) {
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(e eVar);
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f14545e = null;
        this.f14547g = null;
        this.f14548h = null;
        this.f14549i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = new a(2016564);
        setUniqueId(BdUniqueId.gen());
        this.f14546f = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.m);
    }

    public d.a.n0.j0.d.d A() {
        return this.f14545e;
    }

    public long B() {
        return this.l;
    }

    public long C() {
        return this.f14549i;
    }

    public long D() {
        return this.k;
    }

    public long E() {
        return this.j;
    }

    public boolean F() {
        d.a.n0.j0.d.d dVar;
        if (TbadkCoreApplication.isLogin() && d.a.m0.r.d0.b.j().g("enter_forum_create_forum", true) && (dVar = this.f14545e) != null && dVar.b() != null) {
            return this.f14545e.b().z();
        }
        return false;
    }

    public boolean G(boolean z) {
        z(z);
        return true;
    }

    public boolean H(boolean z) {
        return I(z, d.a.m0.r.d0.b.j().k("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean I(boolean z, int i2) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i2));
        forumrecommendrequestmessage.setForumData(this.f14546f.y());
        this.f14549i = System.currentTimeMillis();
        if (this.f14548h == null) {
            this.f14548h = new d.a.n0.e3.j0.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public final void J() {
        d.a.n0.e3.j0.b bVar = this.f14548h;
        if (bVar != null) {
            bVar.a();
            this.f14548h = null;
        }
    }

    public void K(d.a.n0.j0.d.f fVar) {
        if (fVar == null) {
            return;
        }
        int size = this.f14546f.y().size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f14546f.y().get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.D())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f14546f.y().remove(i2);
        }
    }

    public final void L(VisitedForumData visitedForumData) {
        d.a.n0.j0.d.d dVar;
        if (visitedForumData == null || (dVar = this.f14545e) == null) {
            return;
        }
        int size = dVar.e().b().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f14545e.e().b().get(i2).D().equals(visitedForumData.getForumId())) {
                this.f14546f.w(visitedForumData);
                this.f14546f.C(200);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        int downSize = forumrecommendhttpresponsemessage.getDownSize();
        long costTime = forumrecommendhttpresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        O(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void N(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendsocketresponsemessage.getErrorString();
        }
        O(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), errorString, false, downSize, 0L, costTime);
    }

    public void O(ResponsedMessage<?> responsedMessage, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        if (z) {
            this.f14545e = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                R((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                Q((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        P(z, i2, str, z2, i3, j, j2);
    }

    public void P(boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        e eVar = new e(this);
        boolean z3 = !z;
        d.a.n0.e3.j0.b bVar = this.f14548h;
        if (bVar != null) {
            bVar.b(z2, z3, i2, str, i3, j, j2);
            this.f14548h = null;
        }
        if (!z && this.f14545e.i()) {
            eVar.f14557c = 1;
            eVar.f14556b = true;
            eVar.f14558d = this.f14545e;
            this.f14547g.a(eVar);
            return;
        }
        if (str != null && str.length() > 0) {
            setErrorString(str);
            eVar.f14555a = str;
        }
        eVar.f14557c = 1;
        eVar.f14556b = false;
        eVar.f14558d = this.f14545e;
        this.f14547g.a(eVar);
    }

    public void Q(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage == null) {
            return;
        }
        try {
            this.f14545e = new d.a.n0.j0.d.d();
            d.a.n0.j0.f.a.a aVar = new d.a.n0.j0.f.a.a();
            aVar.f(forumrecommendhttpresponsemessage.getForumPopUpInfo());
            this.f14545e.t(aVar);
            this.f14545e.s(forumrecommendhttpresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendhttpresponsemessage.GetLikeForum());
            this.f14545e.n(gVar);
            o1 o1Var = new o1();
            o1Var.C(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
            this.f14545e.p(o1Var);
            this.f14545e.m(true);
            this.f14545e.l(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            this.f14545e.q(forumrecommendhttpresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendhttpresponsemessage.getForumCreateInfo());
            this.f14545e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendhttpresponsemessage.getPrivatePopInfo());
            this.f14545e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendhttpresponsemessage.getTabFeedList());
            this.f14545e.r(jVar);
        } catch (Exception e2) {
            this.f14545e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void R(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage == null) {
            return;
        }
        try {
            this.f14545e = new d.a.n0.j0.d.d();
            d.a.n0.j0.f.a.a aVar = new d.a.n0.j0.f.a.a();
            aVar.f(forumrecommendsocketresponsemessage.getForumPopupInfo());
            this.f14545e.t(aVar);
            this.f14545e.s(forumrecommendsocketresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendsocketresponsemessage.GetLikeForum());
            this.f14545e.n(gVar);
            o1 o1Var = new o1();
            o1Var.C(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
            this.f14545e.p(o1Var);
            this.f14545e.m(true);
            this.f14545e.l(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            this.f14545e.q(forumrecommendsocketresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendsocketresponsemessage.getForumCreateInfo());
            this.f14545e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendsocketresponsemessage.getPrivatePopInfo());
            this.f14545e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendsocketresponsemessage.getTabFeedList());
            this.f14545e.r(jVar);
        } catch (Exception e2) {
            this.f14545e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void S(d.a.n0.j0.d.d dVar) {
        this.f14545e = dVar;
    }

    public void T(f fVar) {
        this.f14547g = fVar;
    }

    public void U(boolean z) {
    }

    public List<d.a.n0.j0.d.f> V(List<d.a.n0.j0.d.f> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    for (d.a.n0.j0.d.f fVar : list) {
                        if (fVar != null && fVar.G() != null && fVar.G().equals(str)) {
                            arrayList.add(fVar);
                        }
                    }
                }
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.n0.j0.d.f fVar2 = list.get(i2);
                    if (!arrayList.contains(fVar2)) {
                        arrayList.add(fVar2);
                    }
                }
            } else {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public final void W() {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        h0.b(new d(), null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        J();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.m);
    }

    public void onPause() {
        W();
    }

    public boolean y() {
        if (TbadkCoreApplication.isLogin()) {
            d.a.n0.j0.d.d dVar = this.f14545e;
            if (dVar == null || dVar.b() == null) {
                return true;
            }
            return this.f14545e.b().y();
        }
        return false;
    }

    public final void z(boolean z) {
        new b().execute(new Void[0]);
        c cVar = new c(z);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
