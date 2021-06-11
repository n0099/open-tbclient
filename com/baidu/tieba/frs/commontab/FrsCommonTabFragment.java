package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.k2.i;
import d.a.n0.r0.n2.k;
import d.a.n0.r0.q0;
import d.a.n0.r0.s0;
import d.a.n0.t2.u;
import d.a.n0.z.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, q0, s0, u {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.l1.b f15329e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r0.l1.c f15330f;

    /* renamed from: g  reason: collision with root package name */
    public View f15331g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f15332h;

    /* renamed from: i  reason: collision with root package name */
    public String f15333i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public VoiceManager s;
    public d.a.m0.d0.c u;
    public ThreadCardViewHolder v;
    public boolean z;
    public int r = 3;
    public boolean t = true;
    public int w = 0;
    public int x = 0;
    public int y = 0;
    public CustomMessageListener A = new a(2921397, true);
    public CustomMessageListener B = new b(2001624);
    public final CustomMessageListener C = new c(2921031);
    public CustomMessageListener D = new d(2921381);
    public CustomMessageListener E = new e(2016331);
    public final RecyclerView.OnScrollListener F = new f();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsCommonTabFragment.this.u == null || !FrsCommonTabFragment.this.u.isViewAttached()) {
                return;
            }
            FrsCommonTabFragment.this.N0(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
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
                int parseInt = Integer.parseInt(data.toString());
                FrsCommonTabFragment frsCommonTabFragment = FrsCommonTabFragment.this;
                if (parseInt == frsCommonTabFragment.k) {
                    d.a.n0.r0.l1.b bVar = frsCommonTabFragment.f15329e;
                    if (bVar != null) {
                        bVar.y(0);
                    }
                    if (FrsCommonTabFragment.this.u != null && FrsCommonTabFragment.this.u.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    d.a.n0.r0.l1.b bVar2 = FrsCommonTabFragment.this.f15329e;
                    if (bVar2 != null) {
                        bVar2.w(true);
                    }
                    FrsCommonTabFragment.this.n();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.r0.l1.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || (bVar = FrsCommonTabFragment.this.f15329e) == null) {
                return;
            }
            bVar.m(str);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.r0.l1.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bVar = FrsCommonTabFragment.this.f15329e) != null) {
                i i2 = bVar.i();
                if (i2 != null && i2.j() != null && (i2.j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsCommonTabFragment.this.v = (ThreadCardViewHolder) i2.j().getTag();
                }
                if (FrsCommonTabFragment.this.v == null || FrsCommonTabFragment.this.v.b() == null) {
                    return;
                }
                FrsCommonTabFragment.this.v.b().o(new a.C0600a(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || FrsCommonTabFragment.this.f15330f == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FrsCommonTabFragment.this.f15330f.l(str);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                d.a.n0.d3.c.g().h(FrsCommonTabFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FrsCommonTabFragment.this.x += i3;
            if (FrsCommonTabFragment.this.x < FrsCommonTabFragment.this.w * 2 || i3 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f15340e;

        public g(d.a.m0.r.s.a aVar) {
            this.f15340e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.r.s.a aVar = this.f15340e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f15342e;

        public h(d.a.m0.r.s.a aVar) {
            this.f15342e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.r.s.a aVar = this.f15342e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    @Override // d.a.n0.r0.q0
    public void E0() {
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.t();
        }
    }

    @Override // d.a.n0.t2.u
    public String G() {
        return this.f15333i;
    }

    public void M0(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f15330f.a(a2Var);
    }

    public void N0(int i2) {
        d.a.m0.d0.c cVar = this.u;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.u.a(i2);
    }

    public final void O0() {
        d.a.n0.r0.l1.b bVar;
        if (ListUtils.isEmpty(d.a.n0.r0.a.h().i()) || (bVar = this.f15329e) == null || bVar.j() == null || this.f15329e.j().getData() == null) {
            return;
        }
        ArrayList<n> arrayList = this.f15330f.e().f62574g;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        List<n> data = this.f15329e.j().getData();
        int count = ListUtils.getCount(d.a.n0.r0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            a2 a2Var = null;
            if (next instanceof z1) {
                a2Var = ((z1) next).w;
            } else if (next instanceof a2) {
                a2Var = (a2) next;
            }
            if (a2Var != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(d.a.n0.r0.a.h().i().get(i3).o0(), a2Var.o0())) {
                        it.remove();
                        data.remove(next);
                        this.f15329e.j().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // d.a.n0.t2.u
    public void P() {
    }

    public final void P0(int i2, int i3) {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.f15333i);
        if (i2 == 89) {
            statisticItem.param("obj_type", 1);
        } else if (i2 == 502) {
            statisticItem.param("obj_type", 8);
        } else if (i2 == 504) {
            statisticItem.param("obj_type", 11);
        } else if (this.l == 3) {
            statisticItem.param("obj_type", 13);
        } else if (this.n == 1) {
            statisticItem.param("obj_type", 12);
        }
        statisticItem.param("obj_locate", i3);
        statisticItem.eventStat();
    }

    public String Q0() {
        return this.k == 89 ? "a006" : "a006";
    }

    public int R0() {
        return R.layout.frs_common_tab_fragment;
    }

    public d.a.n0.r0.l1.b S0() {
        return this.f15329e;
    }

    public d.a.n0.r0.l1.c T0() {
        return this.f15330f;
    }

    public int U0() {
        return this.y;
    }

    public final boolean V0() {
        String string = getPageContext().getResources().getString(R.string.is_district_forum);
        FrsViewData frsViewData = this.f15332h;
        return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f15332h.getForum().getFirst_class()) || !this.f15332h.getForum().getFirst_class().equals(string)) ? false : true;
    }

    public void W0() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.D()) {
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.a.n0.r0.l1.c cVar = this.f15330f;
            if (cVar != null) {
                cVar.j(this.y);
            }
        }
    }

    public void X0(d.a.n0.r0.l1.d dVar) {
        if (dVar == null) {
            return;
        }
        hideLoadingView(this.f15331g);
        this.y = dVar.m;
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.w(false);
            this.f15329e.r();
            this.f15329e.o(dVar);
        }
        if (this.f15330f.i() && this.k == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        d.a.n0.d3.c.g().h(getUniqueId(), false);
    }

    public void Y0() {
        int i2;
        O0();
        int i3 = 0;
        int i4 = -1;
        for (n nVar : this.f15330f.e().f62574g) {
            if ((nVar instanceof z1) && (i2 = ((z1) nVar).position) != i4) {
                i3++;
                i4 = i2;
                continue;
            }
            if (i3 >= 6) {
                break;
            }
        }
        if (i3 < 6) {
            W0();
        }
    }

    public final void Z0() {
        if (l.D()) {
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.a.n0.r0.l1.c cVar = this.f15330f;
            if (cVar != null) {
                cVar.n(this.y);
            }
        }
    }

    public void a1() {
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.q();
        }
    }

    public void b1(int i2) {
        this.y = i2;
    }

    public final void c1() {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
        aVar.setContentViewSize(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new g(aVar));
        professionDialogLayout.setCloseViewClickListener(new h(aVar));
        aVar.setContentView(professionDialogLayout);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(getPageContext()).show();
    }

    public final void d1() {
        if (this.k == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.f15333i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.m0.i0.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new d.a.m0.i0.c(getUniqueId(), Q0(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = k.g(U0());
        tbPageTag.locatePage = "a006";
        tbPageTag.tabId = this.k;
        tbPageTag.tabType = this.l;
        tbPageTag.isGeneralTab = this.n;
        return tbPageTag;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.s == null) {
            this.s = VoiceManager.instance();
        }
        return this.s;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.u(true);
        }
        d.a.m0.d0.c cVar = this.u;
        if (cVar != null) {
            cVar.dettachView(view);
        }
    }

    @Override // d.a.n0.r0.s0
    public void l() {
    }

    @Override // d.a.n0.r0.s0
    public void n() {
        if (getContext() == null) {
            return;
        }
        if (j.z()) {
            hideNetRefreshView(this.f15331g);
            if (this.f15330f.g()) {
                hideLoadingView(this.f15331g);
            } else {
                showLoadingView(this.f15331g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            Z0();
            return;
        }
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.w(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.n0.r0.l1.b bVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 18003) {
            String stringExtra = intent.getStringExtra("tid");
            int intExtra = intent.getIntExtra("type", -1);
            if (StringUtils.isNull(stringExtra) || intExtra != 0 || (bVar = this.f15329e) == null) {
                return;
            }
            bVar.m(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        if (this.r == 3 && this.f15329e == null) {
            return;
        }
        this.r = i2;
        super.onChangeSkinType(i2);
        this.f15329e.l(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.k = bundle.getInt("tab_id");
            this.l = bundle.getInt("tab_type");
            bundle.getString("from");
            this.f15333i = bundle.getString("forum_id");
            this.j = bundle.getString("name");
            this.q = bundle.getBoolean("can_auto_play_video");
            this.o = bundle.getBoolean("need_log");
            this.p = bundle.getBoolean("is_brand_forum");
            this.m = bundle.getString("tab_name");
            this.n = bundle.getInt("is_general_tab");
            this.f15332h = (FrsViewData) bundle.getSerializable("view_data");
            this.z = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            if (this.n != 1) {
                this.y = bundle.getInt("sort_type", 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.k = arguments.getInt("tab_id");
                this.l = arguments.getInt("tab_type");
                arguments.getString("from");
                this.f15333i = arguments.getString("forum_id");
                this.j = arguments.getString("name");
                this.q = arguments.getBoolean("can_auto_play_video");
                this.o = arguments.getBoolean("need_log");
                this.p = arguments.getBoolean("is_brand_forum");
                this.m = arguments.getString("tab_name");
                this.n = arguments.getInt("is_general_tab");
                this.f15332h = (FrsViewData) arguments.getSerializable("view_data");
                this.z = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        VoiceManager voiceManager = getVoiceManager();
        this.s = voiceManager;
        voiceManager.onCreate(getPageContext());
        d.a.n0.d3.c.g().i(getUniqueId());
        d.a.n0.r0.l1.c cVar = new d.a.n0.r0.l1.c(this, d.a.c.e.m.b.d(this.f15333i, 0), this.k, this.m, this.n);
        this.f15330f = cVar;
        cVar.r(this.l);
        this.f15330f.o(d.a.n0.t0.a.a(this.z));
        registerListener(this.B);
        registerListener(this.C);
        registerListener(this.D);
        registerListener(this.E);
        registerListener(this.A);
        this.w = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R0(), (ViewGroup) null);
        this.f15331g = inflate;
        d.a.n0.r0.l1.b bVar = new d.a.n0.r0.l1.b(this, inflate, this.f15332h);
        this.f15329e = bVar;
        bVar.x(this.F);
        return this.f15331g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.n0.d3.c.g().k(getUniqueId());
        t.b().e(false);
        MessageManager.getInstance().unRegisterListener(this.A);
        MessageManager.getInstance().unRegisterListener(this.E);
        super.onDestroy();
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.n();
        }
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.f15331g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            Z0();
            return;
        }
        showNetRefreshView(this.f15331g, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        P0(this.k, 2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.f15331g);
            showLoadingView(this.f15331g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            Z0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.p();
        }
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            d.a.n0.r0.l1.b bVar = this.f15329e;
            if (bVar != null) {
                bVar.s();
            }
            if (this.t) {
                this.t = false;
                if (this.k == 502) {
                    boolean z = true;
                    if ((!d.a.m0.r.d0.b.j().g("first_into_tab_profession", true) || V0()) ? false : false) {
                        d.a.m0.r.d0.b.j().t("first_into_tab_profession", false);
                        c1();
                    }
                    new d.a.n0.r0.f2.a.c(getPageContext()).f(this.f15333i);
                    onLazyLoad();
                }
                int i2 = this.k;
                if (i2 != 503 && i2 != 504) {
                    if (!this.isLazyLoaded) {
                        onLazyLoad();
                    }
                } else {
                    onLazyLoad();
                }
            }
            d1();
            return;
        }
        d.a.n0.r0.l1.b bVar2 = this.f15329e;
        if (bVar2 != null) {
            bVar2.p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.k);
        bundle.putString("forum_id", this.f15333i);
        bundle.putString("name", this.j);
        bundle.putBoolean("can_auto_play_video", this.q);
        bundle.putBoolean("need_log", this.o);
        bundle.putBoolean("is_brand_forum", this.p);
        bundle.putString("tab_name", this.m);
        bundle.putInt("is_general_tab", this.n);
        bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.z);
        if (this.n != 1) {
            bundle.putInt("sort_type", this.y);
        }
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f15331g);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.f15330f.g()) {
            showNetRefreshView(this.f15331g, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.w(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.a.n0.d3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.a.n0.t2.u
    public TbPageContext<?> p() {
        return getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.u(false);
        }
        if (getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.u == null) {
            this.u = new d.a.m0.d0.c(getPageContext().getContext(), getNetRefreshListener());
        }
        this.u.e(null);
        this.u.d(str);
        this.u.c(null);
        this.u.attachView(view, z);
        this.u.f();
        this.u.a(0);
    }

    @Override // d.a.n0.r0.q0
    public void u() {
        E0();
        d.a.n0.r0.l1.b bVar = this.f15329e;
        if (bVar != null) {
            bVar.w(true);
        }
    }

    @Override // d.a.n0.t2.u
    public int w0() {
        return this.f15330f.d();
    }
}
