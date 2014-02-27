package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements c {
    final /* synthetic */ WaittingActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WaittingActivity waittingActivity, String str) {
        this.a = waittingActivity;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.randchat.c
    public final void a() {
        boolean z;
        ar arVar;
        ar arVar2;
        ar arVar3;
        ar arVar4;
        z = this.a.g;
        if (!z) {
            arVar = this.a.b;
            RandChatRoomData f = arVar.f();
            arVar2 = this.a.b;
            int g = arVar2.g();
            WaittingActivity waittingActivity = this.a;
            arVar3 = this.a.b;
            String h = arVar3.h();
            arVar4 = this.a.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, arVar4.i(), this.b, g);
            this.a.finish();
            this.a.g = true;
        }
    }
}
