package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements c {
    final /* synthetic */ WaittingActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WaittingActivity waittingActivity, String str) {
        this.a = waittingActivity;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.randchat.c
    public final void a() {
        boolean z;
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        z = this.a.g;
        if (!z) {
            buVar = this.a.b;
            RandChatRoomData f = buVar.f();
            buVar2 = this.a.b;
            int g = buVar2.g();
            WaittingActivity waittingActivity = this.a;
            buVar3 = this.a.b;
            String h = buVar3.h();
            buVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, buVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
