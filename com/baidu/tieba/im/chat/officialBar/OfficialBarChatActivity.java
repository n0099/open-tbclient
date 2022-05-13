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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a97;
import com.repackage.b47;
import com.repackage.c87;
import com.repackage.ky4;
import com.repackage.l77;
import com.repackage.m57;
import com.repackage.n57;
import com.repackage.s77;
import com.repackage.sd5;
import com.repackage.vd5;
import com.repackage.ya;
import com.repackage.zc5;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMenuShow;
    public OfficialBarMsglistModel mCurrentMsgListModel;
    public OfficialBarMsglistView mCurrentMsgListView;
    public final CustomMessageListener mGetMenuLocalListener;
    public final ya mGetMenuNetLstener;
    public final ya mMenuClickLstener;
    public int mUserType;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
                return;
            }
            this.a.mListModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends sd5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ OfficialBarChatActivity b;

        public b(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = officialBarChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sd5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s77.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends sd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ OfficialBarChatActivity b;

        public c(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = officialBarChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.sd5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(s77.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements zc5<Boolean> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
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

    /* loaded from: classes3.dex */
    public class e extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(OfficialBarChatActivity officialBarChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.mCurrentMsgListView.u(false);
                if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
                if (responseOfficialBarMenuMessage.hasError()) {
                    if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : responseOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    }
                    n57 officialBarMenuDatas = this.a.mCurrentMsgListModel.getOfficialBarMenuDatas();
                    if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                        this.a.mCurrentMsgListView.s(true, true);
                        return;
                    }
                    return;
                }
                n57 officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
                if (officialBarMenuDatas2 != null) {
                    if (officialBarMenuDatas2.c()) {
                        this.a.mCurrentMsgListView.s(false, false);
                        if (officialBarMenuDatas2.a() == null || officialBarMenuDatas2.a().size() <= 0) {
                            return;
                        }
                        this.a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        this.a.mCurrentMsgListView.t(officialBarMenuDatas2.a());
                        return;
                    }
                    this.a.mCurrentMsgListView.s(true, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(OfficialBarChatActivity officialBarChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.mCurrentMsgListView.u(false);
                if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
                if (responseSendOfficialBarMenuMessage.hasError()) {
                    if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : responseSendOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(OfficialBarChatActivity officialBarChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    n57 officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                    if (officialBarMenuDatas != null) {
                        this.a.mCurrentMsgListView.s(false, false);
                        this.a.mCurrentMsgListModel.setOfficialBarMenuDatas(officialBarMenuDatas);
                        this.a.mCurrentMsgListModel.sendGetMenuNetMessage(this.a.mCurrentMsgListModel.getForumId(), officialBarMenuDatas.b());
                        this.a.mCurrentMsgListView.t(officialBarMenuDatas.a());
                        return;
                    }
                    this.a.mCurrentMsgListView.s(true, false);
                    this.a.mCurrentMsgListModel.sendGetMenuNetMessage(this.a.mCurrentMsgListModel.getForumId(), 0L);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
            }
        }
    }

    public OfficialBarChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGetMenuNetLstener = new e(this, 303006);
        this.mMenuClickLstener = new f(this, 208003);
        this.mGetMenuLocalListener = new g(this, 2001177);
    }

    private Rect getViewRangerInWindow(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, view2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        }
        return (Rect) invokeL.objValue;
    }

    private void handleMenuAction(m57 m57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, m57Var) == null) {
            if (m57Var.a() == 2) {
                this.mCurrentMsgListView.u(true);
                this.mCurrentMsgListModel.sendClickMenuMessage(m57Var.c(), TbadkCoreApplication.getCurrentAccount(), this.mCurrentMsgListModel.getForumId());
            } else if (m57Var.a() == 1) {
                UtilHelper.commenDealUrl(getPageContext().getPageActivity(), m57Var.b(), m57Var.d());
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
                OfficialSecondMenuPopupWindow o = this.mCurrentMsgListView.o();
                if (o.isShown() && !getViewRangerInWindow(o).contains(rawX, rawY)) {
                    for (int i = 0; i < 3; i++) {
                        OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.n()[i];
                        if (dVar.a) {
                            this.mCurrentMsgListView.o().g();
                            dVar.a = false;
                            this.mCurrentMsgListView.w(i, false);
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
    public boolean first(b47 b47Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b47Var)) == null) {
            this.mListModel.loadFirst(b47Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            OfficialBarMsglistView officialBarMsglistView = new OfficialBarMsglistView(this, this.mListModel.getIsAcceptNotify());
            this.mListView = officialBarMsglistView;
            OfficialBarMsglistView officialBarMsglistView2 = officialBarMsglistView;
            this.mCurrentMsgListView = officialBarMsglistView2;
            if (this.mUserType == 4) {
                officialBarMsglistView2.r(R.string.obfuscated_res_0x7f0f0ad9);
                this.mCurrentMsgListView.closeNotNotify();
                this.mCurrentMsgListView.closeReceiver();
                this.mCurrentMsgListView.q();
            }
            if (this.mUserType == 3) {
                this.mCurrentMsgListView.q();
            }
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            long longValue = l77.i.longValue();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
                String userName = !TextUtils.isEmpty(user.getUserName()) ? user.getUserName() : "";
                if (this.mUserType == 4) {
                    this.mListView.refreshHeaderFooter(userName, false);
                } else {
                    AbsMsglistView absMsglistView = this.mListView;
                    absMsglistView.refreshHeaderFooter(userName + getPageContext().getString(R.string.obfuscated_res_0x7f0f064b), false);
                }
                this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
                this.mListView.setRecordCallback(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        List<m57> a2;
        m57 m57Var;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mListView.getBtnGroupInfo()) {
                MsglistModel msglistModel = this.mListModel;
                if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
                    if (this.mUserType == 4) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong(), user.getPortrait())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            } else if (view2 == this.mCurrentMsgListView.n()[0].b || view2 == this.mCurrentMsgListView.n()[1].b || view2 == this.mCurrentMsgListView.n()[2].b) {
                TiebaStatic.log("service_bt_ck");
                int m = this.mCurrentMsgListView.m(view2);
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.d dVar = this.mCurrentMsgListView.n()[i];
                    if (dVar.a && i != m) {
                        this.mCurrentMsgListView.o().h();
                        dVar.a = false;
                        this.mCurrentMsgListView.w(i, false);
                    }
                }
                n57 officialBarMenuDatas = this.mCurrentMsgListModel.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || (a2 = officialBarMenuDatas.a()) == null || m >= a2.size() || (m57Var = a2.get(m)) == null) {
                    return;
                }
                if (m57Var.a() == 0) {
                    OfficialBarMsglistView.d dVar2 = this.mCurrentMsgListView.n()[m];
                    OfficialSecondMenuPopupWindow o = this.mCurrentMsgListView.o();
                    if (dVar2.a) {
                        o.g();
                    } else {
                        o.setData(3, m, m57Var.e());
                        o.i(view2);
                    }
                    boolean z = !dVar2.a;
                    dVar2.a = z;
                    this.mCurrentMsgListView.w(m, z);
                    return;
                }
                handleMenuAction(m57Var);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mUserType == 1) {
                this.mCurrentMsgListView.u(true);
                OfficialBarMsglistModel officialBarMsglistModel = this.mCurrentMsgListModel;
                officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
            }
            c87.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(1, "");
            c87.c().f();
            c87.c().b();
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
    public void onItemClick(int i, m57 m57Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i, m57Var) == null) || m57Var == null) {
            return;
        }
        handleMenuAction(m57Var);
        this.mCurrentMsgListView.o().g();
        this.mCurrentMsgListView.n()[i].a = false;
        this.mCurrentMsgListView.w(i, false);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.repackage.ef
    public void onItemViewClick(View view2, int i, int i2, long j) {
        ChatMessage msg;
        ChatMessage msg2;
        String h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.onItemViewClick(view2, i, i2, j);
            if (i != 2) {
                if (i == 4 && isExStorageOk() && (msg2 = this.mListModel.getMsg(i2)) != null && a97.w(msg2) && (h = a97.h(msg2.getContent(), true)) != null) {
                    MsglistModel msglistModel = this.mListModel;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), h, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (this.mUserType == 4 || (msg = this.mListModel.getMsg(i2)) == null || msg.getUserInfo() == null) {
            } else {
                UserData userInfo = msg.getUserInfo();
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = getPageContext().getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, userInfo.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.bg5
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
            boolean z = true;
            ChatStatusManager.getInst().setIsOpen(1, true);
            String curId = ChatStatusManager.getInst().getCurId(1);
            if (!TextUtils.isEmpty(curId)) {
                ky4.h0().r(19);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
            }
            OfficialSettingItemData a2 = s77.j().a(TbadkCoreApplication.getCurrentAccount(), curId);
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null) {
                if (a2 != null && !a2.isAcceptNotify()) {
                    z = false;
                }
                msglistModel.setIsAcceptNotify(z);
            }
            if (this.mListView != null) {
                if (a2 != null && !a2.isAcceptNotify()) {
                    this.mListView.showNotNotfiy();
                } else {
                    this.mListView.closeNotNotify();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.mUserType == 4) {
            return;
        }
        super.refreshHeadIcon();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
            vd5.c(new c(this, user), new d(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, userData) == null) {
            vd5.c(new b(this, userData), null);
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
