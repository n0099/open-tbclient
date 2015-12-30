package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter Mm;
    private b aQR;
    private e aQS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ok().addEventDelegate(this);
        this.aQR = IN();
        this.aQS = IO();
        if (getIntent() != null) {
            this.aQR.b(getIntent().getExtras());
        } else if (bundle != null) {
            this.aQR.b(bundle);
        } else {
            this.aQR.b((Bundle) null);
        }
        setContentView(this.aQS.oE());
        this.aQS.ov();
        this.aQS.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public b IN() {
        if (this.aQR == null) {
            this.aQR = new b(this);
        }
        return this.aQR;
    }

    public e IO() {
        if (this.aQS == null) {
            this.aQS = new e(this);
        }
        return this.aQS;
    }

    public ViewEventCenter ok() {
        if (this.Mm == null) {
            this.Mm = new ViewEventCenter();
        }
        return this.Mm;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean on() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Dj()) {
            case 4096:
                b(bVar);
                break;
        }
        return IO().a(bVar) || IN().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Dk = bVar.Dk();
        if (Dk instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) Dk).ar(getPageContext().getPageActivity()));
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
        IO().onChangeSkinType(getPageContext(), i);
    }
}
