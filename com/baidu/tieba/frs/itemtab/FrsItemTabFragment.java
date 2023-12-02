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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bk5;
import com.baidu.tieba.em6;
import com.baidu.tieba.l65;
import com.baidu.tieba.m65;
import com.baidu.tieba.ot7;
import com.baidu.tieba.p08;
import com.baidu.tieba.pua;
import com.baidu.tieba.q08;
import com.baidu.tieba.qs7;
import com.baidu.tieba.qt7;
import com.baidu.tieba.r08;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, ot7, qt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public View g;
    public bk5 h;
    public p08 i;
    public q08 j;
    public String k;
    public ItemInfo l;
    public BdUniqueId m;
    public VoiceManager n;
    public int o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    public int J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d03a2 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.qt7
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
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
                    this.a.N2(true);
                    this.a.a2();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l65)) {
                l65 l65Var = (l65) customResponsedMessage.getData();
                String str = this.a.d;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    str2 = TbadkCoreApplication.getCurrentAccount();
                }
                l65Var.l(str, str2, this.a.c);
                m65.c(l65Var);
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
        this.o = -1;
        this.p = new a(this, 2001624);
        this.q = new b(this, 2921573);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            pua.g().k(getUniqueId());
            em6.b().e(false);
            super.onDestroy();
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.k();
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
                L2();
                return;
            }
            showNetRefreshView(this.g, null, true);
        }
    }

    public void M2(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void N2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            qs7 qs7Var = new qs7();
            qs7Var.a = this.a;
            qs7Var.b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, qs7Var));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.q(true);
            }
            bk5 bk5Var = this.h;
            if (bk5Var != null) {
                bk5Var.dettachView(view2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.j();
            }
        }
    }

    @Override // com.baidu.tieba.ot7
    public void F() {
        p08 p08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p08Var = this.i) != null) {
            p08Var.o(0);
        }
    }

    public ItemInfo I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (ItemInfo) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !BdUtilHelper.isNetOk()) {
            return;
        }
        VoiceManager voiceManager = this.n;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        q08 q08Var = this.j;
        if (q08Var != null) {
            q08Var.d();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.n == null) {
                this.n = VoiceManager.instance();
            }
            return this.n;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ot7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            F();
            q08 q08Var = this.j;
            if (q08Var != null) {
                q08Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.g);
            showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
            L2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStop();
            pua.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public void K2(r08 r08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, r08Var) != null) || r08Var == null) {
            return;
        }
        hideLoadingView(this.g);
        if (this.i != null) {
            N2(false);
            this.i.m(r08Var);
        }
        this.l = r08Var.a;
        pua.g().h(getUniqueId(), false);
    }

    @Override // com.baidu.tieba.ot7
    public void S0(boolean z) {
        int paddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            View view2 = this.g;
            if (view2 != null) {
                int paddingLeft = view2.getPaddingLeft();
                int paddingTop = this.g.getPaddingTop();
                int paddingRight = this.g.getPaddingRight();
                if (z) {
                    paddingBottom = UtilHelper.getDimenPixelSize(R.dimen.tbds150);
                } else {
                    paddingBottom = this.g.getPaddingBottom();
                }
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.i(z);
            }
        }
    }

    @Override // com.baidu.tieba.qt7
    public void a2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || getContext() == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.g);
            if (this.j.a()) {
                hideLoadingView(this.g);
            } else {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
            }
            L2();
            return;
        }
        N2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.l((isAdded() && isPrimary()) ? false : false);
            }
        }
    }

    public void i(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, errorData) == null) {
            hideLoadingView(this.g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a73);
                }
            }
            if (!this.j.a()) {
                String str = null;
                if (errorData != null) {
                    str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
                }
                showNetRefreshView(this.g, str, true);
            }
            N2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.a);
            bundle.putInt("tab_type", this.b);
            bundle.putString("tab_code", this.c + "");
            bundle.putString("forum_id", this.d);
            bundle.putString("name", this.e);
            bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, this.f);
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.a = bundle.getInt("tab_id");
                this.b = bundle.getInt("tab_type");
                this.c = JavaTypesHelper.toInt(bundle.getString("tab_code"), 0);
                this.d = bundle.getString("forum_id");
                this.e = bundle.getString("name");
                this.f = bundle.getBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG);
                this.k = bundle.getString("theme_color");
                this.o = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.a = arguments.getInt("tab_id");
                    this.b = arguments.getInt("tab_type");
                    this.c = JavaTypesHelper.toInt(arguments.getString("tab_code"), 0);
                    this.d = arguments.getString("forum_id");
                    this.e = arguments.getString("name");
                    this.f = arguments.getBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG);
                    this.o = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.k = arguments.getString("theme_color");
                }
            }
            VoiceManager d1 = d1();
            this.n = d1;
            d1.onCreate(getPageContext());
            pua.g().i(getUniqueId());
            this.j = new q08(this, this.c);
            if (this.o != -1) {
                l65 l65Var = new l65(5);
                String str = this.d;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    str2 = TbadkCoreApplication.getCurrentAccount();
                }
                l65Var.l(str, str2, this.c);
                l65Var.q(this.o);
                m65.c(l65Var);
            }
            registerListener(this.p);
            registerListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(J2(), (ViewGroup) null);
            this.g = inflate;
            p08 p08Var = new p08(this, inflate);
            this.i = p08Var;
            p08Var.p(this.k);
            this.i.n(this.m);
            return this.g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, view2, str, z) == null) {
            p08 p08Var = this.i;
            if (p08Var != null) {
                p08Var.q(false);
            }
            if (getPageContext() != null && getPageContext().getContext() != null) {
                if (this.h == null) {
                    this.h = new bk5(getPageContext().getContext(), getNetRefreshListener());
                }
                this.h.d(null);
                this.h.c(str);
                this.h.b(null);
                this.h.attachView(view2, z);
                this.h.e();
                this.h.a(0);
            }
        }
    }
}
