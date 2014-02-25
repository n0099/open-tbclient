package com.baidu.tieba.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
/* loaded from: classes.dex */
public class ImMessageCenterActivity extends com.baidu.tieba.k {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, Fragment.instantiate(this, a.class.getName()));
        beginTransaction.commit();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, ImMessageCenterActivity.class));
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
    }
}
