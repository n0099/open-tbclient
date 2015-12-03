package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter LW;
    private b aMY;
    private e aMZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oM().addEventDelegate(this);
        this.aMY = Iv();
        this.aMZ = Iw();
        if (getIntent() != null) {
            this.aMY.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aMY.f(bundle);
        } else {
            this.aMY.f(null);
        }
        setContentView(this.aMZ.pg());
        this.aMZ.oX();
        this.aMZ.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b Iv() {
        if (this.aMY == null) {
            this.aMY = new b(this);
        }
        return this.aMY;
    }

    public e Iw() {
        if (this.aMZ == null) {
            this.aMZ = new e(this);
        }
        return this.aMZ;
    }

    public ViewEventCenter oM() {
        if (this.LW == null) {
            this.LW = new ViewEventCenter();
        }
        return this.LW;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Du()) {
            case 4096:
                b(bVar);
                break;
        }
        return Iw().a(bVar) || Iv().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Dv = bVar.Dv();
        if (Dv instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) Dv).ar(getPageContext().getPageActivity()));
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
        Iw().onChangeSkinType(getPageContext(), i);
    }
}
