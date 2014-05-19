package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ca;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c {
    final /* synthetic */ WaittingActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WaittingActivity waittingActivity, String str) {
        this.a = waittingActivity;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.randchat.c
    public void a() {
        boolean z;
        ca caVar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        z = this.a.g;
        if (!z) {
            caVar = this.a.b;
            RandChatRoomData f = caVar.f();
            caVar2 = this.a.b;
            int g = caVar2.g();
            WaittingActivity waittingActivity = this.a;
            caVar3 = this.a.b;
            String h = caVar3.h();
            caVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, caVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
