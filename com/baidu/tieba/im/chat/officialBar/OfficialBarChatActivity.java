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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.au;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements com.baidu.tieba.im.view.o {
    private OfficialBarMsglistView aUh;
    private OfficialBarMsglistModel aUi;
    private boolean aUj;
    private final com.baidu.adp.framework.listener.e aUk = new t(this, 303006);
    private final com.baidu.adp.framework.listener.e aUl = new u(this, 208003);
    private final CustomMessageListener aUm = new v(this, 2001181);
    private int mUserType;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.aUh.cA(true);
            this.aUi.sendGetMenuLocalMessage(this.aUi.getForumId());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            this.mListModel = new OfficialBarMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
            this.aUi = (OfficialBarMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            this.aUi.setUserType(this.mUserType);
            if (checkParam()) {
                this.aUj = true;
                registerListener(this.aUk);
                registerListener(this.aUl);
                registerListener(this.aUm);
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
        this.aUh = (OfficialBarMsglistView) this.mListView;
        if (this.mUserType == 4) {
            this.aUh.KY();
            this.aUh.closeNotNotify();
            this.aUh.closeReceiver();
            this.aUh.KZ();
        }
        if (this.mUserType == 3) {
            this.aUh.KZ();
        }
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.c.a.box;
        if ((this.mListModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.mListModel).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            if (this.mUserType == 4) {
                this.mListView.refreshHeaderFooter(str, false);
            } else {
                this.mListView.refreshHeaderFooter(String.valueOf(str) + getPageContext().getString(com.baidu.tieba.z.bar), false);
            }
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), i);
            this.mListView.setRecordCallback(new w(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean first(au auVar) {
        this.mListModel.loadFirst(auVar);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.rS().cD(com.baidu.adp.lib.g.c.toInt(curId, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (E(this.aUh.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.k KV = this.aUh.KV();
            if (KV.isShown() && !E(KV).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    ah ahVar = this.aUh.KW()[i];
                    if (ahVar.aUK) {
                        this.aUh.KV().TF();
                        ahVar.aUK = false;
                        this.aUh.p(i, ahVar.aUK);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect E(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.i.a(new x(this, userData), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        if (this.mUserType != 4) {
            super.refreshHeadIcon();
            if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
                com.baidu.tieba.im.i.a(new y(this, user), new z(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.d> MG;
        com.baidu.tieba.im.data.d dVar;
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            if ((this.mListModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.mListModel).getUser()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), new StringBuilder(String.valueOf(user.getUserIdLong())).toString(), ForumDetailActivityConfig.FromType.BAR)));
            }
        } else if (view == this.aUh.KX()) {
            this.aUj = !this.aUj;
            this.aUh.cB(this.aUj);
        } else if (view == this.aUh.KW()[0].aUL || view == this.aUh.KW()[1].aUL || view == this.aUh.KW()[2].aUL) {
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "service_bt_ck");
            int F = this.aUh.F(view);
            for (int i = 0; i < 3; i++) {
                ah ahVar = this.aUh.KW()[i];
                if (ahVar.aUK && i != F) {
                    this.aUh.KV().TG();
                    ahVar.aUK = false;
                    this.aUh.p(i, ahVar.aUK);
                }
            }
            com.baidu.tieba.im.data.e officialBarMenuDatas = this.aUi.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (MG = officialBarMenuDatas.MG()) != null && F < MG.size() && (dVar = MG.get(F)) != null) {
                if (dVar.MC() == 0) {
                    ah ahVar2 = this.aUh.KW()[F];
                    com.baidu.tieba.im.view.k KV = this.aUh.KV();
                    if (ahVar2.aUK) {
                        KV.TF();
                    } else {
                        KV.a(3, F, dVar.MD());
                        KV.J(view);
                    }
                    ahVar2.aUK = ahVar2.aUK ? false : true;
                    this.aUh.p(F, ahVar2.aUK);
                    return;
                }
                a(dVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String s;
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
                if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.o(msg) && (s = com.baidu.tieba.im.util.i.s(msg.getContent(), true)) != null && (this.mListModel instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.mListModel).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), s, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.d dVar) {
        if (dVar.MC() == 2) {
            this.aUh.cA(true);
            this.aUi.sendClickMenuMessage(dVar.getId(), TbadkApplication.getCurrentAccount(), this.aUi.getForumId());
        } else if (dVar.MC() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), dVar.getContent(), dVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.o
    public void a(int i, com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            a(dVar);
            this.aUh.KV().TF();
            ah ahVar = this.aUh.KW()[i];
            ahVar.aUK = false;
            this.aUh.p(i, ahVar.aUK);
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
