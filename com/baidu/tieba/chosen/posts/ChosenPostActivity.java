package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes17.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter hok;
    private ChosenPostModelController hol;
    private b hom;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        btQ().addEventDelegate(this);
        this.hol = ccF();
        this.hom = ccG();
        if (getIntent() != null) {
            this.hol.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.hol.aj(bundle);
        } else {
            this.hol.aj(null);
        }
        setContentView(this.hom.bJD());
        this.hom.ccK();
        this.hom.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ccF() {
        if (this.hol == null) {
            this.hol = new ChosenPostModelController(this);
        }
        return this.hol;
    }

    public b ccG() {
        if (this.hom == null) {
            this.hom = new b(this);
        }
        return this.hom;
    }

    public ViewEventCenter btQ() {
        if (this.hok == null) {
            this.hok = new ViewEventCenter();
        }
        return this.hok;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean btt() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.btu()) {
            case 4096:
                b(bVar);
                break;
        }
        return ccG().a(bVar) || ccF().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a btv = bVar.btv();
        if (btv instanceof d) {
            sendMessage(((d) btv).eS(getPageContext().getPageActivity()));
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
        ccG().onChangeSkinType(getPageContext(), i);
    }
}
