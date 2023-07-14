package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ln> a;
    public BdTypeListView b;
    public cg7 c;
    public eg7 d;

    public gg7(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = bdTypeListView;
        arrayList.add(new yf7(baseActivity.getPageContext(), zf7.d));
        this.a.add(new ag7(baseActivity.getPageContext(), bg7.c));
        this.a.add(new xf7(baseActivity.getPageContext(), bi7.c));
        this.a.add(new of7(baseActivity.getPageContext(), pf7.b));
        this.a.add(new qf7(baseActivity.getPageContext(), rf7.g));
        this.a.add(new sf7(baseActivity.getPageContext()));
        cg7 cg7Var = new cg7(baseActivity.getPageContext(), dg7.e);
        this.c = cg7Var;
        this.a.add(cg7Var);
        eg7 eg7Var = new eg7(baseActivity.getPageContext(), fg7.d);
        this.d = eg7Var;
        this.a.add(eg7Var);
    }

    public List<ln> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof pn)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.onDestroy();
            this.d.onDestroy();
        }
    }
}
