package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import c.a.p0.r0.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isPluginSetted;

    public GameCenterDownloadProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isPluginSetted = false;
    }

    private void setPlugin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.isPluginSetted) {
            return;
        }
        MessageManager.getInstance().runTask(new CustomMessage<>(2016518, this), (Class) null);
        if (a.b() != null) {
            a.b().onCreate();
            this.isPluginSetted = true;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            setPlugin();
            if (a.b() != null) {
                try {
                    return a.b().delete(uri, str, strArr);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return 0;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            setPlugin();
            if (a.b() != null) {
                try {
                    return a.b().getType(uri);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValues)) == null) {
            setPlugin();
            if (a.b() != null) {
                try {
                    return a.b().insert(uri, contentValues);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            setPlugin();
            if (a.b() != null) {
                try {
                    return a.b().query(uri, strArr, str, strArr2, str2);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            }
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            setPlugin();
            if (a.b() != null) {
                try {
                    return a.b().update(uri, contentValues, str, strArr);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return 0;
                }
            }
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
