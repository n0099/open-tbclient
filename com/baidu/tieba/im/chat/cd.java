package com.baidu.tieba.im.chat;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cd implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(MsglistActivity msglistActivity) {
        this.a = msglistActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                this.a.d.H();
            } else {
                this.a.d.I();
            }
            if (this.a.e == null || this.a.e.a() == null) {
                return;
            }
            String name = this.a.e.a().getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            this.a.d.a(name);
        }
    }
}
