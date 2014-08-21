package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes.dex */
public class GroupChatActivity extends CommonGroupChatActiviy {
    public static boolean a;
    public static String b;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.y.class, GroupChatActivity.class);
        b = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        GroupData c;
        super.c();
        if ((this.e instanceof CommonGroupMsglistModel) && (c = ((CommonGroupMsglistModel) this.e).c()) != null) {
            if (c != null) {
                String name = c.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name, true);
                }
            }
            com.baidu.tieba.im.e.a(new bb(this, c), new bc(this, c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void m() {
        super.m();
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
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f(b, 1)));
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        this.d = new GroupChatView(this, this.e.j());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.e instanceof GroupMsglistModel) {
            int i = 0;
            if (((GroupMsglistModel) this.e).c() != null) {
                i = ((GroupMsglistModel) this.e).c().getGroupId();
                this.d.a(((GroupMsglistModel) this.e).c().getName(), true);
            }
            this.d.a(this.e.i(), i);
            this.d.a(new bd(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.G()) {
            sendMessage(new CustomMessage(2008011, new com.baidu.tbadk.core.atomData.z(this, ((GroupMsglistModel) this.e).c().getGroupId(), 3)));
            if (TbadkApplication.getCurrentAccount().equals(getIntent().getStringExtra("group_author_id")) && (this.d instanceof GroupChatView)) {
                ((GroupChatView) this.d).T();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage b2 = this.e.b(i2);
                if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getUserName() != null) {
                    this.d.b(b2.getUserInfo().getUserName());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        try {
            this.e = new GroupMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            if (bundle != null) {
                a(bundle);
            } else {
                k();
            }
            return l();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void p() {
        v();
    }

    private void v() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("auto_send_extra_msg");
            if (!com.baidu.adp.lib.util.i.c(stringExtra)) {
                getIntent().removeExtra("auto_send_extra_msg");
                this.e.e(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("auto_send_text_msg");
            if (!com.baidu.adp.lib.util.i.c(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("auto_send_text_msg");
                this.e.d(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.e.a(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void b(Bundle bundle) {
        super.b(bundle);
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void a(Intent intent) {
        super.a(intent);
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b = "";
    }

    private void w() {
        if (this.e == null || !(this.e instanceof GroupMsglistModel)) {
            b = "";
            return;
        }
        GroupData c = ((GroupMsglistModel) this.e).c();
        if (c != null) {
            b = String.valueOf(c.getGroupId());
        } else {
            b = "";
        }
    }
}
