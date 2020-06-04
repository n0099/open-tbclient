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
    private View hAA;
    private boolean hAB;
    private g hAC;
    private a hAD;
    private List<e> hAd;
    private int hAf;
    private int hAg;
    private a hAo;
    private c hAp;
    private ScrollHorizontalTabView hAu;
    private FoldedGridView hAv;
    private d hAw;
    private CustomViewPager hAx;
    private FrsGameTabPagerAdapter hAy;
    private View hAz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hAf = 0;
        this.hAg = 0;
        this.hAB = false;
        this.hAo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bT(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bU(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.bV(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uB(int i) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.uB(i);
                }
                return null;
            }
        };
        this.hAp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uE(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hAd, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAf = 0;
        this.hAg = 0;
        this.hAB = false;
        this.hAo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bT(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bU(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i, int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.bV(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uB(int i) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.uB(i);
                }
                return null;
            }
        };
        this.hAp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uE(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.hAd, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAf = 0;
        this.hAg = 0;
        this.hAB = false;
        this.hAo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bT(int i2, int i22) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bT(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bU(int i2, int i22) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    ScrollLabelTabHost.this.hAD.bU(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bV(int i2, int i22) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.bV(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e uB(int i2) {
                if (ScrollLabelTabHost.this.hAD != null) {
                    return ScrollLabelTabHost.this.hAD.uB(i2);
                }
                return null;
            }
        };
        this.hAp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e uE(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.hAd, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hAy = new FrsGameTabPagerAdapter(context, this.hAo, this.hAp);
        this.hAx = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hAx.setAdapter(this.hAy);
        this.hAu = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hAu.setViewPager(this.hAx);
        this.hAu.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hAf = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hAg = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hAv.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hAv.setVisibility(8);
                    }
                }
            }
        });
        this.hAw = new d(getContext());
        this.hAv = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hAv.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hAv.setNumColumns(5);
        this.hAv.setFoldAdapter(this.hAw);
        this.hAv.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hAv.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hAg = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bYQ = ScrollLabelTabHost.this.hAy.bYQ();
                    bYQ.bZ(ScrollLabelTabHost.this.hAf, ScrollLabelTabHost.this.hAg);
                    if (ScrollLabelTabHost.this.hAo != null && !ScrollLabelTabHost.this.hAo.bV(ScrollLabelTabHost.this.hAf, ScrollLabelTabHost.this.hAg)) {
                        bYQ.pullToRefresh();
                    }
                }
            }
        });
        this.hAz = findViewById(R.id.frs_game_tab_line);
        this.hAA = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hAy != null) {
            this.hAy.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.hAB || this.hAd == null) {
                this.hAB = z;
                this.hAd = list;
                this.hAy.setCount(this.hAd == null ? 0 : this.hAd.size());
                this.hAu.setData(list);
                if (v.isEmpty(list)) {
                    this.hAu.setVisibility(8);
                    this.hAz.setVisibility(8);
                    return;
                }
                this.hAu.setVisibility(0);
                this.hAz.setVisibility(0);
                this.hAu.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hAv.setVisibility(0);
                    this.hAA.setVisibility(0);
                    return;
                }
                this.hAv.setVisibility(8);
                this.hAA.setVisibility(8);
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
        this.hAw.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<o> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bY = this.hAy.bY(i, i2);
        if (bY != null) {
            bY.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                uF(i3);
            }
        }
    }

    public void uF(int i) {
        if (this.hAC != null && this.hAC.isShowing()) {
            this.hAC.bXd();
        }
        this.hAC = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bYZ = this.hAC.bYZ();
        if (i == 0) {
            bYZ.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bYZ.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bYZ, layoutParams);
        this.hAC.bZa();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bY = this.hAy.bY(i, i2);
        if (bY != null) {
            bY.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hAD = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hAu.onChangeSkinType(i);
        this.hAv.onChangeSkinType(i);
        this.hAy.onChangeSkinType(i);
        am.setBackgroundColor(this.hAz, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hAA, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hAC != null) {
            this.hAC.bXd();
        }
        this.hAy.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hAy.bYQ();
    }

    public void brL() {
        FrsGameStrategyItemListView bYQ = this.hAy.bYQ();
        if (bYQ != null) {
            bYQ.pullToRefresh();
        }
    }
}
