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
import com.baidu.tieba.fj;
import com.baidu.tieba.hh;
import com.baidu.tieba.s55;
import com.baidu.tieba.x55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList b;
    public LinkedList c;
    public List d;
    public List e;
    public int f;
    public x55 g;
    public boolean h;
    public boolean i;
    public EditorTools j;
    public Runnable k;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null) {
                this.a.g.display();
            }
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
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.j = editorTools;
        this.d.add(2);
        this.d.add(5);
        this.d.add(6);
        this.e.add(12);
        this.e.add(16);
    }

    public void d(s55 s55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s55Var) == null) {
            this.b.add(s55Var);
        }
    }

    public void e(x55 x55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x55Var) == null) {
            this.c.add(x55Var);
        }
    }

    public final void k(x55 x55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, x55Var) == null) && (x55Var instanceof MoreDeskView)) {
            ((MoreDeskView) x55Var).n(this.b);
            x55Var.init();
        }
    }

    public s55 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                s55 s55Var = (s55) it.next();
                if (s55Var.getToolId() == i) {
                    return s55Var;
                }
            }
            return null;
        }
        return (s55) invokeI.objValue;
    }

    public final boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                if (((x55) it.next()).getToolId() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
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

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            x55 x55Var = this.g;
            if (x55Var != null && x55Var.getToolId() == i && this.d.contains(Integer.valueOf(this.g.getToolId()))) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
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
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                s55 s55Var = (s55) it.next();
                if (s55Var != null && (s55Var instanceof View)) {
                    ((View) s55Var).setEnabled(z);
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                x55 x55Var = (x55) it.next();
                if (x55Var.getToolId() == 2) {
                    k(x55Var);
                }
                if (x55Var instanceof View) {
                    View view2 = (View) x55Var;
                    view2.setVisibility(8);
                    addView(view2, -1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c8));
                }
                x55Var.init();
            }
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x55 x55Var = this.g;
            if (x55Var != null) {
                x55Var.hide();
            }
            this.g = null;
            setVisibility(8);
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

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            x55 x55Var = this.g;
            if (x55Var != null) {
                x55Var.hide();
            }
            this.g = null;
            setVisibility(8);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.g != null) {
            return;
        }
        setVisibility(8);
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                if (((View) ((x55) it.next())).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getVisibility() == 0 && r()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || !m(i)) {
            return;
        }
        if (r()) {
            this.h = true;
        } else {
            this.h = false;
        }
        if ((this.h && q(i)) || p(i)) {
            this.j.q();
            fj.L(getContext(), ((Activity) getContext()).getCurrentFocus());
            return;
        }
        boolean z = this.i;
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            x55 x55Var = (x55) it.next();
            if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (x55Var instanceof View)) {
                View view2 = (View) x55Var;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                view2.setLayoutParams(layoutParams);
                this.i = true;
            }
            if (x55Var.getToolId() == i) {
                this.g = x55Var;
                if (this.h) {
                    x55Var.display();
                }
            } else {
                x55Var.hide();
            }
        }
        if (!this.h && (getContext() instanceof Activity)) {
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.p();
            } else {
                fj.x(getContext(), ((Activity) getContext()).getCurrentFocus());
            }
            hh.a().postDelayed(this.k, 250L);
        }
        j();
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            x55 x55Var = this.g;
            if (x55Var != null && x55Var.getToolId() != i && 2 == i && this.e.contains(Integer.valueOf(this.g.getToolId()))) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            boolean z2 = true;
            if (getVisibility() != i) {
                z = true;
            } else {
                z = false;
            }
            super.setVisibility(i);
            if (z) {
                MessageManager messageManager = MessageManager.getInstance();
                if (i != 0) {
                    z2 = false;
                }
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2010046, Boolean.valueOf(z2)));
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
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((s55) it.next()).onChangeSkinType(i);
            }
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                x55 x55Var = (x55) it2.next();
                if (x55Var != null) {
                    x55Var.onChangeSkinType(i);
                }
            }
        }
    }

    public boolean v(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                s55 s55Var = (s55) it.next();
                if (s55Var instanceof View) {
                    View view2 = (View) s55Var;
                    if (s55Var.getToolId() == i) {
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
