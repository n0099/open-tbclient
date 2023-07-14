package com.baidu.tieba;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m1;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class g4 extends m1<b> {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final b7 d;
    public final b7 e;
    public final b7 f;
    public final t6<a> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448303776, "Lcom/baidu/tieba/g4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448303776, "Lcom/baidu/tieba/g4;");
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public String b;
        public t6<Integer> c;
        public int d;
        public boolean e;
        public boolean f;

        public a(g4 g4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.c = new t6<>(200);
            this.d = 0;
            new y3("");
            this.b = "default";
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean c;

        public b() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g4(k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new b7(300);
        this.e = new b7(300);
        this.f = new b7(200);
        this.g = new t6<>(10);
    }

    public final int j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str != null && str.length() != 0) {
                int parseInt = Integer.parseInt(str);
                if (parseInt < 0) {
                    return i + parseInt;
                }
                return parseInt - 1;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m1
    /* renamed from: k */
    public o4 h(c3 c3Var, b bVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c3Var, bVar)) == null) {
            if (bVar != null && bVar.c) {
                z = true;
            } else {
                z = false;
            }
            return l(c3Var, z);
        }
        return (o4) invokeLL.objValue;
    }

    public o4 l(c3 c3Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        int i4;
        char charAt;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, c3Var, z)) == null) {
            if (h) {
                x0.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
            }
            f4 f4Var = new f4();
            a aVar = new a(this, "default");
            this.g.a(aVar);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c3Var.m()), 4096);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length < 1) {
                        break;
                    } else if (split[0].length() != 0 && (charAt = split[0].toLowerCase().charAt(0)) != '#') {
                        if (charAt == 'v') {
                            if (split[0].length() == 1) {
                                this.d.a(Float.parseFloat(split[1]));
                                this.d.a(Float.parseFloat(split[2]));
                                this.d.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.e.a(Float.parseFloat(split[1]));
                                this.e.a(Float.parseFloat(split[2]));
                                this.e.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.f.a(Float.parseFloat(split[1]));
                                b7 b7Var = this.f;
                                if (z) {
                                    parseFloat = 1.0f - Float.parseFloat(split[2]);
                                } else {
                                    parseFloat = Float.parseFloat(split[2]);
                                }
                                b7Var.a(parseFloat);
                            }
                        } else if (charAt == 'f') {
                            t6<Integer> t6Var = aVar.c;
                            int i5 = 1;
                            while (i5 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                t6Var.a(Integer.valueOf(j(split2[0], this.d.b)));
                                if (split2.length > 2) {
                                    if (i5 == 1) {
                                        aVar.e = true;
                                    }
                                    t6Var.a(Integer.valueOf(j(split2[2], this.e.b)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i5 == 1) {
                                        aVar.f = true;
                                    }
                                    t6Var.a(Integer.valueOf(j(split2[1], this.f.b)));
                                }
                                int i6 = i5 + 1;
                                String[] split3 = split[i6].split("/");
                                t6Var.a(Integer.valueOf(j(split3[0], this.d.b)));
                                if (split3.length > 2) {
                                    t6Var.a(Integer.valueOf(j(split3[2], this.e.b)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    t6Var.a(Integer.valueOf(j(split3[1], this.f.b)));
                                }
                                int i7 = i6 + 1;
                                String[] split4 = split[i7].split("/");
                                t6Var.a(Integer.valueOf(j(split4[0], this.d.b)));
                                if (split4.length > 2) {
                                    t6Var.a(Integer.valueOf(j(split4[2], this.e.b)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    t6Var.a(Integer.valueOf(j(split4[1], this.f.b)));
                                }
                                aVar.d++;
                                i5 = i7 - 1;
                            }
                        } else {
                            if (charAt != 'o' && charAt != 'g') {
                                if (split[0].equals("mtllib")) {
                                    f4Var.b(c3Var.i().a(split[1]));
                                } else if (split[0].equals("usemtl")) {
                                    if (split.length == 1) {
                                        aVar.b = "default";
                                    } else {
                                        aVar.b = split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_');
                                    }
                                }
                            }
                            if (split.length > 1) {
                                aVar = m(split[1]);
                            } else {
                                aVar = m("default");
                            }
                        }
                    }
                } catch (IOException unused) {
                    return null;
                }
            }
            bufferedReader.close();
            int i8 = 0;
            while (true) {
                t6<a> t6Var2 = this.g;
                i = t6Var2.b;
                if (i8 >= i) {
                    break;
                }
                if (t6Var2.get(i8).d < 1) {
                    this.g.h(i8);
                    i8--;
                }
                i8++;
            }
            if (i < 1) {
                return null;
            }
            o4 o4Var = new o4();
            int i9 = 0;
            int i10 = 0;
            while (i9 < i) {
                a aVar2 = this.g.get(i9);
                t6<Integer> t6Var3 = aVar2.c;
                int i11 = t6Var3.b;
                int i12 = aVar2.d;
                boolean z2 = aVar2.e;
                boolean z3 = aVar2.f;
                int i13 = i12 * 3;
                if (z2) {
                    i2 = 3;
                } else {
                    i2 = 0;
                }
                int i14 = i2 + 3;
                if (z3) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                float[] fArr = new float[i13 * (i14 + i3)];
                int i15 = 0;
                int i16 = 0;
                while (i15 < i11) {
                    int i17 = i15 + 1;
                    int intValue = t6Var3.get(i15).intValue() * 3;
                    int i18 = i16 + 1;
                    int i19 = i;
                    int i20 = i11;
                    int i21 = intValue + 1;
                    fArr[i16] = this.d.c(intValue);
                    int i22 = i18 + 1;
                    int i23 = i9;
                    fArr[i18] = this.d.c(i21);
                    int i24 = i22 + 1;
                    fArr[i22] = this.d.c(i21 + 1);
                    if (z2) {
                        int i25 = i17 + 1;
                        int intValue2 = t6Var3.get(i17).intValue() * 3;
                        int i26 = i24 + 1;
                        int i27 = intValue2 + 1;
                        fArr[i24] = this.e.c(intValue2);
                        int i28 = i26 + 1;
                        fArr[i26] = this.e.c(i27);
                        i24 = i28 + 1;
                        fArr[i28] = this.e.c(i27 + 1);
                        i17 = i25;
                    }
                    if (z3) {
                        int i29 = i17 + 1;
                        int intValue3 = t6Var3.get(i17).intValue() * 2;
                        int i30 = i24 + 1;
                        int i31 = intValue3 + 1;
                        fArr[i24] = this.f.c(intValue3);
                        i4 = i30 + 1;
                        fArr[i30] = this.f.c(i31);
                        i15 = i29;
                    } else {
                        i4 = i24;
                        i15 = i17;
                    }
                    i11 = i20;
                    i9 = i23;
                    i16 = i4;
                    i = i19;
                }
                int i32 = i9;
                int i33 = i;
                if (i13 >= 32767) {
                    i13 = 0;
                }
                short[] sArr = new short[i13];
                if (i13 > 0) {
                    for (int i34 = 0; i34 < i13; i34++) {
                        sArr[i34] = (short) i34;
                    }
                }
                t6 t6Var4 = new t6();
                t6Var4.a(new l3(1, 3, "a_position"));
                if (z2) {
                    t6Var4.a(new l3(8, 3, "a_normal"));
                }
                if (z3) {
                    t6Var4.a(new l3(16, 2, "a_texCoord0"));
                }
                i10++;
                String num = Integer.toString(i10);
                if ("default".equals(aVar2.a)) {
                    str = "node" + num;
                } else {
                    str = aVar2.a;
                }
                if ("default".equals(aVar2.a)) {
                    String str3 = "mesh" + num;
                } else {
                    String str4 = aVar2.a;
                }
                if ("default".equals(aVar2.a)) {
                    str2 = "part" + num;
                } else {
                    str2 = aVar2.a;
                }
                r4 r4Var = new r4();
                r4Var.a = str;
                r4Var.d = new Vector3(1.0f, 1.0f, 1.0f);
                r4Var.b = new Vector3();
                r4Var.c = new Quaternion();
                u4 u4Var = new u4();
                u4Var.b = str2;
                u4Var.a = aVar2.b;
                r4Var.e = new u4[]{u4Var};
                q4 q4Var = new q4();
                q4Var.a = str2;
                q4Var.b = sArr;
                q4Var.c = 4;
                p4 p4Var = new p4();
                p4Var.a = (l3[]) t6Var4.m(l3.class);
                p4Var.b = fArr;
                p4Var.c = new q4[]{q4Var};
                o4Var.d.a(r4Var);
                o4Var.b.a(p4Var);
                o4Var.c.a(f4Var.a(aVar2.b));
                i9 = i32 + 1;
                i = i33;
            }
            b7 b7Var2 = this.d;
            if (b7Var2.b > 0) {
                b7Var2.b();
            }
            b7 b7Var3 = this.e;
            if (b7Var3.b > 0) {
                b7Var3.b();
            }
            b7 b7Var4 = this.f;
            if (b7Var4.b > 0) {
                b7Var4.b();
            }
            t6<a> t6Var5 = this.g;
            if (t6Var5.b > 0) {
                t6Var5.clear();
            }
            return o4Var;
        }
        return (o4) invokeLZ.objValue;
    }

    public final a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            t6.b<a> it = this.g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            a aVar = new a(this, str);
            this.g.a(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
