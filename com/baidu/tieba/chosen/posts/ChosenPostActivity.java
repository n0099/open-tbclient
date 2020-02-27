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
    private ViewEventCenter fOi;
    private ChosenPostModelController fOj;
    private b fOk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aQN().addEventDelegate(this);
        this.fOj = bvJ();
        this.fOk = bvK();
        if (getIntent() != null) {
            this.fOj.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fOj.ad(bundle);
        } else {
            this.fOj.ad(null);
        }
        setContentView(this.fOk.beQ());
        this.fOk.bvP();
        this.fOk.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bvJ() {
        if (this.fOj == null) {
            this.fOj = new ChosenPostModelController(this);
        }
        return this.fOj;
    }

    public b bvK() {
        if (this.fOk == null) {
            this.fOk = new b(this);
        }
        return this.fOk;
    }

    public ViewEventCenter aQN() {
        if (this.fOi == null) {
            this.fOi = new ViewEventCenter();
        }
        return this.fOi;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQl()) {
            case 4096:
                b(bVar);
                break;
        }
        return bvK().a(bVar) || bvJ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aQm = bVar.aQm();
        if (aQm instanceof d) {
            sendMessage(((d) aQm).eL(getPageContext().getPageActivity()));
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
        bvK().onChangeSkinType(getPageContext(), i);
    }
}
