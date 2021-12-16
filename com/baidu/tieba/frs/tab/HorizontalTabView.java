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
import c.a.d.f.p.m;
import c.a.r0.s.t.b;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.i1;
import c.a.s0.d1.o1;
import c.a.s0.d1.p0;
import c.a.s0.d1.p1;
import c.a.s0.d1.w2.f;
import c.a.s0.d1.z0;
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
public class HorizontalTabView extends MyHorizontalScrollView implements c.a.s0.d1.w2.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TEXT_LENGTH_ON_TAB = 12;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f45161e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.s0.d1.w2.f f45162f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.s0.d1.w2.e> f45163g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.s0.d1.w2.e> f45164h;

    /* renamed from: i  reason: collision with root package name */
    public TabItemView f45165i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.d1.w2.c f45166j;

    /* renamed from: k  reason: collision with root package name */
    public final Paint f45167k;
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

        @Override // c.a.s0.d1.w2.f.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f45165i != null && this.a.x != null && this.a.x != null) {
                    this.a.x.q(this.a.f45165i.getTabId(), i2, null);
                }
                if (this.a.f45166j != null) {
                    this.a.f45166j.onSelectedMenu(i2);
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

        @Override // c.a.s0.d1.w2.f.d
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
        public final /* synthetic */ HorizontalTabView f45168e;

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
            this.f45168e = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45168e.r) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (this.f45168e.t != null) {
                            this.f45168e.t.a(this.f45168e.getOriginalDataById(1));
                        }
                        this.f45168e.showNewOpDialog();
                        return;
                    }
                    return;
                }
                boolean z = view instanceof TabItemView;
                if (z) {
                    this.f45168e.dealClick((TabItemView) view, false);
                }
                if (this.f45168e.f45166j != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view;
                        if (HorizontalTabView.isNewPageTab(tabItemView.getTabId())) {
                            this.f45168e.f45166j.onSelected(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.f45168e.f45165i != null) {
                        this.f45168e.f45166j.onSelected(this.f45168e.f45165i.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p1 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f45169b;

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
            this.f45169b = horizontalTabView;
            this.a = p1Var;
        }

        @Override // c.a.r0.s.t.b.c
        public void a(c.a.r0.s.t.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || this.a.f16168b.size() <= i2 || this.a.f16168b.get(i2) == null) {
                return;
            }
            bVar.e();
            HorizontalTabView horizontalTabView = this.f45169b;
            horizontalTabView.dealClick(horizontalTabView.getOriginalDataById(this.a.f16168b.get(i2).f16147b));
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f45171f;

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
            this.f45171f = horizontalTabView;
            this.f45170e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45171f.scrollBy(0 - this.f45170e, 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f45172e;

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
            this.f45172e = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.f45172e;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(d1.ds160), 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface g {
        void a(c.a.s0.d1.w2.e eVar);
    }

    /* loaded from: classes12.dex */
    public interface h {
        void a(c.a.s0.d1.w2.e eVar);
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
        this.f45165i = null;
        this.f45166j = null;
        this.f45167k = new Paint();
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
        this.f45161e = linearLayout;
        linearLayout.setOrientation(0);
        this.f45161e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d1.ds88));
        this.f45162f = new c.a.s0.d1.w2.f(tbPageContext.getPageActivity(), this.v, this.w);
        h(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TabItemView tabItemView = this.f45165i;
            if (tabItemView == null || this.mBottomLineWith == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.mBottomLineWith) - this.f45165i.getDrawableWidth()) / 2;
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
            for (int i2 = 0; i2 < this.f45161e.getChildCount(); i2++) {
                View childAt = this.f45161e.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (isNewPageTab(tabItemView.getTabId())) {
                        SkinManager.setViewTextColor(childAt, c1.CAM_X0105);
                    } else {
                        tabItemView.changeSkinType();
                    }
                }
            }
            this.f45162f.c();
        }
    }

    public void dealClick(c.a.s0.d1.w2.e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(eVar);
        }
        if (eVar.f16551b == 49) {
            TiebaStatic.log("c11841");
        }
        if (isNewPageTab(eVar.f16551b)) {
            if (this.x == null || TextUtils.isEmpty(eVar.f16553d)) {
                return;
            }
            z0 z0Var = new z0();
            String str = eVar.f16553d;
            this.x.q(eVar.f16551b, -1, z0Var);
            return;
        }
        int i2 = eVar.f16551b;
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
            String str2 = eVar.f16553d;
            String str3 = eVar.a;
            this.x.q(eVar.f16551b, 0, z0Var3);
            if (z0Var3.f16831d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f45161e.getChildCount(); i3++) {
            View childAt = this.f45161e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(eVar.a);
                }
            }
        }
        if (!TextUtils.isEmpty(eVar.f16553d)) {
            z0Var2 = new z0();
            String str4 = eVar.f16553d;
            String str5 = eVar.a;
        }
        p0 p0Var2 = this.x;
        if (p0Var2 == null || !z) {
            return;
        }
        p0Var2.q(eVar.f16551b, 0, z0Var2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f45165i != null) {
                this.f45167k.setColor(SkinManager.getColor(c1.CAM_X0204));
                if (this.o) {
                    canvas.drawRect(this.f45161e.getLeft(), getMeasuredHeight() - this.m, this.f45161e.getRight() > getRight() ? this.f45161e.getRight() : getRight(), getMeasuredHeight(), this.f45167k);
                }
                if (!this.r) {
                    int i2 = this.s;
                    if (i2 == 0) {
                        this.f45167k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0302));
                    } else {
                        this.f45167k.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.f45165i.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.l, (this.f45165i.getRight() - getBottomLineMargin()) - this.f45165i.getDrawableWidth(), getMeasuredHeight(), this.f45167k);
                }
            }
            if (this.r) {
                this.f45167k.setAntiAlias(true);
                this.f45167k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0105));
                int f2 = m.f(getContext(), d1.ds96);
                TabItemView tabItemView = this.f45165i;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f45165i.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(m.f(getContext(), d1.tbds44), m.f(getContext(), d1.tbds98), f2, m.f(getContext(), d1.tbds104)), m.f(getContext(), d1.tbds6), m.f(getContext(), d1.tbds6), this.f45167k);
            }
        }
    }

    public final c.a.s0.d1.w2.e f(int i2) {
        InterceptResult invokeI;
        List<c.a.s0.d1.w2.e> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0 && (list = this.f45164h) != null && list.size() != 0) {
                for (c.a.s0.d1.w2.e eVar : this.f45164h) {
                    if (eVar != null && eVar.f16551b == i2) {
                        return eVar;
                    }
                }
            }
            return null;
        }
        return (c.a.s0.d1.w2.e) invokeI.objValue;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        p1 p1Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c.a.s0.d1.w2.e f2 = f(i2);
            return (f2 == null || (p1Var = f2.f16552c) == null || (list = p1Var.f16168b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public c.a.s0.d1.w2.e getOriginalDataById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f45164h)) {
                return null;
            }
            for (c.a.s0.d1.w2.e eVar : this.f45164h) {
                if (eVar != null && eVar.f16551b == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (c.a.s0.d1.w2.e) invokeI.objValue;
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
            addView(this.f45161e, layoutParams);
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
            List<c.a.s0.d1.w2.e> list = this.f45164h;
            return (list == null || list.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(List<c.a.s0.d1.w2.e> list) {
        InterceptResult invokeL;
        p1 p1Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            c.a.s0.d1.w2.e f2 = f(1);
            c.a.s0.d1.w2.e eVar = null;
            Iterator<c.a.s0.d1.w2.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.s0.d1.w2.e next = it.next();
                if (next != null && next.f16551b == 1) {
                    eVar = next;
                    break;
                }
            }
            if (f2 == null || eVar == null || (f2.f16552c == null && eVar.f16552c == null)) {
                return false;
            }
            if ((f2.f16552c != null || eVar.f16552c == null) && (eVar.f16552c != null || f2.f16552c == null)) {
                p1 p1Var2 = f2.f16552c;
                if (p1Var2 == null || (p1Var = eVar.f16552c) == null || (p1Var2.f16168b == null && p1Var.f16168b == null)) {
                    return false;
                }
                if ((f2.f16552c.f16168b != null || eVar.f16552c.f16168b == null) && ((eVar.f16552c.f16168b != null || f2.f16552c.f16168b == null) && (size = f2.f16552c.f16168b.size()) == eVar.f16552c.f16168b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        o1 o1Var = eVar.f16552c.f16168b.get(i2);
                        o1 o1Var2 = f2.f16552c.f16168b.get(i2);
                        if (o1Var.f16147b != o1Var2.f16147b || !o1Var.a.equals(o1Var2.a)) {
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

    public final void j(List<c.a.s0.d1.w2.e> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.n > 0 && list.size() == this.n) {
                layoutParams = new LinearLayout.LayoutParams(m.k(getContext()) / this.n, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds15);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.f45163g == null || i(list)) {
                    this.f45163g = list;
                    this.f45161e.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        c.a.s0.d1.w2.e eVar = list.get(i4);
                        if (eVar != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), eVar, i3, this.r);
                            int i5 = this.s;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.y);
                            if (isNewPageTab(eVar.f16551b)) {
                                SkinManager.setViewTextColor(tabItemView, c1.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.tbds44);
                            }
                            this.f45161e.addView(tabItemView, layoutParams);
                            if (eVar.f16551b == i2) {
                                this.f45165i = tabItemView;
                                tabItemView.setState(TabItemView.STATE_CHECKED);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.f45163g = null;
            c.a.s0.d1.w2.e eVar2 = new c.a.s0.d1.w2.e();
            eVar2.f16551b = 1;
            eVar2.a = getContext().getResources().getString(i1.chosen_pb_title);
            this.f45161e.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), eVar2, i3, this.r);
            int i6 = this.s;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.y);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.ds32);
            this.f45161e.addView(tabItemView2, layoutParams);
            this.f45165i = tabItemView2;
            tabItemView2.setState(TabItemView.STATE_CHECKED);
        }
    }

    @Override // c.a.s0.d1.w2.c
    public void onSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            dealClick(getOriginalDataById(i2));
        }
    }

    @Override // c.a.s0.d1.w2.c
    public void onSelectedMenu(int i2) {
        TabItemView tabItemView;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tabItemView = this.f45165i) == null || (p0Var = this.x) == null) {
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

    public void setData(List<c.a.s0.d1.w2.e> list, int i2, int i3) {
        c.a.s0.d1.w2.e eVar;
        List<o1> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, list, i2, i3) == null) {
            if (this.r) {
                ArrayList arrayList = new ArrayList();
                this.f45164h = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (eVar = list.get(0)) != null && eVar.f16551b == 1) {
                    p1 p1Var = eVar.f16552c;
                    if (p1Var != null && (list2 = p1Var.f16168b) != null) {
                        list2.clear();
                    } else {
                        p1Var = new p1();
                        p1Var.f16168b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        o1 o1Var = new o1();
                        o1Var.f16147b = 1;
                        o1Var.a = getContext().getString(i1.chosen_pb_title);
                        p1Var.f16168b.add(o1Var);
                        for (c.a.s0.d1.w2.e eVar2 : list) {
                            if (eVar2 != null && eVar2.f16551b != 1) {
                                o1 o1Var2 = new o1();
                                o1Var2.f16147b = eVar2.f16551b;
                                o1Var2.a = eVar2.a;
                                p1Var.f16168b.add(o1Var2);
                            }
                        }
                        eVar.f16552c = p1Var;
                    }
                    list.clear();
                    list.add(eVar);
                }
            } else {
                this.f45164h = list;
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

    public void setFakeTab(c.a.s0.d1.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f45166j = cVar;
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
        List<c.a.s0.d1.w2.e> list2 = this.f45163g;
        if (list2 == null || list2.size() <= 0 || this.f45163g.get(0) == null || (p1Var = this.f45163g.get(0).f16552c) == null || (list = p1Var.f16168b) == null) {
            return;
        }
        for (o1 o1Var : list) {
            if (o1Var != null) {
                arrayList.add(o1Var.a);
            }
        }
        c.a.r0.s.t.b bVar = new c.a.r0.s.t.b(this.q.getPageActivity());
        bVar.i(arrayList, new d(this, p1Var));
        bVar.c(this.q);
        bVar.m();
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
        this.f45165i = null;
        this.f45166j = null;
        this.f45167k = new Paint();
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
        this.f45161e = linearLayout;
        linearLayout.setOrientation(0);
        this.f45161e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d1.ds88));
        this.f45162f = new c.a.s0.d1.w2.f(context, this.v, this.w);
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
        this.f45165i = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k2 = m.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds160);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k2 < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.f45161e.getChildCount(); i3++) {
            View childAt = this.f45161e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f45165i.getTabId() && !isNewPageTab(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.STATE_UNCHECKED);
                }
            }
        }
        if (this.f45165i.getState() != TabItemView.STATE_UNCHECKED && this.f45165i.getState() != TabItemView.STATE_EXPANDED) {
            if (g(this.f45165i.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.f45165i.getTabId())) {
                    return;
                }
                this.f45165i.setState(TabItemView.STATE_EXPANDED);
                TabItemView tabItemView3 = this.f45165i;
                this.f45162f.g((Activity) getContext(), this, tabItemView3, f(tabItemView3.getTabId()).f16552c);
            }
        } else {
            this.f45162f.d();
            boolean z2 = this.f45165i.getState() == TabItemView.STATE_UNCHECKED;
            this.f45165i.setState(TabItemView.STATE_CHECKED);
            c.a.s0.d1.w2.e f2 = f(this.f45165i.getTabId());
            if (f2 == null) {
                return;
            }
            if (!TextUtils.isEmpty(f2.f16553d)) {
                z0Var2 = new z0();
                String str = f2.f16553d;
                String str2 = f2.a;
            }
            p1 p1Var = f2.f16552c;
            if (p1Var != null && (list = p1Var.f16168b) != null && list.size() > 0) {
                for (o1 o1Var : f2.f16552c.f16168b) {
                    if (o1Var != null && o1Var.f16148c) {
                        i2 = o1Var.f16147b;
                    }
                }
            }
            if (z2 && (p0Var = this.x) != null) {
                p0Var.q(this.f45165i.getTabId(), i2, z0Var2);
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
        this.f45165i = null;
        this.f45166j = null;
        this.f45167k = new Paint();
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
        this.f45161e = linearLayout;
        linearLayout.setOrientation(0);
        this.f45161e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i2);
        this.f45162f = new c.a.s0.d1.w2.f(activity, this.v, this.w);
        h(layoutParams);
    }
}
