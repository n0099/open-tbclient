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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.AlaListViewPullView;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.ala.liveroom.recommend.model.a;
import com.baidu.tieba.ala.liveroom.recommend.view.AlaRecommendLiveListView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a implements View.OnClickListener, b, d {
    private List<AbsDelegateAdapter> aUP;
    private BdTypeListView aUR;
    private CommonEmptyView bjC;
    private ViewGroup fIb;
    private FrameLayout gmz;
    private ViewGroup gqk;
    private TbListCommonPullView gql;
    private View gqm;
    private int gqn;
    private float gqo;
    private float gqp;
    private InterfaceC0578a gqq;
    private final int gqr;
    private com.baidu.tieba.ala.liveroom.recommend.model.a gqs;
    private TextView gqt;
    private boolean gqu;
    private q gqv;
    private AlaLiveView gqw;
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
    public interface InterfaceC0578a {
        void kD(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gqr = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.gqn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            if (c.vf().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0578a interfaceC0578a) {
        this.gqq = interfaceC0578a;
    }

    public void t(q qVar) {
        this.gqv = qVar;
    }

    public void bt(int i, int i2) {
        this.mScreenWidth = i;
        this.mOrientation = i2;
        if (i2 == 2) {
            this.gqm.setVisibility(8);
            if (this.isOpen) {
                onClose();
                return;
            }
            return;
        }
        this.gqm.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.gqw = alaLiveView;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        super.aq(viewGroup);
        if (viewGroup != null) {
            this.fIb = viewGroup;
            this.gqk = (ViewGroup) this.fIb.findViewById(a.g.ala_live_header_view);
            bJe();
            bJd();
            if (!this.gqu && com.baidu.live.v.a.Hm().aZp != null && this.mShowType != 1) {
                long j = c.vf().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.v.a.Hm().aZp.aAX;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            bJg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.fIb != null) {
            this.fIb.removeView(this.gmz);
        }
        this.gqq = null;
        this.isOpen = false;
        if (this.gqu) {
            c.vf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.gqv = null;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        vH();
        if (this.gqs != null) {
            this.gqs.onDestroy();
        }
    }

    private void bJd() {
        if (this.gmz == null) {
            this.gmz = new FrameLayout(this.mContext);
        }
        if (this.aUR == null) {
            this.aUR = new AlaRecommendLiveListView(this.mContext);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.aUR.setPadding(dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12) + BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), dimensionPixelOffset, 0);
            this.gql = new AlaListViewPullView(this.mContext);
            this.aUR.setPullRefresh(this.gql);
            Dz();
            this.aUR.addAdapters(this.aUP);
            this.gql.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.1
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.bJg();
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.gmz.addView(this.aUR, new FrameLayout.LayoutParams(this.gqn, -1));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gqn, -1);
        layoutParams.gravity = 5;
        layoutParams.rightMargin = -this.gqn;
        this.gmz.setLayoutParams(layoutParams);
        this.fIb.addView(this.gmz);
        if (this.gqs == null) {
            this.gqs = new com.baidu.tieba.ala.liveroom.recommend.model.a(getPageContext());
            this.gqs.a(new a.InterfaceC0580a() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.2
                @Override // com.baidu.tieba.ala.liveroom.recommend.model.a.InterfaceC0580a
                public void h(List<IAdapterData> list, int i) {
                    a.this.g(list, i);
                }

                @Override // com.baidu.tieba.ala.liveroom.recommend.model.a.InterfaceC0580a
                public void onFail(int i, String str) {
                    a.this.b(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void Dz() {
        if (this.aUP == null) {
            this.aUP = new ArrayList();
            this.aUP.add(new com.baidu.tieba.ala.liveroom.recommend.a.b(this.mContext, com.baidu.tieba.ala.liveroom.recommend.data.b.gqI));
            this.aUP.add(new com.baidu.tieba.ala.liveroom.recommend.a.a(this.mContext, AlaRecommendLiveData.ALA_RECOMMEND_LIVE));
        }
    }

    private void bJe() {
        this.gqm = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.gqm.setPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds14), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds78));
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.gqm.setLayoutParams(layoutParams);
        this.gqk.addView(this.gqm);
        this.gqm.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (B(motionEvent)) {
            if (this.mAnimator != null && this.mAnimator.isRunning()) {
                return true;
            }
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getY(actionIndex) >= this.gqn) {
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
                this.gqo = this.mDownX;
                this.gqp = this.mDownY;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.mDownY - y;
                if (this.isOpen && Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.gqn) {
                    onClose();
                    return true;
                } else if (this.isOpen && f < this.mTouchSlop && Math.abs(f) > Math.abs(f2)) {
                    onClose();
                    return true;
                } else if (!this.isOpen && f > this.mTouchSlop && Math.abs(f) > Math.abs(f2)) {
                    lv(true);
                    bJf();
                    return true;
                } else {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmz.getLayoutParams();
                    if (!this.isOpen && layoutParams.rightMargin > (-this.gqn)) {
                        layoutParams.rightMargin = -this.gqn;
                        this.gmz.setLayoutParams(layoutParams);
                        return true;
                    }
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.gqo - x2;
                float f4 = this.gqp - y2;
                this.gqo = x2;
                this.gqp = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gmz.getLayoutParams();
                if (f3 > 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.gmz.setLayoutParams(layoutParams2);
                    }
                    return true;
                } else if (this.isOpen && f3 <= 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.gqn)) {
                        layoutParams2.rightMargin = i3;
                        this.gmz.setLayoutParams(layoutParams2);
                    }
                    return true;
                } else if (!this.isOpen && layoutParams2.rightMargin > (-this.gqn) && f3 <= 0.0f && Math.abs(f3) > Math.abs(f4)) {
                    layoutParams2.rightMargin = -this.gqn;
                    this.gmz.setLayoutParams(layoutParams2);
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
        if (this.gqw != null) {
            if (this.gqw.getKeyboardVisibility()) {
                return false;
            }
            if (!this.gqw.bKf()) {
                close();
                return false;
            } else if (this.gqw.getScrollX() != 0) {
                return false;
            }
        }
        return true;
    }

    private void bJf() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void lv(boolean z) {
        if (!this.isOpen) {
            if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmz.getLayoutParams();
                if (layoutParams.rightMargin < 0) {
                    int i = layoutParams.rightMargin;
                    M(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.gqn)));
                }
                this.isOpen = true;
                if (this.gqq != null) {
                    this.gqq.kD(true);
                }
                if (!this.gqu) {
                    this.gqu = true;
                }
                this.aUR.completePullRefresh();
                if (z) {
                    bJg();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1429", LogConfig.KEY_ACCESS, "your_recommend", null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJg() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.gqv != null && this.gqv.mLiveInfo != null) {
            j = this.gqv.mLiveInfo.live_id;
        }
        this.gqs.dK(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i) {
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.aUR.setData(list);
        if (this.aUP != null) {
            Iterator<AbsDelegateAdapter> it = this.aUP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.ala.liveroom.recommend.a.a) {
                    ((com.baidu.tieba.ala.liveroom.recommend.a.a) next).rY(i);
                    ((com.baidu.tieba.ala.liveroom.recommend.a.a) next).e(this.gqv);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            lv(false);
            if (this.mShowType == 1) {
                c.vf().putBoolean("ala_recommend_live_first_show", false);
            } else {
                c.vf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.aUR.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.bjC == null) {
            this.bjC = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bjC.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bjC.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.gqt = (TextView) this.bjC.findViewById(a.g.sdk_cev_refresh_btn);
            this.gqt.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gqt.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.gqt.setLayoutParams(layoutParams2);
            this.bjC.addToParent(this.gmz);
        }
        this.bjC.reset();
        this.bjC.setBackgroundColor(Color.parseColor("#FF161823"));
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
        this.bjC.setTitle(i);
        this.bjC.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.aUR.startPullRefresh();
            }
        });
        this.bjC.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gqt.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bjC.setVisibility(0);
        this.aUR.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bjC != null) {
            this.bjC.setVisibility(8);
        }
    }

    private void close() {
        if (this.isOpen) {
            if (this.mAnimator != null && this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmz.getLayoutParams();
            layoutParams.rightMargin = -this.gqn;
            this.gmz.setLayoutParams(layoutParams);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void onClose() {
        if (this.isOpen) {
            if (this.mAnimator == null || !this.mAnimator.isRunning()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmz.getLayoutParams();
                if (layoutParams.rightMargin > (-this.gqn)) {
                    int i = layoutParams.rightMargin;
                    int i2 = -this.gqn;
                    M(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.gqn)));
                }
                this.isOpen = false;
                if (this.gqq != null) {
                    this.gqq.kD(false);
                }
                this.aUR.completePullRefresh();
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gmz.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.gmz.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqm) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            lv(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (B(motionEvent) && this.isOpen) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean FR() {
        return this.isOpen;
    }
}
