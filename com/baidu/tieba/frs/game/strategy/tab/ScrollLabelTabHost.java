package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bIM;
    private a dLH;
    private c dLI;
    private ScrollHorizontalTabView dLN;
    private FoldedGridView dLO;
    private d dLP;
    private FrsGameTabPagerAdapter dLQ;
    private View dLR;
    private View dLS;
    private boolean dLT;
    private g dLU;
    private a dLV;
    private List<e> dLx;
    private int dLz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bIM = 0;
        this.dLz = 0;
        this.dLT = false;
        this.dLH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aM(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aM(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.aO(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lX(int i) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.lX(i);
                }
                return null;
            }
        };
        this.dLI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ma(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dLx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIM = 0;
        this.dLz = 0;
        this.dLT = false;
        this.dLH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aM(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aM(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.aO(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lX(int i) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.lX(i);
                }
                return null;
            }
        };
        this.dLI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ma(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dLx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIM = 0;
        this.dLz = 0;
        this.dLT = false;
        this.dLH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aM(int i2, int i22) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aM(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i2, int i22) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    ScrollLabelTabHost.this.dLV.aN(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.aO(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lX(int i2) {
                if (ScrollLabelTabHost.this.dLV != null) {
                    return ScrollLabelTabHost.this.dLV.lX(i2);
                }
                return null;
            }
        };
        this.dLI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ma(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dLx, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dLQ = new FrsGameTabPagerAdapter(context, this.dLH, this.dLI);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dLQ);
        this.dLN = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dLN.setViewPager(this.mPager);
        this.dLN.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bIM = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dLz = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dLO.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dLO.setVisibility(8);
                    }
                }
            }
        });
        this.dLP = new d(getContext());
        this.dLO = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dLO.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dLO.setNumColumns(5);
        this.dLO.setFoldAdapter(this.dLP);
        this.dLO.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dLO.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dLz = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aDu = ScrollLabelTabHost.this.dLQ.aDu();
                    aDu.aS(ScrollLabelTabHost.this.bIM, ScrollLabelTabHost.this.dLz);
                    if (ScrollLabelTabHost.this.dLH != null && !ScrollLabelTabHost.this.dLH.aO(ScrollLabelTabHost.this.bIM, ScrollLabelTabHost.this.dLz)) {
                        aDu.pullToRefresh();
                    }
                }
            }
        });
        this.dLR = findViewById(e.g.frs_game_tab_line);
        this.dLS = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dLQ != null) {
            this.dLQ.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.J(list)) {
            if (this.dLT || this.dLx == null) {
                this.dLT = z;
                this.dLx = list;
                this.dLQ.setCount(this.dLx == null ? 0 : this.dLx.size());
                this.dLN.setData(list);
                if (v.J(list)) {
                    this.dLN.setVisibility(8);
                    this.dLR.setVisibility(8);
                    return;
                }
                this.dLN.setVisibility(0);
                this.dLR.setVisibility(0);
                this.dLN.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dLO.setVisibility(0);
                    this.dLS.setVisibility(0);
                    return;
                }
                this.dLO.setVisibility(8);
                this.dLS.setVisibility(8);
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
        this.dLP.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aR = this.dLQ.aR(i, i2);
        if (aR != null) {
            aR.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                mb(i3);
            }
        }
    }

    public void mb(int i) {
        if (this.dLU != null && this.dLU.isShowing()) {
            this.dLU.aBy();
        }
        this.dLU = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0175e.ds60));
        layoutParams.addRule(10);
        TextView aDD = this.dLU.aDD();
        if (i == 0) {
            aDD.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aDD.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aDD, layoutParams);
        this.dLU.aDE();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aR = this.dLQ.aR(i, i2);
        if (aR != null) {
            aR.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dLV = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dLN.onChangeSkinType(i);
        this.dLO.onChangeSkinType(i);
        this.dLQ.onChangeSkinType(i);
        al.j(this.dLR, e.d.cp_bg_line_b);
        al.j(this.dLS, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dLU != null) {
            this.dLU.aBy();
        }
        this.dLQ.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dLQ.aDu();
    }

    public void ZG() {
        FrsGameStrategyItemListView aDu = this.dLQ.aDu();
        if (aDu != null) {
            aDu.pullToRefresh();
        }
    }
}
