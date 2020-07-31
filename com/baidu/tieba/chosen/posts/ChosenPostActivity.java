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
    private ViewEventCenter hbt;
    private ChosenPostModelController hbu;
    private b hbv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bld().addEventDelegate(this);
        this.hbu = bSt();
        this.hbv = bSu();
        if (getIntent() != null) {
            this.hbu.ak(getIntent().getExtras());
        } else if (bundle != null) {
            this.hbu.ak(bundle);
        } else {
            this.hbu.ak(null);
        }
        setContentView(this.hbv.bAi());
        this.hbv.bSy();
        this.hbv.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bSt() {
        if (this.hbu == null) {
            this.hbu = new ChosenPostModelController(this);
        }
        return this.hbu;
    }

    public b bSu() {
        if (this.hbv == null) {
            this.hbv = new b(this);
        }
        return this.hbv;
    }

    public ViewEventCenter bld() {
        if (this.hbt == null) {
            this.hbt = new ViewEventCenter();
        }
        return this.hbt;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bkH() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bkI()) {
            case 4096:
                b(bVar);
                break;
        }
        return bSu().a(bVar) || bSt().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bkJ = bVar.bkJ();
        if (bkJ instanceof d) {
            sendMessage(((d) bkJ).eI(getPageContext().getPageActivity()));
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
        bSu().onChangeSkinType(getPageContext(), i);
    }
}
