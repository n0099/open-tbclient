package com.baidu.tieba.faceshop.emotioncenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
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
import java.util.HashMap;
/* loaded from: classes9.dex */
public class EmotionRecommendFragment extends BaseFragment implements b.a.r0.s0.x.d.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NEED_CHECK_LOGIN = "need_check_login";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.s0.x.e.a f48876e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionCenterModel f48877f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48878g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48879h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48880i;
    public boolean j;
    public final CustomMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public f.g n;
    public BdListView.p o;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f48881a;

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
            this.f48881a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || this.f48881a.f48877f == null || this.f48881a.f48876e == null || this.f48881a.f48876e.h() == null || this.f48881a.f48876e.h().getVisibility() != 0) {
                return;
            }
            this.f48881a.f48877f.y(this.f48881a);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f48882a;

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
            this.f48882a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || this.f48882a.f48876e == null) {
                return;
            }
            this.f48882a.f48876e.x(emotionPackageData);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f48883a;

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
            this.f48883a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (this.f48883a.f48876e != null) {
                        this.f48883a.f48876e.n();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (this.f48883a.f48876e != null) {
                        this.f48883a.f48876e.n();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (this.f48883a.f48876e != null) {
                        this.f48883a.f48876e.n();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (this.f48883a.f48876e != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.J(this.f48883a.getActivity(), str);
                        } else {
                            l.J(this.f48883a.getActivity(), this.f48883a.getString(R.string.emotion_error_default_net_tip));
                        }
                        this.f48883a.f48876e.w();
                    }
                } else {
                    BdToast.c(this.f48883a.getPageContext().getPageActivity(), this.f48883a.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                    if (this.f48883a.f48876e != null) {
                        this.f48883a.f48876e.n();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f48884e;

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
            this.f48884e = emotionRecommendFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f48884e.f48877f != null && !this.f48884e.f48880i) {
                    this.f48884e.f48877f.y(this.f48884e);
                }
                this.f48884e.f48876e.j().refreshNetData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f48885e;

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
            this.f48885e = emotionRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48885e.f48877f == null || this.f48885e.f48880i) {
                return;
            }
            if (this.f48885e.f48879h) {
                this.f48885e.f48876e.s();
                this.f48885e.f48877f.x(this.f48885e);
                return;
            }
            this.f48885e.f48876e.u();
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
        this.f48877f = null;
        this.f48878g = true;
        this.f48879h = false;
        this.f48880i = false;
        this.j = false;
        this.k = new a(this, 2000994);
        this.l = new b(this, 2921059);
        this.m = new c(this, 2921040);
        this.n = new d(this);
        this.o = new e(this);
    }

    @Override // b.a.r0.s0.x.d.b
    public void change(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, emotionCenterData) == null) {
        }
    }

    public void failed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f48880i = false;
            this.f48876e.d();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (b.a.r0.f2.g.e.l().r()) {
                b.a.r0.s0.x.e.a aVar = this.f48876e;
                if (aVar != null) {
                    aVar.r();
                    return;
                }
                return;
            }
            b.a.r0.s0.x.e.a aVar2 = this.f48876e;
            if (aVar2 != null) {
                aVar2.n();
            }
        }
    }

    public int getIsBazhu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.s0.x.e.a aVar = this.f48876e;
            if (aVar != null) {
                return aVar.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.s0.x.d.b
    public void loadMore(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionCenterData) == null) {
            this.f48880i = false;
            this.f48876e.k();
            if (emotionCenterData == null) {
                return;
            }
            this.f48876e.c(emotionCenterData);
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
            b.a.r0.s0.x.e.a aVar = this.f48876e;
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
            b.a.r0.s0.x.e.a aVar = new b.a.r0.s0.x.e.a(getPageContext(), getUniqueId());
            this.f48876e = aVar;
            aVar.p(this.n);
            this.f48876e.q(this.o);
            registerListener(this.k);
            registerListener(this.l);
            if (this.f48877f == null) {
                this.f48877f = new EmotionCenterModel(getPageContext());
            }
            registerListener(this.m);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.j = arguments.getBoolean("need_check_login");
            }
            if (!this.j) {
                if (this.f48878g && (emotionCenterModel2 = this.f48877f) != null) {
                    emotionCenterModel2.y(this);
                    this.f48880i = true;
                    this.f48878g = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f48878g && (emotionCenterModel = this.f48877f) != null) {
                    emotionCenterModel.y(this);
                    this.f48880i = true;
                    this.f48878g = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.f48876e.i();
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
            g();
        }
    }

    @Override // b.a.r0.s0.x.d.b
    public void refreshSuccess(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, emotionCenterData) == null) {
            this.f48880i = false;
            this.f48876e.d();
            this.f48876e.k();
            if (emotionCenterData == null) {
                return;
            }
            if (!"1".equals(emotionCenterData.has_more)) {
                this.f48879h = false;
            } else {
                this.f48879h = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
            }
            this.f48876e.o(emotionCenterData);
        }
    }
}
