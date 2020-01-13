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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
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
/* loaded from: classes11.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private OfficialBarMsglistView hsl;
    private OfficialBarMsglistModel hsm;
    private boolean hsn;
    private final com.baidu.adp.framework.listener.c hso = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.hsl.ng(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.hsm.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.bSD() == null || officialBarMenuDatas.bSD().size() == 0) {
                    OfficialBarChatActivity.this.hsl.T(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.bSC()) {
                    OfficialBarChatActivity.this.hsl.T(false, false);
                    if (officialBarMenuDatas2.bSD() != null && officialBarMenuDatas2.bSD().size() > 0) {
                        OfficialBarChatActivity.this.hsm.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.hsl.cR(officialBarMenuDatas2.bSD());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.hsl.T(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hsp = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.hsl.ng(false);
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
    private final CustomMessageListener hsq = new CustomMessageListener(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.hsl.T(false, false);
                OfficialBarChatActivity.this.hsm.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.hsm.sendGetMenuNetMessage(OfficialBarChatActivity.this.hsm.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.hsl.cR(officialBarMenuDatas.bSD());
                return;
            }
            OfficialBarChatActivity.this.hsl.T(true, false);
            OfficialBarChatActivity.this.hsm.sendGetMenuNetMessage(OfficialBarChatActivity.this.hsm.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.hsl.ng(true);
            this.hsm.sendGetMenuLocalMessage(this.hsm.getForumId());
        }
        com.baidu.tieba.im.b.a.bWB().bWD();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean am(Bundle bundle) {
        try {
            this.hro = new OfficialBarMsglistModel(this);
            this.hro.setLoadDataCallBack(this.hry);
            this.hsm = (OfficialBarMsglistModel) this.hro;
            if (bundle != null) {
                an(bundle);
            } else {
                bQc();
            }
            this.hsm.setUserType(this.mUserType);
            if (!bQd()) {
                return false;
            }
            this.hsn = true;
            registerListener(this.hso);
            registerListener(this.hsp);
            registerListener(this.hsq);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.hrn = new OfficialBarMsglistView(this, this.hro.getIsAcceptNotify());
        this.hsl = (OfficialBarMsglistView) this.hrn;
        if (this.mUserType == 4) {
            this.hsl.vX(R.string.more);
            this.hsl.closeNotNotify();
            this.hsl.closeReceiver();
            this.hsl.bQY();
        }
        if (this.mUserType == 3) {
            this.hsl.bQY();
        }
        this.hrn.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.hGW.longValue();
        if ((this.hro instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.hro).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.hrn.refreshHeaderFooter(str, false);
            } else {
                this.hrn.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.hrn.bindDataAndRefresh(this.hro.getData(), longValue);
            this.hrn.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.hro.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bQa() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.hro.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aIj().lu(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (ce(this.hsl.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow bQW = this.hsl.bQW();
            if (bQW.isShown() && !ce(bQW).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.hsl.bQX()[i];
                    if (aVar.hsN) {
                        this.hsl.bQW().yA();
                        aVar.hsN = false;
                        this.hsl.K(i, aVar.hsN);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect ce(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWq */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bWy().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void bQb() {
        final UserData user;
        if (this.mUserType != 4) {
            super.bQb();
            if ((this.hro instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.hro).getUser()) != null) {
                ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.bWy().dx(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new l<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.hrn.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.hrn.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> bSD;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.hrn.getBtnGroupInfo()) {
            if ((this.hro instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.hro).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.hsl.bQX()[0].hsO || view == this.hsl.bQX()[1].hsO || view == this.hsl.bQX()[2].hsO) {
            TiebaStatic.log("service_bt_ck");
            int cf = this.hsl.cf(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.hsl.bQX()[i];
                if (aVar.hsN && i != cf) {
                    this.hsl.bQW().bWQ();
                    aVar.hsN = false;
                    this.hsl.K(i, aVar.hsN);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.hsm.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (bSD = officialBarMenuDatas.bSD()) != null && cf < bSD.size() && (bVar = bSD.get(cf)) != null) {
                if (bVar.bSA() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.hsl.bQX()[cf];
                    OfficialSecondMenuPopupWindow bQW = this.hsl.bQW();
                    if (aVar2.hsN) {
                        bQW.yA();
                    } else {
                        bQW.setData(3, cf, bVar.bSB());
                        bQW.R(view);
                    }
                    aVar2.hsN = !aVar2.hsN;
                    this.hsl.K(cf, aVar2.hsN);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String ao;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.hro.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (bQN() && (msg = this.hro.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (ao = com.baidu.tieba.im.util.e.ao(msg.getContent(), true)) != null && (this.hro instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.hro).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), ao, ((CommonPersonalMsglistModel) this.hro).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.bSA() == 2) {
            this.hsl.ng(true);
            this.hsm.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.hsm.getForumId());
        } else if (bVar.bSA() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.hsl.bQW().yA();
            OfficialBarMsglistView.a aVar = this.hsl.bQX()[i];
            aVar.hsN = false;
            this.hsl.K(i, aVar.hsN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void ao(Bundle bundle) {
        super.ao(bundle);
        bQi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void an(Intent intent) {
        super.an(intent);
        bQi();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.bWB().bWC();
        com.baidu.tieba.im.b.a.bWB().bWD();
    }

    private void bQi() {
        if (this.hro == null || !(this.hro instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.hro).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }
}
