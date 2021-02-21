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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
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
/* loaded from: classes8.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private boolean kCA;
    private final com.baidu.adp.framework.listener.c kCB = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.kCy.sH(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.kCz.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.cVu() == null || officialBarMenuDatas.cVu().size() == 0) {
                    OfficialBarChatActivity.this.kCy.aj(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.cVt()) {
                    OfficialBarChatActivity.this.kCy.aj(false, false);
                    if (officialBarMenuDatas2.cVu() != null && officialBarMenuDatas2.cVu().size() > 0) {
                        OfficialBarChatActivity.this.kCz.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.kCy.ep(officialBarMenuDatas2.cVu());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.kCy.aj(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kCC = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.kCy.sH(false);
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
    private final CustomMessageListener kCD = new CustomMessageListener(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.kCy.aj(false, false);
                OfficialBarChatActivity.this.kCz.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.kCz.sendGetMenuNetMessage(OfficialBarChatActivity.this.kCz.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.kCy.ep(officialBarMenuDatas.cVu());
                return;
            }
            OfficialBarChatActivity.this.kCy.aj(true, false);
            OfficialBarChatActivity.this.kCz.sendGetMenuNetMessage(OfficialBarChatActivity.this.kCz.getForumId(), 0L);
        }
    };
    private OfficialBarMsglistView kCy;
    private OfficialBarMsglistModel kCz;
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.kCy.sH(true);
            this.kCz.sendGetMenuLocalMessage(this.kCz.getForumId());
        }
        com.baidu.tieba.im.b.a.cYd().cYf();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean au(Bundle bundle) {
        try {
            this.kBt = new OfficialBarMsglistModel(this);
            this.kBt.setLoadDataCallBack(this.kBC);
            this.kCz = (OfficialBarMsglistModel) this.kBt;
            if (bundle != null) {
                av(bundle);
            } else {
                initParam();
            }
            this.kCz.setUserType(this.mUserType);
            if (!cUA()) {
                return false;
            }
            this.kCA = true;
            registerListener(this.kCB);
            registerListener(this.kCC);
            registerListener(this.kCD);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.kBs = new OfficialBarMsglistView(this, this.kBt.getIsAcceptNotify());
        this.kCy = (OfficialBarMsglistView) this.kBs;
        if (this.mUserType == 4) {
            this.kCy.CK(R.string.more);
            this.kCy.closeNotNotify();
            this.kCy.closeReceiver();
            this.kCy.cVd();
        }
        if (this.mUserType == 3) {
            this.kCy.cVd();
        }
        this.kBs.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.kLO.longValue();
        if ((this.kBt instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.kBt).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.kBs.refreshHeaderFooter(str, false);
            } else {
                this.kBs.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.kBs.bindDataAndRefresh(this.kBt.getData(), longValue);
            this.kBs.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.kBt.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cUy() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.c cVar) {
        this.kBt.loadFirst(cVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qq(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (dm(this.kCy.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow cVb = this.kCy.cVb();
            if (cVb.isShown() && !dm(cVb).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.kCy.cVc()[i];
                    if (aVar.bzt) {
                        this.kCy.cVb().UU();
                        aVar.bzt = false;
                        this.kCy.Z(i, aVar.bzt);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect dm(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        af.b(new ae<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bLW */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cYa().b(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void cUz() {
        final UserData user;
        if (this.mUserType != 4) {
            super.cUz();
            if ((this.kBt instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.kBt).getUser()) != null) {
                af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ae
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.cYa().fy(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new m<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.kBs.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.kBs.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> cVu;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.kBs.getBtnGroupInfo()) {
            if ((this.kBt instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.kBt).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.kCy.cVc()[0].kDu || view == this.kCy.cVc()[1].kDu || view == this.kCy.cVc()[2].kDu) {
            TiebaStatic.log("service_bt_ck");
            int dn = this.kCy.dn(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.kCy.cVc()[i];
                if (aVar.bzt && i != dn) {
                    this.kCy.cVb().cYi();
                    aVar.bzt = false;
                    this.kCy.Z(i, aVar.bzt);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.kCz.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (cVu = officialBarMenuDatas.cVu()) != null && dn < cVu.size() && (bVar = cVu.get(dn)) != null) {
                if (bVar.cVr() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.kCy.cVc()[dn];
                    OfficialSecondMenuPopupWindow cVb = this.kCy.cVb();
                    if (aVar2.bzt) {
                        cVb.UU();
                    } else {
                        cVb.setData(3, dn, bVar.cVs());
                        cVb.O(view);
                    }
                    aVar2.bzt = !aVar2.bzt;
                    this.kCy.Z(dn, aVar2.bzt);
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
                if (this.mUserType != 4 && (msg2 = this.kBt.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (cUQ() && (msg = this.kBt.getMsg(i2)) != null && com.baidu.tieba.im.util.c.o(msg) && (aR = com.baidu.tieba.im.util.c.aR(msg.getContent(), true)) != null && (this.kBt instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.kBt).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), aR, ((CommonPersonalMsglistModel) this.kBt).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.cVr() == 2) {
            this.kCy.sH(true);
            this.kCz.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.kCz.getForumId());
        } else if (bVar.cVr() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.kCy.cVb().UU();
            OfficialBarMsglistView.a aVar = this.kCy.cVc()[i];
            aVar.bzt = false;
            this.kCy.Z(i, aVar.bzt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void aw(Bundle bundle) {
        super.aw(bundle);
        cUF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void X(Intent intent) {
        super.X(intent);
        cUF();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.cYd().cYe();
        com.baidu.tieba.im.b.a.cYd().cYf();
    }

    private void cUF() {
        if (this.kBt == null || !(this.kBt instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.kBt).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }
}
