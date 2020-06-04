package com.baidu.tieba.ala.liveroom.recommend;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.c;
import com.baidu.live.data.q;
import com.baidu.live.liveroom.g.b;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.ala.liveroom.recommend.model.a;
import com.baidu.tieba.ala.liveroom.recommend.view.AlaRecommendLiveListView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a implements View.OnClickListener, b, d {
    private List<AbsDelegateAdapter> aSj;
    private BdTypeListView aSl;
    private CommonEmptyView beq;
    private FrameLayout fZB;
    private ViewGroup foI;
    private boolean gdA;
    private q gdB;
    private AlaLiveView gdC;
    private ViewGroup gdq;
    private TbListCommonPullView gdr;
    private View gds;
    private int gdt;
    private float gdu;
    private float gdv;
    private InterfaceC0569a gdw;
    private final int gdx;
    private com.baidu.tieba.ala.liveroom.recommend.model.a gdy;
    private TextView gdz;
    private boolean isOpen;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private float mDownY;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0569a {
        void kq(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gdx = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.gdt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            if (c.uN().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0569a interfaceC0569a) {
        this.gdw = interfaceC0569a;
    }

    public void r(q qVar) {
        this.gdB = qVar;
    }

    public void bp(int i, int i2) {
        this.mScreenWidth = i;
        this.mOrientation = i2;
        if (i2 == 2) {
            this.gds.setVisibility(8);
            if (this.isOpen) {
                onClose();
                return;
            }
            return;
        }
        this.gds.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.gdC = alaLiveView;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        if (viewGroup != null) {
            this.foI = viewGroup;
            this.gdq = (ViewGroup) this.foI.findViewById(a.g.ala_live_header_view);
            bFZ();
            bFY();
            if (!this.gdA && com.baidu.live.v.a.Ge().aWF != null && this.mShowType != 1) {
                long j = c.uN().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.v.a.Ge().aWF.ayG;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            bGb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.foI != null) {
            this.foI.removeView(this.fZB);
        }
        this.gdw = null;
        this.isOpen = false;
        if (this.gdA) {
            c.uN().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.gdB = null;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        vm();
        if (this.gdy != null) {
            this.gdy.onDestroy();
        }
    }

    private void bFY() {
        if (this.fZB == null) {
            this.fZB = new FrameLayout(this.mContext);
        }
        if (this.aSl == null) {
            this.aSl = new AlaRecommendLiveListView(this.mContext);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.aSl.setPadding(dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12) + BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), dimensionPixelOffset, 0);
            this.gdr = new com.baidu.tieba.ala.liveroom.recommend.view.a(this.mContext);
            this.aSl.setPullRefresh(this.gdr);
            CY();
            this.aSl.addAdapters(this.aSj);
            this.gdr.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.1
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.bGb();
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.fZB.addView(this.aSl, new FrameLayout.LayoutParams(this.gdt, -1));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gdt, -1);
        layoutParams.gravity = 5;
        layoutParams.rightMargin = -this.gdt;
        this.fZB.setLayoutParams(layoutParams);
        this.foI.addView(this.fZB);
        if (this.gdy == null) {
            this.gdy = new com.baidu.tieba.ala.liveroom.recommend.model.a(getPageContext());
            this.gdy.a(new a.InterfaceC0571a() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.2
                @Override // com.baidu.tieba.ala.liveroom.recommend.model.a.InterfaceC0571a
                public void g(List<IAdapterData> list, int i) {
                    a.this.f(list, i);
                }

                @Override // com.baidu.tieba.ala.liveroom.recommend.model.a.InterfaceC0571a
                public void onFail(int i, String str) {
                    a.this.a(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void CY() {
        if (this.aSj == null) {
            this.aSj = new ArrayList();
            this.aSj.add(new com.baidu.tieba.ala.liveroom.recommend.a.b(this.mContext, com.baidu.tieba.ala.liveroom.recommend.data.b.gdO));
            this.aSj.add(new com.baidu.tieba.ala.liveroom.recommend.a.a(this.mContext, AlaRecommendLiveData.ALA_RECOMMEND_LIVE));
        }
    }

    private void bFZ() {
        this.gds = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.gds.setPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds14), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds78));
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.gds.setLayoutParams(layoutParams);
        this.gdq.addView(this.gds);
        this.gds.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (B(motionEvent)) {
            if (this.mAnimator != null && this.mAnimator.isRunning()) {
                return true;
            }
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getY(actionIndex) >= this.gdt) {
                return d(motionEvent, actionIndex);
            }
            return false;
        }
        return false;
    }

    private boolean d(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.mDownY = motionEvent.getY(i);
                this.gdu = this.mDownX;
                this.gdv = this.mDownY;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.mDownY - y;
                if (this.isOpen && Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.gdt) {
                    onClose();
                    return true;
                } else if (this.isOpen && f < this.mTouchSlop && Math.abs(f) > Math.abs(f2)) {
                    onClose();
                    return true;
                } else if (!this.isOpen && f > this.mTouchSlop && Math.abs(f) > Math.abs(f2)) {
                    ln(true);
                    bGa();
                    return true;
                } else {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZB.getLayoutParams();
                    if (!this.isOpen && layoutParams.rightMargin > (-this.gdt)) {
                        layoutParams.rightMargin = -this.gdt;
                        this.fZB.setLayoutParams(layoutParams);
                        return true;
                    }
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.gdu - x2;
                float f4 = this.gdv - y2;
                this.gdu = x2;
                this.gdv = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZB.getLayoutParams();
                if (f3 > 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.fZB.setLayoutParams(layoutParams2);
                    }
                    return true;
                } else if (this.isOpen && f3 <= 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.gdt)) {
                        layoutParams2.rightMargin = i3;
                        this.fZB.setLayoutParams(layoutParams2);
                    }
                    return true;
                } else if (!this.isOpen && layoutParams2.rightMargin > (-this.gdt) && f3 <= 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    layoutParams2.rightMargin = -this.gdt;
                    this.fZB.setLayoutParams(layoutParams2);
                    return true;
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
        if (this.gdC != null) {
            if (this.gdC.getKeyboardVisibility()) {
                return false;
            }
            if (!this.gdC.bGY()) {
                close();
                return false;
            } else if (this.gdC.getScrollX() != 0) {
                return false;
            }
        }
        return true;
    }

    private void bGa() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void ln(boolean z) {
        if (!this.isOpen) {
            if (this.mAnimator == null || !this.mAnimator.isRunning()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZB.getLayoutParams();
                if (layoutParams.rightMargin < 0) {
                    int i = layoutParams.rightMargin;
                    M(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.gdt)));
                }
                this.isOpen = true;
                if (this.gdw != null) {
                    this.gdw.kq(true);
                }
                if (!this.gdA) {
                    this.gdA = true;
                }
                this.aSl.completePullRefresh();
                if (z) {
                    bGb();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1429", LogConfig.KEY_ACCESS, "your_recommend", null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGb() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            a(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.gdB != null && this.gdB.mLiveInfo != null) {
            j = this.gdB.mLiveInfo.live_id;
        }
        this.gdy.dH(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<IAdapterData> list, int i) {
        if (ListUtils.isEmpty(list)) {
            a(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.aSl.setData(list);
        if (this.aSj != null) {
            Iterator<AbsDelegateAdapter> it = this.aSj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.ala.liveroom.recommend.a.a) {
                    ((com.baidu.tieba.ala.liveroom.recommend.a.a) next).rA(i);
                    break;
                }
            }
        }
        if (this.mShowType == 1 || this.mShowType == 2) {
            ln(false);
            if (this.mShowType == 1) {
                c.uN().putBoolean("ala_recommend_live_first_show", false);
            } else {
                c.uN().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.aSl.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.beq == null) {
            this.beq = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.beq.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.beq.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.gdz = (TextView) this.beq.findViewById(a.g.sdk_cev_refresh_btn);
            this.gdz.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdz.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.gdz.setLayoutParams(layoutParams2);
            this.beq.addToParent(this.fZB);
        }
        this.beq.reset();
        this.beq.setBackgroundColor(Color.parseColor("#FF161823"));
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
        this.beq.setTitle(i);
        this.beq.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.aSl.startPullRefresh();
            }
        });
        this.beq.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gdz.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.beq.setVisibility(0);
        this.aSl.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }

    private void close() {
        if (this.isOpen) {
            if (this.mAnimator != null && this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZB.getLayoutParams();
            layoutParams.rightMargin = -this.gdt;
            this.fZB.setLayoutParams(layoutParams);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void onClose() {
        if (this.isOpen) {
            if (this.mAnimator == null || !this.mAnimator.isRunning()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZB.getLayoutParams();
                if (layoutParams.rightMargin > (-this.gdt)) {
                    int i = layoutParams.rightMargin;
                    int i2 = -this.gdt;
                    M(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.gdt)));
                }
                this.isOpen = false;
                if (this.gdw != null) {
                    this.gdw.kq(false);
                }
                this.aSl.completePullRefresh();
            }
        }
    }

    private void M(final int i, int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fZB.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.fZB.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gds) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            ln(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (B(motionEvent) && this.isOpen) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }
}
