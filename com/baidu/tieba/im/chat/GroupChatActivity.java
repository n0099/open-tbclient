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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
/* loaded from: classes20.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void cqs() {
        final GroupData group;
        super.cqs();
        if ((this.iRB instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.iRB).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.iRA.refreshHeaderFooter(name, true);
                }
            }
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.cxq().eC(TbadkApplication.getCurrentAccount(), String.valueOf(group.getGroupId())));
                }
            }, new l<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            GroupChatActivity.this.iRA.closeNotNotify();
                        } else {
                            GroupChatActivity.this.iRA.showNotNotfiy();
                        }
                        if (GroupChatActivity.this.iRB != null && group != null) {
                            String name2 = group.getName();
                            if (!TextUtils.isEmpty(name2)) {
                                GroupChatActivity.this.iRA.refreshHeaderFooter(name2, true);
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
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().yJ(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        this.iRA = new GroupChatView(this, this.iRB.getIsAcceptNotify());
        this.iRA.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.iRB instanceof GroupMsglistModel) {
            long j = 0;
            if (((GroupMsglistModel) this.iRB).getGroup() != null) {
                j = ((GroupMsglistModel) this.iRB).getGroup().getGroupId();
                this.iRA.refreshHeaderFooter(((GroupMsglistModel) this.iRB).getGroup().getName(), true);
            }
            this.iRA.bindDataAndRefresh(this.iRB.getData(), j);
            this.iRA.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.GroupChatActivity.3
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        GroupChatActivity.this.iRB.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cqr() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iRA.getBtnGroupInfo()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.iRB).getGroup().getGroupId(), 3)));
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && TbadkApplication.getCurrentAccount().equals(stringExtra) && (this.iRA instanceof GroupChatView)) {
                ((GroupChatView) this.iRA).cqB();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void onItemViewLongClick(View view, int i, int i2, long j) {
        super.onItemViewLongClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg = this.iRB.getMsg(i2);
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getName_show() != null) {
                    this.iRA.addAt2SendMsg(msg.getUserInfo().getName_show());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean au(Bundle bundle) {
        try {
            this.iRB = new GroupMsglistModel(this);
            this.iRB.setLoadDataCallBack(this.iRL);
            if (bundle != null) {
                av(bundle);
            } else {
                cqt();
            }
            return cqu();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.iRB != null) {
            this.iRB.onDestroy();
            this.iRB = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void cqx() {
        cqy();
    }

    private void cqy() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
                this.iRB.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
                this.iRB.sendTextMessage(stringExtra2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.iRB.loadFirst(dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void aw(Bundle bundle) {
        super.aw(bundle);
        cqz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void X(Intent intent) {
        super.X(intent);
        cqz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(2, "");
    }

    private void cqz() {
        if (this.iRB == null || !(this.iRB instanceof GroupMsglistModel)) {
            ChatStatusManager.getInst().setCurId(2, "");
            return;
        }
        GroupData group = ((GroupMsglistModel) this.iRB).getGroup();
        if (group != null) {
            ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
        } else {
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
    }
}
