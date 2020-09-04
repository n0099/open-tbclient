package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes17.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter hoo;
    private ChosenPostModelController hop;
    private b hoq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        btR().addEventDelegate(this);
        this.hop = ccG();
        this.hoq = ccH();
        if (getIntent() != null) {
            this.hop.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.hop.aj(bundle);
        } else {
            this.hop.aj(null);
        }
        setContentView(this.hoq.bJE());
        this.hoq.ccL();
        this.hoq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ccG() {
        if (this.hop == null) {
            this.hop = new ChosenPostModelController(this);
        }
        return this.hop;
    }

    public b ccH() {
        if (this.hoq == null) {
            this.hoq = new b(this);
        }
        return this.hoq;
    }

    public ViewEventCenter btR() {
        if (this.hoo == null) {
            this.hoo = new ViewEventCenter();
        }
        return this.hoo;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean btu() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.btv()) {
            case 4096:
                b(bVar);
                break;
        }
        return ccH().a(bVar) || ccG().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a btw = bVar.btw();
        if (btw instanceof d) {
            sendMessage(((d) btw).eS(getPageContext().getPageActivity()));
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
        ccH().onChangeSkinType(getPageContext(), i);
    }
}
