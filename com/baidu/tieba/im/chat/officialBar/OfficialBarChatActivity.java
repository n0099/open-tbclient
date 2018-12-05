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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
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
    private OfficialBarMsglistView eJP;
    private OfficialBarMsglistModel eJQ;
    private boolean eJR;
    private final com.baidu.adp.framework.listener.c eJS = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eJP.ii(false);
            if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
            if (responseOfficialBarMenuMessage.hasError()) {
                if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(e.j.neterror) : responseOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(e.j.neterror);
                }
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.eJQ.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aQk() == null || officialBarMenuDatas.aQk().size() == 0) {
                    OfficialBarChatActivity.this.eJP.J(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aQj()) {
                    OfficialBarChatActivity.this.eJP.J(false, false);
                    if (officialBarMenuDatas2.aQk() != null && officialBarMenuDatas2.aQk().size() > 0) {
                        OfficialBarChatActivity.this.eJQ.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.eJP.cv(officialBarMenuDatas2.aQk());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.eJP.J(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eJT = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eJP.ii(false);
            if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
            if (responseSendOfficialBarMenuMessage.hasError()) {
                if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(e.j.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(e.j.neterror);
                }
            }
        }
    };
    private final CustomMessageListener eJU = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.eJP.J(false, false);
                OfficialBarChatActivity.this.eJQ.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.eJQ.sendGetMenuNetMessage(OfficialBarChatActivity.this.eJQ.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.eJP.cv(officialBarMenuDatas.aQk());
                return;
            }
            OfficialBarChatActivity.this.eJP.J(true, false);
            OfficialBarChatActivity.this.eJQ.sendGetMenuNetMessage(OfficialBarChatActivity.this.eJQ.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.eJP.ii(true);
            this.eJQ.sendGetMenuLocalMessage(this.eJQ.getForumId());
        }
        com.baidu.tieba.im.b.a.aUn().aUp();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean v(Bundle bundle) {
        try {
            this.eIR = new OfficialBarMsglistModel(this);
            this.eIR.setLoadDataCallBack(this.eJb);
            this.eJQ = (OfficialBarMsglistModel) this.eIR;
            if (bundle != null) {
                w(bundle);
            } else {
                aNI();
            }
            this.eJQ.setUserType(this.mUserType);
            if (!aNJ()) {
                return false;
            }
            this.eJR = true;
            registerListener(this.eJS);
            registerListener(this.eJT);
            registerListener(this.eJU);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.eIQ = new OfficialBarMsglistView(this, this.eIR.getIsAcceptNotify());
        this.eJP = (OfficialBarMsglistView) this.eIQ;
        if (this.mUserType == 4) {
            this.eJP.pE(e.j.more);
            this.eJP.closeNotNotify();
            this.eJP.closeReceiver();
            this.eJP.aOE();
        }
        if (this.mUserType == 3) {
            this.eJP.aOE();
        }
        this.eIQ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.eYu.longValue();
        if ((this.eIR instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eIR).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.eIQ.refreshHeaderFooter(str, false);
            } else {
                this.eIQ.refreshHeaderFooter(str + getPageContext().getString(e.j.forum), false);
            }
            this.eIQ.bindDataAndRefresh(this.eIR.getData(), longValue);
            this.eIQ.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.eIR.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aNG() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.eIR.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.HP().eT(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (bd(this.eJP.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aOC = this.eJP.aOC();
            if (aOC.isShown() && !bd(aOC).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.eJP.aOD()[i];
                    if (aVar.eKt) {
                        this.eJP.aOC().axu();
                        aVar.eKt = false;
                        this.eJP.w(i, aVar.eKt);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect bd(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        x.b(new w<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Ww */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aUk().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aNH() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aNH();
            if ((this.eIR instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.eIR).getUser()) != null) {
                x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aUk().bS(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.eIQ.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.eIQ.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aQk;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.eIQ.getBtnGroupInfo()) {
            if ((this.eIR instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eIR).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.eJP.aOD()[0].eKu || view == this.eJP.aOD()[1].eKu || view == this.eJP.aOD()[2].eKu) {
            TiebaStatic.log("service_bt_ck");
            int be = this.eJP.be(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.eJP.aOD()[i];
                if (aVar.eKt && i != be) {
                    this.eJP.aOC().aUC();
                    aVar.eKt = false;
                    this.eJP.w(i, aVar.eKt);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.eJQ.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aQk = officialBarMenuDatas.aQk()) != null && be < aQk.size() && (bVar = aQk.get(be)) != null) {
                if (bVar.aQh() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.eJP.aOD()[be];
                    OfficialSecondMenuPopupWindow aOC = this.eJP.aOC();
                    if (aVar2.eKt) {
                        aOC.axu();
                    } else {
                        aOC.setData(3, be, bVar.aQi());
                        aOC.aK(view);
                    }
                    aVar2.eKt = !aVar2.eKt;
                    this.eJP.w(be, aVar2.eKt);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String P;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.eIR.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aOt() && (msg = this.eIR.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (P = com.baidu.tieba.im.util.e.P(msg.getContent(), true)) != null && (this.eIR instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.eIR).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), P, ((CommonPersonalMsglistModel) this.eIR).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aQh() == 2) {
            this.eJP.ii(true);
            this.eJQ.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.eJQ.getForumId());
        } else if (bVar.aQh() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.eJP.aOC().axu();
            OfficialBarMsglistView.a aVar = this.eJP.aOD()[i];
            aVar.eKt = false;
            this.eJP.w(i, aVar.eKt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void x(Bundle bundle) {
        super.x(bundle);
        aNO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Q(Intent intent) {
        super.Q(intent);
        aNO();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aUn().aUo();
        com.baidu.tieba.im.b.a.aUn().aUp();
    }

    private void aNO() {
        if (this.eIR == null || !(this.eIR instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.eIR).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ar(Context context, String str) {
    }
}
