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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
import kotlin.text.l;
@kotlin.e
/* loaded from: classes2.dex */
public final class VideoMiddlePageLightActivity extends BaseFragmentActivity {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(VideoMiddlePageLightActivity.class), "viewModel", "getViewModel()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;"))};
    private NoNetworkView gXx;
    private NavigationBar glw;
    private BdTypeRecyclerView iPS;
    private com.baidu.tieba.frs.videomiddlepagelight.a jPH;
    private DividerItemDecoration jPI;
    private GestureDetector jPJ;
    private boolean jPK;
    private int jPL;
    private boolean jPM;
    private g loadingView;
    private View rootView;
    private final kotlin.c jPG = kotlin.d.b(new VideoMiddlePageLightActivity$viewModel$2(this));
    private final a jPN = new a();
    private final VideoMiddlePageLightActivity$scrollListener$1 jPO = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            boolean z;
            int i2;
            p.p(recyclerView, "rv");
            super.onScrollStateChanged(recyclerView, i);
            z = VideoMiddlePageLightActivity.this.jPK;
            if (!z || i != 0) {
                Integer value = VideoMiddlePageLightActivity.this.cMH().cNb().getValue();
                if (value != null && i == 0) {
                    if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition() == -1) {
                        if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition() != -1) {
                            int firstVisiblePosition = VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition();
                            Integer value2 = VideoMiddlePageLightActivity.this.cMH().cNb().getValue();
                            if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                VideoMiddlePageLightActivity.this.jPM = true;
                                VideoMiddlePageLightActivity.this.cMH().Ba(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition());
                            }
                        }
                    } else if (value.intValue() < VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition()) {
                        e.mA().post(new a());
                    } else if (value.intValue() > VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition()) {
                        e.mA().post(new b());
                    }
                }
                if (!VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).canScrollVertically(1)) {
                    if (p.l(VideoMiddlePageLightActivity.this.cMH().cMZ().getValue(), false) && p.l(VideoMiddlePageLightActivity.this.cMH().cMY().getValue(), false)) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.no_more_video_content);
                        return;
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.hard_loading);
                        VideoMiddlePageLightActivity.this.cMH().loadData();
                        return;
                    } else {
                        VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                return;
            }
            VideoMiddlePageLightActivity.this.jPK = false;
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            i2 = VideoMiddlePageLightActivity.this.jPL;
            videoMiddlePageLightActivity.AW(i2);
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jPM = true;
                VideoMiddlePageLightActivity.this.cMH().Ba(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition());
            }
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jPM = true;
                VideoMiddlePageLightActivity.this.cMH().Ba(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition());
            }
        }
    };
    private final CustomMessageListener jPP = new b(MessageConfig.CMD_NETWORK_CHANGED);

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoMiddlePageViewModel cMH() {
        kotlin.c cVar = this.jPG;
        j jVar = $$delegatedProperties[0];
        return (VideoMiddlePageViewModel) cVar.getValue();
    }

    public static final /* synthetic */ com.baidu.tieba.frs.videomiddlepagelight.a a(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = videoMiddlePageLightActivity.jPH;
        if (aVar == null) {
            p.acr("adapterManager");
        }
        return aVar;
    }

    public static final /* synthetic */ GestureDetector b(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        GestureDetector gestureDetector = videoMiddlePageLightActivity.jPJ;
        if (gestureDetector == null) {
            p.acr("listGestureDetector");
        }
        return gestureDetector;
    }

    public static final /* synthetic */ BdTypeRecyclerView g(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        BdTypeRecyclerView bdTypeRecyclerView = videoMiddlePageLightActivity.iPS;
        if (bdTypeRecyclerView == null) {
            p.acr("recyclerView");
        }
        return bdTypeRecyclerView;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > 1000 && f2 < 0) {
                VideoMiddlePageLightActivity.this.cMH().cNf();
            } else if (Math.abs(f2) > 1000 && f2 > 0) {
                VideoMiddlePageLightActivity.this.cMH().cNg();
            }
            return true;
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class b extends CustomMessageListener {
        b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && ((NetWorkChangedMessage) customResponsedMessage).getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    VideoMiddlePageLightActivity.this.cMH().cNh();
                } else {
                    VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VideoMiddlePageViewModel cMH = cMH();
        String stringExtra = getIntent().getStringExtra("PARAM_FID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        cMH.Lx(stringExtra);
        VideoMiddlePageViewModel cMH2 = cMH();
        String stringExtra2 = getIntent().getStringExtra("st_type");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        cMH2.setStType(stringExtra2);
        VideoMiddlePageViewModel cMH3 = cMH();
        String stringExtra3 = getIntent().getStringExtra("yuelaou_locate");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        cMH3.setYuelaouLocate(stringExtra3);
        VideoMiddlePageViewModel cMH4 = cMH();
        String stringExtra4 = getIntent().getStringExtra("PARAM_FROM");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        cMH4.setFrom(stringExtra4);
        VideoMiddlePageViewModel cMH5 = cMH();
        Serializable serializableExtra = getIntent().getSerializableExtra("param_video_thread_info");
        if (serializableExtra == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
        }
        cMH5.a((VideoSerializeVideoThreadInfo) serializableExtra);
        setContentView(R.layout.video_middle_page_light_layout);
        View findViewById = findViewById(R.id.video_middle_page_light_root);
        p.o(findViewById, "findViewById(R.id.video_middle_page_light_root)");
        this.rootView = findViewById;
        this.loadingView = new g(this, getResources().getDimensionPixelSize(R.dimen.ds120));
        View findViewById2 = findViewById(R.id.video_middle_page_light_navigation_bar);
        p.o(findViewById2, "findViewById(R.id.video_…age_light_navigation_bar)");
        this.glw = (NavigationBar) findViewById2;
        NavigationBar navigationBar = this.glw;
        if (navigationBar == null) {
            p.acr("navigationBar");
        }
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar2 = this.glw;
        if (navigationBar2 == null) {
            p.acr("navigationBar");
        }
        navigationBar2.setCenterTextTitle(getString(R.string.tieba_video));
        View findViewById3 = findViewById(R.id.video_middle_page_light_no_network_view);
        p.o(findViewById3, "findViewById(R.id.video_…ge_light_no_network_view)");
        this.gXx = (NoNetworkView) findViewById3;
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            NoNetworkView noNetworkView = this.gXx;
            if (noNetworkView == null) {
                p.acr("noNetworkView");
            }
            noNetworkView.setVisibility(0);
        }
        View findViewById4 = findViewById(R.id.video_middle_page_light_list_view);
        p.o(findViewById4, "findViewById(R.id.video_…dle_page_light_list_view)");
        this.iPS = (BdTypeRecyclerView) findViewById4;
        BdTypeRecyclerView bdTypeRecyclerView = this.iPS;
        if (bdTypeRecyclerView == null) {
            p.acr("recyclerView");
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.jPI = new DividerItemDecoration(this, 1);
        DividerItemDecoration dividerItemDecoration = this.jPI;
        if (dividerItemDecoration == null) {
            p.acr("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        BdTypeRecyclerView bdTypeRecyclerView2 = this.iPS;
        if (bdTypeRecyclerView2 == null) {
            p.acr("recyclerView");
        }
        DividerItemDecoration dividerItemDecoration2 = this.jPI;
        if (dividerItemDecoration2 == null) {
            p.acr("cardDividerLine");
        }
        bdTypeRecyclerView2.addItemDecoration(dividerItemDecoration2);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            BdTypeRecyclerView bdTypeRecyclerView3 = this.iPS;
            if (bdTypeRecyclerView3 == null) {
                p.acr("recyclerView");
            }
            bdTypeRecyclerView3.setVisibility(8);
            NoNetworkView noNetworkView2 = this.gXx;
            if (noNetworkView2 == null) {
                p.acr("noNetworkView");
            }
            noNetworkView2.setVisibility(0);
        }
        registerListener(this.jPP);
        TbPageContext pageContext = getPageContext();
        p.o(pageContext, "pageContext");
        BdTypeRecyclerView bdTypeRecyclerView4 = this.iPS;
        if (bdTypeRecyclerView4 == null) {
            p.acr("recyclerView");
        }
        VideoMiddlePageViewModel cMH6 = cMH();
        p.o(cMH6, "viewModel");
        this.jPH = new com.baidu.tieba.frs.videomiddlepagelight.a(pageContext, bdTypeRecyclerView4, cMH6);
        cMH().loadData();
        showLoadingView();
        cMH().cMX().observe(this, new c());
        this.jPJ = new GestureDetector(this, this.jPN);
        BdTypeRecyclerView bdTypeRecyclerView5 = this.iPS;
        if (bdTypeRecyclerView5 == null) {
            p.acr("recyclerView");
        }
        bdTypeRecyclerView5.setOnTouchListener(new d());
        BdTypeRecyclerView bdTypeRecyclerView6 = this.iPS;
        if (bdTypeRecyclerView6 == null) {
            p.acr("recyclerView");
        }
        bdTypeRecyclerView6.addOnScrollListener(this.jPO);
        cMH().cNb().observe(this, new e());
        cMH().cNa().observe(this, new f());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                Window window = getWindow();
                p.o(window, "window");
                com.baidu.tieba.v.c.a(1, window.getAttributes(), getWindow());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<List<BaseCardInfo>> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: dF */
        public final void onChanged(List<BaseCardInfo> list) {
            if (list.size() > 0) {
                VideoMiddlePageLightActivity.this.hideLoadingView();
                com.baidu.tieba.frs.videomiddlepagelight.a a2 = VideoMiddlePageLightActivity.a(VideoMiddlePageLightActivity.this);
                p.o(list, "it");
                a2.setData(list);
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return VideoMiddlePageLightActivity.b(VideoMiddlePageLightActivity.this).onTouchEvent(motionEvent);
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<Integer> {
        e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: r */
        public final void onChanged(Integer num) {
            if (VideoMiddlePageLightActivity.this.jPM) {
                VideoMiddlePageLightActivity.this.jPM = false;
                return;
            }
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            p.o(num, "it");
            videoMiddlePageLightActivity.AW(num.intValue());
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<String> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: Lw */
        public final void onChanged(String str) {
            if (str != null) {
                if (!l.isBlank(str)) {
                    VideoMiddlePageLightActivity.this.showToast(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jPM = true;
        cMH().cNh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jPH;
        if (aVar == null) {
            p.acr("adapterManager");
        }
        if (aVar != null) {
            aVar.cMI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.VIDEO_LIST;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cMH().cNc().setValue(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        NavigationBar navigationBar = this.glw;
        if (navigationBar == null) {
            p.acr("navigationBar");
        }
        navigationBar.onChangeSkinType(getPageContext(), i);
        NoNetworkView noNetworkView = this.gXx;
        if (noNetworkView == null) {
            p.acr("noNetworkView");
        }
        noNetworkView.onChangeSkinType(getPageContext(), i);
        DividerItemDecoration dividerItemDecoration = this.jPI;
        if (dividerItemDecoration == null) {
            p.acr("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acr("loadingView");
        }
        gVar.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jPH;
        if (aVar == null) {
            p.acr("adapterManager");
        }
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (!com.baidu.adp.lib.util.j.isWifiNet()) {
            com.baidu.tieba.video.f dSn = com.baidu.tieba.video.f.dSn();
            p.o(dSn, "VideoHolyCardManager.getInstance()");
            if (!dSn.dSo()) {
                return false;
            }
        }
        return true;
    }

    public final void showLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acr("loadingView");
        }
        if (!gVar.isViewAttached()) {
            Window window = getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            FrameLayout frameLayout = (FrameLayout) decorView;
            g gVar2 = this.loadingView;
            if (gVar2 == null) {
                p.acr("loadingView");
            }
            gVar2.attachView(frameLayout, false);
        }
    }

    public final void hideLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acr("loadingView");
        }
        if (gVar.isViewAttached()) {
            Window window = getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            FrameLayout frameLayout = (FrameLayout) decorView;
            g gVar2 = this.loadingView;
            if (gVar2 == null) {
                p.acr("loadingView");
            }
            gVar2.dettachView(frameLayout);
        }
    }

    public final void AW(int i) {
        if (i != -1) {
            BdTypeRecyclerView bdTypeRecyclerView = this.iPS;
            if (bdTypeRecyclerView == null) {
                p.acr("recyclerView");
            }
            if (bdTypeRecyclerView.getFirstVisiblePosition() != -1) {
                BdTypeRecyclerView bdTypeRecyclerView2 = this.iPS;
                if (bdTypeRecyclerView2 == null) {
                    p.acr("recyclerView");
                }
                if (i < bdTypeRecyclerView2.getFirstVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.iPS;
                    if (bdTypeRecyclerView3 == null) {
                        p.acr("recyclerView");
                    }
                    bdTypeRecyclerView3.smoothScrollToPosition(i);
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView4 = this.iPS;
                if (bdTypeRecyclerView4 == null) {
                    p.acr("recyclerView");
                }
                if (i <= bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView5 = this.iPS;
                    if (bdTypeRecyclerView5 == null) {
                        p.acr("recyclerView");
                    }
                    int firstVisiblePosition = i - bdTypeRecyclerView5.getFirstVisiblePosition();
                    if (firstVisiblePosition >= 0) {
                        BdTypeRecyclerView bdTypeRecyclerView6 = this.iPS;
                        if (bdTypeRecyclerView6 == null) {
                            p.acr("recyclerView");
                        }
                        if (firstVisiblePosition < bdTypeRecyclerView6.getChildCount()) {
                            BdTypeRecyclerView bdTypeRecyclerView7 = this.iPS;
                            if (bdTypeRecyclerView7 == null) {
                                p.acr("recyclerView");
                            }
                            View childAt = bdTypeRecyclerView7.getChildAt(firstVisiblePosition);
                            p.o(childAt, "recyclerView.getChildAt(movePosition)");
                            int top = childAt.getTop();
                            BdTypeRecyclerView bdTypeRecyclerView8 = this.iPS;
                            if (bdTypeRecyclerView8 == null) {
                                p.acr("recyclerView");
                            }
                            bdTypeRecyclerView8.smoothScrollBy(0, top);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView9 = this.iPS;
                if (bdTypeRecyclerView9 == null) {
                    p.acr("recyclerView");
                }
                bdTypeRecyclerView9.smoothScrollToPosition(i);
                this.jPK = true;
                this.jPL = i;
            }
        }
    }
}
