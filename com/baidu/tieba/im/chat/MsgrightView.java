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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e67;
import com.repackage.g47;
import com.repackage.lx7;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.vr4;
/* loaded from: classes3.dex */
public class MsgrightView extends g47 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String M = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar C;
    public ImageView D;
    public TextView E;
    public HeadImageView F;
    public FrameLayout G;
    public TextView H;
    public TextView I;
    public CenterTextView J;
    public RelativeLayout K;
    public lx7 L;

    /* loaded from: classes3.dex */
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
                msgrightView.b.h(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e67.d {
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

        @Override // com.repackage.e67.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!str.contains(TbConfig.URL_UEG_REPORT)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) this.b.mContext, new String[]{str}, true);
                    return;
                }
                lx7 lx7Var = this.b.L;
                if (lx7Var != null) {
                    lx7Var.c(String.valueOf(this.a.getUserInfo().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                msgrightView.b.h(view2, 1, msgrightView.f, 0L);
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
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, lx7 lx7Var) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0569);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lx7Var};
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
        this.L = null;
        this.L = lx7Var;
        o();
        this.E = (TextView) a(R.id.obfuscated_res_0x7f090e8c);
        this.C = (ProgressBar) a(R.id.obfuscated_res_0x7f0919a2);
        this.D = (ImageView) a(R.id.obfuscated_res_0x7f090421);
        this.F = (HeadImageView) a(R.id.obfuscated_res_0x7f090e8b);
        this.J = (CenterTextView) a(R.id.obfuscated_res_0x7f09225a);
        this.K = (RelativeLayout) a(R.id.obfuscated_res_0x7f091b28);
        this.G = (FrameLayout) a(R.id.obfuscated_res_0x7f091458);
        vr4 d = vr4.d(this.K);
        d.n(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        vr4 d2 = vr4.d(this.J);
        d2.z(R.dimen.T_X09);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0101);
        this.F.setAutoChangeStyle(false);
        this.F.setDrawerType(1);
        this.F.setRadius(pi.d(this.mContext.getContext(), 4.0f));
        this.F.setPlaceHolder(1);
        this.F.setOnClickListener(new a(this));
        this.H = (TextView) a(R.id.obfuscated_res_0x7f090cc3);
        this.I = (TextView) a(R.id.obfuscated_res_0x7f090cc4);
        this.n.setIsLeft(false);
        this.o.setIsLeft(false);
    }

    @Override // com.repackage.g47
    public void C(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.E.getVisibility() != 8) {
                    this.E.setVisibility(8);
                    this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.q.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.E;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.E.setVisibility(0);
            } else if (this.E.getVisibility() != 8) {
                this.E.setVisibility(8);
                this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override // com.repackage.g47
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.B == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.q();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.r.p(M);
        SkinManager.setBackgroundResource(this.o, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        this.k.f(M);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
    }

    @Override // com.repackage.g47
    public void s(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            super.s(view2, chatMessage);
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.H.setVisibility(4);
                this.I.setVisibility(4);
                this.K.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                u(8);
                this.q.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                return;
            }
            try {
                I(chatMessage);
                P(chatMessage);
                this.F.setDefaultResource(R.drawable.obfuscated_res_0x7f080e82);
                if (chatMessage.getUserInfo() != null) {
                    this.F.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.F.J(currentAvatar, 12, false);
                    }
                }
                this.F.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (m()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.G.setLayoutParams(layoutParams);
                    this.F.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f09144d);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.I.setLayoutParams(layoutParams2);
                    this.H.setLayoutParams(layoutParams2);
                }
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.H.setVisibility(4);
                this.I.setVisibility(4);
                this.K.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.C.setVisibility(0);
                            break;
                        case 2:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aaa);
                            break;
                        case 3:
                            this.C.setVisibility(8);
                            if (this.t) {
                                if (chatMessage.isHasRead()) {
                                    this.H.setVisibility(0);
                                    this.I.setVisibility(4);
                                    break;
                                } else {
                                    this.H.setVisibility(4);
                                    this.I.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aac);
                            break;
                        case 5:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aad);
                            break;
                        case 6:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aab);
                            break;
                        case 7:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aa9);
                            break;
                        case 8:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0aa8);
                            break;
                        case 9:
                            this.D.setVisibility(0);
                            this.K.setVisibility(0);
                            if (oi.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.J.setText(R.string.obfuscated_res_0x7f0f0aaa);
                                break;
                            } else {
                                e67 f = e67.f(this.J.getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.J);
                                    f.j(new b(this, chatMessage));
                                    break;
                                } else {
                                    this.J.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                    }
                }
                if (this.D.getVisibility() == 0) {
                    this.D.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                u(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    M(chatMessage, M);
                } else if (msgType == 2) {
                    L(view2, chatMessage, M);
                } else if (msgType == 3) {
                    O(chatMessage, M);
                    this.k.setVisibility(0);
                } else if (msgType == 4) {
                    F(chatMessage, true);
                } else if (msgType == 9) {
                    G(view2, chatMessage, M);
                } else if (msgType == 32) {
                    N(chatMessage);
                } else if (msgType != 33) {
                } else {
                    H(chatMessage);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
