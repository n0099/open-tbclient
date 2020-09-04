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
    private c fLP;
    private LinearLayout fNj;
    private RecyclerView fNk;
    private a fNl;
    private g fNm;
    private int fNn;
    private long fNo;
    private boolean fNp;
    private boolean fNq;
    private e fNr;
    private d fNs;
    private Runnable fNt;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fNm = new g();
        this.fNn = -1;
        this.fNo = 2000L;
        this.fNp = false;
        this.fNq = false;
        this.fLP = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLR;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLR = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLR != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLR.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fNt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNt, AlaBannerAutoScrollView.this.fNo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHd = AlaBannerAutoScrollView.this.fNl.bHd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHd != 0) {
                    currentItem %= bHd;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fNm = new g();
        this.fNn = -1;
        this.fNo = 2000L;
        this.fNp = false;
        this.fNq = false;
        this.fLP = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLR;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLR = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLR != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLR.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fNt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNt, AlaBannerAutoScrollView.this.fNo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHd = AlaBannerAutoScrollView.this.fNl.bHd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHd != 0) {
                    currentItem %= bHd;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fNm = new g();
        this.fNn = -1;
        this.fNo = 2000L;
        this.fNp = false;
        this.fNq = false;
        this.fLP = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLR;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLR = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLR != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLR.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fNt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNq && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNt, AlaBannerAutoScrollView.this.fNo);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHd = AlaBannerAutoScrollView.this.fNl.bHd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHd != 0) {
                    currentItem %= bHd;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.fNr != null) {
                    AlaBannerAutoScrollView.this.fNr.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fNj = (LinearLayout) findViewById(R.id.dotLayout);
        this.fNk = (RecyclerView) findViewById(R.id.list_view);
        this.fNk.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.fNk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.blP();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.blO();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.blP();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.blO();
                        return false;
                }
            }
        });
        this.fNl = new a(context, this.fLP, false);
        this.fNk.setAdapter(this.fNl);
        this.fNk.addOnScrollListener(this.mOnScrollListener);
        this.fNk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.fNk.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fNm.attachToRecyclerView(this.fNk);
    }

    public void setViewHolderAdapter(c cVar) {
        this.fNl.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fNo = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            blP();
            if (this.fNn != y.getCount(list)) {
                this.fNn = y.getCount(list);
                if (this.fNn == 1) {
                    this.fNq = false;
                } else {
                    this.fNq = true;
                }
                sR(this.fNn);
            }
            this.fNl.setData(list);
            this.fNl.notifyDataSetChanged();
            blO();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.fNk != null) {
            if (z) {
                this.fNk.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.fNk != null) {
            ((LinearLayoutManager) this.fNk.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fNm.findSnapView(this.fNk.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.fNk.getLayoutManager().getPosition(findSnapView);
        int bHd = this.fNl.bHd();
        if (position < bHd) {
            int i = position + bHd;
            this.fNk.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bHd * 2) {
            int i2 = position - bHd;
            this.fNk.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        blP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blO() {
        postDelayed(this.fNt, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blP() {
        removeCallbacks(this.fNt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(int i) {
        if (i >= this.fNj.getChildCount()) {
            sR(this.fNn);
            return;
        }
        for (int i2 = 0; i2 < this.fNj.getChildCount(); i2++) {
            View childAt = this.fNj.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void sR(int i) {
        if (this.fNj.getChildCount() != this.fNn) {
            this.fNj.removeAllViews();
            if (this.fNn == 1) {
                this.fNj.setVisibility(8);
            } else {
                this.fNj.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.fNn; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fNj.addView(view, layoutParams);
                }
            }
        }
        if (this.fNj != null && this.fNj.getChildAt(0) != null) {
            this.fNj.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.fNr = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fNs = dVar;
        if (this.fNl != null) {
            this.fNl.setOnBannerClickListener(this.fNs);
        }
    }

    public void onChangeSkinType(int i) {
        blP();
        sQ(getCurrentItem());
        blO();
    }
}
