package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class MsglistActivity extends TalkableActivity implements bv {
    protected abstract boolean a(bv bvVar);

    protected abstract boolean c(Bundle bundle);

    protected abstract void o();

    @Override // com.baidu.tieba.im.chat.bv
    public void f_() {
        p();
    }

    public void p() {
    }

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
                if (a((bv) this)) {
                    q();
                    m();
                    de.a = com.baidu.tbadk.editortool.aa.b();
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            if (!c(null)) {
                finish();
            } else {
                o();
                r();
                if (a((bv) this)) {
                    q();
                }
            }
        } catch (Exception e) {
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
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            this.d.L();
        } else {
            this.d.K();
        }
    }

    protected boolean q() {
        return this.e.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
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
