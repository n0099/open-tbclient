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
    private c fLL;
    private LinearLayout fNf;
    private RecyclerView fNg;
    private a fNh;
    private g fNi;
    private int fNj;
    private long fNk;
    private boolean fNl;
    private boolean fNm;
    private e fNn;
    private d fNo;
    private Runnable fNp;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fNi = new g();
        this.fNj = -1;
        this.fNk = 2000L;
        this.fNl = false;
        this.fNm = false;
        this.fLL = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLN;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLN = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLN != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLN.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fNp = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNm && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNp, AlaBannerAutoScrollView.this.fNk);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHc = AlaBannerAutoScrollView.this.fNh.bHc();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHc != 0) {
                    currentItem %= bHc;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fNi = new g();
        this.fNj = -1;
        this.fNk = 2000L;
        this.fNl = false;
        this.fNm = false;
        this.fLL = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLN;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLN = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLN != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLN.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fNp = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNm && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNp, AlaBannerAutoScrollView.this.fNk);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHc = AlaBannerAutoScrollView.this.fNh.bHc();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHc != 0) {
                    currentItem %= bHc;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fNi = new g();
        this.fNj = -1;
        this.fNk = 2000L;
        this.fNl = false;
        this.fNm = false;
        this.fLL = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fLN;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fLN = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fLN != null && !StringUtils.isNull(bVar.pic)) {
                            this.fLN.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fNp = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fNm && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fNp, AlaBannerAutoScrollView.this.fNk);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bHc = AlaBannerAutoScrollView.this.fNh.bHc();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bHc != 0) {
                    currentItem %= bHc;
                }
                alaBannerAutoScrollView.sQ(currentItem);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.fNn != null) {
                    AlaBannerAutoScrollView.this.fNn.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fNf = (LinearLayout) findViewById(R.id.dotLayout);
        this.fNg = (RecyclerView) findViewById(R.id.list_view);
        this.fNg.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.fNg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
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
        this.fNh = new a(context, this.fLL, false);
        this.fNg.setAdapter(this.fNh);
        this.fNg.addOnScrollListener(this.mOnScrollListener);
        this.fNg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.fNg.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fNi.attachToRecyclerView(this.fNg);
    }

    public void setViewHolderAdapter(c cVar) {
        this.fNh.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fNk = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            blP();
            if (this.fNj != y.getCount(list)) {
                this.fNj = y.getCount(list);
                if (this.fNj == 1) {
                    this.fNm = false;
                } else {
                    this.fNm = true;
                }
                sR(this.fNj);
            }
            this.fNh.setData(list);
            this.fNh.notifyDataSetChanged();
            blO();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.fNg != null) {
            if (z) {
                this.fNg.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.fNg != null) {
            ((LinearLayoutManager) this.fNg.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fNi.findSnapView(this.fNg.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.fNg.getLayoutManager().getPosition(findSnapView);
        int bHc = this.fNh.bHc();
        if (position < bHc) {
            int i = position + bHc;
            this.fNg.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bHc * 2) {
            int i2 = position - bHc;
            this.fNg.getLayoutManager().scrollToPosition(i2);
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
        postDelayed(this.fNp, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blP() {
        removeCallbacks(this.fNp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(int i) {
        if (i >= this.fNf.getChildCount()) {
            sR(this.fNj);
            return;
        }
        for (int i2 = 0; i2 < this.fNf.getChildCount(); i2++) {
            View childAt = this.fNf.getChildAt(i2);
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
        if (this.fNf.getChildCount() != this.fNj) {
            this.fNf.removeAllViews();
            if (this.fNj == 1) {
                this.fNf.setVisibility(8);
            } else {
                this.fNf.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.fNj; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fNf.addView(view, layoutParams);
                }
            }
        }
        if (this.fNf != null && this.fNf.getChildAt(0) != null) {
            this.fNf.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.fNn = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fNo = dVar;
        if (this.fNh != null) {
            this.fNh.setOnBannerClickListener(this.fNo);
        }
    }

    public void onChangeSkinType(int i) {
        blP();
        sQ(getCurrentItem());
        blO();
    }
}
