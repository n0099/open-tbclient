package com.baidu.tieba.im.chat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes.dex */
public class GroupChatActivity extends CommonGroupChatActiviy {
    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.n.class, GroupChatActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public final void c() {
        GroupData b;
        super.c();
        if ((this.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.e).b()) != null) {
            if (b != null) {
                String name = b.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name);
                }
            }
            com.baidu.tieba.im.r.a(new bd(this, b), new be(this, b));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public final void m() {
        super.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            String str = b;
            com.baidu.tieba.im.pushNotify.a.d().b(false, null);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final void o() {
        this.d = new GroupChatView(this, this.e.h());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        if (this.e instanceof GroupMsglistModel) {
            int i = 0;
            if (((GroupMsglistModel) this.e).b() != null) {
                i = ((GroupMsglistModel) this.e).b().getGroupId();
                this.d.a(((GroupMsglistModel) this.e).b().getName());
            }
            this.d.a(this.e.g(), i);
            this.d.a(new bf(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.dj, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.A()) {
            sendMessage(new com.baidu.adp.framework.message.a(2008011, new com.baidu.tbadk.core.b.o(this, ((GroupMsglistModel) this.e).b().getGroupId(), 3)));
            if (TbadkApplication.E().equals(getIntent().getStringExtra("group_author_id")) && (this.d instanceof GroupChatView)) {
                ((GroupChatView) this.d).R();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean b(Bundle bundle) {
        try {
            this.e = new GroupMsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                a(bundle);
            } else {
                k();
            }
            return l();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean p() {
        this.e.f_();
        return true;
    }
}
