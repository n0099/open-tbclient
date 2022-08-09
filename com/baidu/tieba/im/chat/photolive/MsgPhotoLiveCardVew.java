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
import com.repackage.a67;
import com.repackage.cm8;
import com.repackage.qi;
import com.repackage.w67;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends a67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long E;
    public long F;
    public int G;
    public LinearLayout H;
    public ClickableHeaderImageView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public LinearLayout O;
    public TextView P;
    public int Q;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.E <= 0) {
                return;
            }
            cm8 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.a.G != 1) {
                if (this.a.G != 3) {
                    if (this.a.G != 4) {
                        if (this.a.G == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.E)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                    msgPhotoLiveCardVew.F = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.E));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
            msgPhotoLiveCardVew2.b0(msgPhotoLiveCardVew2.G);
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
                this.a.a0(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d058a);
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
        this.E = 0L;
        this.G = 0;
        this.Q = 0;
        this.Q = qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        d0();
    }

    public final SpannableStringBuilder Y(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int Z = Z(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, Z + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int Z(int i) {
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

    public final void a0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.E), null, "message_tab")));
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.H = (LinearLayout) j(R.id.obfuscated_res_0x7f09155e);
            this.I = (ClickableHeaderImageView) j(R.id.obfuscated_res_0x7f0902ee);
            this.J = (TextView) j(R.id.obfuscated_res_0x7f0902ed);
            this.K = (TextView) j(R.id.obfuscated_res_0x7f090482);
            this.L = (TextView) j(R.id.obfuscated_res_0x7f09047f);
            this.M = (TextView) j(R.id.obfuscated_res_0x7f090481);
            this.O = (LinearLayout) j(R.id.obfuscated_res_0x7f0902e2);
            this.N = (TextView) j(R.id.obfuscated_res_0x7f091b8a);
            this.P = (TextView) j(R.id.obfuscated_res_0x7f0904c3);
            this.H.setOnClickListener(new a(this));
        }
    }

    public void e0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        w67.a a2 = w67.a(chatMessage.getContent());
        if (a2 == null) {
            this.E = 0L;
            return;
        }
        this.E = a2.f;
        long j = a2.h;
        this.G = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.O.getLayoutParams();
        int i3 = this.G;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.G == 1) {
                decode = a2.g;
                i = R.string.obfuscated_res_0x7f0f0a6e;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.obfuscated_res_0x7f0f0a6d;
                i4 = 0;
            }
            this.M.setText(decode);
            layoutParams.height = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.O.setPadding(this.Q, 0, 0, 0);
            this.I.setVisibility(0);
            this.I.setOnClickListener(new b(this));
            this.I.setTag(a2.b);
            this.I.setGodIconMargin(i4);
            this.N.setVisibility(8);
            this.J.setVisibility(0);
            this.J.setText(a2.c);
            this.L.setText(a2.e);
            this.J.setTextSize(0, qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.P.setText(i);
        } else if (i3 == 3) {
            this.M.setText(a2.g);
            layoutParams.height = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.O.setPadding(0, 0, 0, 0);
            this.I.setVisibility(8);
            this.N.setVisibility(0);
            this.J.setVisibility(8);
            this.N.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0607));
            String str = a2.e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.L.setText(Y(a2.e, i2));
            } else {
                this.L.setText(a2.e);
            }
        } else {
            layoutParams.height = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.O.setPadding(0, 0, 0, 0);
            this.I.setVisibility(8);
            this.N.setVisibility(0);
            this.J.setVisibility(8);
            this.L.setText(a2.e);
            int i5 = this.G;
            if (i5 == 4) {
                this.M.setText(a2.g);
                this.N.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14c9));
            } else if (i5 == 5) {
                this.M.setText(a2.g);
                this.P.setText(R.string.obfuscated_res_0x7f0f0a70);
                this.N.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0397));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.I.K(a2.a, 12, false);
        } else {
            this.I.K(null, 12, false);
        }
        this.K.setText(StringHelper.getFormatTime(a2.d));
    }
}
