package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
/* loaded from: classes3.dex */
public class PbNewLocationInfoView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbNewLocationInfoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public void setState(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            this.a = i;
            if (i == 1) {
                if (str == null) {
                    str = getResources().getString(R.string.obfuscated_res_0x7f0f0a51);
                }
                setText(str);
            } else if (i == 2) {
                if (str == null) {
                    str = getResources().getString(R.string.obfuscated_res_0x7f0f0a4e);
                }
                setText(str);
            } else {
                if (str == null) {
                    str = getResources().getString(R.string.obfuscated_res_0x7f0f0a4e);
                }
                setText(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNewLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setMaxEms(8);
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextSize(0, li.f(context, R.dimen.obfuscated_res_0x7f0701e8));
        setState(0, null);
    }
}
