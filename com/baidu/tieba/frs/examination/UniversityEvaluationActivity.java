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
    private ForumWriteData ifP;
    private SerializableItemInfo ifR;
    private a igc;
    private boolean igd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.ifP = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.ifR = (SerializableItemInfo) getIntent().getSerializableExtra(UniversityEvaluationConfig.ITEM_INFO);
            this.igd = getIntent().getBooleanExtra(UniversityEvaluationConfig.ITEM_IS_SCHOOL, false);
        }
        if (this.igd) {
            this.igc = new d(this, this.ifP, this.ifR);
        } else {
            this.igc = new b(this, this.ifP, this.ifR);
        }
        this.igc.cqb();
        setContentView(this.igc.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.igc.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.igc.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.igc.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.igc.cqa();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
