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
    private ViewEventCenter deF;
    private ChosenPostModelController deG;
    private b deH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NL().addEventDelegate(this);
        this.deG = amJ();
        this.deH = amK();
        if (getIntent() != null) {
            this.deG.l(getIntent().getExtras());
        } else if (bundle != null) {
            this.deG.l(bundle);
        } else {
            this.deG.l(null);
        }
        setContentView(this.deH.YO());
        this.deH.amP();
        this.deH.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController amJ() {
        if (this.deG == null) {
            this.deG = new ChosenPostModelController(this);
        }
        return this.deG;
    }

    public b amK() {
        if (this.deH == null) {
            this.deH = new b(this);
        }
        return this.deH;
    }

    public ViewEventCenter NL() {
        if (this.deF == null) {
            this.deF = new ViewEventCenter();
        }
        return this.deF;
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
