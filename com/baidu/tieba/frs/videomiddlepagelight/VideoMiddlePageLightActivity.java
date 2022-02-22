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
import c.a.d.f.p.l;
import c.a.t0.g0.g;
import c.a.u0.e1.e3.p;
import c.a.u0.l4.d;
import c.a.u0.n4.h;
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
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\r\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0006\u0010,\u001a\u00020(J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020 H\u0014J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020(H\u0014J\b\u00106\u001a\u00020(H\u0014J\b\u00107\u001a\u00020(H\u0014J\u000e\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020 J\u0006\u0010:\u001a\u00020(J\b\u0010;\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "()V", "adapterManager", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightAdapterManager;", "cardDividerLine", "Landroidx/recyclerview/widget/DividerItemDecoration;", "isForbidOnceListAutoScroll", "", "isNeedTwiceScroll", "listGestureDetector", "Landroid/view/GestureDetector;", "listGestureDetectorListener", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1;", "loadingView", "Lcom/baidu/tbadk/loading/LoadingView;", "mIsFromSchema", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "networkChangeMessageListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "noNetworkView", "Lcom/baidu/tbadk/core/view/NoNetworkView;", "recyclerView", "Lcom/baidu/adp/widget/ListView/BdTypeRecyclerView;", "rootView", "Landroid/view/View;", "scrollListener", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1;", "twiceScrollToPosition", "", "viewModel", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "enterExitAnimation", "", ConstantHelper.LOG_FINISH, "getCurrentPageKey", "", "hideLoadingView", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "scrollCurPlayingVideoToTop", "position", "showLoadingView", "videoNeedPreload", "frsExtra_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class VideoMiddlePageLightActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p adapterManager;
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

    /* loaded from: classes12.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightActivity f44045e;

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
            this.f44045e = videoMiddlePageLightActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (Math.abs(f3) > 1000.0f && f3 < 0.0f) {
                    this.f44045e.getViewModel().playNextVideo();
                    return true;
                } else if (Math.abs(f3) <= 1000.0f || f3 <= 0.0f) {
                    return true;
                } else {
                    this.f44045e.getViewModel().playLastVideo();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageLightActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
            super(2000994);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageLightActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && ((NetWorkChangedMessage) customResponsedMessage).getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (l.z()) {
                    this.a.getViewModel().resumePlayVideo();
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        }
    }

    public VideoMiddlePageLightActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageLightActivity$viewModel$2(this));
        this.listGestureDetectorListener = new a(this);
        this.scrollListener = new VideoMiddlePageLightActivity$scrollListener$1(this);
        this.networkChangeMessageListener = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoMiddlePageViewModel getViewModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (VideoMiddlePageViewModel) this.viewModel$delegate.getValue() : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m59onCreate$lambda0(VideoMiddlePageLightActivity this$0, List it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (it.size() > 0) {
                this$0.hideLoadingView();
                p pVar = this$0.adapterManager;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
                    pVar = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                pVar.e(it);
            }
        }
    }

    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final boolean m60onCreate$lambda1(VideoMiddlePageLightActivity this$0, View view, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, this$0, view, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            GestureDetector gestureDetector = this$0.listGestureDetector;
            if (gestureDetector == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listGestureDetector");
                gestureDetector = null;
            }
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m61onCreate$lambda2(VideoMiddlePageLightActivity this$0, Integer it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.isForbidOnceListAutoScroll) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.scrollCurPlayingVideoToTop(it.intValue());
                return;
            }
            this$0.isForbidOnceListAutoScroll = false;
        }
    }

    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m62onCreate$lambda3(VideoMiddlePageLightActivity this$0, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = false;
            if (str != null && (!StringsKt__StringsJVMKt.isBlank(str))) {
                z = true;
            }
            if (z) {
                this$0.showToast(str);
            }
        }
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
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.t0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a023" : (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g gVar = this.loadingView;
            g gVar2 = null;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                gVar = null;
            }
            if (gVar.isViewAttached()) {
                Window window = getWindow();
                View decorView = window == null ? null : window.getDecorView();
                if (decorView != null) {
                    FrameLayout frameLayout = (FrameLayout) decorView;
                    g gVar3 = this.loadingView;
                    if (gVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                    } else {
                        gVar2 = gVar3;
                    }
                    gVar2.dettachView(frameLayout);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            NavigationBar navigationBar = this.navigationBar;
            g gVar = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            navigationBar.onChangeSkinType(getPageContext(), i2);
            NoNetworkView noNetworkView = this.noNetworkView;
            if (noNetworkView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
                noNetworkView = null;
            }
            noNetworkView.onChangeSkinType(getPageContext(), i2);
            DividerItemDecoration dividerItemDecoration = this.cardDividerLine;
            if (dividerItemDecoration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
                dividerItemDecoration = null;
            }
            dividerItemDecoration.setDrawable(SkinManager.getDrawable(R.drawable.shape_card_video_middle_page_divider));
            g gVar2 = this.loadingView;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                gVar = gVar2;
            }
            gVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            getViewModel().getConfiguration().setValue(newConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.d.a.b.f().h("MainTabActivity")) {
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
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_middle_page_light_root)");
                this.rootView = findViewById;
                this.loadingView = new g(this, getResources().getDimensionPixelSize(R.dimen.ds120));
                View findViewById2 = findViewById(R.id.video_middle_page_light_navigation_bar);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.video_…age_light_navigation_bar)");
                NavigationBar navigationBar = (NavigationBar) findViewById2;
                this.navigationBar = navigationBar;
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (navigationBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                    navigationBar = null;
                }
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                NavigationBar navigationBar2 = this.navigationBar;
                if (navigationBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                    navigationBar2 = null;
                }
                navigationBar2.setCenterTextTitle(getString(R.string.tieba_video));
                View findViewById3 = findViewById(R.id.video_middle_page_light_no_network_view);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.video_…ge_light_no_network_view)");
                this.noNetworkView = (NoNetworkView) findViewById3;
                if (!l.z()) {
                    NoNetworkView noNetworkView = this.noNetworkView;
                    if (noNetworkView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
                        noNetworkView = null;
                    }
                    noNetworkView.setVisibility(0);
                }
                View findViewById4 = findViewById(R.id.video_middle_page_light_list_view);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.video_…dle_page_light_list_view)");
                BdTypeRecyclerView bdTypeRecyclerView2 = (BdTypeRecyclerView) findViewById4;
                this.recyclerView = bdTypeRecyclerView2;
                if (bdTypeRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    bdTypeRecyclerView2 = null;
                }
                bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
                this.cardDividerLine = dividerItemDecoration;
                if (dividerItemDecoration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
                    dividerItemDecoration = null;
                }
                dividerItemDecoration.setDrawable(SkinManager.getDrawable(R.drawable.shape_card_video_middle_page_divider));
                BdTypeRecyclerView bdTypeRecyclerView3 = this.recyclerView;
                if (bdTypeRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    bdTypeRecyclerView3 = null;
                }
                DividerItemDecoration dividerItemDecoration2 = this.cardDividerLine;
                if (dividerItemDecoration2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cardDividerLine");
                    dividerItemDecoration2 = null;
                }
                bdTypeRecyclerView3.addItemDecoration(dividerItemDecoration2);
                if (!l.z()) {
                    BdTypeRecyclerView bdTypeRecyclerView4 = this.recyclerView;
                    if (bdTypeRecyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        bdTypeRecyclerView4 = null;
                    }
                    bdTypeRecyclerView4.setVisibility(8);
                    NoNetworkView noNetworkView2 = this.noNetworkView;
                    if (noNetworkView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
                        noNetworkView2 = null;
                    }
                    noNetworkView2.setVisibility(0);
                }
                registerListener(this.networkChangeMessageListener);
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
                BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
                if (bdTypeRecyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    bdTypeRecyclerView5 = null;
                }
                VideoMiddlePageViewModel viewModel6 = getViewModel();
                Intrinsics.checkNotNullExpressionValue(viewModel6, "viewModel");
                this.adapterManager = new p(pageContext, bdTypeRecyclerView5, viewModel6);
                getViewModel().loadData();
                showLoadingView();
                getViewModel().getVideoDataList().observe(this, new Observer() { // from class: c.a.u0.e1.e3.n
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            VideoMiddlePageLightActivity.m59onCreate$lambda0(VideoMiddlePageLightActivity.this, (List) obj);
                        }
                    }
                });
                this.listGestureDetector = new GestureDetector(this, this.listGestureDetectorListener);
                BdTypeRecyclerView bdTypeRecyclerView6 = this.recyclerView;
                if (bdTypeRecyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    bdTypeRecyclerView6 = null;
                }
                bdTypeRecyclerView6.setOnTouchListener(new View.OnTouchListener() { // from class: c.a.u0.e1.e3.h
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? VideoMiddlePageLightActivity.m60onCreate$lambda1(VideoMiddlePageLightActivity.this, view, motionEvent) : invokeLL.booleanValue;
                    }
                });
                BdTypeRecyclerView bdTypeRecyclerView7 = this.recyclerView;
                if (bdTypeRecyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    bdTypeRecyclerView = bdTypeRecyclerView7;
                }
                bdTypeRecyclerView.addOnScrollListener(this.scrollListener);
                getViewModel().getCurPlayingVideoPos().observe(this, new Observer() { // from class: c.a.u0.e1.e3.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            VideoMiddlePageLightActivity.m61onCreate$lambda2(VideoMiddlePageLightActivity.this, (Integer) obj);
                        }
                    }
                });
                getViewModel().getLoadErrorMsg().observe(this, new Observer() { // from class: c.a.u0.e1.e3.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            VideoMiddlePageLightActivity.m62onCreate$lambda3(VideoMiddlePageLightActivity.this, (String) obj);
                        }
                    }
                });
                if (Build.VERSION.SDK_INT >= 28) {
                    if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                        d.b(1, getWindow().getAttributes(), getWindow());
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            p pVar = this.adapterManager;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
                pVar = null;
            }
            pVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            p pVar = this.adapterManager;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
                pVar = null;
            }
            pVar.g();
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
        BdTypeRecyclerView bdTypeRecyclerView2 = null;
        if (bdTypeRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            bdTypeRecyclerView = null;
        }
        if (bdTypeRecyclerView.getFirstVisiblePosition() == -1) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView3 = this.recyclerView;
        if (bdTypeRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            bdTypeRecyclerView3 = null;
        }
        if (i2 < bdTypeRecyclerView3.getFirstVisiblePosition()) {
            BdTypeRecyclerView bdTypeRecyclerView4 = this.recyclerView;
            if (bdTypeRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                bdTypeRecyclerView2 = bdTypeRecyclerView4;
            }
            bdTypeRecyclerView2.smoothScrollToPosition(i2);
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
        if (bdTypeRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            bdTypeRecyclerView5 = null;
        }
        if (i2 <= bdTypeRecyclerView5.getLastCompletelyVisiblePosition()) {
            BdTypeRecyclerView bdTypeRecyclerView6 = this.recyclerView;
            if (bdTypeRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                bdTypeRecyclerView6 = null;
            }
            int firstVisiblePosition = i2 - bdTypeRecyclerView6.getFirstVisiblePosition();
            if (firstVisiblePosition >= 0) {
                BdTypeRecyclerView bdTypeRecyclerView7 = this.recyclerView;
                if (bdTypeRecyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    bdTypeRecyclerView7 = null;
                }
                if (firstVisiblePosition < bdTypeRecyclerView7.getChildCount()) {
                    BdTypeRecyclerView bdTypeRecyclerView8 = this.recyclerView;
                    if (bdTypeRecyclerView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        bdTypeRecyclerView8 = null;
                    }
                    int top = bdTypeRecyclerView8.getChildAt(firstVisiblePosition).getTop();
                    BdTypeRecyclerView bdTypeRecyclerView9 = this.recyclerView;
                    if (bdTypeRecyclerView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        bdTypeRecyclerView2 = bdTypeRecyclerView9;
                    }
                    bdTypeRecyclerView2.smoothScrollBy(0, top);
                    return;
                }
                return;
            }
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView10 = this.recyclerView;
        if (bdTypeRecyclerView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            bdTypeRecyclerView2 = bdTypeRecyclerView10;
        }
        bdTypeRecyclerView2.smoothScrollToPosition(i2);
        this.isNeedTwiceScroll = true;
        this.twiceScrollToPosition = i2;
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            g gVar = this.loadingView;
            g gVar2 = null;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                gVar = null;
            }
            if (gVar.isViewAttached()) {
                return;
            }
            Window window = getWindow();
            View decorView = window == null ? null : window.getDecorView();
            if (decorView != null) {
                FrameLayout frameLayout = (FrameLayout) decorView;
                g gVar3 = this.loadingView;
                if (gVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                } else {
                    gVar2 = gVar3;
                }
                gVar2.attachView(frameLayout, false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? l.H() || h.c().d() : invokeV.booleanValue;
    }
}
