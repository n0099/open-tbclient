package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes5.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter eKq;
    private ChosenPostModelController eKr;
    private b eKs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        auS().addEventDelegate(this);
        this.eKr = baW();
        this.eKs = baX();
        if (getIntent() != null) {
            this.eKr.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eKr.K(bundle);
        } else {
            this.eKr.K(null);
        }
        setContentView(this.eKs.aLn());
        this.eKs.bbc();
        this.eKs.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController baW() {
        if (this.eKr == null) {
            this.eKr = new ChosenPostModelController(this);
        }
        return this.eKr;
    }

    public b baX() {
        if (this.eKs == null) {
            this.eKs = new b(this);
        }
        return this.eKs;
    }

    public ViewEventCenter auS() {
        if (this.eKq == null) {
            this.eKq = new ViewEventCenter();
        }
        return this.eKq;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aui() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.auj()) {
            case 4096:
                b(bVar);
                break;
        }
        return baX().a(bVar) || baW().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a auk = bVar.auk();
        if (auk instanceof d) {
            sendMessage(((d) auk).dB(getPageContext().getPageActivity()));
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
        baX().onChangeSkinType(getPageContext(), i);
    }
}
