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
    private List<e> hkC;
    private int hkE;
    private int hkF;
    private a hkN;
    private c hkO;
    private ScrollHorizontalTabView hkT;
    private FoldedGridView hkU;
    private d hkV;
    private CustomViewPager hkW;
    private FrsGameTabPagerAdapter hkX;
    private View hkY;
    private View hkZ;
    private boolean hla;
    private g hlb;
    private a hlc;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hkE = 0;
        this.hkF = 0;
        this.hla = false;
        this.hkN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.bQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.tU(i);
                }
                return null;
            }
        };
        this.hkO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkE = 0;
        this.hkF = 0;
        this.hla = false;
        this.hkN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i, int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.bQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.tU(i);
                }
                return null;
            }
        };
        this.hkO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkE = 0;
        this.hkF = 0;
        this.hla = false;
        this.hkN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bO(int i2, int i22) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bP(int i2, int i22) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    ScrollLabelTabHost.this.hlc.bP(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bQ(int i2, int i22) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.bQ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tU(int i2) {
                if (ScrollLabelTabHost.this.hlc != null) {
                    return ScrollLabelTabHost.this.hlc.tU(i2);
                }
                return null;
            }
        };
        this.hkO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tX(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.hkC, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hkX = new FrsGameTabPagerAdapter(context, this.hkN, this.hkO);
        this.hkW = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hkW.setAdapter(this.hkX);
        this.hkT = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hkT.setViewPager(this.hkW);
        this.hkT.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hkE = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hkF = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hkU.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hkU.setVisibility(8);
                    }
                }
            }
        });
        this.hkV = new d(getContext());
        this.hkU = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hkU.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hkU.setNumColumns(5);
        this.hkU.setFoldAdapter(this.hkV);
        this.hkU.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hkU.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hkF = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bSn = ScrollLabelTabHost.this.hkX.bSn();
                    bSn.bU(ScrollLabelTabHost.this.hkE, ScrollLabelTabHost.this.hkF);
                    if (ScrollLabelTabHost.this.hkN != null && !ScrollLabelTabHost.this.hkN.bQ(ScrollLabelTabHost.this.hkE, ScrollLabelTabHost.this.hkF)) {
                        bSn.pullToRefresh();
                    }
                }
            }
        });
        this.hkY = findViewById(R.id.frs_game_tab_line);
        this.hkZ = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hkX != null) {
            this.hkX.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.hla || this.hkC == null) {
                this.hla = z;
                this.hkC = list;
                this.hkX.setCount(this.hkC == null ? 0 : this.hkC.size());
                this.hkT.setData(list);
                if (v.isEmpty(list)) {
                    this.hkT.setVisibility(8);
                    this.hkY.setVisibility(8);
                    return;
                }
                this.hkT.setVisibility(0);
                this.hkY.setVisibility(0);
                this.hkT.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hkU.setVisibility(0);
                    this.hkZ.setVisibility(0);
                    return;
                }
                this.hkU.setVisibility(8);
                this.hkZ.setVisibility(8);
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
        this.hkV.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bT = this.hkX.bT(i, i2);
        if (bT != null) {
            bT.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tY(i3);
            }
        }
    }

    public void tY(int i) {
        if (this.hlb != null && this.hlb.isShowing()) {
            this.hlb.bQF();
        }
        this.hlb = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bSw = this.hlb.bSw();
        if (i == 0) {
            bSw.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bSw.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bSw, layoutParams);
        this.hlb.bSx();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bT = this.hkX.bT(i, i2);
        if (bT != null) {
            bT.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hlc = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hkT.onChangeSkinType(i);
        this.hkU.onChangeSkinType(i);
        this.hkX.onChangeSkinType(i);
        am.setBackgroundColor(this.hkY, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hkZ, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hlb != null) {
            this.hlb.bQF();
        }
        this.hkX.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hkX.bSn();
    }

    public void bml() {
        FrsGameStrategyItemListView bSn = this.hkX.bSn();
        if (bSn != null) {
            bSn.pullToRefresh();
        }
    }
}
