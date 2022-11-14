package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class gw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (str == null && str2 == null) {
                return 0;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            if (str == null) {
                return -1;
            }
            if (str.equals(str2)) {
                return 0;
            }
            if (str.startsWith(str2)) {
                return 1;
            }
            if (str2.startsWith(str)) {
                return -1;
            }
            String[] split = str.split("\\.|-");
            String[] split2 = str2.split("\\.|-");
            if (split.length <= split2.length) {
                length = split.length;
            } else {
                length = split2.length;
            }
            for (int i = 0; i < length; i++) {
                try {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split2[i]);
                    Integer.parseInt(split[i]);
                    Integer.parseInt(split2[i]);
                    if (parseInt > parseInt2) {
                        return 1;
                    }
                    if (parseInt < parseInt2) {
                        return -1;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            if (split.length > length) {
                return 1;
            }
            if (split2.length > length) {
                return -1;
            }
            return str.compareTo(str2);
        }
        return invokeLL.intValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context != null && str != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(Context context, Class<? extends Activity> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, cls)) == null) {
            if (context != null && cls != null) {
                try {
                    context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), cls.getName()), 0);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean e(android.content.Context r4, android.content.Intent r5) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.gw9.$ic
            if (r0 != 0) goto L1a
        L4:
            r0 = 0
            if (r4 == 0) goto L19
            if (r5 != 0) goto La
            goto L19
        La:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Exception -> L19
            java.util.List r4 = r4.queryIntentActivities(r5, r0)     // Catch: java.lang.Exception -> L19
            int r4 = r4.size()     // Catch: java.lang.Exception -> L19
            if (r4 <= 0) goto L19
            r0 = 1
        L19:
            return r0
        L1a:
            r1 = r0
            r2 = 65540(0x10004, float:9.1841E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeLL(r2, r3, r4, r5)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.gw9.e(android.content.Context, android.content.Intent):boolean");
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo.packageName + "(" + packageInfo.versionName + SmallTailInfo.EMOTION_SUFFIX;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
