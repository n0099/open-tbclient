package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupChatActivity extends MsglistActivity {
    public static boolean a;
    public static String b = "";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001003, new al());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void j() {
        super.j();
        com.baidu.tieba.im.messageCenter.e.a().a(103013, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-125, this);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        super.a(sVar);
        switch (sVar.w()) {
            case -125:
                if (TiebaApplication.g().aS() && this.i == 0) {
                    this.d.Q().setVisibility(0);
                    this.d.Q().h();
                    return;
                }
                return;
            case 103013:
                if (sVar instanceof com.baidu.tieba.im.message.cm) {
                    com.baidu.tieba.im.message.cm cmVar = (com.baidu.tieba.im.message.cm) sVar;
                    if (cmVar.l()) {
                        if (cmVar.m() > 0 && !TextUtils.isEmpty(cmVar.n())) {
                            showToast(cmVar.n());
                            return;
                        } else {
                            showToast(R.string.neterror);
                            return;
                        }
                    } else if (cmVar.a() == 0) {
                        showToast(cmVar.b());
                        return;
                    } else {
                        com.baidu.tieba.im.widget.a.a(this, cmVar.c());
                        return;
                    }
                }
                return;
            default:
                return;
        }
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
        if (TiebaApplication.g().aS() && this.i == 0 && this.d != null && this.d.Q() != null) {
            this.d.Q().setVisibility(0);
            this.d.Q().h();
            this.d.Q().setOnClickListener(new am(this));
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
            com.baidu.adp.lib.util.f.b("error:group or forum is null");
            return false;
        } else if (a2.getGroupId() == 0) {
            com.baidu.adp.lib.util.f.b("error:gid invalid," + a2.getGroupId());
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
        this.d.a(new ao(this));
    }

    @Override // com.baidu.tieba.im.chat.cz, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.A()) {
            GroupInfoActivity.a(this, this.e.a().getGroupId(), 3);
            if (TiebaApplication.A().equals(getIntent().getStringExtra("group_author_id")) && (this.d instanceof GroupChatView)) {
                ((GroupChatView) this.d).S();
            }
        }
    }
}
