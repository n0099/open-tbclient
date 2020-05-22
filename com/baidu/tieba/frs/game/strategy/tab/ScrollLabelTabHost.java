package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
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
    private a hzB;
    private c hzC;
    private ScrollHorizontalTabView hzH;
    private FoldedGridView hzI;
    private d hzJ;
    private CustomViewPager hzK;
    private FrsGameTabPagerAdapter hzL;
    private View hzM;
    private View hzN;
    private boolean hzO;
    private g hzP;
    private a hzQ;
    private List<e> hzq;
    private int hzs;
    private int hzt;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hzs = 0;
        this.hzt = 0;
        this.hzO = false;
        this.hzB = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bT(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bU(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.bV(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uz(int i) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.uz(i);
                }
                return null;
            }
        };
        this.hzC = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uC(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hzq, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzs = 0;
        this.hzt = 0;
        this.hzO = false;
        this.hzB = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bT(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bU(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i, int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.bV(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uz(int i) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.uz(i);
                }
                return null;
            }
        };
        this.hzC = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uC(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hzq, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hzs = 0;
        this.hzt = 0;
        this.hzO = false;
        this.hzB = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i2, int i22) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bT(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i2, int i22) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    ScrollLabelTabHost.this.hzQ.bU(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i2, int i22) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.bV(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uz(int i2) {
                if (ScrollLabelTabHost.this.hzQ != null) {
                    return ScrollLabelTabHost.this.hzQ.uz(i2);
                }
                return null;
            }
        };
        this.hzC = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uC(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.hzq, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hzL = new FrsGameTabPagerAdapter(context, this.hzB, this.hzC);
        this.hzK = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hzK.setAdapter(this.hzL);
        this.hzH = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hzH.setViewPager(this.hzK);
        this.hzH.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hzs = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hzt = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hzI.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hzI.setVisibility(8);
                    }
                }
            }
        });
        this.hzJ = new d(getContext());
        this.hzI = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hzI.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hzI.setNumColumns(5);
        this.hzI.setFoldAdapter(this.hzJ);
        this.hzI.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hzI.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hzt = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bYI = ScrollLabelTabHost.this.hzL.bYI();
                    bYI.bZ(ScrollLabelTabHost.this.hzs, ScrollLabelTabHost.this.hzt);
                    if (ScrollLabelTabHost.this.hzB != null && !ScrollLabelTabHost.this.hzB.bV(ScrollLabelTabHost.this.hzs, ScrollLabelTabHost.this.hzt)) {
                        bYI.pullToRefresh();
                    }
                }
            }
        });
        this.hzM = findViewById(R.id.frs_game_tab_line);
        this.hzN = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hzL != null) {
            this.hzL.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.hzO || this.hzq == null) {
                this.hzO = z;
                this.hzq = list;
                this.hzL.setCount(this.hzq == null ? 0 : this.hzq.size());
                this.hzH.setData(list);
                if (v.isEmpty(list)) {
                    this.hzH.setVisibility(8);
                    this.hzM.setVisibility(8);
                    return;
                }
                this.hzH.setVisibility(0);
                this.hzM.setVisibility(0);
                this.hzH.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hzI.setVisibility(0);
                    this.hzN.setVisibility(0);
                    return;
                }
                this.hzI.setVisibility(8);
                this.hzN.setVisibility(8);
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
        this.hzJ.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<o> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bY = this.hzL.bY(i, i2);
        if (bY != null) {
            bY.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                uD(i3);
            }
        }
    }

    public void uD(int i) {
        if (this.hzP != null && this.hzP.isShowing()) {
            this.hzP.bXb();
        }
        this.hzP = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bYR = this.hzP.bYR();
        if (i == 0) {
            bYR.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bYR.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bYR, layoutParams);
        this.hzP.bYS();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bY = this.hzL.bY(i, i2);
        if (bY != null) {
            bY.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hzQ = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hzH.onChangeSkinType(i);
        this.hzI.onChangeSkinType(i);
        this.hzL.onChangeSkinType(i);
        am.setBackgroundColor(this.hzM, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hzN, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hzP != null) {
            this.hzP.bXb();
        }
        this.hzL.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hzL.bYI();
    }

    public void brJ() {
        FrsGameStrategyItemListView bYI = this.hzL.bYI();
        if (bYI != null) {
            bYI.pullToRefresh();
        }
    }
}
