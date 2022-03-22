package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.o0.w.h;
import c.a.o0.w.n;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<h> f30475b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<n> f30476c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f30477d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f30478e;

    /* renamed from: f  reason: collision with root package name */
    public int f30479f;

    /* renamed from: g  reason: collision with root package name */
    public n f30480g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30481h;
    public boolean i;
    public EditorTools j;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorDesk a;

        public a(EditorDesk editorDesk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorDesk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorDesk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f30480g == null) {
                return;
            }
            this.a.f30480g.b();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30477d = new LinkedList();
        this.f30478e = new LinkedList();
        this.f30479f = R.color.CAM_X0206;
        this.f30480g = null;
        this.f30481h = true;
        this.i = false;
        this.k = new a(this);
        this.f30475b = new LinkedList<>();
        this.f30476c = new LinkedList<>();
        this.j = editorTools;
        this.f30477d.add(2);
        this.f30477d.add(5);
        this.f30477d.add(6);
        this.f30478e.add(12);
        this.f30478e.add(16);
    }

    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            this.f30475b.add(hVar);
        }
    }

    public void e(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            this.f30476c.add(nVar);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<n> it = this.f30476c.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.getToolId() == 2) {
                    k(next);
                }
                if (next instanceof View) {
                    View view = (View) next;
                    view.setVisibility(8);
                    addView(view, -1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c1));
                }
                next.init();
            }
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n nVar = this.f30480g;
            if (nVar != null) {
                nVar.hide();
            }
            this.f30480g = null;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && m(i)) {
            if (r()) {
                this.f30481h = true;
            } else {
                this.f30481h = false;
            }
            if ((this.f30481h && q(i)) || p(i)) {
                this.j.q();
                c.a.d.f.p.n.L(getContext(), ((Activity) getContext()).getCurrentFocus());
                return;
            }
            boolean z = this.i;
            Iterator<n> it = this.f30476c.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.i = true;
                }
                if (next.getToolId() == i) {
                    this.f30480g = next;
                    if (this.f30481h) {
                        next.b();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.f30481h && (getContext() instanceof Activity)) {
                EditorTools editorTools = this.j;
                if (editorTools != null) {
                    editorTools.p();
                } else {
                    c.a.d.f.p.n.w(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                e.a().postDelayed(this.k, 250L);
            }
            j();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30480g = null;
            this.f30475b.clear();
            this.f30476c.clear();
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
            ((MoreDeskView) nVar).q(this.f30475b);
            nVar.init();
        }
    }

    public h l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Iterator<h> it = this.f30475b.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.getToolId() == i) {
                    return next;
                }
            }
            return null;
        }
        return (h) invokeI.objValue;
    }

    public final boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Iterator<n> it = this.f30476c.iterator();
            while (it.hasNext()) {
                if (it.next().getToolId() == i) {
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
            n nVar = this.f30480g;
            if (nVar != null) {
                nVar.hide();
            }
            this.f30480g = null;
            setVisibility(8);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f30480g == null) {
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

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            n nVar = this.f30480g;
            return nVar != null && nVar.getToolId() != i && 2 == i && this.f30478e.contains(Integer.valueOf(this.f30480g.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            n nVar = this.f30480g;
            return nVar != null && nVar.getToolId() == i && this.f30477d.contains(Integer.valueOf(this.f30480g.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Iterator<n> it = this.f30476c.iterator();
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

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i));
            this.f30479f = i;
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            Iterator<h> it = this.f30475b.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null && (next instanceof View)) {
                    ((View) next).setEnabled(z);
                }
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            int i2 = this.f30479f;
            if (i2 > 0) {
                SkinManager.setBackgroundColor(this, i2, i);
            }
            Iterator<h> it = this.f30475b.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
            Iterator<n> it2 = this.f30476c.iterator();
            while (it2.hasNext()) {
                n next = it2.next();
                if (next != null) {
                    next.onChangeSkinType(i);
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

    public boolean v(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Iterator<h> it = this.f30475b.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof View) {
                    View view = (View) next;
                    if (next.getToolId() == i) {
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
