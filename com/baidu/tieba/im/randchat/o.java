package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bv;
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
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        z = this.a.g;
        if (!z) {
            bvVar = this.a.b;
            RandChatRoomData f = bvVar.f();
            bvVar2 = this.a.b;
            int g = bvVar2.g();
            WaittingActivity waittingActivity = this.a;
            bvVar3 = this.a.b;
            String h = bvVar3.h();
            bvVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, bvVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
