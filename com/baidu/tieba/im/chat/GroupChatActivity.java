package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes3.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void aFn() {
        final GroupData group;
        super.aFn();
        if ((this.ewR instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ewR).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.ewQ.refreshHeaderFooter(name, true);
                }
            }
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.aLU().bk(TbadkApplication.getCurrentAccount(), String.valueOf(group.getGroupId())));
                }
            }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            GroupChatActivity.this.ewQ.closeNotNotify();
                        } else {
                            GroupChatActivity.this.ewQ.showNotNotfiy();
                        }
                        if (GroupChatActivity.this.ewR != null && group != null) {
                            String name2 = group.getName();
                            if (!TextUtils.isEmpty(name2)) {
                                GroupChatActivity.this.ewQ.refreshHeaderFooter(name2, true);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(2, true);
        String curId = ChatStatusManager.getInst().getCurId(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fo(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        this.ewQ = new GroupChatView(this, this.ewR.getIsAcceptNotify());
        this.ewQ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.ewR instanceof GroupMsglistModel) {
            int i = 0;
            if (((GroupMsglistModel) this.ewR).getGroup() != null) {
                i = ((GroupMsglistModel) this.ewR).getGroup().getGroupId();
                this.ewQ.refreshHeaderFooter(((GroupMsglistModel) this.ewR).getGroup().getName(), true);
            }
            this.ewQ.bindDataAndRefresh(this.ewR.getData(), i);
            this.ewQ.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.3
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        GroupChatActivity.this.ewR.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aFm() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ewQ.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.ewR).getGroup().getGroupId(), 3)));
            if (TbadkApplication.getCurrentAccount().equals(getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID)) && (this.ewQ instanceof GroupChatView)) {
                ((GroupChatView) this.ewQ).aFw();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.ewR.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                    this.ewQ.addAt2SendMsg(msg.getUserInfo().getUserName());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean q(Bundle bundle) {
        try {
            this.ewR = new GroupMsglistModel(this);
            this.ewR.setLoadDataCallBack(this.exb);
            if (bundle != null) {
                r(bundle);
            } else {
                aFo();
            }
            return aFp();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.ewR != null) {
            this.ewR.onDestroy();
            this.ewR = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aFs() {
        aFt();
    }

    private void aFt() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.ewR.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.ewR.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.ewR.loadFirst(dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void s(Bundle bundle) {
        super.s(bundle);
        aFu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void N(Intent intent) {
        super.N(intent);
        aFu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(2, "");
    }

    private void aFu() {
        if (this.ewR == null || !(this.ewR instanceof GroupMsglistModel)) {
            ChatStatusManager.getInst().setCurId(2, "");
            return;
        }
        GroupData group = ((GroupMsglistModel) this.ewR).getGroup();
        if (group != null) {
            ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
        } else {
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
    }
}
