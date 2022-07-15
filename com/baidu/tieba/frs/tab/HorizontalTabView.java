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
import com.repackage.er4;
import com.repackage.he6;
import com.repackage.jo6;
import com.repackage.lo6;
import com.repackage.mo6;
import com.repackage.pi;
import com.repackage.re6;
import com.repackage.xe6;
import com.repackage.ye6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements jo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final LinearLayout b;
    public final mo6 c;
    public List<lo6> d;
    public List<lo6> e;
    public TabItemView f;
    public jo6 g;
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
    public mo6.e r;
    public mo6.d s;
    public he6 t;
    public View.OnClickListener u;
    public i v;

    /* loaded from: classes3.dex */
    public class a implements mo6.e {
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

        @Override // com.repackage.mo6.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f != null && this.a.t != null && this.a.t != null) {
                    this.a.t.u(this.a.f.getTabId(), i, null);
                }
                if (this.a.g != null) {
                    this.a.g.b(i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements mo6.d {
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

        @Override // com.repackage.mo6.d
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
    public class d implements er4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye6 a;
        public final /* synthetic */ HorizontalTabView b;

        public d(HorizontalTabView horizontalTabView, ye6 ye6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, ye6Var};
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
            this.a = ye6Var;
        }

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) || this.a.b.size() <= i || this.a.b.get(i) == null) {
                return;
            }
            er4Var.e();
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
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070255), 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(lo6 lo6Var);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(lo6 lo6Var);
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
        this.i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e8);
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
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070308));
        this.c = new mo6(context, this.r, this.s);
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

    @Override // com.repackage.jo6
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // com.repackage.jo6
    public void b(int i2) {
        TabItemView tabItemView;
        he6 he6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tabItemView = this.f) == null || (he6Var = this.t) == null) {
            return;
        }
        he6Var.u(tabItemView.getTabId(), i2, null);
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
                int f2 = pi.f(getContext(), R.dimen.obfuscated_res_0x7f070281);
                TabItemView tabItemView = this.f;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(pi.f(getContext(), R.dimen.tbds44), pi.f(getContext(), R.dimen.tbds98), f2, pi.f(getContext(), R.dimen.tbds104)), pi.f(getContext(), R.dimen.tbds6), pi.f(getContext(), R.dimen.tbds6), this.h);
            }
        }
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : (i) invokeV.objValue;
    }

    public void h(lo6 lo6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, lo6Var) == null) || lo6Var == null) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(lo6Var);
        }
        if (lo6Var.b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(lo6Var.b)) {
            if (this.t == null || TextUtils.isEmpty(lo6Var.d)) {
                return;
            }
            re6 re6Var = new re6();
            String str = lo6Var.d;
            this.t.u(lo6Var.b, -1, re6Var);
            return;
        }
        int i2 = lo6Var.b;
        re6 re6Var2 = null;
        if (i2 == 301) {
            he6 he6Var = this.t;
            if (he6Var != null) {
                he6Var.u(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.t == null) {
            z = true;
        } else {
            re6 re6Var3 = new re6();
            String str2 = lo6Var.d;
            String str3 = lo6Var.a;
            this.t.u(lo6Var.b, 0, re6Var3);
            if (re6Var3.d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(lo6Var.a);
                }
            }
        }
        if (!TextUtils.isEmpty(lo6Var.d)) {
            re6Var2 = new re6();
            String str4 = lo6Var.d;
            String str5 = lo6Var.a;
        }
        he6 he6Var2 = this.t;
        if (he6Var2 == null || !z) {
            return;
        }
        he6Var2.u(lo6Var.b, 0, re6Var2);
    }

    public void i(TabItemView tabItemView, boolean z) {
        he6 he6Var;
        List<xe6> list;
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
            re6 re6Var = new re6();
            tabItemView.getUrl();
            this.t.u(tabItemView.getTabId(), -1, re6Var);
            return;
        }
        re6 re6Var2 = null;
        if (tabItemView.getTabId() == 301) {
            he6 he6Var2 = this.t;
            if (he6Var2 != null) {
                he6Var2.u(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = pi.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070255);
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
            lo6 j = j(this.f.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.d)) {
                re6Var2 = new re6();
                String str = j.d;
                String str2 = j.a;
            }
            ye6 ye6Var = j.c;
            if (ye6Var != null && (list = ye6Var.b) != null && list.size() > 0) {
                for (xe6 xe6Var : j.c.b) {
                    if (xe6Var != null && xe6Var.c) {
                        i2 = xe6Var.b;
                    }
                }
            }
            if (z2 && (he6Var = this.t) != null) {
                he6Var.u(this.f.getTabId(), i2, re6Var2);
            }
        }
        invalidate();
    }

    public final lo6 j(int i2) {
        InterceptResult invokeI;
        List<lo6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.e) != null && list.size() != 0) {
                for (lo6 lo6Var : this.e) {
                    if (lo6Var != null && lo6Var.b == i2) {
                        return lo6Var;
                    }
                }
            }
            return null;
        }
        return (lo6) invokeI.objValue;
    }

    public lo6 k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (ListUtils.isEmpty(this.e)) {
                return null;
            }
            for (lo6 lo6Var : this.e) {
                if (lo6Var != null && lo6Var.b == i2) {
                    return lo6Var;
                }
            }
            return null;
        }
        return (lo6) invokeI.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        ye6 ye6Var;
        List<xe6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            lo6 j = j(i2);
            return (j == null || (ye6Var = j.c) == null || (list = ye6Var.b) == null || list.size() <= 0) ? false : true;
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

    public final boolean n(List<lo6> list) {
        InterceptResult invokeL;
        ye6 ye6Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            lo6 j = j(1);
            lo6 lo6Var = null;
            Iterator<lo6> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                lo6 next = it.next();
                if (next != null && next.b == 1) {
                    lo6Var = next;
                    break;
                }
            }
            if (j == null || lo6Var == null || (j.c == null && lo6Var.c == null)) {
                return false;
            }
            if ((j.c != null || lo6Var.c == null) && (lo6Var.c != null || j.c == null)) {
                ye6 ye6Var2 = j.c;
                if (ye6Var2 == null || (ye6Var = lo6Var.c) == null || (ye6Var2.b == null && ye6Var.b == null)) {
                    return false;
                }
                if ((j.c.b != null || lo6Var.c.b == null) && ((lo6Var.c.b != null || j.c.b == null) && (size = j.c.b.size()) == lo6Var.c.b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        xe6 xe6Var = lo6Var.c.b.get(i2);
                        xe6 xe6Var2 = j.c.b.get(i2);
                        if (xe6Var.b != xe6Var2.b || !xe6Var.a.equals(xe6Var2.a)) {
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

    public final void p(List<lo6> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.k > 0 && list.size() == this.k) {
                layoutParams = new LinearLayout.LayoutParams(pi.k(getContext()) / this.k, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024e);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.d == null || n(list)) {
                    this.d = list;
                    this.b.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        lo6 lo6Var = list.get(i4);
                        if (lo6Var != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), lo6Var, i3, this.n);
                            int i5 = this.o;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.u);
                            if (o(lo6Var.b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.b.addView(tabItemView, layoutParams);
                            if (lo6Var.b == i2) {
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
            lo6 lo6Var2 = new lo6();
            lo6Var2.b = 1;
            lo6Var2.a = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f03cf);
            this.b.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), lo6Var2, i3, this.n);
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
        ye6 ye6Var;
        List<xe6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.m == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<lo6> list2 = this.d;
        if (list2 == null || list2.size() <= 0 || this.d.get(0) == null || (ye6Var = this.d.get(0).c) == null || (list = ye6Var.b) == null) {
            return;
        }
        for (xe6 xe6Var : list) {
            if (xe6Var != null) {
                arrayList.add(xe6Var.a);
            }
        }
        er4 er4Var = new er4(this.m.getPageActivity());
        er4Var.i(arrayList, new d(this, ye6Var));
        er4Var.c(this.m);
        er4Var.m();
    }

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setData(List<lo6> list, int i2, int i3) {
        lo6 lo6Var;
        List<xe6> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.n) {
                ArrayList arrayList = new ArrayList();
                this.e = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (lo6Var = list.get(0)) != null && lo6Var.b == 1) {
                    ye6 ye6Var = lo6Var.c;
                    if (ye6Var != null && (list2 = ye6Var.b) != null) {
                        list2.clear();
                    } else {
                        ye6Var = new ye6();
                        ye6Var.b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        xe6 xe6Var = new xe6();
                        xe6Var.b = 1;
                        xe6Var.a = getContext().getString(R.string.obfuscated_res_0x7f0f03cf);
                        ye6Var.b.add(xe6Var);
                        for (lo6 lo6Var2 : list) {
                            if (lo6Var2 != null && lo6Var2.b != 1) {
                                xe6 xe6Var2 = new xe6();
                                xe6Var2.b = lo6Var2.b;
                                xe6Var2.a = lo6Var2.a;
                                ye6Var.b.add(xe6Var2);
                            }
                        }
                        lo6Var.c = ye6Var;
                    }
                    list.clear();
                    list.add(lo6Var);
                }
            } else {
                this.e = list;
            }
            p(list, i2, i3, false);
        }
    }

    public void setDataLoadInterface(he6 he6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, he6Var) == null) {
            this.t = he6Var;
        }
    }

    public void setFakeTab(jo6 jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jo6Var) == null) {
            this.g = jo6Var;
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
