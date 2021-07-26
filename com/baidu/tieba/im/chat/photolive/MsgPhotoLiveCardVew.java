package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h3.n0.c;
import d.a.q0.i1.f.e;
import d.a.q0.i1.f.k.a;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class MsgPhotoLiveCardVew extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public LinearLayout D;
    public TextView E;
    public int F;
    public long t;
    public long u;
    public int v;
    public LinearLayout w;
    public ClickableHeaderImageView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f17505e;

        public a(MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgPhotoLiveCardVew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17505e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17505e.t <= 0) {
                return;
            }
            c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.f17505e.v != 1) {
                if (this.f17505e.v != 3) {
                    if (this.f17505e.v != 4) {
                        if (this.f17505e.v == 5) {
                            TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                    }
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                }
            } else {
                TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.f17505e.t)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.f17505e;
                    msgPhotoLiveCardVew.u = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.t));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.f17505e;
            msgPhotoLiveCardVew2.M(msgPhotoLiveCardVew2.v);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f17506e;

        public b(MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgPhotoLiveCardVew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17506e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17506e.L(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_photolive_card_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.v = 0;
        this.F = 0;
        this.F = l.g(tbPageContext.getContext(), R.dimen.ds24);
        O();
    }

    public final SpannableStringBuilder J(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i2));
            int K = K(i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, K + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = 0;
            do {
                i2 /= 10;
                i3++;
            } while (i2 != 0);
            return i3;
        }
        return invokeI.intValue;
    }

    public final void L(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 5 || i2 == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.t), null, "message_tab")));
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = (LinearLayout) d(R.id.msg_photolive_card);
            this.x = (ClickableHeaderImageView) d(R.id.author_portrait);
            this.y = (TextView) d(R.id.author_name);
            this.z = (TextView) d(R.id.call_time);
            this.A = (TextView) d(R.id.call_content);
            this.B = (TextView) d(R.id.call_thread_title);
            this.D = (LinearLayout) d(R.id.auhtor_name_and_call_time);
            this.C = (TextView) d(R.id.remind_title);
            this.E = (TextView) d(R.id.card_bottom_chakanzhibo);
            this.w.setOnClickListener(new a(this));
        }
    }

    public void P(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1465a a2 = d.a.q0.i1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.t = 0L;
            return;
        }
        this.t = a2.f58983f;
        long j = a2.f58985h;
        this.v = a2.f58986i;
        int i3 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i4 = this.v;
        int i5 = -1;
        if (i4 == 1 || i4 == 6) {
            if (this.v == 1) {
                decode = a2.f58984g;
                i2 = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.f58984g);
                i2 = R.string.look_god_thread;
                i5 = 0;
            }
            this.B.setText(decode);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            this.D.setPadding(this.F, 0, 0, 0);
            this.x.setVisibility(0);
            this.x.setOnClickListener(new b(this));
            this.x.setTag(a2.f58979b);
            this.x.setGodIconMargin(i5);
            this.C.setVisibility(8);
            this.y.setVisibility(0);
            this.y.setText(a2.f58980c);
            this.A.setText(a2.f58982e);
            this.y.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
            this.E.setText(i2);
        } else if (i4 == 3) {
            this.B.setText(a2.f58984g);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
            String str = a2.f58982e;
            if (str != null && str.indexOf(String.valueOf(i3)) != -1) {
                this.A.setText(J(a2.f58982e, i3));
            } else {
                this.A.setText(a2.f58982e);
            }
        } else {
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.A.setText(a2.f58982e);
            int i6 = this.v;
            if (i6 == 4) {
                this.B.setText(a2.f58984g);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
            } else if (i6 == 5) {
                this.B.setText(a2.f58984g);
                this.E.setText(R.string.look_normal_thread);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
            }
        }
        if (!TextUtils.isEmpty(a2.f58978a)) {
            this.x.M(a2.f58978a, 12, false);
        } else {
            this.x.M(null, 12, false);
        }
        this.z.setText(StringHelper.getFormatTime(a2.f58981d));
    }
}
