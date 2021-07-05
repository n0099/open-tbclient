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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EmotionRecommendFragment extends BaseFragment implements d.a.s0.p0.y.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.p0.y.e.a f15027e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionCenterModel f15028f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15029g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15030h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15031i;
    public boolean j;
    public final CustomMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public f.g n;
    public BdListView.p o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15032a;

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
            this.f15032a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || this.f15032a.f15028f == null || this.f15032a.f15027e == null || this.f15032a.f15027e.i() == null || this.f15032a.f15027e.i().getVisibility() != 0) {
                return;
            }
            this.f15032a.f15028f.y(this.f15032a);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15033a;

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
            this.f15033a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || this.f15033a.f15027e == null) {
                return;
            }
            this.f15033a.f15027e.y(emotionPackageData);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15034a;

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
            this.f15034a = emotionRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (this.f15034a.f15027e != null) {
                        this.f15034a.f15027e.o();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (this.f15034a.f15027e != null) {
                        this.f15034a.f15027e.o();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (this.f15034a.f15027e != null) {
                        this.f15034a.f15027e.o();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (this.f15034a.f15027e != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.J(this.f15034a.getActivity(), str);
                        } else {
                            l.J(this.f15034a.getActivity(), this.f15034a.getString(R.string.emotion_error_default_net_tip));
                        }
                        this.f15034a.f15027e.x();
                    }
                } else {
                    BdToast.c(this.f15034a.getPageContext().getPageActivity(), this.f15034a.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                    if (this.f15034a.f15027e != null) {
                        this.f15034a.f15027e.o();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15035e;

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
            this.f15035e = emotionRecommendFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f15035e.f15028f != null && !this.f15035e.f15031i) {
                    this.f15035e.f15028f.y(this.f15035e);
                }
                this.f15035e.f15027e.k().d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionRecommendFragment f15036e;

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
            this.f15036e = emotionRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15036e.f15028f == null || this.f15036e.f15031i) {
                return;
            }
            if (this.f15036e.f15030h) {
                this.f15036e.f15027e.t();
                this.f15036e.f15028f.x(this.f15036e);
                return;
            }
            this.f15036e.f15027e.v();
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
        this.f15028f = null;
        this.f15029g = true;
        this.f15030h = false;
        this.f15031i = false;
        this.j = false;
        this.k = new a(this, 2000994);
        this.l = new b(this, 2921059);
        this.m = new c(this, 2921040);
        this.n = new d(this);
        this.o = new e(this);
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.a.s0.c2.g.e.l().r()) {
                d.a.s0.p0.y.e.a aVar = this.f15027e;
                if (aVar != null) {
                    aVar.s();
                    return;
                }
                return;
            }
            d.a.s0.p0.y.e.a aVar2 = this.f15027e;
            if (aVar2 != null) {
                aVar2.o();
            }
        }
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.s0.p0.y.e.a aVar = this.f15027e;
            if (aVar != null) {
                return aVar.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.s0.p0.y.d.b
    public void U(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) == null) {
            this.f15031i = false;
            this.f15027e.l();
            if (emotionCenterData == null) {
                return;
            }
            this.f15027e.c(emotionCenterData);
        }
    }

    @Override // d.a.s0.p0.y.d.b
    public void c0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emotionCenterData) == null) {
        }
    }

    @Override // d.a.s0.p0.y.d.b
    public void j0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionCenterData) == null) {
            this.f15031i = false;
            this.f15027e.d();
            this.f15027e.l();
            if (emotionCenterData == null) {
                return;
            }
            if (!"1".equals(emotionCenterData.has_more)) {
                this.f15030h = false;
            } else {
                this.f15030h = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
            }
            this.f15027e.p(emotionCenterData);
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
            d.a.s0.p0.y.e.a aVar = this.f15027e;
            if (aVar != null) {
                aVar.n(i2);
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
            d.a.s0.p0.y.e.a aVar = new d.a.s0.p0.y.e.a(getPageContext(), getUniqueId());
            this.f15027e = aVar;
            aVar.q(this.n);
            this.f15027e.r(this.o);
            registerListener(this.k);
            registerListener(this.l);
            if (this.f15028f == null) {
                this.f15028f = new EmotionCenterModel(getPageContext());
            }
            registerListener(this.m);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.j = arguments.getBoolean("need_check_login");
            }
            if (!this.j) {
                if (this.f15029g && (emotionCenterModel2 = this.f15028f) != null) {
                    emotionCenterModel2.y(this);
                    this.f15031i = true;
                    this.f15029g = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f15029g && (emotionCenterModel = this.f15028f) != null) {
                    emotionCenterModel.y(this);
                    this.f15031i = true;
                    this.f15029g = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.f15027e.j();
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
            K0();
        }
    }
}
