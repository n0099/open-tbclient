package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter MB;
    private b aSY;
    private e aSZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oF().addEventDelegate(this);
        this.aSY = KF();
        this.aSZ = KG();
        if (getIntent() != null) {
            this.aSY.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.aSY.c(bundle);
        } else {
            this.aSY.c((Bundle) null);
        }
        setContentView(this.aSZ.pa());
        this.aSZ.oQ();
        this.aSZ.d(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public b KF() {
        if (this.aSY == null) {
            this.aSY = new b(this);
        }
        return this.aSY;
    }

    public e KG() {
        if (this.aSZ == null) {
            this.aSZ = new e(this);
        }
        return this.aSZ;
    }

    public ViewEventCenter oF() {
        if (this.MB == null) {
            this.MB = new ViewEventCenter();
        }
        return this.MB;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.EE()) {
            case 4096:
                b(bVar);
                break;
        }
        return KG().a(bVar) || KF().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a EF = bVar.EF();
        if (EF instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) EF).as(getPageContext().getPageActivity()));
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
        KG().d(getPageContext(), i);
    }
}
