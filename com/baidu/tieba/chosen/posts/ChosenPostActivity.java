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
    private ViewEventCenter epL;
    private ChosenPostModelController epM;
    private b epN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoG().addEventDelegate(this);
        this.epM = aRL();
        this.epN = aRM();
        if (getIntent() != null) {
            this.epM.J(getIntent().getExtras());
        } else if (bundle != null) {
            this.epM.J(bundle);
        } else {
            this.epM.J(null);
        }
        setContentView(this.epN.aDs());
        this.epN.aRR();
        this.epN.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aRL() {
        if (this.epM == null) {
            this.epM = new ChosenPostModelController(this);
        }
        return this.epM;
    }

    public b aRM() {
        if (this.epN == null) {
            this.epN = new b(this);
        }
        return this.epN;
    }

    public ViewEventCenter aoG() {
        if (this.epL == null) {
            this.epL = new ViewEventCenter();
        }
        return this.epL;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean anX() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.anY()) {
            case 4096:
                b(bVar);
                break;
        }
        return aRM().a(bVar) || aRL().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a anZ = bVar.anZ();
        if (anZ instanceof d) {
            sendMessage(((d) anZ).dL(getPageContext().getPageActivity()));
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
        aRM().onChangeSkinType(getPageContext(), i);
    }
}
