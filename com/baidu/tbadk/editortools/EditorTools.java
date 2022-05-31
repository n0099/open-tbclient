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
import com.repackage.b05;
import com.repackage.e05;
import com.repackage.f05;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.sz4;
import com.repackage.tz4;
import com.repackage.wq4;
import com.repackage.xz4;
import com.repackage.ys4;
import com.repackage.yz4;
import com.repackage.zx5;
import com.repackage.zz4;
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
    public List<e05> e;
    public SparseArray<tz4> f;
    public SparseArray<HashSet<tz4>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<zz4> n;
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
    public class c implements Comparator<e05> {
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
        public int compare(e05 e05Var, e05 e05Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, e05Var, e05Var2)) == null) ? e05Var.l - e05Var2.l : invokeLL.intValue;
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

    public void A(sz4 sz4Var) {
        HashSet<Integer> hashSet;
        int i;
        e05 n;
        f05 f05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i2 = sz4Var.a;
        if (i2 == 2) {
            boolean z = false;
            zz4 q = this.a.q(sz4Var.b);
            if (q == null) {
                q = this.b.l(sz4Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<zz4> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zz4 next = it.next();
                    if (next.getToolId() == sz4Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.onAction(sz4Var);
                if (!z || (n = n(2)) == null || (f05Var = n.m) == null) {
                    return;
                }
                f05Var.onAction(sz4Var);
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = sz4Var.b;
            if (i3 > 0) {
                tz4 tz4Var = this.f.get(i3);
                if (tz4Var != null) {
                    int i4 = sz4Var.a;
                    if (i4 != 19 && i4 != 20 && (i = sz4Var.b) != 27) {
                        this.a.o(i);
                    }
                    e05 n2 = n(sz4Var.b);
                    if (n2 != null && n2.n == 5) {
                        q();
                        p();
                    } else {
                        this.b.h(sz4Var.b);
                    }
                    tz4Var.onAction(sz4Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        tz4 tz4Var2 = this.f.get(it2.next().intValue());
                        if (tz4Var2 != null) {
                            tz4Var2.onAction(sz4Var);
                        }
                    }
                }
                HashSet<tz4> hashSet2 = this.g.get(sz4Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<tz4> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(sz4Var);
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

    public void B(int[] iArr, int i, tz4 tz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i, tz4Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<tz4> hashSet = this.g.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.g.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(tz4Var);
            } else if (i > 0) {
                this.f.put(i, tz4Var);
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
            zx5 zx5Var = new zx5(baseActivity.getPageContext(), view2);
            zx5Var.g0(R.drawable.obfuscated_res_0x7f0802e9);
            zx5Var.O(48);
            zx5Var.U(true);
            zx5Var.L(2);
            zx5Var.h0(true);
            zx5Var.k0(li.f(baseActivity, R.dimen.tbds_21));
            zx5Var.j0(li.f(baseActivity, R.dimen.tbds0));
            zx5Var.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            zx5Var.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            zx5Var.N((int) 3000);
            zx5Var.n0(baseActivity.getString(R.string.obfuscated_res_0x7f0f14e4), "write_associate_item_hint_tip_key", true);
        }
    }

    public void b(e05 e05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, e05Var) == null) || e05Var == null) {
            return;
        }
        d(e05Var);
        zz4 i = i(e05Var, 1);
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

    public void d(e05 e05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, e05Var) == null) || e05Var == null) {
            return;
        }
        this.e.add(e05Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.c = view3;
                wq4 d2 = wq4.d(view3);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, li.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.c);
        }
    }

    public void f() {
        List<e05> list;
        xz4 xz4Var;
        b05 b05Var;
        f05 f05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.e) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (e05 e05Var : this.e) {
            if (e05Var.d > 0) {
                linkedList.add(e05Var);
            }
            f05 f05Var2 = e05Var.m;
            if (f05Var2 != null) {
                f05Var2.setToolId(e05Var.c);
                e05Var.m.setEditorTools(this);
                int i = e05Var.n;
                if (i == 6) {
                    this.b.e(e05Var.m);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                    this.a.k(e05Var.m, e05Var.n, !e05Var.o);
                    if (e05Var.n == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(e05Var.p, e05Var.c, e05Var.m);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.i) {
            if (this.p) {
                b05Var = new b05(getContext(), true);
            } else {
                b05Var = new b05(getContext());
            }
            int i2 = this.l;
            if (i2 > 0 && (f05Var = b05Var.m) != null && (f05Var instanceof CommonTabHost)) {
                ((CommonTabHost) f05Var).setBackgroundColorId(i2);
            }
            if (!ys4.k().h("key_write_more_tool_point", false)) {
                b05Var.q = true;
            } else {
                b05Var.q = false;
            }
            d(b05Var);
            b05Var.m.setToolId(b05Var.c);
            b05Var.m.setEditorTools(this);
            B(b05Var.p, b05Var.c, b05Var.m);
            this.b.e(b05Var.m);
            if (this.j) {
                linkedList.add(this.i, b05Var);
            } else {
                linkedList.add(0, b05Var);
            }
        }
        int i3 = this.i + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            e05 e05Var2 = (e05) it.next();
            if (i4 < i3) {
                this.a.j(i(e05Var2, 1));
            } else {
                this.b.d(i(e05Var2, 2));
            }
            i4++;
        }
        if (z) {
            if (this.u == 7) {
                xz4Var = new xz4(7);
            } else {
                xz4Var = new xz4(-1);
            }
            d(xz4Var);
            zz4 i5 = i(xz4Var, 1);
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

    public List<e05> getAllTools() {
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

    public final zz4 i(e05 e05Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, e05Var, i)) == null) {
            zz4 a2 = yz4.a(getContext(), e05Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(e05Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.w);
            }
            return a2;
        }
        return (zz4) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            k(true, true);
        }
    }

    public void k(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                for (e05 e05Var : this.e) {
                    if (e05Var != null) {
                        f05 f05Var = e05Var.m;
                        if ((f05Var instanceof View) && ((View) f05Var).getVisibility() == 0 && !e05Var.o) {
                            e05Var.m.e();
                        }
                    }
                }
            }
            if (this.m) {
                this.m = false;
                q();
            }
            if (!u() && z) {
                mg.a().postDelayed(this.y, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void l() {
        e05 n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (n = n(3)) == null) {
            return;
        }
        f05 f05Var = n.m;
        if (f05Var instanceof View) {
            View view2 = (View) f05Var;
            view2.requestFocus();
            li.M(getContext(), view2);
        }
    }

    public zz4 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            zz4 q = this.a.q(i);
            return q != null ? q : this.b.l(i);
        }
        return (zz4) invokeI.objValue;
    }

    public e05 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            for (e05 e05Var : this.e) {
                if (e05Var.c == i) {
                    return e05Var;
                }
            }
            return null;
        }
        return (e05) invokeI.objValue;
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
            mg.a().removeCallbacks(this.y);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                li.x(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            e05 n = n(3);
            if (n != null && (n.m instanceof View)) {
                li.x(getContext(), (View) n.m);
            }
            e05 n2 = n(28);
            if (n2 == null || !(n2.m instanceof View)) {
                return;
            }
            li.x(getContext(), (View) n2.m);
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

    public void setActionListener(int i, tz4 tz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i, tz4Var) == null) {
            B(new int[]{i}, 0, tz4Var);
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
                wq4 d2 = wq4.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view2) == null) && (view2 instanceof zz4)) {
            zz4 zz4Var = (zz4) view2;
            int toolId = zz4Var.getToolId();
            e05 n = n(toolId);
            if (n.a()) {
                A(new sz4(31, 0, Integer.valueOf(zz4Var.getToolId())));
                this.a.n(n);
                if (zz4Var.getToolId() == 2 && !ys4.k().h("key_write_more_tool_point", false)) {
                    ys4.k().u("key_write_more_tool_point", true);
                    zz4Var.k();
                }
                if (zz4Var.getToolId() == 1) {
                    zz4Var.hide();
                    j();
                    A(new sz4(1, 3, null));
                } else if (n.m == null) {
                    int[] iArr = n.p;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new sz4(iArr[0], -1, null));
                } else {
                    A(new sz4(1, toolId, null));
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

    public void setActionListener(int[] iArr, tz4 tz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, iArr, tz4Var) == null) {
            B(iArr, 0, tz4Var);
        }
    }
}
