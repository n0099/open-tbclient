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
    private ViewEventCenter eFu;
    private ChosenPostModelController eFv;
    private b eFw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        atK().addEventDelegate(this);
        this.eFv = aYX();
        this.eFw = aYY();
        if (getIntent() != null) {
            this.eFv.K(getIntent().getExtras());
        } else if (bundle != null) {
            this.eFv.K(bundle);
        } else {
            this.eFv.K(null);
        }
        setContentView(this.eFw.aJI());
        this.eFw.aZd();
        this.eFw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController aYX() {
        if (this.eFv == null) {
            this.eFv = new ChosenPostModelController(this);
        }
        return this.eFv;
    }

    public b aYY() {
        if (this.eFw == null) {
            this.eFw = new b(this);
        }
        return this.eFw;
    }

    public ViewEventCenter atK() {
        if (this.eFu == null) {
            this.eFu = new ViewEventCenter();
        }
        return this.eFu;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean ata() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.atb()) {
            case 4096:
                b(bVar);
                break;
        }
        return aYY().a(bVar) || aYX().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a atc = bVar.atc();
        if (atc instanceof d) {
            sendMessage(((d) atc).dA(getPageContext().getPageActivity()));
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
        aYY().onChangeSkinType(getPageContext(), i);
    }
}
