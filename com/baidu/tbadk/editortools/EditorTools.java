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
import d.a.c.e.p.l;
import d.a.o0.w.f;
import d.a.o0.w.g;
import d.a.o0.w.h;
import d.a.o0.w.j;
import d.a.o0.w.m;
import d.a.o0.w.n;
import d.a.p0.e0.e;
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

    /* renamed from: e  reason: collision with root package name */
    public EditorBar f12990e;

    /* renamed from: f  reason: collision with root package name */
    public EditorDesk f12991f;

    /* renamed from: g  reason: collision with root package name */
    public View f12992g;

    /* renamed from: h  reason: collision with root package name */
    public View f12993h;

    /* renamed from: i  reason: collision with root package name */
    public List<m> f12994i;
    public SparseArray<d.a.o0.w.b> j;
    public SparseArray<HashSet<d.a.o0.w.b>> k;
    public SparseArray<HashSet<Integer>> l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public LinkedList<h> r;
    public boolean s;
    public boolean t;
    public Context u;
    public String v;
    public long w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public Runnable z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f12995e;

        public a(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12995e = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12995e.x(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f12996e;

        public b(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12996e = editorTools;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12996e.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Comparator<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f12997e;

        public c(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12997e = editorTools;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m mVar, m mVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, mVar2)) == null) ? mVar.j - mVar2.j : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f12998e;

        public d(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12998e = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12998e.y == null) {
                return;
            }
            this.f12998e.y.onClick(view);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.s = false;
        this.t = false;
        this.x = new a(this);
        this.z = new b(this);
        this.A = new ArrayList();
        r(context);
    }

    public void A(d.a.o0.w.a aVar) {
        HashSet<Integer> hashSet;
        int i2;
        m n;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        int i3 = aVar.f53487a;
        if (i3 == 2) {
            boolean z = false;
            h q = this.f12990e.q(aVar.f53488b);
            if (q == null) {
                q = this.f12991f.l(aVar.f53488b);
                z = true;
            }
            if (q == null) {
                Iterator<h> it = this.r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.getToolId() == aVar.f53488b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.onAction(aVar);
                if (!z || (n = n(2)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(aVar);
            }
        } else if (i3 == 5) {
            this.f12990e.n(null);
            this.f12991f.g();
        } else {
            int i4 = aVar.f53488b;
            if (i4 > 0) {
                d.a.o0.w.b bVar = this.j.get(i4);
                if (bVar != null) {
                    int i5 = aVar.f53487a;
                    if (i5 != 19 && i5 != 20 && (i2 = aVar.f53488b) != 27) {
                        this.f12990e.o(i2);
                    }
                    m n2 = n(aVar.f53488b);
                    if (n2 != null && n2.l == 5) {
                        q();
                        p();
                    } else {
                        this.f12991f.h(aVar.f53488b);
                    }
                    bVar.onAction(aVar);
                }
            } else if (i4 <= 0) {
                if (i4 < 0 && (hashSet = this.l.get(i3)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        d.a.o0.w.b bVar2 = this.j.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.onAction(aVar);
                        }
                    }
                }
                HashSet<d.a.o0.w.b> hashSet2 = this.k.get(aVar.f53487a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<d.a.o0.w.b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(aVar);
                    }
                }
            }
            if (this.u.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.f12990e.q(2);
                if (bLauncher != null) {
                    E(bLauncher);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void B(int[] iArr, int i2, d.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i2, bVar) == null) {
            int i3 = 0;
            if (i2 == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<d.a.o0.w.b> hashSet = this.k.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i3 < length) {
                        this.k.put(iArr[i3], hashSet);
                        i3++;
                    }
                }
                hashSet.add(bVar);
            } else if (i2 > 0) {
                this.j.put(i2, bVar);
                if (iArr == null || iArr.length <= 0) {
                    return;
                }
                int length2 = iArr.length;
                while (i3 < length2) {
                    int i4 = iArr[i3];
                    HashSet<Integer> hashSet2 = this.l.get(i4);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.l.put(i4, hashSet2);
                    }
                    hashSet2.add(Integer.valueOf(i2));
                    i3++;
                }
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f12990e.y(z);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12990e.z(z);
        }
    }

    public void E(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            BaseActivity baseActivity = (BaseActivity) this.u;
            e eVar = new e(baseActivity.getPageContext(), view);
            eVar.g0(R.drawable.bg_tip_blue_down_right);
            eVar.O(48);
            eVar.U(true);
            eVar.L(2);
            eVar.h0(true);
            eVar.k0(l.g(baseActivity, R.dimen.tbds_21));
            eVar.j0(l.g(baseActivity, R.dimen.tbds0));
            eVar.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            eVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            eVar.N((int) 3000);
            eVar.n0(baseActivity.getString(R.string.user_bubble_tail_position_prompt), "write_buttle_tail_hint_tip_key", true);
        }
    }

    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) || mVar == null) {
            return;
        }
        d(mVar);
        h i2 = i(mVar, 1);
        i2.hide();
        EditorBar editorBar = this.f12990e;
        if (editorBar != null) {
            editorBar.i(0, i2);
            this.f12990e.removeAllViews();
            this.f12990e.l();
        }
        invalidate();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View view = this.f12993h;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f12993h = view2;
                SkinManager.setBackgroundResource(view2, R.color.transparent);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                this.f12993h.setLayoutParams(layoutParams);
                this.f12993h.setOnClickListener(new d(this));
            }
            addView(this.f12993h, 0);
        }
    }

    public void d(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f12994i.add(mVar);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.f12992g;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f12992g = view2;
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.f12992g.setLayoutParams(new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.L_X01)));
            }
            addView(this.f12992g);
        }
    }

    public void f() {
        List<m> list;
        j jVar;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.f12994i) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (m mVar : this.f12994i) {
            if (mVar.f53496d > 0) {
                linkedList.add(mVar);
            }
            n nVar2 = mVar.k;
            if (nVar2 != null) {
                nVar2.setToolId(mVar.f53495c);
                mVar.k.setEditorTools(this);
                int i2 = mVar.l;
                if (i2 == 6) {
                    this.f12991f.e(mVar.k);
                } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                    this.f12990e.k(mVar.k, mVar.l, !mVar.m);
                    if (mVar.l == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(mVar.n, mVar.f53495c, mVar.k);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.m) {
            if (this.t) {
                jVar = new j(getContext(), true);
            } else {
                jVar = new j(getContext());
            }
            int i3 = this.p;
            if (i3 > 0 && (nVar = jVar.k) != null && (nVar instanceof CommonTabHost)) {
                ((CommonTabHost) nVar).setBackgroundColorId(i3);
            }
            if (!d.a.o0.r.d0.b.j().g("key_write_more_tool_point", false)) {
                jVar.o = true;
            } else {
                jVar.o = false;
            }
            d(jVar);
            jVar.k.setToolId(jVar.f53495c);
            jVar.k.setEditorTools(this);
            B(jVar.n, jVar.f53495c, jVar.k);
            this.f12991f.e(jVar.k);
            if (this.n) {
                linkedList.add(this.m, jVar);
            } else {
                linkedList.add(0, jVar);
            }
        }
        int i4 = this.m + 1;
        Iterator it = linkedList.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (i5 < i4) {
                this.f12990e.j(i(mVar2, 1));
            } else {
                this.f12991f.d(i(mVar2, 2));
            }
            i5++;
        }
        if (z) {
            f fVar = new f();
            d(fVar);
            h i6 = i(fVar, 1);
            i6.hide();
            this.f12990e.i(0, i6);
        }
        this.f12990e.l();
        this.f12991f.f();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f12990e.setLayoutParams(layoutParams);
        this.f12991f.setLayoutParams(layoutParams2);
        this.f12991f.n();
        if (this.t) {
            this.f12990e.setPadding(0, 0, 0, 0);
        }
        q();
        removeAllViews();
        if (this.f12990e.getBarLauncherType() != 4) {
            e();
        }
        addView(this.f12990e);
        addView(this.f12991f);
        invalidate();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12990e.p();
            this.f12991f.i();
        }
    }

    public List<m> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12994i : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.A : (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w : invokeV.longValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.A.clear();
            this.A.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final h i(m mVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, mVar, i2)) == null) {
            h a2 = g.a(getContext(), mVar, i2);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(mVar.f53494b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.x);
            }
            return a2;
        }
        return (h) invokeLI.objValue;
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
            for (m mVar : this.f12994i) {
                if (mVar != null) {
                    n nVar = mVar.k;
                    if ((nVar instanceof View) && ((View) nVar).getVisibility() == 0 && !mVar.m) {
                        mVar.k.b();
                    }
                }
            }
            if (this.q) {
                this.q = false;
                q();
            }
            if (!u() && z) {
                d.a.c.e.m.e.a().postDelayed(this.z, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void l() {
        m n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (n = n(3)) == null) {
            return;
        }
        n nVar = n.k;
        if (nVar instanceof View) {
            View view = (View) nVar;
            view.requestFocus();
            l.K(getContext(), view);
        }
    }

    public h m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            h q = this.f12990e.q(i2);
            return q != null ? q : this.f12991f.l(i2);
        }
        return (h) invokeI.objValue;
    }

    public m n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            for (m mVar : this.f12994i) {
                if (mVar.f53495c == i2) {
                    return mVar;
                }
            }
            return null;
        }
        return (m) invokeI.objValue;
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
            d.a.c.e.m.e.a().removeCallbacks(this.z);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                l.x(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            m n = n(3);
            if (n != null && (n.k instanceof View)) {
                l.x(getContext(), (View) n.k);
            }
            m n2 = n(28);
            if (n2 == null || !(n2.k instanceof View)) {
                return;
            }
            l.x(getContext(), (View) n2.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f12991f.n();
            this.f12990e.n(null);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            this.u = context;
            this.f12994i = new LinkedList();
            this.j = new SparseArray<>();
            this.k = new SparseArray<>();
            this.l = new SparseArray<>();
            this.f12990e = new EditorBar(context, this);
            this.f12991f = new EditorDesk(context, this);
            this.r = new LinkedList<>();
            setOrientation(1);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void setActionListener(int i2, d.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i2, bVar) == null) {
            B(new int[]{i2}, 0, bVar);
        }
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.o = i2;
            if (i2 != 0) {
                setBackgroundColor(getContext().getResources().getColor(i2));
            }
        }
    }

    public void setBarBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f12990e.setBackgroundColorId(i2);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f12990e.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f12990e.setBarLauncherType(i2);
        }
    }

    public void setBarMaxLauCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.m = i2;
        }
    }

    public void setDeskBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.f12991f.setBackgroundColorId(i2);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f12991f.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.w = j;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public void setIsIM(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.s = z;
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.n = z;
        }
    }

    public void setMoreDeskBgColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onClickListener) == null) {
            this.y = onClickListener;
            c();
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.v = str;
        }
    }

    public void setToolEnabled(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f12990e.x(z, i2)) {
            return;
        }
        this.f12991f.v(z, i2);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f12991f.s() : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            SkinManager.setBackgroundColor(this, this.o, i2);
            this.f12990e.v(i2);
            this.f12991f.t(i2);
            View view = this.f12992g;
            if (view != null) {
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(view);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, view) == null) && (view instanceof h)) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m n = n(toolId);
            if (n.a()) {
                A(new d.a.o0.w.a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.f12990e.n(n);
                if (hVar.getToolId() == 2 && !d.a.o0.r.d0.b.j().g("key_write_more_tool_point", false)) {
                    d.a.o0.r.d0.b.j().t("key_write_more_tool_point", true);
                    hVar.e();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    j();
                    A(new d.a.o0.w.a(1, 3, null));
                } else if (n.k == null) {
                    int[] iArr = n.n;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new d.a.o0.w.a(iArr[0], -1, null));
                } else {
                    A(new d.a.o0.w.a(1, toolId, null));
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f12990e.n(null);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f12990e.w(this.x);
        }
    }

    public void setActionListener(int[] iArr, d.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, iArr, bVar) == null) {
            B(iArr, 0, bVar);
        }
    }
}
