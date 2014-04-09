package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class PersonalMsgImageActivity extends a {
    @Override // com.baidu.tieba.im.chat.a
    protected final void a(String str, bv bvVar) {
        x.b().b(str, bvVar);
    }

    public static void a(Context context, String str, long j) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, PersonalMsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            context.startActivity(intent);
        }
    }
}
