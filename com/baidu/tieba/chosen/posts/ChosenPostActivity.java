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
    private ViewEventCenter gIO;
    private ChosenPostModelController gIP;
    private b gIQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bfn().addEventDelegate(this);
        this.gIP = bLX();
        this.gIQ = bLY();
        if (getIntent() != null) {
            this.gIP.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.gIP.aj(bundle);
        } else {
            this.gIP.aj(null);
        }
        setContentView(this.gIQ.btW());
        this.gIQ.bMc();
        this.gIQ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bLX() {
        if (this.gIP == null) {
            this.gIP = new ChosenPostModelController(this);
        }
        return this.gIP;
    }

    public b bLY() {
        if (this.gIQ == null) {
            this.gIQ = new b(this);
        }
        return this.gIQ;
    }

    public ViewEventCenter bfn() {
        if (this.gIO == null) {
            this.gIO = new ViewEventCenter();
        }
        return this.gIO;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean beR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.beS()) {
            case 4096:
                b(bVar);
                break;
        }
        return bLY().a(bVar) || bLX().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a beT = bVar.beT();
        if (beT instanceof d) {
            sendMessage(((d) beT).eD(getPageContext().getPageActivity()));
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
        bLY().onChangeSkinType(getPageContext(), i);
    }
}
