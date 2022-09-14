package com.baidu.tieba;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class az4 extends vy4<az4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;

    public az4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static az4 w(@NonNull az4 az4Var, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, az4Var, editable)) == null) {
            az4 az4Var2 = new az4();
            az4Var2.b(az4Var);
            az4Var2.p(editable);
            return az4Var2;
        }
        return (az4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vy4
    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i, i2, i3) == null) {
            super.a(editable, i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.vy4
    public void r(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append("[视频]");
            sb.append(this.i);
            sb.append("#");
            k(sb);
        }
    }

    @Override // com.baidu.tieba.vy4
    public void s(Editable editable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, editable, i) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append("[视频]");
            sb.append(this.i);
            sb.append("#");
            k(sb);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q(true);
            x();
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "#[视频]" + this.i + "#";
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k(u());
            if (ug5.g(this.c, f())) {
                return;
            }
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a45, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X001));
            eMRichTextAnyIconSpan.d(UtilHelper.getDimenPixelSize(R.dimen.M_W_X001));
            n(eMRichTextAnyIconSpan, f() + 1, f() + 1 + 4, 33);
            n(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f(), c(), 33);
        }
    }

    public az4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = str;
    }
}
