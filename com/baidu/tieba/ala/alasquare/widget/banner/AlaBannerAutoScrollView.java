package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c fPd;
    private g fQA;
    private int fQB;
    private long fQC;
    private boolean fQD;
    private boolean fQE;
    private e fQF;
    private d fQG;
    private Runnable fQH;
    private LinearLayout fQx;
    private RecyclerView fQy;
    private a fQz;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fQA = new g();
        this.fQB = -1;
        this.fQC = 2000L;
        this.fQD = false;
        this.fQE = false;
        this.fPd = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b n(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fPf;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void am(View view) {
                        this.fPf = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fPf != null && !StringUtils.isNull(bVar.pic)) {
                            this.fPf.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fQH = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fQE && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fQH, AlaBannerAutoScrollView.this.fQC);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bIt = AlaBannerAutoScrollView.this.fQz.bIt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bIt != 0) {
                    currentItem %= bIt;
                }
                alaBannerAutoScrollView.ti(currentItem);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQA = new g();
        this.fQB = -1;
        this.fQC = 2000L;
        this.fQD = false;
        this.fQE = false;
        this.fPd = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b n(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fPf;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void am(View view) {
                        this.fPf = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fPf != null && !StringUtils.isNull(bVar.pic)) {
                            this.fPf.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fQH = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fQE && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fQH, AlaBannerAutoScrollView.this.fQC);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bIt = AlaBannerAutoScrollView.this.fQz.bIt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bIt != 0) {
                    currentItem %= bIt;
                }
                alaBannerAutoScrollView.ti(currentItem);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQA = new g();
        this.fQB = -1;
        this.fQC = 2000L;
        this.fQD = false;
        this.fQE = false;
        this.fPd = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b n(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fPf;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void am(View view) {
                        this.fPf = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fPf != null && !StringUtils.isNull(bVar.pic)) {
                            this.fPf.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fQH = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fQE && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fQH, AlaBannerAutoScrollView.this.fQC);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bIt = AlaBannerAutoScrollView.this.fQz.bIt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bIt != 0) {
                    currentItem %= bIt;
                }
                alaBannerAutoScrollView.ti(currentItem);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.fQF != null) {
                    AlaBannerAutoScrollView.this.fQF.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fQx = (LinearLayout) findViewById(R.id.dotLayout);
        this.fQy = (RecyclerView) findViewById(R.id.list_view);
        this.fQy.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.fQy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bmJ();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bmI();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bmJ();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bmI();
                        return false;
                }
            }
        });
        this.fQz = new a(context, this.fPd, false);
        this.fQy.setAdapter(this.fQz);
        this.fQy.addOnScrollListener(this.mOnScrollListener);
        this.fQy.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.fQy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fQA.attachToRecyclerView(this.fQy);
    }

    public void setViewHolderAdapter(c cVar) {
        this.fQz.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fQC = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            bmJ();
            if (this.fQB != y.getCount(list)) {
                this.fQB = y.getCount(list);
                if (this.fQB == 1) {
                    this.fQE = false;
                } else {
                    this.fQE = true;
                }
                tj(this.fQB);
            }
            this.fQz.setData(list);
            this.fQz.notifyDataSetChanged();
            bmI();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.fQy != null) {
            if (z) {
                this.fQy.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.fQy != null) {
            ((LinearLayoutManager) this.fQy.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fQA.findSnapView(this.fQy.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.fQy.getLayoutManager().getPosition(findSnapView);
        int bIt = this.fQz.bIt();
        if (position < bIt) {
            int i = position + bIt;
            this.fQy.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bIt * 2) {
            int i2 = position - bIt;
            this.fQy.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmI() {
        postDelayed(this.fQH, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmJ() {
        removeCallbacks(this.fQH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i) {
        if (i >= this.fQx.getChildCount()) {
            tj(this.fQB);
            return;
        }
        for (int i2 = 0; i2 < this.fQx.getChildCount(); i2++) {
            View childAt = this.fQx.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void tj(int i) {
        if (this.fQx.getChildCount() != this.fQB) {
            this.fQx.removeAllViews();
            if (this.fQB == 1) {
                this.fQx.setVisibility(8);
            } else {
                this.fQx.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.fQB; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fQx.addView(view, layoutParams);
                }
            }
        }
        if (this.fQx != null && this.fQx.getChildAt(0) != null) {
            this.fQx.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.fQF = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fQG = dVar;
        if (this.fQz != null) {
            this.fQz.setOnBannerClickListener(this.fQG);
        }
    }

    public void onChangeSkinType(int i) {
        bmJ();
        ti(getCurrentItem());
        bmI();
    }
}
