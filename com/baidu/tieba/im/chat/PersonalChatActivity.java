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
    public static String ZK;
    public static boolean aOq;
    private static CustomMessageListener aPO = new cv(2005016);
    private static com.baidu.tieba.im.chat.personaltalk.b aPS;
    private com.baidu.tbadk.coreExtra.relationship.f aPQ;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private com.baidu.adp.lib.guide.d aHP = null;
    private long aPP = 0;
    private String aPR = TbadkApplication.getCurrentAccount();
    private Runnable aPT = new dd(this);
    private Runnable aPU = new de(this);
    private Runnable aHR = new df(this);
    private com.baidu.adp.framework.listener.e aPV = new dg(this, 205101, true);
    private com.baidu.adp.lib.d.d locationCallBack = new dh(this);

    static {
        MessageManager.getInstance().registerListener(aPO);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new da());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ZK = "";
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
    public void Ju() {
        UserData user;
        super.Ju();
        if ((this.aQe instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.aQe).getUser()) != null) {
            com.baidu.tieba.im.e.a(new di(this, user), new dj(this));
        }
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
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().cr(ZK);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZK, 2)));
        if (this.aQe != null && (this.aQe instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.aQe).sendHasReadReceiveOther();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.e.a(new cw(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void nu() {
        UserData user;
        this.aQd = new PersonalChatView(this, this.aQe.getIsAcceptNotify());
        this.aQd.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = w.aNT;
        if ((this.aQe instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.aQe).getUser()) != null) {
            this.mUser = user;
            this.aQd.refreshPersonalHeadFooter(this.mUser.getUserName(), this.aPQ);
            this.aQd.bindDataAndRefresh(this.aQe.getData(), i);
            this.aQd.setRecordCallback(new cx(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.aQd.getBtnGroupInfo()) {
            com.baidu.tbadk.core.j.l(this, "personal_chat_page_morebutton");
            if ((this.aQe instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.aQe).getUser()) != null) {
                PersonalTalkSettingActivity.L(user.getUserIdLong());
            }
        }
    }

    public void Kb() {
        if (TbadkApplication.m251getInst().getLocationShared()) {
            String str = String.valueOf(this.aPR) + "&" + this.mUser.getUserId();
            if (!aPS.fE(str)) {
                com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.f fF = aPS.fF(str);
            this.aQd.refreshPersonalHeadFooter(this.mUser.getUserName(), fF);
            this.aPP = fA(com.baidu.tbadk.core.util.az.i(fF.getTime()));
            if (this.aPP != 0) {
                this.mHandler.postDelayed(this.aPT, this.aPP);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean h(Bundle bundle) {
        try {
            registerListener(this.aPV);
            if (aPS == null) {
                aPS = new com.baidu.tieba.im.chat.personaltalk.b();
            }
            this.aQe = new PersonalMsglistModel(this);
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aQe.loadFirst(btVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String v;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.aQe.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (Kj() && (msg = this.aQe.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (v = com.baidu.tieba.im.util.i.v(msg.getContent(), true)) != null && (this.aQe instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.aQe).getUser() != null) {
                    PersonalMsgImageActivity.a(this, v, ((CommonPersonalMsglistModel) this.aQe).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void g(Bundle bundle) {
        super.g(bundle);
        JA();
        ((PersonalMsglistModel) this.aQe).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void i(Intent intent) {
        super.i(intent);
        JA();
        ((PersonalMsglistModel) this.aQe).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
    }

    private void JA() {
        if (this.aQe == null || !(this.aQe instanceof PersonalMsglistModel)) {
            ZK = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.aQe).getUser();
        if (user != null) {
            ZK = String.valueOf(user.getUserId());
        } else {
            ZK = "";
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Jy() {
        super.Jy();
        Kc();
        this.handler.postDelayed(new cy(this), 60L);
        Kb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jz() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.aQe.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!com.baidu.adp.lib.util.l.aA(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.aQe.sendTextMessage(stringExtra2);
            }
        }
    }

    private void Kc() {
        boolean Kd = Kd();
        int isFriend = ((PersonalMsglistModel) this.aQe).getIsFriend();
        if (Kd && isFriend == 0) {
            this.mHandler.postDelayed(this.aPU, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq() {
        View view;
        if (this.aQd != null && this.aQd.getMsgListView() != null) {
            int firstVisiblePosition = this.aQd.getMsgListView().getFirstVisiblePosition();
            int lastVisiblePosition = this.aQd.getMsgListView().getLastVisiblePosition();
            cs adapter = this.aQd.getAdapter();
            int i = lastVisiblePosition;
            while (true) {
                if (i < firstVisiblePosition) {
                    view = null;
                    break;
                } else if (com.baidu.tieba.im.util.i.s((ChatMessage) adapter.getItem(i)) || this.aQd.getMsgListView().getChildAt(i - firstVisiblePosition) == null) {
                    i--;
                } else {
                    view = this.aQd.getMsgListView().getChildAt(i - firstVisiblePosition).findViewById(com.baidu.tieba.v.img_msgitem_photo);
                    break;
                }
            }
            if (view != null) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.b(view).A(0).r(false);
                gVar.a(new cz(this));
                this.aHP = gVar.dA();
                this.aHP.c(this);
                cC(false);
                this.mHandler.postDelayed(this.aHR, 3000L);
            }
        }
    }

    private boolean Kd() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("stranger_tips", true);
    }

    private void cC(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("stranger_tips", z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZK = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aHR);
            this.mHandler.removeCallbacks(this.aPU);
            this.mHandler.removeCallbacks(this.aPT);
        }
        com.baidu.adp.lib.d.a.dE().a(this.locationCallBack);
    }
}
