package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupChatActivity extends MsglistActivity {
    public static boolean a;
    public static String b = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void j() {
        super.j();
        com.baidu.tieba.im.messageCenter.e.a().a(103013, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-125, this);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        super.a(qVar);
        switch (qVar.w()) {
            case -125:
                if (TiebaApplication.h().aV() && this.i == 0) {
                    this.d.O().setVisibility(0);
                    this.d.O().h();
                    return;
                }
                return;
            case 103013:
                if (qVar instanceof com.baidu.tieba.im.message.cd) {
                    com.baidu.tieba.im.message.cd cdVar = (com.baidu.tieba.im.message.cd) qVar;
                    if (cdVar.k()) {
                        if (cdVar.l() > 0 && !TextUtils.isEmpty(cdVar.m())) {
                            showToast(cdVar.m());
                            return;
                        } else {
                            showToast(R.string.neterror);
                            return;
                        }
                    } else if (cdVar.a() == 0) {
                        showToast(cdVar.b());
                        return;
                    } else {
                        com.baidu.tieba.im.widget.a.a(this, cdVar.c());
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

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
            com.baidu.adp.lib.g.e.d("grounid" + groupData.getGroupId());
            return;
        }
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra("is_accept_notify", z);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        activity.startActivity(intent);
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
        if (TiebaApplication.h().aV() && this.i == 0 && this.d != null && this.d.O() != null) {
            this.d.O().setVisibility(0);
            this.d.O().h();
            this.d.O().setOnClickListener(new ag(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void a(Intent intent) {
        this.e.a((GroupData) intent.getSerializableExtra("group"));
        this.e.a((UserData) null);
        b = String.valueOf(this.e.a().getGroupId());
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void a(Bundle bundle) {
        this.e.a((GroupData) bundle.getSerializable("group"));
        b = String.valueOf(this.e.a().getGroupId());
        this.e.a((UserData) null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k() {
        GroupData a2 = this.e.a();
        if (a2 == null) {
            com.baidu.adp.lib.g.e.a("error:group or forum is null");
            return false;
        } else if (a2.getGroupId() == 0) {
            com.baidu.adp.lib.g.e.a("error:gid invalid," + a2.getGroupId());
            return false;
        } else {
            return true;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void l() {
        int i;
        this.d = new GroupChatView(this, this.e.d(), this.e.k());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        int i2 = q.a;
        if (this.e.k() == 0 && this.e.a() != null) {
            i = this.e.a().getGroupId();
            this.d.a(this.e.a().getName(), true);
        } else {
            i = q.a;
            this.d.a(this.e.b().getUserName(), false);
        }
        this.d.a(this.e.c(), i);
        this.d.a(new ai(this));
    }

    @Override // com.baidu.tieba.im.chat.cp, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.z()) {
            GroupInfoActivity.a(this, this.e.a().getGroupId(), 3);
        }
    }
}
