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
/* loaded from: classes4.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public a0(Context context) {
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

    public static a0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (a0.class) {
                    if (b == null) {
                        b = new a0(context);
                    }
                }
            }
            return b;
        }
        return (a0) invokeL.objValue;
    }

    @TargetApi(29)
    public int delete(Uri uri, String str, String[] strArr, y yVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, str, strArr, yVar)) == null) {
            try {
                return this.a.getContentResolver().delete(uri, str, strArr);
            } catch (RecoverableSecurityException e) {
                b0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, null, str, strArr, yVar, 1);
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }

    public int delete(Uri uri, String str, String[] strArr, String str2, y yVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr, str2, yVar)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                } catch (RecoverableSecurityException e) {
                    e = e;
                }
                try {
                    return this.a.getContentResolver().delete(uri, str, strArr);
                } catch (RecoverableSecurityException e2) {
                    e = e2;
                    b0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, null, str, strArr, yVar, 1);
                    return 0;
                }
            } else if (!b0.e(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                yVar.onFailed(1);
                Log.e("MediaFileProcessor", "delete: " + str2 + " 删除失败, 需要申请存储权限");
                return 0;
            } else {
                File file = new File(str2);
                if (!file.exists()) {
                    yVar.onFailed(2);
                    Log.e("MediaFileProcessor", file.getAbsolutePath() + " 删除文件不存在");
                    return 0;
                }
                return c0.c(file);
            }
        }
        return invokeLLLLL.intValue;
    }

    public Uri insert(InputStream inputStream, MediaFileProcessor.UriSource uriSource, ContentValues contentValues, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, uriSource, contentValues, str)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                Uri a = MediaFileProcessor.a(uriSource);
                contentValues.put("is_pending", (Integer) 1);
                ContentResolver contentResolver = this.a.getContentResolver();
                Uri insert = contentResolver.insert(a, contentValues);
                if (insert == null) {
                    Log.e("MediaFileProcessor", " 添加" + str + "文件失败， uri返回为null");
                    return null;
                }
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, "w", null);
                    c0.b(inputStream, openFileDescriptor.getFileDescriptor());
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
            } else if (!b0.e(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Log.e("MediaFileProcessor", "insert: " + str + " 添加失败, 需要申请存储权限");
                return null;
            } else {
                File file = new File(str);
                c0.a(inputStream, file);
                return Uri.fromFile(file);
            }
        }
        return (Uri) invokeLLLL.objValue;
    }

    @TargetApi(29)
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr, y yVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, uri, contentValues, str, strArr, yVar)) == null) {
            try {
                return this.a.getContentResolver().update(uri, contentValues, str, strArr);
            } catch (RecoverableSecurityException e) {
                b0.b().g(this.a, e.getUserAction().getActionIntent().getIntentSender(), uri, contentValues, str, strArr, yVar, 2);
                return 0;
            }
        }
        return invokeLLLLL.intValue;
    }
}
