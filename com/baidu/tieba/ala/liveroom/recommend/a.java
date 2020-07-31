package com.baidu.tieba.ala.liveroom.recommend;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.c;
import com.baidu.live.data.q;
import com.baidu.live.liveroom.g.b;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.AlaListViewPullView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.liveroom.recommend.adapter.RecommendPagerAdapter;
import com.baidu.tieba.ala.liveroom.recommend.model.b;
import com.baidu.tieba.ala.liveroom.recommend.view.AlaRecommendLiveListView;
import com.baidu.tieba.ala.liveroom.recommend.view.RecommendViewPager;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a implements View.OnClickListener, b, d {
    private List<AbsDelegateAdapter> aWf;
    private View avM;
    private CommonEmptyView bjW;
    private int cardWidth;
    private ViewGroup fNw;
    private LoadMoreFooter fPr;
    private FrameLayout gvA;
    private View gvB;
    private View gvC;
    private ViewGroup gvl;
    private RecommendViewPager gvm;
    private AlaRecommendLiveListView gvn;
    private TbListCommonPullView gvo;
    private View gvp;
    private int gvq;
    private float gvr;
    private float gvs;
    private InterfaceC0588a gvt;
    private final int gvu;
    private com.baidu.tieba.ala.liveroom.recommend.model.b gvv;
    private TextView gvw;
    private boolean gvx;
    private q gvy;
    private AlaLiveView gvz;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private float mDownY;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0588a {
        void lg(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gvu = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.gvq = this.mScreenWidth;
            bMk();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (c.vf().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0588a interfaceC0588a) {
        this.gvt = interfaceC0588a;
    }

    public void t(q qVar) {
        this.gvy = qVar;
    }

    public void bw(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.gvp.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.gvp.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.gvz = alaLiveView;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        super.ar(viewGroup);
        if (viewGroup != null) {
            this.fNw = viewGroup;
            this.gvl = (ViewGroup) this.fNw.findViewById(a.g.ala_live_header_view);
            bMl();
            bMj();
            if (!this.gvx && com.baidu.live.v.a.Hs().aZn != null && this.mShowType != 1) {
                long j = c.vf().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.v.a.Hs().aZn.aCk;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            sp(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.fNw != null) {
            this.fNw.removeView(this.gvm);
            this.fNw.removeView(this.gvB);
        }
        this.gvt = null;
        if (this.gvx) {
            c.vf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.gvy = null;
        if (this.gvv != null) {
            this.gvv.reset();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        wd();
        if (this.gvv != null) {
            this.gvv.onDestroy();
        }
    }

    private void bMj() {
        if (this.avM == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gvq, -1);
            this.avM = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.avM.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.avM.findViewById(a.g.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.gvC = this.avM.findViewById(a.g.block_view);
            this.gvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.gvA = (FrameLayout) this.avM.findViewById(a.g.listView_layout);
            this.gvn = (AlaRecommendLiveListView) this.avM.findViewById(a.g.recommendLiveListView);
            this.gvo = new AlaListViewPullView(this.mContext);
            this.gvn.setPullRefresh(this.gvo);
            this.fPr = new LoadMoreFooter(this.mContext);
            this.fPr.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.fPr.setFooterHeight(this.cardWidth / 2);
            this.fPr.createView();
            DS();
            this.gvn.addAdapters(this.aWf);
            this.gvo.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.sp(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.gvn.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.fPr.isLoading() && a.this.gvv != null && a.this.gvv.hasMore && i + i2 > i3 - 2) {
                        a.this.bwT();
                        a.this.sp(1);
                    }
                }
            });
        }
        if (this.gvB == null) {
            this.gvB = new View(this.mContext);
            this.gvB.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.gvB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.gvB.setAlpha(0.0f);
        }
        this.fNw.addView(this.gvB);
        if (this.gvm == null) {
            this.gvm = new RecommendViewPager(getPageContext().getPageActivity());
            this.gvm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.gvm.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.gvB.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.gvm != null) {
                        if (a.this.gvm.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.bMn();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.avM);
            this.gvm.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.gvq, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.gvq;
            this.gvm.setLayoutParams(layoutParams2);
        }
        this.fNw.addView(this.gvm);
        this.gvm.setCurrentItem(1, false);
        if (this.gvv == null) {
            this.gvv = new com.baidu.tieba.ala.liveroom.recommend.model.b(getPageContext());
            this.gvv.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.5
                @Override // com.baidu.tieba.ala.liveroom.recommend.model.b.a
                public void f(List<IAdapterData> list, int i, int i2) {
                    a.this.e(list, i, i2);
                }

                @Override // com.baidu.tieba.ala.liveroom.recommend.model.b.a
                public void onFail(int i, String str) {
                    a.this.b(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void bMk() {
        this.cardWidth = ((((this.gvq - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void DS() {
        if (this.aWf == null) {
            this.aWf = new ArrayList();
            this.aWf.add(new com.baidu.tieba.ala.liveroom.recommend.adapter.b(this.mContext, com.baidu.tieba.ala.liveroom.recommend.data.c.gvY));
            this.aWf.add(new com.baidu.tieba.ala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.ala.liveroom.recommend.data.a.gvU, this.cardWidth));
        }
    }

    private void bMl() {
        this.gvp = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.gvp.setLayoutParams(layoutParams);
        if (this.gvl != null) {
            this.gvl.addView(this.gvp);
        }
        this.gvp.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!B(motionEvent)) {
            return false;
        }
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            return true;
        }
        return d(motionEvent, motionEvent.getActionIndex());
    }

    private boolean d(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.mDownY = motionEvent.getY(i);
                this.gvr = this.mDownX;
                this.gvs = this.mDownY;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.mDownY - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.gvq) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvm.getLayoutParams();
                if (f > this.mTouchSlop) {
                    lY(true);
                    bMm();
                    return true;
                } else if (layoutParams.rightMargin > (-this.gvq)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.gvr - x2;
                float f4 = this.gvs - y2;
                this.gvr = x2;
                this.gvs = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gvm.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.gvm.setLayoutParams(layoutParams2);
                        this.gvB.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.gvq));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.gvq)) {
                        layoutParams2.rightMargin = i3;
                        this.gvm.setLayoutParams(layoutParams2);
                        this.gvB.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.gvq));
                        return true;
                    } else if (i3 < (-this.gvq)) {
                        layoutParams2.rightMargin = -this.gvq;
                        this.gvm.setLayoutParams(layoutParams2);
                        this.gvB.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.gvq));
                        return false;
                    }
                }
                break;
            case 3:
                close();
                break;
        }
        return false;
    }

    private boolean B(MotionEvent motionEvent) {
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.gvz != null) {
            if (this.gvz.getKeyboardVisibility()) {
                return false;
            }
            if (!this.gvz.bNm()) {
                close();
                return false;
            } else if (this.gvz.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void bMm() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void lY(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            lZ(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvm.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                L(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.gvq)));
            }
            if (this.gvt != null) {
                this.gvt.lg(true);
            }
            if (!this.gvx) {
                this.gvx = true;
            }
            this.gvn.completePullRefresh();
            if (z) {
                sp(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1429", LogConfig.KEY_ACCESS, "your_recommend", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.gvy != null && this.gvy.mLiveInfo != null) {
            j = this.gvy.mLiveInfo.live_id;
        }
        this.gvv.l(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<IAdapterData> list, int i, int i2) {
        if (this.gvv.hasMore) {
            bAM();
        } else if (i2 == 1) {
            bAM();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.gvn.setData(list);
        if (this.aWf != null) {
            Iterator<AbsDelegateAdapter> it = this.aWf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.ala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.ala.liveroom.recommend.adapter.a) next).sq(i);
                    ((com.baidu.tieba.ala.liveroom.recommend.adapter.a) next).e(this.gvy);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                c.vf().putBoolean("ala_recommend_live_first_show", false);
            } else {
                c.vf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.gvn.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.gvv != null && !this.gvv.IZ()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.gvn.completePullRefresh();
            return;
        }
        if (this.bjW == null) {
            this.bjW = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bjW.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bjW.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.gvw = (TextView) this.bjW.findViewById(a.g.sdk_cev_refresh_btn);
            this.gvw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gvw.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.gvw.setLayoutParams(layoutParams2);
            if (this.gvA != null) {
                this.bjW.addToParent(this.gvA);
            }
        }
        this.bjW.reset();
        switch (imgType) {
            case NO_NET:
                i = a.i.recommend_live_no_net;
                break;
            case SERVER_ERROR:
                i = a.i.recommend_live_no_response;
                break;
            default:
                i = a.i.recommend_live_no_data;
                break;
        }
        this.bjW.setTitle(i);
        this.bjW.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.gvn.startPullRefresh();
            }
        });
        this.bjW.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gvw.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bjW.setVisibility(0);
        this.gvn.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.gvt != null) {
            this.gvt.lg(false);
        }
        lZ(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvm.getLayoutParams();
        layoutParams.rightMargin = -this.gvq;
        this.gvm.setLayoutParams(layoutParams);
        this.gvm.setCurrentItem(1, false);
        this.gvB.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.gvm.getLayoutParams()).rightMargin > (-this.gvq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMn() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.gvm.getLayoutParams()).rightMargin * 1.0f) / this.gvq);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.gvB.setAlpha(abs);
    }

    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            lZ(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvm.getLayoutParams();
            if (layoutParams.rightMargin > (-this.gvq)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.gvq;
                L(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.gvq)));
            }
            if (this.gvt != null) {
                this.gvt.lg(false);
            }
            this.gvn.completePullRefresh();
        }
    }

    private void L(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gvm.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.gvB.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.gvq));
                a.this.gvm.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.gvm.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.gvB.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mAnimator.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gvp) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            lY(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (B(motionEvent) && isOpen()) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean FL() {
        return false;
    }

    public void bAM() {
        if (this.fPr != null) {
            this.fPr.endLoadData();
            this.gvn.setNextPage(null);
        }
    }

    public void bwT() {
        if (this.fPr != null) {
            if (this.fPr.getView().getParent() == null) {
                this.gvn.setNextPage(this.fPr);
            }
            this.fPr.showLoadView();
        }
    }

    private void lZ(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
