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
import com.repackage.fr4;
import com.repackage.h05;
import com.repackage.ht4;
import com.repackage.i05;
import com.repackage.m05;
import com.repackage.n05;
import com.repackage.o05;
import com.repackage.pi;
import com.repackage.q05;
import com.repackage.qg;
import com.repackage.t05;
import com.repackage.u05;
import com.repackage.zy5;
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
    public List<Integer> A;
    public EditorBar a;
    public EditorDesk b;
    public View c;
    public View d;
    public List<t05> e;
    public SparseArray<i05> f;
    public SparseArray<HashSet<i05>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<o05> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Context r;
    public String s;
    public long t;
    public int u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public Runnable z;

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
    public class c implements Comparator<t05> {
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
        public int compare(t05 t05Var, t05 t05Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t05Var, t05Var2)) == null) ? t05Var.l - t05Var2.l : invokeLL.intValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y == null) {
                return;
            }
            this.a.y.onClick(view2);
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
        this.x = new a(this);
        this.z = new b(this);
        this.A = new ArrayList();
        r(context);
    }

    public void A(h05 h05Var) {
        HashSet<Integer> hashSet;
        int i;
        t05 n;
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) || h05Var == null) {
            return;
        }
        int i2 = h05Var.a;
        if (i2 == 2) {
            boolean z = false;
            o05 q = this.a.q(h05Var.b);
            if (q == null) {
                q = this.b.l(h05Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<o05> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o05 next = it.next();
                    if (next.getToolId() == h05Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.C(h05Var);
                if (!z || (n = n(2)) == null || (u05Var = n.m) == null) {
                    return;
                }
                u05Var.C(h05Var);
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = h05Var.b;
            if (i3 > 0) {
                i05 i05Var = this.f.get(i3);
                if (i05Var != null) {
                    int i4 = h05Var.a;
                    if (i4 != 19 && i4 != 20 && (i = h05Var.b) != 27) {
                        this.a.o(i);
                    }
                    t05 n2 = n(h05Var.b);
                    if (n2 != null && n2.n == 5) {
                        q();
                        p();
                    } else {
                        this.b.h(h05Var.b);
                    }
                    i05Var.C(h05Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        i05 i05Var2 = this.f.get(it2.next().intValue());
                        if (i05Var2 != null) {
                            i05Var2.C(h05Var);
                        }
                    }
                }
                HashSet<i05> hashSet2 = this.g.get(h05Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<i05> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().C(h05Var);
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

    public void B(int[] iArr, int i, i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i, i05Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<i05> hashSet = this.g.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.g.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(i05Var);
            } else if (i > 0) {
                this.f.put(i, i05Var);
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
            zy5 zy5Var = new zy5(baseActivity.getPageContext(), view2);
            zy5Var.g0(R.drawable.obfuscated_res_0x7f0802e9);
            zy5Var.O(48);
            zy5Var.U(true);
            zy5Var.L(2);
            zy5Var.h0(true);
            zy5Var.k0(pi.f(baseActivity, R.dimen.tbds_21));
            zy5Var.j0(pi.f(baseActivity, R.dimen.tbds0));
            zy5Var.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            zy5Var.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            zy5Var.N((int) 3000);
            zy5Var.n0(baseActivity.getString(R.string.obfuscated_res_0x7f0f14f1), "write_associate_item_hint_tip_key", true);
        }
    }

    public void b(t05 t05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, t05Var) == null) || t05Var == null) {
            return;
        }
        d(t05Var);
        o05 i = i(t05Var, 1);
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

    public void d(t05 t05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t05Var) == null) || t05Var == null) {
            return;
        }
        this.e.add(t05Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.c = view3;
                fr4 d2 = fr4.d(view3);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, pi.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.c);
        }
    }

    public void f() {
        List<t05> list;
        m05 m05Var;
        q05 q05Var;
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.e) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (t05 t05Var : this.e) {
            if (t05Var.d > 0) {
                linkedList.add(t05Var);
            }
            u05 u05Var2 = t05Var.m;
            if (u05Var2 != null) {
                u05Var2.setToolId(t05Var.c);
                t05Var.m.setEditorTools(this);
                int i = t05Var.n;
                if (i == 6) {
                    this.b.e(t05Var.m);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                    this.a.k(t05Var.m, t05Var.n, !t05Var.o);
                    if (t05Var.n == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(t05Var.p, t05Var.c, t05Var.m);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.i) {
            if (this.p) {
                q05Var = new q05(getContext(), true);
            } else {
                q05Var = new q05(getContext());
            }
            int i2 = this.l;
            if (i2 > 0 && (u05Var = q05Var.m) != null && (u05Var instanceof CommonTabHost)) {
                ((CommonTabHost) u05Var).setBackgroundColorId(i2);
            }
            if (!ht4.k().h("key_write_more_tool_point", false)) {
                q05Var.q = true;
            } else {
                q05Var.q = false;
            }
            d(q05Var);
            q05Var.m.setToolId(q05Var.c);
            q05Var.m.setEditorTools(this);
            B(q05Var.p, q05Var.c, q05Var.m);
            this.b.e(q05Var.m);
            if (this.j) {
                linkedList.add(this.i, q05Var);
            } else {
                linkedList.add(0, q05Var);
            }
        }
        int i3 = this.i + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            t05 t05Var2 = (t05) it.next();
            if (i4 < i3) {
                this.a.j(i(t05Var2, 1));
            } else {
                this.b.d(i(t05Var2, 2));
            }
            i4++;
        }
        if (z) {
            if (this.u == 7) {
                m05Var = new m05(7);
            } else {
                m05Var = new m05(-1);
            }
            d(m05Var);
            o05 i5 = i(m05Var, 1);
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

    public List<t05> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.A : (List) invokeV.objValue;
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
            this.A.clear();
            this.A.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final o05 i(t05 t05Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, t05Var, i)) == null) {
            o05 a2 = n05.a(getContext(), t05Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(t05Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.x);
            }
            return a2;
        }
        return (o05) invokeLI.objValue;
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
                for (t05 t05Var : this.e) {
                    if (t05Var != null) {
                        u05 u05Var = t05Var.m;
                        if ((u05Var instanceof View) && ((View) u05Var).getVisibility() == 0 && !t05Var.o) {
                            t05Var.m.r();
                        }
                    }
                }
            }
            if (this.m) {
                this.m = false;
                q();
            }
            if (!u() && z) {
                qg.a().postDelayed(this.z, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void l() {
        t05 n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (n = n(3)) == null) {
            return;
        }
        u05 u05Var = n.m;
        if (u05Var instanceof View) {
            View view2 = (View) u05Var;
            view2.requestFocus();
            pi.M(getContext(), view2);
        }
    }

    public o05 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            o05 q = this.a.q(i);
            return q != null ? q : this.b.l(i);
        }
        return (o05) invokeI.objValue;
    }

    public t05 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            for (t05 t05Var : this.e) {
                if (t05Var.c == i) {
                    return t05Var;
                }
            }
            return null;
        }
        return (t05) invokeI.objValue;
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
            qg.a().removeCallbacks(this.z);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                pi.x(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            t05 n = n(3);
            if (n != null && (n.m instanceof View)) {
                pi.x(getContext(), (View) n.m);
            }
            t05 n2 = n(28);
            if (n2 == null || !(n2.m instanceof View)) {
                return;
            }
            pi.x(getContext(), (View) n2.m);
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

    public void setActionListener(int i, i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i, i05Var) == null) {
            B(new int[]{i}, 0, i05Var);
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
            this.y = onClickListener;
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
                fr4 d2 = fr4.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view2) == null) && (view2 instanceof o05)) {
            o05 o05Var = (o05) view2;
            int toolId = o05Var.getToolId();
            t05 n = n(toolId);
            if (n.a()) {
                A(new h05(31, 0, Integer.valueOf(o05Var.getToolId())));
                this.a.n(n);
                if (o05Var.getToolId() == 2 && !ht4.k().h("key_write_more_tool_point", false)) {
                    ht4.k().u("key_write_more_tool_point", true);
                    o05Var.k0();
                }
                if (o05Var.getToolId() == 1) {
                    o05Var.hide();
                    j();
                    A(new h05(1, 3, null));
                } else if (n.m == null) {
                    int[] iArr = n.p;
                    if (iArr != null && iArr.length > 0) {
                        A(new h05(iArr[0], -1, null));
                    }
                } else {
                    A(new h05(1, toolId, null));
                }
                if (this.u == 7) {
                    if (o05Var.getToolId() == 6 && !this.w) {
                        this.w = true;
                        A(new h05(63, 0, true));
                    }
                    if (o05Var.getToolId() == 1 && this.w) {
                        this.w = false;
                        A(new h05(63, 0, false));
                    }
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
            this.a.w(this.x);
        }
    }

    public void setActionListener(int[] iArr, i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, iArr, i05Var) == null) {
            B(iArr, 0, i05Var);
        }
    }
}
