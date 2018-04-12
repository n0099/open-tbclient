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
import com.baidu.tbadk.util.h;
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
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private boolean dSA;
    private final com.baidu.adp.framework.listener.c dSB = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.dSy.gM(false);
            if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
            if (responseOfficialBarMenuMessage.hasError()) {
                if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.k.neterror) : responseOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.k.neterror);
                }
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.dSz.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aCT() == null || officialBarMenuDatas.aCT().size() == 0) {
                    OfficialBarChatActivity.this.dSy.B(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aCS()) {
                    OfficialBarChatActivity.this.dSy.B(false, false);
                    if (officialBarMenuDatas2.aCT() != null && officialBarMenuDatas2.aCT().size() > 0) {
                        OfficialBarChatActivity.this.dSz.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.dSy.bR(officialBarMenuDatas2.aCT());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.dSy.B(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dSC = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.dSy.gM(false);
            if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
            if (responseSendOfficialBarMenuMessage.hasError()) {
                if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.k.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.k.neterror);
                }
            }
        }
    };
    private final CustomMessageListener dSD = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(d.k.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.dSy.B(false, false);
                OfficialBarChatActivity.this.dSz.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.dSz.sendGetMenuNetMessage(OfficialBarChatActivity.this.dSz.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.dSy.bR(officialBarMenuDatas.aCT());
                return;
            }
            OfficialBarChatActivity.this.dSy.B(true, false);
            OfficialBarChatActivity.this.dSz.sendGetMenuNetMessage(OfficialBarChatActivity.this.dSz.getForumId(), 0L);
        }
    };
    private OfficialBarMsglistView dSy;
    private OfficialBarMsglistModel dSz;
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.dSy.gM(true);
            this.dSz.sendGetMenuLocalMessage(this.dSz.getForumId());
        }
        com.baidu.tieba.im.b.a.aGZ().aHb();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean n(Bundle bundle) {
        try {
            this.dRB = new OfficialBarMsglistModel(this);
            this.dRB.setLoadDataCallBack(this.dRL);
            this.dSz = (OfficialBarMsglistModel) this.dRB;
            if (bundle != null) {
                o(bundle);
            } else {
                aAo();
            }
            this.dSz.setUserType(this.mUserType);
            if (!aAp()) {
                return false;
            }
            this.dSA = true;
            registerListener(this.dSB);
            registerListener(this.dSC);
            registerListener(this.dSD);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.dRA = new OfficialBarMsglistView(this, this.dRB.getIsAcceptNotify());
        this.dSy = (OfficialBarMsglistView) this.dRA;
        if (this.mUserType == 4) {
            this.dSy.nk(d.k.more);
            this.dSy.closeNotNotify();
            this.dSy.closeReceiver();
            this.dSy.aBm();
        }
        if (this.mUserType == 3) {
            this.dSy.aBm();
        }
        this.dRA.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.ehn.longValue();
        if ((this.dRB instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.dRB).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.dRA.refreshHeaderFooter(str, false);
            } else {
                this.dRA.refreshHeaderFooter(str + getPageContext().getString(d.k.forum), false);
            }
            this.dRA.bindDataAndRefresh(this.dRB.getData(), longValue);
            this.dRA.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.dRB.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aAm() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.dRB.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().dR(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (aG(this.dSy.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aBk = this.dSy.aBk();
            if (aBk.isShown() && !aG(aBk).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.dSy.aBl()[i];
                    if (aVar.dTe) {
                        this.dSy.aBk().ana();
                        aVar.dTe = false;
                        this.dSy.w(i, aVar.dTe);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect aG(View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Nq */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aGW().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aAn() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aAn();
            if ((this.dRB instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.dRB).getUser()) != null) {
                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.u
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aGW().bk(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.dRA.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.dRA.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        List<com.baidu.tieba.im.data.b> aCT;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view2);
        if (view2 == this.dRA.getBtnGroupInfo()) {
            if ((this.dRB instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.dRB).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view2 == this.dSy.aBl()[0].dTf || view2 == this.dSy.aBl()[1].dTf || view2 == this.dSy.aBl()[2].dTf) {
            TiebaStatic.log("service_bt_ck");
            int aH = this.dSy.aH(view2);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.dSy.aBl()[i];
                if (aVar.dTe && i != aH) {
                    this.dSy.aBk().aHo();
                    aVar.dTe = false;
                    this.dSy.w(i, aVar.dTe);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.dSz.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aCT = officialBarMenuDatas.aCT()) != null && aH < aCT.size() && (bVar = aCT.get(aH)) != null) {
                if (bVar.aCQ() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.dSy.aBl()[aH];
                    OfficialSecondMenuPopupWindow aBk = this.dSy.aBk();
                    if (aVar2.dTe) {
                        aBk.ana();
                    } else {
                        aBk.setData(3, aH, bVar.aCR());
                        aBk.ap(view2);
                    }
                    aVar2.dTe = !aVar2.dTe;
                    this.dSy.w(aH, aVar2.dTe);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view2, int i, int i2, long j) {
        ChatMessage msg;
        String F;
        ChatMessage msg2;
        super.a(view2, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.dRB.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aAZ() && (msg = this.dRB.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (F = com.baidu.tieba.im.util.e.F(msg.getContent(), true)) != null && (this.dRB instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.dRB).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), F, ((CommonPersonalMsglistModel) this.dRB).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aCQ() == 2) {
            this.dSy.gM(true);
            this.dSz.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.dSz.getForumId());
        } else if (bVar.aCQ() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.dSy.aBk().ana();
            OfficialBarMsglistView.a aVar = this.dSy.aBl()[i];
            aVar.dTe = false;
            this.dSy.w(i, aVar.dTe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void p(Bundle bundle) {
        super.p(bundle);
        aAu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void M(Intent intent) {
        super.M(intent);
        aAu();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aGZ().aHa();
        com.baidu.tieba.im.b.a.aGZ().aHb();
    }

    private void aAu() {
        if (this.dRB == null || !(this.dRB instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.dRB).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }
}
