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
import com.baidu.tieba.aq5;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.mj7;
import com.baidu.tieba.p35;
import com.baidu.tieba.xl7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MsgleftView extends mj7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String P = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView G;
    public TextView H;
    public ViewGroup I;
    public UserIconBox J;
    public ImageView K;
    public final TouchType L;
    public TbPageContext<MsglistActivity<?>> M;
    public ImMessageCenterPojo N;
    public View.OnLongClickListener O;

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
                    aq5.e();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.a <= 200) {
                        MsgleftView msgleftView = this.b;
                        msgleftView.b.A(view2, 2, msgleftView.f, 0L);
                    } else if (this.b.L.get()) {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.c.N(view2, 2, msgleftView2.f, 0L);
                        this.b.L.set(false);
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
                this.a.L.set(true);
                return true;
            }
            return invokeL.booleanValue;
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
        this.L = new TouchType();
        this.O = new b(this);
        this.M = tbPageContext;
        u();
        this.K = (ImageView) k(R.id.iv_live_group_host);
        this.H = (TextView) k(R.id.tex_msgitem_name);
        this.I = (ViewGroup) k(R.id.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) k(R.id.img_msgitem_photo);
        this.G = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.G.setDrawerType(1);
        this.G.setRadius(ej.d(this.M.getContext(), 4.0f));
        this.G.setPlaceHolder(1);
        this.J = (UserIconBox) k(R.id.user_tshow_icon_box);
        this.G.setLongClickable(true);
        this.G.setOnLongClickListener(this.O);
        this.G.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    public final void Y(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) {
            String s = p35.m().s("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(s)) {
                this.K.setVisibility(0);
            } else {
                this.K.setVisibility(8);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.u) {
                this.H.setVisibility(0);
                this.J.setVisibility(0);
                return;
            }
            this.H.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.I.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.I.setLayoutParams(marginLayoutParams);
            this.J.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) != null) || !this.u) {
            return;
        }
        if (chatMessage != null && chatMessage.getUserInfo() != null) {
            int sex = chatMessage.getUserInfo().getSex();
            if (sex != 1) {
                if (sex == 2) {
                    i = R.drawable.icon_pop_qz_girl;
                }
            } else {
                i = R.drawable.icon_pop_qz_boy;
            }
            if (!this.u) {
                i = 0;
            }
            this.H.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
        i = 0;
        if (!this.u) {
        }
        this.H.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }

    @Override // com.baidu.tieba.mj7
    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.D == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.w();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        this.q.p(P);
        this.r.l(P);
        this.k.f(P);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
        ChatShareChatroomCard chatShareChatroomCard = this.s;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.e(R.drawable.icon_pic_im_bubble_share_left, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x013c A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:19:0x00ae, B:21:0x00b4, B:22:0x00d6, B:24:0x00e3, B:27:0x00ee, B:29:0x00f2, B:30:0x0104, B:32:0x0108, B:34:0x0114, B:35:0x011a, B:37:0x0129, B:39:0x013c, B:40:0x015f, B:42:0x018e, B:43:0x0193, B:55:0x01ac, B:57:0x01b0, B:58:0x01b4, B:59:0x01b8, B:60:0x01bc, B:61:0x01c0, B:62:0x01c6, B:63:0x01ca, B:64:0x01d0, B:65:0x01d6, B:36:0x0122), top: B:73:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018e A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:19:0x00ae, B:21:0x00b4, B:22:0x00d6, B:24:0x00e3, B:27:0x00ee, B:29:0x00f2, B:30:0x0104, B:32:0x0108, B:34:0x0114, B:35:0x011a, B:37:0x0129, B:39:0x013c, B:40:0x015f, B:42:0x018e, B:43:0x0193, B:55:0x01ac, B:57:0x01b0, B:58:0x01b4, B:59:0x01b8, B:60:0x01bc, B:61:0x01c0, B:62:0x01c6, B:63:0x01ca, B:64:0x01d0, B:65:0x01d6, B:36:0x0122), top: B:73:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0199  */
    @Override // com.baidu.tieba.mj7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(View view2, ChatMessage chatMessage) {
        ArrayList<IconData> arrayList;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, chatMessage) == null) {
            super.y(view2, chatMessage);
            String str = null;
            if (chatMessage != null) {
                arrayList = chatMessage.getUserInfo().getTShowInfoNew();
            } else {
                arrayList = null;
            }
            Z();
            UserIconBox userIconBox = this.J;
            if (userIconBox != null && this.u) {
                userIconBox.setVisibility(0);
                this.J.setAutoChangedStyle(false);
                Resources resources = this.M.getResources();
                this.J.h(arrayList, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070303), true);
            }
            if (chatMessage == null) {
                this.H.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                A(8);
                this.p.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.K.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                ChatShareChatroomCard chatShareChatroomCard = this.s;
                if (chatShareChatroomCard != null) {
                    chatShareChatroomCard.setVisibility(8);
                    return;
                }
                return;
            }
            R(chatMessage);
            a0(chatMessage);
            this.H.setText("");
            Y(chatMessage);
            W(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.H.setText(chatMessage.getUserInfo().getName_show());
                    this.G.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.N == null) {
                        this.N = xl7.n().h(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.N != null && !TextUtils.isEmpty(this.N.getGroup_head())) {
                        str = this.N.getGroup_head();
                    }
                    this.G.K(str, 12, false);
                    this.G.setContentDescription(chatMessage.getUserInfo().getName_show());
                    if (r()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
                        layoutParams.leftMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        this.I.setLayoutParams(layoutParams);
                        this.G.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                    A(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    this.n.setVisibility(8);
                    this.m.setVisibility(8);
                    this.o.setVisibility(8);
                    this.q.setVisibility(8);
                    this.r.setVisibility(8);
                    if (this.s != null) {
                        this.s.setVisibility(8);
                    }
                    msgType = chatMessage.getMsgType();
                    if (msgType != 1) {
                        if (msgType != 2) {
                            if (msgType != 3) {
                                if (msgType != 4) {
                                    if (msgType != 9) {
                                        if (msgType != 30) {
                                            if (msgType != 37) {
                                                switch (msgType) {
                                                    case 32:
                                                        U(chatMessage);
                                                        return;
                                                    case 33:
                                                        P(chatMessage);
                                                        return;
                                                    case 34:
                                                        Q(chatMessage);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                            }
                                            N(chatMessage);
                                            return;
                                        }
                                    } else {
                                        O(view2, chatMessage, P);
                                        return;
                                    }
                                } else {
                                    M(chatMessage, false);
                                    return;
                                }
                            } else {
                                V(chatMessage, P);
                                return;
                            }
                        } else {
                            S(view2, chatMessage, P);
                            return;
                        }
                    }
                    T(chatMessage, P);
                }
                this.G.K(str, 10, false);
                this.G.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (r()) {
                }
                this.j.setVisibility(8);
                A(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                if (this.s != null) {
                }
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                }
                T(chatMessage, P);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
