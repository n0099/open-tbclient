package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class GroupMsgImageActivity extends a {
    @Override // com.baidu.tieba.im.chat.a
    protected final void a(String str, bz bzVar) {
        x.b().a(str, bzVar);
    }

    public static void a(Context context, String str, long j, boolean z) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, GroupMsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            intent.putExtra("isSingle", false);
            context.startActivity(intent);
        }
    }
}
