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
import com.repackage.ai8;
import com.repackage.gv4;
import com.repackage.hv4;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.mi;
import com.repackage.nx5;
import com.repackage.t45;
import com.repackage.uk6;
import com.repackage.vd6;
import com.repackage.vk6;
import com.repackage.wk6;
import com.repackage.xd6;
import com.repackage.yc6;
/* loaded from: classes3.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, vd6, xd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public View g;
    public t45 h;
    public uk6 i;
    public vk6 j;
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
                    this.a.I0(true);
                    this.a.k0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gv4)) {
                gv4 gv4Var = (gv4) customResponsedMessage.getData();
                String str = this.a.d;
                if (str == null) {
                    str = "";
                }
                gv4Var.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.a.c);
                hv4.c(gv4Var);
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

    @Override // com.repackage.xd6
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d032e : invokeV.intValue;
    }

    public void F0(wk6 wk6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wk6Var) == null) || wk6Var == null) {
            return;
        }
        hideLoadingView(this.g);
        if (this.i != null) {
            I0(false);
            this.i.m(wk6Var);
        }
        ai8.g().h(getUniqueId(), false);
    }

    @Override // com.repackage.vd6
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            View view2 = this.g;
            view2.setPadding(view2.getPaddingLeft(), this.g.getPaddingTop(), this.g.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds150) : this.g.getPaddingBottom());
            this.i.i(z);
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && mi.C()) {
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            vk6 vk6Var = this.j;
            if (vk6Var != null) {
                vk6Var.d();
            }
        }
    }

    public void H0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.l = bdUniqueId;
        }
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            yc6 yc6Var = new yc6();
            yc6Var.a = this.a;
            yc6Var.b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, yc6Var));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            uk6 uk6Var = this.i;
            if (uk6Var != null) {
                uk6Var.q(true);
            }
            t45 t45Var = this.h;
            if (t45Var != null) {
                t45Var.dettachView(view2);
            }
        }
    }

    @Override // com.repackage.xd6
    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || getContext() == null) {
            return;
        }
        if (ki.z()) {
            hideNetRefreshView(this.g);
            if (this.j.a()) {
                hideLoadingView(this.g);
            } else {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
            }
            G0();
            return;
        }
        I0(false);
    }

    @Override // com.repackage.vd6
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            z0();
            vk6 vk6Var = this.j;
            if (vk6Var != null) {
                vk6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            uk6 uk6Var = this.i;
            if (uk6Var != null) {
                uk6Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.a = bundle.getInt("tab_id");
                this.b = bundle.getInt("tab_type");
                this.c = kg.e(bundle.getString("tab_code"), 0);
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
                    this.c = kg.e(arguments.getString("tab_code"), 0);
                    this.d = arguments.getString("forum_id");
                    this.e = arguments.getString("name");
                    this.f = arguments.getBoolean("need_log");
                    this.n = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.k = arguments.getString("theme_color");
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onCreate(getPageContext());
            ai8.g().i(getUniqueId());
            this.j = new vk6(this, this.c);
            if (this.n != -1) {
                gv4 gv4Var = new gv4(5);
                String str = this.d;
                if (str == null) {
                    str = "";
                }
                gv4Var.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.c);
                gv4Var.n(this.n);
                hv4.c(gv4Var);
            }
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(E0(), (ViewGroup) null);
            this.g = inflate;
            uk6 uk6Var = new uk6(this, inflate);
            this.i = uk6Var;
            uk6Var.p(this.k);
            this.i.n(this.l);
            return this.g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ai8.g().k(getUniqueId());
            nx5.b().e(false);
            super.onDestroy();
            uk6 uk6Var = this.i;
            if (uk6Var != null) {
                uk6Var.k();
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLazyLoad();
            if (ki.z()) {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
                G0();
                return;
            }
            showNetRefreshView(this.g, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && ki.z()) {
            hideNetRefreshView(this.g);
            showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
            G0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
            uk6 uk6Var = this.i;
            if (uk6Var != null) {
                uk6Var.l((isAdded() && isPrimary()) ? false : false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
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

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, errorData) == null) {
            hideLoadingView(this.g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f08a9);
                }
            }
            if (!this.j.a()) {
                showNetRefreshView(this.g, errorData != null ? getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2c, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            I0(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onStop();
            ai8.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048601, this, view2, str, z) == null) {
            uk6 uk6Var = this.i;
            if (uk6Var != null) {
                uk6Var.q(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.h == null) {
                this.h = new t45(getPageContext().getContext(), getNetRefreshListener());
            }
            this.h.e(null);
            this.h.d(str);
            this.h.c(null);
            this.h.attachView(view2, z);
            this.h.f();
            this.h.a(0);
        }
    }

    @Override // com.repackage.vd6
    public void z0() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (uk6Var = this.i) == null) {
            return;
        }
        uk6Var.o(0);
    }
}
