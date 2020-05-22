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
    private c fjO;
    private LinearLayout fli;
    private RecyclerView flj;
    private a flk;
    private g fll;
    private int flm;
    private long fln;
    private boolean flo;
    private boolean flp;
    private e flq;
    private d flr;
    private Runnable fls;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.fll = new g();
        this.flm = -1;
        this.fln = 2000L;
        this.flo = false;
        this.flp = false;
        this.fjO = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b k(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fjQ;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fjQ = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fjQ != null && !StringUtils.isNull(bVar.pic)) {
                            this.fjQ.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fls = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.flp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fls, AlaBannerAutoScrollView.this.fln);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int brV = AlaBannerAutoScrollView.this.flk.brV();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (brV != 0) {
                    currentItem %= brV;
                }
                alaBannerAutoScrollView.pO(currentItem);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fll = new g();
        this.flm = -1;
        this.fln = 2000L;
        this.flo = false;
        this.flp = false;
        this.fjO = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b k(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fjQ;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fjQ = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fjQ != null && !StringUtils.isNull(bVar.pic)) {
                            this.fjQ.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.fls = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.flp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fls, AlaBannerAutoScrollView.this.fln);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int brV = AlaBannerAutoScrollView.this.flk.brV();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (brV != 0) {
                    currentItem %= brV;
                }
                alaBannerAutoScrollView.pO(currentItem);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fll = new g();
        this.flm = -1;
        this.fln = 2000L;
        this.flo = false;
        this.flp = false;
        this.fjO = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b k(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView fjQ;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fjQ = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.fjQ != null && !StringUtils.isNull(bVar.pic)) {
                            this.fjQ.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.fls = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.flp && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.fls, AlaBannerAutoScrollView.this.fln);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int brV = AlaBannerAutoScrollView.this.flk.brV();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (brV != 0) {
                    currentItem %= brV;
                }
                alaBannerAutoScrollView.pO(currentItem);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.flq != null) {
                    AlaBannerAutoScrollView.this.flq.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.fli = (LinearLayout) findViewById(R.id.dotLayout);
        this.flj = (RecyclerView) findViewById(R.id.list_view);
        this.flj.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.flj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aXf();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aXe();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aXf();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aXe();
                        return false;
                }
            }
        });
        this.flk = new a(context, this.fjO, false);
        this.flj.setAdapter(this.flk);
        this.flj.addOnScrollListener(this.mOnScrollListener);
        this.flj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.flj.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.fll.attachToRecyclerView(this.flj);
    }

    public void setViewHolderAdapter(c cVar) {
        this.flk.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.fln = j;
    }

    public void a(List<T> list, c cVar) {
        if (!v.isEmpty(list)) {
            aXf();
            if (this.flm != v.getCount(list)) {
                this.flm = v.getCount(list);
                if (this.flm == 1) {
                    this.flp = false;
                } else {
                    this.flp = true;
                }
                pP(this.flm);
            }
            this.flk.setData(list);
            this.flk.notifyDataSetChanged();
            aXe();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.flj != null) {
            if (z) {
                this.flj.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.flj != null) {
            ((LinearLayoutManager) this.flj.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.fll.findSnapView(this.flj.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.flj.getLayoutManager().getPosition(findSnapView);
        int brV = this.flk.brV();
        if (position < brV) {
            int i = position + brV;
            this.flj.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= brV * 2) {
            int i2 = position - brV;
            this.flj.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aXf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        postDelayed(this.fls, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXf() {
        removeCallbacks(this.fls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(int i) {
        if (i >= this.fli.getChildCount()) {
            pP(this.flm);
            return;
        }
        for (int i2 = 0; i2 < this.fli.getChildCount(); i2++) {
            View childAt = this.fli.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void pP(int i) {
        if (this.fli.getChildCount() != this.flm) {
            this.fli.removeAllViews();
            if (this.flm == 1) {
                this.fli.setVisibility(8);
            } else {
                this.fli.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.flm; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.fli.addView(view, layoutParams);
                }
            }
        }
        if (this.fli != null && this.fli.getChildAt(0) != null) {
            this.fli.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.flq = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.flr = dVar;
        if (this.flk != null) {
            this.flk.setOnBannerClickListener(this.flr);
        }
    }

    public void onChangeSkinType(int i) {
        aXf();
        pO(getCurrentItem());
        aXe();
    }
}
