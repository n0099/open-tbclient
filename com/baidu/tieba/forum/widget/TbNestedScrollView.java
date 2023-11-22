package com.baidu.tieba.forum.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.Scroller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tieba.om7;
import com.baidu.tieba.rm7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b$\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010M\u001a\u00020:H\u0014J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\nH\u0016J\u0010\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\nH\u0016J\b\u0010S\u001a\u00020:H\u0016J \u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u0017H\u0016J\u0018\u0010X\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0016J,\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\b\u0010W\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016J4\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\b\u0010W\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010^\u001a\u00020\nH\u0016J*\u0010_\u001a\u00020:2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010W\u001a\u00020\\2\b\b\u0002\u0010^\u001a\u00020\nH\u0002J2\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016J:\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010^\u001a\u00020\nH\u0016JB\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010^\u001a\u00020\n2\u0006\u0010W\u001a\u00020\\H\u0016J<\u0010e\u001a\u00020:2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\b\b\u0002\u0010^\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\\H\u0002J \u0010f\u001a\u00020:2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0002J\u0018\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0002J\u0010\u0010i\u001a\u00020\u00172\u0006\u0010j\u001a\u00020kH\u0016J&\u0010l\u001a\u00020:2\u0006\u0010m\u001a\u00020\u00142\u0016\b\u0002\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020:\u0018\u000109J\b\u0010o\u001a\u00020\nH\u0016J\u0010\u0010p\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0002J\u0010\u0010q\u001a\u00020\n2\u0006\u0010[\u001a\u00020\nH\u0002J\u0018\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u0014H\u0014J\b\u0010u\u001a\u00020\u0017H\u0016J\u0010\u0010u\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\nH\u0016J\b\u0010v\u001a\u00020\u0017H\u0016J\u0006\u0010w\u001a\u00020\u0017J\u0010\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020zH\u0002J\u0010\u0010{\u001a\u00020\u00172\u0006\u0010j\u001a\u00020kH\u0016J2\u0010|\u001a\u00020:2\u0006\u0010}\u001a\u00020\u00172\u0006\u0010~\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\nH\u0014J*\u0010\u0082\u0001\u001a\u00020\u00172\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u0017H\u0016J\"\u0010\u0084\u0001\u001a\u00020\u00172\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0016J*\u0010\u0085\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010W\u001a\u00020\\H\u0016J2\u0010\u0085\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010W\u001a\u00020\\2\u0006\u0010^\u001a\u00020\nH\u0016J2\u0010\u0086\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\nH\u0016J:\u0010\u0086\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0016JB\u0010\u0086\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010^\u001a\u00020\n2\u0006\u0010W\u001a\u00020\\H\u0016J$\u0010\u0087\u0001\u001a\u00020:2\u0007\u0010\u0088\u0001\u001a\u0002022\u0007\u0010\u0083\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020\nH\u0016J,\u0010\u0087\u0001\u001a\u00020:2\u0007\u0010\u0088\u0001\u001a\u0002022\u0007\u0010\u0083\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0016J-\u0010\u008a\u0001\u001a\u00020:2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0014J$\u0010\u008f\u0001\u001a\u00020\u00172\u0007\u0010\u0088\u0001\u001a\u0002022\u0007\u0010\u0083\u0001\u001a\u0002022\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0016J,\u0010\u008f\u0001\u001a\u00020\u00172\u0007\u0010\u0088\u0001\u001a\u0002022\u0007\u0010\u0083\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0016J\u0012\u0010\u0091\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u000202H\u0016J\u001a\u0010\u0091\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010^\u001a\u00020\nH\u0016J\u0011\u0010\u0092\u0001\u001a\u00020\u00172\u0006\u0010j\u001a\u00020kH\u0017J\u001b\u0010\u0093\u0001\u001a\u00020:2\u0007\u0010\u0094\u0001\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0096\u0001\u001a\u00020:2\u0007\u0010\u0097\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0017H\u0014J2\u0010\u0099\u0001\u001a\u00020:2\u0006\u0010h\u001a\u00020\n2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\n2\u0016\b\u0002\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020:\u0018\u000109J\u0012\u0010\u009b\u0001\u001a\u00020\u00172\u0007\u0010\u0089\u0001\u001a\u00020\nH\u0016J\u001a\u0010\u009b\u0001\u001a\u00020\u00172\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0016J\t\u0010\u009c\u0001\u001a\u00020:H\u0016J\u0011\u0010\u009c\u0001\u001a\u00020:2\u0006\u0010^\u001a\u00020\nH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020:2\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u0017R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010,\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010*R\u000e\u0010/\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0004\u0018\u0001022\b\u0010\u001a\u001a\u0004\u0018\u000102@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\"\u00106\u001a\u0004\u0018\u0001022\b\u0010\u001a\u001a\u0004\u0018\u000102@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u001c\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020:\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b=\u0010>R \u0010@\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010*R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010H\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n@BX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010B\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010*R\u000e\u0010L\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/baidu/tieba/forum/widget/TbNestedScrollView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/core/view/NestedScrollingChild3;", "Lcom/baidu/tieba/forum/widget/NestedScrollBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "getChildHelper", "()Landroidx/core/view/NestedScrollingChildHelper;", "childHelper$delegate", "Lkotlin/Lazy;", "downState", "downX", "", "downY", "enableLog", "", "lastEventTime", "", "<set-?>", "lastScrollDir", "getLastScrollDir", "()I", "lastX", "lastY", "listeners", "Ljava/util/HashSet;", "Lcom/baidu/tieba/forum/widget/BehaviorScrollListener;", "Lkotlin/collections/HashSet;", "getListeners", "()Ljava/util/HashSet;", "maxFlingVelocity", "maxScroll", "getMaxScroll", "setMaxScroll", "(I)V", "minFlingVelocity", "minScroll", "getMinScroll", "setMinScroll", "moveDuration", "moveDx", "moveDy", "Landroid/view/View;", "nestedScrollChild", "getNestedScrollChild", "()Landroid/view/View;", "nestedScrollTarget", "getNestedScrollTarget", "onEndListener", "Lkotlin/Function1;", "", "parentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "getParentHelper", "()Landroidx/core/view/NestedScrollingParentHelper;", "parentHelper$delegate", "scrollAxis", "getScrollAxis$annotations", "()V", "getScrollAxis", "setScrollAxis", "scroller", "Landroid/widget/Scroller;", "value", "state", "getState$annotations", "getState", "setState", "touchInterceptSlop", "adjustScrollBounds", "canScrollHorizontally", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "canScrollSelf", MapBundleKey.MapObjKey.OBJ_DIR, "canScrollVertically", "computeScroll", "dispatchNestedFling", "velocityX", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", LoginConstants.DX_ONE_KEY_LOGIN, "dy", "", "offsetInWindow", "type", "dispatchNestedPreScrollInternal", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "dispatchNestedScrollInternal", "dispatchScrollInternal", "dispatchScrollSelf", "scroll", "dispatchTouchEvent", "e", "Landroid/view/MotionEvent;", "fling", "velocity", "onEnd", "getNestedScrollAxes", "getScrollByX", "getScrollByY", "handleFling", "vx", "vy", "hasNestedScrollingParent", "isNestedScrollingEnabled", "isScrolling", LocalFilesFilterKt.FILTER_NAME_LOG, "text", "", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onNestedFling", "target", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "axes", "onScrollChanged", "l", "t", "oldl", "oldt", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "onTouchEvent", "scrollBy", "x", "y", "setNestedScrollingEnabled", SapiOptions.KEY_CACHE_ENABLED, "shouldBlockOnInterceptTouch", "smoothScrollTo", "duration", "startNestedScroll", "stopNestedScroll", "stopScroll", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class TbNestedScrollView extends ConstraintLayout implements NestedScrollingParent3, NestedScrollingChild3, rm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final HashSet<om7> f;
    public View g;
    public View h;
    public boolean i;
    public final int j;
    public final float k;
    public final float l;
    public final Scroller m;
    public Function1<? super TbNestedScrollView, Unit> n;
    public final Lazy o;
    public final Lazy p;
    public float q;
    public float r;
    public long s;
    public int t;
    public int u;
    public long v;
    public float w;
    public float x;
    public int y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbNestedScrollView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getScrollAxis$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.a = 2;
        this.f = new HashSet<>();
        this.i = true;
        this.m = new Scroller(context);
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<NestedScrollingParentHelper>(this) { // from class: com.baidu.tieba.forum.widget.TbNestedScrollView$parentHelper$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbNestedScrollView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
            public final NestedScrollingParentHelper invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new NestedScrollingParentHelper(this.this$0);
                }
                return (NestedScrollingParentHelper) invokeV.objValue;
            }
        });
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<NestedScrollingChildHelper>(this) { // from class: com.baidu.tieba.forum.widget.TbNestedScrollView$childHelper$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbNestedScrollView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
            public final NestedScrollingChildHelper invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new NestedScrollingChildHelper(this.this$0);
                }
                return (NestedScrollingChildHelper) invokeV.objValue;
            }
        });
        setNestedScrollingEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.j = viewConfiguration.getScaledTouchSlop();
        this.k = viewConfiguration.getScaledMinimumFlingVelocity();
        this.l = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public /* synthetic */ TbNestedScrollView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.forum.widget.TbNestedScrollView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(TbNestedScrollView tbNestedScrollView, float f, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            tbNestedScrollView.k(f, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fling");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.forum.widget.TbNestedScrollView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void E(TbNestedScrollView tbNestedScrollView, int i, int i2, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 300;
            }
            if ((i3 & 4) != 0) {
                function1 = null;
            }
            tbNestedScrollView.D(i, i2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothScrollTo");
    }

    public static /* synthetic */ void G(TbNestedScrollView tbNestedScrollView, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            tbNestedScrollView.F(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopScroll");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048622, this, child, target, i, i2) == null) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            getParentHelper().onNestedScrollAccepted(child, target, i, i2);
            startNestedScroll(i, i2);
            this.g = child;
            this.h = target;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048625, this, child, target, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            if ((getNestedScrollAxes() & i) != 0) {
                return true;
            }
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public static /* synthetic */ void d(TbNestedScrollView tbNestedScrollView, int i, int i2, int[] iArr, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 8) != 0) {
                i3 = 0;
            }
            tbNestedScrollView.c(i, i2, iArr, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchNestedPreScrollInternal");
    }

    public static /* synthetic */ void f(TbNestedScrollView tbNestedScrollView, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6, Object obj) {
        int i7;
        if (obj == null) {
            if ((i6 & 16) != 0) {
                i7 = 0;
            } else {
                i7 = i5;
            }
            if ((i6 & 32) != 0) {
                iArr = new int[]{0, 0};
            }
            tbNestedScrollView.e(i, i2, i3, i4, i7, iArr);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchNestedScrollInternal");
    }

    private final NestedScrollingChildHelper getChildHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return (NestedScrollingChildHelper) this.p.getValue();
        }
        return (NestedScrollingChildHelper) invokeV.objValue;
    }

    private final NestedScrollingParentHelper getParentHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return (NestedScrollingParentHelper) this.o.getValue();
        }
        return (NestedScrollingParentHelper) invokeV.objValue;
    }

    public final int getLastScrollDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final HashSet<om7> getListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.f;
        }
        return (HashSet) invokeV.objValue;
    }

    public final int getMaxScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int getMinScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final View getNestedScrollChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public final View getNestedScrollTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public final int getScrollAxis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return getChildHelper().hasNestedScrollingParent();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return getChildHelper().isNestedScrollingEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            getChildHelper().stopNestedScroll();
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return !this.m.isFinished();
        }
        return invokeV.booleanValue;
    }

    private final void setState(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65549, this, i) == null) && (i2 = this.e) != i) {
            this.e = i;
            for (om7 om7Var : this.f) {
                om7Var.a(this, i2, i);
            }
        }
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.i) {
            Log.d(getClass().getSimpleName(), str);
        }
    }

    public final void F(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.m.forceFinished(true);
            if (z && (view2 = this.g) != null) {
                ViewExtentionsKt.l(view2);
            }
        }
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    return false;
                }
                return canScrollVertically(i);
            }
            return canScrollHorizontally(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (getNestedScrollAxes() != 1) {
                return false;
            }
            if (i > 0) {
                if (getScrollX() >= this.c) {
                    return false;
                }
            } else if (i < 0 && getScrollX() <= this.b) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (getNestedScrollAxes() == 2) {
                if (i > 0) {
                    if (getScrollY() < this.c) {
                        return true;
                    }
                } else if (i >= 0 || getScrollY() > this.b) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            return getChildHelper().hasNestedScrollingParent(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, target) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            onStopNestedScroll(target, 0);
        }
    }

    public Boolean p(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, motionEvent)) == null) {
            return rm7.a.a(this, motionEvent);
        }
        return (Boolean) invokeL.objValue;
    }

    public final void setMaxScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.c = i;
        }
    }

    public final void setMinScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.b = i;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            getChildHelper().setNestedScrollingEnabled(z);
        }
    }

    public final void setScrollAxis(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.a = i;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
            return getChildHelper().startNestedScroll(i);
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            getChildHelper().stopNestedScroll(i);
        }
    }

    public Boolean y(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, motionEvent)) == null) {
            return rm7.a.e(this, motionEvent);
        }
        return (Boolean) invokeL.objValue;
    }

    public final void D(int i, int i2, Function1<? super TbNestedScrollView, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, function1) == null) {
            A("smoothScrollSelf " + i);
            G(this, false, 1, null);
            setState(2);
            this.q = 0.0f;
            this.r = 0.0f;
            this.n = function1;
            this.m.startScroll((int) 0.0f, (int) 0.0f, i - getScrollX(), i - getScrollY(), i2);
            invalidate();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int childCount = getChildCount();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getLeft() < i) {
                    i = childAt.getLeft();
                }
                if (childAt.getRight() > i2) {
                    i2 = childAt.getRight();
                }
                if (childAt.getTop() < i3) {
                    i3 = childAt.getTop();
                }
                if (childAt.getBottom() > i4) {
                    i4 = childAt.getBottom();
                }
            }
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    this.b = 0;
                    this.c = 0;
                    return;
                }
                this.b = i3;
                this.c = i4 - getHeight();
                return;
            }
            this.b = i;
            this.c = i2 - getWidth();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.m.computeScrollOffset()) {
                int currX = (int) (this.m.getCurrX() - this.q);
                int currY = (int) (this.m.getCurrY() - this.r);
                this.q = this.m.getCurrX();
                this.r = this.m.getCurrY();
                if (this.e == 2) {
                    scrollBy(currX, currY);
                } else {
                    h(currX, currY, 1);
                }
                invalidate();
                return;
            }
            int i = this.e;
            if (i == 2) {
                setState(0);
                Function1<? super TbNestedScrollView, Unit> function1 = this.n;
                if (function1 != null) {
                    function1.invoke(this);
                }
                this.n = null;
            } else if (i == 3) {
                setState(0);
                stopNestedScroll(1);
                Function1<? super TbNestedScrollView, Unit> function12 = this.n;
                if (function12 != null) {
                    function12.invoke(this);
                }
                this.n = null;
            }
        }
    }

    public final void c(int i, int i2, int[] iArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) {
            A("dispatchNestedPreScrollInternal: type=" + i3 + ", x=" + i + ", y=" + i2);
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    dispatchNestedPreScroll(i, i2, iArr, null, i3);
                    return;
                }
                Boolean t = t(i2, i3);
                A("handleNestedPreScrollFirst = " + t);
                if (Intrinsics.areEqual(t, Boolean.TRUE)) {
                    int i4 = i(i2, i3);
                    dispatchNestedPreScroll(i, i2 - i4, iArr, null, i3);
                    iArr[1] = iArr[1] + i4;
                    return;
                } else if (Intrinsics.areEqual(t, Boolean.FALSE)) {
                    dispatchNestedPreScroll(i, i2, iArr, null, i3);
                    iArr[1] = iArr[1] + i(i2 - iArr[1], i3);
                    return;
                } else if (t == null) {
                    dispatchNestedPreScroll(i, i2, iArr, null, i3);
                    return;
                } else {
                    return;
                }
            }
            Boolean t2 = t(i, i3);
            A("handleNestedPreScrollFirst = " + t2);
            if (Intrinsics.areEqual(t2, Boolean.TRUE)) {
                int i5 = i(i, i3);
                dispatchNestedPreScroll(i - i5, i2, iArr, null, i3);
                iArr[0] = iArr[0] + i5;
            } else if (Intrinsics.areEqual(t2, Boolean.FALSE)) {
                dispatchNestedPreScroll(i, i2, iArr, null, i3);
                iArr[0] = iArr[0] + i(i - iArr[0], i3);
            } else if (t2 == null) {
                dispatchNestedPreScroll(i, i2, iArr, null, i3);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            return getChildHelper().dispatchNestedFling(f, f2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{target, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            return dispatchNestedPreFling(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return getChildHelper().dispatchNestedPreFling(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048627, this, target, i) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            getParentHelper().onStopNestedScroll(target, i);
            stopNestedScroll(i);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048637, this, i, i2)) == null) {
            return getChildHelper().startNestedScroll(i, i2);
        }
        return invokeII.booleanValue;
    }

    public Boolean t(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048640, this, i, i2)) == null) {
            return rm7.a.b(this, i, i2);
        }
        return (Boolean) invokeII.objValue;
    }

    public Boolean u(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048641, this, i, i2)) == null) {
            return rm7.a.c(this, i, i2);
        }
        return (Boolean) invokeII.objValue;
    }

    public Boolean x(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048642, this, i, i2)) == null) {
            return rm7.a.d(this, i, i2);
        }
        return (Boolean) invokeII.objValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) {
            return getChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{target, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            if (!z && s(f, f2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View target, int i, int i2, int[] consumed) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{target, Integer.valueOf(i), Integer.valueOf(i2), consumed}) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            d(this, i, i2, consumed, 0, 8, null);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})) == null) {
            return getChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            a();
            scrollBy(0, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int i, int i2, int[] consumed, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{target, Integer.valueOf(i), Integer.valueOf(i2), consumed, Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            c(i, i2, consumed, i3);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] consumed) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), consumed}) == null) {
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            getChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5, consumed);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5, int[] consumed) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{target, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), consumed}) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            e(i, i2, i3, i4, i5, consumed);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            return getChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View target, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{target, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            f(this, i, i2, i3, i4, 0, null, 48, null);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) {
            return getChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{target, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            f(this, i, i2, i3, i4, i5, null, 32, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            Boolean p = p(e);
            if (p != null) {
                boolean booleanValue = p.booleanValue();
                A("handleDispatchTouchEvent " + booleanValue);
                return booleanValue;
            }
            return super.dispatchTouchEvent(e);
        }
        return invokeL.booleanValue;
    }

    public final void e(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr}) == null) {
            A("dispatchNestedScrollInternal: type=" + i5 + ", x=" + i3 + ", y=" + i4);
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    dispatchNestedScroll(i, i2, i3, i4, null, i5, iArr);
                    return;
                }
                Boolean u = u(i4, i5);
                A("handleNestedScrollFirst = " + u);
                if (Intrinsics.areEqual(u, Boolean.TRUE)) {
                    int i6 = i(i4, i5);
                    dispatchNestedScroll(i, i2 + i6, i3, i4 - i6, null, i5, iArr);
                    iArr[1] = iArr[1] + i6;
                    return;
                } else if (Intrinsics.areEqual(u, Boolean.FALSE)) {
                    dispatchNestedScroll(i, i2, i3, i4, null, i5, iArr);
                    iArr[1] = iArr[1] + i(i4 - iArr[1], i5);
                    return;
                } else if (u == null) {
                    dispatchNestedScroll(i, i2, i3, i4, null, i5, iArr);
                    return;
                } else {
                    return;
                }
            }
            Boolean u2 = u(i3, i5);
            A("handleNestedScrollFirst = " + u2);
            if (Intrinsics.areEqual(u2, Boolean.TRUE)) {
                int i7 = i(i3, i5);
                dispatchNestedScroll(i + i7, i2, i3 - i7, i4, null, i5, iArr);
                iArr[0] = iArr[0] + i7;
            } else if (Intrinsics.areEqual(u2, Boolean.FALSE)) {
                dispatchNestedScroll(i, i2, i3, i4, null, i5, iArr);
                iArr[0] = iArr[0] + i(i3 - iArr[0], i5);
            } else if (u2 == null) {
                dispatchNestedScroll(i, i2, i3, i4, null, i5, iArr);
            }
        }
    }

    public final void h(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048604, this, i, i2, i3) == null) {
            A("dispatchScrollInternal: type=" + i3 + ", x=" + i + ", y=" + i2);
            int[] iArr = new int[2];
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    c(i, i2, iArr, i3);
                    int i4 = iArr[0];
                    int i5 = iArr[1];
                    iArr[0] = 0;
                    iArr[1] = 0;
                    e(i4, i5, i - i4, i2 - i5, i3, iArr);
                    return;
                }
                c(i, i2, iArr, i3);
                int i6 = iArr[1] + 0;
                int i7 = i6 + i(i2 - i6, i3);
                int i8 = iArr[0];
                iArr[0] = 0;
                iArr[1] = 0;
                e(i8, i7, i - i8, i2 - i7, i3, iArr);
                return;
            }
            c(i, i2, iArr, i3);
            int i9 = iArr[0] + 0;
            int i10 = i9 + i(i - i9, i3);
            int i11 = iArr[1];
            iArr[0] = 0;
            iArr[1] = 0;
            e(i10, i11, i - i10, i2 - i11, i3, iArr);
        }
    }

    public final int i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048607, this, i, i2)) == null) {
            int i3 = 0;
            if (i == 0) {
                return 0;
            }
            Boolean x = x(i, i2);
            if (!Intrinsics.areEqual(x, Boolean.TRUE)) {
                if (!Intrinsics.areEqual(x, Boolean.FALSE) && b(i)) {
                    A("canScrollSelf");
                    scrollBy(i, i);
                }
                A("handleScrollSelf: type=" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + x + WebvttCueParser.CHAR_SPACE + i + LoadErrorCode.TOKEN_NEXT + i3);
                return i3;
            }
            i3 = i;
            A("handleScrollSelf: type=" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + x + WebvttCueParser.CHAR_SPACE + i + LoadErrorCode.TOKEN_NEXT + i3);
            return i3;
        }
        return invokeII.intValue;
    }

    public boolean s(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            int nestedScrollAxes = getNestedScrollAxes();
            boolean z = false;
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes == 2 && Math.abs(f2) > this.k) {
                    l(this, ViewExtentionsKt.e(Float.valueOf(f2), Float.valueOf(-this.l), Float.valueOf(this.l)).floatValue(), null, 2, null);
                    z = true;
                }
                dispatchNestedFling(f, f2, z);
                return z;
            }
            if (Math.abs(f) > this.k) {
                l(this, ViewExtentionsKt.e(Float.valueOf(f), Float.valueOf(-this.l), Float.valueOf(this.l)).floatValue(), null, 2, null);
                z = true;
            }
            dispatchNestedFling(f, f2, z);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void k(float f, Function1<? super TbNestedScrollView, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f), function1}) == null) {
            A("fling " + f);
            G(this, false, 1, null);
            setState(3);
            this.q = 0.0f;
            this.r = 0.0f;
            this.n = function1;
            int i = (int) f;
            this.m.fling((int) 0.0f, (int) 0.0f, i, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            startNestedScroll(getNestedScrollAxes(), 1);
            invalidate();
        }
    }

    public final int n(int i) {
        InterceptResult invokeI;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            int scrollX = getScrollX() + i;
            if (getNestedScrollAxes() != 1) {
                intValue = getScrollX();
            } else if (getScrollX() > 0) {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollX), 0, Integer.valueOf(this.c)).intValue();
            } else if (getScrollX() < 0) {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollX), Integer.valueOf(this.b), 0).intValue();
            } else {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollX), Integer.valueOf(this.b), Integer.valueOf(this.c)).intValue();
            }
            return intValue - getScrollX();
        }
        return invokeI.intValue;
    }

    public final int o(int i) {
        InterceptResult invokeI;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            int scrollY = getScrollY() + i;
            if (getNestedScrollAxes() != 2) {
                intValue = getScrollY();
            } else if (getScrollY() > 0) {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollY), 0, Integer.valueOf(this.c)).intValue();
            } else if (getScrollY() < 0) {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollY), Integer.valueOf(this.b), 0).intValue();
            } else {
                intValue = ViewExtentionsKt.e(Integer.valueOf(scrollY), Integer.valueOf(this.b), Integer.valueOf(this.c)).intValue();
            }
            return intValue - getScrollY();
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        InterceptResult invokeL;
        boolean z;
        View i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (!C()) {
                return super.onInterceptTouchEvent(e);
            }
            int action = e.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return super.onInterceptTouchEvent(e);
                    }
                    int nestedScrollAxes = getNestedScrollAxes();
                    if (nestedScrollAxes != 1) {
                        if (nestedScrollAxes == 2 && Math.abs(e.getRawY() - this.r) > this.j && Math.abs(e.getRawY() - this.r) > Math.abs(e.getRawX() - this.q) && this.h == null) {
                            this.r = e.getRawY();
                            return true;
                        }
                    } else if (Math.abs(e.getRawX() - this.q) > this.j && Math.abs(e.getRawX() - this.q) > Math.abs(e.getRawY() - this.r) && this.h == null) {
                        this.q = e.getRawX();
                        return true;
                    }
                } else if (this.y != 0 && Math.abs(this.q - this.w) < this.j && Math.abs(this.r - this.x) < this.j) {
                    return true;
                }
            } else {
                this.q = e.getRawX();
                this.r = e.getRawY();
                this.w = e.getRawX();
                this.x = e.getRawY();
                this.y = this.e;
                View view2 = this.g;
                if (view2 != null && !ViewExtentionsKt.k(view2, e.getRawX(), e.getRawY())) {
                    z = true;
                } else {
                    z = false;
                }
                F(z);
                setState(0);
                this.d = 0;
                this.g = ViewExtentionsKt.g(this, e.getRawX(), e.getRawY());
                int nestedScrollAxes2 = getNestedScrollAxes();
                if (nestedScrollAxes2 != 1) {
                    if (nestedScrollAxes2 != 2) {
                        i = null;
                    } else {
                        i = ViewExtentionsKt.j(this, e.getRawX(), e.getRawY());
                    }
                } else {
                    i = ViewExtentionsKt.i(this, e.getRawX(), e.getRawY());
                }
                this.h = i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View child, View target, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048621, this, child, target, i) == null) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            onNestedScrollAccepted(child, target, i, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View child, View target, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048624, this, child, target, i)) == null) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            return onStartNestedScroll(child, target, i, 0);
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048623, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            int nestedScrollAxes = getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    this.d = 0;
                    return;
                }
                this.d = i2 - i4;
                for (om7 om7Var : this.f) {
                    om7Var.b(this, i4, i2);
                }
                return;
            }
            this.d = i - i3;
            for (om7 om7Var2 : this.f) {
                om7Var2.b(this, i3, i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
        r9 = true;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            Boolean y = y(e);
            if (y != null) {
                boolean booleanValue = y.booleanValue();
                A("handleTouchEvent " + booleanValue);
                return booleanValue;
            }
            int action = e.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.v = e.getEventTime() - this.s;
                        this.t = (int) (this.q - e.getRawX());
                        this.u = (int) (this.r - e.getRawY());
                        this.s = e.getEventTime();
                        this.q = e.getRawX();
                        this.r = e.getRawY();
                        if (this.e != 1) {
                            boolean z = (r9 = getNestedScrollAxes()) != 1 ? false : false;
                            if (z) {
                                startNestedScroll(getNestedScrollAxes(), 0);
                                setState(1);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.e == 1) {
                            h(this.t, this.u, 0);
                        }
                    }
                } else {
                    setState(0);
                    stopNestedScroll(0);
                    long j = this.v;
                    float f = this.t / (((float) j) / 1000.0f);
                    float f2 = this.u / (((float) j) / 1000.0f);
                    if (!dispatchNestedPreFling(f, f2)) {
                        s(f, f2);
                    }
                }
            } else {
                this.q = e.getRawX();
                this.r = e.getRawY();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i, i2) == null) {
            int n = n(i);
            int o = o(i2);
            super.scrollBy(n, o);
            A("scrollBy " + i + LoadErrorCode.TOKEN_NEXT + n + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + LoadErrorCode.TOKEN_NEXT + o);
        }
    }
}
