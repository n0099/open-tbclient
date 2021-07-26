package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.s.b;
import d.a.q0.u0.d1;
import d.a.q0.u0.e1;
import d.a.q0.u0.k2.f;
import d.a.q0.u0.o0;
import d.a.q0.u0.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements d.a.q0.u0.k2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16078e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f16079f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.q0.u0.k2.f f16080g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.q0.u0.k2.e> f16081h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.q0.u0.k2.e> f16082i;
    public TabItemView j;
    public d.a.q0.u0.k2.c k;
    public final Paint l;
    public final int m;
    public final int n;
    public int o;
    public boolean p;
    public TbPageContext q;
    public boolean r;
    public int s;
    public g t;
    public h u;
    public f.e v;
    public f.d w;
    public o0 x;
    public View.OnClickListener y;
    public i z;

    /* loaded from: classes4.dex */
    public class a implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16083a;

        public a(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16083a = horizontalTabView;
        }

        @Override // d.a.q0.u0.k2.f.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f16083a.j != null && this.f16083a.x != null && this.f16083a.x != null) {
                    this.f16083a.x.q(this.f16083a.j.getTabId(), i2, null);
                }
                if (this.f16083a.k != null) {
                    this.f16083a.k.b(i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16084a;

        public b(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16084a = horizontalTabView;
        }

        @Override // d.a.q0.u0.k2.f.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.f16084a.i(tabItemView, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16085e;

        public c(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16085e = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16085e.r) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (this.f16085e.t != null) {
                            this.f16085e.t.a(this.f16085e.k(1));
                        }
                        this.f16085e.q();
                        return;
                    }
                    return;
                }
                boolean z = view instanceof TabItemView;
                if (z) {
                    this.f16085e.i((TabItemView) view, false);
                }
                if (this.f16085e.k != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view;
                        if (HorizontalTabView.o(tabItemView.getTabId())) {
                            this.f16085e.k.a(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.f16085e.j != null) {
                        this.f16085e.k.a(this.f16085e.j.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e1 f16086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16087b;

        public d(HorizontalTabView horizontalTabView, e1 e1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, e1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16087b = horizontalTabView;
            this.f16086a = e1Var;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || this.f16086a.f63261b.size() <= i2 || this.f16086a.f63261b.get(i2) == null) {
                return;
            }
            bVar.e();
            HorizontalTabView horizontalTabView = this.f16087b;
            horizontalTabView.h(horizontalTabView.k(this.f16086a.f63261b.get(i2).f63255b));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16089f;

        public e(HorizontalTabView horizontalTabView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16089f = horizontalTabView;
            this.f16088e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16089f.scrollBy(0 - this.f16088e, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f16090e;

        public f(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16090e = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.f16090e;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(d.a.q0.u0.k2.e eVar);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(d.a.q0.u0.k2.e eVar);
    }

    /* loaded from: classes4.dex */
    public interface i {
        boolean a(int i2);

        void b(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16078e = 0;
        this.j = null;
        this.k = null;
        this.l = new Paint();
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.o = 0;
        this.p = true;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f16079f = linearLayout;
        linearLayout.setOrientation(0);
        this.f16079f.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.f16080g = new d.a.q0.u0.k2.f(context, this.v, this.w);
        m(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            TabItemView tabItemView = this.j;
            if (tabItemView == null || this.f16078e == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.f16078e) - this.j.getDrawableWidth()) / 2;
        }
        return invokeV.intValue;
    }

    public static boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    @Override // d.a.q0.u0.k2.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // d.a.q0.u0.k2.c
    public void b(int i2) {
        TabItemView tabItemView;
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tabItemView = this.j) == null || (o0Var = this.x) == null) {
            return;
        }
        o0Var.q(tabItemView.getTabId(), i2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.j != null) {
                this.l.setColor(SkinManager.getColor(R.color.CAM_X0204));
                if (this.p) {
                    canvas.drawRect(this.f16079f.getLeft(), getMeasuredHeight() - this.n, this.f16079f.getRight() > getRight() ? this.f16079f.getRight() : getRight(), getMeasuredHeight(), this.l);
                }
                if (!this.r) {
                    int i2 = this.s;
                    if (i2 == 0) {
                        this.l.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0302));
                    } else {
                        this.l.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.j.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.m, (this.j.getRight() - getBottomLineMargin()) - this.j.getDrawableWidth(), getMeasuredHeight(), this.l);
                }
            }
            if (this.r) {
                this.l.setAntiAlias(true);
                this.l.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
                int g2 = l.g(getContext(), R.dimen.ds96);
                TabItemView tabItemView = this.j;
                if (tabItemView != null) {
                    g2 = tabItemView.getRight() - this.j.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g2, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.l);
            }
        }
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.z : (i) invokeV.objValue;
    }

    public void h(d.a.q0.u0.k2.e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) || eVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(eVar);
        }
        if (eVar.f63656b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(eVar.f63656b)) {
            if (this.x == null || TextUtils.isEmpty(eVar.f63658d)) {
                return;
            }
            y0 y0Var = new y0();
            String str = eVar.f63658d;
            this.x.q(eVar.f63656b, -1, y0Var);
            return;
        }
        int i2 = eVar.f63656b;
        y0 y0Var2 = null;
        if (i2 == 301) {
            o0 o0Var = this.x;
            if (o0Var != null) {
                o0Var.q(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.x == null) {
            z = true;
        } else {
            y0 y0Var3 = new y0();
            String str2 = eVar.f63658d;
            String str3 = eVar.f63655a;
            this.x.q(eVar.f63656b, 0, y0Var3);
            if (y0Var3.f64661d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f16079f.getChildCount(); i3++) {
            View childAt = this.f16079f.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(eVar.f63655a);
                }
            }
        }
        if (!TextUtils.isEmpty(eVar.f63658d)) {
            y0Var2 = new y0();
            String str4 = eVar.f63658d;
            String str5 = eVar.f63655a;
        }
        o0 o0Var2 = this.x;
        if (o0Var2 == null || !z) {
            return;
        }
        o0Var2.q(eVar.f63656b, 0, y0Var2);
    }

    public void i(TabItemView tabItemView, boolean z) {
        o0 o0Var;
        List<d1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, tabItemView, z) == null) || tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(tabItemView.getTabId())) {
            if (this.x == null || TextUtils.isEmpty(tabItemView.getUrl())) {
                return;
            }
            y0 y0Var = new y0();
            tabItemView.getUrl();
            this.x.q(tabItemView.getTabId(), -1, y0Var);
            return;
        }
        y0 y0Var2 = null;
        if (tabItemView.getTabId() == 301) {
            o0 o0Var2 = this.x;
            if (o0Var2 != null) {
                o0Var2.q(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.j = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = l.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.f16079f.getChildCount(); i3++) {
            View childAt = this.f16079f.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.j.getTabId() && !o(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.f16091i);
                }
            }
        }
        if (this.j.getState() != TabItemView.f16091i && this.j.getState() != TabItemView.k) {
            if (l(this.j.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.j.getTabId())) {
                    return;
                }
                this.j.setState(TabItemView.k);
                TabItemView tabItemView3 = this.j;
                this.f16080g.f((Activity) getContext(), this, tabItemView3, j(tabItemView3.getTabId()).f63657c);
            }
        } else {
            this.f16080g.c();
            boolean z2 = this.j.getState() == TabItemView.f16091i;
            this.j.setState(TabItemView.j);
            d.a.q0.u0.k2.e j = j(this.j.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.f63658d)) {
                y0Var2 = new y0();
                String str = j.f63658d;
                String str2 = j.f63655a;
            }
            e1 e1Var = j.f63657c;
            if (e1Var != null && (list = e1Var.f63261b) != null && list.size() > 0) {
                for (d1 d1Var : j.f63657c.f63261b) {
                    if (d1Var != null && d1Var.f63256c) {
                        i2 = d1Var.f63255b;
                    }
                }
            }
            if (z2 && (o0Var = this.x) != null) {
                o0Var.q(this.j.getTabId(), i2, y0Var2);
            }
        }
        invalidate();
    }

    public final d.a.q0.u0.k2.e j(int i2) {
        InterceptResult invokeI;
        List<d.a.q0.u0.k2.e> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.f16082i) != null && list.size() != 0) {
                for (d.a.q0.u0.k2.e eVar : this.f16082i) {
                    if (eVar != null && eVar.f63656b == i2) {
                        return eVar;
                    }
                }
            }
            return null;
        }
        return (d.a.q0.u0.k2.e) invokeI.objValue;
    }

    public d.a.q0.u0.k2.e k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f16082i)) {
                return null;
            }
            for (d.a.q0.u0.k2.e eVar : this.f16082i) {
                if (eVar != null && eVar.f63656b == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (d.a.q0.u0.k2.e) invokeI.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        e1 e1Var;
        List<d1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            d.a.q0.u0.k2.e j = j(i2);
            return (j == null || (e1Var = j.f63657c) == null || (list = e1Var.f63261b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void m(AbsListView.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, layoutParams) == null) {
            addView(this.f16079f, layoutParams);
            setLayoutParams(layoutParams);
            setHorizontalScrollBarEnabled(false);
            SkinManager.setBackgroundColor(this, R.color.transparent);
            setDescendantFocusability(262144);
        }
    }

    public final boolean n(List<d.a.q0.u0.k2.e> list) {
        InterceptResult invokeL;
        e1 e1Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            d.a.q0.u0.k2.e j = j(1);
            d.a.q0.u0.k2.e eVar = null;
            Iterator<d.a.q0.u0.k2.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.q0.u0.k2.e next = it.next();
                if (next != null && next.f63656b == 1) {
                    eVar = next;
                    break;
                }
            }
            if (j == null || eVar == null || (j.f63657c == null && eVar.f63657c == null)) {
                return false;
            }
            if ((j.f63657c != null || eVar.f63657c == null) && (eVar.f63657c != null || j.f63657c == null)) {
                e1 e1Var2 = j.f63657c;
                if (e1Var2 == null || (e1Var = eVar.f63657c) == null || (e1Var2.f63261b == null && e1Var.f63261b == null)) {
                    return false;
                }
                if ((j.f63657c.f63261b != null || eVar.f63657c.f63261b == null) && ((eVar.f63657c.f63261b != null || j.f63657c.f63261b == null) && (size = j.f63657c.f63261b.size()) == eVar.f63657c.f63261b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        d1 d1Var = eVar.f63657c.f63261b.get(i2);
                        d1 d1Var2 = j.f63657c.f63261b.get(i2);
                        if (d1Var.f63255b != d1Var2.f63255b || !d1Var.f63254a.equals(d1Var2.f63254a)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(List<d.a.q0.u0.k2.e> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.o > 0 && list.size() == this.o) {
                layoutParams = new LinearLayout.LayoutParams(l.k(getContext()) / this.o, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.f16081h == null || n(list)) {
                    this.f16081h = list;
                    this.f16079f.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d.a.q0.u0.k2.e eVar = list.get(i4);
                        if (eVar != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), eVar, i3, this.r);
                            int i5 = this.s;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.y);
                            if (o(eVar.f63656b)) {
                                SkinManager.setViewTextColor(tabItemView, R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.f16079f.addView(tabItemView, layoutParams);
                            if (eVar.f63656b == i2) {
                                this.j = tabItemView;
                                tabItemView.setState(TabItemView.j);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.f16081h = null;
            d.a.q0.u0.k2.e eVar2 = new d.a.q0.u0.k2.e();
            eVar2.f63656b = 1;
            eVar2.f63655a = getContext().getResources().getString(R.string.chosen_pb_title);
            this.f16079f.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), eVar2, i3, this.r);
            int i6 = this.s;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.y);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.f16079f.addView(tabItemView2, layoutParams);
            this.j = tabItemView2;
            tabItemView2.setState(TabItemView.j);
        }
    }

    public void q() {
        e1 e1Var;
        List<d1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.q0.u0.k2.e> list2 = this.f16081h;
        if (list2 == null || list2.size() <= 0 || this.f16081h.get(0) == null || (e1Var = this.f16081h.get(0).f63657c) == null || (list = e1Var.f63261b) == null) {
            return;
        }
        for (d1 d1Var : list) {
            if (d1Var != null) {
                arrayList.add(d1Var.f63254a);
            }
        }
        d.a.p0.s.s.b bVar = new d.a.p0.s.s.b(this.q.getPageActivity());
        bVar.i(arrayList, new d(this, e1Var));
        bVar.c(this.q);
        bVar.m();
    }

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setData(List<d.a.q0.u0.k2.e> list, int i2, int i3) {
        d.a.q0.u0.k2.e eVar;
        List<d1> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.r) {
                ArrayList arrayList = new ArrayList();
                this.f16082i = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (eVar = list.get(0)) != null && eVar.f63656b == 1) {
                    e1 e1Var = eVar.f63657c;
                    if (e1Var != null && (list2 = e1Var.f63261b) != null) {
                        list2.clear();
                    } else {
                        e1Var = new e1();
                        e1Var.f63261b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        d1 d1Var = new d1();
                        d1Var.f63255b = 1;
                        d1Var.f63254a = getContext().getString(R.string.chosen_pb_title);
                        e1Var.f63261b.add(d1Var);
                        for (d.a.q0.u0.k2.e eVar2 : list) {
                            if (eVar2 != null && eVar2.f63656b != 1) {
                                d1 d1Var2 = new d1();
                                d1Var2.f63255b = eVar2.f63656b;
                                d1Var2.f63254a = eVar2.f63655a;
                                e1Var.f63261b.add(d1Var2);
                            }
                        }
                        eVar.f63657c = e1Var;
                    }
                    list.clear();
                    list.add(eVar);
                }
            } else {
                this.f16082i = list;
            }
            p(list, i2, i3, false);
        }
    }

    public void setDataLoadInterface(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o0Var) == null) {
            this.x = o0Var;
        }
    }

    public void setFakeTab(d.a.q0.u0.k2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.r = z;
        }
    }

    public void setNeedBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
            invalidate();
        }
    }

    public void setOnTabItemClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.t = gVar;
        }
    }

    public void setOnTabItemSelectListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hVar) == null) {
            this.u = hVar;
        }
    }

    public void setSelectedItemColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setTabBackgroudColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    public void setmShowMenuCallBack(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.z = iVar;
        }
    }
}
