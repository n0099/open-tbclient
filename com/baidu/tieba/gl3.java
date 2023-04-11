package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class gl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, context, file) != null) || !file.exists()) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.setAction("android.intent.action.SEND");
        intent.setTypeAndNormalize(ol3.s(file));
        if (Build.VERSION.SDK_INT >= 24) {
            intent.putExtra("android.intent.extra.STREAM", rl3.a(context, file));
            intent.addFlags(1);
        } else {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        }
        context.startActivity(intent);
    }
}
