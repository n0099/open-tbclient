package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.repackage.o25;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.t25;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<o25> b;
    public LinkedList<t25> c;
    public List<Integer> d;
    public List<Integer> e;
    public int f;
    public t25 g;
    public boolean h;
    public boolean i;
    public EditorTools j;
    public Runnable k;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g == null) {
                return;
            }
            this.a.g.display();
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
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = R.color.CAM_X0206;
        this.g = null;
        this.h = true;
        this.i = false;
        this.k = new a(this);
        this.b = new LinkedList<>();
        this.c = new LinkedList<>();
        this.j = editorTools;
        this.d.add(2);
        this.d.add(5);
        this.d.add(6);
        this.e.add(12);
        this.e.add(16);
    }

    public void d(o25 o25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o25Var) == null) {
            this.b.add(o25Var);
        }
    }

    public void e(t25 t25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t25Var) == null) {
            this.c.add(t25Var);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<t25> it = this.c.iterator();
            while (it.hasNext()) {
                t25 next = it.next();
                if (next.getToolId() == 2) {
                    k(next);
                }
                if (next instanceof View) {
                    View view2 = (View) next;
                    view2.setVisibility(8);
                    addView(view2, -1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c8));
                }
                next.init();
            }
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t25 t25Var = this.g;
            if (t25Var != null) {
                t25Var.hide();
            }
            this.g = null;
            setVisibility(8);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && m(i)) {
            if (r()) {
                this.h = true;
            } else {
                this.h = false;
            }
            if ((this.h && q(i)) || p(i)) {
                this.j.q();
                qi.L(getContext(), ((Activity) getContext()).getCurrentFocus());
                return;
            }
            boolean z = this.i;
            Iterator<t25> it = this.c.iterator();
            while (it.hasNext()) {
                t25 next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view2 = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view2.setLayoutParams(layoutParams);
                    this.i = true;
                }
                if (next.getToolId() == i) {
                    this.g = next;
                    if (this.h) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.h && (getContext() instanceof Activity)) {
                EditorTools editorTools = this.j;
                if (editorTools != null) {
                    editorTools.p();
                } else {
                    qi.x(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                rg.a().postDelayed(this.k, 250L);
            }
            j();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g = null;
            this.b.clear();
            this.c.clear();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(0);
        }
    }

    public final void k(t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, t25Var) == null) && (t25Var instanceof MoreDeskView)) {
            ((MoreDeskView) t25Var).n(this.b);
            t25Var.init();
        }
    }

    public o25 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Iterator<o25> it = this.b.iterator();
            while (it.hasNext()) {
                o25 next = it.next();
                if (next.getToolId() == i) {
                    return next;
                }
            }
            return null;
        }
        return (o25) invokeI.objValue;
    }

    public final boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Iterator<t25> it = this.c.iterator();
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
            t25 t25Var = this.g;
            if (t25Var != null) {
                t25Var.hide();
            }
            this.g = null;
            setVisibility(8);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.g == null) {
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
            t25 t25Var = this.g;
            return t25Var != null && t25Var.getToolId() != i && 2 == i && this.e.contains(Integer.valueOf(this.g.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            t25 t25Var = this.g;
            return t25Var != null && t25Var.getToolId() == i && this.d.contains(Integer.valueOf(this.g.getToolId()));
        }
        return invokeI.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Iterator<t25> it = this.c.iterator();
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
            this.f = i;
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            Iterator<o25> it = this.b.iterator();
            while (it.hasNext()) {
                o25 next = it.next();
                if (next != null && (next instanceof View)) {
                    ((View) next).setEnabled(z);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            boolean z = getVisibility() != i;
            super.setVisibility(i);
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010046, Boolean.valueOf(i == 0)));
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            int i2 = this.f;
            if (i2 > 0) {
                SkinManager.setBackgroundColor(this, i2, i);
            }
            Iterator<o25> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
            Iterator<t25> it2 = this.c.iterator();
            while (it2.hasNext()) {
                t25 next = it2.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public boolean v(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Iterator<o25> it = this.b.iterator();
            while (it.hasNext()) {
                o25 next = it.next();
                if (next instanceof View) {
                    View view2 = (View) next;
                    if (next.getToolId() == i) {
                        view2.setEnabled(z);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
