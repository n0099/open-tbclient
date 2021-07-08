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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.o0.z0.n;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMenuShow;
    public OfficialBarMsglistModel mCurrentMsgListModel;
    public OfficialBarMsglistView mCurrentMsgListView;
    public final CustomMessageListener mGetMenuLocalListener;
    public final d.a.c.c.g.c mGetMenuNetLstener;
    public final d.a.c.c.g.c mMenuClickLstener;
    public int mUserType;

    /* loaded from: classes4.dex */
    public class a implements AbsMsglistView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17360a;

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
            this.f17360a = officialBarChatActivity;
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
            this.f17360a.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f17361a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17362b;

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
            this.f17362b = officialBarChatActivity;
            this.f17361a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.p0.i1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.f17361a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f17363a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17364b;

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
            this.f17364b = officialBarChatActivity;
            this.f17363a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.o0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.p0.i1.t.d.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f17363a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17365a;

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
            this.f17365a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.f17365a.mListView.closeNotNotify();
            } else {
                this.f17365a.mListView.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17366a;

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
            this.f17366a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f17366a.mCurrentMsgListView.s(false);
                if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                    this.f17366a.showToast(R.string.neterror);
                    return;
                }
                ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
                if (responseOfficialBarMenuMessage.hasError()) {
                    if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                        this.f17366a.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.f17366a.getResources().getString(R.string.neterror) : responseOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.f17366a.showToast(R.string.neterror);
                    }
                    d.a.p0.i1.g.c officialBarMenuDatas = this.f17366a.mCurrentMsgListModel.getOfficialBarMenuDatas();
                    if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                        this.f17366a.mCurrentMsgListView.q(true, true);
                        return;
                    }
                    return;
                }
                d.a.p0.i1.g.c officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
                if (officialBarMenuDatas2 != null) {
                    if (officialBarMenuDatas2.c()) {
                        this.f17366a.mCurrentMsgListView.q(false, false);
                        if (officialBarMenuDatas2.a() == null || officialBarMenuDatas2.a().size() <= 0) {
                            return;
                        }
                        this.f17366a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        this.f17366a.mCurrentMsgListView.r(officialBarMenuDatas2.a());
                        return;
                    }
                    this.f17366a.mCurrentMsgListView.q(true, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17367a;

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
            this.f17367a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f17367a.mCurrentMsgListView.s(false);
                if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                    this.f17367a.showToast(R.string.neterror);
                    return;
                }
                ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
                if (responseSendOfficialBarMenuMessage.hasError()) {
                    if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                        this.f17367a.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? this.f17367a.getResources().getString(R.string.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.f17367a.showToast(R.string.neterror);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarChatActivity f17368a;

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
            this.f17368a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
                    d.a.p0.i1.g.c officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                    if (officialBarMenuDatas != null) {
                        this.f17368a.mCurrentMsgListView.q(false, false);
                        this.f17368a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas);
                        this.f17368a.mCurrentMsgListModel.sendGetMenuNetMessage(this.f17368a.mCurrentMsgListModel.getForumId(), officialBarMenuDatas.b());
                        this.f17368a.mCurrentMsgListView.r(officialBarMenuDatas.a());
                        return;
                    }
                    this.f17368a.mCurrentMsgListView.q(true, false);
                    this.f17368a.mCurrentMsgListModel.sendGetMenuNetMessage(this.f17368a.mCurrentMsgListModel.getForumId(), 0L);
                    return;
                }
                this.f17368a.showToast(R.string.neterror);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, view)) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        }
        return (Rect) invokeL.objValue;
    }

    private void handleMenuAction(d.a.p0.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bVar) == null) {
            if (bVar.a() == 2) {
                this.mCurrentMsgListView.s(true);
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
                OfficialSecondMenuPopupWindow n = this.mCurrentMsgListView.n();
                if (n.isShown() && !getViewRangerInWindow(n).contains(rawX, rawY)) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.m()[i2];
                        if (dVar.f17409a) {
                            this.mCurrentMsgListView.n().g();
                            dVar.f17409a = false;
                            this.mCurrentMsgListView.u(i2, false);
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
    public boolean first(d.a.p0.i1.f.c cVar) {
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
                officialBarMsglistView2.p(R.string.more);
                this.mCurrentMsgListView.closeNotNotify();
                this.mCurrentMsgListView.closeReceiver();
                this.mCurrentMsgListView.o();
            }
            if (this.mUserType == 3) {
                this.mCurrentMsgListView.o();
            }
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            long longValue = d.a.p0.i1.s.a.f58618i.longValue();
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
        List<d.a.p0.i1.g.b> a2;
        d.a.p0.i1.g.b bVar;
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
            } else if (view == this.mCurrentMsgListView.m()[0].f17410b || view == this.mCurrentMsgListView.m()[1].f17410b || view == this.mCurrentMsgListView.m()[2].f17410b) {
                TiebaStatic.log("service_bt_ck");
                int l = this.mCurrentMsgListView.l(view);
                for (int i2 = 0; i2 < 3; i2++) {
                    OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.m()[i2];
                    if (dVar.f17409a && i2 != l) {
                        this.mCurrentMsgListView.n().h();
                        dVar.f17409a = false;
                        this.mCurrentMsgListView.u(i2, false);
                    }
                }
                d.a.p0.i1.g.c officialBarMenuDatas = this.mCurrentMsgListModel.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || (a2 = officialBarMenuDatas.a()) == null || l >= a2.size() || (bVar = a2.get(l)) == null) {
                    return;
                }
                if (bVar.a() == 0) {
                    OfficialBarMsglistView.d dVar2 = this.mCurrentMsgListView.m()[l];
                    OfficialSecondMenuPopupWindow n = this.mCurrentMsgListView.n();
                    if (dVar2.f17409a) {
                        n.g();
                    } else {
                        n.setData(3, l, bVar.e());
                        n.i(view);
                    }
                    boolean z = !dVar2.f17409a;
                    dVar2.f17409a = z;
                    this.mCurrentMsgListView.u(l, z);
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
                this.mCurrentMsgListView.s(true);
                OfficialBarMsglistModel officialBarMsglistModel = this.mCurrentMsgListModel;
                officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
            }
            d.a.p0.i1.u.a.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(1, "");
            d.a.p0.i1.u.a.c().f();
            d.a.p0.i1.u.a.c().b();
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
    public void onItemClick(int i2, d.a.p0.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, bVar) == null) || bVar == null) {
            return;
        }
        handleMenuAction(bVar);
        this.mCurrentMsgListView.n().g();
        this.mCurrentMsgListView.m()[i2].f17409a = false;
        this.mCurrentMsgListView.u(i2, false);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, d.a.c.e.h.a
    public void onItemViewClick(View view, int i2, int i3, long j) {
        ChatMessage msg;
        ChatMessage msg2;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            super.onItemViewClick(view, i2, i3, j);
            if (i2 != 2) {
                if (i2 == 4 && isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && d.a.p0.i1.w.c.s(msg2) && (f2 = d.a.p0.i1.w.c.f(msg2.getContent(), true)) != null) {
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

    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.a.o0.b1.m.h
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
            d.a.o0.s.d.b.g0().r(19);
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
            i0.c(new c(this, user), new d(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, userData) == null) {
            i0.c(new b(this, userData), null);
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
