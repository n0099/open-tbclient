package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.aa8;
import com.baidu.tieba.ax5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.nc8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class MsgleftView extends aa8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String Q = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView H;
    public TextView I;
    public ViewGroup J;
    public UserIconBox K;
    public ImageView L;
    public final TouchType M;
    public TbPageContext<MsglistActivity<?>> N;
    public ImMessageCenterPojo O;
    public View.OnLongClickListener P;

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

    /* loaded from: classes6.dex */
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
                    ax5.e();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.a <= 200) {
                        MsgleftView msgleftView = this.b;
                        msgleftView.b.z(view2, 2, msgleftView.f, 0L);
                    } else if (this.b.M.get()) {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.c.O(view2, 2, msgleftView2.f, 0L);
                        this.b.M.set(false);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.M.set(true);
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
        this.M = new TouchType();
        this.P = new b(this);
        this.N = tbPageContext;
        I();
        this.k.d();
        this.L = (ImageView) u(R.id.iv_live_group_host);
        this.I = (TextView) u(R.id.tex_msgitem_name);
        this.J = (ViewGroup) u(R.id.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) u(R.id.img_msgitem_photo);
        this.H = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.H.setDrawerType(1);
        this.H.setRadius(BdUtilHelper.dip2px(this.N.getContext(), 4.0f));
        this.H.setPlaceHolder(1);
        this.K = (UserIconBox) u(R.id.user_tshow_icon_box);
        this.H.setLongClickable(true);
        this.H.setOnLongClickListener(this.P);
        this.H.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    @Override // com.baidu.tieba.aa8
    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.E == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.K();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        this.q.p(Q);
        this.r.l(Q);
        this.k.setVoicePureColor(SkinManager.getColor(R.color.CAM_X0105));
        this.k.f(Q);
        this.t.e(R.drawable.icon_pic_im_bubble_share_left, true);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
        ChatShareChatroomCard chatShareChatroomCard = this.s;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.h(R.drawable.icon_pic_im_bubble_share_left, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141 A[Catch: Exception -> 0x01ee, TryCatch #0 {Exception -> 0x01ee, blocks: (B:19:0x00b3, B:21:0x00b9, B:22:0x00db, B:24:0x00e8, B:27:0x00f3, B:29:0x00f7, B:30:0x0109, B:32:0x010d, B:34:0x0119, B:35:0x011f, B:37:0x012e, B:39:0x0141, B:40:0x0164, B:42:0x0198, B:43:0x019d, B:57:0x01ba, B:59:0x01be, B:60:0x01c2, B:61:0x01c6, B:62:0x01ca, B:63:0x01ce, B:64:0x01d2, B:65:0x01d8, B:66:0x01dc, B:67:0x01e2, B:68:0x01e8, B:36:0x0127), top: B:76:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0198 A[Catch: Exception -> 0x01ee, TryCatch #0 {Exception -> 0x01ee, blocks: (B:19:0x00b3, B:21:0x00b9, B:22:0x00db, B:24:0x00e8, B:27:0x00f3, B:29:0x00f7, B:30:0x0109, B:32:0x010d, B:34:0x0119, B:35:0x011f, B:37:0x012e, B:39:0x0141, B:40:0x0164, B:42:0x0198, B:43:0x019d, B:57:0x01ba, B:59:0x01be, B:60:0x01c2, B:61:0x01c6, B:62:0x01ca, B:63:0x01ce, B:64:0x01d2, B:65:0x01d8, B:66:0x01dc, B:67:0x01e2, B:68:0x01e8, B:36:0x0127), top: B:76:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    @Override // com.baidu.tieba.aa8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N(View view2, ChatMessage chatMessage) {
        ArrayList<IconData> arrayList;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.N(view2, chatMessage);
            String str = null;
            if (chatMessage != null) {
                arrayList = chatMessage.getUserInfo().getTShowInfoNew();
            } else {
                arrayList = null;
            }
            p0();
            UserIconBox userIconBox = this.K;
            if (userIconBox != null && this.v) {
                userIconBox.setVisibility(0);
                this.K.setAutoChangedStyle(false);
                Resources resources = this.N.getResources();
                this.K.h(arrayList, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c), true);
            }
            if (chatMessage == null) {
                this.I.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                P(8);
                this.p.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.L.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
                ChatShareChatroomCard chatShareChatroomCard = this.s;
                if (chatShareChatroomCard != null) {
                    chatShareChatroomCard.setVisibility(8);
                    return;
                }
                return;
            }
            f0(chatMessage);
            q0(chatMessage);
            this.I.setText("");
            o0(chatMessage);
            l0(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.I.setText(chatMessage.getUserInfo().getName_show());
                    this.H.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.O == null) {
                        this.O = nc8.n().h(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.O != null && !TextUtils.isEmpty(this.O.getGroup_head())) {
                        str = this.O.getGroup_head();
                    }
                    this.H.startLoad(str, 12, false);
                    this.H.setContentDescription(chatMessage.getUserInfo().getName_show());
                    if (F()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
                        layoutParams.leftMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        this.J.setLayoutParams(layoutParams);
                        this.H.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                    P(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    this.n.setVisibility(8);
                    this.m.setVisibility(8);
                    this.o.setVisibility(8);
                    this.q.setVisibility(8);
                    this.r.setVisibility(8);
                    this.t.setVisibility(8);
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
                                                if (msgType != 38) {
                                                    switch (msgType) {
                                                        case 32:
                                                            j0(chatMessage);
                                                            return;
                                                        case 33:
                                                            d0(chatMessage);
                                                            return;
                                                        case 34:
                                                            e0(chatMessage);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                }
                                                h0(chatMessage);
                                                return;
                                            }
                                            b0(chatMessage);
                                            return;
                                        }
                                    } else {
                                        c0(view2, chatMessage, Q);
                                        return;
                                    }
                                } else {
                                    a0(chatMessage, false);
                                    return;
                                }
                            } else {
                                k0(chatMessage, Q);
                                return;
                            }
                        } else {
                            g0(view2, chatMessage, Q);
                            return;
                        }
                    }
                    i0(chatMessage, Q);
                }
                this.H.startLoad(str, 10, false);
                this.H.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (F()) {
                }
                this.j.setVisibility(8);
                P(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
                if (this.s != null) {
                }
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                }
                i0(chatMessage, Q);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void o0(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            String string = SharedPrefHelper.getInstance().getString("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.v) {
                this.I.setVisibility(0);
                this.K.setVisibility(0);
                return;
            }
            this.I.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.J.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.J.setLayoutParams(marginLayoutParams);
            this.K.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q0(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, chatMessage) != null) || !this.v) {
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
            if (!this.v) {
                i = 0;
            }
            this.I.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
        i = 0;
        if (!this.v) {
        }
        this.I.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }
}
