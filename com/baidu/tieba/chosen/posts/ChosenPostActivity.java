package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes23.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter iow;
    private ChosenPostModelController iox;
    private b ioy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bEP().addEventDelegate(this);
        this.iox = csO();
        this.ioy = csP();
        if (getIntent() != null) {
            this.iox.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iox.aj(bundle);
        } else {
            this.iox.aj(null);
        }
        setContentView(this.ioy.bVH());
        this.ioy.csT();
        this.ioy.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController csO() {
        if (this.iox == null) {
            this.iox = new ChosenPostModelController(this);
        }
        return this.iox;
    }

    public b csP() {
        if (this.ioy == null) {
            this.ioy = new b(this);
        }
        return this.ioy;
    }

    public ViewEventCenter bEP() {
        if (this.iow == null) {
            this.iow = new ViewEventCenter();
        }
        return this.iow;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bEs() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bEt()) {
            case 4096:
                b(bVar);
                break;
        }
        return csP().a(bVar) || csO().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bEu = bVar.bEu();
        if (bEu instanceof d) {
            sendMessage(((d) bEu).fM(getPageContext().getPageActivity()));
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
        csP().onChangeSkinType(getPageContext(), i);
    }
}
