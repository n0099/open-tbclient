package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class MsglistActivity extends dj {
    public static boolean a;
    public static String b = "";

    protected abstract boolean b(Bundle bundle);

    protected abstract void o();

    protected abstract boolean p();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (!b(bundle)) {
                finish();
            } else {
                o();
                q();
                p();
                this.e.e();
                m();
                dc.a = com.baidu.tbadk.core.util.b.b();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.im.chat.dj, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            com.baidu.adp.lib.util.f.d("----onNewIntent start-----");
            setIntent(intent);
            if (!b((Bundle) null)) {
                finish();
            } else {
                o();
                q();
                p();
                this.e.e();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.d != null) {
            this.d.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            h hVar = this.d;
            TbadkApplication.j().l();
            hVar.O();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (TbadkApplication.j().V()) {
            this.d.J();
        } else {
            this.d.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.f.e("----ondestroy---");
        super.onDestroy();
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
    }
}
