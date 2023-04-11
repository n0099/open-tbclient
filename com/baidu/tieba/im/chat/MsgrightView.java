package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.az8;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.mx7;
import com.baidu.tieba.q25;
import com.baidu.tieba.uz7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MsgrightView extends mx7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String Q = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar G;
    public ImageView H;
    public TextView I;
    public HeadImageView J;
    public FrameLayout K;
    public TextView L;
    public TextView M;
    public CenterTextView N;
    public RelativeLayout O;
    public az8 P;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1924798751, "Lcom/baidu/tieba/im/chat/MsgrightView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1924798751, "Lcom/baidu/tieba/im/chat/MsgrightView;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgrightView a;

        public a(MsgrightView msgrightView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgrightView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgrightView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MsgrightView msgrightView = this.a;
                msgrightView.b.D(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements uz7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ MsgrightView b;

        public b(MsgrightView msgrightView, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgrightView, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = msgrightView;
            this.a = chatMessage;
        }

        @Override // com.baidu.tieba.uz7.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str.contains(TbConfig.URL_UEG_REPORT)) {
                    az8 az8Var = this.b.P;
                    if (az8Var != null) {
                        az8Var.c(String.valueOf(this.a.getUserInfo().getUserId()));
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.b.mContext, new String[]{str}, true);
                if (this.a.getError() == 220907) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "2").param("obj_locate", "1"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgrightView a;

        public c(MsgrightView msgrightView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgrightView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgrightView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MsgrightView msgrightView = this.a;
                msgrightView.b.D(view2, 1, msgrightView.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, az8 az8Var) {
        super(tbPageContext, R.layout.msg_msgright_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, az8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P = null;
        this.P = az8Var;
        G();
        this.I = (TextView) u(R.id.img_msgitem_progressbar);
        this.G = (ProgressBar) u(R.id.obfuscated_res_0x7f091c37);
        this.H = (ImageView) u(R.id.btn_msgitem_resend);
        this.J = (HeadImageView) u(R.id.img_msgitem_photo);
        this.N = (CenterTextView) u(R.id.tv_msgerror);
        this.O = (RelativeLayout) u(R.id.rl_errmsg);
        this.K = (FrameLayout) u(R.id.message_text_container);
        q25 d = q25.d(this.O);
        d.o(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        q25 d2 = q25.d(this.N);
        d2.B(R.dimen.T_X09);
        d2.C(R.string.F_X01);
        d2.w(R.color.CAM_X0101);
        this.J.setAutoChangeStyle(false);
        this.J.setDrawerType(1);
        this.J.setRadius(ii.d(this.mContext.getContext(), 4.0f));
        this.J.setPlaceHolder(1);
        this.J.setOnClickListener(new a(this));
        this.L = (TextView) u(R.id.has_read);
        this.M = (TextView) u(R.id.has_sent);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // com.baidu.tieba.mx7
    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.D == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.I();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.q.p(Q);
        this.r.l(Q);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_me);
        this.k.i(Q);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
        ChatShareChatroomCard chatShareChatroomCard = this.s;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.h(R.drawable.icon_pic_im_bubble_share_right, false);
        }
    }

    @Override // com.baidu.tieba.mx7
    public void K(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.K(view2, chatMessage);
            String str = null;
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.G.setVisibility(8);
                this.H.setVisibility(8);
                this.L.setVisibility(4);
                this.M.setVisibility(4);
                this.O.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                N(8);
                this.p.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                ChatShareChatroomCard chatShareChatroomCard = this.s;
                if (chatShareChatroomCard != null) {
                    chatShareChatroomCard.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                d0(chatMessage);
                j0(chatMessage);
                this.J.setDefaultResource(R.drawable.obfuscated_res_0x7f080f98);
                if (chatMessage.getUserInfo() != null) {
                    this.J.setUserId(chatMessage.getUserInfo().getUserId());
                    if (TbadkCoreApplication.isLogin()) {
                        str = TbadkCoreApplication.getCurrentAvatar();
                    }
                    if (str != null && str.length() > 0) {
                        this.J.N(str, 12, false);
                    }
                }
                this.J.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (D()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.K.setLayoutParams(layoutParams);
                    this.J.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.message_container);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.M.setLayoutParams(layoutParams2);
                    this.L.setLayoutParams(layoutParams2);
                }
                this.G.setVisibility(8);
                this.H.setVisibility(8);
                this.L.setVisibility(4);
                this.M.setVisibility(4);
                this.O.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.G.setVisibility(0);
                            break;
                        case 2:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_network);
                            break;
                        case 3:
                            this.G.setVisibility(8);
                            if (this.v) {
                                if (chatMessage.isHasRead()) {
                                    this.L.setVisibility(0);
                                    this.M.setVisibility(4);
                                    break;
                                } else {
                                    this.L.setVisibility(4);
                                    this.M.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_refuse_friend);
                            break;
                        case 5:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_refuse_stranger);
                            break;
                        case 6:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_refuse);
                            break;
                        case 7:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_cancellation);
                            break;
                        case 8:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            this.N.setText(R.string.message_text_error_because_banned);
                            break;
                        case 9:
                            this.H.setVisibility(0);
                            this.O.setVisibility(0);
                            if (hi.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.N.setText(R.string.message_text_error_because_network);
                                break;
                            } else {
                                uz7 f = uz7.f(TbadkCoreApplication.getInst().getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.N);
                                    f.j(new b(this, chatMessage));
                                    if (chatMessage.getError() == 220907) {
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "1").param("obj_locate", "1"));
                                        break;
                                    }
                                } else {
                                    this.N.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                            break;
                    }
                }
                if (this.H.getVisibility() == 0) {
                    this.H.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                N(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                if (this.s != null) {
                    this.s.setVisibility(8);
                }
                int msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    if (msgType != 2) {
                        if (msgType != 3) {
                            if (msgType != 4) {
                                if (msgType != 9) {
                                    if (msgType != 37) {
                                        switch (msgType) {
                                            case 32:
                                                g0(chatMessage);
                                                return;
                                            case 33:
                                                b0(chatMessage);
                                                return;
                                            case 34:
                                                c0(chatMessage);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    Z(chatMessage);
                                    return;
                                }
                                a0(view2, chatMessage, Q);
                                return;
                            }
                            Y(chatMessage, true);
                            return;
                        }
                        h0(chatMessage, Q);
                        this.k.setVisibility(0);
                        return;
                    }
                    e0(view2, chatMessage, Q);
                    return;
                }
                f0(chatMessage, Q);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.mx7
    public void V(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.I.getVisibility() != 8) {
                    this.I.setVisibility(8);
                    this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.I;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.I.setVisibility(0);
            } else if (this.I.getVisibility() != 8) {
                this.I.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
