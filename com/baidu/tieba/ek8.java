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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
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
/* loaded from: classes5.dex */
public class ek8 implements ck8, zj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<TbPageContext<BaseFragmentActivity>> a;
    public final ResponsesPanelControllerImpl b;
    @Nullable
    public ml8 c;
    @Nullable
    public BaseMsg d;
    @Nullable
    public ChatRoomDetail e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public String k;
    public long l;
    public String m;
    public long n;
    public int o;
    public boolean p;
    public FastRequest q;
    public FastRequest r;
    public String s;
    @Nullable
    public ak8 t;
    public hc8 u;
    @NonNull
    public final fk8 v;
    public final FastRequest.b<Void> w;
    public final FastRequest.b<Void> x;
    public final FastRequest.b<Void> y;
    public FastRequest z;

    @Override // com.baidu.tieba.ck8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek8 b;

        public a(ek8 ek8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ek8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.s(str);
                this.b.b.o(3, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                ek8 ek8Var = this.b;
                ek8Var.p = !ek8Var.p;
                String str = null;
                if (this.b.p) {
                    if (this.b.b.c.w2() != null) {
                        if (this.b.b.c.w2().H0()) {
                            if (this.b.b.c.w2().B0().size() >= 6) {
                                str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                            } else {
                                str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                            }
                        } else if (this.b.b.c.w2().B0().size() >= 5) {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                        } else {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                        }
                    }
                } else {
                    str = TbadkApplication.getInst().getString(R.string.chat_msg_remove_excellent);
                }
                this.b.b.o(3, 1, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek8 b;

        public b(ek8 ek8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ek8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.o(1, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.o(1, i, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek8 b;

        public c(ek8 ek8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ek8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.o(2, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.o(2, i, str);
            }
        }
    }

    public ek8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull ResponsesPanelControllerImpl responsesPanelControllerImpl) {
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
        this.p = false;
        this.u = null;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.a = new WeakReference<>(tbPageContext);
        this.b = responsesPanelControllerImpl;
        responsesPanelControllerImpl.q(this);
        this.v = new fk8(responsesPanelControllerImpl);
    }

    public boolean j(boolean z, @NonNull AbilityItem.StyleConf styleConf) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, styleConf)) == null) {
            if (styleConf.isFilterBotMsg() == null || styleConf.getShowMsgType() == null || ListUtils.isEmpty(styleConf.getShowMsgType()) || ListUtils.getCount(styleConf.getShowMsgType()) <= 0) {
                return true;
            }
            if (this.d != null && !styleConf.getShowMsgType().contains(Integer.valueOf(this.d.getMsgType()))) {
                return true;
            }
            if (z && Objects.equals(styleConf.isFilterBotMsg(), 1)) {
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.ck8
    public void c(@NonNull ak8 ak8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ak8Var) == null) {
            this.t = ak8Var;
        }
    }

    @Override // com.baidu.tieba.ck8
    public void f(@NonNull ml8 ml8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ml8Var) == null) {
            this.c = ml8Var;
        }
    }

    @Override // com.baidu.tieba.zj8
    public void a(int i, @Nullable Map<String, Object> map) {
        String format;
        ak8 ak8Var;
        ml8 ml8Var;
        BaseMsg baseMsg;
        ml8 ml8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, map) == null) {
            String str = null;
            String thumbUrl = null;
            r2 = null;
            Reaction reaction = null;
            switch (i) {
                case 17:
                    ChatRoomDetail chatRoomDetail = this.e;
                    if (chatRoomDetail != null && !StringUtils.isNull(chatRoomDetail.getForbiddenContent())) {
                        format = String.format(this.e.getForbiddenContent().replaceAll("\\\\n", "\n"), this.k);
                    } else {
                        format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0414), this.k);
                    }
                    this.b.r(format);
                    return;
                case 18:
                    ep8.e("c15091", String.valueOf(this.l), this.n, this.h);
                    n(new Object[0]);
                    return;
                case 19:
                    ak8 ak8Var2 = this.t;
                    if (ak8Var2 != null) {
                        ak8Var2.a(19, this.d, null);
                    }
                    BaseMsg baseMsg2 = this.d;
                    if (baseMsg2 != null) {
                        if (baseMsg2.getMsgType() == 1 || this.d.getMsgType() == 101) {
                            BaseMsg baseMsg3 = this.d;
                            if (baseMsg3 instanceof TextMsg) {
                                str = ((TextMsg) baseMsg3).getText();
                            } else if (baseMsg3 instanceof TextGenImageMsg) {
                                str = ((TextGenImageMsg) baseMsg3).getText();
                            }
                            if (!StringUtils.isNull(str)) {
                                oi.a(str);
                                this.b.s(this.a.get().getResources().getString(R.string.obfuscated_res_0x7f0f093b));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 20:
                    m(new String[0]);
                    return;
                case 21:
                    if (this.d == null) {
                        return;
                    }
                    UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.d.getReplyPrefix());
                    spannableStringBuilder.append(this.d.getThumbnailText());
                    userReplyInfoData.setmContent(spannableStringBuilder);
                    userReplyInfoData.setmNameShow(this.d.getCommonMsgField().getUserName());
                    userReplyInfoData.setmPortrait(this.d.getCommonMsgField().getPortrait());
                    userReplyInfoData.setmUid(this.d.getCommonMsgField().getUserId());
                    userReplyInfoData.setRobot(this.d.getCommonMsgField().isRobot());
                    ak8 ak8Var3 = this.t;
                    if (ak8Var3 != null) {
                        ak8Var3.a(21, this.d, userReplyInfoData);
                        return;
                    }
                    return;
                case 22:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                default:
                    return;
                case 23:
                    BaseMsg baseMsg4 = this.d;
                    if (baseMsg4 != null && baseMsg4.getCommonMsgField().getBubbleInfo() != null) {
                        String jumpUrl = this.d.getCommonMsgField().getBubbleInfo().getJumpUrl();
                        if (!StringUtils.isNull(jumpUrl)) {
                            UrlManager.getInstance().dealOneLink(jumpUrl);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c15236").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 24:
                    ChatRoomDetail chatRoomDetail2 = this.e;
                    if (chatRoomDetail2 != null && chatRoomDetail2.getLongPressMsgBtn() != null && (ak8Var = this.t) != null && map != null) {
                        ak8Var.a(i, this.d, map.get("robot_tag"));
                        return;
                    }
                    return;
                case 25:
                    ep8.e("c15092", String.valueOf(this.j), this.n, this.h);
                    l(new Object[0]);
                    return;
                case 26:
                    if (map != null && map.containsKey("ext_reaction")) {
                        reaction = (Reaction) map.get("ext_reaction");
                    }
                    if (reaction != null && (ml8Var = this.c) != null && (baseMsg = this.d) != null) {
                        this.v.c(ml8Var, reaction, baseMsg);
                        return;
                    }
                    return;
                case 32:
                    BaseMsg baseMsg5 = this.d;
                    if (baseMsg5 != null) {
                        if (baseMsg5.getMsgType() == 102 || this.d.getMsgType() == 2 || this.d.getMsgType() == 101) {
                            BaseMsg baseMsg6 = this.d;
                            if (baseMsg6 instanceof ImageMsg) {
                                thumbUrl = ((ImageMsg) baseMsg6).getThumbUrl();
                            } else if (baseMsg6 instanceof SingleTextImageMsg) {
                                thumbUrl = ((SingleTextImageMsg) baseMsg6).getThumbUrl();
                            } else if (baseMsg6 instanceof TextGenImageMsg) {
                                thumbUrl = ((TextGenImageMsg) baseMsg6).getThumbUrl();
                            }
                            hc8 hc8Var = new hc8(this.a.get().getContext(), thumbUrl, this.n, null, this.h, true);
                            this.u = hc8Var;
                            hc8Var.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                case 33:
                    k();
                    return;
                case 34:
                    BaseMsg baseMsg7 = this.d;
                    if (baseMsg7 != null && (ml8Var2 = this.c) != null) {
                        nm8.f(ml8Var2, 1, baseMsg7);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.ck8
    public void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseMsg, chatRoomDetail) == null) {
            this.d = baseMsg;
            this.e = chatRoomDetail;
            this.v.e(chatRoomDetail.getReactions());
            this.v.d(this.a.get().getPageActivity());
            CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
            if (!StringUtils.isNull(commonMsgField.getUserName())) {
                this.k = commonMsgField.getUserName();
            }
            if (!StringUtils.isNull(commonMsgField.getMsgKey())) {
                this.m = commonMsgField.getMsgKey();
            }
            CharSequence thumbnailText = this.d.getThumbnailText();
            int role = commonMsgField.getRole();
            if (commonMsgField.getRobotRole() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                role = 64;
            }
            this.f = role;
            this.h = commonMsgField.getRoomId();
            this.i = commonMsgField.getMsgId();
            this.j = commonMsgField.getUserId();
            this.l = TbadkCoreApplication.getCurrentAccountId();
            this.o = baseMsg.getMsgType();
            if (chatRoomDetail.getBasicInfo() != null) {
                this.n = chatRoomDetail.getBasicInfo().getForumId();
            }
            this.g = 1;
            if (chatRoomDetail.getUserInfo() != null) {
                int identityRole = chatRoomDetail.getUserInfo().getIdentityRole();
                if (identityRole != 0) {
                    if (identityRole != 1) {
                        if (identityRole == 2 || identityRole == 3) {
                            this.g = 2;
                        }
                    } else {
                        this.g = 3;
                    }
                } else {
                    this.g = 1;
                }
            }
            if (this.e.getLongPressMsgBtn() != null && !ListUtils.isEmpty(this.e.getLongPressMsgBtn())) {
                int size = this.e.getLongPressMsgBtn().size();
                for (int i = 0; i < size; i++) {
                    if (this.e.getLongPressMsgBtn().get(i) != null) {
                        AbilityItem abilityItem = this.e.getLongPressMsgBtn().get(i);
                        if (abilityItem.getStyleConf() != null && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
                            this.b.b(abilityItem);
                            this.b.d(abilityItem.getStyleConf().getContent(), i());
                            if (j(z, abilityItem.getStyleConf())) {
                                this.b.m();
                            }
                        }
                    }
                }
            } else {
                this.b.m();
            }
            this.b.j(this.k, thumbnailText);
            h();
        }
    }

    @Override // com.baidu.tieba.ck8
    public void h() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap hashMap = new HashMap();
            ChatRoomDetail chatRoomDetail = this.e;
            if (chatRoomDetail != null) {
                hashMap.put("is_show_reply", Boolean.valueOf(em8.r(chatRoomDetail)));
            }
            BaseMsg baseMsg = this.d;
            if (baseMsg != null && baseMsg.getCommonMsgField().getBubbleInfo() != null && !StringUtils.isNull(this.d.getCommonMsgField().getBubbleInfo().getJumpUrl())) {
                hashMap.put("is_show_bubble", Boolean.TRUE);
                TiebaStatic.log(new StatisticItem("c15235").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            BaseMsg baseMsg2 = this.d;
            if (baseMsg2 != null && baseMsg2.getMsgType() == 2) {
                hashMap.put("is_show_copy", Boolean.FALSE);
            }
            int i = this.o;
            if (i != 102 && i != 2 && i != 101) {
                z = false;
            } else {
                z = true;
            }
            BaseMsg baseMsg3 = this.d;
            if (baseMsg3 != null && baseMsg3.getCommonMsgField().getExcellentInfo() != null) {
                boolean isExcellent = this.d.getCommonMsgField().getExcellentInfo().isExcellent();
                this.p = isExcellent;
                hashMap.put("is_excellent_msg", Boolean.valueOf(isExcellent));
            } else {
                this.p = false;
            }
            ChatRoomDetail chatRoomDetail2 = this.e;
            if (chatRoomDetail2 != null && this.d != null && chatRoomDetail2.getBots() != null && this.e.getCanExcellent() != null) {
                if (this.e.getCanExcellent().getCanOpExcellent() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    for (BotsDTO.BotListDTO botListDTO : this.e.getBots().getBotList()) {
                        this.s = botListDTO.getAtGuide();
                    }
                    if (this.d.getMsgType() == 1) {
                        String text = ((TextMsg) this.d).getText();
                        if (StringUtils.isNull(this.s) || (text != null && !text.contains(this.s))) {
                            hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                        }
                    } else {
                        hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                    }
                }
            }
            BaseMsg baseMsg4 = this.d;
            if (baseMsg4 != null && (baseMsg4.getItemStatus() != 5 || this.d.isLocalMsg())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.b.c.p2() != null) {
                z3 = nm8.c(this.b.c.p2());
            } else {
                z3 = true;
            }
            boolean e = nm8.e();
            if (!z2 && z3 && !e) {
                hashMap.put("is_show_emoji_reply", Boolean.TRUE);
            } else {
                hashMap.put("is_show_emoji_reply", Boolean.FALSE);
            }
            ResponsesPanelControllerImpl responsesPanelControllerImpl = this.b;
            if (this.l == this.j) {
                z4 = true;
            } else {
                z4 = false;
            }
            responsesPanelControllerImpl.l(z4, this.f, this.g, hashMap, z, this.n, this.h);
        }
    }

    @Nullable
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.e;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getLongPressMsgBtn()) && this.e.getLongPressMsgBtn().get(0) != null) {
                int skinType = TbadkApplication.getInst().getSkinType();
                AbilityItem.StyleConf styleConf = this.e.getLongPressMsgBtn().get(0).getStyleConf();
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

    public void k() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.z == null) {
                this.z = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GROUP_CHAT_EXCELLENT_MESSAGE, "c/c/chatroom/opExcellentMsg");
            }
            FastRequest fastRequest = this.z;
            fastRequest.W("forum_id", Long.valueOf(this.n));
            fastRequest.W("chatroom_id", String.valueOf(this.h));
            fastRequest.W("msg_id", String.valueOf(this.i));
            fastRequest.W("msg_key", String.valueOf(this.m));
            fastRequest.W("tbs", TbadkCoreApplication.getInst().getTbs());
            if (this.p) {
                i = 2;
            } else {
                i = 1;
            }
            fastRequest.W("op_type", Integer.valueOf(i));
            fastRequest.Y(this.w);
            fastRequest.X();
        }
    }

    public void l(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr) == null) {
            if (this.q == null && this.a.get() != null) {
                this.q = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.q;
            fastRequest.W("uid", String.valueOf(this.l));
            fastRequest.W("chatroom_id", String.valueOf(this.h));
            fastRequest.W("op_type", 1);
            fastRequest.W("block_uid", String.valueOf(this.j));
            fastRequest.W("forum_id", String.valueOf(this.n));
            fastRequest.Y(this.x);
            fastRequest.c0(true);
            fastRequest.X();
        }
    }

    public void n(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, objArr) == null) {
            if (this.r == null) {
                this.r = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.r;
            fastRequest.W("msg_type", Integer.valueOf(this.o));
            fastRequest.W("uid_to", String.valueOf(this.j));
            fastRequest.W("chatroom_id", String.valueOf(this.h));
            fastRequest.W("msg_id", String.valueOf(this.i));
            fastRequest.W("msg_key", String.valueOf(this.m));
            fastRequest.W("forum_id", String.valueOf(this.n));
            fastRequest.Y(this.y);
            fastRequest.c0(true);
            fastRequest.X();
        }
    }

    public void m(@NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, strArr) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf(5));
            hashMap.put("chatroom_msg_id", String.valueOf(this.i));
            hashMap.put("chatroom_id", String.valueOf(this.h));
            String appendParams = UrlUtils.appendParams("https://tieba.baidu.com/tpl/wise-bawu-core/report", hashMap);
            if (this.a.get() != null) {
                UrlManager.getInstance().dealOneLink(this.a.get(), new String[]{appendParams});
            }
        }
    }
}
