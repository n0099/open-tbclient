package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.im.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cd implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ Context a;
    final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, UserData userData) {
        this.a = context;
        this.b = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        PersonalChatActivity.a(this.a, this.b, true);
    }
}
