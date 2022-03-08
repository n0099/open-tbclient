package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.s1.f.e;
import c.a.r0.s1.f.k.a;
import c.a.r0.y3.q0.c;
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
/* loaded from: classes5.dex */
public class MsgPhotoLiveCardVew extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public LinearLayout B;
    public ClickableHeaderImageView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public TextView J;
    public int K;
    public long y;
    public long z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f43507e;

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
            this.f43507e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43507e.y <= 0) {
                return;
            }
            c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.f43507e.A != 1) {
                if (this.f43507e.A != 3) {
                    if (this.f43507e.A != 4) {
                        if (this.f43507e.A == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.f43507e.y)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.f43507e;
                    msgPhotoLiveCardVew.z = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.y));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.f43507e;
            msgPhotoLiveCardVew2.P(msgPhotoLiveCardVew2.A);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgPhotoLiveCardVew f43508e;

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
            this.f43508e = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43508e.O(view);
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
        this.y = 0L;
        this.A = 0;
        this.K = 0;
        this.K = n.f(tbPageContext.getContext(), R.dimen.ds24);
        Q();
    }

    public final SpannableStringBuilder M(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i2));
            int N = N(i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, N + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int N(int i2) {
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

    public final void O(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 5 || i2 == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.y), null, "message_tab")));
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.B = (LinearLayout) c(R.id.msg_photolive_card);
            this.C = (ClickableHeaderImageView) c(R.id.author_portrait);
            this.D = (TextView) c(R.id.author_name);
            this.E = (TextView) c(R.id.call_time);
            this.F = (TextView) c(R.id.call_content);
            this.G = (TextView) c(R.id.call_thread_title);
            this.I = (LinearLayout) c(R.id.auhtor_name_and_call_time);
            this.H = (TextView) c(R.id.remind_title);
            this.J = (TextView) c(R.id.card_bottom_chakanzhibo);
            this.B.setOnClickListener(new a(this));
        }
    }

    public void R(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1356a a2 = c.a.r0.s1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.y = 0L;
            return;
        }
        this.y = a2.f21775f;
        long j2 = a2.f21777h;
        this.A = a2.f21778i;
        int i3 = a2.f21779j;
        ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
        int i4 = this.A;
        int i5 = -1;
        if (i4 == 1 || i4 == 6) {
            if (this.A == 1) {
                decode = a2.f21776g;
                i2 = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.f21776g);
                i2 = R.string.look_god_thread;
                i5 = 0;
            }
            this.G.setText(decode);
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.ds72);
            this.I.setPadding(this.K, 0, 0, 0);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new b(this));
            this.C.setTag(a2.f21771b);
            this.C.setGodIconMargin(i5);
            this.H.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setText(a2.f21772c);
            this.F.setText(a2.f21774e);
            this.D.setTextSize(0, n.f(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
            this.J.setText(i2);
        } else if (i4 == 3) {
            this.G.setText(a2.f21776g);
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
            String str = a2.f21774e;
            if (str != null && str.indexOf(String.valueOf(i3)) != -1) {
                this.F.setText(M(a2.f21774e, i3));
            } else {
                this.F.setText(a2.f21774e);
            }
        } else {
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.F.setText(a2.f21774e);
            int i6 = this.A;
            if (i6 == 4) {
                this.G.setText(a2.f21776g);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
            } else if (i6 == 5) {
                this.G.setText(a2.f21776g);
                this.J.setText(R.string.look_normal_thread);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.C.startLoad(a2.a, 12, false);
        } else {
            this.C.startLoad(null, 12, false);
        }
        this.E.setText(StringHelper.getFormatTime(a2.f21773d));
    }
}
