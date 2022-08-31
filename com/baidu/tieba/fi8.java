package com.baidu.tieba;

import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar A;
    public boolean B;
    public int C;
    public LinearLayout a;
    public final View b;
    public final View c;
    public ViewPager d;
    public LinearLayout e;
    public NavigationBar f;
    public TextView g;
    public ImageView h;
    public BdListView i;
    public BdListView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public TextView q;
    public ImageView r;
    public cv4 s;
    public cv4 t;
    public PopupWindow u;
    public View v;
    public ForumListActivity w;
    public ListView x;
    public di8 y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi8 a;

        public a(fi8 fi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi8Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 4 && this.a.u.isShowing()) {
                    fi8 fi8Var = this.a;
                    ug.d(fi8Var.u, fi8Var.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi8 a;

        public b(fi8 fi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.u.isShowing()) {
                    fi8 fi8Var = this.a;
                    ug.d(fi8Var.u, fi8Var.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi8 a;

        public c(fi8 fi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi8Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B = false;
            }
        }
    }

    public fi8(ForumListActivity forumListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = 0;
        this.a = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f090a69);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.obfuscated_res_0x7f09256c);
        this.d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.e = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091fcc);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.obfuscated_res_0x7f092566);
        this.f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f.setTitleView(R.layout.obfuscated_res_0x7f0d0618, null);
        this.z = linearLayout;
        this.g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0921ee);
        this.h = (ImageView) this.z.findViewById(R.id.obfuscated_res_0x7f090a6c);
        TextView textView = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091fcb);
        this.k = textView;
        textView.setOnClickListener(forumListActivity);
        TextView textView2 = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091fc4);
        this.l = textView2;
        textView2.setOnClickListener(forumListActivity);
        this.s = new cv4(forumListActivity.getPageContext());
        this.t = new cv4(forumListActivity.getPageContext());
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02b1, (ViewGroup) null);
        this.m = linearLayout2;
        this.b = linearLayout2.findViewById(R.id.obfuscated_res_0x7f090a1f);
        this.n = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090a23);
        this.o = (ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f090a22);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02b1, (ViewGroup) null);
        this.p = linearLayout3;
        this.c = linearLayout3.findViewById(R.id.obfuscated_res_0x7f090a1f);
        this.q = (TextView) this.p.findViewById(R.id.obfuscated_res_0x7f090a23);
        this.r = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f090a22);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.obfuscated_res_0x7f0913ee);
        this.B = false;
        this.w = forumListActivity;
        this.y = new di8(this.w.getPageContext().getContext());
    }

    public View b(int i, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, onItemClickListener)) == null) {
            View inflate = LayoutInflater.from(this.w.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02ad, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f0907c4);
            this.x = listView;
            listView.setOnItemClickListener(onItemClickListener);
            inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
            this.C = this.y.getCount();
            this.x.setAdapter((ListAdapter) this.y);
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setVisibility(8);
        }
    }

    public void d() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ProgressBar progressBar = this.A;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ViewPager viewPager = this.d;
            if (viewPager == null) {
                return;
            }
            if (viewPager.getCurrentItem() == 0 && (bdListView = this.i) != null) {
                bdListView.A(0L);
                return;
            }
            BdListView bdListView2 = this.j;
            if (bdListView2 != null) {
                bdListView2.A(0L);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setVisibility(4);
            this.z.setClickable(false);
            this.z.setOnClickListener(null);
        }
    }

    public void f(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onItemClickListener) == null) {
            if (!this.B) {
                this.B = true;
                if (this.v == null) {
                    this.v = b(0, onItemClickListener);
                }
                int d = (ri.d(this.w.getPageContext().getPageActivity(), 160.0f) - this.z.getWidth()) / 2;
                if (this.u == null) {
                    PopupWindow popupWindow = new PopupWindow(this.v, ri.d(this.w.getPageContext().getPageActivity(), 160.0f), -2, true);
                    this.u = popupWindow;
                    popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                    if (this.C > 6) {
                        this.u.setHeight(ri.d(this.w.getPageContext().getPageActivity(), 272.0f));
                    }
                }
                this.u.setOutsideTouchable(true);
                this.u.setFocusable(true);
                this.v.setFocusable(true);
                this.v.setFocusableInTouchMode(true);
                ug.l(this.u, this.z, 0 - d, ri.d(this.w.getPageContext().getPageActivity(), 0.0f));
                this.v.setOnKeyListener(new a(this));
                this.v.setOnTouchListener(new b(this));
                this.u.setOnDismissListener(new c(this));
                return;
            }
            ug.d(this.u, this.w.getPageContext().getPageActivity());
            this.B = false;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.setVisibility(0);
        }
    }
}
