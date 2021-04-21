package com.baidu.tieba.im.chat.officialBar;

import android.app.Activity;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public boolean isMenuShow;
    public OfficialBarMsglistModel mCurrentMsgListModel;
    public OfficialBarMsglistView mCurrentMsgListView;
    public int mUserType;
    public final d.b.c.c.g.c mGetMenuNetLstener = new e(303006);
    public final d.b.c.c.g.c mMenuClickLstener = new f(208003);
    public final CustomMessageListener mGetMenuLocalListener = new g(2001177);

    /* loaded from: classes4.dex */
    public class a implements AbsMsglistView.f {
        public a() {
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a(VoiceData$VoiceModel voiceData$VoiceModel) {
            if (voiceData$VoiceModel != null) {
                OfficialBarChatActivity.this.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f17500a;

        public b(UserData userData) {
            this.f17500a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.j0.e1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.f17500a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f17502a;

        public c(UserData userData) {
            this.f17502a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.j0.e1.t.d.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f17502a.getUserId())));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                OfficialBarChatActivity.this.mListView.closeNotNotify();
            } else {
                OfficialBarChatActivity.this.mListView.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.b.c.c.g.c {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.mCurrentMsgListView.u(false);
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
                d.b.j0.e1.g.c officialBarMenuDatas = OfficialBarChatActivity.this.mCurrentMsgListModel.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                    OfficialBarChatActivity.this.mCurrentMsgListView.r(true, true);
                    return;
                }
                return;
            }
            d.b.j0.e1.g.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
            if (officialBarMenuDatas2 != null) {
                if (officialBarMenuDatas2.c()) {
                    OfficialBarChatActivity.this.mCurrentMsgListView.r(false, false);
                    if (officialBarMenuDatas2.a() == null || officialBarMenuDatas2.a().size() <= 0) {
                        return;
                    }
                    OfficialBarChatActivity.this.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    OfficialBarChatActivity.this.mCurrentMsgListView.s(officialBarMenuDatas2.a());
                    return;
                }
                OfficialBarChatActivity.this.mCurrentMsgListView.r(true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.b.c.c.g.c {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarChatActivity.this.mCurrentMsgListView.u(false);
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
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                d.b.j0.e1.g.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                if (officialBarMenuDatas != null) {
                    OfficialBarChatActivity.this.mCurrentMsgListView.r(false, false);
                    OfficialBarChatActivity.this.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas);
                    OfficialBarChatActivity.this.mCurrentMsgListModel.sendGetMenuNetMessage(OfficialBarChatActivity.this.mCurrentMsgListModel.getForumId(), officialBarMenuDatas.b());
                    OfficialBarChatActivity.this.mCurrentMsgListView.s(officialBarMenuDatas.a());
                    return;
                }
                OfficialBarChatActivity.this.mCurrentMsgListView.r(true, false);
                OfficialBarChatActivity.this.mCurrentMsgListModel.sendGetMenuNetMessage(OfficialBarChatActivity.this.mCurrentMsgListModel.getForumId(), 0L);
                return;
            }
            OfficialBarChatActivity.this.showToast(R.string.neterror);
        }
    }

    private Rect getViewRangerInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    private void handleMenuAction(d.b.j0.e1.g.b bVar) {
        if (bVar.a() == 2) {
            this.mCurrentMsgListView.u(true);
            this.mCurrentMsgListModel.sendClickMenuMessage(bVar.c(), TbadkCoreApplication.getCurrentAccount(), this.mCurrentMsgListModel.getForumId());
        } else if (bVar.a() == 1) {
            UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.b(), bVar.d());
        }
    }

    private void initCurId() {
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null && (msglistModel instanceof OfficialBarMsglistModel)) {
            UserData user = ((OfficialBarMsglistModel) msglistModel).getUser();
            if (user != null) {
                ChatStatusManager.getInst().setCurId(1, String.valueOf(user.getUserId()));
                return;
            } else {
                ChatStatusManager.getInst().setCurId(1, "");
                return;
            }
        }
        ChatStatusManager.getInst().setCurId(1, "");
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (getViewRangerInWindow(this.mCurrentMsgListView.getListMain()).contains(rawX, rawY)) {
            OfficialSecondMenuPopupWindow n = this.mCurrentMsgListView.n();
            if (n.isShown() && !getViewRangerInWindow(n).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.m()[i];
                    if (dVar.f17544a) {
                        this.mCurrentMsgListView.n().g();
                        dVar.f17544a = false;
                        this.mCurrentMsgListView.w(i, false);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(d.b.j0.e1.f.c cVar) {
        this.mListModel.loadFirst(cVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        try {
            OfficialBarMsglistModel officialBarMsglistModel = new OfficialBarMsglistModel(this);
            this.mListModel = officialBarMsglistModel;
            officialBarMsglistModel.setLoadDataCallBack(this.mMsgCallback);
            this.mCurrentMsgListModel = (OfficialBarMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            this.mCurrentMsgListModel.setUserType(this.mUserType);
            if (!checkParam()) {
                return false;
            }
            this.isMenuShow = true;
            registerListener(this.mGetMenuNetLstener);
            registerListener(this.mMenuClickLstener);
            registerListener(this.mGetMenuLocalListener);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        OfficialBarMsglistView officialBarMsglistView = new OfficialBarMsglistView(this, this.mListModel.getIsAcceptNotify());
        this.mListView = officialBarMsglistView;
        OfficialBarMsglistView officialBarMsglistView2 = officialBarMsglistView;
        this.mCurrentMsgListView = officialBarMsglistView2;
        if (this.mUserType == 4) {
            officialBarMsglistView2.q(R.string.more);
            this.mCurrentMsgListView.closeNotNotify();
            this.mCurrentMsgListView.closeReceiver();
            this.mCurrentMsgListView.o();
        }
        if (this.mUserType == 3) {
            this.mCurrentMsgListView.o();
        }
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        long longValue = d.b.j0.e1.s.a.i.longValue();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
            String userName = !TextUtils.isEmpty(user.getUserName()) ? user.getUserName() : "";
            if (this.mUserType == 4) {
                this.mListView.refreshHeaderFooter(userName, false);
            } else {
                AbsMsglistView absMsglistView = this.mListView;
                absMsglistView.refreshHeaderFooter(userName + getPageContext().getString(R.string.forum), false);
            }
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
            this.mListView.setRecordCallback(new a());
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<d.b.j0.e1.g.b> a2;
        d.b.j0.e1.g.b bVar;
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
                if (this.mUserType == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
            }
        } else if (view == this.mCurrentMsgListView.m()[0].f17545b || view == this.mCurrentMsgListView.m()[1].f17545b || view == this.mCurrentMsgListView.m()[2].f17545b) {
            TiebaStatic.log("service_bt_ck");
            int l = this.mCurrentMsgListView.l(view);
            for (int i = 0; i < 3; i++) {
                OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.m()[i];
                if (dVar.f17544a && i != l) {
                    this.mCurrentMsgListView.n().h();
                    dVar.f17544a = false;
                    this.mCurrentMsgListView.w(i, false);
                }
            }
            d.b.j0.e1.g.c officialBarMenuDatas = this.mCurrentMsgListModel.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || (a2 = officialBarMenuDatas.a()) == null || l >= a2.size() || (bVar = a2.get(l)) == null) {
                return;
            }
            if (bVar.a() == 0) {
                OfficialBarMsglistView.d dVar2 = this.mCurrentMsgListView.m()[l];
                OfficialSecondMenuPopupWindow n = this.mCurrentMsgListView.n();
                if (dVar2.f17544a) {
                    n.g();
                } else {
                    n.setData(3, l, bVar.e());
                    n.i(view);
                }
                boolean z = !dVar2.f17544a;
                dVar2.f17544a = z;
                this.mCurrentMsgListView.w(l, z);
                return;
            }
            handleMenuAction(bVar);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUserType == 1) {
            this.mCurrentMsgListView.u(true);
            OfficialBarMsglistModel officialBarMsglistModel = this.mCurrentMsgListModel;
            officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
        }
        d.b.j0.e1.u.a.c().b();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(1, "");
        d.b.j0.e1.u.a.c().f();
        d.b.j0.e1.u.a.c().b();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.c
    public void onItemClick(int i, d.b.j0.e1.g.b bVar) {
        if (bVar == null) {
            return;
        }
        handleMenuAction(bVar);
        this.mCurrentMsgListView.n().g();
        this.mCurrentMsgListView.m()[i].f17544a = false;
        this.mCurrentMsgListView.w(i, false);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, d.b.c.e.h.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        ChatMessage msg2;
        String f2;
        super.onItemViewClick(view, i, i2, j);
        if (i != 2) {
            if (i == 4 && isExStorageOk() && (msg2 = this.mListModel.getMsg(i2)) != null && d.b.j0.e1.w.c.s(msg2) && (f2 = d.b.j0.e1.w.c.f(msg2.getContent(), true)) != null) {
                MsglistModel msglistModel = this.mListModel;
                if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), f2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
            }
        } else if (this.mUserType == 4 || (msg = this.mListModel.getMsg(i2)) == null || msg.getUserInfo() == null) {
        } else {
            UserData userInfo = msg.getUserInfo();
            MessageManager messageManager = MessageManager.getInstance();
            Activity pageActivity = getPageContext().getPageActivity();
            messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, userInfo.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.b.i0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(1, false);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(1, true);
        String curId = ChatStatusManager.getInst().getCurId(1);
        if (TextUtils.isEmpty(curId)) {
            return;
        }
        d.b.i0.s.d.b.g0().r(19);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        if (this.mUserType == 4) {
            return;
        }
        super.refreshHeadIcon();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
            h0.c(new c(user), new d());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        h0.c(new b(userData), null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        this.mUserType = intent.getIntExtra("user_type", 1);
    }
}
