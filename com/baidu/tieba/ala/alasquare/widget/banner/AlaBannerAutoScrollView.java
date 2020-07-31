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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c fAt;
    private LinearLayout fBN;
    private RecyclerView fBO;
    private a fBP;
    private g fBQ;
    private int fBR;
    private long fBS;
    private boolean fBT;
    private boolean fBU;
    private e fBV;
    private d fBW;
    private Runnable fBX;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fBQ = new g();
        this.fBR = -1;
        this.fBS = 2000L;
        this.fBT = false;
        this.fBU = false;
        this.fAt = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fAv;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void aj(View view) {
                        this.fAv = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fAv != null && !StringUtils.isNull(bVar.pic)) {
                            this.fAv.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fBX = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fBU && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fBX, AlaBannerAutoScrollView.this.fBS);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int byd = AlaBannerAutoScrollView.this.fBP.byd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (byd != 0) {
                    currentItem %= byd;
                }
                alaBannerAutoScrollView.qE(currentItem);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBQ = new g();
        this.fBR = -1;
        this.fBS = 2000L;
        this.fBT = false;
        this.fBU = false;
        this.fAt = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fAv;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void aj(View view) {
                        this.fAv = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fAv != null && !StringUtils.isNull(bVar.pic)) {
                            this.fAv.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fBX = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fBU && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fBX, AlaBannerAutoScrollView.this.fBS);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int byd = AlaBannerAutoScrollView.this.fBP.byd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (byd != 0) {
                    currentItem %= byd;
                }
                alaBannerAutoScrollView.qE(currentItem);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBQ = new g();
        this.fBR = -1;
        this.fBS = 2000L;
        this.fBT = false;
        this.fBU = false;
        this.fAt = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b l(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fAv;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void aj(View view) {
                        this.fAv = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fAv != null && !StringUtils.isNull(bVar.pic)) {
                            this.fAv.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fBX = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.fBU && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fBX, AlaBannerAutoScrollView.this.fBS);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int byd = AlaBannerAutoScrollView.this.fBP.byd();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (byd != 0) {
                    currentItem %= byd;
                }
                alaBannerAutoScrollView.qE(currentItem);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.fBV != null) {
                    AlaBannerAutoScrollView.this.fBV.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fBN = (LinearLayout) findViewById(R.id.dotLayout);
        this.fBO = (RecyclerView) findViewById(R.id.list_view);
        this.fBO.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.fBO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bdj();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bdi();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bdj();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bdi();
                        return false;
                }
            }
        });
        this.fBP = new a(context, this.fAt, false);
        this.fBO.setAdapter(this.fBP);
        this.fBO.addOnScrollListener(this.mOnScrollListener);
        this.fBO.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.fBO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fBQ.attachToRecyclerView(this.fBO);
    }

    public void setViewHolderAdapter(c cVar) {
        this.fBP.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fBS = j;
    }

    public void a(List<T> list, c cVar) {
        if (!x.isEmpty(list)) {
            bdj();
            if (this.fBR != x.getCount(list)) {
                this.fBR = x.getCount(list);
                if (this.fBR == 1) {
                    this.fBU = false;
                } else {
                    this.fBU = true;
                }
                qF(this.fBR);
            }
            this.fBP.setData(list);
            this.fBP.notifyDataSetChanged();
            bdi();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.fBO != null) {
            if (z) {
                this.fBO.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.fBO != null) {
            ((LinearLayoutManager) this.fBO.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fBQ.findSnapView(this.fBO.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.fBO.getLayoutManager().getPosition(findSnapView);
        int byd = this.fBP.byd();
        if (position < byd) {
            int i = position + byd;
            this.fBO.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= byd * 2) {
            int i2 = position - byd;
            this.fBO.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bdj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdi() {
        postDelayed(this.fBX, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdj() {
        removeCallbacks(this.fBX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qE(int i) {
        if (i >= this.fBN.getChildCount()) {
            qF(this.fBR);
            return;
        }
        for (int i2 = 0; i2 < this.fBN.getChildCount(); i2++) {
            View childAt = this.fBN.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void qF(int i) {
        if (this.fBN.getChildCount() != this.fBR) {
            this.fBN.removeAllViews();
            if (this.fBR == 1) {
                this.fBN.setVisibility(8);
            } else {
                this.fBN.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.fBR; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fBN.addView(view, layoutParams);
                }
            }
        }
        if (this.fBN != null && this.fBN.getChildAt(0) != null) {
            this.fBN.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.fBV = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fBW = dVar;
        if (this.fBP != null) {
            this.fBP.setOnBannerClickListener(this.fBW);
        }
    }

    public void onChangeSkinType(int i) {
        bdj();
        qE(getCurrentItem());
        bdi();
    }
}
