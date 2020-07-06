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
    private ViewEventCenter gVO;
    private ChosenPostModelController gVP;
    private b gVQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bhs().addEventDelegate(this);
        this.gVP = bPi();
        this.gVQ = bPj();
        if (getIntent() != null) {
            this.gVP.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.gVP.aj(bundle);
        } else {
            this.gVP.aj(null);
        }
        setContentView(this.gVQ.bwS());
        this.gVQ.bPn();
        this.gVQ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bPi() {
        if (this.gVP == null) {
            this.gVP = new ChosenPostModelController(this);
        }
        return this.gVP;
    }

    public b bPj() {
        if (this.gVQ == null) {
            this.gVQ = new b(this);
        }
        return this.gVQ;
    }

    public ViewEventCenter bhs() {
        if (this.gVO == null) {
            this.gVO = new ViewEventCenter();
        }
        return this.gVO;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bgW() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bgX()) {
            case 4096:
                b(bVar);
                break;
        }
        return bPj().a(bVar) || bPi().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bgY = bVar.bgY();
        if (bgY instanceof d) {
            sendMessage(((d) bgY).eE(getPageContext().getPageActivity()));
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
        bPj().onChangeSkinType(getPageContext(), i);
    }
}
