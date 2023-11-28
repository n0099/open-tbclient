package com.baidu.tieba.forum.strategy;

import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dn7;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.tieba.ip7;
import com.baidu.tieba.uj7;
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
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00142\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0011\u0018\u00010!H\u0002J\b\u0010#\u001a\u00020\u001cH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006$"}, d2 = {"Lcom/baidu/tieba/forum/strategy/FullWebLayoutStrategy;", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "dataWrapper", "Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;", "(Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;)V", "stateChangeListener", "Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "getStateChangeListener", "()Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "setStateChangeListener", "(Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;)V", "topScrollChangeListener", "com/baidu/tieba/forum/strategy/FullWebLayoutStrategy$topScrollChangeListener$1", "Lcom/baidu/tieba/forum/strategy/FullWebLayoutStrategy$topScrollChangeListener$1;", "afterInflate", "", "configLinkageTab", "getScrollThreshold", "", "getSecondFloorTouchTarget", "Landroid/webkit/WebView;", "getWriteAndRefreshBtnOpacity", "", "initLayoutParams", "minVisibleHeightForTopContent", "needHandlerPost", "", "scrollToBottom", "scrollToPosition", "pos", "onScrollFinish", "Lkotlin/Function1;", "Lcom/baidu/tieba/forum/widget/TbNestedScrollView;", "scrollToTop", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FullWebLayoutStrategy extends BaseLayoutStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dn7 C;
    public final a D;

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements dn7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullWebLayoutStrategy a;
        public final /* synthetic */ ActivityForumBinding b;

        public a(FullWebLayoutStrategy fullWebLayoutStrategy, ActivityForumBinding activityForumBinding) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullWebLayoutStrategy, activityForumBinding};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullWebLayoutStrategy;
            this.b = activityForumBinding;
        }

        @Override // com.baidu.tieba.dn7
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O((this.b.m.getHeight() - this.a.q()) - this.a.t());
                dn7 Y = this.a.Y();
                if (Y != null) {
                    Y.a();
                }
            }
        }

        @Override // com.baidu.tieba.dn7
        public void b() {
            dn7 Y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (Y = this.a.Y()) != null) {
                Y.b();
            }
        }

        @Override // com.baidu.tieba.dn7
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                dn7.a.a(this, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullWebLayoutStrategy(ActivityForumBinding binding, uj7.a dataWrapper) {
        super(binding, (int) dataWrapper.c(), (int) dataWrapper.d());
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
        this.D = new a(this, binding);
    }

    public final void a0(int i, Function1<? super TbNestedScrollView, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, function1) == null) {
            TbBottomSheetView tbBottomSheetView = i().t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            LinearLayout linearLayout = i().h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            if (!ViewExtentionsKt.f(tbBottomSheetView, linearLayout)) {
                TbLinkageScrollView tbLinkageScrollView = i().m;
                Intrinsics.checkNotNullExpressionValue(tbLinkageScrollView, "binding.linkageView");
                if (!ip7.a(tbLinkageScrollView)) {
                    g();
                    i().m.scrollTo(0, (t() - s()) - 1);
                    d();
                    TbBottomSheetView tbBottomSheetView2 = i().t;
                    Intrinsics.checkNotNullExpressionValue(tbBottomSheetView2, "binding.topContentContainer");
                    TbNestedScrollView.E(tbBottomSheetView2, i, 0, function1, 2, null);
                    return;
                }
                return;
            }
            i().t.setVisibility(0);
            TbBottomSheetView tbBottomSheetView3 = i().t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView3, "binding.topContentContainer");
            TbNestedScrollView.E(tbBottomSheetView3, i, 0, function1, 2, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.forum.strategy.FullWebLayoutStrategy */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b0(FullWebLayoutStrategy fullWebLayoutStrategy, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        fullWebLayoutStrategy.a0(i, function1);
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy, com.baidu.tieba.en7
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.F();
            if (l() == 1) {
                return false;
            }
            b0(this, 0, null, 2, null);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy, com.baidu.tieba.en7
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.L();
            Z();
            D(this.D);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en7
    /* renamed from: X */
    public WebView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return i().d.getInnerWebView();
        }
        return (WebView) invokeV.objValue;
    }

    public final dn7 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.C;
        }
        return (dn7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return t() - s();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.forum.strategy.BaseLayoutStrategy
    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return t();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.en7
    public float I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (p() <= w()) {
                return 0.0f;
            }
            return ((k() - w()) * 1.0f) / (p() - w());
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.en7
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (l() == 2 || i().t.A()) {
                return false;
            }
            b0(this, i().t.getMinScroll(), null, 2, null);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i().c.getLayoutParams().height = i().m.getHeight() - q();
            ViewGroup.LayoutParams layoutParams = i().t.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, q(), 0, 0);
            }
            ViewGroup.LayoutParams layoutParams2 = i().b.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.setMargins(0, 0, 0, s());
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            P(i().p.getHeight());
            TbBottomSheetView tbBottomSheetView = i().t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            TbBottomSheetView.setup$default(tbBottomSheetView, 1, t(), 0, false, 12, null);
            i().m.setTopScrollTarget(new Function0<WebView>(this) { // from class: com.baidu.tieba.forum.strategy.FullWebLayoutStrategy$initLayoutParams$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FullWebLayoutStrategy this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
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

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final WebView invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.this$0.i().d.getInnerWebView();
                    }
                    return (WebView) invokeV.objValue;
                }
            });
            W();
            T();
            i().t.M(q() - h(), false, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.strategy.FullWebLayoutStrategy$initLayoutParams$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FullWebLayoutStrategy this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
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

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> n;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (n = this.this$0.n()) != null) {
                        n.invoke();
                    }
                }
            });
            O(h() - q());
        }
    }
}
