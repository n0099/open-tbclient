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
    private ViewEventCenter cVP;
    private ChosenPostModelController cVQ;
    private b cVR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NH().addEventDelegate(this);
        this.cVQ = aoW();
        this.cVR = aoX();
        if (getIntent() != null) {
            this.cVQ.m(getIntent().getExtras());
        } else if (bundle != null) {
            this.cVQ.m(bundle);
        } else {
            this.cVQ.m(null);
        }
        setContentView(this.cVR.aaV());
        this.cVR.apc();
        this.cVR.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aoW() {
        if (this.cVQ == null) {
            this.cVQ = new ChosenPostModelController(this);
        }
        return this.cVQ;
    }

    public b aoX() {
        if (this.cVR == null) {
            this.cVR = new b(this);
        }
        return this.cVR;
    }

    public ViewEventCenter NH() {
        if (this.cVP == null) {
            this.cVP = new ViewEventCenter();
        }
        return this.cVP;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MY() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.MZ()) {
            case 4096:
                b(bVar);
                break;
        }
        return aoX().a(bVar) || aoW().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Na = bVar.Na();
        if (Na instanceof d) {
            sendMessage(((d) Na).cl(getPageContext().getPageActivity()));
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
        aoX().d(getPageContext(), i);
    }
}
