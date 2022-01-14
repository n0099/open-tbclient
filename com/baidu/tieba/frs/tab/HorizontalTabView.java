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
import c.a.d.f.p.n;
import c.a.s0.s.s.c;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.i1;
import c.a.t0.d1.o1;
import c.a.t0.d1.p0;
import c.a.t0.d1.p1;
import c.a.t0.d1.x2.f;
import c.a.t0.d1.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements c.a.t0.d1.x2.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TEXT_LENGTH_ON_TAB = 12;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f43701e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.t0.d1.x2.f f43702f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.t0.d1.x2.e> f43703g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.t0.d1.x2.e> f43704h;

    /* renamed from: i  reason: collision with root package name */
    public TabItemView f43705i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.d1.x2.c f43706j;
    public final Paint k;
    public final int l;
    public final int m;
    public int mBottomLineWith;
    public int n;
    public boolean o;
    public int p;
    public TbPageContext q;
    public boolean r;
    public int s;
    public g t;
    public h u;
    public f.e v;
    public f.d w;
    public p0 x;
    public View.OnClickListener y;
    public i z;

    /* loaded from: classes12.dex */
    public class a implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalTabView a;

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
            this.a = horizontalTabView;
        }

        @Override // c.a.t0.d1.x2.f.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f43705i != null && this.a.x != null && this.a.x != null) {
                    this.a.x.q(this.a.f43705i.getTabId(), i2, null);
                }
                if (this.a.f43706j != null) {
                    this.a.f43706j.onSelectedMenu(i2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalTabView a;

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
            this.a = horizontalTabView;
        }

        @Override // c.a.t0.d1.x2.f.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.a.dealClick(tabItemView, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f43707e;

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
            this.f43707e = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f43707e.r) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (this.f43707e.t != null) {
                            this.f43707e.t.a(this.f43707e.getOriginalDataById(1));
                        }
                        this.f43707e.showNewOpDialog();
                        return;
                    }
                    return;
                }
                boolean z = view instanceof TabItemView;
                if (z) {
                    this.f43707e.dealClick((TabItemView) view, false);
                }
                if (this.f43707e.f43706j != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view;
                        if (HorizontalTabView.isNewPageTab(tabItemView.getTabId())) {
                            this.f43707e.f43706j.onSelected(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.f43707e.f43705i != null) {
                        this.f43707e.f43706j.onSelected(this.f43707e.f43705i.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements c.InterfaceC0884c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p1 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f43708b;

        public d(HorizontalTabView horizontalTabView, p1 p1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, p1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43708b = horizontalTabView;
            this.a = p1Var;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0884c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) || this.a.f16353b.size() <= i2 || this.a.f16353b.get(i2) == null) {
                return;
            }
            cVar.e();
            HorizontalTabView horizontalTabView = this.f43708b;
            horizontalTabView.dealClick(horizontalTabView.getOriginalDataById(this.a.f16353b.get(i2).f16351b));
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f43710f;

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
            this.f43710f = horizontalTabView;
            this.f43709e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43710f.scrollBy(0 - this.f43709e, 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f43711e;

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
            this.f43711e = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.f43711e;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(d1.ds160), 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface g {
        void a(c.a.t0.d1.x2.e eVar);
    }

    /* loaded from: classes12.dex */
    public interface h {
        void a(c.a.t0.d1.x2.e eVar);
    }

    /* loaded from: classes12.dex */
    public interface i {
        boolean a(int i2);

        void b(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalTabView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mBottomLineWith = 0;
        this.f43705i = null;
        this.f43706j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds1);
        this.n = 0;
        this.o = true;
        this.p = c1.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        this.q = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f43701e = linearLayout;
        linearLayout.setOrientation(0);
        this.f43701e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d1.ds88));
        this.f43702f = new c.a.t0.d1.x2.f(tbPageContext.getPageActivity(), this.v, this.w);
        h(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TabItemView tabItemView = this.f43705i;
            if (tabItemView == null || this.mBottomLineWith == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.mBottomLineWith) - this.f43705i.getDrawableWidth()) / 2;
        }
        return invokeV.intValue;
    }

    public static boolean isNewPageTab(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this, this.p);
            for (int i2 = 0; i2 < this.f43701e.getChildCount(); i2++) {
                View childAt = this.f43701e.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (isNewPageTab(tabItemView.getTabId())) {
                        SkinManager.setViewTextColor(childAt, c1.CAM_X0105);
                    } else {
                        tabItemView.changeSkinType();
                    }
                }
            }
            this.f43702f.c();
        }
    }

    public void dealClick(c.a.t0.d1.x2.e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(eVar);
        }
        if (eVar.f16765b == 49) {
            TiebaStatic.log("c11841");
        }
        if (isNewPageTab(eVar.f16765b)) {
            if (this.x == null || TextUtils.isEmpty(eVar.f16767d)) {
                return;
            }
            z0 z0Var = new z0();
            String str = eVar.f16767d;
            this.x.q(eVar.f16765b, -1, z0Var);
            return;
        }
        int i2 = eVar.f16765b;
        z0 z0Var2 = null;
        if (i2 == 301) {
            p0 p0Var = this.x;
            if (p0Var != null) {
                p0Var.q(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.x == null) {
            z = true;
        } else {
            z0 z0Var3 = new z0();
            String str2 = eVar.f16767d;
            String str3 = eVar.a;
            this.x.q(eVar.f16765b, 0, z0Var3);
            if (z0Var3.f16900d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f43701e.getChildCount(); i3++) {
            View childAt = this.f43701e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(eVar.a);
                }
            }
        }
        if (!TextUtils.isEmpty(eVar.f16767d)) {
            z0Var2 = new z0();
            String str4 = eVar.f16767d;
            String str5 = eVar.a;
        }
        p0 p0Var2 = this.x;
        if (p0Var2 == null || !z) {
            return;
        }
        p0Var2.q(eVar.f16765b, 0, z0Var2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f43705i != null) {
                this.k.setColor(SkinManager.getColor(c1.CAM_X0204));
                if (this.o) {
                    canvas.drawRect(this.f43701e.getLeft(), getMeasuredHeight() - this.m, this.f43701e.getRight() > getRight() ? this.f43701e.getRight() : getRight(), getMeasuredHeight(), this.k);
                }
                if (!this.r) {
                    int i2 = this.s;
                    if (i2 == 0) {
                        this.k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0302));
                    } else {
                        this.k.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.f43705i.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.l, (this.f43705i.getRight() - getBottomLineMargin()) - this.f43705i.getDrawableWidth(), getMeasuredHeight(), this.k);
                }
            }
            if (this.r) {
                this.k.setAntiAlias(true);
                this.k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0105));
                int f2 = n.f(getContext(), d1.ds96);
                TabItemView tabItemView = this.f43705i;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f43705i.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(n.f(getContext(), d1.tbds44), n.f(getContext(), d1.tbds98), f2, n.f(getContext(), d1.tbds104)), n.f(getContext(), d1.tbds6), n.f(getContext(), d1.tbds6), this.k);
            }
        }
    }

    public final c.a.t0.d1.x2.e f(int i2) {
        InterceptResult invokeI;
        List<c.a.t0.d1.x2.e> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0 && (list = this.f43704h) != null && list.size() != 0) {
                for (c.a.t0.d1.x2.e eVar : this.f43704h) {
                    if (eVar != null && eVar.f16765b == i2) {
                        return eVar;
                    }
                }
            }
            return null;
        }
        return (c.a.t0.d1.x2.e) invokeI.objValue;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        p1 p1Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c.a.t0.d1.x2.e f2 = f(i2);
            return (f2 == null || (p1Var = f2.f16766c) == null || (list = p1Var.f16353b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public c.a.t0.d1.x2.e getOriginalDataById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f43704h)) {
                return null;
            }
            for (c.a.t0.d1.x2.e eVar : this.f43704h) {
                if (eVar != null && eVar.f16765b == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (c.a.t0.d1.x2.e) invokeI.objValue;
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (i) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void h(AbsListView.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            addView(this.f43701e, layoutParams);
            setLayoutParams(layoutParams);
            setHorizontalScrollBarEnabled(false);
            SkinManager.setBackgroundColor(this, c1.transparent);
            setDescendantFocusability(262144);
        }
    }

    public boolean haveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<c.a.t0.d1.x2.e> list = this.f43704h;
            return (list == null || list.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(List<c.a.t0.d1.x2.e> list) {
        InterceptResult invokeL;
        p1 p1Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            c.a.t0.d1.x2.e f2 = f(1);
            c.a.t0.d1.x2.e eVar = null;
            Iterator<c.a.t0.d1.x2.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.t0.d1.x2.e next = it.next();
                if (next != null && next.f16765b == 1) {
                    eVar = next;
                    break;
                }
            }
            if (f2 == null || eVar == null || (f2.f16766c == null && eVar.f16766c == null)) {
                return false;
            }
            if ((f2.f16766c != null || eVar.f16766c == null) && (eVar.f16766c != null || f2.f16766c == null)) {
                p1 p1Var2 = f2.f16766c;
                if (p1Var2 == null || (p1Var = eVar.f16766c) == null || (p1Var2.f16353b == null && p1Var.f16353b == null)) {
                    return false;
                }
                if ((f2.f16766c.f16353b != null || eVar.f16766c.f16353b == null) && ((eVar.f16766c.f16353b != null || f2.f16766c.f16353b == null) && (size = f2.f16766c.f16353b.size()) == eVar.f16766c.f16353b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        o1 o1Var = eVar.f16766c.f16353b.get(i2);
                        o1 o1Var2 = f2.f16766c.f16353b.get(i2);
                        if (o1Var.f16351b != o1Var2.f16351b || !o1Var.a.equals(o1Var2.a)) {
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

    public final void j(List<c.a.t0.d1.x2.e> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.n > 0 && list.size() == this.n) {
                layoutParams = new LinearLayout.LayoutParams(n.k(getContext()) / this.n, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds15);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.f43703g == null || i(list)) {
                    this.f43703g = list;
                    this.f43701e.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        c.a.t0.d1.x2.e eVar = list.get(i4);
                        if (eVar != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), eVar, i3, this.r);
                            int i5 = this.s;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.y);
                            if (isNewPageTab(eVar.f16765b)) {
                                SkinManager.setViewTextColor(tabItemView, c1.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.tbds44);
                            }
                            this.f43701e.addView(tabItemView, layoutParams);
                            if (eVar.f16765b == i2) {
                                this.f43705i = tabItemView;
                                tabItemView.setState(TabItemView.STATE_CHECKED);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.f43703g = null;
            c.a.t0.d1.x2.e eVar2 = new c.a.t0.d1.x2.e();
            eVar2.f16765b = 1;
            eVar2.a = getContext().getResources().getString(i1.chosen_pb_title);
            this.f43701e.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), eVar2, i3, this.r);
            int i6 = this.s;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.y);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.ds32);
            this.f43701e.addView(tabItemView2, layoutParams);
            this.f43705i = tabItemView2;
            tabItemView2.setState(TabItemView.STATE_CHECKED);
        }
    }

    @Override // c.a.t0.d1.x2.c
    public void onSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            dealClick(getOriginalDataById(i2));
        }
    }

    @Override // c.a.t0.d1.x2.c
    public void onSelectedMenu(int i2) {
        TabItemView tabItemView;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tabItemView = this.f43705i) == null || (p0Var = this.x) == null) {
            return;
        }
        p0Var.q(tabItemView.getTabId(), i2, null);
    }

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setData(List<c.a.t0.d1.x2.e> list, int i2, int i3) {
        c.a.t0.d1.x2.e eVar;
        List<o1> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, list, i2, i3) == null) {
            if (this.r) {
                ArrayList arrayList = new ArrayList();
                this.f43704h = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (eVar = list.get(0)) != null && eVar.f16765b == 1) {
                    p1 p1Var = eVar.f16766c;
                    if (p1Var != null && (list2 = p1Var.f16353b) != null) {
                        list2.clear();
                    } else {
                        p1Var = new p1();
                        p1Var.f16353b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        o1 o1Var = new o1();
                        o1Var.f16351b = 1;
                        o1Var.a = getContext().getString(i1.chosen_pb_title);
                        p1Var.f16353b.add(o1Var);
                        for (c.a.t0.d1.x2.e eVar2 : list) {
                            if (eVar2 != null && eVar2.f16765b != 1) {
                                o1 o1Var2 = new o1();
                                o1Var2.f16351b = eVar2.f16765b;
                                o1Var2.a = eVar2.a;
                                p1Var.f16353b.add(o1Var2);
                            }
                        }
                        eVar.f16766c = p1Var;
                    }
                    list.clear();
                    list.add(eVar);
                }
            } else {
                this.f43704h = list;
            }
            j(list, i2, i3, false);
        }
    }

    public void setDataLoadInterface(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, p0Var) == null) {
            this.x = p0Var;
        }
    }

    public void setFakeTab(c.a.t0.d1.x2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f43706j = cVar;
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.r = z;
        }
    }

    public void setNeedBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
            invalidate();
        }
    }

    public void setOnTabItemClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, gVar) == null) {
            this.t = gVar;
        }
    }

    public void setOnTabItemSelectListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, hVar) == null) {
            this.u = hVar;
        }
    }

    public void setSelectedItemColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setTabBackgroudColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setmShowMenuCallBack(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iVar) == null) {
            this.z = iVar;
        }
    }

    public void showNewOpDialog() {
        p1 p1Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.q == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<c.a.t0.d1.x2.e> list2 = this.f43703g;
        if (list2 == null || list2.size() <= 0 || this.f43703g.get(0) == null || (p1Var = this.f43703g.get(0).f16766c) == null || (list = p1Var.f16353b) == null) {
            return;
        }
        for (o1 o1Var : list) {
            if (o1Var != null) {
                arrayList.add(o1Var.a);
            }
        }
        c.a.s0.s.s.c cVar = new c.a.s0.s.s.c(this.q.getPageActivity());
        cVar.i(arrayList, new d(this, p1Var));
        cVar.c(this.q);
        cVar.m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBottomLineWith = 0;
        this.f43705i = null;
        this.f43706j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds1);
        this.n = 0;
        this.o = true;
        this.p = c1.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f43701e = linearLayout;
        linearLayout.setOrientation(0);
        this.f43701e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d1.ds88));
        this.f43702f = new c.a.t0.d1.x2.f(context, this.v, this.w);
        h(layoutParams);
    }

    public void dealClick(TabItemView tabItemView, boolean z) {
        p0 p0Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, tabItemView, z) == null) || tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (isNewPageTab(tabItemView.getTabId())) {
            if (this.x == null || TextUtils.isEmpty(tabItemView.getUrl())) {
                return;
            }
            z0 z0Var = new z0();
            tabItemView.getUrl();
            this.x.q(tabItemView.getTabId(), -1, z0Var);
            return;
        }
        z0 z0Var2 = null;
        if (tabItemView.getTabId() == 301) {
            p0 p0Var2 = this.x;
            if (p0Var2 != null) {
                p0Var2.q(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f43705i = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = n.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds160);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.f43701e.getChildCount(); i3++) {
            View childAt = this.f43701e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f43705i.getTabId() && !isNewPageTab(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.STATE_UNCHECKED);
                }
            }
        }
        if (this.f43705i.getState() != TabItemView.STATE_UNCHECKED && this.f43705i.getState() != TabItemView.STATE_EXPANDED) {
            if (g(this.f43705i.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.f43705i.getTabId())) {
                    return;
                }
                this.f43705i.setState(TabItemView.STATE_EXPANDED);
                TabItemView tabItemView3 = this.f43705i;
                this.f43702f.g((Activity) getContext(), this, tabItemView3, f(tabItemView3.getTabId()).f16766c);
            }
        } else {
            this.f43702f.d();
            boolean z2 = this.f43705i.getState() == TabItemView.STATE_UNCHECKED;
            this.f43705i.setState(TabItemView.STATE_CHECKED);
            c.a.t0.d1.x2.e f2 = f(this.f43705i.getTabId());
            if (f2 == null) {
                return;
            }
            if (!TextUtils.isEmpty(f2.f16767d)) {
                z0Var2 = new z0();
                String str = f2.f16767d;
                String str2 = f2.a;
            }
            p1 p1Var = f2.f16766c;
            if (p1Var != null && (list = p1Var.f16353b) != null && list.size() > 0) {
                for (o1 o1Var : f2.f16766c.f16353b) {
                    if (o1Var != null && o1Var.f16352c) {
                        i2 = o1Var.f16351b;
                    }
                }
            }
            if (z2 && (p0Var = this.x) != null) {
                p0Var.q(this.f43705i.getTabId(), i2, z0Var2);
            }
        }
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalTabView(Activity activity, int i2) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBottomLineWith = 0;
        this.f43705i = null;
        this.f43706j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds1);
        this.n = 0;
        this.o = true;
        this.p = c1.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        LinearLayout linearLayout = new LinearLayout(activity);
        this.f43701e = linearLayout;
        linearLayout.setOrientation(0);
        this.f43701e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i2);
        this.f43702f = new c.a.t0.d1.x2.f(activity, this.v, this.w);
        h(layoutParams);
    }
}
