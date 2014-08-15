package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bf;
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
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        z = this.a.g;
        if (!z) {
            bfVar = this.a.b;
            RandChatRoomData f = bfVar.f();
            bfVar2 = this.a.b;
            int g = bfVar2.g();
            WaittingActivity waittingActivity = this.a;
            bfVar3 = this.a.b;
            String h = bfVar3.h();
            bfVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, bfVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
