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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes3.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void bzQ() {
        final GroupData group;
        super.bzQ();
        if ((this.gzO instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.gzO).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.gzN.refreshHeaderFooter(name, true);
                }
            }
            aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.bGq().dp(TbadkApplication.getCurrentAccount(), String.valueOf(group.getGroupId())));
                }
            }, new k<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            GroupChatActivity.this.gzN.closeNotNotify();
                        } else {
                            GroupChatActivity.this.gzN.showNotNotfiy();
                        }
                        if (GroupChatActivity.this.gzO != null && group != null) {
                            String name2 = group.getName();
                            if (!TextUtils.isEmpty(name2)) {
                                GroupChatActivity.this.gzN.refreshHeaderFooter(name2, true);
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
        com.baidu.tbadk.coreExtra.messageCenter.b.anD().pk(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        this.gzN = new GroupChatView(this, this.gzO.getIsAcceptNotify());
        this.gzN.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.gzO instanceof GroupMsglistModel) {
            long j = 0;
            if (((GroupMsglistModel) this.gzO).getGroup() != null) {
                j = ((GroupMsglistModel) this.gzO).getGroup().getGroupId();
                this.gzN.refreshHeaderFooter(((GroupMsglistModel) this.gzO).getGroup().getName(), true);
            }
            this.gzN.bindDataAndRefresh(this.gzO.getData(), j);
            this.gzN.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.3
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        GroupChatActivity.this.gzO.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bzP() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gzN.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.gzO).getGroup().getGroupId(), 3)));
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && TbadkApplication.getCurrentAccount().equals(stringExtra) && (this.gzN instanceof GroupChatView)) {
                ((GroupChatView) this.gzN).bzZ();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.gzO.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getName_show() != null) {
                    this.gzN.addAt2SendMsg(msg.getUserInfo().getName_show());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean U(Bundle bundle) {
        try {
            this.gzO = new GroupMsglistModel(this);
            this.gzO.setLoadDataCallBack(this.gzY);
            if (bundle != null) {
                V(bundle);
            } else {
                bzR();
            }
            return bzS();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.gzO != null) {
            this.gzO.onDestroy();
            this.gzO = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void bzV() {
        bzW();
    }

    private void bzW() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!com.baidu.adp.lib.util.k.isEmpty(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.gzO.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!com.baidu.adp.lib.util.k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.gzO.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.gzO.loadFirst(dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void W(Bundle bundle) {
        super.W(bundle);
        bzX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void ak(Intent intent) {
        super.ak(intent);
        bzX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(2, "");
    }

    private void bzX() {
        if (this.gzO == null || !(this.gzO instanceof GroupMsglistModel)) {
            ChatStatusManager.getInst().setCurId(2, "");
            return;
        }
        GroupData group = ((GroupMsglistModel) this.gzO).getGroup();
        if (group != null) {
            ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
        } else {
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }
}
