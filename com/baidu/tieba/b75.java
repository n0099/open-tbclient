package com.baidu.tieba;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b75 extends x65<b75> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtSelectData i;

    public b75() {
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

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(true);
            u();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f(), c(), 33);
        }
    }

    public AtSelectData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (AtSelectData) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "@" + this.i.getNameShow() + " ";
        }
        return (String) invokeV.objValue;
    }

    public b75(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atSelectData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = atSelectData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x65
    /* renamed from: v */
    public void b(b75 b75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b75Var) == null) {
            super.b(b75Var);
            this.i = b75Var.i;
        }
    }

    public static b75 z(@NonNull b75 b75Var, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b75Var, editable)) == null) {
            b75 b75Var2 = new b75();
            b75Var2.b(b75Var);
            b75Var2.p(editable);
            return b75Var2;
        }
        return (b75) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.x65
    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i, i2, i3) == null) {
            super.a(editable, i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.x65
    public void r(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getUid());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            k(sb);
        }
    }

    @Override // com.baidu.tieba.x65
    public void s(Editable editable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, editable, i) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            k(sb);
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "#(at, " + this.i.getPortrait() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.i.getNameShow() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.i.getUid() + SmallTailInfo.EMOTION_SUFFIX + " ";
        }
        return (String) invokeV.objValue;
    }
}
