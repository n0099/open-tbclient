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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.repackage.fr4;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.q37;
/* loaded from: classes3.dex */
public class MsgrightView extends q37 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String K = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar C;
    public ImageView D;
    public TextView E;
    public HeadImageView F;
    public FrameLayout G;
    public TextView H;
    public TextView I;
    public EMTextView J;

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
                msgrightView.b.i(view2, 6, msgrightView.f, 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgrightView a;

        public b(MsgrightView msgrightView) {
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
                msgrightView.b.i(view2, 1, msgrightView.f, 0L);
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
    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0545);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        o();
        this.E = (TextView) a(R.id.obfuscated_res_0x7f090e84);
        this.C = (ProgressBar) a(R.id.obfuscated_res_0x7f09191e);
        this.D = (ImageView) a(R.id.obfuscated_res_0x7f09041f);
        this.F = (HeadImageView) a(R.id.obfuscated_res_0x7f090e83);
        this.J = (EMTextView) a(R.id.obfuscated_res_0x7f0913c9);
        this.G = (FrameLayout) a(R.id.obfuscated_res_0x7f0913d4);
        fr4 d = fr4.d(this.J);
        d.z(R.dimen.T_X09);
        d.A(R.string.F_X01);
        d.n(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        this.F.setAutoChangeStyle(false);
        this.F.setDrawerType(1);
        this.F.setRadius(pi.d(this.mContext.getContext(), 4.0f));
        this.F.setPlaceHolder(1);
        this.F.setOnClickListener(new a(this));
        this.H = (TextView) a(R.id.obfuscated_res_0x7f090cc1);
        this.I = (TextView) a(R.id.obfuscated_res_0x7f090cc2);
        this.n.setIsLeft(false);
        this.o.setIsLeft(false);
    }

    @Override // com.repackage.q37
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

    @Override // com.repackage.q37
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.B == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.q();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.r.p(K);
        SkinManager.setBackgroundResource(this.o, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        this.k.f(K);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
    }

    @Override // com.repackage.q37
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
                this.J.setVisibility(8);
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
                this.F.setDefaultResource(R.drawable.obfuscated_res_0x7f080efc);
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
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f0913c8);
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
                this.J.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.C.setVisibility(0);
                            break;
                        case 2:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0acf);
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
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0ad1);
                            break;
                        case 5:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0ad2);
                            break;
                        case 6:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0ad0);
                            break;
                        case 7:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0ace);
                            break;
                        case 8:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            this.J.setText(R.string.obfuscated_res_0x7f0f0acd);
                            break;
                        case 9:
                            this.D.setVisibility(0);
                            this.J.setVisibility(0);
                            if (oi.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.J.setText(R.string.obfuscated_res_0x7f0f0acf);
                                break;
                            } else {
                                this.J.setText(chatMessage.getLocalData().getErrorString());
                                break;
                            }
                    }
                }
                if (this.D.getVisibility() == 0) {
                    this.D.setOnClickListener(new b(this));
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
                    M(chatMessage, K);
                } else if (msgType == 2) {
                    L(view2, chatMessage, K);
                } else if (msgType == 3) {
                    O(chatMessage, K);
                    this.k.setVisibility(0);
                } else if (msgType == 4) {
                    F(chatMessage, true);
                } else if (msgType == 9) {
                    G(view2, chatMessage, K);
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
