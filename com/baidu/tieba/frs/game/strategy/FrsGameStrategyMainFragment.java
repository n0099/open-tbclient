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
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.k0.q0.r0;
import d.a.k0.q0.s1.a.d.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, r0 {

    /* renamed from: e  reason: collision with root package name */
    public String f15486e;

    /* renamed from: f  reason: collision with root package name */
    public String f15487f;

    /* renamed from: g  reason: collision with root package name */
    public String f15488g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.q0.s1.a.e.d f15489h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.q0.s1.a.c.b f15490i;
    public boolean j;
    public d.a.k0.q0.s1.a.d.b k = new a();
    public d.a.k0.q0.s1.a.d.a l = new b();
    public CustomMessageListener m = new c(0);
    public boolean n = true;
    public CustomMessageListener o = new d(0);

    /* loaded from: classes4.dex */
    public class a implements d.a.k0.q0.s1.a.d.b {
        public a() {
        }

        @Override // d.a.k0.q0.s1.a.d.b
        public void a(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
            if (i2 != 0 || i3 != 0 || !ListUtils.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.f15489h != null) {
                    FrsGameStrategyMainFragment.this.j = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = FrsGameStrategyMainFragment.this;
                    frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f15489h.f());
                    FrsGameStrategyMainFragment.this.f15489h.c(i2, i3, list, list2, z, z2, i4);
                    if (i2 == 0 && i3 == 0) {
                        FrsGameStrategyMainFragment.this.f15489h.l(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f15489h.f(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // d.a.k0.q0.s1.a.d.b
        public void b(int i2, int i3, String str) {
            if (i2 != 0 || i3 != 0) {
                if (FrsGameStrategyMainFragment.this.f15489h != null) {
                    FrsGameStrategyMainFragment.this.j = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = FrsGameStrategyMainFragment.this;
                    frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f15489h.f());
                    FrsGameStrategyMainFragment.this.f15489h.m(i2, i3, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f15489h.f(), str, false);
            FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = FrsGameStrategyMainFragment.this;
            frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.k0.q0.s1.a.d.a {
        public b() {
        }

        @Override // d.a.k0.q0.s1.a.d.a
        public e a(int i2) {
            if (FrsGameStrategyMainFragment.this.f15490i != null) {
                return FrsGameStrategyMainFragment.this.f15490i.a(i2);
            }
            return null;
        }

        @Override // d.a.k0.q0.s1.a.d.a
        public void b(int i2, int i3) {
            if (FrsGameStrategyMainFragment.this.f15490i != null) {
                FrsGameStrategyMainFragment.this.f15490i.b(i2, i3);
            }
        }

        @Override // d.a.k0.q0.s1.a.d.a
        public void c(int i2, int i3) {
            if (FrsGameStrategyMainFragment.this.f15490i != null) {
                FrsGameStrategyMainFragment.this.f15490i.c(i2, i3);
            }
        }

        @Override // d.a.k0.q0.s1.a.d.a
        public boolean d(int i2, int i3) {
            if (FrsGameStrategyMainFragment.this.f15490i != null) {
                return FrsGameStrategyMainFragment.this.f15490i.d(i2, i3);
            }
            return false;
        }

        @Override // d.a.k0.q0.s1.a.d.a
        public String h() {
            if (FrsGameStrategyMainFragment.this.f15490i != null) {
                return FrsGameStrategyMainFragment.this.f15490i.h();
            }
            return null;
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
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                FrsGameStrategyMainFragment.this.t();
            }
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
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (FrsGameStrategyMainFragment.this.f15489h == null || FrsGameStrategyMainFragment.this.f15489h.e() == null || FrsGameStrategyMainFragment.this.f15489h.e().getNavBarIsShow()) {
                    return;
                }
                FrsGameStrategyMainFragment.this.f15489h.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || FrsGameStrategyMainFragment.this.f15489h == null || FrsGameStrategyMainFragment.this.f15489h.e() == null || !FrsGameStrategyMainFragment.this.f15489h.e().getNavBarIsShow()) {
            } else {
                FrsGameStrategyMainFragment.this.f15489h.e().hideNavigationBarWithAnimation();
            }
        }
    }

    public String F() {
        return this.f15486e;
    }

    public final void J0() {
        d.a.k0.q0.s1.a.c.b bVar;
        if (!this.n || (bVar = this.f15490i) == null) {
            return;
        }
        bVar.b(0, 0);
        this.n = false;
        d.a.k0.q0.s1.a.e.d dVar = this.f15489h;
        if (dVar != null) {
            this.j = true;
            showLoadingView(dVar.f());
        }
    }

    @Override // d.a.k0.q0.r0
    public NavigationBar e0() {
        d.a.k0.q0.s1.a.e.d dVar = this.f15489h;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
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
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.q0.s1.a.e.d dVar = this.f15489h;
        if (dVar != null) {
            dVar.h(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f15486e = bundle.getString("fid");
            this.f15487f = bundle.getString("name");
            this.f15488g = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.f15486e = getArguments().getString("fid");
            this.f15487f = getArguments().getString("name");
            this.f15488g = getArguments().getString("key_from");
        }
        d.a.k0.q0.s1.a.c.b bVar = new d.a.k0.q0.s1.a.c.b(getActivity(), getUniqueId(), d.a.c.e.m.b.f(this.f15486e, 0L), this.f15487f);
        this.f15490i = bVar;
        bVar.u(this.k);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        d.a.k0.q0.s1.a.e.d dVar = new d.a.k0.q0.s1.a.e.d(this, inflate);
        this.f15489h = dVar;
        dVar.j(this.f15488g);
        this.f15489h.k(this.l);
        this.f15489h.h(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.f15488g)) {
            J0();
            e0().setCenterTextTitle(this.f15487f);
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.k0.q0.s1.a.c.b bVar = this.f15490i;
        if (bVar != null) {
            bVar.r();
        }
        d.a.k0.q0.s1.a.e.d dVar = this.f15489h;
        if (dVar != null) {
            dVar.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        d.a.k0.q0.s1.a.c.b bVar = this.f15490i;
        if (bVar != null) {
            bVar.b(0, 0);
        }
        d.a.k0.q0.s1.a.e.d dVar = this.f15489h;
        if (dVar != null) {
            hideNetRefreshView(dVar.f());
            this.j = true;
            showLoadingView(this.f15489h.f());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            J0();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
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
        bundle.putString("fid", this.f15486e);
        bundle.putString("name", this.f15487f);
        bundle.putString("key_from", this.f15488g);
    }

    public final void t() {
        if (this.j || this.f15489h == null || !j.z()) {
            return;
        }
        this.f15489h.d();
    }
}
