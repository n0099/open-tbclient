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
    private OfficialBarMsglistView eBH;
    private OfficialBarMsglistModel eBI;
    private boolean eBJ;
    private final com.baidu.adp.framework.listener.c eBK = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eBH.hW(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.eBI.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aOV() == null || officialBarMenuDatas.aOV().size() == 0) {
                    OfficialBarChatActivity.this.eBH.H(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aOU()) {
                    OfficialBarChatActivity.this.eBH.H(false, false);
                    if (officialBarMenuDatas2.aOV() != null && officialBarMenuDatas2.aOV().size() > 0) {
                        OfficialBarChatActivity.this.eBI.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.eBH.ct(officialBarMenuDatas2.aOV());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.eBH.H(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eBL = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eBH.hW(false);
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
    private final CustomMessageListener eBM = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.eBH.H(false, false);
                OfficialBarChatActivity.this.eBI.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.eBI.sendGetMenuNetMessage(OfficialBarChatActivity.this.eBI.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.eBH.ct(officialBarMenuDatas.aOV());
                return;
            }
            OfficialBarChatActivity.this.eBH.H(true, false);
            OfficialBarChatActivity.this.eBI.sendGetMenuNetMessage(OfficialBarChatActivity.this.eBI.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.eBH.hW(true);
            this.eBI.sendGetMenuLocalMessage(this.eBI.getForumId());
        }
        com.baidu.tieba.im.b.a.aSY().aTa();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean p(Bundle bundle) {
        try {
            this.eAJ = new OfficialBarMsglistModel(this);
            this.eAJ.setLoadDataCallBack(this.eAT);
            this.eBI = (OfficialBarMsglistModel) this.eAJ;
            if (bundle != null) {
                q(bundle);
            } else {
                aMs();
            }
            this.eBI.setUserType(this.mUserType);
            if (!aMt()) {
                return false;
            }
            this.eBJ = true;
            registerListener(this.eBK);
            registerListener(this.eBL);
            registerListener(this.eBM);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.eAI = new OfficialBarMsglistView(this, this.eAJ.getIsAcceptNotify());
        this.eBH = (OfficialBarMsglistView) this.eAI;
        if (this.mUserType == 4) {
            this.eBH.oR(e.j.more);
            this.eBH.closeNotNotify();
            this.eBH.closeReceiver();
            this.eBH.aNp();
        }
        if (this.mUserType == 3) {
            this.eBH.aNp();
        }
        this.eAI.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.eQn.longValue();
        if ((this.eAJ instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eAJ).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.eAI.refreshHeaderFooter(str, false);
            } else {
                this.eAI.refreshHeaderFooter(str + getPageContext().getString(e.j.forum), false);
            }
            this.eAI.bindDataAndRefresh(this.eAJ.getData(), longValue);
            this.eAI.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.eAJ.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aMq() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.eAJ.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().er(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (bb(this.eBH.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aNn = this.eBH.aNn();
            if (aNn.isShown() && !bb(aNn).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.eBH.aNo()[i];
                    if (aVar.eCl) {
                        this.eBH.aNn().awl();
                        aVar.eCl = false;
                        this.eBH.w(i, aVar.eCl);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect bb(View view) {
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
            /* renamed from: Vh */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aSV().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aMr() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aMr();
            if ((this.eAJ instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.eAJ).getUser()) != null) {
                x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aSV().bN(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.eAI.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.eAI.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aOV;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.eAI.getBtnGroupInfo()) {
            if ((this.eAJ instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eAJ).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.eBH.aNo()[0].eCm || view == this.eBH.aNo()[1].eCm || view == this.eBH.aNo()[2].eCm) {
            TiebaStatic.log("service_bt_ck");
            int bc = this.eBH.bc(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.eBH.aNo()[i];
                if (aVar.eCl && i != bc) {
                    this.eBH.aNn().aTn();
                    aVar.eCl = false;
                    this.eBH.w(i, aVar.eCl);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.eBI.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aOV = officialBarMenuDatas.aOV()) != null && bc < aOV.size() && (bVar = aOV.get(bc)) != null) {
                if (bVar.aOS() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.eBH.aNo()[bc];
                    OfficialSecondMenuPopupWindow aNn = this.eBH.aNn();
                    if (aVar2.eCl) {
                        aNn.awl();
                    } else {
                        aNn.setData(3, bc, bVar.aOT());
                        aNn.aI(view);
                    }
                    aVar2.eCl = !aVar2.eCl;
                    this.eBH.w(bc, aVar2.eCl);
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
                if (this.mUserType != 4 && (msg2 = this.eAJ.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aNd() && (msg = this.eAJ.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (N = com.baidu.tieba.im.util.e.N(msg.getContent(), true)) != null && (this.eAJ instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.eAJ).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), N, ((CommonPersonalMsglistModel) this.eAJ).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aOS() == 2) {
            this.eBH.hW(true);
            this.eBI.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.eBI.getForumId());
        } else if (bVar.aOS() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.eBH.aNn().awl();
            OfficialBarMsglistView.a aVar = this.eBH.aNo()[i];
            aVar.eCl = false;
            this.eBH.w(i, aVar.eCl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void r(Bundle bundle) {
        super.r(bundle);
        aMy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Q(Intent intent) {
        super.Q(intent);
        aMy();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aSY().aSZ();
        com.baidu.tieba.im.b.a.aSY().aTa();
    }

    private void aMy() {
        if (this.eAJ == null || !(this.eAJ instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.eAJ).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
    }
}
