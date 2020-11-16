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
    private c gqT;
    private LinearLayout gsn;
    private RecyclerView gso;
    private a gsp;
    private g gsq;
    private int gsr;
    private long gss;
    private boolean gst;
    private boolean gsu;
    private e gsv;
    private d gsw;
    private Runnable gsx;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gsq = new g();
        this.gsr = -1;
        this.gss = 2000L;
        this.gst = false;
        this.gsu = false;
        this.gqT = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gqV;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gqV = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gqV != null && !StringUtils.isNull(bVar.pic)) {
                            this.gqV.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsu && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsx, AlaBannerAutoScrollView.this.gss);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bPy = AlaBannerAutoScrollView.this.gsp.bPy();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bPy != 0) {
                    currentItem %= bPy;
                }
                alaBannerAutoScrollView.uH(currentItem);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsq = new g();
        this.gsr = -1;
        this.gss = 2000L;
        this.gst = false;
        this.gsu = false;
        this.gqT = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gqV;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gqV = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gqV != null && !StringUtils.isNull(bVar.pic)) {
                            this.gqV.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsu && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsx, AlaBannerAutoScrollView.this.gss);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bPy = AlaBannerAutoScrollView.this.gsp.bPy();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bPy != 0) {
                    currentItem %= bPy;
                }
                alaBannerAutoScrollView.uH(currentItem);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsq = new g();
        this.gsr = -1;
        this.gss = 2000L;
        this.gst = false;
        this.gsu = false;
        this.gqT = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gqV;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gqV = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gqV != null && !StringUtils.isNull(bVar.pic)) {
                            this.gqV.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsu && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsx, AlaBannerAutoScrollView.this.gss);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bPy = AlaBannerAutoScrollView.this.gsp.bPy();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bPy != 0) {
                    currentItem %= bPy;
                }
                alaBannerAutoScrollView.uH(currentItem);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gsv != null) {
                    AlaBannerAutoScrollView.this.gsv.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gsn = (LinearLayout) findViewById(R.id.dotLayout);
        this.gso = (RecyclerView) findViewById(R.id.list_view);
        this.gso.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gso.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.btc();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.btb();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.btc();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.btb();
                        return false;
                }
            }
        });
        this.gsp = new a(context, this.gqT, false);
        this.gso.setAdapter(this.gsp);
        this.gso.addOnScrollListener(this.mOnScrollListener);
        this.gso.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gso.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gsq.attachToRecyclerView(this.gso);
    }

    public void setViewHolderAdapter(c cVar) {
        this.gsp.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gss = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            btc();
            if (this.gsr != y.getCount(list)) {
                this.gsr = y.getCount(list);
                if (this.gsr == 1) {
                    this.gsu = false;
                } else {
                    this.gsu = true;
                }
                uI(this.gsr);
            }
            this.gsp.setData(list);
            this.gsp.notifyDataSetChanged();
            btb();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gso != null) {
            if (z) {
                this.gso.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gso != null) {
            ((LinearLayoutManager) this.gso.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gsq.findSnapView(this.gso.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gso.getLayoutManager().getPosition(findSnapView);
        int bPy = this.gsp.bPy();
        if (position < bPy) {
            int i = position + bPy;
            this.gso.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bPy * 2) {
            int i2 = position - bPy;
            this.gso.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btb() {
        postDelayed(this.gsx, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btc() {
        removeCallbacks(this.gsx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        if (i >= this.gsn.getChildCount()) {
            uI(this.gsr);
            return;
        }
        for (int i2 = 0; i2 < this.gsn.getChildCount(); i2++) {
            View childAt = this.gsn.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void uI(int i) {
        if (this.gsn.getChildCount() != this.gsr) {
            this.gsn.removeAllViews();
            if (this.gsr == 1) {
                this.gsn.setVisibility(8);
            } else {
                this.gsn.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gsr; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gsn.addView(view, layoutParams);
                }
            }
        }
        if (this.gsn != null && this.gsn.getChildAt(0) != null) {
            this.gsn.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.gsv = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gsw = dVar;
        if (this.gsp != null) {
            this.gsp.setOnBannerClickListener(this.gsw);
        }
    }

    public void onChangeSkinType(int i) {
        btc();
        uH(getCurrentItem());
        btb();
    }
}
