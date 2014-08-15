package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity {
    public static boolean a;
    public static String b;
    private Handler m = new Handler();
    private com.baidu.adp.lib.guide.d n = null;
    private Runnable o = new cw(this);
    private Runnable p = new cx(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new ct());
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
            com.baidu.tieba.im.e.a(new cy(this, c), new cz(this));
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
        com.baidu.tbadk.coreExtra.messageCenter.a.a().b(b);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f(b, 2)));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.e.a(new da(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        UserData c;
        this.d = new PersonalChatView(this, this.e.j());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = w.a;
        if ((this.e instanceof PersonalMsglistModel) && (c = ((PersonalMsglistModel) this.e).c()) != null) {
            this.d.a(c.getUserName(), false);
            this.d.a(this.e.i(), i);
            this.d.a(new db(this));
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
    protected boolean a(bt btVar) {
        this.e.a(btVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage b2;
        String a2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage b3 = this.e.b(i2);
                if (b3 != null && b3.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this, b3.getUserInfo().getUserId(), b3.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (t() && (b2 = this.e.b(i2)) != null && com.baidu.tieba.im.d.j.b(b2) && (a2 = com.baidu.tieba.im.d.j.a(b2.getContent(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    PersonalMsgImageActivity.a(this, a2, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong(), String.valueOf(b2.getMsgId()));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
        ((PersonalMsglistModel) this.e).e(bundle.getInt("key_is_friend"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Intent intent) {
        super.a(intent);
        v();
        ((PersonalMsglistModel) this.e).e(intent.getIntExtra("key_is_friend", 1));
    }

    private void v() {
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
        w();
    }

    private void w() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.i.c(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.e.e(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.i.c(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.e.d(stringExtra2);
            }
        }
    }

    private void x() {
        boolean z = z();
        int m = ((PersonalMsglistModel) this.e).m();
        if (z && m == 0) {
            this.m.postDelayed(this.o, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        View view;
        if (this.d != null && this.d.m() != null) {
            int firstVisiblePosition = this.d.m().getFirstVisiblePosition();
            int lastVisiblePosition = this.d.m().getLastVisiblePosition();
            cq a2 = this.d.a();
            int i = lastVisiblePosition;
            while (true) {
                if (i < firstVisiblePosition) {
                    view = null;
                    break;
                } else if (com.baidu.tieba.im.d.j.e((ChatMessage) a2.getItem(i)) || this.d.m().getChildAt(i - firstVisiblePosition) == null) {
                    i--;
                } else {
                    view = this.d.m().getChildAt(i - firstVisiblePosition).findViewById(com.baidu.tieba.u.img_msgitem_photo);
                    break;
                }
            }
            if (view != null) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.a(view).a(0).b(false);
                gVar.a(new dc(this));
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
        com.baidu.tbadk.core.sharedPref.b.a().b("stranger_tips", z);
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
