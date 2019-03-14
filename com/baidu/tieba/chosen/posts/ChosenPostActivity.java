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
    private ViewEventCenter epZ;
    private ChosenPostModelController eqa;
    private b eqb;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoJ().addEventDelegate(this);
        this.eqa = aRN();
        this.eqb = aRO();
        if (getIntent() != null) {
            this.eqa.J(getIntent().getExtras());
        } else if (bundle != null) {
            this.eqa.J(bundle);
        } else {
            this.eqa.J(null);
        }
        setContentView(this.eqb.aDv());
        this.eqb.aRT();
        this.eqb.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aRN() {
        if (this.eqa == null) {
            this.eqa = new ChosenPostModelController(this);
        }
        return this.eqa;
    }

    public b aRO() {
        if (this.eqb == null) {
            this.eqb = new b(this);
        }
        return this.eqb;
    }

    public ViewEventCenter aoJ() {
        if (this.epZ == null) {
            this.epZ = new ViewEventCenter();
        }
        return this.epZ;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aoa() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aob()) {
            case 4096:
                b(bVar);
                break;
        }
        return aRO().a(bVar) || aRN().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aoc = bVar.aoc();
        if (aoc instanceof d) {
            sendMessage(((d) aoc).dL(getPageContext().getPageActivity()));
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
        aRO().onChangeSkinType(getPageContext(), i);
    }
}
