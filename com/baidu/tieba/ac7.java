package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ac7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yb7 a;

    public ac7(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new wb7(tbPageContext, fc7.d, tbPageContext.getUniqueId()));
        yb7 yb7Var = new yb7(tbPageContext, gc7.h, tbPageContext.getUniqueId());
        this.a = yb7Var;
        arrayList.add(yb7Var);
        arrayList.add(new xb7(tbPageContext, fc7.c, tbPageContext.getUniqueId()));
        arrayList.add(new zb7(tbPageContext, fc7.e, tbPageContext.getUniqueId()));
        bdTypeListView.addAdapters(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.u(onClickListener);
        }
    }
}
