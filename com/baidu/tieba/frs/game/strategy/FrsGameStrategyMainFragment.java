package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.r0.w0.q0;
import c.a.r0.w0.s1.a.d.e;
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
/* loaded from: classes7.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, q0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_SINGLE_ACT = "from_single_act";
    public static final String KEY_FID = "fid";
    public static final String KEY_FROM = "key_from";
    public static final String NAME = "name";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f51260e;

    /* renamed from: f  reason: collision with root package name */
    public String f51261f;

    /* renamed from: g  reason: collision with root package name */
    public String f51262g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.w0.s1.a.e.d f51263h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.w0.s1.a.c.b f51264i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51265j;
    public c.a.r0.w0.s1.a.d.b k;
    public c.a.r0.w0.s1.a.d.a l;
    public CustomMessageListener m;
    public boolean n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a implements c.a.r0.w0.s1.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f51266e;

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
            this.f51266e = frsGameStrategyMainFragment;
        }

        @Override // c.a.r0.w0.s1.a.d.b
        public void refreshView(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
                if (i2 != 0 || i3 != 0 || !ListUtils.isEmpty(list2)) {
                    if (this.f51266e.f51263h != null) {
                        this.f51266e.f51265j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f51266e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f51263h.f());
                        this.f51266e.f51263h.c(i2, i3, list, list2, z, z2, i4);
                        if (i2 == 0 && i3 == 0) {
                            this.f51266e.f51263h.l(list2, z2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f51266e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f51263h.f(), this.f51266e.getResources().getString(R.string.no_data_text), false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f51266e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }

        @Override // c.a.r0.w0.s1.a.d.b
        public void showError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                if (i2 != 0 || i3 != 0) {
                    if (this.f51266e.f51263h != null) {
                        this.f51266e.f51265j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f51266e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f51263h.f());
                        this.f51266e.f51263h.m(i2, i3, str);
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f51266e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f51263h.f(), str, false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f51266e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.r0.w0.s1.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f51267a;

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
            this.f51267a = frsGameStrategyMainFragment;
        }

        @Override // c.a.r0.w0.s1.a.d.a
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f51267a.f51264i != null) {
                    return this.f51267a.f51264i.a(i2);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // c.a.r0.w0.s1.a.d.a
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f51267a.f51264i == null) {
                return;
            }
            this.f51267a.f51264i.b(i2, i3);
        }

        @Override // c.a.r0.w0.s1.a.d.a
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f51267a.f51264i == null) {
                return;
            }
            this.f51267a.f51264i.c(i2, i3);
        }

        @Override // c.a.r0.w0.s1.a.d.a
        public boolean d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (this.f51267a.f51264i != null) {
                    return this.f51267a.f51264i.d(i2, i3);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // c.a.r0.w0.s1.a.d.a
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f51267a.f51264i != null) {
                    return this.f51267a.f51264i.getForumId();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f51268a;

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
            this.f51268a = frsGameStrategyMainFragment;
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
                this.f51268a.forceRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f51269a;

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
            this.f51269a = frsGameStrategyMainFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.f51269a.f51263h == null || this.f51269a.f51263h.e() == null || this.f51269a.f51263h.e().getNavBarIsShow()) {
                    return;
                }
                this.f51269a.f51263h.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || this.f51269a.f51263h == null || this.f51269a.f51263h.e() == null || !this.f51269a.f51263h.e().getNavBarIsShow()) {
            } else {
                this.f51269a.f51263h.e().hideNavigationBarWithAnimation();
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

    public final void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51265j || this.f51263h == null || !j.z()) {
            return;
        }
        this.f51263h.d();
    }

    public final void g() {
        c.a.r0.w0.s1.a.c.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.n && (bVar = this.f51264i) != null) {
            bVar.b(0, 0);
            this.n = false;
            c.a.r0.w0.s1.a.e.d dVar = this.f51263h;
            if (dVar != null) {
                this.f51265j = true;
                showLoadingView(dVar.f());
            }
        }
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51260e : (String) invokeV.objValue;
    }

    @Override // c.a.r0.w0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.w0.s1.a.e.d dVar = this.f51263h;
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
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.w0.s1.a.e.d dVar = this.f51263h;
            if (dVar != null) {
                dVar.h(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f51260e = bundle.getString("fid");
                this.f51261f = bundle.getString("name");
                this.f51262g = bundle.getString(KEY_FROM);
            } else if (getArguments() != null) {
                this.f51260e = getArguments().getString("fid");
                this.f51261f = getArguments().getString("name");
                this.f51262g = getArguments().getString(KEY_FROM);
            }
            c.a.r0.w0.s1.a.c.b bVar = new c.a.r0.w0.s1.a.c.b(getActivity(), getUniqueId(), c.a.e.e.m.b.g(this.f51260e, 0L), this.f51261f);
            this.f51264i = bVar;
            bVar.t(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
            c.a.r0.w0.s1.a.e.d dVar = new c.a.r0.w0.s1.a.e.d(this, inflate);
            this.f51263h = dVar;
            dVar.j(this.f51262g);
            this.f51263h.k(this.l);
            this.f51263h.h(TbadkCoreApplication.getInst().getSkinType());
            if (FROM_SINGLE_ACT.equals(this.f51262g)) {
                g();
                getNavigationBar().setCenterTextTitle(this.f51261f);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            c.a.r0.w0.s1.a.c.b bVar = this.f51264i;
            if (bVar != null) {
                bVar.q();
            }
            c.a.r0.w0.s1.a.e.d dVar = this.f51263h;
            if (dVar != null) {
                dVar.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.w0.s1.a.c.b bVar = this.f51264i;
            if (bVar != null) {
                bVar.b(0, 0);
            }
            c.a.r0.w0.s1.a.e.d dVar = this.f51263h;
            if (dVar != null) {
                hideNetRefreshView(dVar.f());
                this.f51265j = true;
                showLoadingView(this.f51263h.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                g();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048587, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("fid", this.f51260e);
            bundle.putString("name", this.f51261f);
            bundle.putString(KEY_FROM, this.f51262g);
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f51260e = str;
        }
    }
}
