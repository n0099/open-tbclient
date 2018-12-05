package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes3.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ChosenPostModelController dcA;
    private b dcB;
    private ViewEventCenter dcz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OL().addEventDelegate(this);
        this.dcA = aqJ();
        this.dcB = aqK();
        if (getIntent() != null) {
            this.dcA.p(getIntent().getExtras());
        } else if (bundle != null) {
            this.dcA.p(bundle);
        } else {
            this.dcA.p(null);
        }
        setContentView(this.dcB.acb());
        this.dcB.aqP();
        this.dcB.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aqJ() {
        if (this.dcA == null) {
            this.dcA = new ChosenPostModelController(this);
        }
        return this.dcA;
    }

    public b aqK() {
        if (this.dcB == null) {
            this.dcB = new b(this);
        }
        return this.dcB;
    }

    public ViewEventCenter OL() {
        if (this.dcz == null) {
            this.dcz = new ViewEventCenter();
        }
        return this.dcz;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Oc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Od()) {
            case 4096:
                b(bVar);
                break;
        }
        return aqK().a(bVar) || aqJ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Oe = bVar.Oe();
        if (Oe instanceof d) {
            sendMessage(((d) Oe).cp(getPageContext().getPageActivity()));
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
        aqK().d(getPageContext(), i);
    }
}
