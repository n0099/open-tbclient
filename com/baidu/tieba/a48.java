package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a48 implements y38, v38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<TbPageContext<BaseFragmentActivity>> a;
    public final ResponsesPanelControllerImpl b;
    @Nullable
    public BaseMsg c;
    @Nullable
    public ChatRoomDetail d;
    public int e;
    public int f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public int n;
    public FastRequest o;
    public FastRequest p;
    @Nullable
    public w38 q;
    public final FastRequest.b<Void> r;
    public final FastRequest.b<Void> s;

    @Override // com.baidu.tieba.y38
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a48 b;

        public a(a48 a48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.k(1, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.k(1, i, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a48 b;

        public b(a48 a48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.k(2, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.k(2, i, str);
            }
        }
    }

    public a48(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull ResponsesPanelControllerImpl responsesPanelControllerImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, responsesPanelControllerImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.a = new WeakReference<>(tbPageContext);
        this.b = responsesPanelControllerImpl;
        responsesPanelControllerImpl.l(this);
    }

    @Override // com.baidu.tieba.y38
    public void c(@NonNull w38 w38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w38Var) == null) {
            this.q = w38Var;
        }
    }

    @Override // com.baidu.tieba.v38
    public void a(int i) {
        String format;
        w38 w38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            switch (i) {
                case 17:
                    ChatRoomDetail chatRoomDetail = this.d;
                    if (chatRoomDetail != null && !StringUtils.isNull(chatRoomDetail.getForbiddenContent())) {
                        format = String.format(this.d.getForbiddenContent().replaceAll("\\\\n", "\n"), this.j);
                    } else {
                        format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03d0), this.j);
                    }
                    this.b.n(format);
                    return;
                case 18:
                    s78.b("c15091", String.valueOf(this.k), this.m, this.g);
                    i(new Object[0]);
                    return;
                case 19:
                    w38 w38Var2 = this.q;
                    String str = null;
                    if (w38Var2 != null) {
                        w38Var2.a(19, this.c, null);
                    }
                    BaseMsg baseMsg = this.c;
                    if (baseMsg != null) {
                        if (baseMsg.getMsgType() == 1 || this.c.getMsgType() == 101) {
                            BaseMsg baseMsg2 = this.c;
                            if (baseMsg2 instanceof TextMsg) {
                                str = ((TextMsg) baseMsg2).getText();
                            } else if (baseMsg2 instanceof TextGenImageMsg) {
                                str = ((TextGenImageMsg) baseMsg2).getText();
                            }
                            if (!StringUtils.isNull(str)) {
                                yh.a(str);
                                this.b.o(this.a.get().getResources().getString(R.string.obfuscated_res_0x7f0f0876));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 20:
                    g(new String[0]);
                    return;
                case 21:
                    if (this.c == null) {
                        return;
                    }
                    UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getReplyPrefix());
                    spannableStringBuilder.append(this.c.getThumbnailText());
                    userReplyInfoData.setmContent(spannableStringBuilder);
                    userReplyInfoData.setmNameShow(this.c.getCommonMsgField().getUserName());
                    userReplyInfoData.setmPortrait(this.c.getCommonMsgField().getPortrait());
                    userReplyInfoData.setmUid(this.c.getCommonMsgField().getUserId());
                    userReplyInfoData.setRobot(this.c.getCommonMsgField().isRobot());
                    w38 w38Var3 = this.q;
                    if (w38Var3 != null) {
                        w38Var3.a(21, this.c, userReplyInfoData);
                        return;
                    }
                    return;
                case 22:
                default:
                    return;
                case 23:
                    BaseMsg baseMsg3 = this.c;
                    if (baseMsg3 != null && baseMsg3.getCommonMsgField().getBubbleInfo() != null) {
                        String jumpUrl = this.c.getCommonMsgField().getBubbleInfo().getJumpUrl();
                        if (!StringUtils.isNull(jumpUrl)) {
                            UrlManager.getInstance().dealOneLink(jumpUrl);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c15236").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 24:
                    ChatRoomDetail chatRoomDetail2 = this.d;
                    if (chatRoomDetail2 != null && chatRoomDetail2.getLongPressMsgBtn() != null && (w38Var = this.q) != null) {
                        w38Var.a(i, this.c, this.d.getLongPressMsgBtn().get(0));
                        return;
                    }
                    return;
                case 25:
                    s78.b("c15092", String.valueOf(this.i), this.m, this.g);
                    f(new Object[0]);
                    return;
            }
        }
    }

    @Nullable
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.d;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getLongPressMsgBtn()) && this.d.getLongPressMsgBtn().get(0) != null) {
                int skinType = TbadkApplication.getInst().getSkinType();
                AbilityItem abilityItem = this.d.getLongPressMsgBtn().get(0);
                if (skinType == 4) {
                    if (abilityItem.getStyleConf().getDark() != null) {
                        return abilityItem.getStyleConf().getDark().getIcon();
                    }
                } else if (skinType == 0 && abilityItem.getStyleConf().getDay() != null) {
                    return abilityItem.getStyleConf().getDay().getIcon();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y38
    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            HashMap hashMap = new HashMap();
            ChatRoomDetail chatRoomDetail = this.d;
            if (chatRoomDetail != null) {
                hashMap.put("is_show_reply", Boolean.valueOf(r58.n(chatRoomDetail)));
            }
            BaseMsg baseMsg = this.c;
            if (baseMsg != null && baseMsg.getCommonMsgField().getBubbleInfo() != null && !StringUtils.isNull(this.c.getCommonMsgField().getBubbleInfo().getJumpUrl())) {
                hashMap.put("is_show_bubble", Boolean.TRUE);
                TiebaStatic.log(new StatisticItem("c15235").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            ResponsesPanelControllerImpl responsesPanelControllerImpl = this.b;
            if (this.k == this.i) {
                z = true;
            } else {
                z = false;
            }
            responsesPanelControllerImpl.g(z, this.e, this.f, hashMap);
        }
    }

    @Override // com.baidu.tieba.y38
    public void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        boolean z;
        BaseMsg baseMsg2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, baseMsg, chatRoomDetail) == null) {
            this.c = baseMsg;
            this.d = chatRoomDetail;
            CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
            if (!StringUtils.isNull(commonMsgField.getUserName())) {
                this.j = commonMsgField.getUserName();
            }
            if (!StringUtils.isNull(commonMsgField.getMsgKey())) {
                this.l = commonMsgField.getMsgKey();
            }
            CharSequence thumbnailText = this.c.getThumbnailText();
            int role = commonMsgField.getRole();
            if (commonMsgField.getRobotRole() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                role = 64;
            }
            this.e = role;
            this.g = commonMsgField.getRoomId();
            this.h = commonMsgField.getMsgId();
            this.i = commonMsgField.getUserId();
            this.k = TbadkCoreApplication.getCurrentAccountId();
            this.n = baseMsg.getMsgType();
            if (chatRoomDetail.getBasicInfo() != null) {
                this.m = chatRoomDetail.getBasicInfo().getForumId();
            }
            this.f = 1;
            if (chatRoomDetail.getUserInfo() != null) {
                int identityRole = chatRoomDetail.getUserInfo().getIdentityRole();
                if (identityRole != 0) {
                    if (identityRole != 1) {
                        if (identityRole == 2 || identityRole == 3) {
                            this.f = 2;
                        }
                    } else {
                        this.f = 3;
                    }
                } else {
                    this.f = 1;
                }
            }
            if (this.d.getLongPressMsgBtn() != null && !ListUtils.isEmpty(this.d.getLongPressMsgBtn())) {
                int size = this.d.getLongPressMsgBtn().size();
                for (int i = 0; i < size; i++) {
                    if (this.d.getLongPressMsgBtn().get(i) != null) {
                        AbilityItem abilityItem = this.d.getLongPressMsgBtn().get(i);
                        if ("call_robot".equals(abilityItem.getType()) && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
                            this.b.b();
                            this.b.d(abilityItem.getStyleConf().getContent(), d());
                        }
                    }
                }
            } else {
                this.b.j();
            }
            if (z || ((baseMsg2 = this.c) != null && (baseMsg2.getMsgType() == 7009 || this.c.getMsgType() == 7010))) {
                this.b.j();
            }
            this.b.f(this.j, thumbnailText);
            h();
        }
    }

    public void f(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, objArr) == null) {
            if (this.o == null && this.a.get() != null) {
                this.o = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.o;
            fastRequest.R("uid", String.valueOf(this.k));
            fastRequest.R("chatroom_id", String.valueOf(this.g));
            fastRequest.R("op_type", 1);
            fastRequest.R("block_uid", String.valueOf(this.i));
            fastRequest.R("forum_id", String.valueOf(this.m));
            fastRequest.T(this.r);
            fastRequest.S();
        }
    }

    public void i(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, objArr) == null) {
            if (this.p == null) {
                this.p = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.p;
            fastRequest.R("msg_type", Integer.valueOf(this.n));
            fastRequest.R("uid_to", String.valueOf(this.i));
            fastRequest.R("chatroom_id", String.valueOf(this.g));
            fastRequest.R("msg_id", String.valueOf(this.h));
            fastRequest.R("msg_key", String.valueOf(this.l));
            fastRequest.R("forum_id", String.valueOf(this.m));
            fastRequest.T(this.s);
            fastRequest.S();
        }
    }

    public void g(@NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strArr) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf(5));
            hashMap.put("chatroom_msg_id", String.valueOf(this.h));
            hashMap.put("chatroom_id", String.valueOf(this.g));
            String appendParams = UrlUtils.appendParams("https://tieba.baidu.com/tpl/wise-bawu-core/report", hashMap);
            if (this.a.get() != null) {
                UrlManager.getInstance().dealOneLink(this.a.get(), new String[]{appendParams});
            }
        }
    }
}
