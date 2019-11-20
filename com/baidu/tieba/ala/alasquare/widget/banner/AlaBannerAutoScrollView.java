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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c dCv;
    private LinearLayout dDR;
    private RecyclerView dDS;
    private a dDT;
    private g dDU;
    private int dDV;
    private long dDW;
    private boolean dDX;
    private boolean dDY;
    private e dDZ;
    private d dEa;
    private Runnable dEb;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.dDU = new g();
        this.dDV = -1;
        this.dDW = 2000L;
        this.dDX = false;
        this.dDY = false;
        this.dCv = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dCx;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dCx = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dCx != null && !StringUtils.isNull(bVar.pic)) {
                            this.dCx.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.dEb = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dDY && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dEb, AlaBannerAutoScrollView.this.dDW);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKr = AlaBannerAutoScrollView.this.dDT.aKr();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKr != 0) {
                    currentItem %= aKr;
                }
                alaBannerAutoScrollView.mr(currentItem);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDU = new g();
        this.dDV = -1;
        this.dDW = 2000L;
        this.dDX = false;
        this.dDY = false;
        this.dCv = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dCx;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dCx = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dCx != null && !StringUtils.isNull(bVar.pic)) {
                            this.dCx.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.dEb = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dDY && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dEb, AlaBannerAutoScrollView.this.dDW);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKr = AlaBannerAutoScrollView.this.dDT.aKr();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKr != 0) {
                    currentItem %= aKr;
                }
                alaBannerAutoScrollView.mr(currentItem);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDU = new g();
        this.dDV = -1;
        this.dDW = 2000L;
        this.dDX = false;
        this.dDY = false;
        this.dCv = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dCx;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dCx = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dCx != null && !StringUtils.isNull(bVar.pic)) {
                            this.dCx.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.dEb = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dDY && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dEb, AlaBannerAutoScrollView.this.dDW);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKr = AlaBannerAutoScrollView.this.dDT.aKr();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKr != 0) {
                    currentItem %= aKr;
                }
                alaBannerAutoScrollView.mr(currentItem);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.dDZ != null) {
                    AlaBannerAutoScrollView.this.dDZ.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.dDR = (LinearLayout) findViewById(R.id.dotLayout);
        this.dDS = (RecyclerView) findViewById(R.id.list_view);
        this.dDS.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.dDS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aon();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aom();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aon();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aom();
                        return false;
                }
            }
        });
        this.dDT = new a(context, this.dCv, false);
        this.dDS.setAdapter(this.dDT);
        this.dDS.addOnScrollListener(this.mOnScrollListener);
        this.dDS.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.dDS.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.dDU.attachToRecyclerView(this.dDS);
    }

    public void setViewHolderAdapter(c cVar) {
        this.dDT.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.dDW = j;
    }

    public void a(List<T> list, c cVar) {
        if (!v.isEmpty(list)) {
            aon();
            if (this.dDV != v.getCount(list)) {
                this.dDV = v.getCount(list);
                if (this.dDV == 1) {
                    this.dDY = false;
                } else {
                    this.dDY = true;
                }
                ms(this.dDV);
            }
            this.dDT.setData(list);
            this.dDT.notifyDataSetChanged();
            aom();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.dDS != null) {
            if (z) {
                this.dDS.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.dDS != null) {
            ((LinearLayoutManager) this.dDS.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.dDU.findSnapView(this.dDS.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.dDS.getLayoutManager().getPosition(findSnapView);
        int aKr = this.dDT.aKr();
        if (position < aKr) {
            int i = position + aKr;
            this.dDS.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= aKr * 2) {
            int i2 = position - aKr;
            this.dDS.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aom() {
        postDelayed(this.dEb, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aon() {
        removeCallbacks(this.dEb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(int i) {
        if (i >= this.dDR.getChildCount()) {
            ms(this.dDV);
            return;
        }
        for (int i2 = 0; i2 < this.dDR.getChildCount(); i2++) {
            View childAt = this.dDR.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void ms(int i) {
        if (this.dDR.getChildCount() != this.dDV) {
            this.dDR.removeAllViews();
            if (this.dDV == 1) {
                this.dDR.setVisibility(8);
            } else {
                this.dDR.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.dDV; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.dDR.addView(view, layoutParams);
                }
            }
        }
        if (this.dDR != null && this.dDR.getChildAt(0) != null) {
            this.dDR.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.dDZ = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.dEa = dVar;
        if (this.dDT != null) {
            this.dDT.setOnBannerClickListener(this.dEa);
        }
    }

    public void onChangeSkinType(int i) {
        aon();
        mr(getCurrentItem());
        aom();
    }
}
