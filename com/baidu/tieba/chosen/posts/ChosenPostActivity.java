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
    private ViewEventCenter gtS;
    private ChosenPostModelController gtT;
    private b gtU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aZc().addEventDelegate(this);
        this.gtT = bFA();
        this.gtU = bFB();
        if (getIntent() != null) {
            this.gtT.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.gtT.ad(bundle);
        } else {
            this.gtT.ad(null);
        }
        setContentView(this.gtU.bom());
        this.gtU.bFG();
        this.gtU.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bFA() {
        if (this.gtT == null) {
            this.gtT = new ChosenPostModelController(this);
        }
        return this.gtT;
    }

    public b bFB() {
        if (this.gtU == null) {
            this.gtU = new b(this);
        }
        return this.gtU;
    }

    public ViewEventCenter aZc() {
        if (this.gtS == null) {
            this.gtS = new ViewEventCenter();
        }
        return this.gtS;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aYG() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aYH()) {
            case 4096:
                b(bVar);
                break;
        }
        return bFB().a(bVar) || bFA().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aYI = bVar.aYI();
        if (aYI instanceof d) {
            sendMessage(((d) aYI).eo(getPageContext().getPageActivity()));
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
        bFB().onChangeSkinType(getPageContext(), i);
    }
}
