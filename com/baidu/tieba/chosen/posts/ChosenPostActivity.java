package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class ChosenPostActivity extends MvcActivity<com.baidu.tbadk.mvc.core.c, b, ChosenPostActivity> {
    private b aBh;
    private d aBi;

    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(ChosenPostActivityConfig.class, ChosenPostActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zZ().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.AF()) {
            case 4096:
                b(bVar);
                break;
        }
        return super.a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a AG = bVar.AG();
        if (AG instanceof com.baidu.tieba.chosen.posts.a.d) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.d) AG).an(getBaseContext()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: FS */
    public b oi() {
        if (this.aBh == null) {
            this.aBh = new b(this);
        }
        return this.aBh;
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public com.baidu.tbadk.mvc.core.c ok() {
        if (this.aBi == null) {
            this.aBi = new d();
        }
        return this.aBi;
    }
}
