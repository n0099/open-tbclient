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
    private NoNetworkView gVO;
    private NavigationBar gjT;
    private BdTypeRecyclerView iOj;
    private com.baidu.tieba.frs.videomiddlepagelight.a jNY;
    private DividerItemDecoration jNZ;
    private GestureDetector jOa;
    private boolean jOb;
    private int jOc;
    private boolean jOd;
    private g loadingView;
    private View rootView;
    private final kotlin.c jNX = kotlin.d.b(new VideoMiddlePageLightActivity$viewModel$2(this));
    private final a jOe = new a();
    private final VideoMiddlePageLightActivity$scrollListener$1 jOf = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            boolean z;
            int i2;
            p.o(recyclerView, "rv");
            super.onScrollStateChanged(recyclerView, i);
            z = VideoMiddlePageLightActivity.this.jOb;
            if (!z || i != 0) {
                Integer value = VideoMiddlePageLightActivity.this.cMB().cMV().getValue();
                if (value != null && i == 0) {
                    if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition() == -1) {
                        if (VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition() != -1) {
                            int firstVisiblePosition = VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition();
                            Integer value2 = VideoMiddlePageLightActivity.this.cMB().cMV().getValue();
                            if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                VideoMiddlePageLightActivity.this.jOd = true;
                                VideoMiddlePageLightActivity.this.cMB().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstVisiblePosition());
                            }
                        }
                    } else if (value.intValue() < VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition()) {
                        e.mA().post(new a());
                    } else if (value.intValue() > VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition()) {
                        e.mA().post(new b());
                    }
                }
                if (!VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).canScrollVertically(1)) {
                    if (p.l(VideoMiddlePageLightActivity.this.cMB().cMT().getValue(), false) && p.l(VideoMiddlePageLightActivity.this.cMB().cMS().getValue(), false)) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.no_more_video_content);
                        return;
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        VideoMiddlePageLightActivity.this.showToast(R.string.hard_loading);
                        VideoMiddlePageLightActivity.this.cMB().loadData();
                        return;
                    } else {
                        VideoMiddlePageLightActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                return;
            }
            VideoMiddlePageLightActivity.this.jOb = false;
            VideoMiddlePageLightActivity videoMiddlePageLightActivity = VideoMiddlePageLightActivity.this;
            i2 = VideoMiddlePageLightActivity.this.jOc;
            videoMiddlePageLightActivity.AV(i2);
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jOd = true;
                VideoMiddlePageLightActivity.this.cMB().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getFirstCompletelyVisiblePosition());
            }
        }

        @kotlin.e
        /* loaded from: classes2.dex */
        static final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoMiddlePageLightActivity.this.jOd = true;
                VideoMiddlePageLightActivity.this.cMB().AZ(VideoMiddlePageLightActivity.g(VideoMiddlePageLightActivity.this).getLastCompletelyVisiblePosition());
            }
        }
    };
    private final CustomMessageListener jOg = new b(MessageConfig.CMD_NETWORK_CHANGED);

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoMiddlePageViewModel cMB() {
        kotlin.c cVar = this.jNX;
        j jVar = $$delegatedProperties[0];
        return (VideoMiddlePageViewModel) cVar.getValue();
    }

    public static final /* synthetic */ com.baidu.tieba.frs.videomiddlepagelight.a a(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = videoMiddlePageLightActivity.jNY;
        if (aVar == null) {
            p.acs("adapterManager");
        }
        return aVar;
    }

    public static final /* synthetic */ GestureDetector b(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        GestureDetector gestureDetector = videoMiddlePageLightActivity.jOa;
        if (gestureDetector == null) {
            p.acs("listGestureDetector");
        }
        return gestureDetector;
    }

    public static final /* synthetic */ BdTypeRecyclerView g(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        BdTypeRecyclerView bdTypeRecyclerView = videoMiddlePageLightActivity.iOj;
        if (bdTypeRecyclerView == null) {
            p.acs("recyclerView");
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
                VideoMiddlePageLightActivity.this.cMB().cMZ();
            } else if (Math.abs(f2) > 1000 && f2 > 0) {
                VideoMiddlePageLightActivity.this.cMB().cNa();
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
                    VideoMiddlePageLightActivity.this.cMB().cNb();
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
        VideoMiddlePageViewModel cMB = cMB();
        String stringExtra = getIntent().getStringExtra("PARAM_FID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        cMB.Lo(stringExtra);
        VideoMiddlePageViewModel cMB2 = cMB();
        String stringExtra2 = getIntent().getStringExtra("st_type");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        cMB2.setStType(stringExtra2);
        VideoMiddlePageViewModel cMB3 = cMB();
        String stringExtra3 = getIntent().getStringExtra("yuelaou_locate");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        cMB3.setYuelaouLocate(stringExtra3);
        VideoMiddlePageViewModel cMB4 = cMB();
        String stringExtra4 = getIntent().getStringExtra("PARAM_FROM");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        cMB4.setFrom(stringExtra4);
        VideoMiddlePageViewModel cMB5 = cMB();
        Serializable serializableExtra = getIntent().getSerializableExtra("param_video_thread_info");
        if (serializableExtra == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo");
        }
        cMB5.a((VideoSerializeVideoThreadInfo) serializableExtra);
        setContentView(R.layout.video_middle_page_light_layout);
        View findViewById = findViewById(R.id.video_middle_page_light_root);
        p.n(findViewById, "findViewById(R.id.video_middle_page_light_root)");
        this.rootView = findViewById;
        this.loadingView = new g(this, getResources().getDimensionPixelSize(R.dimen.ds120));
        View findViewById2 = findViewById(R.id.video_middle_page_light_navigation_bar);
        p.n(findViewById2, "findViewById(R.id.video_…age_light_navigation_bar)");
        this.gjT = (NavigationBar) findViewById2;
        NavigationBar navigationBar = this.gjT;
        if (navigationBar == null) {
            p.acs("navigationBar");
        }
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar2 = this.gjT;
        if (navigationBar2 == null) {
            p.acs("navigationBar");
        }
        navigationBar2.setCenterTextTitle(getString(R.string.tieba_video));
        View findViewById3 = findViewById(R.id.video_middle_page_light_no_network_view);
        p.n(findViewById3, "findViewById(R.id.video_…ge_light_no_network_view)");
        this.gVO = (NoNetworkView) findViewById3;
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            NoNetworkView noNetworkView = this.gVO;
            if (noNetworkView == null) {
                p.acs("noNetworkView");
            }
            noNetworkView.setVisibility(0);
        }
        View findViewById4 = findViewById(R.id.video_middle_page_light_list_view);
        p.n(findViewById4, "findViewById(R.id.video_…dle_page_light_list_view)");
        this.iOj = (BdTypeRecyclerView) findViewById4;
        BdTypeRecyclerView bdTypeRecyclerView = this.iOj;
        if (bdTypeRecyclerView == null) {
            p.acs("recyclerView");
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.jNZ = new DividerItemDecoration(this, 1);
        DividerItemDecoration dividerItemDecoration = this.jNZ;
        if (dividerItemDecoration == null) {
            p.acs("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        BdTypeRecyclerView bdTypeRecyclerView2 = this.iOj;
        if (bdTypeRecyclerView2 == null) {
            p.acs("recyclerView");
        }
        DividerItemDecoration dividerItemDecoration2 = this.jNZ;
        if (dividerItemDecoration2 == null) {
            p.acs("cardDividerLine");
        }
        bdTypeRecyclerView2.addItemDecoration(dividerItemDecoration2);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            BdTypeRecyclerView bdTypeRecyclerView3 = this.iOj;
            if (bdTypeRecyclerView3 == null) {
                p.acs("recyclerView");
            }
            bdTypeRecyclerView3.setVisibility(8);
            NoNetworkView noNetworkView2 = this.gVO;
            if (noNetworkView2 == null) {
                p.acs("noNetworkView");
            }
            noNetworkView2.setVisibility(0);
        }
        registerListener(this.jOg);
        TbPageContext pageContext = getPageContext();
        p.n(pageContext, "pageContext");
        BdTypeRecyclerView bdTypeRecyclerView4 = this.iOj;
        if (bdTypeRecyclerView4 == null) {
            p.acs("recyclerView");
        }
        VideoMiddlePageViewModel cMB6 = cMB();
        p.n(cMB6, "viewModel");
        this.jNY = new com.baidu.tieba.frs.videomiddlepagelight.a(pageContext, bdTypeRecyclerView4, cMB6);
        cMB().loadData();
        showLoadingView();
        cMB().cMR().observe(this, new c());
        this.jOa = new GestureDetector(this, this.jOe);
        BdTypeRecyclerView bdTypeRecyclerView5 = this.iOj;
        if (bdTypeRecyclerView5 == null) {
            p.acs("recyclerView");
        }
        bdTypeRecyclerView5.setOnTouchListener(new d());
        BdTypeRecyclerView bdTypeRecyclerView6 = this.iOj;
        if (bdTypeRecyclerView6 == null) {
            p.acs("recyclerView");
        }
        bdTypeRecyclerView6.addOnScrollListener(this.jOf);
        cMB().cMV().observe(this, new e());
        cMB().cMU().observe(this, new f());
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
            if (VideoMiddlePageLightActivity.this.jOd) {
                VideoMiddlePageLightActivity.this.jOd = false;
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
        /* renamed from: Ln */
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
        this.jOd = true;
        cMB().cNb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jNY;
        if (aVar == null) {
            p.acs("adapterManager");
        }
        if (aVar != null) {
            aVar.cMC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.VIDEO_LIST;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cMB().cMW().setValue(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        NavigationBar navigationBar = this.gjT;
        if (navigationBar == null) {
            p.acs("navigationBar");
        }
        navigationBar.onChangeSkinType(getPageContext(), i);
        NoNetworkView noNetworkView = this.gVO;
        if (noNetworkView == null) {
            p.acs("noNetworkView");
        }
        noNetworkView.onChangeSkinType(getPageContext(), i);
        DividerItemDecoration dividerItemDecoration = this.jNZ;
        if (dividerItemDecoration == null) {
            p.acs("cardDividerLine");
        }
        dividerItemDecoration.setDrawable(ap.getDrawable(R.drawable.shape_card_video_middle_page_divider));
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acs("loadingView");
        }
        gVar.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.frs.videomiddlepagelight.a aVar = this.jNY;
        if (aVar == null) {
            p.acs("adapterManager");
        }
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void showLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acs("loadingView");
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
                p.acs("loadingView");
            }
            gVar2.attachView(frameLayout, false);
        }
    }

    public final void hideLoadingView() {
        g gVar = this.loadingView;
        if (gVar == null) {
            p.acs("loadingView");
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
                p.acs("loadingView");
            }
            gVar2.dettachView(frameLayout);
        }
    }

    public final void AV(int i) {
        if (i != -1) {
            BdTypeRecyclerView bdTypeRecyclerView = this.iOj;
            if (bdTypeRecyclerView == null) {
                p.acs("recyclerView");
            }
            if (bdTypeRecyclerView.getFirstVisiblePosition() != -1) {
                BdTypeRecyclerView bdTypeRecyclerView2 = this.iOj;
                if (bdTypeRecyclerView2 == null) {
                    p.acs("recyclerView");
                }
                if (i < bdTypeRecyclerView2.getFirstVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.iOj;
                    if (bdTypeRecyclerView3 == null) {
                        p.acs("recyclerView");
                    }
                    bdTypeRecyclerView3.smoothScrollToPosition(i);
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView4 = this.iOj;
                if (bdTypeRecyclerView4 == null) {
                    p.acs("recyclerView");
                }
                if (i <= bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
                    BdTypeRecyclerView bdTypeRecyclerView5 = this.iOj;
                    if (bdTypeRecyclerView5 == null) {
                        p.acs("recyclerView");
                    }
                    int firstVisiblePosition = i - bdTypeRecyclerView5.getFirstVisiblePosition();
                    if (firstVisiblePosition >= 0) {
                        BdTypeRecyclerView bdTypeRecyclerView6 = this.iOj;
                        if (bdTypeRecyclerView6 == null) {
                            p.acs("recyclerView");
                        }
                        if (firstVisiblePosition < bdTypeRecyclerView6.getChildCount()) {
                            BdTypeRecyclerView bdTypeRecyclerView7 = this.iOj;
                            if (bdTypeRecyclerView7 == null) {
                                p.acs("recyclerView");
                            }
                            View childAt = bdTypeRecyclerView7.getChildAt(firstVisiblePosition);
                            p.n(childAt, "recyclerView.getChildAt(movePosition)");
                            int top = childAt.getTop();
                            BdTypeRecyclerView bdTypeRecyclerView8 = this.iOj;
                            if (bdTypeRecyclerView8 == null) {
                                p.acs("recyclerView");
                            }
                            bdTypeRecyclerView8.smoothScrollBy(0, top);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BdTypeRecyclerView bdTypeRecyclerView9 = this.iOj;
                if (bdTypeRecyclerView9 == null) {
                    p.acs("recyclerView");
                }
                bdTypeRecyclerView9.smoothScrollToPosition(i);
                this.jOb = true;
                this.jOc = i;
            }
        }
    }
}
