package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gk5 extends ui5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yj5 a;

    @Override // com.baidu.tieba.ui5
    public void c(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wi5Var) == null) {
        }
    }

    public gk5(yj5 yj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yj5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yj5Var;
    }

    @Override // com.baidu.tieba.ui5
    public wi5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(6);
            editorTools.setBackgroundColorId(R.color.CAM_X0602);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setMoreDeskBgColorId(R.color.CAM_X0206);
            editorTools.G(false);
            return new fk5(editorTools);
        }
        return (wi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ui5
    public void d(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wi5Var) == null) {
            EditorTools a = wi5Var.a();
            a.setHideBigEmotion(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a.h(arrayList);
            a.d(new hk5(a.getContext(), this.a));
            ej5 p = a.p(5);
            p.d = 0;
            p.e(false);
            a.setClearEbPadding(true);
            a.f();
        }
    }
}
