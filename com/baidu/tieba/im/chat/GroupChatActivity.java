package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes.dex */
public class GroupChatActivity extends CommonGroupChatActiviy {
    public static String ZK;
    public static boolean aOq;

    static {
        TbadkApplication.m251getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        ZK = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void Ju() {
        GroupData group;
        super.Ju();
        if ((this.aQe instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aQe).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aQd.refreshHeaderFooter(name, true);
                }
            }
            com.baidu.tieba.im.e.a(new bb(this, group), new bc(this, group));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void nY() {
        super.nY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aOq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aOq = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().cq(ZK);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZK, 1)));
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void nu() {
        this.aQd = new GroupChatView(this, this.aQe.getIsAcceptNotify());
        this.aQd.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.aQe instanceof GroupMsglistModel) {
            int i = 0;
            if (((GroupMsglistModel) this.aQe).getGroup() != null) {
                i = ((GroupMsglistModel) this.aQe).getGroup().getGroupId();
                this.aQd.refreshHeaderFooter(((GroupMsglistModel) this.aQe).getGroup().getName(), true);
            }
            this.aQd.bindDataAndRefresh(this.aQe.getData(), i);
            this.aQd.setRecordCallback(new bd(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aQd.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(this, ((GroupMsglistModel) this.aQe).getGroup().getGroupId(), 3)));
            if (TbadkApplication.getCurrentAccount().equals(getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID)) && (this.aQd instanceof GroupChatView)) {
                ((GroupChatView) this.aQd).JC();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.aQe.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                    this.aQd.addAt2SendMsg(msg.getUserInfo().getUserName());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean h(Bundle bundle) {
        try {
            this.aQe = new GroupMsglistModel(this);
            this.aQe.setLoadDataCallBack(this.aQo);
            if (bundle != null) {
                f(bundle);
            } else {
                Jv();
            }
            return Jw();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.aQe != null) {
            this.aQe.onDestroy();
            this.aQe = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Jy() {
        Jz();
    }

    private void Jz() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.aQe.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.aQe.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aQe.loadFirst(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void g(Bundle bundle) {
        super.g(bundle);
        JA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void i(Intent intent) {
        super.i(intent);
        JA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZK = "";
    }

    private void JA() {
        if (this.aQe == null || !(this.aQe instanceof GroupMsglistModel)) {
            ZK = "";
            return;
        }
        GroupData group = ((GroupMsglistModel) this.aQe).getGroup();
        if (group != null) {
            ZK = String.valueOf(group.getGroupId());
        } else {
            ZK = "";
        }
    }
}
