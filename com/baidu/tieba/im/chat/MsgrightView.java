package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.l1.f.e;
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
/* loaded from: classes9.dex */
public class MsgrightView extends e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String z = "com.baidu.tieba.im.chat.MsgrightView";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar t;
    public ImageButton u;
    public TextView v;
    public HeadImageView w;
    public TextView x;
    public TextView y;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgrightView f50193e;

        public a(MsgrightView msgrightView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgrightView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50193e = msgrightView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MsgrightView msgrightView = this.f50193e;
                msgrightView.f19988b.onItemViewClick(view, 6, msgrightView.f19992f, 0L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgrightView f50194e;

        public b(MsgrightView msgrightView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgrightView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50194e = msgrightView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MsgrightView msgrightView = this.f50194e;
                msgrightView.f19988b.onItemViewClick(view, 1, msgrightView.f19992f, 0L);
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
        super(tbPageContext, R.layout.msg_msgright_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f();
        ChatImageWithTailView chatImageWithTailView = this.p;
        if (chatImageWithTailView != null && chatImageWithTailView.getImage() != null && (this.p.getImage() instanceof ChatClipImageItemView)) {
            this.p.getImage().setLeft(false);
        }
        this.v = (TextView) c(R.id.img_msgitem_progressbar);
        this.t = (ProgressBar) c(R.id.progress);
        this.u = (ImageButton) c(R.id.btn_msgitem_resend);
        HeadImageView headImageView = (HeadImageView) c(R.id.img_msgitem_photo);
        this.w = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.w.setDrawerType(1);
        this.w.setRadius(l.e(this.mContext.getContext(), 4.0f));
        this.w.setPlaceHolder(1);
        this.w.setOnClickListener(new a(this));
        this.x = (TextView) c(R.id.has_read);
        this.y = (TextView) c(R.id.has_sent);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // b.a.r0.l1.f.e
    public void i(View view, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, chatMessage) == null) {
            super.i(view, chatMessage);
            if (chatMessage == null) {
                this.f19994h.setVisibility(8);
                this.t.setVisibility(8);
                this.u.setVisibility(8);
                this.x.setVisibility(8);
                this.y.setVisibility(8);
                this.f19995i.setVisibility(0);
                this.f19995i.setText(null);
                j(8);
                this.p.getImage().setTag(null);
                this.j.setVisibility(8);
                this.j.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                return;
            }
            try {
                u(chatMessage);
                this.w.setDefaultResource(R.drawable.photo);
                if (chatMessage.getUserInfo() != null) {
                    this.w.setUserId(chatMessage.getUserInfo().getUserId());
                    String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                    if (currentAvatar != null && currentAvatar.length() > 0) {
                        this.w.startLoad(currentAvatar, 12, false);
                    }
                }
                this.w.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.t.setVisibility(8);
                this.u.setVisibility(8);
                this.x.setVisibility(8);
                this.y.setVisibility(8);
                if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                    short shortValue = chatMessage.getLocalData().getStatus().shortValue();
                    if (shortValue == 1) {
                        this.t.setVisibility(0);
                    } else if (shortValue == 2) {
                        this.u.setVisibility(0);
                    } else if (shortValue == 3) {
                        this.t.setVisibility(8);
                        if (this.r) {
                            if (chatMessage.isHasRead()) {
                                this.x.setVisibility(0);
                                this.y.setVisibility(8);
                            } else {
                                this.x.setVisibility(8);
                                this.y.setVisibility(0);
                            }
                        }
                    }
                }
                if (this.u.getVisibility() == 0) {
                    this.u.setOnClickListener(new b(this));
                }
                this.f19995i.setVisibility(8);
                j(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                int msgType = chatMessage.getMsgType();
                if (msgType == 1) {
                    x(chatMessage, z);
                } else if (msgType == 2) {
                    w(view, chatMessage, z);
                } else if (msgType == 3) {
                    y(chatMessage, z);
                    this.j.setVisibility(0);
                } else if (msgType == 4) {
                    s(chatMessage, true);
                } else if (msgType != 9) {
                } else {
                    t(view, chatMessage, z);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // b.a.r0.l1.f.e
    public void q(View view, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, chatMessage) == null) {
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
                if (this.v.getVisibility() != 8) {
                    this.v.setVisibility(8);
                    this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
                }
            } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
                this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
                TextView textView = this.v;
                textView.setText(chatMessage.getProgressValue() + "%");
                this.v.setVisibility(0);
            } else if (this.v.getVisibility() != 8) {
                this.v.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}
