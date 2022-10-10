package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fp extends s55 {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448304675, "Lcom/baidu/tieba/fp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448304675, "Lcom/baidu/tieba/fp;");
                return;
            }
        }
        t = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp(Context context) {
        super(context, (String) null, 6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f135e);
        this.d = R.drawable.obfuscated_res_0x7f0809d5;
        this.f = R.color.CAM_X0105;
        this.i = false;
        this.j = true;
        this.o = true;
        this.n = 5;
        this.m = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        int i3 = t;
        ((LinearLayout.LayoutParams) layoutParams).topMargin = i3;
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i3;
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        ((View) this.m).setLayoutParams(layoutParams);
        this.p = new int[0];
    }
}
