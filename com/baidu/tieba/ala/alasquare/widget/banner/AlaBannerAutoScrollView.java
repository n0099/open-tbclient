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
/* loaded from: classes3.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c esU;
    private LinearLayout eup;
    private RecyclerView euq;
    private a eur;
    private g eus;
    private int eut;
    private long euu;
    private boolean euv;
    private boolean euw;
    private e eux;
    private d euy;
    private Runnable euz;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.eus = new g();
        this.eut = -1;
        this.euu = 2000L;
        this.euv = false;
        this.euw = false;
        this.esU = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView esW;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.esW = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.esW != null && !StringUtils.isNull(bVar.pic)) {
                            this.esW.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.euz = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.euw && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.euz, AlaBannerAutoScrollView.this.euu);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bdC = AlaBannerAutoScrollView.this.eur.bdC();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bdC != 0) {
                    currentItem %= bdC;
                }
                alaBannerAutoScrollView.oS(currentItem);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eus = new g();
        this.eut = -1;
        this.euu = 2000L;
        this.euv = false;
        this.euw = false;
        this.esU = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView esW;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.esW = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.esW != null && !StringUtils.isNull(bVar.pic)) {
                            this.esW.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.euz = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.euw && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.euz, AlaBannerAutoScrollView.this.euu);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bdC = AlaBannerAutoScrollView.this.eur.bdC();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bdC != 0) {
                    currentItem %= bdC;
                }
                alaBannerAutoScrollView.oS(currentItem);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eus = new g();
        this.eut = -1;
        this.euu = 2000L;
        this.euv = false;
        this.euw = false;
        this.esU = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView esW;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.esW = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.esW != null && !StringUtils.isNull(bVar.pic)) {
                            this.esW.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.euz = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.euw && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.euz, AlaBannerAutoScrollView.this.euu);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bdC = AlaBannerAutoScrollView.this.eur.bdC();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bdC != 0) {
                    currentItem %= bdC;
                }
                alaBannerAutoScrollView.oS(currentItem);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.eux != null) {
                    AlaBannerAutoScrollView.this.eux.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.eup = (LinearLayout) findViewById(R.id.dotLayout);
        this.euq = (RecyclerView) findViewById(R.id.list_view);
        this.euq.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.euq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aIA();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aIz();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aIA();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aIz();
                        return false;
                }
            }
        });
        this.eur = new a(context, this.esU, false);
        this.euq.setAdapter(this.eur);
        this.euq.addOnScrollListener(this.mOnScrollListener);
        this.euq.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.euq.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.eus.attachToRecyclerView(this.euq);
    }

    public void setViewHolderAdapter(c cVar) {
        this.eur.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.euu = j;
    }

    public void a(List<T> list, c cVar) {
        if (!v.isEmpty(list)) {
            aIA();
            if (this.eut != v.getCount(list)) {
                this.eut = v.getCount(list);
                if (this.eut == 1) {
                    this.euw = false;
                } else {
                    this.euw = true;
                }
                oT(this.eut);
            }
            this.eur.setData(list);
            this.eur.notifyDataSetChanged();
            aIz();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.euq != null) {
            if (z) {
                this.euq.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.euq != null) {
            ((LinearLayoutManager) this.euq.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.eus.findSnapView(this.euq.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.euq.getLayoutManager().getPosition(findSnapView);
        int bdC = this.eur.bdC();
        if (position < bdC) {
            int i = position + bdC;
            this.euq.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bdC * 2) {
            int i2 = position - bdC;
            this.euq.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aIA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIz() {
        postDelayed(this.euz, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIA() {
        removeCallbacks(this.euz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        if (i >= this.eup.getChildCount()) {
            oT(this.eut);
            return;
        }
        for (int i2 = 0; i2 < this.eup.getChildCount(); i2++) {
            View childAt = this.eup.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void oT(int i) {
        if (this.eup.getChildCount() != this.eut) {
            this.eup.removeAllViews();
            if (this.eut == 1) {
                this.eup.setVisibility(8);
            } else {
                this.eup.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.eut; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.eup.addView(view, layoutParams);
                }
            }
        }
        if (this.eup != null && this.eup.getChildAt(0) != null) {
            this.eup.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.eux = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.euy = dVar;
        if (this.eur != null) {
            this.eur.setOnBannerClickListener(this.euy);
        }
    }

    public void onChangeSkinType(int i) {
        aIA();
        oS(getCurrentItem());
        aIz();
    }
}
