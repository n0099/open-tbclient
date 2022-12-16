package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes4.dex */
public final class hb0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, List<gb0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    @JvmOverloads
    public static final gb0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(null, str, 1, null) : (gb0) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817811, "Lcom/baidu/tieba/hb0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817811, "Lcom/baidu/tieba/hb0;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
    }

    @JvmStatic
    @JvmOverloads
    public static final gb0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "getPlayer pageId= " + str2 + WebvttCueParser.CHAR_SPACE + a.size());
            List<gb0> list = a.get(str2);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.isEmpty() && list.size() >= 2) {
                gb0 gb0Var = list.get(0);
                Collections.swap(list, 0, 1);
                if (gb0Var.isPlaying()) {
                    gb0Var.detachFromContainer();
                    gb0Var.stop();
                }
                LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "getPlayer " + gb0Var);
                return gb0Var;
            }
            gb0 gb0Var2 = new gb0(new ib0(str, 0, null, null, 14, null));
            list.add(gb0Var2);
            a.put(str2, list);
            return gb0Var2;
        }
        return (gb0) invokeLL.objValue;
    }

    public static /* synthetic */ gb0 c(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return b(str, str2);
    }

    @JvmStatic
    public static final void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "release playerMap= " + a.size());
            List<gb0> list = a.get(str);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            for (gb0 gb0Var : list) {
                gb0Var.detachFromContainer();
                gb0Var.release();
            }
            list.clear();
            a.remove(str);
        }
    }
}
