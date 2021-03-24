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
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FollowUserButton;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.r0;
import d.b.h0.r.q.v0;
import d.b.i0.z0.g.e;
import d.b.i0.z0.g.h.b0;
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
    public d.b.b.j.e.l F;
    public FRSRefreshButton G;
    public Context H;
    public CustomMessageListener I;
    public b0.f J;
    public CustomMessageListener K;
    public NEGFeedBackView.b L;
    public FollowUserButton.a M;
    public ScrollFragmentTabHost N;
    public int O;
    public RecyclerView.OnScrollListener P;
    public ScrollFragmentTabHost.q Q;
    public View.OnClickListener R;
    public CustomMessageListener S;
    public e.i0 T;
    public f.g U;
    public f.h V;
    public f.e W;
    public f.InterfaceC1074f a0;
    public Runnable b0;
    public final CustomMessageListener c0;
    public View.OnClickListener d0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f17206e;
    public CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f17207f;
    public CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.z0.g.i.b f17208g;
    public View.OnClickListener g0;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.z0.g.i.a f17209h;
    public a0 i;
    public PbListView j;
    public b0 k;
    public TbPageContext<?> l;
    public d.b.i0.z0.c.b m;
    public d.b.i0.z0.g.e n;
    public d.b.i0.z0.g.a o;
    public d.b.i0.z0.g.k.e p;
    public d.b.h0.d0.g q;
    public d.b.h0.d0.h r;
    public long s;
    public int t;
    public boolean u;
    public boolean v;
    public long w;
    public boolean x;
    public d.b.i0.x.p y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements e.i0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f17210a = d.b.h0.r.d0.b.i().g("key_first_install", true);

        public a() {
        }

        @Override // d.b.i0.z0.g.e.i0
        public void a(int i, d.b.h0.z0.c cVar, int i2) {
            if (PersonalizePageView.this.m != null) {
                boolean X = PersonalizePageView.this.X();
                PersonalizePageView.this.T();
                if (X) {
                    PersonalizePageView.this.m0(true);
                }
                PersonalizePageView.this.m.c(i, cVar, i2);
                d.b.h0.a.q.g().s();
                return;
            }
            PersonalizePageView personalizePageView = PersonalizePageView.this;
            personalizePageView.n0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            PersonalizePageView.this.S();
        }

        @Override // d.b.i0.z0.g.e.i0
        public void b(int i, int i2, d.b.h0.z0.c cVar, int i3) {
            if (PersonalizePageView.this.m != null) {
                PersonalizePageView.this.m.b(i, i2, cVar, i3);
            }
        }

        @Override // d.b.i0.z0.g.e.i0
        public void c() {
            if (PersonalizePageView.this.j != null) {
                PersonalizePageView.this.j.A(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                PersonalizePageView.this.j.f();
                PersonalizePageView.this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }

        @Override // d.b.i0.z0.g.e.i0
        public void d(boolean z) {
            e();
            PersonalizePageView.this.f17206e.setVisibility(0);
            PersonalizePageView.this.S();
            PersonalizePageView.this.T();
            if (PermissionUtil.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                MercatorModel.d().f();
            }
            if (z) {
                PersonalizePageView.this.v = true;
                PersonalizePageView.this.w = System.currentTimeMillis();
            }
        }

        public final void e() {
            if (this.f17210a) {
                this.f17210a = false;
                d.b.h0.r.d0.b.i().s("key_first_install", false);
            }
        }

        @Override // d.b.i0.z0.g.e.i0
        public void onError(int i, String str) {
            PersonalizePageView.this.S();
            if (i == 1) {
                if (d.b.b.e.p.j.z()) {
                    PersonalizePageView.this.l.showToast(str);
                }
                e();
            } else if (!this.f17210a) {
                PersonalizePageView.this.f17206e.setVisibility(8);
                PersonalizePageView personalizePageView = PersonalizePageView.this;
                personalizePageView.n0(personalizePageView, str, true);
            } else {
                e();
                PersonalizePageView.this.o0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface a0 {
        void a(f.e eVar);

        void b(f.g gVar);

        void c(f.h hVar);

        void g(f.InterfaceC1074f interfaceC1074f);
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            d.b.i0.m.d.c().f("page_recommend");
            PersonalizePageView.this.n.X0();
            PersonalizePageView.this.n.P0(false);
            PersonalizePageView.this.C = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.h {
        public c() {
        }

        @Override // d.b.h0.r.f0.f.h
        public void a(boolean z) {
            if (PersonalizePageView.this.n == null || PersonalizePageView.this.n.g0() == null) {
                return;
            }
            PersonalizePageView.this.n.g0().w();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.e {
        public d() {
        }

        @Override // d.b.h0.r.f0.f.e
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
    public class e implements f.InterfaceC1074f {
        public e() {
        }

        @Override // d.b.h0.r.f0.f.InterfaceC1074f
        public void a(View view, boolean z) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.n.P0(true);
                PersonalizePageView.this.n.G0();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
            d.b.h0.r.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.b.h0.r.d0.b.i().k("key_bigday_next_showtime_home", 0L)) {
                aVar = d.b.h0.r.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (PersonalizePageView.this.E == null || i != 0) {
                return;
            }
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
                PersonalizePageView.this.Y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            PersonalizePageView.this.B += i2;
            if (PersonalizePageView.this.G != null) {
                d.b.b.j.e.n B = PersonalizePageView.this.f17207f.B(PersonalizePageView.this.E.findLastVisibleItemPosition());
                if (B instanceof d.b.i0.x.e0.k) {
                    if (((d.b.i0.x.e0.k) B).position >= 6) {
                        PersonalizePageView.this.G.f();
                    } else {
                        PersonalizePageView.this.G.b();
                    }
                }
            }
            if (!d.b.h0.b.d.s() || TbadkCoreApplication.isLogin() || d.b.h0.r.d0.b.i().j("home_page_login_dialog_show_key", 0) != 0 || PersonalizePageView.this.B < d.b.b.e.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                return;
            }
            d.b.h0.r.d0.b.i().u("home_page_login_dialog_show_key", 1);
            DialogLoginHelper.checkUpIsLogin(new r0(PersonalizePageView.this.H, "new_shouye"));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements BdListView.p {
        public g() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            PersonalizePageView.this.Y();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements BdListView.o {
        public h() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            if (System.currentTimeMillis() - PersonalizePageView.this.s < 5000) {
                return;
            }
            PersonalizePageView.this.n.F0(i, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements RecyclerView.RecyclerListener {
        public i() {
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
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.n.X0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PersonalizePageView.this.F == null) {
                    PersonalizePageView.this.F = new d.b.b.j.e.l(new d.b.b.j.e.j());
                }
                PersonalizePageView.this.F.q(PersonalizePageView.this.f17207f, 2);
            } else if (PersonalizePageView.this.F != null) {
                PersonalizePageView.this.F.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PersonalizePageView.this.l != null) {
                d.b.h0.r.d0.b.i().u("show_is_uninterest_tag", PersonalizePageView.x(PersonalizePageView.this));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.l.getContext(), 2)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalizePageView.this.f0();
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PersonalizePageView.this.a0();
            }
        }

        public n(int i) {
            super(i);
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
                d.b.b.e.m.e.a().postDelayed(new a(), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalizePageView.this.Y();
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public p(int i) {
            super(i);
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
    public class q extends CustomMessageListener {
        public q(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.f17206e == null || PersonalizePageView.this.f17206e.t()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d.b.h0.r.n.a))) {
                if (PersonalizePageView.this.f17209h != null) {
                    if (PersonalizePageView.this.i == PersonalizePageView.this.f17209h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = PersonalizePageView.this;
                    personalizePageView.i = personalizePageView.f17209h;
                } else {
                    PersonalizePageView personalizePageView2 = PersonalizePageView.this;
                    personalizePageView2.f17209h = new d.b.i0.z0.g.i.a(personalizePageView2.l);
                    PersonalizePageView.this.f17209h.I(PersonalizePageView.this.t);
                    PersonalizePageView personalizePageView3 = PersonalizePageView.this;
                    personalizePageView3.i = personalizePageView3.f17209h;
                    PersonalizePageView.this.W();
                }
                PersonalizePageView.this.f17209h.B(true);
                PersonalizePageView.this.f17206e.setProgressView(PersonalizePageView.this.f17209h);
                int i = (int) (PersonalizePageView.this.getResources().getDisplayMetrics().density * 86.0f);
                PersonalizePageView.this.f17206e.setCustomDistances(i, i, i * 2);
                return;
            }
            d.b.h0.r.n.a aVar = (d.b.h0.r.n.a) customResponsedMessage.getData();
            if (PersonalizePageView.this.f17208g != null) {
                if (PersonalizePageView.this.i == PersonalizePageView.this.f17208g && aVar.equals(PersonalizePageView.this.f17208g.G())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = PersonalizePageView.this;
                personalizePageView4.i = personalizePageView4.f17208g;
            } else {
                PersonalizePageView personalizePageView5 = PersonalizePageView.this;
                personalizePageView5.f17208g = new d.b.i0.z0.g.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = PersonalizePageView.this;
                personalizePageView6.i = personalizePageView6.f17208g;
                PersonalizePageView.this.W();
            }
            PersonalizePageView.this.f17208g.B(true);
            PersonalizePageView.this.f17206e.setProgressView(PersonalizePageView.this.f17208g);
            PersonalizePageView.this.f17208g.J(aVar);
            double i2 = d.b.b.e.p.l.i(PersonalizePageView.this.l.getContext());
            Double.isNaN(i2);
            PersonalizePageView.this.f17206e.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (i2 * 0.8d), d.b.b.e.p.l.i(PersonalizePageView.this.l.getContext()));
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.G != null) {
                PersonalizePageView.this.G.b();
                PersonalizePageView.this.i0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements b0.f {
        public s() {
        }

        @Override // d.b.i0.z0.g.h.b0.f
        public void a() {
            if (PersonalizePageView.this.f17207f == null || PersonalizePageView.this.y == null) {
                return;
            }
            if (TbSingleton.getInstance().isAddBanner) {
                PersonalizePageView.this.f17207f.removeHeaderView(PersonalizePageView.this.y.b());
            } else if (PersonalizePageView.this.y.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
            } else {
                PersonalizePageView.this.y.d();
                PersonalizePageView.this.y.b().setVisibility(0);
                PersonalizePageView.this.y.f("1");
                PersonalizePageView.this.f17207f.setHeaderView(PersonalizePageView.this.y.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public t(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.n != null) {
                PersonalizePageView.this.p0(d.b.h0.r.v.a.b().c(), false, false);
            }
            PersonalizePageView.this.S();
        }
    }

    /* loaded from: classes4.dex */
    public class u implements NEGFeedBackView.b {
        public u() {
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
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = v0Var.m;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49) {
                i = 3;
            }
            if (PersonalizePageView.this.k != null) {
                PersonalizePageView.this.k.m();
            }
            TiebaStatic.log(new StatisticItem("c11693").param("tid", v0Var.e()).param("nid", v0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
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
    public class v implements FollowUserButton.a {
        public v() {
        }

        @Override // com.baidu.tieba.view.FollowUserButton.a
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof a2) {
                TiebaStatic.log(d.b.i0.b3.a.m("c13696", (a2) tag));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w extends RecyclerView.OnScrollListener {
        public w() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (PersonalizePageView.this.O == i || PersonalizePageView.this.N == null) {
                return;
            }
            PersonalizePageView.this.O = i;
            if (PersonalizePageView.this.O == 1) {
                PersonalizePageView.this.N.Q();
            } else if (PersonalizePageView.this.h0(recyclerView)) {
                PersonalizePageView.this.N.u();
            } else {
                PersonalizePageView.this.N.Q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends ScrollFragmentTabHost.q {
        public x() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.q
        public void b() {
            if (PersonalizePageView.this.N != null) {
                PersonalizePageView.this.O = -1;
                PersonalizePageView personalizePageView = PersonalizePageView.this;
                if (personalizePageView.h0(personalizePageView.f17207f)) {
                    PersonalizePageView.this.N.u();
                } else {
                    PersonalizePageView.this.N.Q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalizePageView.this.f17207f != null) {
                PersonalizePageView.this.f17207f.removeHeaderView(PersonalizePageView.this.y.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public z(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizePageView.this.f17207f == null || PersonalizePageView.this.y == null || PersonalizePageView.this.y.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner) {
                return;
            }
            PersonalizePageView.this.y.d();
            PersonalizePageView.this.y.b().setVisibility(0);
            PersonalizePageView.this.y.f("1");
            PersonalizePageView.this.f17207f.setHeaderView(PersonalizePageView.this.y.b());
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
        this.I = new k(2156674);
        this.J = new s();
        this.K = new t(2921456);
        this.L = new u();
        this.M = new v();
        this.O = -1;
        this.P = new w();
        this.Q = new x();
        this.R = new y();
        this.S = new z(2001371);
        this.T = new a();
        this.U = new b();
        this.V = new c();
        this.W = new d();
        this.a0 = new e();
        this.b0 = new l();
        this.c0 = new n(2001118);
        this.d0 = new o();
        this.e0 = new p(2921033);
        this.f0 = new q(2921349);
        this.g0 = new r();
        U(context);
    }

    public static /* synthetic */ int x(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.A + 1;
        personalizePageView.A = i2;
        return i2;
    }

    public void P() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17206e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void Q(Long l2) {
        this.n.Y(l2);
    }

    public void R() {
        if (this.r != null) {
            i0();
            return;
        }
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.X0();
        }
    }

    public final void S() {
        d.b.h0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.dettachView(this);
            this.q = null;
            this.f17207f.setNextPage(this.j);
            this.j.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17206e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.setVisibility(0);
        }
        d.b.i0.z0.c.b bVar = this.m;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void T() {
        d.b.h0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.dettachView(this);
            this.r = null;
        }
    }

    public final void U(Context context) {
        this.H = context;
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f17207f = bdTypeRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
        this.E = linearLayoutManager;
        this.f17207f.setLayoutManager(linearLayoutManager);
        this.f17207f.setFadingEdgeLength(0);
        this.f17207f.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f17207f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        d.b.i0.x.p pVar = new d.b.i0.x.p(context);
        this.y = pVar;
        pVar.setFrom("from_personaize");
        this.y.a().setVisibility(0);
        this.y.a().setOnClickListener(this.R);
        MessageManager.getInstance().registerListener(this.S);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            d.b.b.j.e.l lVar = new d.b.b.j.e.l(new d.b.b.j.e.j());
            this.F = lVar;
            lVar.q(this.f17207f, 2);
        }
        MessageManager.getInstance().registerListener(this.I);
        MessageManager.getInstance().registerListener(this.K);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.f17206e = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.f17207f);
        PbListView pbListView = new PbListView(context);
        this.j = pbListView;
        pbListView.b();
        this.j.o(R.color.transparent);
        this.j.v();
        this.j.C(SkinManager.getColor(R.color.CAM_X0107));
        this.j.E(R.dimen.tbfontsize33);
        this.j.y(R.color.CAM_X0110);
        this.j.r(d.b.b.e.p.l.g(context, R.dimen.tbds182));
        this.j.z(this.d0);
        this.j.q();
        this.f17207f.setNextPage(this.j);
        d.b.b.a.f<?> a2 = d.b.b.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.l = (TbPageContext) a2;
        }
        MessageManager.getInstance().registerListener(this.f0);
        d.b.h0.r.n.b.i().n(true);
        d.b.h0.r.n.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.b.h0.r.d0.b.i().k("key_bigday_next_showtime_home", 0L)) {
            aVar = d.b.h0.r.n.b.i().h(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.f17206e);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.G = new FRSRefreshButton(context);
            int g2 = d.b.b.e.p.l.g(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = d.b.b.e.p.l.g(context, R.dimen.tbds24);
            layoutParams.bottomMargin = d.b.b.e.p.l.g(context, R.dimen.tbds180);
            addView(this.G, layoutParams);
            this.G.setOnClickListener(this.g0);
            this.G.setVisibility(8);
        }
        this.p = new d.b.i0.z0.g.k.e();
        b0 b0Var = new b0(context, this.f17207f);
        this.k = b0Var;
        b0Var.x(this.p);
        this.k.v(this.J);
        this.n = new d.b.i0.z0.g.e(this.l, this.f17207f, this.k, this.f17206e);
        this.o = new d.b.i0.z0.g.a(this.l);
        b0(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.e0);
        this.A = d.b.h0.r.d0.b.i().j("show_is_uninterest_tag", 0);
    }

    public void V() {
        this.k.u(this.L);
        this.k.s(this.M);
        this.n.O0(this.T);
        this.o.i(this);
        W();
        this.f17207f.addOnScrollListener(new f());
        this.f17207f.setOnSrollToBottomListener(new g());
        this.f17207f.setOnScrollStopDelayedListener(new h(), 1L);
        this.f17207f.setRecyclerListener(new i());
        this.f17207f.removeOnScrollListener(this.P);
        this.f17207f.addOnScrollListener(this.P);
    }

    public void W() {
        a0 a0Var = this.i;
        if (a0Var != null) {
            a0Var.b(this.U);
            this.i.c(this.V);
            this.i.a(this.W);
            this.i.g(this.a0);
        }
    }

    public final boolean X() {
        d.b.h0.d0.h hVar = this.r;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public final void Y() {
        d.b.i0.z0.c.a.d().j(System.currentTimeMillis(), 1);
        PbListView pbListView = this.j;
        if (pbListView != null && !pbListView.l()) {
            this.j.O();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.r0();
    }

    public void Z() {
        this.n.o0();
    }

    public void a0() {
        b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.m();
        }
    }

    public void b0(int i2) {
        if (this.t != i2) {
            d.b.h0.d0.g gVar = this.q;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            d.b.h0.d0.h hVar = this.r;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            d.b.i0.z0.g.i.a aVar = this.f17209h;
            if (aVar != null) {
                aVar.I(i2);
            }
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.j.d(i2);
            }
            this.k.n(i2);
            d.b.i0.z0.g.e eVar = this.n;
            if (eVar != null) {
                eVar.w0(i2);
            }
            FRSRefreshButton fRSRefreshButton = this.G;
            if (fRSRefreshButton != null) {
                fRSRefreshButton.d(i2);
            }
            d.b.i0.x.p pVar = this.y;
            if (pVar != null) {
                pVar.e(i2);
            }
        }
        this.t = i2;
    }

    public void c0() {
        MessageManager.getInstance().unRegisterListener(this.I);
        MessageManager.getInstance().unRegisterListener(this.e0);
        MessageManager.getInstance().unRegisterListener(this.f0);
        this.n.x0();
        this.k.u(null);
        this.k.o();
        this.n.O0(null);
        d.b.i0.z0.g.i.b bVar = this.f17208g;
        if (bVar != null) {
            bVar.b(null);
            this.f17208g.c(null);
            this.f17208g.a(null);
            this.f17208g.g(null);
            this.f17208g.H();
        }
        d.b.i0.z0.g.i.a aVar = this.f17209h;
        if (aVar != null) {
            aVar.b(null);
            this.f17209h.c(null);
            this.f17209h.a(null);
            this.f17209h.g(null);
            this.f17209h.X();
        }
        this.f17207f.setOnSrollToBottomListener(null);
        ScrollFragmentTabHost scrollFragmentTabHost = this.N;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.Q);
        }
        this.f17207f.removeOnScrollListener(this.P);
        d.b.h0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.m();
        }
        this.f17207f.setRecyclerListener(null);
        d.b.i0.z0.g.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.g();
        }
        d.b.h0.r.n.b.i().e();
        d.b.b.e.m.e.a().removeCallbacks(this.b0);
    }

    public void d0() {
        this.n.A0();
        b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.v) {
            post(new m());
        }
    }

    public void e0() {
        if (this.u) {
            i0();
            this.u = false;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17206e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.D();
        }
        b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.q();
        }
    }

    public final void f0() {
        if (!this.x) {
            long f2 = d.b.i0.z0.c.a.d().f(1) + d.b.i0.z0.c.a.d().b();
            long a2 = d.b.i0.z0.c.a.d().a(1);
            if (a2 > 0) {
                f2 = System.currentTimeMillis() - a2;
            }
            d.b.h0.m0.n nVar = new d.b.h0.m0.n();
            nVar.a();
            nVar.b();
            d.b.h0.m0.l.b().o(f2);
            if (this.w > 0) {
                d.b.h0.m0.l.b().I(System.currentTimeMillis() - this.w);
            }
            d.b.h0.m0.l.b().M(nVar.c());
        }
        this.x = true;
    }

    public void g0() {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.u0(true);
        }
        d.b.i0.x.t.b().d(false);
        d.b.i0.m.d.c().h("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        d.b.b.e.m.e.a().removeCallbacks(this.b0);
    }

    public boolean getIsUnreadTipShow() {
        return this.z;
    }

    public boolean h0(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void i0() {
        d.b.i0.z0.g.e eVar;
        if (this.r != null && (eVar = this.n) != null) {
            eVar.X0();
        } else if (this.f17207f == null || this.f17206e == null) {
        } else {
            l0();
            this.f17207f.setSelection(0);
            if (!this.f17206e.t()) {
                d.b.i0.z0.g.e eVar2 = this.n;
                if (eVar2 != null && eVar2.g0() != null) {
                    this.n.g0().w();
                    this.n.P0(false);
                }
                this.f17206e.setRefreshing(true);
            }
            ScrollFragmentTabHost.q qVar = this.Q;
            if (qVar != null) {
                qVar.b();
            }
        }
    }

    public void j0() {
        this.n.L0();
    }

    public void k0() {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.T0();
        }
    }

    public void l0() {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.U0();
        }
    }

    public final void m0(boolean z2) {
        if (this.q == null) {
            this.q = new d.b.h0.d0.g(getContext());
            this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + d.b.b.e.p.l.g(getContext(), R.dimen.tbds60));
            this.q.h();
            this.q.setWrapStyle(true);
            this.q.onChangeSkinType();
        }
        this.q.attachView(this, z2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        this.f17207f.setNextPage(null);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f17206e;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
    }

    public final void n0(View view, String str, boolean z2) {
        if (this.r == null) {
            this.r = new d.b.h0.d0.h(getContext(), new j());
        }
        this.r.attachView(view, z2);
        this.r.o();
    }

    public void o0() {
        if (this.n != null) {
            m0(true);
            this.n.X0();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            d.b.h0.r.n.b.i().j();
            d.b.h0.r.n.b.i().k();
        }
    }

    public void p0(DataRes dataRes, boolean z2, boolean z3) {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.y0(z2, z3, dataRes, 0, null);
    }

    public void q0(String str, int i2) {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
            this.j.f();
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.n.y0(true, false, null, i2, str);
    }

    public void setCallback(d.b.i0.z0.c.b bVar) {
        this.m = bVar;
    }

    public void setIsUnreadTipShow(boolean z2) {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.M0(!z2);
        }
        this.z = z2;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        b0 b0Var = this.k;
        if (b0Var != null) {
            b0Var.w(bdUniqueId);
        }
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.H0(bdUniqueId);
        }
        d.b.i0.z0.g.k.e eVar2 = this.p;
        if (eVar2 != null) {
            eVar2.a(bdUniqueId);
        }
        d.b.i0.z0.g.i.a aVar = this.f17209h;
        if (aVar != null) {
            aVar.Z(bdUniqueId);
        }
        d.b.h0.r.n.b.i().o(bdUniqueId);
        CustomMessageListener customMessageListener = this.c0;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.c0);
        }
        d.b.i0.z0.g.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.h(bdUniqueId);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(d.b.h0.z0.b0 b0Var) {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.Q0(b0Var);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.N = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.Q);
            this.N.s(this.Q);
        }
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.R0(scrollFragmentTabHost);
        }
        d.b.i0.z0.g.a aVar = this.o;
        if (aVar != null) {
            aVar.j(scrollFragmentTabHost);
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.S0(z2);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.u0(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.A >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
            return;
        }
        d.b.b.e.m.e.a().postDelayed(this.b0, 1000L);
    }

    public void setViewForeground(boolean z2) {
        d.b.i0.z0.g.e eVar = this.n;
        if (eVar != null) {
            eVar.B0(z2);
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.N;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.Q);
            this.N.s(this.Q);
            this.Q.b();
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
        this.I = new k(2156674);
        this.J = new s();
        this.K = new t(2921456);
        this.L = new u();
        this.M = new v();
        this.O = -1;
        this.P = new w();
        this.Q = new x();
        this.R = new y();
        this.S = new z(2001371);
        this.T = new a();
        this.U = new b();
        this.V = new c();
        this.W = new d();
        this.a0 = new e();
        this.b0 = new l();
        this.c0 = new n(2001118);
        this.d0 = new o();
        this.e0 = new p(2921033);
        this.f0 = new q(2921349);
        this.g0 = new r();
        U(context);
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
        this.I = new k(2156674);
        this.J = new s();
        this.K = new t(2921456);
        this.L = new u();
        this.M = new v();
        this.O = -1;
        this.P = new w();
        this.Q = new x();
        this.R = new y();
        this.S = new z(2001371);
        this.T = new a();
        this.U = new b();
        this.V = new c();
        this.W = new d();
        this.a0 = new e();
        this.b0 = new l();
        this.c0 = new n(2001118);
        this.d0 = new o();
        this.e0 = new p(2921033);
        this.f0 = new q(2921349);
        this.g0 = new r();
        U(context);
    }
}
