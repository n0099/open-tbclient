package com.baidu.tieba.frs.sportspage.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlarmReceiver() {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_MATCH_ID");
        String stringExtra2 = intent.getStringExtra("KEY_MATCH_TYPE");
        String stringExtra3 = intent.getStringExtra("KEY_MATCH_NAME");
        String str2 = "";
        if ("football".equals(stringExtra2)) {
            str = "dqd";
        } else if (!"basketball".equals(stringExtra2)) {
            str = "";
        } else {
            str = "bkb";
        }
        try {
            str2 = URLEncoder.encode(context.getString(R.string.obfuscated_res_0x7f0f141a), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String str3 = "tiebaclient://swan/Rz2DrtP6l7EcuE3rRzeAscUxQk3Zvphj/pages/fbLive/fbLive/?match_id=" + stringExtra + "&type=" + str + "/?_baiduboxapp=%7B%22from%22:%221191003800000000%22%7D&callback=_bdbox_js_275&upgrade=0&tbcfrom=web_search&swanName=" + str2;
        try {
            Intent intent2 = new Intent(context, DealIntentService.class);
            intent2.putExtra("class", 37);
            intent2.putExtra(IntentConfig.KEY_AI_APP_SCHEMA, str3);
            NotificationHelper.showNotification(context, 2001, stringExtra3 + context.getString(R.string.obfuscated_res_0x7f0f0c4c), "", "", PendingIntent.getService(context, 2001, intent2, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
