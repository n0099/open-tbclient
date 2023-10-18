package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d2c extends e2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public c0c m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2c(k2c k2cVar) {
        super(k2cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k2c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = new c0c(0.7f, 0.9f, 0.95f, 0.75f);
    }

    @Override // com.baidu.tieba.e2c
    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            super.a(str, str2, i, i2);
            GLES20.glUseProgram(this.a);
            this.l = GLES20.glGetUniformLocation(this.a, "u_frontArea");
            l2c.c("PipUniform", this.j);
            int i3 = this.l;
            c0c c0cVar = this.m;
            GLES20.glUniform4f(i3, c0cVar.b, c0cVar.c, c0cVar.d, c0cVar.e);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.baidu.tieba.e2c
    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && obj != null && this.l != -1) {
            c0c c0cVar = (c0c) obj;
            if (!c0cVar.equals(this.m)) {
                GLES20.glUniform4f(this.l, c0cVar.b, c0cVar.d, c0cVar.c, c0cVar.e);
                this.m = c0cVar;
            }
        }
    }
}
