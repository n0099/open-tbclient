package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class ct5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947686309, "Lcom/baidu/tieba/ct5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947686309, "Lcom/baidu/tieba/ct5;");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0031 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x000f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStream] */
    @JvmStatic
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String a(Context context, String fileName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, fileName)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            InputStream inputStream = null;
            try {
                try {
                    context = context.getAssets().open(fileName);
                    try {
                        byte[] bArr = new byte[context.available()];
                        context.read(bArr);
                        String str = new String(bArr, Charsets.UTF_8);
                        if (context != 0) {
                            context.close();
                        }
                        return str;
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e);
                        if (context == 0) {
                            return null;
                        }
                        context.close();
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = context;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                context = 0;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }
}
