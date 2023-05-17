package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.k83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class bm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i, List<cm2> list);
    }

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Resources c;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = textView;
            this.c = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.size() > 0) {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f081374));
                } else {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f081373));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ List b;
        public final /* synthetic */ k83 c;

        public b(f fVar, List list, k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, k83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = list;
            this.c = k83Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.a.a(dialogInterface, i, this.b)) {
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k83 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public c(k83 k83Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k83Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k83Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-1);
                this.b.onClick(this.a, -1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k83 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public d(k83 k83Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k83Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k83Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-2);
                this.b.onClick(this.a, -2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ Drawable d;
        public final /* synthetic */ int e;
        public final /* synthetic */ List f;
        public final /* synthetic */ cm2 g;
        public final /* synthetic */ View.OnClickListener h;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i, List list, cm2 cm2Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i), list, cm2Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = textView;
            this.c = drawable;
            this.d = drawable2;
            this.e = i;
            this.f = list;
            this.g = cm2Var;
            this.h = onClickListener;
            this.a = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !this.a;
                this.a = z;
                TextView textView = this.b;
                if (z) {
                    drawable = this.c;
                } else {
                    drawable = this.d;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                this.b.setCompoundDrawablePadding(this.e);
                if (this.a) {
                    this.f.add(this.g);
                } else {
                    this.f.remove(this.g);
                }
                this.h.onClick(view2);
            }
        }
    }

    @UiThread
    public static k83 a(@NonNull Activity activity, @NonNull g93 g93Var, @Nullable String str, @NonNull List<cm2> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, g93Var, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d08c8, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09220c);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, an3.i(g93Var.W(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(R.color.obfuscated_res_0x7f060a8f));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902ff);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090300);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09220e)).setText(g93Var.Z());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09246c)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09235d);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (cm2 cm2Var : list) {
                    linearLayout.addView(b(activity, cm2Var, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            k83.a aVar = new k83.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new oo3());
            aVar.p(R.drawable.obfuscated_res_0x7f08013f);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            k83 c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(xm3.s(activity), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003af);
            }
            return c2;
        }
        return (k83) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull cm2 cm2Var, List<cm2> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, cm2Var, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0707c7);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(jn4.b(activity, R.color.obfuscated_res_0x7f060aa8));
            textView.setText(cm2Var.b);
            Drawable drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801dc);
            Drawable drawable2 = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801db);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, cm2Var, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
