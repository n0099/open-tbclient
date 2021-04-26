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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import d.a.c.e.p.k;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
/* loaded from: classes4.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupData f17743a;

        public a(GroupData groupData) {
            this.f17743a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.j0.e1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f17743a.getGroupId())));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupData f17745a;

        public b(GroupData groupData) {
            this.f17745a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            GroupData groupData;
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                GroupChatActivity.this.mListView.closeNotNotify();
            } else {
                GroupChatActivity.this.mListView.showNotNotfiy();
            }
            if (GroupChatActivity.this.mListModel == null || (groupData = this.f17745a) == null) {
                return;
            }
            String name = groupData.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            GroupChatActivity.this.mListView.refreshHeaderFooter(name, true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AbsMsglistView.f {
        public c() {
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData$VoiceModel voiceData$VoiceModel) {
            if (voiceData$VoiceModel != null) {
                GroupChatActivity.this.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
            }
        }
    }

    private void initCurId() {
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null && (msglistModel instanceof GroupMsglistModel)) {
            GroupData group = ((GroupMsglistModel) msglistModel).getGroup();
            if (group != null) {
                ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
                return;
            } else {
                ChatStatusManager.getInst().setCurId(2, "");
                return;
            }
        }
        ChatStatusManager.getInst().setCurId(2, "");
    }

    private void sendAutoMessage() {
        if (getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
        if (!k.isEmpty(stringExtra)) {
            getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            this.mListModel.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        if (k.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
            return;
        }
        getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        this.mListModel.sendTextMessage(stringExtra2);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(d.a.j0.e1.f.c cVar) {
        this.mListModel.loadFirst(cVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        try {
            GroupMsglistModel groupMsglistModel = new GroupMsglistModel(this);
            this.mListModel = groupMsglistModel;
            groupMsglistModel.setLoadDataCallBack(this.mMsgCallback);
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            return checkParam();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        this.mListView = new GroupChatView(this, this.mListModel.getIsAcceptNotify());
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel instanceof GroupMsglistModel) {
            long j = 0;
            if (((GroupMsglistModel) msglistModel).getGroup() != null) {
                j = ((GroupMsglistModel) this.mListModel).getGroup().getGroupId();
                this.mListView.refreshHeaderFooter(((GroupMsglistModel) this.mListModel).getGroup().getName(), true);
            }
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), j);
            this.mListView.setRecordCallback(new c());
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.mListModel).getGroup().getGroupId(), 3)));
            String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(stringExtra)) {
                return;
            }
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView instanceof GroupChatView) {
                ((GroupChatView) absMsglistView).d();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(2, "");
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, d.a.c.e.h.b
    public void onItemViewLongClick(View view, int i2, int i3, long j) {
        ChatMessage msg;
        super.onItemViewLongClick(view, i2, i3, j);
        if (i2 != 2 || (msg = this.mListModel.getMsg(i3)) == null || msg.getUserInfo() == null || msg.getUserInfo().getName_show() == null) {
            return;
        }
        this.mListView.addAt2SendMsg(msg.getUserInfo().getName_show());
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.a.i0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null) {
            msglistModel.onDestroy();
            this.mListModel = null;
        }
        super.onNewIntent(intent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        sendAutoMessage();
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(2, false);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(2, true);
        String curId = ChatStatusManager.getInst().getCurId(2);
        d.a.i0.s.d.b.g0().d(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        GroupData group;
        super.refreshHeadIcon();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null) {
            if (group != null) {
                String name = group.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.mListView.refreshHeaderFooter(name, true);
                }
            }
            h0.c(new a(group), new b(group));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
    }
}
