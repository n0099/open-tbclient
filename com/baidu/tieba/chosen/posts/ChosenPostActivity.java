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
    private ViewEventCenter cUJ;
    private ChosenPostModelController cUK;
    private b cUL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ny().addEventDelegate(this);
        this.cUK = apv();
        this.cUL = apw();
        if (getIntent() != null) {
            this.cUK.j(getIntent().getExtras());
        } else if (bundle != null) {
            this.cUK.j(bundle);
        } else {
            this.cUK.j(null);
        }
        setContentView(this.cUL.aaK());
        this.cUL.apB();
        this.cUL.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController apv() {
        if (this.cUK == null) {
            this.cUK = new ChosenPostModelController(this);
        }
        return this.cUK;
    }

    public b apw() {
        if (this.cUL == null) {
            this.cUL = new b(this);
        }
        return this.cUL;
    }

    public ViewEventCenter Ny() {
        if (this.cUJ == null) {
            this.cUJ = new ViewEventCenter();
        }
        return this.cUJ;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.MQ()) {
            case 4096:
                b(bVar);
                break;
        }
        return apw().a(bVar) || apv().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a MR = bVar.MR();
        if (MR instanceof d) {
            sendMessage(((d) MR).cq(getPageContext().getPageActivity()));
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
        apw().d(getPageContext(), i);
    }
}
