package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.chat.bv;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OfficialHistoryImageActivity extends com.baidu.tieba.im.chat.a {
    @Override // com.baidu.tieba.im.chat.a
    protected void a(String str, bv bvVar) {
        bvVar.a(new ArrayList<>());
    }

    public static void a(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, OfficialHistoryImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", "0");
            context.startActivity(intent);
        }
    }
}
