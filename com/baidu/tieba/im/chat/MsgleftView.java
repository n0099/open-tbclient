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
import com.baidu.tieba.bc8;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.uf8;
import com.baidu.tieba.ws5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class MsgleftView extends bc8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String R = "com.baidu.tieba.im.chat.MsgleftView";
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView I;
    public TextView J;
    public ViewGroup K;
    public UserIconBox L;
    public ImageView M;
    public final TouchType N;
    public TbPageContext<MsglistActivity<?>> O;
    public ImMessageCenterPojo P;
    public View.OnLongClickListener Q;

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
                    ws5.e();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.a <= 200) {
                        MsgleftView msgleftView = this.b;
                        msgleftView.b.t(view2, 2, msgleftView.f, 0L);
                    } else if (this.b.N.get()) {
                        MsgleftView msgleftView2 = this.b;
                        msgleftView2.c.G(view2, 2, msgleftView2.f, 0L);
                        this.b.N.set(false);
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
                this.a.N.set(true);
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
        this.N = new TouchType();
        this.Q = new b(this);
        this.O = tbPageContext;
        D();
        this.k.d();
        this.M = (ImageView) f(R.id.iv_live_group_host);
        this.J = (TextView) f(R.id.tex_msgitem_name);
        this.K = (ViewGroup) f(R.id.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) f(R.id.img_msgitem_photo);
        this.I = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.I.setDrawerType(1);
        this.I.setRadius(BdUtilHelper.dip2px(this.O.getContext(), 4.0f));
        this.I.setPlaceHolder(1);
        this.L = (UserIconBox) f(R.id.user_tshow_icon_box);
        this.I.setLongClickable(true);
        this.I.setOnLongClickListener(this.Q);
        this.I.setOnTouchListener(new a(this));
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    @Override // com.baidu.tieba.bc8
    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.F == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        super.F();
        SkinManager.setBackgroundResource(this.j, R.drawable.selector_msg_text_bubble_other);
        this.q.u(R);
        this.r.l(R);
        this.s.l(R);
        this.k.setVoicePureColor(SkinManager.getColor(R.color.CAM_X0105));
        this.k.f(R);
        this.u.d(R.drawable.icon_pic_im_bubble_share_left, true);
        this.j.setTextColor(SkinManager.getColor(R.color.msg_chat_friend_text_color));
        ChatShareChatroomCard chatShareChatroomCard = this.t;
        if (chatShareChatroomCard != null) {
            chatShareChatroomCard.f(R.drawable.icon_pic_im_bubble_share_left, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141 A[Catch: Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:19:0x00b3, B:21:0x00b9, B:22:0x00db, B:24:0x00e8, B:27:0x00f3, B:29:0x00f7, B:30:0x0109, B:32:0x010d, B:34:0x0119, B:35:0x011f, B:37:0x012e, B:39:0x0141, B:40:0x0164, B:42:0x019d, B:43:0x01a2, B:59:0x01c3, B:61:0x01c7, B:62:0x01cb, B:63:0x01cf, B:64:0x01d3, B:65:0x01d7, B:66:0x01db, B:67:0x01e1, B:68:0x01e7, B:69:0x01eb, B:70:0x01f1, B:71:0x01f7, B:36:0x0127), top: B:79:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019d A[Catch: Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:19:0x00b3, B:21:0x00b9, B:22:0x00db, B:24:0x00e8, B:27:0x00f3, B:29:0x00f7, B:30:0x0109, B:32:0x010d, B:34:0x0119, B:35:0x011f, B:37:0x012e, B:39:0x0141, B:40:0x0164, B:42:0x019d, B:43:0x01a2, B:59:0x01c3, B:61:0x01c7, B:62:0x01cb, B:63:0x01cf, B:64:0x01d3, B:65:0x01d7, B:66:0x01db, B:67:0x01e1, B:68:0x01e7, B:69:0x01eb, B:70:0x01f1, B:71:0x01f7, B:36:0x0127), top: B:79:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a8  */
    @Override // com.baidu.tieba.bc8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(View view2, ChatMessage chatMessage) {
        ArrayList<IconData> arrayList;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage) == null) {
            super.I(view2, chatMessage);
            String str = null;
            if (chatMessage != null) {
                arrayList = chatMessage.getUserInfo().getTShowInfoNew();
            } else {
                arrayList = null;
            }
            l0();
            UserIconBox userIconBox = this.L;
            if (userIconBox != null && this.w) {
                userIconBox.setVisibility(0);
                this.L.setAutoChangedStyle(false);
                Resources resources = this.O.getResources();
                this.L.h(arrayList, 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c), true);
            }
            if (chatMessage == null) {
                this.J.setText((CharSequence) null);
                this.j.setVisibility(0);
                this.j.setText(null);
                K(8);
                this.p.getImage().setTag(null);
                this.k.setVisibility(8);
                this.k.setTag(null);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.M.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.u.setVisibility(8);
                ChatShareChatroomCard chatShareChatroomCard = this.t;
                if (chatShareChatroomCard != null) {
                    chatShareChatroomCard.setVisibility(8);
                    return;
                }
                return;
            }
            c0(chatMessage);
            m0(chatMessage);
            this.J.setText("");
            k0(chatMessage);
            i0(chatMessage);
            try {
                if (chatMessage.getUserInfo() != null) {
                    this.J.setText(chatMessage.getUserInfo().getName_show());
                    this.I.setUserId(chatMessage.getUserInfo().getUserId());
                    str = chatMessage.getUserInfo().getAvater();
                }
                if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                    if (this.P == null) {
                        this.P = uf8.n().h(String.valueOf(chatMessage.getUserId()), 2);
                    }
                    if (this.P != null && !TextUtils.isEmpty(this.P.getGroup_head())) {
                        str = this.P.getGroup_head();
                    }
                    this.I.startLoad(str, 12, false);
                    this.I.setContentDescription(chatMessage.getUserInfo().getName_show());
                    if (A()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                        layoutParams.leftMargin = SelectorHelper.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        this.K.setLayoutParams(layoutParams);
                        this.I.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                    K(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    this.n.setVisibility(8);
                    this.m.setVisibility(8);
                    this.o.setVisibility(8);
                    this.q.setVisibility(8);
                    this.r.setVisibility(8);
                    this.u.setVisibility(8);
                    this.s.setVisibility(8);
                    if (this.t != null) {
                        this.t.setVisibility(8);
                    }
                    msgType = chatMessage.getMsgType();
                    if (msgType != 1) {
                        if (msgType != 2) {
                            if (msgType != 3) {
                                if (msgType != 4) {
                                    if (msgType != 9) {
                                        if (msgType != 30) {
                                            if (msgType != 40) {
                                                if (msgType != 37) {
                                                    if (msgType != 38) {
                                                        switch (msgType) {
                                                            case 32:
                                                                g0(chatMessage);
                                                                return;
                                                            case 33:
                                                                Z(chatMessage);
                                                                return;
                                                            case 34:
                                                                a0(chatMessage);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                    }
                                                    e0(chatMessage);
                                                    return;
                                                }
                                                W(chatMessage);
                                                return;
                                            }
                                            b0(chatMessage, R);
                                            return;
                                        }
                                    } else {
                                        Y(view2, chatMessage, R);
                                        return;
                                    }
                                } else {
                                    V(chatMessage, false);
                                    return;
                                }
                            } else {
                                h0(chatMessage, R);
                                return;
                            }
                        } else {
                            d0(view2, chatMessage, R);
                            return;
                        }
                    }
                    f0(chatMessage, R);
                }
                this.I.startLoad(str, 10, false);
                this.I.setContentDescription(chatMessage.getUserInfo().getName_show());
                if (A()) {
                }
                this.j.setVisibility(8);
                K(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.u.setVisibility(8);
                this.s.setVisibility(8);
                if (this.t != null) {
                }
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                }
                f0(chatMessage, R);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void k0(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            String string = SharedPrefHelper.getInstance().getString("live_room_chat_page_author_id", "");
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
                this.M.setVisibility(0);
            } else {
                this.M.setVisibility(8);
            }
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.w) {
                this.J.setVisibility(0);
                this.L.setVisibility(0);
                return;
            }
            this.J.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.K.setLayoutParams(marginLayoutParams);
            this.L.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(ChatMessage chatMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, chatMessage) != null) || !this.w) {
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
            if (!this.w) {
                i = 0;
            }
            this.J.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
        i = 0;
        if (!this.w) {
        }
        this.J.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }
}
