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
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g47;
import com.repackage.pi;
import com.repackage.s67;
import com.repackage.xt4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MsgleftView extends g47 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String L = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView C;
    public TextView D;
    public ViewGroup E;
    public UserIconBox F;
    public ImageView G;
    public final TouchType H;
    public TbPageContext<MsglistActivity<?>> I;
    public ImMessageCenterPojo J;
    public View.OnLongClickListener K;

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
                        if (this.b.H.get()) {
                            MsgleftView msgleftView = this.b;
                            msgleftView.c.m(view2, 2, msgleftView.f, 0L);
                            this.b.H.set(false);
                        }
                    } else {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.b.h(view2, 2, msgleftView2.f, 0L);
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
                this.a.H.set(true);
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d055c);
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
        this.H = new TouchType();
        this.K = new b(this);
        this.I = tbPageContext;
        o();
        this.G = (ImageView) a(R.id.obfuscated_res_0x7f090fa8);
        this.D = (TextView) a(R.id.obfuscated_res_0x7f091fa4);
        this.E = (ViewGroup) a(R.id.obfuscated_res_0x7f0903e1);
        HeadImageView headImageView = (HeadImageView) a(R.id.obfuscated_res_0x7f090e92);
        this.C = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.C.setDrawerType(1);
        this.C.setRadius(pi.d(this.I.getContext(), 4.0f));
        this.C.setPlaceHolder(1);
        this.F = (UserIconBox) a(R.id.obfuscated_res_0x7f09234f);
        this.C.setLongClickable(true);
        this.C.setOnLongClickListener(this.K);
        this.C.setOnTouchListener(new a(this));
        this.n.setIsLeft(true);
        this.o.setIsLeft(true);
    }

    public final void R(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String q = xt4.k().q("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(q)) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.s) {
                this.D.setVisibility(0);
                this.F.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.E.setLayoutParams(marginLayoutParams);
            this.F.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.s) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i = R.drawable.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i = R.drawable.icon_pop_qz_girl;
                }
                if (!this.s) {
                    i = 0;
                }
                this.D.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
            i = 0;
            if (!this.s) {
            }
            this.D.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    @Override // com.repackage.g47
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.B == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.q();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_other);
        this.r.p(L);
        this.k.f(L);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x013a A[Catch: Exception -> 0x01d3, TryCatch #0 {Exception -> 0x01d3, blocks: (B:17:0x00ac, B:19:0x00b2, B:20:0x00d4, B:22:0x00e1, B:25:0x00ec, B:27:0x00f0, B:28:0x0102, B:30:0x0106, B:32:0x0112, B:33:0x0118, B:35:0x0127, B:37:0x013a, B:38:0x015d, B:55:0x01a9, B:56:0x01ad, B:57:0x01b1, B:58:0x01b7, B:59:0x01bd, B:60:0x01c1, B:61:0x01c7, B:62:0x01cd, B:34:0x0120), top: B:70:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018e  */
    @Override // com.repackage.g47
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(View view2, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, chatMessage) == null) {
            super.s(view2, chatMessage);
            String str = null;
            ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
            S();
            UserIconBox userIconBox = this.F;
            if (userIconBox != null && this.s) {
                userIconBox.setVisibility(0);
                this.F.setAutoChangedStyle(false);
                Resources resources = this.I.getResources();
                this.F.h(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070304), true);
            }
            if (chatMessage == null) {
                this.D.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                u(8);
                this.q.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.m.setTag(null);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.G.setVisibility(8);
                this.r.setVisibility(8);
                return;
            }
            I(chatMessage);
            T(chatMessage);
            this.D.setText("");
            R(chatMessage);
            P(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.D.setText(chatMessage.getUserInfo().getName_show());
                    this.C.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.J == null) {
                        this.J = s67.o().i(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.J != null && !TextUtils.isEmpty(this.J.getGroup_head())) {
                        str = this.J.getGroup_head();
                    }
                    this.C.J(str, 12, false);
                    this.C.setContentDescription(chatMessage.getUserInfo().getName_show());
                    if (m()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
                        layoutParams.leftMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        this.E.setLayoutParams(layoutParams);
                        this.C.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                    u(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    this.m.setVisibility(8);
                    this.o.setVisibility(8);
                    this.n.setVisibility(8);
                    this.p.setVisibility(8);
                    this.r.setVisibility(8);
                    msgType = chatMessage.getMsgType();
                    if (msgType != 1) {
                        if (msgType == 2) {
                            L(view2, chatMessage, L);
                            return;
                        } else if (msgType == 3) {
                            O(chatMessage, L);
                            return;
                        } else if (msgType == 4) {
                            F(chatMessage, false);
                            return;
                        } else if (msgType == 5) {
                            J(view2, chatMessage, L);
                            return;
                        } else if (msgType == 9) {
                            G(view2, chatMessage, L);
                            return;
                        } else if (msgType != 30) {
                            if (msgType == 32) {
                                N(chatMessage);
                                return;
                            } else if (msgType != 33) {
                                return;
                            } else {
                                H(chatMessage);
                                return;
                            }
                        }
                    }
                    M(chatMessage, L);
                }
                this.C.J(str, 10, false);
                this.C.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (m()) {
                }
                this.j.setVisibility(8);
                u(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                }
                M(chatMessage, L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
