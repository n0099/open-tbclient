package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.l1.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MsgleftView extends e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnLongClickListener A;
    public HeadImageView t;
    public TextView u;
    public ViewGroup v;
    public UserIconBox w;
    public ImageView x;
    public final TouchType y;
    public TbPageContext<MsglistActivity<?>> z;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f50191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MsgleftView f50192f;

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
            this.f50192f = msgleftView;
            this.f50191e = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f50191e = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.f50191e > 200) {
                        if (this.f50192f.y.get()) {
                            MsgleftView msgleftView = this.f50192f;
                            msgleftView.f19989c.onItemViewLongClick(view, 2, msgleftView.f19992f, 0L);
                            this.f50192f.y.set(false);
                        }
                    } else {
                        MsgleftView msgleftView2 = this.f50192f;
                        msgleftView2.f19988b.onItemViewClick(view, 2, msgleftView2.f19992f, 0L);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgleftView f50193e;

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
            this.f50193e = msgleftView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f50193e.y.set(true);
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
        super(tbPageContext, R.layout.msg_msgleft_view);
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
        this.y = new TouchType();
        this.A = new b(this);
        this.z = tbPageContext;
        f();
        this.x = (ImageView) c(R.id.iv_live_group_host);
        this.u = (TextView) c(R.id.tex_msgitem_name);
        this.v = (ViewGroup) c(R.id.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) c(R.id.img_msgitem_photo);
        this.t = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.t.setDrawerType(1);
        this.t.setRadius(l.e(this.z.getContext(), 4.0f));
        this.t.setPlaceHolder(1);
        this.w = (UserIconBox) c(R.id.user_tshow_icon_box);
        this.t.setLongClickable(true);
        this.t.setOnLongClickListener(this.A);
        this.t.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    public final void A(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String p = b.a.q0.s.e0.b.j().p("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(p)) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.q) {
                this.u.setVisibility(0);
                this.w.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.v.setLayoutParams(marginLayoutParams);
            this.w.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.q) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i2 = R.drawable.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i2 = R.drawable.icon_pop_qz_girl;
                }
                if (!this.q) {
                    i2 = 0;
                }
                this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
            }
            i2 = 0;
            if (!this.q) {
            }
            this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0154 A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #0 {Exception -> 0x015a, blocks: (B:17:0x00a1, B:19:0x00a7, B:20:0x00c9, B:22:0x00d5, B:25:0x00e0, B:27:0x00ef, B:39:0x0138, B:40:0x013e, B:41:0x0144, B:42:0x0148, B:43:0x014e, B:44:0x0154, B:26:0x00e8), top: B:52:0x00a1 }] */
    @Override // b.a.r0.l1.f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(View view, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, view, chatMessage) != null) {
            return;
        }
        super.i(view, chatMessage);
        String str = null;
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        B();
        UserIconBox userIconBox = this.w;
        if (userIconBox != null && this.q) {
            userIconBox.setVisibility(0);
            this.w.setAutoChangedStyle(false);
            Resources resources = this.z.getResources();
            this.w.loadIcon(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.u.setText((CharSequence) null);
            this.f19995i.setVisibility(0);
            this.f19995i.setText(null);
            j(8);
            this.p.getImage().setTag(null);
            this.j.setVisibility(8);
            this.j.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.x.setVisibility(8);
            return;
        }
        u(chatMessage);
        D(chatMessage);
        this.u.setText("");
        A(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.u.setText(chatMessage.getUserInfo().getName_show());
                this.t.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                this.t.startLoad(str, 12, false);
                this.t.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.f19995i.setVisibility(8);
                j(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    x(chatMessage, B);
                    return;
                } else if (msgType == 2) {
                    w(view, chatMessage, B);
                    return;
                } else if (msgType == 3) {
                    y(chatMessage, B);
                    return;
                } else if (msgType == 4) {
                    s(chatMessage, false);
                    return;
                } else if (msgType == 5) {
                    v(view, chatMessage, B);
                    return;
                } else if (msgType != 9) {
                    return;
                } else {
                    t(view, chatMessage, B);
                    return;
                }
            }
            this.t.startLoad(str, 10, false);
            this.t.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.f19995i.setVisibility(8);
            j(8);
            this.j.setVisibility(8);
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
