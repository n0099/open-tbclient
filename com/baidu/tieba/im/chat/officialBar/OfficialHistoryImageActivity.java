package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.im.chat.bu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OfficialHistoryImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, bu buVar) {
        buVar.a(new ArrayList<>());
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
