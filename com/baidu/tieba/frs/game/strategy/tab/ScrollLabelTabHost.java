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
    private boolean gAA;
    private g gAB;
    private a gAC;
    private List<e> gAc;
    private int gAe;
    private int gAf;
    private a gAn;
    private c gAo;
    private ScrollHorizontalTabView gAt;
    private FoldedGridView gAu;
    private d gAv;
    private CustomViewPager gAw;
    private FrsGameTabPagerAdapter gAx;
    private View gAy;
    private View gAz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.gAe = 0;
        this.gAf = 0;
        this.gAA = false;
        this.gAn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.tq(i);
                }
                return null;
            }
        };
        this.gAo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gAc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAe = 0;
        this.gAf = 0;
        this.gAA = false;
        this.gAn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.tq(i);
                }
                return null;
            }
        };
        this.gAo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gAc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAe = 0;
        this.gAf = 0;
        this.gAA = false;
        this.gAn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bH(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    ScrollLabelTabHost.this.gAC.bI(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.bJ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i2) {
                if (ScrollLabelTabHost.this.gAC != null) {
                    return ScrollLabelTabHost.this.gAC.tq(i2);
                }
                return null;
            }
        };
        this.gAo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.gAc, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.gAx = new FrsGameTabPagerAdapter(context, this.gAn, this.gAo);
        this.gAw = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.gAw.setAdapter(this.gAx);
        this.gAt = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.gAt.setViewPager(this.gAw);
        this.gAt.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.gAe = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.gAf = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.gAu.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.gAu.setVisibility(8);
                    }
                }
            }
        });
        this.gAv = new d(getContext());
        this.gAu = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.gAu.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.gAu.setNumColumns(5);
        this.gAu.setFoldAdapter(this.gAv);
        this.gAu.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.gAu.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.gAf = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bHD = ScrollLabelTabHost.this.gAx.bHD();
                    bHD.bN(ScrollLabelTabHost.this.gAe, ScrollLabelTabHost.this.gAf);
                    if (ScrollLabelTabHost.this.gAn != null && !ScrollLabelTabHost.this.gAn.bJ(ScrollLabelTabHost.this.gAe, ScrollLabelTabHost.this.gAf)) {
                        bHD.pullToRefresh();
                    }
                }
            }
        });
        this.gAy = findViewById(R.id.frs_game_tab_line);
        this.gAz = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gAx != null) {
            this.gAx.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gAA || this.gAc == null) {
                this.gAA = z;
                this.gAc = list;
                this.gAx.setCount(this.gAc == null ? 0 : this.gAc.size());
                this.gAt.setData(list);
                if (v.isEmpty(list)) {
                    this.gAt.setVisibility(8);
                    this.gAy.setVisibility(8);
                    return;
                }
                this.gAt.setVisibility(0);
                this.gAy.setVisibility(0);
                this.gAt.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.gAu.setVisibility(0);
                    this.gAz.setVisibility(0);
                    return;
                }
                this.gAu.setVisibility(8);
                this.gAz.setVisibility(8);
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
        this.gAv.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bM = this.gAx.bM(i, i2);
        if (bM != null) {
            bM.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tu(i3);
            }
        }
    }

    public void tu(int i) {
        if (this.gAB != null && this.gAB.isShowing()) {
            this.gAB.bFT();
        }
        this.gAB = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bHM = this.gAB.bHM();
        if (i == 0) {
            bHM.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bHM.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bHM, layoutParams);
        this.gAB.bHN();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bM = this.gAx.bM(i, i2);
        if (bM != null) {
            bM.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gAC = aVar;
    }

    public void onChangeSkinType(int i) {
        this.gAt.onChangeSkinType(i);
        this.gAu.onChangeSkinType(i);
        this.gAx.onChangeSkinType(i);
        am.setBackgroundColor(this.gAy, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gAz, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gAB != null) {
            this.gAB.bFT();
        }
        this.gAx.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.gAx.bHD();
    }

    public void bdr() {
        FrsGameStrategyItemListView bHD = this.gAx.bHD();
        if (bHD != null) {
            bHD.pullToRefresh();
        }
    }
}
