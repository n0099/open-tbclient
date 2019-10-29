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
    private ViewEventCenter eUM;
    private ChosenPostModelController eUN;
    private b eUO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        awx().addEventDelegate(this);
        this.eUN = bbH();
        this.eUO = bbI();
        if (getIntent() != null) {
            this.eUN.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eUN.K(bundle);
        } else {
            this.eUN.K(null);
        }
        setContentView(this.eUO.aKY());
        this.eUO.bbN();
        this.eUO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bbH() {
        if (this.eUN == null) {
            this.eUN = new ChosenPostModelController(this);
        }
        return this.eUN;
    }

    public b bbI() {
        if (this.eUO == null) {
            this.eUO = new b(this);
        }
        return this.eUO;
    }

    public ViewEventCenter awx() {
        if (this.eUM == null) {
            this.eUM = new ViewEventCenter();
        }
        return this.eUM;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean avP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.avQ()) {
            case 4096:
                b(bVar);
                break;
        }
        return bbI().a(bVar) || bbH().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a avR = bVar.avR();
        if (avR instanceof d) {
            sendMessage(((d) avR).dp(getPageContext().getPageActivity()));
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
        bbI().onChangeSkinType(getPageContext(), i);
    }
}
