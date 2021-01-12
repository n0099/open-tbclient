package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    private a gFB;
    private LinearLayout gHC;
    private RecyclerView gHD;
    private AlaBannerRecyclerAdapter gHE;
    private PagerSnapHelper gHF;
    private int gHG;
    private long gHH;
    private boolean gHI;
    private boolean gHJ;
    private c gHK;
    private b gHL;
    private Runnable gHM;
    private Context mContext;
    private RecyclerView.OnScrollListener mOnScrollListener;

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.gHF = new PagerSnapHelper();
        this.gHG = -1;
        this.gHH = 2000L;
        this.gHI = false;
        this.gHJ = false;
        this.gFB = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gFD;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gFD = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gFD != null && !StringUtils.isNull(bVar.pic)) {
                            this.gFD.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gHM = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gHJ && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gHM, AlaBannerAutoScrollView.this.gHH);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bRY = AlaBannerAutoScrollView.this.gHE.bRY();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bRY != 0) {
                    currentItem %= bRY;
                }
                alaBannerAutoScrollView.tQ(currentItem);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHF = new PagerSnapHelper();
        this.gHG = -1;
        this.gHH = 2000L;
        this.gHI = false;
        this.gHJ = false;
        this.gFB = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gFD;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gFD = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gFD != null && !StringUtils.isNull(bVar.pic)) {
                            this.gFD.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.gHM = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gHJ && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gHM, AlaBannerAutoScrollView.this.gHH);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bRY = AlaBannerAutoScrollView.this.gHE.bRY();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bRY != 0) {
                    currentItem %= bRY;
                }
                alaBannerAutoScrollView.tQ(currentItem);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrolled(recyclerView, i, i2);
                }
            }
        };
        init(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHF = new PagerSnapHelper();
        this.gHG = -1;
        this.gHH = 2000L;
        this.gHI = false;
        this.gHJ = false;
        this.gFB = new a() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup, int i2) {
                return new AlaBannerViewHolder<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(AlaBannerAutoScrollView.this.mContext).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.3.1
                    public TbImageView gFD;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gFD = (TbImageView) view.findViewById(R.id.cover);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i22, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.gFD != null && !StringUtils.isNull(bVar.pic)) {
                            this.gFD.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i22) {
                    }
                };
            }
        };
        this.gHM = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                if (AlaBannerAutoScrollView.this.gHJ && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                    AlaBannerAutoScrollView.this.setCurrentItem(currentItem + 1, true);
                }
                AlaBannerAutoScrollView.this.postDelayed(AlaBannerAutoScrollView.this.gHM, AlaBannerAutoScrollView.this.gHH);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
                int bRY = AlaBannerAutoScrollView.this.gHE.bRY();
                AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
                if (bRY != 0) {
                    currentItem %= bRY;
                }
                alaBannerAutoScrollView.tQ(currentItem);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (AlaBannerAutoScrollView.this.gHK != null) {
                    AlaBannerAutoScrollView.this.gHK.onScrolled(recyclerView, i2, i22);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.gHC = (LinearLayout) findViewById(R.id.dotLayout);
        this.gHD = (RecyclerView) findViewById(R.id.list_view);
        this.gHD.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.gHD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        AlaBannerAutoScrollView.this.bvc();
                        return false;
                    case 1:
                        AlaBannerAutoScrollView.this.bvb();
                        return false;
                    case 2:
                        AlaBannerAutoScrollView.this.bvc();
                        return false;
                    default:
                        AlaBannerAutoScrollView.this.bvb();
                        return false;
                }
            }
        });
        this.gHE = new AlaBannerRecyclerAdapter(context, this.gFB, false);
        this.gHD.setAdapter(this.gHE);
        this.gHD.addOnScrollListener(this.mOnScrollListener);
        this.gHD.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaBannerAutoScrollView.this.gHD.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaBannerAutoScrollView.this.scrollToPosition(0);
            }
        });
        this.gHF.attachToRecyclerView(this.gHD);
    }

    public void setViewHolderAdapter(a aVar) {
        this.gHE.setViewHolderAdapter(aVar);
    }

    public void setAutoPlayDuation(long j) {
        this.gHH = j;
    }

    public void a(List<T> list, a aVar) {
        if (!x.isEmpty(list)) {
            bvc();
            if (this.gHG != x.getCount(list)) {
                this.gHG = x.getCount(list);
                if (this.gHG == 1) {
                    this.gHJ = false;
                } else {
                    this.gHJ = true;
                }
                tR(this.gHG);
            }
            this.gHE.setData(list);
            this.gHE.notifyDataSetChanged();
            bvb();
        }
    }

    private void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i, boolean z) {
        if (this.gHD != null) {
            if (z) {
                this.gHD.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        if (this.gHD != null) {
            ((LinearLayoutManager) this.gHD.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.gHF.findSnapView(this.gHD.getLayoutManager());
        if (findSnapView == null) {
            return -1;
        }
        int position = this.gHD.getLayoutManager().getPosition(findSnapView);
        int bRY = this.gHE.bRY();
        if (position < bRY) {
            int i = position + bRY;
            this.gHD.getLayoutManager().scrollToPosition(i);
            return i;
        } else if (position >= bRY * 2) {
            int i2 = position - bRY;
            this.gHD.getLayoutManager().scrollToPosition(i2);
            return i2;
        } else {
            return position;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvb() {
        postDelayed(this.gHM, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvc() {
        removeCallbacks(this.gHM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(int i) {
        if (i >= this.gHC.getChildCount()) {
            tR(this.gHG);
            return;
        }
        for (int i2 = 0; i2 < this.gHC.getChildCount(); i2++) {
            View childAt = this.gHC.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    ao.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    private void tR(int i) {
        if (this.gHC.getChildCount() != this.gHG) {
            this.gHC.removeAllViews();
            if (this.gHG == 1) {
                this.gHC.setVisibility(8);
            } else {
                this.gHC.setVisibility(0);
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.gHG; i2++) {
                    View view = new View(this.mContext);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.gHC.addView(view, layoutParams);
                }
            }
        }
        if (this.gHC != null && this.gHC.getChildAt(0) != null) {
            this.gHC.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void setOnBannerScrollListener(c cVar) {
        this.gHK = cVar;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gHL = bVar;
        if (this.gHE != null) {
            this.gHE.setOnBannerClickListener(this.gHL);
        }
    }

    public void onChangeSkinType(int i) {
        bvc();
        tQ(getCurrentItem());
        bvb();
    }
}
