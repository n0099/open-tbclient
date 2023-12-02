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
import com.baidu.tieba.h5a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.ls8;
import com.baidu.tieba.rd;
import com.baidu.tieba.uu8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MsgrightView extends ls8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String S = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar I;
    public ImageView J;
    public TextView K;
    public HeadImageView L;
    public FrameLayout M;
    public TextView N;
    public TextView O;
    public CenterTextView P;
    public RelativeLayout Q;
    public h5a R;

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
                msgrightView.b.u(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements uu8.c {
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

        @Override // com.baidu.tieba.uu8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str.contains(TbConfig.URL_UEG_REPORT)) {
                    h5a h5aVar = this.b.R;
                    if (h5aVar != null) {
                        h5aVar.c(String.valueOf(this.a.getUserInfo().getUserId()));
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
                msgrightView.b.u(view2, 1, msgrightView.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, h5a h5aVar) {
        super(tbPageContext, R.layout.msg_msgright_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, h5aVar};
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
        this.R = null;
        this.R = h5aVar;
        H();
        this.K = (TextView) g(R.id.img_msgitem_progressbar);
        this.I = (ProgressBar) g(R.id.obfuscated_res_0x7f091e5c);
        this.J = (ImageView) g(R.id.btn_msgitem_resend);
        this.L = (HeadImageView) g(R.id.img_msgitem_photo);
        this.P = (CenterTextView) g(R.id.tv_msgerror);
        this.Q = (RelativeLayout) g(R.id.rl_errmsg);
        this.M = (FrameLayout) g(R.id.message_text_container);
        EMManager.from(this.Q).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0603);
        EMManager.from(this.P).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
        this.L.setAutoChangeStyle(false);
        this.L.setDrawerType(1);
        this.L.setRadius(BdUtilHelper.dip2px(this.mContext.getContext(), 4.0f));
        this.L.setPlaceHolder(1);
        this.L.setOnClickListener(new a(this));
        this.N = (TextView) g(R.id.has_read);
        this.O = (TextView) g(R.id.has_sent);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // com.baidu.tieba.ls8
    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.F == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.J();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.q.x(S);
        this.r.l(S);
        this.s.l(S);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_me);
        this.k.f(S);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
        ChatShareChatroomCard chatShareChatroomCard = this.t;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.e(R.drawable.icon_pic_im_bubble_share_right, false);
        }
        this.u.c(R.drawable.icon_pic_im_bubble_share_right, false);
    }

    @Override // com.baidu.tieba.ls8
    public void M(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.M(view2, chatMessage);
            String str = null;
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                this.N.setVisibility(4);
                this.O.setVisibility(4);
                this.Q.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                O(8);
                this.p.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                ChatShareChatroomCard chatShareChatroomCard = this.t;
                if (chatShareChatroomCard != null) {
                    chatShareChatroomCard.setVisibility(8);
                }
                this.u.setVisibility(8);
                return;
            }
            try {
                f0(chatMessage);
                l0(chatMessage);
                this.L.setDefaultResource(R.drawable.obfuscated_res_0x7f081204);
                if (chatMessage.getUserInfo() != null) {
                    this.L.setUserId(chatMessage.getUserInfo().getUserId());
                    if (TbadkCoreApplication.isLogin()) {
                        str = TbadkCoreApplication.getCurrentAvatar();
                    }
                    if (str != null && str.length() > 0) {
                        this.L.startLoad(str, 12, false);
                    }
                }
                this.L.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (E()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.M.setLayoutParams(layoutParams);
                    this.L.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.message_container);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.O.setLayoutParams(layoutParams2);
                    this.N.setLayoutParams(layoutParams2);
                }
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                this.N.setVisibility(4);
                this.O.setVisibility(4);
                this.Q.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.I.setVisibility(0);
                            break;
                        case 2:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_network);
                            break;
                        case 3:
                            this.I.setVisibility(8);
                            if (this.x) {
                                if (chatMessage.isHasRead()) {
                                    this.N.setVisibility(0);
                                    this.O.setVisibility(4);
                                    break;
                                } else {
                                    this.N.setVisibility(4);
                                    this.O.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_refuse_friend);
                            break;
                        case 5:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_refuse_stranger);
                            break;
                        case 6:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_refuse);
                            break;
                        case 7:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_cancellation);
                            break;
                        case 8:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            this.P.setText(R.string.message_text_error_because_banned);
                            break;
                        case 9:
                            this.J.setVisibility(0);
                            this.Q.setVisibility(0);
                            if (rd.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.P.setText(R.string.message_text_error_because_network);
                                break;
                            } else {
                                uu8 f = uu8.f(TbadkCoreApplication.getInst().getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.P);
                                    f.j(new b(this, chatMessage));
                                    if (chatMessage.getError() == 220907) {
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "1").param("obj_locate", "1"));
                                        break;
                                    }
                                } else {
                                    this.P.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                            break;
                    }
                }
                if (this.J.getVisibility() == 0) {
                    this.J.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                O(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                if (this.t != null) {
                    this.t.setVisibility(8);
                }
                this.u.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    if (msgType != 2) {
                        if (msgType != 3) {
                            if (msgType != 4) {
                                if (msgType != 9) {
                                    if (msgType != 40) {
                                        if (msgType != 37) {
                                            if (msgType != 38) {
                                                switch (msgType) {
                                                    case 32:
                                                        j0(chatMessage);
                                                        return;
                                                    case 33:
                                                        c0(chatMessage);
                                                        return;
                                                    case 34:
                                                        d0(chatMessage);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                            }
                                            h0(chatMessage);
                                            return;
                                        }
                                        a0(chatMessage);
                                        return;
                                    }
                                    e0(chatMessage, S);
                                    return;
                                }
                                b0(view2, chatMessage, S);
                                return;
                            }
                            Z(chatMessage, true);
                            return;
                        }
                        k0(chatMessage, S);
                        this.k.setVisibility(0);
                        return;
                    }
                    g0(view2, chatMessage, S);
                    return;
                }
                i0(chatMessage, S);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.ls8
    public void W(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.K.getVisibility() != 8) {
                    this.K.setVisibility(8);
                    this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.K;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.K.setVisibility(0);
            } else if (this.K.getVisibility() != 8) {
                this.K.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
