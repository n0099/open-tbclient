package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.content.Intent;
import com.baidu.tieba.im.data.GroupData;
/* loaded from: classes.dex */
public class GroupChatActivity extends bc {
    public static boolean a;

    public static void a(Activity activity, int i, String str, long j, String str2) {
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(j);
        String valueOf = String.valueOf(i);
        if (!com.baidu.tieba.model.cb.a().a(valueOf)) {
            new com.baidu.tieba.account.w("chat_pg", str2, valueOf).start();
            com.baidu.tieba.model.cb.a().a(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        a(activity, groupData, true);
    }

    private static void a(Activity activity, GroupData groupData, boolean z) {
        Intent intent = new Intent(activity, GroupChatActivity.class);
        if (groupData.getGroupId() == 0) {
            com.baidu.adp.lib.h.e.d("grounid" + groupData.getGroupId());
            return;
        }
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra("is_accept_notify", z);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bc, com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bc, com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
    }
}
