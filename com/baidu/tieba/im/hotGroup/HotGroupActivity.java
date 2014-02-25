package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.k;
/* loaded from: classes.dex */
public class HotGroupActivity extends k implements View.OnClickListener {
    private d d;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, HotGroupActivity.class));
        }
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.a()) {
            finish();
        }
    }
}
