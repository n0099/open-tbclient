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
    private e aKA;
    private b aKz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oE().addEventDelegate(this);
        this.aKz = Hp();
        this.aKA = Hq();
        if (getIntent() != null) {
            this.aKz.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aKz.f(bundle);
        } else {
            this.aKz.f(null);
        }
        setContentView(this.aKA.oY());
        this.aKA.oP();
        this.aKA.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b Hp() {
        if (this.aKz == null) {
            this.aKz = new b(this);
        }
        return this.aKz;
    }

    public e Hq() {
        if (this.aKA == null) {
            this.aKA = new e(this);
        }
        return this.aKA;
    }

    public ViewEventCenter oE() {
        if (this.LD == null) {
            this.LD = new ViewEventCenter();
        }
        return this.LD;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oH() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CQ()) {
            case 4096:
                b(bVar);
                break;
        }
        return Hq().a(bVar) || Hp().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a CR = bVar.CR();
        if (CR instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) CR).as(getPageContext().getPageActivity()));
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
        Hq().onChangeSkinType(getPageContext(), i);
    }
}
