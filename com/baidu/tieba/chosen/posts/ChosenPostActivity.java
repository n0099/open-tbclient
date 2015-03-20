package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class ChosenPostActivity extends MvcActivity<com.baidu.tbadk.mvc.core.c, b, ChosenPostActivity> {
    private b aAZ;
    private d aBa;

    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(ChosenPostActivityConfig.class, ChosenPostActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zT().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Az()) {
            case 4096:
                b(bVar);
                break;
        }
        return super.a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a AA = bVar.AA();
        if (AA instanceof com.baidu.tieba.chosen.posts.a.d) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.d) AA).an(getBaseContext()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: FM */
    public b oi() {
        if (this.aAZ == null) {
            this.aAZ = new b(this);
        }
        return this.aAZ;
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public com.baidu.tbadk.mvc.core.c ok() {
        if (this.aBa == null) {
            this.aBa = new d();
        }
        return this.aBa;
    }
}
