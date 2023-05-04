package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.rp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bq5 extends wp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rp5.c a;
    public TbPageContext b;
    public BdRecyclerView c;
    public PbListView d;

    public bq5(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, rp5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdRecyclerView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = bdRecyclerView;
        this.a = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.d = pbListView;
        pbListView.c();
        this.d.r(R.color.transparent);
        this.d.v(this.a.a);
        this.d.N(this.a.b);
        this.d.A();
        this.d.J(R.dimen.tbfontsize33);
        this.d.H(SkinManager.getColor(R.color.CAM_X0107));
        this.d.D(R.color.CAM_X0110);
        this.d.u();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.b.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wp5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // com.baidu.tieba.wp5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(this.d);
            this.d.S();
            this.d.F(this.a.c);
            this.d.E(null);
        }
    }

    @Override // com.baidu.tieba.wp5
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.F(this.a.e);
            this.d.E(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.F(this.a.d);
            this.d.E(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.F(this.a.f);
            this.d.E(this.a.h);
        }
    }

    @Override // com.baidu.tieba.zp5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.e(i);
        }
    }
}
