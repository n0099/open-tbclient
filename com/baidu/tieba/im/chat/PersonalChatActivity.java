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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity {
    public static String ZG;
    public static boolean aOc;
    private static CustomMessageListener aPA = new cv(2005016);
    private static com.baidu.tieba.im.chat.personaltalk.b aPE;
    private com.baidu.tbadk.coreExtra.relationship.f aPC;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private com.baidu.adp.lib.guide.d aHF = null;
    private long aPB = 0;
    private String aPD = TbadkApplication.getCurrentAccount();
    private Runnable aPF = new dd(this);
    private Runnable aPG = new de(this);
    private Runnable aHH = new df(this);
    private com.baidu.adp.framework.listener.e aPH = new dg(this, 205101, true);
    private com.baidu.adp.lib.d.d locationCallBack = new dh(this);

    static {
        MessageManager.getInstance().registerListener(aPA);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new da());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ZG = "";
    }

    public long fA(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void Jq() {
        UserData user;
        super.Jq();
        if ((this.aPQ instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.aPQ).getUser()) != null) {
            com.baidu.tieba.im.e.a(new di(this, user), new dj(this));
        }
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
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().cq(ZG);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZG, 2)));
        if (this.aPQ != null && (this.aPQ instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.aPQ).sendHasReadReceiveOther();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.e.a(new cw(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void nu() {
        UserData user;
        this.aPP = new PersonalChatView(this, this.aPQ.getIsAcceptNotify());
        this.aPP.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = w.aNF;
        if ((this.aPQ instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.aPQ).getUser()) != null) {
            this.mUser = user;
            this.aPP.refreshPersonalHeadFooter(this.mUser.getUserName(), this.aPC);
            this.aPP.bindDataAndRefresh(this.aPQ.getData(), i);
            this.aPP.setRecordCallback(new cx(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.aPP.getBtnGroupInfo()) {
            com.baidu.tbadk.core.i.l(this, "personal_chat_page_morebutton");
            if ((this.aPQ instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.aPQ).getUser()) != null) {
                PersonalTalkSettingActivity.L(user.getUserIdLong());
            }
        }
    }

    public void JX() {
        if (TbadkApplication.m251getInst().getLocationShared()) {
            String str = String.valueOf(this.aPD) + "&" + this.mUser.getUserId();
            if (!aPE.fE(str)) {
                com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.f fF = aPE.fF(str);
            this.aPP.refreshPersonalHeadFooter(this.mUser.getUserName(), fF);
            this.aPB = fA(com.baidu.tbadk.core.util.ay.i(fF.getTime()));
            if (this.aPB != 0) {
                this.mHandler.postDelayed(this.aPF, this.aPB);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean h(Bundle bundle) {
        try {
            registerListener(this.aPH);
            if (aPE == null) {
                aPE = new com.baidu.tieba.im.chat.personaltalk.b();
            }
            this.aPQ = new PersonalMsglistModel(this);
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aPQ.loadFirst(btVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String v;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.aPQ.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (Kf() && (msg = this.aPQ.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (v = com.baidu.tieba.im.util.i.v(msg.getContent(), true)) != null && (this.aPQ instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.aPQ).getUser() != null) {
                    PersonalMsgImageActivity.a(this, v, ((CommonPersonalMsglistModel) this.aPQ).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void g(Bundle bundle) {
        super.g(bundle);
        Jw();
        ((PersonalMsglistModel) this.aPQ).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void i(Intent intent) {
        super.i(intent);
        Jw();
        ((PersonalMsglistModel) this.aPQ).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
    }

    private void Jw() {
        if (this.aPQ == null || !(this.aPQ instanceof PersonalMsglistModel)) {
            ZG = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.aPQ).getUser();
        if (user != null) {
            ZG = String.valueOf(user.getUserId());
        } else {
            ZG = "";
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Ju() {
        super.Ju();
        JY();
        this.handler.postDelayed(new cy(this), 60L);
        JX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.aPQ.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.aPQ.sendTextMessage(stringExtra2);
            }
        }
    }

    private void JY() {
        boolean JZ = JZ();
        int isFriend = ((PersonalMsglistModel) this.aPQ).getIsFriend();
        if (JZ && isFriend == 0) {
            this.mHandler.postDelayed(this.aPG, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho() {
        View view;
        if (this.aPP != null && this.aPP.getMsgListView() != null) {
            int firstVisiblePosition = this.aPP.getMsgListView().getFirstVisiblePosition();
            int lastVisiblePosition = this.aPP.getMsgListView().getLastVisiblePosition();
            cs adapter = this.aPP.getAdapter();
            int i = lastVisiblePosition;
            while (true) {
                if (i < firstVisiblePosition) {
                    view = null;
                    break;
                } else if (com.baidu.tieba.im.util.i.s((ChatMessage) adapter.getItem(i)) || this.aPP.getMsgListView().getChildAt(i - firstVisiblePosition) == null) {
                    i--;
                } else {
                    view = this.aPP.getMsgListView().getChildAt(i - firstVisiblePosition).findViewById(com.baidu.tieba.v.img_msgitem_photo);
                    break;
                }
            }
            if (view != null) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.b(view).A(0).r(false);
                gVar.a(new cz(this));
                this.aHF = gVar.dA();
                this.aHF.c(this);
                cC(false);
                this.mHandler.postDelayed(this.aHH, 3000L);
            }
        }
    }

    private boolean JZ() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("stranger_tips", true);
    }

    private void cC(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("stranger_tips", z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZG = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aHH);
            this.mHandler.removeCallbacks(this.aPG);
            this.mHandler.removeCallbacks(this.aPF);
        }
        com.baidu.adp.lib.d.a.dE().a(this.locationCallBack);
    }
}
