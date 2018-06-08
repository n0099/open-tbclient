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
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
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
    private OfficialBarMsglistView eeP;
    private OfficialBarMsglistModel eeQ;
    private boolean eeR;
    private final com.baidu.adp.framework.listener.c eeS = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eeP.gT(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.eeQ.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aHM() == null || officialBarMenuDatas.aHM().size() == 0) {
                    OfficialBarChatActivity.this.eeP.B(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aHL()) {
                    OfficialBarChatActivity.this.eeP.B(false, false);
                    if (officialBarMenuDatas2.aHM() != null && officialBarMenuDatas2.aHM().size() > 0) {
                        OfficialBarChatActivity.this.eeQ.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.eeP.bZ(officialBarMenuDatas2.aHM());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.eeP.B(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eeT = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eeP.gT(false);
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
    private final CustomMessageListener eeU = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(d.k.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.eeP.B(false, false);
                OfficialBarChatActivity.this.eeQ.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.eeQ.sendGetMenuNetMessage(OfficialBarChatActivity.this.eeQ.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.eeP.bZ(officialBarMenuDatas.aHM());
                return;
            }
            OfficialBarChatActivity.this.eeP.B(true, false);
            OfficialBarChatActivity.this.eeQ.sendGetMenuNetMessage(OfficialBarChatActivity.this.eeQ.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.eeP.gT(true);
            this.eeQ.sendGetMenuLocalMessage(this.eeQ.getForumId());
        }
        com.baidu.tieba.im.b.a.aLS().aLU();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean o(Bundle bundle) {
        try {
            this.edS = new OfficialBarMsglistModel(this);
            this.edS.setLoadDataCallBack(this.eec);
            this.eeQ = (OfficialBarMsglistModel) this.edS;
            if (bundle != null) {
                p(bundle);
            } else {
                aFh();
            }
            this.eeQ.setUserType(this.mUserType);
            if (!aFi()) {
                return false;
            }
            this.eeR = true;
            registerListener(this.eeS);
            registerListener(this.eeT);
            registerListener(this.eeU);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.edR = new OfficialBarMsglistView(this, this.edS.getIsAcceptNotify());
        this.eeP = (OfficialBarMsglistView) this.edR;
        if (this.mUserType == 4) {
            this.eeP.nu(d.k.more);
            this.eeP.closeNotNotify();
            this.eeP.closeReceiver();
            this.eeP.aGf();
        }
        if (this.mUserType == 3) {
            this.eeP.aGf();
        }
        this.edR.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.etI.longValue();
        if ((this.edS instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.edS).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.edR.refreshHeaderFooter(str, false);
            } else {
                this.edR.refreshHeaderFooter(str + getPageContext().getString(d.k.forum), false);
            }
            this.edR.bindDataAndRefresh(this.edS.getData(), longValue);
            this.edR.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.edS.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aFf() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.edS.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().dT(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (aJ(this.eeP.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aGd = this.eeP.aGd();
            if (aGd.isShown() && !aJ(aGd).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.eeP.aGe()[i];
                    if (aVar.efv) {
                        this.eeP.aGd().arf();
                        aVar.efv = false;
                        this.eeP.w(i, aVar.efv);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect aJ(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        w.b(new v<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: QO */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aLP().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aFg() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aFg();
            if ((this.edS instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.edS).getUser()) != null) {
                w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.v
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aLP().br(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.edR.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.edR.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aHM;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.edR.getBtnGroupInfo()) {
            if ((this.edS instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.edS).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.eeP.aGe()[0].efw || view == this.eeP.aGe()[1].efw || view == this.eeP.aGe()[2].efw) {
            TiebaStatic.log("service_bt_ck");
            int aK = this.eeP.aK(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.eeP.aGe()[i];
                if (aVar.efv && i != aK) {
                    this.eeP.aGd().aMh();
                    aVar.efv = false;
                    this.eeP.w(i, aVar.efv);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.eeQ.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aHM = officialBarMenuDatas.aHM()) != null && aK < aHM.size() && (bVar = aHM.get(aK)) != null) {
                if (bVar.aHJ() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.eeP.aGe()[aK];
                    OfficialSecondMenuPopupWindow aGd = this.eeP.aGd();
                    if (aVar2.efv) {
                        aGd.arf();
                    } else {
                        aGd.setData(3, aK, bVar.aHK());
                        aGd.ap(view);
                    }
                    aVar2.efv = !aVar2.efv;
                    this.eeP.w(aK, aVar2.efv);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String F;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.edS.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aFS() && (msg = this.edS.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (F = com.baidu.tieba.im.util.e.F(msg.getContent(), true)) != null && (this.edS instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.edS).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), F, ((CommonPersonalMsglistModel) this.edS).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aHJ() == 2) {
            this.eeP.gT(true);
            this.eeQ.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.eeQ.getForumId());
        } else if (bVar.aHJ() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.eeP.aGd().arf();
            OfficialBarMsglistView.a aVar = this.eeP.aGe()[i];
            aVar.efv = false;
            this.eeP.w(i, aVar.efv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void q(Bundle bundle) {
        super.q(bundle);
        aFn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void M(Intent intent) {
        super.M(intent);
        aFn();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aLS().aLT();
        com.baidu.tieba.im.b.a.aLS().aLU();
    }

    private void aFn() {
        if (this.edS == null || !(this.edS instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.edS).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }
}
