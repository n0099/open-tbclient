package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import com.baidu.tieba.im.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements a.b {
    private OfficialBarMsglistView exD;
    private OfficialBarMsglistModel exE;
    private boolean exF;
    private final com.baidu.adp.framework.listener.c exG = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.exD.hh(false);
            if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
            if (responseOfficialBarMenuMessage.hasError()) {
                if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.j.neterror) : responseOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.j.neterror);
                }
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.exE.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aHT() == null || officialBarMenuDatas.aHT().size() == 0) {
                    OfficialBarChatActivity.this.exD.F(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aHS()) {
                    OfficialBarChatActivity.this.exD.F(false, false);
                    if (officialBarMenuDatas2.aHT() != null && officialBarMenuDatas2.aHT().size() > 0) {
                        OfficialBarChatActivity.this.exE.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.exD.bY(officialBarMenuDatas2.aHT());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.exD.F(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c exH = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.exD.hh(false);
            if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
            if (responseSendOfficialBarMenuMessage.hasError()) {
                if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.j.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.j.neterror);
                }
            }
        }
    };
    private final CustomMessageListener exI = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.exD.F(false, false);
                OfficialBarChatActivity.this.exE.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.exE.sendGetMenuNetMessage(OfficialBarChatActivity.this.exE.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.exD.bY(officialBarMenuDatas.aHT());
                return;
            }
            OfficialBarChatActivity.this.exD.F(true, false);
            OfficialBarChatActivity.this.exE.sendGetMenuNetMessage(OfficialBarChatActivity.this.exE.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.exD.hh(true);
            this.exE.sendGetMenuLocalMessage(this.exE.getForumId());
        }
        com.baidu.tieba.im.b.a.aLY().aMa();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean q(Bundle bundle) {
        try {
            this.ewF = new OfficialBarMsglistModel(this);
            this.ewF.setLoadDataCallBack(this.ewP);
            this.exE = (OfficialBarMsglistModel) this.ewF;
            if (bundle != null) {
                r(bundle);
            } else {
                aFn();
            }
            this.exE.setUserType(this.mUserType);
            if (!aFo()) {
                return false;
            }
            this.exF = true;
            registerListener(this.exG);
            registerListener(this.exH);
            registerListener(this.exI);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.ewE = new OfficialBarMsglistView(this, this.ewF.getIsAcceptNotify());
        this.exD = (OfficialBarMsglistView) this.ewE;
        if (this.mUserType == 4) {
            this.exD.pK(d.j.more);
            this.exD.closeNotNotify();
            this.exD.closeReceiver();
            this.exD.aGl();
        }
        if (this.mUserType == 3) {
            this.exD.aGl();
        }
        this.ewE.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.sendmessage.a.eMr;
        if ((this.ewF instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.ewF).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.ewE.refreshHeaderFooter(str, false);
            } else {
                this.ewE.refreshHeaderFooter(str + getPageContext().getString(d.j.forum), false);
            }
            this.ewE.bindDataAndRefresh(this.ewF.getData(), i);
            this.ewE.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.ewF.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aFl() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.ewF.loadFirst(dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(1, true);
        String curId = ChatStatusManager.getInst().getCurId(1);
        if (!TextUtils.isEmpty(curId)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().gS(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (ca(this.exD.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.a aGj = this.exD.aGj();
            if (aGj.isShown() && !ca(aGj).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.exD.aGk()[i];
                    if (aVar.eyk) {
                        this.exD.aGj().asJ();
                        aVar.eyk = false;
                        this.exD.K(i, aVar.eyk);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect ca(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: UO */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aLV().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aFm() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aFm();
            if ((this.ewF instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.ewF).getUser()) != null) {
                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.u
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aLV().bk(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.ewE.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.ewE.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aHT;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.ewE.getBtnGroupInfo()) {
            if ((this.ewF instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.ewF).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.exD.aGk()[0].eyl || view == this.exD.aGk()[1].eyl || view == this.exD.aGk()[2].eyl) {
            TiebaStatic.log("service_bt_ck");
            int cb = this.exD.cb(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.exD.aGk()[i];
                if (aVar.eyk && i != cb) {
                    this.exD.aGj().aMn();
                    aVar.eyk = false;
                    this.exD.K(i, aVar.eyk);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.exE.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aHT = officialBarMenuDatas.aHT()) != null && cb < aHT.size() && (bVar = aHT.get(cb)) != null) {
                if (bVar.aHQ() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.exD.aGk()[cb];
                    com.baidu.tieba.im.view.a aGj = this.exD.aGj();
                    if (aVar2.eyk) {
                        aGj.asJ();
                    } else {
                        aGj.a(3, cb, bVar.aHR());
                        aGj.bK(view);
                    }
                    aVar2.eyk = !aVar2.eyk;
                    this.exD.K(cb, aVar2.eyk);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String I;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.ewF.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aFY() && (msg = this.ewF.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (I = com.baidu.tieba.im.util.e.I(msg.getContent(), true)) != null && (this.ewF instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.ewF).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), I, ((CommonPersonalMsglistModel) this.ewF).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aHQ() == 2) {
            this.exD.hh(true);
            this.exE.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.exE.getForumId());
        } else if (bVar.aHQ() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.a.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.exD.aGj().asJ();
            OfficialBarMsglistView.a aVar = this.exD.aGk()[i];
            aVar.eyk = false;
            this.exD.K(i, aVar.eyk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void s(Bundle bundle) {
        super.s(bundle);
        aFt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void N(Intent intent) {
        super.N(intent);
        aFt();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aLY().aLZ();
        com.baidu.tieba.im.b.a.aLY().aMa();
    }

    private void aFt() {
        if (this.ewF == null || !(this.ewF instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.ewF).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
    }
}
