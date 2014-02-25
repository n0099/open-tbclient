package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.data.GroupData;
/* loaded from: classes.dex */
public class PersonalChatActivity extends MsglistActivity {
    public static boolean a;
    public static String b = "";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001002, new cl());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tieba.mention.v.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.ag.a(b);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void a(Intent intent) {
        UserData userData = (UserData) intent.getSerializableExtra("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        this.e.a(userData);
        this.e.a((GroupData) null);
    }

    private void a(UserData userData) {
        com.baidu.tieba.im.j.a(new co(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void a(Bundle bundle) {
        UserData userData = (UserData) bundle.getSerializable("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        this.e.a(userData);
        this.e.a((GroupData) null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k() {
        UserData b2 = this.e.b();
        if (b2 == null) {
            com.baidu.adp.lib.util.f.b("error:user or forum is null");
            return false;
        } else if (b2.getUserIdLong() == 0) {
            com.baidu.adp.lib.util.f.b("error:uid invalid," + b2.getUserId());
            return false;
        } else {
            return true;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void l() {
        this.d = new GroupChatView(this, this.e.d(), this.e.k());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        int i = q.a;
        this.d.a(this.e.b().getUserName(), false);
        this.d.a(this.e.c(), i);
        this.d.a(new cp(this));
    }

    @Override // com.baidu.tieba.im.chat.cz, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.A()) {
            com.baidu.tieba.ai.a(this, "personal_chat_page_morebutton");
            PersonalTalkSettingActivity.a(this.e.b().getUserIdLong());
        }
    }
}
