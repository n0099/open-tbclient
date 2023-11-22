package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ffc extends gfc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public edc m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ffc(mfc mfcVar) {
        super(mfcVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mfcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mfc) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = new edc(0.7f, 0.9f, 0.95f, 0.75f);
    }

    @Override // com.baidu.tieba.gfc
    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            super.a(str, str2, i, i2);
            GLES20.glUseProgram(this.a);
            this.l = GLES20.glGetUniformLocation(this.a, "u_frontArea");
            nfc.c("PipUniform", this.j);
            int i3 = this.l;
            edc edcVar = this.m;
            GLES20.glUniform4f(i3, edcVar.b, edcVar.c, edcVar.d, edcVar.e);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.baidu.tieba.gfc
    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && obj != null && this.l != -1) {
            edc edcVar = (edc) obj;
            if (!edcVar.equals(this.m)) {
                GLES20.glUniform4f(this.l, edcVar.b, edcVar.d, edcVar.c, edcVar.e);
                this.m = edcVar;
            }
        }
    }
}
