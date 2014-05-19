package com.baidu.tieba.im.live.room.intro;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.message.RequestLiveRoomIntroMessage;
/* loaded from: classes.dex */
public class d {
    private int a;
    private int b;
    private String c;

    public d(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public void a(BaseActivity baseActivity) {
        RequestLiveRoomIntroMessage requestLiveRoomIntroMessage = new RequestLiveRoomIntroMessage();
        requestLiveRoomIntroMessage.setGroupId(this.a);
        requestLiveRoomIntroMessage.setPublisherId(this.b);
        MessageManager.getInstance().sendMessage(requestLiveRoomIntroMessage);
    }

    public void a(Bundle bundle, String str) {
        bundle.putInt(str, this.a);
    }

    public void b(Bundle bundle, String str) {
        bundle.putInt(str, this.b);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.c);
    }
}
