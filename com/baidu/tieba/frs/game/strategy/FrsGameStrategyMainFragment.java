package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.f1.r0;
import c.a.p0.f1.u1.a.d.e;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f32520b;

    /* renamed from: c  reason: collision with root package name */
    public String f32521c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.u1.a.e.d f32522d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.u1.a.c.b f32523e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32524f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f1.u1.a.d.b f32525g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f1.u1.a.d.a f32526h;
    public CustomMessageListener i;
    public boolean j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a implements c.a.p0.f1.u1.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

        public a(FrsGameStrategyMainFragment frsGameStrategyMainFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyMainFragment;
        }

        @Override // c.a.p0.f1.u1.a.d.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
                if (i != 0 || i2 != 0 || !ListUtils.isEmpty(list2)) {
                    if (this.a.f32522d != null) {
                        this.a.f32524f = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f32522d.f());
                        this.a.f32522d.c(i, i2, list, list2, z, z2, i3);
                        if (i == 0 && i2 == 0) {
                            this.a.f32522d.l(list2, z2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f32522d.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d), false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a));
            }
        }

        @Override // c.a.p0.f1.u1.a.d.b
        public void b(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                if (i != 0 || i2 != 0) {
                    if (this.a.f32522d != null) {
                        this.a.f32524f = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f32522d.f());
                        this.a.f32522d.m(i, i2, str);
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f32522d.f(), str, false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.f1.u1.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

        public b(FrsGameStrategyMainFragment frsGameStrategyMainFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyMainFragment;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.f32523e != null) {
                    return this.a.f32523e.a(i);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || this.a.f32523e == null) {
                return;
            }
            this.a.f32523e.b(i, i2);
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.f32523e != null) {
                    return this.a.f32523e.c();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.a.f32523e == null) {
                return;
            }
            this.a.f32523e.d(i, i2);
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public boolean e(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
                if (this.a.f32523e != null) {
                    return this.a.f32523e.e(i, i2);
                }
                return false;
            }
            return invokeII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsGameStrategyMainFragment frsGameStrategyMainFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyMainFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyMainFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.a.f32522d == null || this.a.f32522d.e() == null || this.a.f32522d.e().getNavBarIsShow()) {
                    return;
                }
                this.a.f32522d.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || this.a.f32522d == null || this.a.f32522d.e() == null || !this.a.f32522d.e().getNavBarIsShow()) {
            } else {
                this.a.f32522d.e().hideNavigationBarWithAnimation();
            }
        }
    }

    public FrsGameStrategyMainFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32525g = new a(this);
        this.f32526h = new b(this);
        this.i = new c(this, 0);
        this.j = true;
        this.k = new d(this, 0);
    }

    public final void I0() {
        c.a.p0.f1.u1.a.c.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j && (bVar = this.f32523e) != null) {
            bVar.b(0, 0);
            this.j = false;
            c.a.p0.f1.u1.a.e.d dVar = this.f32522d;
            if (dVar != null) {
                this.f32524f = true;
                showLoadingView(dVar.f());
            }
        }
    }

    @Override // c.a.p0.f1.r0
    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.f1.u1.a.e.d dVar = this.f32522d;
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.k.setSelfListener(true);
            registerListener(2001617, this.k, getBaseFragmentActivity().getUniqueId());
            registerListener(2001618, this.k, getBaseFragmentActivity().getUniqueId());
            registerListener(2001446, this.i, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.p0.f1.u1.a.e.d dVar = this.f32522d;
            if (dVar != null) {
                dVar.h(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.a = bundle.getString("fid");
                this.f32520b = bundle.getString("name");
                this.f32521c = bundle.getString("key_from");
            } else if (getArguments() != null) {
                this.a = getArguments().getString("fid");
                this.f32520b = getArguments().getString("name");
                this.f32521c = getArguments().getString("key_from");
            }
            c.a.p0.f1.u1.a.c.b bVar = new c.a.p0.f1.u1.a.c.b(getActivity(), getUniqueId(), c.a.d.f.m.b.g(this.a, 0L), this.f32520b);
            this.f32523e = bVar;
            bVar.u(this.f32525g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0318, (ViewGroup) null);
            c.a.p0.f1.u1.a.e.d dVar = new c.a.p0.f1.u1.a.e.d(this, inflate);
            this.f32522d = dVar;
            dVar.j(this.f32521c);
            this.f32522d.k(this.f32526h);
            this.f32522d.h(TbadkCoreApplication.getInst().getSkinType());
            if ("from_single_act".equals(this.f32521c)) {
                I0();
                d0().setCenterTextTitle(this.f32520b);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            c.a.p0.f1.u1.a.c.b bVar = this.f32523e;
            if (bVar != null) {
                bVar.r();
            }
            c.a.p0.f1.u1.a.e.d dVar = this.f32522d;
            if (dVar != null) {
                dVar.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.f1.u1.a.c.b bVar = this.f32523e;
            if (bVar != null) {
                bVar.b(0, 0);
            }
            c.a.p0.f1.u1.a.e.d dVar = this.f32522d;
            if (dVar != null) {
                hideNetRefreshView(dVar.f());
                this.f32524f = true;
                showLoadingView(this.f32522d.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                I0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048585, this, i, strArr, iArr) == null) && i == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.obfuscated_res_0x7f0f1312);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f1076);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("fid", this.a);
            bundle.putString("name", this.f32520b);
            bundle.putString("key_from", this.f32521c);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f32524f || this.f32522d == null || !l.z()) {
            return;
        }
        this.f32522d.d();
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
