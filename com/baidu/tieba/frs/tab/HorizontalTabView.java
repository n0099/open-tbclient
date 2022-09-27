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
import com.baidu.tieba.aj6;
import com.baidu.tieba.bj6;
import com.baidu.tieba.ej;
import com.baidu.tieba.gs6;
import com.baidu.tieba.is6;
import com.baidu.tieba.ji6;
import com.baidu.tieba.js6;
import com.baidu.tieba.pu4;
import com.baidu.tieba.ti6;
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
public class HorizontalTabView extends MyHorizontalScrollView implements gs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final LinearLayout b;
    public final js6 c;
    public List<is6> d;
    public List<is6> e;
    public TabItemView f;
    public gs6 g;
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
    public js6.e r;
    public js6.d s;
    public ji6 t;
    public View.OnClickListener u;
    public i v;

    /* loaded from: classes4.dex */
    public class a implements js6.e {
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

        @Override // com.baidu.tieba.js6.e
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
    public class b implements js6.d {
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

        @Override // com.baidu.tieba.js6.d
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
    public class d implements pu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj6 a;
        public final /* synthetic */ HorizontalTabView b;

        public d(HorizontalTabView horizontalTabView, bj6 bj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTabView, bj6Var};
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
            this.a = bj6Var;
        }

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) || this.a.b.size() <= i || this.a.b.get(i) == null) {
                return;
            }
            pu4Var.e();
            HorizontalTabView horizontalTabView = this.b;
            horizontalTabView.h(horizontalTabView.k(this.a.b.get(i).b));
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

    /* loaded from: classes4.dex */
    public interface g {
        void a(is6 is6Var);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(is6 is6Var);
    }

    /* loaded from: classes4.dex */
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
        this.c = new js6(context, this.r, this.s);
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

    @Override // com.baidu.tieba.gs6
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h(k(i2));
        }
    }

    @Override // com.baidu.tieba.gs6
    public void b(int i2) {
        TabItemView tabItemView;
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tabItemView = this.f) == null || (ji6Var = this.t) == null) {
            return;
        }
        ji6Var.t(tabItemView.getTabId(), i2, null);
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
                int f2 = ej.f(getContext(), R.dimen.obfuscated_res_0x7f070281);
                TabItemView tabItemView = this.f;
                if (tabItemView != null) {
                    f2 = tabItemView.getRight() - this.f.getDrawableWidth();
                }
                canvas.drawRoundRect(new RectF(ej.f(getContext(), R.dimen.tbds44), ej.f(getContext(), R.dimen.tbds98), f2, ej.f(getContext(), R.dimen.tbds104)), ej.f(getContext(), R.dimen.tbds6), ej.f(getContext(), R.dimen.tbds6), this.h);
            }
        }
    }

    public i getmShowMenuCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : (i) invokeV.objValue;
    }

    public void h(is6 is6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, is6Var) == null) || is6Var == null) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(is6Var);
        }
        if (is6Var.b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(is6Var.b)) {
            if (this.t == null || TextUtils.isEmpty(is6Var.d)) {
                return;
            }
            ti6 ti6Var = new ti6();
            String str = is6Var.d;
            this.t.t(is6Var.b, -1, ti6Var);
            return;
        }
        int i2 = is6Var.b;
        ti6 ti6Var2 = null;
        if (i2 == 301) {
            ji6 ji6Var = this.t;
            if (ji6Var != null) {
                ji6Var.t(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.t == null) {
            z = true;
        } else {
            ti6 ti6Var3 = new ti6();
            String str2 = is6Var.d;
            String str3 = is6Var.a;
            this.t.t(is6Var.b, 0, ti6Var3);
            if (ti6Var3.d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
            View childAt = this.b.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(is6Var.a);
                }
            }
        }
        if (!TextUtils.isEmpty(is6Var.d)) {
            ti6Var2 = new ti6();
            String str4 = is6Var.d;
            String str5 = is6Var.a;
        }
        ji6 ji6Var2 = this.t;
        if (ji6Var2 == null || !z) {
            return;
        }
        ji6Var2.t(is6Var.b, 0, ti6Var2);
    }

    public void i(TabItemView tabItemView, boolean z) {
        ji6 ji6Var;
        List<aj6> list;
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
            ti6 ti6Var = new ti6();
            tabItemView.getUrl();
            this.t.t(tabItemView.getTabId(), -1, ti6Var);
            return;
        }
        ti6 ti6Var2 = null;
        if (tabItemView.getTabId() == 301) {
            ji6 ji6Var2 = this.t;
            if (ji6Var2 != null) {
                ji6Var2.t(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.f = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = ej.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252);
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
            boolean z2 = this.f.getState() == 0;
            this.f.setState(1);
            is6 j = j(this.f.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.d)) {
                ti6Var2 = new ti6();
                String str = j.d;
                String str2 = j.a;
            }
            bj6 bj6Var = j.c;
            if (bj6Var != null && (list = bj6Var.b) != null && list.size() > 0) {
                for (aj6 aj6Var : j.c.b) {
                    if (aj6Var != null && aj6Var.c) {
                        i2 = aj6Var.b;
                    }
                }
            }
            if (z2 && (ji6Var = this.t) != null) {
                ji6Var.t(this.f.getTabId(), i2, ti6Var2);
            }
        }
        invalidate();
    }

    public final is6 j(int i2) {
        InterceptResult invokeI;
        List<is6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 0 && (list = this.e) != null && list.size() != 0) {
                for (is6 is6Var : this.e) {
                    if (is6Var != null && is6Var.b == i2) {
                        return is6Var;
                    }
                }
            }
            return null;
        }
        return (is6) invokeI.objValue;
    }

    public is6 k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (ListUtils.isEmpty(this.e)) {
                return null;
            }
            for (is6 is6Var : this.e) {
                if (is6Var != null && is6Var.b == i2) {
                    return is6Var;
                }
            }
            return null;
        }
        return (is6) invokeI.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        bj6 bj6Var;
        List<aj6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            is6 j = j(i2);
            return (j == null || (bj6Var = j.c) == null || (list = bj6Var.b) == null || list.size() <= 0) ? false : true;
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

    public final boolean n(List<is6> list) {
        InterceptResult invokeL;
        bj6 bj6Var;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list == null) {
                return false;
            }
            is6 j = j(1);
            is6 is6Var = null;
            Iterator<is6> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                is6 next = it.next();
                if (next != null && next.b == 1) {
                    is6Var = next;
                    break;
                }
            }
            if (j == null || is6Var == null || (j.c == null && is6Var.c == null)) {
                return false;
            }
            if ((j.c != null || is6Var.c == null) && (is6Var.c != null || j.c == null)) {
                bj6 bj6Var2 = j.c;
                if (bj6Var2 == null || (bj6Var = is6Var.c) == null || (bj6Var2.b == null && bj6Var.b == null)) {
                    return false;
                }
                if ((j.c.b != null || is6Var.c.b == null) && ((is6Var.c.b != null || j.c.b == null) && (size = j.c.b.size()) == is6Var.c.b.size())) {
                    for (int i2 = 0; i2 < size; i2++) {
                        aj6 aj6Var = is6Var.c.b.get(i2);
                        aj6 aj6Var2 = j.c.b.get(i2);
                        if (aj6Var.b != aj6Var2.b || !aj6Var.a.equals(aj6Var2.a)) {
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

    public final void p(List<is6> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.k > 0 && list.size() == this.k) {
                layoutParams = new LinearLayout.LayoutParams(ej.k(getContext()) / this.k, -1);
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
                        is6 is6Var = list.get(i4);
                        if (is6Var != null) {
                            TabItemView tabItemView = new TabItemView(getContext(), is6Var, i3, this.n);
                            int i5 = this.o;
                            if (i5 != 0) {
                                tabItemView.setSelectItemColorResId(i5);
                            }
                            tabItemView.setOnClickListener(this.u);
                            if (o(is6Var.b)) {
                                SkinManager.setViewTextColor(tabItemView, (int) R.color.CAM_X0105);
                            }
                            if (i4 == 0) {
                                layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                            }
                            this.b.addView(tabItemView, layoutParams);
                            if (is6Var.b == i2) {
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
            is6 is6Var2 = new is6();
            is6Var2.b = 1;
            is6Var2.a = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f03df);
            this.b.removeAllViews();
            TabItemView tabItemView2 = new TabItemView(getContext(), is6Var2, i3, this.n);
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
        bj6 bj6Var;
        List<aj6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.m == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<is6> list2 = this.d;
        if (list2 == null || list2.size() <= 0 || this.d.get(0) == null || (bj6Var = this.d.get(0).c) == null || (list = bj6Var.b) == null) {
            return;
        }
        for (aj6 aj6Var : list) {
            if (aj6Var != null) {
                arrayList.add(aj6Var.a);
            }
        }
        pu4 pu4Var = new pu4(this.m.getPageActivity());
        pu4Var.i(arrayList, new d(this, bj6Var));
        pu4Var.c(this.m);
        pu4Var.m();
    }

    public void setAutoFillTabCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setData(List<is6> list, int i2, int i3) {
        is6 is6Var;
        List<aj6> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i2, i3) == null) {
            if (this.n) {
                ArrayList arrayList = new ArrayList();
                this.e = arrayList;
                arrayList.addAll(list);
                if (list != null && list.size() > 0 && (is6Var = list.get(0)) != null && is6Var.b == 1) {
                    bj6 bj6Var = is6Var.c;
                    if (bj6Var != null && (list2 = bj6Var.b) != null) {
                        list2.clear();
                    } else {
                        bj6Var = new bj6();
                        bj6Var.b = new ArrayList();
                    }
                    if (ListUtils.getCount(list) > 1) {
                        aj6 aj6Var = new aj6();
                        aj6Var.b = 1;
                        aj6Var.a = getContext().getString(R.string.obfuscated_res_0x7f0f03df);
                        bj6Var.b.add(aj6Var);
                        for (is6 is6Var2 : list) {
                            if (is6Var2 != null && is6Var2.b != 1) {
                                aj6 aj6Var2 = new aj6();
                                aj6Var2.b = is6Var2.b;
                                aj6Var2.a = is6Var2.a;
                                bj6Var.b.add(aj6Var2);
                            }
                        }
                        is6Var.c = bj6Var;
                    }
                    list.clear();
                    list.add(is6Var);
                }
            } else {
                this.e = list;
            }
            p(list, i2, i3, false);
        }
    }

    public void setDataLoadInterface(ji6 ji6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ji6Var) == null) {
            this.t = ji6Var;
        }
    }

    public void setFakeTab(gs6 gs6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gs6Var) == null) {
            this.g = gs6Var;
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
