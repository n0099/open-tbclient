package com.baidu.tieba.frs.videomiddlepagelight;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.m.e;
import c.a.e.e.p.j;
import c.a.p0.f0.g;
import c.a.q0.w3.h;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002+A\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\rJ\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010&R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001d\u0010K\u001a\u00020F8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "enterExitAnimation", "()V", ConstantHelper.LOG_FINISH, "", "getCurrentPageKey", "()Ljava/lang/String;", "hideLoadingView", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "position", "scrollCurPlayingVideoToTop", "showLoadingView", "", "videoNeedPreload", "()Z", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightAdapterManager;", "adapterManager", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightAdapterManager;", "Landroidx/recyclerview/widget/DividerItemDecoration;", "cardDividerLine", "Landroidx/recyclerview/widget/DividerItemDecoration;", "isForbidOnceListAutoScroll", "Z", "isNeedTwiceScroll", "Landroid/view/GestureDetector;", "listGestureDetector", "Landroid/view/GestureDetector;", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1", "listGestureDetectorListener", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1;", "Lcom/baidu/tbadk/loading/LoadingView;", "loadingView", "Lcom/baidu/tbadk/loading/LoadingView;", "mIsFromSchema", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "networkChangeMessageListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tbadk/core/view/NoNetworkView;", "noNetworkView", "Lcom/baidu/tbadk/core/view/NoNetworkView;", "Lcom/baidu/adp/widget/ListView/BdTypeRecyclerView;", "recyclerView", "Lcom/baidu/adp/widget/ListView/BdTypeRecyclerView;", "Landroid/view/View;", "rootView", "Landroid/view/View;", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1", "scrollListener", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1;", "twiceScrollToPosition", "I", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel", "<init>", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoMiddlePageLightActivity extends BaseFragmentActivity {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.v0.p2.a adapterManager;
    public DividerItemDecoration cardDividerLine;
    public boolean isForbidOnceListAutoScroll;
    public boolean isNeedTwiceScroll;
    public GestureDetector listGestureDetector;
    public final a listGestureDetectorListener;
    public g loadingView;
    public boolean mIsFromSchema;
    public NavigationBar navigationBar;
    public final CustomMessageListener networkChangeMessageListener;
    public NoNetworkView noNetworkView;
    public BdTypeRecyclerView recyclerView;
    public View rootView;
    public final VideoMiddlePageLightActivity$scrollListener$1 scrollListener;
    public int twiceScrollToPosition;
    public final Lazy viewModel$delegate;

    /* loaded from: classes7.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51513e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51513e = videoMiddlePageLightActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                float f4 = 1000;
                if (Math.abs(f3) > f4 && f3 < 0) {
                    this.f51513e.getViewModel().playNextVideo();
                    return true;
                } else if (Math.abs(f3) <= f4 || f3 <= 0) {
                    return true;
                } else {
                    this.f51513e.getViewModel().playLastVideo();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51514a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoMiddlePageLightActivity videoMiddlePageLightActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51514a = videoMiddlePageLightActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && ((NetWorkChangedMessage) customResponsedMessage).getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (j.z()) {
                    this.f51514a.getViewModel().resumePlayVideo();
                } else {
                    this.f51514a.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<List<BaseCardInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51515e;

        public c(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51515e = videoMiddlePageLightActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(List<BaseCardInfo> it) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, it) == null) || it.size() <= 0) {
                return;
            }
            this.f51515e.hideLoadingView();
            c.a.q0.v0.p2.a access$getAdapterManager$p = VideoMiddlePageLightActivity.access$getAdapterManager$p(this.f51515e);
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            access$getAdapterManager$p.d(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51516e;

        public d(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51516e = videoMiddlePageLightActivity;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? VideoMiddlePageLightActivity.access$getListGestureDetector$p(this.f51516e).onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51517e;

        public e(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51517e = videoMiddlePageLightActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                if (this.f51517e.isForbidOnceListAutoScroll) {
                    this.f51517e.isForbidOnceListAutoScroll = false;
                    return;
                }
                VideoMiddlePageLightActivity videoMiddlePageLightActivity = this.f51517e;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                videoMiddlePageLightActivity.scrollCurPlayingVideoToTop(it.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f51518e;

        public f(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51518e = videoMiddlePageLightActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && (!StringsKt__StringsJVMKt.isBlank(str))) {
                this.f51518e.showToast(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1812746701, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1812746701, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoMiddlePageLightActivity.class), "viewModel", "getViewModel()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;"))};
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1] */
    public VideoMiddlePageLightActivity() {
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
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageLightActivity$viewModel$2(this));
        this.listGestureDetectorListener = new a(this);
        this.scrollListener = new RecyclerView.OnScrollListener(this) { // from class: com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ VideoMiddlePageLightActivity f51519a;

            /* loaded from: classes7.dex */
            public static final class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ VideoMiddlePageLightActivity$scrollListener$1 f51520e;

                public a(VideoMiddlePageLightActivity$scrollListener$1 videoMiddlePageLightActivity$scrollListener$1) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {videoMiddlePageLightActivity$scrollListener$1};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51520e = videoMiddlePageLightActivity$scrollListener$1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f51520e.f51519a.isForbidOnceListAutoScroll = true;
                        this.f51520e.f51519a.getViewModel().playVideoAtPosition(VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51520e.f51519a).getFirstCompletelyVisiblePosition());
                    }
                }
            }

            /* loaded from: classes7.dex */
            public static final class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ VideoMiddlePageLightActivity$scrollListener$1 f51521e;

                public b(VideoMiddlePageLightActivity$scrollListener$1 videoMiddlePageLightActivity$scrollListener$1) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {videoMiddlePageLightActivity$scrollListener$1};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51521e = videoMiddlePageLightActivity$scrollListener$1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f51521e.f51519a.isForbidOnceListAutoScroll = true;
                        this.f51521e.f51519a.getViewModel().playVideoAtPosition(VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51521e.f51519a).getLastCompletelyVisiblePosition());
                    }
                }
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f51519a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                boolean z;
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    z = this.f51519a.isNeedTwiceScroll;
                    if (!z || i4 != 0) {
                        Integer value = this.f51519a.getViewModel().getCurPlayingVideoPos().getValue();
                        if (value != null && i4 == 0) {
                            if (VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getFirstCompletelyVisiblePosition() == -1) {
                                if (VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getFirstVisiblePosition() != -1) {
                                    int firstVisiblePosition = VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getFirstVisiblePosition();
                                    Integer value2 = this.f51519a.getViewModel().getCurPlayingVideoPos().getValue();
                                    if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                        this.f51519a.isForbidOnceListAutoScroll = true;
                                        this.f51519a.getViewModel().playVideoAtPosition(VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getFirstVisiblePosition());
                                    }
                                }
                            } else if (value.intValue() < VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getFirstCompletelyVisiblePosition()) {
                                e.a().post(new a(this));
                            } else if (value.intValue() > VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).getLastCompletelyVisiblePosition()) {
                                e.a().post(new b(this));
                            }
                        }
                        if (VideoMiddlePageLightActivity.access$getRecyclerView$p(this.f51519a).canScrollVertically(1)) {
                            return;
                        }
                        if (Intrinsics.areEqual(this.f51519a.getViewModel().getHasMore().getValue(), Boolean.FALSE) && Intrinsics.areEqual(this.f51519a.getViewModel().isLoading().getValue(), Boolean.FALSE)) {
                            this.f51519a.showToast(R.string.no_more_video_content);
                            return;
                        } else if (j.z()) {
                            this.f51519a.showToast(R.string.hard_loading);
                            this.f51519a.getViewModel().loadData();
                            return;
                        } else {
                            this.f51519a.showToast(R.string.neterror);
                            return;
                        }
                    }
                    this.f51519a.isNeedTwiceScroll = false;
                    VideoMiddlePageLightActivity videoMiddlePageLightActivity = this.f51519a;
                    i5 = videoMiddlePageLightActivity.twiceScrollToPosition;
                    videoMiddlePageLightActivity.scrollCurPlayingVideoToTop(i5);
                }
            }
        };
        this.networkChangeMessageListener = new b(this, 2000994);
    }

    public static final /* synthetic */ c.a.q0.v0.p2.a access$getAdapterManager$p(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        c.a.q0.v0.p2.a aVar = videoMiddlePageLightActivity.adapterManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
        }
        return aVar;
    }

    public static final /* synthetic */ GestureDetector access$getListGestureDetector$p(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        GestureDetector gestureDetector = videoMiddlePageLightActivity.listGestureDetector;
        if (gestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listGestureDetector");
        }
        return gestureDetector;
    }

    public static final /* synthetic */ BdTypeRecyclerView access$getRecyclerView$p(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        BdTypeRecyclerView bdTypeRecyclerView = videoMiddlePageLightActivity.recyclerView;
        if (bdTypeRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return bdTypeRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoMiddlePageViewModel getViewModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Lazy lazy = this.viewModel$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (VideoMiddlePageViewModel) lazy.getValue();
        }
        return (VideoMiddlePageViewModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(pageContext.getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a023" : (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g gVar = this.loadingView;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            if (gVar.isViewAttached()) {
                Window window = getWindow();
                View decorView = window != null ? window.getDecorView() : null;
                if (decorView != null) {
                    FrameLayout frameLayout = (FrameLayout) decorView;
                    g gVar2 = this.loadingView;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                    }
                    gVar2.dettachView(frameLayout);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar.onChangeSkinType(getPageContext(), i2);
            NoNetworkView noNetworkView = this.noNetworkView;
            if (noNetworkView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
            }
            noNetworkView.onChangeSkinType(getPageContext(), i2);
            DividerItemDecoration dividerItemDecoration = this.cardDividerLine;
            if (dividerItemDecoration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
            }
            dividerItemDecoration.setDrawable(SkinManager.getDrawable(R.drawable.shape_card_video_middle_page_divider));
            g gVar = this.loadingView;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            gVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            getViewModel().getConfiguration().setValue(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.e.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            VideoMiddlePageViewModel viewModel = getViewModel();
            String stringExtra = getIntent().getStringExtra("PARAM_FID");
            if (stringExtra == null) {
                stringExtra = "";
            }
            viewModel.setFromTid(stringExtra);
            VideoMiddlePageViewModel viewModel2 = getViewModel();
            String stringExtra2 = getIntent().getStringExtra("st_type");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            viewModel2.setStType(stringExtra2);
            VideoMiddlePageViewModel viewModel3 = getViewModel();
            String stringExtra3 = getIntent().getStringExtra("yuelaou_locate");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            viewModel3.setYuelaouLocate(stringExtra3);
            VideoMiddlePageViewModel viewModel4 = getViewModel();
            String stringExtra4 = getIntent().getStringExtra("PARAM_FROM");
            viewModel4.setFrom(stringExtra4 != null ? stringExtra4 : "");
            VideoMiddlePageViewModel viewModel5 = getViewModel();
            Serializable serializableExtra = getIntent().getSerializableExtra("param_video_thread_info");
            if (serializableExtra != null) {
                viewModel5.setVideoThreadInfo((VideoSerializeVideoThreadInfo) serializableExtra);
                setContentView(R.layout.video_middle_page_light_layout);
                View findViewById = findViewById(R.id.video_middle_page_light_root);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.video_middle_page_light_root)");
                this.rootView = findViewById;
                this.loadingView = new g(this, getResources().getDimensionPixelSize(R.dimen.ds120));
                View findViewById2 = findViewById(R.id.video_middle_page_light_navigation_bar);
                Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.video_…age_light_navigation_bar)");
                NavigationBar navigationBar = (NavigationBar) findViewById2;
                this.navigationBar = navigationBar;
                if (navigationBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                }
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                NavigationBar navigationBar2 = this.navigationBar;
                if (navigationBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                }
                navigationBar2.setCenterTextTitle(getString(R.string.tieba_video));
                View findViewById3 = findViewById(R.id.video_middle_page_light_no_network_view);
                Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.video_…ge_light_no_network_view)");
                this.noNetworkView = (NoNetworkView) findViewById3;
                if (!j.z()) {
                    NoNetworkView noNetworkView = this.noNetworkView;
                    if (noNetworkView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
                    }
                    noNetworkView.setVisibility(0);
                }
                View findViewById4 = findViewById(R.id.video_middle_page_light_list_view);
                Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.video_…dle_page_light_list_view)");
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById4;
                this.recyclerView = bdTypeRecyclerView;
                if (bdTypeRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
                this.cardDividerLine = dividerItemDecoration;
                if (dividerItemDecoration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
                }
                dividerItemDecoration.setDrawable(SkinManager.getDrawable(R.drawable.shape_card_video_middle_page_divider));
                BdTypeRecyclerView bdTypeRecyclerView2 = this.recyclerView;
                if (bdTypeRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                DividerItemDecoration dividerItemDecoration2 = this.cardDividerLine;
                if (dividerItemDecoration2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
                }
                bdTypeRecyclerView2.addItemDecoration(dividerItemDecoration2);
                if (!j.z()) {
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.recyclerView;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    bdTypeRecyclerView3.setVisibility(8);
                    NoNetworkView noNetworkView2 = this.noNetworkView;
                    if (noNetworkView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
                    }
                    noNetworkView2.setVisibility(0);
                }
                registerListener(this.networkChangeMessageListener);
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                BdTypeRecyclerView bdTypeRecyclerView4 = this.recyclerView;
                if (bdTypeRecyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                VideoMiddlePageViewModel viewModel6 = getViewModel();
                Intrinsics.checkExpressionValueIsNotNull(viewModel6, "viewModel");
                this.adapterManager = new c.a.q0.v0.p2.a(pageContext, bdTypeRecyclerView4, viewModel6);
                getViewModel().loadData();
                showLoadingView();
                getViewModel().getVideoDataList().observe(this, new c(this));
                this.listGestureDetector = new GestureDetector(this, this.listGestureDetectorListener);
                BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
                if (bdTypeRecyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                bdTypeRecyclerView5.setOnTouchListener(new d(this));
                BdTypeRecyclerView bdTypeRecyclerView6 = this.recyclerView;
                if (bdTypeRecyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                bdTypeRecyclerView6.addOnScrollListener(this.scrollListener);
                getViewModel().getCurPlayingVideoPos().observe(this, new e(this));
                getViewModel().getLoadErrorMsg().observe(this, new f(this));
                if (Build.VERSION.SDK_INT >= 28) {
                    if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                        Window window = getWindow();
                        Intrinsics.checkExpressionValueIsNotNull(window, "window");
                        c.a.q0.u3.c.b(1, window.getAttributes(), getWindow());
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            c.a.q0.v0.p2.a aVar = this.adapterManager;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
            }
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            c.a.q0.v0.p2.a aVar = this.adapterManager;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
            }
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            this.isForbidOnceListAutoScroll = true;
            getViewModel().resumePlayVideo();
        }
    }

    public final void scrollCurPlayingVideoToTop(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 == -1) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.recyclerView;
        if (bdTypeRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        if (bdTypeRecyclerView.getFirstVisiblePosition() == -1) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView2 = this.recyclerView;
        if (bdTypeRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        if (i2 < bdTypeRecyclerView2.getFirstVisiblePosition()) {
            BdTypeRecyclerView bdTypeRecyclerView3 = this.recyclerView;
            if (bdTypeRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            bdTypeRecyclerView3.smoothScrollToPosition(i2);
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView4 = this.recyclerView;
        if (bdTypeRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        if (i2 <= bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
            BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
            if (bdTypeRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            int firstVisiblePosition = i2 - bdTypeRecyclerView5.getFirstVisiblePosition();
            if (firstVisiblePosition >= 0) {
                BdTypeRecyclerView bdTypeRecyclerView6 = this.recyclerView;
                if (bdTypeRecyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                if (firstVisiblePosition < bdTypeRecyclerView6.getChildCount()) {
                    BdTypeRecyclerView bdTypeRecyclerView7 = this.recyclerView;
                    if (bdTypeRecyclerView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    View childAt = bdTypeRecyclerView7.getChildAt(firstVisiblePosition);
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "recyclerView.getChildAt(movePosition)");
                    int top = childAt.getTop();
                    BdTypeRecyclerView bdTypeRecyclerView8 = this.recyclerView;
                    if (bdTypeRecyclerView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    bdTypeRecyclerView8.smoothScrollBy(0, top);
                    return;
                }
                return;
            }
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView9 = this.recyclerView;
        if (bdTypeRecyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        bdTypeRecyclerView9.smoothScrollToPosition(i2);
        this.isNeedTwiceScroll = true;
        this.twiceScrollToPosition = i2;
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            g gVar = this.loadingView;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            if (gVar.isViewAttached()) {
                return;
            }
            Window window = getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                FrameLayout frameLayout = (FrameLayout) decorView;
                g gVar2 = this.loadingView;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                }
                gVar2.attachView(frameLayout, false);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!j.H()) {
                h d2 = h.d();
                Intrinsics.checkExpressionValueIsNotNull(d2, "VideoHolyCardManager.getInstance()");
                if (!d2.e()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
