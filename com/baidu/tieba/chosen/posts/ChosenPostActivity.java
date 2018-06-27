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
    private ViewEventCenter cDX;
    private ChosenPostModelController cDY;
    private b cDZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kl().addEventDelegate(this);
        this.cDY = ajJ();
        this.cDZ = ajK();
        if (getIntent() != null) {
            this.cDY.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cDY.i(bundle);
        } else {
            this.cDY.i(null);
        }
        setContentView(this.cDZ.Vd());
        this.cDZ.ajP();
        this.cDZ.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ajJ() {
        if (this.cDY == null) {
            this.cDY = new ChosenPostModelController(this);
        }
        return this.cDY;
    }

    public b ajK() {
        if (this.cDZ == null) {
            this.cDZ = new b(this);
        }
        return this.cDZ;
    }

    public ViewEventCenter Kl() {
        if (this.cDX == null) {
            this.cDX = new ViewEventCenter();
        }
        return this.cDX;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean JC() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.JD()) {
            case 4096:
                b(bVar);
                break;
        }
        return ajK().a(bVar) || ajJ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a JE = bVar.JE();
        if (JE instanceof d) {
            sendMessage(((d) JE).bv(getPageContext().getPageActivity()));
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
        ajK().d(getPageContext(), i);
    }
}
