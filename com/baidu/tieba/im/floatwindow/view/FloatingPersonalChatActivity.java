package com.baidu.tieba.im.floatwindow.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private static CustomMessageListener aRu = new o(2005016);
    private static com.baidu.tieba.im.chat.personaltalk.e aRy;
    private static List<UserData> mUserDataList;
    private com.baidu.tbadk.coreExtra.relationship.f aRw;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String ahu = "";
    private long aRv = 0;
    private String aRx = TbadkCoreApplication.getCurrentAccount();
    private boolean aYC = false;
    private Runnable aRB = new x(this);
    private com.baidu.adp.framework.listener.e aRC = new y(this, 205101, true);
    private CustomMessageListener aRD = new z(this, 0);
    private com.baidu.adp.lib.d.d locationCallBack = new aa(this);
    private FloatingPersonalChatView aYD = null;
    private View.OnClickListener aYE = new ab(this);
    private final CustomMessageListener aSs = new ac(this, 0);

    static {
        MessageManager.getInstance().registerListener(aRu);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002011, new u());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        mUserDataList = null;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
            com.baidu.tieba.im.i.a(new ad(this, user), new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().dn(this.ahu);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(this.ahu, 2)));
        if (this.mListModel != null && (this.mListModel instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.mListModel).sendHasReadReceiveOther();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.i.a(new q(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        if (this.mListModel != null && mUserDataList != null && mUserDataList.size() > 0 && !this.aYC) {
            this.aYC = true;
            this.aYD = new FloatingPersonalChatView(this, this.mListModel.getIsAcceptNotify(), mUserDataList);
            this.mListView = this.aYD;
            this.aYD.setOnClickListener(this.aYE);
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.bnb;
            if ((this.mListModel instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.mListModel).getUser()) != null) {
                this.mUser = user;
                this.aYD.a(this.mUser.getUserName(), this.aRw);
                this.mListView.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.mListView.setRecordCallback(new r(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void Km() {
        if (TbadkCoreApplication.m255getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.aRx) + "&" + this.mUser.getUserId();
            if (!aRy.fT(str)) {
                com.baidu.adp.lib.d.a.dD().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.f fU = aRy.fU(str);
            if (fU != null) {
                this.aYD.a(this.mUser.getUserName(), fU);
                this.aRv = fS(ba.m(fU.getTime()));
                if (this.aRv != 0) {
                    this.mHandler.postDelayed(this.aRB, this.aRv);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            registerListener(this.aRC);
            if (aRy == null) {
                aRy = new com.baidu.tieba.im.chat.personaltalk.e();
            }
            this.mListModel = new PersonalMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
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
    protected boolean first(com.baidu.tieba.im.chat.ar arVar) {
        if (this.mListModel != null) {
            this.mListModel.loadFirst(arVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String s;
        super.onItemViewClick(view, i, i2, j);
        if (this.mListModel != null) {
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
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
        if (this.mListModel instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        if (this.mListModel instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void initCurId() {
        if (this.mListModel == null || !(this.mListModel instanceof PersonalMsglistModel)) {
            this.ahu = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.mListModel).getUser();
        if (user != null) {
            this.ahu = String.valueOf(user.getUserId());
        } else {
            this.ahu = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.ahu);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new s(this), 60L);
        Km();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (getIntent() != null && this.mListModel != null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ahu = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aRB);
        }
        com.baidu.tieba.im.floatwindow.b.MX().Ng();
        com.baidu.adp.lib.d.a.dD().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return mUserDataList;
    }

    public void fL(int i) {
        if ((this.mListModel instanceof PersonalMsglistModel) && mUserDataList != null && mUserDataList.size() > 0) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.mListModel;
            personalMsglistModel.setUser(mUserDataList.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.ahu = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.ahu);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.aYD.gC(this.ahu) ? 1 : 0);
            personalMsglistModel.loadFirst(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mUserDataList == null || mUserDataList.isEmpty()) {
            finish();
            return;
        }
        registerListener(2016003, this.aSs);
        registerListener(2001176, this.aRD);
        registerListener(2001177, this.aRD);
        registerListener(2001225, this.aRD);
        registerListener(2001226, this.aRD);
        registerListener(2001227, this.aRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.aYD.NR();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
