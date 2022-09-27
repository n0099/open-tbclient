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
import com.baidu.tieba.a87;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.ia7;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.p18;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MsgrightView extends a87 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String P = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar F;
    public ImageView G;
    public TextView H;
    public HeadImageView I;
    public FrameLayout J;
    public TextView K;
    public TextView L;
    public CenterTextView M;
    public RelativeLayout N;
    public p18 O;

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
                msgrightView.b.q(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ia7.c {
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

        @Override // com.baidu.tieba.ia7.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!str.contains(TbConfig.URL_UEG_REPORT)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) this.b.mContext, new String[]{str}, true);
                    if (this.a.getError() == 220907) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "2").param("obj_locate", "1"));
                        return;
                    }
                    return;
                }
                p18 p18Var = this.b.O;
                if (p18Var != null) {
                    p18Var.c(String.valueOf(this.a.getUserInfo().getUserId()));
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
                msgrightView.b.q(view2, 1, msgrightView.f, 0L);
            }
        }
    }

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, p18 p18Var) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d059e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, p18Var};
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
        this.O = null;
        this.O = p18Var;
        r();
        this.H = (TextView) j(R.id.obfuscated_res_0x7f090ef4);
        this.F = (ProgressBar) j(R.id.obfuscated_res_0x7f091abc);
        this.G = (ImageView) j(R.id.obfuscated_res_0x7f090449);
        this.I = (HeadImageView) j(R.id.obfuscated_res_0x7f090ef3);
        this.M = (CenterTextView) j(R.id.obfuscated_res_0x7f0923c9);
        this.N = (RelativeLayout) j(R.id.obfuscated_res_0x7f091c57);
        this.J = (FrameLayout) j(R.id.obfuscated_res_0x7f091529);
        hv4 d = hv4.d(this.N);
        d.n(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        hv4 d2 = hv4.d(this.M);
        d2.z(R.dimen.T_X09);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0101);
        this.I.setAutoChangeStyle(false);
        this.I.setDrawerType(1);
        this.I.setRadius(ej.d(this.mContext.getContext(), 4.0f));
        this.I.setPlaceHolder(1);
        this.I.setOnClickListener(new a(this));
        this.K = (TextView) j(R.id.obfuscated_res_0x7f090d23);
        this.L = (TextView) j(R.id.obfuscated_res_0x7f090d24);
        this.n.setIsLeft(false);
        this.o.setIsLeft(false);
    }

    @Override // com.baidu.tieba.a87
    public void F(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.H.getVisibility() != 8) {
                    this.H.setVisibility(8);
                    this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.q.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.H;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.H.setVisibility(0);
            } else if (this.H.getVisibility() != 8) {
                this.H.setVisibility(8);
                this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override // com.baidu.tieba.a87
    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.D == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.t();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.r.p(P);
        this.s.l(P);
        SkinManager.setBackgroundResource(this.o, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        this.k.f(P);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
    }

    @Override // com.baidu.tieba.a87
    public void v(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            super.v(view2, chatMessage);
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.F.setVisibility(8);
                this.G.setVisibility(8);
                this.K.setVisibility(4);
                this.L.setVisibility(4);
                this.N.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                x(8);
                this.q.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                return;
            }
            try {
                N(chatMessage);
                T(chatMessage);
                this.I.setDefaultResource(R.drawable.obfuscated_res_0x7f080f10);
                if (chatMessage.getUserInfo() != null) {
                    this.I.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.I.K(currentAvatar, 12, false);
                    }
                }
                this.I.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (p()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.J.setLayoutParams(layoutParams);
                    this.I.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f09151e);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.L.setLayoutParams(layoutParams2);
                    this.K.setLayoutParams(layoutParams2);
                }
                this.F.setVisibility(8);
                this.G.setVisibility(8);
                this.K.setVisibility(4);
                this.L.setVisibility(4);
                this.N.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.F.setVisibility(0);
                            break;
                        case 2:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0ae8);
                            break;
                        case 3:
                            this.F.setVisibility(8);
                            if (this.v) {
                                if (chatMessage.isHasRead()) {
                                    this.K.setVisibility(0);
                                    this.L.setVisibility(4);
                                    break;
                                } else {
                                    this.K.setVisibility(4);
                                    this.L.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0aea);
                            break;
                        case 5:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0aeb);
                            break;
                        case 6:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0ae9);
                            break;
                        case 7:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0ae7);
                            break;
                        case 8:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            this.M.setText(R.string.obfuscated_res_0x7f0f0ae6);
                            break;
                        case 9:
                            this.G.setVisibility(0);
                            this.N.setVisibility(0);
                            if (dj.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.M.setText(R.string.obfuscated_res_0x7f0f0ae8);
                                break;
                            } else {
                                ia7 f = ia7.f(TbadkCoreApplication.getInst().getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.M);
                                    f.j(new b(this, chatMessage));
                                    if (chatMessage.getError() == 220907) {
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_GROWUP_LEVEL_DIALOG_SHOW).param("obj_type", "1").param("obj_locate", "1"));
                                        break;
                                    }
                                } else {
                                    this.M.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                            break;
                    }
                }
                if (this.G.getVisibility() == 0) {
                    this.G.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                x(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    Q(chatMessage, P);
                } else if (msgType == 2) {
                    P(view2, chatMessage, P);
                } else if (msgType == 3) {
                    S(chatMessage, P);
                    this.k.setVisibility(0);
                } else if (msgType == 4) {
                    I(chatMessage, true);
                } else if (msgType != 9) {
                    switch (msgType) {
                        case 32:
                            R(chatMessage);
                            return;
                        case 33:
                            L(chatMessage);
                            return;
                        case 34:
                            M(chatMessage);
                            return;
                        default:
                            return;
                    }
                } else {
                    K(view2, chatMessage, P);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
