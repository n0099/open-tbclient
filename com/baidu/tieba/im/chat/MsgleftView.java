package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.t1.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class MsgleftView extends e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String G = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup A;
    public UserIconBox B;
    public ImageView C;
    public final TouchType D;
    public TbPageContext<MsglistActivity<?>> E;
    public View.OnLongClickListener F;
    public HeadImageView y;
    public TextView z;

    /* loaded from: classes12.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f44979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MsgleftView f44980f;

        public a(MsgleftView msgleftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgleftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44980f = msgleftView;
            this.f44979e = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f44979e = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.f44979e > 200) {
                        if (this.f44980f.D.get()) {
                            MsgleftView msgleftView = this.f44980f;
                            msgleftView.f22419c.onItemViewLongClick(view, 2, msgleftView.f22422f, 0L);
                            this.f44980f.D.set(false);
                        }
                    } else {
                        MsgleftView msgleftView2 = this.f44980f;
                        msgleftView2.f22418b.onItemViewClick(view, 2, msgleftView2.f22422f, 0L);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgleftView f44981e;

        public b(MsgleftView msgleftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgleftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44981e = msgleftView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f44981e.D.set(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1300635688, "Lcom/baidu/tieba/im/chat/MsgleftView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1300635688, "Lcom/baidu/tieba/im/chat/MsgleftView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, h.msg_msgleft_view);
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
        this.D = new TouchType();
        this.F = new b(this);
        this.E = tbPageContext;
        k();
        this.C = (ImageView) c(g.iv_live_group_host);
        this.z = (TextView) c(g.tex_msgitem_name);
        this.A = (ViewGroup) c(g.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) c(g.img_msgitem_photo);
        this.y = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.y.setDrawerType(1);
        this.y.setRadius(n.d(this.E.getContext(), 4.0f));
        this.y.setPlaceHolder(1);
        this.B = (UserIconBox) c(g.user_tshow_icon_box);
        this.y.setLongClickable(true);
        this.y.setOnLongClickListener(this.F);
        this.y.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    public final void I(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String q = c.a.t0.s.j0.b.k().q("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(q)) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.q) {
                this.z.setVisibility(0);
                this.B.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.A.setLayoutParams(marginLayoutParams);
            this.B.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.q) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i2 = f.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i2 = f.icon_pop_qz_girl;
                }
                if (!this.q) {
                    i2 = 0;
                }
                this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
            }
            i2 = 0;
            if (!this.q) {
            }
            this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0157 A[Catch: Exception -> 0x015d, TRY_LEAVE, TryCatch #0 {Exception -> 0x015d, blocks: (B:17:0x00a4, B:19:0x00aa, B:20:0x00cc, B:22:0x00d8, B:25:0x00e3, B:27:0x00f2, B:39:0x013b, B:40:0x0141, B:41:0x0147, B:42:0x014b, B:43:0x0151, B:44:0x0157, B:26:0x00eb), top: B:52:0x00a4 }] */
    @Override // c.a.u0.t1.f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(View view, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, view, chatMessage) != null) {
            return;
        }
        super.n(view, chatMessage);
        String str = null;
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        J();
        UserIconBox userIconBox = this.B;
        if (userIconBox != null && this.q) {
            userIconBox.setVisibility(0);
            this.B.setAutoChangedStyle(false);
            Resources resources = this.E.getResources();
            this.B.loadIcon(tShowInfoNew, 2, resources.getDimensionPixelSize(c.a.u0.a4.e.ds32), resources.getDimensionPixelSize(c.a.u0.a4.e.ds32), resources.getDimensionPixelSize(c.a.u0.a4.e.ds8), true);
        }
        if (chatMessage == null) {
            this.z.setText((CharSequence) null);
            this.f22425i.setVisibility(0);
            this.f22425i.setText(null);
            p(8);
            this.p.getImage().setTag(null);
            this.f22426j.setVisibility(8);
            this.f22426j.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.C.setVisibility(8);
            return;
        }
        B(chatMessage);
        K(chatMessage);
        this.z.setText("");
        I(chatMessage);
        G(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.z.setText(chatMessage.getUserInfo().getName_show());
                this.y.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                this.y.startLoad(str, 12, false);
                this.y.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.f22425i.setVisibility(8);
                p(8);
                this.f22426j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    E(chatMessage, G);
                    return;
                } else if (msgType == 2) {
                    D(view, chatMessage, G);
                    return;
                } else if (msgType == 3) {
                    F(chatMessage, G);
                    return;
                } else if (msgType == 4) {
                    z(chatMessage, false);
                    return;
                } else if (msgType == 5) {
                    C(view, chatMessage, G);
                    return;
                } else if (msgType != 9) {
                    return;
                } else {
                    A(view, chatMessage, G);
                    return;
                }
            }
            this.y.startLoad(str, 10, false);
            this.y.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.f22425i.setVisibility(8);
            p(8);
            this.f22426j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            msgType = chatMessage.getMsgType();
            if (msgType != 1) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
