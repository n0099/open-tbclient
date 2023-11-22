package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.m07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class az8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public rz8 a;
    @NonNull
    public wy8 b;
    public long c;
    public String d;
    @Nullable
    public TbPageContext e;
    public ck8 f;
    public final View.OnClickListener g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az8 a;

        public a(az8 az8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity pageActivity;
            rz8 rz8Var;
            long roomId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                az8 az8Var = this.a;
                if (az8Var.f != null && (rz8Var = az8Var.a) != null) {
                    if (rz8Var.a() == null) {
                        roomId = this.a.c;
                    } else {
                        roomId = this.a.a.a().getRoomId();
                    }
                    if (this.a.d.equals("message_tab")) {
                        az8 az8Var2 = this.a;
                        az8Var2.l(az8Var2.a, "2");
                    }
                    this.a.f.a(roomId, 0);
                }
                if (this.a.b.e() != null) {
                    this.a.b.e().setVisibility(8);
                }
                TbPageContext tbPageContext = this.a.e;
                if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
                    ul5 a = tl5.a();
                    az8 az8Var3 = this.a;
                    a.d(pageActivity, az8Var3.c, "source_from_group_chat_dialog", az8Var3.f(), this.a.e());
                }
                this.a.d(1);
                this.a.b.c().setVisibility(8);
                rz8 rz8Var2 = this.a.a;
                if (rz8Var2 != null && rz8Var2.a() != null) {
                    this.a.a.a().setAtInfo(null);
                }
            }
        }
    }

    public az8(@Nullable TbPageContext tbPageContext, @NonNull rz8 rz8Var, @NonNull wy8 wy8Var, String str, ck8 ck8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rz8Var, wy8Var, str, ck8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.a = rz8Var;
        this.b = wy8Var;
        this.d = str;
        this.e = tbPageContext;
        this.f = ck8Var;
    }

    public /* synthetic */ void g(SpannableStringBuilder spannableStringBuilder) {
        this.b.d().setText(spannableStringBuilder);
    }

    public void n(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, chatRoomInfo, z) == null) {
            j(chatRoomInfo);
            k(chatRoomInfo, z);
            h(chatRoomInfo);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK);
            rz8 rz8Var = this.a;
            if (rz8Var != null && rz8Var.a() != null) {
                statisticItem.param("fid", this.a.a().getForumId());
                statisticItem.param("fname", this.a.a().getForumName());
                statisticItem.param("room_id", this.a.a().getRoomId());
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", i);
            if (this.d.equals("message_tab")) {
                statisticItem.param("obj_locate", 15);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            rz8 rz8Var = this.a;
            if (rz8Var != null && rz8Var.a() != null && this.a.a().getSingleListHotText() != null) {
                return this.a.a().getSingleListHotText();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ("message_tab".equals(this.d)) {
                return 15;
            }
            if ("frs".equals(this.d)) {
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomInfo) == null) {
            ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
            if (newMessage != null && !StringUtils.isNull(newMessage.getSpecialMsg())) {
                this.b.c().setVisibility(0);
                this.b.c().setText(newMessage.getSpecialMsg());
                return;
            }
            this.b.c().setVisibility(8);
        }
    }

    public void i(@NonNull ChatRoomInfo chatRoomInfo) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomInfo) == null) {
            if (chatRoomInfo.getUnreadNum() < 10) {
                i = R.drawable.icon_list_dot_one_number;
            } else if (chatRoomInfo.getUnreadNum() < 100) {
                i = R.drawable.icon_list_dot_two_number;
            } else {
                i = R.drawable.icon_list_dot_three_number;
            }
            this.b.e().setBackgroundResource(i);
        }
    }

    public void j(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatRoomInfo) == null) {
            if (chatRoomInfo.getNewMessage() != null && !StringUtils.isNull(chatRoomInfo.getNewMessage().getContent())) {
                String str = "";
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromName())) {
                    str = "" + chatRoomInfo.getNewMessage().getFromName() + ": ";
                }
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getContent())) {
                    str = str + chatRoomInfo.getNewMessage().getContent();
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) str);
                m07.g(this.e.getContext(), spannableStringBuilder, new m07.i() { // from class: com.baidu.tieba.py8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m07.i
                    public final void a(SpannableStringBuilder spannableStringBuilder2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder2) == null) {
                            az8.this.g(spannableStringBuilder2);
                        }
                    }
                });
                this.b.d().setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            this.b.f().setLayoutParams(layoutParams);
            this.b.d().setVisibility(8);
        }
    }

    public void k(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, chatRoomInfo, z) == null) {
            if (chatRoomInfo.getUnreadNum() != 0 && z) {
                this.b.e().setVisibility(0);
                if (chatRoomInfo.getUnreadNum() >= 100) {
                    this.b.e().setText("99+");
                } else {
                    this.b.e().setText(String.valueOf(chatRoomInfo.getUnreadNum()));
                }
                if (this.d.equals("message_tab")) {
                    this.b.a(this.a);
                    return;
                } else {
                    i(chatRoomInfo);
                    return;
                }
            }
            this.b.e().setVisibility(8);
        }
    }

    public void l(rz8 rz8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rz8Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c15358");
            if (rz8Var != null && rz8Var.a() != null) {
                statisticItem.param("fid", rz8Var.a().getForumId());
                statisticItem.param("room_id", rz8Var.a().getRoomId());
                if (rz8Var.a().getUnreadNum() > 0) {
                    statisticItem.param("obj_source", "1");
                } else {
                    statisticItem.param("obj_source", "2");
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            rz8 rz8Var = this.a;
            if (rz8Var != null && rz8Var.a() != null) {
                ChatRoomInfo a2 = this.a.a();
                if (a2.getName() != null) {
                    this.b.f().setText(MeasureTextLength.fitTextLabel(a2.getName(), "...", MeasureTextLength.spaceLength(this.b.i()), this.b.f().getPaint(), ""));
                }
                n(a2, this.a.b());
                if (this.d.equals("message_tab")) {
                    SkinManager.setImageResource(this.b.b(), R.drawable.obfuscated_res_0x7f08086a);
                } else if (a2.getAvatar() != null) {
                    this.b.b().startLoad(a2.getAvatar(), 10, false);
                }
                this.c = a2.getRoomId();
            }
            this.b.h(this.a);
            this.b.j();
            this.b.g().setOnClickListener(this.g);
            l(this.a, "1");
            d(2);
        }
    }
}
