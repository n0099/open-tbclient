package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.repackage.e47;
import com.repackage.iu4;
import com.repackage.mi;
import com.repackage.r67;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MsgleftView extends e47 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String K = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView B;
    public TextView C;
    public ViewGroup D;
    public UserIconBox E;
    public ImageView F;
    public final TouchType G;
    public TbPageContext<MsglistActivity<?>> H;
    public ImMessageCenterPojo I;
    public View.OnLongClickListener J;

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
                        if (this.b.G.get()) {
                            MsgleftView msgleftView = this.b;
                            msgleftView.c.onItemViewLongClick(view2, 2, msgleftView.f, 0L);
                            this.b.G.set(false);
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
                this.a.G.set(true);
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d054f);
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
        this.G = new TouchType();
        this.J = new b(this);
        this.H = tbPageContext;
        l();
        this.F = (ImageView) e(R.id.obfuscated_res_0x7f090fe6);
        this.C = (TextView) e(R.id.obfuscated_res_0x7f091f5b);
        this.D = (ViewGroup) e(R.id.obfuscated_res_0x7f0903ea);
        HeadImageView headImageView = (HeadImageView) e(R.id.obfuscated_res_0x7f090ecc);
        this.B = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.B.setDrawerType(1);
        this.B.setRadius(mi.d(this.H.getContext(), 4.0f));
        this.B.setPlaceHolder(1);
        this.E = (UserIconBox) e(R.id.obfuscated_res_0x7f092315);
        this.B.setLongClickable(true);
        this.B.setOnLongClickListener(this.J);
        this.B.setOnTouchListener(new a(this));
        this.n.setIsLeft(true);
        this.o.setIsLeft(true);
    }

    public final void O(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String q = iu4.k().q("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(q)) {
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.s) {
                this.C.setVisibility(0);
                this.E.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.D.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.D.setLayoutParams(marginLayoutParams);
            this.E.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(ChatMessage chatMessage) {
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
                this.C.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
            i = 0;
            if (!this.s) {
            }
            this.C.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    @Override // com.repackage.e47
    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.A == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.n();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        SkinManager.setBackgroundResource(this.m, R.drawable.selector_msg_text_bubble_other);
        this.r.q(K);
        this.k.f(K);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0165  */
    @Override // com.repackage.e47
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(View view2, ChatMessage chatMessage) {
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, chatMessage) == null) {
            super.q(view2, chatMessage);
            String str = null;
            ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
            P();
            UserIconBox userIconBox = this.E;
            if (userIconBox != null && this.s) {
                userIconBox.setVisibility(0);
                this.E.setAutoChangedStyle(false);
                Resources resources = this.H.getResources();
                this.E.h(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305), true);
            }
            if (chatMessage == null) {
                this.C.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                s(8);
                this.q.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.m.setTag(null);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.F.setVisibility(8);
                this.r.setVisibility(8);
                return;
            }
            F(chatMessage);
            Q(chatMessage);
            this.C.setText("");
            O(chatMessage);
            M(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.C.setText(chatMessage.getUserInfo().getName_show());
                    this.B.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.I == null) {
                        this.I = r67.p().j(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.I != null && !TextUtils.isEmpty(this.I.getGroup_head())) {
                        str = this.I.getGroup_head();
                    }
                    this.B.K(str, 12, false);
                    this.B.setContentDescription(chatMessage.getUserInfo().getName_show());
                    this.j.setVisibility(8);
                    s(8);
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
                            H(view2, chatMessage, K);
                            return;
                        } else if (msgType == 3) {
                            L(chatMessage, K);
                            return;
                        } else if (msgType == 4) {
                            C(chatMessage, false);
                            return;
                        } else if (msgType == 5) {
                            G(view2, chatMessage, K);
                            return;
                        } else if (msgType == 9) {
                            D(view2, chatMessage, K);
                            return;
                        } else if (msgType != 30) {
                            if (msgType == 32) {
                                K(chatMessage);
                                return;
                            } else if (msgType != 33) {
                                return;
                            } else {
                                E(chatMessage);
                                return;
                            }
                        }
                    }
                    I(chatMessage, K);
                }
                this.B.K(str, 10, false);
                this.B.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.j.setVisibility(8);
                s(8);
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
                I(chatMessage, K);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
