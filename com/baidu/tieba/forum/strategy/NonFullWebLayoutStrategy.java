package com.baidu.tieba.forum.strategy;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ei7;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.tieba.xk7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/tieba/forum/strategy/NonFullWebLayoutStrategy;", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "dataWrapper", "Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;", "(Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;)V", "dragBounceOffset", "", "dragScrollThreshold", "interceptFloatStateUpdate", "", "maxScrollOffset", "stateChangeListener", "Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "getStateChangeListener", "()Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "setStateChangeListener", "(Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;)V", "topScrollChangeListener", "com/baidu/tieba/forum/strategy/NonFullWebLayoutStrategy$topScrollChangeListener$1", "Lcom/baidu/tieba/forum/strategy/NonFullWebLayoutStrategy$topScrollChangeListener$1;", "webHeight", "afterInflate", "", "configLinkageTab", "bottomSpaceBetweenTabAndWeb", "getScrollThreshold", "getSecondFloorTouchTarget", "Lcom/baidu/tieba/forum/widget/TbLinkageScrollView;", "getWriteBtnOpacity", "", "initLayoutParams", "minVisibleHeightForTopContent", "needHandlerPost", "scrollToBottom", "scrollToTop", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NonFullWebLayoutStrategy extends BaseLayoutStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ei7.a A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public final int F;
    public xk7 G;
    public final a H;

    @Override // com.baidu.tieba.yk7
    public float M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements xk7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NonFullWebLayoutStrategy a;

        public a(NonFullWebLayoutStrategy nonFullWebLayoutStrategy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nonFullWebLayoutStrategy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nonFullWebLayoutStrategy;
        }

        @Override // com.baidu.tieba.xk7
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                xk7.a.a(this, i);
            }
        }

        @Override // com.baidu.tieba.xk7
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NonFullWebLayoutStrategy nonFullWebLayoutStrategy = this.a;
                nonFullWebLayoutStrategy.E(nonFullWebLayoutStrategy.C);
                xk7 Y = this.a.Y();
                if (Y != null) {
                    Y.a();
                }
            }
        }

        @Override // com.baidu.tieba.xk7
        public void b() {
            xk7 Y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (Y = this.a.Y()) != null) {
                Y.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonFullWebLayoutStrategy(ActivityForumBinding binding, ei7.a dataWrapper) {
        super(binding, (int) dataWrapper.e(), (int) dataWrapper.f());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binding, dataWrapper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ActivityForumBinding) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        this.A = dataWrapper;
        this.B = (int) dataWrapper.a();
        this.D = 1;
        this.F = (int) this.A.d();
        this.H = new a(this);
    }

    public final void a0(xk7 xk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xk7Var) == null) {
            this.G = xk7Var;
        }
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy, com.baidu.tieba.yk7
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.F();
            if (k() == 1) {
                return false;
            }
            TbBottomSheetView tbBottomSheetView = i().t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            LinearLayout linearLayout = i().h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            if (!ViewExtentionsKt.f(tbBottomSheetView, linearLayout)) {
                g();
                this.E = true;
                i().m.scrollTo(0, 0);
                d();
                TbBottomSheetView tbBottomSheetView2 = i().t;
                Intrinsics.checkNotNullExpressionValue(tbBottomSheetView2, "binding.topContentContainer");
                TbNestedScrollView.E(tbBottomSheetView2, 0, 0, new Function1<TbNestedScrollView, Unit>(this) { // from class: com.baidu.tieba.forum.strategy.NonFullWebLayoutStrategy$scrollToTop$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NonFullWebLayoutStrategy this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TbNestedScrollView tbNestedScrollView) {
                        invoke2(tbNestedScrollView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TbNestedScrollView it) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.this$0.E = false;
                        }
                    }
                }, 2, null);
            } else {
                i().t.setVisibility(0);
                TbBottomSheetView tbBottomSheetView3 = i().t;
                Intrinsics.checkNotNullExpressionValue(tbBottomSheetView3, "binding.topContentContainer");
                TbNestedScrollView.E(tbBottomSheetView3, 0, 0, null, 6, null);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yk7
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (k() == 2 || i().t.z()) {
                return false;
            }
            FrameLayout frameLayout = i().c;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomContentContainer");
            LinearLayout linearLayout = i().h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            if (ViewExtentionsKt.f(frameLayout, linearLayout)) {
                return false;
            }
            i().t.setVisibility(0);
            TbBottomSheetView tbBottomSheetView = i().t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            TbNestedScrollView.E(tbBottomSheetView, i().t.getMidScroll(), 0, null, 6, null);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy, com.baidu.tieba.yk7
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.K();
            Z();
            B(this.H);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yk7
    /* renamed from: X */
    public TbLinkageScrollView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbLinkageScrollView tbLinkageScrollView = i().m;
            Intrinsics.checkNotNullExpressionValue(tbLinkageScrollView, "binding.linkageView");
            return tbLinkageScrollView;
        }
        return (TbLinkageScrollView) invokeV.objValue;
    }

    public final xk7 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.G;
        }
        return (xk7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.E;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return r() + this.B;
        }
        return invokeV.intValue;
    }

    public final void W(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            i().c.getLayoutParams().height = i().m.getHeight() - o();
            ViewGroup.LayoutParams layoutParams = i().t.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, o(), 0, 0);
            }
            ViewGroup.LayoutParams layoutParams2 = i().b.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.setMargins(0, 0, 0, i);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            N(i().p.getHeight());
            int height = (i().m.getHeight() - this.F) + q();
            int i = this.B + height;
            if (i < l()) {
                O(l());
                this.D = l() - i;
                this.B = 0;
            } else {
                O(height);
                this.D = 1;
            }
            i().t.setup(2, r(), r() + this.B, true);
            this.C = ((i().m.getHeight() - r()) - o()) - this.B;
            W(i);
            R();
            i().t.L(o() - h(), false, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.strategy.NonFullWebLayoutStrategy$initLayoutParams$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NonFullWebLayoutStrategy this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> m;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (m = this.this$0.m()) != null) {
                        m.invoke();
                    }
                }
            });
            E(h() - o());
        }
    }
}
