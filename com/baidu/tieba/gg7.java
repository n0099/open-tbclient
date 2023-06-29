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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.cv4;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class gg7 implements ry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TbImageView c;
    public TextView d;
    public RoundLinearLayout e;
    public RoundRelativeLayout f;
    public TextView g;
    public g55 h;
    public x2a i;
    public ForumData j;
    public View k;
    public LinearLayout l;
    public TBLottieAnimationView m;
    public cv4 n;
    public cv4.b o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(gg7 gg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg7Var};
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
                d65.s("frsAd");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cv4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg7 a;

        public b(gg7 gg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gg7Var;
        }

        @Override // com.baidu.tieba.cv4.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg7 a;

        public c(gg7 gg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gg7Var;
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

    public gg7(TbPageContext tbPageContext) {
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
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (x2aVar = this.i) != null && !StringUtils.isNull(x2aVar.p())) {
            if (!r16.a(this.a.getPageActivity(), this.i.i())) {
                jr7.b(this.a, this.i.k(), this.i.p(), this.i.j());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.i.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            this.h.dismiss();
            cv4 cv4Var = this.n;
            if (cv4Var != null) {
                cv4Var.c();
            }
            FrsFragment.x2 = true;
            hr7.a("common_click", this.i, this.j, 1, null);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cv4 cv4Var = new cv4(this.a.getPageActivity().getBaseContext(), this.o);
            this.n = cv4Var;
            cv4Var.k(1.5d);
            this.n.j(2.5d);
            this.n.f();
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d038e, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090d96);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091f44);
            this.f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f0916bf);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092186);
            this.l = linearLayout;
            linearLayout.setOnClickListener(this.p);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.b.findViewById(R.id.obfuscated_res_0x7f09164f);
            this.m = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.frs_ad_shark);
            this.m.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c2d);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            this.c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int l = xi.l(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = l;
            layoutParams.height = (int) (l * 1.3333333333333333d);
            this.c.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c2b);
            this.d = textView;
            textView.setOnClickListener(this.p);
            x2a x2aVar = this.i;
            if (x2aVar != null) {
                this.c.N(x2aVar.e(), 10, false);
            }
            new rg7(this.f, this.m).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0344, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090d96);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091f44);
            this.e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c2d);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int l = xi.l(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = l;
            layoutParams.height = (int) (l * 1.3306452f);
            this.c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c2b);
            this.d = textView;
            textView.setOnClickListener(this.p);
            x2a x2aVar = this.i;
            if (x2aVar != null) {
                this.c.N(x2aVar.e(), 10, false);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x2a x2aVar = this.i;
            if (x2aVar != null && x2aVar.r()) {
                h();
            } else {
                i();
            }
            g55 g55Var = new g55(this.a.getPageActivity());
            this.h = g55Var;
            g55Var.setCancelable(true);
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
            x2a x2aVar2 = this.i;
            if (x2aVar2 != null && x2aVar2.f()) {
                s75 d = s75.d(this.g);
                d.o(R.string.J_X01);
                d.f(R.color.CAM_X0602);
                s75.d(this.g).x(R.color.CAM_X0617);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            hr7.k("common_exp", this.i, this.j, 1, null);
            d65.m("frsAd");
        }
    }

    public boolean j(c3a c3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c3aVar)) == null) {
            if (c3aVar == null || c3aVar.getForum() == null || c3aVar.getBusinessPromot() == null || c3aVar.getBusinessPromot().g()) {
                return false;
            }
            this.j = c3aVar.getForum();
            this.i = c3aVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + c3aVar.getForum().getId();
            long r = r95.p().r(str, 0L);
            if (r >= 0 && TimeHelper.isSameDay(new Date(r), new Date(System.currentTimeMillis()))) {
                return false;
            }
            r95.p().H(str, System.currentTimeMillis());
            k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ry
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
        }
    }
}
