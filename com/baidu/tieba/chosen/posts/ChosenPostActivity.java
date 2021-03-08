package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes7.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter iDQ;
    private ChosenPostModelController iDR;
    private b iDS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bDL().addEventDelegate(this);
        this.iDR = ctp();
        this.iDS = ctq();
        if (getIntent() != null) {
            this.iDR.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iDR.aj(bundle);
        } else {
            this.iDR.aj(null);
        }
        setContentView(this.iDS.bVx());
        this.iDS.ctu();
        this.iDS.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ctp() {
        if (this.iDR == null) {
            this.iDR = new ChosenPostModelController(this);
        }
        return this.iDR;
    }

    public b ctq() {
        if (this.iDS == null) {
            this.iDS = new b(this);
        }
        return this.iDS;
    }

    public ViewEventCenter bDL() {
        if (this.iDQ == null) {
            this.iDQ = new ViewEventCenter();
        }
        return this.iDQ;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDp() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDq()) {
            case 4096:
                b(bVar);
                break;
        }
        return ctq().a(bVar) || ctp().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bDr = bVar.bDr();
        if (bDr instanceof d) {
            sendMessage(((d) bDr).gc(getPageContext().getPageActivity()));
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
        ctq().onChangeSkinType(getPageContext(), i);
    }
}
