package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class MyGroupActivity extends BaseFragmentActivity implements View.OnClickListener {
    private l d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new l(this);
        a(103008, new b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.d.a(i);
    }

    public static void a(Context context) {
        if (context != null) {
            if (!TbadkApplication.isLogin()) {
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).showToast(com.baidu.tieba.x.not_login_text);
                    return;
                } else if (context instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) context).c(com.baidu.tieba.x.not_login_text);
                    return;
                } else {
                    return;
                }
            }
            context.startActivity(new Intent(context, MyGroupActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.a();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null) {
        }
    }
}
