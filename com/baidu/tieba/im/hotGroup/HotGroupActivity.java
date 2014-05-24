package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class HotGroupActivity extends BaseFragmentActivity implements View.OnClickListener {
    private e c;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, HotGroupActivity.class));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new e(this);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.a()) {
            finish();
        }
    }
}
