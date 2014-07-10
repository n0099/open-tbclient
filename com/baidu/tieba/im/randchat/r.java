package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.ca;
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
        ca caVar;
        ca caVar2;
        caVar = this.a.b;
        RandChatRoomData f = caVar.f();
        if (f != null) {
            caVar2 = this.a.b;
            caVar2.a(f.d(), str, str2, z);
        }
    }
}
