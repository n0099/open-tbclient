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
import com.repackage.m47;
import com.repackage.pi;
import com.repackage.q37;
import com.repackage.ui8;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends q37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long C;
    public long D;
    public int E;
    public LinearLayout F;
    public ClickableHeaderImageView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public LinearLayout M;
    public TextView N;
    public int O;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.C <= 0) {
                return;
            }
            ui8 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.a.E != 1) {
                if (this.a.E != 3) {
                    if (this.a.E != 4) {
                        if (this.a.E == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.C)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                    msgPhotoLiveCardVew.D = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.C));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
            msgPhotoLiveCardVew2.Y(msgPhotoLiveCardVew2.E);
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
                this.a.X(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d054a);
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
        this.C = 0L;
        this.E = 0;
        this.O = 0;
        this.O = pi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        Z();
    }

    public final SpannableStringBuilder V(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int W = W(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, W + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int W(int i) {
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

    public final void X(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.C), null, "message_tab")));
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.F = (LinearLayout) a(R.id.obfuscated_res_0x7f091422);
            this.G = (ClickableHeaderImageView) a(R.id.obfuscated_res_0x7f0902d9);
            this.H = (TextView) a(R.id.obfuscated_res_0x7f0902d8);
            this.I = (TextView) a(R.id.obfuscated_res_0x7f090465);
            this.J = (TextView) a(R.id.obfuscated_res_0x7f090462);
            this.K = (TextView) a(R.id.obfuscated_res_0x7f090464);
            this.M = (LinearLayout) a(R.id.obfuscated_res_0x7f0902cd);
            this.L = (TextView) a(R.id.obfuscated_res_0x7f091a28);
            this.N = (TextView) a(R.id.obfuscated_res_0x7f0904a6);
            this.F.setOnClickListener(new a(this));
        }
    }

    public void a0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        m47.a a2 = m47.a(chatMessage.getContent());
        if (a2 == null) {
            this.C = 0L;
            return;
        }
        this.C = a2.f;
        long j = a2.h;
        this.E = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
        int i3 = this.E;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.E == 1) {
                decode = a2.g;
                i = R.string.obfuscated_res_0x7f0f0a70;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.obfuscated_res_0x7f0f0a6f;
                i4 = 0;
            }
            this.K.setText(decode);
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.M.setPadding(this.O, 0, 0, 0);
            this.G.setVisibility(0);
            this.G.setOnClickListener(new b(this));
            this.G.setTag(a2.b);
            this.G.setGodIconMargin(i4);
            this.L.setVisibility(8);
            this.H.setVisibility(0);
            this.H.setText(a2.c);
            this.J.setText(a2.e);
            this.H.setTextSize(0, pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.N.setText(i);
        } else if (i3 == 3) {
            this.K.setText(a2.g);
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.M.setPadding(0, 0, 0, 0);
            this.G.setVisibility(8);
            this.L.setVisibility(0);
            this.H.setVisibility(8);
            this.L.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05f3));
            String str = a2.e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.J.setText(V(a2.e, i2));
            } else {
                this.J.setText(a2.e);
            }
        } else {
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.M.setPadding(0, 0, 0, 0);
            this.G.setVisibility(8);
            this.L.setVisibility(0);
            this.H.setVisibility(8);
            this.J.setText(a2.e);
            int i5 = this.E;
            if (i5 == 4) {
                this.K.setText(a2.g);
                this.L.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14e2));
            } else if (i5 == 5) {
                this.K.setText(a2.g);
                this.N.setText(R.string.obfuscated_res_0x7f0f0a72);
                this.L.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f038d));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.G.J(a2.a, 12, false);
        } else {
            this.G.J(null, 12, false);
        }
        this.I.setText(StringHelper.getFormatTime(a2.d));
    }
}
