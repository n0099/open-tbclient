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
    private b aJs;
    private e aJt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oF().addEventDelegate(this);
        this.aJs = Hj();
        this.aJt = Hk();
        if (getIntent() != null) {
            this.aJs.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aJs.f(bundle);
        } else {
            this.aJs.f(null);
        }
        setContentView(this.aJt.oZ());
        this.aJt.oQ();
        this.aJt.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b Hj() {
        if (this.aJs == null) {
            this.aJs = new b(this);
        }
        return this.aJs;
    }

    public e Hk() {
        if (this.aJt == null) {
            this.aJt = new e(this);
        }
        return this.aJt;
    }

    public ViewEventCenter oF() {
        if (this.LD == null) {
            this.LD = new ViewEventCenter();
        }
        return this.LD;
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
