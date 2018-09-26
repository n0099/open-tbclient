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
    private ViewEventCenter cMr;
    private ChosenPostModelController cMs;
    private b cMt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LA().addEventDelegate(this);
        this.cMs = alV();
        this.cMt = alW();
        if (getIntent() != null) {
            this.cMs.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.cMs.i(bundle);
        } else {
            this.cMs.i(null);
        }
        setContentView(this.cMt.Xd());
        this.cMt.amb();
        this.cMt.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController alV() {
        if (this.cMs == null) {
            this.cMs = new ChosenPostModelController(this);
        }
        return this.cMs;
    }

    public b alW() {
        if (this.cMt == null) {
            this.cMt = new b(this);
        }
        return this.cMt;
    }

    public ViewEventCenter LA() {
        if (this.cMr == null) {
            this.cMr = new ViewEventCenter();
        }
        return this.cMr;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean KR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.KS()) {
            case 4096:
                b(bVar);
                break;
        }
        return alW().a(bVar) || alV().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a KT = bVar.KT();
        if (KT instanceof d) {
            sendMessage(((d) KT).cd(getPageContext().getPageActivity()));
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
        alW().d(getPageContext(), i);
    }
}
