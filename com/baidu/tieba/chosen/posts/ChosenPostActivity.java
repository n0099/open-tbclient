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
    private ViewEventCenter eKx;
    private ChosenPostModelController eKy;
    private b eKz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        auU().addEventDelegate(this);
        this.eKy = baY();
        this.eKz = baZ();
        if (getIntent() != null) {
            this.eKy.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eKy.K(bundle);
        } else {
            this.eKy.K(null);
        }
        setContentView(this.eKz.aLp());
        this.eKz.bbe();
        this.eKz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController baY() {
        if (this.eKy == null) {
            this.eKy = new ChosenPostModelController(this);
        }
        return this.eKy;
    }

    public b baZ() {
        if (this.eKz == null) {
            this.eKz = new b(this);
        }
        return this.eKz;
    }

    public ViewEventCenter auU() {
        if (this.eKx == null) {
            this.eKx = new ViewEventCenter();
        }
        return this.eKx;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean auk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aul()) {
            case 4096:
                b(bVar);
                break;
        }
        return baZ().a(bVar) || baY().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aum = bVar.aum();
        if (aum instanceof d) {
            sendMessage(((d) aum).dB(getPageContext().getPageActivity()));
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
        baZ().onChangeSkinType(getPageContext(), i);
    }
}
