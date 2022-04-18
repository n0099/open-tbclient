package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.repackage.d57;
import com.repackage.oi;
import com.repackage.vt4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MsgleftView extends d57 {
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

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ MsgleftView b;

        public a(MsgleftView msgleftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgleftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = msgleftView;
            this.a = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.a > 200) {
                        if (this.b.D.get()) {
                            MsgleftView msgleftView = this.b;
                            msgleftView.c.onItemViewLongClick(view2, 2, msgleftView.f, 0L);
                            this.b.D.set(false);
                        }
                    } else {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.b.onItemViewClick(view2, 2, msgleftView2.f, 0L);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgleftView a;

        public b(MsgleftView msgleftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgleftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgleftView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.D.set(true);
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d055b);
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
        this.D = new TouchType();
        this.F = new b(this);
        this.E = tbPageContext;
        k();
        this.C = (ImageView) e(R.id.obfuscated_res_0x7f090fd9);
        this.z = (TextView) e(R.id.obfuscated_res_0x7f091f03);
        this.A = (ViewGroup) e(R.id.obfuscated_res_0x7f0903ef);
        HeadImageView headImageView = (HeadImageView) e(R.id.obfuscated_res_0x7f090ec0);
        this.y = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.y.setDrawerType(1);
        this.y.setRadius(oi.d(this.E.getContext(), 4.0f));
        this.y.setPlaceHolder(1);
        this.B = (UserIconBox) e(R.id.obfuscated_res_0x7f0922bf);
        this.y.setLongClickable(true);
        this.y.setOnLongClickListener(this.F);
        this.y.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    public final void K(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String q = vt4.k().q("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(q)) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
        }
    }

    public void L() {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.q) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i = R.drawable.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i = R.drawable.icon_pop_qz_girl;
                }
                if (!this.q) {
                    i = 0;
                }
                this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
            i = 0;
            if (!this.q) {
            }
            this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015a A[Catch: Exception -> 0x0160, TRY_LEAVE, TryCatch #0 {Exception -> 0x0160, blocks: (B:17:0x00a7, B:19:0x00ad, B:20:0x00cf, B:22:0x00db, B:25:0x00e6, B:27:0x00f5, B:39:0x013e, B:40:0x0144, B:41:0x014a, B:42:0x014e, B:43:0x0154, B:44:0x015a, B:26:0x00ee), top: B:52:0x00a7 }] */
    @Override // com.repackage.d57
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(View view2, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, view2, chatMessage) != null) {
            return;
        }
        super.n(view2, chatMessage);
        String str = null;
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        L();
        UserIconBox userIconBox = this.B;
        if (userIconBox != null && this.q) {
            userIconBox.setVisibility(0);
            this.B.setAutoChangedStyle(false);
            Resources resources = this.E.getResources();
            this.B.h(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305), true);
        }
        if (chatMessage == null) {
            this.z.setText((CharSequence) null);
            this.i.setVisibility(0);
            this.i.setText(null);
            p(8);
            this.p.getImage().setTag(null);
            this.j.setVisibility(8);
            this.j.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.C.setVisibility(8);
            return;
        }
        C(chatMessage);
        M(chatMessage);
        this.z.setText("");
        K(chatMessage);
        H(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.z.setText(chatMessage.getUserInfo().getName_show());
                this.y.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                this.y.K(str, 12, false);
                this.y.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.i.setVisibility(8);
                p(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    F(chatMessage, G);
                    return;
                } else if (msgType == 2) {
                    E(view2, chatMessage, G);
                    return;
                } else if (msgType == 3) {
                    G(chatMessage, G);
                    return;
                } else if (msgType == 4) {
                    A(chatMessage, false);
                    return;
                } else if (msgType == 5) {
                    D(view2, chatMessage, G);
                    return;
                } else if (msgType != 9) {
                    return;
                } else {
                    B(view2, chatMessage, G);
                    return;
                }
            }
            this.y.K(str, 10, false);
            this.y.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.i.setVisibility(8);
            p(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            msgType = chatMessage.getMsgType();
            if (msgType != 1) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
