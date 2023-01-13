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
public class b4 extends c2<a4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public com.badlogic.gdx.math.a c;

    /* loaded from: classes3.dex */
    public static class a extends m1<a4> {
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
    public b4(t1 t1Var) {
        super(t1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a();
        this.c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c2
    /* renamed from: e */
    public a4 c(o1 o1Var, String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, o1Var, str, l3Var, aVar)) == null) {
            return f(new e4((Texture) o1Var.i(o1Var.n(str).first())), l3Var);
        }
        return (a4) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: d */
    public c7<k1> a(String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, l3Var, aVar)) == null) {
            if (aVar == null) {
                aVar = this.b;
            }
            try {
                BufferedReader q = l3Var.q(aVar.c);
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
                        l3 s = l3Var.s(l3Var.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 == null) {
                    return null;
                }
                c7<k1> c7Var = new c7<>(1);
                c7Var.a(new k1(l3Var.s(str2), Texture.class));
                return c7Var;
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading " + str, e);
            }
        }
        return (c7) invokeLLL.objValue;
    }

    public a4 f(e4 e4Var, l3 l3Var) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, e4Var, l3Var)) == null) {
            BufferedReader q = l3Var.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            k8.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + l3Var);
                        }
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + l3Var, e);
                    }
                } finally {
                    k8.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            return new a4(e4Var, fArr, this.c.c(fArr).f());
        }
        return (a4) invokeLL.objValue;
    }
}
