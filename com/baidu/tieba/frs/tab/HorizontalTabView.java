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
import c.a.q0.r.t.c;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.p0;
import c.a.r0.d1.p2.f;
import c.a.r0.d1.z0;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements c.a.r0.d1.p2.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TEXT_LENGTH_ON_TAB = 12;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f42371e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.d1.p2.f f42372f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.r0.d1.p2.e> f42373g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.r0.d1.p2.e> f42374h;

    /* renamed from: i  reason: collision with root package name */
    public TabItemView f42375i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.d1.p2.c f42376j;
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

    /* loaded from: classes5.dex */
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

        @Override // c.a.r0.d1.p2.f.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f42375i != null && this.a.x != null && this.a.x != null) {
                    this.a.x.q(this.a.f42375i.getTabId(), i2, null);
                }
                if (this.a.f42376j != null) {
                    this.a.f42376j.onSelectedMenu(i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.r0.d1.p2.f.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.a.dealClick(tabItemView, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f42377e;

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
            this.f42377e = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42377e.r) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (this.f42377e.t != null) {
                            this.f42377e.t.a(this.f42377e.getOriginalDataById(1));
                        }
                        this.f42377e.showNewOpDialog();
                        return;
                    }
                    return;
                }
                boolean z = view instanceof TabItemView;
                if (z) {
                    this.f42377e.dealClick((TabItemView) view, false);
                }
                if (this.f42377e.f42376j != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view;
                        if (HorizontalTabView.isNewPageTab(tabItemView.getTabId())) {
                            this.f42377e.f42376j.onSelected(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.f42377e.f42375i != null) {
                        this.f42377e.f42376j.onSelected(this.f42377e.f42375i.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.InterfaceC0876c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f1 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f42378b;

        public d(HorizontalTabView horizontalTabView, f1 f1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, f1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42378b = horizontalTabView;
            this.a = f1Var;
        }

        @Override // c.a.q0.r.t.c.InterfaceC0876c
        public void a(c.a.q0.r.t.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) || this.a.f15469b.size() <= i2 || this.a.f15469b.get(i2) == null) {
                return;
            }
            cVar.e();
            HorizontalTabView horizontalTabView = this.f42378b;
            horizontalTabView.dealClick(horizontalTabView.getOriginalDataById(this.a.f15469b.get(i2).f15466b));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f42380f;

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
            this.f42380f = horizontalTabView;
            this.f42379e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42380f.scrollBy(0 - this.f42379e, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTabView f42381e;

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
            this.f42381e = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.f42381e;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(c.a.r0.d1.p2.e eVar);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(c.a.r0.d1.p2.e eVar);
    }

    /* loaded from: classes5.dex */
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
        this.f42375i = null;
        this.f42376j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.n = 0;
        this.o = true;
        this.p = R.color.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        this.q = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f42371e = linearLayout;
        linearLayout.setOrientation(0);
        this.f42371e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.f42372f = new c.a.r0.d1.p2.f(tbPageContext.getPageActivity(), this.v, this.w);
        h(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TabItemView tabItemView = this.f42375i;
            if (tabItemView == null || this.mBottomLineWith == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.mBottomLineWith) - this.f42375i.getDrawableWidth()) / 2;
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
            for (int i2 = 0; i2 < this.f42371e.getChildCount(); i2++) {
                View childAt = this.f42371e.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (isNewPageTab(tabItemView.getTabId())) {
                        SkinManager.setViewTextColor(childAt, (int) R.color.CAM_X0105);
                    } else {
                        tabItemView.changeSkinType();
                    }
                }
            }
            this.f42372f.c();
        }
    }

    public void dealClick(c.a.r0.d1.p2.e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(eVar);
        }
        if (eVar.f16047b == 49) {
            TiebaStatic.log("c11841");
        }
        if (isNewPageTab(eVar.f16047b)) {
            if (this.x == null || TextUtils.isEmpty(eVar.f16049d)) {
                return;
            }
            z0 z0Var = new z0();
            String str = eVar.f16049d;
            this.x.q(eVar.f16047b, -1, z0Var);
            return;
        }
        int i2 = eVar.f16047b;
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
            String str2 = eVar.f16049d;
            String str3 = eVar.a;
            this.x.q(eVar.f16047b, 0, z0Var3);
            if (z0Var3.f16774d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f42371e.getChildCount(); i3++) {
            View childAt = this.f42371e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(eVar.a);
                }
            }
        }
        if (!TextUtils.isEmpty(eVar.f16049d)) {
            z0Var2 = new z0();
            String str4 = eVar.f16049d;
            String str5 = eVar.a;
        }
        p0 p0Var2 = this.x;
        if (p0Var2 == null || !z) {
            return;
        }
        p0Var2.q(eVar.f16047b, 0, z0Var2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f42375i != null) {
                this.k.setColor(SkinManager.getColor(R.color.CAM_X0204));
                if (this.o) {
                    canvas.drawRect(this.f42371e.getLeft(), getMeasuredHeight() - this.m, this.f42371e.getRight() > getRight() ? this.f42371e.getRight() : getRight(), getMeasuredHeight(), this.k);
                }
                if (!this.r) {
                    int i2 = this.s;
                    if (i2 == 0) {
                        this.k.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0302));
                    } else {
                        this.k.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.f42375i.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.l, (this.f42375i.getRight() - getBottomLineMargin()) - this.f42375i.getDrawableWidth(), getMeasuredHeight(), this.k);
                }
            }
            if (this.r) {
                this.k.setAntiAlias(true);
                this.k.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
                int f2 = n.f(getContext(), R.dimen.ds96);
                TabItemView tabItemView = this.f42375i;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f42375i.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(n.f(getContext(), R.dimen.tbds44), n.f(getContext(), R.dimen.tbds98), f2, n.f(getContext(), R.dimen.tbds104)), n.f(getContext(), R.dimen.tbds6), n.f(getContext(), R.dimen.tbds6), this.k);
            }
        }
    }

    public final c.a.r0.d1.p2.e f(int i2) {
        InterceptResult invokeI;
        List<c.a.r0.d1.p2.e> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0 && (list = this.f42374h) != null && list.size() != 0) {
                for (c.a.r0.d1.p2.e eVar : this.f42374h) {
                    if (eVar != null && eVar.f16047b == i2) {
                        return eVar;
                    }
                }
            }
            return null;
        }
        return (c.a.r0.d1.p2.e) invokeI.objValue;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        f1 f1Var;
        List<e1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c.a.r0.d1.p2.e f2 = f(i2);
            return (f2 == null || (f1Var = f2.f16048c) == null || (list = f1Var.f15469b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public c.a.r0.d1.p2.e getOriginalDataById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f42374h)) {
                return null;
            }
            for (c.a.r0.d1.p2.e eVar : this.f42374h) {
                if (eVar != null && eVar.f16047b == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (c.a.r0.d1.p2.e) invokeI.objValue;
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
            addView(this.f42371e, layoutParams);
            setLayoutParams(layoutParams);
            setHorizontalScrollBarEnabled(false);
            SkinManager.setBackgroundColor(this, R.color.transparent);
            setDescendantFocusability(262144);
        }
    }

    public boolean haveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<c.a.r0.d1.p2.e> list = this.f42374h;
            return (list == null || list.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(List<c.a.r0.d1.p2.e> list) {
        InterceptResult invokeL;
        f1 f1Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            c.a.r0.d1.p2.e f2 = f(1);
            c.a.r0.d1.p2.e eVar = null;
            Iterator<c.a.r0.d1.p2.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.r0.d1.p2.e next = it.next();
                if (next != null && next.f16047b == 1) {
                    eVar = next;
                    break;
                }
            }
            if (f2 == null || eVar == null || (f2.f16048c == null && eVar.f16048c == null)) {
                return false;
            }
            if ((f2.f16048c != null || eVar.f16048c == null) && (eVar.f16048c != null || f2.f16048c == null)) {
                f1 f1Var2 = f2.f16048c;
                if (f1Var2 == null || (f1Var = eVar.f16048c) == null || (f1Var2.f15469b == null && f1Var.f15469b == null)) {
                    return false;
                }
                if ((f2.f16048c.f15469b != null || eVar.f16048c.f15469b == null) && ((eVar.f16048c.f15469b != null || f2.f16048c.f15469b == null) && (size = f2.f16048c.f15469b.size()) == eVar.f16048c.f15469b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        e1 e1Var = eVar.f16048c.f15469b.get(i2);
                        e1 e1Var2 = f2.f16048c.f15469b.get(i2);
                        if (e1Var.f15466b != e1Var2.f15466b || !e1Var.a.equals(e1Var2.a)) {
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

    public final void j(List<c.a.r0.d1.p2.e> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.n > 0 && list.size() == this.n) {
                layoutParams = new LinearLayout.LayoutParams(n.k(getContext()) / this.n, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.f42373g == null || i(list)) {
                    this.f42373g = list;
                    this.f42371e.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        c.a.r0.d1.p2.e eVar = list.get(i4);
                        if (eVar != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), eVar, i3, this.r);
                            int i5 = this.s;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.y);
                            if (isNewPageTab(eVar.f16047b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.f42371e.addView(tabItemView, layoutParams);
                            if (eVar.f16047b == i2) {
                                this.f42375i = tabItemView;
                                tabItemView.setState(TabItemView.STATE_CHECKED);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.f42373g = null;
            c.a.r0.d1.p2.e eVar2 = new c.a.r0.d1.p2.e();
            eVar2.f16047b = 1;
            eVar2.a = getContext().getResources().getString(R.string.chosen_pb_title);
            this.f42371e.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), eVar2, i3, this.r);
            int i6 = this.s;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.y);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.f42371e.addView(tabItemView2, layoutParams);
            this.f42375i = tabItemView2;
            tabItemView2.setState(TabItemView.STATE_CHECKED);
        }
    }

    @Override // c.a.r0.d1.p2.c
    public void onSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            dealClick(getOriginalDataById(i2));
        }
    }

    @Override // c.a.r0.d1.p2.c
    public void onSelectedMenu(int i2) {
        TabItemView tabItemView;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tabItemView = this.f42375i) == null || (p0Var = this.x) == null) {
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

    public void setData(List<c.a.r0.d1.p2.e> list, int i2, int i3) {
        c.a.r0.d1.p2.e eVar;
        List<e1> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, list, i2, i3) == null) {
            if (this.r) {
                ArrayList arrayList = new ArrayList();
                this.f42374h = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (eVar = list.get(0)) != null && eVar.f16047b == 1) {
                    f1 f1Var = eVar.f16048c;
                    if (f1Var != null && (list2 = f1Var.f15469b) != null) {
                        list2.clear();
                    } else {
                        f1Var = new f1();
                        f1Var.f15469b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        e1 e1Var = new e1();
                        e1Var.f15466b = 1;
                        e1Var.a = getContext().getString(R.string.chosen_pb_title);
                        f1Var.f15469b.add(e1Var);
                        for (c.a.r0.d1.p2.e eVar2 : list) {
                            if (eVar2 != null && eVar2.f16047b != 1) {
                                e1 e1Var2 = new e1();
                                e1Var2.f15466b = eVar2.f16047b;
                                e1Var2.a = eVar2.a;
                                f1Var.f15469b.add(e1Var2);
                            }
                        }
                        eVar.f16048c = f1Var;
                    }
                    list.clear();
                    list.add(eVar);
                }
            } else {
                this.f42374h = list;
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

    public void setFakeTab(c.a.r0.d1.p2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f42376j = cVar;
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
        f1 f1Var;
        List<e1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.q == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<c.a.r0.d1.p2.e> list2 = this.f42373g;
        if (list2 == null || list2.size() <= 0 || this.f42373g.get(0) == null || (f1Var = this.f42373g.get(0).f16048c) == null || (list = f1Var.f15469b) == null) {
            return;
        }
        for (e1 e1Var : list) {
            if (e1Var != null) {
                arrayList.add(e1Var.a);
            }
        }
        c.a.q0.r.t.c cVar = new c.a.q0.r.t.c(this.q.getPageActivity());
        cVar.i(arrayList, new d(this, f1Var));
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
        this.f42375i = null;
        this.f42376j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.n = 0;
        this.o = true;
        this.p = R.color.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f42371e = linearLayout;
        linearLayout.setOrientation(0);
        this.f42371e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.f42372f = new c.a.r0.d1.p2.f(context, this.v, this.w);
        h(layoutParams);
    }

    public void dealClick(TabItemView tabItemView, boolean z) {
        p0 p0Var;
        List<e1> list;
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
        this.f42375i = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = n.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.f42371e.getChildCount(); i3++) {
            View childAt = this.f42371e.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f42375i.getTabId() && !isNewPageTab(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.STATE_UNCHECKED);
                }
            }
        }
        if (this.f42375i.getState() != TabItemView.STATE_UNCHECKED && this.f42375i.getState() != TabItemView.STATE_EXPANDED) {
            if (g(this.f42375i.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.f42375i.getTabId())) {
                    return;
                }
                this.f42375i.setState(TabItemView.STATE_EXPANDED);
                TabItemView tabItemView3 = this.f42375i;
                this.f42372f.g((Activity) getContext(), this, tabItemView3, f(tabItemView3.getTabId()).f16048c);
            }
        } else {
            this.f42372f.d();
            boolean z2 = this.f42375i.getState() == TabItemView.STATE_UNCHECKED;
            this.f42375i.setState(TabItemView.STATE_CHECKED);
            c.a.r0.d1.p2.e f2 = f(this.f42375i.getTabId());
            if (f2 == null) {
                return;
            }
            if (!TextUtils.isEmpty(f2.f16049d)) {
                z0Var2 = new z0();
                String str = f2.f16049d;
                String str2 = f2.a;
            }
            f1 f1Var = f2.f16048c;
            if (f1Var != null && (list = f1Var.f15469b) != null && list.size() > 0) {
                for (e1 e1Var : f2.f16048c.f15469b) {
                    if (e1Var != null && e1Var.f15467c) {
                        i2 = e1Var.f15466b;
                    }
                }
            }
            if (z2 && (p0Var = this.x) != null) {
                p0Var.q(this.f42375i.getTabId(), i2, z0Var2);
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
        this.f42375i = null;
        this.f42376j = null;
        this.k = new Paint();
        this.l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.n = 0;
        this.o = true;
        this.p = R.color.transparent;
        this.s = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.y = new c(this);
        LinearLayout linearLayout = new LinearLayout(activity);
        this.f42371e = linearLayout;
        linearLayout.setOrientation(0);
        this.f42371e.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i2);
        this.f42372f = new c.a.r0.d1.p2.f(activity, this.v, this.w);
        h(layoutParams);
    }
}
