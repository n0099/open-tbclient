package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.im.chat.bs;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class OfficialHistoryImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, bs bsVar) {
        bsVar.a(new LinkedHashMap<>());
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            Intent intent = new Intent(context, OfficialHistoryImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", "0");
            intent.putExtra("uniqueid", str2);
            context.startActivity(intent);
        }
    }
}
