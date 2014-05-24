package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class MsglistActivity extends TalkableActivity {
    public static boolean a;
    public static String b = "";

    protected abstract boolean c(Bundle bundle);

    protected abstract void o();

    protected abstract boolean p();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (!c(bundle)) {
                finish();
            } else {
                o();
                r();
                if (p()) {
                    q();
                    m();
                    cy.a = com.baidu.tbadk.editortool.ab.b();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            BdLog.i("----onNewIntent start-----");
            setIntent(intent);
            if (!c(null)) {
                finish();
            } else {
                o();
                r();
                if (p()) {
                    q();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.a(TbadkApplication.m252getInst().getSkinType());
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
            this.d.K();
        } else {
            this.d.J();
        }
    }

    protected boolean q() {
        return this.e.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        BdLog.d("----ondestroy---");
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
