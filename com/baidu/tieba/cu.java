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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.fw4;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class cu<T extends fw4> implements jt, d26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public it<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public os<T> g;
    public os<T> h;
    public List<vs> i;
    public os<T> j;
    public ArrayList<qs> k;
    public jt l;
    public du m;
    public T n;
    public nu o;
    public int p;
    public nu.a q;

    @Override // com.baidu.tieba.d26
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu a;

        public a(cu cuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cuVar;
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
                    cu cuVar = this.a;
                    cuVar.q(cuVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                cu cuVar2 = this.a;
                cuVar2.q(cuVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public os a;
        public os b;
        public List<vs> c;
        public os d;
        public ArrayList<qs> e;
        public Context f;
        public du g;

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
            du duVar = new du();
            this.g = duVar;
            if (!z) {
                duVar.j(0);
            }
            this.c = new ArrayList();
        }

        public b h(vs vsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vsVar)) == null) {
                this.c.add(vsVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(os osVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, osVar)) == null) {
                this.d = osVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(os osVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, osVar)) == null) {
                this.b = osVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(os osVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, osVar)) == null) {
                this.a = osVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public cu i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new cu(this, (a) null);
            }
            return (cu) invokeV.objValue;
        }

        public du l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (du) invokeV.objValue;
        }

        public cu j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) {
                return new cu(this, supportType, viewGroup, (a) null);
            }
            return (cu) invokeLL.objValue;
        }

        public cu k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vi viVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, viVar)) == null) {
                return new cu(this, supportType, viewGroup, viVar, null);
            }
            return (cu) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cu(b bVar) {
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

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                if (8 != viewGroup.getChildAt(i2).getVisibility()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            if (!z) {
                i = 8;
            }
            viewGroup.setVisibility(i);
        }
    }

    public void p(qs qsVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, qsVar) == null) && qsVar != null && qsVar.getDecorView() != null) {
            this.k.remove(qsVar);
            if (qsVar.getDecorView().getParent() != null) {
                ((ViewGroup) qsVar.getDecorView().getParent()).removeView(qsVar.getDecorView());
                qsVar.onDetachCard();
                qsVar.setThreadCard(null);
            }
        }
    }

    public void r(mm6<T> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mm6Var) == null) {
            os<T> osVar = this.g;
            if (osVar != null) {
                osVar.n(mm6Var);
            }
            os<T> osVar2 = this.h;
            if (osVar2 != null) {
                osVar2.n(mm6Var);
            }
            for (vs vsVar : this.i) {
                if (vsVar != null) {
                    vsVar.n(mm6Var);
                }
            }
            os<T> osVar3 = this.j;
            if (osVar3 != null) {
                osVar3.n(mm6Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cu(b bVar, BaseCardInfo.SupportType supportType) {
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
    public cu(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (vi) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (vi) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ cu(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public cu(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vi viVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, viVar};
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
        this.o = new nu();
        this.p = 0;
        this.q = new nu.a(7);
        this.b = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.thread_card_layout, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.b);
            this.c = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.thread_card_layout, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.d = threadCardView;
        this.e = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.body_root);
        this.f = linearLayout;
        linearLayout.setClipToPadding(false);
        this.g = bVar.a;
        this.h = bVar.b;
        this.i = bVar.c;
        this.j = bVar.d;
        this.k = bVar.e;
        this.m = bVar.g;
        this.d.setParent(viewGroup);
        this.d.setITypeListView(viVar);
        m();
        int dimens = this.m.a() ? BdUtilHelper.getDimens(this.b, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + dimens, marginLayoutParams.topMargin + this.m.j, marginLayoutParams.rightMargin + dimens, marginLayoutParams.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + dimens, marginLayoutParams2.topMargin + this.m.e, marginLayoutParams2.rightMargin + dimens, marginLayoutParams2.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (dimens != 0 && (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + dimens, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + dimens, marginLayoutParams3.bottomMargin);
            this.d.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    public /* synthetic */ cu(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, vi viVar, a aVar) {
        this(bVar, supportType, viewGroup, viVar);
    }

    public /* synthetic */ cu(b bVar, a aVar) {
        this(bVar);
    }

    public void o(int i, nu.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public boolean q(nu.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            return this.o.b(aVar);
        }
        return invokeL.booleanValue;
    }

    public void s(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (threadCardView = this.d) != null) {
            threadCardView.setPosition(i);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.p = i;
        }
    }

    public void c(qs qsVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qsVar) == null) && qsVar != null && qsVar.getDecorView() != null) {
            p(qsVar);
            qsVar.getDecorView().setVisibility(0);
            if (qsVar.getLayoutParams() == null) {
                this.e.addView(qsVar.getDecorView(), qsVar.getInsertIndex());
            } else {
                this.e.addView(qsVar.getDecorView(), qsVar.getInsertIndex(), qsVar.getLayoutParams());
            }
            qsVar.setThreadCard(this);
            qsVar.onAttachCard();
            this.k.add(qsVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qs qsVar = new qs();
            qsVar.setDecorView(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f070387), BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0703ed));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.h;
            qsVar.setLayoutParams(layoutParams);
            qsVar.setInsertIndex(-1);
            this.k.add(qsVar);
        }
    }

    public os<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (os) invokeV.objValue;
    }

    public os<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (os) invokeV.objValue;
    }

    public Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public T i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (T) invokeV.objValue;
    }

    public List<vs> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                return frameLayout;
            }
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.m == null) {
            return;
        }
        if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            du duVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(duVar.g, duVar.d, duVar.h, duVar.f);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        os<T> osVar = this.g;
        if (osVar != null) {
            osVar.k(this);
            this.f.addView(this.g.g());
            this.g.h();
        }
        os<T> osVar2 = this.h;
        if (osVar2 != null) {
            osVar2.k(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.f().booleanValue()) {
                du duVar2 = this.m;
                layoutParams.leftMargin = -duVar2.g;
                layoutParams.rightMargin = -duVar2.h;
            }
            this.f.addView(this.h.g(), layoutParams);
            this.h.h();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                vs vsVar = this.i.get(i);
                if (vsVar != null) {
                    vsVar.k(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = vsVar.s();
                    layoutParams2.bottomMargin = vsVar.r();
                    if (vsVar.f().booleanValue()) {
                        du duVar3 = this.m;
                        layoutParams2.leftMargin = -duVar3.g;
                        layoutParams2.rightMargin = -duVar3.h;
                    }
                    this.f.addView(vsVar.g(), layoutParams2);
                    vsVar.h();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.k(this);
            this.f.addView(this.j.g(), layoutParams3);
            this.j.h();
        }
        if (!ListUtils.isEmpty(this.k)) {
            Iterator<qs> it = this.k.iterator();
            while (it.hasNext()) {
                qs next = it.next();
                if (next != null && next.getDecorView() != null) {
                    if (next.getLayoutParams() == null) {
                        this.e.addView(next.getDecorView(), next.getInsertIndex());
                    } else {
                        this.e.addView(next.getDecorView(), next.getInsertIndex(), next.getLayoutParams());
                    }
                    next.setThreadCard(this);
                    next.onAttachCard();
                }
            }
        }
    }

    public void n(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            this.n = t;
            if (t.isHighLight()) {
                this.m.i = R.color.CAM_X0313;
            } else {
                this.m.i = R.color.CAM_X0205;
            }
            if (this.g != null) {
                this.d.setTag(R.id.virtual_image_user_head, null);
                this.g.onBindDataToView(t);
                os<T> osVar = this.g;
                if (osVar instanceof jdb) {
                    this.d.setTag(R.id.virtual_image_user_head, osVar);
                }
            }
            os<T> osVar2 = this.h;
            if (osVar2 != null) {
                osVar2.onBindDataToView(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    vs vsVar = this.i.get(i);
                    vsVar.onBindDataToView(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(vsVar.g(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            os<T> osVar3 = this.j;
            if (osVar3 != null) {
                osVar3.onBindDataToView(t);
            }
            it<T> itVar = this.a;
            if (itVar != null) {
                itVar.onBindDataToView(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.i);
            }
            os<T> osVar = this.g;
            if (osVar != null) {
                osVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    EMManager.from(this.d).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            os<T> osVar2 = this.h;
            if (osVar2 != null) {
                osVar2.onChangeSkinType(tbPageContext, i);
            }
            for (vs vsVar : this.i) {
                if (vsVar != null) {
                    vsVar.onChangeSkinType(tbPageContext, i);
                }
            }
            os<T> osVar3 = this.j;
            if (osVar3 != null) {
                osVar3.onChangeSkinType(tbPageContext, i);
                if (this.g == null && ((t = this.n) == null || !t.isSupportContent())) {
                    EMManager.from(this.d).setCardType(2).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            if (this.g != null && this.j != null) {
                EMManager.from(this.d).setCorner(R.string.J_X06).setBackGroundSelectorColor(this.m.i, R.color.CAM_X0206);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
            }
            if (!ListUtils.isEmpty(this.k)) {
                Iterator<qs> it = this.k.iterator();
                while (it.hasNext()) {
                    qs next = it.next();
                    if (next != null && (next instanceof jt)) {
                        ((jt) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            jt jtVar = this.l;
            if (jtVar != null) {
                jtVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
