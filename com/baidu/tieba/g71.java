package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g71 extends e71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt
    public int p;
    public CharSequence q;
    public int r;
    public float s;

    public g71() {
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
        this.p = -1;
        this.r = -1;
        this.s = -1.0f;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.p;
            return i != -1 ? i : g61.a().getResources().getColor(R.color.obfuscated_res_0x7f06032f);
        }
        return invokeV.intValue;
    }

    public void C(CharSequence charSequence, int i, int i2, float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) || (textView = this.e) == null) {
            return;
        }
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        this.e.setTextColor(i);
        if (i2 < 0 || f <= 0.0f) {
            return;
        }
        this.e.setTextSize(i2, f);
    }

    public void D(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                Log.d("BubbleTextManager", "str is empty !!!, will show nothing !!!");
            }
            this.q = charSequence;
        }
    }

    public void E(@ColorInt int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.p = i;
        }
    }

    @Override // com.baidu.tieba.e71
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d05e2 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.e71
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (super.g()) {
                int B = B();
                TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09047d);
                this.e = textView;
                textView.setTextColor(B);
                this.e.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e71
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.q) && super.h() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e71
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.n();
            this.q = null;
        }
    }
}
