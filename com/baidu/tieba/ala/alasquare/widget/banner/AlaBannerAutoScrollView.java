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
/* loaded from: classes9.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private a gKi;
    private LinearLayout gMj;
    private RecyclerView gMk;
    private AlaBannerRecyclerAdapter gMl;
    private PagerSnapHelper gMm;
    private int gMn;
    private long gMo;
    private boolean gMp;
    private boolean gMq;
    private c gMr;
    private b gMs;
    private Runnable gMt;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gMm = new PagerSnapHelper();
        this.gMn = -1;
        this.gMo = 2000L;
        this.gMp = false;
        this.gMq = false;
        this.gKi = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKk;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gKk = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKk != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKk.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gMt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMt, AlaBannerAutoScrollView.this.gMo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSO = AlaBannerAutoScrollView.this.gMl.bSO();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSO != 0) {
                    currentItem %= bSO;
                }
                alaBannerAutoScrollView.tY(currentItem);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gMm = new PagerSnapHelper();
        this.gMn = -1;
        this.gMo = 2000L;
        this.gMp = false;
        this.gMq = false;
        this.gKi = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKk;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gKk = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKk != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKk.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gMt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMt, AlaBannerAutoScrollView.this.gMo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSO = AlaBannerAutoScrollView.this.gMl.bSO();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSO != 0) {
                    currentItem %= bSO;
                }
                alaBannerAutoScrollView.tY(currentItem);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMm = new PagerSnapHelper();
        this.gMn = -1;
        this.gMo = 2000L;
        this.gMp = false;
        this.gMq = false;
        this.gKi = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i2) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gKk;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gKk = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gKk != null && !StringUtils.isNull(bVar.pic)) {
                            this.gKk.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gMt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gMq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gMt, AlaBannerAutoScrollView.this.gMo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bSO = AlaBannerAutoScrollView.this.gMl.bSO();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bSO != 0) {
                    currentItem %= bSO;
                }
                alaBannerAutoScrollView.tY(currentItem);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gMr != null) {
                    AlaBannerAutoScrollView.this.gMr.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gMj = (LinearLayout) findViewById(R.id.dotLayout);
        this.gMk = (RecyclerView) findViewById(R.id.list_view);
        this.gMk.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gMk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bvz();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bvy();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bvz();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bvy();
                        return false;
                }
            }
        });
        this.gMl = new AlaBannerRecyclerAdapter(context, this.gKi, false);
        this.gMk.setAdapter(this.gMl);
        this.gMk.addOnScrollListener(this.mOnScrollListener);
        this.gMk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gMk.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gMm.attachToRecyclerView(this.gMk);
    }

    public void setViewHolderAdapter(a aVar) {
        this.gMl.setViewHolderAdapter(aVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gMo = j;
    }

    public void a(List<T> list, a aVar) {
        if (!y.isEmpty(list)) {
            bvz();
            if (this.gMn != y.getCount(list)) {
                this.gMn = y.getCount(list);
                if (this.gMn == 1) {
                    this.gMq = false;
                } else {
                    this.gMq = true;
                }
                tZ(this.gMn);
            }
            this.gMl.setData(list);
            this.gMl.notifyDataSetChanged();
            bvy();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gMk != null) {
            if (z) {
                this.gMk.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gMk != null) {
            ((LinearLayoutManager) this.gMk.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gMm.findSnapView(this.gMk.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gMk.getLayoutManager().getPosition(findSnapView);
        int bSO = this.gMl.bSO();
        if (position < bSO) {
            int i = position + bSO;
            this.gMk.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bSO * 2) {
            int i2 = position - bSO;
            this.gMk.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvy() {
        postDelayed(this.gMt, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvz() {
        removeCallbacks(this.gMt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY(int i) {
        if (i >= this.gMj.getChildCount()) {
            tZ(this.gMn);
            return;
        }
        for (int i2 = 0; i2 < this.gMj.getChildCount(); i2++) {
            View childAt = this.gMj.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void tZ(int i) {
        if (this.gMj.getChildCount() != this.gMn) {
            this.gMj.removeAllViews();
            if (this.gMn == 1) {
                this.gMj.setVisibility(8);
            } else {
                this.gMj.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gMn; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gMj.addView(view, layoutParams);
                }
            }
        }
        if (this.gMj != null && this.gMj.getChildAt(0) != null) {
            this.gMj.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(c cVar) {
        this.gMr = cVar;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gMs = bVar;
        if (this.gMl != null) {
            this.gMl.setOnBannerClickListener(this.gMs);
        }
    }

    public void onChangeSkinType(int i) {
        bvz();
        tY(getCurrentItem());
        bvy();
    }
}
