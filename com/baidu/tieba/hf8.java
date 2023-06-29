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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes6.dex */
public class hf8 implements ff8, cf8 {
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
    public boolean o;
    public FastRequest p;
    public FastRequest q;
    public String r;
    @Nullable
    public df8 s;
    public m78 t;
    public final FastRequest.b<Void> u;
    public final FastRequest.b<Void> v;
    public final FastRequest.b<Void> w;
    public FastRequest x;

    @Override // com.baidu.tieba.ff8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf8 b;

        public a(hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.q(str);
                this.b.b.l(3, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                hf8 hf8Var = this.b;
                hf8Var.o = !hf8Var.o;
                String str = null;
                if (this.b.o) {
                    if (this.b.b.c.t2() != null) {
                        if (this.b.b.c.t2().G0()) {
                            if (this.b.b.c.t2().A0().size() >= 6) {
                                str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                            } else {
                                str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                            }
                        } else if (this.b.b.c.t2().A0().size() >= 5) {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                        } else {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                        }
                    }
                } else {
                    str = TbadkApplication.getInst().getString(R.string.chat_msg_remove_excellent);
                }
                this.b.b.l(3, 1, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf8 b;

        public b(hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.l(1, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.l(1, i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf8 b;

        public c(hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.l(2, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.l(2, i, str);
            }
        }
    }

    public hf8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull ResponsesPanelControllerImpl responsesPanelControllerImpl) {
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
        this.o = false;
        this.t = null;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.a = new WeakReference<>(tbPageContext);
        this.b = responsesPanelControllerImpl;
        responsesPanelControllerImpl.m(this);
    }

    public boolean h(boolean z, @NonNull AbilityItem.StyleConf styleConf) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, styleConf)) == null) {
            if (styleConf.isFilterBotMsg() == null || styleConf.getShowMsgType() == null || ListUtils.isEmpty(styleConf.getShowMsgType()) || ListUtils.getCount(styleConf.getShowMsgType()) <= 0) {
                return true;
            }
            if (this.c != null && !styleConf.getShowMsgType().contains(Integer.valueOf(this.c.getMsgType()))) {
                return true;
            }
            if (z && Objects.equals(styleConf.isFilterBotMsg(), 1)) {
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.ff8
    public void c(@NonNull df8 df8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, df8Var) == null) {
            this.s = df8Var;
        }
    }

    @Override // com.baidu.tieba.cf8
    public void a(int i, @Nullable Map<String, Object> map) {
        String format;
        df8 df8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, map) == null) {
            String str = null;
            if (i != 32) {
                if (i != 33) {
                    switch (i) {
                        case 17:
                            ChatRoomDetail chatRoomDetail = this.d;
                            if (chatRoomDetail != null && !StringUtils.isNull(chatRoomDetail.getForbiddenContent())) {
                                format = String.format(this.d.getForbiddenContent().replaceAll("\\\\n", "\n"), this.j);
                            } else {
                                format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0411), this.j);
                            }
                            this.b.p(format);
                            return;
                        case 18:
                            oj8.e("c15091", String.valueOf(this.k), this.m, this.g);
                            m(new Object[0]);
                            return;
                        case 19:
                            df8 df8Var2 = this.s;
                            if (df8Var2 != null) {
                                df8Var2.a(19, this.c, null);
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
                                        ni.a(str);
                                        this.b.q(this.a.get().getResources().getString(R.string.obfuscated_res_0x7f0f0931));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 20:
                            l(new String[0]);
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
                            df8 df8Var3 = this.s;
                            if (df8Var3 != null) {
                                df8Var3.a(21, this.c, userReplyInfoData);
                                return;
                            }
                            return;
                        default:
                            switch (i) {
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
                                    if (chatRoomDetail2 != null && chatRoomDetail2.getLongPressMsgBtn() != null && (df8Var = this.s) != null && map != null) {
                                        df8Var.a(i, this.c, map.get("robot_tag"));
                                        return;
                                    }
                                    return;
                                case 25:
                                    oj8.e("c15092", String.valueOf(this.i), this.m, this.g);
                                    k(new Object[0]);
                                    return;
                                default:
                                    return;
                            }
                    }
                }
                j();
                return;
            }
            BaseMsg baseMsg4 = this.c;
            if (baseMsg4 != null) {
                if (baseMsg4.getMsgType() == 102 || this.c.getMsgType() == 2 || this.c.getMsgType() == 101) {
                    BaseMsg baseMsg5 = this.c;
                    if (baseMsg5 instanceof ImageMsg) {
                        str = ((ImageMsg) baseMsg5).getThumbUrl();
                    } else if (baseMsg5 instanceof SingleTextImageMsg) {
                        str = ((SingleTextImageMsg) baseMsg5).getThumbUrl();
                    } else if (baseMsg5 instanceof TextGenImageMsg) {
                        str = ((TextGenImageMsg) baseMsg5).getThumbUrl();
                    }
                    m78 m78Var = new m78(this.a.get().getContext(), str, this.m, null, this.g, true);
                    this.t = m78Var;
                    m78Var.execute(new String[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ff8
    public void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseMsg, chatRoomDetail) == null) {
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
                        if (abilityItem.getStyleConf() != null && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
                            this.b.b(abilityItem);
                            this.b.d(abilityItem.getStyleConf().getContent(), g());
                            if (h(z, abilityItem.getStyleConf())) {
                                this.b.j();
                            }
                        }
                    }
                }
            } else {
                this.b.j();
            }
            this.b.f(this.j, thumbnailText);
            i();
        }
    }

    @Nullable
    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.d;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getLongPressMsgBtn()) && this.d.getLongPressMsgBtn().get(0) != null) {
                int skinType = TbadkApplication.getInst().getSkinType();
                AbilityItem.StyleConf styleConf = this.d.getLongPressMsgBtn().get(0).getStyleConf();
                if (skinType == 4) {
                    if (styleConf != null && styleConf.getDark() != null) {
                        return styleConf.getDark().getIcon();
                    }
                } else if (skinType == 0 && styleConf != null && styleConf.getDay() != null) {
                    return styleConf.getDay().getIcon();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void j() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.x == null) {
                this.x = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GROUP_CHAT_EXCELLENT_MESSAGE, "c/c/chatroom/opExcellentMsg");
            }
            FastRequest fastRequest = this.x;
            fastRequest.V("forum_id", Long.valueOf(this.m));
            fastRequest.V("chatroom_id", String.valueOf(this.g));
            fastRequest.V("msg_id", String.valueOf(this.h));
            fastRequest.V("msg_key", String.valueOf(this.l));
            fastRequest.V("tbs", TbadkCoreApplication.getInst().getTbs());
            if (this.o) {
                i = 2;
            } else {
                i = 1;
            }
            fastRequest.V("op_type", Integer.valueOf(i));
            fastRequest.X(this.u);
            fastRequest.W();
        }
    }

    @Override // com.baidu.tieba.ff8
    public void i() {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HashMap hashMap = new HashMap();
            ChatRoomDetail chatRoomDetail = this.d;
            if (chatRoomDetail != null) {
                hashMap.put("is_show_reply", Boolean.valueOf(eh8.p(chatRoomDetail)));
            }
            BaseMsg baseMsg = this.c;
            if (baseMsg != null && baseMsg.getCommonMsgField().getBubbleInfo() != null && !StringUtils.isNull(this.c.getCommonMsgField().getBubbleInfo().getJumpUrl())) {
                hashMap.put("is_show_bubble", Boolean.TRUE);
                TiebaStatic.log(new StatisticItem("c15235").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            BaseMsg baseMsg2 = this.c;
            if (baseMsg2 != null && baseMsg2.getMsgType() == 2) {
                hashMap.put("is_show_copy", Boolean.FALSE);
            }
            int i = this.n;
            if (i != 102 && i != 2 && i != 101) {
                z = false;
            } else {
                z = true;
            }
            BaseMsg baseMsg3 = this.c;
            if (baseMsg3 != null && baseMsg3.getCommonMsgField().getExcellentInfo() != null) {
                boolean isExcellent = this.c.getCommonMsgField().getExcellentInfo().isExcellent();
                this.o = isExcellent;
                hashMap.put("is_excellent_msg", Boolean.valueOf(isExcellent));
            } else {
                this.o = false;
            }
            ChatRoomDetail chatRoomDetail2 = this.d;
            if (chatRoomDetail2 != null && this.c != null && chatRoomDetail2.getBots() != null && this.d.getCanExcellent() != null) {
                if (this.d.getCanExcellent().getCanOpExcellent() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    for (BotsDTO.BotListDTO botListDTO : this.d.getBots().getBotList()) {
                        this.r = botListDTO.getAtGuide();
                    }
                    if (this.c.getMsgType() == 1) {
                        String text = ((TextMsg) this.c).getText();
                        if (StringUtils.isNull(this.r) || (text != null && !text.contains(this.r))) {
                            hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                        }
                    } else {
                        hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                    }
                }
            }
            ResponsesPanelControllerImpl responsesPanelControllerImpl = this.b;
            if (this.k == this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            responsesPanelControllerImpl.g(z2, this.e, this.f, hashMap, z, this.m, this.g);
        }
    }

    public void k(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, objArr) == null) {
            if (this.p == null && this.a.get() != null) {
                this.p = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.p;
            fastRequest.V("uid", String.valueOf(this.k));
            fastRequest.V("chatroom_id", String.valueOf(this.g));
            fastRequest.V("op_type", 1);
            fastRequest.V("block_uid", String.valueOf(this.i));
            fastRequest.V("forum_id", String.valueOf(this.m));
            fastRequest.X(this.v);
            fastRequest.b0(true);
            fastRequest.W();
        }
    }

    public void m(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, objArr) == null) {
            if (this.q == null) {
                this.q = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.q;
            fastRequest.V("msg_type", Integer.valueOf(this.n));
            fastRequest.V("uid_to", String.valueOf(this.i));
            fastRequest.V("chatroom_id", String.valueOf(this.g));
            fastRequest.V("msg_id", String.valueOf(this.h));
            fastRequest.V("msg_key", String.valueOf(this.l));
            fastRequest.V("forum_id", String.valueOf(this.m));
            fastRequest.X(this.w);
            fastRequest.b0(true);
            fastRequest.W();
        }
    }

    public void l(@NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
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
