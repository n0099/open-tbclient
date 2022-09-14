package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.bx4;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.m77;
import com.baidu.tieba.y97;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MsgleftView extends m77 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String O = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView F;
    public TextView G;
    public ViewGroup H;
    public UserIconBox I;
    public ImageView J;
    public final TouchType K;
    public TbPageContext<MsglistActivity<?>> L;
    public ImMessageCenterPojo M;
    public View.OnLongClickListener N;

    /* loaded from: classes4.dex */
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
                        if (this.b.K.get()) {
                            MsgleftView msgleftView = this.b;
                            msgleftView.c.y(view2, 2, msgleftView.f, 0L);
                            this.b.K.set(false);
                        }
                    } else {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.b.q(view2, 2, msgleftView2.f, 0L);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.K.set(true);
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d059b);
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
        this.K = new TouchType();
        this.N = new b(this);
        this.L = tbPageContext;
        r();
        this.J = (ImageView) j(R.id.obfuscated_res_0x7f091013);
        this.G = (TextView) j(R.id.obfuscated_res_0x7f0920f8);
        this.H = (ViewGroup) j(R.id.obfuscated_res_0x7f090407);
        HeadImageView headImageView = (HeadImageView) j(R.id.obfuscated_res_0x7f090ef3);
        this.F = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.F.setDrawerType(1);
        this.F.setRadius(ej.d(this.L.getContext(), 4.0f));
        this.F.setPlaceHolder(1);
        this.I = (UserIconBox) j(R.id.obfuscated_res_0x7f0924d6);
        this.F.setLongClickable(true);
        this.F.setOnLongClickListener(this.N);
        this.F.setOnTouchListener(new a(this));
        this.n.setIsLeft(true);
        this.o.setIsLeft(true);
    }

    public final void V(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String q = bx4.k().q("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(q)) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.u) {
                this.G.setVisibility(0);
                this.I.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.H.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.H.setLayoutParams(marginLayoutParams);
            this.I.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.u) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i = R.drawable.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i = R.drawable.icon_pop_qz_girl;
                }
                if (!this.u) {
                    i = 0;
                }
                this.G.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
            i = 0;
            if (!this.u) {
            }
            this.G.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    @Override // com.baidu.tieba.m77
    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.D == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.t();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_other);
        this.r.p(O);
        this.s.l(O);
        this.k.f(O);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x013f A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:17:0x00b1, B:19:0x00b7, B:20:0x00d9, B:22:0x00e6, B:25:0x00f1, B:27:0x00f5, B:28:0x0107, B:30:0x010b, B:32:0x0117, B:33:0x011d, B:35:0x012c, B:37:0x013f, B:38:0x0162, B:50:0x01aa, B:52:0x01ae, B:53:0x01b2, B:54:0x01b6, B:55:0x01ba, B:56:0x01c0, B:57:0x01c6, B:58:0x01ca, B:59:0x01d0, B:60:0x01d6, B:34:0x0125), top: B:68:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0198  */
    @Override // com.baidu.tieba.m77
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(View view2, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, chatMessage) == null) {
            super.v(view2, chatMessage);
            String str = null;
            ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
            W();
            UserIconBox userIconBox = this.I;
            if (userIconBox != null && this.u) {
                userIconBox.setVisibility(0);
                this.I.setAutoChangedStyle(false);
                Resources resources = this.L.getResources();
                this.I.h(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302), true);
            }
            if (chatMessage == null) {
                this.G.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                x(8);
                this.q.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.m.setTag(null);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.J.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                return;
            }
            N(chatMessage);
            X(chatMessage);
            this.G.setText("");
            V(chatMessage);
            T(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.G.setText(chatMessage.getUserInfo().getName_show());
                    this.F.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.M == null) {
                        this.M = y97.o().i(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.M != null && !TextUtils.isEmpty(this.M.getGroup_head())) {
                        str = this.M.getGroup_head();
                    }
                    this.F.K(str, 12, false);
                    this.F.setContentDescription(chatMessage.getUserInfo().getName_show());
                    if (p()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
                        layoutParams.leftMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        this.H.setLayoutParams(layoutParams);
                        this.F.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                    x(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    this.m.setVisibility(8);
                    this.o.setVisibility(8);
                    this.n.setVisibility(8);
                    this.p.setVisibility(8);
                    this.r.setVisibility(8);
                    this.s.setVisibility(8);
                    msgType = chatMessage.getMsgType();
                    if (msgType != 1) {
                        if (msgType == 2) {
                            P(view2, chatMessage, O);
                            return;
                        } else if (msgType == 3) {
                            S(chatMessage, O);
                            return;
                        } else if (msgType == 4) {
                            I(chatMessage, false);
                            return;
                        } else if (msgType == 5) {
                            O(view2, chatMessage, O);
                            return;
                        } else if (msgType == 9) {
                            K(view2, chatMessage, O);
                            return;
                        } else if (msgType != 30) {
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
                        }
                    }
                    Q(chatMessage, O);
                }
                this.F.K(str, 10, false);
                this.F.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (p()) {
                }
                this.j.setVisibility(8);
                x(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                }
                Q(chatMessage, O);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
