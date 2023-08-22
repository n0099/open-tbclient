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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.tieba.ai5;
import com.baidu.tieba.fi5;
import com.baidu.tieba.gi5;
import com.baidu.tieba.hi5;
import com.baidu.tieba.ji5;
import com.baidu.tieba.li5;
import com.baidu.tieba.mi5;
import com.baidu.tieba.zh5;
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
/* loaded from: classes4.dex */
public class EditorTools extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> A;
    public EditorBar a;
    public EditorDesk b;
    public View c;
    public View d;
    public List<li5> e;
    public SparseArray<ai5> f;
    public SparseArray<HashSet<ai5>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<hi5> n;
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

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
        }
    }

    public void setShouldShowMorePopTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.A(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c implements Comparator<li5> {
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
        public int compare(li5 li5Var, li5 li5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, li5Var, li5Var2)) == null) {
                return li5Var.l - li5Var2.l;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.y != null) {
                this.a.y.onClick(view2);
            }
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
        u(context);
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, context) == null) {
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

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a.y(z);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.z(z);
        }
    }

    public void d(li5 li5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, li5Var) != null) || li5Var == null) {
            return;
        }
        this.e.add(li5Var);
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.A.clear();
            this.A.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && i == 5) {
            D(new zh5(74, 0, null));
        }
    }

    public hi5 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            hi5 q = this.a.q(i);
            if (q != null) {
                return q;
            }
            return this.b.l(i);
        }
        return (hi5) invokeI.objValue;
    }

    public li5 p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            for (li5 li5Var : this.e) {
                if (li5Var.c == i) {
                    return li5Var;
                }
            }
            return null;
        }
        return (li5) invokeI.objValue;
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.k = i;
            if (i != 0) {
                setBackgroundColor(getContext().getResources().getColor(i));
            }
        }
    }

    public void setBarBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.a.setBackgroundColorId(i);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.a.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.t = i;
            this.a.setBarLauncherType(i);
        }
    }

    public void setBarMaxLauCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.i = i;
        }
    }

    public void setClearEbPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.u = z;
        }
    }

    public void setDeskBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.b.setBackgroundColorId(i);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.b.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            this.s = j;
        }
    }

    public void setHideBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.o = z;
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.p = z;
        }
    }

    public void setIsShowAllBg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.a.setIsShowAllBg(z);
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.j = z;
        }
    }

    public void setMoreDeskBgColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.l = i;
        }
    }

    public void setMoreVipIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.w = z;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.y = onClickListener;
            c();
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.r = str;
        }
    }

    public void setTopShadowDividerVisible(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && (view2 = this.c) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void A(View view2) {
        hi5 hi5Var;
        int toolId;
        li5 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2 instanceof hi5) && (p = p((toolId = (hi5Var = (hi5) view2).getToolId()))) != null && p.a()) {
            n(toolId);
            D(new zh5(31, 0, Integer.valueOf(hi5Var.getToolId())));
            this.a.n(p);
            if (hi5Var.getToolId() == 2 && !SharedPrefHelper.getInstance().getBoolean("key_write_more_tool_point", false)) {
                SharedPrefHelper.getInstance().putBoolean("key_write_more_tool_point", true);
                hi5Var.z0();
            }
            if (hi5Var.getToolId() == 1) {
                hi5Var.hide();
                j();
                D(new zh5(1, 3, null));
            } else if (p.m == null) {
                int[] iArr = p.p;
                if (iArr != null && iArr.length > 0) {
                    D(new zh5(iArr[0], -1, null));
                }
            } else {
                D(new zh5(1, toolId, null));
            }
            int i = this.t;
            if (i == 7 || i == 9) {
                if (hi5Var.getToolId() == 6 && !this.v) {
                    this.v = true;
                    D(new zh5(63, 0, true));
                }
                if (hi5Var.getToolId() == 1 && this.v) {
                    this.v = false;
                    D(new zh5(63, 0, false));
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.n(null);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.w(this.x);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.p();
            this.b.i();
        }
    }

    public List<li5> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.A;
        }
        return (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.s;
        }
        return invokeV.longValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            k(true, true);
        }
    }

    public void l() {
        li5 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (p = p(3)) != null) {
            mi5 mi5Var = p.m;
            if (mi5Var instanceof View) {
                View view2 = (View) mi5Var;
                view2.requestFocus();
                BdUtilHelper.showSoftKeyPad(getContext(), view2);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            t();
            setVisibility(8);
            r();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.b.n();
            this.a.n(null);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.b.s();
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D(zh5 zh5Var) {
        HashSet<Integer> hashSet;
        int i;
        li5 p;
        mi5 mi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zh5Var) != null) || zh5Var == null) {
            return;
        }
        int i2 = zh5Var.a;
        if (i2 == 2) {
            boolean z = false;
            hi5 q = this.a.q(zh5Var.b);
            if (q == null) {
                q = this.b.l(zh5Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<hi5> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    hi5 next = it.next();
                    if (next.getToolId() == zh5Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.E(zh5Var);
                if (z && (p = p(2)) != null && (mi5Var = p.m) != null) {
                    mi5Var.E(zh5Var);
                }
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = zh5Var.b;
            if (i3 > 0) {
                ai5 ai5Var = this.f.get(i3);
                if (ai5Var != null) {
                    int i4 = zh5Var.a;
                    if (i4 != 19 && i4 != 20 && (i = zh5Var.b) != 27) {
                        this.a.o(i);
                    }
                    li5 p2 = p(zh5Var.b);
                    if (p2 != null && p2.n == 5) {
                        t();
                        r();
                    } else {
                        this.b.h(zh5Var.b);
                    }
                    ai5Var.E(zh5Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        ai5 ai5Var2 = this.f.get(it2.next().intValue());
                        if (ai5Var2 != null) {
                            ai5Var2.E(zh5Var);
                        }
                    }
                }
                HashSet<ai5> hashSet2 = this.g.get(zh5Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<ai5> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().E(zh5Var);
                    }
                }
            }
            if (this.q.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.a.q(2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void E(int[] iArr, int i, ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, iArr, i, ai5Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr != null && iArr.length != 0) {
                    HashSet<ai5> hashSet = this.g.get(iArr[0]);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        int length = iArr.length;
                        while (i2 < length) {
                            this.g.put(iArr[i2], hashSet);
                            i2++;
                        }
                    }
                    hashSet.add(ai5Var);
                }
            } else if (i > 0) {
                this.f.put(i, ai5Var);
                if (iArr != null && iArr.length > 0) {
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
    }

    public void b(li5 li5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, li5Var) != null) || li5Var == null) {
            return;
        }
        d(li5Var);
        hi5 i = i(li5Var, 1);
        i.hide();
        EditorBar editorBar = this.a;
        if (editorBar != null) {
            editorBar.i(0, i);
            this.a.removeAllViews();
            this.a.l();
        }
        invalidate();
    }

    public void s(int i) {
        mi5 mi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || ListUtils.isEmpty(this.e)) {
            return;
        }
        for (li5 li5Var : this.e) {
            if (li5Var != null && li5Var.c == i && (mi5Var = li5Var.m) != null) {
                mi5Var.hide();
            }
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            SkinManager.setBackgroundColor(this, this.k, i);
            this.a.v(i);
            this.b.t(i);
            View view2 = this.c;
            if (view2 != null) {
                EMManager.from(view2).setCorner(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getParent() != null) {
                View view3 = new View(getContext());
                this.c = view3;
                EMManager.from(view3).setCorner(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.L_X01)));
            }
            addView(this.c);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            for (li5 li5Var : this.e) {
                if (li5Var != null) {
                    mi5 mi5Var = li5Var.m;
                    if ((mi5Var instanceof View) && ((View) mi5Var).getVisibility() == 0 && !li5Var.o) {
                        li5Var.m.display();
                    }
                }
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void f() {
        List<li5> list;
        fi5 fi5Var;
        ji5 ji5Var;
        int i;
        mi5 mi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (list = this.e) != null && list.size() != 0) {
            g();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (li5 li5Var : this.e) {
                if (li5Var.d > 0) {
                    linkedList.add(li5Var);
                }
                mi5 mi5Var2 = li5Var.m;
                if (mi5Var2 != null) {
                    mi5Var2.setToolId(li5Var.c);
                    li5Var.m.setEditorTools(this);
                    int i2 = li5Var.n;
                    if (i2 == 6) {
                        this.b.e(li5Var.m);
                    } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
                        this.a.k(li5Var.m, li5Var.n, !li5Var.o);
                        if (li5Var.n == 5 && p(1) == null) {
                            z = true;
                        }
                    }
                    E(li5Var.p, li5Var.c, li5Var.m);
                }
            }
            Collections.sort(linkedList, new c(this));
            if (linkedList.size() > this.i) {
                if (this.p) {
                    ji5Var = new ji5(getContext(), true);
                } else {
                    Context context = getContext();
                    if (this.w) {
                        i = R.drawable.icon_editor_tool_vip;
                    } else {
                        i = -1;
                    }
                    ji5Var = new ji5(context, i);
                }
                int i3 = this.l;
                if (i3 > 0 && (mi5Var = ji5Var.m) != null && (mi5Var instanceof CommonTabHost)) {
                    ((CommonTabHost) mi5Var).setBackgroundColorId(i3);
                }
                if (!SharedPrefHelper.getInstance().getBoolean("key_write_more_tool_point", false)) {
                    ji5Var.q = true;
                } else {
                    ji5Var.q = false;
                }
                d(ji5Var);
                ji5Var.m.setToolId(ji5Var.c);
                ji5Var.m.setEditorTools(this);
                E(ji5Var.p, ji5Var.c, ji5Var.m);
                this.b.e(ji5Var.m);
                if (this.j) {
                    linkedList.add(this.i, ji5Var);
                } else {
                    linkedList.add(0, ji5Var);
                }
            }
            int i4 = this.i + 1;
            Iterator it = linkedList.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                li5 li5Var2 = (li5) it.next();
                if (i5 < i4) {
                    this.a.j(i(li5Var2, 1));
                } else {
                    this.b.d(i(li5Var2, 2));
                }
                i5++;
            }
            if (z) {
                int i6 = this.t;
                if (i6 != 7 && i6 != 9) {
                    fi5Var = new fi5(-1);
                } else {
                    fi5Var = new fi5(7);
                }
                d(fi5Var);
                hi5 i7 = i(fi5Var, 1);
                i7.hide();
                this.a.i(0, i7);
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
            t();
            removeAllViews();
            if (this.a.getBarLauncherType() != 4 && this.a.getBarLauncherType() != 10) {
                e();
            }
            addView(this.a);
            addView(this.b);
            invalidate();
        }
    }

    public final hi5 i(li5 li5Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, li5Var, i)) == null) {
            hi5 a2 = gi5.a(getContext(), li5Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(li5Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.x);
            }
            return a2;
        }
        return (hi5) invokeLI.objValue;
    }

    public void k(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                for (li5 li5Var : this.e) {
                    if (li5Var != null) {
                        mi5 mi5Var = li5Var.m;
                        if ((mi5Var instanceof View) && ((View) mi5Var).getVisibility() == 0 && !li5Var.o) {
                            li5Var.m.display();
                        }
                    }
                }
            }
            if (this.m) {
                this.m = false;
                t();
            }
            if (!x() && z) {
                SafeHandler.getInst().postDelayed(this.z, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void r() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.z);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), currentFocus);
            }
            if (!z) {
                li5 p = p(3);
                if (p != null && (p.m instanceof View)) {
                    BdUtilHelper.hideSoftKeyPad(getContext(), (View) p.m);
                }
                li5 p2 = p(28);
                if (p2 != null && (p2.m instanceof View)) {
                    BdUtilHelper.hideSoftKeyPad(getContext(), (View) p2.m);
                }
            }
        }
    }

    public void setActionListener(int i, ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, ai5Var) == null) {
            E(new int[]{i}, 0, ai5Var);
        }
    }

    public void setToolEnabled(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && !this.a.x(z, i)) {
            this.b.v(z, i);
        }
    }

    public void setViewDisplayTime(long j, long j2) {
        EditorDesk editorDesk;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (editorDesk = this.b) != null) {
            editorDesk.setViewDisplayTime(j, j2);
        }
    }

    public void setActionListener(int[] iArr, ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, iArr, ai5Var) == null) {
            E(iArr, 0, ai5Var);
        }
    }
}
