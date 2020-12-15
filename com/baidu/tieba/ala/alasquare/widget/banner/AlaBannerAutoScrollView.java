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
    private a gAA;
    private g gAB;
    private int gAC;
    private long gAD;
    private boolean gAE;
    private boolean gAF;
    private e gAG;
    private d gAH;
    private Runnable gAI;
    private LinearLayout gAy;
    private RecyclerView gAz;
    private c gze;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gAB = new g();
        this.gAC = -1;
        this.gAD = 2000L;
        this.gAE = false;
        this.gAF = false;
        this.gze = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gzg;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gzg = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gzg != null && !StringUtils.isNull(bVar.pic)) {
                            this.gzg.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gAI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAF && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAI, AlaBannerAutoScrollView.this.gAD);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTk = AlaBannerAutoScrollView.this.gAA.bTk();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTk != 0) {
                    currentItem %= bTk;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAB = new g();
        this.gAC = -1;
        this.gAD = 2000L;
        this.gAE = false;
        this.gAF = false;
        this.gze = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gzg;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gzg = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gzg != null && !StringUtils.isNull(bVar.pic)) {
                            this.gzg.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gAI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAF && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAI, AlaBannerAutoScrollView.this.gAD);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTk = AlaBannerAutoScrollView.this.gAA.bTk();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTk != 0) {
                    currentItem %= bTk;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAB = new g();
        this.gAC = -1;
        this.gAD = 2000L;
        this.gAE = false;
        this.gAF = false;
        this.gze = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gzg;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gzg = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gzg != null && !StringUtils.isNull(bVar.pic)) {
                            this.gzg.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gAI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gAF && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gAI, AlaBannerAutoScrollView.this.gAD);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bTk = AlaBannerAutoScrollView.this.gAA.bTk();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bTk != 0) {
                    currentItem %= bTk;
                }
                alaBannerAutoScrollView.vl(currentItem);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gAG != null) {
                    AlaBannerAutoScrollView.this.gAG.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gAy = (LinearLayout) findViewById(R.id.dotLayout);
        this.gAz = (RecyclerView) findViewById(R.id.list_view);
        this.gAz.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gAz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
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
        this.gAA = new a(context, this.gze, false);
        this.gAz.setAdapter(this.gAA);
        this.gAz.addOnScrollListener(this.mOnScrollListener);
        this.gAz.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gAz.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gAB.attachToRecyclerView(this.gAz);
    }

    public void setViewHolderAdapter(c cVar) {
        this.gAA.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gAD = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            bwC();
            if (this.gAC != y.getCount(list)) {
                this.gAC = y.getCount(list);
                if (this.gAC == 1) {
                    this.gAF = false;
                } else {
                    this.gAF = true;
                }
                vm(this.gAC);
            }
            this.gAA.setData(list);
            this.gAA.notifyDataSetChanged();
            bwB();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gAz != null) {
            if (z) {
                this.gAz.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gAz != null) {
            ((LinearLayoutManager) this.gAz.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gAB.findSnapView(this.gAz.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gAz.getLayoutManager().getPosition(findSnapView);
        int bTk = this.gAA.bTk();
        if (position < bTk) {
            int i = position + bTk;
            this.gAz.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bTk * 2) {
            int i2 = position - bTk;
            this.gAz.getLayoutManager().scrollToPosition(i2);
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
        postDelayed(this.gAI, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        removeCallbacks(this.gAI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(int i) {
        if (i >= this.gAy.getChildCount()) {
            vm(this.gAC);
            return;
        }
        for (int i2 = 0; i2 < this.gAy.getChildCount(); i2++) {
            View childAt = this.gAy.getChildAt(i2);
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
        if (this.gAy.getChildCount() != this.gAC) {
            this.gAy.removeAllViews();
            if (this.gAC == 1) {
                this.gAy.setVisibility(8);
            } else {
                this.gAy.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gAC; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gAy.addView(view, layoutParams);
                }
            }
        }
        if (this.gAy != null && this.gAy.getChildAt(0) != null) {
            this.gAy.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.gAG = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gAH = dVar;
        if (this.gAA != null) {
            this.gAA.setOnBannerClickListener(this.gAH);
        }
    }

    public void onChangeSkinType(int i) {
        bwC();
        vl(getCurrentItem());
        bwB();
    }
}
