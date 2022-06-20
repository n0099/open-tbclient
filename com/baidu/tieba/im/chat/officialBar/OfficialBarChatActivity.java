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
import com.repackage.a77;
import com.repackage.ad5;
import com.repackage.bb;
import com.repackage.ed5;
import com.repackage.gc5;
import com.repackage.i87;
import com.repackage.k77;
import com.repackage.n37;
import com.repackage.px4;
import com.repackage.t67;
import com.repackage.y47;
import com.repackage.z47;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public OfficialBarMsglistView v;
    public OfficialBarMsglistModel w;
    public int x;
    public final bb y;
    public final bb z;

    /* loaded from: classes3.dex */
    public class a implements AbsMsglistView.h {
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

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.h
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
                return;
            }
            this.a.c.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ad5<Void> {
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
        @Override // com.repackage.ad5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a77.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ad5<Boolean> {
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
        @Override // com.repackage.ad5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(a77.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements gc5<Boolean> {
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
        @Override // com.repackage.gc5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.b.closeNotNotify();
            } else {
                this.a.b.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends bb {
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
                this.a.v.v(false);
                if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                    return;
                }
                ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
                if (responseOfficialBarMenuMessage.hasError()) {
                    if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37) : responseOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                    }
                    z47 officialBarMenuDatas = this.a.w.getOfficialBarMenuDatas();
                    if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                        this.a.v.t(true, true);
                        return;
                    }
                    return;
                }
                z47 officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
                if (officialBarMenuDatas2 != null) {
                    if (officialBarMenuDatas2.c()) {
                        this.a.v.t(false, false);
                        if (officialBarMenuDatas2.a() == null || officialBarMenuDatas2.a().size() <= 0) {
                            return;
                        }
                        this.a.w.setOfficialBarMenuDatas(officialBarMenuDatas2);
                        this.a.v.u(officialBarMenuDatas2.a());
                        return;
                    }
                    this.a.v.t(true, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends bb {
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
                this.a.v.v(false);
                if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                    return;
                }
                ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
                if (responseSendOfficialBarMenuMessage.hasError()) {
                    if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                        this.a.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37) : responseSendOfficialBarMenuMessage.getErrorString());
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
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
                    z47 officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                    if (officialBarMenuDatas != null) {
                        this.a.v.t(false, false);
                        this.a.w.setOfficialBarMenuDatas(officialBarMenuDatas);
                        this.a.w.sendGetMenuNetMessage(this.a.w.getForumId(), officialBarMenuDatas.b());
                        this.a.v.u(officialBarMenuDatas.a());
                        return;
                    }
                    this.a.v.t(true, false);
                    this.a.w.sendGetMenuNetMessage(this.a.w.getForumId(), 0L);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
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
        this.y = new e(this, 303006);
        this.z = new f(this, 208003);
        this.A = new g(this, 2001177);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean X0(n37 n37Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n37Var)) == null) {
            this.c.loadFirst(n37Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.sf5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean a1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            try {
                OfficialBarMsglistModel officialBarMsglistModel = new OfficialBarMsglistModel(this);
                this.c = officialBarMsglistModel;
                officialBarMsglistModel.setLoadDataCallBack(this.r);
                this.w = (OfficialBarMsglistModel) this.c;
                if (bundle != null) {
                    l1(bundle);
                } else {
                    k1();
                }
                this.w.setUserType(this.x);
                if (!j1()) {
                    return false;
                }
                registerListener(this.y);
                registerListener(this.z);
                registerListener(this.A);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (u1(this.v.getListMain()).contains(rawX, rawY)) {
                OfficialSecondMenuPopupWindow q = this.v.q();
                if (q.isShown() && !u1(q).contains(rawX, rawY)) {
                    for (int i = 0; i < 3; i++) {
                        OfficialBarMsglistView.d dVar = this.v.p()[i];
                        if (dVar.a) {
                            this.v.q().g();
                            dVar.a = false;
                            this.v.x(i, false);
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
    public void e1() {
        UserData user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.x == 4) {
            return;
        }
        super.e1();
        MsglistModel msglistModel = this.c;
        if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
            ed5.c(new c(this, user), new d(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.repackage.hf
    public void i(View view2, int i, int i2, long j) {
        ChatMessage msg;
        ChatMessage msg2;
        String h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.i(view2, i, i2, j);
            if (i != 2) {
                if (i == 4 && G0() && (msg2 = this.c.getMsg(i2)) != null && i87.w(msg2) && (h = i87.h(msg2.getContent(), true)) != null) {
                    MsglistModel msglistModel = this.c;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), h, ((CommonPersonalMsglistModel) this.c).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (this.x == 4 || (msg = this.c.getMsg(i2)) == null || msg.getUserInfo() == null) {
            } else {
                UserData userInfo = msg.getUserInfo();
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = getPageContext().getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, userInfo.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            OfficialBarMsglistView officialBarMsglistView = new OfficialBarMsglistView(this, this.c.getIsAcceptNotify());
            this.b = officialBarMsglistView;
            OfficialBarMsglistView officialBarMsglistView2 = officialBarMsglistView;
            this.v = officialBarMsglistView2;
            if (this.x == 4) {
                officialBarMsglistView2.s(R.string.obfuscated_res_0x7f0f0ae3);
                this.v.closeNotNotify();
                this.v.closeReceiver();
                this.v.r();
            }
            if (this.x == 3) {
                this.v.r();
            }
            this.b.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            long longValue = t67.j.longValue();
            MsglistModel msglistModel = this.c;
            if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
                String userName = !TextUtils.isEmpty(user.getUserName()) ? user.getUserName() : "";
                if (this.x == 4) {
                    this.b.refreshHeaderFooter(userName, false);
                } else {
                    AbsMsglistView absMsglistView = this.b;
                    absMsglistView.refreshHeaderFooter(userName + getPageContext().getString(R.string.obfuscated_res_0x7f0f0646), false);
                }
                this.b.bindDataAndRefresh(this.c.getData(), longValue);
                this.b.setRecordCallback(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void m1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.m1(intent);
            w1();
            this.x = intent.getIntExtra("user_type", 1);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void n1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.n1(bundle);
            w1();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void o1(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, userData) == null) {
            ed5.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        List<y47> a2;
        y47 y47Var;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.getBtnGroupInfo()) {
                MsglistModel msglistModel = this.c;
                if ((msglistModel instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) msglistModel).getUser()) != null) {
                    if (this.x == 4) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong(), user.getPortrait())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
                }
            } else if (view2 == this.v.p()[0].b || view2 == this.v.p()[1].b || view2 == this.v.p()[2].b) {
                TiebaStatic.log("service_bt_ck");
                int o = this.v.o(view2);
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.d dVar = this.v.p()[i];
                    if (dVar.a && i != o) {
                        this.v.q().h();
                        dVar.a = false;
                        this.v.x(i, false);
                    }
                }
                z47 officialBarMenuDatas = this.w.getOfficialBarMenuDatas();
                if (officialBarMenuDatas == null || (a2 = officialBarMenuDatas.a()) == null || o >= a2.size() || (y47Var = a2.get(o)) == null) {
                    return;
                }
                if (y47Var.a() == 0) {
                    OfficialBarMsglistView.d dVar2 = this.v.p()[o];
                    OfficialSecondMenuPopupWindow q = this.v.q();
                    if (dVar2.a) {
                        q.g();
                    } else {
                        q.setData(3, o, y47Var.e());
                        q.i(view2);
                    }
                    boolean z = !dVar2.a;
                    dVar2.a = z;
                    this.v.x(o, z);
                    return;
                }
                v1(y47Var);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.x == 1) {
                this.v.v(true);
                OfficialBarMsglistModel officialBarMsglistModel = this.w;
                officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
            }
            k77.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(1, "");
            k77.c().f();
            k77.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(1, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            boolean z = true;
            ChatStatusManager.getInst().setIsOpen(1, true);
            String curId = ChatStatusManager.getInst().getCurId(1);
            if (!TextUtils.isEmpty(curId)) {
                px4.f0().q(19);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
            }
            OfficialSettingItemData a2 = a77.j().a(TbadkCoreApplication.getCurrentAccount(), curId);
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                if (a2 != null && !a2.isAcceptNotify()) {
                    z = false;
                }
                msglistModel.setIsAcceptNotify(z);
            }
            if (this.b != null) {
                if (a2 != null && !a2.isAcceptNotify()) {
                    this.b.showNotNotfiy();
                } else {
                    this.b.closeNotNotify();
                }
            }
        }
    }

    public final Rect u1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        }
        return (Rect) invokeL.objValue;
    }

    public final void v1(y47 y47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, y47Var) == null) {
            if (y47Var.a() == 2) {
                this.v.v(true);
                this.w.sendClickMenuMessage(y47Var.c(), TbadkCoreApplication.getCurrentAccount(), this.w.getForumId());
            } else if (y47Var.a() == 1) {
                UtilHelper.commenDealUrl(getPageContext().getPageActivity(), y47Var.b(), y47Var.d());
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MsglistModel msglistModel = this.c;
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

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.c
    public void y(int i, y47 y47Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i, y47Var) == null) || y47Var == null) {
            return;
        }
        v1(y47Var);
        this.v.q().g();
        this.v.p()[i].a = false;
        this.v.x(i, false);
    }
}
