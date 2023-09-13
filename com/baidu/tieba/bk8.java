package com.baidu.tieba;

import android.text.InputFilter;
import android.text.Spanned;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk8 implements InputFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public int b;

    public bk8(@NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int length = this.b - (spanned.length() - (i4 - i3));
            int i5 = i2 - i;
            if (length < i5) {
                new BdTopToast(this.a.getContext(), 3000).setIcon(false).setContent(this.a.getString(R.string.obfuscated_res_0x7f0f0119)).show((ViewGroup) this.a.getPageActivity().getWindow().getDecorView().findViewById(16908290));
            }
            if (length <= 0) {
                return "";
            }
            if (length >= i5) {
                return null;
            }
            return charSequence.subSequence(i, length + i);
        }
        return (CharSequence) invokeCommon.objValue;
    }
}
