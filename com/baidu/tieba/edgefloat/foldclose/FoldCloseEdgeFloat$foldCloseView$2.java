package com.baidu.tieba.edgefloat.foldclose;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.foldclose.FoldCloseEdgeFloat;
import com.baidu.tieba.edgefloat.foldclose.FoldCloseEdgeFloat$foldCloseView$2;
import com.baidu.tieba.ix6;
import com.baidu.tieba.oqa;
import com.baidu.tieba.pqa;
import com.baidu.tieba.qqa;
import com.baidu.tieba.view.foldclose.FoldCloseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/view/foldclose/FoldCloseView;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FoldCloseEdgeFloat$foldCloseView$2 extends Lambda implements Function0<FoldCloseView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FoldCloseEdgeFloat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldCloseEdgeFloat$foldCloseView$2(FoldCloseEdgeFloat foldCloseEdgeFloat) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCloseEdgeFloat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = foldCloseEdgeFloat;
    }

    /* loaded from: classes5.dex */
    public static final class a implements pqa {
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

        @Override // com.baidu.tieba.pqa
        public void a(int i, int i2) {
            EdgeFloat c;
            EdgeFloat c2;
            EdgeFloat c3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                c = this.a.c();
                if (c.m()) {
                    c3 = this.a.c();
                    c3.s(0);
                    return;
                }
                c2 = this.a.c();
                c2.s(i - i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements qqa {
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

        @Override // com.baidu.tieba.qqa
        public void a(boolean z) {
            qqa f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (f = this.a.f()) != null) {
                f.a(z);
            }
        }
    }

    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m132invoke$lambda2$lambda0(FoldCloseView this_apply, FoldCloseEdgeFloat this$0, View view2) {
        EdgeFloat c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this_apply, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this_apply.e()) {
                c = this$0.c();
                c.k();
            }
            View.OnClickListener e = this$0.e();
            if (e != null) {
                e.onClick(view2);
            }
        }
    }

    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m133invoke$lambda2$lambda1(FoldCloseEdgeFloat this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View.OnClickListener g = this$0.g();
            if (g != null) {
                g.onClick(view2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FoldCloseView invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getInst().context");
            final FoldCloseView foldCloseView = new FoldCloseView(context);
            final FoldCloseEdgeFloat foldCloseEdgeFloat = this.this$0;
            oqa oqaVar = new oqa();
            oqaVar.e(ix6.a.b());
            oqaVar.g(ix6.a.d());
            oqaVar.f(ix6.a.c());
            foldCloseView.setData(oqaVar);
            foldCloseView.setOnCloseClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hx6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FoldCloseEdgeFloat$foldCloseView$2.m132invoke$lambda2$lambda0(FoldCloseView.this, foldCloseEdgeFloat, view2);
                    }
                }
            });
            foldCloseView.setOnFoldCloseWidthChangeListener(new a(foldCloseEdgeFloat));
            foldCloseView.setOnOtherClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gx6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FoldCloseEdgeFloat$foldCloseView$2.m133invoke$lambda2$lambda1(FoldCloseEdgeFloat.this, view2);
                    }
                }
            });
            foldCloseView.setOnFoldStateChangeListener(new b(foldCloseEdgeFloat));
            return foldCloseView;
        }
        return (FoldCloseView) invokeV.objValue;
    }
}
