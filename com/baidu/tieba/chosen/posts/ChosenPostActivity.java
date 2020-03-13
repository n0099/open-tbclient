package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes10.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter fOx;
    private ChosenPostModelController fOy;
    private b fOz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aQQ().addEventDelegate(this);
        this.fOy = bvM();
        this.fOz = bvN();
        if (getIntent() != null) {
            this.fOy.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.fOy.ad(bundle);
        } else {
            this.fOy.ad(null);
        }
        setContentView(this.fOz.beT());
        this.fOz.bvS();
        this.fOz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bvM() {
        if (this.fOy == null) {
            this.fOy = new ChosenPostModelController(this);
        }
        return this.fOy;
    }

    public b bvN() {
        if (this.fOz == null) {
            this.fOz = new b(this);
        }
        return this.fOz;
    }

    public ViewEventCenter aQQ() {
        if (this.fOx == null) {
            this.fOx = new ViewEventCenter();
        }
        return this.fOx;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQn() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQo()) {
            case 4096:
                b(bVar);
                break;
        }
        return bvN().a(bVar) || bvM().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aQp = bVar.aQp();
        if (aQp instanceof d) {
            sendMessage(((d) aQp).eL(getPageContext().getPageActivity()));
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
        bvN().onChangeSkinType(getPageContext(), i);
    }
}
