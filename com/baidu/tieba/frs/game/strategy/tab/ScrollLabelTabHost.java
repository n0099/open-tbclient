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
    private a ihF;
    private c ihG;
    private ScrollHorizontalTabView ihL;
    private FoldedGridView ihM;
    private d ihN;
    private CustomViewPager ihO;
    private FrsGameTabPagerAdapter ihP;
    private View ihQ;
    private View ihR;
    private boolean ihS;
    private g ihT;
    private a ihU;
    private List<e> ihu;
    private int ihw;
    private int ihx;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.ihw = 0;
        this.ihx = 0;
        this.ihS = false;
        this.ihF = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.ck(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.cl(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.cm(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.xR(i);
                }
                return null;
            }
        };
        this.ihG = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihu, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ihw = 0;
        this.ihx = 0;
        this.ihS = false;
        this.ihF = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.ck(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.cl(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i, int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.cm(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.xR(i);
                }
                return null;
            }
        };
        this.ihG = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihu, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihw = 0;
        this.ihx = 0;
        this.ihS = false;
        this.ihF = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ck(int i2, int i22) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.ck(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cl(int i2, int i22) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    ScrollLabelTabHost.this.ihU.cl(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cm(int i2, int i22) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.cm(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e xR(int i2) {
                if (ScrollLabelTabHost.this.ihU != null) {
                    return ScrollLabelTabHost.this.ihU.xR(i2);
                }
                return null;
            }
        };
        this.ihG = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e xU(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.ihu, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.ihP = new FrsGameTabPagerAdapter(context, this.ihF, this.ihG);
        this.ihO = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.ihO.setAdapter(this.ihP);
        this.ihL = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.ihL.setViewPager(this.ihO);
        this.ihL.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.ihw = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.ihx = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.ihM.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.ihM.setVisibility(8);
                    }
                }
            }
        });
        this.ihN = new d(getContext());
        this.ihM = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.ihM.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.ihM.setNumColumns(5);
        this.ihM.setFoldAdapter(this.ihN);
        this.ihM.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.ihM.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.ihx = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cqk = ScrollLabelTabHost.this.ihP.cqk();
                    cqk.cq(ScrollLabelTabHost.this.ihw, ScrollLabelTabHost.this.ihx);
                    if (ScrollLabelTabHost.this.ihF != null && !ScrollLabelTabHost.this.ihF.cm(ScrollLabelTabHost.this.ihw, ScrollLabelTabHost.this.ihx)) {
                        cqk.pullToRefresh();
                    }
                }
            }
        });
        this.ihQ = findViewById(R.id.frs_game_tab_line);
        this.ihR = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ihP != null) {
            this.ihP.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.ihS || this.ihu == null) {
                this.ihS = z;
                this.ihu = list;
                this.ihP.setCount(this.ihu == null ? 0 : this.ihu.size());
                this.ihL.setData(list);
                if (y.isEmpty(list)) {
                    this.ihL.setVisibility(8);
                    this.ihQ.setVisibility(8);
                    return;
                }
                this.ihL.setVisibility(0);
                this.ihQ.setVisibility(0);
                this.ihL.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.ihM.setVisibility(0);
                    this.ihR.setVisibility(0);
                    return;
                }
                this.ihM.setVisibility(8);
                this.ihR.setVisibility(8);
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
        this.ihN.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cp = this.ihP.cp(i, i2);
        if (cp != null) {
            cp.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                xV(i3);
            }
        }
    }

    public void xV(int i) {
        if (this.ihT != null && this.ihT.isShowing()) {
            this.ihT.com();
        }
        this.ihT = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cqt = this.ihT.cqt();
        if (i == 0) {
            cqt.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cqt.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cqt, layoutParams);
        this.ihT.cqu();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView cp = this.ihP.cp(i, i2);
        if (cp != null) {
            cp.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.ihU = aVar;
    }

    public void onChangeSkinType(int i) {
        this.ihL.onChangeSkinType(i);
        this.ihM.onChangeSkinType(i);
        this.ihP.onChangeSkinType(i);
        ap.setBackgroundColor(this.ihQ, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ihR, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.ihT != null) {
            this.ihT.com();
        }
        this.ihP.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.ihP.cqk();
    }

    public void bGQ() {
        FrsGameStrategyItemListView cqk = this.ihP.cqk();
        if (cqk != null) {
            cqk.pullToRefresh();
        }
    }
}
