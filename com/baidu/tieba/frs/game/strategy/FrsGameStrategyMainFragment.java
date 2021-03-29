package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.i0.p0.r0;
import d.b.i0.p0.s1.a.d.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, r0 {

    /* renamed from: e  reason: collision with root package name */
    public String f16306e;

    /* renamed from: f  reason: collision with root package name */
    public String f16307f;

    /* renamed from: g  reason: collision with root package name */
    public String f16308g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.s1.a.e.d f16309h;
    public d.b.i0.p0.s1.a.c.b i;
    public boolean j;
    public d.b.i0.p0.s1.a.d.b k = new a();
    public d.b.i0.p0.s1.a.d.a l = new b();
    public CustomMessageListener m = new c(0);
    public boolean n = true;
    public CustomMessageListener o = new d(0);

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.p0.s1.a.d.b {
        public a() {
        }

        @Override // d.b.i0.p0.s1.a.d.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !ListUtils.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.f16309h != null) {
                    FrsGameStrategyMainFragment.this.j = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = FrsGameStrategyMainFragment.this;
                    frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f16309h.f());
                    FrsGameStrategyMainFragment.this.f16309h.c(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.f16309h.l(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f16309h.f(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // d.b.i0.p0.s1.a.d.b
        public void b(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.f16309h != null) {
                    FrsGameStrategyMainFragment.this.j = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = FrsGameStrategyMainFragment.this;
                    frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f16309h.f());
                    FrsGameStrategyMainFragment.this.f16309h.m(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f16309h.f(), str, false);
            FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.p0.s1.a.d.a {
        public b() {
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public e a(int i) {
            if (FrsGameStrategyMainFragment.this.i != null) {
                return FrsGameStrategyMainFragment.this.i.a(i);
            }
            return null;
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public void b(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.i != null) {
                FrsGameStrategyMainFragment.this.i.b(i, i2);
            }
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public boolean c(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.i != null) {
                return FrsGameStrategyMainFragment.this.i.c(i, i2);
            }
            return false;
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public void d(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.i != null) {
                FrsGameStrategyMainFragment.this.i.d(i, i2);
            }
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public String h() {
            if (FrsGameStrategyMainFragment.this.i != null) {
                return FrsGameStrategyMainFragment.this.i.h();
            }
            return null;
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
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                FrsGameStrategyMainFragment.this.E();
            }
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
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (FrsGameStrategyMainFragment.this.f16309h == null || FrsGameStrategyMainFragment.this.f16309h.e() == null || FrsGameStrategyMainFragment.this.f16309h.e().getNavBarIsShow()) {
                    return;
                }
                FrsGameStrategyMainFragment.this.f16309h.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || FrsGameStrategyMainFragment.this.f16309h == null || FrsGameStrategyMainFragment.this.f16309h.e() == null || !FrsGameStrategyMainFragment.this.f16309h.e().getNavBarIsShow()) {
            } else {
                FrsGameStrategyMainFragment.this.f16309h.e().hideNavigationBarWithAnimation();
            }
        }
    }

    public final void E() {
        if (this.j || this.f16309h == null || !j.z()) {
            return;
        }
        this.f16309h.d();
    }

    public final void K0() {
        d.b.i0.p0.s1.a.c.b bVar;
        if (!this.n || (bVar = this.i) == null) {
            return;
        }
        bVar.b(0, 0);
        this.n = false;
        d.b.i0.p0.s1.a.e.d dVar = this.f16309h;
        if (dVar != null) {
            this.j = true;
            showLoadingView(dVar.f());
        }
    }

    @Override // d.b.i0.p0.r0
    public NavigationBar Q() {
        d.b.i0.p0.s1.a.e.d dVar = this.f16309h;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    public String V() {
        return this.f16306e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.o.setSelfListener(true);
        registerListener(2001617, this.o, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.o, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.m, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.p0.s1.a.e.d dVar = this.f16309h;
        if (dVar != null) {
            dVar.h(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f16306e = bundle.getString("fid");
            this.f16307f = bundle.getString("name");
            this.f16308g = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.f16306e = getArguments().getString("fid");
            this.f16307f = getArguments().getString("name");
            this.f16308g = getArguments().getString("key_from");
        }
        d.b.i0.p0.s1.a.c.b bVar = new d.b.i0.p0.s1.a.c.b(getActivity(), getUniqueId(), d.b.b.e.m.b.f(this.f16306e, 0L), this.f16307f);
        this.i = bVar;
        bVar.u(this.k);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        d.b.i0.p0.s1.a.e.d dVar = new d.b.i0.p0.s1.a.e.d(this, inflate);
        this.f16309h = dVar;
        dVar.j(this.f16308g);
        this.f16309h.k(this.l);
        this.f16309h.h(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.f16308g)) {
            K0();
            Q().setCenterTextTitle(this.f16307f);
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.p0.s1.a.c.b bVar = this.i;
        if (bVar != null) {
            bVar.r();
        }
        d.b.i0.p0.s1.a.e.d dVar = this.f16309h;
        if (dVar != null) {
            dVar.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        d.b.i0.p0.s1.a.c.b bVar = this.i;
        if (bVar != null) {
            bVar.b(0, 0);
        }
        d.b.i0.p0.s1.a.e.d dVar = this.f16309h;
        if (dVar != null) {
            hideNetRefreshView(dVar.f());
            this.j = true;
            showLoadingView(this.f16309h.f());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            K0();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.f16306e);
        bundle.putString("name", this.f16307f);
        bundle.putString("key_from", this.f16308g);
    }
}
