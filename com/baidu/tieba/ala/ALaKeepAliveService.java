package com.baidu.tieba.ala;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.base.BdBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ALaKeepAliveService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CONTENT_TEXT = "content_text";
    public static final String KEY_CONTENT_TITLE = "content_title";
    public static final String KEY_NOTIFICATION_ID = "notification_id";
    public static final String KEY_TICKER = "ticker";
    public transient /* synthetic */ FieldHolder $fh;

    public ALaKeepAliveService() {
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

    public static void startService(Context context, String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2)}) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, ALaKeepAliveService.class);
        intent.setPackage(context.getPackageName());
        intent.putExtra(KEY_CONTENT_TITLE, str);
        intent.putExtra(KEY_CONTENT_TEXT, str2);
        intent.putExtra(KEY_TICKER, str3);
        if (i2 != 0) {
            intent.putExtra(KEY_NOTIFICATION_ID, i2);
        }
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, intent, i2, i3)) == null) {
            if (intent == null) {
                startForeground(Integer.MAX_VALUE, new Notification());
            } else {
                String stringExtra = intent.getStringExtra(KEY_CONTENT_TITLE);
                String stringExtra2 = intent.getStringExtra(KEY_CONTENT_TEXT);
                String stringExtra3 = intent.getStringExtra(KEY_TICKER);
                int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, Integer.MAX_VALUE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setContentTitle(stringExtra).setContentText(stringExtra2).setSmallIcon(R.drawable.ic_icon_foreground).setTicker(stringExtra3);
                startForeground(intExtra, builder.build());
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
