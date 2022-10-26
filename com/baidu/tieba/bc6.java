package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class bc6 implements ic6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dc6 a;
    public boolean b;
    public boolean c;
    public ac6 d;
    public boolean e;

    public bc6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.e = false;
        this.a = new dc6();
        this.e = z;
    }

    @Override // com.baidu.tieba.ic6
    public void a(String str, jc6 jc6Var) {
        ac6 ac6Var;
        ac6 ac6Var2;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, jc6Var) != null) || jc6Var == null) {
            return;
        }
        if (this.b) {
            File file = new File(jc6Var.a);
            Bitmap decodeFile = BitmapFactory.decodeFile(jc6Var.a);
            if (file.exists() && decodeFile != null) {
                float height = decodeFile.getHeight();
                float width = decodeFile.getWidth();
                float f3 = height * 1.0f;
                float f4 = f3 / width;
                if (f4 > 1.0f) {
                    f = 1.7777778f;
                } else {
                    f = 0.75f;
                }
                float f5 = 0.0f;
                if (f4 > f) {
                    float f6 = f * width;
                    f2 = (height - f6) * 0.5f;
                    height = f6;
                } else {
                    float f7 = f3 / f;
                    f5 = (width - f7) * 0.5f;
                    width = f7;
                    f2 = 0.0f;
                }
                jc6Var.a = FileHelper.saveBitmapByAbsolutelyPath(file.getPath(), file.getName(), Bitmap.createBitmap(decodeFile, (int) f5, (int) f2, (int) width, (int) height), 95);
            }
        }
        if ("default".equals(str)) {
            if (!this.c && (ac6Var2 = this.d) != null) {
                ac6Var2.h0(jc6Var.a);
            }
        } else if ("manual".equals(str) && (ac6Var = this.d) != null) {
            ac6Var.h0(jc6Var.a);
        }
    }

    public void b(kc6 kc6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kc6Var, str) == null) {
            this.a.a(str, this.e).a(kc6Var, this);
        }
    }

    @Override // com.baidu.tieba.ic6
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            BdLog.e("get cover error ! type : " + str + ", err : " + str2);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.c = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.b = z;
        }
    }

    public void e(ac6 ac6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ac6Var) == null) {
            this.d = ac6Var;
        }
    }
}
