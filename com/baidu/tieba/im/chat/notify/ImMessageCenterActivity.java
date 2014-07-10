package com.baidu.tieba.im.chat.notify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class ImMessageCenterActivity extends BaseFragmentActivity {
    static {
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, Fragment.instantiate(this, d.class.getName()));
        beginTransaction.commit();
    }

    private static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008012, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }
}
