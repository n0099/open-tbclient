package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.dh;
import com.baidu.tieba.pm6;
import com.baidu.tieba.qm6;
import com.baidu.tieba.rm6;
import com.baidu.tieba.um6;
import com.baidu.tieba.yh6;
import com.baidu.tieba.ym6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, yh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public ym6 d;
    public pm6 e;
    public boolean f;
    public rm6 g;
    public qm6 h;
    public CustomMessageListener i;
    public boolean j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a implements rm6 {
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

        @Override // com.baidu.tieba.rm6
        public void a(int i, int i2, List<Cdo> list, List<um6> list2, boolean z, boolean z2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
                if (i != 0 || i2 != 0 || !ListUtils.isEmpty(list2)) {
                    if (this.a.d != null) {
                        this.a.f = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.d.f());
                        this.a.d.c(i, i2, list, list2, z, z2, i3);
                        if (i == 0 && i2 == 0) {
                            this.a.d.l(list2, z2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.d.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c73), false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070283));
            }
        }

        @Override // com.baidu.tieba.rm6
        public void b(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                if (i != 0 || i2 != 0) {
                    if (this.a.d != null) {
                        this.a.f = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.d.f());
                        this.a.d.m(i, i2, str);
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.d.f(), str, false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070283));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qm6 {
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

        @Override // com.baidu.tieba.qm6
        public um6 a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.e != null) {
                    return this.a.e.a(i);
                }
                return null;
            }
            return (um6) invokeI.objValue;
        }

        @Override // com.baidu.tieba.qm6
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.b(i, i2);
        }

        @Override // com.baidu.tieba.qm6
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.c(i, i2);
        }

        @Override // com.baidu.tieba.qm6
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.e != null) {
                    return this.a.e.d();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qm6
        public boolean e(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
                if (this.a.e != null) {
                    return this.a.e.e(i, i2);
                }
                return false;
            }
            return invokeII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.x();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.d == null || this.a.d.e() == null || this.a.d.e().getNavBarIsShow()) {
                    return;
                }
                this.a.d.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || this.a.d == null || this.a.d.e() == null || !this.a.d.e().getNavBarIsShow()) {
            } else {
                this.a.d.e().hideNavigationBarWithAnimation();
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
        this.g = new a(this);
        this.h = new b(this);
        this.i = new c(this, 0);
        this.j = true;
        this.k = new d(this, 0);
    }

    @Override // com.baidu.tieba.yh6
    public NavigationBar L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ym6 ym6Var = this.d;
            if (ym6Var != null) {
                return ym6Var.e();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
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
            ym6 ym6Var = this.d;
            if (ym6Var != null) {
                ym6Var.h(i);
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
                this.b = bundle.getString("name");
                this.c = bundle.getString("key_from");
            } else if (getArguments() != null) {
                this.a = getArguments().getString("fid");
                this.b = getArguments().getString("name");
                this.c = getArguments().getString("key_from");
            }
            pm6 pm6Var = new pm6(getActivity(), getUniqueId(), dh.g(this.a, 0L), this.b);
            this.e = pm6Var;
            pm6Var.u(this.g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d030e, (ViewGroup) null);
            ym6 ym6Var = new ym6(this, inflate);
            this.d = ym6Var;
            ym6Var.j(this.c);
            this.d.k(this.h);
            this.d.h(TbadkCoreApplication.getInst().getSkinType());
            if ("from_single_act".equals(this.c)) {
                w1();
                L0().setCenterTextTitle(this.b);
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
            pm6 pm6Var = this.e;
            if (pm6Var != null) {
                pm6Var.r();
            }
            ym6 ym6Var = this.d;
            if (ym6Var != null) {
                ym6Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            pm6 pm6Var = this.e;
            if (pm6Var != null) {
                pm6Var.b(0, 0);
            }
            ym6 ym6Var = this.d;
            if (ym6Var != null) {
                hideNetRefreshView(ym6Var.f());
                this.f = true;
                showLoadingView(this.d.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                w1();
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
                showToast(R.string.obfuscated_res_0x7f0f1361);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f10bd);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("fid", this.a);
            bundle.putString("name", this.b);
            bundle.putString("key_from", this.c);
        }
    }

    public final void w1() {
        pm6 pm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.j && (pm6Var = this.e) != null) {
            pm6Var.b(0, 0);
            this.j = false;
            ym6 ym6Var = this.d;
            if (ym6Var != null) {
                this.f = true;
                showLoadingView(ym6Var.f());
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f || this.d == null || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        this.d.d();
    }
}
