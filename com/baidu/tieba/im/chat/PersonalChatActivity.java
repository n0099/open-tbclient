package com.baidu.tieba.im.chat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001005, new cx());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public final void c() {
        UserData c;
        super.c();
        if ((this.e instanceof CommonPersonalMsglistModel) && (c = ((CommonPersonalMsglistModel) this.e).c()) != null) {
            com.baidu.tieba.im.s.a(new da(this, c), new db(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(b);
            if (a != null) {
                a.setUnread_count(0);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected final void a(UserData userData) {
        com.baidu.tieba.im.s.a(new dc(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final void o() {
        UserData c;
        this.d = new PersonalChatView(this, this.e.h());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        int i = x.a;
        if ((this.e instanceof PersonalMsglistModel) && (c = ((PersonalMsglistModel) this.e).c()) != null) {
            this.d.a(c.getUserName());
            this.d.a(this.e.g(), i);
            this.d.a(new dd(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.dn, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData c;
        super.onClick(view);
        if (view == this.d.A()) {
            com.baidu.tbadk.core.g.a(this, "personal_chat_page_morebutton");
            if ((this.e instanceof PersonalMsglistModel) && (c = ((PersonalMsglistModel) this.e).c()) != null) {
                PersonalTalkSettingActivity.a(c.getUserIdLong());
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean b(Bundle bundle) {
        try {
            this.e = new PersonalMsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                a(bundle);
            } else {
                l();
            }
            return k();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean p() {
        ((PersonalMsglistModel) this.e).b();
        this.e.d_();
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.dn, com.baidu.adp.lib.b.a
    public final void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.a.a a;
        String a2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                com.baidu.tieba.im.message.a.a a3 = this.e.a(i2);
                if (a3 != null && a3.r() != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this, a3.r().getUserId(), a3.r().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (s() && (a = this.e.a(i2)) != null && com.baidu.tieba.im.f.q.a(a) && (a2 = com.baidu.tieba.im.f.q.a(a.v(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    PersonalMsgImageActivity.a(this, a2, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong());
                    return;
                }
                return;
        }
    }
}
