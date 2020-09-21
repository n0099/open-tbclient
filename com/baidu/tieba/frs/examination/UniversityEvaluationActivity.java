package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes21.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    private ForumWriteData imW;
    private SerializableItemInfo imY;
    private a inj;
    private boolean ink;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.imW = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.imY = (SerializableItemInfo) getIntent().getSerializableExtra(UniversityEvaluationConfig.ITEM_INFO);
            this.ink = getIntent().getBooleanExtra(UniversityEvaluationConfig.ITEM_IS_SCHOOL, false);
        }
        if (this.ink) {
            this.inj = new d(this, this.imW, this.imY);
        } else {
            this.inj = new b(this, this.imW, this.imY);
        }
        this.inj.ctp();
        setContentView(this.inj.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.inj.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.inj.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.inj.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.inj.cto();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
