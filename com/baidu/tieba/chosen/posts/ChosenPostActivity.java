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
    private ViewEventCenter fIC;
    private ChosenPostModelController fID;
    private b fIE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aOf().addEventDelegate(this);
        this.fID = btd();
        this.fIE = bte();
        if (getIntent() != null) {
            this.fID.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fID.ad(bundle);
        } else {
            this.fID.ad(null);
        }
        setContentView(this.fIE.bci());
        this.fIE.btj();
        this.fIE.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController btd() {
        if (this.fID == null) {
            this.fID = new ChosenPostModelController(this);
        }
        return this.fID;
    }

    public b bte() {
        if (this.fIE == null) {
            this.fIE = new b(this);
        }
        return this.fIE;
    }

    public ViewEventCenter aOf() {
        if (this.fIC == null) {
            this.fIC = new ViewEventCenter();
        }
        return this.fIC;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aNx() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aNy()) {
            case 4096:
                b(bVar);
                break;
        }
        return bte().a(bVar) || btd().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aNz = bVar.aNz();
        if (aNz instanceof d) {
            sendMessage(((d) aNz).eI(getPageContext().getPageActivity()));
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
        bte().onChangeSkinType(getPageContext(), i);
    }
}
