package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a4 extends b2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public com.badlogic.gdx.math.a c;

    /* loaded from: classes3.dex */
    public class a extends l1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public int c;
        public String[] d;

        public a() {
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
            this.b = "i ";
            this.c = 1024;
            this.d = new String[]{"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(s1 s1Var) {
        super(s1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a();
        this.c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b2
    /* renamed from: e */
    public z3 c(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, n1Var, str, k3Var, aVar)) == null) {
            return f(new d4((Texture) n1Var.i((String) n1Var.n(str).f())), k3Var);
        }
        return (z3) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: d */
    public b7 a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, k3Var, aVar)) == null) {
            if (aVar == null) {
                aVar = this.b;
            }
            try {
                BufferedReader q = k3Var.q(aVar.c);
                while (true) {
                    String readLine = q.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(aVar.b)) {
                            str2 = readLine.substring(aVar.b.length());
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                q.close();
                if (str2 == null && (strArr = aVar.d) != null) {
                    for (String str3 : strArr) {
                        k3 s = k3Var.s(k3Var.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 == null) {
                    return null;
                }
                b7 b7Var = new b7(1);
                b7Var.a(new j1(k3Var.s(str2), Texture.class));
                return b7Var;
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading " + str, e);
            }
        }
        return (b7) invokeLLL.objValue;
    }

    public z3 f(d4 d4Var, k3 k3Var) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, d4Var, k3Var)) == null) {
            BufferedReader q = k3Var.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            j8.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + k3Var);
                        }
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + k3Var, e);
                    }
                } finally {
                    j8.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            return new z3(d4Var, fArr, this.c.c(fArr).f());
        }
        return (z3) invokeLL.objValue;
    }
}
