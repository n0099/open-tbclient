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
import com.repackage.d57;
import com.repackage.em8;
import com.repackage.oi;
import com.repackage.r57;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends d57 {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y <= 0) {
                return;
            }
            em8 photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
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
            msgPhotoLiveCardVew2.S(msgPhotoLiveCardVew2.A);
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
                this.a.Q(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0563);
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
        this.K = oi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        T();
    }

    public final SpannableStringBuilder O(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str == null || "".equals(str)) {
                return null;
            }
            int indexOf = str.indexOf(String.valueOf(i));
            int P = P(i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, P + indexOf, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final int P(int i) {
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

    public final void Q(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Object tag = view2.getTag();
            if (tag instanceof String) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
            }
        }
    }

    public final void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.y), null, "message_tab")));
            }
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.B = (LinearLayout) e(R.id.obfuscated_res_0x7f091454);
            this.C = (ClickableHeaderImageView) e(R.id.obfuscated_res_0x7f0902e3);
            this.D = (TextView) e(R.id.obfuscated_res_0x7f0902e2);
            this.E = (TextView) e(R.id.obfuscated_res_0x7f09048f);
            this.F = (TextView) e(R.id.obfuscated_res_0x7f09048c);
            this.G = (TextView) e(R.id.obfuscated_res_0x7f09048e);
            this.I = (LinearLayout) e(R.id.obfuscated_res_0x7f0902d7);
            this.H = (TextView) e(R.id.obfuscated_res_0x7f091a2e);
            this.J = (TextView) e(R.id.obfuscated_res_0x7f0904cf);
            this.B.setOnClickListener(new a(this));
        }
    }

    public void U(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        r57.a a2 = r57.a(chatMessage.getContent());
        if (a2 == null) {
            this.y = 0L;
            return;
        }
        this.y = a2.f;
        long j = a2.h;
        this.A = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
        int i3 = this.A;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.A == 1) {
                decode = a2.g;
                i = R.string.obfuscated_res_0x7f0f0a5f;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.obfuscated_res_0x7f0f0a5e;
                i4 = 0;
            }
            this.G.setText(decode);
            layoutParams.height = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.I.setPadding(this.K, 0, 0, 0);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new b(this));
            this.C.setTag(a2.b);
            this.C.setGodIconMargin(i4);
            this.H.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setText(a2.c);
            this.F.setText(a2.e);
            this.D.setTextSize(0, oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.J.setText(i);
        } else if (i3 == 3) {
            this.G.setText(a2.g);
            layoutParams.height = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05f2));
            String str = a2.e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.F.setText(O(a2.e, i2));
            } else {
                this.F.setText(a2.e);
            }
        } else {
            layoutParams.height = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
            this.I.setPadding(0, 0, 0, 0);
            this.C.setVisibility(8);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            this.F.setText(a2.e);
            int i5 = this.A;
            if (i5 == 4) {
                this.G.setText(a2.g);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1496));
            } else if (i5 == 5) {
                this.G.setText(a2.g);
                this.J.setText(R.string.obfuscated_res_0x7f0f0a61);
                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0396));
            }
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.C.K(a2.a, 12, false);
        } else {
            this.C.K(null, 12, false);
        }
        this.E.setText(StringHelper.getFormatTime(a2.d));
    }
}
