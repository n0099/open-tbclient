package com.baidu.tieba.faceshop.emotioncenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ca6;
import com.repackage.cu4;
import com.repackage.ea6;
import com.repackage.ko7;
import com.repackage.mi;
import com.repackage.oi;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class EmotionRecommendFragment extends BaseFragment implements ca6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ea6 a;
    public EmotionCenterModel b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final CustomMessageListener g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public cu4.g j;
    public BdListView.p k;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionRecommendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionRecommendFragment emotionRecommendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i)};
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
            this.a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !mi.z() || this.a.b == null || this.a.a == null || this.a.a.h() == null || this.a.a.h().getVisibility() != 0) {
                return;
            }
            this.a.b.A(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionRecommendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionRecommendFragment emotionRecommendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i)};
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
            this.a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || this.a.a == null) {
                return;
            }
            this.a.a.y(emotionPackageData);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionRecommendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionRecommendFragment emotionRecommendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i)};
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
            this.a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (this.a.a != null) {
                        this.a.a.n();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (this.a.a != null) {
                        this.a.a.n();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (this.a.a != null) {
                        this.a.a.n();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (this.a.a != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            oi.K(this.a.getActivity(), str);
                        } else {
                            oi.K(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0542));
                        }
                        this.a.a.x();
                    }
                } else {
                    BdToast.c(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f05e0)).q();
                    if (this.a.a != null) {
                        this.a.a.n();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements cu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionRecommendFragment a;

        public d(EmotionRecommendFragment emotionRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionRecommendFragment;
        }

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.b != null && !this.a.e) {
                    this.a.b.A(this.a);
                }
                this.a.a.j().d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionRecommendFragment a;

        public e(EmotionRecommendFragment emotionRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null || this.a.e) {
                return;
            }
            if (this.a.d) {
                this.a.a.t();
                this.a.b.z(this.a);
                return;
            }
            this.a.a.v();
        }
    }

    public EmotionRecommendFragment() {
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
        this.b = null;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = new a(this, 2000994);
        this.h = new b(this, 2921059);
        this.i = new c(this, 2921040);
        this.j = new d(this);
        this.k = new e(this);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (ko7.l().r()) {
                ea6 ea6Var = this.a;
                if (ea6Var != null) {
                    ea6Var.s();
                    return;
                }
                return;
            }
            ea6 ea6Var2 = this.a;
            if (ea6Var2 != null) {
                ea6Var2.n();
            }
        }
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ea6 ea6Var = this.a;
            if (ea6Var != null) {
                return ea6Var.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ca6
    public void Q(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) == null) {
            this.e = false;
            this.a.k();
            if (emotionCenterData == null) {
                return;
            }
            this.a.c(emotionCenterData);
        }
    }

    @Override // com.repackage.ca6
    public void Z(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emotionCenterData) == null) {
        }
    }

    @Override // com.repackage.ca6
    public void i0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionCenterData) == null) {
            this.e = false;
            this.a.d();
            this.a.k();
            if (emotionCenterData == null) {
                return;
            }
            if (!"1".equals(emotionCenterData.has_more)) {
                this.d = false;
            } else {
                this.d = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
            }
            this.a.o(emotionCenterData);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            ea6 ea6Var = this.a;
            if (ea6Var != null) {
                ea6Var.m(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        EmotionCenterModel emotionCenterModel;
        EmotionCenterModel emotionCenterModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            ea6 ea6Var = new ea6(getPageContext(), getUniqueId());
            this.a = ea6Var;
            ea6Var.p(this.j);
            this.a.r(this.k);
            registerListener(this.g);
            registerListener(this.h);
            if (this.b == null) {
                this.b = new EmotionCenterModel(getPageContext());
            }
            registerListener(this.i);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f = arguments.getBoolean("need_check_login");
            }
            if (!this.f) {
                if (this.c && (emotionCenterModel2 = this.b) != null) {
                    emotionCenterModel2.A(this);
                    this.e = true;
                    this.c = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.c && (emotionCenterModel = this.b) != null) {
                    emotionCenterModel.A(this);
                    this.e = true;
                    this.c = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.a.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            F0();
        }
    }
}
