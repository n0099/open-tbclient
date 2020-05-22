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
    private ViewEventCenter gID;
    private ChosenPostModelController gIE;
    private b gIF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bfm().addEventDelegate(this);
        this.gIE = bLV();
        this.gIF = bLW();
        if (getIntent() != null) {
            this.gIE.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.gIE.aj(bundle);
        } else {
            this.gIE.aj(null);
        }
        setContentView(this.gIF.btU());
        this.gIF.bMa();
        this.gIF.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bLV() {
        if (this.gIE == null) {
            this.gIE = new ChosenPostModelController(this);
        }
        return this.gIE;
    }

    public b bLW() {
        if (this.gIF == null) {
            this.gIF = new b(this);
        }
        return this.gIF;
    }

    public ViewEventCenter bfm() {
        if (this.gID == null) {
            this.gID = new ViewEventCenter();
        }
        return this.gID;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean beQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.beR()) {
            case 4096:
                b(bVar);
                break;
        }
        return bLW().a(bVar) || bLV().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a beS = bVar.beS();
        if (beS instanceof d) {
            sendMessage(((d) beS).eD(getPageContext().getPageActivity()));
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
        bLW().onChangeSkinType(getPageContext(), i);
    }
}
