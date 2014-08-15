package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.view.d {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.view.d
    public void a(String str, String str2, boolean z) {
        bf bfVar;
        bf bfVar2;
        bfVar = this.a.b;
        RandChatRoomData f = bfVar.f();
        if (f != null) {
            bfVar2 = this.a.b;
            bfVar2.a(f.d(), str, str2, z);
        }
    }
}
