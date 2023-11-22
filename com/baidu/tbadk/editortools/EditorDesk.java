package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.noConflictPanel.widget.KPSwitchFSPanelFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.he5;
import com.baidu.tieba.me5;
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
    public LinkedList<he5> b;
    public LinkedList<me5> c;
    public List<Integer> d;
    public List<Integer> e;
    public int f;
    public me5 g;
    public boolean h;
    public boolean i;
    public EditorTools j;
    public long k;
    public long l;
    public Runnable m;
    public Runnable n;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null) {
                this.a.g.display();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorDesk a;

        public b(EditorDesk editorDesk) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
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
        this.k = 250L;
        this.l = 0L;
        this.m = new a(this);
        this.n = new b(this);
        this.b = new LinkedList<>();
        this.c = new LinkedList<>();
        this.j = editorTools;
        this.d.add(2);
        this.d.add(5);
        this.d.add(6);
        this.e.add(12);
        this.e.add(16);
    }

    public void d(he5 he5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, he5Var) == null) {
            this.b.add(he5Var);
        }
    }

    public void e(me5 me5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me5Var) == null) {
            this.c.add(me5Var);
        }
    }

    public final void k(me5 me5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, me5Var) == null) && (me5Var instanceof MoreDeskView)) {
            ((MoreDeskView) me5Var).n(this.b);
            me5Var.init();
        }
    }

    public he5 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Iterator<he5> it = this.b.iterator();
            while (it.hasNext()) {
                he5 next = it.next();
                if (next.getToolId() == i) {
                    return next;
                }
            }
            return null;
        }
        return (he5) invokeI.objValue;
    }

    public final boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Iterator<me5> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().getToolId() == i) {
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
            me5 me5Var = this.g;
            if (me5Var != null && me5Var.getToolId() == i && this.d.contains(Integer.valueOf(this.g.getToolId()))) {
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
            Iterator<he5> it = this.b.iterator();
            while (it.hasNext()) {
                he5 next = it.next();
                if (next != null && (next instanceof View)) {
                    ((View) next).setEnabled(z);
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<me5> it = this.c.iterator();
            while (it.hasNext()) {
                me5 next = it.next();
                if (next.getToolId() == 2) {
                    k(next);
                }
                if (next instanceof View) {
                    View view2 = (View) next;
                    view2.setVisibility(8);
                    addView(view2, -1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e2));
                }
                next.init();
            }
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            me5 me5Var = this.g;
            if (me5Var != null) {
                me5Var.hide();
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
            me5 me5Var = this.g;
            if (me5Var != null) {
                me5Var.hide();
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
            Iterator<me5> it = this.c.iterator();
            while (it.hasNext()) {
                if (((View) it.next()).getVisibility() == 0) {
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
            this.j.y();
            BdUtilHelper.showSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
            return;
        }
        boolean z = this.i;
        Iterator<me5> it = this.c.iterator();
        while (it.hasNext()) {
            me5 next = it.next();
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
                editorTools.w();
            } else {
                BdUtilHelper.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
            }
            SafeHandler.getInst().postDelayed(this.m, this.k);
        }
        if (this.l < this.k) {
            SafeHandler.getInst().postDelayed(this.n, this.l);
        } else {
            j();
        }
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            me5 me5Var = this.g;
            if (me5Var != null && me5Var.getToolId() != i && 2 == i && this.e.contains(Integer.valueOf(this.g.getToolId()))) {
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
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            int i2 = this.f;
            if (i2 > 0) {
                SkinManager.setBackgroundColor(this, i2, i);
            }
            Iterator<he5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
            Iterator<me5> it2 = this.c.iterator();
            while (it2.hasNext()) {
                me5 next = it2.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setViewDisplayTime(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (j > 0 && j < this.k) {
                this.l = j;
            }
            if (j2 > 0 && j2 > this.l) {
                this.k = j2;
            }
        }
    }

    public boolean v(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Iterator<he5> it = this.b.iterator();
            while (it.hasNext()) {
                he5 next = it.next();
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
