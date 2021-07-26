package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.r0.c.a;
/* loaded from: classes3.dex */
public class GameCenterDownloadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GameCenterDownloadService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (a.d() != null) {
                try {
                    return a.d().onBind(intent);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (a.d() != null) {
                a.d().onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016519, this));
            if (a.d() != null) {
                try {
                    a.d().onCreate();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            if (a.d() != null) {
                try {
                    a.d().onDestroy();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onLowMemory();
            if (a.d() != null) {
                a.d().onLowMemory();
            }
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            super.onRebind(intent);
            if (a.d() != null) {
                try {
                    a.d().onRebind(intent);
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, intent, i2) == null) {
            super.onStart(intent, i2);
            if (a.d() != null) {
                try {
                    a.d().onStart(intent, i2);
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, intent, i2, i3)) == null) {
            if (a.d() != null) {
                try {
                    return a.d().onStartCommand(intent, i2, i3);
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent)) == null) {
            if (a.d() != null) {
                try {
                    return a.d().onUnbind(intent);
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
            return super.onUnbind(intent);
        }
        return invokeL.booleanValue;
    }
}
