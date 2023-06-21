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
import com.baidu.tieba.c1a;
import com.baidu.tieba.c88;
import com.baidu.tieba.f78;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
/* loaded from: classes6.dex */
public class MsgPhotoLiveCardVew extends f78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long H;
    public long I;
    public int J;
    public LinearLayout K;
    public ClickableHeaderImageView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public LinearLayout R;
    public TextView S;

    /* renamed from: T  reason: collision with root package name */
    public int f1118T;

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.H > 0) {
                c1a photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                if (this.a.J == 1) {
                    TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                    if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.H)) > 0) {
                        MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                        msgPhotoLiveCardVew.I = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.H));
                    }
                } else if (this.a.J == 3) {
                    TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                } else if (this.a.J == 4) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                } else if (this.a.J == 5) {
                    TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                }
                MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
                msgPhotoLiveCardVew2.u0(msgPhotoLiveCardVew2.J);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d061c);
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
        this.H = 0L;
        this.J = 0;
        this.f1118T = 0;
        this.f1118T = wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        v0();
    }

    public final int r0(int i) {
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

    public final SpannableStringBuilder q0(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str != null && !"".equals(str)) {
                int indexOf = str.indexOf(String.valueOf(i));
                int r0 = r0(i);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, r0 + indexOf, 33);
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

    public final void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 5 || i == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.H), null, "message_tab")));
            }
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.K = (LinearLayout) u(R.id.obfuscated_res_0x7f091783);
            this.L = (ClickableHeaderImageView) u(R.id.obfuscated_res_0x7f090302);
            this.M = (TextView) u(R.id.author_name);
            this.N = (TextView) u(R.id.obfuscated_res_0x7f090523);
            this.O = (TextView) u(R.id.obfuscated_res_0x7f090520);
            this.P = (TextView) u(R.id.obfuscated_res_0x7f090522);
            this.R = (LinearLayout) u(R.id.obfuscated_res_0x7f0902f6);
            this.Q = (TextView) u(R.id.obfuscated_res_0x7f091e0b);
            this.S = (TextView) u(R.id.obfuscated_res_0x7f090567);
            this.K.setOnClickListener(new a(this));
        }
    }

    public void w0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) != null) || chatMessage == null) {
            return;
        }
        c88.a a2 = c88.a(chatMessage.getContent());
        if (a2 == null) {
            this.H = 0L;
            return;
        }
        this.H = a2.f;
        long j = a2.h;
        this.J = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
        int i3 = this.J;
        int i4 = -1;
        if (i3 != 1 && i3 != 6) {
            if (i3 == 3) {
                this.P.setText(a2.g);
                layoutParams.height = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.R.setPadding(0, 0, 0, 0);
                this.L.setVisibility(8);
                this.Q.setVisibility(0);
                this.M.setVisibility(8);
                this.Q.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                String str = a2.e;
                if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                    this.O.setText(q0(a2.e, i2));
                } else {
                    this.O.setText(a2.e);
                }
            } else {
                layoutParams.height = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.R.setPadding(0, 0, 0, 0);
                this.L.setVisibility(8);
                this.Q.setVisibility(0);
                this.M.setVisibility(8);
                this.O.setText(a2.e);
                int i5 = this.J;
                if (i5 == 4) {
                    this.P.setText(a2.g);
                    this.Q.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (i5 == 5) {
                    this.P.setText(a2.g);
                    this.S.setText(R.string.look_normal_thread);
                    this.Q.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
        } else {
            if (this.J == 1) {
                decode = a2.g;
                i = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.look_god_thread;
                i4 = 0;
            }
            this.P.setText(decode);
            layoutParams.height = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.R.setPadding(this.f1118T, 0, 0, 0);
            this.L.setVisibility(0);
            this.L.setOnClickListener(new b(this));
            this.L.setTag(a2.b);
            this.L.setGodIconMargin(i4);
            this.Q.setVisibility(8);
            this.M.setVisibility(0);
            this.M.setText(a2.c);
            this.O.setText(a2.e);
            this.M.setTextSize(0, wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.S.setText(i);
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.L.N(a2.a, 12, false);
        } else {
            this.L.N(null, 12, false);
        }
        this.N.setText(StringHelper.getFormatTime(a2.d));
    }
}
