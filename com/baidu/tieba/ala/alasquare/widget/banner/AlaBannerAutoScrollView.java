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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private a gKh;
    private LinearLayout gMi;
    private RecyclerView gMj;
    private AlaBannerRecyclerAdapter gMk;
    private PagerSnapHelper gMl;
    private int gMm;
    private long gMn;
    private boolean gMo;
    private boolean gMp;
    private c gMq;
    private b gMr;
    private Runnable gMs;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gMl = new PagerSnapHelper();
        this.gMm = -1;
        this.gMn = 2000L;
        this.gMo = false;
        this.gMp = false;
        this.gKh = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKj;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gKj = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKj != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKj.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gMs = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMs, AlaBannerAutoScrollView.this.gMn);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bVP = AlaBannerAutoScrollView.this.gMk.bVP();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bVP != 0) {
                    currentItem %= bVP;
                }
                alaBannerAutoScrollView.vw(currentItem);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gMl = new PagerSnapHelper();
        this.gMm = -1;
        this.gMn = 2000L;
        this.gMo = false;
        this.gMp = false;
        this.gKh = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKj;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gKj = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKj != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKj.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gMs = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMs, AlaBannerAutoScrollView.this.gMn);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bVP = AlaBannerAutoScrollView.this.gMk.bVP();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bVP != 0) {
                    currentItem %= bVP;
                }
                alaBannerAutoScrollView.vw(currentItem);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMl = new PagerSnapHelper();
        this.gMm = -1;
        this.gMn = 2000L;
        this.gMo = false;
        this.gMp = false;
        this.gKh = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i2) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKj;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gKj = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKj != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKj.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gMs = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMs, AlaBannerAutoScrollView.this.gMn);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bVP = AlaBannerAutoScrollView.this.gMk.bVP();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bVP != 0) {
                    currentItem %= bVP;
                }
                alaBannerAutoScrollView.vw(currentItem);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gMq != null) {
                    AlaBannerAutoScrollView.this.gMq.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gMi = (LinearLayout) findViewById(R.id.dotLayout);
        this.gMj = (RecyclerView) findViewById(R.id.list_view);
        this.gMj.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gMj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.byV();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.byU();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.byV();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.byU();
                        return false;
                }
            }
        });
        this.gMk = new AlaBannerRecyclerAdapter(context, this.gKh, false);
        this.gMj.setAdapter(this.gMk);
        this.gMj.addOnScrollListener(this.mOnScrollListener);
        this.gMj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gMj.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gMl.attachToRecyclerView(this.gMj);
    }

    public void setViewHolderAdapter(a aVar) {
        this.gMk.setViewHolderAdapter(aVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gMn = j;
    }

    public void a(List<T> list, a aVar) {
        if (!x.isEmpty(list)) {
            byV();
            if (this.gMm != x.getCount(list)) {
                this.gMm = x.getCount(list);
                if (this.gMm == 1) {
                    this.gMp = false;
                } else {
                    this.gMp = true;
                }
                vx(this.gMm);
            }
            this.gMk.setData(list);
            this.gMk.notifyDataSetChanged();
            byU();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gMj != null) {
            if (z) {
                this.gMj.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gMj != null) {
            ((LinearLayoutManager) this.gMj.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gMl.findSnapView(this.gMj.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gMj.getLayoutManager().getPosition(findSnapView);
        int bVP = this.gMk.bVP();
        if (position < bVP) {
            int i = position + bVP;
            this.gMj.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bVP * 2) {
            int i2 = position - bVP;
            this.gMj.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        byV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byU() {
        postDelayed(this.gMs, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byV() {
        removeCallbacks(this.gMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i) {
        if (i >= this.gMi.getChildCount()) {
            vx(this.gMm);
            return;
        }
        for (int i2 = 0; i2 < this.gMi.getChildCount(); i2++) {
            View childAt = this.gMi.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void vx(int i) {
        if (this.gMi.getChildCount() != this.gMm) {
            this.gMi.removeAllViews();
            if (this.gMm == 1) {
                this.gMi.setVisibility(8);
            } else {
                this.gMi.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gMm; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gMi.addView(view, layoutParams);
                }
            }
        }
        if (this.gMi != null && this.gMi.getChildAt(0) != null) {
            this.gMi.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(c cVar) {
        this.gMq = cVar;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gMr = bVar;
        if (this.gMk != null) {
            this.gMk.setOnBannerClickListener(this.gMr);
        }
    }

    public void onChangeSkinType(int i) {
        byV();
        vw(getCurrentItem());
        byU();
    }
}
