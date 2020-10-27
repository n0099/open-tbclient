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
    private ViewEventCenter hWK;
    private ChosenPostModelController hWL;
    private b hWM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bzy().addEventDelegate(this);
        this.hWL = cmy();
        this.hWM = cmz();
        if (getIntent() != null) {
            this.hWL.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.hWL.aj(bundle);
        } else {
            this.hWL.aj(null);
        }
        setContentView(this.hWM.bQd());
        this.hWM.cmD();
        this.hWM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController cmy() {
        if (this.hWL == null) {
            this.hWL = new ChosenPostModelController(this);
        }
        return this.hWL;
    }

    public b cmz() {
        if (this.hWM == null) {
            this.hWM = new b(this);
        }
        return this.hWM;
    }

    public ViewEventCenter bzy() {
        if (this.hWK == null) {
            this.hWK = new ViewEventCenter();
        }
        return this.hWK;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bzb() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bzc()) {
            case 4096:
                b(bVar);
                break;
        }
        return cmz().a(bVar) || cmy().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bzd = bVar.bzd();
        if (bzd instanceof d) {
            sendMessage(((d) bzd).fg(getPageContext().getPageActivity()));
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
        cmz().onChangeSkinType(getPageContext(), i);
    }
}
