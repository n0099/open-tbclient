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
    private ViewEventCenter fLM;
    private ChosenPostModelController fLN;
    private b fLO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aOy().addEventDelegate(this);
        this.fLN = buf();
        this.fLO = bug();
        if (getIntent() != null) {
            this.fLN.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fLN.ad(bundle);
        } else {
            this.fLN.ad(null);
        }
        setContentView(this.fLO.bcD());
        this.fLO.bul();
        this.fLO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController buf() {
        if (this.fLN == null) {
            this.fLN = new ChosenPostModelController(this);
        }
        return this.fLN;
    }

    public b bug() {
        if (this.fLO == null) {
            this.fLO = new b(this);
        }
        return this.fLO;
    }

    public ViewEventCenter aOy() {
        if (this.fLM == null) {
            this.fLM = new ViewEventCenter();
        }
        return this.fLM;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aNQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aNR()) {
            case 4096:
                b(bVar);
                break;
        }
        return bug().a(bVar) || buf().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aNS = bVar.aNS();
        if (aNS instanceof d) {
            sendMessage(((d) aNS).eI(getPageContext().getPageActivity()));
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
        bug().onChangeSkinType(getPageContext(), i);
    }
}
