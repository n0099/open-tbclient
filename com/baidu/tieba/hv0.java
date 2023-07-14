package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.tieba.gv0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "CloudClarityConfig")
/* loaded from: classes6.dex */
public final class hv0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837031, "Lcom/baidu/tieba/hv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837031, "Lcom/baidu/tieba/hv0;");
                return;
            }
        }
        a = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sd", ClarityUrlList.ClarityUrl.KEY_HD, "sc", ClarityUrlList.ClarityUrl.KEY_1080P});
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String mobileNetClarity = c31.c();
            if (a.contains(mobileNetClarity)) {
                Intrinsics.checkNotNullExpressionValue(mobileNetClarity, "mobileNetClarity");
                return mobileNetClarity;
            }
            return "sd";
        }
        return (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String wifiClarity = c31.e();
            if (a.contains(wifiClarity)) {
                Intrinsics.checkNotNullExpressionValue(wifiClarity, "wifiClarity");
                return wifiClarity;
            }
            return "sc";
        }
        return (String) invokeV.objValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TextUtils.equals("1", c31.d())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final Pair<Integer, Integer> a(com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            String b = b(true);
            int i = 0;
            String b2 = b(false);
            int size = list.size() - 1;
            int i2 = 0;
            for (ClarityUrlList.c entity : list) {
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                if (TextUtils.equals(entity.c(), b)) {
                    i = i2;
                } else if (TextUtils.equals(entity.c(), b2)) {
                    size = i2;
                }
                i2++;
            }
            return new Pair<>(Integer.valueOf(size), Integer.valueOf(i));
        }
        return (Pair) invokeL.objValue;
    }

    public static final String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return f();
            }
            return e();
        }
        return (String) invokeZ.objValue;
    }

    public static final gv0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String a2 = c31.a();
            if (a2 != null) {
                int hashCode = a2.hashCode();
                if (hashCode != 49) {
                    if (hashCode == 50 && a2.equals("2")) {
                        return gv0.a.a;
                    }
                } else if (a2.equals("1")) {
                    return gv0.b.a;
                }
            }
            return gv0.a.a;
        }
        return (gv0) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String condition = c31.b();
            for (String str : a) {
                Intrinsics.checkNotNullExpressionValue(condition, "condition");
                if (StringsKt__StringsKt.contains$default((CharSequence) condition, (CharSequence) str, false, 2, (Object) null)) {
                    return condition;
                }
            }
            return ClarityUrlList.ClarityUrl.KEY_1080P;
        }
        return (String) invokeV.objValue;
    }
}
