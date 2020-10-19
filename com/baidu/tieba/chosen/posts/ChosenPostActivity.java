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
    private ViewEventCenter hKn;
    private ChosenPostModelController hKo;
    private b hKp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bxF().addEventDelegate(this);
        this.hKo = cjr();
        this.hKp = cjs();
        if (getIntent() != null) {
            this.hKo.aj(getIntent().getExtras());
        } else if (bundle != null) {
            this.hKo.aj(bundle);
        } else {
            this.hKo.aj(null);
        }
        setContentView(this.hKp.bNy());
        this.hKp.cjw();
        this.hKp.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController cjr() {
        if (this.hKo == null) {
            this.hKo = new ChosenPostModelController(this);
        }
        return this.hKo;
    }

    public b cjs() {
        if (this.hKp == null) {
            this.hKp = new b(this);
        }
        return this.hKp;
    }

    public ViewEventCenter bxF() {
        if (this.hKn == null) {
            this.hKn = new ViewEventCenter();
        }
        return this.hKn;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bxi() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bxj()) {
            case 4096:
                b(bVar);
                break;
        }
        return cjs().a(bVar) || cjr().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a bxk = bVar.bxk();
        if (bxk instanceof d) {
            sendMessage(((d) bxk).ff(getPageContext().getPageActivity()));
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
        cjs().onChangeSkinType(getPageContext(), i);
    }
}
