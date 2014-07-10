package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.RequestLiveGroupHistoryMessage;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.e {
    private String a;
    private int b;
    private int c;
    private LiveCardData d;

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public LiveCardData d() {
        return this.d;
    }

    public void a(LiveCardData liveCardData) {
        this.d = liveCardData;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Bundle bundle) {
    }

    public void a(String str, int i, int i2) {
        RequestLiveGroupHistoryMessage requestLiveGroupHistoryMessage = new RequestLiveGroupHistoryMessage();
        requestLiveGroupHistoryMessage.setGroupId(com.baidu.adp.lib.f.b.a(str, 0L));
        requestLiveGroupHistoryMessage.setOffset(i);
        requestLiveGroupHistoryMessage.setRn(i2);
        super.sendMessage(requestLiveGroupHistoryMessage);
    }

    public void a(Intent intent) {
        this.a = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
    }

    public void b(Bundle bundle) {
        this.a = bundle.getString(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
    }
}
