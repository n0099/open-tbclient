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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aa8;
import com.baidu.tieba.bi;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.jc8;
import com.baidu.tieba.xk9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MsgrightView extends aa8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String R = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar H;
    public ImageView I;
    public TextView J;
    public HeadImageView K;
    public FrameLayout L;
    public TextView M;
    public TextView N;
    public CenterTextView O;
    public RelativeLayout P;
    public xk9 Q;

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

    /* loaded from: classes6.dex */
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
                msgrightView.b.z(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jc8.c {
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

        @Override // com.baidu.tieba.jc8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str.contains(TbConfig.URL_UEG_REPORT)) {
                    xk9 xk9Var = this.b.Q;
                    if (xk9Var != null) {
                        xk9Var.c(String.valueOf(this.a.getUserInfo().getUserId()));
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

    /* loaded from: classes6.dex */
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
                msgrightView.b.z(view2, 1, msgrightView.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, xk9 xk9Var) {
        super(tbPageContext, R.layout.msg_msgright_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xk9Var};
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
        this.Q = null;
        this.Q = xk9Var;
        I();
        this.J = (TextView) u(R.id.img_msgitem_progressbar);
        this.H = (ProgressBar) u(R.id.obfuscated_res_0x7f091d64);
        this.I = (ImageView) u(R.id.btn_msgitem_resend);
        this.K = (HeadImageView) u(R.id.img_msgitem_photo);
        this.O = (CenterTextView) u(R.id.tv_msgerror);
        this.P = (RelativeLayout) u(R.id.rl_errmsg);
        this.L = (FrameLayout) u(R.id.message_text_container);
        EMManager.from(this.P).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0603);
        EMManager.from(this.O).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
        this.K.setAutoChangeStyle(false);
        this.K.setDrawerType(1);
        this.K.setRadius(BdUtilHelper.dip2px(this.mContext.getContext(), 4.0f));
        this.K.setPlaceHolder(1);
        this.K.setOnClickListener(new a(this));
        this.M = (TextView) u(R.id.has_read);
        this.N = (TextView) u(R.id.has_sent);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // com.baidu.tieba.aa8
    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.E == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.K();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.q.p(R);
        this.r.l(R);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_me);
        this.k.f(R);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
        ChatShareChatroomCard chatShareChatroomCard = this.s;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.h(R.drawable.icon_pic_im_bubble_share_right, false);
        }
        this.t.e(R.drawable.icon_pic_im_bubble_share_right, false);
    }

    @Override // com.baidu.tieba.aa8
    public void N(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.N(view2, chatMessage);
            String str = null;
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                this.M.setVisibility(4);
                this.N.setVisibility(4);
                this.P.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                P(8);
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
                }
                this.t.setVisibility(8);
                return;
            }
            try {
                f0(chatMessage);
                l0(chatMessage);
                this.K.setDefaultResource(R.drawable.obfuscated_res_0x7f08119c);
                if (chatMessage.getUserInfo() != null) {
                    this.K.setUserId(chatMessage.getUserInfo().getUserId());
                    if (TbadkCoreApplication.isLogin()) {
                        str = TbadkCoreApplication.getCurrentAvatar();
                    }
                    if (str != null && str.length() > 0) {
                        this.K.startLoad(str, 12, false);
                    }
                }
                this.K.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (F()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.L.setLayoutParams(layoutParams);
                    this.K.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.message_container);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.N.setLayoutParams(layoutParams2);
                    this.M.setLayoutParams(layoutParams2);
                }
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                this.M.setVisibility(4);
                this.N.setVisibility(4);
                this.P.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.H.setVisibility(0);
                            break;
                        case 2:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_network);
                            break;
                        case 3:
                            this.H.setVisibility(8);
                            if (this.w) {
                                if (chatMessage.isHasRead()) {
                                    this.M.setVisibility(0);
                                    this.N.setVisibility(4);
                                    break;
                                } else {
                                    this.M.setVisibility(4);
                                    this.N.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_refuse_friend);
                            break;
                        case 5:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_refuse_stranger);
                            break;
                        case 6:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_refuse);
                            break;
                        case 7:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_cancellation);
                            break;
                        case 8:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            this.O.setText(R.string.message_text_error_because_banned);
                            break;
                        case 9:
                            this.I.setVisibility(0);
                            this.P.setVisibility(0);
                            if (bi.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.O.setText(R.string.message_text_error_because_network);
                                break;
                            } else {
                                jc8 f = jc8.f(TbadkCoreApplication.getInst().getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.O);
                                    f.j(new b(this, chatMessage));
                                    if (chatMessage.getError() == 220907) {
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "1").param("obj_locate", "1"));
                                        break;
                                    }
                                } else {
                                    this.O.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                            break;
                    }
                }
                if (this.I.getVisibility() == 0) {
                    this.I.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                P(8);
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
                this.t.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    if (msgType != 2) {
                        if (msgType != 3) {
                            if (msgType != 4) {
                                if (msgType != 9) {
                                    if (msgType != 37) {
                                        if (msgType != 38) {
                                            switch (msgType) {
                                                case 32:
                                                    j0(chatMessage);
                                                    return;
                                                case 33:
                                                    d0(chatMessage);
                                                    return;
                                                case 34:
                                                    e0(chatMessage);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        h0(chatMessage);
                                        return;
                                    }
                                    b0(chatMessage);
                                    return;
                                }
                                c0(view2, chatMessage, R);
                                return;
                            }
                            a0(chatMessage, true);
                            return;
                        }
                        k0(chatMessage, R);
                        this.k.setVisibility(0);
                        return;
                    }
                    g0(view2, chatMessage, R);
                    return;
                }
                i0(chatMessage, R);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.aa8
    public void X(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.J.getVisibility() != 8) {
                    this.J.setVisibility(8);
                    this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.J;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.J.setVisibility(0);
            } else if (this.J.getVisibility() != 8) {
                this.J.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
