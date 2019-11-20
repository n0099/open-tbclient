package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes5.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter eTV;
    private ChosenPostModelController eTW;
    private b eTX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        awv().addEventDelegate(this);
        this.eTW = bbF();
        this.eTX = bbG();
        if (getIntent() != null) {
            this.eTW.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eTW.K(bundle);
        } else {
            this.eTW.K(null);
        }
        setContentView(this.eTX.aKW());
        this.eTX.bbL();
        this.eTX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bbF() {
        if (this.eTW == null) {
            this.eTW = new ChosenPostModelController(this);
        }
        return this.eTW;
    }

    public b bbG() {
        if (this.eTX == null) {
            this.eTX = new b(this);
        }
        return this.eTX;
    }

    public ViewEventCenter awv() {
        if (this.eTV == null) {
            this.eTV = new ViewEventCenter();
        }
        return this.eTV;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean avN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.avO()) {
            case 4096:
                b(bVar);
                break;
        }
        return bbG().a(bVar) || bbF().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a avP = bVar.avP();
        if (avP instanceof d) {
            sendMessage(((d) avP).dp(getPageContext().getPageActivity()));
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
        bbG().onChangeSkinType(getPageContext(), i);
    }
}
