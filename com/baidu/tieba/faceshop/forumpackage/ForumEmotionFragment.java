package com.baidu.tieba.faceshop.forumpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.p0.z.c.a f15093e;

    /* renamed from: f  reason: collision with root package name */
    public ForumEmotionModel f15094f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15095g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15096h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15097i;
    public d.a.s0.p0.z.a.c j;
    public final CustomMessageListener k;
    public CustomMessageListener l;
    public final d.a.s0.p0.z.a.a m;
    public f.g n;
    public BdListView.p o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15098a;

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
            this.f15098a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || this.f15098a.f15094f == null || this.f15098a.f15093e == null || this.f15098a.f15093e.c() == null || this.f15098a.f15093e.c().getVisibility() != 0) {
                return;
            }
            this.f15098a.f15094f.B(this.f15098a);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15099a;

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
            this.f15099a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ForumEmotionPackageData) || (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) == null || this.f15099a.j == null) {
                return;
            }
            this.f15099a.j.g(forumEmotionPackageData);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.s0.p0.z.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15100a;

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
            this.f15100a = forumEmotionFragment;
        }

        @Override // d.a.s0.p0.z.a.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f15100a.j.d();
                this.f15100a.f15094f.B(this.f15100a);
            }
        }

        @Override // d.a.s0.p0.z.a.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f15100a.j.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15101e;

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
            this.f15101e = forumEmotionFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f15101e.f15094f == null || this.f15101e.f15096h) {
                return;
            }
            this.f15101e.f15094f.B(this.f15101e);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15102e;

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
            this.f15102e = forumEmotionFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15102e.f15094f == null || this.f15102e.f15096h) {
                return;
            }
            if (this.f15102e.f15094f.z()) {
                this.f15102e.f15093e.p();
                this.f15102e.f15094f.A(this.f15102e);
                return;
            }
            this.f15102e.f15093e.s();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionData f15103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f15104f;

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
            this.f15104f = forumEmotionFragment;
            this.f15103e = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f15103e.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f15104f.getPageContext(), new String[]{this.f15103e.activity_url});
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
        this.f15094f = null;
        this.f15095g = true;
        this.f15096h = false;
        this.f15097i = false;
        this.k = new a(this, 2000994);
        this.l = new b(this, 2921059);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void T(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionData) == null) {
            this.f15096h = false;
            this.f15093e.f();
            this.f15093e.h();
            if (forumEmotionData == null) {
                return;
            }
            if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    d.a.s0.p0.z.b.c cVar = new d.a.s0.p0.z.b.c();
                    cVar.f64604e = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.j.a(arrayList);
            }
            this.j.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.p0.z.c.a aVar = this.f15093e;
            if (aVar != null) {
                aVar.l(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ForumEmotionModel forumEmotionModel;
        ForumEmotionModel forumEmotionModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            d.a.s0.p0.z.c.a aVar = new d.a.s0.p0.z.c.a(getPageContext(), getUniqueId());
            this.f15093e = aVar;
            aVar.n(this.n);
            this.f15093e.o(this.o);
            registerListener(this.k);
            registerListener(this.l);
            if (this.f15094f == null) {
                this.f15094f = new ForumEmotionModel(getPageContext());
            }
            d.a.s0.p0.z.a.c cVar = new d.a.s0.p0.z.a.c(getPageContext(), this.f15093e.b(), this.f15094f);
            this.j = cVar;
            cVar.f(this.m);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f15097i = arguments.getBoolean("need_check_login");
            }
            if (!this.f15097i) {
                if (this.f15095g && (forumEmotionModel2 = this.f15094f) != null) {
                    forumEmotionModel2.B(this);
                    this.f15096h = true;
                    this.f15095g = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f15095g && (forumEmotionModel = this.f15094f) != null) {
                    forumEmotionModel.B(this);
                    this.f15096h = true;
                    this.f15095g = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.f15093e.d();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f15096h = false;
            this.f15093e.a();
            this.f15093e.g();
            d.a.s0.p0.z.a.c cVar = this.j;
            if (cVar != null && cVar.b() > 0) {
                l.M(getPageContext().getContext(), str);
            } else {
                this.f15093e.r();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void y0(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumEmotionData) == null) {
            this.f15096h = false;
            this.f15093e.a();
            this.f15093e.f();
            this.f15093e.g();
            this.f15093e.h();
            if (forumEmotionData == null) {
                return;
            }
            this.f15093e.m(forumEmotionData);
            this.f15093e.e().setOnClickListener(new f(this, forumEmotionData));
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    d.a.s0.p0.z.b.c cVar = new d.a.s0.p0.z.b.c();
                    cVar.f64604e = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new d.a.s0.p0.z.b.a());
                }
                this.j.e(arrayList);
            }
            this.j.d();
        }
    }
}
