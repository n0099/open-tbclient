package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements com.baidu.tieba.im.view.d {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.view.d
    public final void a(String str, String str2, boolean z) {
        bu buVar;
        bu buVar2;
        buVar = this.a.b;
        RandChatRoomData f = buVar.f();
        if (f != null) {
            buVar2 = this.a.b;
            buVar2.a(f.d(), str, str2, z);
        }
    }
}
