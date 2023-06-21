package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class gq2 extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public String[] b;
    public int c;
    public e d;
    public wo2 e;

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b(int i);

        void c(String str);

        void d();
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridView a;
        public final /* synthetic */ AdapterView.OnItemClickListener b;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int intValue = ((Integer) view2.getTag()).intValue();
                    b bVar = this.a;
                    bVar.b.onItemClick(bVar.a, view2, intValue, intValue);
                }
            }
        }

        public b(gq2 gq2Var, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq2Var, gridView, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gridView;
            this.b = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.a.getChildCount();
                if (childCount > 0) {
                    this.a.setClickable(false);
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.a.getChildAt(i);
                        childAt.setTag(Integer.valueOf(i));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.a.setOnItemClickListener(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq2 a;

        public a(gq2 gq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq2Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && i >= 0 && i <= this.a.b.length) {
                if (i == 11) {
                    if (this.a.d != null) {
                        this.a.d.d();
                    }
                } else if (this.a.d != null) {
                    this.a.d.c(this.a.b[i]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq2 a;

        public c(gq2 gq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends wo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq2 a;

        public d(gq2 gq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq2Var;
        }

        @Override // com.baidu.tieba.wo2, com.baidu.tieba.xo2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, keyEvent)) == null) {
                if (i == 4) {
                    this.a.dismiss();
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq2(@NonNull Activity activity, int i, @NonNull e eVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new String[12];
        this.e = new d(this);
        this.d = eVar;
        c(i);
        d(activity);
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = 0;
            while (i2 < 9) {
                int i3 = i2 + 1;
                this.b[i2] = String.valueOf(i3);
                i2 = i3;
            }
            if (i == 1) {
                this.b[9] = "X";
            } else if (i == 0) {
                this.b[9] = "";
            } else if (i == 2) {
                this.b[9] = ".";
            }
            this.b[10] = "0";
        }
    }

    public final void d(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.a = activity;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00ba, (ViewGroup) null);
            this.c = activity.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091214);
            gridView.setAdapter((ListAdapter) new fq2(activity, this.b));
            tp3.a0(new b(this, gridView, new a(this)));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09071e);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.c);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            Activity activity = this.a;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).G0(this.e);
            }
            e eVar = this.d;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !isShowing()) {
            showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
            Activity activity = this.a;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).u0(this.e);
            }
            e eVar = this.d;
            if (eVar != null) {
                eVar.b(this.c);
            }
        }
    }
}
