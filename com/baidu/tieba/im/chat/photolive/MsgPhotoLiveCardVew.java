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
import com.repackage.ci8;
import com.repackage.d37;
import com.repackage.h27;
import com.repackage.li;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends h27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long B;
    public long C;
    public int D;
    public LinearLayout E;
    public ClickableHeaderImageView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public int N;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.B <= 0) {
                return;
            }
            ci8 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.a.D != 1) {
                if (this.a.D != 3) {
                    if (this.a.D != 4) {
                        if (this.a.D == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.B)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                    msgPhotoLiveCardVew.C = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.B));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
            msgPhotoLiveCardVew2.V(msgPhotoLiveCardVew2.D);
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.U(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d054d);
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
        this.B = 0L;
        this.D = 0;
        this.N = 0;
        this.N = li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        W();
    }

    public final SpannableStringBuilder R(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int T = T(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, T + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int T(int i) {
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

    public final void U(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.B), null, "message_tab")));
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.E = (LinearLayout) b(R.id.obfuscated_res_0x7f091430);
            this.F = (ClickableHeaderImageView) b(R.id.obfuscated_res_0x7f0902d9);
            this.G = (TextView) b(R.id.obfuscated_res_0x7f0902d8);
            this.H = (TextView) b(R.id.obfuscated_res_0x7f090485);
            this.I = (TextView) b(R.id.obfuscated_res_0x7f090482);
            this.J = (TextView) b(R.id.obfuscated_res_0x7f090484);
            this.L = (LinearLayout) b(R.id.obfuscated_res_0x7f0902cd);
            this.K = (TextView) b(R.id.obfuscated_res_0x7f091a31);
            this.M = (TextView) b(R.id.obfuscated_res_0x7f0904c6);
            this.E.setOnClickListener(new a(this));
        }
    }

    public void X(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        d37.a a2 = d37.a(chatMessage.getContent());
        if (a2 == null) {
            this.B = 0L;
            return;
        }
        this.B = a2.f;
        long j = a2.h;
        this.D = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
        int i3 = this.D;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.D == 1) {
                decode = a2.g;
                i = R.string.obfuscated_res_0x7f0f0a6c;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.obfuscated_res_0x7f0f0a6b;
                i4 = 0;
            }
            this.J.setText(decode);
            layoutParams.height = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.L.setPadding(this.N, 0, 0, 0);
            this.F.setVisibility(0);
            this.F.setOnClickListener(new b(this));
            this.F.setTag(a2.b);
            this.F.setGodIconMargin(i4);
            this.K.setVisibility(8);
            this.G.setVisibility(0);
            this.G.setText(a2.c);
            this.I.setText(a2.e);
            this.G.setTextSize(0, li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.M.setText(i);
        } else if (i3 == 3) {
            this.J.setText(a2.g);
            layoutParams.height = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.L.setPadding(0, 0, 0, 0);
            this.F.setVisibility(8);
            this.K.setVisibility(0);
            this.G.setVisibility(8);
            this.K.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05ff));
            String str = a2.e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.I.setText(R(a2.e, i2));
            } else {
                this.I.setText(a2.e);
            }
        } else {
            layoutParams.height = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.L.setPadding(0, 0, 0, 0);
            this.F.setVisibility(8);
            this.K.setVisibility(0);
            this.G.setVisibility(8);
            this.I.setText(a2.e);
            int i5 = this.D;
            if (i5 == 4) {
                this.J.setText(a2.g);
                this.K.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14d5));
            } else if (i5 == 5) {
                this.J.setText(a2.g);
                this.M.setText(R.string.obfuscated_res_0x7f0f0a6e);
                this.K.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f039c));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.F.K(a2.a, 12, false);
        } else {
            this.F.K(null, 12, false);
        }
        this.H.setText(StringHelper.getFormatTime(a2.d));
    }
}
