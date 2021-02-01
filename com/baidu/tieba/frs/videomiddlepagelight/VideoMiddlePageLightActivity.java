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
    private NoNetworkView gVA;
    private NavigationBar gjF;
    private BdTypeRecyclerView iNV;
    private com.baidu.tieba.frs.videomiddlepagelight.a jNK;
    private DividerItemDecoration jNL;
    private GestureDetector jNM;
    private boolean jNN;
    private int jNO;
    private boolean jNP;
    private g loadingView;
    private View rootView;
    private final kotlin.c jNJ = kotlin.d.b(new VideoMiddlePageLightActivity$viewModel$2(this));
    private final a jNQ = new a();
    private final VideoMiddlePageLightActivity$scrollListener$1 jNR = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            boolean z;
            int i2;
            p.o(recyclerView, "rv");
            super.onScrollStateChanged(recyclerView, i);
            z = VideoMiddlePageLightActivity.this.jNN;
            if (!z || i != 0) {
                Integer value = VideoMiddlePageLightActivity.this.cMu().cMO().getValue();
                if (value != null && i == 0) {
                    if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition() == -1) {
                        if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition() != -1) {
                            int firstVisiblePosition = VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition();
                            Integer value2 = VideoMiddlePageLightActivity.this.cMu().cMO().getValue();
                            if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                VideoMiddlePageLightActivity.this.jNP = true;
                                VideoMiddlePageLightActivity.this.cMu().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition());
                            }
                        }
                    } else if (value.intValue() < VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition()) {
                        e.mA().post(new a());
                    } else if (value.intValue() > VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition()) {
                        e.mA().post(new b());
                    }
                }
                if (!VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).canScrollVertically(1)) {
                    if (p.l(VideoMiddlePageLightActivity.this.cMu().cMM().getValue(), false) && p.l(VideoMiddlePageLightActivity.this.cMu().cML().getValue(), false)) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.no_more_video_content);
                        return;
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.hard_loading);
                        VideoMiddlePageLightActivity.this.cMu().loadData();
                        return;
                    } else {
                        VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                return;
            }
            VideoMiddlePageLightActivity.this.jNN = false;
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            i2 = VideoMiddlePageLightActivity.this.jNO;
            videoMiddlePageLightActivity.AV(i2);
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jNP = true;
                VideoMiddlePageLightActivity.this.cMu().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition());
            }
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jNP = true;
                VideoMiddlePageLightActivity.this.cMu().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition());
            }
        }
    };
    private final CustomMessageListener jNS = new b(MessageConfig.CMD_NETWORK_CHANGED);

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoMiddlePageViewModel cMu() {
        kotlin.c cVar = this.jNJ;
        j jVar = $$delegatedProperties[0];
        return (VideoMiddlePageViewModel) cVar.getValue();
    }

    public static final /* synthetic */ com.baidu.tieba.frs.videomiddlepagelight.a a(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = videoMiddlePageLightActivity.jNK;
        if (aVar == null) {
            p.acg("adapterManager");
        }
        return aVar;
    }

    public static final /* synthetic */ GestureDetector b(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        GestureDetector gestureDetector = videoMiddlePageLightActivity.jNM;
        if (gestureDetector == null) {
            p.acg("listGestureDetector");
        }
        return gestureDetector;
    }

    public static final /* synthetic */ BdTypeRecyclerView g(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        BdTypeRecyclerView bdTypeRecyclerView = videoMiddlePageLightActivity.iNV;
        if (bdTypeRecyclerView == null) {
            p.acg("recyclerView");
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
                VideoMiddlePageLightActivity.this.cMu().cMS();
            } else if (Math.abs(f2) > 1000 && f2 > 0) {
                VideoMiddlePageLightActivity.this.cMu().cMT();
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
                    VideoMiddlePageLightActivity.this.cMu().cMU();
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
        VideoMiddlePageViewModel cMu = cMu();
        String stringExtra = getIntent().getStringExtra("PARAM_FID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        cMu.Ln(stringExtra);
        VideoMiddlePageViewModel cMu2 = cMu();
        String stringExtra2 = getIntent().getStringExtra("st_type");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        cMu2.setStType(stringExtra2);
        VideoMiddlePageViewModel cMu3 = cMu();
        String stringExtra3 = getIntent().getStringExtra("yuelaou_locate");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        cMu3.setYuelaouLocate(stringExtra3);
        VideoMiddlePageViewModel cMu4 = cMu();
        String stringExtra4 = getIntent().getStringExtra("PARAM_FROM");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        cMu4.setFrom(stringExtra4);
        VideoMiddlePageViewModel cMu5 = cMu();
        Serializable serializableExtra = getIntent().getSerializableExtra("param_video_thread_info");
        if (serializableExtra == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
        }
        cMu5.a((VideoSerializeVideoThreadInfo) serializableExtra);
        setContentView(R.layout.video_middle_page_light_layout);
        View findViewById = findViewById(R.id.video_middle_page_light_root);
        p.n(findViewById, "findViewById(R.id.video_middle_page_light_root)");
        this.rootView = findViewById;
        this.loadingView = new g(this, getResources().getDimensionPixelSize(R.dimen.ds120));
        View findViewById2 = findViewById(R.id.video_middle_page_light_navigation_bar);
        p.n(findViewById2, "findViewById(R.id.video_…age_light_navigation_bar)");
        this.gjF = (NavigationBar) findViewById2;
        NavigationBar navigationBar = this.gjF;
        if (navigationBar == null) {
            p.acg("navigationBar");
        }
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar2 = this.gjF;
        if (navigationBar2 == null) {
            p.acg("navigationBar");
        }
        navigationBar2.setCenterTextTitle(getString(R.string.tieba_video));
        View findViewById3 = findViewById(R.id.video_middle_page_light_no_network_view);
        p.n(findViewById3, "findViewById(R.id.video_…ge_light_no_network_view)");
        this.gVA = (NoNetworkView) findViewById3;
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            NoNetworkView noNetworkView = this.gVA;
            if (noNetworkView == null) {
                p.acg("noNetworkView");
            }
            noNetworkView.setVisibility(0);
        }
        View findViewById4 = findViewById(R.id.video_middle_page_light_list_view);
        p.n(findViewById4, "findViewById(R.id.video_…dle_page_light_list_view)");
        this.iNV = (BdTypeRecyclerView) findViewById4;
        BdTypeRecyclerView bdTypeRecyclerView = this.iNV;
        if (bdTypeRecyclerView == null) {
            p.acg("recyclerView");
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.jNL = new DividerItemDecoration(this, 1);
        DividerItemDecoration dividerItemDecoration = this.jNL;
        if (dividerItemDecoration == null) {
            p.acg("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        BdTypeRecyclerView bdTypeRecyclerView2 = this.iNV;
        if (bdTypeRecyclerView2 == null) {
            p.acg("recyclerView");
        }
        DividerItemDecoration dividerItemDecoration2 = this.jNL;
        if (dividerItemDecoration2 == null) {
            p.acg("cardDividerLine");
        }
        bdTypeRecyclerView2.addItemDecoration(dividerItemDecoration2);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            BdTypeRecyclerView bdTypeRecyclerView3 = this.iNV;
            if (bdTypeRecyclerView3 == null) {
                p.acg("recyclerView");
            }
            bdTypeRecyclerView3.setVisibility(8);
            NoNetworkView noNetworkView2 = this.gVA;
            if (noNetworkView2 == null) {
                p.acg("noNetworkView");
            }
            noNetworkView2.setVisibility(0);
        }
        registerListener(this.jNS);
        TbPageContext pageContext = getPageContext();
        p.n(pageContext, "pageContext");
        BdTypeRecyclerView bdTypeRecyclerView4 = this.iNV;
        if (bdTypeRecyclerView4 == null) {
            p.acg("recyclerView");
        }
        VideoMiddlePageViewModel cMu6 = cMu();
        p.n(cMu6, "viewModel");
        this.jNK = new com.baidu.tieba.frs.videomiddlepagelight.a(pageContext, bdTypeRecyclerView4, cMu6);
        cMu().loadData();
        showLoadingView();
        cMu().cMK().observe(this, new c());
        this.jNM = new GestureDetector(this, this.jNQ);
        BdTypeRecyclerView bdTypeRecyclerView5 = this.iNV;
        if (bdTypeRecyclerView5 == null) {
            p.acg("recyclerView");
        }
        bdTypeRecyclerView5.setOnTouchListener(new d());
        BdTypeRecyclerView bdTypeRecyclerView6 = this.iNV;
        if (bdTypeRecyclerView6 == null) {
            p.acg("recyclerView");
        }
        bdTypeRecyclerView6.addOnScrollListener(this.jNR);
        cMu().cMO().observe(this, new e());
        cMu().cMN().observe(this, new f());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                Window window = getWindow();
                p.n(window, "window");
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
                p.n(list, "it");
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
            if (VideoMiddlePageLightActivity.this.jNP) {
                VideoMiddlePageLightActivity.this.jNP = false;
                return;
            }
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            p.n(num, "it");
            videoMiddlePageLightActivity.AV(num.intValue());
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<String> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: Lm */
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
        this.jNP = true;
        cMu().cMU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jNK;
        if (aVar == null) {
            p.acg("adapterManager");
        }
        if (aVar != null) {
            aVar.cMv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.VIDEO_LIST;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cMu().cMP().setValue(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        NavigationBar navigationBar = this.gjF;
        if (navigationBar == null) {
            p.acg("navigationBar");
        }
        navigationBar.onChangeSkinType(getPageContext(), i);
        NoNetworkView noNetworkView = this.gVA;
        if (noNetworkView == null) {
            p.acg("noNetworkView");
        }
        noNetworkView.onChangeSkinType(getPageContext(), i);
        DividerItemDecoration dividerItemDecoration = this.jNL;
        if (dividerItemDecoration == null) {
            p.acg("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acg("loadingView");
        }
        gVar.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jNK;
        if (aVar == null) {
            p.acg("adapterManager");
        }
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void showLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acg("loadingView");
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
                p.acg("loadingView");
            }
            gVar2.attachView(frameLayout, false);
        }
    }

    public final void hideLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acg("loadingView");
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
                p.acg("loadingView");
            }
            gVar2.dettachView(frameLayout);
        }
    }

    public final void AV(int i) {
        if (i != -1) {
            BdTypeRecyclerView bdTypeRecyclerView = this.iNV;
            if (bdTypeRecyclerView == null) {
                p.acg("recyclerView");
            }
            if (bdTypeRecyclerView.getFirstVisiblePosition() != -1) {
                BdTypeRecyclerView bdTypeRecyclerView2 = this.iNV;
                if (bdTypeRecyclerView2 == null) {
                    p.acg("recyclerView");
                }
                if (i < bdTypeRecyclerView2.getFirstVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.iNV;
                    if (bdTypeRecyclerView3 == null) {
                        p.acg("recyclerView");
                    }
                    bdTypeRecyclerView3.smoothScrollToPosition(i);
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView4 = this.iNV;
                if (bdTypeRecyclerView4 == null) {
                    p.acg("recyclerView");
                }
                if (i <= bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView5 = this.iNV;
                    if (bdTypeRecyclerView5 == null) {
                        p.acg("recyclerView");
                    }
                    int firstVisiblePosition = i - bdTypeRecyclerView5.getFirstVisiblePosition();
                    if (firstVisiblePosition >= 0) {
                        BdTypeRecyclerView bdTypeRecyclerView6 = this.iNV;
                        if (bdTypeRecyclerView6 == null) {
                            p.acg("recyclerView");
                        }
                        if (firstVisiblePosition < bdTypeRecyclerView6.getChildCount()) {
                            BdTypeRecyclerView bdTypeRecyclerView7 = this.iNV;
                            if (bdTypeRecyclerView7 == null) {
                                p.acg("recyclerView");
                            }
                            View childAt = bdTypeRecyclerView7.getChildAt(firstVisiblePosition);
                            p.n(childAt, "recyclerView.getChildAt(movePosition)");
                            int top = childAt.getTop();
                            BdTypeRecyclerView bdTypeRecyclerView8 = this.iNV;
                            if (bdTypeRecyclerView8 == null) {
                                p.acg("recyclerView");
                            }
                            bdTypeRecyclerView8.smoothScrollBy(0, top);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView9 = this.iNV;
                if (bdTypeRecyclerView9 == null) {
                    p.acg("recyclerView");
                }
                bdTypeRecyclerView9.smoothScrollToPosition(i);
                this.jNN = true;
                this.jNO = i;
            }
        }
    }
}
