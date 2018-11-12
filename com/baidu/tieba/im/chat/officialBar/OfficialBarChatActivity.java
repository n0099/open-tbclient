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
    private OfficialBarMsglistView eDa;
    private OfficialBarMsglistModel eDb;
    private boolean eDc;
    private final com.baidu.adp.framework.listener.c eDd = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eDa.m19if(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.eDb.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aOs() == null || officialBarMenuDatas.aOs().size() == 0) {
                    OfficialBarChatActivity.this.eDa.J(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aOr()) {
                    OfficialBarChatActivity.this.eDa.J(false, false);
                    if (officialBarMenuDatas2.aOs() != null && officialBarMenuDatas2.aOs().size() > 0) {
                        OfficialBarChatActivity.this.eDb.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.eDa.cr(officialBarMenuDatas2.aOs());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.eDa.J(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eDe = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eDa.m19if(false);
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
    private final CustomMessageListener eDf = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.eDa.J(false, false);
                OfficialBarChatActivity.this.eDb.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.eDb.sendGetMenuNetMessage(OfficialBarChatActivity.this.eDb.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.eDa.cr(officialBarMenuDatas.aOs());
                return;
            }
            OfficialBarChatActivity.this.eDa.J(true, false);
            OfficialBarChatActivity.this.eDb.sendGetMenuNetMessage(OfficialBarChatActivity.this.eDb.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.eDa.m19if(true);
            this.eDb.sendGetMenuLocalMessage(this.eDb.getForumId());
        }
        com.baidu.tieba.im.b.a.aSv().aSx();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean s(Bundle bundle) {
        try {
            this.eCc = new OfficialBarMsglistModel(this);
            this.eCc.setLoadDataCallBack(this.eCm);
            this.eDb = (OfficialBarMsglistModel) this.eCc;
            if (bundle != null) {
                t(bundle);
            } else {
                aLQ();
            }
            this.eDb.setUserType(this.mUserType);
            if (!aLR()) {
                return false;
            }
            this.eDc = true;
            registerListener(this.eDd);
            registerListener(this.eDe);
            registerListener(this.eDf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.eCb = new OfficialBarMsglistView(this, this.eCc.getIsAcceptNotify());
        this.eDa = (OfficialBarMsglistView) this.eCb;
        if (this.mUserType == 4) {
            this.eDa.pj(e.j.more);
            this.eDa.closeNotNotify();
            this.eDa.closeReceiver();
            this.eDa.aMM();
        }
        if (this.mUserType == 3) {
            this.eDa.aMM();
        }
        this.eCb.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.eRF.longValue();
        if ((this.eCc instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eCc).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.eCb.refreshHeaderFooter(str, false);
            } else {
                this.eCb.refreshHeaderFooter(str + getPageContext().getString(e.j.forum), false);
            }
            this.eCb.bindDataAndRefresh(this.eCc.getData(), longValue);
            this.eCb.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.eCc.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aLO() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.eCc.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().eF(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (bd(this.eDa.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aMK = this.eDa.aMK();
            if (aMK.isShown() && !bd(aMK).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.eDa.aML()[i];
                    if (aVar.eDE) {
                        this.eDa.aMK().avJ();
                        aVar.eDE = false;
                        this.eDa.w(i, aVar.eDE);
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
            /* renamed from: Vq */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aSs().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aLP() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aLP();
            if ((this.eCc instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.eCc).getUser()) != null) {
                x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aSs().bN(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.eCb.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.eCb.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aOs;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.eCb.getBtnGroupInfo()) {
            if ((this.eCc instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eCc).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.eDa.aML()[0].eDF || view == this.eDa.aML()[1].eDF || view == this.eDa.aML()[2].eDF) {
            TiebaStatic.log("service_bt_ck");
            int be = this.eDa.be(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.eDa.aML()[i];
                if (aVar.eDE && i != be) {
                    this.eDa.aMK().aSK();
                    aVar.eDE = false;
                    this.eDa.w(i, aVar.eDE);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.eDb.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aOs = officialBarMenuDatas.aOs()) != null && be < aOs.size() && (bVar = aOs.get(be)) != null) {
                if (bVar.aOp() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.eDa.aML()[be];
                    OfficialSecondMenuPopupWindow aMK = this.eDa.aMK();
                    if (aVar2.eDE) {
                        aMK.avJ();
                    } else {
                        aMK.setData(3, be, bVar.aOq());
                        aMK.aK(view);
                    }
                    aVar2.eDE = !aVar2.eDE;
                    this.eDa.w(be, aVar2.eDE);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String N;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.eCc.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aMB() && (msg = this.eCc.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (N = com.baidu.tieba.im.util.e.N(msg.getContent(), true)) != null && (this.eCc instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.eCc).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), N, ((CommonPersonalMsglistModel) this.eCc).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aOp() == 2) {
            this.eDa.m19if(true);
            this.eDb.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.eDb.getForumId());
        } else if (bVar.aOp() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.eDa.aMK().avJ();
            OfficialBarMsglistView.a aVar = this.eDa.aML()[i];
            aVar.eDE = false;
            this.eDa.w(i, aVar.eDE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void u(Bundle bundle) {
        super.u(bundle);
        aLW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Q(Intent intent) {
        super.Q(intent);
        aLW();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aSv().aSw();
        com.baidu.tieba.im.b.a.aSv().aSx();
    }

    private void aLW() {
        if (this.eCc == null || !(this.eCc instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.eCc).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }
}
