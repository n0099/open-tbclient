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
    private c dDm;
    private LinearLayout dEI;
    private RecyclerView dEJ;
    private a dEK;
    private g dEL;
    private int dEM;
    private long dEN;
    private boolean dEO;
    private boolean dEP;
    private e dEQ;
    private d dER;
    private Runnable dES;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.dEL = new g();
        this.dEM = -1;
        this.dEN = 2000L;
        this.dEO = false;
        this.dEP = false;
        this.dDm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dDo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dDo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dDo != null && !StringUtils.isNull(bVar.pic)) {
                            this.dDo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.dES = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dEP && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dES, AlaBannerAutoScrollView.this.dEN);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKt = AlaBannerAutoScrollView.this.dEK.aKt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKt != 0) {
                    currentItem %= aKt;
                }
                alaBannerAutoScrollView.ms(currentItem);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEL = new g();
        this.dEM = -1;
        this.dEN = 2000L;
        this.dEO = false;
        this.dEP = false;
        this.dDm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dDo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dDo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dDo != null && !StringUtils.isNull(bVar.pic)) {
                            this.dDo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.dES = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dEP && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dES, AlaBannerAutoScrollView.this.dEN);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKt = AlaBannerAutoScrollView.this.dEK.aKt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKt != 0) {
                    currentItem %= aKt;
                }
                alaBannerAutoScrollView.ms(currentItem);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEL = new g();
        this.dEM = -1;
        this.dEN = 2000L;
        this.dEO = false;
        this.dEP = false;
        this.dDm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b j(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView dDo;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dDo = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.dDo != null && !StringUtils.isNull(bVar.pic)) {
                            this.dDo.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.dES = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.dEP && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.dES, AlaBannerAutoScrollView.this.dEN);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int aKt = AlaBannerAutoScrollView.this.dEK.aKt();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (aKt != 0) {
                    currentItem %= aKt;
                }
                alaBannerAutoScrollView.ms(currentItem);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.dEQ != null) {
                    AlaBannerAutoScrollView.this.dEQ.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.dEI = (LinearLayout) findViewById(R.id.dotLayout);
        this.dEJ = (RecyclerView) findViewById(R.id.list_view);
        this.dEJ.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.dEJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aop();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aoo();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aop();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aoo();
                        return false;
                }
            }
        });
        this.dEK = new a(context, this.dDm, false);
        this.dEJ.setAdapter(this.dEK);
        this.dEJ.addOnScrollListener(this.mOnScrollListener);
        this.dEJ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.dEJ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.dEL.attachToRecyclerView(this.dEJ);
    }

    public void setViewHolderAdapter(c cVar) {
        this.dEK.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.dEN = j;
    }

    public void a(List<T> list, c cVar) {
        if (!v.isEmpty(list)) {
            aop();
            if (this.dEM != v.getCount(list)) {
                this.dEM = v.getCount(list);
                if (this.dEM == 1) {
                    this.dEP = false;
                } else {
                    this.dEP = true;
                }
                mt(this.dEM);
            }
            this.dEK.setData(list);
            this.dEK.notifyDataSetChanged();
            aoo();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.dEJ != null) {
            if (z) {
                this.dEJ.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.dEJ != null) {
            ((LinearLayoutManager) this.dEJ.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.dEL.findSnapView(this.dEJ.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.dEJ.getLayoutManager().getPosition(findSnapView);
        int aKt = this.dEK.aKt();
        if (position < aKt) {
            int i = position + aKt;
            this.dEJ.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= aKt * 2) {
            int i2 = position - aKt;
            this.dEJ.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoo() {
        postDelayed(this.dES, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aop() {
        removeCallbacks(this.dES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (i >= this.dEI.getChildCount()) {
            mt(this.dEM);
            return;
        }
        for (int i2 = 0; i2 < this.dEI.getChildCount(); i2++) {
            View childAt = this.dEI.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void mt(int i) {
        if (this.dEI.getChildCount() != this.dEM) {
            this.dEI.removeAllViews();
            if (this.dEM == 1) {
                this.dEI.setVisibility(8);
            } else {
                this.dEI.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.dEM; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.dEI.addView(view, layoutParams);
                }
            }
        }
        if (this.dEI != null && this.dEI.getChildAt(0) != null) {
            this.dEI.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.dEQ = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.dER = dVar;
        if (this.dEK != null) {
            this.dEK.setOnBannerClickListener(this.dER);
        }
    }

    public void onChangeSkinType(int i) {
        aop();
        ms(getCurrentItem());
        aoo();
    }
}
