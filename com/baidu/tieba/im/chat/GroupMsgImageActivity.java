package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class GroupMsgImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, bu buVar) {
        w.b().a(str, buVar);
    }

    public static void a(Context context, String str, long j, boolean z, String str2) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, GroupMsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            intent.putExtra("uniqueid", str2);
            intent.putExtra("isSingle", z);
            context.startActivity(intent);
        }
    }
}
