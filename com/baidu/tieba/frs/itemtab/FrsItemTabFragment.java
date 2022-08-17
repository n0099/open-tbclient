package com.baidu.tieba.frs.itemtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag6;
import com.repackage.c65;
import com.repackage.cg6;
import com.repackage.cj8;
import com.repackage.df6;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.qi;
import com.repackage.tm6;
import com.repackage.um6;
import com.repackage.uz5;
import com.repackage.vm6;
import com.repackage.yv4;
import com.repackage.zv4;
/* loaded from: classes3.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, ag6, cg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public View g;
    public c65 h;
    public tm6 i;
    public um6 j;
    public String k;
    public BdUniqueId l;
    public VoiceManager m;
    public int n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsItemTabFragment frsItemTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemTabFragment, Integer.valueOf(i)};
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
            this.a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int parseInt = Integer.parseInt(data.toString());
                FrsItemTabFragment frsItemTabFragment = this.a;
                if (parseInt == frsItemTabFragment.a) {
                    if (frsItemTabFragment.i != null) {
                        this.a.i.o(0);
                    }
                    if (this.a.h != null && this.a.h.isViewAttached()) {
                        this.a.onNetRefreshButtonClicked();
                        return;
                    }
                    this.a.x1(true);
                    this.a.V0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsItemTabFragment frsItemTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemTabFragment, Integer.valueOf(i)};
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
            this.a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yv4)) {
                yv4 yv4Var = (yv4) customResponsedMessage.getData();
                String str = this.a.d;
                if (str == null) {
                    str = "";
                }
                yv4Var.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.a.c);
                zv4.c(yv4Var);
            }
        }
    }

    public FrsItemTabFragment() {
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
        this.n = -1;
        this.o = new a(this, 2001624);
        this.p = new b(this, 2921573);
    }

    @Override // com.repackage.cg6
    public void V0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getContext() == null) {
            return;
        }
        if (oi.z()) {
            hideNetRefreshView(this.g);
            if (this.j.a()) {
                hideLoadingView(this.g);
            } else {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
            }
            v1();
            return;
        }
        x1(false);
    }

    @Override // com.repackage.cg6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, errorData) == null) {
            hideLoadingView(this.g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f08ba);
                }
            }
            if (!this.j.a()) {
                showNetRefreshView(this.g, errorData != null ? getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3c, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            x1(false);
        }
    }

    @Override // com.repackage.ag6
    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            View view2 = this.g;
            view2.setPadding(view2.getPaddingLeft(), this.g.getPaddingTop(), this.g.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds150) : this.g.getPaddingBottom());
            this.i.i(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            tm6 tm6Var = this.i;
            if (tm6Var != null) {
                tm6Var.q(true);
            }
            c65 c65Var = this.h;
            if (c65Var != null) {
                c65Var.dettachView(view2);
            }
        }
    }

    @Override // com.repackage.ag6
    public void o1() {
        tm6 tm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tm6Var = this.i) == null) {
            return;
        }
        tm6Var.o(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            tm6 tm6Var = this.i;
            if (tm6Var != null) {
                tm6Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.a = bundle.getInt("tab_id");
                this.b = bundle.getInt("tab_type");
                this.c = og.e(bundle.getString("tab_code"), 0);
                this.d = bundle.getString("forum_id");
                this.e = bundle.getString("name");
                this.f = bundle.getBoolean("need_log");
                this.k = bundle.getString("theme_color");
                this.n = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.a = arguments.getInt("tab_id");
                    this.b = arguments.getInt("tab_type");
                    this.c = og.e(arguments.getString("tab_code"), 0);
                    this.d = arguments.getString("forum_id");
                    this.e = arguments.getString("name");
                    this.f = arguments.getBoolean("need_log");
                    this.n = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.k = arguments.getString("theme_color");
                }
            }
            VoiceManager t0 = t0();
            this.m = t0;
            t0.onCreate(getPageContext());
            cj8.g().i(getUniqueId());
            this.j = new um6(this, this.c);
            if (this.n != -1) {
                yv4 yv4Var = new yv4(5);
                String str = this.d;
                if (str == null) {
                    str = "";
                }
                yv4Var.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.c);
                yv4Var.n(this.n);
                zv4.c(yv4Var);
            }
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(t1(), (ViewGroup) null);
            this.g = inflate;
            tm6 tm6Var = new tm6(this, inflate);
            this.i = tm6Var;
            tm6Var.p(this.k);
            this.i.n(this.l);
            return this.g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            cj8.g().k(getUniqueId());
            uz5.b().e(false);
            super.onDestroy();
            tm6 tm6Var = this.i;
            if (tm6Var != null) {
                tm6Var.k();
            }
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLazyLoad();
            if (oi.z()) {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
                v1();
                return;
            }
            showNetRefreshView(this.g, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && oi.z()) {
            hideNetRefreshView(this.g);
            showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
            v1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            boolean z = true;
            if (isAdded() && isPrimary()) {
                TbSingleton.getInstance().isItemTabVisible = true;
                if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            } else {
                TbSingleton.getInstance().isItemTabVisible = false;
            }
            tm6 tm6Var = this.i;
            if (tm6Var != null) {
                tm6Var.l((isAdded() && isPrimary()) ? false : false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.a);
            bundle.putInt("tab_type", this.b);
            bundle.putString("tab_code", this.c + "");
            bundle.putString("forum_id", this.d);
            bundle.putString("name", this.e);
            bundle.putBoolean("need_log", this.f);
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            cj8.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view2, str, z) == null) {
            tm6 tm6Var = this.i;
            if (tm6Var != null) {
                tm6Var.q(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.h == null) {
                this.h = new c65(getPageContext().getContext(), getNetRefreshListener());
            }
            this.h.e(null);
            this.h.d(str);
            this.h.c(null);
            this.h.attachView(view2, z);
            this.h.f();
            this.h.a(0);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? R.layout.obfuscated_res_0x7f0d0329 : invokeV.intValue;
    }

    public void u1(vm6 vm6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, vm6Var) == null) || vm6Var == null) {
            return;
        }
        hideLoadingView(this.g);
        if (this.i != null) {
            x1(false);
            this.i.m(vm6Var);
        }
        cj8.g().h(getUniqueId(), false);
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && qi.D()) {
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            um6 um6Var = this.j;
            if (um6Var != null) {
                um6Var.d();
            }
        }
    }

    public void w1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.l = bdUniqueId;
        }
    }

    @Override // com.repackage.ag6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            o1();
            um6 um6Var = this.j;
            if (um6Var != null) {
                um6Var.d();
            }
        }
    }

    public void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            df6 df6Var = new df6();
            df6Var.a = this.a;
            df6Var.b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, df6Var));
        }
    }
}
