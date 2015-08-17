package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter LD;
    private b aKm;
    private e aKn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oH().addEventDelegate(this);
        this.aKm = HB();
        this.aKn = HC();
        if (getIntent() != null) {
            this.aKm.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aKm.f(bundle);
        } else {
            this.aKm.f(null);
        }
        setContentView(this.aKn.pb());
        this.aKn.oS();
        this.aKn.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b HB() {
        if (this.aKm == null) {
            this.aKm = new b(this);
        }
        return this.aKm;
    }

    public e HC() {
        if (this.aKn == null) {
            this.aKn = new e(this);
        }
        return this.aKn;
    }

    public ViewEventCenter oH() {
        if (this.LD == null) {
            this.LD = new ViewEventCenter();
        }
        return this.LD;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oK() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CG()) {
            case 4096:
                b(bVar);
                break;
        }
        return HC().a(bVar) || HB().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a CH = bVar.CH();
        if (CH instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) CH).at(getPageContext().getPageActivity()));
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
        HC().onChangeSkinType(getPageContext(), i);
    }
}
