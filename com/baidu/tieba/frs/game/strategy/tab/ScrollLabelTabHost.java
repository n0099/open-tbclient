package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes16.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> ihA;
    private int ihC;
    private int ihD;
    private a ihL;
    private c ihM;
    private ScrollHorizontalTabView ihR;
    private FoldedGridView ihS;
    private d ihT;
    private CustomViewPager ihU;
    private FrsGameTabPagerAdapter ihV;
    private View ihW;
    private View ihX;
    private boolean ihY;
    private g ihZ;
    private a iia;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.ihC = 0;
        this.ihD = 0;
        this.ihY = false;
        this.ihL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.ck(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.cl(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.cm(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.xR(i);
                }
                return null;
            }
        };
        this.ihM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ihC = 0;
        this.ihD = 0;
        this.ihY = false;
        this.ihL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.ck(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.cl(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i, int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.cm(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.xR(i);
                }
                return null;
            }
        };
        this.ihM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihC = 0;
        this.ihD = 0;
        this.ihY = false;
        this.ihL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i2, int i22) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.ck(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i2, int i22) {
                if (ScrollLabelTabHost.this.iia != null) {
                    ScrollLabelTabHost.this.iia.cl(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i2, int i22) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.cm(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i2) {
                if (ScrollLabelTabHost.this.iia != null) {
                    return ScrollLabelTabHost.this.iia.xR(i2);
                }
                return null;
            }
        };
        this.ihM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihA, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.ihV = new FrsGameTabPagerAdapter(context, this.ihL, this.ihM);
        this.ihU = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.ihU.setAdapter(this.ihV);
        this.ihR = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.ihR.setViewPager(this.ihU);
        this.ihR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.ihC = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.ihD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.ihS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.ihS.setVisibility(8);
                    }
                }
            }
        });
        this.ihT = new d(getContext());
        this.ihS = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.ihS.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.ihS.setNumColumns(5);
        this.ihS.setFoldAdapter(this.ihT);
        this.ihS.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.ihS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.ihD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cql = ScrollLabelTabHost.this.ihV.cql();
                    cql.cq(ScrollLabelTabHost.this.ihC, ScrollLabelTabHost.this.ihD);
                    if (ScrollLabelTabHost.this.ihL != null && !ScrollLabelTabHost.this.ihL.cm(ScrollLabelTabHost.this.ihC, ScrollLabelTabHost.this.ihD)) {
                        cql.pullToRefresh();
                    }
                }
            }
        });
        this.ihW = findViewById(R.id.frs_game_tab_line);
        this.ihX = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ihV != null) {
            this.ihV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.ihY || this.ihA == null) {
                this.ihY = z;
                this.ihA = list;
                this.ihV.setCount(this.ihA == null ? 0 : this.ihA.size());
                this.ihR.setData(list);
                if (y.isEmpty(list)) {
                    this.ihR.setVisibility(8);
                    this.ihW.setVisibility(8);
                    return;
                }
                this.ihR.setVisibility(0);
                this.ihW.setVisibility(0);
                this.ihR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.ihS.setVisibility(0);
                    this.ihX.setVisibility(0);
                    return;
                }
                this.ihS.setVisibility(8);
                this.ihX.setVisibility(8);
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
        this.ihT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cp = this.ihV.cp(i, i2);
        if (cp != null) {
            cp.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                xV(i3);
            }
        }
    }

    public void xV(int i) {
        if (this.ihZ != null && this.ihZ.isShowing()) {
            this.ihZ.con();
        }
        this.ihZ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cqu = this.ihZ.cqu();
        if (i == 0) {
            cqu.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cqu.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cqu, layoutParams);
        this.ihZ.cqv();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView cp = this.ihV.cp(i, i2);
        if (cp != null) {
            cp.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.iia = aVar;
    }

    public void onChangeSkinType(int i) {
        this.ihR.onChangeSkinType(i);
        this.ihS.onChangeSkinType(i);
        this.ihV.onChangeSkinType(i);
        ap.setBackgroundColor(this.ihW, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ihX, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.ihZ != null) {
            this.ihZ.con();
        }
        this.ihV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.ihV.cql();
    }

    public void bGR() {
        FrsGameStrategyItemListView cql = this.ihV.cql();
        if (cql != null) {
            cql.pullToRefresh();
        }
    }
}
