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
import com.baidu.tieba.e05;
import com.baidu.tieba.eh7;
import com.baidu.tieba.f67;
import com.baidu.tieba.gh7;
import com.baidu.tieba.hh7;
import com.baidu.tieba.ii;
import com.baidu.tieba.p67;
import com.baidu.tieba.w67;
import com.baidu.tieba.x67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements eh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final LinearLayout b;
    public final hh7 c;
    public List<gh7> d;
    public List<gh7> e;
    public TabItemView f;
    public eh7 g;
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
    public hh7.e r;
    public hh7.d s;
    public f67 t;
    public View.OnClickListener u;
    public i v;

    /* loaded from: classes4.dex */
    public interface g {
        void a(gh7 gh7Var);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(gh7 gh7Var);
    }

    /* loaded from: classes4.dex */
    public interface i {
        boolean a(int i);

        void b(int i);
    }

    public static boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public void setTabBackgroudColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements hh7.e {
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

        @Override // com.baidu.tieba.hh7.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f != null && this.a.t != null && this.a.t != null) {
                    this.a.t.I(this.a.f.getTabId(), i, null);
                }
                if (this.a.g != null) {
                    this.a.g.b(i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements hh7.d {
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

        @Override // com.baidu.tieba.hh7.d
        public void a(TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tabItemView) == null) {
                this.a.i(tabItemView, false);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class d implements e05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x67 a;
        public final /* synthetic */ HorizontalTabView b;

        public d(HorizontalTabView horizontalTabView, x67 x67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, x67Var};
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
            this.a = x67Var;
        }

        @Override // com.baidu.tieba.e05.c
        public void a(e05 e05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, e05Var, i, view2) == null) && this.a.b.size() > i && this.a.b.get(i) != null) {
                e05Var.e();
                HorizontalTabView horizontalTabView = this.b;
                horizontalTabView.h(horizontalTabView.k(this.a.b.get(i).b));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254), 0);
            }
        }
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
        this.i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e7);
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
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070307));
        this.c = new hh7(context, this.r, this.s);
        m(layoutParams);
    }

    @Override // com.baidu.tieba.eh7
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // com.baidu.tieba.eh7
    public void b(int i2) {
        TabItemView tabItemView;
        f67 f67Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (tabItemView = this.f) != null && (f67Var = this.t) != null) {
            f67Var.I(tabItemView.getTabId(), i2, null);
        }
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        x67 x67Var;
        List<w67> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            gh7 j = j(i2);
            if (j != null && (x67Var = j.c) != null && (list = x67Var.b) != null && list.size() > 0) {
                return true;
            }
            return false;
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

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setDataLoadInterface(f67 f67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, f67Var) == null) {
            this.t = f67Var;
        }
    }

    public void setFakeTab(eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eh7Var) == null) {
            this.g = eh7Var;
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

    public void setmShowMenuCallBack(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.v = iVar;
        }
    }

    private int getBottomLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            TabItemView tabItemView = this.f;
            if (tabItemView != null && this.a != 0) {
                return ((tabItemView.getMeasuredWidth() - this.a) - this.f.getDrawableWidth()) / 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.v;
        }
        return (i) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int right;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f != null) {
                this.h.setColor(SkinManager.getColor(R.color.CAM_X0204));
                if (this.l) {
                    float left = this.b.getLeft();
                    float measuredHeight = getMeasuredHeight() - this.j;
                    if (this.b.getRight() > getRight()) {
                        right = this.b.getRight();
                    } else {
                        right = getRight();
                    }
                    canvas.drawRect(left, measuredHeight, right, getMeasuredHeight(), this.h);
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
                int g2 = ii.g(getContext(), R.dimen.obfuscated_res_0x7f070281);
                TabItemView tabItemView = this.f;
                if (tabItemView != null) {
                    g2 = tabItemView.getRight() - this.f.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(ii.g(getContext(), R.dimen.tbds44), ii.g(getContext(), R.dimen.tbds98), g2, ii.g(getContext(), R.dimen.tbds104)), ii.g(getContext(), R.dimen.tbds6), ii.g(getContext(), R.dimen.tbds6), this.h);
            }
        }
    }

    public void h(gh7 gh7Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, gh7Var) != null) || gh7Var == null) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(gh7Var);
        }
        if (gh7Var.b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(gh7Var.b)) {
            if (this.t != null && !TextUtils.isEmpty(gh7Var.d)) {
                p67 p67Var = new p67();
                String str = gh7Var.d;
                this.t.I(gh7Var.b, -1, p67Var);
                return;
            }
            return;
        }
        int i2 = gh7Var.b;
        p67 p67Var2 = null;
        if (i2 == 301) {
            f67 f67Var = this.t;
            if (f67Var != null) {
                f67Var.I(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 == 49 && this.t != null) {
            p67 p67Var3 = new p67();
            String str2 = gh7Var.d;
            String str3 = gh7Var.a;
            this.t.I(gh7Var.b, 0, p67Var3);
            if (p67Var3.d) {
                return;
            }
            z = false;
        } else {
            z = true;
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(gh7Var.a);
                }
            }
        }
        if (!TextUtils.isEmpty(gh7Var.d)) {
            p67Var2 = new p67();
            String str4 = gh7Var.d;
            String str5 = gh7Var.a;
        }
        f67 f67Var2 = this.t;
        if (f67Var2 != null && z) {
            f67Var2.I(gh7Var.b, 0, p67Var2);
        }
    }

    public final boolean n(List<gh7> list) {
        InterceptResult invokeL;
        x67 x67Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            gh7 j = j(1);
            gh7 gh7Var = null;
            Iterator<gh7> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gh7 next = it.next();
                if (next != null && next.b == 1) {
                    gh7Var = next;
                    break;
                }
            }
            if (j == null || gh7Var == null || (j.c == null && gh7Var.c == null)) {
                return false;
            }
            if ((j.c == null && gh7Var.c != null) || (gh7Var.c == null && j.c != null)) {
                return true;
            }
            x67 x67Var2 = j.c;
            if (x67Var2 == null || (x67Var = gh7Var.c) == null || (x67Var2.b == null && x67Var.b == null)) {
                return false;
            }
            if ((j.c.b == null && gh7Var.c.b != null) || ((gh7Var.c.b == null && j.c.b != null) || (size = j.c.b.size()) != gh7Var.c.b.size())) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                w67 w67Var = gh7Var.c.b.get(i2);
                w67 w67Var2 = j.c.b.get(i2);
                if (w67Var.b != w67Var2.b || !w67Var.a.equals(w67Var2.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(TabItemView tabItemView, boolean z) {
        boolean z2;
        f67 f67Var;
        List<w67> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, tabItemView, z) != null) || tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(tabItemView.getTabId())) {
            if (this.t != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                p67 p67Var = new p67();
                tabItemView.getUrl();
                this.t.I(tabItemView.getTabId(), -1, p67Var);
                return;
            }
            return;
        }
        p67 p67Var2 = null;
        if (tabItemView.getTabId() == 301) {
            f67 f67Var2 = this.t;
            if (f67Var2 != null) {
                f67Var2.I(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int l = ii.l(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254);
        if (iArr[0] < 0) {
            post(new e(this, dimensionPixelSize));
        } else if (l < dimensionPixelSize) {
            post(new f(this));
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.f.getTabId() && !o(tabItemView2.getTabId())) {
                    tabItemView2.setState(0);
                }
            }
        }
        if (this.f.getState() != 0 && this.f.getState() != 2) {
            if (l(this.f.getTabId()) && !z) {
                i iVar = this.v;
                if (iVar != null && !iVar.a(this.f.getTabId())) {
                    return;
                }
                this.f.setState(2);
                TabItemView tabItemView3 = this.f;
                this.c.f((Activity) getContext(), this, tabItemView3, j(tabItemView3.getTabId()).c);
            }
        } else {
            this.c.c();
            if (this.f.getState() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f.setState(1);
            gh7 j = j(this.f.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.d)) {
                p67Var2 = new p67();
                String str = j.d;
                String str2 = j.a;
            }
            x67 x67Var = j.c;
            if (x67Var != null && (list = x67Var.b) != null && list.size() > 0) {
                for (w67 w67Var : j.c.b) {
                    if (w67Var != null && w67Var.c) {
                        i2 = w67Var.b;
                    }
                }
            }
            if (z2 && (f67Var = this.t) != null) {
                f67Var.I(this.f.getTabId(), i2, p67Var2);
            }
        }
        invalidate();
    }

    public final gh7 j(int i2) {
        InterceptResult invokeI;
        List<gh7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.e) != null && list.size() != 0) {
                for (gh7 gh7Var : this.e) {
                    if (gh7Var != null && gh7Var.b == i2) {
                        return gh7Var;
                    }
                }
            }
            return null;
        }
        return (gh7) invokeI.objValue;
    }

    public gh7 k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (!ListUtils.isEmpty(this.e)) {
                for (gh7 gh7Var : this.e) {
                    if (gh7Var != null && gh7Var.b == i2) {
                        return gh7Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (gh7) invokeI.objValue;
    }

    public final void p(List<gh7> list, int i2, int i3, boolean z) {
        boolean z2;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.k > 0 && list.size() == this.k) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(ii.l(getContext()) / this.k, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024d);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.d == null || n(list)) {
                    this.d = list;
                    this.b.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        gh7 gh7Var = list.get(i4);
                        if (gh7Var != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), gh7Var, i3, this.n);
                            int i5 = this.o;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.u);
                            if (o(gh7Var.b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.b.addView(tabItemView, layoutParams);
                            if (gh7Var.b == i2) {
                                this.f = tabItemView;
                                tabItemView.setState(1);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.d = null;
            gh7 gh7Var2 = new gh7();
            gh7Var2.b = 1;
            gh7Var2.a = getContext().getResources().getString(R.string.chosen_pb_title);
            this.b.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), gh7Var2, i3, this.n);
            int i6 = this.o;
            if (i6 != 0) {
                tabItemView2.setSelectItemColorResId(i6);
            }
            tabItemView2.setOnClickListener(this.u);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
            this.b.addView(tabItemView2, layoutParams);
            this.f = tabItemView2;
            tabItemView2.setState(1);
        }
    }

    public void q() {
        x67 x67Var;
        List<w67> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.m != null) {
            ArrayList arrayList = new ArrayList();
            List<gh7> list2 = this.d;
            if (list2 != null && list2.size() > 0 && this.d.get(0) != null && (x67Var = this.d.get(0).c) != null && (list = x67Var.b) != null) {
                for (w67 w67Var : list) {
                    if (w67Var != null) {
                        arrayList.add(w67Var.a);
                    }
                }
                e05 e05Var = new e05(this.m.getPageActivity());
                e05Var.i(arrayList, new d(this, x67Var));
                e05Var.c(this.m);
                e05Var.m();
            }
        }
    }

    public void setData(List<gh7> list, int i2, int i3) {
        gh7 gh7Var;
        List<w67> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.n) {
                ArrayList arrayList = new ArrayList();
                this.e = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (gh7Var = list.get(0)) != null && gh7Var.b == 1) {
                    x67 x67Var = gh7Var.c;
                    if (x67Var != null && (list2 = x67Var.b) != null) {
                        list2.clear();
                    } else {
                        x67Var = new x67();
                        x67Var.b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        w67 w67Var = new w67();
                        w67Var.b = 1;
                        w67Var.a = getContext().getString(R.string.chosen_pb_title);
                        x67Var.b.add(w67Var);
                        for (gh7 gh7Var2 : list) {
                            if (gh7Var2 != null && gh7Var2.b != 1) {
                                w67 w67Var2 = new w67();
                                w67Var2.b = gh7Var2.b;
                                w67Var2.a = gh7Var2.a;
                                x67Var.b.add(w67Var2);
                            }
                        }
                        gh7Var.c = x67Var;
                    }
                    list.clear();
                    list.add(gh7Var);
                }
            } else {
                this.e = list;
            }
            p(list, i2, i3, false);
        }
    }
}
