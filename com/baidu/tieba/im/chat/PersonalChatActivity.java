package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalTalkSettingActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private static CustomMessageListener aRu = new bs(2005016);
    private static com.baidu.tieba.im.chat.personaltalk.e aRy;
    private PersonalChatView aRA;
    private com.baidu.tbadk.coreExtra.relationship.f aRw;
    private PersonalMsglistModel aRz;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private com.baidu.adp.lib.guide.d Ac = null;
    private long aRv = 0;
    private String aRx = TbadkCoreApplication.getCurrentAccount();
    private Runnable aRB = new cb(this);
    private Runnable Ao = new cc(this);
    private com.baidu.adp.framework.listener.e aRC = new cd(this, 205101, true);
    private CustomMessageListener aRD = new ce(this, 0);
    private com.baidu.adp.lib.d.d locationCallBack = new cf(this);

    static {
        MessageManager.getInstance().registerListener(aRu);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new by());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    protected void sendTextMsg() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.mListModel.getData().getChatMessages().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            chatMessage = it.next();
            if (chatMessage.getMsgType() == 23) {
                if (chatMessage.getLocalData().getStatus().shortValue() != 3) {
                    z = false;
                }
            }
        }
        chatMessage = null;
        z = true;
        if (!z) {
            chatMessage.setSt_type("aio");
            this.mListModel.doSendText(chatMessage);
        }
        super.sendTextMsg();
    }

    public long fS(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.contains("分钟") || str.contains("刚刚")) {
            return TbConfig.USE_TIME_INTERVAL;
        }
        if (str.contains("小时")) {
            return 3600000L;
        }
        return str.contains("天") ? 86400000L : 0L;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
            com.baidu.tieba.im.i.a(new cg(this, user), new ch(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().dn(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(curId, 2)));
        if (this.mListModel != null && (this.mListModel instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.mListModel).sendHasReadReceiveOther();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.i.a(new bt(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.aRA = (PersonalChatView) this.mListView;
        int i = com.baidu.tieba.im.c.a.bnb;
        if ((this.mListModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.mListModel).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.im.floatwindow.b.MX().gA(this.mUser.getUserId());
            com.baidu.tieba.im.floatwindow.b.MX().gx(this.mUser.getUserId());
            this.mListView.refreshPersonalHeadFooter(this.mUser.getUserName(), this.aRw);
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), i);
            this.mListView.setRecordCallback(new bu(this));
            if (!Kn()) {
                Kl();
            }
            if (!TextUtils.isEmpty(this.aRz.getReplyContent())) {
                this.aRz.insertReplyCard(this.aRz.getReplyContent());
            }
        }
    }

    public PersonalMsglistModel Kk() {
        return this.aRz;
    }

    private void Kl() {
        com.baidu.tieba.im.i.a(new bv(this), new bw(this));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            com.baidu.tbadk.core.i.B(getPageContext().getContext(), "personal_chat_page_morebutton");
            if ((this.mListModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.mListModel).getUser()) != null) {
                sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.aRA.Kt()) {
            if (this.aRz.getCardStatus() == PersonalMsglistModel.CardStatus.APPLY || this.aRz.getCardStatus() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.aRz.getUser().getUserId(), this.aRz.getUser().getUserName(), this.aRz.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.aRz.getCardStatus() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.yC().c(com.baidu.adp.lib.g.c.a(this.aRz.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void Km() {
        if (TbadkCoreApplication.m255getInst().getLocationShared()) {
            String str = String.valueOf(this.aRx) + "&" + this.mUser.getUserId();
            if (!aRy.fT(str)) {
                com.baidu.adp.lib.d.a.dD().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.f fU = aRy.fU(str);
            this.mListView.refreshPersonalHeadFooter(this.mUser.getUserName(), fU);
            this.aRv = fS(com.baidu.tbadk.core.util.ba.m(fU.getTime()));
            if (this.aRv != 0) {
                this.mHandler.postDelayed(this.aRB, this.aRv);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            registerListener(this.aRC);
            registerListener(2001176, this.aRD);
            registerListener(2001177, this.aRD);
            registerListener(2001225, this.aRD);
            registerListener(2001226, this.aRD);
            registerListener(2001227, this.aRD);
            if (aRy == null) {
                aRy = new com.baidu.tieba.im.chat.personaltalk.e();
            }
            this.mListModel = new PersonalMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
            this.aRz = (PersonalMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            return checkParam();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean first(ar arVar) {
        this.mListModel.loadFirst(arVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String s;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.mListModel.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.o(msg) && (s = com.baidu.tieba.im.util.i.s(msg.getContent(), true)) != null && (this.mListModel instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.mListModel).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), s, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.mListModel).setReplyContent(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.mListModel).setReplyContent(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.mListModel).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).getReplyContent());
    }

    private void initCurId() {
        if (this.mListModel == null || !(this.mListModel instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.mListModel).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new bx(this), 60L);
        Km();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.k.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.mListModel.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.mListModel.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean Kn() {
        return ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.im.floatwindow.b.MX().gy(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.Ao);
            this.mHandler.removeCallbacks(this.aRB);
        }
        com.baidu.adp.lib.d.a.dD().a(this.locationCallBack);
    }
}
