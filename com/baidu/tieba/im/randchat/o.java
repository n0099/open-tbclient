package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.cb;
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
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        cb cbVar4;
        z = this.a.g;
        if (!z) {
            cbVar = this.a.b;
            RandChatRoomData f = cbVar.f();
            cbVar2 = this.a.b;
            int g = cbVar2.g();
            WaittingActivity waittingActivity = this.a;
            cbVar3 = this.a.b;
            String h = cbVar3.h();
            cbVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, cbVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
