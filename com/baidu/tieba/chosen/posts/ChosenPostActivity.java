package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes22.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter idA;
    private ChosenPostModelController idB;
    private b idC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bBn().addEventDelegate(this);
        this.idB = coA();
        this.idC = coB();
        if (getIntent() != null) {
            this.idB.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.idB.aj(bundle);
        } else {
            this.idB.aj(null);
        }
        setContentView(this.idC.bRW());
        this.idC.coF();
        this.idC.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController coA() {
        if (this.idB == null) {
            this.idB = new ChosenPostModelController(this);
        }
        return this.idB;
    }

    public b coB() {
        if (this.idC == null) {
            this.idC = new b(this);
        }
        return this.idC;
    }

    public ViewEventCenter bBn() {
        if (this.idA == null) {
            this.idA = new ViewEventCenter();
        }
        return this.idA;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bAQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bAR()) {
            case 4096:
                b(bVar);
                break;
        }
        return coB().a(bVar) || coA().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bAS = bVar.bAS();
        if (bAS instanceof d) {
            sendMessage(((d) bAS).fg(getPageContext().getPageActivity()));
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
        coB().onChangeSkinType(getPageContext(), i);
    }
}
