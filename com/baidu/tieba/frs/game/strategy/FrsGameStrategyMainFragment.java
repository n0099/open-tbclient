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
import com.baidu.tieba.R;
import com.baidu.tieba.bb7;
import com.baidu.tieba.cb7;
import com.baidu.tieba.db7;
import com.baidu.tieba.gb7;
import com.baidu.tieba.gg;
import com.baidu.tieba.h67;
import com.baidu.tieba.hn;
import com.baidu.tieba.kb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, h67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public kb7 d;
    public bb7 e;
    public boolean f;
    public db7 g;
    public cb7 h;
    public CustomMessageListener i;
    public boolean j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a implements db7 {
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

        @Override // com.baidu.tieba.db7
        public void a(int i, int i2, List<hn> list, List<gb7> list2, boolean z, boolean z2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
                if (i == 0 && i2 == 0 && ListUtils.isEmpty(list2)) {
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                    frsGameStrategyMainFragment.showNetRefreshView(frsGameStrategyMainFragment.d.f(), this.a.getResources().getString(R.string.no_data_text), false);
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                    frsGameStrategyMainFragment2.setNetRefreshViewTopMargin(frsGameStrategyMainFragment2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070284));
                } else if (this.a.d == null) {
                } else {
                    this.a.f = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                    frsGameStrategyMainFragment3.hideLoadingView(frsGameStrategyMainFragment3.d.f());
                    this.a.d.c(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        this.a.d.l(list2, z2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.db7
        public void b(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                if (i == 0 && i2 == 0) {
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.a;
                    frsGameStrategyMainFragment.showNetRefreshView(frsGameStrategyMainFragment.d.f(), str, false);
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.a;
                    frsGameStrategyMainFragment2.setNetRefreshViewTopMargin(frsGameStrategyMainFragment2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070284));
                } else if (this.a.d != null) {
                    this.a.f = false;
                    FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.a;
                    frsGameStrategyMainFragment3.hideLoadingView(frsGameStrategyMainFragment3.d.f());
                    this.a.d.m(i, i2, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements cb7 {
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

        @Override // com.baidu.tieba.cb7
        public gb7 a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.e != null) {
                    return this.a.e.a(i);
                }
                return null;
            }
            return (gb7) invokeI.objValue;
        }

        @Override // com.baidu.tieba.cb7
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && this.a.e != null) {
                this.a.e.b(i, i2);
            }
        }

        @Override // com.baidu.tieba.cb7
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && this.a.e != null) {
                this.a.e.c(i, i2);
            }
        }

        @Override // com.baidu.tieba.cb7
        public boolean d(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
                if (this.a.e != null) {
                    return this.a.e.d(i, i2);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // com.baidu.tieba.cb7
        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.e != null) {
                    return this.a.e.w();
                }
                return null;
            }
            return (String) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    this.a.D();
                }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.a.d != null && this.a.d.e() != null && !this.a.d.e().getNavBarIsShow()) {
                    this.a.d.e().showNavigationBarWithAnimation();
                }
            } else if (customResponsedMessage.getCmd() == 2001618 && this.a.d != null && this.a.d.e() != null && this.a.d.e().getNavBarIsShow()) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            kb7 kb7Var = this.d;
            if (kb7Var != null) {
                kb7Var.h(i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("fid", this.a);
            bundle.putString("name", this.b);
            bundle.putString("key_from", this.c);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f && this.d != null && BdNetTypeUtil.isNetWorkAvailable()) {
            this.d.d();
        }
    }

    public final void K1() {
        bb7 bb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.j && (bb7Var = this.e) != null) {
            bb7Var.b(0, 0);
            this.j = false;
            kb7 kb7Var = this.d;
            if (kb7Var != null) {
                this.f = true;
                showLoadingView(kb7Var.f());
            }
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h67
    public NavigationBar V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            kb7 kb7Var = this.d;
            if (kb7Var != null) {
                return kb7Var.e();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            bb7 bb7Var = this.e;
            if (bb7Var != null) {
                bb7Var.q();
            }
            kb7 kb7Var = this.d;
            if (kb7Var != null) {
                kb7Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            bb7 bb7Var = this.e;
            if (bb7Var != null) {
                bb7Var.b(0, 0);
            }
            kb7 kb7Var = this.d;
            if (kb7Var != null) {
                hideNetRefreshView(kb7Var.f());
                this.f = true;
                showLoadingView(this.d.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                K1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.k.setSelfListener(true);
            registerListener(2001617, this.k, getBaseFragmentActivity().getUniqueId());
            registerListener(2001618, this.k, getBaseFragmentActivity().getUniqueId());
            registerListener(2001446, this.i, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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
            bb7 bb7Var = new bb7(getActivity(), getUniqueId(), gg.g(this.a, 0L), this.b);
            this.e = bb7Var;
            bb7Var.t(this.g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d032d, (ViewGroup) null);
            kb7 kb7Var = new kb7(this, inflate);
            this.d = kb7Var;
            kb7Var.j(this.c);
            this.d.k(this.h);
            this.d.h(TbadkCoreApplication.getInst().getSkinType());
            if ("from_single_act".equals(this.c)) {
                K1();
                V0().setCenterTextTitle(this.b);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048587, this, i, strArr, iArr) == null) && i == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
