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
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.iy7;
import com.baidu.tieba.mx7;
import com.baidu.tieba.tm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class MsgPhotoLiveCardVew extends mx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long G;
    public long H;
    public int I;
    public LinearLayout J;
    public ClickableHeaderImageView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public LinearLayout Q;
    public TextView R;
    public int S;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgPhotoLiveCardVew a;

        public a(MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgPhotoLiveCardVew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G > 0) {
                tm9 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                if (this.a.I == 1) {
                    TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                    if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.G)) > 0) {
                        MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                        msgPhotoLiveCardVew.H = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.G));
                    }
                } else if (this.a.I == 3) {
                    TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                } else if (this.a.I == 4) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                } else if (this.a.I == 5) {
                    TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                }
                MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
                msgPhotoLiveCardVew2.t0(msgPhotoLiveCardVew2.I);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgPhotoLiveCardVew a;

        public b(MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgPhotoLiveCardVew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgPhotoLiveCardVew;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s0(view2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d05e5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = 0L;
        this.I = 0;
        this.S = 0;
        this.S = ii.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        u0();
    }

    public final int q0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = 0;
            do {
                i /= 10;
                i2++;
            } while (i != 0);
            return i2;
        }
        return invokeI.intValue;
    }

    public final SpannableStringBuilder p0(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str != null && !"".equals(str)) {
                int indexOf = str.indexOf(String.valueOf(i));
                int q0 = q0(i);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, q0 + indexOf, 33);
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final void s0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.G), null, "message_tab")));
            }
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.J = (LinearLayout) u(R.id.obfuscated_res_0x7f091706);
            this.K = (ClickableHeaderImageView) u(R.id.obfuscated_res_0x7f0902f9);
            this.L = (TextView) u(R.id.author_name);
            this.M = (TextView) u(R.id.obfuscated_res_0x7f090505);
            this.N = (TextView) u(R.id.obfuscated_res_0x7f090502);
            this.O = (TextView) u(R.id.obfuscated_res_0x7f090504);
            this.Q = (LinearLayout) u(R.id.obfuscated_res_0x7f0902ed);
            this.P = (TextView) u(R.id.obfuscated_res_0x7f091d68);
            this.R = (TextView) u(R.id.obfuscated_res_0x7f090546);
            this.J.setOnClickListener(new a(this));
        }
    }

    public void v0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) != null) || chatMessage == null) {
            return;
        }
        iy7.a a2 = iy7.a(chatMessage.getContent());
        if (a2 == null) {
            this.G = 0L;
            return;
        }
        this.G = a2.f;
        long j = a2.h;
        this.I = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.Q.getLayoutParams();
        int i3 = this.I;
        int i4 = -1;
        if (i3 != 1 && i3 != 6) {
            if (i3 == 3) {
                this.O.setText(a2.g);
                layoutParams.height = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.Q.setPadding(0, 0, 0, 0);
                this.K.setVisibility(8);
                this.P.setVisibility(0);
                this.L.setVisibility(8);
                this.P.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                String str = a2.e;
                if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                    this.N.setText(p0(a2.e, i2));
                } else {
                    this.N.setText(a2.e);
                }
            } else {
                layoutParams.height = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.Q.setPadding(0, 0, 0, 0);
                this.K.setVisibility(8);
                this.P.setVisibility(0);
                this.L.setVisibility(8);
                this.N.setText(a2.e);
                int i5 = this.I;
                if (i5 == 4) {
                    this.O.setText(a2.g);
                    this.P.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (i5 == 5) {
                    this.O.setText(a2.g);
                    this.R.setText(R.string.look_normal_thread);
                    this.P.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
        } else {
            if (this.I == 1) {
                decode = a2.g;
                i = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.look_god_thread;
                i4 = 0;
            }
            this.O.setText(decode);
            layoutParams.height = ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.Q.setPadding(this.S, 0, 0, 0);
            this.K.setVisibility(0);
            this.K.setOnClickListener(new b(this));
            this.K.setTag(a2.b);
            this.K.setGodIconMargin(i4);
            this.P.setVisibility(8);
            this.L.setVisibility(0);
            this.L.setText(a2.c);
            this.N.setText(a2.e);
            this.L.setTextSize(0, ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.R.setText(i);
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.K.N(a2.a, 12, false);
        } else {
            this.K.N(null, 12, false);
        }
        this.M.setText(StringHelper.getFormatTime(a2.d));
    }
}
