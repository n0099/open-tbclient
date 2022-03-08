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
import c.a.r0.d1.r0;
import c.a.r0.d1.u1.a.d.e;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_SINGLE_ACT = "from_single_act";
    public static final String KEY_FID = "fid";
    public static final String KEY_FROM = "key_from";
    public static final String NAME = "name";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f41996e;

    /* renamed from: f  reason: collision with root package name */
    public String f41997f;

    /* renamed from: g  reason: collision with root package name */
    public String f41998g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.d1.u1.a.e.d f41999h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.d1.u1.a.c.b f42000i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42001j;
    public c.a.r0.d1.u1.a.d.b k;
    public c.a.r0.d1.u1.a.d.a l;
    public CustomMessageListener m;
    public boolean n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements c.a.r0.d1.u1.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyMainFragment f42002e;

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
            this.f42002e = frsGameStrategyMainFragment;
        }

        @Override // c.a.r0.d1.u1.a.d.b
        public void refreshView(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
                if (i2 != 0 || i3 != 0 || !ListUtils.isEmpty(list2)) {
                    if (this.f42002e.f41999h != null) {
                        this.f42002e.f42001j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f42002e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f41999h.f());
                        this.f42002e.f41999h.c(i2, i3, list, list2, z, z2, i4);
                        if (i2 == 0 && i3 == 0) {
                            this.f42002e.f41999h.l(list2, z2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f42002e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f41999h.f(), this.f42002e.getResources().getString(R.string.no_data_text), false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f42002e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }

        @Override // c.a.r0.d1.u1.a.d.b
        public void showError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                if (i2 != 0 || i3 != 0) {
                    if (this.f42002e.f41999h != null) {
                        this.f42002e.f42001j = false;
                        FrsGameStrategyMainFragment frsGameStrategyMainFragment = this.f42002e;
                        frsGameStrategyMainFragment.hideLoadingView(frsGameStrategyMainFragment.f41999h.f());
                        this.f42002e.f41999h.m(i2, i3, str);
                        return;
                    }
                    return;
                }
                FrsGameStrategyMainFragment frsGameStrategyMainFragment2 = this.f42002e;
                frsGameStrategyMainFragment2.showNetRefreshView(frsGameStrategyMainFragment2.f41999h.f(), str, false);
                FrsGameStrategyMainFragment frsGameStrategyMainFragment3 = this.f42002e;
                frsGameStrategyMainFragment3.setNetRefreshViewTopMargin(frsGameStrategyMainFragment3.getResources().getDimensionPixelSize(R.dimen.ds240));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.r0.d1.u1.a.d.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyMainFragment;
        }

        @Override // c.a.r0.d1.u1.a.d.a
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.a.f42000i != null) {
                    return this.a.f42000i.a(i2);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // c.a.r0.d1.u1.a.d.a
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.a.f42000i == null) {
                return;
            }
            this.a.f42000i.b(i2, i3);
        }

        @Override // c.a.r0.d1.u1.a.d.a
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.a.f42000i == null) {
                return;
            }
            this.a.f42000i.c(i2, i3);
        }

        @Override // c.a.r0.d1.u1.a.d.a
        public boolean d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (this.a.f42000i != null) {
                    return this.a.f42000i.d(i2, i3);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // c.a.r0.d1.u1.a.d.a
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.f42000i != null) {
                    return this.a.f42000i.getForumId();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

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
                this.a.forceRefresh();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyMainFragment a;

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
                if (this.a.f41999h == null || this.a.f41999h.e() == null || this.a.f41999h.e().getNavBarIsShow()) {
                    return;
                }
                this.a.f41999h.e().showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() != 2001618 || this.a.f41999h == null || this.a.f41999h.e() == null || !this.a.f41999h.e().getNavBarIsShow()) {
            } else {
                this.a.f41999h.e().hideNavigationBarWithAnimation();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42001j || this.f41999h == null || !l.z()) {
            return;
        }
        this.f41999h.d();
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41996e : (String) invokeV.objValue;
    }

    @Override // c.a.r0.d1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.d1.u1.a.e.d dVar = this.f41999h;
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void k() {
        c.a.r0.d1.u1.a.c.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.n && (bVar = this.f42000i) != null) {
            bVar.b(0, 0);
            this.n = false;
            c.a.r0.d1.u1.a.e.d dVar = this.f41999h;
            if (dVar != null) {
                this.f42001j = true;
                showLoadingView(dVar.f());
            }
        }
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
            c.a.r0.d1.u1.a.e.d dVar = this.f41999h;
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
                this.f41996e = bundle.getString("fid");
                this.f41997f = bundle.getString("name");
                this.f41998g = bundle.getString(KEY_FROM);
            } else if (getArguments() != null) {
                this.f41996e = getArguments().getString("fid");
                this.f41997f = getArguments().getString("name");
                this.f41998g = getArguments().getString(KEY_FROM);
            }
            c.a.r0.d1.u1.a.c.b bVar = new c.a.r0.d1.u1.a.c.b(getActivity(), getUniqueId(), c.a.d.f.m.b.g(this.f41996e, 0L), this.f41997f);
            this.f42000i = bVar;
            bVar.t(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
            c.a.r0.d1.u1.a.e.d dVar = new c.a.r0.d1.u1.a.e.d(this, inflate);
            this.f41999h = dVar;
            dVar.j(this.f41998g);
            this.f41999h.k(this.l);
            this.f41999h.h(TbadkCoreApplication.getInst().getSkinType());
            if (FROM_SINGLE_ACT.equals(this.f41998g)) {
                k();
                getNavigationBar().setCenterTextTitle(this.f41997f);
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
            c.a.r0.d1.u1.a.c.b bVar = this.f42000i;
            if (bVar != null) {
                bVar.q();
            }
            c.a.r0.d1.u1.a.e.d dVar = this.f41999h;
            if (dVar != null) {
                dVar.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.d1.u1.a.c.b bVar = this.f42000i;
            if (bVar != null) {
                bVar.b(0, 0);
            }
            c.a.r0.d1.u1.a.e.d dVar = this.f41999h;
            if (dVar != null) {
                hideNetRefreshView(dVar.f());
                this.f42001j = true;
                showLoadingView(this.f41999h.f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                k();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
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
            bundle.putString("fid", this.f41996e);
            bundle.putString("name", this.f41997f);
            bundle.putString(KEY_FROM, this.f41998g);
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f41996e = str;
        }
    }
}
