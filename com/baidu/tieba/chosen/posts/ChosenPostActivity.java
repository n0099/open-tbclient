package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes7.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter iwj;
    private ChosenPostModelController iwk;
    private b iwl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bDq().addEventDelegate(this);
        this.iwk = crQ();
        this.iwl = crR();
        if (getIntent() != null) {
            this.iwk.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iwk.aj(bundle);
        } else {
            this.iwk.aj(null);
        }
        setContentView(this.iwl.bUv());
        this.iwl.crV();
        this.iwl.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController crQ() {
        if (this.iwk == null) {
            this.iwk = new ChosenPostModelController(this);
        }
        return this.iwk;
    }

    public b crR() {
        if (this.iwl == null) {
            this.iwl = new b(this);
        }
        return this.iwl;
    }

    public ViewEventCenter bDq() {
        if (this.iwj == null) {
            this.iwj = new ViewEventCenter();
        }
        return this.iwj;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bCU() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bCV()) {
            case 4096:
                b(bVar);
                break;
        }
        return crR().a(bVar) || crQ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bCW = bVar.bCW();
        if (bCW instanceof d) {
            sendMessage(((d) bCW).gc(getPageContext().getPageActivity()));
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
        crR().onChangeSkinType(getPageContext(), i);
    }
}
