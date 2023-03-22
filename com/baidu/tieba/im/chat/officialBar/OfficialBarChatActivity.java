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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.aq5;
import com.baidu.tieba.ar7;
import com.baidu.tieba.bb;
import com.baidu.tieba.hs7;
import com.baidu.tieba.i85;
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
import com.baidu.tieba.mn7;
import com.baidu.tieba.nr7;
import com.baidu.tieba.sq7;
import com.baidu.tieba.wo7;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xo7;
import com.baidu.tieba.zo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity<OfficialBarChatActivity> implements OfficialSecondMenuPopupWindow.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public OfficialBarMsglistView v;
    public OfficialBarMsglistModel w;
    public int x;
    public final bb y;
    public final bb z;

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.yt5
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AbsMsglistView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarChatActivity a;

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null) {
                this.a.c.sendMsgVoice(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends wp5<Void> {
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
        @Override // com.baidu.tieba.wp5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ar7.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends wp5<Boolean> {
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
        @Override // com.baidu.tieba.wp5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(ar7.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId())));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements zo5<Boolean> {
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
        @Override // com.baidu.tieba.zo5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bool) != null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.b.closeNotNotify();
            } else {
                this.a.b.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.v.A(false);
                if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    return;
                }
                ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
                if (responseOfficialBarMenuMessage.hasError()) {
                    if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                        if (StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1f);
                        } else {
                            errorString = responseOfficialBarMenuMessage.getErrorString();
                        }
                        this.a.showToast(errorString);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    }
                    xo7 officialBarMenuDatas = this.a.w.getOfficialBarMenuDatas();
                    if (officialBarMenuDatas == null || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() == 0) {
                        this.a.v.y(true, true);
                        return;
                    }
                    return;
                }
                xo7 officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
                if (officialBarMenuDatas2 != null) {
                    if (officialBarMenuDatas2.c()) {
                        this.a.v.y(false, false);
                        if (officialBarMenuDatas2.a() != null && officialBarMenuDatas2.a().size() > 0) {
                            this.a.w.setOfficialBarMenuDatas(officialBarMenuDatas2);
                            this.a.v.z(officialBarMenuDatas2.a());
                            return;
                        }
                        return;
                    }
                    this.a.v.y(true, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.v.A(false);
                if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    return;
                }
                ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
                if (responseSendOfficialBarMenuMessage.hasError()) {
                    if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                        if (StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1f);
                        } else {
                            errorString = responseSendOfficialBarMenuMessage.getErrorString();
                        }
                        this.a.showToast(errorString);
                        return;
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    xo7 officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
                    if (officialBarMenuDatas != null) {
                        this.a.v.y(false, false);
                        this.a.w.setOfficialBarMenuDatas(officialBarMenuDatas);
                        this.a.w.sendGetMenuNetMessage(this.a.w.getForumId(), officialBarMenuDatas.b());
                        this.a.v.z(officialBarMenuDatas.a());
                        return;
                    }
                    this.a.v.y(true, false);
                    this.a.w.sendGetMenuNetMessage(this.a.w.getForumId(), 0L);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
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
    public void X1() {
        UserData user;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.x == 4) {
            return;
        }
        super.X1();
        MsglistModel msglistModel = this.c;
        if (!(msglistModel instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) == null) {
            return;
        }
        aq5.c(new c(this, user), new d(this));
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean S1(mn7 mn7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mn7Var)) == null) {
            this.c.loadFirst(mn7Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void d2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.d2(intent);
            n2();
            this.x = intent.getIntExtra("user_type", 1);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void e2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.e2(bundle);
            n2();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void f2(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userData) == null) {
            aq5.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.x == 1) {
                this.v.A(true);
                OfficialBarMsglistModel officialBarMsglistModel = this.w;
                officialBarMsglistModel.sendGetMenuLocalMessage(officialBarMsglistModel.getForumId());
            }
            nr7.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.af
    public void C(View view2, int i, int i2, long j) {
        ChatMessage msg;
        ChatMessage msg2;
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.C(view2, i, i2, j);
            if (i != 2) {
                if (i != 4 || !G1() || (msg2 = this.c.getMsg(i2)) == null || !hs7.z(msg2) || (j2 = hs7.j(msg2.getContent(), true)) == null) {
                    return;
                }
                MsglistModel msglistModel = this.c;
                if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new OfficialMsgImageActivityConfig(getPageContext().getPageActivity(), j2, ((CommonPersonalMsglistModel) this.c).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
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
    public boolean T1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            try {
                OfficialBarMsglistModel officialBarMsglistModel = new OfficialBarMsglistModel(this);
                this.c = officialBarMsglistModel;
                officialBarMsglistModel.setLoadDataCallBack(this.r);
                this.w = (OfficialBarMsglistModel) this.c;
                if (bundle != null) {
                    c2(bundle);
                } else {
                    b2();
                }
                this.w.setUserType(this.x);
                if (!a2()) {
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

    public final void m2(wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wo7Var) == null) {
            if (wo7Var.a() == 2) {
                this.v.A(true);
                this.w.sendClickMenuMessage(wo7Var.c(), TbadkCoreApplication.getCurrentAccount(), this.w.getForumId());
            } else if (wo7Var.a() == 1) {
                UtilHelper.commenDealUrl(getPageContext().getPageActivity(), wo7Var.b(), wo7Var.d());
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (l2(this.v.getListMain()).contains(rawX, rawY)) {
                OfficialSecondMenuPopupWindow t = this.v.t();
                if (t.isShown() && !l2(t).contains(rawX, rawY)) {
                    for (int i = 0; i < 3; i++) {
                        OfficialBarMsglistView.d dVar = this.v.s()[i];
                        if (dVar.a) {
                            this.v.t().g();
                            dVar.a = false;
                            this.v.C(i, false);
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
    public void initView() {
        UserData user;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            OfficialBarMsglistView officialBarMsglistView = new OfficialBarMsglistView(this, this.c.getIsAcceptNotify());
            this.b = officialBarMsglistView;
            OfficialBarMsglistView officialBarMsglistView2 = officialBarMsglistView;
            this.v = officialBarMsglistView2;
            if (this.x == 4) {
                officialBarMsglistView2.x(R.string.obfuscated_res_0x7f0f0bb0);
                this.v.closeNotNotify();
                this.v.closeReceiver();
                this.v.u();
            }
            if (this.x == 3) {
                this.v.u();
            }
            this.b.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            long longValue = sq7.j.longValue();
            MsglistModel msglistModel = this.c;
            if (!(msglistModel instanceof OfficialBarMsglistModel) || (user = ((OfficialBarMsglistModel) msglistModel).getUser()) == null) {
                return;
            }
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            } else {
                str = "";
            }
            if (this.x == 4) {
                this.b.refreshHeaderFooter(str, false);
            } else {
                AbsMsglistView absMsglistView = this.b;
                absMsglistView.refreshHeaderFooter(str + getPageContext().getString(R.string.obfuscated_res_0x7f0f06bd), false);
            }
            this.b.bindDataAndRefresh(this.c.getData(), longValue);
            this.b.setRecordCallback(new a(this));
        }
    }

    public final Rect l2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        }
        return (Rect) invokeL.objValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        List<wo7> a2;
        wo7 wo7Var;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.getBtnGroupInfo()) {
                MsglistModel msglistModel = this.c;
                if (!(msglistModel instanceof OfficialBarMsglistModel) || (user = ((OfficialBarMsglistModel) msglistModel).getUser()) == null) {
                    return;
                }
                if (this.x == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong(), user.getPortrait())));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong() + "", ForumDetailActivityConfig.FromType.BAR)));
            } else if (view2 == this.v.s()[0].b || view2 == this.v.s()[1].b || view2 == this.v.s()[2].b) {
                TiebaStatic.log("service_bt_ck");
                int r = this.v.r(view2);
                for (int i = 0; i < 3; i++) {
                    OfficialBarMsglistView.d dVar = this.v.s()[i];
                    if (dVar.a && i != r) {
                        this.v.t().h();
                        dVar.a = false;
                        this.v.C(i, false);
                    }
                }
                xo7 officialBarMenuDatas = this.w.getOfficialBarMenuDatas();
                if (officialBarMenuDatas != null && (a2 = officialBarMenuDatas.a()) != null && r < a2.size() && (wo7Var = a2.get(r)) != null) {
                    if (wo7Var.a() == 0) {
                        OfficialBarMsglistView.d dVar2 = this.v.s()[r];
                        OfficialSecondMenuPopupWindow t = this.v.t();
                        if (dVar2.a) {
                            t.g();
                        } else {
                            t.setData(3, r, wo7Var.e());
                            t.i(view2);
                        }
                        boolean z = !dVar2.a;
                        dVar2.a = z;
                        this.v.C(r, z);
                        return;
                    }
                    m2(wo7Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(1, "");
            nr7.c().g();
            nr7.c().b();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(1, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            boolean z = true;
            ChatStatusManager.getInst().setIsOpen(1, true);
            String curId = ChatStatusManager.getInst().getCurId(1);
            if (!TextUtils.isEmpty(curId)) {
                i85.h0().q(19);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 4)));
            }
            OfficialSettingItemData a2 = ar7.j().a(TbadkCoreApplication.getCurrentAccount(), curId);
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
            if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(curId)) {
                CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_SHOW, null, null);
            }
        }
    }

    @Override // com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.c
    public void s0(int i, wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048594, this, i, wo7Var) != null) || wo7Var == null) {
            return;
        }
        m2(wo7Var);
        this.v.t().g();
        this.v.s()[i].a = false;
        this.v.C(i, false);
    }
}
