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
    private ViewEventCenter iou;
    private ChosenPostModelController iov;
    private b iow;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bEP().addEventDelegate(this);
        this.iov = csN();
        this.iow = csO();
        if (getIntent() != null) {
            this.iov.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iov.aj(bundle);
        } else {
            this.iov.aj(null);
        }
        setContentView(this.iow.bVG());
        this.iow.csS();
        this.iow.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController csN() {
        if (this.iov == null) {
            this.iov = new ChosenPostModelController(this);
        }
        return this.iov;
    }

    public b csO() {
        if (this.iow == null) {
            this.iow = new b(this);
        }
        return this.iow;
    }

    public ViewEventCenter bEP() {
        if (this.iou == null) {
            this.iou = new ViewEventCenter();
        }
        return this.iou;
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
        return csO().a(bVar) || csN().a(bVar);
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
        csO().onChangeSkinType(getPageContext(), i);
    }
}
