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
    private c grm;
    private LinearLayout gsG;
    private RecyclerView gsH;
    private a gsI;
    private g gsJ;
    private int gsK;
    private long gsL;
    private boolean gsM;
    private boolean gsN;
    private e gsO;
    private d gsP;
    private Runnable gsQ;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gsJ = new g();
        this.gsK = -1;
        this.gsL = 2000L;
        this.gsM = false;
        this.gsN = false;
        this.grm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gro;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gro = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gro != null && !StringUtils.isNull(bVar.pic)) {
                            this.gro.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gsQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsQ, AlaBannerAutoScrollView.this.gsL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bQf = AlaBannerAutoScrollView.this.gsI.bQf();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bQf != 0) {
                    currentItem %= bQf;
                }
                alaBannerAutoScrollView.uj(currentItem);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsJ = new g();
        this.gsK = -1;
        this.gsL = 2000L;
        this.gsM = false;
        this.gsN = false;
        this.grm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gro;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gro = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gro != null && !StringUtils.isNull(bVar.pic)) {
                            this.gro.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gsQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsQ, AlaBannerAutoScrollView.this.gsL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bQf = AlaBannerAutoScrollView.this.gsI.bQf();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bQf != 0) {
                    currentItem %= bQf;
                }
                alaBannerAutoScrollView.uj(currentItem);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsJ = new g();
        this.gsK = -1;
        this.gsL = 2000L;
        this.gsM = false;
        this.gsN = false;
        this.grm = new c() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public b p(ViewGroup viewGroup, int i2) {
                return new b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gro;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gro = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gro != null && !StringUtils.isNull(bVar.pic)) {
                            this.gro.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gsQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gsN && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gsQ, AlaBannerAutoScrollView.this.gsL);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bQf = AlaBannerAutoScrollView.this.gsI.bQf();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bQf != 0) {
                    currentItem %= bQf;
                }
                alaBannerAutoScrollView.uj(currentItem);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gsO != null) {
                    AlaBannerAutoScrollView.this.gsO.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gsG = (LinearLayout) findViewById(R.id.dotLayout);
        this.gsH = (RecyclerView) findViewById(R.id.list_view);
        this.gsH.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gsH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.btM();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.btL();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.btM();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.btL();
                        return false;
                }
            }
        });
        this.gsI = new a(context, this.grm, false);
        this.gsH.setAdapter(this.gsI);
        this.gsH.addOnScrollListener(this.mOnScrollListener);
        this.gsH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gsH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gsJ.attachToRecyclerView(this.gsH);
    }

    public void setViewHolderAdapter(c cVar) {
        this.gsI.setViewHolderAdapter(cVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gsL = j;
    }

    public void a(List<T> list, c cVar) {
        if (!y.isEmpty(list)) {
            btM();
            if (this.gsK != y.getCount(list)) {
                this.gsK = y.getCount(list);
                if (this.gsK == 1) {
                    this.gsN = false;
                } else {
                    this.gsN = true;
                }
                uk(this.gsK);
            }
            this.gsI.setData(list);
            this.gsI.notifyDataSetChanged();
            btL();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gsH != null) {
            if (z) {
                this.gsH.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gsH != null) {
            ((LinearLayoutManager) this.gsH.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gsJ.findSnapView(this.gsH.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gsH.getLayoutManager().getPosition(findSnapView);
        int bQf = this.gsI.bQf();
        if (position < bQf) {
            int i = position + bQf;
            this.gsH.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bQf * 2) {
            int i2 = position - bQf;
            this.gsH.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btL() {
        postDelayed(this.gsQ, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btM() {
        removeCallbacks(this.gsQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(int i) {
        if (i >= this.gsG.getChildCount()) {
            uk(this.gsK);
            return;
        }
        for (int i2 = 0; i2 < this.gsG.getChildCount(); i2++) {
            View childAt = this.gsG.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ap.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void uk(int i) {
        if (this.gsG.getChildCount() != this.gsK) {
            this.gsG.removeAllViews();
            if (this.gsK == 1) {
                this.gsG.setVisibility(8);
            } else {
                this.gsG.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gsK; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gsG.addView(view, layoutParams);
                }
            }
        }
        if (this.gsG != null && this.gsG.getChildAt(0) != null) {
            this.gsG.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(e eVar) {
        this.gsO = eVar;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gsP = dVar;
        if (this.gsI != null) {
            this.gsI.setOnBannerClickListener(this.gsP);
        }
    }

    public void onChangeSkinType(int i) {
        btM();
        uj(getCurrentItem());
        btL();
    }
}
