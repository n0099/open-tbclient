package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.i3.n0.c;
import c.a.p0.j1.f.e;
import c.a.p0.j1.f.k.a;
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
import java.net.URLDecoder;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f52722e;

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
            this.f52722e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52722e.t <= 0) {
                return;
            }
            c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.f52722e.v != 1) {
                if (this.f52722e.v != 3) {
                    if (this.f52722e.v != 4) {
                        if (this.f52722e.v == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.f52722e.t)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.f52722e;
                    msgPhotoLiveCardVew.u = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.t));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.f52722e;
            msgPhotoLiveCardVew2.O(msgPhotoLiveCardVew2.v);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f52723e;

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
            this.f52723e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52723e.N(view);
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
        P();
    }

    public final SpannableStringBuilder K(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i2));
            int L = L(i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, L + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int L(int i2) {
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

    public final void N(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 5 || i2 == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.t), null, "message_tab")));
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = (LinearLayout) c(R.id.msg_photolive_card);
            this.x = (ClickableHeaderImageView) c(R.id.author_portrait);
            this.y = (TextView) c(R.id.author_name);
            this.z = (TextView) c(R.id.call_time);
            this.A = (TextView) c(R.id.call_content);
            this.B = (TextView) c(R.id.call_thread_title);
            this.D = (LinearLayout) c(R.id.auhtor_name_and_call_time);
            this.C = (TextView) c(R.id.remind_title);
            this.E = (TextView) c(R.id.card_bottom_chakanzhibo);
            this.w.setOnClickListener(new a(this));
        }
    }

    public void Q(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C0951a a2 = c.a.p0.j1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.t = 0L;
            return;
        }
        this.t = a2.f20412f;
        long j2 = a2.f20414h;
        this.v = a2.f20415i;
        int i3 = a2.f20416j;
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i4 = this.v;
        int i5 = -1;
        if (i4 == 1 || i4 == 6) {
            if (this.v == 1) {
                decode = a2.f20413g;
                i2 = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.f20413g);
                i2 = R.string.look_god_thread;
                i5 = 0;
            }
            this.B.setText(decode);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            this.D.setPadding(this.F, 0, 0, 0);
            this.x.setVisibility(0);
            this.x.setOnClickListener(new b(this));
            this.x.setTag(a2.f20408b);
            this.x.setGodIconMargin(i5);
            this.C.setVisibility(8);
            this.y.setVisibility(0);
            this.y.setText(a2.f20409c);
            this.A.setText(a2.f20411e);
            this.y.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
            this.E.setText(i2);
        } else if (i4 == 3) {
            this.B.setText(a2.f20413g);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
            String str = a2.f20411e;
            if (str != null && str.indexOf(String.valueOf(i3)) != -1) {
                this.A.setText(K(a2.f20411e, i3));
            } else {
                this.A.setText(a2.f20411e);
            }
        } else {
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.A.setText(a2.f20411e);
            int i6 = this.v;
            if (i6 == 4) {
                this.B.setText(a2.f20413g);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
            } else if (i6 == 5) {
                this.B.setText(a2.f20413g);
                this.E.setText(R.string.look_normal_thread);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
            }
        }
        if (!TextUtils.isEmpty(a2.f20407a)) {
            this.x.startLoad(a2.f20407a, 12, false);
        } else {
            this.x.startLoad(null, 12, false);
        }
        this.z.setText(StringHelper.getFormatTime(a2.f20410d));
    }
}
