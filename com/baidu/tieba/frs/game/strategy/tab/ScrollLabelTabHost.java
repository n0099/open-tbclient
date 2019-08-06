package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int dmE;
    private List<e> fFY;
    private int fGa;
    private a fGi;
    private c fGj;
    private ScrollHorizontalTabView fGo;
    private FoldedGridView fGp;
    private d fGq;
    private FrsGameTabPagerAdapter fGr;
    private View fGs;
    private View fGt;
    private boolean fGu;
    private g fGv;
    private a fGw;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dmE = 0;
        this.fGa = 0;
        this.fGu = false;
        this.fGi = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sd(int i) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.sd(i);
                }
                return null;
            }
        };
        this.fGj = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sg(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fFY, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmE = 0;
        this.fGa = 0;
        this.fGu = false;
        this.fGi = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sd(int i) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.sd(i);
                }
                return null;
            }
        };
        this.fGj = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sg(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fFY, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmE = 0;
        this.fGa = 0;
        this.fGu = false;
        this.fGi = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bv(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    ScrollLabelTabHost.this.fGw.bw(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.bx(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sd(int i2) {
                if (ScrollLabelTabHost.this.fGw != null) {
                    return ScrollLabelTabHost.this.fGw.sd(i2);
                }
                return null;
            }
        };
        this.fGj = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sg(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fFY, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fGr = new FrsGameTabPagerAdapter(context, this.fGi, this.fGj);
        this.mPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.mPager.setAdapter(this.fGr);
        this.fGo = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fGo.setViewPager(this.mPager);
        this.fGo.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dmE = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fGa = aVar.bFM;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fGp.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fGp.setVisibility(8);
                    }
                }
            }
        });
        this.fGq = new d(getContext());
        this.fGp = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fGp.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fGp.setNumColumns(5);
        this.fGp.setFoldAdapter(this.fGq);
        this.fGp.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fGp.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fGa = ((com.baidu.tieba.frs.game.strategy.data.a) obj).bFM;
                    FrsGameStrategyItemListView bpK = ScrollLabelTabHost.this.fGr.bpK();
                    bpK.bB(ScrollLabelTabHost.this.dmE, ScrollLabelTabHost.this.fGa);
                    if (ScrollLabelTabHost.this.fGi != null && !ScrollLabelTabHost.this.fGi.bx(ScrollLabelTabHost.this.dmE, ScrollLabelTabHost.this.fGa)) {
                        bpK.pullToRefresh();
                    }
                }
            }
        });
        this.fGs = findViewById(R.id.frs_game_tab_line);
        this.fGt = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fGr != null) {
            this.fGr.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.aa(list)) {
            if (this.fGu || this.fFY == null) {
                this.fGu = z;
                this.fFY = list;
                this.fGr.setCount(this.fFY == null ? 0 : this.fFY.size());
                this.fGo.setData(list);
                if (v.aa(list)) {
                    this.fGo.setVisibility(8);
                    this.fGs.setVisibility(8);
                    return;
                }
                this.fGo.setVisibility(0);
                this.fGs.setVisibility(0);
                this.fGo.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fGp.setVisibility(0);
                    this.fGt.setVisibility(0);
                    return;
                }
                this.fGp.setVisibility(8);
                this.fGt.setVisibility(8);
            }
        }
    }

    public boolean a(e eVar) {
        if (eVar == null || !(eVar.extra instanceof LabelDataList)) {
            return false;
        }
        LabelDataList labelDataList = (LabelDataList) eVar.extra;
        if (labelDataList.isEmpty()) {
            return false;
        }
        this.fGq.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bA = this.fGr.bA(i, i2);
        if (bA != null) {
            bA.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                sh(i3);
            }
        }
    }

    public void sh(int i) {
        if (this.fGv != null && this.fGv.isShowing()) {
            this.fGv.bod();
        }
        this.fGv = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bpT = this.fGv.bpT();
        if (i == 0) {
            bpT.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bpT.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bpT, layoutParams);
        this.fGv.bpU();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bA = this.fGr.bA(i, i2);
        if (bA != null) {
            bA.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fGw = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fGo.onChangeSkinType(i);
        this.fGp.onChangeSkinType(i);
        this.fGr.onChangeSkinType(i);
        am.l(this.fGs, R.color.cp_bg_line_b);
        am.l(this.fGt, R.color.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fGv != null) {
            this.fGv.bod();
        }
        this.fGr.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fGr.bpK();
    }

    public void aKj() {
        FrsGameStrategyItemListView bpK = this.fGr.bpK();
        if (bpK != null) {
            bpK.pullToRefresh();
        }
    }
}
