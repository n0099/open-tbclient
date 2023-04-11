package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class hq8 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdListView b;
    public aq8 c;
    public dq8 d;
    public View e;
    public og5 f;
    public FrameLayout g;
    public NoDataView h;
    public boolean i;
    public NoNetworkView j;

    public hq8(TbPageContext tbPageContext) {
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
        this.i = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0305, (ViewGroup) null, false);
        this.e = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.j = noNetworkView;
        noNetworkView.a(this);
        this.g = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0920b8);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f090991);
        this.d = new dq8(this.e.findViewById(R.id.obfuscated_res_0x7f090990), tbPageContext.getString(R.string.obfuscated_res_0x7f0f058e));
        this.b.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        this.c = new aq8(tbPageContext, this.b);
        h();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null && (frameLayout = this.g) != null) {
            frameLayout.setVisibility(8);
            this.f.dettachView(this.g);
            this.f = null;
        }
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.h) != null && noDataView.getParent() == this.g) {
            this.h.setVisibility(8);
            this.g.removeView(this.h);
            this.g.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b();
            c();
        }
    }

    public final void g() {
        BdListView bdListView;
        dq8 dq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bdListView = this.b) != null && !this.i && (dq8Var = this.d) != null) {
            this.i = true;
            bdListView.setEmptyView(dq8Var.a());
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            View view2 = this.e;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            BdListView bdListView = this.b;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i);
            }
            dq8 dq8Var = this.d;
            if (dq8Var != null) {
                dq8Var.b(i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && z) {
            h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a != null && this.g != null) {
            f();
            this.g.setVisibility(0);
            if (this.f == null) {
                this.f = new og5(this.a.getPageActivity());
            }
            this.f.attachView(this.g, true);
            this.f.onChangeSkinType();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a != null && this.g != null) {
            f();
            this.g.setVisibility(0);
            NoDataView b = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, ii.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070237)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0590)), null, true);
            this.h = b;
            b.setVisibility(0);
            this.h.d(this.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        aq8 aq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            g();
            if (list != null && (aq8Var = this.c) != null) {
                aq8Var.update(list);
            }
        }
    }
}
