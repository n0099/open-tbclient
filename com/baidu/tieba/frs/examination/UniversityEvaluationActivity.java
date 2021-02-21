package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes2.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    private ForumWriteData jtH;
    private SerializableItemInfo jtJ;
    private a jtU;
    private boolean jtV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.jtH = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.jtJ = (SerializableItemInfo) getIntent().getSerializableExtra("item_info");
            this.jtV = getIntent().getBooleanExtra("item_is_school", false);
        }
        if (this.jtV) {
            this.jtU = new d(this, this.jtH, this.jtJ);
        } else {
            this.jtU = new b(this, this.jtH, this.jtJ);
        }
        this.jtU.cGU();
        setContentView(this.jtU.getView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jtU.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jtU.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jtU.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.jtU.cGT();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
