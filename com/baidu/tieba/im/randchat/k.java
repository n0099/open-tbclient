package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c {
    final /* synthetic */ String a;
    final /* synthetic */ WaittingActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WaittingActivity waittingActivity, String str) {
        this.b = waittingActivity;
        this.a = str;
    }

    @Override // com.baidu.tieba.im.randchat.c
    public void a() {
        boolean z;
        ar arVar;
        ar arVar2;
        ar arVar3;
        ar arVar4;
        z = this.b.g;
        if (!z) {
            arVar = this.b.b;
            RandChatRoomData f = arVar.f();
            arVar2 = this.b.b;
            int g = arVar2.g();
            WaittingActivity waittingActivity = this.b;
            arVar3 = this.b.b;
            String h = arVar3.h();
            arVar4 = this.b.b;
            SnapGroupChatActivity.a(waittingActivity, f, h, arVar4.i(), this.a, g);
            this.b.finish();
            this.b.g = true;
        }
    }
}
