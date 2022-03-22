package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.o0.w.f;
import c.a.o0.w.h;
import c.a.o0.w.j;
import c.a.o0.w.m;
import c.a.o0.w.n;
import c.a.p0.l0.g;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditorTools extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorBar a;

    /* renamed from: b  reason: collision with root package name */
    public EditorDesk f30482b;

    /* renamed from: c  reason: collision with root package name */
    public View f30483c;

    /* renamed from: d  reason: collision with root package name */
    public View f30484d;

    /* renamed from: e  reason: collision with root package name */
    public List<m> f30485e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<c.a.o0.w.b> f30486f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<HashSet<c.a.o0.w.b>> f30487g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<HashSet<Integer>> f30488h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<h> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Context r;
    public String s;
    public long t;
    public boolean u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public Runnable x;
    public List<Integer> y;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x(view);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class c implements Comparator<m> {
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
        public int compare(m mVar, m mVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, mVar2)) == null) ? mVar.j - mVar2.j : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.w == null) {
                return;
            }
            this.a.w.onClick(view);
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
        this.u = false;
        this.v = new a(this);
        this.x = new b(this);
        this.y = new ArrayList();
        r(context);
    }

    public void A(c.a.o0.w.a aVar) {
        HashSet<Integer> hashSet;
        int i;
        m n;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 2) {
            boolean z = false;
            h q = this.a.q(aVar.f11498b);
            if (q == null) {
                q = this.f30482b.l(aVar.f11498b);
                z = true;
            }
            if (q == null) {
                Iterator<h> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.getToolId() == aVar.f11498b) {
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
        } else if (i2 == 5) {
            this.a.n(null);
            this.f30482b.g();
        } else {
            int i3 = aVar.f11498b;
            if (i3 > 0) {
                c.a.o0.w.b bVar = this.f30486f.get(i3);
                if (bVar != null) {
                    int i4 = aVar.a;
                    if (i4 != 19 && i4 != 20 && (i = aVar.f11498b) != 27) {
                        this.a.o(i);
                    }
                    m n2 = n(aVar.f11498b);
                    if (n2 != null && n2.l == 5) {
                        q();
                        p();
                    } else {
                        this.f30482b.h(aVar.f11498b);
                    }
                    bVar.onAction(aVar);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.f30488h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        c.a.o0.w.b bVar2 = this.f30486f.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.onAction(aVar);
                        }
                    }
                }
                HashSet<c.a.o0.w.b> hashSet2 = this.f30487g.get(aVar.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<c.a.o0.w.b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(aVar);
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

    public void B(int[] iArr, int i, c.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i, bVar) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<c.a.o0.w.b> hashSet = this.f30487g.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.f30487g.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            } else if (i > 0) {
                this.f30486f.put(i, bVar);
                if (iArr == null || iArr.length <= 0) {
                    return;
                }
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.f30488h.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.f30488h.put(i3, hashSet2);
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

    public void E(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            BaseActivity baseActivity = (BaseActivity) this.r;
            g gVar = new g(baseActivity.getPageContext(), view);
            gVar.g0(R.drawable.obfuscated_res_0x7f0802ef);
            gVar.O(48);
            gVar.U(true);
            gVar.L(2);
            gVar.h0(true);
            gVar.k0(c.a.d.f.p.n.f(baseActivity, R.dimen.tbds_21));
            gVar.j0(c.a.d.f.p.n.f(baseActivity, R.dimen.tbds0));
            gVar.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            gVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            gVar.N((int) 3000);
            gVar.n0(baseActivity.getString(R.string.obfuscated_res_0x7f0f149e), "write_associate_item_hint_tip_key", true);
        }
    }

    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) || mVar == null) {
            return;
        }
        d(mVar);
        h i = i(mVar, 1);
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
            View view = this.f30484d;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f30484d = view2;
                SkinManager.setBackgroundResource(view2, R.color.transparent);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                this.f30484d.setLayoutParams(layoutParams);
                this.f30484d.setOnClickListener(new d(this));
            }
            addView(this.f30484d, 0);
        }
    }

    public void d(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f30485e.add(mVar);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.f30483c;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f30483c = view2;
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.f30483c.setLayoutParams(new RelativeLayout.LayoutParams(-1, c.a.d.f.p.n.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.f30483c);
        }
    }

    public void f() {
        List<m> list;
        j jVar;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.f30485e) == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (m mVar : this.f30485e) {
            if (mVar.f11510d > 0) {
                linkedList.add(mVar);
            }
            n nVar2 = mVar.k;
            if (nVar2 != null) {
                nVar2.setToolId(mVar.f11509c);
                mVar.k.setEditorTools(this);
                int i = mVar.l;
                if (i == 6) {
                    this.f30482b.e(mVar.k);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    this.a.k(mVar.k, mVar.l, !mVar.m);
                    if (mVar.l == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(mVar.n, mVar.f11509c, mVar.k);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.i) {
            if (this.p) {
                jVar = new j(getContext(), true);
            } else {
                jVar = new j(getContext());
            }
            int i2 = this.l;
            if (i2 > 0 && (nVar = jVar.k) != null && (nVar instanceof CommonTabHost)) {
                ((CommonTabHost) nVar).setBackgroundColorId(i2);
            }
            if (!c.a.o0.r.j0.b.k().h("key_write_more_tool_point", false)) {
                jVar.o = true;
            } else {
                jVar.o = false;
            }
            d(jVar);
            jVar.k.setToolId(jVar.f11509c);
            jVar.k.setEditorTools(this);
            B(jVar.n, jVar.f11509c, jVar.k);
            this.f30482b.e(jVar.k);
            if (this.j) {
                linkedList.add(this.i, jVar);
            } else {
                linkedList.add(0, jVar);
            }
        }
        int i3 = this.i + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (i4 < i3) {
                this.a.j(i(mVar2, 1));
            } else {
                this.f30482b.d(i(mVar2, 2));
            }
            i4++;
        }
        if (z) {
            f fVar = new f();
            d(fVar);
            h i5 = i(fVar, 1);
            i5.hide();
            this.a.i(0, i5);
        }
        this.a.l();
        this.f30482b.f();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.a.setLayoutParams(layoutParams);
        this.f30482b.setLayoutParams(layoutParams2);
        this.f30482b.n();
        if (this.p || this.u) {
            this.a.setPadding(0, 0, 0, 0);
        }
        q();
        removeAllViews();
        if (this.a.getBarLauncherType() != 4) {
            e();
        }
        addView(this.a);
        addView(this.f30482b);
        invalidate();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.p();
            this.f30482b.i();
        }
    }

    public List<m> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30485e : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y : (List) invokeV.objValue;
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
            this.y.clear();
            this.y.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final h i(m mVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, mVar, i)) == null) {
            h a2 = c.a.o0.w.g.a(getContext(), mVar, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(mVar.f11508b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.v);
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
            for (m mVar : this.f30485e) {
                if (mVar != null) {
                    n nVar = mVar.k;
                    if ((nVar instanceof View) && ((View) nVar).getVisibility() == 0 && !mVar.m) {
                        mVar.k.b();
                    }
                }
            }
            if (this.m) {
                this.m = false;
                q();
            }
            if (!u() && z) {
                e.a().postDelayed(this.x, 200L);
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
            c.a.d.f.p.n.L(getContext(), view);
        }
    }

    public h m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            h q = this.a.q(i);
            return q != null ? q : this.f30482b.l(i);
        }
        return (h) invokeI.objValue;
    }

    public m n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            for (m mVar : this.f30485e) {
                if (mVar.f11509c == i) {
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
            e.a().removeCallbacks(this.x);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                c.a.d.f.p.n.w(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            m n = n(3);
            if (n != null && (n.k instanceof View)) {
                c.a.d.f.p.n.w(getContext(), (View) n.k);
            }
            m n2 = n(28);
            if (n2 == null || !(n2.k instanceof View)) {
                return;
            }
            c.a.d.f.p.n.w(getContext(), (View) n2.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f30482b.n();
            this.a.n(null);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            this.r = context;
            this.f30485e = new LinkedList();
            this.f30486f = new SparseArray<>();
            this.f30487g = new SparseArray<>();
            this.f30488h = new SparseArray<>();
            this.a = new EditorBar(context, this);
            this.f30482b = new EditorDesk(context, this);
            this.n = new LinkedList<>();
            setOrientation(1);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void setActionListener(int i, c.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i, bVar) == null) {
            B(new int[]{i}, 0, bVar);
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
            this.u = z;
        }
    }

    public void setDeskBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.f30482b.setBackgroundColorId(i);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.f30482b.setDeskLauncherEnabled(z);
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
            this.w = onClickListener;
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
        this.f30482b.v(z, i);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f30482b.s() : invokeV.booleanValue;
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
            this.f30482b.t(i);
            View view = this.f30483c;
            if (view != null) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(view);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view) == null) && (view instanceof h)) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m n = n(toolId);
            if (n.a()) {
                A(new c.a.o0.w.a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.a.n(n);
                if (hVar.getToolId() == 2 && !c.a.o0.r.j0.b.k().h("key_write_more_tool_point", false)) {
                    c.a.o0.r.j0.b.k().u("key_write_more_tool_point", true);
                    hVar.f();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    j();
                    A(new c.a.o0.w.a(1, 3, null));
                } else if (n.k == null) {
                    int[] iArr = n.n;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new c.a.o0.w.a(iArr[0], -1, null));
                } else {
                    A(new c.a.o0.w.a(1, toolId, null));
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
            this.a.w(this.v);
        }
    }

    public void setActionListener(int[] iArr, c.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, iArr, bVar) == null) {
            B(iArr, 0, bVar);
        }
    }
}
