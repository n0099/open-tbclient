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
/* loaded from: classes6.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private int gAA;
    private long gAB;
    private boolean gAC;
    private boolean gAD;
    private e gAE;
    private d gAF;
    private Runnable gAG;
    private LinearLayout gAw;
    private RecyclerView gAx;
    private a gAy;
    private g gAz;
    private c gzc;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gAz = new g();
        this.gAA = -1;
        this.gAB = 2000L;
        this.gAC = false;
        this.gAD = false;
        this.gzc = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gze;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gze = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gze != null && !StringUtils.isNull(bVar.pic)) {
                            this.gze.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gAG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAD && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAG, AlaBannerAutoScrollView.this.gAB);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTj = AlaBannerAutoScrollView.this.gAy.bTj();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTj != 0) {
                    currentItem %= bTj;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAz = new g();
        this.gAA = -1;
        this.gAB = 2000L;
        this.gAC = false;
        this.gAD = false;
        this.gzc = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gze;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gze = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gze != null && !StringUtils.isNull(bVar.pic)) {
                            this.gze.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gAG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAD && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAG, AlaBannerAutoScrollView.this.gAB);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTj = AlaBannerAutoScrollView.this.gAy.bTj();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTj != 0) {
                    currentItem %= bTj;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAz = new g();
        this.gAA = -1;
        this.gAB = 2000L;
        this.gAC = false;
        this.gAD = false;
        this.gzc = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gze;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gze = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gze != null && !StringUtils.isNull(bVar.pic)) {
                            this.gze.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gAG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAD && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAG, AlaBannerAutoScrollView.this.gAB);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTj = AlaBannerAutoScrollView.this.gAy.bTj();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTj != 0) {
                    currentItem %= bTj;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gAE != null) {
                    AlaBannerAutoScrollView.this.gAE.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gAw = (LinearLayout) findViewById(R.id.dotLayout);
        this.gAx = (RecyclerView) findViewById(R.id.list_view);
        this.gAx.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gAx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bwC();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bwB();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bwC();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bwB();
                        return false;
                }
            }
        });
        this.gAy = new a(context, this.gzc, false);
        this.gAx.setAdapter(this.gAy);
        this.gAx.addOnScrollListener(this.mOnScrollListener);
        this.gAx.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gAx.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gAz.attachToRecyclerView(this.gAx);
    }

    public void setViewHolderAdapter(c cVar) {
        this.gAy.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gAB = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            bwC();
            if (this.gAA != y.getCount(list)) {
                this.gAA = y.getCount(list);
                if (this.gAA == 1) {
                    this.gAD = false;
                } else {
                    this.gAD = true;
                }
                vm(this.gAA);
            }
            this.gAy.setData(list);
            this.gAy.notifyDataSetChanged();
            bwB();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gAx != null) {
            if (z) {
                this.gAx.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gAx != null) {
            ((LinearLayoutManager) this.gAx.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gAz.findSnapView(this.gAx.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gAx.getLayoutManager().getPosition(findSnapView);
        int bTj = this.gAy.bTj();
        if (position < bTj) {
            int i = position + bTj;
            this.gAx.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bTj * 2) {
            int i2 = position - bTj;
            this.gAx.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwB() {
        postDelayed(this.gAG, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        removeCallbacks(this.gAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(int i) {
        if (i >= this.gAw.getChildCount()) {
            vm(this.gAA);
            return;
        }
        for (int i2 = 0; i2 < this.gAw.getChildCount(); i2++) {
            View childAt = this.gAw.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void vm(int i) {
        if (this.gAw.getChildCount() != this.gAA) {
            this.gAw.removeAllViews();
            if (this.gAA == 1) {
                this.gAw.setVisibility(8);
            } else {
                this.gAw.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gAA; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gAw.addView(view, layoutParams);
                }
            }
        }
        if (this.gAw != null && this.gAw.getChildAt(0) != null) {
            this.gAw.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.gAE = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gAF = dVar;
        if (this.gAy != null) {
            this.gAy.setOnBannerClickListener(this.gAF);
        }
    }

    public void onChangeSkinType(int i) {
        bwC();
        vl(getCurrentItem());
        bwB();
    }
}
