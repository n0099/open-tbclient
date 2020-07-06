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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c fvm;
    private LinearLayout fwG;
    private RecyclerView fwH;
    private a fwI;
    private g fwJ;
    private int fwK;
    private long fwL;
    private boolean fwM;
    private boolean fwN;
    private e fwO;
    private d fwP;
    private Runnable fwQ;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fwJ = new g();
        this.fwK = -1;
        this.fwL = 2000L;
        this.fwM = false;
        this.fwN = false;
        this.fvm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fvo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fvo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fvo != null && !StringUtils.isNull(bVar.pic)) {
                            this.fvo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fwQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fwN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fwQ, AlaBannerAutoScrollView.this.fwL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int buU = AlaBannerAutoScrollView.this.fwI.buU();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (buU != 0) {
                    currentItem %= buU;
                }
                alaBannerAutoScrollView.qp(currentItem);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fwJ = new g();
        this.fwK = -1;
        this.fwL = 2000L;
        this.fwM = false;
        this.fwN = false;
        this.fvm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fvo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fvo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fvo != null && !StringUtils.isNull(bVar.pic)) {
                            this.fvo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fwQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fwN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fwQ, AlaBannerAutoScrollView.this.fwL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int buU = AlaBannerAutoScrollView.this.fwI.buU();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (buU != 0) {
                    currentItem %= buU;
                }
                alaBannerAutoScrollView.qp(currentItem);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fwJ = new g();
        this.fwK = -1;
        this.fwL = 2000L;
        this.fwM = false;
        this.fwN = false;
        this.fvm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fvo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fvo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fvo != null && !StringUtils.isNull(bVar.pic)) {
                            this.fvo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fwQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fwN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fwQ, AlaBannerAutoScrollView.this.fwL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int buU = AlaBannerAutoScrollView.this.fwI.buU();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (buU != 0) {
                    currentItem %= buU;
                }
                alaBannerAutoScrollView.qp(currentItem);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.fwO != null) {
                    AlaBannerAutoScrollView.this.fwO.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fwG = (LinearLayout) findViewById(R.id.dotLayout);
        this.fwH = (RecyclerView) findViewById(R.id.list_view);
        this.fwH.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.fwH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aZm();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aZl();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aZm();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aZl();
                        return false;
                }
            }
        });
        this.fwI = new a(context, this.fvm, false);
        this.fwH.setAdapter(this.fwI);
        this.fwH.addOnScrollListener(this.mOnScrollListener);
        this.fwH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.fwH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fwJ.attachToRecyclerView(this.fwH);
    }

    public void setViewHolderAdapter(c cVar) {
        this.fwI.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fwL = j;
    }

    public void a(List<T> list, c cVar) {
        if (!w.isEmpty(list)) {
            aZm();
            if (this.fwK != w.getCount(list)) {
                this.fwK = w.getCount(list);
                if (this.fwK == 1) {
                    this.fwN = false;
                } else {
                    this.fwN = true;
                }
                qq(this.fwK);
            }
            this.fwI.setData(list);
            this.fwI.notifyDataSetChanged();
            aZl();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.fwH != null) {
            if (z) {
                this.fwH.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.fwH != null) {
            ((LinearLayoutManager) this.fwH.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fwJ.findSnapView(this.fwH.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.fwH.getLayoutManager().getPosition(findSnapView);
        int buU = this.fwI.buU();
        if (position < buU) {
            int i = position + buU;
            this.fwH.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= buU * 2) {
            int i2 = position - buU;
            this.fwH.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZl() {
        postDelayed(this.fwQ, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZm() {
        removeCallbacks(this.fwQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        if (i >= this.fwG.getChildCount()) {
            qq(this.fwK);
            return;
        }
        for (int i2 = 0; i2 < this.fwG.getChildCount(); i2++) {
            View childAt = this.fwG.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    an.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    an.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void qq(int i) {
        if (this.fwG.getChildCount() != this.fwK) {
            this.fwG.removeAllViews();
            if (this.fwK == 1) {
                this.fwG.setVisibility(8);
            } else {
                this.fwG.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.fwK; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fwG.addView(view, layoutParams);
                }
            }
        }
        if (this.fwG != null && this.fwG.getChildAt(0) != null) {
            this.fwG.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.fwO = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fwP = dVar;
        if (this.fwI != null) {
            this.fwI.setOnBannerClickListener(this.fwP);
        }
    }

    public void onChangeSkinType(int i) {
        aZm();
        qp(getCurrentItem());
        aZl();
    }
}
