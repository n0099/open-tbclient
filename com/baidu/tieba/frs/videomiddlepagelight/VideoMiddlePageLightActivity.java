package com.baidu.tieba.frs.videomiddlepagelight;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.b.b.e.m.e;
import d.b.b.e.p.j;
import d.b.h0.d0.g;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002)>\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\u0007J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u000bJ\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001d\u0010H\u001a\u00020C8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "hideLoadingView", "()V", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", MissionEvent.MESSAGE_CREATE, "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, MissionEvent.MESSAGE_RESUME, "position", "scrollCurPlayingVideoToTop", "showLoadingView", "", "videoNeedPreload", "()Z", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightAdapterManager;", "adapterManager", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightAdapterManager;", "Landroidx/recyclerview/widget/DividerItemDecoration;", "cardDividerLine", "Landroidx/recyclerview/widget/DividerItemDecoration;", "isForbidOnceListAutoScroll", "Z", "isNeedTwiceScroll", "Landroid/view/GestureDetector;", "listGestureDetector", "Landroid/view/GestureDetector;", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1", "listGestureDetectorListener", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$listGestureDetectorListener$1;", "Lcom/baidu/tbadk/loading/LoadingView;", "loadingView", "Lcom/baidu/tbadk/loading/LoadingView;", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "networkChangeMessageListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tbadk/core/view/NoNetworkView;", "noNetworkView", "Lcom/baidu/tbadk/core/view/NoNetworkView;", "Lcom/baidu/adp/widget/ListView/BdTypeRecyclerView;", "recyclerView", "Lcom/baidu/adp/widget/ListView/BdTypeRecyclerView;", "Landroid/view/View;", "rootView", "Landroid/view/View;", "com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1", "scrollListener", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1;", "twiceScrollToPosition", "I", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel", "<init>", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightActivity extends BaseFragmentActivity {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoMiddlePageLightActivity.class), "viewModel", "getViewModel()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;"))};
    public d.b.i0.p0.p2.a adapterManager;
    public DividerItemDecoration cardDividerLine;
    public boolean isForbidOnceListAutoScroll;
    public boolean isNeedTwiceScroll;
    public GestureDetector listGestureDetector;
    public g loadingView;
    public NavigationBar navigationBar;
    public NoNetworkView noNetworkView;
    public BdTypeRecyclerView recyclerView;
    public View rootView;
    public int twiceScrollToPosition;
    public final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageLightActivity$viewModel$2(this));
    public final a listGestureDetectorListener = new a();
    public final VideoMiddlePageLightActivity$scrollListener$1 scrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1

        /* loaded from: classes4.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.isForbidOnceListAutoScroll = true;
                VideoMiddlePageLightActivity.this.getViewModel().o(VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition());
            }
        }

        /* loaded from: classes4.dex */
        public static final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.isForbidOnceListAutoScroll = true;
                VideoMiddlePageLightActivity.this.getViewModel().o(VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            boolean z;
            int i2;
            super.onScrollStateChanged(recyclerView, i);
            z = VideoMiddlePageLightActivity.this.isNeedTwiceScroll;
            if (!z || i != 0) {
                Integer value = VideoMiddlePageLightActivity.this.getViewModel().c().getValue();
                if (value != null && i == 0) {
                    if (VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition() == -1) {
                        if (VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstVisiblePosition() != -1) {
                            int firstVisiblePosition = VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstVisiblePosition();
                            Integer value2 = VideoMiddlePageLightActivity.this.getViewModel().c().getValue();
                            if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                VideoMiddlePageLightActivity.this.isForbidOnceListAutoScroll = true;
                                VideoMiddlePageLightActivity.this.getViewModel().o(VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstVisiblePosition());
                            }
                        }
                    } else if (value.intValue() < VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition()) {
                        e.a().post(new a());
                    } else if (value.intValue() > VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition()) {
                        e.a().post(new b());
                    }
                }
                if (VideoMiddlePageLightActivity.access$getRecyclerView$p(VideoMiddlePageLightActivity.this).canScrollVertically(1)) {
                    return;
                }
                if (Intrinsics.areEqual(VideoMiddlePageLightActivity.this.getViewModel().f().getValue(), Boolean.FALSE) && Intrinsics.areEqual(VideoMiddlePageLightActivity.this.getViewModel().k().getValue(), Boolean.FALSE)) {
                    VideoMiddlePageLightActivity.this.showToast(R.string.no_more_video_content);
                    return;
                } else if (j.z()) {
                    VideoMiddlePageLightActivity.this.showToast(R.string.hard_loading);
                    VideoMiddlePageLightActivity.this.getViewModel().l();
                    return;
                } else {
                    VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            VideoMiddlePageLightActivity.this.isNeedTwiceScroll = false;
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            i2 = videoMiddlePageLightActivity.twiceScrollToPosition;
            videoMiddlePageLightActivity.scrollCurPlayingVideoToTop(i2);
        }
    };
    public final CustomMessageListener networkChangeMessageListener = new b(2000994);

    /* loaded from: classes4.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float f4 = 1000;
            if (Math.abs(f3) > f4 && f3 < 0) {
                VideoMiddlePageLightActivity.this.getViewModel().n();
                return true;
            } else if (Math.abs(f3) <= f4 || f3 <= 0) {
                return true;
            } else {
                VideoMiddlePageLightActivity.this.getViewModel().m();
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && ((NetWorkChangedMessage) customResponsedMessage).getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (j.z()) {
                    VideoMiddlePageLightActivity.this.getViewModel().p();
                } else {
                    VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c<T> implements Observer<List<BaseCardInfo>> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(List<BaseCardInfo> it) {
            if (it.size() > 0) {
                VideoMiddlePageLightActivity.this.hideLoadingView();
                d.b.i0.p0.p2.a access$getAdapterManager$p = VideoMiddlePageLightActivity.access$getAdapterManager$p(VideoMiddlePageLightActivity.this);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                access$getAdapterManager$p.d(it);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return VideoMiddlePageLightActivity.access$getListGestureDetector$p(VideoMiddlePageLightActivity.this).onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes4.dex */
    public static final class e<T> implements Observer<Integer> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer it) {
            if (VideoMiddlePageLightActivity.this.isForbidOnceListAutoScroll) {
                VideoMiddlePageLightActivity.this.isForbidOnceListAutoScroll = false;
                return;
            }
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            videoMiddlePageLightActivity.scrollCurPlayingVideoToTop(it.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public static final class f<T> implements Observer<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            if (str == null || !(!StringsKt__StringsJVMKt.isBlank(str))) {
                return;
            }
            VideoMiddlePageLightActivity.this.showToast(str);
        }
    }

    public static final /* synthetic */ d.b.i0.p0.p2.a access$getAdapterManager$p(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        d.b.i0.p0.p2.a aVar = videoMiddlePageLightActivity.adapterManager;
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
        Lazy lazy = this.viewModel$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (VideoMiddlePageViewModel) lazy.getValue();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a023";
    }

    public final void hideLoadingView() {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        NavigationBar navigationBar = this.navigationBar;
        if (navigationBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
        }
        navigationBar.onChangeSkinType(getPageContext(), i);
        NoNetworkView noNetworkView = this.noNetworkView;
        if (noNetworkView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noNetworkView");
        }
        noNetworkView.c(getPageContext(), i);
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getViewModel().b().setValue(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VideoMiddlePageViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra("PARAM_FID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.r(stringExtra);
        VideoMiddlePageViewModel viewModel2 = getViewModel();
        String stringExtra2 = getIntent().getStringExtra("st_type");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        viewModel2.s(stringExtra2);
        VideoMiddlePageViewModel viewModel3 = getViewModel();
        String stringExtra3 = getIntent().getStringExtra("yuelaou_locate");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        viewModel3.u(stringExtra3);
        VideoMiddlePageViewModel viewModel4 = getViewModel();
        String stringExtra4 = getIntent().getStringExtra("PARAM_FROM");
        viewModel4.q(stringExtra4 != null ? stringExtra4 : "");
        VideoMiddlePageViewModel viewModel5 = getViewModel();
        Serializable serializableExtra = getIntent().getSerializableExtra("param_video_thread_info");
        if (serializableExtra != null) {
            viewModel5.t((VideoSerializeVideoThreadInfo) serializableExtra);
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
            this.adapterManager = new d.b.i0.p0.p2.a(pageContext, bdTypeRecyclerView4, viewModel6);
            getViewModel().l();
            showLoadingView();
            getViewModel().j().observe(this, new c());
            this.listGestureDetector = new GestureDetector(this, this.listGestureDetectorListener);
            BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
            if (bdTypeRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            bdTypeRecyclerView5.setOnTouchListener(new d());
            BdTypeRecyclerView bdTypeRecyclerView6 = this.recyclerView;
            if (bdTypeRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            bdTypeRecyclerView6.addOnScrollListener(this.scrollListener);
            getViewModel().c().observe(this, new e());
            getViewModel().g().observe(this, new f());
            if (Build.VERSION.SDK_INT >= 28) {
                if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                    Window window = getWindow();
                    Intrinsics.checkExpressionValueIsNotNull(window, "window");
                    d.b.i0.o3.c.b(1, window.getAttributes(), getWindow());
                    return;
                }
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.p0.p2.a aVar = this.adapterManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
        }
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.b.i0.p0.p2.a aVar = this.adapterManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterManager");
        }
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForbidOnceListAutoScroll = true;
        getViewModel().p();
    }

    public final void scrollCurPlayingVideoToTop(int i) {
        if (i != -1) {
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
            if (i < bdTypeRecyclerView2.getFirstVisiblePosition()) {
                BdTypeRecyclerView bdTypeRecyclerView3 = this.recyclerView;
                if (bdTypeRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                bdTypeRecyclerView3.smoothScrollToPosition(i);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView4 = this.recyclerView;
            if (bdTypeRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            if (i <= bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
                BdTypeRecyclerView bdTypeRecyclerView5 = this.recyclerView;
                if (bdTypeRecyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                int firstVisiblePosition = i - bdTypeRecyclerView5.getFirstVisiblePosition();
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
            bdTypeRecyclerView9.smoothScrollToPosition(i);
            this.isNeedTwiceScroll = true;
            this.twiceScrollToPosition = i;
        }
    }

    public final void showLoadingView() {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        if (!j.H()) {
            d.b.i0.p3.f d2 = d.b.i0.p3.f.d();
            Intrinsics.checkExpressionValueIsNotNull(d2, "VideoHolyCardManager.getInstance()");
            if (!d2.e()) {
                return false;
            }
        }
        return true;
    }
}
