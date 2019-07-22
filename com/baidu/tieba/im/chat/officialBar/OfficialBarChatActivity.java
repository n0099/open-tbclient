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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
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
    private OfficialBarMsglistView gAL;
    private OfficialBarMsglistModel gAM;
    private boolean gAN;
    private final com.baidu.adp.framework.listener.c gAO = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gAL.lP(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.gAM.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.bCu() == null || officialBarMenuDatas.bCu().size() == 0) {
                    OfficialBarChatActivity.this.gAL.S(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.bCt()) {
                    OfficialBarChatActivity.this.gAL.S(false, false);
                    if (officialBarMenuDatas2.bCu() != null && officialBarMenuDatas2.bCu().size() > 0) {
                        OfficialBarChatActivity.this.gAM.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.gAL.cQ(officialBarMenuDatas2.bCu());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.gAL.S(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gAP = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gAL.lP(false);
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
    private final CustomMessageListener gAQ = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(R.string.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.gAL.S(false, false);
                OfficialBarChatActivity.this.gAM.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.gAM.sendGetMenuNetMessage(OfficialBarChatActivity.this.gAM.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.gAL.cQ(officialBarMenuDatas.bCu());
                return;
            }
            OfficialBarChatActivity.this.gAL.S(true, false);
            OfficialBarChatActivity.this.gAM.sendGetMenuNetMessage(OfficialBarChatActivity.this.gAM.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.gAL.lP(true);
            this.gAM.sendGetMenuLocalMessage(this.gAM.getForumId());
        }
        com.baidu.tieba.im.b.a.bGv().bGx();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean U(Bundle bundle) {
        try {
            this.gzO = new OfficialBarMsglistModel(this);
            this.gzO.setLoadDataCallBack(this.gzY);
            this.gAM = (OfficialBarMsglistModel) this.gzO;
            if (bundle != null) {
                V(bundle);
            } else {
                bzR();
            }
            this.gAM.setUserType(this.mUserType);
            if (!bzS()) {
                return false;
            }
            this.gAN = true;
            registerListener(this.gAO);
            registerListener(this.gAP);
            registerListener(this.gAQ);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.gzN = new OfficialBarMsglistView(this, this.gzO.getIsAcceptNotify());
        this.gAL = (OfficialBarMsglistView) this.gzN;
        if (this.mUserType == 4) {
            this.gAL.vg(R.string.more);
            this.gAL.closeNotNotify();
            this.gAL.closeReceiver();
            this.gAL.bAN();
        }
        if (this.mUserType == 3) {
            this.gAL.bAN();
        }
        this.gzN.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.gPt.longValue();
        if ((this.gzO instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gzO).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.gzN.refreshHeaderFooter(str, false);
            } else {
                this.gzN.refreshHeaderFooter(str + getPageContext().getString(R.string.forum), false);
            }
            this.gzN.bindDataAndRefresh(this.gzO.getData(), longValue);
            this.gzN.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.gzO.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bzP() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.gzO.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.anD().jt(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (cf(this.gAL.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow bAL = this.gAL.bAL();
            if (bAL.isShown() && !cf(bAL).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.gAL.bAM()[i];
                    if (aVar.gBn) {
                        this.gAL.bAL().bgM();
                        aVar.gBn = false;
                        this.gAL.J(i, aVar.gBn);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect cf(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        aa.b(new z<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: aDr */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bGs().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void bzQ() {
        final UserData user;
        if (this.mUserType != 4) {
            super.bzQ();
            if ((this.gzO instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.gzO).getUser()) != null) {
                aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.z
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.bGs().dp(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new k<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.gzN.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.gzN.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> bCu;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.gzN.getBtnGroupInfo()) {
            if ((this.gzO instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gzO).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.gAL.bAM()[0].gBo || view == this.gAL.bAM()[1].gBo || view == this.gAL.bAM()[2].gBo) {
            TiebaStatic.log("service_bt_ck");
            int cg = this.gAL.cg(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.gAL.bAM()[i];
                if (aVar.gBn && i != cg) {
                    this.gAL.bAL().bGK();
                    aVar.gBn = false;
                    this.gAL.J(i, aVar.gBn);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.gAM.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (bCu = officialBarMenuDatas.bCu()) != null && cg < bCu.size() && (bVar = bCu.get(cg)) != null) {
                if (bVar.bCr() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.gAL.bAM()[cg];
                    OfficialSecondMenuPopupWindow bAL = this.gAL.bAL();
                    if (aVar2.gBn) {
                        bAL.bgM();
                    } else {
                        bAL.setData(3, cg, bVar.bCs());
                        bAL.bo(view);
                    }
                    aVar2.gBn = !aVar2.gBn;
                    this.gAL.J(cg, aVar2.gBn);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String ao;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.gzO.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (bAC() && (msg = this.gzO.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (ao = com.baidu.tieba.im.util.e.ao(msg.getContent(), true)) != null && (this.gzO instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.gzO).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), ao, ((CommonPersonalMsglistModel) this.gzO).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.bCr() == 2) {
            this.gAL.lP(true);
            this.gAM.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.gAM.getForumId());
        } else if (bVar.bCr() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.gAL.bAL().bgM();
            OfficialBarMsglistView.a aVar = this.gAL.bAM()[i];
            aVar.gBn = false;
            this.gAL.J(i, aVar.gBn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void W(Bundle bundle) {
        super.W(bundle);
        bzX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void ak(Intent intent) {
        super.ak(intent);
        bzX();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.bGv().bGw();
        com.baidu.tieba.im.b.a.bGv().bGx();
    }

    private void bzX() {
        if (this.gzO == null || !(this.gzO instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.gzO).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }
}
