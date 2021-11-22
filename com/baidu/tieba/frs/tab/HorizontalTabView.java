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
import b.a.e.f.p.l;
import b.a.q0.s.s.b;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.i1;
import b.a.r0.x0.o1;
import b.a.r0.x0.p0;
import b.a.r0.x0.p1;
import b.a.r0.x0.w2.f;
import b.a.r0.x0.z0;
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
/* loaded from: classes9.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements b.a.r0.x0.w2.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TEXT_LENGTH_ON_TAB = 12;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f49831e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.r0.x0.w2.f f49832f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.a.r0.x0.w2.e> f49833g;

    /* renamed from: h  reason: collision with root package name */
    public List<b.a.r0.x0.w2.e> f49834h;

    /* renamed from: i  reason: collision with root package name */
    public TabItemView f49835i;
    public b.a.r0.x0.w2.c j;
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

    /* loaded from: classes9.dex */
    public class a implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49836a;

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
            this.f49836a = horizontalTabView;
        }

        @Override // b.a.r0.x0.w2.f.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f49836a.f49835i != null && this.f49836a.x != null && this.f49836a.x != null) {
                    this.f49836a.x.q(this.f49836a.f49835i.getTabId(), i2, null);
                }
                if (this.f49836a.j != null) {
                    this.f49836a.j.onSelectedMenu(i2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49837a;

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
            this.f49837a = horizontalTabView;
        }

        @Override // b.a.r0.x0.w2.f.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.f49837a.dealClick(tabItemView, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49838e;

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
            this.f49838e = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49838e.r) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (this.f49838e.t != null) {
                            this.f49838e.t.a(this.f49838e.getOriginalDataById(1));
                        }
                        this.f49838e.showNewOpDialog();
                        return;
                    }
                    return;
                }
                boolean z = view instanceof TabItemView;
                if (z) {
                    this.f49838e.dealClick((TabItemView) view, false);
                }
                if (this.f49838e.j != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view;
                        if (HorizontalTabView.isNewPageTab(tabItemView.getTabId())) {
                            this.f49838e.j.onSelected(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.f49838e.f49835i != null) {
                        this.f49838e.j.onSelected(this.f49838e.f49835i.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p1 f49839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49840b;

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
            this.f49840b = horizontalTabView;
            this.f49839a = p1Var;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || this.f49839a.f27622b.size() <= i2 || this.f49839a.f27622b.get(i2) == null) {
                return;
            }
            bVar.e();
            HorizontalTabView horizontalTabView = this.f49840b;
            horizontalTabView.dealClick(horizontalTabView.getOriginalDataById(this.f49839a.f27622b.get(i2).f27597b));
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49842f;

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
            this.f49842f = horizontalTabView;
            this.f49841e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49842f.scrollBy(0 - this.f49841e, 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f49843e;

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
            this.f49843e = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.f49843e;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(d1.ds160), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(b.a.r0.x0.w2.e eVar);
    }

    /* loaded from: classes9.dex */
    public interface h {
        void a(b.a.r0.x0.w2.e eVar);
    }

    /* loaded from: classes9.dex */
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
        this.f49835i = null;
        this.j = null;
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
        this.f49831e = linearLayout;
        linearLayout.setOrientation(0);
        this.f49831e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d1.ds88));
        this.f49832f = new b.a.r0.x0.w2.f(tbPageContext.getPageActivity(), this.v, this.w);
        h(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TabItemView tabItemView = this.f49835i;
            if (tabItemView == null || this.mBottomLineWith == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.mBottomLineWith) - this.f49835i.getDrawableWidth()) / 2;
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
            for (int i2 = 0; i2 < this.f49831e.getChildCount(); i2++) {
                View childAt = this.f49831e.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (isNewPageTab(tabItemView.getTabId())) {
                        SkinManager.setViewTextColor(childAt, c1.CAM_X0105);
                    } else {
                        tabItemView.changeSkinType();
                    }
                }
            }
            this.f49832f.c();
        }
    }

    public void dealClick(b.a.r0.x0.w2.e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(eVar);
        }
        if (eVar.f28052b == 49) {
            TiebaStatic.log("c11841");
        }
        if (isNewPageTab(eVar.f28052b)) {
            if (this.x == null || TextUtils.isEmpty(eVar.f28054d)) {
                return;
            }
            z0 z0Var = new z0();
            String str = eVar.f28054d;
            this.x.q(eVar.f28052b, -1, z0Var);
            return;
        }
        int i2 = eVar.f28052b;
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
            String str2 = eVar.f28054d;
            String str3 = eVar.f28051a;
            this.x.q(eVar.f28052b, 0, z0Var3);
            if (z0Var3.f28385d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f49831e.getChildCount(); i3++) {
            View childAt = this.f49831e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(eVar.f28051a);
                }
            }
        }
        if (!TextUtils.isEmpty(eVar.f28054d)) {
            z0Var2 = new z0();
            String str4 = eVar.f28054d;
            String str5 = eVar.f28051a;
        }
        p0 p0Var2 = this.x;
        if (p0Var2 == null || !z) {
            return;
        }
        p0Var2.q(eVar.f28052b, 0, z0Var2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f49835i != null) {
                this.k.setColor(SkinManager.getColor(c1.CAM_X0204));
                if (this.o) {
                    canvas.drawRect(this.f49831e.getLeft(), getMeasuredHeight() - this.m, this.f49831e.getRight() > getRight() ? this.f49831e.getRight() : getRight(), getMeasuredHeight(), this.k);
                }
                if (!this.r) {
                    int i2 = this.s;
                    if (i2 == 0) {
                        this.k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0302));
                    } else {
                        this.k.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.f49835i.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.l, (this.f49835i.getRight() - getBottomLineMargin()) - this.f49835i.getDrawableWidth(), getMeasuredHeight(), this.k);
                }
            }
            if (this.r) {
                this.k.setAntiAlias(true);
                this.k.setColor(SkinManager.getSkinColor(null, c1.CAM_X0105));
                int g2 = l.g(getContext(), d1.ds96);
                TabItemView tabItemView = this.f49835i;
                if (tabItemView != null) {
                    g2 = tabItemView.getRight() - this.f49835i.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(l.g(getContext(), d1.tbds44), l.g(getContext(), d1.tbds98), g2, l.g(getContext(), d1.tbds104)), l.g(getContext(), d1.tbds6), l.g(getContext(), d1.tbds6), this.k);
            }
        }
    }

    public final b.a.r0.x0.w2.e f(int i2) {
        InterceptResult invokeI;
        List<b.a.r0.x0.w2.e> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0 && (list = this.f49834h) != null && list.size() != 0) {
                for (b.a.r0.x0.w2.e eVar : this.f49834h) {
                    if (eVar != null && eVar.f28052b == i2) {
                        return eVar;
                    }
                }
            }
            return null;
        }
        return (b.a.r0.x0.w2.e) invokeI.objValue;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        p1 p1Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            b.a.r0.x0.w2.e f2 = f(i2);
            return (f2 == null || (p1Var = f2.f28053c) == null || (list = p1Var.f27622b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public b.a.r0.x0.w2.e getOriginalDataById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f49834h)) {
                return null;
            }
            for (b.a.r0.x0.w2.e eVar : this.f49834h) {
                if (eVar != null && eVar.f28052b == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (b.a.r0.x0.w2.e) invokeI.objValue;
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
            addView(this.f49831e, layoutParams);
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
            List<b.a.r0.x0.w2.e> list = this.f49834h;
            return (list == null || list.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(List<b.a.r0.x0.w2.e> list) {
        InterceptResult invokeL;
        p1 p1Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            b.a.r0.x0.w2.e f2 = f(1);
            b.a.r0.x0.w2.e eVar = null;
            Iterator<b.a.r0.x0.w2.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b.a.r0.x0.w2.e next = it.next();
                if (next != null && next.f28052b == 1) {
                    eVar = next;
                    break;
                }
            }
            if (f2 == null || eVar == null || (f2.f28053c == null && eVar.f28053c == null)) {
                return false;
            }
            if ((f2.f28053c != null || eVar.f28053c == null) && (eVar.f28053c != null || f2.f28053c == null)) {
                p1 p1Var2 = f2.f28053c;
                if (p1Var2 == null || (p1Var = eVar.f28053c) == null || (p1Var2.f27622b == null && p1Var.f27622b == null)) {
                    return false;
                }
                if ((f2.f28053c.f27622b != null || eVar.f28053c.f27622b == null) && ((eVar.f28053c.f27622b != null || f2.f28053c.f27622b == null) && (size = f2.f28053c.f27622b.size()) == eVar.f28053c.f27622b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        o1 o1Var = eVar.f28053c.f27622b.get(i2);
                        o1 o1Var2 = f2.f28053c.f27622b.get(i2);
                        if (o1Var.f27597b != o1Var2.f27597b || !o1Var.f27596a.equals(o1Var2.f27596a)) {
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

    public final void j(List<b.a.r0.x0.w2.e> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.n > 0 && list.size() == this.n) {
                layoutParams = new LinearLayout.LayoutParams(l.k(getContext()) / this.n, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds15);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.f49833g == null || i(list)) {
                    this.f49833g = list;
                    this.f49831e.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        b.a.r0.x0.w2.e eVar = list.get(i4);
                        if (eVar != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), eVar, i3, this.r);
                            int i5 = this.s;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.y);
                            if (isNewPageTab(eVar.f28052b)) {
                                SkinManager.setViewTextColor(tabItemView, c1.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.tbds44);
                            }
                            this.f49831e.addView(tabItemView, layoutParams);
                            if (eVar.f28052b == i2) {
                                this.f49835i = tabItemView;
                                tabItemView.setState(TabItemView.STATE_CHECKED);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.f49833g = null;
            b.a.r0.x0.w2.e eVar2 = new b.a.r0.x0.w2.e();
            eVar2.f28052b = 1;
            eVar2.f28051a = getContext().getResources().getString(i1.chosen_pb_title);
            this.f49831e.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), eVar2, i3, this.r);
            int i6 = this.s;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.y);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d1.ds32);
            this.f49831e.addView(tabItemView2, layoutParams);
            this.f49835i = tabItemView2;
            tabItemView2.setState(TabItemView.STATE_CHECKED);
        }
    }

    @Override // b.a.r0.x0.w2.c
    public void onSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            dealClick(getOriginalDataById(i2));
        }
    }

    @Override // b.a.r0.x0.w2.c
    public void onSelectedMenu(int i2) {
        TabItemView tabItemView;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tabItemView = this.f49835i) == null || (p0Var = this.x) == null) {
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

    public void setData(List<b.a.r0.x0.w2.e> list, int i2, int i3) {
        b.a.r0.x0.w2.e eVar;
        List<o1> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, list, i2, i3) == null) {
            if (this.r) {
                ArrayList arrayList = new ArrayList();
                this.f49834h = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (eVar = list.get(0)) != null && eVar.f28052b == 1) {
                    p1 p1Var = eVar.f28053c;
                    if (p1Var != null && (list2 = p1Var.f27622b) != null) {
                        list2.clear();
                    } else {
                        p1Var = new p1();
                        p1Var.f27622b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        o1 o1Var = new o1();
                        o1Var.f27597b = 1;
                        o1Var.f27596a = getContext().getString(i1.chosen_pb_title);
                        p1Var.f27622b.add(o1Var);
                        for (b.a.r0.x0.w2.e eVar2 : list) {
                            if (eVar2 != null && eVar2.f28052b != 1) {
                                o1 o1Var2 = new o1();
                                o1Var2.f27597b = eVar2.f28052b;
                                o1Var2.f27596a = eVar2.f28051a;
                                p1Var.f27622b.add(o1Var2);
                            }
                        }
                        eVar.f28053c = p1Var;
                    }
                    list.clear();
                    list.add(eVar);
                }
            } else {
                this.f49834h = list;
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

    public void setFakeTab(b.a.r0.x0.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.j = cVar;
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
        List<b.a.r0.x0.w2.e> list2 = this.f49833g;
        if (list2 == null || list2.size() <= 0 || this.f49833g.get(0) == null || (p1Var = this.f49833g.get(0).f28053c) == null || (list = p1Var.f27622b) == null) {
            return;
        }
        for (o1 o1Var : list) {
            if (o1Var != null) {
                arrayList.add(o1Var.f27596a);
            }
        }
        b.a.q0.s.s.b bVar = new b.a.q0.s.s.b(this.q.getPageActivity());
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
        this.f49835i = null;
        this.j = null;
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
        this.f49831e = linearLayout;
        linearLayout.setOrientation(0);
        this.f49831e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d1.ds88));
        this.f49832f = new b.a.r0.x0.w2.f(context, this.v, this.w);
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
        this.f49835i = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = l.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d1.ds160);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.f49831e.getChildCount(); i3++) {
            View childAt = this.f49831e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f49835i.getTabId() && !isNewPageTab(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.STATE_UNCHECKED);
                }
            }
        }
        if (this.f49835i.getState() != TabItemView.STATE_UNCHECKED && this.f49835i.getState() != TabItemView.STATE_EXPANDED) {
            if (g(this.f49835i.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.f49835i.getTabId())) {
                    return;
                }
                this.f49835i.setState(TabItemView.STATE_EXPANDED);
                TabItemView tabItemView3 = this.f49835i;
                this.f49832f.g((Activity) getContext(), this, tabItemView3, f(tabItemView3.getTabId()).f28053c);
            }
        } else {
            this.f49832f.d();
            boolean z2 = this.f49835i.getState() == TabItemView.STATE_UNCHECKED;
            this.f49835i.setState(TabItemView.STATE_CHECKED);
            b.a.r0.x0.w2.e f2 = f(this.f49835i.getTabId());
            if (f2 == null) {
                return;
            }
            if (!TextUtils.isEmpty(f2.f28054d)) {
                z0Var2 = new z0();
                String str = f2.f28054d;
                String str2 = f2.f28051a;
            }
            p1 p1Var = f2.f28053c;
            if (p1Var != null && (list = p1Var.f27622b) != null && list.size() > 0) {
                for (o1 o1Var : f2.f28053c.f27622b) {
                    if (o1Var != null && o1Var.f27598c) {
                        i2 = o1Var.f27597b;
                    }
                }
            }
            if (z2 && (p0Var = this.x) != null) {
                p0Var.q(this.f49835i.getTabId(), i2, z0Var2);
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
        this.f49835i = null;
        this.j = null;
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
        this.f49831e = linearLayout;
        linearLayout.setOrientation(0);
        this.f49831e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i2);
        this.f49832f = new b.a.r0.x0.w2.f(activity, this.v, this.w);
        h(layoutParams);
    }
}
