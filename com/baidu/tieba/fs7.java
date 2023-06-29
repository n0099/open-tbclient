package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class fs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AdvancedAdSlideLoadingLayout b;
    public AppBarLayout c;
    public BdTypeRecyclerView d;
    public cf7 e;
    public String f;
    public List<String> g;
    public int h;
    public boolean i;
    public eb5 j;
    public db5 k;
    public cb5 l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a implements eb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.eb5
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public a(fs7 fs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements db5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs7 a;

        @Override // com.baidu.tieba.db5
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(fs7 fs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs7Var;
        }

        @Override // com.baidu.tieba.db5
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
                this.a.i = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements cb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs7 a;

        @Override // com.baidu.tieba.cb5
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.cb5
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.baidu.tieba.cb5
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        public c(fs7 fs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs7Var;
        }

        @Override // com.baidu.tieba.cb5
        public void d(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                if (this.a.e != null) {
                    this.a.e.m0();
                }
                if (this.a.i) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 2));
                }
                this.a.i = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs7 a;

        public d(fs7 fs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(fs7 fs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public fs7(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = "999999";
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.a = frsFragment;
        View R3 = frsFragment.R3();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) R3.findViewById(R.id.obfuscated_res_0x7f090c63);
        this.b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.j);
        this.b.j(this.k);
        this.b.i(this.l);
        this.b.n();
        this.c = (AppBarLayout) R3.findViewById(R.id.obfuscated_res_0x7f090c3c);
        this.d = (BdTypeRecyclerView) R3.findViewById(R.id.obfuscated_res_0x7f090cfd);
    }

    public void f(o15 o15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o15Var) == null) {
            if (o15Var != null && !wi.isEmpty(o15Var.b) && !wi.isEmpty(o15Var.a) && o15Var.c >= 0) {
                if (this.b.v()) {
                    this.b.o();
                }
                this.b.X(o15Var, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.b.setAdvancedAdStyle(true);
                this.b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.b.setAdvancedAdStyle(false);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h = i;
        }
    }

    public void r(cf7 cf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cf7Var) == null) {
            this.e = cf7Var;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b.setEnableSlideLoading(z);
        }
    }

    public void u(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.setEnable(z);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.b.getData() != null && this.b.b0()) {
                o15 data = this.b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f;
                }
                String str = currentAccount + data.i;
                List<String> list = (List) new Gson().fromJson(r95.p().w("key_uid_adid", ""), new e(this).getType());
                this.g = list;
                if (list == null) {
                    this.g = new ArrayList();
                }
                Iterator<String> it = this.g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(r95.p().r(next, 0L))) {
                        r95.p().Q(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(r95.p().r(str, 0L))) {
                    this.g.add(str);
                    r95.p().H(str, System.currentTimeMillis());
                    z = true;
                }
                r95.p().J("key_uid_adid", this.g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.a.R3().findViewById(R.id.obfuscated_res_0x7f090ee0);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090edf);
            tbImageView.setPlaceHolder(2);
            TbVideoView tbVideoView = (TbVideoView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f09286e);
            TbImageView tbImageView2 = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092868);
            View findViewById2 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f09286d);
            View findViewById3 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090efc);
            if (findViewById == null) {
                return;
            }
            this.b.setBgView(findViewById);
            this.b.l(tbImageView2);
            this.b.l(tbVideoView);
            this.b.l(findViewById2);
            int F3 = this.a.F3();
            if (findViewById3.getVisibility() == 0) {
                F3 -= this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            }
            if (F3 <= 0) {
                F3 = findViewById.getLayoutParams().height;
            }
            this.b.setAdvancedAdView(tbImageView, F3, xi.l(this.a.getContext()));
        }
    }

    public void h() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null) {
            advancedAdSlideLoadingLayout.Z();
        }
    }

    public cf7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (cf7) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.getLoadingVewMaxHeight();
        }
        return invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.v();
        }
        return invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.m(this.a.R3().findViewById(R.id.obfuscated_res_0x7f090ca5), 0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.o();
            yg.a().removeCallbacks(this.m);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            this.b.e0();
        }
    }

    public void w() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (advancedAdSlideLoadingLayout = this.b) != null && advancedAdSlideLoadingLayout.u()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            this.b.H();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.b.v()) {
            this.b.o();
            yg.a().removeCallbacks(this.m);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yg.a().postDelayed(this.m, 5000L);
            cf7 cf7Var = this.e;
            if (cf7Var != null) {
                cf7Var.k1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public void t(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || i != this.h) {
            return;
        }
        if (z) {
            w();
            return;
        }
        this.d.getAdapter().notifyDataSetChanged();
        x();
    }
}
