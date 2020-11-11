package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.chosen.posts.a.d;
/* loaded from: classes23.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter icH;
    private ChosenPostModelController icI;
    private b icJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bBX().addEventDelegate(this);
        this.icI = coZ();
        this.icJ = cpa();
        if (getIntent() != null) {
            this.icI.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.icI.aj(bundle);
        } else {
            this.icI.aj(null);
        }
        setContentView(this.icJ.bSD());
        this.icJ.cpe();
        this.icJ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController coZ() {
        if (this.icI == null) {
            this.icI = new ChosenPostModelController(this);
        }
        return this.icI;
    }

    public b cpa() {
        if (this.icJ == null) {
            this.icJ = new b(this);
        }
        return this.icJ;
    }

    public ViewEventCenter bBX() {
        if (this.icH == null) {
            this.icH = new ViewEventCenter();
        }
        return this.icH;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bBA() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bBB()) {
            case 4096:
                b(bVar);
                break;
        }
        return cpa().a(bVar) || coZ().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bBC = bVar.bBC();
        if (bBC instanceof d) {
            sendMessage(((d) bBC).fg(getPageContext().getPageActivity()));
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
        cpa().onChangeSkinType(getPageContext(), i);
    }
}
