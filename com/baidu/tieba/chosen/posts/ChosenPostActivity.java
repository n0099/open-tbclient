package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes10.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter fPf;
    private ChosenPostModelController fPg;
    private b fPh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aQU().addEventDelegate(this);
        this.fPg = bvR();
        this.fPh = bvS();
        if (getIntent() != null) {
            this.fPg.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fPg.ad(bundle);
        } else {
            this.fPg.ad(null);
        }
        setContentView(this.fPh.beY());
        this.fPh.bvX();
        this.fPh.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bvR() {
        if (this.fPg == null) {
            this.fPg = new ChosenPostModelController(this);
        }
        return this.fPg;
    }

    public b bvS() {
        if (this.fPh == null) {
            this.fPh = new b(this);
        }
        return this.fPh;
    }

    public ViewEventCenter aQU() {
        if (this.fPf == null) {
            this.fPf = new ViewEventCenter();
        }
        return this.fPf;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQr() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQs()) {
            case 4096:
                b(bVar);
                break;
        }
        return bvS().a(bVar) || bvR().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aQt = bVar.aQt();
        if (aQt instanceof d) {
            sendMessage(((d) aQt).eK(getPageContext().getPageActivity()));
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
        bvS().onChangeSkinType(getPageContext(), i);
    }
}
