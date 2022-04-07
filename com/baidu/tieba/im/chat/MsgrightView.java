package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a57;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class MsgrightView extends a57 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String E = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public TextView D;
    public ProgressBar y;
    public ImageButton z;

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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d055e);
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
        k();
        ChatImageWithTailView chatImageWithTailView = this.p;
        if (chatImageWithTailView != null && chatImageWithTailView.getImage() != null && (this.p.getImage() instanceof ChatClipImageItemView)) {
            this.p.getImage().setLeft(false);
        }
        this.A = (TextView) e(R.id.obfuscated_res_0x7f090ec0);
        this.y = (ProgressBar) e(R.id.obfuscated_res_0x7f09191c);
        this.z = (ImageButton) e(R.id.obfuscated_res_0x7f09042e);
        HeadImageView headImageView = (HeadImageView) e(R.id.obfuscated_res_0x7f090ebf);
        this.B = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.B.setDrawerType(1);
        this.B.setRadius(oi.d(this.mContext.getContext(), 4.0f));
        this.B.setPlaceHolder(1);
        this.B.setOnClickListener(new a(this));
        this.C = (TextView) e(R.id.obfuscated_res_0x7f090d1f);
        this.D = (TextView) e(R.id.obfuscated_res_0x7f090d20);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // com.repackage.a57
    public void n(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatMessage) == null) {
            super.n(view2, chatMessage);
            if (chatMessage == null) {
                this.h.setVisibility(8);
                this.y.setVisibility(8);
                this.z.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.i.setVisibility(0);
                this.i.setText(null);
                p(8);
                this.p.getImage().setTag(null);
                this.j.setVisibility(8);
                this.j.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                return;
            }
            try {
                C(chatMessage);
                H(chatMessage);
                this.B.setDefaultResource(R.drawable.obfuscated_res_0x7f080edc);
                if (chatMessage.getUserInfo() != null) {
                    this.B.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.B.K(currentAvatar, 12, false);
                    }
                }
                this.B.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.y.setVisibility(8);
                this.z.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    short shortValue = chatMessage.getLocalData().getStatus().shortValue();
                    if (shortValue == 1) {
                        this.y.setVisibility(0);
                    } else if (shortValue == 2) {
                        this.z.setVisibility(0);
                    } else if (shortValue == 3) {
                        this.y.setVisibility(8);
                        if (this.r) {
                            if (chatMessage.isHasRead()) {
                                this.C.setVisibility(0);
                                this.D.setVisibility(8);
                            } else {
                                this.C.setVisibility(8);
                                this.D.setVisibility(0);
                            }
                        }
                    }
                }
                if (this.z.getVisibility() == 0) {
                    this.z.setOnClickListener(new b(this));
                }
                this.i.setVisibility(8);
                p(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    F(chatMessage, E);
                } else if (msgType == 2) {
                    E(view2, chatMessage, E);
                } else if (msgType == 3) {
                    G(chatMessage, E);
                    this.j.setVisibility(0);
                } else if (msgType == 4) {
                    A(chatMessage, true);
                } else if (msgType != 9) {
                } else {
                    B(view2, chatMessage, E);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.repackage.a57
    public void x(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.A.getVisibility() != 8) {
                    this.A.setVisibility(8);
                    this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.A;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.A.setVisibility(0);
            } else if (this.A.getVisibility() != 8) {
                this.A.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
