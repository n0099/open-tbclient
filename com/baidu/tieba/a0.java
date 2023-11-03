package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
@SuppressLint({"NewApi"})
@Deprecated
/* loaded from: classes5.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @TargetApi(29)
    public static ParcelFileDescriptor a(Context context, Uri uri, String str, b0 b0Var) throws FileNotFoundException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, uri, str, b0Var)) == null) {
            try {
                return context.getContentResolver().openFileDescriptor(uri, str);
            } catch (RecoverableSecurityException e) {
                e0.b().h(context, e.getUserAction().getActionIntent().getIntentSender(), uri, str, null, b0Var, 3);
                return null;
            }
        }
        return (ParcelFileDescriptor) invokeLLLL.objValue;
    }
}
