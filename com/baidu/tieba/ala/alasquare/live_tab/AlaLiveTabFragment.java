package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.d0.h;
import d.a.j0.z0.b0;
import d.a.k0.q0.o0;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements o0 {
    public static int m = 1;
    public static int n = 1;
    public static int o = 1;
    public static HashMap<Integer, Integer> p = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.t.d.c.h.a f13785e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f13786f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f13787g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13788h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f13789i = -1;
    public CustomMessageListener k = new a(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
    public CustomMessageListener l = new b(2921446);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.t.d.c.e.b)) {
                return;
            }
            AlaLiveTabFragment.this.f13785e.x(true);
            d.a.k0.t.d.c.e.b bVar = (d.a.k0.t.d.c.e.b) customResponsedMessage.getData();
            if (bVar.f61208a) {
                if (AlaLiveTabFragment.this.f13788h || !bVar.f61209b) {
                    AlaLiveTabFragment.this.M0();
                    AlaLiveTabFragment alaLiveTabFragment = AlaLiveTabFragment.this;
                    alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f13785e.k());
                    AlaLiveTabFragment.this.f13785e.z(bVar.f61210c);
                    AlaLiveTabFragment.this.f13788h = false;
                }
            } else if (AlaLiveTabFragment.this.f13788h || !bVar.f61209b) {
                AlaLiveTabFragment alaLiveTabFragment2 = AlaLiveTabFragment.this;
                alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f13785e.k());
                AlaLiveTabFragment.this.Q0();
            }
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (AlaLiveTabFragment.this.f13785e != null) {
                AlaLiveTabFragment.this.f13785e.y(intValue);
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
                AlaLiveTabFragment.this.f13786f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.c.f.c {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.g
        /* renamed from: c */
        public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
            boolean e2;
            if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e2 = d.a.k0.t.d.c.c.e()) != AlaLiveTabFragment.this.f13785e.q) {
                AlaLiveTabFragment.this.f13785e.h(e2, true);
                return null;
            }
            return httpResponsedMessage;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || AlaLiveTabFragment.this.f13785e == null) {
                return;
            }
            AlaLiveTabFragment.this.f13785e.x(false);
            AlaLiveTabFragment.this.P0();
            AlaLiveTabFragment.this.f13785e.q();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    public static void K0(int i2) {
        if (p.containsKey(Integer.valueOf(i2))) {
            p.put(Integer.valueOf(i2), Integer.valueOf(p.get(Integer.valueOf(i2)).intValue() + 1));
        } else {
            p.put(Integer.valueOf(i2), 2);
        }
    }

    public static int L0(int i2) {
        if (p.containsKey(Integer.valueOf(i2))) {
            return p.get(Integer.valueOf(i2)).intValue();
        }
        p.put(Integer.valueOf(i2), 1);
        return 1;
    }

    @Override // d.a.k0.q0.o0
    public void G() {
    }

    @Override // d.a.k0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void M0() {
        this.f13785e.x(true);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f13785e.k());
            this.mRefreshView = null;
        }
    }

    public boolean N0() {
        return this.f13788h;
    }

    public void O0() {
        if (isAdded()) {
            P0();
            this.f13785e.q();
        }
    }

    public final void P0() {
        if (this.f13789i < 0) {
            this.f13789i = this.f13785e.k().getHeight();
        }
        showLoadingView(this.f13785e.k(), false, (((this.f13789i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    public void Q0() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new e());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.f13785e.x(false);
        this.mRefreshView.k(0);
        this.mRefreshView.attachView(this.f13785e.k(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a083";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.t.d.c.h.a aVar = this.f13785e;
        if (aVar != null) {
            aVar.t();
        }
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.f13785e = new d.a.k0.t.d.c.h.a(getPageContext(), getChildFragmentManager(), this.j);
        if (this.f13786f == null) {
            this.f13786f = new AlaLiveUserNotifyController(getPageContext());
        }
        this.f13787g = new c();
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f13787g);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().addResponsedMessageRule(new d(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
        this.f13785e.l();
        if (this.f13789i > 0) {
            P0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup k = this.f13785e.k();
        if (k.getParent() instanceof ViewGroup) {
            ((ViewGroup) k.getParent()).removeView(k);
        }
        return k;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13788h = true;
        d.a.k0.t.d.c.h.a aVar = this.f13785e;
        if (aVar != null) {
            aVar.i();
        }
        AlaLiveUserNotifyController alaLiveUserNotifyController = this.f13786f;
        if (alaLiveUserNotifyController != null) {
            alaLiveUserNotifyController.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f13787g);
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.j = true;
        this.f13785e.q();
        P0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            d.a.k0.t.d.c.h.a aVar = this.f13785e;
            if (aVar != null) {
                aVar.s(true);
            }
        } else {
            d.a.k0.t.d.c.h.a aVar2 = this.f13785e;
            if (aVar2 != null) {
                aVar2.s(false);
            }
        }
        d.a.k0.t.d.c.h.a aVar3 = this.f13785e;
        if (aVar3 != null) {
            aVar3.u(isPrimary());
        }
    }

    @Override // d.a.k0.q0.o0
    public void p() {
        this.f13785e.v();
    }

    @Override // d.a.k0.q0.o0
    public void s() {
    }

    @Override // d.a.k0.q0.o0
    public void u() {
    }

    @Override // d.a.k0.q0.o0
    public void y(b0 b0Var) {
    }
}
