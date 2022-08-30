package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ho4;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ey<T extends ho4> implements jx, wl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ix<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public sw<T> g;
    public sw<T> h;
    public List<zw> i;
    public sw<T> j;
    public ArrayList<uw> k;
    public jx l;
    public fy m;
    public T n;
    public py o;
    public int p;
    public py.a q;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;

        public a(ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                        }
                    }
                    this.a.q.d(Boolean.FALSE);
                    ey eyVar = this.a;
                    eyVar.o(eyVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                ey eyVar2 = this.a;
                eyVar2.o(eyVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ ey(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.baidu.tieba.wl5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(uw uwVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uwVar) == null) || uwVar == null || uwVar.b() == null) {
            return;
        }
        n(uwVar);
        uwVar.b().setVisibility(0);
        if (uwVar.d() == null) {
            this.e.addView(uwVar.b(), uwVar.c());
        } else {
            this.e.addView(uwVar.b(), uwVar.c(), uwVar.d());
        }
        uwVar.j(this);
        uwVar.e();
        this.k.add(uwVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            uw uwVar = new uw();
            uwVar.g(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ri.f(this.b, R.dimen.obfuscated_res_0x7f070260), ri.f(this.b, R.dimen.obfuscated_res_0x7f0702d2));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.g;
            uwVar.i(layoutParams);
            uwVar.h(-1);
            this.k.add(uwVar);
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                z = 8 != viewGroup.getChildAt(i).getVisibility();
                if (z) {
                    break;
                }
            }
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public sw<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (sw) invokeV.objValue;
    }

    public sw<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (sw) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    public List<zw> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout frameLayout = this.c;
            return frameLayout != null ? frameLayout : this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.m == null) {
            return;
        }
        if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            fy fyVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(fyVar.f, fyVar.d, fyVar.g, fyVar.e);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        sw<T> swVar = this.g;
        if (swVar != null) {
            swVar.k(this);
            this.f.addView(this.g.h());
            this.g.i();
        }
        sw<T> swVar2 = this.h;
        if (swVar2 != null) {
            swVar2.k(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.g().booleanValue()) {
                fy fyVar2 = this.m;
                layoutParams.leftMargin = -fyVar2.f;
                layoutParams.rightMargin = -fyVar2.g;
            }
            this.f.addView(this.h.h(), layoutParams);
            this.h.i();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                zw zwVar = this.i.get(i);
                if (zwVar != null) {
                    zwVar.k(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = zwVar.q();
                    layoutParams2.bottomMargin = zwVar.p();
                    if (zwVar.g().booleanValue()) {
                        fy fyVar3 = this.m;
                        layoutParams2.leftMargin = -fyVar3.f;
                        layoutParams2.rightMargin = -fyVar3.g;
                    }
                    this.f.addView(zwVar.h(), layoutParams2);
                    zwVar.i();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.k(this);
            this.f.addView(this.j.h(), layoutParams3);
            this.j.i();
        }
        if (ListUtils.isEmpty(this.k)) {
            return;
        }
        Iterator<uw> it = this.k.iterator();
        while (it.hasNext()) {
            uw next = it.next();
            if (next != null && next.b() != null) {
                if (next.d() == null) {
                    this.e.addView(next.b(), next.c());
                } else {
                    this.e.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            this.n = t;
            if (t.isHighLight()) {
                this.m.h = R.color.CAM_X0313;
            } else {
                this.m.h = R.color.CAM_X0205;
            }
            if (this.g != null) {
                this.d.setTag(R.id.obfuscated_res_0x7f0925ab, null);
                this.g.a(t);
                sw<T> swVar = this.g;
                if (swVar instanceof ez8) {
                    this.d.setTag(R.id.obfuscated_res_0x7f0925ab, swVar);
                }
            }
            sw<T> swVar2 = this.h;
            if (swVar2 != null) {
                swVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    zw zwVar = this.i.get(i);
                    zwVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(zwVar.h(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            sw<T> swVar3 = this.j;
            if (swVar3 != null) {
                swVar3.a(t);
            }
            ix<T> ixVar = this.a;
            if (ixVar != null) {
                ixVar.a(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    public void m(int i, py.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public void n(uw uwVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, uwVar) == null) || uwVar == null || uwVar.b() == null) {
            return;
        }
        this.k.remove(uwVar);
        if (uwVar.b().getParent() != null) {
            ((ViewGroup) uwVar.b().getParent()).removeView(uwVar.b());
            uwVar.f();
            uwVar.j(null);
        }
    }

    public boolean o(py.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.o.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.h);
            }
            sw<T> swVar = this.g;
            if (swVar != null) {
                swVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    os4 d = os4.d(this.d);
                    d.m(1);
                    d.n(R.string.J_X06);
                    d.f(this.m.h);
                }
            }
            sw<T> swVar2 = this.h;
            if (swVar2 != null) {
                swVar2.onChangeSkinType(tbPageContext, i);
            }
            for (zw zwVar : this.i) {
                if (zwVar != null) {
                    zwVar.onChangeSkinType(tbPageContext, i);
                }
            }
            sw<T> swVar3 = this.j;
            if (swVar3 != null) {
                swVar3.onChangeSkinType(tbPageContext, i);
                if (this.g == null && ((t = this.n) == null || !t.isSupportContent())) {
                    os4 d2 = os4.d(this.d);
                    d2.m(2);
                    d2.n(R.string.J_X06);
                    d2.f(this.m.h);
                }
            }
            if (this.g != null && this.j != null) {
                os4 d3 = os4.d(this.d);
                d3.n(R.string.J_X06);
                d3.i(this.m.h, R.color.CAM_X0206);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
            }
            if (!ListUtils.isEmpty(this.k)) {
                Iterator<uw> it = this.k.iterator();
                while (it.hasNext()) {
                    uw next = it.next();
                    if (next != null && (next instanceof jx)) {
                        ((jx) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            jx jxVar = this.l;
            if (jxVar != null) {
                jxVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void p(j06<T> j06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, j06Var) == null) {
            sw<T> swVar = this.g;
            if (swVar != null) {
                swVar.m(j06Var);
            }
            sw<T> swVar2 = this.h;
            if (swVar2 != null) {
                swVar2.m(j06Var);
            }
            for (zw zwVar : this.i) {
                if (zwVar != null) {
                    zwVar.m(j06Var);
                }
            }
            sw<T> swVar3 = this.j;
            if (swVar3 != null) {
                swVar3.m(j06Var);
            }
        }
    }

    public void q(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (threadCardView = this.d) == null) {
            return;
        }
        threadCardView.setPosition(i);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.p = i;
        }
    }

    public /* synthetic */ ey(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vn vnVar, a aVar) {
        this(bVar, supportType, viewGroup, vnVar);
    }

    public /* synthetic */ ey(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ey(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ey(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ey(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (vn) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (vn) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ey(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vn vnVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, vnVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = null;
        this.l = null;
        this.o = new py();
        this.p = 0;
        this.q = new py.a(7);
        this.b = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0865, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.b);
            this.c = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0865, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f09212d);
        this.d = threadCardView;
        this.e = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904ee);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0903ab);
        this.f = linearLayout;
        linearLayout.setClipToPadding(false);
        this.g = bVar.a;
        this.h = bVar.b;
        this.i = bVar.c;
        this.j = bVar.d;
        this.k = bVar.e;
        this.m = bVar.g;
        this.d.setParent(viewGroup);
        this.d.setITypeListView(vnVar);
        k();
        int f = this.m.a() ? ri.f(this.b, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + f, marginLayoutParams.topMargin + this.m.i, marginLayoutParams.rightMargin + f, marginLayoutParams.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + f, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + f, marginLayoutParams2.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (f != 0 && (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + f, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + f, marginLayoutParams3.bottomMargin);
            this.d.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public sw a;
        public sw b;
        public List<zw> c;
        public sw d;
        public ArrayList<uw> e;
        public Context f;
        public fy g;

        public b(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.d = null;
            this.f = context;
            this.e = new ArrayList<>();
            fy fyVar = new fy();
            this.g = fyVar;
            if (!z) {
                fyVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(zw zwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zwVar)) == null) {
                this.c.add(zwVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ey i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ey(this, (a) null) : (ey) invokeV.objValue;
        }

        public ey j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new ey(this, supportType, viewGroup, (a) null) : (ey) invokeLL.objValue;
        }

        public ey k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vn vnVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, vnVar)) == null) ? new ey(this, supportType, viewGroup, vnVar, null) : (ey) invokeLLL.objValue;
        }

        public fy l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (fy) invokeV.objValue;
        }

        public b m(sw swVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, swVar)) == null) {
                this.d = swVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(sw swVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, swVar)) == null) {
                this.b = swVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(sw swVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, swVar)) == null) {
                this.a = swVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            this(context, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
