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
    public static String ZG;
    public static boolean aOc;

    static {
        TbadkApplication.m251getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        ZG = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void Jq() {
        GroupData group;
        super.Jq();
        if ((this.aPQ instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aPQ).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aPP.refreshHeaderFooter(name, true);
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
        aOc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aOc = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().cp(ZG);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZG, 1)));
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void nu() {
        this.aPP = new GroupChatView(this, this.aPQ.getIsAcceptNotify());
        this.aPP.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.aPQ instanceof GroupMsglistModel) {
            int i = 0;
            if (((GroupMsglistModel) this.aPQ).getGroup() != null) {
                i = ((GroupMsglistModel) this.aPQ).getGroup().getGroupId();
                this.aPP.refreshHeaderFooter(((GroupMsglistModel) this.aPQ).getGroup().getName(), true);
            }
            this.aPP.bindDataAndRefresh(this.aPQ.getData(), i);
            this.aPP.setRecordCallback(new bd(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aPP.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(this, ((GroupMsglistModel) this.aPQ).getGroup().getGroupId(), 3)));
            if (TbadkApplication.getCurrentAccount().equals(getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID)) && (this.aPP instanceof GroupChatView)) {
                ((GroupChatView) this.aPP).Jy();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.aPQ.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                    this.aPP.addAt2SendMsg(msg.getUserInfo().getUserName());
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
            this.aPQ = new GroupMsglistModel(this);
            this.aPQ.setLoadDataCallBack(this.aQa);
            if (bundle != null) {
                f(bundle);
            } else {
                Jr();
            }
            return Js();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.aPQ != null) {
            this.aPQ.onDestroy();
            this.aPQ = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Ju() {
        Jv();
    }

    private void Jv() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.aPQ.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.aPQ.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aPQ.loadFirst(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void g(Bundle bundle) {
        super.g(bundle);
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void i(Intent intent) {
        super.i(intent);
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZG = "";
    }

    private void Jw() {
        if (this.aPQ == null || !(this.aPQ instanceof GroupMsglistModel)) {
            ZG = "";
            return;
        }
        GroupData group = ((GroupMsglistModel) this.aPQ).getGroup();
        if (group != null) {
            ZG = String.valueOf(group.getGroupId());
        } else {
            ZG = "";
        }
    }
}
