package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter LE;
    private b aJD;
    private e aJE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oF().addEventDelegate(this);
        this.aJD = Hj();
        this.aJE = Hk();
        if (getIntent() != null) {
            this.aJD.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aJD.f(bundle);
        } else {
            this.aJD.f(null);
        }
        setContentView(this.aJE.oZ());
        this.aJE.oQ();
        this.aJE.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b Hj() {
        if (this.aJD == null) {
            this.aJD = new b(this);
        }
        return this.aJD;
    }

    public e Hk() {
        if (this.aJE == null) {
            this.aJE = new e(this);
        }
        return this.aJE;
    }

    public ViewEventCenter oF() {
        if (this.LE == null) {
            this.LE = new ViewEventCenter();
        }
        return this.LE;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CD()) {
            case 4096:
                b(bVar);
                break;
        }
        return Hk().a(bVar) || Hj().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a CE = bVar.CE();
        if (CE instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) CE).ar(getPageContext().getPageActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        Hk().onChangeSkinType(getPageContext(), i);
    }
}
