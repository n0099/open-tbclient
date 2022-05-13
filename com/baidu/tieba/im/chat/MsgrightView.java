package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.repackage.e47;
import com.repackage.gs4;
import com.repackage.li;
import com.repackage.mi;
/* loaded from: classes3.dex */
public class MsgrightView extends e47 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String I = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar B;
    public ImageView C;
    public TextView D;
    public HeadImageView E;
    public TextView F;
    public TextView G;
    public EMTextView H;

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
                msgrightView.b.onItemViewClick(view2, 6, msgrightView.f, 0L);
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
                msgrightView.b.onItemViewClick(view2, 1, msgrightView.f, 0L);
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0552);
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
        l();
        this.D = (TextView) e(R.id.obfuscated_res_0x7f090ecd);
        this.B = (ProgressBar) e(R.id.obfuscated_res_0x7f091975);
        this.C = (ImageView) e(R.id.obfuscated_res_0x7f090429);
        this.E = (HeadImageView) e(R.id.obfuscated_res_0x7f090ecc);
        EMTextView eMTextView = (EMTextView) e(R.id.obfuscated_res_0x7f091411);
        this.H = eMTextView;
        gs4 d = gs4.d(eMTextView);
        d.z(R.dimen.T_X09);
        d.A(R.string.F_X01);
        d.n(R.string.J_X05);
        d.f(R.color.CAM_X0603);
        this.E.setAutoChangeStyle(false);
        this.E.setDrawerType(1);
        this.E.setRadius(mi.d(this.mContext.getContext(), 4.0f));
        this.E.setPlaceHolder(1);
        this.E.setOnClickListener(new a(this));
        this.F = (TextView) e(R.id.obfuscated_res_0x7f090d0d);
        this.G = (TextView) e(R.id.obfuscated_res_0x7f090d0e);
        this.n.setIsLeft(false);
        this.o.setIsLeft(false);
    }

    @Override // com.repackage.e47
    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.A == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.n();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_me);
        this.r.q(I);
        SkinManager.setBackgroundResource(this.o, R.drawable.selector_msg_text_bubble_me);
        SkinManager.setBackgroundResource(this.n, R.drawable.selector_msg_text_bubble_me);
        this.k.f(I);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
    }

    @Override // com.repackage.e47
    public void q(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.q(view2, chatMessage);
            if (chatMessage == null) {
                this.i.setVisibility(8);
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.F.setVisibility(4);
                this.G.setVisibility(4);
                this.H.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(null);
                s(8);
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
                F(chatMessage);
                M(chatMessage);
                this.E.setDefaultResource(R.drawable.obfuscated_res_0x7f080efb);
                if (chatMessage.getUserInfo() != null) {
                    this.E.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.E.K(currentAvatar, 12, false);
                    }
                }
                this.E.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.F.setVisibility(4);
                this.G.setVisibility(4);
                this.H.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    switch (chatMessage.getLocalData().getStatus().shortValue()) {
                        case 1:
                            this.B.setVisibility(0);
                            break;
                        case 2:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac4);
                            break;
                        case 3:
                            this.B.setVisibility(8);
                            if (this.t) {
                                if (chatMessage.isHasRead()) {
                                    this.F.setVisibility(0);
                                    this.G.setVisibility(4);
                                    break;
                                } else {
                                    this.F.setVisibility(4);
                                    this.G.setVisibility(0);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac6);
                            break;
                        case 5:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac7);
                            break;
                        case 6:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac5);
                            break;
                        case 7:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac3);
                            break;
                        case 8:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ac2);
                            break;
                        case 9:
                            this.C.setVisibility(0);
                            this.H.setVisibility(0);
                            if (li.isEmpty(chatMessage.getLocalData().getErrorString())) {
                                this.H.setText(R.string.obfuscated_res_0x7f0f0ac4);
                                break;
                            } else {
                                this.H.setText(chatMessage.getLocalData().getErrorString());
                                break;
                            }
                    }
                }
                if (this.C.getVisibility() == 0) {
                    this.C.setOnClickListener(new b(this));
                }
                this.j.setVisibility(8);
                s(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    I(chatMessage, I);
                } else if (msgType == 2) {
                    H(view2, chatMessage, I);
                } else if (msgType == 3) {
                    L(chatMessage, I);
                    this.k.setVisibility(0);
                } else if (msgType == 4) {
                    C(chatMessage, true);
                } else if (msgType == 9) {
                    D(view2, chatMessage, I);
                } else if (msgType == 32) {
                    K(chatMessage);
                } else if (msgType != 33) {
                } else {
                    E(chatMessage);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.repackage.e47
    public void z(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.D.getVisibility() != 8) {
                    this.D.setVisibility(8);
                    this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.q.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.D;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.D.setVisibility(0);
            } else if (this.D.getVisibility() != 8) {
                this.D.setVisibility(8);
                this.q.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
