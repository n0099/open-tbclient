package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.j;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MyGroupActivity extends BaseFragmentActivity implements View.OnClickListener {
    private i b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.b.a(i);
    }

    public static void a(Context context) {
        if (context != null) {
            if (!TiebaApplication.B()) {
                if (context instanceof j) {
                    ((j) context).showToast(R.string.not_login_text);
                    return;
                } else if (context instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) context).b(R.string.not_login_text);
                    return;
                } else {
                    return;
                }
            }
            context.startActivity(new Intent(context, MyGroupActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b == null) {
        }
    }
}
