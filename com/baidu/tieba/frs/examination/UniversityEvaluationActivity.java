package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes16.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    private ForumWriteData hRF;
    private SerializableItemInfo hRH;
    private a hRS;
    private boolean hRT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.hRF = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.hRH = (SerializableItemInfo) getIntent().getSerializableExtra(UniversityEvaluationConfig.ITEM_INFO);
            this.hRT = getIntent().getBooleanExtra(UniversityEvaluationConfig.ITEM_IS_SCHOOL, false);
        }
        if (this.hRT) {
            this.hRS = new d(this, this.hRF, this.hRH);
        } else {
            this.hRS = new b(this, this.hRF, this.hRH);
        }
        this.hRS.cfw();
        setContentView(this.hRS.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hRS.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hRS.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.hRS.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.hRS.cfv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
