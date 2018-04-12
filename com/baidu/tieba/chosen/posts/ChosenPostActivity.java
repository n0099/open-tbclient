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
    private ViewEventCenter cwv;
    private ChosenPostModelController cww;
    private b cwx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Gn().addEventDelegate(this);
        this.cww = agH();
        this.cwx = agI();
        if (getIntent() != null) {
            this.cww.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cww.i(bundle);
        } else {
            this.cww.i(null);
        }
        setContentView(this.cwx.Rn());
        this.cwx.agN();
        this.cwx.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController agH() {
        if (this.cww == null) {
            this.cww = new ChosenPostModelController(this);
        }
        return this.cww;
    }

    public b agI() {
        if (this.cwx == null) {
            this.cwx = new b(this);
        }
        return this.cwx;
    }

    public ViewEventCenter Gn() {
        if (this.cwv == null) {
            this.cwv = new ViewEventCenter();
        }
        return this.cwv;
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
