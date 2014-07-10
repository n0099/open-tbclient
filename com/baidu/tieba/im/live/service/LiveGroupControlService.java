package com.baidu.tieba.im.live.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.live.p;
/* loaded from: classes.dex */
public class LiveGroupControlService extends Service {
    public static final String ACTION_LIVE_CLOSE = "com.baidu.tieba.im.live.service.close";
    public static final String ACTION_LIVE_PAUSE = "com.baidu.tieba.im.live.service.pause";
    public static final String ACTION_LIVE_PLAY = "com.baidu.tieba.im.live.service.play";
    public static final String KEY_LIVE_URL = "KEY_LIVE_URL";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getAction() != null) {
            String stringExtra = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            GroupData groupData = (GroupData) intent.getSerializableExtra("group");
            String stringExtra2 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
            String stringExtra3 = intent.getStringExtra(KEY_LIVE_URL);
            if (intent.getAction().equals(ACTION_LIVE_CLOSE)) {
                com.baidu.tieba.im.live.d.b().d(String.valueOf(groupData.getGroupId()));
                p.a().a(getApplicationContext());
            } else if (intent.getAction().equals(ACTION_LIVE_PAUSE)) {
                com.baidu.tieba.im.live.d.b().d(String.valueOf(groupData.getGroupId()));
                p.a().a(getApplicationContext());
                p.a().a(getApplicationContext(), stringExtra, groupData, stringExtra2, stringExtra3);
            } else if (intent.getAction().equals(ACTION_LIVE_PLAY)) {
                com.baidu.tieba.im.live.d.b().a(String.valueOf(groupData.getGroupId()), stringExtra3);
                p.a().a(getApplicationContext());
                p.a().b(getApplicationContext(), stringExtra, groupData, stringExtra2, stringExtra3);
            }
            stopSelf();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
