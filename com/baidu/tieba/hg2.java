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
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.q23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class hg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i, List list);
    }

    /* loaded from: classes4.dex */
    public final class a implements View.OnClickListener {
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
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f081155));
                } else {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f081154));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ List b;
        public final /* synthetic */ q23 c;

        public b(f fVar, List list, q23 q23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, q23Var};
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
            this.c = q23Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.a.a(dialogInterface, i, this.b)) {
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q23 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public c(q23 q23Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q23Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q23Var;
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

    /* loaded from: classes4.dex */
    public final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q23 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public d(q23 q23Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q23Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q23Var;
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

    /* loaded from: classes4.dex */
    public final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ Drawable d;
        public final /* synthetic */ int e;
        public final /* synthetic */ List f;
        public final /* synthetic */ ig2 g;
        public final /* synthetic */ View.OnClickListener h;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i, List list, ig2 ig2Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i), list, ig2Var, onClickListener};
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
            this.g = ig2Var;
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

    public static q23 a(Activity activity, m33 m33Var, String str, List list, f fVar, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, m33Var, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d081f, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091fc3);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, gh3.i(m33Var.W(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(R.color.obfuscated_res_0x7f060a56));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902f0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902f1);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091fc5)).setText(m33Var.Z());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092200)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920f1);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linearLayout.addView(b(activity, (ig2) it.next(), arrayList, new a(arrayList, textView2, resources)));
                }
            }
            q23.a aVar = new q23.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new ui3());
            aVar.p(R.drawable.obfuscated_res_0x7f080125);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            q23 c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(dh3.s(activity), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f10039c);
            }
            return c2;
        }
        return (q23) invokeCommon.objValue;
    }

    public static View b(Activity activity, ig2 ig2Var, List list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, ig2Var, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070662);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(ph4.b(activity, R.color.obfuscated_res_0x7f060a6f));
            textView.setText(ig2Var.b);
            Drawable drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c2);
            Drawable drawable2 = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c1);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, ig2Var, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
