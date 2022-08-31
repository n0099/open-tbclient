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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.tieba.l25;
import com.baidu.tieba.m25;
import com.baidu.tieba.ns4;
import com.baidu.tieba.q25;
import com.baidu.tieba.r25;
import com.baidu.tieba.ri;
import com.baidu.tieba.s25;
import com.baidu.tieba.sg;
import com.baidu.tieba.su4;
import com.baidu.tieba.u25;
import com.baidu.tieba.w25;
import com.baidu.tieba.x25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public List<w25> e;
    public SparseArray<m25> f;
    public SparseArray<HashSet<m25>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<s25> n;
    public boolean o;
    public boolean p;
    public Context q;
    public String r;
    public long s;
    public int t;
    public boolean u;
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
    public class c implements Comparator<w25> {
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
        public int compare(w25 w25Var, w25 w25Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, w25Var, w25Var2)) == null) ? w25Var.l - w25Var2.l : invokeLL.intValue;
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
        this.t = 0;
        this.u = false;
        this.x = new a(this);
        this.z = new b(this);
        this.A = new ArrayList();
        r(context);
    }

    public void A(l25 l25Var) {
        HashSet<Integer> hashSet;
        int i;
        w25 n;
        x25 x25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, l25Var) == null) || l25Var == null) {
            return;
        }
        int i2 = l25Var.a;
        if (i2 == 2) {
            boolean z = false;
            s25 q = this.a.q(l25Var.b);
            if (q == null) {
                q = this.b.l(l25Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<s25> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    s25 next = it.next();
                    if (next.getToolId() == l25Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.A(l25Var);
                if (!z || (n = n(2)) == null || (x25Var = n.m) == null) {
                    return;
                }
                x25Var.A(l25Var);
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = l25Var.b;
            if (i3 > 0) {
                m25 m25Var = this.f.get(i3);
                if (m25Var != null) {
                    int i4 = l25Var.a;
                    if (i4 != 19 && i4 != 20 && (i = l25Var.b) != 27) {
                        this.a.o(i);
                    }
                    w25 n2 = n(l25Var.b);
                    if (n2 != null && n2.n == 5) {
                        q();
                        p();
                    } else {
                        this.b.h(l25Var.b);
                    }
                    m25Var.A(l25Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        m25 m25Var2 = this.f.get(it2.next().intValue());
                        if (m25Var2 != null) {
                            m25Var2.A(l25Var);
                        }
                    }
                }
                HashSet<m25> hashSet2 = this.g.get(l25Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<m25> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().A(l25Var);
                    }
                }
            }
            if (this.q.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.a.q(2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void B(int[] iArr, int i, m25 m25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i, m25Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<m25> hashSet = this.g.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.g.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(m25Var);
            } else if (i > 0) {
                this.f.put(i, m25Var);
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

    public void b(w25 w25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, w25Var) == null) || w25Var == null) {
            return;
        }
        d(w25Var);
        s25 i = i(w25Var, 1);
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public void d(w25 w25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, w25Var) == null) || w25Var == null) {
            return;
        }
        this.e.add(w25Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.c = view3;
                ns4 d2 = ns4.d(view3);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, ri.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.c);
        }
    }

    public void f() {
        List<w25> list;
        q25 q25Var;
        u25 u25Var;
        x25 x25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.e) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (w25 w25Var : this.e) {
            if (w25Var.d > 0) {
                linkedList.add(w25Var);
            }
            x25 x25Var2 = w25Var.m;
            if (x25Var2 != null) {
                x25Var2.setToolId(w25Var.c);
                w25Var.m.setEditorTools(this);
                int i = w25Var.n;
                if (i == 6) {
                    this.b.e(w25Var.m);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                    this.a.k(w25Var.m, w25Var.n, !w25Var.o);
                    if (w25Var.n == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(w25Var.p, w25Var.c, w25Var.m);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.i) {
            if (this.p) {
                u25Var = new u25(getContext(), true);
            } else {
                u25Var = new u25(getContext(), this.w ? R.drawable.obfuscated_res_0x7f0806e0 : -1);
            }
            int i2 = this.l;
            if (i2 > 0 && (x25Var = u25Var.m) != null && (x25Var instanceof CommonTabHost)) {
                ((CommonTabHost) x25Var).setBackgroundColorId(i2);
            }
            if (!su4.k().h("key_write_more_tool_point", false)) {
                u25Var.q = true;
            } else {
                u25Var.q = false;
            }
            d(u25Var);
            u25Var.m.setToolId(u25Var.c);
            u25Var.m.setEditorTools(this);
            B(u25Var.p, u25Var.c, u25Var.m);
            this.b.e(u25Var.m);
            if (this.j) {
                linkedList.add(this.i, u25Var);
            } else {
                linkedList.add(0, u25Var);
            }
        }
        int i3 = this.i + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            w25 w25Var2 = (w25) it.next();
            if (i4 < i3) {
                this.a.j(i(w25Var2, 1));
            } else {
                this.b.d(i(w25Var2, 2));
            }
            i4++;
        }
        if (z) {
            if (this.t == 7) {
                q25Var = new q25(7);
            } else {
                q25Var = new q25(-1);
            }
            d(q25Var);
            s25 i5 = i(q25Var, 1);
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
        if (this.p || this.u) {
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
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.p();
            this.b.i();
        }
    }

    public List<w25> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.A : (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.s : invokeV.longValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.A.clear();
            this.A.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final s25 i(w25 w25Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, w25Var, i)) == null) {
            s25 a2 = r25.a(getContext(), w25Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(w25Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.x);
            }
            return a2;
        }
        return (s25) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k(true, true);
        }
    }

    public void k(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                for (w25 w25Var : this.e) {
                    if (w25Var != null) {
                        x25 x25Var = w25Var.m;
                        if ((x25Var instanceof View) && ((View) x25Var).getVisibility() == 0 && !w25Var.o) {
                            w25Var.m.display();
                        }
                    }
                }
            }
            if (this.m) {
                this.m = false;
                q();
            }
            if (!u() && z) {
                sg.a().postDelayed(this.z, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void l() {
        w25 n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (n = n(3)) == null) {
            return;
        }
        x25 x25Var = n.m;
        if (x25Var instanceof View) {
            View view2 = (View) x25Var;
            view2.requestFocus();
            ri.L(getContext(), view2);
        }
    }

    public s25 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            s25 q = this.a.q(i);
            return q != null ? q : this.b.l(i);
        }
        return (s25) invokeI.objValue;
    }

    public w25 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            for (w25 w25Var : this.e) {
                if (w25Var.c == i) {
                    return w25Var;
                }
            }
            return null;
        }
        return (w25) invokeI.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            sg.a().removeCallbacks(this.z);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                ri.x(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            w25 n = n(3);
            if (n != null && (n.m instanceof View)) {
                ri.x(getContext(), (View) n.m);
            }
            w25 n2 = n(28);
            if (n2 == null || !(n2.m instanceof View)) {
                return;
            }
            ri.x(getContext(), (View) n2.m);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.b.n();
            this.a.n(null);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            this.q = context;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void setActionListener(int i, m25 m25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, m25Var) == null) {
            B(new int[]{i}, 0, m25Var);
        }
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.k = i;
            if (i != 0) {
                setBackgroundColor(getContext().getResources().getColor(i));
            }
        }
    }

    public void setBarBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.a.setBackgroundColorId(i);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.a.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.t = i;
            this.a.setBarLauncherType(i);
        }
    }

    public void setBarMaxLauCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.i = i;
        }
    }

    public void setClearEbPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.u = z;
        }
    }

    public void setDeskBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.b.setBackgroundColorId(i);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.b.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.s = j;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
        }
    }

    public void setHideBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.o = z;
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.p = z;
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.j = z;
        }
    }

    public void setMoreDeskBgColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.l = i;
        }
    }

    public void setMoreVipIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.w = z;
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
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.r = str;
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
                ns4 d2 = ns4.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view2) == null) && (view2 instanceof s25)) {
            s25 s25Var = (s25) view2;
            int toolId = s25Var.getToolId();
            w25 n = n(toolId);
            if (n.a()) {
                A(new l25(31, 0, Integer.valueOf(s25Var.getToolId())));
                this.a.n(n);
                if (s25Var.getToolId() == 2 && !su4.k().h("key_write_more_tool_point", false)) {
                    su4.k().u("key_write_more_tool_point", true);
                    s25Var.j0();
                }
                if (s25Var.getToolId() == 1) {
                    s25Var.hide();
                    j();
                    A(new l25(1, 3, null));
                } else if (n.m == null) {
                    int[] iArr = n.p;
                    if (iArr != null && iArr.length > 0) {
                        A(new l25(iArr[0], -1, null));
                    }
                } else {
                    A(new l25(1, toolId, null));
                }
                if (this.t == 7) {
                    if (s25Var.getToolId() == 6 && !this.v) {
                        this.v = true;
                        A(new l25(63, 0, true));
                    }
                    if (s25Var.getToolId() == 1 && this.v) {
                        this.v = false;
                        A(new l25(63, 0, false));
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

    public void setActionListener(int[] iArr, m25 m25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, iArr, m25Var) == null) {
            B(iArr, 0, m25Var);
        }
    }
}
