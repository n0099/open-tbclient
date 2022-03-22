package com.baidu.tieba.faceshop.forumpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
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
/* loaded from: classes5.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a1.z.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public ForumEmotionModel f32131b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32132c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32133d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32134e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a1.z.a.c f32135f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f32136g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f32137h;
    public final c.a.p0.a1.z.a.a i;
    public f.g j;
    public BdListView.p k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumEmotionFragment forumEmotionFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, Integer.valueOf(i)};
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
            this.a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !l.z() || this.a.f32131b == null || this.a.a == null || this.a.a.c() == null || this.a.a.c().getVisibility() != 0) {
                return;
            }
            this.a.f32131b.C(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumEmotionFragment forumEmotionFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, Integer.valueOf(i)};
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
            this.a = forumEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ForumEmotionPackageData) || (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) == null || this.a.f32135f == null) {
                return;
            }
            this.a.f32135f.g(forumEmotionPackageData);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.p0.a1.z.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionFragment a;

        public c(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumEmotionFragment;
        }

        @Override // c.a.p0.a1.z.a.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.f32135f.d();
                this.a.f32131b.C(this.a);
            }
        }

        @Override // c.a.p0.a1.z.a.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f32135f.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionFragment a;

        public d(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumEmotionFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f32131b == null || this.a.f32133d) {
                return;
            }
            this.a.f32131b.C(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionFragment a;

        public e(ForumEmotionFragment forumEmotionFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumEmotionFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f32131b == null || this.a.f32133d) {
                return;
            }
            if (this.a.f32131b.hasMore()) {
                this.a.a.p();
                this.a.f32131b.B(this.a);
                return;
            }
            this.a.a.s();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionFragment f32138b;

        public f(ForumEmotionFragment forumEmotionFragment, ForumEmotionData forumEmotionData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionFragment, forumEmotionData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32138b = forumEmotionFragment;
            this.a = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f32138b.getPageContext(), new String[]{this.a.activity_url});
        }
    }

    public ForumEmotionFragment() {
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
        this.f32131b = null;
        this.f32132c = true;
        this.f32133d = false;
        this.f32134e = false;
        this.f32136g = new a(this, 2000994);
        this.f32137h = new b(this, 2921059);
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void P(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionData) == null) {
            this.f32133d = false;
            this.a.f();
            this.a.h();
            if (forumEmotionData == null) {
                return;
            }
            if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    c.a.p0.a1.z.b.c cVar = new c.a.p0.a1.z.b.c();
                    cVar.a = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.f32135f.a(arrayList);
            }
            this.f32135f.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.p0.a1.z.c.a aVar = this.a;
            if (aVar != null) {
                aVar.l(i);
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
            c.a.p0.a1.z.c.a aVar = new c.a.p0.a1.z.c.a(getPageContext(), getUniqueId());
            this.a = aVar;
            aVar.n(this.j);
            this.a.o(this.k);
            registerListener(this.f32136g);
            registerListener(this.f32137h);
            if (this.f32131b == null) {
                this.f32131b = new ForumEmotionModel(getPageContext());
            }
            c.a.p0.a1.z.a.c cVar = new c.a.p0.a1.z.a.c(getPageContext(), this.a.b(), this.f32131b);
            this.f32135f = cVar;
            cVar.f(this.i);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f32134e = arguments.getBoolean("need_check_login");
            }
            if (!this.f32134e) {
                if (this.f32132c && (forumEmotionModel2 = this.f32131b) != null) {
                    forumEmotionModel2.C(this);
                    this.f32133d = true;
                    this.f32132c = false;
                }
            } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                if (this.f32132c && (forumEmotionModel = this.f32131b) != null) {
                    forumEmotionModel.C(this);
                    this.f32133d = true;
                    this.f32132c = false;
                }
            } else {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                getPageContext().getPageActivity().finish();
            }
            return this.a.d();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f32133d = false;
            this.a.a();
            this.a.g();
            c.a.p0.a1.z.a.c cVar = this.f32135f;
            if (cVar != null && cVar.b() > 0) {
                n.N(getPageContext().getContext(), str);
            } else {
                this.a.r();
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
    public void t0(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumEmotionData) == null) {
            this.f32133d = false;
            this.a.a();
            this.a.f();
            this.a.g();
            this.a.h();
            if (forumEmotionData == null) {
                return;
            }
            this.a.m(forumEmotionData);
            this.a.e().setOnClickListener(new f(this, forumEmotionData));
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    c.a.p0.a1.z.b.c cVar = new c.a.p0.a1.z.b.c();
                    cVar.a = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new c.a.p0.a1.z.b.a());
                }
                this.f32135f.e(arrayList);
            }
            this.f32135f.d();
        }
    }
}
