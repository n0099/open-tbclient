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
/* loaded from: classes9.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private a hkH;
    private c hkI;
    private ScrollHorizontalTabView hkN;
    private FoldedGridView hkO;
    private d hkP;
    private CustomViewPager hkQ;
    private FrsGameTabPagerAdapter hkR;
    private View hkS;
    private View hkT;
    private boolean hkU;
    private g hkV;
    private a hkW;
    private List<e> hkw;
    private int hky;
    private int hkz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hky = 0;
        this.hkz = 0;
        this.hkU = false;
        this.hkH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.bQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.tU(i);
                }
                return null;
            }
        };
        this.hkI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkw, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hky = 0;
        this.hkz = 0;
        this.hkU = false;
        this.hkH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i, int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.bQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.tU(i);
                }
                return null;
            }
        };
        this.hkI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkw, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hky = 0;
        this.hkz = 0;
        this.hkU = false;
        this.hkH = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i2, int i22) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i2, int i22) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    ScrollLabelTabHost.this.hkW.bP(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i2, int i22) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.bQ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i2) {
                if (ScrollLabelTabHost.this.hkW != null) {
                    return ScrollLabelTabHost.this.hkW.tU(i2);
                }
                return null;
            }
        };
        this.hkI = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkw, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hkR = new FrsGameTabPagerAdapter(context, this.hkH, this.hkI);
        this.hkQ = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hkQ.setAdapter(this.hkR);
        this.hkN = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hkN.setViewPager(this.hkQ);
        this.hkN.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hky = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hkz = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hkO.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hkO.setVisibility(8);
                    }
                }
            }
        });
        this.hkP = new d(getContext());
        this.hkO = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hkO.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hkO.setNumColumns(5);
        this.hkO.setFoldAdapter(this.hkP);
        this.hkO.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hkO.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hkz = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bSo = ScrollLabelTabHost.this.hkR.bSo();
                    bSo.bU(ScrollLabelTabHost.this.hky, ScrollLabelTabHost.this.hkz);
                    if (ScrollLabelTabHost.this.hkH != null && !ScrollLabelTabHost.this.hkH.bQ(ScrollLabelTabHost.this.hky, ScrollLabelTabHost.this.hkz)) {
                        bSo.pullToRefresh();
                    }
                }
            }
        });
        this.hkS = findViewById(R.id.frs_game_tab_line);
        this.hkT = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hkR != null) {
            this.hkR.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.hkU || this.hkw == null) {
                this.hkU = z;
                this.hkw = list;
                this.hkR.setCount(this.hkw == null ? 0 : this.hkw.size());
                this.hkN.setData(list);
                if (v.isEmpty(list)) {
                    this.hkN.setVisibility(8);
                    this.hkS.setVisibility(8);
                    return;
                }
                this.hkN.setVisibility(0);
                this.hkS.setVisibility(0);
                this.hkN.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hkO.setVisibility(0);
                    this.hkT.setVisibility(0);
                    return;
                }
                this.hkO.setVisibility(8);
                this.hkT.setVisibility(8);
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
        this.hkP.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bT = this.hkR.bT(i, i2);
        if (bT != null) {
            bT.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tY(i3);
            }
        }
    }

    public void tY(int i) {
        if (this.hkV != null && this.hkV.isShowing()) {
            this.hkV.bQG();
        }
        this.hkV = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bSx = this.hkV.bSx();
        if (i == 0) {
            bSx.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bSx.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bSx, layoutParams);
        this.hkV.bSy();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bT = this.hkR.bT(i, i2);
        if (bT != null) {
            bT.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hkW = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hkN.onChangeSkinType(i);
        this.hkO.onChangeSkinType(i);
        this.hkR.onChangeSkinType(i);
        am.setBackgroundColor(this.hkS, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hkT, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hkV != null) {
            this.hkV.bQG();
        }
        this.hkR.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hkR.bSo();
    }

    public void bmn() {
        FrsGameStrategyItemListView bSo = this.hkR.bSo();
        if (bSo != null) {
            bSo.pullToRefresh();
        }
    }
}
