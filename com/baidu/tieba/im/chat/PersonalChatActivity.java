package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity {
    public static boolean a;
    public static String b;
    private Handler m = new Handler();
    private com.baidu.adp.lib.guide.d n = null;
    private Runnable o = new cv(this);
    private Runnable p = new cw(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new cs());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        b = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        UserData c;
        super.c();
        if ((this.e instanceof CommonPersonalMsglistModel) && (c = ((CommonPersonalMsglistModel) this.e).c()) != null) {
            com.baidu.tieba.im.i.a(new cx(this, c), new cy(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.im.model.p.b(b);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.i.a(new cz(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        UserData c;
        this.d = new PersonalChatView(this, this.e.i());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = w.a;
        if ((this.e instanceof PersonalMsglistModel) && (c = ((PersonalMsglistModel) this.e).c()) != null) {
            this.d.a(c.getUserName(), false);
            this.d.a(this.e.h(), i);
            this.d.a(new da(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData c;
        super.onClick(view);
        if (view == this.d.G()) {
            com.baidu.tbadk.core.f.a(this, "personal_chat_page_morebutton");
            if ((this.e instanceof PersonalMsglistModel) && (c = ((PersonalMsglistModel) this.e).c()) != null) {
                PersonalTalkSettingActivity.a(c.getUserIdLong());
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        try {
            this.e = new PersonalMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            if (bundle != null) {
                b(bundle);
            } else {
                l();
            }
            return k();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bv bvVar) {
        this.e.a(bvVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage a2;
        String a3;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage a4 = this.e.a(i2);
                if (a4 != null && a4.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(this, a4.getUserInfo().getUserId(), a4.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (t() && (a2 = this.e.a(i2)) != null && com.baidu.tieba.im.e.r.a(a2) && (a3 = com.baidu.tieba.im.e.r.a(a2.getContent(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    PersonalMsgImageActivity.a(this, a3, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong(), String.valueOf(a2.getMsgId()));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Bundle bundle) {
        super.a(bundle);
        w();
        ((PersonalMsglistModel) this.e).d(bundle.getInt("key_is_friend"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Intent intent) {
        super.a(intent);
        w();
        ((PersonalMsglistModel) this.e).d(intent.getIntExtra("key_is_friend", 1));
    }

    private void w() {
        if (this.e == null || !(this.e instanceof PersonalMsglistModel)) {
            b = "";
            return;
        }
        UserData c = ((PersonalMsglistModel) this.e).c();
        if (c != null) {
            b = String.valueOf(c.getUserId());
        } else {
            b = "";
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void p() {
        super.p();
        x();
    }

    private void x() {
        boolean z = z();
        int l = ((PersonalMsglistModel) this.e).l();
        if (z && l == 0) {
            this.m.postDelayed(this.o, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        View view;
        if (this.d != null && this.d.m() != null) {
            int firstVisiblePosition = this.d.m().getFirstVisiblePosition();
            int lastVisiblePosition = this.d.m().getLastVisiblePosition();
            cp a2 = this.d.a();
            int i = lastVisiblePosition;
            while (true) {
                if (i < firstVisiblePosition) {
                    view = null;
                    break;
                } else if (com.baidu.tieba.im.e.r.d((ChatMessage) a2.getItem(i)) || this.d.m().getChildAt(i - firstVisiblePosition) == null) {
                    i--;
                } else {
                    view = this.d.m().getChildAt(i - firstVisiblePosition).findViewById(com.baidu.tieba.v.img_msgitem_photo);
                    break;
                }
            }
            if (view != null) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.a(view).a(0).b(false);
                gVar.a(new db(this));
                this.n = gVar.a();
                this.n.a(this);
                a(false);
                this.m.postDelayed(this.p, 3000L);
            }
        }
    }

    private boolean z() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("stranger_tips", true);
    }

    private void a(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.a().c("stranger_tips", z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b = "";
        if (this.m != null) {
            this.m.removeCallbacks(this.p);
            this.m.removeCallbacks(this.o);
        }
    }
}
