package com.baidu.tieba.im.live.room;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestAddLiveGroupMessage;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.b {
    private LiveRoomEntranceActivity a;
    private RequestAddLiveGroupMessage b;
    private int c;
    private String d;
    private String e;
    private int f = 21;

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.e = str;
    }

    public ay(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        this.a = liveRoomEntranceActivity;
    }

    public void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
            this.d = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
            return;
        }
        this.c = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, 0);
        this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
    }

    public void b() {
        this.b = new RequestAddLiveGroupMessage();
        this.b.forumId = this.c;
        this.b.name = this.e;
        this.b.groupType = this.f;
        this.b.publisherName = TbadkApplication.getCurrentAccountName();
        this.b.publisherId = com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0);
        this.a.sendMessage(this.b);
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }
}
