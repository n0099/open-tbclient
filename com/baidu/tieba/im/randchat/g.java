package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.view.k {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.view.k
    public void a(String str, String str2, boolean z) {
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
