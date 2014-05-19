package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MyGroupActivity extends com.baidu.tbadk.core.e implements View.OnClickListener {
    private k c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.base.b, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.base.b, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.e
    protected void b(int i) {
        this.c.a(i);
    }

    public static void a(Context context) {
        if (context != null) {
            if (!TbadkApplication.isLogin()) {
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).showToast(u.not_login_text);
                    return;
                } else if (context instanceof com.baidu.tbadk.core.e) {
                    ((com.baidu.tbadk.core.e) context).c(u.not_login_text);
                    return;
                } else {
                    return;
                }
            }
            context.startActivity(new Intent(context, MyGroupActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.a();
    }

    @Override // com.baidu.adp.base.b, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c == null) {
        }
    }
}
