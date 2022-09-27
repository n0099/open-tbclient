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
import com.baidu.tieba.a87;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.ko8;
import com.baidu.tieba.w87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class MsgPhotoLiveCardVew extends a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long F;
    public long G;
    public int H;
    public LinearLayout I;
    public ClickableHeaderImageView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public LinearLayout P;
    public TextView Q;
    public int R;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.F <= 0) {
                return;
            }
            ko8 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.a.H != 1) {
                if (this.a.H != 3) {
                    if (this.a.H != 4) {
                        if (this.a.H == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.F)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                    msgPhotoLiveCardVew.G = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.F));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
            msgPhotoLiveCardVew2.d0(msgPhotoLiveCardVew2.H);
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b0(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d05a3);
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
        this.F = 0L;
        this.H = 0;
        this.R = 0;
        this.R = ej.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        e0();
    }

    public final SpannableStringBuilder Z(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int a0 = a0(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, a0 + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int a0(int i) {
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

    public final void b0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.F), null, "message_tab")));
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.I = (LinearLayout) j(R.id.obfuscated_res_0x7f091589);
            this.J = (ClickableHeaderImageView) j(R.id.obfuscated_res_0x7f0902f6);
            this.K = (TextView) j(R.id.obfuscated_res_0x7f0902f5);
            this.L = (TextView) j(R.id.obfuscated_res_0x7f090491);
            this.M = (TextView) j(R.id.obfuscated_res_0x7f09048e);
            this.N = (TextView) j(R.id.obfuscated_res_0x7f090490);
            this.P = (LinearLayout) j(R.id.obfuscated_res_0x7f0902ea);
            this.O = (TextView) j(R.id.obfuscated_res_0x7f091bd2);
            this.Q = (TextView) j(R.id.obfuscated_res_0x7f0904d2);
            this.I.setOnClickListener(new a(this));
        }
    }

    public void f0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        w87.a a2 = w87.a(chatMessage.getContent());
        if (a2 == null) {
            this.F = 0L;
            return;
        }
        this.F = a2.f;
        long j = a2.h;
        this.H = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
        int i3 = this.H;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.H == 1) {
                decode = a2.g;
                i = R.string.obfuscated_res_0x7f0f0a88;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.obfuscated_res_0x7f0f0a87;
                i4 = 0;
            }
            this.N.setText(decode);
            layoutParams.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.P.setPadding(this.R, 0, 0, 0);
            this.J.setVisibility(0);
            this.J.setOnClickListener(new b(this));
            this.J.setTag(a2.b);
            this.J.setGodIconMargin(i4);
            this.O.setVisibility(8);
            this.K.setVisibility(0);
            this.K.setText(a2.c);
            this.M.setText(a2.e);
            this.K.setTextSize(0, ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.Q.setText(i);
        } else if (i3 == 3) {
            this.N.setText(a2.g);
            layoutParams.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.P.setPadding(0, 0, 0, 0);
            this.J.setVisibility(8);
            this.O.setVisibility(0);
            this.K.setVisibility(8);
            this.O.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0615));
            String str = a2.e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.M.setText(Z(a2.e, i2));
            } else {
                this.M.setText(a2.e);
            }
        } else {
            layoutParams.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.P.setPadding(0, 0, 0, 0);
            this.J.setVisibility(8);
            this.O.setVisibility(0);
            this.K.setVisibility(8);
            this.M.setText(a2.e);
            int i5 = this.H;
            if (i5 == 4) {
                this.N.setText(a2.g);
                this.O.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14ee));
            } else if (i5 == 5) {
                this.N.setText(a2.g);
                this.Q.setText(R.string.obfuscated_res_0x7f0f0a8a);
                this.O.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f039c));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.J.K(a2.a, 12, false);
        } else {
            this.J.K(null, 12, false);
        }
        this.L.setText(StringHelper.getFormatTime(a2.d));
    }
}
