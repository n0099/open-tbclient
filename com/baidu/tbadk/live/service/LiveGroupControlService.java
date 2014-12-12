package com.baidu.tbadk.live.service;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.live.LiveGroupManager;
import com.baidu.tbadk.live.LiveGroupNotifyManager;
/* loaded from: classes.dex */
public class LiveGroupControlService extends BdBaseService {
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
            String stringExtra = intent.getStringExtra("group_name");
            GroupData groupData = (GroupData) intent.getSerializableExtra("group");
            String stringExtra2 = intent.getStringExtra("forum_name");
            String stringExtra3 = intent.getStringExtra(KEY_LIVE_URL);
            if (intent.getAction().equals(ACTION_LIVE_CLOSE)) {
                LiveGroupManager.getInstance().stopPlayLive(String.valueOf(groupData.getGroupId()));
                LiveGroupNotifyManager.getInstance().cancelAll(getApplicationContext());
            } else if (intent.getAction().equals(ACTION_LIVE_PAUSE)) {
                LiveGroupManager.getInstance().stopPlayLive(String.valueOf(groupData.getGroupId()));
                LiveGroupNotifyManager.getInstance().cancelAll(getApplicationContext());
                LiveGroupNotifyManager.getInstance().notifyShowPlay(getApplicationContext(), stringExtra, groupData, stringExtra2, stringExtra3);
            } else if (intent.getAction().equals(ACTION_LIVE_PLAY)) {
                LiveGroupManager.getInstance().startPlayLive(String.valueOf(groupData.getGroupId()), stringExtra3);
                LiveGroupNotifyManager.getInstance().cancelAll(getApplicationContext());
                LiveGroupNotifyManager.getInstance().notifyShowPause(getApplicationContext(), stringExtra, groupData, stringExtra2, stringExtra3);
            }
            stopSelf();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
