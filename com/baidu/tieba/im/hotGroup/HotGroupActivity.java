package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* loaded from: classes.dex */
public class HotGroupActivity extends BaseFragmentActivity implements View.OnClickListener {
    private d b;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, HotGroupActivity.class));
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            finish();
        }
    }
}
