package com.baidu.tieba.im.chat.notify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ImMessageCenterActivity extends com.baidu.tbadk.core.e {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008012, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, Fragment.instantiate(this, b.class.getName()));
        beginTransaction.commit();
    }

    @Override // com.baidu.tbadk.core.e
    protected final void b(int i) {
    }
}
