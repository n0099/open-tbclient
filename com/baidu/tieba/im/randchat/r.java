package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bv;
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
        bv bvVar;
        bv bvVar2;
        bvVar = this.a.b;
        RandChatRoomData f = bvVar.f();
        if (f != null) {
            bvVar2 = this.a.b;
            bvVar2.a(f.d(), str, str2, z);
        }
    }
}
