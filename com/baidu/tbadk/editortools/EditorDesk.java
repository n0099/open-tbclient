package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.noConflictPanel.widget.KPSwitchFSPanelFrameLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.o0.w.h;
import d.a.o0.w.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<h> f12985f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<n> f12986g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f12987h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f12988i;
    public int j;
    public n k;
    public boolean l;
    public boolean m;
    public EditorTools n;
    public Runnable o;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorDesk f12989e;

        public a(EditorDesk editorDesk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorDesk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12989e = editorDesk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12989e.k == null) {
                return;
            }
            this.f12989e.k.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editorTools};
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
        this.f12987h = new LinkedList();
        this.f12988i = new LinkedList();
        this.j = R.color.CAM_X0206;
        this.k = null;
        this.l = true;
        this.m = false;
        this.o = new a(this);
        this.f12985f = new LinkedList<>();
        this.f12986g = new LinkedList<>();
        this.n = editorTools;
        this.f12987h.add(2);
        this.f12987h.add(5);
        this.f12987h.add(6);
        this.f12988i.add(12);
        this.f12988i.add(16);
    }

    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            this.f12985f.add(hVar);
        }
    }

    public void e(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            this.f12986g.add(nVar);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<n> it = this.f12986g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.getToolId() == 2) {
                    k(next);
                }
                if (next instanceof View) {
                    View view = (View) next;
                    view.setVisibility(8);
                    addView(view, -1, getContext().getResources().getDimensionPixelSize(R.dimen.ds460));
                }
                next.init();
            }
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.hide();
            }
            this.k = null;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && m(i2)) {
            if (r()) {
                this.l = true;
            } else {
                this.l = false;
            }
            if ((this.l && q(i2)) || p(i2)) {
                this.n.q();
                l.K(getContext(), ((Activity) getContext()).getCurrentFocus());
                return;
            }
            boolean z = this.m;
            Iterator<n> it = this.f12986g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.m = true;
                }
                if (next.getToolId() == i2) {
                    this.k = next;
                    if (this.l) {
                        next.b();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.l && (getContext() instanceof Activity)) {
                EditorTools editorTools = this.n;
                if (editorTools != null) {
                    editorTools.p();
                } else {
                    l.x(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                e.a().postDelayed(this.o, 250L);
            }
            j();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = null;
            this.f12985f.clear();
            this.f12986g.clear();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(0);
        }
    }

    public final void k(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) && (nVar instanceof MoreDeskView)) {
            ((MoreDeskView) nVar).q(this.f12985f);
            nVar.init();
        }
    }

    public h l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Iterator<h> it = this.f12985f.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.getToolId() == i2) {
                    return next;
                }
            }
            return null;
        }
        return (h) invokeI.objValue;
    }

    public final boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            Iterator<n> it = this.f12986g.iterator();
            while (it.hasNext()) {
                if (it.next().getToolId() == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.hide();
            }
            this.k = null;
            setVisibility(8);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.k == null) {
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            u(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            n nVar = this.k;
            return nVar != null && nVar.getToolId() != i2 && 2 == i2 && this.f12988i.contains(Integer.valueOf(this.k.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            n nVar = this.k;
            return nVar != null && nVar.getToolId() == i2 && this.f12987h.contains(Integer.valueOf(this.k.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Iterator<n> it = this.f12986g.iterator();
            while (it.hasNext()) {
                if (((View) it.next()).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                u(true);
            }
            super.requestDisallowInterceptTouchEvent(false);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getVisibility() == 0 && r() : invokeV.booleanValue;
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i2));
            this.j = i2;
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            Iterator<h> it = this.f12985f.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null && (next instanceof View)) {
                    ((View) next).setEnabled(z);
                }
            }
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            int i3 = this.j;
            if (i3 > 0) {
                SkinManager.setBackgroundColor(this, i3, i2);
            }
            Iterator<h> it = this.f12985f.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i2);
            }
            Iterator<n> it2 = this.f12986g.iterator();
            while (it2.hasNext()) {
                n next = it2.next();
                if (next != null) {
                    next.onChangeSkinType(i2);
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public boolean v(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Iterator<h> it = this.f12985f.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof View) {
                    View view = (View) next;
                    if (next.getToolId() == i2) {
                        view.setEnabled(z);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
