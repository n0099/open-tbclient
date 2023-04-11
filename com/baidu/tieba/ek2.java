package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ek2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "/aigames/sandbox/";
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947737149, "Lcom/baidu/tieba/ek2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947737149, "Lcom/baidu/tieba/ek2;");
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830359904, "Lcom/baidu/tieba/ek2$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-830359904, "Lcom/baidu/tieba/ek2$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

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
            this.a = 0L;
        }
    }

    public static long A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return z(new File(str));
        }
        return invokeL.longValue;
    }

    public static void a0(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, jsFunction) == null) && jsFunction != null) {
            jsFunction.release();
        }
    }

    public static void b0(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65566, null, jsObject) != null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            if (context == null) {
                return "";
            }
            return context.getCacheDir().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            if (context == null) {
                return "";
            }
            if (TextUtils.isEmpty(b) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                b = externalFilesDir.getAbsolutePath();
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.startsWith(rj2.USER_DATA_PATH)) {
                return P(str);
            }
            if (!str.startsWith("bdfile://tmp")) {
                return "";
            }
            return N(str);
        }
        return (String) invokeL.objValue;
    }

    public static JSExceptionType C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != -5) {
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                return JSExceptionType.Error;
                            }
                            return JSExceptionType.Error;
                        }
                        return JSExceptionType.TypeError;
                    }
                    return JSExceptionType.SyntaxError;
                }
                return JSExceptionType.ReferenceError;
            }
            return JSExceptionType.RangeError;
        }
        return (JSExceptionType) invokeI.objValue;
    }

    public static Map<String, JsFunction> E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jsObject.length(); i++) {
                if (jsObject.getPropertyType(i) == 8) {
                    hashMap.put(jsObject.getPropertyName(i), jsObject.toJsFunction(i));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf("../");
            if (indexOf == 0) {
                String substring = str.substring(3);
                if (TextUtils.isEmpty(substring) || !substring.contains("../")) {
                    return false;
                }
                return true;
            } else if (indexOf <= 0) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equalsIgnoreCase(rj2.USER_DATA_PATH + File.separator + "record.pro");
        }
        return invokeL.booleanValue;
    }

    public static void i(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65575, null, list) == null) && list != null && list.size() != 0) {
            for (String str : list) {
                File file = new File(str);
                if (file.exists()) {
                    yn4.j(file);
                }
            }
        }
    }

    public static byte[] r(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            for (int i = 0; i < jsObject.length(); i++) {
                if (jsObject.getPropertyType(i) == 10) {
                    JsArrayBuffer jsArrayBuffer = jsObject.toJsArrayBuffer(i);
                    if (jsArrayBuffer == null) {
                        return null;
                    }
                    return jsArrayBuffer.buffer();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static long z(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, file)) == null) {
            if (file == null || !file.exists() || !file.isFile()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                long available = fileInputStream.available();
                yn4.d(fileInputStream);
                return available;
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                yn4.d(fileInputStream2);
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                yn4.d(fileInputStream2);
                throw th;
            }
        }
        return invokeL.longValue;
    }

    public static JsFunction D(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str) && map != null) {
                Object obj = map.get(str);
                if (obj instanceof JsFunction) {
                    return (JsFunction) obj;
                }
            }
            return null;
        }
        return (JsFunction) invokeLL.objValue;
    }

    public static String I(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, map)) == null) {
            if (TextUtils.isEmpty(str) || map == null || (obj = map.get(str)) == null || !(obj instanceof String)) {
                return null;
            }
            return (String) obj;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Object obj, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, obj, map) == null) {
            c0(D("success", map), D(TaskProcessData.keyComplete, map), obj, D(com.baidu.pass.biometrics.face.liveness.b.a.g0, map));
        }
    }

    public static void d(cf2 cf2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65569, null, cf2Var, str) == null) && cf2Var != null && cf2Var.w() != null && !TextUtils.isEmpty(str)) {
            cf2Var.w().b(str);
        }
    }

    public static boolean f(File file, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, file, bVar)) == null) {
            if (bVar != null) {
                bVar.a = 0L;
            }
            return h(file, bVar);
        }
        return invokeLL.booleanValue;
    }

    public static String F(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, str, str2, str3, str4)) == null) {
            return G(str, str2, str3, str4, false);
        }
        return (String) invokeLLLL.objValue;
    }

    public static void c0(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, jsFunction, jsFunction2, obj, jsFunction3) == null) {
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            a0(jsFunction3);
        }
    }

    public static void m(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65579, null, jsFunction, jsFunction2, obj, jsFunction3) == null) {
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            a0(jsFunction3);
            if (obj instanceof gk2) {
                cr2.j().b(((gk2) obj).errMsg);
            }
        }
    }

    public static String G(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return com.baidu.pass.biometrics.face.liveness.b.a.g0;
            }
            if (str.endsWith(" ")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str3 == null) {
                str3 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return String.format("%s \"%s\"", str, str3);
            }
            if (str.endsWith(",")) {
                str = str.substring(0, str.length() - 1);
            }
            if (!z && TextUtils.isEmpty(str4)) {
                return String.format("%s, %s \"%s\"", str, str2, str3);
            }
            return String.format("%s, %s \"%s\" -> \"%s\"", str, str2, str3, str4);
        }
        return (String) invokeCommon.objValue;
    }

    @NonNull
    public static <T> T H(String str, Map<String, Object> map, @NonNull T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, map, t)) == null) {
            if (!TextUtils.isEmpty(str) && map != null) {
                T t2 = (T) map.get(str);
                if (t2 == null) {
                    return t;
                }
                return t2;
            }
            return t;
        }
        return (T) invokeLLL.objValue;
    }

    public static sj2 v(tj2 tj2Var, String str, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65588, null, tj2Var, str, map)) == null) {
            sj2 sj2Var = new sj2();
            sj2Var.a = tj2Var;
            sj2Var.b = str;
            sj2Var.c = map;
            return sj2Var;
        }
        return (sj2) invokeLLL.objValue;
    }

    public static tj2 x(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65590, null, str, str2, str3)) == null) {
            tj2 tj2Var = new tj2();
            if (str == null) {
                tj2Var.b = str3;
                tj2Var.a = -2;
                return tj2Var;
            } else if ("".equals(str)) {
                tj2Var.b = str2;
                tj2Var.a = -1;
                return tj2Var;
            } else {
                return null;
            }
        }
        return (tj2) invokeLLL.objValue;
    }

    public static Map<String, Object> J(wj2 wj2Var, JsObject jsObject, gk2 gk2Var, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, wj2Var, jsObject, gk2Var, str)) == null) {
            if (jsObject != null && wj2Var != null && gk2Var != null) {
                Map<String, JsFunction> E = E(jsObject);
                if (E == null) {
                    b0(jsObject);
                    return null;
                }
                Map<String, Object> l = l(jsObject);
                if (l == null) {
                    b0(jsObject);
                    gk2Var.errMsg = str;
                    m(E.get(com.baidu.pass.biometrics.face.liveness.b.a.g0), E.get(TaskProcessData.keyComplete), gk2Var, E.get("success"));
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (String str2 : E.keySet()) {
                    hashMap.put(str2, E.get(str2));
                }
                for (String str3 : l.keySet()) {
                    hashMap.put(str3, l.get(str3));
                }
                b0(jsObject);
                return hashMap;
            }
            b0(jsObject);
            return null;
        }
        return (Map) invokeLLLL.objValue;
    }

    public static String K(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "path";
            }
            switch (i) {
                case 1:
                    str2 = "Boolean;";
                    break;
                case 2:
                case 3:
                case 5:
                    str2 = "Number;";
                    break;
                case 4:
                case 7:
                case 11:
                default:
                    str2 = "NoSupport;";
                    break;
                case 6:
                    str2 = "Array;";
                    break;
                case 8:
                    str2 = "Function;";
                    break;
                case 9:
                    str2 = "Object;";
                    break;
                case 10:
                    str2 = "ArrayBuffer;";
                    break;
                case 12:
                    str2 = "Undefined;";
                    break;
            }
            return "fail parameter error: parameter." + str + " should be String instead of " + str2;
        }
        return (String) invokeLI.objValue;
    }

    public static void X(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str + "/tmp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str + "/usr");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(str + File.separator + "record.pro");
                if (!file3.exists()) {
                    try {
                        file3.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                File file4 = new File(str2);
                if (!file4.exists()) {
                    file4.mkdirs();
                }
            }
        }
    }

    public static String L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.startsWith(WebGLImageLoader.BDFILE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("bdfile://code");
                if (!str.startsWith(File.separator)) {
                    str = File.separator + str;
                }
                sb.append(str);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str != null && str.length() >= 1) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                char[] charArray = str.toCharArray();
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4));
                }
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ((!str.startsWith(rj2.USER_DATA_PATH + File.separator) && !rj2.USER_DATA_PATH.equals(str)) || R(str) || S(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String Y(String str) {
        InterceptResult invokeL;
        String B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            int i = a.a[cf3.s(str).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    B = str;
                } else {
                    B = ht2.U().z() + str;
                }
            } else {
                B = B(str);
            }
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String M(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            String y = y(AppRuntime.getAppContext());
            return y + File.separator + str + a + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static int O(String str, JsObject jsObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, jsObject)) == null) {
            if (jsObject != null && !TextUtils.isEmpty(str)) {
                for (int i = 0; i < jsObject.length(); i++) {
                    if (str.equals(jsObject.getPropertyName(i))) {
                        return jsObject.getPropertyType(i);
                    }
                }
            }
            return 12;
        }
        return invokeLL.intValue;
    }

    public static boolean U(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return true;
            }
            if (file.isDirectory() && file2.isFile()) {
                return false;
            }
            if (!file.isFile() || !file2.isDirectory()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static String[] u(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, str, str2)) == null) {
            String[] strArr = new String[2];
            if (TextUtils.isEmpty(str)) {
                strArr[0] = "";
                strArr[1] = str2;
                return strArr;
            }
            if (TextUtils.equals(str2, "hex")) {
                byte[] Q = Q(str);
                if (Q == null) {
                    str = "";
                } else {
                    str = new String(Q, IMAudioTransRequest.CHARSET);
                }
                str2 = "";
            }
            strArr[0] = str;
            strArr[1] = str2;
            return strArr;
        }
        return (String[]) invokeLL.objValue;
    }

    public static String N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                    String p = p();
                    if (TextUtils.isEmpty(p)) {
                        return null;
                    }
                    String substring = str.substring(9);
                    if (substring.startsWith(File.separator)) {
                        return p + substring;
                    }
                    return p + File.separator + substring;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(rj2.USER_DATA_PATH + File.separator) || rj2.USER_DATA_PATH.equals(str)) {
                    String p = p();
                    if (TextUtils.isEmpty(p)) {
                        return null;
                    }
                    String substring = str.substring(9);
                    if (substring.startsWith(File.separator)) {
                        return p + substring;
                    }
                    return p + File.separator + substring;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String p = p();
            if (TextUtils.isEmpty(p)) {
                return null;
            }
            String str2 = p + File.separator;
            if (!str.startsWith(str2) || str.length() <= str2.length()) {
                return null;
            }
            return WebGLImageLoader.BDFILE + str.substring(str2.length());
        }
        return (String) invokeL.objValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return false;
            }
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    z = g(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = j(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                }
            }
            if (!z) {
                return false;
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static Map<String, Object> l(JsObject jsObject) {
        InterceptResult invokeL;
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jsObject.length(); i++) {
                int propertyType = jsObject.getPropertyType(i);
                if (propertyType != 1) {
                    if (propertyType != 2) {
                        if (propertyType != 3) {
                            if (propertyType != 5) {
                                if (propertyType != 7) {
                                    valueOf = null;
                                } else {
                                    valueOf = jsObject.toString(i);
                                }
                            } else {
                                valueOf = Double.valueOf(jsObject.toDouble(i));
                            }
                        } else {
                            valueOf = Long.valueOf(jsObject.toLong(i));
                        }
                    } else {
                        valueOf = Integer.valueOf(jsObject.toInteger(i));
                    }
                } else {
                    valueOf = Boolean.valueOf(jsObject.toBoolean(i));
                }
                if (valueOf != null) {
                    hashMap.put(jsObject.getPropertyName(i), valueOf);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            FileInputStream fileInputStream2 = null;
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int available = fileInputStream.available();
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr);
                for (int i = 0; i < available; i++) {
                    String hexString = Integer.toHexString(bArr[i] & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                yn4.d(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                if (eo1.a) {
                    e.printStackTrace();
                }
                yn4.d(fileInputStream2);
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                yn4.d(fileInputStream2);
                throw th;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] q(String str) {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        yn4.d(bufferedInputStream);
                        yn4.d(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream2 = bufferedInputStream;
                e.printStackTrace();
                yn4.d(bufferedInputStream2);
                yn4.d(byteArrayOutputStream);
                return new byte[0];
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                yn4.d(bufferedInputStream2);
                yn4.d(byteArrayOutputStream);
                throw th;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static String w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65589, null, i)) == null) {
            if (i != 1) {
                if (i != 2 && i != 3 && i != 5) {
                    if (i != 6) {
                        if (i != 8) {
                            if (i != 9) {
                                if (i != 12) {
                                    return "";
                                }
                                return "fail TypeError: data argument must not be a " + "Undefined;".toLowerCase();
                            }
                        } else {
                            return "fail TypeError: data argument must not be a " + "Function;".toLowerCase();
                        }
                    } else {
                        return "fail TypeError: data argument must not be a " + "Array;".toLowerCase();
                    }
                } else {
                    return "fail TypeError: data argument must not be a " + "Number;".toLowerCase();
                }
            }
            return "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object";
        }
        return (String) invokeI.objValue;
    }

    public static boolean T(wj2 wj2Var, cf2 cf2Var, JsObject jsObject, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, wj2Var, cf2Var, jsObject, str)) == null) {
            if (wj2Var != null && cf2Var != null) {
                return true;
            }
            if (jsObject == null && !TextUtils.isEmpty(str)) {
                d(cf2Var, str + "Object;");
            }
            b0(jsObject);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean V(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.startsWith("bdfile://tmp" + File.separator) && !"bdfile://tmp".equals(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!str.startsWith(rj2.USER_DATA_PATH + File.separator) && !rj2.USER_DATA_PATH.equals(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!str.startsWith("bdfile://code" + File.separator) && !"bdfile://code".equals(str)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z && !z2 && !z3) {
                z4 = false;
            } else {
                z4 = true;
            }
            boolean S = S(str);
            if (!z4 || S || R(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, str) == null) {
            String h = br2.h0().h(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(h)) {
                yn4.M(M(h, str));
                yn4.M(M(ao4.d(h.getBytes(), false), str));
            }
            String i = br2.h0().i(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(i)) {
                yn4.M(M(i, str));
                yn4.M(M(ao4.d(i.replace("|", "").getBytes(), false), str));
            }
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return;
            }
            String str2 = y(appContext) + File.separator + "swangame/anonymous/sandbox" + File.separator + str;
            if (!TextUtils.isEmpty(str2)) {
                yn4.M(str2);
            }
        }
    }

    public static boolean a(sj2 sj2Var, gk2 gk2Var, Map<Integer, String> map, cf2 cf2Var) {
        InterceptResult invokeLLLL;
        String str;
        Map<String, Object> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65563, null, sj2Var, gk2Var, map, cf2Var)) == null) {
            if (map != null) {
                for (Integer num : map.keySet()) {
                    if (num.intValue() != 7) {
                        str = K(map.get(num), num.intValue());
                        break;
                    }
                }
            }
            str = null;
            if (gk2Var == null || sj2Var == null || (map2 = sj2Var.c) == null) {
                return false;
            }
            tj2 tj2Var = sj2Var.a;
            JsFunction D = D(com.baidu.pass.biometrics.face.liveness.b.a.g0, map2);
            JsFunction D2 = D(TaskProcessData.keyComplete, map2);
            JsFunction D3 = D("success", map2);
            if (!TextUtils.isEmpty(str)) {
                String str2 = sj2Var.b + str;
                gk2Var.errMsg = str2;
                d(cf2Var, str2);
                m(D, D2, gk2Var, D3);
                return false;
            } else if (tj2Var == null) {
                gk2Var.errMsg = sj2Var.b + "unknown error";
                m(D, D2, gk2Var, D3);
                return false;
            } else {
                gk2Var.errMsg = sj2Var.b + tj2Var.b;
                if (tj2Var.a != 0) {
                    m(D, D2, gk2Var, D3);
                    return false;
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static void c() {
        Context appContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65567, null) != null) || (appContext = AppRuntime.getAppContext()) == null) {
            return;
        }
        String y = y(appContext);
        String str = y + File.separator + "swangame/anonymous/sandbox";
        if (!TextUtils.isEmpty(str)) {
            yn4.M(str);
        }
        String str2 = y + File.separator + c + a;
        if (!TextUtils.isEmpty(str2)) {
            yn4.M(str2);
        }
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return "";
            }
            String y = y(appContext);
            if (u73.M() == null) {
                return y;
            }
            String g0 = u73.g0();
            return y + File.separator + "swangame/anonymous/sandbox" + File.separator + g0;
        }
        return (String) invokeV.objValue;
    }

    public static void d0(cf2 cf2Var, tj2 tj2Var, JSExceptionType jSExceptionType, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65570, null, cf2Var, tj2Var, jSExceptionType, str, str2) != null) || cf2Var == null) {
            return;
        }
        if (tj2Var == null) {
            cf2Var.throwJSException(jSExceptionType, str2 + str);
            return;
        }
        int i = tj2Var.a;
        if (i != 0) {
            JSExceptionType C = C(i);
            cf2Var.throwJSException(C, str2 + tj2Var.b);
        }
    }

    public static void e(String str, String str2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, null, str, str2) == null) {
            try {
                new File(str2).mkdirs();
                String[] list = new File(str).list();
                for (int i = 0; i < list.length; i++) {
                    if (str.endsWith(File.separator)) {
                        file = new File(str + list[i]);
                    } else {
                        file = new File(str + File.separator + list[i]);
                    }
                    if (file.isFile()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName());
                        byte[] bArr = new byte[5120];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        yn4.d(fileOutputStream);
                        yn4.d(fileInputStream);
                    }
                    if (file.isDirectory()) {
                        e(str + "/" + list[i], str2 + "/" + list[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean h(File file, b bVar) {
        InterceptResult invokeLL;
        boolean delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, file, bVar)) == null) {
            if (bVar == null) {
                bVar = new b();
            }
            if (file == null) {
                return false;
            }
            boolean z = true;
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                long z2 = z(file);
                delete = file.delete();
                if (delete) {
                    bVar.a += z2;
                }
            } else if (!file.isDirectory()) {
                return true;
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= h(file2, bVar);
                    }
                }
                delete = file.delete();
            }
            return z & delete;
        }
        return invokeLL.booleanValue;
    }

    public static List<String> o(String str, boolean z) {
        InterceptResult invokeLZ;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65581, null, str, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            if (file.isFile()) {
                arrayList.add(file.getAbsolutePath());
                return arrayList;
            }
            LinkedList linkedList = new LinkedList();
            File[] listFiles2 = file.listFiles();
            for (int i = 0; i < listFiles2.length; i++) {
                if (listFiles2[i] != null) {
                    if (listFiles2[i].isDirectory()) {
                        linkedList.add(listFiles2[i]);
                    }
                    if (z || listFiles2[i].isFile()) {
                        arrayList.add(listFiles2[i].getAbsolutePath());
                    }
                }
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.removeFirst();
                if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (listFiles[i2].isDirectory()) {
                            linkedList.add(listFiles[i2]);
                        }
                        if (z || listFiles[i2].isFile()) {
                            arrayList.add(listFiles[i2].getAbsolutePath());
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            String str = "";
            if (appContext == null) {
                return "";
            }
            String s = s(appContext);
            u73 M = u73.M();
            if (M == null) {
                return s;
            }
            String g0 = u73.g0();
            String k0 = M.k0();
            if (M.N() != null) {
                str = M.N().d();
            }
            String i = br2.h0().i(appContext);
            StringBuilder sb = new StringBuilder();
            sb.append(s(appContext));
            sb.append(File.separator);
            if (TextUtils.isEmpty(str)) {
                str = i;
            }
            sb.append(str);
            sb.append("/aigames/swancache/");
            sb.append(g0);
            sb.append(File.separator);
            sb.append(k0);
            sb.append(File.separator);
            sb.append("code");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
