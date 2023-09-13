package com.baidu.tieba;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d54 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) ? f <= 1.0f && f >= 0.0f : invokeF.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655526, "Lcom/baidu/tieba/d54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655526, "Lcom/baidu/tieba/d54;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("494433", ".mp3");
        a.put("524946", ".wav");
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String e = e();
            if (j() && !TextUtils.isEmpty(e)) {
                return e;
            }
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr != null && bArr.length > 0) {
                for (byte b : bArr) {
                    String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                    if (upperCase.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(upperCase);
                }
                String sb2 = sb.toString();
                if (rr1.a) {
                    Log.e("AudioDataUtils", "audio buffer header: " + sb2);
                }
                return sb2;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf);
            } else {
                str2 = "";
            }
            return "/" + hb3.g0() + "/" + str.hashCode() + str2;
        }
        return (String) invokeL.objValue;
    }

    public static b54 c(e54 e54Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e54Var)) == null) {
            b54 b54Var = new b54();
            b54Var.a = e54Var.b;
            b54Var.e = e54Var.autoplay;
            b54Var.f = e54Var.loop;
            b54Var.c = e54Var.src;
            b54Var.d = e54Var.startTime;
            b54Var.g = e54Var.obeyMuteSwitch;
            b54Var.i = e54Var.volume;
            b54Var.j = i().toString();
            return b54Var;
        }
        return (b54) invokeL.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr != null && 3 <= bArr.length) {
                byte[] bArr2 = new byte[3];
                for (int i = 0; i < 3; i++) {
                    bArr2[i] = bArr[i];
                }
                return a.get(a(bArr2));
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = rn2.p() + "/usr";
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return File.separator + "bdata" + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return "mounted".equals(Environment.getExternalStorageState());
        }
        return invokeV.booleanValue;
    }

    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onCanplay", "canplay");
                jSONObject.put("onPlay", "play");
                jSONObject.put("onEnded", "ended");
                jSONObject.put(MissionEvent.MESSAGE_PAUSE, DownloadStatisticConstants.UBC_TYPE_PAUSE);
                jSONObject.put("onSeeking", "seeking");
                jSONObject.put("onSeeked", "seeked");
                jSONObject.put(MissionEvent.MESSAGE_STOP, "stop");
                jSONObject.put(GameAssistConstKt.TYPE_CALLBACK_ERROR, "error");
                jSONObject.put("onTimeUpdate", "timeupdate");
                jSONObject.put("onBufferingUpdate", "buffered");
                jSONObject.put("onWaiting", "waiting");
            } catch (Exception e) {
                if (rr1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
