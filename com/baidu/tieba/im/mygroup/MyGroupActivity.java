package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.k;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MyGroupActivity extends k implements View.OnClickListener {
    private i d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        this.d.a(i);
    }

    public static void a(Context context) {
        if (context != null) {
            if (!TiebaApplication.B()) {
                if (context instanceof com.baidu.tieba.f) {
                    ((com.baidu.tieba.f) context).showToast(R.string.not_login_text);
                    return;
                } else if (context instanceof k) {
                    ((k) context).c(R.string.not_login_text);
                    return;
                } else {
                    return;
                }
            }
            context.startActivity(new Intent(context, MyGroupActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null) {
        }
    }
}
