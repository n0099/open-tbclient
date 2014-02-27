package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements com.baidu.tieba.view.l {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.view.l
    public final void a(String str, String str2, boolean z) {
        ar arVar;
        ar arVar2;
        arVar = this.a.b;
        RandChatRoomData f = arVar.f();
        if (f != null) {
            arVar2 = this.a.b;
            arVar2.a(f.d(), str, str2, z);
        }
    }
}
