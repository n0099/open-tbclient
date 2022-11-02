package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.gk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class cu7 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public SimpleDragSortListView b;
    public View c;
    public wt7 d;
    public au7 e;
    public ca5 f;
    public FrameLayout g;
    public boolean h;
    public ut7 i;
    public NoDataView j;
    public NoNetworkView k;

    /* loaded from: classes3.dex */
    public class a implements gk5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu7 a;

        public a(cu7 cu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu7Var;
        }

        @Override // com.baidu.tieba.gk5.i
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.d.a(i, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ cu7 b;

        public b(cu7 cu7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cu7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.j();
                if (this.b.d != null && this.a != null) {
                    this.b.d.update(this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu7 a;

        public c(cu7 cu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.update();
            }
        }
    }

    public cu7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02df, (ViewGroup) null, false);
        this.c = inflate;
        this.g = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0915f5);
        this.k = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f092606);
        this.e = new au7(this.c.findViewById(R.id.obfuscated_res_0x7f0908e1), tbPageContext.getString(R.string.obfuscated_res_0x7f0f056d));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.c.findViewById(R.id.obfuscated_res_0x7f0915f4);
        this.b = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        k();
        this.d = new wt7(tbPageContext, this.b, this.i);
        l();
        this.k.a(this);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void e() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null && (frameLayout = this.g) != null) {
            frameLayout.setVisibility(8);
            this.f.dettachView(this.g);
            this.f = null;
        }
    }

    public final void f() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.j) != null && noDataView.getParent() == this.g) {
            this.j.setVisibility(8);
            this.g.removeView(this.j);
            this.g.setVisibility(8);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zg.a().post(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e();
            f();
        }
    }

    public final void j() {
        SimpleDragSortListView simpleDragSortListView;
        au7 au7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (simpleDragSortListView = this.b) != null && !this.h && (au7Var = this.e) != null) {
            this.h = true;
            simpleDragSortListView.setEmptyView(au7Var.a());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ut7 ut7Var = new ut7(this.b);
            this.i = ut7Var;
            ut7Var.c(new a(this));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            au7 au7Var = this.e;
            if (au7Var != null) {
                au7Var.b(i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
            au7 au7Var2 = this.e;
            if (au7Var2 != null) {
                SkinManager.setBackgroundColor(au7Var2.a(), R.color.CAM_X0201, i);
            }
            SimpleDragSortListView simpleDragSortListView = this.b;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i);
            }
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && this.g != null) {
            i();
            this.g.setVisibility(0);
            ca5 ca5Var = new ca5(this.a.getPageActivity());
            this.f = ca5Var;
            ca5Var.attachView(this.g, true);
            this.f.onChangeSkinType();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a != null && this.g != null) {
            i();
            this.g.setVisibility(0);
            NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, xi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070236)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0570)), null, true);
            this.j = b2;
            b2.setVisibility(0);
            this.j.d(this.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            zg.a().post(new b(this, list));
        }
    }
}
