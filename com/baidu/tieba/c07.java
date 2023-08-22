package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.q17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public Context c;
    public q17 d;
    public d e;
    public x17 f;
    public boolean g;
    public q17.d h;
    public View.OnClickListener i;
    public PopupWindow.OnDismissListener j;

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public class a implements q17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        public a(c07 c07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c07Var;
        }

        @Override // com.baidu.tieba.q17.d
        public void onItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.b = i;
            StatisticItem statisticItem = new StatisticItem("c13369");
            int i2 = 1;
            if (i == 1) {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2));
            this.a.r();
            if (this.a.e != null) {
                this.a.e.a(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        public b(c07 c07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f.p()) {
                return;
            }
            if (view2 == this.a.a) {
                if (this.a.d == null) {
                    this.a.d = new q17(this.a.c);
                    this.a.d.setOnDismissListener(this.a.j);
                    this.a.d.l(this.a.h);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new vz6(this.a.c.getString(R.string.obfuscated_res_0x7f0f0b83), 2));
                arrayList.add(new vz6(this.a.c.getString(R.string.obfuscated_res_0x7f0f17a7), 1));
                this.a.d.k(arrayList, this.a.b);
                this.a.d.n(this.a.a);
            }
            this.a.g = true;
            c07 c07Var = this.a;
            c07Var.s(c07Var.g);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        public c(c07 c07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c07Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.g = false;
            c07 c07Var = this.a;
            c07Var.s(c07Var.g);
        }
    }

    public c07(Context context, int i, int i2, x17 x17Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), x17Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
        this.c = context;
        this.b = i;
        this.f = x17Var;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (n()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i);
                if (this.a != null) {
                    s(this.g);
                }
            }
            q17 q17Var = this.d;
            if (q17Var != null && this.g) {
                q17Var.j();
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || !n()) {
            return;
        }
        this.b = i;
        r();
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.a = textView;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.b;
            if (i == 2 || i == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public void p() {
        q17 q17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (q17Var = this.d) != null) {
            q17Var.i();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && n() && (textView = this.a) != null) {
            int i = this.b;
            if (i != 1) {
                if (i == 2) {
                    textView.setText(R.string.obfuscated_res_0x7f0f0b83);
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f17a7);
            }
            this.a.setOnClickListener(this.i);
            s(this.g);
        }
    }

    public final void s(boolean z) {
        int i;
        pz6 pz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                i = R.drawable.icon_pure_fold12_svg;
            } else {
                i = R.drawable.icon_pure_unfold12_svg;
            }
            x17 x17Var = this.f;
            if (x17Var != null) {
                pz6Var = x17Var.l();
            } else {
                pz6Var = null;
            }
            if (pz6Var != null && pz6Var.a) {
                x17 x17Var2 = this.f;
                if (x17Var2 != null && x17Var2.r()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                    this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
            this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
        }
    }
}
