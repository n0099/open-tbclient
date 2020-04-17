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
    private ViewEventCenter gtM;
    private ChosenPostModelController gtN;
    private b gtO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aZe().addEventDelegate(this);
        this.gtN = bFC();
        this.gtO = bFD();
        if (getIntent() != null) {
            this.gtN.ad(getIntent().getExtras());
        } else if (bundle != null) {
            this.gtN.ad(bundle);
        } else {
            this.gtN.ad(null);
        }
        setContentView(this.gtO.boo());
        this.gtO.bFI();
        this.gtO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController bFC() {
        if (this.gtN == null) {
            this.gtN = new ChosenPostModelController(this);
        }
        return this.gtN;
    }

    public b bFD() {
        if (this.gtO == null) {
            this.gtO = new b(this);
        }
        return this.gtO;
    }

    public ViewEventCenter aZe() {
        if (this.gtM == null) {
            this.gtM = new ViewEventCenter();
        }
        return this.gtM;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aYI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aYJ()) {
            case 4096:
                b(bVar);
                break;
        }
        return bFD().a(bVar) || bFC().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a aYK = bVar.aYK();
        if (aYK instanceof d) {
            sendMessage(((d) aYK).eA(getPageContext().getPageActivity()));
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
        bFD().onChangeSkinType(getPageContext(), i);
    }
}
