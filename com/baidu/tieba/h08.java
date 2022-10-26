package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.pu4;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public pv7 b;
    public LikeModel c;
    public uv7 d;
    public AlertDialog e;
    public q9 f;
    public AntiHelper.k g;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h08 h08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() != 502014 && pbAdCardGiftItemResponseMessage.getError() != 502015) {
                    this.a.a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ h08 b;

        public b(h08 h08Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h08Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, pu4Var) != null) || lh5.a()) {
                return;
            }
            if (this.a == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.b.a.getActivity()).createNormalCfg(this.b.d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.b.a.checkUpIsLogin()) {
                return;
            } else {
                if (this.b.c == null) {
                    h08 h08Var = this.b;
                    h08Var.c = new LikeModel(h08Var.a.getPageContext());
                    this.b.c.setLoadDataCallBack(this.b.f);
                }
                this.b.c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.b.c.Q(this.b.d.l().getName(), String.valueOf(this.b.d.l().getId()));
            }
            pu4Var.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public d(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.p();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public e(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.d != null && this.a.d.l() != null && obj != null) {
                if (AntiHelper.m(this.a.c.getErrorCode(), this.a.c.getErrorString())) {
                    if (AntiHelper.t(this.a.a.getContext(), this.a.c.N(), this.a.g) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                this.a.d.l().getName();
                String id = this.a.d.l().getId();
                rm8 rm8Var = null;
                if (obj instanceof rm8) {
                    rm8Var = (rm8) obj;
                }
                boolean z2 = false;
                if (rm8Var != null && this.a.c.getErrorCode() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (rm8Var != null && rm8Var.d() == 3250013) {
                    BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), rm8Var.e());
                    b.f(BdToast.ToastIcon.FAILURE);
                    b.c(3000);
                    b.i();
                } else {
                    z2 = z;
                }
                if (rm8Var != null && z2) {
                    rm8Var.x(1);
                    this.a.t(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rm8Var));
                } else if (this.a.c.getErrorCode() == 22) {
                    this.a.a.showToast(this.a.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0847));
                } else {
                    this.a.a.showToast(this.a.c.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public g(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.dismiss();
                h08 h08Var = this.a;
                h08Var.n(h08Var.b);
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public h(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public i(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.p();
        }
    }

    public h08(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new e(this);
        this.g = new f(this);
        this.a = pbFragment;
        r();
        s();
    }

    public final void t(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            ub7.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void v(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uv7Var) == null) {
            this.d = uv7Var;
        }
    }

    public final void n(pv7 pv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pv7Var) != null) || pv7Var == null) {
            return;
        }
        sl8.g().c(this.a.getUniqueId(), ql8.c(this.d.P(), "a005", "common_click", 1, pv7Var.b, true, pv7Var.a.a + "", "", 19));
    }

    public void u(pv7 pv7Var) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, pv7Var) == null) && pv7Var != null && pv7Var.a != null && (uv7Var = this.d) != null && uv7Var.P() != null) {
            this.b = pv7Var;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
            httpMessage.addParam("tid", this.d.P().getTid());
            httpMessage.addParam("packet_id", pv7Var.a.a);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void o(pv7 pv7Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pv7Var) != null) || pv7Var == null) {
            return;
        }
        String tid = this.d.P().getTid();
        sl8.g().d(this.a.getUniqueId(), ql8.b(tid, str, "", null) + "_dialog", ql8.d(this.d.P(), "a005", "common_exp", pv7Var.b, true, pv7Var.a.a + "", "", 19));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LikeModel likeModel = this.c;
            if (likeModel != null) {
                likeModel.M();
            }
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
            tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (i2 == 502014) {
                i3 = R.string.obfuscated_res_0x7f0f0ddc;
                i4 = R.string.obfuscated_res_0x7f0f0375;
                string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ddd);
            } else {
                i3 = R.string.obfuscated_res_0x7f0f0dd8;
                i4 = R.string.obfuscated_res_0x7f0f0dd9;
                string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ddb, this.d.l().getName());
                str = "";
            }
            pu4 pu4Var = new pu4(this.a.getPageContext().getPageActivity());
            pu4Var.setTitle(str);
            pu4Var.setMessage(string);
            pu4Var.setPositiveButton(i3, new b(this, i2));
            pu4Var.setNegativeButton(i4, new c(this));
            pu4Var.setOnDismissListener(new d(this));
            pu4Var.setTitleShowCenter(true);
            pu4Var.setNegativeTextColor(R.color.CAM_X0105);
            pu4Var.setCanceledOnTouchOutside(true);
            pu4Var.create(this.a.getPageContext()).show();
        }
    }

    public final void x(qv7 qv7Var) {
        pv7 pv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qv7Var) == null) {
            pv7 pv7Var2 = this.b;
            if (pv7Var2 != null) {
                pv7Var2.a = qv7Var;
            }
            uv7 uv7Var = this.d;
            if (uv7Var != null && (pv7Var = uv7Var.l) != null) {
                pv7Var.a = qv7Var;
            }
            o(this.b);
            AlertDialog create = new AlertDialog.Builder(this.a.getPageContext().getPageActivity()).create();
            this.e = create;
            create.setCanceledOnTouchOutside(false);
            jh.i(this.e, this.a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06b9, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090382);
            tbImageView.setRadius(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f92);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090430);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09042f);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09241e);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092420);
            textView3.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0de3, new Object[]{qv7Var.c}));
            textView2.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0de2, new Object[]{qv7Var.f}));
            SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09241f), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0112);
            this.e.setOnDismissListener(new i(this));
            Window window = this.e.getWindow();
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003d0);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}
