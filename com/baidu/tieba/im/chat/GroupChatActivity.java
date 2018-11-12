package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes3.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void aLP() {
        final GroupData group;
        super.aLP();
        if ((this.eCc instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.eCc).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.eCb.refreshHeaderFooter(name, true);
                }
            }
            x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.aSq().bN(TbadkApplication.getCurrentAccount(), String.valueOf(group.getGroupId())));
                }
            }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            GroupChatActivity.this.eCb.closeNotNotify();
                        } else {
                            GroupChatActivity.this.eCb.showNotNotfiy();
                        }
                        if (GroupChatActivity.this.eCc != null && group != null) {
                            String name2 = group.getName();
                            if (!TextUtils.isEmpty(name2)) {
                                GroupChatActivity.this.eCb.refreshHeaderFooter(name2, true);
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
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().gq(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        this.eCb = new GroupChatView(this, this.eCc.getIsAcceptNotify());
        this.eCb.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.eCc instanceof GroupMsglistModel) {
            long j = 0;
            if (((GroupMsglistModel) this.eCc).getGroup() != null) {
                j = ((GroupMsglistModel) this.eCc).getGroup().getGroupId();
                this.eCb.refreshHeaderFooter(((GroupMsglistModel) this.eCc).getGroup().getName(), true);
            }
            this.eCb.bindDataAndRefresh(this.eCc.getData(), j);
            this.eCb.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.3
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        GroupChatActivity.this.eCc.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aLO() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eCb.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.eCc).getGroup().getGroupId(), 3)));
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && TbadkApplication.getCurrentAccount().equals(stringExtra) && (this.eCb instanceof GroupChatView)) {
                ((GroupChatView) this.eCb).aLY();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.eCc.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getName_show() != null) {
                    this.eCb.addAt2SendMsg(msg.getUserInfo().getName_show());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean s(Bundle bundle) {
        try {
            this.eCc = new GroupMsglistModel(this);
            this.eCc.setLoadDataCallBack(this.eCm);
            if (bundle != null) {
                t(bundle);
            } else {
                aLQ();
            }
            return aLR();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.eCc != null) {
            this.eCc.onDestroy();
            this.eCc = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aLU() {
        aLV();
    }

    private void aLV() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.eCc.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.eCc.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.eCc.loadFirst(dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void u(Bundle bundle) {
        super.u(bundle);
        aLW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void Q(Intent intent) {
        super.Q(intent);
        aLW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(2, "");
    }

    private void aLW() {
        if (this.eCc == null || !(this.eCc instanceof GroupMsglistModel)) {
            ChatStatusManager.getInst().setCurId(2, "");
            return;
        }
        GroupData group = ((GroupMsglistModel) this.eCc).getGroup();
        if (group != null) {
            ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
        } else {
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }
}
