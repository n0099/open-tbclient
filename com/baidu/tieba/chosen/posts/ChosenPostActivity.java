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
    private ViewEventCenter iAQ;
    private ChosenPostModelController iAR;
    private b iAS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bHj().addEventDelegate(this);
        this.iAR = cvI();
        this.iAS = cvJ();
        if (getIntent() != null) {
            this.iAR.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iAR.aj(bundle);
        } else {
            this.iAR.aj(null);
        }
        setContentView(this.iAS.bYn());
        this.iAS.cvN();
        this.iAS.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController cvI() {
        if (this.iAR == null) {
            this.iAR = new ChosenPostModelController(this);
        }
        return this.iAR;
    }

    public b cvJ() {
        if (this.iAS == null) {
            this.iAS = new b(this);
        }
        return this.iAS;
    }

    public ViewEventCenter bHj() {
        if (this.iAQ == null) {
            this.iAQ = new ViewEventCenter();
        }
        return this.iAQ;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bGN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bGO()) {
            case 4096:
                b(bVar);
                break;
        }
        return cvJ().a(bVar) || cvI().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bGP = bVar.bGP();
        if (bGP instanceof d) {
            sendMessage(((d) bGP).gf(getPageContext().getPageActivity()));
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
        cvJ().onChangeSkinType(getPageContext(), i);
    }
}
