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
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.b {
    private OfficialBarMsglistView gdi;
    private OfficialBarMsglistModel gdj;
    private boolean gdk;
    private final com.baidu.adp.framework.listener.c gdl = new com.baidu.adp.framework.listener.c(303006) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gdi.kL(false);
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
                com.baidu.tieba.im.data.c officialBarMenuDatas = OfficialBarChatActivity.this.gdj.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.brZ() == null || officialBarMenuDatas.brZ().size() == 0) {
                    OfficialBarChatActivity.this.gdi.O(true, true);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.brY()) {
                    OfficialBarChatActivity.this.gdi.O(false, false);
                    if (officialBarMenuDatas2.brZ() != null && officialBarMenuDatas2.brZ().size() > 0) {
                        OfficialBarChatActivity.this.gdj.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        OfficialBarChatActivity.this.gdi.cG(officialBarMenuDatas2.brZ());
                        return;
                    }
                    return;
                }
                OfficialBarChatActivity.this.gdi.O(true, true);
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gdm = new com.baidu.adp.framework.listener.c(208003) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.gdi.kL(false);
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
    private final CustomMessageListener gdn = new CustomMessageListener(2001177) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                OfficialBarChatActivity.this.showToast(d.j.neterror);
                return;
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null) {
                OfficialBarChatActivity.this.gdi.O(false, false);
                OfficialBarChatActivity.this.gdj.setOfficialBarMenuDatas(officialBarMenuDatas);
                OfficialBarChatActivity.this.gdj.sendGetMenuNetMessage(OfficialBarChatActivity.this.gdj.getForumId(), officialBarMenuDatas.getUpdate_time());
                OfficialBarChatActivity.this.gdi.cG(officialBarMenuDatas.brZ());
                return;
            }
            OfficialBarChatActivity.this.gdi.O(true, false);
            OfficialBarChatActivity.this.gdj.sendGetMenuNetMessage(OfficialBarChatActivity.this.gdj.getForumId(), 0L);
        }
    };
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.gdi.kL(true);
            this.gdj.sendGetMenuLocalMessage(this.gdj.getForumId());
        }
        com.baidu.tieba.im.b.a.bwc().bwe();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean T(Bundle bundle) {
        try {
            this.gck = new OfficialBarMsglistModel(this);
            this.gck.setLoadDataCallBack(this.gcu);
            this.gdj = (OfficialBarMsglistModel) this.gck;
            if (bundle != null) {
                U(bundle);
            } else {
                bpx();
            }
            this.gdj.setUserType(this.mUserType);
            if (!bpy()) {
                return false;
            }
            this.gdk = true;
            registerListener(this.gdl);
            registerListener(this.gdm);
            registerListener(this.gdn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.gcj = new OfficialBarMsglistView(this, this.gck.getIsAcceptNotify());
        this.gdi = (OfficialBarMsglistView) this.gcj;
        if (this.mUserType == 4) {
            this.gdi.ty(d.j.more);
            this.gdi.closeNotNotify();
            this.gdi.closeReceiver();
            this.gdi.bqt();
        }
        if (this.mUserType == 3) {
            this.gdi.bqt();
        }
        this.gcj.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = com.baidu.tieba.im.sendmessage.a.grT.longValue();
        if ((this.gck instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gck).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.gcj.refreshHeaderFooter(str, false);
            } else {
                this.gcj.refreshHeaderFooter(str + getPageContext().getString(d.j.forum), false);
            }
            this.gcj.bindDataAndRefresh(this.gck.getData(), longValue);
            this.gcj.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.1
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        OfficialBarChatActivity.this.gck.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bpv() {
                }
            });
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.d dVar) {
        this.gck.loadFirst(dVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iz(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (bV(this.gdi.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow bqr = this.gdi.bqr();
            if (bqr.isShown() && !bV(bqr).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.a aVar = this.gdi.bqs()[i];
                    if (aVar.gdM) {
                        this.gdi.bqr().aXr();
                        aVar.gdM = false;
                        this.gdi.C(i, aVar.gdM);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect bV(View view) {
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
            /* renamed from: awS */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bvZ().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void bpw() {
        final UserData user;
        if (this.mUserType != 4) {
            super.bpw();
            if ((this.gck instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.gck).getUser()) != null) {
                aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.z
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.settingcache.d.bvZ().db(TbadkApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                    }
                }, new k<Boolean>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    public void onReturnDataInUI(Boolean bool) {
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                OfficialBarChatActivity.this.gcj.closeNotNotify();
                            } else {
                                OfficialBarChatActivity.this.gcj.showNotNotfiy();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.b> brZ;
        com.baidu.tieba.im.data.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.gcj.getBtnGroupInfo()) {
            if ((this.gck instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.gck).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.gdi.bqs()[0].gdN || view == this.gdi.bqs()[1].gdN || view == this.gdi.bqs()[2].gdN) {
            TiebaStatic.log("service_bt_ck");
            int bW = this.gdi.bW(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.a aVar = this.gdi.bqs()[i];
                if (aVar.gdM && i != bW) {
                    this.gdi.bqr().bwr();
                    aVar.gdM = false;
                    this.gdi.C(i, aVar.gdM);
                }
            }
            com.baidu.tieba.im.data.c officialBarMenuDatas = this.gdj.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (brZ = officialBarMenuDatas.brZ()) != null && bW < brZ.size() && (bVar = brZ.get(bW)) != null) {
                if (bVar.brW() == 0) {
                    OfficialBarMsglistView.a aVar2 = this.gdi.bqs()[bW];
                    OfficialSecondMenuPopupWindow bqr = this.gdi.bqr();
                    if (aVar2.gdM) {
                        bqr.aXr();
                    } else {
                        bqr.setData(3, bW, bVar.brX());
                        bqr.bg(view);
                    }
                    aVar2.gdM = !aVar2.gdM;
                    this.gdi.C(bW, aVar2.gdM);
                    return;
                }
                a(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String ai;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.gck.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), msg2.getUserInfo().getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (bqi() && (msg = this.gck.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (ai = com.baidu.tieba.im.util.e.ai(msg.getContent(), true)) != null && (this.gck instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.gck).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), ai, ((CommonPersonalMsglistModel) this.gck).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        if (bVar.brW() == 2) {
            this.gdi.kL(true);
            this.gdj.sendClickMenuMessage(bVar.getId(), TbadkApplication.getCurrentAccount(), this.gdj.getForumId());
        } else if (bVar.brW() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.getContent(), bVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.b
    public void a(int i, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            a(bVar);
            this.gdi.bqr().aXr();
            OfficialBarMsglistView.a aVar = this.gdi.bqs()[i];
            aVar.gdM = false;
            this.gdi.C(i, aVar.gdM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void V(Bundle bundle) {
        super.V(bundle);
        bpD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void ah(Intent intent) {
        super.ah(intent);
        bpD();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.b.a.bwc().bwd();
        com.baidu.tieba.im.b.a.bwc().bwe();
    }

    private void bpD() {
        if (this.gck == null || !(this.gck instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.gck).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
    }
}
