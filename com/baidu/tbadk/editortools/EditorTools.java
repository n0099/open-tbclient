package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b15;
import com.repackage.c15;
import com.repackage.d15;
import com.repackage.f15;
import com.repackage.gs4;
import com.repackage.i15;
import com.repackage.iu4;
import com.repackage.j15;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.oz5;
import com.repackage.w05;
import com.repackage.x05;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorTools extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorBar a;
    public EditorDesk b;
    public View c;
    public View d;
    public List<i15> e;
    public SparseArray<x05> f;
    public SparseArray<HashSet<x05>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<d15> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Context r;
    public String s;
    public long t;
    public int u;
    public boolean v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public Runnable y;
    public List<Integer> z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public a(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public b(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Comparator<i15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public c(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i15 i15Var, i15 i15Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i15Var, i15Var2)) == null) ? i15Var.l - i15Var2.l : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public d(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onClick(view2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorTools(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 1;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.u = 0;
        this.v = false;
        this.w = new a(this);
        this.y = new b(this);
        this.z = new ArrayList();
        r(context);
    }

    public void A(w05 w05Var) {
        HashSet<Integer> hashSet;
        int i;
        i15 n;
        j15 j15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, w05Var) == null) || w05Var == null) {
            return;
        }
        int i2 = w05Var.a;
        if (i2 == 2) {
            boolean z = false;
            d15 q = this.a.q(w05Var.b);
            if (q == null) {
                q = this.b.l(w05Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<d15> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d15 next = it.next();
                    if (next.getToolId() == w05Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.onAction(w05Var);
                if (!z || (n = n(2)) == null || (j15Var = n.m) == null) {
                    return;
                }
                j15Var.onAction(w05Var);
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = w05Var.b;
            if (i3 > 0) {
                x05 x05Var = this.f.get(i3);
                if (x05Var != null) {
                    int i4 = w05Var.a;
                    if (i4 != 19 && i4 != 20 && (i = w05Var.b) != 27) {
                        this.a.o(i);
                    }
                    i15 n2 = n(w05Var.b);
                    if (n2 != null && n2.n == 5) {
                        q();
                        p();
                    } else {
                        this.b.h(w05Var.b);
                    }
                    x05Var.onAction(w05Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        x05 x05Var2 = this.f.get(it2.next().intValue());
                        if (x05Var2 != null) {
                            x05Var2.onAction(w05Var);
                        }
                    }
                }
                HashSet<x05> hashSet2 = this.g.get(w05Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<x05> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(w05Var);
                    }
                }
            }
            if (this.r.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.a.q(2);
                if (bLauncher != null && this.q) {
                    E(bLauncher);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void B(int[] iArr, int i, x05 x05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i, x05Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<x05> hashSet = this.g.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.g.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(x05Var);
            } else if (i > 0) {
                this.f.put(i, x05Var);
                if (iArr == null || iArr.length <= 0) {
                    return;
                }
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.h.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.h.put(i3, hashSet2);
                    }
                    hashSet2.add(Integer.valueOf(i));
                    i2++;
                }
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.y(z);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a.z(z);
        }
    }

    public void E(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            BaseActivity baseActivity = (BaseActivity) this.r;
            oz5 oz5Var = new oz5(baseActivity.getPageContext(), view2);
            oz5Var.g0(R.drawable.obfuscated_res_0x7f0802ea);
            oz5Var.O(48);
            oz5Var.U(true);
            oz5Var.L(2);
            oz5Var.h0(true);
            oz5Var.k0(mi.f(baseActivity, R.dimen.tbds_21));
            oz5Var.j0(mi.f(baseActivity, R.dimen.tbds0));
            oz5Var.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            oz5Var.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            oz5Var.N((int) 3000);
            oz5Var.n0(baseActivity.getString(R.string.obfuscated_res_0x7f0f14d0), "write_associate_item_hint_tip_key", true);
        }
    }

    public void b(i15 i15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, i15Var) == null) || i15Var == null) {
            return;
        }
        d(i15Var);
        d15 i = i(i15Var, 1);
        i.hide();
        EditorBar editorBar = this.a;
        if (editorBar != null) {
            editorBar.i(0, i);
            this.a.removeAllViews();
            this.a.l();
        }
        invalidate();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View view2 = this.d;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.d = view3;
                SkinManager.setBackgroundResource(view3, R.color.transparent);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                this.d.setLayoutParams(layoutParams);
                this.d.setOnClickListener(new d(this));
            }
            addView(this.d, 0);
        }
    }

    public void d(i15 i15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, i15Var) == null) || i15Var == null) {
            return;
        }
        this.e.add(i15Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.c = view3;
                gs4 d2 = gs4.d(view3);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, mi.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.c);
        }
    }

    public void f() {
        List<i15> list;
        b15 b15Var;
        f15 f15Var;
        j15 j15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.e) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (i15 i15Var : this.e) {
            if (i15Var.d > 0) {
                linkedList.add(i15Var);
            }
            j15 j15Var2 = i15Var.m;
            if (j15Var2 != null) {
                j15Var2.setToolId(i15Var.c);
                i15Var.m.setEditorTools(this);
                int i = i15Var.n;
                if (i == 6) {
                    this.b.e(i15Var.m);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                    this.a.k(i15Var.m, i15Var.n, !i15Var.o);
                    if (i15Var.n == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(i15Var.p, i15Var.c, i15Var.m);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.i) {
            if (this.p) {
                f15Var = new f15(getContext(), true);
            } else {
                f15Var = new f15(getContext());
            }
            int i2 = this.l;
            if (i2 > 0 && (j15Var = f15Var.m) != null && (j15Var instanceof CommonTabHost)) {
                ((CommonTabHost) j15Var).setBackgroundColorId(i2);
            }
            if (!iu4.k().h("key_write_more_tool_point", false)) {
                f15Var.q = true;
            } else {
                f15Var.q = false;
            }
            d(f15Var);
            f15Var.m.setToolId(f15Var.c);
            f15Var.m.setEditorTools(this);
            B(f15Var.p, f15Var.c, f15Var.m);
            this.b.e(f15Var.m);
            if (this.j) {
                linkedList.add(this.i, f15Var);
            } else {
                linkedList.add(0, f15Var);
            }
        }
        int i3 = this.i + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            i15 i15Var2 = (i15) it.next();
            if (i4 < i3) {
                this.a.j(i(i15Var2, 1));
            } else {
                this.b.d(i(i15Var2, 2));
            }
            i4++;
        }
        if (z) {
            if (this.u == 7) {
                b15Var = new b15(7);
            } else {
                b15Var = new b15(-1);
            }
            d(b15Var);
            d15 i5 = i(b15Var, 1);
            i5.hide();
            this.a.i(0, i5);
        }
        this.a.l();
        this.b.f();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.a.setLayoutParams(layoutParams);
        this.b.setLayoutParams(layoutParams2);
        this.b.n();
        if (this.p || this.v) {
            this.a.setPadding(0, 0, 0, 0);
        }
        q();
        removeAllViews();
        if (this.a.getBarLauncherType() != 4) {
            e();
        }
        addView(this.a);
        addView(this.b);
        invalidate();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.p();
            this.b.i();
        }
    }

    public List<i15> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t : invokeV.longValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.z.clear();
            this.z.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final d15 i(i15 i15Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, i15Var, i)) == null) {
            d15 a2 = c15.a(getContext(), i15Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(i15Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.w);
            }
            return a2;
        }
        return (d15) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            k(true);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (i15 i15Var : this.e) {
                if (i15Var != null) {
                    j15 j15Var = i15Var.m;
                    if ((j15Var instanceof View) && ((View) j15Var).getVisibility() == 0 && !i15Var.o) {
                        i15Var.m.e();
                    }
                }
            }
            if (this.m) {
                this.m = false;
                q();
            }
            if (!u() && z) {
                ng.a().postDelayed(this.y, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void l() {
        i15 n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (n = n(3)) == null) {
            return;
        }
        j15 j15Var = n.m;
        if (j15Var instanceof View) {
            View view2 = (View) j15Var;
            view2.requestFocus();
            mi.L(getContext(), view2);
        }
    }

    public d15 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            d15 q = this.a.q(i);
            return q != null ? q : this.b.l(i);
        }
        return (d15) invokeI.objValue;
    }

    public i15 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            for (i15 i15Var : this.e) {
                if (i15Var.c == i) {
                    return i15Var;
                }
            }
            return null;
        }
        return (i15) invokeI.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            q();
            setVisibility(8);
            p();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ng.a().removeCallbacks(this.y);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                mi.w(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            i15 n = n(3);
            if (n != null && (n.m instanceof View)) {
                mi.w(getContext(), (View) n.m);
            }
            i15 n2 = n(28);
            if (n2 == null || !(n2.m instanceof View)) {
                return;
            }
            mi.w(getContext(), (View) n2.m);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b.n();
            this.a.n(null);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            this.r = context;
            this.e = new LinkedList();
            this.f = new SparseArray<>();
            this.g = new SparseArray<>();
            this.h = new SparseArray<>();
            this.a = new EditorBar(context, this);
            this.b = new EditorDesk(context, this);
            this.n = new LinkedList<>();
            setOrientation(1);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void setActionListener(int i, x05 x05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i, x05Var) == null) {
            B(new int[]{i}, 0, x05Var);
        }
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.k = i;
            if (i != 0) {
                setBackgroundColor(getContext().getResources().getColor(i));
            }
        }
    }

    public void setBarBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.a.setBackgroundColorId(i);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.a.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.u = i;
            this.a.setBarLauncherType(i);
        }
    }

    public void setBarMaxLauCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.i = i;
        }
    }

    public void setClearEbPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.v = z;
        }
    }

    public void setDeskBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.b.setBackgroundColorId(i);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.b.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j) == null) {
            this.t = j;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
        }
    }

    public void setHideBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.o = z;
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.p = z;
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.j = z;
        }
    }

    public void setMoreDeskBgColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.l = i;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.x = onClickListener;
            c();
        }
    }

    public void setShouldShowMorePopTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.q = z;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.s = str;
        }
    }

    public void setToolEnabled(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.a.x(z, i)) {
            return;
        }
        this.b.v(z, i);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.b.s() : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            SkinManager.setBackgroundColor(this, this.k, i);
            this.a.v(i);
            this.b.t(i);
            View view2 = this.c;
            if (view2 != null) {
                gs4 d2 = gs4.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view2) == null) && (view2 instanceof d15)) {
            d15 d15Var = (d15) view2;
            int toolId = d15Var.getToolId();
            i15 n = n(toolId);
            if (n.a()) {
                A(new w05(31, 0, Integer.valueOf(d15Var.getToolId())));
                this.a.n(n);
                if (d15Var.getToolId() == 2 && !iu4.k().h("key_write_more_tool_point", false)) {
                    iu4.k().u("key_write_more_tool_point", true);
                    d15Var.k();
                }
                if (d15Var.getToolId() == 1) {
                    d15Var.hide();
                    j();
                    A(new w05(1, 3, null));
                } else if (n.m == null) {
                    int[] iArr = n.p;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new w05(iArr[0], -1, null));
                } else {
                    A(new w05(1, toolId, null));
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.a.n(null);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.a.w(this.w);
        }
    }

    public void setActionListener(int[] iArr, x05 x05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, iArr, x05Var) == null) {
            B(iArr, 0, x05Var);
        }
    }
}
