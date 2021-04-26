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
import d.a.i0.d0.h;
import d.a.i0.z0.b0;
import d.a.j0.q0.o0;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements o0 {
    public static int m = 1;
    public static int n = 1;
    public static int o = 1;
    public static HashMap<Integer, Integer> p = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.t.d.c.h.a f14470e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f14471f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f14472g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14473h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f14474i = -1;
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.t.d.c.e.b)) {
                return;
            }
            AlaLiveTabFragment.this.f14470e.w(true);
            d.a.j0.t.d.c.e.b bVar = (d.a.j0.t.d.c.e.b) customResponsedMessage.getData();
            if (bVar.f60484a) {
                if (AlaLiveTabFragment.this.f14473h || !bVar.f60485b) {
                    AlaLiveTabFragment.this.N0();
                    AlaLiveTabFragment alaLiveTabFragment = AlaLiveTabFragment.this;
                    alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f14470e.j());
                    AlaLiveTabFragment.this.f14470e.y(bVar.f60486c);
                    AlaLiveTabFragment.this.f14473h = false;
                }
            } else if (AlaLiveTabFragment.this.f14473h || !bVar.f60485b) {
                AlaLiveTabFragment alaLiveTabFragment2 = AlaLiveTabFragment.this;
                alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f14470e.j());
                AlaLiveTabFragment.this.R0();
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
            if (AlaLiveTabFragment.this.f14470e != null) {
                AlaLiveTabFragment.this.f14470e.x(intValue);
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
                AlaLiveTabFragment.this.f14471f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
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
            if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e2 = d.a.j0.t.d.c.c.e()) != AlaLiveTabFragment.this.f14470e.q) {
                AlaLiveTabFragment.this.f14470e.g(e2, true);
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
            if (!j.A() || AlaLiveTabFragment.this.f14470e == null) {
                return;
            }
            AlaLiveTabFragment.this.f14470e.w(false);
            AlaLiveTabFragment.this.Q0();
            AlaLiveTabFragment.this.f14470e.p();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    public static void L0(int i2) {
        if (p.containsKey(Integer.valueOf(i2))) {
            p.put(Integer.valueOf(i2), Integer.valueOf(p.get(Integer.valueOf(i2)).intValue() + 1));
        } else {
            p.put(Integer.valueOf(i2), 2);
        }
    }

    public static int M0(int i2) {
        if (p.containsKey(Integer.valueOf(i2))) {
            return p.get(Integer.valueOf(i2)).intValue();
        }
        p.put(Integer.valueOf(i2), 1);
        return 1;
    }

    @Override // d.a.j0.q0.o0
    public void G() {
    }

    @Override // d.a.j0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void N0() {
        this.f14470e.w(true);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f14470e.j());
            this.mRefreshView = null;
        }
    }

    public boolean O0() {
        return this.f14473h;
    }

    public void P0() {
        if (isAdded()) {
            Q0();
            this.f14470e.p();
        }
    }

    public final void Q0() {
        if (this.f14474i < 0) {
            this.f14474i = this.f14470e.j().getHeight();
        }
        showLoadingView(this.f14470e.j(), false, (((this.f14474i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    public void R0() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new e());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.f14470e.w(false);
        this.mRefreshView.k(0);
        this.mRefreshView.attachView(this.f14470e.j(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a083";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.t.d.c.h.a aVar = this.f14470e;
        if (aVar != null) {
            aVar.s();
        }
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.f14470e = new d.a.j0.t.d.c.h.a(getPageContext(), getChildFragmentManager(), this.j);
        if (this.f14471f == null) {
            this.f14471f = new AlaLiveUserNotifyController(getPageContext());
        }
        this.f14472g = new c();
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f14472g);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().addResponsedMessageRule(new d(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
        this.f14470e.k();
        if (this.f14474i > 0) {
            Q0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup j = this.f14470e.j();
        if (j.getParent() instanceof ViewGroup) {
            ((ViewGroup) j.getParent()).removeView(j);
        }
        return j;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14473h = true;
        d.a.j0.t.d.c.h.a aVar = this.f14470e;
        if (aVar != null) {
            aVar.h();
        }
        AlaLiveUserNotifyController alaLiveUserNotifyController = this.f14471f;
        if (alaLiveUserNotifyController != null) {
            alaLiveUserNotifyController.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f14472g);
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.j = true;
        this.f14470e.p();
        Q0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            d.a.j0.t.d.c.h.a aVar = this.f14470e;
            if (aVar != null) {
                aVar.r(true);
            }
        } else {
            d.a.j0.t.d.c.h.a aVar2 = this.f14470e;
            if (aVar2 != null) {
                aVar2.r(false);
            }
        }
        d.a.j0.t.d.c.h.a aVar3 = this.f14470e;
        if (aVar3 != null) {
            aVar3.t(isPrimary());
        }
    }

    @Override // d.a.j0.q0.o0
    public void p() {
        this.f14470e.u();
    }

    @Override // d.a.j0.q0.o0
    public void s() {
    }

    @Override // d.a.j0.q0.o0
    public void u() {
    }

    @Override // d.a.j0.q0.o0
    public void y(b0 b0Var) {
    }
}
