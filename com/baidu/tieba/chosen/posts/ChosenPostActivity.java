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
    private ViewEventCenter dge;
    private ChosenPostModelController dgf;
    private b dgg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Pe().addEventDelegate(this);
        this.dgf = arW();
        this.dgg = arX();
        if (getIntent() != null) {
            this.dgf.p(getIntent().getExtras());
        } else if (bundle != null) {
            this.dgf.p(bundle);
        } else {
            this.dgf.p(null);
        }
        setContentView(this.dgg.acA());
        this.dgg.asc();
        this.dgg.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController arW() {
        if (this.dgf == null) {
            this.dgf = new ChosenPostModelController(this);
        }
        return this.dgf;
    }

    public b arX() {
        if (this.dgg == null) {
            this.dgg = new b(this);
        }
        return this.dgg;
    }

    public ViewEventCenter Pe() {
        if (this.dge == null) {
            this.dge = new ViewEventCenter();
        }
        return this.dge;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Ov() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Ow()) {
            case 4096:
                b(bVar);
                break;
        }
        return arX().a(bVar) || arW().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Ox = bVar.Ox();
        if (Ox instanceof d) {
            sendMessage(((d) Ox).cp(getPageContext().getPageActivity()));
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
        arX().d(getPageContext(), i);
    }
}
