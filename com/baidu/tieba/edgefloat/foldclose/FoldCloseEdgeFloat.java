package com.baidu.tieba.edgefloat.foldclose;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.aja;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.foldclose.FoldCloseEdgeFloat;
import com.baidu.tieba.mx6;
import com.baidu.tieba.nx6;
import com.baidu.tieba.qx6;
import com.baidu.tieba.view.foldclose.FoldCloseView;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020 R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006)"}, d2 = {"Lcom/baidu/tieba/edgefloat/foldclose/FoldCloseEdgeFloat;", "", "builder", "Lcom/baidu/tieba/edgefloat/foldclose/FoldCloseEdgeFloat$Builder;", "(Lcom/baidu/tieba/edgefloat/foldclose/FoldCloseEdgeFloat$Builder;)V", "edgeFloat", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "getEdgeFloat", "()Lcom/baidu/tieba/edgefloat/EdgeFloat;", "edgeFloat$delegate", "Lkotlin/Lazy;", "foldCloseView", "Lcom/baidu/tieba/view/foldclose/FoldCloseView;", "getFoldCloseView", "()Lcom/baidu/tieba/view/foldclose/FoldCloseView;", "foldCloseView$delegate", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "getOnCloseClickListener", "()Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "(Landroid/view/View$OnClickListener;)V", "onFoldStateChangeListener", "Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;", "getOnFoldStateChangeListener", "()Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;", "setOnFoldStateChangeListener", "(Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;)V", "onOtherClickListener", "getOnOtherClickListener", "setOnOtherClickListener", "hide", "", "isFolded", "", "isShowing", "setChildView", "childView", "Landroid/view/View;", "show", "Builder", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FoldCloseEdgeFloat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;
    public View.OnClickListener b;
    public aja c;
    public final Lazy d;
    public final Lazy e;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public View b;
        public final ArrayList<String> c;

        public a(Activity activity, View childView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, childView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(childView, "childView");
            this.a = activity;
            this.b = childView;
            this.c = new ArrayList<>();
        }

        public final FoldCloseEdgeFloat a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FoldCloseEdgeFloat foldCloseEdgeFloat = new FoldCloseEdgeFloat(this);
                foldCloseEdgeFloat.k(this.b);
                return foldCloseEdgeFloat;
            }
            return (FoldCloseEdgeFloat) invokeV.objValue;
        }

        public final Activity b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (Activity) invokeV.objValue;
        }

        public final ArrayList<String> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return (ArrayList) invokeV.objValue;
        }

        public final a d(List<String> pageNoSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pageNoSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
                this.c.clear();
                this.c.addAll(pageNoSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public FoldCloseEdgeFloat(final a builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<EdgeFloat>(builder, this) { // from class: com.baidu.tieba.edgefloat.foldclose.FoldCloseEdgeFloat$edgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ FoldCloseEdgeFloat.a $builder;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FoldCloseEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {builder, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$builder = builder;
                this.this$0 = this;
            }

            /* loaded from: classes5.dex */
            public static final class a implements mx6 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FoldCloseEdgeFloat a;

                public a(FoldCloseEdgeFloat foldCloseEdgeFloat) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {foldCloseEdgeFloat};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = foldCloseEdgeFloat;
                }

                @Override // com.baidu.tieba.mx6
                public void onChangeSkinType(int i) {
                    FoldCloseView d;
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                        return;
                    }
                    d = this.a.d();
                    d.onChangeSkinType(i);
                }
            }

            /* loaded from: classes5.dex */
            public static final class b implements nx6 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FoldCloseEdgeFloat a;

                public b(FoldCloseEdgeFloat foldCloseEdgeFloat) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {foldCloseEdgeFloat};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = foldCloseEdgeFloat;
                }

                @Override // com.baidu.tieba.nx6
                public void dispatchTouchEvent(MotionEvent ev) {
                    FoldCloseView d;
                    FoldCloseView d2;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, ev) == null) {
                        Intrinsics.checkNotNullParameter(ev, "ev");
                        d = this.a.d();
                        if (d.e() || ev.getAction() != 0) {
                            return;
                        }
                        d2 = this.a.d();
                        d2.c();
                    }
                }

                @Override // com.baidu.tieba.nx6
                public void onBackPressed() {
                    FoldCloseView d;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        d = this.a.d();
                        d.f();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EdgeFloat invoke() {
                InterceptResult invokeV;
                FoldCloseView d;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    int l = xi.l(this.$builder.b());
                    int j = xi.j(this.$builder.b());
                    int u = xi.u(this.$builder.b());
                    int b2 = (l - qx6.a.b()) - (qx6.a.c() * 2);
                    int normalMainTabBarHeight = TbadkCoreApplication.getInst().getNormalMainTabBarHeight() + xi.g(this.$builder.b(), R.dimen.tbds177);
                    EdgeFloat.a aVar = new EdgeFloat.a(this.$builder.b());
                    d = this.this$0.d();
                    aVar.M(d);
                    aVar.I(b2);
                    aVar.J(j - qx6.a.a());
                    aVar.z(qx6.a.b() + (qx6.a.c() * 2));
                    aVar.N(qx6.a.b() + (qx6.a.c() * 2));
                    aVar.E(j);
                    aVar.F(l);
                    aVar.K(u);
                    aVar.L(xi.g(this.$builder.b(), R.dimen.tbds352));
                    aVar.b(normalMainTabBarHeight);
                    aVar.a(xi.g(this.$builder.b(), R.dimen.tbds450) + xi.g(this.$builder.b(), R.dimen.M_H_X002));
                    aVar.C(this.$builder.c());
                    aVar.B(new a(this.this$0));
                    aVar.A(new b(this.this$0));
                    return aVar.c();
                }
                return (EdgeFloat) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new FoldCloseEdgeFloat$foldCloseView$2(this));
    }

    public final void k(View childView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, childView) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            d().setChild(childView, qx6.a.b(), qx6.a.b());
        }
    }

    public final void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.a = onClickListener;
        }
    }

    public final void m(aja ajaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ajaVar) == null) {
            this.c = ajaVar;
        }
    }

    public final void n(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public final EdgeFloat c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (EdgeFloat) this.d.getValue();
        }
        return (EdgeFloat) invokeV.objValue;
    }

    public final FoldCloseView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (FoldCloseView) this.e.getValue();
        }
        return (FoldCloseView) invokeV.objValue;
    }

    public final View.OnClickListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final aja f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (aja) invokeV.objValue;
    }

    public final View.OnClickListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c().k();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return d().e();
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return c().o();
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c().D();
        }
    }
}
