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
    private ViewEventCenter dfr;
    private ChosenPostModelController dfs;
    private b dft;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OM().addEventDelegate(this);
        this.dfs = ary();
        this.dft = arz();
        if (getIntent() != null) {
            this.dfs.p(getIntent().getExtras());
        } else if (bundle != null) {
            this.dfs.p(bundle);
        } else {
            this.dfs.p(null);
        }
        setContentView(this.dft.acd());
        this.dft.arE();
        this.dft.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    public ChosenPostModelController ary() {
        if (this.dfs == null) {
            this.dfs = new ChosenPostModelController(this);
        }
        return this.dfs;
    }

    public b arz() {
        if (this.dft == null) {
            this.dft = new b(this);
        }
        return this.dft;
    }

    public ViewEventCenter OM() {
        if (this.dfr == null) {
            this.dfr = new ViewEventCenter();
        }
        return this.dfr;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Od() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Oe()) {
            case 4096:
                b(bVar);
                break;
        }
        return arz().a(bVar) || ary().a(bVar);
    }

    private void b(com.baidu.tbadk.mvc.c.b bVar) {
        com.baidu.tbadk.mvc.b.a Of = bVar.Of();
        if (Of instanceof d) {
            sendMessage(((d) Of).cp(getPageContext().getPageActivity()));
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
        arz().d(getPageContext(), i);
    }
}
