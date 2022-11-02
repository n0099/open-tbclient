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
import com.baidu.tieba.ak6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.kv4;
import com.baidu.tieba.rk6;
import com.baidu.tieba.sk6;
import com.baidu.tieba.vt6;
import com.baidu.tieba.xi;
import com.baidu.tieba.xt6;
import com.baidu.tieba.yt6;
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
public class HorizontalTabView extends MyHorizontalScrollView implements vt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final LinearLayout b;
    public final yt6 c;
    public List<xt6> d;
    public List<xt6> e;
    public TabItemView f;
    public vt6 g;
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
    public yt6.e r;
    public yt6.d s;
    public ak6 t;
    public View.OnClickListener u;
    public i v;

    /* loaded from: classes4.dex */
    public interface g {
        void a(xt6 xt6Var);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(xt6 xt6Var);
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
    public class a implements yt6.e {
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

        @Override // com.baidu.tieba.yt6.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f != null && this.a.t != null && this.a.t != null) {
                    this.a.t.t(this.a.f.getTabId(), i, null);
                }
                if (this.a.g != null) {
                    this.a.g.b(i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements yt6.d {
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

        @Override // com.baidu.tieba.yt6.d
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
    public class d implements kv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk6 a;
        public final /* synthetic */ HorizontalTabView b;

        public d(HorizontalTabView horizontalTabView, sk6 sk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, sk6Var};
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
            this.a = sk6Var;
        }

        @Override // com.baidu.tieba.kv4.c
        public void a(kv4 kv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, kv4Var, i, view2) == null) && this.a.b.size() > i && this.a.b.get(i) != null) {
                kv4Var.e();
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
                horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252), 0);
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
        this.i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e6);
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
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070306));
        this.c = new yt6(context, this.r, this.s);
        m(layoutParams);
    }

    @Override // com.baidu.tieba.vt6
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // com.baidu.tieba.vt6
    public void b(int i2) {
        TabItemView tabItemView;
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (tabItemView = this.f) != null && (ak6Var = this.t) != null) {
            ak6Var.t(tabItemView.getTabId(), i2, null);
        }
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        sk6 sk6Var;
        List<rk6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            xt6 j = j(i2);
            if (j != null && (sk6Var = j.c) != null && (list = sk6Var.b) != null && list.size() > 0) {
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

    public void setDataLoadInterface(ak6 ak6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ak6Var) == null) {
            this.t = ak6Var;
        }
    }

    public void setFakeTab(vt6 vt6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vt6Var) == null) {
            this.g = vt6Var;
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
                int g2 = xi.g(getContext(), R.dimen.obfuscated_res_0x7f070281);
                TabItemView tabItemView = this.f;
                if (tabItemView != null) {
                    g2 = tabItemView.getRight() - this.f.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(xi.g(getContext(), R.dimen.tbds44), xi.g(getContext(), R.dimen.tbds98), g2, xi.g(getContext(), R.dimen.tbds104)), xi.g(getContext(), R.dimen.tbds6), xi.g(getContext(), R.dimen.tbds6), this.h);
            }
        }
    }

    public void h(xt6 xt6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, xt6Var) != null) || xt6Var == null) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(xt6Var);
        }
        if (xt6Var.b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(xt6Var.b)) {
            if (this.t != null && !TextUtils.isEmpty(xt6Var.d)) {
                kk6 kk6Var = new kk6();
                String str = xt6Var.d;
                this.t.t(xt6Var.b, -1, kk6Var);
                return;
            }
            return;
        }
        int i2 = xt6Var.b;
        kk6 kk6Var2 = null;
        if (i2 == 301) {
            ak6 ak6Var = this.t;
            if (ak6Var != null) {
                ak6Var.t(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 == 49 && this.t != null) {
            kk6 kk6Var3 = new kk6();
            String str2 = xt6Var.d;
            String str3 = xt6Var.a;
            this.t.t(xt6Var.b, 0, kk6Var3);
            if (kk6Var3.d) {
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
                    tabItemView.setText(xt6Var.a);
                }
            }
        }
        if (!TextUtils.isEmpty(xt6Var.d)) {
            kk6Var2 = new kk6();
            String str4 = xt6Var.d;
            String str5 = xt6Var.a;
        }
        ak6 ak6Var2 = this.t;
        if (ak6Var2 != null && z) {
            ak6Var2.t(xt6Var.b, 0, kk6Var2);
        }
    }

    public final boolean n(List<xt6> list) {
        InterceptResult invokeL;
        sk6 sk6Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            xt6 j = j(1);
            xt6 xt6Var = null;
            Iterator<xt6> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xt6 next = it.next();
                if (next != null && next.b == 1) {
                    xt6Var = next;
                    break;
                }
            }
            if (j == null || xt6Var == null || (j.c == null && xt6Var.c == null)) {
                return false;
            }
            if ((j.c == null && xt6Var.c != null) || (xt6Var.c == null && j.c != null)) {
                return true;
            }
            sk6 sk6Var2 = j.c;
            if (sk6Var2 == null || (sk6Var = xt6Var.c) == null || (sk6Var2.b == null && sk6Var.b == null)) {
                return false;
            }
            if ((j.c.b == null && xt6Var.c.b != null) || ((xt6Var.c.b == null && j.c.b != null) || (size = j.c.b.size()) != xt6Var.c.b.size())) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                rk6 rk6Var = xt6Var.c.b.get(i2);
                rk6 rk6Var2 = j.c.b.get(i2);
                if (rk6Var.b != rk6Var2.b || !rk6Var.a.equals(rk6Var2.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(TabItemView tabItemView, boolean z) {
        boolean z2;
        ak6 ak6Var;
        List<rk6> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, tabItemView, z) != null) || tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(tabItemView.getTabId())) {
            if (this.t != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                kk6 kk6Var = new kk6();
                tabItemView.getUrl();
                this.t.t(tabItemView.getTabId(), -1, kk6Var);
                return;
            }
            return;
        }
        kk6 kk6Var2 = null;
        if (tabItemView.getTabId() == 301) {
            ak6 ak6Var2 = this.t;
            if (ak6Var2 != null) {
                ak6Var2.t(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int l = xi.l(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252);
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
            xt6 j = j(this.f.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.d)) {
                kk6Var2 = new kk6();
                String str = j.d;
                String str2 = j.a;
            }
            sk6 sk6Var = j.c;
            if (sk6Var != null && (list = sk6Var.b) != null && list.size() > 0) {
                for (rk6 rk6Var : j.c.b) {
                    if (rk6Var != null && rk6Var.c) {
                        i2 = rk6Var.b;
                    }
                }
            }
            if (z2 && (ak6Var = this.t) != null) {
                ak6Var.t(this.f.getTabId(), i2, kk6Var2);
            }
        }
        invalidate();
    }

    public final xt6 j(int i2) {
        InterceptResult invokeI;
        List<xt6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.e) != null && list.size() != 0) {
                for (xt6 xt6Var : this.e) {
                    if (xt6Var != null && xt6Var.b == i2) {
                        return xt6Var;
                    }
                }
            }
            return null;
        }
        return (xt6) invokeI.objValue;
    }

    public xt6 k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (!ListUtils.isEmpty(this.e)) {
                for (xt6 xt6Var : this.e) {
                    if (xt6Var != null && xt6Var.b == i2) {
                        return xt6Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (xt6) invokeI.objValue;
    }

    public final void p(List<xt6> list, int i2, int i3, boolean z) {
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
                layoutParams = new LinearLayout.LayoutParams(xi.l(getContext()) / this.k, -1);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024c);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            if (list != null && list.size() != 0) {
                setVisibility(0);
                if (this.d == null || n(list)) {
                    this.d = list;
                    this.b.removeAllViews();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        xt6 xt6Var = list.get(i4);
                        if (xt6Var != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), xt6Var, i3, this.n);
                            int i5 = this.o;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.u);
                            if (o(xt6Var.b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.b.addView(tabItemView, layoutParams);
                            if (xt6Var.b == i2) {
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
            xt6 xt6Var2 = new xt6();
            xt6Var2.b = 1;
            xt6Var2.a = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f03e8);
            this.b.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), xt6Var2, i3, this.n);
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
        sk6 sk6Var;
        List<rk6> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.m != null) {
            ArrayList arrayList = new ArrayList();
            List<xt6> list2 = this.d;
            if (list2 != null && list2.size() > 0 && this.d.get(0) != null && (sk6Var = this.d.get(0).c) != null && (list = sk6Var.b) != null) {
                for (rk6 rk6Var : list) {
                    if (rk6Var != null) {
                        arrayList.add(rk6Var.a);
                    }
                }
                kv4 kv4Var = new kv4(this.m.getPageActivity());
                kv4Var.i(arrayList, new d(this, sk6Var));
                kv4Var.c(this.m);
                kv4Var.m();
            }
        }
    }

    public void setData(List<xt6> list, int i2, int i3) {
        xt6 xt6Var;
        List<rk6> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.n) {
                ArrayList arrayList = new ArrayList();
                this.e = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (xt6Var = list.get(0)) != null && xt6Var.b == 1) {
                    sk6 sk6Var = xt6Var.c;
                    if (sk6Var != null && (list2 = sk6Var.b) != null) {
                        list2.clear();
                    } else {
                        sk6Var = new sk6();
                        sk6Var.b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        rk6 rk6Var = new rk6();
                        rk6Var.b = 1;
                        rk6Var.a = getContext().getString(R.string.obfuscated_res_0x7f0f03e8);
                        sk6Var.b.add(rk6Var);
                        for (xt6 xt6Var2 : list) {
                            if (xt6Var2 != null && xt6Var2.b != 1) {
                                rk6 rk6Var2 = new rk6();
                                rk6Var2.b = xt6Var2.b;
                                rk6Var2.a = xt6Var2.a;
                                sk6Var.b.add(rk6Var2);
                            }
                        }
                        xt6Var.c = sk6Var;
                    }
                    list.clear();
                    list.add(xt6Var);
                }
            } else {
                this.e = list;
            }
            p(list, i2, i3, false);
        }
    }
}
