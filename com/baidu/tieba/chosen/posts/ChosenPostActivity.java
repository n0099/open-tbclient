package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter LF;
    private b aIx;
    private e aIy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oG().addEventDelegate(this);
        this.aIx = Hc();
        this.aIy = Hd();
        if (getIntent() != null) {
            this.aIx.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aIx.f(bundle);
        } else {
            this.aIx.f(null);
        }
        setContentView(this.aIy.pa());
        this.aIy.oR();
        this.aIy.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public b Hc() {
        if (this.aIx == null) {
            this.aIx = new b(this);
        }
        return this.aIx;
    }

    public e Hd() {
        if (this.aIy == null) {
            this.aIy = new e(this);
        }
        return this.aIy;
    }

    public ViewEventCenter oG() {
        if (this.LF == null) {
            this.LF = new ViewEventCenter();
        }
        return this.LF;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oJ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Ct()) {
            case 4096:
                b(bVar);
                break;
        }
        return Hd().a(bVar) || Hc().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Cu = bVar.Cu();
        if (Cu instanceof com.baidu.tieba.chosen.posts.a.h) {
            sendMessage(((com.baidu.tieba.chosen.posts.a.h) Cu).ar(getPageContext().getPageActivity()));
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
        Hd().onChangeSkinType(getPageContext(), i);
    }
}
