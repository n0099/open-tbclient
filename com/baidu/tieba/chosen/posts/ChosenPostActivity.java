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
    private ViewEventCenter fOk;
    private ChosenPostModelController fOl;
    private b fOm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aQP().addEventDelegate(this);
        this.fOl = bvL();
        this.fOm = bvM();
        if (getIntent() != null) {
            this.fOl.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fOl.ad(bundle);
        } else {
            this.fOl.ad(null);
        }
        setContentView(this.fOm.beS());
        this.fOm.bvR();
        this.fOm.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bvL() {
        if (this.fOl == null) {
            this.fOl = new ChosenPostModelController(this);
        }
        return this.fOl;
    }

    public b bvM() {
        if (this.fOm == null) {
            this.fOm = new b(this);
        }
        return this.fOm;
    }

    public ViewEventCenter aQP() {
        if (this.fOk == null) {
            this.fOk = new ViewEventCenter();
        }
        return this.fOk;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQn()) {
            case 4096:
                b(bVar);
                break;
        }
        return bvM().a(bVar) || bvL().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aQo = bVar.aQo();
        if (aQo instanceof d) {
            sendMessage(((d) aQo).eL(getPageContext().getPageActivity()));
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
        bvM().onChangeSkinType(getPageContext(), i);
    }
}
