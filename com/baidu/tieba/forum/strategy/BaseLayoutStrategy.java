package com.baidu.tieba.forum.strategy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bh7;
import com.baidu.tieba.ei7;
import com.baidu.tieba.forum.bubble.ForumFloatBubble;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.strategy.BaseLayoutStrategy;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.kk7;
import com.baidu.tieba.nq6;
import com.baidu.tieba.om7;
import com.baidu.tieba.qe7;
import com.baidu.tieba.te7;
import com.baidu.tieba.uk7;
import com.baidu.tieba.vm7;
import com.baidu.tieba.yk7;
import com.baidu.tieba.zk7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0005\u0010\u00137GX\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010`\u001a\u000201H\u0017J\b\u0010a\u001a\u000201H\u0002J\b\u0010b\u001a\u000201H\u0004J\u0018\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0005H\u0002J \u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\rH\u0002J\b\u0010g\u001a\u000201H\u0016J\b\u0010h\u001a\u000201H\u0004J\b\u0010i\u001a\u00020\u0005H&J\b\u0010j\u001a\u00020\u0005H\u0016J\b\u0010k\u001a\u00020.H\u0016J\b\u0010l\u001a\u00020\u0005H&J\b\u0010m\u001a\u00020.H&J\u0010\u0010n\u001a\u0002012\u0006\u0010o\u001a\u00020\rH\u0002J\u0010\u0010p\u001a\u0002012\u0006\u0010d\u001a\u00020\u0005H\u0016J \u0010q\u001a\u0002012\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005H\u0017J\u0010\u0010v\u001a\u0002012\u0006\u0010w\u001a\u00020\u0005H\u0016J\b\u0010x\u001a\u000201H\u0016J \u0010y\u001a\u0002012\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005H\u0017J\u0010\u0010z\u001a\u0002012\u0006\u0010{\u001a\u00020\u0005H\u0014J\u0010\u0010|\u001a\u0002012\u0006\u0010}\u001a\u00020sH\u0002J\b\u0010~\u001a\u00020.H\u0017J\u001b\u0010\u007f\u001a\u0002012\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020.H\u0016J\u000f\u0010\u0083\u0001\u001a\u000201H\u0000¢\u0006\u0003\b\u0084\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u00020\u0005X\u0084\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010&R\u001a\u0010C\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\t\"\u0004\bE\u0010&R\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u0014\u0010\u0006\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\tR\u001a\u0010J\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010&R\u001c\u0010M\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u001a\u001a\u0004\bT\u0010UR\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010YR(\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000201\u0018\u00010[X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006\u0085\u0001"}, d2 = {"Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy;", "Lcom/baidu/tieba/forum/strategy/ILinkageLayoutStrategy;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "anchorPos", "", "tabCornerHeight", "(Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;II)V", "getAnchorPos", "()I", "getBinding$forum_release", "()Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "bottomScrollRatio", "", "bottomScrollY", "bottomSheetStateListener", "com/baidu/tieba/forum/strategy/BaseLayoutStrategy$bottomSheetStateListener$1", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy$bottomSheetStateListener$1;", "bounceAnimatorListener", "com/baidu/tieba/forum/strategy/BaseLayoutStrategy$bounceAnimatorListener$1", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy$bounceAnimatorListener$1;", "bubbleHolder", "Lcom/baidu/tieba/forum/bubble/BubbleHolder;", "getBubbleHolder", "()Lcom/baidu/tieba/forum/bubble/BubbleHolder;", "bubbleHolder$delegate", "Lkotlin/Lazy;", "contentScrollStateChangeListener", "Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "getContentScrollStateChangeListener", "()Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;", "setContentScrollStateChangeListener", "(Lcom/baidu/tieba/forum/strategy/IContentScrollStateChangeListener;)V", "currentTopContentState", "getCurrentTopContentState$annotations", "()V", "getCurrentTopContentState", "setCurrentTopContentState", "(I)V", "defaultBubbleBackgroundColor", "", "defaultTabHeight", "getDefaultTabHeight", "dragPerformance", "Lcom/baidu/tieba/forum/performance/DragPerformance;", "enalbeNavAlphaChange", "", "initPositionInvoke", "Lkotlin/Function0;", "", "getInitPositionInvoke", "()Lkotlin/jvm/functions/Function0;", "setInitPositionInvoke", "(Lkotlin/jvm/functions/Function0;)V", "linkageScrollListener", "com/baidu/tieba/forum/strategy/BaseLayoutStrategy$linkageScrollListener$1", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy$linkageScrollListener$1;", "linkageStatisticListener", "Lcom/baidu/tieba/forum/statistic/LinkageStatisticListener;", "getLinkageStatisticListener", "()Lcom/baidu/tieba/forum/statistic/LinkageStatisticListener;", "setLinkageStatisticListener", "(Lcom/baidu/tieba/forum/statistic/LinkageStatisticListener;)V", "maxScrollYForBottom", "maxScrollYForTop", "getMaxScrollYForTop", "setMaxScrollYForTop", "navHeight", "getNavHeight$forum_release", "setNavHeight$forum_release", "onPageChangeListener", "com/baidu/tieba/forum/strategy/BaseLayoutStrategy$onPageChangeListener$1", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy$onPageChangeListener$1;", "getTabCornerHeight", "tabHeight", "getTabHeight$forum_release", "setTabHeight$forum_release", AiBotChatDispatcher.AI_SINGLE_THEME_COLOR, "getThemeColor", "()Ljava/lang/String;", "setThemeColor", "(Ljava/lang/String;)V", "topContentRect", "Landroid/graphics/Rect;", "getTopContentRect", "()Landroid/graphics/Rect;", "topContentRect$delegate", "topContentScrollListener", "com/baidu/tieba/forum/strategy/BaseLayoutStrategy$topContentScrollListener$1", "Lcom/baidu/tieba/forum/strategy/BaseLayoutStrategy$topContentScrollListener$1;", "topContentVisibleHeightChangeListener", "Lkotlin/Function1;", "getTopContentVisibleHeightChangeListener", "()Lkotlin/jvm/functions/Function1;", "setTopContentVisibleHeightChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "afterInflate", "attachContentToBottom", "attachContentToTop", "computeScrollRatio", "scrollY", "maxScrollY", "initRatio", "dismissBubble", "fixTopContentScrollYBeforeScrollTop", "getScrollThreshold", "getTopContentState", "interceptFloatStateUpdate", "minVisibleHeightForTopContent", "needHandlerPost", "notifyScrollPercentChanged", "percent", "onBottomScrollChange", "onBottomSheetScrollChanged", "v", "Lcom/baidu/tieba/forum/widget/TbNestedScrollView;", "from", "to", "onChangeSkinType", "skin", MissionEvent.MESSAGE_DESTROY, "onLinkageScrollChanged", "onTopContentVisibleHeightChanged", "visibleHeight", "onTopContentVisibleRectChanged", "scrollTarget", "scrollToTop", "showBubble", "data", "Lcom/baidu/tieba/forum/bubble/BubbleData;", "showShadow", "updateFloatState", "updateFloatState$forum_release", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BaseLayoutStrategy implements zk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityForumBinding a;
    public final int b;
    public final int c;
    public final int d;
    public String e;
    public Function0<Unit> f;
    public Function1<? super Integer, Unit> g;
    public yk7 h;
    public uk7 i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public float p;
    public int q;
    public final Lazy r;
    public final kk7 s;
    public final String t;
    public final Lazy u;
    public final BaseLayoutStrategy$onPageChangeListener$1 v;
    public final a w;
    public final d x;
    public final c y;
    public final b z;

    public final float f(int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            if (i2 <= 0 || i < 0 || f < 0.0f || f > 1.0f) {
                return 0.0f;
            }
            if (i <= i2) {
                return f + ((i * (1.0f - f)) / i2);
            }
            return 1.0f;
        }
        return invokeCommon.floatValue;
    }

    public abstract int p();

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract int u();

    public abstract boolean v();

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements vm7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseLayoutStrategy a;

        public a(BaseLayoutStrategy baseLayoutStrategy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseLayoutStrategy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseLayoutStrategy;
        }

        @Override // com.baidu.tieba.vm7
        public void a() {
            uk7 n;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (n = this.a.n()) != null) {
                n.b();
            }
        }

        @Override // com.baidu.tieba.vm7
        public void b() {
            uk7 n;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (n = this.a.n()) != null) {
                n.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseLayoutStrategy a;

        public b(BaseLayoutStrategy baseLayoutStrategy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseLayoutStrategy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseLayoutStrategy;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.a.o = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.o = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.o = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements om7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseLayoutStrategy a;

        public c(BaseLayoutStrategy baseLayoutStrategy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseLayoutStrategy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseLayoutStrategy;
        }

        @Override // com.baidu.tieba.om7
        public void a(TbNestedScrollView tbNestedScrollView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, tbNestedScrollView, i, i2) == null) {
                om7.a.a(this, tbNestedScrollView, i, i2);
            }
        }

        @Override // com.baidu.tieba.om7
        public void b(TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.R();
                this.a.y(v, i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements om7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseLayoutStrategy a;

        public d(BaseLayoutStrategy baseLayoutStrategy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseLayoutStrategy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseLayoutStrategy;
        }

        @Override // com.baidu.tieba.om7
        public void a(TbNestedScrollView tbNestedScrollView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, tbNestedScrollView, i, i2) == null) {
                om7.a.a(this, tbNestedScrollView, i, i2);
            }
        }

        @Override // com.baidu.tieba.om7
        public void b(TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.x(v, i, i2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [com.baidu.tieba.forum.strategy.BaseLayoutStrategy$onPageChangeListener$1] */
    public BaseLayoutStrategy(ActivityForumBinding binding, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binding, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = binding;
        this.b = i;
        this.c = i2;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds213);
        this.d = dimenPixelSize;
        this.k = dimenPixelSize;
        this.l = 3;
        this.n = UtilHelper.getDimenPixelSize(R.dimen.tbds300);
        this.o = true;
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<te7>(this) { // from class: com.baidu.tieba.forum.strategy.BaseLayoutStrategy$bubbleHolder$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseLayoutStrategy this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final te7 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context context = this.this$0.i().m.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "binding.linkageView.context");
                    return new te7(new ForumFloatBubble(context, null, 0, 6, null));
                }
                return (te7) invokeV.objValue;
            }
        });
        this.s = new kk7();
        this.t = "#000000";
        this.u = LazyKt__LazyJVMKt.lazy(BaseLayoutStrategy$topContentRect$2.INSTANCE);
        this.v = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.tieba.forum.strategy.BaseLayoutStrategy$onPageChangeListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;
            public final /* synthetic */ BaseLayoutStrategy b;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i5), Float.valueOf(f), Integer.valueOf(i6)}) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.b = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i5) == null) && i5 == 1) {
                    this.a = true;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                uk7 n;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i5) == null) {
                    if (this.a && this.b.F() && (n = this.b.n()) != null) {
                        n.c();
                    }
                    this.a = false;
                }
            }
        };
        this.w = new a(this);
        this.x = new d(this);
        this.y = new c(this);
        this.z = new b(this);
    }

    public static final void S(BaseLayoutStrategy this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b();
        }
    }

    public static final void T(BaseLayoutStrategy this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d();
        }
    }

    public final void B(yk7 yk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yk7Var) == null) {
            this.h = yk7Var;
        }
    }

    public final void C(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function0) == null) {
            this.f = function0;
        }
    }

    public final void D(uk7 uk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uk7Var) == null) {
            this.i = uk7Var;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.zk7
    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.q = i;
            float e = e(i, this.n);
            this.p = e;
            w(e);
        }
    }

    public final void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.j = i;
        }
    }

    public final void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.e = str;
        }
    }

    public final void Q(Function1<? super Integer, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, function1) == null) {
            this.g = function1;
        }
    }

    @Override // com.baidu.tieba.zk7
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            j().g(i);
        }
    }

    public final void w(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048614, this, f) == null) && this.o) {
            NavigationBar navigationBar = this.a.p;
            Intrinsics.checkNotNullExpressionValue(navigationBar, "binding.navBar");
            bh7.a(navigationBar, f);
        }
    }

    public final float e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i, i2)) == null) {
            return f(i, i2, 0.0f);
        }
        return invokeII.floatValue;
    }

    public final void A(TbNestedScrollView tbNestedScrollView) {
        uk7 uk7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbNestedScrollView) == null) {
            this.a.h.getGlobalVisibleRect(s());
            int i = s().bottom - s().top;
            z(i);
            Function1<? super Integer, Unit> function1 = this.g;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
            if (u() == i) {
                this.l = 2;
                yk7 yk7Var = this.h;
                if (yk7Var != null) {
                    yk7Var.a();
                }
                this.s.a();
            } else if (this.j == s().top) {
                if (this.l != 1 && (tbNestedScrollView instanceof TbLinkageScrollView) && (uk7Var = this.i) != null) {
                    uk7Var.a();
                }
                this.l = 1;
                yk7 yk7Var2 = this.h;
                if (yk7Var2 != null) {
                    yk7Var2.b();
                }
                this.s.b();
            } else {
                this.l = 3;
                yk7 yk7Var3 = this.h;
                if (yk7Var3 != null) {
                    yk7Var3.c(i);
                }
                this.s.c(i);
            }
            nq6.b().c(new ei7(this.a.h.getContext(), false));
        }
    }

    @Override // com.baidu.tieba.zk7
    @CallSuper
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            G();
            this.s.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zk7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j().e();
        }
    }

    @Override // com.baidu.tieba.zk7
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Rect rect = new Rect();
            this.a.h.getGlobalVisibleRect(rect);
            this.a.t.scrollTo(0, (rect.bottom - rect.top) - this.a.h.getHeight());
        }
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final ActivityForumBinding i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a;
        }
        return (ActivityForumBinding) invokeV.objValue;
    }

    public final te7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return (te7) this.r.getValue();
        }
        return (te7) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final Function0<Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.f;
        }
        return (Function0) invokeV.objValue;
    }

    public final uk7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.i;
        }
        return (uk7) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final Rect s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return (Rect) this.u.getValue();
        }
        return (Rect) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zk7
    public void J(qe7 data, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, data, z) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            te7 j = j();
            FrameLayout frameLayout = this.a.e;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bubbleContainer");
            TbBottomSheetView tbBottomSheetView = this.a.t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            j.a(frameLayout, tbBottomSheetView);
            j().h(data);
            if (z) {
                String str = this.e;
                if (str == null) {
                    str = this.t;
                }
                te7 j2 = j();
                View view2 = this.a.f;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.bubbleShadow");
                TbBottomSheetView tbBottomSheetView2 = this.a.t;
                Intrinsics.checkNotNullExpressionValue(tbBottomSheetView2, "binding.topContentContainer");
                j2.i(view2, tbBottomSheetView2, this.c, str);
            }
        }
    }

    @Override // com.baidu.tieba.zk7
    @CallSuper
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.w.addOnPageChangeListener(this.v);
            this.a.m.getListeners().add(this.y);
            this.a.t.getListeners().add(this.x);
            this.a.t.setBounceAnimatorListener(this.z);
            this.a.t.setBottomSheetStateListener(this.w);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.t.setVisibility(8);
            ActivityForumBinding activityForumBinding = this.a;
            activityForumBinding.t.removeView(activityForumBinding.h);
            FrameLayout frameLayout = this.a.c;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomContentContainer");
            LinearLayout linearLayout = this.a.h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            ViewExtentionsKt.d(frameLayout, linearLayout, 0, 2, null);
            this.a.m.setBottomScrollTarget(new Function0<LinearLayout>(this) { // from class: com.baidu.tieba.forum.strategy.BaseLayoutStrategy$attachContentToBottom$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseLayoutStrategy this$0;

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
                public final LinearLayout invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.this$0.i().h;
                    }
                    return (LinearLayout) invokeV.objValue;
                }
            });
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.m.setBottomScrollTarget(null);
            ActivityForumBinding activityForumBinding = this.a;
            activityForumBinding.c.removeView(activityForumBinding.h);
            TbBottomSheetView tbBottomSheetView = this.a.t;
            Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
            LinearLayout linearLayout = this.a.h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            ViewExtentionsKt.d(tbBottomSheetView, linearLayout, 0, 2, null);
            this.a.t.setVisibility(0);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || t()) {
            return;
        }
        int p = p();
        TbBottomSheetView tbBottomSheetView = this.a.t;
        Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
        LinearLayout linearLayout = this.a.h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
        if (ViewExtentionsKt.f(tbBottomSheetView, linearLayout)) {
            if (this.a.m.getScrollY() >= p) {
                if (v()) {
                    this.a.m.post(new Runnable() { // from class: com.baidu.tieba.wk7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                BaseLayoutStrategy.S(BaseLayoutStrategy.this);
                            }
                        }
                    });
                } else {
                    b();
                }
            }
        } else if (this.a.m.getScrollY() < p) {
            if (v()) {
                this.a.m.post(new Runnable() { // from class: com.baidu.tieba.xk7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BaseLayoutStrategy.T(BaseLayoutStrategy.this);
                        }
                    }
                });
            } else {
                d();
            }
        }
    }

    @Override // com.baidu.tieba.zk7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.a.w.removeOnPageChangeListener(this.v);
            this.a.m.getListeners().remove(this.y);
            this.a.t.getListeners().remove(this.x);
            this.a.t.setBounceAnimatorListener(null);
            this.a.t.setBottomSheetStateListener(null);
            j().d();
            this.g = null;
            this.i = null;
        }
    }

    @CallSuper
    public void x(TbNestedScrollView v, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048615, this, v, i, i2) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            A(v);
            w(f(this.m - Math.abs(v.getScrollY()), this.m, this.p));
        }
    }

    @CallSuper
    public void y(TbNestedScrollView v, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, v, i, i2) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            A(v);
            w(e(v.getScrollY() + this.q, this.n));
        }
    }
}
