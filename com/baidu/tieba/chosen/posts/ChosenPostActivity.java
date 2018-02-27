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
    private ViewEventCenter deC;
    private ChosenPostModelController deD;
    private b deE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NK().addEventDelegate(this);
        this.deD = amI();
        this.deE = amJ();
        if (getIntent() != null) {
            this.deD.l(getIntent().getExtras());
        } else if (bundle != null) {
            this.deD.l(bundle);
        } else {
            this.deD.l(null);
        }
        setContentView(this.deE.YN());
        this.deE.amO();
        this.deE.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController amI() {
        if (this.deD == null) {
            this.deD = new ChosenPostModelController(this);
        }
        return this.deD;
    }

    public b amJ() {
        if (this.deE == null) {
            this.deE = new b(this);
        }
        return this.deE;
    }

    public ViewEventCenter NK() {
        if (this.deC == null) {
            this.deC = new ViewEventCenter();
        }
        return this.deC;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Nb() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Nc()) {
            case 4096:
                b(bVar);
                break;
        }
        return amJ().a(bVar) || amI().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Nd = bVar.Nd();
        if (Nd instanceof d) {
            sendMessage(((d) Nd).by(getPageContext().getPageActivity()));
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
        amJ().d(getPageContext(), i);
    }
}
