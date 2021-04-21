package com.baidu.tbadk.template.base;

import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import d.b.i0.x0.a;
/* loaded from: classes3.dex */
public abstract class BaseTemplatePageActivity extends BaseActivity {
    public a mPageLoader;
    public ViewGroup mRootLayout;

    public abstract a buildPageTemplate();

    public abstract int getLayoutR();

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a aVar = this.mPageLoader;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
        this.mRootLayout = viewGroup;
        setContentView(viewGroup);
        this.mPageLoader = buildPageTemplate();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.mPageLoader;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a aVar = this.mPageLoader;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a aVar = this.mPageLoader;
        if (aVar != null) {
            aVar.d();
        }
    }
}
