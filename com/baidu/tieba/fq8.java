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
import com.baidu.tieba.os5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class fq8 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public SimpleDragSortListView b;
    public View c;
    public zp8 d;
    public dq8 e;
    public og5 f;
    public FrameLayout g;
    public boolean h;
    public xp8 i;
    public NoDataView j;
    public NoNetworkView k;

    /* loaded from: classes4.dex */
    public class a implements os5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq8 a;

        public a(fq8 fq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fq8Var;
        }

        @Override // com.baidu.tieba.os5.i
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.d.a(i, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ fq8 b;

        public b(fq8 fq8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fq8Var;
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

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq8 a;

        public c(fq8 fq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.update();
            }
        }
    }

    public fq8(TbPageContext tbPageContext) {
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
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02fb, (ViewGroup) null, false);
        this.c = inflate;
        this.g = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091740);
        this.k = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.e = new dq8(this.c.findViewById(R.id.obfuscated_res_0x7f090985), tbPageContext.getString(R.string.obfuscated_res_0x7f0f058d));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.c.findViewById(R.id.obfuscated_res_0x7f09173f);
        this.b = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        k();
        this.d = new zp8(tbPageContext, this.b, this.i);
        l();
        this.k.a(this);
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && z) {
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

    public void d() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null && (frameLayout = this.g) != null) {
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
            jg.a().post(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d();
            f();
        }
    }

    public final void j() {
        SimpleDragSortListView simpleDragSortListView;
        dq8 dq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (simpleDragSortListView = this.b) != null && !this.h && (dq8Var = this.e) != null) {
            this.h = true;
            simpleDragSortListView.setEmptyView(dq8Var.a());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            xp8 xp8Var = new xp8(this.b);
            this.i = xp8Var;
            xp8Var.c(new a(this));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            dq8 dq8Var = this.e;
            if (dq8Var != null) {
                dq8Var.b(i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
            dq8 dq8Var2 = this.e;
            if (dq8Var2 != null) {
                SkinManager.setBackgroundColor(dq8Var2.a(), R.color.CAM_X0201, i);
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
            og5 og5Var = new og5(this.a.getPageActivity());
            this.f = og5Var;
            og5Var.attachView(this.g, true);
            this.f.onChangeSkinType();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a != null && this.g != null) {
            i();
            this.g.setVisibility(0);
            NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, ii.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070237)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0590)), null, true);
            this.j = b2;
            b2.setVisibility(0);
            this.j.d(this.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            jg.a().post(new b(this, list));
        }
    }
}
