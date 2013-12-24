package com.baidu.tieba.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ae;
import com.baidu.tieba.BaseFragmentActivity;
/* loaded from: classes.dex */
public class ChatListActivity extends BaseFragmentActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ae a = getSupportFragmentManager().a();
        a.a(16908290, Fragment.a(this, ChatListFragment.class.getName()));
        a.a();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, ChatListActivity.class));
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
    }
}
