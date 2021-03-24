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
import d.b.b.e.d.l;
import d.b.b.e.p.k;
import d.b.h0.r.q.o1;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.i0.d.g;
import d.b.i0.i0.d.j;
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
    public d.b.i0.i0.d.d f15471e;

    /* renamed from: f  reason: collision with root package name */
    public RecentlyVisitedForumData f15472f;

    /* renamed from: g  reason: collision with root package name */
    public f f15473g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c3.j0.b f15474h;
    public long i;
    public long j;
    public long k;
    public long l;
    public CustomMessageListener m;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            EnterForumModel.this.H((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, d.b.i0.i0.d.d> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.b.i0.i0.d.d doInBackground(Void... voidArr) {
            l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
            d.b.i0.i0.d.d dVar = new d.b.i0.i0.d.d();
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
        public void onPostExecute(d.b.i0.i0.d.d dVar) {
            super.onPostExecute(dVar);
            e eVar = new e(EnterForumModel.this);
            eVar.f15482c = 0;
            if (dVar != null && dVar.i()) {
                eVar.f15481b = true;
                eVar.f15483d = dVar;
            } else {
                eVar.f15481b = false;
                eVar.f15483d = dVar;
            }
            EnterForumModel.this.f15473g.a(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f15477a;

        public c(boolean z) {
            this.f15477a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            l<String> h2 = d.b.h0.r.r.a.f().h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
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
                EnterForumModel.this.f15472f.x(recentlyVisitedForumData.u());
                EnterForumModel.this.f15472f.y(200);
            }
            EnterForumModel.this.D(this.f15477a);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Object> {
        public d() {
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            RecentlyVisitedForumData recentlyVisitedForumData;
            l<String> h2 = d.b.h0.r.r.a.f().h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
            if (h2 != null && (recentlyVisitedForumData = EnterForumModel.this.f15472f) != null) {
                h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public String f15480a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f15481b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f15482c = -1;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.i0.d.d f15483d = null;

        public e(EnterForumModel enterForumModel) {
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(e eVar);
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f15471e = null;
        this.f15473g = null;
        this.f15474h = null;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = new a(2016564);
        setUniqueId(BdUniqueId.gen());
        this.f15472f = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.m);
    }

    public long A() {
        return this.j;
    }

    public boolean B() {
        d.b.i0.i0.d.d dVar;
        if (TbadkCoreApplication.isLogin() && d.b.h0.r.d0.b.i().g("enter_forum_create_forum", true) && (dVar = this.f15471e) != null && dVar.b() != null) {
            return this.f15471e.b().v();
        }
        return false;
    }

    public boolean C(boolean z) {
        v(z);
        return true;
    }

    public boolean D(boolean z) {
        return E(z, d.b.h0.r.d0.b.i().j("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL));
    }

    public boolean E(boolean z, int i) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        forumrecommendrequestmessage.set_sortType(Integer.valueOf(i));
        forumrecommendrequestmessage.setForumData(this.f15472f.u());
        this.i = System.currentTimeMillis();
        if (this.f15474h == null) {
            this.f15474h = new d.b.i0.c3.j0.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public final void F() {
        d.b.i0.c3.j0.b bVar = this.f15474h;
        if (bVar != null) {
            bVar.a();
            this.f15474h = null;
        }
    }

    public void G(d.b.i0.i0.d.f fVar) {
        if (fVar == null) {
            return;
        }
        int size = this.f15472f.u().size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f15472f.u().get(i2);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.D())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.f15472f.u().remove(i);
        }
    }

    public final void H(VisitedForumData visitedForumData) {
        d.b.i0.i0.d.d dVar;
        if (visitedForumData == null || (dVar = this.f15471e) == null) {
            return;
        }
        int size = dVar.e().b().size();
        for (int i = 0; i < size; i++) {
            if (this.f15471e.e().b().get(i).D().equals(visitedForumData.getForumId())) {
                this.f15472f.s(visitedForumData);
                this.f15472f.y(200);
            }
        }
    }

    public void I(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        int downSize = forumrecommendhttpresponsemessage.getDownSize();
        long costTime = forumrecommendhttpresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        K(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void J(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
        } else {
            errorString = forumrecommendsocketresponsemessage.getErrorString();
        }
        K(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), errorString, false, downSize, 0L, costTime);
    }

    public void K(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.f15471e = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                N((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                M((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        L(z, i, str, z2, i2, j, j2);
    }

    public void L(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        e eVar = new e(this);
        boolean z3 = !z;
        d.b.i0.c3.j0.b bVar = this.f15474h;
        if (bVar != null) {
            bVar.b(z2, z3, i, str, i2, j, j2);
            this.f15474h = null;
        }
        if (!z && this.f15471e.i()) {
            eVar.f15482c = 1;
            eVar.f15481b = true;
            eVar.f15483d = this.f15471e;
            this.f15473g.a(eVar);
            return;
        }
        if (str != null && str.length() > 0) {
            setErrorString(str);
            eVar.f15480a = str;
        }
        eVar.f15482c = 1;
        eVar.f15481b = false;
        eVar.f15483d = this.f15471e;
        this.f15473g.a(eVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage == null) {
            return;
        }
        try {
            this.f15471e = new d.b.i0.i0.d.d();
            d.b.i0.i0.f.a.a aVar = new d.b.i0.i0.f.a.a();
            aVar.f(forumrecommendhttpresponsemessage.getForumPopUpInfo());
            this.f15471e.t(aVar);
            this.f15471e.s(forumrecommendhttpresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendhttpresponsemessage.GetLikeForum());
            this.f15471e.n(gVar);
            o1 o1Var = new o1();
            o1Var.C(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
            this.f15471e.p(o1Var);
            this.f15471e.m(true);
            this.f15471e.l(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            this.f15471e.q(forumrecommendhttpresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.w(forumrecommendhttpresponsemessage.getForumCreateInfo());
            this.f15471e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.w(forumrecommendhttpresponsemessage.getPrivatePopInfo());
            this.f15471e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendhttpresponsemessage.getTabFeedList());
            this.f15471e.r(jVar);
        } catch (Exception e2) {
            this.f15471e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void N(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage == null) {
            return;
        }
        try {
            this.f15471e = new d.b.i0.i0.d.d();
            d.b.i0.i0.f.a.a aVar = new d.b.i0.i0.f.a.a();
            aVar.f(forumrecommendsocketresponsemessage.getForumPopupInfo());
            this.f15471e.t(aVar);
            this.f15471e.s(forumrecommendsocketresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendsocketresponsemessage.GetLikeForum());
            this.f15471e.n(gVar);
            o1 o1Var = new o1();
            o1Var.C(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
            this.f15471e.p(o1Var);
            this.f15471e.m(true);
            this.f15471e.l(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            this.f15471e.q(forumrecommendsocketresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.w(forumrecommendsocketresponsemessage.getForumCreateInfo());
            this.f15471e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.w(forumrecommendsocketresponsemessage.getPrivatePopInfo());
            this.f15471e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendsocketresponsemessage.getTabFeedList());
            this.f15471e.r(jVar);
        } catch (Exception e2) {
            this.f15471e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void O(d.b.i0.i0.d.d dVar) {
        this.f15471e = dVar;
    }

    public void P(f fVar) {
        this.f15473g = fVar;
    }

    public void Q(boolean z) {
    }

    public List<d.b.i0.i0.d.f> R(List<d.b.i0.i0.d.f> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    for (d.b.i0.i0.d.f fVar : list) {
                        if (fVar != null && fVar.G() != null && fVar.G().equals(str)) {
                            arrayList.add(fVar);
                        }
                    }
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    d.b.i0.i0.d.f fVar2 = list.get(i);
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

    public final void S() {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        h0.b(new d(), null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        F();
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
        S();
    }

    public boolean u() {
        if (TbadkCoreApplication.isLogin()) {
            d.b.i0.i0.d.d dVar = this.f15471e;
            if (dVar == null || dVar.b() == null) {
                return true;
            }
            return this.f15471e.b().u();
        }
        return false;
    }

    public final void v(boolean z) {
        new b().execute(new Void[0]);
        c cVar = new c(z);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }

    public d.b.i0.i0.d.d w() {
        return this.f15471e;
    }

    public long x() {
        return this.l;
    }

    public long y() {
        return this.i;
    }

    public long z() {
        return this.k;
    }
}
