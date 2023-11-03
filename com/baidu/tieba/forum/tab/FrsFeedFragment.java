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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
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
import com.baidu.tieba.bi7;
import com.baidu.tieba.ci7;
import com.baidu.tieba.ck7;
import com.baidu.tieba.d57;
import com.baidu.tieba.di7;
import com.baidu.tieba.e57;
import com.baidu.tieba.f57;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.fi7;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.controller.TopController;
import com.baidu.tieba.forum.databinding.FragmentFrsFeedBinding;
import com.baidu.tieba.forum.model.OperateType;
import com.baidu.tieba.forum.tab.FrsFeedFragment;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.g55;
import com.baidu.tieba.g77;
import com.baidu.tieba.gh7;
import com.baidu.tieba.iq7;
import com.baidu.tieba.k77;
import com.baidu.tieba.kk7;
import com.baidu.tieba.kl7;
import com.baidu.tieba.km7;
import com.baidu.tieba.l27;
import com.baidu.tieba.ll7;
import com.baidu.tieba.lq6;
import com.baidu.tieba.mk7;
import com.baidu.tieba.mq6;
import com.baidu.tieba.n57;
import com.baidu.tieba.na7;
import com.baidu.tieba.nl7;
import com.baidu.tieba.oc7;
import com.baidu.tieba.og7;
import com.baidu.tieba.oj7;
import com.baidu.tieba.ol7;
import com.baidu.tieba.oq6;
import com.baidu.tieba.p27;
import com.baidu.tieba.p77;
import com.baidu.tieba.pa7;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.pq6;
import com.baidu.tieba.q58;
import com.baidu.tieba.ql7;
import com.baidu.tieba.rl7;
import com.baidu.tieba.s47;
import com.baidu.tieba.sa7;
import com.baidu.tieba.so5;
import com.baidu.tieba.t27;
import com.baidu.tieba.tg7;
import com.baidu.tieba.v47;
import com.baidu.tieba.vl7;
import com.baidu.tieba.w97;
import com.baidu.tieba.wa7;
import com.baidu.tieba.wg7;
import com.baidu.tieba.wj7;
import com.baidu.tieba.xg7;
import com.baidu.tieba.xj7;
import com.baidu.tieba.y47;
import com.baidu.tieba.ya7;
import com.baidu.tieba.za7;
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
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001|B\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020;H\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u001fH\u0002J\u0016\u0010C\u001a\u00020;2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001f0EH\u0002J'\u0010F\u001a\u0004\u0018\u0001HG\"\b\b\u0000\u0010G*\u00020H2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HG0JH\u0016¢\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020)J\b\u0010N\u001a\u00020;H\u0002J\u000e\u0010O\u001a\u00020;2\u0006\u0010P\u001a\u00020QJ*\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020)2\b\u0010V\u001a\u0004\u0018\u00010\u001f2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010Y\u001a\u00020;H\u0002J\u0012\u0010Z\u001a\u00020)2\b\b\u0002\u0010[\u001a\u00020)H\u0002J\u0006\u0010\\\u001a\u00020;J\b\u0010]\u001a\u00020)H\u0002J\b\u0010^\u001a\u00020;H\u0016J\u0012\u0010_\u001a\u00020;2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J$\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010h\u001a\u00020;H\u0016J\b\u0010i\u001a\u00020;H\u0016J\b\u0010j\u001a\u00020;H\u0016J2\u0010k\u001a\u00020;2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020)2\u0006\u0010l\u001a\u00020X2\b\u0010V\u001a\u0004\u0018\u00010\u001f2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010m\u001a\u00020;H\u0016J\u001a\u0010n\u001a\u00020;2\u0006\u0010o\u001a\u00020c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010p\u001a\u00020;H\u0002J\b\u0010q\u001a\u00020;H\u0002J\b\u0010r\u001a\u00020;H\u0002J\b\u0010s\u001a\u00020;H\u0002J\b\u0010t\u001a\u00020;H\u0002J\b\u0010u\u001a\u00020;H\u0002J\u0010\u0010v\u001a\u00020;2\u0006\u0010w\u001a\u00020)H\u0002J\b\u0010x\u001a\u00020\u001fH\u0016J\b\u0010y\u001a\u00020;H\u0002J\b\u0010z\u001a\u00020;H\u0002J\b\u0010{\u001a\u00020)H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/baidu/tieba/forum/tab/FrsFeedFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/forum/model/ResultCallback;", "Lcom/baidu/tbadk/core/util/videoPreload/IVideoNeedPreload;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Lcom/baidu/tieba/forum/controller/IGetActivityController;", "Lcom/baidu/tieba/forum/tab/IFakeWallTabData;", "()V", "_adapter", "Lcom/baidu/tieba/feed/list/ITemplateAdapter;", "_binding", "Lcom/baidu/tieba/forum/databinding/FragmentFrsFeedBinding;", "_frsHeadViewControl", "Lcom/baidu/tieba/forum/tab/FrsHeadViewControl;", "_fullViewControl", "Lcom/baidu/tieba/forum/tab/FrsFeedFullViewControl;", "_loadMoreViewControl", "Lcom/baidu/tieba/forum/tab/FrsLoadMoreViewControl;", "adapter", "getAdapter", "()Lcom/baidu/tieba/feed/list/ITemplateAdapter;", "autoPlayController", "Lcom/baidu/tieba/play/AutoPlayController;", "binding", "getBinding", "()Lcom/baidu/tieba/forum/databinding/FragmentFrsFeedBinding;", "exposeListener", "Lcom/baidu/tieba/forum/statistic/ForumFeedExposeLog;", "feedModel", "Lcom/baidu/tieba/forum/model/FrsFeedModel;", "formTab", "", "frsFeedBackControl", "Lcom/baidu/tieba/forum/tab/FrsFeedBackControl;", "frsHeadViewControl", "getFrsHeadViewControl", "()Lcom/baidu/tieba/forum/tab/FrsHeadViewControl;", "fullViewControl", "getFullViewControl", "()Lcom/baidu/tieba/forum/tab/FrsFeedFullViewControl;", "isPullingRefresh", "", "loadMoreViewControl", "getLoadMoreViewControl", "()Lcom/baidu/tieba/forum/tab/FrsLoadMoreViewControl;", "onCurrentCardBackgroundListener", "Lcom/baidu/tieba/play/AutoPlayController$OnCurrentCardBackgroundListener;", "pullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "refreshFinishRunnable", "Ljava/lang/Runnable;", "refreshTipManager", "Lcom/baidu/tieba/forum/management/RefreshTipManager;", "videoTabLastPositionListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "visibilityTag", "", "volumeUpOnKeyDownListener", "addThreadData", "", "data", "Lcom/baidu/tbadk/core/data/ThreadData;", "requestParmas", "Lorg/json/JSONObject;", "clearListView", "commitTopThread", "threadId", "deleteThread", "threadIdList", "", "getActivityController", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tieba/forum/controller/BaseActivityController;", Bundle.EXTRA_KEY_CLAZZ, "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/baidu/tieba/forum/controller/BaseActivityController;", "handleEditModeEvent", "isInEditMode", "handleRecommendSuccess", "handleThreadOperationEvent", "event", "Lcom/baidu/tieba/forum/event/ThreadOperationEvent;", "handlerOperateType", "operateType", "Lcom/baidu/tieba/forum/model/OperateType;", "success", "errorMessage", "updateCount", "", "initFeedView", "interceptByNoNet", PopItemMethodConstant.showToast, "manualRefresh", "notInEditMode", "onChangeSkin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onResult", CloudStabilityUBCUtils.KEY_ERROR_CODE, "onResume", "onViewCreated", "view", "refreshListView", "refreshLoadMore", "refreshSortView", "refreshTabView", "registerEvent", "registerFragmentVisibilityEvent", "startRefresh", "fromRefreshBtn", "taskActionId", "tryScrollToTop", "tryToLoadMore", "videoNeedPreload", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsFeedFragment extends BaseFragment implements ck7, IVideoNeedPreload, sa7, wg7, ql7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentFrsFeedBinding a;
    public ll7 b;
    public ol7 c;
    public nl7 d;
    public pa7 e;
    public xj7 f;
    public final Object g;
    public mk7 h;
    public g55 i;
    public boolean j;
    public oj7 k;
    public final kl7 l;
    public AutoPlayController m;
    public final AutoPlayController.a n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public String q;
    public Runnable r;
    public Map<Integer, View> s;

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

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.s.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements na7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        public b(FrsFeedFragment frsFeedFragment) {
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

        @Override // com.baidu.tieba.na7.c
        public void b(RecyclerView rv) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                mk7 mk7Var = this.a.h;
                if (mk7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                    mk7Var = null;
                }
                mk7Var.b(rv);
            }
        }

        @Override // com.baidu.tieba.na7.c
        public void a(za7<?> data, ya7<?, ?> template, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(template, "template");
                mk7 mk7Var = this.a.h;
                BdUniqueId bdUniqueId = null;
                if (mk7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                    mk7Var = null;
                }
                mk7Var.a(data, template, i);
                so5.a aVar = so5.a;
                FragmentActivity activity = this.a.getActivity();
                if (activity != null) {
                    bdUniqueId = tg7.a(activity);
                }
                aVar.h(bdUniqueId);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements AutoPlayController.a {
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

        @Override // com.baidu.tieba.play.AutoPlayController.a
        public void onBackground(boolean z) {
            Object obj;
            View h;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            AutoPlayController autoPlayController = this.a.m;
            t27.r rVar = null;
            if (autoPlayController != null && (h = autoPlayController.h()) != null) {
                obj = h.getTag();
            } else {
                obj = null;
            }
            if (obj instanceof t27.r) {
                rVar = (t27.r) obj;
            }
            if (rVar != null) {
                rVar.onBackground(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends pq6<ai7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsFeedFragment frsFeedFragment, Class<ai7> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(ai7 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.getUniqueId())) {
                    this.b.Y2();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends pq6<ci7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsFeedFragment frsFeedFragment, Class<ci7> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(ci7 event) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                FragmentActivity activity = this.b.getActivity();
                if (activity != null) {
                    FrsFeedFragment frsFeedFragment = this.b;
                    gh7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
                    if (value != null) {
                        str = Long.valueOf(value.d()).toString();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, event.a())) {
                        frsFeedFragment.R2();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends pq6<bi7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsFeedFragment frsFeedFragment, Class<bi7> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(bi7 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.a()) {
                    this.b.M2().h.setVisibility(0);
                } else if (!this.b.isResumed()) {
                    this.b.M2().h.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsFeedFragment frsFeedFragment) {
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
            n57 n57Var;
            LinearLayoutManager linearLayoutManager;
            Map<String, String> a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
                FrsFeedFragment frsFeedFragment = this.a;
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
                int i = 0;
                for (Object obj : frsFeedFragment.f.i().a()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    za7 za7Var = (za7) obj;
                    if (za7Var instanceof n57) {
                        n57Var = (n57) za7Var;
                    } else {
                        n57Var = null;
                    }
                    if (n57Var != null) {
                        String valueOf = String.valueOf(j);
                        d57 d57Var = n57Var.b;
                        if (Intrinsics.areEqual(valueOf, (d57Var == null || (a = d57Var.a()) == null || (r6 = a.get("thread_id")) == null) ? "" : "")) {
                            RecyclerView.LayoutManager layoutManager = frsFeedFragment.M2().g.getLayoutManager();
                            if (layoutManager instanceof LinearLayoutManager) {
                                linearLayoutManager = (LinearLayoutManager) layoutManager;
                            } else {
                                linearLayoutManager = null;
                            }
                            if (linearLayoutManager != null) {
                                linearLayoutManager.scrollToPositionWithOffset(i2, 0);
                            }
                        }
                    }
                    i = i2;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsFeedFragment frsFeedFragment) {
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
                t27.r rVar = null;
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
                    AutoPlayController autoPlayController = this.a.m;
                    if (autoPlayController != null && (h = autoPlayController.h()) != null) {
                        obj2 = h.getTag();
                    } else {
                        obj2 = null;
                    }
                    if (obj2 instanceof t27.r) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = new LinkedHashMap();
        this.f = new wj7();
        this.g = new Object();
        this.l = new kl7();
        this.n = new c(this);
        this.o = new h(this);
        this.p = new g(this);
        this.q = "";
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FragmentActivity activity = getActivity();
            boolean z = false;
            if (activity != null) {
                Boolean value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).f().getValue();
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(value, "ViewModelProvider(it).ge…InEditMode.value ?: false");
                    z = value.booleanValue();
                }
                if (z) {
                    BdUtilHelper.showToast(getActivity(), (int) R.string.obfuscated_res_0x7f0f044a);
                }
            }
            return !z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        TopController k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            Log.d("FrsFeedFragment", "onResume = " + this);
            if (!this.f.m()) {
                FragmentActivity activity = getActivity();
                boolean z = true;
                if ((activity == null || (k = tg7.k(activity)) == null || !k.H()) ? false : false) {
                    h3(false);
                }
            } else {
                j3();
            }
            AutoPlayController autoPlayController = this.m;
            if (autoPlayController != null) {
                autoPlayController.k(false);
            }
        }
    }

    public final void J2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Y2();
            K2(CollectionsKt__CollectionsJVMKt.listOf(str));
        }
    }

    public final boolean W2(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
            if (!isNetWorkAvailable && z) {
                BdUtilHelper.showToast(getActivity(), (int) R.string.network_not_available);
            }
            return !isNetWorkAvailable;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.wg7
    public <T extends og7> T X1(KClass<T> clazz) {
        InterceptResult invokeL;
        wg7 wg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            FragmentActivity activity = getActivity();
            if (activity instanceof wg7) {
                wg7Var = (wg7) activity;
            } else {
                wg7Var = null;
            }
            if (wg7Var == null) {
                return null;
            }
            return (T) wg7Var.X1(clazz);
        }
        return (T) invokeL.objValue;
    }

    public static final void f3(FrsFeedFragment this$0, gh7 gh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, gh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.N2().i(gh7Var.m());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, android.os.Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            g3();
            e3();
            r();
        }
    }

    @Override // com.baidu.tieba.ql7
    public void q2(ThreadData data, JSONObject requestParmas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, data, requestParmas) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(requestParmas, "requestParmas");
            this.f.j(data);
            L2().notifyDataSetChanged();
        }
    }

    public static final void U2(FrsFeedFragment this$0, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, this$0, i) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.N2().j();
            this$0.j = false;
            oj7 oj7Var = this$0.k;
            if (oj7Var != null) {
                FrameLayout frameLayout = this$0.M2().c;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frsRefreshTipContainer");
                oj7Var.b(i, frameLayout);
            }
            this$0.r = null;
        }
    }

    public static /* synthetic */ boolean X2(FrsFeedFragment frsFeedFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return frsFeedFragment.W2(z);
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            L2().setList(CollectionsKt__CollectionsKt.emptyList());
            P2().d(false, false);
        }
    }

    public final pa7 L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            pa7 pa7Var = this.e;
            Intrinsics.checkNotNull(pa7Var);
            return pa7Var;
        }
        return (pa7) invokeV.objValue;
    }

    public final FragmentFrsFeedBinding M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FragmentFrsFeedBinding fragmentFrsFeedBinding = this.a;
            Intrinsics.checkNotNull(fragmentFrsFeedBinding);
            return fragmentFrsFeedBinding;
        }
        return (FragmentFrsFeedBinding) invokeV.objValue;
    }

    public final nl7 N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            nl7 nl7Var = this.d;
            Intrinsics.checkNotNull(nl7Var);
            return nl7Var;
        }
        return (nl7) invokeV.objValue;
    }

    public final ll7 O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ll7 ll7Var = this.b;
            Intrinsics.checkNotNull(ll7Var);
            return ll7Var;
        }
        return (ll7) invokeV.objValue;
    }

    public final ol7 P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ol7 ol7Var = this.c;
            Intrinsics.checkNotNull(ol7Var);
            return ol7Var;
        }
        return (ol7) invokeV.objValue;
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d3();
            c3();
            a3();
            b3();
            if (this.f.k()) {
                N2().j();
            }
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            h3(true);
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            L2().setList(this.f.i().a());
            AutoPlayController autoPlayController = this.m;
            if (autoPlayController != null) {
                autoPlayController.p(true);
            }
            AutoPlayController autoPlayController2 = this.m;
            if (autoPlayController2 != null) {
                autoPlayController2.r();
            }
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            P2().d(this.f.hasMore(), !this.f.i().a().isEmpty());
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            N2().e(this.f.i().b());
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            N2().f(this.f.i().c());
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            oq6 b2 = mq6.b();
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            b2.b(new lq6(uniqueId, this.g), new f(this, bi7.class));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDestroy();
            this.f.onDestroy();
            mk7 mk7Var = this.h;
            if (mk7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exposeListener");
                mk7Var = null;
            }
            mk7Var.d();
            oj7 oj7Var = this.k;
            if (oj7Var != null) {
                oj7Var.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            AutoPlayController autoPlayController = this.m;
            if (autoPlayController != null) {
                autoPlayController.k(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return VideoAudioHelper.checkNeedAutoPlay(2);
        }
        return invokeV.booleanValue;
    }

    public final void K2(List<String> list) {
        e57<?> e57Var;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            Iterator<za7<?>> it = this.f.i().a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                za7<?> next = it.next();
                if ((next instanceof v47) && (e57Var = ((v47) next).c) != null && (m = e57Var.m()) != null && list.contains(m)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                L2().notifyDataSetChanged();
            }
        }
    }

    public final void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            for (za7<?> za7Var : this.f.i().a()) {
                if (za7Var instanceof w97) {
                    ((w97) za7Var).d(new f57(z));
                }
            }
            L2().notifyDataSetChanged();
            P2().b(z);
        }
    }

    public final void R2() {
        e57 e57Var;
        List<za7<? extends Object>> c2;
        s47 s47Var;
        k77 m;
        List<p77> manageItemList;
        g77 g77Var;
        y47 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Iterator<T> it = this.f.i().a().iterator();
            while (it.hasNext()) {
                Object b2 = ((za7) it.next()).b();
                if (b2 instanceof e57) {
                    e57Var = (e57) b2;
                } else {
                    e57Var = null;
                }
                if (e57Var != null && (c2 = e57Var.c()) != null) {
                    Iterator<T> it2 = c2.iterator();
                    while (it2.hasNext()) {
                        Object b3 = ((za7) it2.next()).b();
                        if (b3 instanceof s47) {
                            s47Var = (s47) b3;
                        } else {
                            s47Var = null;
                        }
                        if (s47Var != null && (m = s47Var.m()) != null && (manageItemList = m.m) != null) {
                            Intrinsics.checkNotNullExpressionValue(manageItemList, "manageItemList");
                            for (p77 p77Var : manageItemList) {
                                Object a3 = p77Var.a();
                                if (a3 instanceof g77) {
                                    g77Var = (g77) a3;
                                } else {
                                    g77Var = null;
                                }
                                if (g77Var != null && (a2 = g77Var.a()) != null) {
                                    a2.d(a2.c() + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void S2(fi7 event) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int c2 = event.c();
            if (c2 != 0) {
                if (c2 == 4 && (str = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.b())) != null) {
                    J2(str);
                    return;
                }
                return;
            }
            K2(event.b());
        }
    }

    public final void T2(OperateType operateType, boolean z, String str, final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{operateType, Boolean.valueOf(z), str, Integer.valueOf(i)}) == null) {
            switch (a.$EnumSwitchMapping$0[operateType.ordinal()]) {
                case 1:
                    M2().h.setRefreshing(false);
                    Runnable runnable = this.r;
                    if (runnable != null) {
                        SafeHandler.getInst().removeCallbacks(runnable);
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.baidu.tieba.dl7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                FrsFeedFragment.U2(FrsFeedFragment.this, i);
                            }
                        }
                    };
                    SafeHandler.getInst().postDelayed(runnable2, 800L);
                    this.r = runnable2;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    if (z) {
                        O2().f(this.f.i().a().isEmpty());
                        N2().j();
                        break;
                    } else {
                        O2().e(false, this.f.i().a().isEmpty(), str);
                        break;
                    }
                case 6:
                    break;
                default:
                    vl7.b(null, 1, null);
                    break;
            }
            a3();
            b3();
            j3();
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            oq6 b2 = mq6.b();
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            b2.b(new lq6(uniqueId, Reflection.getOrCreateKotlinClass(ai7.class)), new d(this, ai7.class));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().observe(activity, new Observer() { // from class: com.baidu.tieba.al7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            FrsFeedFragment.f3(FrsFeedFragment.this, (gh7) obj);
                        }
                    }
                });
            }
            oq6 b3 = mq6.b();
            BdUniqueId uniqueId2 = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
            b3.b(new lq6(uniqueId2, Reflection.getOrCreateKotlinClass(ci7.class)), new e(this, ci7.class));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroyView();
            Log.d("FrsFeedFragment", "onDestroyView = " + this);
            Runnable runnable = this.r;
            if (runnable != null) {
                SafeHandler.getInst().removeCallbacks(runnable);
            }
            this.a = null;
            this.e = null;
            P2().a();
            this.c = null;
            O2().a();
            this.b = null;
            N2().c();
            this.d = null;
            this.i = null;
            AutoPlayController autoPlayController = this.m;
            if (autoPlayController != null) {
                autoPlayController.o(null);
            }
            AutoPlayController autoPlayController2 = this.m;
            if (autoPlayController2 != null) {
                autoPlayController2.l();
            }
            this.m = null;
            u2();
        }
    }

    public final void h3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z) != null) || this.f.g()) {
            return;
        }
        if (X2(this, false, 1, null)) {
            if (!this.f.m()) {
                O2().e(true, false, getString(R.string.network_not_available));
                return;
            }
            return;
        }
        if (z) {
            N2().k();
            M2().g.scrollToPosition(0);
            M2().h.setRefreshing(true);
            this.j = true;
            this.f.f(true);
        } else {
            O2().m();
            this.f.f(false);
        }
        AutoPlayController autoPlayController = this.m;
        if (autoPlayController != null) {
            autoPlayController.p(false);
        }
        mq6.b().c(new di7(getActivity(), false));
    }

    public final void i3() {
        boolean z;
        xg7 xg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            LinkageController linkageController = (LinkageController) X1(Reflection.getOrCreateKotlinClass(LinkageController.class));
            if (linkageController != null) {
                z = linkageController.S();
            } else {
                z = false;
            }
            if (z && (xg7Var = (xg7) X1(Reflection.getOrCreateKotlinClass(xg7.class))) != null) {
                xg7Var.t();
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean hasMore = this.f.hasMore();
            int size = this.f.i().a().size();
            boolean z = false;
            if (1 <= size && size < 6) {
                z = true;
            }
            if (hasMore && z) {
                P2().c();
            }
        }
    }

    @Override // com.baidu.tieba.sa7
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.e != null && this.d != null && this.a != null) {
            L2().r();
            N2().b();
            EMManager.from(M2().getRoot()).setBackGroundColor(R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        xj7 a2;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                a2 = new wj7();
            } else {
                android.os.Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new android.os.Bundle();
                }
                BdUniqueId uniqueId = getUniqueId();
                Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
                a2 = rl7.a(activity, arguments, uniqueId, this);
            }
            this.f = a2;
            android.os.Bundle arguments2 = getArguments();
            boolean z3 = true;
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
                    this.k = new oj7(requireContext);
                }
            }
            android.os.Bundle arguments4 = getArguments();
            if (arguments4 != null && arguments4.getInt("forum_tab_id") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.q = "frs_hot_tab";
            } else {
                android.os.Bundle arguments5 = getArguments();
                if ((arguments5 == null || arguments5.getInt("forum_tab_id") != 503) ? false : false) {
                    this.q = "frs_new_tab";
                }
            }
            BdUniqueId uniqueId2 = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
            android.os.Bundle arguments6 = getArguments();
            if (arguments6 == null) {
                arguments6 = new android.os.Bundle();
            }
            this.h = new mk7(uniqueId2, arguments6);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, android.os.Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Log.d("FrsFeedFragment", "onCreateView = " + this);
            this.a = FragmentFrsFeedBinding.c(inflater, viewGroup, false);
            M2().h.setDisableRefresh(true);
            this.i = new g55(getPageContext());
            M2().h.setProgressView(this.i);
            BdRecyclerView bdRecyclerView = M2().g;
            final Context context = getContext();
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this, context) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
            M2().g.setFadingEdgeLength(0);
            M2().g.setOverScrollMode(2);
            FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
            feedTemplateAdapter.d(new b(this));
            android.os.Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new android.os.Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
            feedTemplateAdapter.b(new kk7(arguments));
            feedTemplateAdapter.e(M2().g);
            feedTemplateAdapter.i(new oc7());
            l27 l27Var = new l27(2);
            l27Var.c(getPageContext());
            l27Var.b("FRS");
            feedTemplateAdapter.i(l27Var);
            feedTemplateAdapter.i(new p27(q58.e(), "frs", "frs_feed", this.q));
            feedTemplateAdapter.n(new km7());
            feedTemplateAdapter.i(new wa7());
            this.e = feedTemplateAdapter;
            M2().g.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int a;
                public long b;
                public final /* synthetic */ FrsFeedFragment c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        if (System.currentTimeMillis() - this.b < 16) {
                            return;
                        }
                        this.b = System.currentTimeMillis();
                        if ((i2 > 0 && this.a < 0) || (i2 < 0 && this.a > 0)) {
                            this.a = 0;
                            return;
                        }
                        this.a = i2;
                        if (i2 < 0) {
                            mq6.b().c(new di7(this.c.getActivity(), true));
                        } else {
                            mq6.b().c(new di7(this.c.getActivity(), false));
                        }
                        if (!recyclerView.canScrollVertically(-1)) {
                            mq6.b().c(new di7(this.c.getActivity(), false));
                        }
                    }
                }
            });
            NestedScrollView nestedScrollView = M2().e;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "binding.fullLoadingRootView");
            FrameLayout frameLayout = M2().d;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fullLoadingContainer");
            this.b = new ll7(nestedScrollView, frameLayout, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$4
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.h3(false);
                }
            });
            BdRecyclerView bdRecyclerView2 = M2().g;
            Intrinsics.checkNotNullExpressionValue(bdRecyclerView2, "binding.recyclerView");
            this.c = new ol7(bdRecyclerView2, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$5
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
                    boolean W2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.this$0.f.g()) {
                        return;
                    }
                    W2 = this.this$0.W2(false);
                    if (W2) {
                        return;
                    }
                    this.this$0.f.b();
                }
            });
            kl7 kl7Var = this.l;
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            kl7Var.a(uniqueId, this.f, new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$6
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
                    pa7 L2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        L2 = this.this$0.L2();
                        L2.notifyDataSetChanged();
                    }
                }
            });
            this.d = new nl7(M2(), new Function1<TabLayout.Tab, Boolean>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$7
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
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(TabLayout.Tab tab) {
                    InterceptResult invokeL;
                    boolean Z2;
                    boolean z;
                    ll7 O2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, tab)) == null) {
                        Intrinsics.checkNotNullParameter(tab, "tab");
                        Z2 = this.this$0.Z2();
                        if (Z2 && !this.this$0.f.g()) {
                            Object tag = tab.getTag();
                            if (this.this$0.isResumed() && (tag instanceof Integer)) {
                                this.this$0.i3();
                                this.this$0.I2();
                                O2 = this.this$0.O2();
                                O2.m();
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
            }, new Function1<iq7, Boolean>(this) { // from class: com.baidu.tieba.forum.tab.FrsFeedFragment$onCreateView$8
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
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(iq7 sortData) {
                    InterceptResult invokeL;
                    boolean Z2;
                    boolean z;
                    ll7 O2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sortData)) == null) {
                        Intrinsics.checkNotNullParameter(sortData, "sortData");
                        Z2 = this.this$0.Z2();
                        if (!Z2 || this.this$0.f.g()) {
                            z = false;
                        } else {
                            this.this$0.i3();
                            this.this$0.I2();
                            O2 = this.this$0.O2();
                            O2.m();
                            this.this$0.f.n(sortData.b);
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
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(TabLayout.Tab tab) {
                    InterceptResult invokeL;
                    boolean Z2;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, tab)) == null) {
                        Intrinsics.checkNotNullParameter(tab, "<anonymous parameter 0>");
                        Z2 = this.this$0.Z2();
                        if (!Z2 || this.this$0.f.g()) {
                            z = false;
                        } else {
                            this.this$0.i3();
                            this.this$0.Y2();
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    return (Boolean) invokeL.objValue;
                }
            });
            BdPageContext<?> a2 = a5.a(getContext());
            if (a2 != null) {
                BdRecyclerView bdRecyclerView3 = M2().g;
                Intrinsics.checkNotNullExpressionValue(bdRecyclerView3, "binding.recyclerView");
                AutoPlayController autoPlayController = new AutoPlayController(a2, bdRecyclerView3);
                this.m = autoPlayController;
                if (autoPlayController != null) {
                    autoPlayController.o(this.n);
                }
                AutoPlayController autoPlayController2 = this.m;
                if (autoPlayController2 != null) {
                    BdUniqueId uniqueId2 = getUniqueId();
                    Intrinsics.checkNotNullExpressionValue(uniqueId2, "uniqueId");
                    autoPlayController2.q(uniqueId2);
                }
                registerListener(this.o);
                registerListener(this.p);
            }
            V2();
            RelativeLayout root = M2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ck7
    public void w0(OperateType operateType, boolean z, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{operateType, Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            Intrinsics.checkNotNullParameter(operateType, "operateType");
            if (this.a == null) {
                return;
            }
            T2(operateType, z, str, i2);
        }
    }
}
