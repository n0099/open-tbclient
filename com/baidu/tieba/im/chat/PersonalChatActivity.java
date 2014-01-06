package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.data.UserData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalChatActivity extends ba {
    public static boolean a;

    public static void a(Context context, long j, String str, String str2, int i, String str3) {
        UserData userData = new UserData();
        userData.setUserId(j);
        userData.setUserName(str);
        userData.setPortrait(str2);
        userData.setSex(i);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(String.valueOf(j));
        com.baidu.tieba.im.db.as.a().a(linkedList, new cl(context, userData));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, UserData userData, boolean z) {
        Intent intent = new Intent(context, PersonalChatActivity.class);
        if (userData.getUserId() == 0) {
            com.baidu.adp.lib.h.e.d("userid" + userData.getUserId());
            return;
        }
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("is_accept_notify", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ba, com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ba, com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
    }
}
