package com.baidu.tieba.forum.tab;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.ai7;
import com.baidu.tieba.ar6;
import com.baidu.tieba.b37;
import com.baidu.tieba.b67;
import com.baidu.tieba.bb7;
import com.baidu.tieba.bi7;
import com.baidu.tieba.bp5;
import com.baidu.tieba.cd7;
import com.baidu.tieba.d87;
import com.baidu.tieba.do7;
import com.baidu.tieba.f37;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.controller.TopController;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.forum.databinding.FragmentFrsFeedBinding;
import com.baidu.tieba.forum.model.OperateType;
import com.baidu.tieba.forum.tab.FrsFeedFragment;
import com.baidu.tieba.forum.template.FrsTemplateAdapter;
import com.baidu.tieba.forum.view.FrsStaggerSpaceItemDecoration;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.g57;
import com.baidu.tieba.gb7;
import com.baidu.tieba.hl7;
import com.baidu.tieba.j57;
import com.baidu.tieba.ka7;
import com.baidu.tieba.kb7;
import com.baidu.tieba.l88;
import com.baidu.tieba.m57;
import com.baidu.tieba.mb7;
import com.baidu.tieba.mm7;
import com.baidu.tieba.n55;
import com.baidu.tieba.nb7;
import com.baidu.tieba.ni7;
import com.baidu.tieba.ob7;
import com.baidu.tieba.om7;
import com.baidu.tieba.pl7;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.qj7;
import com.baidu.tieba.ql7;
import com.baidu.tieba.qn7;
import com.baidu.tieba.r57;
import com.baidu.tieba.rj7;
import com.baidu.tieba.rn7;
import com.baidu.tieba.s57;
import com.baidu.tieba.sh7;
import com.baidu.tieba.sj7;
import com.baidu.tieba.sn7;
import com.baidu.tieba.soa;
import com.baidu.tieba.t57;
import com.baidu.tieba.tj7;
import com.baidu.tieba.tn7;
import com.baidu.tieba.u77;
import com.baidu.tieba.v95;
import com.baidu.tieba.vj7;
import com.baidu.tieba.vl7;
import com.baidu.tieba.vn7;
import com.baidu.tieba.vs7;
import com.baidu.tieba.wn7;
import com.baidu.tieba.wo7;
import com.baidu.tieba.wq6;
import com.baidu.tieba.x27;
import com.baidu.tieba.xf7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.xl7;
import com.baidu.tieba.xq6;
import com.baidu.tieba.y77;
import com.baidu.tieba.zq6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0086\u0001B\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010?\u001a\u00020@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030B2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020@2\u0006\u0010A\u001a\u00020F2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020@H\u0002J\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020!H\u0002J\u0016\u0010J\u001a\u00020@2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020!0LH\u0002J'\u0010M\u001a\u0004\u0018\u0001HN\"\b\b\u0000\u0010N*\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HN0QH\u0016¢\u0006\u0002\u0010RJ\u000e\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020+J\b\u0010U\u001a\u00020@H\u0002J\u000e\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020XJ*\u0010Y\u001a\u00020@2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020+2\b\u0010]\u001a\u0004\u0018\u00010!2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020@H\u0002J\u0012\u0010a\u001a\u00020+2\b\b\u0002\u0010b\u001a\u00020+H\u0002J\u0006\u0010c\u001a\u00020@J\b\u0010d\u001a\u00020+H\u0002J\b\u0010e\u001a\u00020@H\u0016J\u0012\u0010f\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J$\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010n2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010o\u001a\u00020@H\u0016J\b\u0010p\u001a\u00020@H\u0016J\b\u0010q\u001a\u00020@H\u0016J2\u0010r\u001a\u00020@2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020+2\u0006\u0010s\u001a\u00020_2\b\u0010]\u001a\u0004\u0018\u00010!2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010t\u001a\u00020@H\u0016J\u001a\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u00020j2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010w\u001a\u00020@2\b\b\u0002\u0010x\u001a\u00020+H\u0002J\b\u0010y\u001a\u00020@H\u0002J\b\u0010z\u001a\u00020@H\u0002J\b\u0010{\u001a\u00020@H\u0002J\b\u0010|\u001a\u00020@H\u0002J\b\u0010}\u001a\u00020@H\u0002J\b\u0010~\u001a\u00020@H\u0002J\u0011\u0010\u007f\u001a\u00020@2\u0007\u0010\u0080\u0001\u001a\u00020+H\u0002J\t\u0010\u0081\u0001\u001a\u00020!H\u0016J\t\u0010\u0082\u0001\u001a\u00020@H\u0002J\t\u0010\u0083\u0001\u001a\u00020@H\u0002J\t\u0010\u0084\u0001\u001a\u00020@H\u0002J\t\u0010\u0085\u0001\u001a\u00020+H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/baidu/tieba/forum/tab/FrsFeedFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/forum/model/ResultCallback;", "Lcom/baidu/tbadk/core/util/videoPreload/IVideoNeedPreload;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Lcom/baidu/tieba/forum/controller/IGetActivityController;", "Lcom/baidu/tieba/forum/tab/IFakeWallTabData;", "()V", "_adapter", "Lcom/baidu/tieba/forum/template/FrsTemplateAdapter;", "_binding", "Lcom/baidu/tieba/forum/databinding/FragmentFrsFeedBinding;", "_frsHeadViewControl", "Lcom/baidu/tieba/forum/tab/FrsHeadViewControl;", "_fullViewControl", "Lcom/baidu/tieba/forum/tab/FrsFeedFullViewControl;", "_loadMoreViewControl", "Lcom/baidu/tieba/forum/tab/FrsLoadMoreViewControl;", "adapter", "getAdapter", "()Lcom/baidu/tieba/forum/template/FrsTemplateAdapter;", "autoPlayController", "Lcom/baidu/tieba/play/AutoPlayController;", "binding", "getBinding", "()Lcom/baidu/tieba/forum/databinding/FragmentFrsFeedBinding;", "eventTag", "", "exposeListener", "Lcom/baidu/tieba/forum/statistic/ForumFeedExposeLog;", "feedModel", "Lcom/baidu/tieba/forum/model/FrsFeedModel;", "formTab", "", "frsFeedBackControl", "Lcom/baidu/tieba/forum/tab/FrsFeedBackControl;", "frsHeadViewControl", "getFrsHeadViewControl", "()Lcom/baidu/tieba/forum/tab/FrsHeadViewControl;", "fullViewControl", "getFullViewControl", "()Lcom/baidu/tieba/forum/tab/FrsFeedFullViewControl;", "isPullingRefresh", "", "isStaggeredTab", "isVideoTab", "loadMoreViewControl", "getLoadMoreViewControl", "()Lcom/baidu/tieba/forum/tab/FrsLoadMoreViewControl;", "mVideoTabLoadMore", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "needForcedRefresh", "onCurrentCardBackgroundListener", "Lcom/baidu/tieba/play/AutoPlayController$OnCurrentCardBackgroundListener;", "pullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "refreshFinishRunnable", "Ljava/lang/Runnable;", "refreshTipManager", "Lcom/baidu/tieba/forum/management/RefreshTipManager;", "videoTabLastPositionListener", "visibilityTag", "volumeUpOnKeyDownListener", "addTemplateData", "", "data", "Lcom/baidu/tieba/feed/list/TemplateData;", "requestParams", "Lorg/json/JSONObject;", "addThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "clearListView", "commitTopThread", "threadId", "deleteThread", "threadIdList", "", "getActivityController", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tieba/forum/controller/BaseActivityController;", Bundle.EXTRA_KEY_CLAZZ, "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/baidu/tieba/forum/controller/BaseActivityController;", "handleEditModeEvent", "isInEditMode", "handleRecommendSuccess", "handleThreadOperationEvent", "event", "Lcom/baidu/tieba/forum/event/ThreadOperationEvent;", "handlerOperateType", "operateType", "Lcom/baidu/tieba/forum/model/OperateType;", "success", "errorMessage", "updateCount", "", "initFeedView", "interceptByNoNet", PopItemMethodConstant.showToast, "manualRefresh", "notInEditMode", "onChangeSkin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onResult", CloudStabilityUBCUtils.KEY_ERROR_CODE, "onResume", "onViewCreated", "view", "refreshListView", "fromLoadMore", "refreshLoadMore", "refreshSortView", "refreshTabView", "registerEvent", "registerFragmentVisibilityEvent", "registerGoodThreadEvents", "startRefresh", "isPullRefresh", "taskActionId", "tryHandleLoadMoreEditMode", "tryScrollToTop", "tryToLoadMore", "videoNeedPreload", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsFeedFragment extends BaseFragment implements vl7, IVideoNeedPreload, gb7, ai7, vn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentFrsFeedBinding a;
    public rn7 b;
    public tn7 c;
    public sn7 d;
    public FrsTemplateAdapter e;
    public ql7 f;
    public final Object g;
    public om7 h;
    public n55 i;
    public boolean j;
    public hl7 k;
    public final qn7 l;
    public final Object m;
    public boolean n;
    public AutoPlayController o;
    public final AutoPlayController.a p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;
    public String t;
    public boolean u;
    public boolean v;
    public Runnable w;
    public Map<Integer, View> x;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123950719, "Lcom/baidu/tieba/forum/tab/FrsFeedFragment$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1123950719, "Lcom/baidu/tieba/forum/tab/FrsFeedFragment$a;");
                    return;
                }
            }
            int[] iArr = new int[OperateType.values().length];
            iArr[OperateType.PULLREFRESH.ordinal()] = 1;
            iArr[OperateType.FULLREFRESH.ordinal()] = 2;
            iArr[OperateType.REFRESH.ordinal()] = 3;
            iArr[OperateType.CHANGETAB.ordinal()] = 4;
            iArr[OperateType.CHANGESORT.ordinal()] = 5;
            iArr[OperateType.LOADMORE.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2048094684, "Lcom/baidu/tieba/forum/tab/FrsFeedFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2048094684, "Lcom/baidu/tieba/forum/tab/FrsFeedFragment;");
        }
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.x.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsFeedFragment frsFeedFragment) {
            super(2921629);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment};
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
            this.a = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (this.a.v && this.a.f.hasMore()) {
                    this.a.f3().c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements bb7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        public c(FrsFeedFragment frsFeedFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFeedFragment;
        }

        @Override // com.baidu.tieba.bb7.c
        public void b(RecyclerView rv) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                om7 om7Var = this.a.h;
                if (om7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                    om7Var = null;
                }
                om7Var.b(rv);
            }
        }

        @Override // com.baidu.tieba.bb7.c
        public void a(nb7<?> data, mb7<?, ?> template, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(template, "template");
                om7 om7Var = this.a.h;
                BdUniqueId bdUniqueId = null;
                if (om7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                    om7Var = null;
                }
                om7Var.a(data, template, i);
                soa.a("frs_new", true);
                bp5.a aVar = bp5.a;
                FragmentActivity activity = this.a.getActivity();
                if (activity != null) {
                    bdUniqueId = xh7.a(activity);
                }
                aVar.h(bdUniqueId);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements AutoPlayController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        public d(FrsFeedFragment frsFeedFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFeedFragment;
        }

        @Override // com.baidu.tieba.play.AutoPlayController.a
        public void onBackground(boolean z) {
            Object obj;
            View h;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            AutoPlayController autoPlayController = this.a.o;
            f37.r rVar = null;
            if (autoPlayController != null && (h = autoPlayController.h()) != null) {
                obj = h.getTag();
            } else {
                obj = null;
            }
            if (obj instanceof f37.r) {
                rVar = (f37.r) obj;
            }
            if (rVar != null) {
                rVar.onBackground(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends ar6<qj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsFeedFragment frsFeedFragment, Class<qj7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(qj7 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.getUniqueId())) {
                    this.b.o3();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends ar6<sj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsFeedFragment frsFeedFragment, Class<sj7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(sj7 event) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                FragmentActivity activity = this.b.getActivity();
                if (activity != null) {
                    FrsFeedFragment frsFeedFragment = this.b;
                    ni7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
                    if (value != null) {
                        str = Long.valueOf(value.e()).toString();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, event.a())) {
                        frsFeedFragment.h3();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends ar6<v95> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsFeedFragment frsFeedFragment, Class<v95> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(v95 event) {
            FrsTemplateAdapter b3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                ql7 ql7Var = this.b.f;
                String a = event.a();
                if (a == null) {
                    a = "";
                }
                if (ql7Var.m(a) && (b3 = this.b.b3()) != null) {
                    b3.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends ar6<rj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsFeedFragment frsFeedFragment, Class<rj7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(rj7 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.a()) {
                    this.b.c3().h.setVisibility(0);
                } else if (!this.b.isResumed()) {
                    this.b.c3().h.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends ar6<tj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsFeedFragment frsFeedFragment, Class<tj7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(tj7 event) {
            ni7 value;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                FragmentActivity activity = this.b.getActivity();
                if (!(activity instanceof ViewModelStoreOwner)) {
                    activity = null;
                }
                if (activity == null || (value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue()) == null) {
                    return;
                }
                if (!Intrinsics.areEqual(event.b(), String.valueOf(value.e()))) {
                    return;
                }
                if (!event.a() && this.b.isResumed()) {
                    this.b.o3();
                } else {
                    this.b.n = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsFeedFragment frsFeedFragment) {
            super(2921630);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment};
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
            this.a = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Long l;
            long j;
            LinearLayoutManager linearLayoutManager;
            b67 b67Var;
            ob7 ob7Var;
            Map<String, String> a;
            String str;
            Map<String, String> a2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
                FrsFeedFragment frsFeedFragment = this.a;
                StaggeredGridLayoutManager staggeredGridLayoutManager = null;
                if (data instanceof Long) {
                    l = (Long) data;
                } else {
                    l = null;
                }
                if (l != null) {
                    j = l.longValue();
                } else {
                    j = 0;
                }
                int i = -1;
                int i2 = 0;
                for (Object obj : frsFeedFragment.f.i().a()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    nb7 nb7Var = (nb7) obj;
                    if (nb7Var instanceof b67) {
                        b67Var = (b67) nb7Var;
                    } else {
                        b67Var = null;
                    }
                    String str2 = "";
                    if (b67Var != null) {
                        String valueOf = String.valueOf(j);
                        r57 r57Var = b67Var.b;
                        if (Intrinsics.areEqual(valueOf, (r57Var == null || (a2 = r57Var.a()) == null || (r7 = a2.get("thread_id")) == null) ? "" : "")) {
                            i = i3;
                        }
                    }
                    if (nb7Var instanceof ob7) {
                        ob7Var = (ob7) nb7Var;
                    } else {
                        ob7Var = null;
                    }
                    if (ob7Var != null) {
                        String valueOf2 = String.valueOf(j);
                        r57 r57Var2 = ob7Var.b;
                        if (r57Var2 != null && (a = r57Var2.a()) != null && (str = a.get("thread_id")) != null) {
                            str2 = str;
                        }
                        if (Intrinsics.areEqual(valueOf2, str2)) {
                            i = i3;
                        }
                    }
                    i2 = i3;
                }
                if (i != -1) {
                    RecyclerView.LayoutManager layoutManager = frsFeedFragment.c3().g.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        linearLayoutManager = (LinearLayoutManager) layoutManager;
                    } else {
                        linearLayoutManager = null;
                    }
                    if (linearLayoutManager != null) {
                        linearLayoutManager.scrollToPositionWithOffset(i, 0);
                    }
                    RecyclerView.LayoutManager layoutManager2 = frsFeedFragment.c3().g.getLayoutManager();
                    if (layoutManager2 instanceof StaggeredGridLayoutManager) {
                        staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager2;
                    }
                    if (staggeredGridLayoutManager != null) {
                        staggeredGridLayoutManager.scrollToPositionWithOffset(i, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(FrsFeedFragment frsFeedFragment) {
            super(2921381);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFeedFragment};
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
            this.a = frsFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object obj;
            KeyEvent keyEvent;
            Object obj2;
            View h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                f37.r rVar = null;
                if (customResponsedMessage != null) {
                    obj = customResponsedMessage.getData();
                } else {
                    obj = null;
                }
                if (!(obj instanceof KeyEvent)) {
                    return;
                }
                Object data = customResponsedMessage.getData();
                if (data instanceof KeyEvent) {
                    keyEvent = (KeyEvent) data;
                } else {
                    keyEvent = null;
                }
                if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    AutoPlayController autoPlayController = this.a.o;
                    if (autoPlayController != null && (h = autoPlayController.h()) != null) {
                        obj2 = h.getTag();
                    } else {
                        obj2 = null;
                    }
                    if (obj2 instanceof f37.r) {
                        rVar = obj2;
                    }
                    if (rVar != null) {
                        rVar.onVolumeUp();
                    }
                }
            }
        }
    }

    public FrsFeedFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = new LinkedHashMap();
        this.f = new pl7();
        this.g = new Object();
        this.l = new qn7();
        this.m = new Object();
        this.p = new d(this);
        this.q = new k(this);
        this.r = new j(this);
        this.s = new b(this);
        this.t = "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroyView();
            Log.d("FrsFeedFragment", "onDestroyView = " + this);
            Runnable runnable = this.w;
            if (runnable != null) {
                SafeHandler.getInst().removeCallbacks(runnable);
            }
            this.a = null;
            this.e = null;
            f3().a();
            this.c = null;
            e3().a();
            this.b = null;
            d3().c();
            this.d = null;
            this.i = null;
            AutoPlayController autoPlayController = this.o;
            if (autoPlayController != null) {
                autoPlayController.o(null);
            }
            AutoPlayController autoPlayController2 = this.o;
            if (autoPlayController2 != null) {
                autoPlayController2.l();
            }
            this.o = null;
            G2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        List<SubTabItem> list;
        TopController m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            Log.d("FrsFeedFragment", "onResume = " + this);
            if (!this.f.n()) {
                FragmentActivity activity = getActivity();
                boolean z = true;
                if ((activity == null || (m = xh7.m(activity)) == null || !m.I()) ? false : false) {
                    z3(false);
                }
            } else {
                D3();
            }
            AutoPlayController autoPlayController = this.o;
            if (autoPlayController != null) {
                autoPlayController.k(false);
            }
            if (this.n) {
                if (c3().l.getVisibility() == 8) {
                    o3();
                } else {
                    xl7 c2 = this.f.i().c();
                    xl7 xl7Var = null;
                    if (c2 != null) {
                        list = c2.b();
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        xl7Var = new xl7(list, 0);
                    }
                    d3().f(xl7Var);
                }
                this.n = false;
            }
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            zq6 b2 = xq6.b();
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            b2.b(new wq6(uniqueId, Reflection.getOrCreateKotlinClass(qj7.class)), new e(this, qj7.class));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().observe(activity, new Observer() { // from class: com.baidu.tieba.pn7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            FrsFeedFragment.w3(FrsFeedFragment.this, (ni7) obj);
                        }
                    }
                });
            }
            zq6 b3 = xq6.b();
            BdUniqueId uniqueId2 = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
            b3.b(new wq6(uniqueId2, Reflection.getOrCreateKotlinClass(sj7.class)), new f(this, sj7.class));
            zq6 b4 = xq6.b();
            BdUniqueId uniqueId3 = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId3, "uniqueId");
            b4.b(new wq6(uniqueId3, Reflection.getOrCreateKotlinClass(v95.class)), new g(this, v95.class));
        }
    }

    public static final void A3(FrsFeedFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d3().k();
            this$0.c3().h.setRefreshing(true);
            this$0.j = true;
            this$0.f.f(true);
        }
    }

    public final void Z2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            o3();
            a3(CollectionsKt__CollectionsJVMKt.listOf(str));
        }
    }

    @Override // com.baidu.tieba.ai7
    public <T extends sh7> T j2(KClass<T> clazz) {
        InterceptResult invokeL;
        ai7 ai7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            FragmentActivity activity = getActivity();
            if (activity instanceof ai7) {
                ai7Var = (ai7) activity;
            } else {
                ai7Var = null;
            }
            if (ai7Var == null) {
                return null;
            }
            return (T) ai7Var.j2(clazz);
        }
        return (T) invokeL.objValue;
    }

    public final boolean m3(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
            if (!isNetWorkAvailable && z) {
                BdUtilHelper.showToast(getActivity(), (int) R.string.network_not_available);
            }
            return !isNetWorkAvailable;
        }
        return invokeZ.booleanValue;
    }

    public static final void w3(FrsFeedFragment this$0, ni7 ni7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, this$0, ni7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d3().i(ni7Var.o());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, android.os.Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            x3();
            y3();
            v3();
            f();
        }
    }

    public static final void k3(FrsFeedFragment this$0, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, this$0, i2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d3().j();
            this$0.j = false;
            hl7 hl7Var = this$0.k;
            if (hl7Var != null) {
                FrameLayout frameLayout = this$0.c3().c;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frsRefreshTipContainer");
                hl7Var.b(i2, frameLayout);
            }
            this$0.w = null;
        }
    }

    public static /* synthetic */ boolean n3(FrsFeedFragment frsFeedFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return frsFeedFragment.m3(z);
    }

    public static /* synthetic */ void r3(FrsFeedFragment frsFeedFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        frsFeedFragment.q3(z);
    }

    @Override // com.baidu.tieba.vl7
    public void A0(OperateType operateType, boolean z, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{operateType, Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(operateType, "operateType");
            if (this.a == null) {
                return;
            }
            j3(operateType, z, str, i3);
        }
    }

    public final void B3() {
        FragmentActivity activity;
        Boolean inEditMode;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (activity = getActivity()) != null && (inEditMode = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).h().getValue()) != null) {
            Intrinsics.checkNotNullExpressionValue(inEditMode, "inEditMode");
            g3(inEditMode.booleanValue());
        }
    }

    public final void C3() {
        boolean z;
        bi7 bi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinkageController linkageController = (LinkageController) j2(Reflection.getOrCreateKotlinClass(LinkageController.class));
            if (linkageController != null) {
                z = linkageController.V();
            } else {
                z = false;
            }
            if (z && (bi7Var = (bi7) j2(Reflection.getOrCreateKotlinClass(bi7.class))) != null) {
                bi7Var.u();
            }
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean hasMore = this.f.hasMore();
            int size = this.f.i().a().size();
            boolean z = false;
            if (1 <= size && size < 6) {
                z = true;
            }
            if (hasMore && z) {
                f3().c();
            }
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.u) {
                b3().A(CollectionsKt__CollectionsKt.emptyList());
            } else {
                b3().setList(CollectionsKt__CollectionsKt.emptyList());
            }
            f3().d(false, false);
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || this.f.p() != 301) {
            return;
        }
        zq6 b2 = xq6.b();
        BdUniqueId uniqueId = getUniqueId();
        Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
        b2.b(new wq6(uniqueId, this.m), new i(this, tj7.class));
    }

    @Override // com.baidu.tieba.vn7
    public void C2(ThreadData data, JSONObject requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, data, requestParams) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(requestParams, "requestParams");
            boolean isEmpty = this.f.i().a().isEmpty();
            int k2 = this.f.k(data);
            if (this.u) {
                if (k2 >= 0) {
                    b3().z(k2);
                }
            } else {
                b3().notifyDataSetChanged();
            }
            if (isEmpty && k2 >= 0) {
                e3().f(false);
            }
        }
    }

    @Override // com.baidu.tieba.vn7
    public void U0(nb7<?> data, JSONObject requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, data, requestParams) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(requestParams, "requestParams");
            boolean isEmpty = this.f.i().a().isEmpty();
            int j2 = this.f.j(data);
            if (this.u) {
                if (j2 >= 0) {
                    b3().z(j2);
                }
            } else {
                b3().notifyDataSetChanged();
            }
            if (isEmpty && j2 >= 0) {
                e3().f(false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r2 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
        if (r2 < 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a3(List<String> list) {
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            Iterator<nb7<?>> it = this.f.i().a().iterator();
            int i2 = -1;
            int i3 = -1;
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                i2++;
                if ((next instanceof j57) && (s57Var = ((j57) next).c) != null) {
                    String m = s57Var.m();
                    if (m != null && list.contains(m)) {
                        it.remove();
                    }
                } else if (next instanceof ob7) {
                    ob7 ob7Var = (ob7) next;
                    if (ob7Var.b() instanceof xf7) {
                        Object b2 = ob7Var.b();
                        if (b2 != null) {
                            String r = ((xf7) b2).r();
                            if (r != null && list.contains(r)) {
                                it.remove();
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.forum.component.uistate.CardStaggeredVideoUiState");
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                z = true;
            }
            if (z) {
                if (this.u) {
                    b3().x(i3);
                } else {
                    b3().notifyDataSetChanged();
                }
                if (!this.f.hasMore() && this.f.i().a().isEmpty()) {
                    e3().f(true);
                    s3();
                }
            }
        }
    }

    public final FrsTemplateAdapter b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsTemplateAdapter frsTemplateAdapter = this.e;
            Intrinsics.checkNotNull(frsTemplateAdapter);
            return frsTemplateAdapter;
        }
        return (FrsTemplateAdapter) invokeV.objValue;
    }

    public final FragmentFrsFeedBinding c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FragmentFrsFeedBinding fragmentFrsFeedBinding = this.a;
            Intrinsics.checkNotNull(fragmentFrsFeedBinding);
            return fragmentFrsFeedBinding;
        }
        return (FragmentFrsFeedBinding) invokeV.objValue;
    }

    public final sn7 d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            sn7 sn7Var = this.d;
            Intrinsics.checkNotNull(sn7Var);
            return sn7Var;
        }
        return (sn7) invokeV.objValue;
    }

    public final rn7 e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            rn7 rn7Var = this.b;
            Intrinsics.checkNotNull(rn7Var);
            return rn7Var;
        }
        return (rn7) invokeV.objValue;
    }

    public final tn7 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            tn7 tn7Var = this.c;
            Intrinsics.checkNotNull(tn7Var);
            return tn7Var;
        }
        return (tn7) invokeV.objValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            u3();
            t3();
            r3(this, false, 1, null);
            s3();
            if (this.f.l()) {
                d3().j();
            }
        }
    }

    public final void o3() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f.i().a().size() != 0) {
                z = true;
            } else {
                z = false;
            }
            z3(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            this.f.onDestroy();
            om7 om7Var = this.h;
            if (om7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                om7Var = null;
            }
            om7Var.d();
            hl7 hl7Var = this.k;
            if (hl7Var != null) {
                hl7Var.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            AutoPlayController autoPlayController = this.o;
            if (autoPlayController != null) {
                autoPlayController.k(true);
            }
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            f3().d(this.f.hasMore(), !this.f.i().a().isEmpty());
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            d3().e(this.f.i().b());
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            d3().f(this.f.i().c());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.u) {
                return false;
            }
            return VideoAudioHelper.checkNeedAutoPlay(2);
        }
        return invokeV.booleanValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            zq6 b2 = xq6.b();
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            b2.b(new wq6(uniqueId, this.g), new h(this, rj7.class));
        }
    }

    @Override // com.baidu.tieba.gb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.e != null && this.d != null && this.a != null) {
            if (this.u) {
                b3().u();
            } else {
                b3().f();
            }
            d3().b();
            EMManager.from(c3().getRoot()).setBackGroundColor(R.color.CAM_X0202);
        }
    }

    public final boolean p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            FragmentActivity activity = getActivity();
            boolean z = false;
            if (activity != null) {
                Boolean value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).h().getValue();
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(value, "ViewModelProvider(it).ge…InEditMode.value ?: false");
                    z = value.booleanValue();
                }
                if (z) {
                    BdUtilHelper.showToast(getActivity(), (int) R.string.obfuscated_res_0x7f0f0452);
                }
            }
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void g3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            for (nb7<?> nb7Var : this.f.i().a()) {
                if (nb7Var instanceof ka7) {
                    ((ka7) nb7Var).d(new t57(z));
                }
            }
            if (!this.u) {
                b3().notifyDataSetChanged();
            }
            f3().b(z);
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (this.u) {
                if (z) {
                    b3().t(this.f.i().a());
                } else {
                    b3().A(this.f.i().a());
                }
            } else {
                b3().setList(this.f.i().a());
            }
            AutoPlayController autoPlayController = this.o;
            if (autoPlayController != null) {
                autoPlayController.p(true);
            }
            AutoPlayController autoPlayController2 = this.o;
            if (autoPlayController2 != null) {
                autoPlayController2.r();
            }
        }
    }

    public final void h3() {
        s57 s57Var;
        List<nb7<? extends Object>> c2;
        g57 g57Var;
        y77 m;
        List<d87> manageItemList;
        u77 u77Var;
        m57 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Iterator<T> it = this.f.i().a().iterator();
            while (it.hasNext()) {
                Object b2 = ((nb7) it.next()).b();
                if (b2 instanceof s57) {
                    s57Var = (s57) b2;
                } else {
                    s57Var = null;
                }
                if (s57Var != null && (c2 = s57Var.c()) != null) {
                    Iterator<T> it2 = c2.iterator();
                    while (it2.hasNext()) {
                        Object b3 = ((nb7) it2.next()).b();
                        if (b3 instanceof g57) {
                            g57Var = (g57) b3;
                        } else {
                            g57Var = null;
                        }
                        if (g57Var != null && (m = g57Var.m()) != null && (manageItemList = m.m) != null) {
                            Intrinsics.checkNotNullExpressionValue(manageItemList, "manageItemList");
                            for (d87 d87Var : manageItemList) {
                                Object a3 = d87Var.a();
                                if (a3 instanceof u77) {
                                    u77Var = (u77) a3;
                                } else {
                                    u77Var = null;
                                }
                                if (u77Var != null && (a2 = u77Var.a()) != null) {
                                    a2.d(a2.c() + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void i3(vj7 event) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int c2 = event.c();
            if (c2 != 0) {
                if (c2 == 4 && (str = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.b())) != null) {
                    Z2(str);
                    return;
                }
                return;
            }
            a3(event.b());
        }
    }

    public final void j3(OperateType operateType, boolean z, String str, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{operateType, Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) {
            boolean z2 = true;
            BdUniqueId bdUniqueId = null;
            switch (a.$EnumSwitchMapping$0[operateType.ordinal()]) {
                case 1:
                    c3().h.setRefreshing(false);
                    Runnable runnable = this.w;
                    if (runnable != null) {
                        SafeHandler.getInst().removeCallbacks(runnable);
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.baidu.tieba.kn7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                FrsFeedFragment.k3(FrsFeedFragment.this, i2);
                            }
                        }
                    };
                    SafeHandler.getInst().postDelayed(runnable2, 800L);
                    this.w = runnable2;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    if (z) {
                        if (this.f.i().a().isEmpty()) {
                            soa.a("frs_new", true);
                            bp5.a aVar = bp5.a;
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                bdUniqueId = xh7.a(activity);
                            }
                            aVar.h(bdUniqueId);
                        }
                        e3().f(this.f.i().a().isEmpty());
                        d3().j();
                        break;
                    } else {
                        e3().e(false, this.f.i().a().isEmpty(), str);
                        break;
                    }
                case 6:
                    if (this.v) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                        break;
                    }
                    break;
                default:
                    do7.b(null, 1, null);
                    break;
            }
            if (operateType != OperateType.LOADMORE) {
                z2 = false;
            }
            q3(z2);
            s3();
            if (operateType == OperateType.LOADMORE) {
                B3();
            }
            D3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        ql7 a2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                a2 = new pl7();
            } else {
                android.os.Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new android.os.Bundle();
                }
                BdUniqueId uniqueId = getUniqueId();
                Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
                a2 = wn7.a(activity, arguments, uniqueId, this);
            }
            this.f = a2;
            android.os.Bundle arguments2 = getArguments();
            boolean z5 = true;
            if (arguments2 != null && arguments2.getInt("forum_tab_id") == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                android.os.Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    str = arguments3.getString("forum_tab_name");
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual("热门", str)) {
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    this.k = new hl7(requireContext);
                }
            }
            android.os.Bundle arguments4 = getArguments();
            if (arguments4 != null && arguments4.getInt("forum_tab_id") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.t = "frs_hot_tab";
            } else {
                android.os.Bundle arguments5 = getArguments();
                if (arguments5 != null && arguments5.getInt("forum_tab_id") == 503) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.t = "frs_new_tab";
                }
            }
            android.os.Bundle arguments6 = getArguments();
            if (arguments6 != null && arguments6.getInt("forum_staggered_tab") == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.u = z4;
            android.os.Bundle arguments7 = getArguments();
            this.v = (arguments7 == null || arguments7.getInt("forum_tab_type") != 100) ? false : false;
            BdUniqueId uniqueId2 = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
            android.os.Bundle arguments8 = getArguments();
            if (arguments8 == null) {
                arguments8 = new android.os.Bundle();
            }
            this.h = new om7(uniqueId2, arguments8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, android.os.Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Log.d("FrsFeedFragment", "onCreateView = " + this);
            this.a = FragmentFrsFeedBinding.c(inflater, viewGroup, false);
            c3().h.setDisableRefresh(true);
            this.i = new n55(getPageContext());
            c3().h.setProgressView(this.i);
            if (this.u) {
                c3().g.setItemAnimator(null);
                c3().g.useNotifyItemRangeChanged();
                c3().g.setLayoutManager(new StaggeredGridLayoutManager(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FrsFeedFragment a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2, 1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean canScrollVertically() {
                        InterceptResult invokeV;
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            z = this.a.j;
                            if (z) {
                                return false;
                            }
                            return super.canScrollVertically();
                        }
                        return invokeV.booleanValue;
                    }
                });
                c3().g.addItemDecoration(new FrsStaggerSpaceItemDecoration(2, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X003), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003)));
            } else {
                BdRecyclerView bdRecyclerView = c3().g;
                final Context context = getContext();
                bdRecyclerView.setLayoutManager(new LinearLayoutManager(this, context) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FrsFeedFragment a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(context);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Context) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean canScrollVertically() {
                        InterceptResult invokeV;
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            z = this.a.j;
                            if (z) {
                                return false;
                            }
                            return super.canScrollVertically();
                        }
                        return invokeV.booleanValue;
                    }
                });
            }
            c3().g.setFadingEdgeLength(0);
            c3().g.setOverScrollMode(2);
            FrsTemplateAdapter frsTemplateAdapter = new FrsTemplateAdapter();
            frsTemplateAdapter.d(new c(this));
            android.os.Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new android.os.Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
            frsTemplateAdapter.b(new mm7(arguments));
            BdRecyclerView bdRecyclerView2 = c3().g;
            Intrinsics.checkNotNullExpressionValue(bdRecyclerView2, "binding.recyclerView");
            frsTemplateAdapter.s(bdRecyclerView2);
            frsTemplateAdapter.j(new cd7());
            x27 x27Var = new x27(2);
            x27Var.c(getPageContext());
            x27Var.b("FRS");
            frsTemplateAdapter.j(x27Var);
            frsTemplateAdapter.j(new b37(l88.e(), "frs", "frs_feed", this.t));
            frsTemplateAdapter.o(new wo7());
            frsTemplateAdapter.j(new kb7());
            this.e = frsTemplateAdapter;
            NestedScrollView nestedScrollView = c3().e;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "binding.fullLoadingRootView");
            FrameLayout frameLayout = c3().d;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fullLoadingContainer");
            this.b = new rn7(nestedScrollView, frameLayout, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.z3(false);
                }
            });
            BdRecyclerView bdRecyclerView3 = c3().g;
            Intrinsics.checkNotNullExpressionValue(bdRecyclerView3, "binding.recyclerView");
            this.c = new tn7(bdRecyclerView3, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

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
                    boolean m3;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.this$0.f.g()) {
                        return;
                    }
                    m3 = this.this$0.m3(false);
                    if (m3) {
                        return;
                    }
                    this.this$0.b3().B();
                    z = this.this$0.u;
                    if (z) {
                        this.this$0.c3().g.stopScroll();
                    }
                    this.this$0.f.b();
                }
            });
            qn7 qn7Var = this.l;
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            qn7Var.a(uniqueId, this.f, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

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
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        z = this.this$0.u;
                        if (z) {
                            this.this$0.b3().y();
                        } else {
                            this.this$0.b3().notifyDataSetChanged();
                        }
                    }
                }
            });
            this.d = new sn7(c3(), new Function1<TabLayout.Tab, Boolean>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(TabLayout.Tab tab) {
                    InterceptResult invokeL;
                    boolean p3;
                    boolean z;
                    rn7 e3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, tab)) == null) {
                        Intrinsics.checkNotNullParameter(tab, "tab");
                        p3 = this.this$0.p3();
                        if (p3 && !this.this$0.f.g()) {
                            Object tag = tab.getTag();
                            if (this.this$0.isResumed() && (tag instanceof Integer)) {
                                this.this$0.C3();
                                this.this$0.Y2();
                                e3 = this.this$0.e3();
                                e3.m();
                                this.this$0.f.e(((Number) tag).intValue());
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    return (Boolean) invokeL.objValue;
                }
            }, new Function1<vs7, Boolean>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(vs7 sortData) {
                    InterceptResult invokeL;
                    boolean p3;
                    boolean z;
                    rn7 e3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sortData)) == null) {
                        Intrinsics.checkNotNullParameter(sortData, "sortData");
                        p3 = this.this$0.p3();
                        if (!p3 || this.this$0.f.g()) {
                            z = false;
                        } else {
                            this.this$0.C3();
                            this.this$0.Y2();
                            e3 = this.this$0.e3();
                            e3.m();
                            this.this$0.f.o(sortData.b);
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    return (Boolean) invokeL.objValue;
                }
            }, new Function1<TabLayout.Tab, Boolean>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsFeedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(TabLayout.Tab tab) {
                    InterceptResult invokeL;
                    boolean p3;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, tab)) == null) {
                        Intrinsics.checkNotNullParameter(tab, "<anonymous parameter 0>");
                        p3 = this.this$0.p3();
                        if (!p3 || this.this$0.f.g()) {
                            z = false;
                        } else {
                            this.this$0.C3();
                            this.this$0.o3();
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    return (Boolean) invokeL.objValue;
                }
            });
            BdPageContext<?> a2 = a5.a(getContext());
            if (a2 != null) {
                BdRecyclerView bdRecyclerView4 = c3().g;
                Intrinsics.checkNotNullExpressionValue(bdRecyclerView4, "binding.recyclerView");
                AutoPlayController autoPlayController = new AutoPlayController(a2, bdRecyclerView4);
                this.o = autoPlayController;
                if (autoPlayController != null) {
                    autoPlayController.o(this.p);
                }
                AutoPlayController autoPlayController2 = this.o;
                if (autoPlayController2 != null) {
                    BdUniqueId uniqueId2 = getUniqueId();
                    Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
                    autoPlayController2.q(uniqueId2);
                }
                registerListener(this.q);
                registerListener(this.r);
                registerListener(this.s);
            }
            l3();
            RelativeLayout root = c3().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    public final void z3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048617, this, z) != null) || this.f.g()) {
            return;
        }
        if (n3(this, false, 1, null)) {
            if (!this.f.n()) {
                e3().e(true, false, getString(R.string.network_not_available));
                return;
            }
            return;
        }
        if (z) {
            if (this.u) {
                c3().g.scrollToPosition(0);
                c3().g.post(new Runnable() { // from class: com.baidu.tieba.jn7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            FrsFeedFragment.A3(FrsFeedFragment.this);
                        }
                    }
                });
            } else {
                d3().k();
                c3().g.scrollToPosition(0);
                c3().h.setRefreshing(true);
                this.j = true;
                this.f.f(true);
            }
        } else {
            e3().m();
            this.f.f(false);
        }
        AutoPlayController autoPlayController = this.o;
        if (autoPlayController != null) {
            autoPlayController.p(false);
        }
    }
}
