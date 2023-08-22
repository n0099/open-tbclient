package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.bu7;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class du7 implements xt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public bu7.e b;
    public List<wi7> c;
    public View d;
    public View e;
    public TabMenuPopView f;
    public bu7 g;
    public TabMenuPopView.c h;

    /* loaded from: classes5.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du7 a;

        public a(du7 du7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du7Var;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, wi7 wi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, wi7Var) == null) {
                if (this.a.g != null) {
                    this.a.g.c();
                }
                this.a.b.a(wi7Var.b);
            }
        }
    }

    public du7() {
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
        this.h = new a(this);
    }

    @Override // com.baidu.tieba.xt7
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xt7
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xt7
    public void a(Context context, bu7 bu7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, bu7Var) == null) && context != null && bu7Var != null) {
            this.a = context;
            this.g = bu7Var;
            this.b = bu7Var.d();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d094e, (ViewGroup) null);
            this.d = inflate;
            this.e = inflate.findViewById(R.id.top_line);
            TabMenuPopView tabMenuPopView = (TabMenuPopView) this.d.findViewById(R.id.obfuscated_res_0x7f09065c);
            this.f = tabMenuPopView;
            tabMenuPopView.setOnItemClickCallBack(this.h);
        }
    }

    @Override // com.baidu.tieba.xt7
    public void setData(List<wi7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        this.c = list;
        wi7 wi7Var = new wi7();
        wi7Var.b = 0;
        wi7Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f029d);
        wi7Var.c = false;
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.f.setData(this.c, wi7Var);
    }
}
