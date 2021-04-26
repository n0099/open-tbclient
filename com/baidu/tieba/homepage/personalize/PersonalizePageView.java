package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import d.a.i0.r.f0.f;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.r0;
import d.a.i0.r.q.v0;
import d.a.j0.a1.g.e;
import d.a.j0.a1.g.h.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    public int A;
    public int B;
    public boolean C;
    public int D;
    public LinearLayoutManager E;
    public d.a.c.j.e.l F;
    public FRSRefreshButton G;
    public RightFloatLayerView H;
    public d.a.i0.s.c.f I;
    public int J;
    public Context K;
    public CustomMessageListener L;
    public b0.f M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public NEGFeedBackView.b P;
    public FollowUserButton.a Q;
    public ScrollFragmentTabHost R;
    public int S;
    public RecyclerView.OnScrollListener T;
    public ScrollFragmentTabHost.q U;
    public View.OnClickListener V;
    public CustomMessageListener W;
    public e.j0 a0;
    public f.g b0;
    public f.h c0;
    public f.e d0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f17157e;
    public f.InterfaceC1049f e0;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f17158f;
    public Runnable f0;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.a1.g.i.b f17159g;
    public final CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.a1.g.i.a f17160h;
    public View.OnClickListener h0;

    /* renamed from: i  reason: collision with root package name */
    public d0 f17161i;
    public CustomMessageListener i0;
    public PbListView j;
    public CustomMessageListener j0;
    public d.a.j0.a1.g.h.b0 k;
    public View.OnClickListener k0;
    public TbPageContext<?> l;
    public d.a.j0.a1.c.b m;
    public d.a.j0.a1.g.e n;
    public d.a.j0.a1.g.a o;
    public d.a.j0.a1.g.k.e p;
    public d.a.i0.d0.g q;
    public d.a.i0.d0.h r;
    public long s;
    public int t;
    public boolean u;
    public boolean v;
    public long w;
    public boolean x;
    public d.a.j0.x.p y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.f17158f != null && PersonalizePageView.this.y != null && PersonalizePageView.this.y.b().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                PersonalizePageView.this.y.d();
                PersonalizePageView.this.y.b().setVisibility(0);
                PersonalizePageView.this.y.f("1");
                PersonalizePageView.this.f17158f.setHeaderView(PersonalizePageView.this.y.b());
            }
            PersonalizePageView.this.d0();
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends RecyclerView.OnScrollListener {
        public a0() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (PersonalizePageView.this.S == i2 || PersonalizePageView.this.R == null) {
                return;
            }
            PersonalizePageView.this.S = i2;
            if (PersonalizePageView.this.S == 1) {
                PersonalizePageView.this.R.T();
            } else if (PersonalizePageView.this.p0(recyclerView)) {
                PersonalizePageView.this.R.w();
            } else {
                PersonalizePageView.this.R.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.j0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f17164a = d.a.i0.r.d0.b.j().g("key_first_install", true);

        public b() {
        }

        @Override // d.a.j0.a1.g.e.j0
        public void a(int i2, d.a.i0.z0.c cVar, int i3) {
            if (PersonalizePageView.this.m != null) {
                boolean e0 = PersonalizePageView.this.e0();
                PersonalizePageView.this.Y();
                if (e0) {
                    PersonalizePageView.this.u0(true);
                }
                PersonalizePageView.this.m.c(i2, cVar, i3);
                d.a.i0.a.q.g().s();
                return;
            }
            PersonalizePageView personalizePageView = PersonalizePageView.this;
            personalizePageView.v0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            PersonalizePageView.this.X();
        }

        @Override // d.a.j0.a1.g.e.j0
        public void b() {
            if (PersonalizePageView.this.j != null) {
                PersonalizePageView.this.j.A(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                PersonalizePageView.this.j.f();
                PersonalizePageView.this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }

        @Override // d.a.j0.a1.g.e.j0
        public void c(int i2, int i3, d.a.i0.z0.c cVar, int i4) {
            if (PersonalizePageView.this.m != null) {
                PersonalizePageView.this.m.d(i2, i3, cVar, i4);
            }
        }

        @Override // d.a.j0.a1.g.e.j0
        public void d(boolean z) {
            e();
            PersonalizePageView.this.f17157e.setVisibility(0);
            PersonalizePageView.this.X();
            PersonalizePageView.this.Y();
            if (PermissionUtil.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                MercatorModel.d().f();
            }
            if (z) {
                PersonalizePageView.this.v = true;
                PersonalizePageView.this.w = System.currentTimeMillis();
            }
        }

        public final void e() {
            if (this.f17164a) {
                this.f17164a = false;
                d.a.i0.r.d0.b.j().t("key_first_install", false);
            }
        }

        @Override // d.a.j0.a1.g.e.j0
        public void onError(int i2, String str) {
            PersonalizePageView.this.X();
            if (i2 == 1) {
                if (d.a.c.e.p.j.z()) {
                    PersonalizePageView.this.l.showToast(str);
                }
                e();
            } else if (!this.f17164a) {
                PersonalizePageView.this.f17157e.setVisibility(8);
                PersonalizePageView personalizePageView = PersonalizePageView.this;
                personalizePageView.v0(personalizePageView, str, true);
            } else {
                e();
                PersonalizePageView.this.x0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends ScrollFragmentTabHost.q {
        public b0() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.q
        public void b() {
            if (PersonalizePageView.this.R != null) {
                PersonalizePageView.this.S = -1;
                PersonalizePageView personalizePageView = PersonalizePageView.this;
                if (personalizePageView.p0(personalizePageView.f17158f)) {
                    PersonalizePageView.this.R.w();
                } else {
                    PersonalizePageView.this.R.T();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17167e;

        public c(String str) {
            this.f17167e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalizePageView.this.H.j();
            PersonalizePageView.this.f0(this.f17167e);
            PersonalizePageView.this.Z();
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1).param("obj_param1", 0));
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.f17158f != null) {
                PersonalizePageView.this.f17158f.removeHeaderView(PersonalizePageView.this.y.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalizePageView.this.H.j();
            PersonalizePageView.this.Z();
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 1).param("obj_locate", 1));
        }
    }

    /* loaded from: classes4.dex */
    public interface d0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void i(f.e eVar);

        void l(f.InterfaceC1049f interfaceC1049f);
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            d.a.j0.m.d.c().f("page_recommend");
            PersonalizePageView.this.n.X0();
            PersonalizePageView.this.n.P0(false);
            PersonalizePageView.this.C = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements f.h {
        public f() {
        }

        @Override // d.a.i0.r.f0.f.h
        public void a(boolean z) {
            if (PersonalizePageView.this.n == null || PersonalizePageView.this.n.g0() == null) {
                return;
            }
            PersonalizePageView.this.n.g0().w();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements f.e {
        public g() {
        }

        @Override // d.a.i0.r.f0.f.e
        public void a() {
            if (PersonalizePageView.this.C) {
                PersonalizePageView.this.B = 0;
                PersonalizePageView.this.D = 1;
                PersonalizePageView.this.C = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.InterfaceC1049f {
        public h() {
        }

        @Override // d.a.i0.r.f0.f.InterfaceC1049f
        public void a(View view, boolean z) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.n.P0(true);
                PersonalizePageView.this.n.G0();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
            d.a.i0.r.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.a.i0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = d.a.i0.r.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (PersonalizePageView.this.E != null && i2 == 0) {
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                if (PersonalizePageView.this.B < height || PersonalizePageView.this.D != 1) {
                    if (PersonalizePageView.this.B < height && PersonalizePageView.this.D == 2) {
                        PersonalizePageView.this.D = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                    }
                } else {
                    PersonalizePageView.this.D = 2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.D)));
                }
                if (PersonalizePageView.this.E.getItemCount() - PersonalizePageView.this.E.findLastVisibleItemPosition() <= 15) {
                    PersonalizePageView.this.g0();
                }
            }
            if (i2 == 0) {
                if (PersonalizePageView.this.H != null) {
                    PersonalizePageView.this.H.q();
                }
            } else if (i2 == 1) {
                if (PersonalizePageView.this.H != null) {
                    PersonalizePageView.this.H.p();
                }
            } else if (i2 != 2 || PersonalizePageView.this.H == null) {
            } else {
                PersonalizePageView.this.H.r();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            PersonalizePageView.this.B += i3;
            if (PersonalizePageView.this.G != null) {
                d.a.c.j.e.n B = PersonalizePageView.this.f17158f.B(PersonalizePageView.this.E.findLastVisibleItemPosition());
                if (B instanceof d.a.j0.x.e0.k) {
                    if (((d.a.j0.x.e0.k) B).position >= 6) {
                        PersonalizePageView.this.G.f();
                    } else {
                        PersonalizePageView.this.G.b();
                    }
                }
            }
            if (!d.a.i0.b.d.t() || TbadkCoreApplication.isLogin() || d.a.i0.r.d0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || PersonalizePageView.this.B < d.a.c.e.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                return;
            }
            d.a.i0.r.d0.b.j().v("home_page_login_dialog_show_key", 1);
            DialogLoginHelper.checkUpIsLogin(new r0(PersonalizePageView.this.K, "new_shouye"));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements BdListView.p {
        public j() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            PersonalizePageView.this.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PersonalizePageView.this.F == null) {
                    PersonalizePageView.this.F = new d.a.c.j.e.l(new d.a.c.j.e.j());
                }
                PersonalizePageView.this.F.q(PersonalizePageView.this.f17158f, 2);
            } else if (PersonalizePageView.this.F != null) {
                PersonalizePageView.this.F.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements BdListView.o {
        public l() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            if (System.currentTimeMillis() - PersonalizePageView.this.s < 5000) {
                return;
            }
            PersonalizePageView.this.n.F0(i2, i3);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements RecyclerView.RecyclerListener {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (PersonalizePageView.this.n != null && PersonalizePageView.this.n.g0() != null) {
                PersonalizePageView.this.n.g0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.n.X0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PersonalizePageView.this.l != null) {
                d.a.i0.r.d0.b.j().v("show_is_uninterest_tag", PersonalizePageView.C(PersonalizePageView.this));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.l.getContext(), 2)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalizePageView.this.n0();
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PersonalizePageView.this.i0();
            }
        }

        public q(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            if (customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData.getStatus() == 0) {
                    z = true;
                }
            }
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new a(), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalizePageView.this.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public s(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            PersonalizePageView.this.u = true;
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public t(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.f17157e == null || PersonalizePageView.this.f17157e.t()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d.a.i0.r.n.a))) {
                if (PersonalizePageView.this.f17160h != null) {
                    if (PersonalizePageView.this.f17161i == PersonalizePageView.this.f17160h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = PersonalizePageView.this;
                    personalizePageView.f17161i = personalizePageView.f17160h;
                } else {
                    PersonalizePageView personalizePageView2 = PersonalizePageView.this;
                    personalizePageView2.f17160h = new d.a.j0.a1.g.i.a(personalizePageView2.l);
                    PersonalizePageView.this.f17160h.I(PersonalizePageView.this.t);
                    PersonalizePageView personalizePageView3 = PersonalizePageView.this;
                    personalizePageView3.f17161i = personalizePageView3.f17160h;
                    PersonalizePageView.this.c0();
                }
                PersonalizePageView.this.f17160h.B(true);
                PersonalizePageView.this.f17157e.setProgressView(PersonalizePageView.this.f17160h);
                int i2 = (int) (PersonalizePageView.this.getResources().getDisplayMetrics().density * 86.0f);
                PersonalizePageView.this.f17157e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            d.a.i0.r.n.a aVar = (d.a.i0.r.n.a) customResponsedMessage.getData();
            if (PersonalizePageView.this.f17159g != null) {
                if (PersonalizePageView.this.f17161i == PersonalizePageView.this.f17159g && aVar.equals(PersonalizePageView.this.f17159g.G())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = PersonalizePageView.this;
                personalizePageView4.f17161i = personalizePageView4.f17159g;
            } else {
                PersonalizePageView personalizePageView5 = PersonalizePageView.this;
                personalizePageView5.f17159g = new d.a.j0.a1.g.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = PersonalizePageView.this;
                personalizePageView6.f17161i = personalizePageView6.f17159g;
                PersonalizePageView.this.c0();
            }
            PersonalizePageView.this.f17159g.B(true);
            PersonalizePageView.this.f17157e.setProgressView(PersonalizePageView.this.f17159g);
            PersonalizePageView.this.f17159g.J(aVar);
            PersonalizePageView.this.f17157e.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (d.a.c.e.p.l.i(PersonalizePageView.this.l.getContext()) * 0.8d), d.a.c.e.p.l.i(PersonalizePageView.this.l.getContext()));
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.G != null) {
                PersonalizePageView.this.G.b();
                PersonalizePageView.this.q0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements b0.f {
        public v() {
        }

        @Override // d.a.j0.a1.g.h.b0.f
        public void a() {
            if (PersonalizePageView.this.f17158f == null || PersonalizePageView.this.y == null) {
                return;
            }
            if (TbSingleton.getInstance().isAddBanner) {
                PersonalizePageView.this.f17158f.removeHeaderView(PersonalizePageView.this.y.b());
            } else if (PersonalizePageView.this.y.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
            } else {
                PersonalizePageView.this.y.d();
                PersonalizePageView.this.y.b().setVisibility(0);
                PersonalizePageView.this.y.f("1");
                PersonalizePageView.this.f17158f.setHeaderView(PersonalizePageView.this.y.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w extends CustomMessageListener {
        public w(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.y0(d.a.i0.r.v.a.b().c(), false, false);
            }
            PersonalizePageView.this.X();
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public x(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                PersonalizePageView.this.J = ((Integer) data).intValue();
                if (PersonalizePageView.this.H != null) {
                    ((FrameLayout.LayoutParams) PersonalizePageView.this.H.getLayoutParams()).topMargin = d.a.c.e.p.l.g(PersonalizePageView.this.K, R.dimen.tbds1409) - PersonalizePageView.this.J;
                    PersonalizePageView.this.H.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements NEGFeedBackView.b {
        public y() {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            if (arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = v0Var.m;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49 || i4 == 69) {
                i2 = 3;
            }
            if (PersonalizePageView.this.k != null) {
                PersonalizePageView.this.k.m();
            }
            TiebaStatic.log(new StatisticItem("c11693").param("tid", v0Var.e()).param("nid", v0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c11693").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", v0Var.d()));
            TiebaStatic.log(new StatisticItem("c11989").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes4.dex */
    public class z implements FollowUserButton.a {
        public z() {
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof a2) {
                TiebaStatic.log(d.a.j0.c3.a.m("c13696", (a2) tag));
            }
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(2156674);
        this.M = new v();
        this.N = new w(2921456);
        this.O = new x(2921553);
        this.P = new y();
        this.Q = new z();
        this.S = -1;
        this.T = new a0();
        this.U = new b0();
        this.V = new c0();
        this.W = new a(2001371);
        this.a0 = new b();
        this.b0 = new e();
        this.c0 = new f();
        this.d0 = new g();
        this.e0 = new h();
        this.f0 = new o();
        this.g0 = new q(2001118);
        this.h0 = new r();
        this.i0 = new s(2921033);
        this.j0 = new t(2921349);
        this.k0 = new u();
        a0(context);
    }

    public static /* synthetic */ int C(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.A + 1;
        personalizePageView.A = i2;
        return i2;
    }

    public void A0() {
        RightFloatLayerView rightFloatLayerView = this.H;
        if (rightFloatLayerView == null) {
            return;
        }
        if (!rightFloatLayerView.m()) {
            Z();
            return;
        }
        d.a.i0.s.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
        this.I = adFloatViewData;
        if (adFloatViewData == null) {
            return;
        }
        this.H.setData(adFloatViewData.a());
        w0();
        TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1));
        this.H.setLogoListener(new c(this.I.d()));
        this.H.setFeedBackListener(new d());
    }

    public void U() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17157e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void V(Long l2) {
        this.n.Y(l2);
    }

    public void W() {
        if (this.r != null) {
            q0();
            return;
        }
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.X0();
        }
    }

    public final void X() {
        d.a.i0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.dettachView(this);
            this.q = null;
            this.f17158f.setNextPage(this.j);
            this.j.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17157e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.setVisibility(0);
        }
        d.a.j0.a1.c.b bVar = this.m;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void Y() {
        d.a.i0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.dettachView(this);
            this.r = null;
        }
    }

    public void Z() {
        RightFloatLayerView rightFloatLayerView = this.H;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.f();
        }
    }

    public final void a0(Context context) {
        this.K = context;
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f17158f = bdTypeRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
        this.E = linearLayoutManager;
        this.f17158f.setLayoutManager(linearLayoutManager);
        this.f17158f.setFadingEdgeLength(0);
        this.f17158f.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f17158f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        d.a.j0.x.p pVar = new d.a.j0.x.p(context);
        this.y = pVar;
        pVar.setFrom("from_personaize");
        this.y.a().setVisibility(0);
        this.y.a().setOnClickListener(this.V);
        MessageManager.getInstance().registerListener(this.W);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            d.a.c.j.e.l lVar = new d.a.c.j.e.l(new d.a.c.j.e.j());
            this.F = lVar;
            lVar.q(this.f17158f, 2);
        }
        MessageManager.getInstance().registerListener(this.L);
        MessageManager.getInstance().registerListener(this.N);
        MessageManager.getInstance().registerListener(this.O);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.f17157e = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.f17158f);
        PbListView pbListView = new PbListView(context);
        this.j = pbListView;
        pbListView.b();
        this.j.o(R.color.transparent);
        this.j.v();
        this.j.C(SkinManager.getColor(R.color.CAM_X0107));
        this.j.E(R.dimen.tbfontsize33);
        this.j.y(R.color.CAM_X0110);
        this.j.r(d.a.c.e.p.l.g(context, R.dimen.tbds182));
        this.j.z(this.h0);
        this.j.q();
        this.f17158f.setNextPage(this.j);
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.l = (TbPageContext) a2;
        }
        MessageManager.getInstance().registerListener(this.j0);
        d.a.i0.r.n.b.i().n(true);
        d.a.i0.r.n.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.a.i0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            aVar = d.a.i0.r.n.b.i().h(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.f17157e);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.G = new FRSRefreshButton(context);
            int g2 = d.a.c.e.p.l.g(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = d.a.c.e.p.l.g(context, R.dimen.tbds24);
            layoutParams.bottomMargin = d.a.c.e.p.l.g(context, R.dimen.tbds180);
            addView(this.G, layoutParams);
            this.G.setOnClickListener(this.k0);
            this.G.setVisibility(8);
        }
        this.H = new RightFloatLayerView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 53;
        layoutParams2.topMargin = d.a.c.e.p.l.g(context, R.dimen.tbds1409) - this.J;
        addView(this.H, layoutParams2);
        this.H.setVisibility(8);
        d0();
        this.p = new d.a.j0.a1.g.k.e();
        d.a.j0.a1.g.h.b0 b0Var = new d.a.j0.a1.g.h.b0(context, this.f17158f);
        this.k = b0Var;
        b0Var.x(this.p);
        this.k.v(this.M);
        this.n = new d.a.j0.a1.g.e(this.l, this.f17158f, this.k, this.f17157e);
        this.o = new d.a.j0.a1.g.a(this.l);
        j0(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.i0);
        this.A = d.a.i0.r.d0.b.j().k("show_is_uninterest_tag", 0);
    }

    public void b0() {
        this.k.u(this.P);
        this.k.s(this.Q);
        this.n.O0(this.a0);
        this.o.i(this);
        c0();
        this.f17158f.addOnScrollListener(new i());
        this.f17158f.setOnSrollToBottomListener(new j());
        this.f17158f.setOnScrollStopDelayedListener(new l(), 1L);
        this.f17158f.setRecyclerListener(new m());
        this.f17158f.removeOnScrollListener(this.T);
        this.f17158f.addOnScrollListener(this.T);
    }

    public void c0() {
        d0 d0Var = this.f17161i;
        if (d0Var != null) {
            d0Var.a(this.b0);
            this.f17161i.b(this.c0);
            this.f17161i.i(this.d0);
            this.f17161i.l(this.e0);
        }
    }

    public final void d0() {
        if (TbSingleton.getInstance().isShowRightFloatView(0)) {
            A0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.v) {
            post(new p());
        }
    }

    public final boolean e0() {
        d.a.i0.d0.h hVar = this.r;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public final void f0(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.l.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void g0() {
        d.a.j0.a1.c.a.d().j(System.currentTimeMillis(), 1);
        PbListView pbListView = this.j;
        if (pbListView != null && !pbListView.l()) {
            this.j.O();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.r0();
    }

    public boolean getIsUnreadTipShow() {
        return this.z;
    }

    public void h0() {
        this.n.o0();
    }

    public void i0() {
        d.a.j0.a1.g.h.b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.m();
        }
    }

    public void j0(int i2) {
        if (this.t != i2) {
            d.a.i0.d0.g gVar = this.q;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            d.a.i0.d0.h hVar = this.r;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            d.a.j0.a1.g.i.a aVar = this.f17160h;
            if (aVar != null) {
                aVar.I(i2);
            }
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.j.d(i2);
            }
            this.k.n(i2);
            d.a.j0.a1.g.e eVar = this.n;
            if (eVar != null) {
                eVar.w0(i2);
            }
            FRSRefreshButton fRSRefreshButton = this.G;
            if (fRSRefreshButton != null) {
                fRSRefreshButton.d(i2);
            }
            d.a.j0.x.p pVar = this.y;
            if (pVar != null) {
                pVar.e(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.H;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
        }
        this.t = i2;
    }

    public void k0() {
        MessageManager.getInstance().unRegisterListener(this.W);
        MessageManager.getInstance().unRegisterListener(this.L);
        MessageManager.getInstance().unRegisterListener(this.N);
        MessageManager.getInstance().unRegisterListener(this.i0);
        MessageManager.getInstance().unRegisterListener(this.j0);
        MessageManager.getInstance().unRegisterListener(this.O);
        this.n.x0();
        this.k.u(null);
        this.k.o();
        this.n.O0(null);
        d.a.j0.a1.g.i.b bVar = this.f17159g;
        if (bVar != null) {
            bVar.a(null);
            this.f17159g.b(null);
            this.f17159g.i(null);
            this.f17159g.l(null);
            this.f17159g.H();
        }
        d.a.j0.a1.g.i.a aVar = this.f17160h;
        if (aVar != null) {
            aVar.a(null);
            this.f17160h.b(null);
            this.f17160h.i(null);
            this.f17160h.l(null);
            this.f17160h.X();
        }
        this.f17158f.setOnSrollToBottomListener(null);
        ScrollFragmentTabHost scrollFragmentTabHost = this.R;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.U);
        }
        this.f17158f.removeOnScrollListener(this.T);
        d.a.i0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.m();
        }
        this.f17158f.setRecyclerListener(null);
        d.a.j0.a1.g.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.g();
        }
        d.a.i0.r.n.b.i().e();
        d.a.c.e.m.e.a().removeCallbacks(this.f0);
    }

    public void l0() {
        this.n.A0();
        d.a.j0.a1.g.h.b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.p();
        }
    }

    public void m0() {
        if (this.u) {
            q0();
            this.u = false;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17157e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.D();
        }
        d.a.j0.a1.g.h.b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.q();
        }
    }

    public final void n0() {
        if (!this.x) {
            long f2 = d.a.j0.a1.c.a.d().f(1) + d.a.j0.a1.c.a.d().b();
            long a2 = d.a.j0.a1.c.a.d().a(1);
            if (a2 > 0) {
                f2 = System.currentTimeMillis() - a2;
            }
            d.a.i0.m0.n nVar = new d.a.i0.m0.n();
            nVar.a();
            nVar.b();
            d.a.i0.m0.l.b().o(f2);
            if (this.w > 0) {
                d.a.i0.m0.l.b().I(System.currentTimeMillis() - this.w);
            }
            d.a.i0.m0.l.b().M(nVar.c());
        }
        this.x = true;
    }

    public void o0() {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.u0(true);
        }
        d.a.j0.x.t.b().d(false);
        d.a.j0.m.d.c().h("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        d.a.c.e.m.e.a().removeCallbacks(this.f0);
    }

    public boolean p0(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void q0() {
        d.a.j0.a1.g.e eVar;
        if (this.r != null && (eVar = this.n) != null) {
            eVar.X0();
        } else if (this.f17158f == null || this.f17157e == null) {
        } else {
            t0();
            this.f17158f.setSelection(0);
            if (!this.f17157e.t()) {
                d.a.j0.a1.g.e eVar2 = this.n;
                if (eVar2 != null && eVar2.g0() != null) {
                    this.n.g0().w();
                    this.n.P0(false);
                }
                this.f17157e.setRefreshing(true);
            }
            ScrollFragmentTabHost.q qVar = this.U;
            if (qVar != null) {
                qVar.b();
            }
        }
    }

    public void r0() {
        this.n.L0();
    }

    public void s0() {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.T0();
        }
    }

    public void setCallback(d.a.j0.a1.c.b bVar) {
        this.m = bVar;
    }

    public void setIsUnreadTipShow(boolean z2) {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.M0(!z2);
        }
        this.z = z2;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.j0.a1.g.h.b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.w(bdUniqueId);
        }
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.H0(bdUniqueId);
        }
        d.a.j0.a1.g.k.e eVar2 = this.p;
        if (eVar2 != null) {
            eVar2.a(bdUniqueId);
        }
        d.a.j0.a1.g.i.a aVar = this.f17160h;
        if (aVar != null) {
            aVar.Z(bdUniqueId);
        }
        d.a.i0.r.n.b.i().o(bdUniqueId);
        CustomMessageListener customMessageListener = this.g0;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.g0);
        }
        d.a.j0.a1.g.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.h(bdUniqueId);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(d.a.i0.z0.b0 b0Var) {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.Q0(b0Var);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.R = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.U);
            this.R.u(this.U);
        }
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.R0(scrollFragmentTabHost);
        }
        d.a.j0.a1.g.a aVar = this.o;
        if (aVar != null) {
            aVar.j(scrollFragmentTabHost);
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.S0(z2);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.u0(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.A >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
            return;
        }
        d.a.c.e.m.e.a().postDelayed(this.f0, 1000L);
    }

    public void t0() {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.U0();
        }
    }

    public final void u0(boolean z2) {
        if (this.q == null) {
            this.q = new d.a.i0.d0.g(getContext());
            this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + d.a.c.e.p.l.g(getContext(), R.dimen.tbds60));
            this.q.h();
            this.q.setWrapStyle(true);
            this.q.onChangeSkinType();
        }
        this.q.attachView(this, z2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        this.f17158f.setNextPage(null);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17157e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
    }

    public final void v0(View view, String str, boolean z2) {
        if (this.r == null) {
            this.r = new d.a.i0.d0.h(getContext(), new n());
        }
        this.r.attachView(view, z2);
        this.r.o();
    }

    public void w0() {
        RightFloatLayerView rightFloatLayerView = this.H;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.g();
        }
    }

    public void x0() {
        if (this.n != null) {
            u0(true);
            this.n.X0();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            d.a.i0.r.n.b.i().j();
            d.a.i0.r.n.b.i().k();
        }
    }

    public void y0(DataRes dataRes, boolean z2, boolean z3) {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.y0(z2, z3, dataRes, 0, null);
    }

    public void z0(String str, int i2) {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.y0(true, false, null, i2, str);
    }

    public void setViewForeground(boolean z2) {
        d.a.j0.a1.g.e eVar = this.n;
        if (eVar != null) {
            eVar.B0(z2);
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.R;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.U);
            this.R.u(this.U);
            this.U.b();
        }
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(2156674);
        this.M = new v();
        this.N = new w(2921456);
        this.O = new x(2921553);
        this.P = new y();
        this.Q = new z();
        this.S = -1;
        this.T = new a0();
        this.U = new b0();
        this.V = new c0();
        this.W = new a(2001371);
        this.a0 = new b();
        this.b0 = new e();
        this.c0 = new f();
        this.d0 = new g();
        this.e0 = new h();
        this.f0 = new o();
        this.g0 = new q(2001118);
        this.h0 = new r();
        this.i0 = new s(2921033);
        this.j0 = new t(2921349);
        this.k0 = new u();
        a0(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(2156674);
        this.M = new v();
        this.N = new w(2921456);
        this.O = new x(2921553);
        this.P = new y();
        this.Q = new z();
        this.S = -1;
        this.T = new a0();
        this.U = new b0();
        this.V = new c0();
        this.W = new a(2001371);
        this.a0 = new b();
        this.b0 = new e();
        this.c0 = new f();
        this.d0 = new g();
        this.e0 = new h();
        this.f0 = new o();
        this.g0 = new q(2001118);
        this.h0 = new r();
        this.i0 = new s(2921033);
        this.j0 = new t(2921349);
        this.k0 = new u();
        a0(context);
    }
}
