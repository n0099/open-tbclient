package com.baidu.tieba;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.cp4;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class gs7 implements it {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TbImageView c;
    public TextView d;
    public RoundLinearLayout e;
    public RoundRelativeLayout f;
    public TextView g;
    public zz4 h;
    public fqa i;
    public ForumData j;
    public View k;
    public LinearLayout l;
    public TBLottieAnimationView m;
    public cp4 n;
    public cp4.b o;
    public View.OnClickListener p;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(gs7 gs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 1));
                YunDialogManager.unMarkShowingDialogName("frsAd");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cp4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs7 a;

        public b(gs7 gs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs7Var;
        }

        @Override // com.baidu.tieba.cp4.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs7 a;

        public c(gs7 gs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.d) {
                    if (this.a.h != null && this.a.h.isShowing()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                        this.a.h.dismiss();
                        if (this.a.n != null) {
                            this.a.n.c();
                        }
                    }
                } else if (view2 == this.a.c || view2 == this.a.l) {
                    this.a.g();
                }
            }
        }
    }

    public gs7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new b(this);
        this.p = new c(this);
        this.a = tbPageContext;
    }

    public final void g() {
        fqa fqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fqaVar = this.i) != null && !StringUtils.isNull(fqaVar.q())) {
            if (!xx5.a(this.a.getPageActivity(), this.i.i())) {
                s38.b(this.a, this.i.k(), this.i.q(), this.i.j());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.i.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            this.h.dismiss();
            cp4 cp4Var = this.n;
            if (cp4Var != null) {
                cp4Var.c();
            }
            FrsFragment.y2 = true;
            q38.a("common_click", this.i, this.j, 1, null);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cp4 cp4Var = new cp4(this.a.getPageActivity().getBaseContext(), this.o);
            this.n = cp4Var;
            cp4Var.k(1.5d);
            this.n.j(2.5d);
            this.n.f();
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03b8, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e04);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092016);
            this.f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f09174c);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092258);
            this.l = linearLayout;
            linearLayout.setOnClickListener(this.p);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.b.findViewById(R.id.obfuscated_res_0x7f0916da);
            this.m = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.frs_ad_shark);
            this.m.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c92);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            this.c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (int) (equipmentWidth * 1.3333333333333333d);
            this.c.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c90);
            this.d = textView;
            textView.setOnClickListener(this.p);
            fqa fqaVar = this.i;
            if (fqaVar != null) {
                this.c.startLoad(fqaVar.e(), 10, false);
            }
            new qs7(this.f, this.m).g();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            fqa fqaVar = this.i;
            if (fqaVar != null && fqaVar.s()) {
                h();
            } else {
                i();
            }
            zz4 zz4Var = new zz4(this.a.getPageActivity());
            this.h = zz4Var;
            zz4Var.setCancelable(true);
            this.h.setCanceledOnTouchOutside(true);
            this.h.setOnDismissListener(new a(this));
            this.h.create(this.a).show();
            View decorView = this.h.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.h.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.h.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.b);
            }
            fqa fqaVar2 = this.i;
            if (fqaVar2 != null && fqaVar2.f()) {
                EMManager.from(this.g).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0602);
                EMManager.from(this.g).setTextColor(R.color.CAM_X0617);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            q38.k("common_exp", this.i, this.j, 1, null);
            YunDialogManager.markShowingDialogName("frsAd");
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d036a, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e04);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092016);
            this.e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c92);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (int) (equipmentWidth * 1.3306452f);
            this.c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c90);
            this.d = textView;
            textView.setOnClickListener(this.p);
            fqa fqaVar = this.i;
            if (fqaVar != null) {
                this.c.startLoad(fqaVar.e(), 10, false);
            }
        }
    }

    public boolean j(kqa kqaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kqaVar)) == null) {
            if (kqaVar == null || kqaVar.getForum() == null || kqaVar.getBusinessPromot() == null || kqaVar.getBusinessPromot().g()) {
                return false;
            }
            this.j = kqaVar.getForum();
            this.i = kqaVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + kqaVar.getForum().getId();
            long j = SharedPrefHelper.getInstance().getLong(str, 0L);
            if (j >= 0 && TimeHelper.isSameDay(new Date(j), new Date(System.currentTimeMillis()))) {
                return false;
            }
            SharedPrefHelper.getInstance().putLong(str, System.currentTimeMillis());
            k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.it
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
        }
    }
}
