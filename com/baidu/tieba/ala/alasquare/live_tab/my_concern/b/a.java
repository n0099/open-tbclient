package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class a {
    public static boolean k(TbPageContext tbPageContext) {
        return NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
    }

    public static void l(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", tbPageContext.getPageActivity().getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", tbPageContext.getPageActivity().getApplicationInfo().uid);
            intent.putExtra("app_package", tbPageContext.getPageActivity().getPackageName());
            intent.putExtra("app_uid", tbPageContext.getPageActivity().getApplicationInfo().uid);
            tbPageContext.getPageActivity().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", tbPageContext.getPageActivity().getPackageName(), null));
            tbPageContext.getPageActivity().startActivity(intent2);
        }
    }
}
