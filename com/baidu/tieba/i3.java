package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class i3 implements v6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public o6<q3> b;
    public boolean c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String[] b;
        public x2 c;
        public boolean d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public float o;
        public boolean p;
        public final b[][] q;
        public b r;
        public float s;
        public float t;
        public char[] u;
        public char[] v;

        public a(x2 x2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 1.0f;
            this.n = 1.0f;
            this.o = 1.0f;
            this.q = new b[128];
            this.t = 1.0f;
            this.u = new char[]{'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z'};
            this.v = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            this.c = x2Var;
            this.d = z;
            e(x2Var, z);
        }

        public void i(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                if (f != 0.0f) {
                    if (f2 != 0.0f) {
                        float f3 = f / this.n;
                        float f4 = f2 / this.o;
                        this.i *= f4;
                        this.s *= f3;
                        this.t *= f4;
                        this.j *= f4;
                        this.k *= f4;
                        this.l *= f4;
                        this.m *= f4;
                        this.h *= f3;
                        this.f *= f3;
                        this.e *= f4;
                        this.g *= f4;
                        this.n = f;
                        this.o = f2;
                        return;
                    }
                    throw new IllegalArgumentException("scaleY cannot be 0.");
                }
                throw new IllegalArgumentException("scaleX cannot be 0.");
            }
        }

        public b a() {
            InterceptResult invokeV;
            b[][] bVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                for (b[] bVarArr2 : this.q) {
                    if (bVarArr2 != null) {
                        for (b bVar : bVarArr2) {
                            if (bVar != null && bVar.e != 0 && bVar.d != 0) {
                                return bVar;
                            }
                        }
                        continue;
                    }
                }
                throw new GdxRuntimeException("No glyphs found.");
            }
            return (b) invokeV.objValue;
        }

        public b b(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c)})) == null) {
                b[] bVarArr = this.q[c / 512];
                if (bVarArr != null) {
                    return bVarArr[c & 511];
                }
                return null;
            }
            return (b) invokeCommon.objValue;
        }

        public String c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.b[i];
            }
            return (String) invokeI.objValue;
        }

        public void h(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
                i(f, f);
            }
        }

        public String[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return (String[]) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String str = this.a;
                if (str == null) {
                    return super.toString();
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x02d5 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x02eb A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02f3 A[Catch: Exception -> 0x0452, all -> 0x0476, TRY_LEAVE, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:135:0x0340 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0357 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0352 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0343 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0213 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0231 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0250 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0262 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0276 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x028a A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(x2 x2Var, boolean z) {
            String[] split;
            int i;
            int i2;
            String readLine;
            String readLine2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            b b;
            int length;
            int i3;
            b bVar;
            int length2;
            int i4;
            b bVar2;
            b bVar3;
            BufferedReader bufferedReader;
            b[][] bVarArr;
            BufferedReader bufferedReader2;
            b[] bVarArr2;
            StringTokenizer stringTokenizer;
            int parseInt;
            b b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048580, this, x2Var, z) == null) {
                if (this.b == null) {
                    this.a = x2Var.h();
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(x2Var.m()), 512);
                    try {
                        try {
                            String readLine3 = bufferedReader3.readLine();
                            try {
                                if (readLine3 != null) {
                                    String substring = readLine3.substring(readLine3.indexOf("padding=") + 8);
                                    if (substring.substring(0, substring.indexOf(32)).split(",", 4).length == 4) {
                                        this.e = Integer.parseInt(split[0]);
                                        boolean z2 = true;
                                        this.f = Integer.parseInt(split[1]);
                                        this.g = Integer.parseInt(split[2]);
                                        this.h = Integer.parseInt(split[3]);
                                        float f7 = this.e + this.g;
                                        String readLine4 = bufferedReader3.readLine();
                                        if (readLine4 != null) {
                                            String[] split2 = readLine4.split(" ", 9);
                                            if (split2.length >= 3) {
                                                if (split2[1].startsWith("lineHeight=")) {
                                                    this.i = Integer.parseInt(split2[1].substring(11));
                                                    if (split2[2].startsWith("base=")) {
                                                        float parseInt2 = Integer.parseInt(split2[2].substring(5));
                                                        if (split2.length >= 6 && split2[5] != null && split2[5].startsWith("pages=")) {
                                                            try {
                                                                i = Math.max(1, Integer.parseInt(split2[5].substring(6)));
                                                            } catch (NumberFormatException unused) {
                                                            }
                                                            this.b = new String[i];
                                                            for (i2 = 0; i2 < i; i2++) {
                                                                String readLine5 = bufferedReader3.readLine();
                                                                if (readLine5 != null) {
                                                                    Matcher matcher = Pattern.compile(".*id=(\\d+)").matcher(readLine5);
                                                                    if (matcher.find()) {
                                                                        String group = matcher.group(1);
                                                                        try {
                                                                            if (Integer.parseInt(group) != i2) {
                                                                                throw new GdxRuntimeException("Page IDs must be indices starting at 0: " + group);
                                                                            }
                                                                        } catch (NumberFormatException e) {
                                                                            throw new GdxRuntimeException("Invalid page id: " + group, e);
                                                                        }
                                                                    }
                                                                    Matcher matcher2 = Pattern.compile(".*file=\"?([^\"]+)\"?").matcher(readLine5);
                                                                    if (matcher2.find()) {
                                                                        this.b[i2] = x2Var.i().a(matcher2.group(1)).j().replaceAll("\\\\", "/");
                                                                    } else {
                                                                        throw new GdxRuntimeException("Missing: file");
                                                                    }
                                                                } else {
                                                                    throw new GdxRuntimeException("Missing additional page definitions.");
                                                                }
                                                            }
                                                            float f8 = 0.0f;
                                                            this.l = 0.0f;
                                                            while (true) {
                                                                readLine = bufferedReader3.readLine();
                                                                if (readLine != null || readLine.startsWith("kernings ") || readLine.startsWith("metrics ")) {
                                                                    break;
                                                                }
                                                                BufferedReader bufferedReader4 = bufferedReader3;
                                                                if (!readLine.startsWith("char ")) {
                                                                    b bVar4 = new b();
                                                                    StringTokenizer stringTokenizer2 = new StringTokenizer(readLine, " =");
                                                                    stringTokenizer2.nextToken();
                                                                    stringTokenizer2.nextToken();
                                                                    int parseInt3 = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    if (parseInt3 <= 0) {
                                                                        this.r = bVar4;
                                                                    } else if (parseInt3 <= 65535) {
                                                                        f(parseInt3, bVar4);
                                                                    }
                                                                    bVar4.a = parseInt3;
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.b = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.c = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.d = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.e = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.j = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    if (z) {
                                                                        bVar4.k = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    } else {
                                                                        bVar4.k = -(bVar4.e + Integer.parseInt(stringTokenizer2.nextToken()));
                                                                    }
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.l = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    if (stringTokenizer2.hasMoreTokens()) {
                                                                        stringTokenizer2.nextToken();
                                                                    }
                                                                    if (stringTokenizer2.hasMoreTokens()) {
                                                                        try {
                                                                            bVar4.n = Integer.parseInt(stringTokenizer2.nextToken());
                                                                        } catch (NumberFormatException unused2) {
                                                                        }
                                                                    }
                                                                    if (bVar4.d > 0 && bVar4.e > 0) {
                                                                        this.l = Math.min(bVar4.k + parseInt2, this.l);
                                                                    }
                                                                }
                                                                bufferedReader3 = bufferedReader4;
                                                            }
                                                            this.l += this.g;
                                                            while (true) {
                                                                readLine2 = bufferedReader3.readLine();
                                                                if (readLine2 != null || !readLine2.startsWith("kerning ")) {
                                                                    break;
                                                                }
                                                                BufferedReader bufferedReader5 = bufferedReader3;
                                                                stringTokenizer = new StringTokenizer(readLine2, " =");
                                                                stringTokenizer.nextToken();
                                                                stringTokenizer.nextToken();
                                                                parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                                                stringTokenizer.nextToken();
                                                                int parseInt4 = Integer.parseInt(stringTokenizer.nextToken());
                                                                if (parseInt >= 0 && parseInt <= 65535 && parseInt4 >= 0 && parseInt4 <= 65535) {
                                                                    b2 = b((char) parseInt);
                                                                    stringTokenizer.nextToken();
                                                                    int parseInt5 = Integer.parseInt(stringTokenizer.nextToken());
                                                                    if (b2 == null) {
                                                                        b2.a(parseInt4, parseInt5);
                                                                    }
                                                                }
                                                                bufferedReader3 = bufferedReader5;
                                                            }
                                                            if (readLine2 == null && readLine2.startsWith("metrics ")) {
                                                                StringTokenizer stringTokenizer3 = new StringTokenizer(readLine2, " =");
                                                                stringTokenizer3.nextToken();
                                                                stringTokenizer3.nextToken();
                                                                float parseFloat = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f2 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f3 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f4 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f5 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f6 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f = Float.parseFloat(stringTokenizer3.nextToken());
                                                                f8 = parseFloat;
                                                            } else {
                                                                z2 = false;
                                                                f = 0.0f;
                                                                f2 = 0.0f;
                                                                f3 = 0.0f;
                                                                f4 = 0.0f;
                                                                f5 = 0.0f;
                                                                f6 = 0.0f;
                                                            }
                                                            b = b(WebvttCueParser.CHAR_SPACE);
                                                            if (b == null) {
                                                                b = new b();
                                                                b.a = 32;
                                                                b b3 = b('l');
                                                                if (b3 == null) {
                                                                    b3 = a();
                                                                }
                                                                b.l = b3.l;
                                                                f(32, b);
                                                            }
                                                            if (b.d == 0) {
                                                                b.d = (int) (this.h + b.l + this.f);
                                                                b.j = (int) (-this.h);
                                                            }
                                                            this.s = b.l;
                                                            char[] cArr = this.u;
                                                            length = cArr.length;
                                                            i3 = 0;
                                                            bVar = null;
                                                            while (i3 < length) {
                                                                int i5 = length;
                                                                bVar = b(cArr[i3]);
                                                                if (bVar != null) {
                                                                    break;
                                                                }
                                                                i3++;
                                                                length = i5;
                                                            }
                                                            if (bVar == null) {
                                                                bVar = a();
                                                            }
                                                            this.t = bVar.e - f7;
                                                            char[] cArr2 = this.v;
                                                            length2 = cArr2.length;
                                                            i4 = 0;
                                                            bVar2 = null;
                                                            while (i4 < length2) {
                                                                int i6 = length2;
                                                                bVar2 = b(cArr2[i4]);
                                                                if (bVar2 != null) {
                                                                    break;
                                                                }
                                                                i4++;
                                                                length2 = i6;
                                                            }
                                                            if (bVar2 != null) {
                                                                b[][] bVarArr3 = this.q;
                                                                int length3 = bVarArr3.length;
                                                                int i7 = 0;
                                                                while (i7 < length3) {
                                                                    int i8 = length3;
                                                                    b[] bVarArr4 = bVarArr3[i7];
                                                                    if (bVarArr4 == null) {
                                                                        bufferedReader2 = bufferedReader3;
                                                                        bVarArr = bVarArr3;
                                                                    } else {
                                                                        bVarArr = bVarArr3;
                                                                        int length4 = bVarArr4.length;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        int i9 = 0;
                                                                        while (i9 < length4) {
                                                                            int i10 = length4;
                                                                            b bVar5 = bVarArr4[i9];
                                                                            if (bVar5 != null) {
                                                                                bVarArr2 = bVarArr4;
                                                                                if (bVar5.e != 0 && bVar5.d != 0) {
                                                                                    this.j = Math.max(this.j, bVar5.e);
                                                                                }
                                                                            } else {
                                                                                bVarArr2 = bVarArr4;
                                                                            }
                                                                            i9++;
                                                                            length4 = i10;
                                                                            bVarArr4 = bVarArr2;
                                                                        }
                                                                    }
                                                                    i7++;
                                                                    length3 = i8;
                                                                    bVarArr3 = bVarArr;
                                                                    bufferedReader3 = bufferedReader2;
                                                                }
                                                                bufferedReader = bufferedReader3;
                                                            } else {
                                                                bufferedReader = bufferedReader3;
                                                                this.j = bVar3.e;
                                                            }
                                                            float f9 = this.j - f7;
                                                            this.j = f9;
                                                            float f10 = parseInt2 - f9;
                                                            this.k = f10;
                                                            float f11 = -this.i;
                                                            this.m = f11;
                                                            if (z) {
                                                                this.k = -f10;
                                                                this.m = -f11;
                                                            }
                                                            if (z2) {
                                                                this.k = f8;
                                                                this.l = f2;
                                                                this.m = f3;
                                                                this.j = f4;
                                                                this.i = f5;
                                                                this.s = f6;
                                                                this.t = f;
                                                            }
                                                            w7.a(bufferedReader);
                                                            return;
                                                        }
                                                        i = 1;
                                                        this.b = new String[i];
                                                        while (i2 < i) {
                                                        }
                                                        float f82 = 0.0f;
                                                        this.l = 0.0f;
                                                        while (true) {
                                                            readLine = bufferedReader3.readLine();
                                                            if (readLine != null) {
                                                                break;
                                                                break;
                                                            }
                                                            BufferedReader bufferedReader42 = bufferedReader3;
                                                            if (!readLine.startsWith("char ")) {
                                                            }
                                                            bufferedReader3 = bufferedReader42;
                                                        }
                                                        this.l += this.g;
                                                        while (true) {
                                                            readLine2 = bufferedReader3.readLine();
                                                            if (readLine2 != null) {
                                                                break;
                                                            }
                                                            BufferedReader bufferedReader52 = bufferedReader3;
                                                            stringTokenizer = new StringTokenizer(readLine2, " =");
                                                            stringTokenizer.nextToken();
                                                            stringTokenizer.nextToken();
                                                            parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                                            stringTokenizer.nextToken();
                                                            int parseInt42 = Integer.parseInt(stringTokenizer.nextToken());
                                                            if (parseInt >= 0) {
                                                                b2 = b((char) parseInt);
                                                                stringTokenizer.nextToken();
                                                                int parseInt52 = Integer.parseInt(stringTokenizer.nextToken());
                                                                if (b2 == null) {
                                                                }
                                                            }
                                                            bufferedReader3 = bufferedReader52;
                                                        }
                                                        if (readLine2 == null) {
                                                        }
                                                        z2 = false;
                                                        f = 0.0f;
                                                        f2 = 0.0f;
                                                        f3 = 0.0f;
                                                        f4 = 0.0f;
                                                        f5 = 0.0f;
                                                        f6 = 0.0f;
                                                        b = b(WebvttCueParser.CHAR_SPACE);
                                                        if (b == null) {
                                                        }
                                                        if (b.d == 0) {
                                                        }
                                                        this.s = b.l;
                                                        char[] cArr3 = this.u;
                                                        length = cArr3.length;
                                                        i3 = 0;
                                                        bVar = null;
                                                        while (i3 < length) {
                                                        }
                                                        if (bVar == null) {
                                                        }
                                                        this.t = bVar.e - f7;
                                                        char[] cArr22 = this.v;
                                                        length2 = cArr22.length;
                                                        i4 = 0;
                                                        bVar2 = null;
                                                        while (i4 < length2) {
                                                        }
                                                        if (bVar2 != null) {
                                                        }
                                                        float f92 = this.j - f7;
                                                        this.j = f92;
                                                        float f102 = parseInt2 - f92;
                                                        this.k = f102;
                                                        float f112 = -this.i;
                                                        this.m = f112;
                                                        if (z) {
                                                        }
                                                        if (z2) {
                                                        }
                                                        w7.a(bufferedReader);
                                                        return;
                                                    }
                                                    throw new GdxRuntimeException("Missing: base");
                                                }
                                                throw new GdxRuntimeException("Missing: lineHeight");
                                            }
                                            throw new GdxRuntimeException("Invalid common header.");
                                        }
                                        throw new GdxRuntimeException("Missing common header.");
                                    }
                                    throw new GdxRuntimeException("Invalid padding.");
                                }
                                throw new GdxRuntimeException("File is empty.");
                            } catch (Exception e2) {
                                e = e2;
                                throw new GdxRuntimeException("Error loading font file: " + x2Var, e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            w7.a(bufferedReader3);
                            throw th2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        throw new GdxRuntimeException("Error loading font file: " + x2Var, e);
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th22 = th;
                        w7.a(bufferedReader3);
                        throw th22;
                    }
                }
                throw new IllegalStateException("Already loaded.");
            }
        }

        public void f(int i, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, bVar) == null) {
                b[][] bVarArr = this.q;
                int i2 = i / 512;
                b[] bVarArr2 = bVarArr[i2];
                if (bVarArr2 == null) {
                    bVarArr2 = new b[512];
                    bVarArr[i2] = bVarArr2;
                }
                bVarArr2[i & 511] = bVar;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(b bVar, q3 q3Var) {
            float f;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, bVar, q3Var) == null) {
                Texture f3 = q3Var.f();
                float x = 1.0f / f3.x();
                float u = 1.0f / f3.u();
                float f4 = q3Var.b;
                float f5 = q3Var.c;
                float c = q3Var.c();
                float b = q3Var.b();
                float f6 = 0.0f;
                if (q3Var instanceof p3.a) {
                    p3.a aVar = (p3.a) q3Var;
                    f = aVar.j;
                    f2 = (aVar.o - aVar.m) - aVar.k;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
                int i = bVar.b;
                float f7 = i;
                int i2 = bVar.d;
                float f8 = i + i2;
                int i3 = bVar.c;
                float f9 = i3;
                float f10 = i3 + bVar.e;
                if (f > 0.0f) {
                    f7 -= f;
                    if (f7 < 0.0f) {
                        bVar.d = (int) (i2 + f7);
                        bVar.j = (int) (bVar.j - f7);
                        f7 = 0.0f;
                    }
                    f8 -= f;
                    if (f8 > c) {
                        bVar.d = (int) (bVar.d - (f8 - c));
                        if (f2 > 0.0f) {
                            float f11 = f9 - f2;
                            if (f11 < 0.0f) {
                                int i4 = (int) (bVar.e + f11);
                                bVar.e = i4;
                                if (i4 < 0) {
                                    bVar.e = 0;
                                }
                            } else {
                                f6 = f11;
                            }
                            f10 -= f2;
                            if (f10 > b) {
                                float f12 = f10 - b;
                                bVar.e = (int) (bVar.e - f12);
                                bVar.k = (int) (bVar.k + f12);
                                f9 = f6;
                                bVar.f = (f7 * x) + f4;
                                bVar.h = f4 + (c * x);
                                if (this.d) {
                                    bVar.g = (f9 * u) + f5;
                                    bVar.i = f5 + (b * u);
                                    return;
                                }
                                bVar.i = (f9 * u) + f5;
                                bVar.g = f5 + (b * u);
                                return;
                            }
                            f9 = f6;
                        }
                        b = f10;
                        bVar.f = (f7 * x) + f4;
                        bVar.h = f4 + (c * x);
                        if (this.d) {
                        }
                    }
                }
                c = f8;
                if (f2 > 0.0f) {
                }
                b = f10;
                bVar.f = (f7 * x) + f4;
                bVar.h = f4 + (c * x);
                if (this.d) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;
        public float i;
        public int j;
        public int k;
        public int l;
        public byte[][] m;
        public int n;

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
                    return;
                }
            }
            this.n = 0;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Character.toString((char) this.a);
            }
            return (String) invokeV.objValue;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.m == null) {
                    this.m = new byte[128];
                }
                byte[][] bArr = this.m;
                int i3 = i >>> 9;
                byte[] bArr2 = bArr[i3];
                if (bArr2 == null) {
                    bArr2 = new byte[512];
                    bArr[i3] = bArr2;
                }
                bArr2[i & 511] = (byte) i2;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3() {
        this(s0.d.f("com/badlogic/gdx/utils/arial-15.fnt"), s0.d.f("com/badlogic/gdx/utils/arial-15.png"), false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((x2) objArr[0], (x2) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public i3(a aVar, o6<q3> o6Var, boolean z) {
        x2 d;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, o6Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        boolean z2 = aVar.d;
        this.a = aVar;
        this.c = z;
        if (o6Var != null && o6Var.b != 0) {
            this.b = o6Var;
            this.d = false;
        } else {
            String[] strArr = aVar.b;
            if (strArr != null) {
                int length = strArr.length;
                this.b = new o6<>(length);
                for (int i3 = 0; i3 < length; i3++) {
                    x2 x2Var = aVar.c;
                    if (x2Var == null) {
                        d = s0.d.a(aVar.b[i3]);
                    } else {
                        d = s0.d.d(aVar.b[i3], x2Var.t());
                    }
                    this.b.a(new q3(new Texture(d, false)));
                }
                this.d = true;
            } else {
                throw new IllegalArgumentException("If no regions are specified, the font data must have an images path.");
            }
        }
        h();
        g(aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i3(a aVar, q3 q3Var, boolean z) {
        this(aVar, r10, z);
        o6 o6Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, q3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((a) objArr2[0], (o6) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (q3Var != null) {
            o6Var = o6.n(q3Var);
        } else {
            o6Var = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(x2 x2Var, q3 q3Var) {
        this(x2Var, q3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, q3Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((x2) objArr2[0], (q3) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(x2 x2Var, q3 q3Var, boolean z) {
        this(new a(x2Var, z), q3Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, q3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((a) objArr2[0], (q3) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(x2 x2Var, x2 x2Var2, boolean z) {
        this(x2Var, x2Var2, z, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, x2Var2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((x2) objArr2[0], (x2) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(x2 x2Var, x2 x2Var2, boolean z, boolean z2) {
        this(new a(x2Var, z), new q3(new Texture(x2Var2, false)), z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, x2Var2, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((a) objArr2[0], (q3) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.d = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(x2 x2Var, boolean z) {
        this(new a(x2Var, z), (q3) null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((a) objArr2[0], (q3) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.j;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.v6
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.d) {
            int i = 0;
            while (true) {
                o6<q3> o6Var = this.b;
                if (i < o6Var.b) {
                    o6Var.get(i).f().dispose();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (a) invokeV.objValue;
    }

    public j3 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new j3(this, this.c);
        }
        return (j3) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.a.a;
            if (str == null) {
                return super.toString();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void g(a aVar) {
        b[][] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            for (b[] bVarArr2 : aVar.q) {
                if (bVarArr2 != null) {
                    for (b bVar : bVarArr2) {
                        if (bVar != null) {
                            aVar.g(bVar, this.b.get(bVar.n));
                        }
                    }
                }
            }
            b bVar2 = aVar.r;
            if (bVar2 != null) {
                aVar.g(bVar2, this.b.get(bVar2.n));
            }
        }
    }
}
