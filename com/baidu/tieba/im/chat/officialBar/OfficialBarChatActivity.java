package com.baidu.tieba.im.chat.officialBar;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements com.baidu.tieba.im.view.e {
    private OfficialBarMsglistView aZe;
    private OfficialBarMsglistModel aZf;
    private boolean aZg;
    private final com.baidu.adp.framework.listener.e aZh = new r(this, 303006);
    private final com.baidu.adp.framework.listener.e aZi = new s(this, 208003);
    private final CustomMessageListener aZj = new t(this, 2001181);
    private int mUserType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.aZe.ct(true);
            this.aZf.sendGetMenuLocalMessage(this.aZf.getForumId());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            this.mListModel = new OfficialBarMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
            this.aZf = (OfficialBarMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            this.aZf.setUserType(this.mUserType);
            if (checkParam()) {
                this.aZg = true;
                registerListener(this.aZh);
                registerListener(this.aZi);
                registerListener(this.aZj);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.mListView = new OfficialBarMsglistView(this, this.mListModel.getIsAcceptNotify());
        this.aZe = (OfficialBarMsglistView) this.mListView;
        if (this.mUserType == 4) {
            this.aZe.fD(com.baidu.tieba.y.data_more);
            this.aZe.closeNotNotify();
            this.aZe.closeReceiver();
            this.aZe.Or();
        }
        if (this.mUserType == 3) {
            this.aZe.Or();
        }
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.c.a.bmK;
        if ((this.mListModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.mListModel).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.mListView.refreshHeaderFooter(str, false);
            } else {
                this.mListView.refreshHeaderFooter(String.valueOf(str) + getPageContext().getString(com.baidu.tieba.y.bar), false);
            }
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), i);
            this.mListView.setRecordCallback(new u(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean first(com.baidu.tieba.im.chat.ax axVar) {
        this.mListModel.loadFirst(axVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().cC(com.baidu.adp.lib.g.c.toInt(curId, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(curId, 4)));
        }
        com.baidu.tieba.im.d.a.TF().TG();
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (C(this.aZe.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.a Oo = this.aZe.Oo();
            if (Oo.isShown() && !C(Oo).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    ai aiVar = this.aZe.Op()[i];
                    if (aiVar.aZM) {
                        this.aZe.Oo().TS();
                        aiVar.aZM = false;
                        this.aZe.m(i, aiVar.aZM);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect C(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.l.a(new v(this, userData), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        if (this.mUserType != 4) {
            super.refreshHeadIcon();
            if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
                com.baidu.tieba.im.l.a(new w(this, user), new x(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.d> PS;
        com.baidu.tieba.im.data.d dVar;
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            if ((this.mListModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.mListModel).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), new StringBuilder(String.valueOf(user.getUserIdLong())).toString(), ForumDetailActivityConfig.FromType.BAR)));
                }
            }
        } else if (view == this.aZe.Oq()) {
            this.aZg = !this.aZg;
            this.aZe.cu(this.aZg);
        } else if (view == this.aZe.Op()[0].aZN || view == this.aZe.Op()[1].aZN || view == this.aZe.Op()[2].aZN) {
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "service_bt_ck");
            int D = this.aZe.D(view);
            for (int i = 0; i < 3; i++) {
                ai aiVar = this.aZe.Op()[i];
                if (aiVar.aZM && i != D) {
                    this.aZe.Oo().TT();
                    aiVar.aZM = false;
                    this.aZe.m(i, aiVar.aZM);
                }
            }
            com.baidu.tieba.im.data.e officialBarMenuDatas = this.aZf.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (PS = officialBarMenuDatas.PS()) != null && D < PS.size() && (dVar = PS.get(D)) != null) {
                if (dVar.PO() == 0) {
                    ai aiVar2 = this.aZe.Op()[D];
                    com.baidu.tieba.im.view.a Oo = this.aZe.Oo();
                    if (aiVar2.aZM) {
                        Oo.TS();
                    } else {
                        Oo.a(3, D, dVar.PP());
                        Oo.F(view);
                    }
                    aiVar2.aZM = aiVar2.aZM ? false : true;
                    this.aZe.m(D, aiVar2.aZM);
                    return;
                }
                a(dVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String t;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                if (this.mUserType != 4 && (msg2 = this.mListModel.getMsg(i2)) != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), new StringBuilder(String.valueOf(msg2.getUserInfo().getUserIdLong())).toString(), ForumDetailActivityConfig.FromType.BAR)));
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (t = com.baidu.tieba.im.util.i.t(msg.getContent(), true)) != null && (this.mListModel instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.mListModel).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), t, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.d dVar) {
        if (dVar.PO() == 2) {
            this.aZe.ct(true);
            this.aZf.sendClickMenuMessage(dVar.getId(), TbadkApplication.getCurrentAccount(), this.aZf.getForumId());
        } else if (dVar.PO() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), dVar.getContent(), dVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.e
    public void a(int i, com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            a(dVar);
            this.aZe.Oo().TS();
            ai aiVar = this.aZe.Op()[i];
            aiVar.aZM = false;
            this.aZe.m(i, aiVar.aZM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        this.mUserType = intent.getIntExtra(OfficalBarChatActivityConfig.USER_TYPE, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        com.baidu.tieba.im.d.a.TF().TG();
    }

    private void initCurId() {
        if (this.mListModel == null || !(this.mListModel instanceof OfficialBarMsglistModel)) {
            ChatStatusManager.getInst().setCurId(1, "");
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.mListModel).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(1, "");
        }
    }
}
