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
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.j2.i;
import d.b.j0.q0.n2.k;
import d.b.j0.q0.q0;
import d.b.j0.q0.s0;
import d.b.j0.s2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, q0, s0, t {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.q0.l1.b f15863e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q0.l1.c f15864f;

    /* renamed from: g  reason: collision with root package name */
    public View f15865g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f15866h;
    public String i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public VoiceManager s;
    public d.b.i0.d0.c u;
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
        public a(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsCommonTabFragment.this.u == null || !FrsCommonTabFragment.this.u.isViewAttached()) {
                return;
            }
            FrsCommonTabFragment.this.L0(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
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
                    d.b.j0.q0.l1.b bVar = frsCommonTabFragment.f15863e;
                    if (bVar != null) {
                        bVar.y(0);
                    }
                    if (FrsCommonTabFragment.this.u != null && FrsCommonTabFragment.this.u.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    d.b.j0.q0.l1.b bVar2 = FrsCommonTabFragment.this.f15863e;
                    if (bVar2 != null) {
                        bVar2.w(true);
                    }
                    FrsCommonTabFragment.this.m();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.j0.q0.l1.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || (bVar = FrsCommonTabFragment.this.f15863e) == null) {
                return;
            }
            bVar.m(str);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.j0.q0.l1.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bVar = FrsCommonTabFragment.this.f15863e) != null) {
                i i = bVar.i();
                if (i != null && i.j() != null && (i.j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsCommonTabFragment.this.v = (ThreadCardViewHolder) i.j().getTag();
                }
                if (FrsCommonTabFragment.this.v == null || FrsCommonTabFragment.this.v.b() == null) {
                    return;
                }
                FrsCommonTabFragment.this.v.b().o(new a.C1072a(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || FrsCommonTabFragment.this.f15864f == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FrsCommonTabFragment.this.f15864f.l(str);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                d.b.j0.c3.c.g().h(FrsCommonTabFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.x += i2;
            if (FrsCommonTabFragment.this.x < FrsCommonTabFragment.this.w * 2 || i2 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f15873e;

        public g(d.b.i0.r.s.a aVar) {
            this.f15873e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.r.s.a aVar = this.f15873e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f15875e;

        public h(d.b.i0.r.s.a aVar) {
            this.f15875e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.r.s.a aVar = this.f15875e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    @Override // d.b.j0.q0.q0
    public void B0() {
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.t();
        }
    }

    @Override // d.b.j0.q0.q0
    public void E() {
        B0();
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.w(true);
        }
    }

    public void K0(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f15864f.a(a2Var);
    }

    public void L0(int i) {
        d.b.i0.d0.c cVar = this.u;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.u.a(i);
    }

    public final void M0() {
        d.b.j0.q0.l1.b bVar;
        if (ListUtils.isEmpty(d.b.j0.q0.a.h().i()) || (bVar = this.f15863e) == null || bVar.j() == null || this.f15863e.j().getData() == null) {
            return;
        }
        ArrayList<n> arrayList = this.f15864f.e().f59925g;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        List<n> data = this.f15863e.j().getData();
        int count = ListUtils.getCount(d.b.j0.q0.a.h().i());
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            a2 a2Var = null;
            if (next instanceof z1) {
                a2Var = ((z1) next).w;
            } else if (next instanceof a2) {
                a2Var = (a2) next;
            }
            if (a2Var != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= count) {
                        break;
                    } else if (StringHelper.equals(d.b.j0.q0.a.h().i().get(i2).o0(), a2Var.o0())) {
                        it.remove();
                        data.remove(next);
                        this.f15863e.j().getAdapter().notifyItemRemoved(i);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i++;
        }
    }

    public final void N0(int i, int i2) {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.i);
        if (i == 89) {
            statisticItem.param("obj_type", 1);
        } else if (i == 502) {
            statisticItem.param("obj_type", 8);
        } else if (i == 504) {
            statisticItem.param("obj_type", 11);
        } else if (this.l == 3) {
            statisticItem.param("obj_type", 13);
        } else if (this.n == 1) {
            statisticItem.param("obj_type", 12);
        }
        statisticItem.param("obj_locate", i2);
        statisticItem.eventStat();
    }

    public String O0() {
        return this.k == 89 ? "a006" : "a006";
    }

    public int P0() {
        return R.layout.frs_common_tab_fragment;
    }

    public d.b.j0.q0.l1.b Q0() {
        return this.f15863e;
    }

    public d.b.j0.q0.l1.c R0() {
        return this.f15864f;
    }

    public int S0() {
        return this.y;
    }

    public final boolean T0() {
        String string = getPageContext().getResources().getString(R.string.is_district_forum);
        FrsViewData frsViewData = this.f15866h;
        return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f15866h.getForum().getFirst_class()) || !this.f15866h.getForum().getFirst_class().equals(string)) ? false : true;
    }

    public void U0() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.C()) {
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.b.j0.q0.l1.c cVar = this.f15864f;
            if (cVar != null) {
                cVar.k(this.y);
            }
        }
    }

    @Override // d.b.j0.s2.t
    public String V() {
        return this.i;
    }

    public void V0(d.b.j0.q0.l1.d dVar) {
        if (dVar == null) {
            return;
        }
        hideLoadingView(this.f15865g);
        this.y = dVar.m;
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.w(false);
            this.f15863e.r();
            this.f15863e.o(dVar);
        }
        if (this.f15864f.j() && this.k == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        d.b.j0.c3.c.g().h(getUniqueId(), false);
    }

    public void W0() {
        int i;
        M0();
        int i2 = 0;
        int i3 = -1;
        for (n nVar : this.f15864f.e().f59925g) {
            if ((nVar instanceof z1) && (i = ((z1) nVar).position) != i3) {
                i2++;
                i3 = i;
                continue;
            }
            if (i2 >= 6) {
                break;
            }
        }
        if (i2 < 6) {
            U0();
        }
    }

    public final void X0() {
        if (l.C()) {
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.b.j0.q0.l1.c cVar = this.f15864f;
            if (cVar != null) {
                cVar.o(this.y);
            }
        }
    }

    public void Y0() {
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.q();
        }
    }

    public void Z0(int i) {
        this.y = i;
    }

    public final void a1() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getActivity());
        aVar.setContentViewSize(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new g(aVar));
        professionDialogLayout.setCloseViewClickListener(new h(aVar));
        aVar.setContentView(professionDialogLayout);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(getPageContext()).show();
    }

    public final void b1() {
        if (this.k == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.b.i0.i0.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new d.b.i0.i0.c(getUniqueId(), O0(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = k.g(S0());
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
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.u(true);
        }
        d.b.i0.d0.c cVar = this.u;
        if (cVar != null) {
            cVar.dettachView(view);
        }
    }

    @Override // d.b.j0.s2.t
    public void j0(AdvertAppInfo advertAppInfo, String str) {
        d.b.i0.u.a.l().u(advertAppInfo, this.i, 0L, advertAppInfo.c4, str, this.f15864f.d());
    }

    @Override // d.b.j0.q0.s0
    public void m() {
        if (getContext() == null) {
            return;
        }
        if (j.z()) {
            hideNetRefreshView(this.f15865g);
            if (this.f15864f.h()) {
                hideLoadingView(this.f15865g);
            } else {
                showLoadingView(this.f15865g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            X0();
            return;
        }
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.w(false);
        }
    }

    @Override // d.b.j0.s2.t
    public int n0() {
        return this.f15864f.d();
    }

    @Override // d.b.j0.q0.s0
    public void o() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        d.b.j0.q0.l1.b bVar;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18003) {
            String stringExtra = intent.getStringExtra("tid");
            int intExtra = intent.getIntExtra("type", -1);
            if (StringUtils.isNull(stringExtra) || intExtra != 0 || (bVar = this.f15863e) == null) {
                return;
            }
            bVar.m(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.r == 3 && this.f15863e == null) {
            return;
        }
        this.r = i;
        super.onChangeSkinType(i);
        this.f15863e.l(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.k = bundle.getInt("tab_id");
            this.l = bundle.getInt("tab_type");
            bundle.getString("from");
            this.i = bundle.getString("forum_id");
            this.j = bundle.getString("name");
            this.q = bundle.getBoolean("can_auto_play_video");
            this.o = bundle.getBoolean("need_log");
            this.p = bundle.getBoolean("is_brand_forum");
            this.m = bundle.getString("tab_name");
            this.n = bundle.getInt("is_general_tab");
            this.f15866h = (FrsViewData) bundle.getSerializable("view_data");
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
                this.i = arguments.getString("forum_id");
                this.j = arguments.getString("name");
                this.q = arguments.getBoolean("can_auto_play_video");
                this.o = arguments.getBoolean("need_log");
                this.p = arguments.getBoolean("is_brand_forum");
                this.m = arguments.getString("tab_name");
                this.n = arguments.getInt("is_general_tab");
                this.f15866h = (FrsViewData) arguments.getSerializable("view_data");
                this.z = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        VoiceManager voiceManager = getVoiceManager();
        this.s = voiceManager;
        voiceManager.onCreate(getPageContext());
        d.b.j0.c3.c.g().i(getUniqueId());
        d.b.j0.q0.l1.c cVar = new d.b.j0.q0.l1.c(this, d.b.c.e.m.b.d(this.i, 0), this.k, this.m, this.n);
        this.f15864f = cVar;
        cVar.r(this.l);
        this.f15864f.p(d.b.j0.s0.a.a(this.z));
        registerListener(this.B);
        registerListener(this.C);
        registerListener(this.D);
        registerListener(this.E);
        registerListener(this.A);
        this.w = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(P0(), (ViewGroup) null);
        this.f15865g = inflate;
        d.b.j0.q0.l1.b bVar = new d.b.j0.q0.l1.b(this, inflate, this.f15866h);
        this.f15863e = bVar;
        bVar.x(this.F);
        return this.f15865g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.j0.c3.c.g().k(getUniqueId());
        d.b.j0.x.t.b().e(false);
        MessageManager.getInstance().unRegisterListener(this.A);
        MessageManager.getInstance().unRegisterListener(this.E);
        super.onDestroy();
        d.b.j0.q0.l1.b bVar = this.f15863e;
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
            showLoadingView(this.f15865g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            X0();
            return;
        }
        showNetRefreshView(this.f15865g, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        N0(this.k, 2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.f15865g);
            showLoadingView(this.f15865g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            X0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.b.j0.q0.l1.b bVar = this.f15863e;
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
            d.b.j0.q0.l1.b bVar = this.f15863e;
            if (bVar != null) {
                bVar.s();
            }
            if (this.t) {
                this.t = false;
                if (this.k == 502) {
                    boolean z = true;
                    if ((!d.b.i0.r.d0.b.j().g("first_into_tab_profession", true) || T0()) ? false : false) {
                        d.b.i0.r.d0.b.j().t("first_into_tab_profession", false);
                        a1();
                    }
                    new d.b.j0.q0.f2.a.c(getPageContext()).g(this.i);
                    onLazyLoad();
                }
                int i = this.k;
                if (i != 503 && i != 504) {
                    if (!this.isLazyLoaded) {
                        onLazyLoad();
                    }
                } else {
                    onLazyLoad();
                }
            }
            b1();
            return;
        }
        d.b.j0.q0.l1.b bVar2 = this.f15863e;
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
        bundle.putString("forum_id", this.i);
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
        hideLoadingView(this.f15865g);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.f15864f.h()) {
            showNetRefreshView(this.f15865g, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        d.b.j0.q0.l1.b bVar = this.f15863e;
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
        d.b.j0.c3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.s;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.b.j0.s2.t
    public TbPageContext<?> q() {
        return getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        d.b.j0.q0.l1.b bVar = this.f15863e;
        if (bVar != null) {
            bVar.u(false);
        }
        if (getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.u == null) {
            this.u = new d.b.i0.d0.c(getPageContext().getContext(), getNetRefreshListener());
        }
        this.u.e(null);
        this.u.d(str);
        this.u.c(null);
        this.u.attachView(view, z);
        this.u.f();
        this.u.a(0);
    }

    @Override // d.b.j0.s2.t
    public void u0() {
    }
}
