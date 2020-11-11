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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
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
/* loaded from: classes26.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private OfficialBarMsglistView jXL;
    private OfficialBarMsglistModel jXM;
    private boolean jXN;
    private final com.baidu.adp.framework.listener.c jXO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.jXL.rA(false);
            if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
            if (responseOfficialBarMenuMessage.hasError()) {
                if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(R.string.neterror) : responseOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(R.string.neterror);
                }
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.jXM.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.cQP() == null || officialBarMenuDatas.cQP().size() == 0) {
                    OfficialBarChatActivity.this.jXL.ai(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.cQO()) {
                    OfficialBarChatActivity.this.jXL.ai(false, false);
                    if (officialBarMenuDatas2.cQP() != null && officialBarMenuDatas2.cQP().size() > 0) {
                        OfficialBarChatActivity.this.jXM.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.jXL.dZ(officialBarMenuDatas2.cQP());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.jXL.ai(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jXP = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.jXL.rA(false);
            if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
            if (responseSendOfficialBarMenuMessage.hasError()) {
                if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(R.string.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private final CustomMessageListener jXQ = new CustomMessageListener(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.jXL.ai(false, false);
                OfficialBarChatActivity.this.jXM.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.jXM.sendGetMenuNetMessage(OfficialBarChatActivity.this.jXM.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.jXL.dZ(officialBarMenuDatas.cQP());
                return;
            }
            OfficialBarChatActivity.this.jXL.ai(true, false);
            OfficialBarChatActivity.this.jXM.sendGetMenuNetMessage(OfficialBarChatActivity.this.jXM.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.jXL.rA(true);
            this.jXM.sendGetMenuLocalMessage(this.jXM.getForumId());
        }
        com.baidu.tieba.im.b.a.cVj().cVl();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean at(Bundle bundle) {
        try {
            this.jWF = new OfficialBarMsglistModel(this);
            this.jWF.setLoadDataCallBack(this.jWP);
            this.jXM = (OfficialBarMsglistModel) this.jWF;
            if (bundle != null) {
                au(bundle);
            } else {
                cOk();
            }
            this.jXM.setUserType(this.mUserType);
            if (!cOl()) {
                return false;
            }
            this.jXN = true;
            registerListener(this.jXO);
            registerListener(this.jXP);
            registerListener(this.jXQ);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.jWE = new OfficialBarMsglistView(this, this.jWF.getIsAcceptNotify());
        this.jXL = (OfficialBarMsglistView) this.jWE;
        if (this.mUserType == 4) {
            this.jXL.CA(R.string.more);
            this.jXL.closeNotNotify();
            this.jXL.closeReceiver();
            this.jXL.cPi();
        }
        if (this.mUserType == 3) {
            this.jXL.cPi();
        }
        this.jWE.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.kox.longValue();
        if ((this.jWF instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.jWF).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.jWE.refreshHeaderFooter(str, false);
            } else {
                this.jWE.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.jWE.bindDataAndRefresh(this.jWF.getData(), longValue);
            this.jWE.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.jWF.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cOi() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.jWF.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qG(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (cS(this.jXL.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow cPg = this.jXL.cPg();
            if (cPg.isShown() && !cS(cPg).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.jXL.cPh()[i];
                    if (aVar.bss) {
                        this.jXL.cPg().Um();
                        aVar.bss = false;
                        this.jXL.aa(i, aVar.bss);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect cS(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJS */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cVg().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void cOj() {
        final UserData user;
        if (this.mUserType != 4) {
            super.cOj();
            if ((this.jWF instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.jWF).getUser()) != null) {
                ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ad
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.cVg().ft(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new m<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.jWE.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.jWE.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> cQP;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.jWE.getBtnGroupInfo()) {
            if ((this.jWF instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.jWF).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.jXL.cPh()[0].jYI || view == this.jXL.cPh()[1].jYI || view == this.jXL.cPh()[2].jYI) {
            TiebaStatic.log("service_bt_ck");
            int cT = this.jXL.cT(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.jXL.cPh()[i];
                if (aVar.bss && i != cT) {
                    this.jXL.cPg().cVy();
                    aVar.bss = false;
                    this.jXL.aa(i, aVar.bss);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.jXM.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (cQP = officialBarMenuDatas.cQP()) != null && cT < cQP.size() && (bVar = cQP.get(cT)) != null) {
                if (bVar.cQM() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.jXL.cPh()[cT];
                    OfficialSecondMenuPopupWindow cPg = this.jXL.cPg();
                    if (aVar2.bss) {
                        cPg.Um();
                    } else {
                        cPg.setData(3, cT, bVar.cQN());
                        cPg.O(view);
                    }
                    aVar2.bss = !aVar2.bss;
                    this.jXL.aa(cT, aVar2.bss);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String aR;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.jWF.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (cOV() && (msg = this.jWF.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (aR = com.baidu.tieba.im.util.e.aR(msg.getContent(), true)) != null && (this.jWF instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.jWF).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), aR, ((CommonPersonalMsglistModel) this.jWF).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.cQM() == 2) {
            this.jXL.rA(true);
            this.jXM.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.jXM.getForumId());
        } else if (bVar.cQM() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.jXL.cPg().Um();
            OfficialBarMsglistView.a aVar = this.jXL.cPh()[i];
            aVar.bss = false;
            this.jXL.aa(i, aVar.bss);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void av(Bundle bundle) {
        super.av(bundle);
        cOq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void W(Intent intent) {
        super.W(intent);
        cOq();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.cVj().cVk();
        com.baidu.tieba.im.b.a.cVj().cVl();
    }

    private void cOq() {
        if (this.jWF == null || !(this.jWF instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.jWF).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.i
    public void aB(Context context, String str) {
    }
}
