package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f55 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int n = 2131235802;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public TbImageView e;
    public WindowManager f;
    public WindowManager.LayoutParams g;
    public int h;
    public int i;
    public float j;
    public int k;
    public Runnable l;
    public mu4 m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947715139, "Lcom/baidu/tieba/f55;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947715139, "Lcom/baidu/tieba/f55;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f55 a;

        public a(f55 f55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f55Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public f55(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 3000;
        if (context == null) {
            return;
        }
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.b = viewGroup;
        this.c = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.b.findViewById(R.id.toast_btn);
        this.d = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.toast_bg);
        this.e = tbImageView;
        tbImageView.setDefaultBgResource(n);
        this.e.setDrawCorner(true);
        this.e.setConrers(15);
        this.e.setRadius(BdUtilHelper.getDimens(context, R.dimen.tbds20));
        this.i = BdUtilHelper.getDimens(context, R.dimen.tbds176);
        this.h = BdUtilHelper.getDimens(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.b, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.f = (WindowManager) this.a.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        g();
        this.l = new a(this);
    }

    public static f55 h(Context context, mu4 mu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, mu4Var)) == null) {
            f55 f55Var = new f55(context);
            f55Var.a(mu4Var);
            return f55Var;
        }
        return (f55) invokeLL.objValue;
    }

    public final f55 a(mu4 mu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mu4Var)) == null) {
            if (this.a == null) {
                return this;
            }
            if (mu4Var == null) {
                c();
                return this;
            }
            this.m = mu4Var;
            if (ei.isEmpty(mu4Var.e)) {
                this.c.setText(this.a.getResources().getString(R.string.task_already_finish));
            } else {
                this.c.setText(mu4Var.e);
            }
            if (ei.isEmpty(mu4Var.f)) {
                this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f030a));
            } else {
                this.d.setText(mu4Var.f);
            }
            if (ei.isEmpty(mu4Var.p)) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            } else {
                this.c.setTextColor(ColorUtils.parseColor(mu4Var.p));
            }
            if (ei.isEmpty(mu4Var.q)) {
                SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            } else {
                this.d.setTextColor(ColorUtils.parseColor(mu4Var.q));
            }
            if (!ei.isEmpty(mu4Var.o)) {
                this.d.setBackgroundDrawable(b(mu4Var.o));
            }
            if (!ei.isEmpty(mu4Var.j)) {
                this.e.startLoad(mu4Var.j, 10, false);
            }
            int i = mu4Var.i;
            if (i > 3) {
                this.k = i * 1000;
            }
            this.j = (float) mu4Var.n;
            i();
            return this;
        }
        return (f55) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.a.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds10));
            gradientDrawable.setColor(ColorUtils.parseColor(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final f55 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.c.setText(this.a.getResources().getString(R.string.task_already_finish));
            this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f030a));
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (f55) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.g = layoutParams;
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.a) - (this.h * 2);
            this.g.height = BdUtilHelper.getDimens(this.a, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.g;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f1003f7;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public f55 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != null) {
                this.f.addView(this.b, this.g);
                SafeHandler.getInst().removeCallbacks(this.l);
                SafeHandler.getInst().postDelayed(this.l, this.k);
                if (this.m != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.m.a).param("obj_type", this.m.b));
                }
            }
            return this;
        }
        return (f55) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !ei.isEmpty(str) && (e = e(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(e, new String[]{str});
        }
    }

    public final TbPageContext e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a != null) {
                if (this.b.getWindowToken() != null) {
                    this.f.removeView(this.b);
                }
                SafeHandler.getInst().removeCallbacks(this.l);
            }
            this.a = null;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.g;
            layoutParams.y = this.i;
            layoutParams.alpha = this.j;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        mu4 mu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || (mu4Var = this.m) == null) {
            return;
        }
        int i = mu4Var.d;
        if (i == mu4.C) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.m.l) && !ei.isEmpty(this.m.k)) {
                d(this.m.k);
            }
        } else if (i == mu4.D && !ei.isEmpty(mu4Var.k)) {
            d(this.m.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.m.a).param("obj_type", this.m.b));
    }
}
