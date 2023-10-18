package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h28 extends cj6<i28> {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> i;
    public View j;
    public TextView k;
    public int l;
    public String m;
    public i28 n;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d01e1 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h28 a;

        public a(h28 h28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f() == null) {
                return;
            }
            this.a.f().a(view2, this.a.n);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ h28 b;

        public b(h28 h28Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h28Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h28Var;
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.b.k.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (h28.q - h28.r)) + h28.r);
                this.b.j.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h28 a;

        public c(h28 h28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h28Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.B();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771931, "Lcom/baidu/tieba/h28;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771931, "Lcom/baidu/tieba/h28;");
                return;
            }
        }
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        o = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        p = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
        r = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h28(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.i = tbPageContext;
        View i3 = i();
        this.j = i3;
        TextView textView = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f091e5b);
        this.k = textView;
        int i4 = p;
        textView.setPadding(0, i4, 0, i4 - o);
        this.m = this.i.getResources().getString(R.string.obfuscated_res_0x7f0f09fa);
        this.j.setOnClickListener(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: A */
    public void j(i28 i28Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, i28Var) == null) && i28Var != null && this.j.getLayoutParams() != null) {
            if (!i28Var.b) {
                this.j.getLayoutParams().height = r;
                this.j.requestLayout();
                this.k.setAlpha(0.0f);
            }
            if (this.j.getLayoutParams().height != q) {
                i28Var.b = true;
                SafeHandler.getInst().postDelayed(new c(this), 1600L);
            }
            String formatTimeShort = StringHelper.getFormatTimeShort(i28Var.a);
            TextView textView = this.k;
            textView.setText(formatTimeShort + this.m);
            k(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void B() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (layoutParams = this.j.getLayoutParams()) == null || layoutParams.height == q) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, layoutParams));
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.l != i) {
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0304);
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
                this.k.setCompoundDrawables(pureDrawable, null, null, null);
            }
            this.l = i;
        }
    }
}
