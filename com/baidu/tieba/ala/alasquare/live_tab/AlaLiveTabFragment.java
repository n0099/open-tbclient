package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.d0.h;
import d.b.i0.z0.b0;
import d.b.j0.q0.o0;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements o0 {
    public static int m = 1;
    public static int n = 1;
    public static int o = 1;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.t.d.c.h.a f14408e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f14409f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f14410g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14411h = true;
    public int i = -1;
    public CustomMessageListener k = new a(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
    public CustomMessageListener l = new b(2921446);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.t.d.c.e.b)) {
                return;
            }
            AlaLiveTabFragment.this.f14408e.r(true);
            d.b.j0.t.d.c.e.b bVar = (d.b.j0.t.d.c.e.b) customResponsedMessage.getData();
            if (bVar.f62307a) {
                if (AlaLiveTabFragment.this.f14411h || !bVar.f62308b) {
                    AlaLiveTabFragment.this.L0();
                    AlaLiveTabFragment alaLiveTabFragment = AlaLiveTabFragment.this;
                    alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f14408e.i());
                    AlaLiveTabFragment.this.f14408e.t(bVar.f62309c);
                    AlaLiveTabFragment.this.f14411h = false;
                }
            } else if (AlaLiveTabFragment.this.f14411h || !bVar.f62308b) {
                AlaLiveTabFragment alaLiveTabFragment2 = AlaLiveTabFragment.this;
                alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f14408e.i());
                AlaLiveTabFragment.this.P0();
            }
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (AlaLiveTabFragment.this.f14408e != null) {
                AlaLiveTabFragment.this.f14408e.s(intValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public c() {
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            if (AlaLiveTabFragment.this.isPrimary()) {
                AlaLiveTabFragment.this.f14409f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || AlaLiveTabFragment.this.f14408e == null) {
                return;
            }
            AlaLiveTabFragment.this.f14408e.r(false);
            AlaLiveTabFragment.this.O0();
            AlaLiveTabFragment.this.f14408e.m();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // d.b.j0.q0.o0
    public void A() {
    }

    @Override // d.b.j0.q0.o0
    public void F() {
    }

    @Override // d.b.j0.q0.o0
    public void K(b0 b0Var) {
    }

    public void L0() {
        this.f14408e.r(true);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f14408e.i());
            this.mRefreshView = null;
        }
    }

    public boolean M0() {
        return this.f14411h;
    }

    public void N0() {
        if (isAdded()) {
            O0();
            this.f14408e.m();
        }
    }

    public final void O0() {
        if (this.i < 0) {
            this.i = this.f14408e.i().getHeight();
        }
        showLoadingView(this.f14408e.i(), false, (((this.i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    public void P0() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new d());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.f14408e.r(false);
        this.mRefreshView.k(0);
        this.mRefreshView.attachView(this.f14408e.i(), false);
    }

    @Override // d.b.j0.q0.o0
    public void W() {
    }

    @Override // d.b.j0.q0.o0
    public void b0() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a083";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.t.d.c.h.a aVar = this.f14408e;
        if (aVar != null) {
            aVar.o();
        }
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.f14408e = new d.b.j0.t.d.c.h.a(getPageContext(), getChildFragmentManager(), this.j);
        if (this.f14409f == null) {
            this.f14409f = new AlaLiveUserNotifyController(getPageContext());
        }
        this.f14410g = new c();
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f14410g);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
        this.f14408e.j();
        if (this.i > 0) {
            O0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup i = this.f14408e.i();
        if (i.getParent() instanceof ViewGroup) {
            ((ViewGroup) i.getParent()).removeView(i);
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14411h = true;
        d.b.j0.t.d.c.h.a aVar = this.f14408e;
        if (aVar != null) {
            aVar.g();
        }
        AlaLiveUserNotifyController alaLiveUserNotifyController = this.f14409f;
        if (alaLiveUserNotifyController != null) {
            alaLiveUserNotifyController.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f14410g);
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.j = true;
        this.f14408e.m();
        O0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            d.b.j0.t.d.c.h.a aVar = this.f14408e;
            if (aVar != null) {
                aVar.n(true);
            }
        } else {
            d.b.j0.t.d.c.h.a aVar2 = this.f14408e;
            if (aVar2 != null) {
                aVar2.n(false);
            }
        }
        d.b.j0.t.d.c.h.a aVar3 = this.f14408e;
        if (aVar3 != null) {
            aVar3.p(isPrimary());
        }
    }

    @Override // d.b.j0.q0.o0
    public void w() {
        this.f14408e.q();
    }
}
