package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class ChosenPostActivity extends MvcActivity<com.baidu.tbadk.mvc.core.c, b, ChosenPostActivity> {
    private b aCS;
    private e aCT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AL().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Br()) {
            case 4096:
                b(bVar);
                break;
        }
        return super.a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Bs = bVar.Bs();
        if (Bs instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) Bs).as(getBaseContext()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: GM */
    public b oy() {
        if (this.aCS == null) {
            this.aCS = new b(this);
        }
        return this.aCS;
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public com.baidu.tbadk.mvc.core.c oA() {
        if (this.aCT == null) {
            this.aCT = new e();
        }
        return this.aCT;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
    }
}
