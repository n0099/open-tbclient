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
import c.a.d.f.p.l;
import c.a.q0.x.f;
import c.a.q0.x.g;
import c.a.q0.x.h;
import c.a.q0.x.j;
import c.a.q0.x.m;
import c.a.q0.x.n;
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
/* loaded from: classes9.dex */
public class EditorTools extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BAR_LAUNCHER_TYPE_BIG = 0;
    public static final int BAR_LAUNCHER_TYPE_BJH = 5;
    public static final int BAR_LAUNCHER_TYPE_NEW_PB = 3;
    public static final int BAR_LAUNCHER_TYPE_NEW_SUB_PB = 2;
    public static final int BAR_LAUNCHER_TYPE_SMALL = 1;
    public static final int BAR_LAUNCHER_TYPE_VIDEO_PLAY = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f41737e;

    /* renamed from: f  reason: collision with root package name */
    public View f41738f;

    /* renamed from: g  reason: collision with root package name */
    public List<m> f41739g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<c.a.q0.x.b> f41740h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<HashSet<c.a.q0.x.b>> f41741i;

    /* renamed from: j  reason: collision with root package name */
    public SparseArray<HashSet<Integer>> f41742j;

    /* renamed from: k  reason: collision with root package name */
    public int f41743k;
    public boolean l;
    public int m;
    public EditorBar mEB;
    public EditorDesk mED;
    public int n;
    public boolean o;
    public LinkedList<h> p;
    public boolean q;
    public boolean r;
    public Context s;
    public String t;
    public long u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public Runnable x;
    public List<Integer> y;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f41744e;

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
            this.f41744e = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41744e.performLauncherClick(view);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f41745e;

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
            this.f41745e = editorTools;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41745e.displaySoftKey();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Comparator<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f41746e;

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
            this.f41746e = editorTools;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m mVar, m mVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, mVar2)) == null) ? mVar.f13697j - mVar2.f13697j : invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorTools f41747e;

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
            this.f41747e = editorTools;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41747e.w == null) {
                return;
            }
            this.f41747e.w.onClick(view);
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
        this.f41743k = 1;
        this.l = false;
        this.m = 0;
        this.n = 0;
        this.o = true;
        this.q = false;
        this.r = false;
        this.v = new a(this);
        this.x = new b(this);
        this.y = new ArrayList();
        f(context);
    }

    public void addHideLauncher(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) || mVar == null) {
            return;
        }
        addTool(mVar);
        h e2 = e(mVar, 1);
        e2.hide();
        EditorBar editorBar = this.mEB;
        if (editorBar != null) {
            editorBar.addLauncher(0, e2);
            this.mEB.removeAllViews();
            this.mEB.build();
        }
        invalidate();
    }

    public void addOutLauncher(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            this.p.add(hVar);
        }
    }

    public void addTool(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f41739g.add(mVar);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View view = this.f41738f;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f41738f = view2;
                SkinManager.setBackgroundResource(view2, R.color.transparent);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                this.f41738f.setLayoutParams(layoutParams);
                this.f41738f.setOnClickListener(new d(this));
            }
            addView(this.f41738f, 0);
        }
    }

    public void build() {
        List<m> list;
        j jVar;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.f41739g) == null || list.size() == 0) {
            return;
        }
        d();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (m mVar : this.f41739g) {
            if (mVar.f13691d > 0) {
                linkedList.add(mVar);
            }
            n nVar2 = mVar.f13698k;
            if (nVar2 != null) {
                nVar2.setToolId(mVar.f13690c);
                mVar.f13698k.setEditorTools(this);
                int i2 = mVar.l;
                if (i2 == 6) {
                    this.mED.addToolView(mVar.f13698k);
                } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                    this.mEB.addToolView(mVar.f13698k, mVar.l, !mVar.m);
                    if (mVar.l == 5 && findToolById(1) == null) {
                        z = true;
                    }
                }
                setActionListener(mVar.n, mVar.f13690c, mVar.f13698k);
            }
        }
        Collections.sort(linkedList, new c(this));
        if (linkedList.size() > this.f41743k) {
            if (this.r) {
                jVar = new j(getContext(), true);
            } else {
                jVar = new j(getContext());
            }
            int i3 = this.n;
            if (i3 > 0 && (nVar = jVar.f13698k) != null && (nVar instanceof CommonTabHost)) {
                ((CommonTabHost) nVar).setBackgroundColorId(i3);
            }
            if (!c.a.q0.s.e0.b.j().g("key_write_more_tool_point", false)) {
                jVar.o = true;
            } else {
                jVar.o = false;
            }
            addTool(jVar);
            jVar.f13698k.setToolId(jVar.f13690c);
            jVar.f13698k.setEditorTools(this);
            setActionListener(jVar.n, jVar.f13690c, jVar.f13698k);
            this.mED.addToolView(jVar.f13698k);
            if (this.l) {
                linkedList.add(this.f41743k, jVar);
            } else {
                linkedList.add(0, jVar);
            }
        }
        int i4 = this.f41743k + 1;
        Iterator it = linkedList.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (i5 < i4) {
                this.mEB.addLauncher(e(mVar2, 1));
            } else {
                this.mED.addLauncher(e(mVar2, 2));
            }
            i5++;
        }
        if (z) {
            f fVar = new f();
            addTool(fVar);
            h e2 = e(fVar, 1);
            e2.hide();
            this.mEB.addLauncher(0, e2);
        }
        this.mEB.build();
        this.mED.build();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.mEB.setLayoutParams(layoutParams);
        this.mED.setLayoutParams(layoutParams2);
        this.mED.hide();
        if (this.r) {
            this.mEB.setPadding(0, 0, 0, 0);
        }
        hideTools();
        removeAllViews();
        if (this.mEB.getBarLauncherType() != 4) {
            c();
        }
        addView(this.mEB);
        addView(this.mED);
        invalidate();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View view = this.f41737e;
            if (view == null || view.getParent() != null) {
                View view2 = new View(getContext());
                this.f41737e = view2;
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(view2);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
                this.f41737e.setLayoutParams(new RelativeLayout.LayoutParams(-1, l.f(getContext(), R.dimen.L_X01)));
            }
            addView(this.f41737e);
        }
    }

    public void clearTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f41739g.clear();
            this.f41740h.clear();
            this.f41741i.clear();
            this.f41742j.clear();
        }
    }

    public void collect(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.y.clear();
            this.y.addAll(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mEB.clear();
            this.mED.clear();
        }
    }

    public void display(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            for (m mVar : this.f41739g) {
                if (mVar != null) {
                    n nVar = mVar.f13698k;
                    if ((nVar instanceof View) && ((View) nVar).getVisibility() == 0 && !mVar.m) {
                        mVar.f13698k.display();
                    }
                }
            }
            if (this.o) {
                this.o = false;
                hideTools();
            }
            if (!isToolVisible() && z) {
                e.a().postDelayed(this.x, 200L);
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public void displaySoftKey() {
        m findToolById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (findToolById = findToolById(3)) == null) {
            return;
        }
        n nVar = findToolById.f13698k;
        if (nVar instanceof View) {
            View view = (View) nVar;
            view.requestFocus();
            l.K(getContext(), view);
        }
    }

    public void displayTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mED.display();
        }
    }

    public void displayWithoutSoftKey() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (m mVar : this.f41739g) {
                if (mVar != null) {
                    n nVar = mVar.f13698k;
                    if ((nVar instanceof View) && ((View) nVar).getVisibility() == 0 && !mVar.m) {
                        mVar.f13698k.display();
                    }
                }
            }
            setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
        }
    }

    public final h e(m mVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, mVar, i2)) == null) {
            h a2 = g.a(getContext(), mVar, i2);
            if (a2 instanceof View) {
                ((View) a2).setContentDescription(mVar.f13689b);
            }
            if (a2 instanceof BLauncher) {
                ((View) a2).setOnClickListener(this.v);
            }
            return a2;
        }
        return (h) invokeLI.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.s = context;
            this.f41739g = new LinkedList();
            this.f41740h = new SparseArray<>();
            this.f41741i = new SparseArray<>();
            this.f41742j = new SparseArray<>();
            this.mEB = new EditorBar(context, this);
            this.mED = new EditorDesk(context, this);
            this.p = new LinkedList<>();
            setOrientation(1);
        }
    }

    public h findLauncherById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            h findLauncherById = this.mEB.findLauncherById(i2);
            return findLauncherById != null ? findLauncherById : this.mED.findLauncherById(i2);
        }
        return (h) invokeI.objValue;
    }

    public m findToolById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            for (m mVar : this.f41739g) {
                if (mVar.f13690c == i2) {
                    return mVar;
                }
            }
            return null;
        }
        return (m) invokeI.objValue;
    }

    public List<m> getAllTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f41739g : (List) invokeV.objValue;
    }

    public List<Integer> getCollectTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.y : (List) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.u : invokeV.longValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            hideTools();
            setVisibility(8);
            hideSoftKey();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
        }
    }

    public void hideSoftKey() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e.a().removeCallbacks(this.x);
            boolean z = false;
            if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
                z = true;
                l.w(getContext(), currentFocus);
            }
            if (z) {
                return;
            }
            m findToolById = findToolById(3);
            if (findToolById != null && (findToolById.f13698k instanceof View)) {
                l.w(getContext(), (View) findToolById.f13698k);
            }
            m findToolById2 = findToolById(28);
            if (findToolById2 == null || !(findToolById2.f13698k instanceof View)) {
                return;
            }
            l.w(getContext(), (View) findToolById2.f13698k);
        }
    }

    public void hideTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mED.hide();
            this.mEB.changeToLauncher(null);
        }
    }

    public boolean isHideBigEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean isIsFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean isToolVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mED.isToolVisible() : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            SkinManager.setBackgroundColor(this, this.m, i2);
            this.mEB.onChangeSkinType(i2);
            this.mED.onChangeSkinType(i2);
            View view = this.f41737e;
            if (view != null) {
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(view);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0210);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void performLauncherClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, view) == null) && (view instanceof h)) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m findToolById = findToolById(toolId);
            if (findToolById.a()) {
                sendAction(new c.a.q0.x.a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.mEB.changeToLauncher(findToolById);
                if (hVar.getToolId() == 2 && !c.a.q0.s.e0.b.j().g("key_write_more_tool_point", false)) {
                    c.a.q0.s.e0.b.j().t("key_write_more_tool_point", true);
                    hVar.hideRedPoint();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    sendAction(new c.a.q0.x.a(1, 3, null));
                } else if (findToolById.f13698k == null) {
                    int[] iArr = findToolById.n;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    sendAction(new c.a.q0.x.a(iArr[0], -1, null));
                } else {
                    sendAction(new c.a.q0.x.a(1, toolId, null));
                }
            }
        }
    }

    public void removeTools(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, iArr) == null) || iArr == null || iArr.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > 0) {
                this.f41739g.remove(iArr[i2]);
            }
        }
    }

    public void resetChangeToLauncher() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mEB.changeToLauncher(null);
        }
    }

    public void resetLaunchers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mEB.resetLaunchers(this.v);
        }
    }

    public void sendAction(c.a.q0.x.a aVar) {
        HashSet<Integer> hashSet;
        int i2;
        m findToolById;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) || aVar == null) {
            return;
        }
        int i3 = aVar.a;
        if (i3 == 2) {
            boolean z = false;
            h findLauncherById = this.mEB.findLauncherById(aVar.f13678b);
            if (findLauncherById == null) {
                findLauncherById = this.mED.findLauncherById(aVar.f13678b);
                z = true;
            }
            if (findLauncherById == null) {
                Iterator<h> it = this.p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.getToolId() == aVar.f13678b) {
                        findLauncherById = next;
                        break;
                    }
                }
            }
            if (findLauncherById != null) {
                findLauncherById.onAction(aVar);
                if (!z || (findToolById = findToolById(2)) == null || (nVar = findToolById.f13698k) == null) {
                    return;
                }
                nVar.onAction(aVar);
            }
        } else if (i3 == 5) {
            this.mEB.changeToLauncher(null);
            this.mED.changeToKeyboard();
        } else {
            int i4 = aVar.f13678b;
            if (i4 > 0) {
                c.a.q0.x.b bVar = this.f41740h.get(i4);
                if (bVar != null) {
                    int i5 = aVar.a;
                    if (i5 != 19 && i5 != 20 && (i2 = aVar.f13678b) != 27) {
                        this.mEB.changeToTool(i2);
                    }
                    m findToolById2 = findToolById(aVar.f13678b);
                    if (findToolById2 != null && findToolById2.l == 5) {
                        hideTools();
                        hideSoftKey();
                    } else {
                        this.mED.changeToTool(aVar.f13678b);
                    }
                    bVar.onAction(aVar);
                }
            } else if (i4 <= 0) {
                if (i4 < 0 && (hashSet = this.f41742j.get(i3)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        c.a.q0.x.b bVar2 = this.f41740h.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.onAction(aVar);
                        }
                    }
                }
                HashSet<c.a.q0.x.b> hashSet2 = this.f41741i.get(aVar.a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<c.a.q0.x.b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(aVar);
                    }
                }
            }
            if (this.s.getClass().getSimpleName().equals("WriteActivity")) {
                BLauncher bLauncher = (BLauncher) this.mEB.findLauncherById(2);
                if (bLauncher != null) {
                    showTips(bLauncher);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void setActionListener(int i2, c.a.q0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i2, bVar) == null) {
            setActionListener(new int[]{i2}, 0, bVar);
        }
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.m = i2;
            if (i2 != 0) {
                setBackgroundColor(getContext().getResources().getColor(i2));
            }
        }
    }

    public void setBarBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.mEB.setBackgroundColorId(i2);
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.mEB.setBarLauncherEnabled(z);
        }
    }

    public void setBarLauncherType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mEB.setBarLauncherType(i2);
        }
    }

    public void setBarMaxLauCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.f41743k = i2;
        }
    }

    public void setDeskBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.mED.setBackgroundColorId(i2);
        }
    }

    public void setDeskLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mED.setDeskLauncherEnabled(z);
        }
    }

    public void setFid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j2) == null) {
            this.u = j2;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
        }
    }

    public void setHideBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.q = z;
        }
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.r = z;
        }
    }

    public void setMoreButtonAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.l = z;
        }
    }

    public void setMoreDeskBgColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.w = onClickListener;
            b();
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.t = str;
        }
    }

    public void setToolEnabled(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.mEB.setBarLauncherEnabled(z, i2)) {
            return;
        }
        this.mED.setDeskLauncherEnabled(z, i2);
    }

    public void showLinePositionBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.mEB.showLinePositionBottom(z);
        }
    }

    public void showLinePositionTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mEB.showLinePositionTop(z);
        }
    }

    public void showNoLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.mEB.showNoLine(false);
        }
    }

    public void showTips(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, view) == null) {
            BaseActivity baseActivity = (BaseActivity) this.s;
            c.a.r0.k0.g gVar = new c.a.r0.k0.g(baseActivity.getPageContext(), view);
            gVar.g0(R.drawable.bg_tip_blue_down_right);
            gVar.O(48);
            gVar.U(true);
            gVar.L(2);
            gVar.h0(true);
            gVar.k0(l.f(baseActivity, R.dimen.tbds_21));
            gVar.j0(l.f(baseActivity, R.dimen.tbds0));
            gVar.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds26));
            gVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds44));
            gVar.N((int) 3000);
            gVar.n0(baseActivity.getString(R.string.user_associate_item_prompt), "write_associate_item_hint_tip_key", true);
        }
    }

    public void setActionListener(int[] iArr, c.a.q0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, iArr, bVar) == null) {
            setActionListener(iArr, 0, bVar);
        }
    }

    public void setActionListener(int[] iArr, int i2, c.a.q0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048613, this, iArr, i2, bVar) == null) {
            int i3 = 0;
            if (i2 == 0) {
                if (iArr == null || iArr.length == 0) {
                    return;
                }
                HashSet<c.a.q0.x.b> hashSet = this.f41741i.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i3 < length) {
                        this.f41741i.put(iArr[i3], hashSet);
                        i3++;
                    }
                }
                hashSet.add(bVar);
            } else if (i2 > 0) {
                this.f41740h.put(i2, bVar);
                if (iArr == null || iArr.length <= 0) {
                    return;
                }
                int length2 = iArr.length;
                while (i3 < length2) {
                    int i4 = iArr[i3];
                    HashSet<Integer> hashSet2 = this.f41742j.get(i4);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.f41742j.put(i4, hashSet2);
                    }
                    hashSet2.add(Integer.valueOf(i2));
                    i3++;
                }
            }
        }
    }

    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            display(true);
        }
    }
}
