package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes9.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    private b hyJ;
    private ForumWriteData hyK;
    private SerializableItemInfo hyL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.hyK = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.hyL = (SerializableItemInfo) getIntent().getSerializableExtra(UniversityEvaluationConfig.ITEM_INFO);
        }
        this.hyJ = new b(this, this.hyK, this.hyL);
        setContentView(this.hyJ.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hyJ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hyJ.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.hyJ.bYL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
