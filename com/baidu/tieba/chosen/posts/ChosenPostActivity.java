package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes22.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter hvs;
    private ChosenPostModelController hvt;
    private b hvu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        buV().addEventDelegate(this);
        this.hvt = cfV();
        this.hvu = cfW();
        if (getIntent() != null) {
            this.hvt.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.hvt.aj(bundle);
        } else {
            this.hvt.aj(null);
        }
        setContentView(this.hvu.bKO());
        this.hvu.cga();
        this.hvu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController cfV() {
        if (this.hvt == null) {
            this.hvt = new ChosenPostModelController(this);
        }
        return this.hvt;
    }

    public b cfW() {
        if (this.hvu == null) {
            this.hvu = new b(this);
        }
        return this.hvu;
    }

    public ViewEventCenter buV() {
        if (this.hvs == null) {
            this.hvs = new ViewEventCenter();
        }
        return this.hvs;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean buy() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.buz()) {
            case 4096:
                b(bVar);
                break;
        }
        return cfW().a(bVar) || cfV().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a buA = bVar.buA();
        if (buA instanceof d) {
            sendMessage(((d) buA).eY(getPageContext().getPageActivity()));
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
        cfW().onChangeSkinType(getPageContext(), i);
    }
}
