package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class fi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, file) == null) && file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                    return;
                }
                return;
            }
            String absolutePath = file.getAbsolutePath();
            if (file.delete()) {
                BdLog.v("Abi64WebViewCompat:Delete[" + absolutePath + PreferencesUtil.RIGHT_MOUNT);
                return;
            }
            BdLog.e("Abi64WebViewCompat:Delete[" + absolutePath + "]Error!");
        }
    }

    public static void b(@NonNull Context context) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, context) != null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            context.getApplicationContext().getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
            File filesDir = context.getFilesDir();
            if (filesDir != null && filesDir.getParent() != null) {
                File file = new File(filesDir.getParent());
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        String absolutePath = file2.getAbsolutePath();
                        if (!TextUtils.isEmpty(absolutePath) && absolutePath.toLowerCase().contains(AlbumActivityConfig.FROM_WEB_VIEW)) {
                            a(file2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
