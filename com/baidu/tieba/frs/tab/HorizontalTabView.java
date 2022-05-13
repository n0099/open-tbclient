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
import com.repackage.ee6;
import com.repackage.je6;
import com.repackage.ke6;
import com.repackage.mi;
import com.repackage.mo6;
import com.repackage.oo6;
import com.repackage.po6;
import com.repackage.pr4;
import com.repackage.ud6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements mo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final LinearLayout b;
    public final po6 c;
    public List<oo6> d;
    public List<oo6> e;
    public TabItemView f;
    public mo6 g;
    public final Paint h;
    public final int i;
    public final int j;
    public int k;
    public boolean l;
    public TbPageContext m;
    public boolean n;
    public int o;
    public g p;
    public h q;
    public po6.e r;
    public po6.d s;
    public ud6 t;
    public View.OnClickListener u;
    public i v;

    /* loaded from: classes3.dex */
    public class a implements po6.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalTabView;
        }

        @Override // com.repackage.po6.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f != null && this.a.t != null && this.a.t != null) {
                    this.a.t.s(this.a.f.getTabId(), i, null);
                }
                if (this.a.g != null) {
                    this.a.g.b(i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements po6.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalTabView;
        }

        @Override // com.repackage.po6.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.a.i(tabItemView, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalTabView a;

        public c(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n) {
                    if ((view2 instanceof TabItemView) && ((TabItemView) view2).getTabId() == 1) {
                        if (this.a.p != null) {
                            this.a.p.a(this.a.k(1));
                        }
                        this.a.q();
                        return;
                    }
                    return;
                }
                boolean z = view2 instanceof TabItemView;
                if (z) {
                    this.a.i((TabItemView) view2, false);
                }
                if (this.a.g != null) {
                    if (z) {
                        TabItemView tabItemView = (TabItemView) view2;
                        if (HorizontalTabView.o(tabItemView.getTabId())) {
                            this.a.g.a(tabItemView.getTabId());
                            return;
                        }
                    }
                    if (this.a.f != null) {
                        this.a.g.a(this.a.f.getTabId());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements pr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke6 a;
        public final /* synthetic */ HorizontalTabView b;

        public d(HorizontalTabView horizontalTabView, ke6 ke6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, ke6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = horizontalTabView;
            this.a = ke6Var;
        }

        @Override // com.repackage.pr4.c
        public void a(pr4 pr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, pr4Var, i, view2) == null) || this.a.b.size() <= i || this.a.b.get(i) == null) {
                return;
            }
            pr4Var.e();
            HorizontalTabView horizontalTabView = this.b;
            horizontalTabView.h(horizontalTabView.k(this.a.b.get(i).b));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ HorizontalTabView b;

        public e(HorizontalTabView horizontalTabView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = horizontalTabView;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.scrollBy(0 - this.a, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalTabView a;

        public f(HorizontalTabView horizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalTabView horizontalTabView = this.a;
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256), 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(oo6 oo6Var);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(oo6 oo6Var);
    }

    /* loaded from: classes3.dex */
    public interface i {
        boolean a(int i);

        void b(int i);
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
        this.a = 0;
        this.f = null;
        this.g = null;
        this.h = new Paint();
        this.i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e9);
        this.j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
        this.k = 0;
        this.l = true;
        this.o = 0;
        this.r = new a(this);
        this.s = new b(this);
        this.u = new c(this);
        LinearLayout linearLayout = new LinearLayout(context);
        this.b = linearLayout;
        linearLayout.setOrientation(0);
        this.b.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070309));
        this.c = new po6(context, this.r, this.s);
        m(layoutParams);
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            TabItemView tabItemView = this.f;
            if (tabItemView == null || this.a == 0) {
                return 0;
            }
            return ((tabItemView.getMeasuredWidth() - this.a) - this.f.getDrawableWidth()) / 2;
        }
        return invokeV.intValue;
    }

    public static boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    @Override // com.repackage.mo6
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // com.repackage.mo6
    public void b(int i2) {
        TabItemView tabItemView;
        ud6 ud6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tabItemView = this.f) == null || (ud6Var = this.t) == null) {
            return;
        }
        ud6Var.s(tabItemView.getTabId(), i2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f != null) {
                this.h.setColor(SkinManager.getColor(R.color.CAM_X0204));
                if (this.l) {
                    canvas.drawRect(this.b.getLeft(), getMeasuredHeight() - this.j, this.b.getRight() > getRight() ? this.b.getRight() : getRight(), getMeasuredHeight(), this.h);
                }
                if (!this.n) {
                    int i2 = this.o;
                    if (i2 == 0) {
                        this.h.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0302));
                    } else {
                        this.h.setColor(SkinManager.getSkinColor(null, i2));
                    }
                    canvas.drawRect(this.f.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.i, (this.f.getRight() - getBottomLineMargin()) - this.f.getDrawableWidth(), getMeasuredHeight(), this.h);
                }
            }
            if (this.n) {
                this.h.setAntiAlias(true);
                this.h.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
                int f2 = mi.f(getContext(), R.dimen.obfuscated_res_0x7f070281);
                TabItemView tabItemView = this.f;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(mi.f(getContext(), R.dimen.tbds44), mi.f(getContext(), R.dimen.tbds98), f2, mi.f(getContext(), R.dimen.tbds104)), mi.f(getContext(), R.dimen.tbds6), mi.f(getContext(), R.dimen.tbds6), this.h);
            }
        }
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : (i) invokeV.objValue;
    }

    public void h(oo6 oo6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, oo6Var) == null) || oo6Var == null) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(oo6Var);
        }
        if (oo6Var.b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(oo6Var.b)) {
            if (this.t == null || TextUtils.isEmpty(oo6Var.d)) {
                return;
            }
            ee6 ee6Var = new ee6();
            String str = oo6Var.d;
            this.t.s(oo6Var.b, -1, ee6Var);
            return;
        }
        int i2 = oo6Var.b;
        ee6 ee6Var2 = null;
        if (i2 == 301) {
            ud6 ud6Var = this.t;
            if (ud6Var != null) {
                ud6Var.s(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.t == null) {
            z = true;
        } else {
            ee6 ee6Var3 = new ee6();
            String str2 = oo6Var.d;
            String str3 = oo6Var.a;
            this.t.s(oo6Var.b, 0, ee6Var3);
            if (ee6Var3.d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(oo6Var.a);
                }
            }
        }
        if (!TextUtils.isEmpty(oo6Var.d)) {
            ee6Var2 = new ee6();
            String str4 = oo6Var.d;
            String str5 = oo6Var.a;
        }
        ud6 ud6Var2 = this.t;
        if (ud6Var2 == null || !z) {
            return;
        }
        ud6Var2.s(oo6Var.b, 0, ee6Var2);
    }

    public void i(TabItemView tabItemView, boolean z) {
        ud6 ud6Var;
        List<je6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, tabItemView, z) == null) || tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(tabItemView.getTabId())) {
            if (this.t == null || TextUtils.isEmpty(tabItemView.getUrl())) {
                return;
            }
            ee6 ee6Var = new ee6();
            tabItemView.getUrl();
            this.t.s(tabItemView.getTabId(), -1, ee6Var);
            return;
        }
        ee6 ee6Var2 = null;
        if (tabItemView.getTabId() == 301) {
            ud6 ud6Var2 = this.t;
            if (ud6Var2 != null) {
                ud6Var2.s(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = mi.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f.getTabId() && !o(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.e);
                }
            }
        }
        if (this.f.getState() != TabItemView.e && this.f.getState() != TabItemView.g) {
            if (l(this.f.getTabId()) && !z) {
                i iVar = this.v;
                if (iVar != null && !iVar.a(this.f.getTabId())) {
                    return;
                }
                this.f.setState(TabItemView.g);
                TabItemView tabItemView3 = this.f;
                this.c.f((Activity) getContext(), this, tabItemView3, j(tabItemView3.getTabId()).c);
            }
        } else {
            this.c.c();
            boolean z2 = this.f.getState() == TabItemView.e;
            this.f.setState(TabItemView.f);
            oo6 j = j(this.f.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.d)) {
                ee6Var2 = new ee6();
                String str = j.d;
                String str2 = j.a;
            }
            ke6 ke6Var = j.c;
            if (ke6Var != null && (list = ke6Var.b) != null && list.size() > 0) {
                for (je6 je6Var : j.c.b) {
                    if (je6Var != null && je6Var.c) {
                        i2 = je6Var.b;
                    }
                }
            }
            if (z2 && (ud6Var = this.t) != null) {
                ud6Var.s(this.f.getTabId(), i2, ee6Var2);
            }
        }
        invalidate();
    }

    public final oo6 j(int i2) {
        InterceptResult invokeI;
        List<oo6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.e) != null && list.size() != 0) {
                for (oo6 oo6Var : this.e) {
                    if (oo6Var != null && oo6Var.b == i2) {
                        return oo6Var;
                    }
                }
            }
            return null;
        }
        return (oo6) invokeI.objValue;
    }

    public oo6 k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (ListUtils.isEmpty(this.e)) {
                return null;
            }
            for (oo6 oo6Var : this.e) {
                if (oo6Var != null && oo6Var.b == i2) {
                    return oo6Var;
                }
            }
            return null;
        }
        return (oo6) invokeI.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        ke6 ke6Var;
        List<je6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            oo6 j = j(i2);
            return (j == null || (ke6Var = j.c) == null || (list = ke6Var.b) == null || list.size() <= 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void m(AbsListView.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, layoutParams) == null) {
            addView(this.b, layoutParams);
            setLayoutParams(layoutParams);
            setHorizontalScrollBarEnabled(false);
            SkinManager.setBackgroundColor(this, R.color.transparent);
            setDescendantFocusability(262144);
        }
    }

    public final boolean n(List<oo6> list) {
        InterceptResult invokeL;
        ke6 ke6Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            oo6 j = j(1);
            oo6 oo6Var = null;
            Iterator<oo6> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                oo6 next = it.next();
                if (next != null && next.b == 1) {
                    oo6Var = next;
                    break;
                }
            }
            if (j == null || oo6Var == null || (j.c == null && oo6Var.c == null)) {
                return false;
            }
            if ((j.c != null || oo6Var.c == null) && (oo6Var.c != null || j.c == null)) {
                ke6 ke6Var2 = j.c;
                if (ke6Var2 == null || (ke6Var = oo6Var.c) == null || (ke6Var2.b == null && ke6Var.b == null)) {
                    return false;
                }
                if ((j.c.b != null || oo6Var.c.b == null) && ((oo6Var.c.b != null || j.c.b == null) && (size = j.c.b.size()) == oo6Var.c.b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        je6 je6Var = oo6Var.c.b.get(i2);
                        je6 je6Var2 = j.c.b.get(i2);
                        if (je6Var.b != je6Var2.b || !je6Var.a.equals(je6Var2.a)) {
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

    public final void p(List<oo6> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.k > 0 && list.size() == this.k) {
                layoutParams = new LinearLayout.LayoutParams(mi.k(getContext()) / this.k, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024f);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.d == null || n(list)) {
                    this.d = list;
                    this.b.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        oo6 oo6Var = list.get(i4);
                        if (oo6Var != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), oo6Var, i3, this.n);
                            int i5 = this.o;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.u);
                            if (o(oo6Var.b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.b.addView(tabItemView, layoutParams);
                            if (oo6Var.b == i2) {
                                this.f = tabItemView;
                                tabItemView.setState(TabItemView.f);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.d = null;
            oo6 oo6Var2 = new oo6();
            oo6Var2.b = 1;
            oo6Var2.a = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f03d4);
            this.b.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), oo6Var2, i3, this.n);
            int i6 = this.o;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.u);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
            this.b.addView(tabItemView2, layoutParams);
            this.f = tabItemView2;
            tabItemView2.setState(TabItemView.f);
        }
    }

    public void q() {
        ke6 ke6Var;
        List<je6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.m == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<oo6> list2 = this.d;
        if (list2 == null || list2.size() <= 0 || this.d.get(0) == null || (ke6Var = this.d.get(0).c) == null || (list = ke6Var.b) == null) {
            return;
        }
        for (je6 je6Var : list) {
            if (je6Var != null) {
                arrayList.add(je6Var.a);
            }
        }
        pr4 pr4Var = new pr4(this.m.getPageActivity());
        pr4Var.i(arrayList, new d(this, ke6Var));
        pr4Var.c(this.m);
        pr4Var.m();
    }

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setData(List<oo6> list, int i2, int i3) {
        oo6 oo6Var;
        List<je6> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.n) {
                ArrayList arrayList = new ArrayList();
                this.e = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (oo6Var = list.get(0)) != null && oo6Var.b == 1) {
                    ke6 ke6Var = oo6Var.c;
                    if (ke6Var != null && (list2 = ke6Var.b) != null) {
                        list2.clear();
                    } else {
                        ke6Var = new ke6();
                        ke6Var.b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        je6 je6Var = new je6();
                        je6Var.b = 1;
                        je6Var.a = getContext().getString(R.string.obfuscated_res_0x7f0f03d4);
                        ke6Var.b.add(je6Var);
                        for (oo6 oo6Var2 : list) {
                            if (oo6Var2 != null && oo6Var2.b != 1) {
                                je6 je6Var2 = new je6();
                                je6Var2.b = oo6Var2.b;
                                je6Var2.a = oo6Var2.a;
                                ke6Var.b.add(je6Var2);
                            }
                        }
                        oo6Var.c = ke6Var;
                    }
                    list.clear();
                    list.add(oo6Var);
                }
            } else {
                this.e = list;
            }
            p(list, i2, i3, false);
        }
    }

    public void setDataLoadInterface(ud6 ud6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ud6Var) == null) {
            this.t = ud6Var;
        }
    }

    public void setFakeTab(mo6 mo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mo6Var) == null) {
            this.g = mo6Var;
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
        }
    }

    public void setNeedBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l = z;
            invalidate();
        }
    }

    public void setOnTabItemClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.p = gVar;
        }
    }

    public void setOnTabItemSelectListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hVar) == null) {
            this.q = hVar;
        }
    }

    public void setSelectedItemColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.o = i2;
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
            this.v = iVar;
        }
    }
}
