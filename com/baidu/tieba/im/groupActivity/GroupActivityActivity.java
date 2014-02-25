package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class GroupActivityActivity extends com.baidu.tieba.f implements View.OnClickListener {
    private r a;
    private q b;
    private p c;

    public static void a(Context context, int i, long j, int i2) {
        Intent intent = new Intent(context, GroupActivityActivity.class);
        intent.putExtra("activity_id", i);
        intent.putExtra("group_id", j);
        intent.putExtra("from", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        if (this.b == null) {
            this.b = new q();
        }
        if (bundle != null) {
            this.b.b(bundle.getInt("activity_id", 0));
            this.b.a(bundle.getLong("group_id", 0L));
            this.b.a(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.b.b(getIntent().getIntExtra("activity_id", 0));
            this.b.a(getIntent().getLongExtra("group_id", 0L));
            this.b.a(getIntent().getIntExtra("from", 0));
        }
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a();
        b();
        if (this.b == null) {
            this.b = new q();
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.b.b(intent.getIntExtra("activity_id", 0));
            this.b.a(intent.getLongExtra("group_id", 0L));
            this.b.a(intent.getIntExtra("from", 0));
        }
        c();
    }

    private void a() {
        if (this.c == null) {
            this.c = new p(this, null);
            com.baidu.tieba.im.messageCenter.e.a().a(103015, this.c);
            com.baidu.tieba.im.messageCenter.e.a().a(-127, this.c);
            com.baidu.tieba.im.messageCenter.e.a().a(103121, this.c);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.b != null) {
            bundle.putInt("activity_id", this.b.b());
            bundle.putLong("group_id", this.b.c());
            bundle.putInt("from", this.b.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.d();
        com.baidu.tieba.im.messageCenter.e.a().a(this.c);
        if (this.a != null) {
            this.a.a();
        }
    }

    private void b() {
        if (this.a == null) {
            this.a = new r(this);
        }
    }

    private void c() {
        showProgressBar();
        this.b.d(this.b.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.e()) {
            closeActivity();
        } else if (view == this.a.f()) {
            com.baidu.tieba.im.util.b.b(this, new n(this));
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface != null && dialogInterface == this.a.g()) {
            if (i == 0) {
                CreateGroupActivityActivity.a(this, (int) this.b.c(), this.b.h(), 23001);
            } else if (i == 1) {
                com.baidu.tieba.im.util.b.b(this, new o(this));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23001:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void closeActivity() {
        finish();
    }
}
