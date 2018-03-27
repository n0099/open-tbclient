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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
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
import com.baidu.tieba.im.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements a.b {
    private OfficialBarMsglistView exT;
    private OfficialBarMsglistModel exU;
    private boolean exV;
    private final com.baidu.adp.framework.listener.c exW = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.exT.hm(false);
            if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
            if (responseOfficialBarMenuMessage.hasError()) {
                if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.j.neterror) : responseOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.j.neterror);
                }
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.exU.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.aHU() == null || officialBarMenuDatas.aHU().size() == 0) {
                    OfficialBarChatActivity.this.exT.F(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.aHT()) {
                    OfficialBarChatActivity.this.exT.F(false, false);
                    if (officialBarMenuDatas2.aHU() != null && officialBarMenuDatas2.aHU().size() > 0) {
                        OfficialBarChatActivity.this.exU.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.exT.bY(officialBarMenuDatas2.aHU());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.exT.F(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c exX = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.exT.hm(false);
            if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
            if (responseSendOfficialBarMenuMessage.hasError()) {
                if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                    OfficialBarChatActivity.this.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? OfficialBarChatActivity.this.getResources().getString(d.j.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                } else {
                    OfficialBarChatActivity.this.showToast(d.j.neterror);
                }
            }
        }
    };
    private final CustomMessageListener exY = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.exT.F(false, false);
                OfficialBarChatActivity.this.exU.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.exU.sendGetMenuNetMessage(OfficialBarChatActivity.this.exU.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.exT.bY(officialBarMenuDatas.aHU());
                return;
            }
            OfficialBarChatActivity.this.exT.F(true, false);
            OfficialBarChatActivity.this.exU.sendGetMenuNetMessage(OfficialBarChatActivity.this.exU.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.exT.hm(true);
            this.exU.sendGetMenuLocalMessage(this.exU.getForumId());
        }
        com.baidu.tieba.im.b.a.aLZ().aMb();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean q(Bundle bundle) {
        try {
            this.ewV = new OfficialBarMsglistModel(this);
            this.ewV.setLoadDataCallBack(this.exf);
            this.exU = (OfficialBarMsglistModel) this.ewV;
            if (bundle != null) {
                r(bundle);
            } else {
                aFo();
            }
            this.exU.setUserType(this.mUserType);
            if (!aFp()) {
                return false;
            }
            this.exV = true;
            registerListener(this.exW);
            registerListener(this.exX);
            registerListener(this.exY);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.ewU = new OfficialBarMsglistView(this, this.ewV.getIsAcceptNotify());
        this.exT = (OfficialBarMsglistView) this.ewU;
        if (this.mUserType == 4) {
            this.exT.pL(d.j.more);
            this.exT.closeNotNotify();
            this.exT.closeReceiver();
            this.exT.aGm();
        }
        if (this.mUserType == 3) {
            this.exT.aGm();
        }
        this.ewU.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.sendmessage.a.eMH;
        if ((this.ewV instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.ewV).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.ewU.refreshHeaderFooter(str, false);
            } else {
                this.ewU.refreshHeaderFooter(str + getPageContext().getString(d.j.forum), false);
            }
            this.ewU.bindDataAndRefresh(this.ewV.getData(), i);
            this.ewU.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.ewV.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aFm() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.ewV.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gS(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (ca(this.exT.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.a aGk = this.exT.aGk();
            if (aGk.isShown() && !ca(aGk).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.exT.aGl()[i];
                    if (aVar.eyB) {
                        this.exT.aGk().asK();
                        aVar.eyB = false;
                        this.exT.K(i, aVar.eyB);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect ca(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: UP */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aLW().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void aFn() {
        final UserData user;
        if (this.mUserType != 4) {
            super.aFn();
            if ((this.ewV instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.ewV).getUser()) != null) {
                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.u
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.aLW().bk(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.ewU.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.ewU.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> aHU;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.ewU.getBtnGroupInfo()) {
            if ((this.ewV instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.ewV).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.exT.aGl()[0].eyC || view == this.exT.aGl()[1].eyC || view == this.exT.aGl()[2].eyC) {
            TiebaStatic.log("service_bt_ck");
            int cb = this.exT.cb(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.exT.aGl()[i];
                if (aVar.eyB && i != cb) {
                    this.exT.aGk().aMo();
                    aVar.eyB = false;
                    this.exT.K(i, aVar.eyB);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.exU.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (aHU = officialBarMenuDatas.aHU()) != null && cb < aHU.size() && (bVar = aHU.get(cb)) != null) {
                if (bVar.aHR() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.exT.aGl()[cb];
                    com.baidu.tieba.im.view.a aGk = this.exT.aGk();
                    if (aVar2.eyB) {
                        aGk.asK();
                    } else {
                        aGk.a(3, cb, bVar.aHS());
                        aGk.bK(view);
                    }
                    aVar2.eyB = !aVar2.eyB;
                    this.exT.K(cb, aVar2.eyB);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String I;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.ewV.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (aFZ() && (msg = this.ewV.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (I = com.baidu.tieba.im.util.e.I(msg.getContent(), true)) != null && (this.ewV instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.ewV).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), I, ((CommonPersonalMsglistModel) this.ewV).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.aHR() == 2) {
            this.exT.hm(true);
            this.exU.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.exU.getForumId());
        } else if (bVar.aHR() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.a.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.exT.aGk().asK();
            OfficialBarMsglistView.a aVar = this.exT.aGl()[i];
            aVar.eyB = false;
            this.exT.K(i, aVar.eyB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void s(Bundle bundle) {
        super.s(bundle);
        aFu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void N(Intent intent) {
        super.N(intent);
        aFu();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.aLZ().aMa();
        com.baidu.tieba.im.b.a.aLZ().aMb();
    }

    private void aFu() {
        if (this.ewV == null || !(this.ewV instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.ewV).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
    }
}
