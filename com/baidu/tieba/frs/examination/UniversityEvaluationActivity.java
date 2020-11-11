package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes22.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    private ForumWriteData iUj;
    private SerializableItemInfo iUl;
    private a iUw;
    private boolean iUx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.iUj = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.iUl = (SerializableItemInfo) getIntent().getSerializableExtra(UniversityEvaluationConfig.ITEM_INFO);
            this.iUx = getIntent().getBooleanExtra(UniversityEvaluationConfig.ITEM_IS_SCHOOL, false);
        }
        if (this.iUx) {
            this.iUw = new d(this, this.iUj, this.iUl);
        } else {
            this.iUw = new b(this, this.iUj, this.iUl);
        }
        this.iUw.cCu();
        setContentView(this.iUw.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iUw.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.iUw.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.iUw.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.iUw.cCt();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
