package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class PersonalMsgImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, bs bsVar) {
        w.Jo().c(str, bsVar);
    }

    public static void a(Context context, String str, long j, String str2) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, PersonalMsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            intent.putExtra("uniqueid", str2);
            context.startActivity(intent);
        }
    }
}
