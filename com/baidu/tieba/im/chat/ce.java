package com.baidu.tieba.im.chat;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(MsglistActivity msglistActivity) {
        this.a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.a.d.K();
            } else {
                this.a.d.L();
            }
            if (this.a.e != null && this.a.e.a() != null) {
                String name = this.a.e.a().getName();
                if (!TextUtils.isEmpty(name)) {
                    this.a.d.a(name, true);
                }
            }
        }
    }
}
