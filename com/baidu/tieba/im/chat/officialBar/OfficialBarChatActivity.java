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
/* loaded from: classes25.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private OfficialBarMsglistView jqs;
    private OfficialBarMsglistModel jqt;
    private boolean jqu;
    private final com.baidu.adp.framework.listener.c jqv = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.jqs.qt(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.jqt.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.cHy() == null || officialBarMenuDatas.cHy().size() == 0) {
                    OfficialBarChatActivity.this.jqs.ag(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.cHx()) {
                    OfficialBarChatActivity.this.jqs.ag(false, false);
                    if (officialBarMenuDatas2.cHy() != null && officialBarMenuDatas2.cHy().size() > 0) {
                        OfficialBarChatActivity.this.jqt.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.jqs.dF(officialBarMenuDatas2.cHy());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.jqs.ag(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jqw = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.jqs.qt(false);
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
    private final CustomMessageListener jqx = new CustomMessageListener(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.jqs.ag(false, false);
                OfficialBarChatActivity.this.jqt.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.jqt.sendGetMenuNetMessage(OfficialBarChatActivity.this.jqt.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.jqs.dF(officialBarMenuDatas.cHy());
                return;
            }
            OfficialBarChatActivity.this.jqs.ag(true, false);
            OfficialBarChatActivity.this.jqt.sendGetMenuNetMessage(OfficialBarChatActivity.this.jqt.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.jqs.qt(true);
            this.jqt.sendGetMenuLocalMessage(this.jqt.getForumId());
        }
        com.baidu.tieba.im.b.a.cLT().cLV();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean at(Bundle bundle) {
        try {
            this.jpm = new OfficialBarMsglistModel(this);
            this.jpm.setLoadDataCallBack(this.jpw);
            this.jqt = (OfficialBarMsglistModel) this.jpm;
            if (bundle != null) {
                au(bundle);
            } else {
                cET();
            }
            this.jqt.setUserType(this.mUserType);
            if (!cEU()) {
                return false;
            }
            this.jqu = true;
            registerListener(this.jqv);
            registerListener(this.jqw);
            registerListener(this.jqx);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.jpl = new OfficialBarMsglistView(this, this.jpm.getIsAcceptNotify());
        this.jqs = (OfficialBarMsglistView) this.jpl;
        if (this.mUserType == 4) {
            this.jqs.Bo(R.string.more);
            this.jqs.closeNotNotify();
            this.jqs.closeReceiver();
            this.jqs.cFR();
        }
        if (this.mUserType == 3) {
            this.jqs.cFR();
        }
        this.jpl.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.jHd.longValue();
        if ((this.jpm instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.jpm).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.jpl.refreshHeaderFooter(str, false);
            } else {
                this.jpl.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.jpl.bindDataAndRefresh(this.jpm.getData(), longValue);
            this.jpl.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.jpm.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cER() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.jpm.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().pN(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (cF(this.jqs.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow cFP = this.jqs.cFP();
            if (cFP.isShown() && !cF(cFP).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.jqs.cFQ()[i];
                    if (aVar.blz) {
                        this.jqs.cFP().PE();
                        aVar.blz = false;
                        this.jqs.Y(i, aVar.blz);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect cF(View view) {
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
            /* renamed from: bCO */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cLQ().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void cES() {
        final UserData user;
        if (this.mUserType != 4) {
            super.cES();
            if ((this.jpm instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.jpm).getUser()) != null) {
                ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ad
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.cLQ().fh(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new m<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.jpl.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.jpl.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> cHy;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.jpl.getBtnGroupInfo()) {
            if ((this.jpm instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.jpm).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.jqs.cFQ()[0].jrq || view == this.jqs.cFQ()[1].jrq || view == this.jqs.cFQ()[2].jrq) {
            TiebaStatic.log("service_bt_ck");
            int cG = this.jqs.cG(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.jqs.cFQ()[i];
                if (aVar.blz && i != cG) {
                    this.jqs.cFP().cMi();
                    aVar.blz = false;
                    this.jqs.Y(i, aVar.blz);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.jqt.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (cHy = officialBarMenuDatas.cHy()) != null && cG < cHy.size() && (bVar = cHy.get(cG)) != null) {
                if (bVar.cHv() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.jqs.cFQ()[cG];
                    OfficialSecondMenuPopupWindow cFP = this.jqs.cFP();
                    if (aVar2.blz) {
                        cFP.PE();
                    } else {
                        cFP.setData(3, cG, bVar.cHw());
                        cFP.O(view);
                    }
                    aVar2.blz = !aVar2.blz;
                    this.jqs.Y(cG, aVar2.blz);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String aL;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.jpm.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (cFE() && (msg = this.jpm.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (aL = com.baidu.tieba.im.util.e.aL(msg.getContent(), true)) != null && (this.jpm instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.jpm).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), aL, ((CommonPersonalMsglistModel) this.jpm).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.cHv() == 2) {
            this.jqs.qt(true);
            this.jqt.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.jqt.getForumId());
        } else if (bVar.cHv() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.jqs.cFP().PE();
            OfficialBarMsglistView.a aVar = this.jqs.cFQ()[i];
            aVar.blz = false;
            this.jqs.Y(i, aVar.blz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void av(Bundle bundle) {
        super.av(bundle);
        cEZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Y(Intent intent) {
        super.Y(intent);
        cEZ();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.cLT().cLU();
        com.baidu.tieba.im.b.a.cLT().cLV();
    }

    private void cEZ() {
        if (this.jpm == null || !(this.jpm instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.jpm).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
    }
}
