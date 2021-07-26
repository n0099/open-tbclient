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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.q0.u0.q0;
import d.a.q0.u0.r1.a.d.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f15708e;

    /* renamed from: f  reason: collision with root package name */
    public String f15709f;

    /* renamed from: g  reason: collision with root package name */
    public String f15710g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.u0.r1.a.e.d f15711h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.u0.r1.a.c.b f15712i;
    public boolean j;
    public d.a.q0.u0.r1.a.d.b k;
    public d.a.q0.u0.r1.a.d.a l;
    public CustomMessageListener m;
    public boolean n;
    public CustomMessageListener o;

    /* loaded from: classes4.dex */
    public class a implements d.a.q0.u0.r1.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f15713e;

        public a(FrsGameStrategyMainFragment frsGameStrategyMainFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15713e = frsGameStrategyMainFragment;
        }

        @Override // d.a.q0.u0.r1.a.d.b
        public void a(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
                if (i2 != 0 || i3 != 0 || !ListUtils.isEmpty(list2)) {
                    if (this.f15713e.f15711h != null) {
                        this.f15713e.j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f15713e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f15711h.f());
                        this.f15713e.f15711h.c(i2, i3, list, list2, z, z2, i4);
                        if (i2 == 0 && i3 == 0) {
                            this.f15713e.f15711h.l(list2, z2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f15713e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f15711h.f(), this.f15713e.getResources().getString(R.string.no_data_text), false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f15713e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }

        @Override // d.a.q0.u0.r1.a.d.b
        public void b(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                if (i2 != 0 || i3 != 0) {
                    if (this.f15713e.f15711h != null) {
                        this.f15713e.j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f15713e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f15711h.f());
                        this.f15713e.f15711h.m(i2, i3, str);
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f15713e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f15711h.f(), str, false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f15713e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.q0.u0.r1.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f15714a;

        public b(FrsGameStrategyMainFragment frsGameStrategyMainFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15714a = frsGameStrategyMainFragment;
        }

        @Override // d.a.q0.u0.r1.a.d.a
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f15714a.f15712i != null) {
                    return this.f15714a.f15712i.a(i2);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // d.a.q0.u0.r1.a.d.a
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f15714a.f15712i == null) {
                return;
            }
            this.f15714a.f15712i.b(i2, i3);
        }

        @Override // d.a.q0.u0.r1.a.d.a
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f15714a.f15712i == null) {
                return;
            }
            this.f15714a.f15712i.c(i2, i3);
        }

        @Override // d.a.q0.u0.r1.a.d.a
        public boolean d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (this.f15714a.f15712i != null) {
                    return this.f15714a.f15712i.d(i2, i3);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // d.a.q0.u0.r1.a.d.a
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f15714a.f15712i != null) {
                    return this.f15714a.f15712i.h();
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f15715a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsGameStrategyMainFragment frsGameStrategyMainFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15715a = frsGameStrategyMainFragment;
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
                this.f15715a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f15716a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyMainFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15716a = frsGameStrategyMainFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.f15716a.f15711h == null || this.f15716a.f15711h.e() == null || this.f15716a.f15711h.e().getNavBarIsShow()) {
                    return;
                }
                this.f15716a.f15711h.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || this.f15716a.f15711h == null || this.f15716a.f15711h.e() == null || !this.f15716a.f15711h.e().getNavBarIsShow()) {
            } else {
                this.f15716a.f15711h.e().hideNavigationBarWithAnimation();
            }
        }
    }

    public FrsGameStrategyMainFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this, 0);
        this.n = true;
        this.o = new d(this, 0);
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15708e : (String) invokeV.objValue;
    }

    public final void S0() {
        d.a.q0.u0.r1.a.c.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.n && (bVar = this.f15712i) != null) {
            bVar.b(0, 0);
            this.n = false;
            d.a.q0.u0.r1.a.e.d dVar = this.f15711h;
            if (dVar != null) {
                this.j = true;
                showLoadingView(dVar.f());
            }
        }
    }

    @Override // d.a.q0.u0.q0
    public NavigationBar j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.u0.r1.a.e.d dVar = this.f15711h;
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
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.o.setSelfListener(true);
            registerListener(2001617, this.o, getBaseFragmentActivity().getUniqueId());
            registerListener(2001618, this.o, getBaseFragmentActivity().getUniqueId());
            registerListener(2001446, this.m, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.u0.r1.a.e.d dVar = this.f15711h;
            if (dVar != null) {
                dVar.h(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f15708e = bundle.getString("fid");
                this.f15709f = bundle.getString("name");
                this.f15710g = bundle.getString("key_from");
            } else if (getArguments() != null) {
                this.f15708e = getArguments().getString("fid");
                this.f15709f = getArguments().getString("name");
                this.f15710g = getArguments().getString("key_from");
            }
            d.a.q0.u0.r1.a.c.b bVar = new d.a.q0.u0.r1.a.c.b(getActivity(), getUniqueId(), d.a.d.e.m.b.f(this.f15708e, 0L), this.f15709f);
            this.f15712i = bVar;
            bVar.u(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
            d.a.q0.u0.r1.a.e.d dVar = new d.a.q0.u0.r1.a.e.d(this, inflate);
            this.f15711h = dVar;
            dVar.j(this.f15710g);
            this.f15711h.k(this.l);
            this.f15711h.h(TbadkCoreApplication.getInst().getSkinType());
            if ("from_single_act".equals(this.f15710g)) {
                S0();
                j0().setCenterTextTitle(this.f15709f);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            d.a.q0.u0.r1.a.c.b bVar = this.f15712i;
            if (bVar != null) {
                bVar.r();
            }
            d.a.q0.u0.r1.a.e.d dVar = this.f15711h;
            if (dVar != null) {
                dVar.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.u0.r1.a.c.b bVar = this.f15712i;
            if (bVar != null) {
                bVar.b(0, 0);
            }
            d.a.q0.u0.r1.a.e.d dVar = this.f15711h;
            if (dVar != null) {
                hideNetRefreshView(dVar.f());
                this.j = true;
                showLoadingView(this.f15711h.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                S0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, iArr) == null) && i2 == 1) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("fid", this.f15708e);
            bundle.putString("name", this.f15709f);
            bundle.putString("key_from", this.f15710g);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.j || this.f15711h == null || !j.z()) {
            return;
        }
        this.f15711h.d();
    }
}
