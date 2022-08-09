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
import com.repackage.a67;
import com.repackage.ms4;
import com.repackage.oz7;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.y77;
/* loaded from: classes3.dex */
public class MsgrightView extends a67 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String O = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar E;
    public ImageView F;
    public TextView G;
    public HeadImageView H;
    public FrameLayout I;
    public TextView J;
    public TextView K;
    public CenterTextView L;
    public RelativeLayout M;
    public oz7 N;

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
                msgrightView.b.o(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements y77.d {
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

        @Override // com.repackage.y77.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!str.contains(TbConfig.URL_UEG_REPORT)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) this.b.mContext, new String[]{str}, true);
                    return;
                }
                oz7 oz7Var = this.b.N;
                if (oz7Var != null) {
                    oz7Var.c(String.valueOf(this.a.getUserInfo().getUserId()));
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
                msgrightView.b.o(view2, 1, msgrightView.f, 0L);
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
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext, oz7 oz7Var) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0585);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, oz7Var};
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
        this.N = null;
        this.N = oz7Var;
        q();
        this.G = (TextView) j(R.id.obfuscated_res_0x7f090ed8);
        this.E = (ProgressBar) j(R.id.obfuscated_res_0x7f091a78);
        this.F = (ImageView) j(R.id.obfuscated_res_0x7f09043b);
        this.H = (HeadImageView) j(R.id.obfuscated_res_0x7f090ed7);
        this.L = (CenterTextView) j(R.id.obfuscated_res_0x7f092364);
        this.M = (RelativeLayout) j(R.id.obfuscated_res_0x7f091c0a);
        this.I = (FrameLayout) j(R.id.obfuscated_res_0x7f091502);
        ms4 d = ms4.d(this.M);
        d.n(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        ms4 d2 = ms4.d(this.L);
        d2.z(R.dimen.T_X09);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0101);
        this.H.setAutoChangeStyle(false);
        this.H.setDrawerType(1);
        this.H.setRadius(qi.d(this.mContext.getContext(), 4.0f));
        this.H.setPlaceHolder(1);
        this.H.setOnClickListener(new a(this));
        this.J = (TextView) j(R.id.obfuscated_res_0x7f090d08);
        this.K = (TextView) j(R.id.obfuscated_res_0x7f090d09);
        this.n.setIsLeft(false);
        this.o.setIsLeft(false);
    }

    @Override // com.repackage.a67
    public void E(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.G.getVisibility() != 8) {
                    this.G.setVisibility(8);
                    this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.q.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.G;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.G.setVisibility(0);
            } else if (this.G.getVisibility() != 8) {
                this.G.setVisibility(8);
                this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override // com.repackage.a67
    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.D == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.s();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.r.p(O);
        this.s.l(O);
        SkinManager.setBackgroundResource(this.o, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        this.k.f(O);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
    }

    @Override // com.repackage.a67
    public void u(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            super.u(view2, chatMessage);
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.E.setVisibility(8);
                this.F.setVisibility(8);
                this.J.setVisibility(4);
                this.K.setVisibility(4);
                this.M.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                w(8);
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
                M(chatMessage);
                S(chatMessage);
                this.H.setDefaultResource(R.drawable.obfuscated_res_0x7f080ee3);
                if (chatMessage.getUserInfo() != null) {
                    this.H.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.H.K(currentAvatar, 12, false);
                    }
                }
                this.H.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (o()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.I.setLayoutParams(layoutParams);
                    this.H.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f0914f7);
                    layoutParams2.rightMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                    layoutParams2.topMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X002);
                    layoutParams2.bottomMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.K.setLayoutParams(layoutParams2);
                    this.J.setLayoutParams(layoutParams2);
                }
                this.E.setVisibility(8);
                this.F.setVisibility(8);
                this.J.setVisibility(4);
                this.K.setVisibility(4);
                this.M.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.E.setVisibility(0);
                            break;
                        case 2:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0ace);
                            break;
                        case 3:
                            this.E.setVisibility(8);
                            if (this.v) {
                                if (chatMessage.isHasRead()) {
                                    this.J.setVisibility(0);
                                    this.K.setVisibility(4);
                                    break;
                                } else {
                                    this.J.setVisibility(4);
                                    this.K.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0ad0);
                            break;
                        case 5:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0ad1);
                            break;
                        case 6:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0acf);
                            break;
                        case 7:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0acd);
                            break;
                        case 8:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            this.L.setText(R.string.obfuscated_res_0x7f0f0acc);
                            break;
                        case 9:
                            this.F.setVisibility(0);
                            this.M.setVisibility(0);
                            if (pi.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.L.setText(R.string.obfuscated_res_0x7f0f0ace);
                                break;
                            } else {
                                y77 f = y77.f(this.L.getContext());
                                if (f.i(chatMessage.getLocalData().getErrorString())) {
                                    f.g(chatMessage.getLocalData().getErrorString());
                                    f.h(this.L);
                                    f.j(new b(this, chatMessage));
                                    break;
                                } else {
                                    this.L.setText(chatMessage.getLocalData().getErrorString());
                                    break;
                                }
                            }
                    }
                }
                if (this.F.getVisibility() == 0) {
                    this.F.setOnClickListener(new c(this));
                }
                this.j.setVisibility(8);
                w(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    P(chatMessage, O);
                } else if (msgType == 2) {
                    O(view2, chatMessage, O);
                } else if (msgType == 3) {
                    R(chatMessage, O);
                    this.k.setVisibility(0);
                } else if (msgType == 4) {
                    H(chatMessage, true);
                } else if (msgType != 9) {
                    switch (msgType) {
                        case 32:
                            Q(chatMessage);
                            return;
                        case 33:
                            K(chatMessage);
                            return;
                        case 34:
                            L(chatMessage);
                            return;
                        default:
                            return;
                    }
                } else {
                    J(view2, chatMessage, O);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
