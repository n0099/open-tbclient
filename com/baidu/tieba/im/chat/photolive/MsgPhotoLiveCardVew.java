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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.wp8;
import com.baidu.tieba.xsa;
import com.baidu.tieba.zo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
/* loaded from: classes6.dex */
public class MsgPhotoLiveCardVew extends zo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long I;
    public long J;
    public int K;
    public LinearLayout L;
    public ClickableHeaderImageView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public LinearLayout S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1115T;
    public int U;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.I > 0) {
                xsa photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                if (this.a.K == 1) {
                    TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                    if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(this.a.I)) > 0) {
                        MsgPhotoLiveCardVew msgPhotoLiveCardVew = this.a;
                        msgPhotoLiveCardVew.J = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.I));
                    }
                } else if (this.a.K == 3) {
                    TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                } else if (this.a.K == 4) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                } else if (this.a.K == 5) {
                    TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                }
                MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = this.a;
                msgPhotoLiveCardVew2.u0(msgPhotoLiveCardVew2.K);
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
            this.a.t0(view2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0651);
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
        this.I = 0L;
        this.K = 0;
        this.U = 0;
        this.U = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0701e8);
        v0();
    }

    public final int s0(int i) {
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

    public final SpannableStringBuilder r0(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (str != null && !"".equals(str)) {
                int indexOf = str.indexOf(String.valueOf(i));
                int s0 = s0(i);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, s0 + indexOf, 33);
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public final void t0(View view2) {
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.I), null, "message_tab")));
            }
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.L = (LinearLayout) g(R.id.obfuscated_res_0x7f091856);
            this.M = (ClickableHeaderImageView) g(R.id.obfuscated_res_0x7f09031b);
            this.N = (TextView) g(R.id.author_name);
            this.O = (TextView) g(R.id.obfuscated_res_0x7f090555);
            this.P = (TextView) g(R.id.obfuscated_res_0x7f090552);
            this.Q = (TextView) g(R.id.obfuscated_res_0x7f090554);
            this.S = (LinearLayout) g(R.id.obfuscated_res_0x7f09030f);
            this.R = (TextView) g(R.id.obfuscated_res_0x7f091f25);
            this.f1115T = (TextView) g(R.id.obfuscated_res_0x7f09059a);
            this.L.setOnClickListener(new a(this));
        }
    }

    public void w0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        String decode;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view2) != null) || chatMessage == null) {
            return;
        }
        wp8.a a2 = wp8.a(chatMessage.getContent());
        if (a2 == null) {
            this.I = 0L;
            return;
        }
        this.I = a2.f;
        long j = a2.h;
        this.K = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.S.getLayoutParams();
        int i3 = this.K;
        int i4 = -1;
        if (i3 != 1 && i3 != 6) {
            if (i3 == 3) {
                this.Q.setText(a2.g);
                layoutParams.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.S.setPadding(0, 0, 0, 0);
                this.M.setVisibility(8);
                this.R.setVisibility(0);
                this.N.setVisibility(8);
                this.R.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                String str = a2.e;
                if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                    this.P.setText(r0(a2.e, i2));
                } else {
                    this.P.setText(a2.e);
                }
            } else {
                layoutParams.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070275);
                this.S.setPadding(0, 0, 0, 0);
                this.M.setVisibility(8);
                this.R.setVisibility(0);
                this.N.setVisibility(8);
                this.P.setText(a2.e);
                int i5 = this.K;
                if (i5 == 4) {
                    this.Q.setText(a2.g);
                    this.R.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (i5 == 5) {
                    this.Q.setText(a2.g);
                    this.f1115T.setText(R.string.look_normal_thread);
                    this.R.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
        } else {
            if (this.K == 1) {
                decode = a2.g;
                i = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.g);
                i = R.string.look_god_thread;
                i4 = 0;
            }
            this.Q.setText(decode);
            layoutParams.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            this.S.setPadding(this.U, 0, 0, 0);
            this.M.setVisibility(0);
            this.M.setOnClickListener(new b(this));
            this.M.setTag(a2.b);
            this.M.setGodIconMargin(i4);
            this.R.setVisibility(8);
            this.N.setVisibility(0);
            this.N.setText(a2.c);
            this.P.setText(a2.e);
            this.N.setTextSize(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702b5));
            this.f1115T.setText(i);
        }
        if (!TextUtils.isEmpty(a2.a)) {
            this.M.startLoad(a2.a, 12, false);
        } else {
            this.M.startLoad(null, 12, false);
        }
        this.O.setText(StringHelper.getFormatTime(a2.d));
    }
}
