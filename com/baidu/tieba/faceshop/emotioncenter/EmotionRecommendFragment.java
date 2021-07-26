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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class EmotionRecommendFragment extends BaseFragment implements d.a.q0.p0.y.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.p0.y.e.a f15114e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionCenterModel f15115f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15116g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15117h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15118i;
    public boolean j;
    public final CustomMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public f.g n;
    public BdListView.p o;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15119a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionRecommendFragment emotionRecommendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i2)};
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
            this.f15119a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || this.f15119a.f15115f == null || this.f15119a.f15114e == null || this.f15119a.f15114e.h() == null || this.f15119a.f15114e.h().getVisibility() != 0) {
                return;
            }
            this.f15119a.f15115f.y(this.f15119a);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15120a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionRecommendFragment emotionRecommendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i2)};
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
            this.f15120a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || this.f15120a.f15114e == null) {
                return;
            }
            this.f15120a.f15114e.x(emotionPackageData);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15121a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionRecommendFragment emotionRecommendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment, Integer.valueOf(i2)};
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
            this.f15121a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (this.f15121a.f15114e != null) {
                        this.f15121a.f15114e.n();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (this.f15121a.f15114e != null) {
                        this.f15121a.f15114e.n();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (this.f15121a.f15114e != null) {
                        this.f15121a.f15114e.n();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (this.f15121a.f15114e != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.J(this.f15121a.getActivity(), str);
                        } else {
                            l.J(this.f15121a.getActivity(), this.f15121a.getString(R.string.emotion_error_default_net_tip));
                        }
                        this.f15121a.f15114e.w();
                    }
                } else {
                    BdToast.c(this.f15121a.getPageContext().getPageActivity(), this.f15121a.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                    if (this.f15121a.f15114e != null) {
                        this.f15121a.f15114e.n();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15122e;

        public d(EmotionRecommendFragment emotionRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15122e = emotionRecommendFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f15122e.f15115f != null && !this.f15122e.f15118i) {
                    this.f15122e.f15115f.y(this.f15122e);
                }
                this.f15122e.f15114e.j().d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15123e;

        public e(EmotionRecommendFragment emotionRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15123e = emotionRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15123e.f15115f == null || this.f15123e.f15118i) {
                return;
            }
            if (this.f15123e.f15117h) {
                this.f15123e.f15114e.s();
                this.f15123e.f15115f.x(this.f15123e);
                return;
            }
            this.f15123e.f15114e.u();
        }
    }

    public EmotionRecommendFragment() {
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
        this.f15115f = null;
        this.f15116g = true;
        this.f15117h = false;
        this.f15118i = false;
        this.j = false;
        this.k = new a(this, 2000994);
        this.l = new b(this, 2921059);
        this.m = new c(this, 2921040);
        this.n = new d(this);
        this.o = new e(this);
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.a.q0.c2.g.e.l().r()) {
                d.a.q0.p0.y.e.a aVar = this.f15114e;
                if (aVar != null) {
                    aVar.r();
                    return;
                }
                return;
            }
            d.a.q0.p0.y.e.a aVar2 = this.f15114e;
            if (aVar2 != null) {
                aVar2.n();
            }
        }
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.p0.y.e.a aVar = this.f15114e;
            if (aVar != null) {
                return aVar.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.p0.y.d.b
    public void V(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) == null) {
            this.f15118i = false;
            this.f15114e.k();
            if (emotionCenterData == null) {
                return;
            }
            this.f15114e.c(emotionCenterData);
        }
    }

    @Override // d.a.q0.p0.y.d.b
    public void f0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emotionCenterData) == null) {
        }
    }

    @Override // d.a.q0.p0.y.d.b
    public void m0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionCenterData) == null) {
            this.f15118i = false;
            this.f15114e.d();
            this.f15114e.k();
            if (emotionCenterData == null) {
                return;
            }
            if (!"1".equals(emotionCenterData.has_more)) {
                this.f15117h = false;
            } else {
                this.f15117h = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
            }
            this.f15114e.o(emotionCenterData);
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.p0.y.e.a aVar = this.f15114e;
            if (aVar != null) {
                aVar.m(i2);
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
            d.a.q0.p0.y.e.a aVar = new d.a.q0.p0.y.e.a(getPageContext(), getUniqueId());
            this.f15114e = aVar;
            aVar.p(this.n);
            this.f15114e.q(this.o);
            registerListener(this.k);
            registerListener(this.l);
            if (this.f15115f == null) {
                this.f15115f = new EmotionCenterModel(getPageContext());
            }
            registerListener(this.m);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.j = arguments.getBoolean("need_check_login");
            }
            if (!this.j) {
                if (this.f15116g && (emotionCenterModel2 = this.f15115f) != null) {
                    emotionCenterModel2.y(this);
                    this.f15118i = true;
                    this.f15116g = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f15116g && (emotionCenterModel = this.f15115f) != null) {
                    emotionCenterModel.y(this);
                    this.f15118i = true;
                    this.f15116g = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.f15114e.i();
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
            Q0();
        }
    }
}
