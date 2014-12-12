package com.baidu.tbadk.live;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.live.service.LiveGroupControlService;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class LiveGroupNotifyManager {
    public static LiveGroupNotifyManager mManager = new LiveGroupNotifyManager();

    private LiveGroupNotifyManager() {
    }

    public static LiveGroupNotifyManager getInstance() {
        return mManager;
    }

    public boolean cancelAll(Context context) {
        if (context == null) {
            return false;
        }
        return NotificationHelper.cancelNotification(context, 20);
    }

    public boolean notifyGroup(Context context, boolean z, int i, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        if (NotificationHelper.canSupportClickPendingIntent() && !z) {
            return NotificationHelper.showCustomViewNotification(context, 20, str, str, buildPendingIntent(context, groupData, str2), buildRemoteViews(context, str, groupData, str2, str3, false), true);
        }
        return NotificationHelper.showNotification(context, 20, str, context.getResources().getString(i), str, buildPendingIntent(context, groupData, str2), true);
    }

    public boolean notifyShowPlay(Context context, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        return NotificationHelper.showCustomViewNotification(context, 20, str, str, buildPendingIntent(context, groupData, str2), buildRemoteViews(context, str, groupData, str2, str3, true), true);
    }

    public boolean notifyShowPause(Context context, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        return NotificationHelper.showCustomViewNotification(context, 20, str, str, buildPendingIntent(context, groupData, str2), buildRemoteViews(context, str, groupData, str2, str3, false), true);
    }

    private PendingIntent buildPendingIntent(Context context, GroupData groupData, String str) {
        Intent intent = new Intent("com.baidu.tieba.live.LIVEROOMCHAT");
        intent.setFlags(335544320);
        intent.putExtra("gid", groupData.getGroupId());
        intent.putExtra("group", groupData);
        intent.putExtra("forum_name", str);
        return PendingIntent.getActivity(context, z.app_name, intent, 134217728);
    }

    private RemoteViews buildRemoteViews(Context context, String str, GroupData groupData, String str2, String str3, boolean z) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), x.noti_live_bar);
        remoteViews.setTextViewText(w.noti_live_title, str);
        remoteViews.setTextViewText(w.noti_live_content, context.getResources().getString(z.live_room_notify));
        if (z) {
            remoteViews.setViewVisibility(w.noti_live_btn_pause, 8);
            Intent buildIntent = buildIntent(context, str, groupData, str2, str3);
            buildIntent.setAction(LiveGroupControlService.ACTION_LIVE_PLAY);
            remoteViews.setOnClickPendingIntent(w.noti_live_btn_play, PendingIntent.getService(context, w.noti_live_btn_play, buildIntent, 134217728));
        } else {
            remoteViews.setViewVisibility(w.noti_live_btn_play, 8);
            Intent buildIntent2 = buildIntent(context, str, groupData, str2, str3);
            buildIntent2.setAction(LiveGroupControlService.ACTION_LIVE_PAUSE);
            remoteViews.setOnClickPendingIntent(w.noti_live_btn_pause, PendingIntent.getService(context, w.noti_live_btn_pause, buildIntent2, 134217728));
        }
        Intent buildIntent3 = buildIntent(context, str, groupData, str2, str3);
        buildIntent3.setAction(LiveGroupControlService.ACTION_LIVE_CLOSE);
        remoteViews.setOnClickPendingIntent(w.noti_live_btn_close, PendingIntent.getService(context, w.noti_live_btn_close, buildIntent3, 134217728));
        return remoteViews;
    }

    private Intent buildIntent(Context context, String str, GroupData groupData, String str2, String str3) {
        Intent intent = new Intent(context, LiveGroupControlService.class);
        intent.putExtra("gid", groupData.getGroupId());
        intent.putExtra("group", groupData);
        intent.putExtra("group_name", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra(LiveGroupControlService.KEY_LIVE_URL, str3);
        return intent;
    }
}
