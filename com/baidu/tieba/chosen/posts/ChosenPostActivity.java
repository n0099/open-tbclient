package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes8.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter iBT;
    private ChosenPostModelController iBU;
    private b iBV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bDI().addEventDelegate(this);
        this.iBU = ctc();
        this.iBV = ctd();
        if (getIntent() != null) {
            this.iBU.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.iBU.aj(bundle);
        } else {
            this.iBU.aj(null);
        }
        setContentView(this.iBV.bVk());
        this.iBV.cth();
        this.iBV.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ctc() {
        if (this.iBU == null) {
            this.iBU = new ChosenPostModelController(this);
        }
        return this.iBU;
    }

    public b ctd() {
        if (this.iBV == null) {
            this.iBV = new b(this);
        }
        return this.iBV;
    }

    public ViewEventCenter bDI() {
        if (this.iBT == null) {
            this.iBT = new ViewEventCenter();
        }
        return this.iBT;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDn()) {
            case 4096:
                b(bVar);
                break;
        }
        return ctd().a(bVar) || ctc().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bDo = bVar.bDo();
        if (bDo instanceof d) {
            sendMessage(((d) bDo).ge(getPageContext().getPageActivity()));
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
        ctd().onChangeSkinType(getPageContext(), i);
    }
}
