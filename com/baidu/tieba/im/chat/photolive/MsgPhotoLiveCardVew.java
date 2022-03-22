package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.a4.q0.c;
import c.a.p0.u1.f.e;
import c.a.p0.u1.f.k.a;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.y <= 0) {
                return;
            }
            c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
            if (this.a.A != 1) {
                if (this.a.A != 3) {
                    if (this.a.A != 4) {
                        if (this.a.A == 5) {
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
                if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.y)) > 0) {
                    MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                    msgPhotoLiveCardVew.z = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.y));
                }
            }
            MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
            msgPhotoLiveCardVew2.Q(msgPhotoLiveCardVew2.A);
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.P(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0568);
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
        this.y = 0L;
        this.A = 0;
        this.K = 0;
        this.K = n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        S();
    }

    public final SpannableStringBuilder N(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int O = O(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, O + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int O(int i) {
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

    public final void P(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.y), null, "message_tab")));
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.B = (LinearLayout) c(R.id.obfuscated_res_0x7f09145a);
            this.C = (ClickableHeaderImageView) c(R.id.obfuscated_res_0x7f0902d9);
            this.D = (TextView) c(R.id.obfuscated_res_0x7f0902d8);
            this.E = (TextView) c(R.id.obfuscated_res_0x7f090487);
            this.F = (TextView) c(R.id.obfuscated_res_0x7f090484);
            this.G = (TextView) c(R.id.obfuscated_res_0x7f090486);
            this.I = (LinearLayout) c(R.id.obfuscated_res_0x7f0902cd);
            this.H = (TextView) c(R.id.obfuscated_res_0x7f091a3d);
            this.J = (TextView) c(R.id.obfuscated_res_0x7f0904c7);
            this.B.setOnClickListener(new a(this));
        }
    }

    public void T(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1409a a2 = c.a.p0.u1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.y = 0L;
            return;
        }
        this.y = a2.f18742f;
        long j = a2.f18744h;
        this.A = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
        int i3 = this.A;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.A == 1) {
                decode = a2.f18743g;
                i = R.string.obfuscated_res_0x7f0f0a5d;
            } else {
                decode = URLDecoder.decode(a2.f18743g);
                i = R.string.obfuscated_res_0x7f0f0a5c;
                i4 = 0;
            }
            this.G.setText(decode);
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.I.setPadding(this.K, 0, 0, 0);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new b(this));
            this.C.setTag(a2.f18738b);
            this.C.setGodIconMargin(i4);
            this.H.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setText(a2.f18739c);
            this.F.setText(a2.f18741e);
            this.D.setTextSize(0, n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.J.setText(i);
        } else if (i3 == 3) {
            this.G.setText(a2.f18743g);
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05eb));
            String str = a2.f18741e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.F.setText(N(a2.f18741e, i2));
            } else {
                this.F.setText(a2.f18741e);
            }
        } else {
            layoutParams.height = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.F.setText(a2.f18741e);
            int i5 = this.A;
            if (i5 == 4) {
                this.G.setText(a2.f18743g);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f148f));
            } else if (i5 == 5) {
                this.G.setText(a2.f18743g);
                this.J.setText(R.string.obfuscated_res_0x7f0f0a5f);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0394));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.C.J(a2.a, 12, false);
        } else {
            this.C.J(null, 12, false);
        }
        this.E.setText(StringHelper.getFormatTime(a2.f18740d));
    }
}
