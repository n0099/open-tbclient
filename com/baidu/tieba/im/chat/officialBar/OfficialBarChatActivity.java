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
    private OfficialBarMsglistView eMG;
    private OfficialBarMsglistModel eMH;
    private boolean eMI;
    private final com.baidu.adp.framework.listener.c eMJ = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eMG.il(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.eMH.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aQX() == null || officialBarMenuDatas.aQX().size() == 0) {
                    OfficialBarChatActivity.this.eMG.J(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aQW()) {
                    OfficialBarChatActivity.this.eMG.J(false, false);
                    if (officialBarMenuDatas2.aQX() != null && officialBarMenuDatas2.aQX().size() > 0) {
                        OfficialBarChatActivity.this.eMH.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.eMG.cw(officialBarMenuDatas2.aQX());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.eMG.J(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eMK = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.eMG.il(false);
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
    private final CustomMessageListener eML = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(e.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.eMG.J(false, false);
                OfficialBarChatActivity.this.eMH.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.eMH.sendGetMenuNetMessage(OfficialBarChatActivity.this.eMH.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.eMG.cw(officialBarMenuDatas.aQX());
                return;
            }
            OfficialBarChatActivity.this.eMG.J(true, false);
            OfficialBarChatActivity.this.eMH.sendGetMenuNetMessage(OfficialBarChatActivity.this.eMH.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.eMG.il(true);
            this.eMH.sendGetMenuLocalMessage(this.eMH.getForumId());
        }
        com.baidu.tieba.im.b.a.aVa().aVc();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean v(Bundle bundle) {
        try {
            this.eLI = new OfficialBarMsglistModel(this);
            this.eLI.setLoadDataCallBack(this.eLS);
            this.eMH = (OfficialBarMsglistModel) this.eLI;
            if (bundle != null) {
                w(bundle);
            } else {
                aOv();
            }
            this.eMH.setUserType(this.mUserType);
            if (!aOw()) {
                return false;
            }
            this.eMI = true;
            registerListener(this.eMJ);
            registerListener(this.eMK);
            registerListener(this.eML);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.eLH = new OfficialBarMsglistView(this, this.eLI.getIsAcceptNotify());
        this.eMG = (OfficialBarMsglistView) this.eLH;
        if (this.mUserType == 4) {
            this.eMG.pR(e.j.more);
            this.eMG.closeNotNotify();
            this.eMG.closeReceiver();
            this.eMG.aPr();
        }
        if (this.mUserType == 3) {
            this.eMG.aPr();
        }
        this.eLH.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.fbl.longValue();
        if ((this.eLI instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eLI).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.eLH.refreshHeaderFooter(str, false);
            } else {
                this.eLH.refreshHeaderFooter(str + getPageContext().getString(e.j.forum), false);
            }
            this.eLH.bindDataAndRefresh(this.eLI.getData(), longValue);
            this.eLH.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.eLI.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aOt() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.eLI.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().eU(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (bg(this.eMG.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow aPp = this.eMG.aPp();
            if (aPp.isShown() && !bg(aPp).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.eMG.aPq()[i];
                    if (aVar.eNk) {
                        this.eMG.aPp().ayj();
                        aVar.eNk = false;
                        this.eMG.w(i, aVar.eNk);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect bg(View view) {
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
            /* renamed from: Wy */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aUX().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aOu() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aOu();
            if ((this.eLI instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.eLI).getUser()) != null) {
                x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aUX().bS(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.eLH.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.eLH.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aQX;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.eLH.getBtnGroupInfo()) {
            if ((this.eLI instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.eLI).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.eMG.aPq()[0].eNl || view == this.eMG.aPq()[1].eNl || view == this.eMG.aPq()[2].eNl) {
            TiebaStatic.log("service_bt_ck");
            int bh = this.eMG.bh(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.eMG.aPq()[i];
                if (aVar.eNk && i != bh) {
                    this.eMG.aPp().aVp();
                    aVar.eNk = false;
                    this.eMG.w(i, aVar.eNk);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.eMH.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aQX = officialBarMenuDatas.aQX()) != null && bh < aQX.size() && (bVar = aQX.get(bh)) != null) {
                if (bVar.aQU() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.eMG.aPq()[bh];
                    OfficialSecondMenuPopupWindow aPp = this.eMG.aPp();
                    if (aVar2.eNk) {
                        aPp.ayj();
                    } else {
                        aPp.setData(3, bh, bVar.aQV());
                        aPp.aN(view);
                    }
                    aVar2.eNk = !aVar2.eNk;
                    this.eMG.w(bh, aVar2.eNk);
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
                if (this.mUserType != 4 && (msg2 = this.eLI.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aPg() && (msg = this.eLI.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (P = com.baidu.tieba.im.util.e.P(msg.getContent(), true)) != null && (this.eLI instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.eLI).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), P, ((CommonPersonalMsglistModel) this.eLI).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aQU() == 2) {
            this.eMG.il(true);
            this.eMH.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.eMH.getForumId());
        } else if (bVar.aQU() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.eMG.aPp().ayj();
            OfficialBarMsglistView.a aVar = this.eMG.aPq()[i];
            aVar.eNk = false;
            this.eMG.w(i, aVar.eNk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void x(Bundle bundle) {
        super.x(bundle);
        aOB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Q(Intent intent) {
        super.Q(intent);
        aOB();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aVa().aVb();
        com.baidu.tieba.im.b.a.aVa().aVc();
    }

    private void aOB() {
        if (this.eLI == null || !(this.eLI instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.eLI).getUser();
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
