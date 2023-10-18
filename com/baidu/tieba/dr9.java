package com.baidu.tieba;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import tbclient.ThemeMyTab;
/* loaded from: classes5.dex */
public class dr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public int a;
    public TbPageContext b;
    public NoNetworkView c;
    public NavigationBar d;
    public BdTypeListView e;
    public gq9 f;
    public bsa g;
    public View h;
    public RelativeLayout i;
    public gi5 j;
    public g k;
    public nq9 l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int[] q;
    public View r;
    public TbImageView s;
    public View t;
    public SimpleDraweeView u;
    public BdUniqueId v;
    public boolean w;
    public AbsListView x;
    public AbsListView.OnScrollListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public interface g {
        void a(View view2);
    }

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }

        public a(dr9 dr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr9Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (this.a.x == null) {
                    this.a.x = absListView;
                }
                this.a.C(absListView);
                if (this.a.f != null) {
                    this.a.f.g();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dr9 dr9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var, Integer.valueOf(i)};
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
            this.a = dr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921739 && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() != -1) {
                this.a.e.setSelection(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dr9 dr9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var, Integer.valueOf(i)};
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
            this.a = dr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921750 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.w = true;
                    this.a.A();
                    return;
                }
                this.a.w = false;
                this.a.s.setVisibility(8);
                this.a.u.setVisibility(8);
                this.a.t.setVisibility(8);
                if (this.a.g != null && this.a.d != null && this.a.d.getBarBgView() != null && this.a.d.getBarBgView().getAlpha() != 1.0f) {
                    this.a.g.t(1.0f);
                    this.a.g.q(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(dr9 dr9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var, Integer.valueOf(i)};
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
            this.a = dr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921755 && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                dr9 dr9Var = this.a;
                dr9Var.C(dr9Var.x);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        public e(dr9 dr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dr9 dr9Var = this.a;
                dr9Var.m = dr9Var.d.getHeight();
                MessageManager.getInstance().registerStickyMode(2921749);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921749, Integer.valueOf(this.a.m)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr9 a;

        public f(dr9 dr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.r();
                if (this.a.k != null) {
                    this.a.k.a(view2);
                }
            }
        }
    }

    public dr9(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.n = -1;
        this.q = new int[2];
        this.y = new a(this);
        this.z = new b(this, 2921739);
        this.A = new c(this, 2921750);
        this.B = new d(this, 2921755);
        if (view2 == null) {
            return;
        }
        this.b = tbPageContext;
        this.v = bdUniqueId;
        this.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091bed);
        this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f091bec);
        this.s = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910ab);
        this.u = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0910ac);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f0910aa);
        this.i = (RelativeLayout) view2.findViewById(R.id.layout_container);
        this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f091bdc);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f07038f));
        View view3 = new View(tbPageContext.getPageActivity());
        this.h = view3;
        view3.setLayoutParams(layoutParams);
        this.e.addFooterView(this.h);
        this.e.setOnScrollListener(this.y);
        this.f = new gq9(this.e, tbPageContext, bdUniqueId);
        this.g = new bsa(this.b, 1);
    }

    public void D(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.k = gVar;
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.u.setVisibility(8);
            this.s.setVisibility(0);
            this.s.startLoad(str, 10, false);
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g.w(str);
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g.s(i);
            this.g.x(6, true);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.t.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, p(vca.f(str))));
    }

    public void I(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g.x(i, z);
        }
    }

    public final void A() {
        sq9 B;
        UserData userData;
        ThemeMyTab themeMyTab;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (B = this.l.B()) != null && (userData = B.a) != null && (themeMyTab = userData.themeMyTab) != null) {
            if (!TextUtils.isEmpty(themeMyTab.button_color)) {
                this.t.setVisibility(0);
                q(themeMyTab.button_color);
            }
            if (!TextUtils.isEmpty(themeMyTab.dynamic_url)) {
                this.s.setVisibility(8);
                this.u.setVisibility(0);
                Uri parse = Uri.parse(themeMyTab.dynamic_url);
                if (parse == null) {
                    E(themeMyTab.url);
                    return;
                }
                this.u.setController(Fresco.newDraweeControllerBuilder().setUri(parse).setAutoPlayAnimations(true).build());
                this.u.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            } else if (!TextUtils.isEmpty(themeMyTab.url)) {
                E(themeMyTab.url);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.g.r(this.b.getPageActivity(), this.d);
            this.g.n();
            this.g.u(null);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.post(new e(this));
            }
            v(TbadkCoreApplication.getInst().getSkinType());
            this.z.setTag(this.v);
            this.b.registerListener(this.z);
            this.A.setTag(this.v);
            this.b.registerListener(this.A);
            this.B.setTag(this.v);
            this.b.registerListener(this.B);
        }
    }

    public void B(nq9 nq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq9Var) == null) && nq9Var != null) {
            this.l = nq9Var;
            this.f.h(nq9Var.x());
            this.g.v(nq9Var.A());
            if (nq9Var.v() != null) {
                this.g.y(nq9Var.v().c());
            }
        }
    }

    public int[] p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? new int[]{Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)), Color.argb(255, Color.red(i), Color.green(i), Color.blue(i))} : (int[]) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(AbsListView absListView) {
        float f2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, absListView) == null) && absListView != null && this.w) {
            if ((this.n == -1 && this.l != null) || this.r == null) {
                int u = this.l.u();
                this.n = u;
                View childAt = absListView.getChildAt(u);
                this.r = childAt;
                if (childAt == null) {
                    return;
                }
                childAt.getLocationOnScreen(this.q);
                NavigationBar navigationBar2 = this.d;
                if (navigationBar2 != null) {
                    int height = navigationBar2.getHeight();
                    this.p = height;
                    this.o = this.q[1] - height;
                } else {
                    this.o = this.q[1];
                }
            }
            View view2 = this.r;
            if (view2 != null) {
                view2.getLocationOnScreen(this.q);
                int i = this.o;
                float f3 = 1.0f;
                if (i >= 0) {
                    int[] iArr = this.q;
                    if (iArr[1] >= 0) {
                        f2 = ((i - (iArr[1] - this.p)) / i) * 1.0f;
                        if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        if (f2 <= 1.0f) {
                            f3 = f2;
                        }
                        if (this.g == null && (navigationBar = this.d) != null && navigationBar.getBarBgView() != null) {
                            this.g.t(f3);
                            this.g.q(TbadkCoreApplication.getInst().getSkinType());
                            return;
                        }
                        return;
                    }
                }
                f2 = 1.0f;
                if (f2 < 0.0f) {
                }
                if (f2 <= 1.0f) {
                }
                if (this.g == null) {
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || t()) {
            return;
        }
        if (this.j == null) {
            this.j = new gi5(this.b.getPageActivity(), new f(this));
        }
        this.j.attachView(this.i, false);
        this.j.o();
        this.j.onChangeSkinType();
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (gi5Var = this.j) != null) {
            gi5Var.dettachView(this.i);
            this.j = null;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gi5 gi5Var = this.j;
            if (gi5Var != null) {
                return gi5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f.a();
        }
    }

    public void w() {
        gq9 gq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (gq9Var = this.f) != null) {
            gq9Var.c();
        }
    }

    public void x() {
        gq9 gq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (gq9Var = this.f) != null) {
            gq9Var.d();
        }
    }

    public void z() {
        gq9 gq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (gq9Var = this.f) != null) {
            gq9Var.f();
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && this.a != i) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            this.d.onChangeSkinType(this.b, i);
            SkinManager.setBackgroundColor(this.d.getBarBgView(), R.color.CAM_X0204, i);
            if (this.d.getBackground() != null && this.d.getBackground().mutate() != null) {
                this.d.getBackground().mutate().setAlpha(0);
            }
            if (this.d.getBarBgView() != null) {
                this.d.getBarBgView().setAlpha(1.0f);
            }
            this.g.p(i);
            this.f.b();
            this.c.onChangeSkinType(this.b, i);
            gi5 gi5Var = this.j;
            if (gi5Var != null) {
                gi5Var.onChangeSkinType();
            }
            this.a = i;
        }
    }

    public void y(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            gq9 gq9Var = this.f;
            if (gq9Var != null) {
                gq9Var.e(z);
            }
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_tip_is_show");
            boolean z2 = SharedPrefHelper.getInstance().getBoolean(sharedPrefKeyWithAccount, false);
            NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
            if (newGodData != null && newGodData.isNewGod() && z2 && this.l != null) {
                RelativeLayout relativeLayout = this.i;
                if (relativeLayout != null && this.d != null) {
                    i = (relativeLayout.getHeight() / 2) - this.d.getHeight();
                } else {
                    i = 0;
                }
                this.e.smoothScrollToPositionFromTop(this.l.w(), i);
                if (this.f != null) {
                    SharedPrefHelper.getInstance().putBoolean(sharedPrefKeyWithAccount, false);
                }
            }
        }
    }
}
