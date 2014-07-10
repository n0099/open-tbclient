package com.baidu.tieba.im.live;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.im.live.room.LiveRoomChatActivity;
import com.baidu.tieba.im.live.service.LiveGroupControlService;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class p {
    public static p a = new p();

    private p() {
    }

    public static p a() {
        return a;
    }

    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return bb.a(context, 20);
    }

    public boolean a(Context context, boolean z, int i, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        if (bb.a() && !z) {
            return bb.a(context, 20, str, str, a(context, groupData, str2), a(context, str, groupData, str2, str3, false), true);
        }
        return bb.a(context, 20, str, context.getResources().getString(i), str, a(context, groupData, str2), true);
    }

    public boolean a(Context context, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        return bb.a(context, 20, str, str, a(context, groupData, str2), a(context, str, groupData, str2, str3, true), true);
    }

    public boolean b(Context context, String str, GroupData groupData, String str2, String str3) {
        if (context == null || str == null || groupData == null || str2 == null || str3 == null) {
            return false;
        }
        return bb.a(context, 20, str, str, a(context, groupData, str2), a(context, str, groupData, str2, str3, false), true);
    }

    private PendingIntent a(Context context, GroupData groupData, String str) {
        Intent intent = new Intent(context, LiveRoomChatActivity.class);
        intent.setFlags(335544320);
        intent.putExtra("gid", groupData.getGroupId());
        intent.putExtra("group", groupData);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
        return PendingIntent.getActivity(context, y.app_name, intent, 134217728);
    }

    private RemoteViews a(Context context, String str, GroupData groupData, String str2, String str3, boolean z) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), w.noti_live_bar);
        remoteViews.setTextViewText(v.noti_live_title, str);
        remoteViews.setTextViewText(v.noti_live_content, context.getResources().getString(y.live_room_notify));
        if (z) {
            remoteViews.setViewVisibility(v.noti_live_btn_pause, 8);
            Intent c = c(context, str, groupData, str2, str3);
            c.setAction(LiveGroupControlService.ACTION_LIVE_PLAY);
            remoteViews.setOnClickPendingIntent(v.noti_live_btn_play, PendingIntent.getService(context, v.noti_live_btn_play, c, 134217728));
        } else {
            remoteViews.setViewVisibility(v.noti_live_btn_play, 8);
            Intent c2 = c(context, str, groupData, str2, str3);
            c2.setAction(LiveGroupControlService.ACTION_LIVE_PAUSE);
            remoteViews.setOnClickPendingIntent(v.noti_live_btn_pause, PendingIntent.getService(context, v.noti_live_btn_pause, c2, 134217728));
        }
        Intent c3 = c(context, str, groupData, str2, str3);
        c3.setAction(LiveGroupControlService.ACTION_LIVE_CLOSE);
        remoteViews.setOnClickPendingIntent(v.noti_live_btn_close, PendingIntent.getService(context, v.noti_live_btn_close, c3, 134217728));
        return remoteViews;
    }

    private Intent c(Context context, String str, GroupData groupData, String str2, String str3) {
        Intent intent = new Intent(context, LiveGroupControlService.class);
        intent.putExtra("gid", groupData.getGroupId());
        intent.putExtra("group", groupData);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str2);
        intent.putExtra(LiveGroupControlService.KEY_LIVE_URL, str3);
        return intent;
    }
}
