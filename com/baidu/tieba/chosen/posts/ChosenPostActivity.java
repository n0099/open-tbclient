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
    private ViewEventCenter epM;
    private ChosenPostModelController epN;
    private b epO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoG().addEventDelegate(this);
        this.epN = aRL();
        this.epO = aRM();
        if (getIntent() != null) {
            this.epN.J(getIntent().getExtras());
        } else if (bundle != null) {
            this.epN.J(bundle);
        } else {
            this.epN.J(null);
        }
        setContentView(this.epO.aDs());
        this.epO.aRR();
        this.epO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aRL() {
        if (this.epN == null) {
            this.epN = new ChosenPostModelController(this);
        }
        return this.epN;
    }

    public b aRM() {
        if (this.epO == null) {
            this.epO = new b(this);
        }
        return this.epO;
    }

    public ViewEventCenter aoG() {
        if (this.epM == null) {
            this.epM = new ViewEventCenter();
        }
        return this.epM;
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
