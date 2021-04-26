package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import d.a.j0.q0.o1.a;
import d.a.j0.q0.o1.b;
import d.a.j0.q0.o1.d;
/* loaded from: classes4.dex */
public class UniversityEvaluationActivity extends BaseFragmentActivity {
    public a mEvaluationView;
    public ForumWriteData mForumWriteData;
    public SerializableItemInfo mItemInfo;
    public boolean mItemIsSchool;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.mEvaluationView.h(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mEvaluationView.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.mForumWriteData = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
            this.mItemInfo = (SerializableItemInfo) getIntent().getSerializableExtra("item_info");
            this.mItemIsSchool = getIntent().getBooleanExtra("item_is_school", false);
        }
        if (this.mItemIsSchool) {
            this.mEvaluationView = new d(this, this.mForumWriteData, this.mItemInfo);
        } else {
            this.mEvaluationView = new b(this, this.mForumWriteData, this.mItemInfo);
        }
        this.mEvaluationView.c();
        setContentView(this.mEvaluationView.d());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mEvaluationView.j();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.mEvaluationView.l();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
