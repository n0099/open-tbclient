package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.cg5;
import com.baidu.tieba.de5;
import com.baidu.tieba.fe5;
import com.baidu.tieba.ge5;
import com.baidu.tieba.he5;
import com.baidu.tieba.je5;
import com.baidu.tieba.le5;
import com.baidu.tieba.me5;
import com.baidu.tieba.yd5;
import com.baidu.tieba.zd5;
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
import tbclient.SpriteMemeInfo;
/* loaded from: classes5.dex */
public class EditorTools extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public cg5 B;
    public View.OnClickListener C;
    public Runnable D;
    public List<Integer> E;
    public EditorBar a;
    public EditorDesk b;
    public View c;
    public View d;
    public List<le5> e;
    public SparseArray<zd5> f;
    public SparseArray<HashSet<zd5>> g;
    public SparseArray<HashSet<Integer>> h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public LinkedList<he5> n;
    public boolean o;
    public boolean p;
    public Context q;
    public String r;
    public long s;
    public String t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final ArrayList<de5> y;
    public View.OnClickListener z;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
        }
    }

    public void setShouldShowMorePopTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
        }
    }

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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.G(view2);
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
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Comparator<le5> {
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
        public int compare(le5 le5Var, le5 le5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, le5Var, le5Var2)) == null) {
                return le5Var.l - le5Var2.l;
            }
            return invokeLL.intValue;
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.B == null || !this.a.B.a(view2)) && this.a.A != null) {
                    this.a.A.onClick(view2);
                }
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
        this.u = 0;
        this.v = false;
        this.y = new ArrayList<>();
        this.z = new a(this);
        this.D = new b(this);
        this.E = new ArrayList();
        A(context);
    }

    public void H(de5 de5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, de5Var) == null) {
            this.y.remove(de5Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.a.y(z);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a.z(z);
        }
    }

    public void e(de5 de5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, de5Var) == null) {
            this.y.add(de5Var);
        }
    }

    public void f(le5 le5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, le5Var) != null) || le5Var == null) {
            return;
        }
        this.e.add(le5Var);
    }

    public void k(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            this.E.clear();
            this.E.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public void n(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, spriteMemeInfo) == null) {
            p(true, true, spriteMemeInfo);
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && i == 5) {
            K(new yd5(74, 0, null));
        }
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.k = i;
            if (i != 0) {
                setBackgroundColor(getContext().getResources().getColor(i));
            }
        }
    }

    public void setBarBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.a.setBackgroundColorId(i);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.a.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.u = i;
            this.a.setBarLauncherType(i);
        }
    }

    public void setBarMaxLauCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.i = i;
        }
    }

    public void setClearEbPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.v = z;
        }
    }

    public void setDeskBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.b.setBackgroundColorId(i);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.b.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j) == null) {
            this.s = j;
        }
    }

    public void setFname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.t = str;
        }
    }

    public void setHideBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.o = z;
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.p = z;
        }
    }

    public void setIsShowAllBg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.a.setIsShowAllBg(z);
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.j = z;
        }
    }

    public void setMoreDeskBgColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.l = i;
        }
    }

    public void setMoreVipIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.x = z;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onClickListener) == null) {
            this.A = onClickListener;
            d();
        }
    }

    public void setOnInterceptCancelClickListener(cg5 cg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, cg5Var) == null) {
            this.B = cg5Var;
        }
    }

    public void setOnLauncherClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.r = str;
        }
    }

    public void setTopShadowDividerVisible(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048638, this, z) == null) && (view2 = this.c) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public he5 t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
            he5 q = this.a.q(i);
            if (q != null) {
                return q;
            }
            return this.b.l(i);
        }
        return (he5) invokeI.objValue;
    }

    public le5 u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i)) == null) {
            for (le5 le5Var : this.e) {
                if (le5Var.c == i) {
                    return le5Var;
                }
            }
            return null;
        }
        return (le5) invokeI.objValue;
    }

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
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

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setBackgroundColor(this, this.k, i);
            this.a.v(i);
            this.b.t(i);
            View view2 = this.c;
            if (view2 != null) {
                EMManager.from(view2).setCorner(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            }
        }
    }

    public void c(le5 le5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, le5Var) != null) || le5Var == null) {
            return;
        }
        f(le5Var);
        he5 l = l(le5Var, 1);
        l.hide();
        EditorBar editorBar = this.a;
        if (editorBar != null) {
            editorBar.i(0, l);
            this.a.removeAllViews();
            this.a.l();
        }
        invalidate();
    }

    public void x(int i) {
        me5 me5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048644, this, i) != null) || ListUtils.isEmpty(this.e)) {
            return;
        }
        for (le5 le5Var : this.e) {
            if (le5Var != null && le5Var.c == i && (me5Var = le5Var.m) != null) {
                me5Var.hide();
            }
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.s();
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.n(null);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.w(this.z);
        }
    }

    public List<le5> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.E;
        }
        return (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.s;
        }
        return invokeV.longValue;
    }

    public String getFname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.a.p();
            this.b.i();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            o(true, true);
        }
    }

    public void q() {
        le5 u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (u = u(3)) != null) {
            me5 me5Var = u.m;
            if (me5Var instanceof View) {
                View view2 = (View) me5Var;
                view2.requestFocus();
                BdUtilHelper.showSoftKeyPad(getContext(), view2);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            y();
            setVisibility(8);
            i(EditorToolsState.EDITOR_TOOLS_HIDE, null);
            w();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.b.n();
            this.a.n(null);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            y();
            setVisibility(8);
            w();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
        }
    }

    public void G(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (view2 instanceof he5)) {
            View.OnClickListener onClickListener = this.C;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            he5 he5Var = (he5) view2;
            int toolId = he5Var.getToolId();
            le5 u = u(toolId);
            if (u != null && u.a()) {
                s(toolId);
                K(new yd5(31, 0, Integer.valueOf(he5Var.getToolId())));
                this.a.n(u);
                if (he5Var.getToolId() == 2 && !SharedPrefHelper.getInstance().getBoolean("key_write_more_tool_point", false)) {
                    SharedPrefHelper.getInstance().putBoolean("key_write_more_tool_point", true);
                    he5Var.P0();
                }
                if (he5Var.getToolId() == 41) {
                    he5Var.setIcon();
                }
                if (he5Var.getToolId() == 1) {
                    he5Var.hide();
                    m();
                    K(new yd5(1, 3, null));
                } else if (u.m == null) {
                    int[] iArr = u.p;
                    if (iArr != null && iArr.length > 0) {
                        K(new yd5(iArr[0], -1, null));
                    }
                } else {
                    K(new yd5(1, toolId, null));
                }
                if (this.u == 7) {
                    if (he5Var.getToolId() == 6 && !this.w) {
                        this.w = true;
                        K(new yd5(63, 0, true));
                    }
                    if (he5Var.getToolId() == 1 && this.w) {
                        this.w = false;
                        K(new yd5(63, 0, false));
                    }
                }
                if (this.u == 9) {
                    if (he5Var.getToolId() == 6) {
                        K(new yd5(63, 0, Boolean.TRUE));
                    }
                    if (he5Var.getToolId() == 1) {
                        K(new yd5(63, 0, Boolean.FALSE));
                    }
                }
            }
        }
    }

    public void K(yd5 yd5Var) {
        HashSet<Integer> hashSet;
        int i;
        le5 u;
        me5 me5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, yd5Var) != null) || yd5Var == null) {
            return;
        }
        int i2 = yd5Var.a;
        if (i2 == 2) {
            boolean z = false;
            he5 q = this.a.q(yd5Var.b);
            if (q == null) {
                q = this.b.l(yd5Var.b);
                z = true;
            }
            if (q == null) {
                Iterator<he5> it = this.n.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    he5 next = it.next();
                    if (next.getToolId() == yd5Var.b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.S(yd5Var);
                if (z && (u = u(2)) != null && (me5Var = u.m) != null) {
                    me5Var.S(yd5Var);
                }
            }
        } else if (i2 == 5) {
            this.a.n(null);
            this.b.g();
        } else {
            int i3 = yd5Var.b;
            if (i3 > 0) {
                zd5 zd5Var = this.f.get(i3);
                if (zd5Var != null) {
                    int i4 = yd5Var.a;
                    if (i4 != 19 && i4 != 20 && (i = yd5Var.b) != 27) {
                        this.a.o(i);
                    }
                    le5 u2 = u(yd5Var.b);
                    if (u2 != null && u2.n == 5) {
                        y();
                        w();
                    } else {
                        this.b.h(yd5Var.b);
                    }
                    zd5Var.S(yd5Var);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.h.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        zd5 zd5Var2 = this.f.get(it2.next().intValue());
                        if (zd5Var2 != null) {
                            zd5Var2.S(yd5Var);
                        }
                    }
                }
                HashSet<zd5> hashSet2 = this.g.get(yd5Var.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<zd5> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().S(yd5Var);
                    }
                }
            }
            if (this.q.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.a.q(2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void L(int[] iArr, int i, zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, iArr, i, zd5Var) == null) {
            int i2 = 0;
            if (i == 0) {
                if (iArr != null && iArr.length != 0) {
                    HashSet<zd5> hashSet = this.g.get(iArr[0]);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        int length = iArr.length;
                        while (i2 < length) {
                            this.g.put(iArr[i2], hashSet);
                            i2++;
                        }
                    }
                    hashSet.add(zd5Var);
                }
            } else if (i > 0) {
                this.f.put(i, zd5Var);
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

    public void p(boolean z, boolean z2, @Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), spriteMemeInfo}) == null) {
            if (z2) {
                for (le5 le5Var : this.e) {
                    if (le5Var != null) {
                        me5 me5Var = le5Var.m;
                        if ((me5Var instanceof View) && ((View) me5Var).getVisibility() == 0 && !le5Var.o) {
                            le5Var.m.display();
                        }
                    }
                }
            }
            if (this.m) {
                this.m = false;
                y();
            }
            if (!D() && z) {
                SafeHandler.getInst().postDelayed(this.D, 200L);
            }
            setVisibility(0);
            i(EditorToolsState.EDITOR_TOOLS_SHOW, spriteMemeInfo);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            for (le5 le5Var : this.e) {
                if (le5Var != null) {
                    me5 me5Var = le5Var.m;
                    if ((me5Var instanceof View) && ((View) me5Var).getVisibility() == 0 && !le5Var.o) {
                        le5Var.m.display();
                    }
                }
            }
            setVisibility(0);
            i(EditorToolsState.EDITOR_TOOLS_SHOW, null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void h() {
        List<le5> list;
        fe5 fe5Var;
        je5 je5Var;
        int i;
        me5 me5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (list = this.e) != null && list.size() != 0) {
            j();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (le5 le5Var : this.e) {
                if (le5Var.d > 0) {
                    linkedList.add(le5Var);
                }
                me5 me5Var2 = le5Var.m;
                if (me5Var2 != null) {
                    me5Var2.setToolId(le5Var.c);
                    le5Var.m.setEditorTools(this);
                    int i2 = le5Var.n;
                    if (i2 == 6) {
                        this.b.e(le5Var.m);
                    } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
                        this.a.k(le5Var.m, le5Var.n, !le5Var.o);
                        if (le5Var.n == 5 && u(1) == null) {
                            z = true;
                        }
                    }
                    L(le5Var.p, le5Var.c, le5Var.m);
                }
            }
            Collections.sort(linkedList, new c(this));
            if (linkedList.size() > this.i) {
                if (this.p) {
                    je5Var = new je5(getContext(), true);
                } else {
                    Context context = getContext();
                    if (this.x) {
                        i = R.drawable.icon_editor_tool_vip;
                    } else {
                        i = -1;
                    }
                    je5Var = new je5(context, i);
                }
                int i3 = this.l;
                if (i3 > 0 && (me5Var = je5Var.m) != null && (me5Var instanceof CommonTabHost)) {
                    ((CommonTabHost) me5Var).setBackgroundColorId(i3);
                }
                if (!SharedPrefHelper.getInstance().getBoolean("key_write_more_tool_point", false)) {
                    je5Var.q = true;
                } else {
                    je5Var.q = false;
                }
                f(je5Var);
                je5Var.m.setToolId(je5Var.c);
                je5Var.m.setEditorTools(this);
                L(je5Var.p, je5Var.c, je5Var.m);
                this.b.e(je5Var.m);
                if (this.j) {
                    linkedList.add(this.i, je5Var);
                } else {
                    linkedList.add(0, je5Var);
                }
            }
            int i4 = this.i + 1;
            Iterator it = linkedList.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                le5 le5Var2 = (le5) it.next();
                if (i5 < i4) {
                    this.a.j(l(le5Var2, 1));
                } else {
                    this.b.d(l(le5Var2, 2));
                }
                i5++;
            }
            if (z) {
                int i6 = this.u;
                if (i6 != 7 && i6 != 9) {
                    fe5Var = new fe5(-1);
                } else {
                    fe5Var = new fe5(7);
                }
                f(fe5Var);
                he5 l = l(fe5Var, 1);
                l.hide();
                this.a.i(0, l);
            }
            this.a.l();
            this.b.f();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.a.setLayoutParams(layoutParams);
            this.b.setLayoutParams(layoutParams2);
            this.b.n();
            if (this.p || this.v) {
                this.a.setPadding(0, 0, 0, 0);
            }
            y();
            removeAllViews();
            if (this.a.getBarLauncherType() != 4 && this.a.getBarLauncherType() != 10) {
                g();
            }
            addView(this.a);
            addView(this.b);
            invalidate();
        }
    }

    public final void i(EditorToolsState editorToolsState, @Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, editorToolsState, spriteMemeInfo) == null) {
            Iterator<de5> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().a(editorToolsState, spriteMemeInfo);
            }
        }
    }

    public void o(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p(z, z2, null);
        }
    }

    public void setActionListener(int i, zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i, zd5Var) == null) {
            L(new int[]{i}, 0, zd5Var);
        }
    }

    public void setToolEnabled(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && !this.a.x(z, i)) {
            this.b.v(z, i);
        }
    }

    public void setViewDisplayTime(long j, long j2) {
        EditorDesk editorDesk;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (editorDesk = this.b) != null) {
            editorDesk.setViewDisplayTime(j, j2);
        }
    }

    public final he5 l(le5 le5Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, le5Var, i)) == null) {
            he5 a2 = ge5.a(getContext(), le5Var, i);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(le5Var.b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.z);
            }
            return a2;
        }
        return (he5) invokeLI.objValue;
    }

    public void setActionListener(int[] iArr, zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, iArr, zd5Var) == null) {
            L(iArr, 0, zd5Var);
        }
    }

    public void w() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.D);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), currentFocus);
            }
            if (!z) {
                le5 u = u(3);
                if (u != null && (u.m instanceof View)) {
                    BdUtilHelper.hideSoftKeyPad(getContext(), (View) u.m);
                }
                le5 u2 = u(28);
                if (u2 != null && (u2.m instanceof View)) {
                    BdUtilHelper.hideSoftKeyPad(getContext(), (View) u2.m);
                }
            }
        }
    }
}
