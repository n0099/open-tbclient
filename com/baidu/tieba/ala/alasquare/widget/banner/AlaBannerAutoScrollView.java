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
/* loaded from: classes2.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private c eoJ;
    private LinearLayout eqd;
    private RecyclerView eqe;
    private a eqf;
    private g eqg;
    private int eqh;
    private long eqi;
    private boolean eqj;
    private boolean eqk;
    private e eql;
    private d eqm;
    private Runnable eqn;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.eqg = new g();
        this.eqh = -1;
        this.eqi = 2000L;
        this.eqj = false;
        this.eqk = false;
        this.eoJ = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView eoL;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.eoL = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.eoL != null && !StringUtils.isNull(bVar.pic)) {
                            this.eoL.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.eqn = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.eqk && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.eqn, AlaBannerAutoScrollView.this.eqi);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bbl = AlaBannerAutoScrollView.this.eqf.bbl();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bbl != 0) {
                    currentItem %= bbl;
                }
                alaBannerAutoScrollView.oB(currentItem);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqg = new g();
        this.eqh = -1;
        this.eqi = 2000L;
        this.eqj = false;
        this.eqk = false;
        this.eoJ = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView eoL;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.eoL = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.eoL != null && !StringUtils.isNull(bVar.pic)) {
                            this.eoL.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.eqn = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.eqk && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.eqn, AlaBannerAutoScrollView.this.eqi);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bbl = AlaBannerAutoScrollView.this.eqf.bbl();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bbl != 0) {
                    currentItem %= bbl;
                }
                alaBannerAutoScrollView.oB(currentItem);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqg = new g();
        this.eqh = -1;
        this.eqi = 2000L;
        this.eqj = false;
        this.eqk = false;
        this.eoJ = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b m(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView eoL;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.eoL = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.eoL != null && !StringUtils.isNull(bVar.pic)) {
                            this.eoL.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.eqn = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.eqk && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.eqn, AlaBannerAutoScrollView.this.eqi);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bbl = AlaBannerAutoScrollView.this.eqf.bbl();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bbl != 0) {
                    currentItem %= bbl;
                }
                alaBannerAutoScrollView.oB(currentItem);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.eql != null) {
                    AlaBannerAutoScrollView.this.eql.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.eqd = (LinearLayout) findViewById(R.id.dotLayout);
        this.eqe = (RecyclerView) findViewById(R.id.list_view);
        this.eqe.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.eqe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.aGj();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.aGi();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.aGj();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.aGi();
                        return false;
                }
            }
        });
        this.eqf = new a(context, this.eoJ, false);
        this.eqe.setAdapter(this.eqf);
        this.eqe.addOnScrollListener(this.mOnScrollListener);
        this.eqe.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.eqe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.eqg.attachToRecyclerView(this.eqe);
    }

    public void setViewHolderAdapter(c cVar) {
        this.eqf.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.eqi = j;
    }

    public void a(List<T> list, c cVar) {
        if (!v.isEmpty(list)) {
            aGj();
            if (this.eqh != v.getCount(list)) {
                this.eqh = v.getCount(list);
                if (this.eqh == 1) {
                    this.eqk = false;
                } else {
                    this.eqk = true;
                }
                oC(this.eqh);
            }
            this.eqf.setData(list);
            this.eqf.notifyDataSetChanged();
            aGi();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.eqe != null) {
            if (z) {
                this.eqe.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.eqe != null) {
            ((LinearLayoutManager) this.eqe.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.eqg.findSnapView(this.eqe.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.eqe.getLayoutManager().getPosition(findSnapView);
        int bbl = this.eqf.bbl();
        if (position < bbl) {
            int i = position + bbl;
            this.eqe.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bbl * 2) {
            int i2 = position - bbl;
            this.eqe.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGi() {
        postDelayed(this.eqn, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGj() {
        removeCallbacks(this.eqn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(int i) {
        if (i >= this.eqd.getChildCount()) {
            oC(this.eqh);
            return;
        }
        for (int i2 = 0; i2 < this.eqd.getChildCount(); i2++) {
            View childAt = this.eqd.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    am.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void oC(int i) {
        if (this.eqd.getChildCount() != this.eqh) {
            this.eqd.removeAllViews();
            if (this.eqh == 1) {
                this.eqd.setVisibility(8);
            } else {
                this.eqd.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.eqh; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.eqd.addView(view, layoutParams);
                }
            }
        }
        if (this.eqd != null && this.eqd.getChildAt(0) != null) {
            this.eqd.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.eql = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.eqm = dVar;
        if (this.eqf != null) {
            this.eqf.setOnBannerClickListener(this.eqm);
        }
    }

    public void onChangeSkinType(int i) {
        aGj();
        oB(getCurrentItem());
        aGi();
    }
}
