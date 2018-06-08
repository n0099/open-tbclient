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
    private ViewEventCenter cGe;
    private ChosenPostModelController cGf;
    private b cGg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        JT().addEventDelegate(this);
        this.cGf = akp();
        this.cGg = akq();
        if (getIntent() != null) {
            this.cGf.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cGf.i(bundle);
        } else {
            this.cGf.i(null);
        }
        setContentView(this.cGg.UI());
        this.cGg.akv();
        this.cGg.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController akp() {
        if (this.cGf == null) {
            this.cGf = new ChosenPostModelController(this);
        }
        return this.cGf;
    }

    public b akq() {
        if (this.cGg == null) {
            this.cGg = new b(this);
        }
        return this.cGg;
    }

    public ViewEventCenter JT() {
        if (this.cGe == null) {
            this.cGe = new ViewEventCenter();
        }
        return this.cGe;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Jl()) {
            case 4096:
                b(bVar);
                break;
        }
        return akq().a(bVar) || akp().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Jm = bVar.Jm();
        if (Jm instanceof d) {
            sendMessage(((d) Jm).bw(getPageContext().getPageActivity()));
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
        akq().d(getPageContext(), i);
    }
}
