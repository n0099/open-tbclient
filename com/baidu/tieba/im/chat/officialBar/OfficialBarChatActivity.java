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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private OfficialBarMsglistView gBu;
    private OfficialBarMsglistModel gBv;
    private boolean gBw;
    private final com.baidu.adp.framework.listener.c gBx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gBu.lG(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.gBv.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.bAg() == null || officialBarMenuDatas.bAg().size() == 0) {
                    OfficialBarChatActivity.this.gBu.U(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.bAf()) {
                    OfficialBarChatActivity.this.gBu.U(false, false);
                    if (officialBarMenuDatas2.bAg() != null && officialBarMenuDatas2.bAg().size() > 0) {
                        OfficialBarChatActivity.this.gBv.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.gBu.dc(officialBarMenuDatas2.bAg());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.gBu.U(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gBy = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gBu.lG(false);
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
    private final CustomMessageListener gBz = new CustomMessageListener(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.gBu.U(false, false);
                OfficialBarChatActivity.this.gBv.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.gBv.sendGetMenuNetMessage(OfficialBarChatActivity.this.gBv.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.gBu.dc(officialBarMenuDatas.bAg());
                return;
            }
            OfficialBarChatActivity.this.gBu.U(true, false);
            OfficialBarChatActivity.this.gBv.sendGetMenuNetMessage(OfficialBarChatActivity.this.gBv.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.gBu.lG(true);
            this.gBv.sendGetMenuLocalMessage(this.gBv.getForumId());
        }
        com.baidu.tieba.im.b.a.bEi().bEk();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean T(Bundle bundle) {
        try {
            this.gAv = new OfficialBarMsglistModel(this);
            this.gAv.setLoadDataCallBack(this.gAG);
            this.gBv = (OfficialBarMsglistModel) this.gAv;
            if (bundle != null) {
                U(bundle);
            } else {
                bxE();
            }
            this.gBv.setUserType(this.mUserType);
            if (!bxF()) {
                return false;
            }
            this.gBw = true;
            registerListener(this.gBx);
            registerListener(this.gBy);
            registerListener(this.gBz);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.gAu = new OfficialBarMsglistView(this, this.gAv.getIsAcceptNotify());
        this.gBu = (OfficialBarMsglistView) this.gAu;
        if (this.mUserType == 4) {
            this.gBu.tR(R.string.more);
            this.gBu.closeNotNotify();
            this.gBu.closeReceiver();
            this.gBu.byz();
        }
        if (this.mUserType == 3) {
            this.gBu.byz();
        }
        this.gAu.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.gQg.longValue();
        if ((this.gAv instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gAv).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.gAu.refreshHeaderFooter(str, false);
            } else {
                this.gAu.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.gAu.bindDataAndRefresh(this.gAv.getData(), longValue);
            this.gAu.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.gAv.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bxC() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.gAv.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aqt().ji(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (cd(this.gBu.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow byx = this.gBu.byx();
            if (byx.isShown() && !cd(byx).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.gBu.byy()[i];
                    if (aVar.gBW) {
                        this.gBu.byx().wl();
                        aVar.gBW = false;
                        this.gBu.I(i, aVar.gBW);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect cd(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        z.b(new y<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: aEg */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bEf().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void bxD() {
        final UserData user;
        if (this.mUserType != 4) {
            super.bxD();
            if ((this.gAv instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.gAv).getUser()) != null) {
                z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.y
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.bEf().dc(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new j<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.gAu.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.gAu.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> bAg;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.gAu.getBtnGroupInfo()) {
            if ((this.gAv instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gAv).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.gBu.byy()[0].gBX || view == this.gBu.byy()[1].gBX || view == this.gBu.byy()[2].gBX) {
            TiebaStatic.log("service_bt_ck");
            int ce = this.gBu.ce(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.gBu.byy()[i];
                if (aVar.gBW && i != ce) {
                    this.gBu.byx().bEx();
                    aVar.gBW = false;
                    this.gBu.I(i, aVar.gBW);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.gBv.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (bAg = officialBarMenuDatas.bAg()) != null && ce < bAg.size() && (bVar = bAg.get(ce)) != null) {
                if (bVar.bAd() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.gBu.byy()[ce];
                    OfficialSecondMenuPopupWindow byx = this.gBu.byx();
                    if (aVar2.gBW) {
                        byx.wl();
                    } else {
                        byx.setData(3, ce, bVar.bAe());
                        byx.O(view);
                    }
                    aVar2.gBW = !aVar2.gBW;
                    this.gBu.I(ce, aVar2.gBW);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String ak;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.gAv.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (byo() && (msg = this.gAv.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (ak = com.baidu.tieba.im.util.e.ak(msg.getContent(), true)) != null && (this.gAv instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.gAv).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), ak, ((CommonPersonalMsglistModel) this.gAv).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.bAd() == 2) {
            this.gBu.lG(true);
            this.gBv.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.gBv.getForumId());
        } else if (bVar.bAd() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.gBu.byx().wl();
            OfficialBarMsglistView.a aVar = this.gBu.byy()[i];
            aVar.gBW = false;
            this.gBu.I(i, aVar.gBW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void V(Bundle bundle) {
        super.V(bundle);
        bxK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void au(Intent intent) {
        super.au(intent);
        bxK();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.bEi().bEj();
        com.baidu.tieba.im.b.a.bEi().bEk();
    }

    private void bxK() {
        if (this.gAv == null || !(this.gAv instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.gAv).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }
}
