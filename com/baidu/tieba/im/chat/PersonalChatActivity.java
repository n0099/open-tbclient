package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.UserData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalChatActivity extends MsglistActivity {
    public static boolean a;
    public static String b = "";

    public static void a(Context context, long j, String str, String str2, int i, String str3) {
        UserData userData = new UserData();
        userData.setUserId(j);
        userData.setUserName(str);
        userData.setPortrait(str2);
        userData.setSex(i);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(String.valueOf(j));
        com.baidu.tieba.im.db.au.a().a(linkedList, new cd(context, userData));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, UserData userData, boolean z) {
        Intent intent = new Intent(context, PersonalChatActivity.class);
        if (userData.getUserId() == 0) {
            com.baidu.adp.lib.g.e.d("userid" + userData.getUserId());
            return;
        }
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("is_accept_notify", z);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cp, com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cp, com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tieba.mention.s.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.i.a(b);
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
        com.baidu.tieba.im.m.a(new ce(this, userData), null);
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
            com.baidu.adp.lib.g.e.a("error:user or forum is null");
            return false;
        } else if (b2.getUserId() == 0) {
            com.baidu.adp.lib.g.e.a("error:uid invalid," + b2.getUserId());
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
        this.d.a(new cf(this));
    }

    @Override // com.baidu.tieba.im.chat.cp, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.z()) {
            com.baidu.tieba.ao.a(this, "personal_chat_page_morebutton");
            PersonalTalkSettingActivity.a(this.e.b().getUserId());
        }
    }
}
