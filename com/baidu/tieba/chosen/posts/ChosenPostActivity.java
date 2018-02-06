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
    private ViewEventCenter deO;
    private ChosenPostModelController deP;
    private b deQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NL().addEventDelegate(this);
        this.deP = amJ();
        this.deQ = amK();
        if (getIntent() != null) {
            this.deP.l(getIntent().getExtras());
        } else if (bundle != null) {
            this.deP.l(bundle);
        } else {
            this.deP.l(null);
        }
        setContentView(this.deQ.YO());
        this.deQ.amP();
        this.deQ.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController amJ() {
        if (this.deP == null) {
            this.deP = new ChosenPostModelController(this);
        }
        return this.deP;
    }

    public b amK() {
        if (this.deQ == null) {
            this.deQ = new b(this);
        }
        return this.deQ;
    }

    public ViewEventCenter NL() {
        if (this.deO == null) {
            this.deO = new ViewEventCenter();
        }
        return this.deO;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Nc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Nd()) {
            case 4096:
                b(bVar);
                break;
        }
        return amK().a(bVar) || amJ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Ne = bVar.Ne();
        if (Ne instanceof d) {
            sendMessage(((d) Ne).by(getPageContext().getPageActivity()));
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
        amK().d(getPageContext(), i);
    }
}
