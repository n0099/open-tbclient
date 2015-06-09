package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class ChosenPostActivity extends MvcActivity<com.baidu.tbadk.mvc.core.c, b, ChosenPostActivity> {
    private b aCT;
    private e aCU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AM().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Bs()) {
            case 4096:
                b(bVar);
                break;
        }
        return super.a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Bt = bVar.Bt();
        if (Bt instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) Bt).as(getBaseContext()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: GN */
    public b oy() {
        if (this.aCT == null) {
            this.aCT = new b(this);
        }
        return this.aCT;
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public com.baidu.tbadk.mvc.core.c oA() {
        if (this.aCU == null) {
            this.aCU = new e();
        }
        return this.aCU;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
    }
}
