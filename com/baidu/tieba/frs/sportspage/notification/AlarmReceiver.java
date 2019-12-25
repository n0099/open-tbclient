package com.baidu.tieba.frs.sportspage.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("KEY_MATCH_ID");
            String stringExtra2 = intent.getStringExtra("KEY_MATCH_TYPE");
            String stringExtra3 = intent.getStringExtra("KEY_MATCH_NAME");
            String str = "";
            if ("football".equals(stringExtra2)) {
                str = "dqd";
            } else if ("basketball".equals(stringExtra2)) {
                str = "bkb";
            }
            String str2 = "";
            try {
                str2 = URLEncoder.encode(context.getString(R.string.sport_ai_app_name), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String str3 = "tiebaclient://swan/Rz2DrtP6l7EcuE3rRzeAscUxQk3Zvphj/pages/fbLive/fbLive/?match_id=" + stringExtra + "&type=" + str + "/?_baiduboxapp=%7B%22from%22:%221191003800000000%22%7D&callback=_bdbox_js_275&upgrade=0&tbcfrom=web_search&swanName=" + str2;
            try {
                Intent intent2 = new Intent(context, DealIntentService.class);
                intent2.putExtra(DealIntentService.KEY_CLASS, 37);
                intent2.putExtra(IntentConfig.KEY_AI_APP_SCHEMA, str3);
                NotificationHelper.showNotification(context, 2001, stringExtra3 + context.getString(R.string.match_is_to_begin), "", "", PendingIntent.getService(context, 2001, intent2, 134217728), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
