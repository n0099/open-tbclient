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
    private ViewEventCenter cws;
    private ChosenPostModelController cwt;
    private b cwu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Gn().addEventDelegate(this);
        this.cwt = agH();
        this.cwu = agI();
        if (getIntent() != null) {
            this.cwt.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cwt.i(bundle);
        } else {
            this.cwt.i(null);
        }
        setContentView(this.cwu.Rn());
        this.cwu.agN();
        this.cwu.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController agH() {
        if (this.cwt == null) {
            this.cwt = new ChosenPostModelController(this);
        }
        return this.cwt;
    }

    public b agI() {
        if (this.cwu == null) {
            this.cwu = new b(this);
        }
        return this.cwu;
    }

    public ViewEventCenter Gn() {
        if (this.cws == null) {
            this.cws = new ViewEventCenter();
        }
        return this.cws;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean FE() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.FF()) {
            case 4096:
                b(bVar);
                break;
        }
        return agI().a(bVar) || agH().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a FG = bVar.FG();
        if (FG instanceof d) {
            sendMessage(((d) FG).bm(getPageContext().getPageActivity()));
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
