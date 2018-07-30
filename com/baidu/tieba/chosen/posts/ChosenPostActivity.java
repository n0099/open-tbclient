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
    private ViewEventCenter cGD;
    private ChosenPostModelController cGE;
    private b cGF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kg().addEventDelegate(this);
        this.cGE = aki();
        this.cGF = akj();
        if (getIntent() != null) {
            this.cGE.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cGE.i(bundle);
        } else {
            this.cGE.i(null);
        }
        setContentView(this.cGF.Vm());
        this.cGF.ako();
        this.cGF.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aki() {
        if (this.cGE == null) {
            this.cGE = new ChosenPostModelController(this);
        }
        return this.cGE;
    }

    public b akj() {
        if (this.cGF == null) {
            this.cGF = new b(this);
        }
        return this.cGF;
    }

    public ViewEventCenter Kg() {
        if (this.cGD == null) {
            this.cGD = new ViewEventCenter();
        }
        return this.cGD;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jx() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Jy()) {
            case 4096:
                b(bVar);
                break;
        }
        return akj().a(bVar) || aki().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Jz = bVar.Jz();
        if (Jz instanceof d) {
            sendMessage(((d) Jz).bw(getPageContext().getPageActivity()));
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
        akj().d(getPageContext(), i);
    }
}
