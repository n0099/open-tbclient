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
    private ViewEventCenter cGA;
    private ChosenPostModelController cGB;
    private b cGC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kk().addEventDelegate(this);
        this.cGB = akk();
        this.cGC = akl();
        if (getIntent() != null) {
            this.cGB.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cGB.i(bundle);
        } else {
            this.cGB.i(null);
        }
        setContentView(this.cGC.Vq());
        this.cGC.akq();
        this.cGC.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController akk() {
        if (this.cGB == null) {
            this.cGB = new ChosenPostModelController(this);
        }
        return this.cGB;
    }

    public b akl() {
        if (this.cGC == null) {
            this.cGC = new b(this);
        }
        return this.cGC;
    }

    public ViewEventCenter Kk() {
        if (this.cGA == null) {
            this.cGA = new ViewEventCenter();
        }
        return this.cGA;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean JB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.JC()) {
            case 4096:
                b(bVar);
                break;
        }
        return akl().a(bVar) || akk().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a JD = bVar.JD();
        if (JD instanceof d) {
            sendMessage(((d) JD).bw(getPageContext().getPageActivity()));
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
        akl().d(getPageContext(), i);
    }
}
