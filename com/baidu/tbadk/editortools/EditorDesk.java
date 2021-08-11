package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.e;
import c.a.e.e.p.l;
import c.a.o0.x.h;
import c.a.o0.x.n;
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
/* loaded from: classes6.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<h> f48029f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<n> f48030g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f48031h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f48032i;

    /* renamed from: j  reason: collision with root package name */
    public int f48033j;
    public n k;
    public boolean l;
    public boolean m;
    public EditorTools n;
    public Runnable o;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorDesk f48034e;

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
            this.f48034e = editorDesk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48034e.k == null) {
                return;
            }
            this.f48034e.k.display();
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
        this.f48031h = new LinkedList();
        this.f48032i = new LinkedList();
        this.f48033j = R.color.CAM_X0206;
        this.k = null;
        this.l = true;
        this.m = false;
        this.o = new a(this);
        this.f48029f = new LinkedList<>();
        this.f48030g = new LinkedList<>();
        this.n = editorTools;
        this.f48031h.add(2);
        this.f48031h.add(5);
        this.f48031h.add(6);
        this.f48032i.add(12);
        this.f48032i.add(16);
    }

    public void addLauncher(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            this.f48029f.add(hVar);
        }
    }

    public void addToolView(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            this.f48030g.add(nVar);
        }
    }

    public void build() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<n> it = this.f48030g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.getToolId() == 2) {
                    c(next);
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

    public final void c(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nVar) == null) && (nVar instanceof MoreDeskView)) {
            ((MoreDeskView) nVar).addLaunchers(this.f48029f);
            nVar.init();
        }
    }

    public void changeToKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.hide();
            }
            this.k = null;
        }
    }

    public void changeToTool(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && d(i2)) {
            if (g()) {
                this.l = true;
            } else {
                this.l = false;
            }
            if ((this.l && f(i2)) || e(i2)) {
                this.n.hideTools();
                l.K(getContext(), ((Activity) getContext()).getCurrentFocus());
                return;
            }
            boolean z = this.m;
            Iterator<n> it = this.f48030g.iterator();
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
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.l && (getContext() instanceof Activity)) {
                EditorTools editorTools = this.n;
                if (editorTools != null) {
                    editorTools.hideSoftKey();
                } else {
                    l.x(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                e.a().postDelayed(this.o, 250L);
            }
            display();
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = null;
            this.f48029f.clear();
            this.f48030g.clear();
        }
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            Iterator<n> it = this.f48030g.iterator();
            while (it.hasNext()) {
                if (it.next().getToolId() == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(0);
        }
    }

    public final boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            n nVar = this.k;
            return nVar != null && nVar.getToolId() != i2 && 2 == i2 && this.f48032i.contains(Integer.valueOf(this.k.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            n nVar = this.k;
            return nVar != null && nVar.getToolId() == i2 && this.f48031h.contains(Integer.valueOf(this.k.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public h findLauncherById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            Iterator<h> it = this.f48029f.iterator();
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

    public n findToolsById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            Iterator<n> it = this.f48030g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.getToolId() == i2) {
                    return next;
                }
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Iterator<n> it = this.f48030g.iterator();
            while (it.hasNext()) {
                if (((View) it.next()).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.hide();
            }
            this.k = null;
            setVisibility(8);
        }
    }

    public void hideWhenKeyboardNotShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.k == null) {
            setVisibility(8);
        }
    }

    public boolean isToolVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getVisibility() == 0 && g() : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int i3 = this.f48033j;
            if (i3 > 0) {
                SkinManager.setBackgroundColor(this, i3, i2);
            }
            Iterator<h> it = this.f48029f.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i2);
            }
            Iterator<n> it2 = this.f48030g.iterator();
            while (it2.hasNext()) {
                n next = it2.next();
                if (next != null) {
                    next.onChangeSkinType(i2);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            h(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                h(true);
            }
            super.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i2));
            this.f48033j = i2;
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            Iterator<h> it = this.f48029f.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null && (next instanceof View)) {
                    ((View) next).setEnabled(z);
                }
            }
        }
    }

    public boolean setDeskLauncherEnabled(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Iterator<h> it = this.f48029f.iterator();
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
