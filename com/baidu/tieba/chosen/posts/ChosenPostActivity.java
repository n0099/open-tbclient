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
    private ViewEventCenter eMg;
    private ChosenPostModelController eMh;
    private b eMi;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        avg().addEventDelegate(this);
        this.eMh = bbC();
        this.eMi = bbD();
        if (getIntent() != null) {
            this.eMh.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eMh.K(bundle);
        } else {
            this.eMh.K(null);
        }
        setContentView(this.eMi.aLT());
        this.eMi.bbI();
        this.eMi.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bbC() {
        if (this.eMh == null) {
            this.eMh = new ChosenPostModelController(this);
        }
        return this.eMh;
    }

    public b bbD() {
        if (this.eMi == null) {
            this.eMi = new b(this);
        }
        return this.eMi;
    }

    public ViewEventCenter avg() {
        if (this.eMg == null) {
            this.eMg = new ViewEventCenter();
        }
        return this.eMg;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean auw() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aux()) {
            case 4096:
                b(bVar);
                break;
        }
        return bbD().a(bVar) || bbC().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a auy = bVar.auy();
        if (auy instanceof d) {
            sendMessage(((d) auy).dC(getPageContext().getPageActivity()));
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
        bbD().onChangeSkinType(getPageContext(), i);
    }
}
