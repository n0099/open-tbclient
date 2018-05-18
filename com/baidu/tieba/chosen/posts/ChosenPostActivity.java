package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes3.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter cxB;
    private ChosenPostModelController cxC;
    private b cxD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Gl().addEventDelegate(this);
        this.cxC = agH();
        this.cxD = agI();
        if (getIntent() != null) {
            this.cxC.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cxC.i(bundle);
        } else {
            this.cxC.i(null);
        }
        setContentView(this.cxD.Rk());
        this.cxD.agN();
        this.cxD.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController agH() {
        if (this.cxC == null) {
            this.cxC = new ChosenPostModelController(this);
        }
        return this.cxC;
    }

    public b agI() {
        if (this.cxD == null) {
            this.cxD = new b(this);
        }
        return this.cxD;
    }

    public ViewEventCenter Gl() {
        if (this.cxB == null) {
            this.cxB = new ViewEventCenter();
        }
        return this.cxB;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean FC() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.FD()) {
            case 4096:
                b(bVar);
                break;
        }
        return agI().a(bVar) || agH().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a FE = bVar.FE();
        if (FE instanceof d) {
            sendMessage(((d) FE).bm(getPageContext().getPageActivity()));
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
        agI().d(getPageContext(), i);
    }
}
