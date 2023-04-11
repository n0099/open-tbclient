package com.baidu.tieba;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.tieba.b50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, b50.a aVar) {
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            try {
                Uri parse = Uri.parse("content://cn.nubia.identity/identity");
                if (Build.VERSION.SDK_INT > 17) {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient != null) {
                        call = acquireContentProviderClient.call("getOAID", null, null);
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireContentProviderClient.close();
                        } else {
                            acquireContentProviderClient.release();
                        }
                    } else {
                        call = null;
                    }
                } else {
                    call = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
                }
                aVar.a(true, (call == null || call.getInt("code", -1) != 0) ? null : call.getString("id"));
            } catch (Throwable unused) {
                aVar.a(false, null);
            }
        }
    }
}
