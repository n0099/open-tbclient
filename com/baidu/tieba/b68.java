package com.baidu.tieba;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.sa5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b68 extends nn implements BigdaySwipeRefreshLayout.k, PersonalizePageView.y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView g;
    public LottieAnimationView h;
    public ImageView i;
    public TextView j;
    public m15 k;
    public String l;
    public String m;
    public String n;
    public String o;
    public sa5.g p;
    public sa5.f q;
    public sa5.h r;
    public sa5.e s;

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b68 a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(b68 b68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b68Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && this.a.g.getBdImage() == null && this.a.k != null && !xi.isEmpty(this.a.k.a)) {
                this.a.g.N(this.a.k.a, 41, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b68(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        if (context != null) {
            this.l = context.getText(R.string.obfuscated_res_0x7f0f0108).toString();
            this.m = context.getText(R.string.obfuscated_res_0x7f0f0354).toString();
            this.n = context.getText(R.string.obfuscated_res_0x7f0f0356).toString();
            this.o = context.getText(R.string.obfuscated_res_0x7f0f0355).toString();
        }
    }

    public void I(m15 m15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, m15Var) == null) {
            if (m15Var.a()) {
                this.k = m15Var;
            }
            if (m15Var.c == 1) {
                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037e);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110052);
            } else {
                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037f);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110051);
            }
            this.h.setFrame(0);
            this.g.N(m15Var.a, 41, false);
            this.g.setOnDrawListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.y0
    public void f(sa5.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.p = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.y0
    public void g(sa5.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            this.r = hVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.y0
    public void k(sa5.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.s = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.y0
    public void m(sa5.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.q = fVar;
        }
    }

    @Override // com.baidu.tieba.nn
    public void u(boolean z) {
        sa5.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (gVar = this.p) != null) {
            gVar.e(z);
        }
    }

    @Override // com.baidu.tieba.nn
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            H(1.0f);
            this.j.setText(this.l);
            sa5.h hVar = this.r;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    public m15 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (m15) invokeV.objValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.setText(this.o);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (int) (yi.j(getContext()) * 0.3d);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nn
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.j.setText("");
            this.h.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.nn
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.j.setText(this.n);
        }
    }

    public final void H(float f) {
        m15 m15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.j.setAlpha(f);
            this.i.setAlpha(f);
            if (this.i.getBackground() == null && (m15Var = this.k) != null) {
                if (m15Var.c == 1) {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037e);
                } else {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037f);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            H(1.0f);
            this.h.setAlpha(1.0f);
            this.j.setText(this.l);
            sa5.e eVar = this.s;
            if (eVar != null) {
                eVar.a();
            }
            sa5.f fVar = this.q;
            if (fVar != null) {
                fVar.a(getView(), z);
            }
            this.h.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.nn, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.c(f, f2);
            float dimension = getView().getResources().getDimension(R.dimen.tbds120);
            float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
            float f3 = f * dimension2;
            if (f3 < dimension2) {
                float f4 = 0.09090909f;
                float f5 = ((f3 - dimension) / (dimension2 - dimension)) * 0.09090909f;
                if (f5 < 0.0f) {
                    f4 = 0.0f;
                } else if (f5 <= 0.09090909f) {
                    f4 = f5;
                }
                this.h.setProgress(f4);
                return;
            }
            this.h.setAlpha(1.0f - ((f3 - dimension2) / (j() - dimension2)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void i() {
        m15 m15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (m15Var = this.k) != null && m15Var.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context context = getContext();
            m15 m15Var2 = this.k;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(context, m15Var2.a, m15Var2.b, m15Var2.d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.j.animate().alpha(0.0f).setDuration(200L).start();
            this.i.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.nn
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            H(1.0f);
            this.j.setText(this.m);
            this.h.setAlpha(1.0f);
            this.h.setMinAndMaxFrame(8, 58);
            this.h.loop(true);
            this.h.playAnimation();
        }
    }

    @Override // com.baidu.tieba.nn
    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0174, (ViewGroup) null, false);
            this.g = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d82);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903ef);
            this.h = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f1);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092462);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092293);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a5));
            }
            this.g.setAutoChangeStyle(false);
            this.j.setText(this.l);
            return inflate;
        }
        return (View) invokeV.objValue;
    }
}
