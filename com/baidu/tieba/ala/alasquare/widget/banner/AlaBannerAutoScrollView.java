package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private a gIz;
    private LinearLayout gKA;
    private RecyclerView gKB;
    private AlaBannerRecyclerAdapter gKC;
    private PagerSnapHelper gKD;
    private int gKE;
    private long gKF;
    private boolean gKG;
    private boolean gKH;
    private c gKI;
    private b gKJ;
    private Runnable gKK;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gKD = new PagerSnapHelper();
        this.gKE = -1;
        this.gKF = 2000L;
        this.gKG = false;
        this.gKH = false;
        this.gIz = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gIB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gIB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gIB != null && !StringUtils.isNull(bVar.pic)) {
                            this.gIB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gKK = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gKH && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gKK, AlaBannerAutoScrollView.this.gKF);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSI = AlaBannerAutoScrollView.this.gKC.bSI();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSI != 0) {
                    currentItem %= bSI;
                }
                alaBannerAutoScrollView.tW(currentItem);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKD = new PagerSnapHelper();
        this.gKE = -1;
        this.gKF = 2000L;
        this.gKG = false;
        this.gKH = false;
        this.gIz = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gIB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gIB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gIB != null && !StringUtils.isNull(bVar.pic)) {
                            this.gIB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gKK = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gKH && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gKK, AlaBannerAutoScrollView.this.gKF);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSI = AlaBannerAutoScrollView.this.gKC.bSI();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSI != 0) {
                    currentItem %= bSI;
                }
                alaBannerAutoScrollView.tW(currentItem);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKD = new PagerSnapHelper();
        this.gKE = -1;
        this.gKF = 2000L;
        this.gKG = false;
        this.gKH = false;
        this.gIz = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i2) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gIB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gIB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gIB != null && !StringUtils.isNull(bVar.pic)) {
                            this.gIB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gKK = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gKH && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gKK, AlaBannerAutoScrollView.this.gKF);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSI = AlaBannerAutoScrollView.this.gKC.bSI();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSI != 0) {
                    currentItem %= bSI;
                }
                alaBannerAutoScrollView.tW(currentItem);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gKI != null) {
                    AlaBannerAutoScrollView.this.gKI.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gKA = (LinearLayout) findViewById(R.id.dotLayout);
        this.gKB = (RecyclerView) findViewById(R.id.list_view);
        this.gKB.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gKB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bvw();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bvv();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bvw();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bvv();
                        return false;
                }
            }
        });
        this.gKC = new AlaBannerRecyclerAdapter(context, this.gIz, false);
        this.gKB.setAdapter(this.gKC);
        this.gKB.addOnScrollListener(this.mOnScrollListener);
        this.gKB.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gKB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gKD.attachToRecyclerView(this.gKB);
    }

    public void setViewHolderAdapter(a aVar) {
        this.gKC.setViewHolderAdapter(aVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gKF = j;
    }

    public void a(List<T> list, a aVar) {
        if (!y.isEmpty(list)) {
            bvw();
            if (this.gKE != y.getCount(list)) {
                this.gKE = y.getCount(list);
                if (this.gKE == 1) {
                    this.gKH = false;
                } else {
                    this.gKH = true;
                }
                tX(this.gKE);
            }
            this.gKC.setData(list);
            this.gKC.notifyDataSetChanged();
            bvv();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gKB != null) {
            if (z) {
                this.gKB.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gKB != null) {
            ((LinearLayoutManager) this.gKB.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gKD.findSnapView(this.gKB.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gKB.getLayoutManager().getPosition(findSnapView);
        int bSI = this.gKC.bSI();
        if (position < bSI) {
            int i = position + bSI;
            this.gKB.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bSI * 2) {
            int i2 = position - bSI;
            this.gKB.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvv() {
        postDelayed(this.gKK, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvw() {
        removeCallbacks(this.gKK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW(int i) {
        if (i >= this.gKA.getChildCount()) {
            tX(this.gKE);
            return;
        }
        for (int i2 = 0; i2 < this.gKA.getChildCount(); i2++) {
            View childAt = this.gKA.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void tX(int i) {
        if (this.gKA.getChildCount() != this.gKE) {
            this.gKA.removeAllViews();
            if (this.gKE == 1) {
                this.gKA.setVisibility(8);
            } else {
                this.gKA.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gKE; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gKA.addView(view, layoutParams);
                }
            }
        }
        if (this.gKA != null && this.gKA.getChildAt(0) != null) {
            this.gKA.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(c cVar) {
        this.gKI = cVar;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gKJ = bVar;
        if (this.gKC != null) {
            this.gKC.setOnBannerClickListener(this.gKJ);
        }
    }

    public void onChangeSkinType(int i) {
        bvw();
        tW(getCurrentItem());
        bvv();
    }
}
