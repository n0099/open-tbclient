package com.baidu.tieba.faceshop.forumpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NEED_CHECK_LOGIN = "need_check_login";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.s0.y.c.a f48942e;

    /* renamed from: f  reason: collision with root package name */
    public ForumEmotionModel f48943f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48944g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48945h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48946i;
    public b.a.r0.s0.y.a.c j;
    public final CustomMessageListener k;
    public CustomMessageListener l;
    public final b.a.r0.s0.y.a.a m;
    public f.g n;
    public BdListView.p o;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48947a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumEmotionFragment forumEmotionFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, Integer.valueOf(i2)};
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
            this.f48947a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || this.f48947a.f48943f == null || this.f48947a.f48942e == null || this.f48947a.f48942e.c() == null || this.f48947a.f48942e.c().getVisibility() != 0) {
                return;
            }
            this.f48947a.f48943f.B(this.f48947a);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48948a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumEmotionFragment forumEmotionFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, Integer.valueOf(i2)};
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
            this.f48948a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ForumEmotionPackageData) || (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) == null || this.f48948a.j == null) {
                return;
            }
            this.f48948a.j.g(forumEmotionPackageData);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.a.r0.s0.y.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48949a;

        public c(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48949a = forumEmotionFragment;
        }

        @Override // b.a.r0.s0.y.a.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f48949a.j.d();
                this.f48949a.f48943f.B(this.f48949a);
            }
        }

        @Override // b.a.r0.s0.y.a.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f48949a.j.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48950e;

        public d(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48950e = forumEmotionFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f48950e.f48943f == null || this.f48950e.f48945h) {
                return;
            }
            this.f48950e.f48943f.B(this.f48950e);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48951e;

        public e(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48951e = forumEmotionFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48951e.f48943f == null || this.f48951e.f48945h) {
                return;
            }
            if (this.f48951e.f48943f.z()) {
                this.f48951e.f48942e.p();
                this.f48951e.f48943f.A(this.f48951e);
                return;
            }
            this.f48951e.f48942e.s();
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionData f48952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f48953f;

        public f(ForumEmotionFragment forumEmotionFragment, ForumEmotionData forumEmotionData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, forumEmotionData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48953f = forumEmotionFragment;
            this.f48952e = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f48952e.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f48953f.getPageContext(), new String[]{this.f48952e.activity_url});
        }
    }

    public ForumEmotionFragment() {
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
        this.f48943f = null;
        this.f48944g = true;
        this.f48945h = false;
        this.f48946i = false;
        this.k = new a(this, 2000994);
        this.l = new b(this, 2921059);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.s0.y.c.a aVar = this.f48942e;
            if (aVar != null) {
                aVar.l(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ForumEmotionModel forumEmotionModel;
        ForumEmotionModel forumEmotionModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.r0.s0.y.c.a aVar = new b.a.r0.s0.y.c.a(getPageContext(), getUniqueId());
            this.f48942e = aVar;
            aVar.n(this.n);
            this.f48942e.o(this.o);
            registerListener(this.k);
            registerListener(this.l);
            if (this.f48943f == null) {
                this.f48943f = new ForumEmotionModel(getPageContext());
            }
            b.a.r0.s0.y.a.c cVar = new b.a.r0.s0.y.a.c(getPageContext(), this.f48942e.b(), this.f48943f);
            this.j = cVar;
            cVar.f(this.m);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f48946i = arguments.getBoolean("need_check_login");
            }
            if (!this.f48946i) {
                if (this.f48944g && (forumEmotionModel2 = this.f48943f) != null) {
                    forumEmotionModel2.B(this);
                    this.f48945h = true;
                    this.f48944g = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f48944g && (forumEmotionModel = this.f48943f) != null) {
                    forumEmotionModel.B(this);
                    this.f48945h = true;
                    this.f48944g = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.f48942e.d();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f48945h = false;
            this.f48942e.a();
            this.f48942e.g();
            b.a.r0.s0.y.a.c cVar = this.j;
            if (cVar != null && cVar.b() > 0) {
                l.M(getPageContext().getContext(), str);
            } else {
                this.f48942e.r();
            }
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onLoadMoreSuccess(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumEmotionData) == null) {
            this.f48945h = false;
            this.f48942e.f();
            this.f48942e.h();
            if (forumEmotionData == null) {
                return;
            }
            if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    b.a.r0.s0.y.b.c cVar = new b.a.r0.s0.y.b.c();
                    cVar.f24810e = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.j.a(arrayList);
            }
            this.j.d();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onRefreshSuccess(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumEmotionData) == null) {
            this.f48945h = false;
            this.f48942e.a();
            this.f48942e.f();
            this.f48942e.g();
            this.f48942e.h();
            if (forumEmotionData == null) {
                return;
            }
            this.f48942e.m(forumEmotionData);
            this.f48942e.e().setOnClickListener(new f(this, forumEmotionData));
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    b.a.r0.s0.y.b.c cVar = new b.a.r0.s0.y.b.c();
                    cVar.f24810e = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new b.a.r0.s0.y.b.a());
                }
                this.j.e(arrayList);
            }
            this.j.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
        }
    }
}
