package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.tieba.yp5;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class aq5 extends p9<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;
    public View b;
    public NavigationBar c;
    public ImageView d;
    public BdListView e;
    public yp5 f;
    public zx4 g;
    public NoDataView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq5(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = newFriendsActivity;
        this.b = newFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091688);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0925c5);
        this.c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c5e));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0079, this.a).findViewById(R.id.obfuscated_res_0x7f09168a);
        this.d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a25, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.e = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091689);
        yp5 yp5Var = new yp5(this.a);
        this.f = yp5Var;
        this.e.setAdapter((ListAdapter) yp5Var);
        this.e.setOnItemClickListener(this.a);
        this.e.setOnItemLongClickListener(this.a);
        zx4 zx4Var = new zx4(newFriendsActivity.getPageContext());
        this.g = zx4Var;
        this.e.setPullRefresh(zx4Var);
        BdListViewHelper.d(this.a.getActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        this.h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07029e)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c98), null);
    }

    public void j(yp4 yp4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, yp4Var, i) == null) {
            yp4Var.l(i == 1);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.g.H(i);
            yp4Var.k(this.b);
            this.h.f(this.a.getPageContext(), i);
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a25, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.A(0L);
        }
    }

    public yp5 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (yp5) invokeV.objValue;
    }

    public void m(h97 h97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h97Var) == null) {
            this.f.d(h97Var);
            this.f.notifyDataSetChanged();
        }
    }

    public void n(List<h97> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.e.setEmptyView(this.h);
            this.f.e(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void o(yx4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.g.f(gVar);
        }
    }

    public void p(yp5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f.f(cVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.F();
        }
    }

    public void r(List<h97> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f.h(list);
            this.f.notifyDataSetChanged();
        }
    }
}
