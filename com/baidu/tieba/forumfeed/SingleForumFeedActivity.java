package com.baidu.tieba.forumfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.aa;
import com.baidu.tbadk.core.voice.y;
/* loaded from: classes.dex */
public class SingleForumFeedActivity extends BaseFragmentActivity implements aa {
    private a d;
    private VoiceManager e;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010011, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new VoiceManager();
        this.e.onCreate(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.d = new a();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(16908290, this.d);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.e.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.e.onStop(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.e.onSaveInstanceState(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.onDestory(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.d != null) {
            this.d.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView p_() {
        j f;
        if (this.d == null || (f = this.d.f()) == null) {
            return null;
        }
        return f.g();
    }
}
