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
    private c glz;
    private LinearLayout gmT;
    private RecyclerView gmU;
    private a gmV;
    private g gmW;
    private int gmX;
    private long gmY;
    private boolean gmZ;
    private boolean gna;
    private e gnb;
    private d gnc;
    private Runnable gnd;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gmW = new g();
        this.gmX = -1;
        this.gmY = 2000L;
        this.gmZ = false;
        this.gna = false;
        this.glz = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView glB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ah(View view) {
                        this.glB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void l(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.glB != null && !StringUtils.isNull(bVar.pic)) {
                            this.glB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gnd = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gna && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gnd, AlaBannerAutoScrollView.this.gmY);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bNF = AlaBannerAutoScrollView.this.gmV.bNF();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bNF != 0) {
                    currentItem %= bNF;
                }
                alaBannerAutoScrollView.tZ(currentItem);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmW = new g();
        this.gmX = -1;
        this.gmY = 2000L;
        this.gmZ = false;
        this.gna = false;
        this.glz = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView glB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ah(View view) {
                        this.glB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void l(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.glB != null && !StringUtils.isNull(bVar.pic)) {
                            this.glB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gnd = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gna && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gnd, AlaBannerAutoScrollView.this.gmY);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bNF = AlaBannerAutoScrollView.this.gmV.bNF();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bNF != 0) {
                    currentItem %= bNF;
                }
                alaBannerAutoScrollView.tZ(currentItem);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmW = new g();
        this.gmX = -1;
        this.gmY = 2000L;
        this.gmZ = false;
        this.gna = false;
        this.glz = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView glB;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ah(View view) {
                        this.glB = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void l(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.glB != null && !StringUtils.isNull(bVar.pic)) {
                            this.glB.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gnd = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gna && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gnd, AlaBannerAutoScrollView.this.gmY);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bNF = AlaBannerAutoScrollView.this.gmV.bNF();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bNF != 0) {
                    currentItem %= bNF;
                }
                alaBannerAutoScrollView.tZ(currentItem);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gnb != null) {
                    AlaBannerAutoScrollView.this.gnb.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gmT = (LinearLayout) findViewById(R.id.dotLayout);
        this.gmU = (RecyclerView) findViewById(R.id.list_view);
        this.gmU.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gmU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.brm();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.brl();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.brm();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.brl();
                        return false;
                }
            }
        });
        this.gmV = new a(context, this.glz, false);
        this.gmU.setAdapter(this.gmV);
        this.gmU.addOnScrollListener(this.mOnScrollListener);
        this.gmU.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gmU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gmW.attachToRecyclerView(this.gmU);
    }

    public void setViewHolderAdapter(c cVar) {
        this.gmV.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gmY = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            brm();
            if (this.gmX != y.getCount(list)) {
                this.gmX = y.getCount(list);
                if (this.gmX == 1) {
                    this.gna = false;
                } else {
                    this.gna = true;
                }
                ua(this.gmX);
            }
            this.gmV.setData(list);
            this.gmV.notifyDataSetChanged();
            brl();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gmU != null) {
            if (z) {
                this.gmU.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gmU != null) {
            ((LinearLayoutManager) this.gmU.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gmW.findSnapView(this.gmU.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gmU.getLayoutManager().getPosition(findSnapView);
        int bNF = this.gmV.bNF();
        if (position < bNF) {
            int i = position + bNF;
            this.gmU.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bNF * 2) {
            int i2 = position - bNF;
            this.gmU.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        brm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brl() {
        postDelayed(this.gnd, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brm() {
        removeCallbacks(this.gnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(int i) {
        if (i >= this.gmT.getChildCount()) {
            ua(this.gmX);
            return;
        }
        for (int i2 = 0; i2 < this.gmT.getChildCount(); i2++) {
            View childAt = this.gmT.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void ua(int i) {
        if (this.gmT.getChildCount() != this.gmX) {
            this.gmT.removeAllViews();
            if (this.gmX == 1) {
                this.gmT.setVisibility(8);
            } else {
                this.gmT.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gmX; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gmT.addView(view, layoutParams);
                }
            }
        }
        if (this.gmT != null && this.gmT.getChildAt(0) != null) {
            this.gmT.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.gnb = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gnc = dVar;
        if (this.gmV != null) {
            this.gmV.setOnBannerClickListener(this.gnc);
        }
    }

    public void onChangeSkinType(int i) {
        brm();
        tZ(getCurrentItem());
        brl();
    }
}
