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
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.k0;
import c.a.s0.e1.n0;
import c.a.s0.e1.s;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMenuShow;
    public OfficialBarMsglistModel mCurrentMsgListModel;
    public OfficialBarMsglistView mCurrentMsgListView;
    public final CustomMessageListener mGetMenuLocalListener;
    public final c.a.d.c.g.c mGetMenuNetLstener;
    public final c.a.d.c.g.c mMenuClickLstener;
    public int mUserType;

    /* loaded from: classes12.dex */
    public class a implements AbsMsglistView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        public a(OfficialBarChatActivity officialBarChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData$VoiceModel voiceData$VoiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
                return;
            }
            this.a.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
        }
    }

    /* loaded from: classes12.dex */
    public class b extends k0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f44859b;

        public b(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44859b = officialBarChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.t0.s1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends k0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f44860b;

        public c(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44860b = officialBarChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.s0.e1.k0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.t0.s1.t.d.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d implements s<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        public d(OfficialBarChatActivity officialBarChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.s
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.mListView.closeNotNotify();
            } else {
                this.a.mListView.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(OfficialBarChatActivity officialBarChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.mCurrentMsgListView.q(false);
                if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.neterror);
                    return;
                }
                ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
                if (responseOfficialBarMenuMessage.hasError()) {
                    if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : responseOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.neterror);
                    }
                    c.a.t0.s1.g.c officialBarMenuDatas = this.a.mCurrentMsgListModel.getOfficialBarMenuDatas();
                    if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                        this.a.mCurrentMsgListView.o(true, true);
                        return;
                    }
                    return;
                }
                c.a.t0.s1.g.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
                if (officialBarMenuDatas2 != null) {
                    if (officialBarMenuDatas2.c()) {
                        this.a.mCurrentMsgListView.o(false, false);
                        if (officialBarMenuDatas2.a() == null || officialBarMenuDatas2.a().size() <= 0) {
                            return;
                        }
                        this.a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        this.a.mCurrentMsgListView.p(officialBarMenuDatas2.a());
                        return;
                    }
                    this.a.mCurrentMsgListView.o(true, true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(OfficialBarChatActivity officialBarChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.mCurrentMsgListView.q(false);
                if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.neterror);
                    return;
                }
                ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
                if (responseSendOfficialBarMenuMessage.hasError()) {
                    if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.neterror);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(OfficialBarChatActivity officialBarChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                    c.a.t0.s1.g.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                    if (officialBarMenuDatas != null) {
                        this.a.mCurrentMsgListView.o(false, false);
                        this.a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas);
                        this.a.mCurrentMsgListModel.sendGetMenuNetMessage(this.a.mCurrentMsgListModel.getForumId(), officialBarMenuDatas.b());
                        this.a.mCurrentMsgListView.p(officialBarMenuDatas.a());
                        return;
                    }
                    this.a.mCurrentMsgListView.o(true, false);
                    this.a.mCurrentMsgListModel.sendGetMenuNetMessage(this.a.mCurrentMsgListModel.getForumId(), 0L);
                    return;
                }
                this.a.showToast(R.string.neterror);
            }
        }
    }

    public OfficialBarChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGetMenuNetLstener = new e(this, 303006);
        this.mMenuClickLstener = new f(this, 208003);
        this.mGetMenuLocalListener = new g(this, 2001177);
    }

    private Rect getViewRangerInWindow(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, view)) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        }
        return (Rect) invokeL.objValue;
    }

    private void handleMenuAction(c.a.t0.s1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bVar) == null) {
            if (bVar.a() == 2) {
                this.mCurrentMsgListView.q(true);
                this.mCurrentMsgListModel.sendClickMenuMessage(bVar.c(), TbadkCoreApplication.getCurrentAccount(), this.mCurrentMsgListModel.getForumId());
            } else if (bVar.a() == 1) {
                UtilHelper.commenDealUrl(getPageContext().getPageActivity(), bVar.b(), bVar.d());
            }
        }
    }

    private void initCurId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (getViewRangerInWindow(this.mCurrentMsgListView.getListMain()).contains(rawX, rawY)) {
                OfficialSecondMenuPopupWindow l = this.mCurrentMsgListView.l();
                if (l.isShown() && !getViewRangerInWindow(l).contains(rawX, rawY)) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.k()[i2];
                        if (dVar.a) {
                            this.mCurrentMsgListView.l().hidePopupWindow();
                            dVar.a = false;
                            this.mCurrentMsgListView.s(i2, false);
                        }
                    }
                    return false;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(c.a.t0.s1.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            this.mListModel.loadFirst(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            OfficialBarMsglistView officialBarMsglistView = new OfficialBarMsglistView(this, this.mListModel.getIsAcceptNotify());
            this.mListView = officialBarMsglistView;
            OfficialBarMsglistView officialBarMsglistView2 = officialBarMsglistView;
            this.mCurrentMsgListView = officialBarMsglistView2;
            if (this.mUserType == 4) {
                officialBarMsglistView2.n(R.string.more);
                this.mCurrentMsgListView.closeNotNotify();
                this.mCurrentMsgListView.closeReceiver();
                this.mCurrentMsgListView.m();
            }
            if (this.mUserType == 3) {
                this.mCurrentMsgListView.m();
            }
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            long longValue = c.a.t0.s1.s.a.f22227i.longValue();
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
                this.mListView.setRecordCallback(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<c.a.t0.s1.g.b> a2;
        c.a.t0.s1.g.b bVar;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
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
            } else if (view == this.mCurrentMsgListView.k()[0].f44897b || view == this.mCurrentMsgListView.k()[1].f44897b || view == this.mCurrentMsgListView.k()[2].f44897b) {
                TiebaStatic.log("service_bt_ck");
                int j2 = this.mCurrentMsgListView.j(view);
                for (int i2 = 0; i2 < 3; i2++) {
                    OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.k()[i2];
                    if (dVar.a && i2 != j2) {
                        this.mCurrentMsgListView.l().hidePopupWindowNoAnimation();
                        dVar.a = false;
                        this.mCurrentMsgListView.s(i2, false);
                    }
                }
                c.a.t0.s1.g.c officialBarMenuDatas = this.mCurrentMsgListModel.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || (a2 = officialBarMenuDatas.a()) == null || j2 >= a2.size() || (bVar = a2.get(j2)) == null) {
                    return;
                }
                if (bVar.a() == 0) {
                    OfficialBarMsglistView.d dVar2 = this.mCurrentMsgListView.k()[j2];
                    OfficialSecondMenuPopupWindow l = this.mCurrentMsgListView.l();
                    if (dVar2.a) {
                        l.hidePopupWindow();
                    } else {
                        l.setData(3, j2, bVar.e());
                        l.showPopupWindow(view);
                    }
                    boolean z = !dVar2.a;
                    dVar2.a = z;
                    this.mCurrentMsgListView.s(j2, z);
                    return;
                }
                handleMenuAction(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mUserType == 1) {
                this.mCurrentMsgListView.q(true);
                OfficialBarMsglistModel officialBarMsglistModel = this.mCurrentMsgListModel;
                officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
            }
            c.a.t0.s1.u.a.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(1, "");
            c.a.t0.s1.u.a.c().f();
            c.a.t0.s1.u.a.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onInitParam(bundle);
            initCurId();
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.c
    public void onItemClick(int i2, c.a.t0.s1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, bVar) == null) || bVar == null) {
            return;
        }
        handleMenuAction(bVar);
        this.mCurrentMsgListView.l().hidePopupWindow();
        this.mCurrentMsgListView.k()[i2].a = false;
        this.mCurrentMsgListView.s(i2, false);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, c.a.d.f.h.a
    public void onItemViewClick(View view, int i2, int i3, long j2) {
        ChatMessage msg;
        ChatMessage msg2;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewClick(view, i2, i3, j2);
            if (i2 != 2) {
                if (i2 == 4 && isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && c.a.t0.s1.w.c.s(msg2) && (f2 = c.a.t0.s1.w.c.f(msg2.getContent(), true)) != null) {
                    MsglistModel msglistModel = this.mListModel;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), f2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (this.mUserType == 4 || (msg = this.mListModel.getMsg(i3)) == null || msg.getUserInfo() == null) {
            } else {
                UserData userInfo = msg.getUserInfo();
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = getPageContext().getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, userInfo.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, c.a.s0.g1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(1, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            ChatStatusManager.getInst().setIsOpen(1, true);
            String curId = ChatStatusManager.getInst().getCurId(1);
            if (TextUtils.isEmpty(curId)) {
                return;
            }
            c.a.s0.t.d.b.g0().r(19);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.mUserType == 4) {
            return;
        }
        super.refreshHeadIcon();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
            n0.c(new c(this, user), new d(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, userData) == null) {
            n0.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onInitParam(intent);
            initCurId();
            this.mUserType = intent.getIntExtra("user_type", 1);
        }
    }
}
