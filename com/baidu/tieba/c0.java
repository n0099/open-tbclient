package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.RecoverableSecurityException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public c0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static c0 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (c0.class) {
                    if (b == null) {
                        b = new c0(context);
                    }
                }
            }
            return b;
        }
        return (c0) invokeL.objValue;
    }

    @TargetApi(29)
    public int a(Uri uri, String str, String[] strArr, a0 a0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, str, strArr, a0Var)) == null) {
            try {
                return this.a.getContentResolver().delete(uri, str, strArr);
            } catch (RecoverableSecurityException e) {
                d0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, null, str, strArr, a0Var, 1);
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }

    public int b(Uri uri, String str, String[] strArr, String str2, a0 a0Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr, str2, a0Var)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                } catch (RecoverableSecurityException e) {
                    e = e;
                }
                try {
                    return this.a.getContentResolver().delete(uri, str, strArr);
                } catch (RecoverableSecurityException e2) {
                    e = e2;
                    d0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, null, str, strArr, a0Var, 1);
                    return 0;
                }
            } else if (!d0.e(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                a0Var.onFailed(1);
                Log.e("MediaFileProcessor", "delete: " + str2 + " 删除失败, 需要申请存储权限");
                return 0;
            } else {
                File file = new File(str2);
                if (!file.exists()) {
                    a0Var.onFailed(2);
                    Log.e("MediaFileProcessor", file.getAbsolutePath() + " 删除文件不存在");
                    return 0;
                }
                return e0.c(file);
            }
        }
        return invokeLLLLL.intValue;
    }

    public Uri d(InputStream inputStream, MediaFileProcessor.UriSource uriSource, ContentValues contentValues, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, uriSource, contentValues, str)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                Uri c = MediaFileProcessor.c(uriSource);
                contentValues.put("is_pending", (Integer) 1);
                ContentResolver contentResolver = this.a.getContentResolver();
                Uri insert = contentResolver.insert(c, contentValues);
                if (insert == null) {
                    Log.e("MediaFileProcessor", " 添加" + str + "文件失败， uri返回为null");
                    return null;
                }
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, "w", null);
                    e0.b(inputStream, openFileDescriptor.getFileDescriptor());
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                return insert;
            } else if (!d0.e(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Log.e("MediaFileProcessor", "insert: " + str + " 添加失败, 需要申请存储权限");
                return null;
            } else {
                File file = new File(str);
                e0.a(inputStream, file);
                return Uri.fromFile(file);
            }
        }
        return (Uri) invokeLLLL.objValue;
    }

    @TargetApi(29)
    public int e(Uri uri, ContentValues contentValues, String str, String[] strArr, a0 a0Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, uri, contentValues, str, strArr, a0Var)) == null) {
            try {
                return this.a.getContentResolver().update(uri, contentValues, str, strArr);
            } catch (RecoverableSecurityException e) {
                d0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, contentValues, str, strArr, a0Var, 2);
                return 0;
            }
        }
        return invokeLLLLL.intValue;
    }
}
