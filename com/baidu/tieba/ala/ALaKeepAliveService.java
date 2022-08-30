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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void startService(Context context, String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, str3, Integer.valueOf(i)}) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, ALaKeepAliveService.class);
        intent.setPackage(context.getPackageName());
        intent.putExtra(KEY_CONTENT_TITLE, str);
        intent.putExtra(KEY_CONTENT_TEXT, str2);
        intent.putExtra(KEY_TICKER, str3);
        if (i != 0) {
            intent.putExtra(KEY_NOTIFICATION_ID, i);
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
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, intent, i, i2)) == null) {
            if (intent == null) {
                startForeground(Integer.MAX_VALUE, new Notification());
            } else {
                String stringExtra = intent.getStringExtra(KEY_CONTENT_TITLE);
                String stringExtra2 = intent.getStringExtra(KEY_CONTENT_TEXT);
                String stringExtra3 = intent.getStringExtra(KEY_TICKER);
                int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, Integer.MAX_VALUE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setContentTitle(stringExtra).setContentText(stringExtra2).setSmallIcon(R.drawable.obfuscated_res_0x7f0805d7).setTicker(stringExtra3);
                startForeground(intExtra, builder.build());
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
