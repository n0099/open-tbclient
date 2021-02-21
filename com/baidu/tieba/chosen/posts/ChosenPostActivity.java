package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes8.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter iCh;
    private ChosenPostModelController iCi;
    private b iCj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bDI().addEventDelegate(this);
        this.iCi = ctj();
        this.iCj = ctk();
        if (getIntent() != null) {
            this.iCi.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iCi.aj(bundle);
        } else {
            this.iCi.aj(null);
        }
        setContentView(this.iCj.bVr());
        this.iCj.cto();
        this.iCj.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ctj() {
        if (this.iCi == null) {
            this.iCi = new ChosenPostModelController(this);
        }
        return this.iCi;
    }

    public b ctk() {
        if (this.iCj == null) {
            this.iCj = new b(this);
        }
        return this.iCj;
    }

    public ViewEventCenter bDI() {
        if (this.iCh == null) {
            this.iCh = new ViewEventCenter();
        }
        return this.iCh;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDn()) {
            case 4096:
                b(bVar);
                break;
        }
        return ctk().a(bVar) || ctj().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bDo = bVar.bDo();
        if (bDo instanceof d) {
            sendMessage(((d) bDo).ge(getPageContext().getPageActivity()));
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
        ctk().onChangeSkinType(getPageContext(), i);
    }
}
