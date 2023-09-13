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
import com.baidu.tieba.ep6;
import com.baidu.tieba.mq7;
import com.baidu.tieba.nj7;
import com.baidu.tieba.nq7;
import com.baidu.tieba.oq7;
import com.baidu.tieba.pi7;
import com.baidu.tieba.pj7;
import com.baidu.tieba.sn5;
import com.baidu.tieba.va5;
import com.baidu.tieba.vfa;
import com.baidu.tieba.wa5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, nj7, pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public View g;
    public sn5 h;
    public mq7 i;
    public nq7 j;
    public String k;
    public ItemInfo l;
    public BdUniqueId m;
    public VoiceManager n;
    public int o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    public int Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0389 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pj7
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.d2(true);
                    this.a.w1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof va5)) {
                va5 va5Var = (va5) customResponsedMessage.getData();
                String str = this.a.d;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    str2 = TbadkCoreApplication.getCurrentAccount();
                }
                va5Var.k(str, str2, this.a.c);
                wa5.c(va5Var);
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            vfa.g().k(getUniqueId());
            ep6.b().e(false);
            super.onDestroy();
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.k();
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
                b2();
                return;
            }
            showNetRefreshView(this.g, null, true);
        }
    }

    public void c2(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void d2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            pi7 pi7Var = new pi7();
            pi7Var.a = this.a;
            pi7Var.b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, pi7Var));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.q(true);
            }
            sn5 sn5Var = this.h;
            if (sn5Var != null) {
                sn5Var.dettachView(view2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onChangeSkinType(i);
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.n == null) {
                this.n = VoiceManager.instance();
            }
            return this.n;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void S1() {
        mq7 mq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (mq7Var = this.i) != null) {
            mq7Var.o(0);
        }
    }

    public ItemInfo Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (ItemInfo) invokeV.objValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !BdUtilHelper.isNetOk()) {
            return;
        }
        VoiceManager voiceManager = this.n;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        nq7 nq7Var = this.j;
        if (nq7Var != null) {
            nq7Var.d();
        }
    }

    @Override // com.baidu.tieba.nj7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            S1();
            nq7 nq7Var = this.j;
            if (nq7Var != null) {
                nq7Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.g);
            showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
            b2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            vfa.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public void a2(oq7 oq7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, oq7Var) != null) || oq7Var == null) {
            return;
        }
        hideLoadingView(this.g);
        if (this.i != null) {
            d2(false);
            this.i.m(oq7Var);
        }
        this.l = oq7Var.a;
        vfa.g().h(getUniqueId(), false);
    }

    @Override // com.baidu.tieba.nj7
    public void y0(boolean z) {
        int paddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
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
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.i(z);
            }
        }
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, errorData) == null) {
            hideLoadingView(this.g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a50);
                }
            }
            if (!this.j.a()) {
                String str = null;
                if (errorData != null) {
                    str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
                }
                showNetRefreshView(this.g, str, true);
            }
            d2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
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
            VoiceManager H0 = H0();
            this.n = H0;
            H0.onCreate(getPageContext());
            vfa.g().i(getUniqueId());
            this.j = new nq7(this, this.c);
            if (this.o != -1) {
                va5 va5Var = new va5(5);
                String str = this.d;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    str2 = TbadkCoreApplication.getCurrentAccount();
                }
                va5Var.k(str, str2, this.c);
                va5Var.p(this.o);
                wa5.c(va5Var);
            }
            registerListener(this.p);
            registerListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(Z1(), (ViewGroup) null);
            this.g = inflate;
            mq7 mq7Var = new mq7(this, inflate);
            this.i = mq7Var;
            mq7Var.p(this.k);
            this.i.n(this.m);
            return this.g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.l((isAdded() && isPrimary()) ? false : false);
            }
        }
    }

    @Override // com.baidu.tieba.pj7
    public void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || getContext() == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.g);
            if (this.j.a()) {
                hideLoadingView(this.g);
            } else {
                showLoadingView(this.g, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
            }
            b2();
            return;
        }
        d2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view2, str, z) == null) {
            mq7 mq7Var = this.i;
            if (mq7Var != null) {
                mq7Var.q(false);
            }
            if (getPageContext() != null && getPageContext().getContext() != null) {
                if (this.h == null) {
                    this.h = new sn5(getPageContext().getContext(), getNetRefreshListener());
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
