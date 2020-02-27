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
    private c gAa;
    private ScrollHorizontalTabView gAf;
    private FoldedGridView gAg;
    private d gAh;
    private CustomViewPager gAi;
    private FrsGameTabPagerAdapter gAj;
    private View gAk;
    private View gAl;
    private boolean gAm;
    private g gAn;
    private a gAo;
    private List<e> gzO;
    private int gzQ;
    private int gzR;
    private a gzZ;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.gzQ = 0;
        this.gzR = 0;
        this.gAm = false;
        this.gzZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.tq(i);
                }
                return null;
            }
        };
        this.gAa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzQ = 0;
        this.gzR = 0;
        this.gAm = false;
        this.gzZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.tq(i);
                }
                return null;
            }
        };
        this.gAa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzQ = 0;
        this.gzR = 0;
        this.gAm = false;
        this.gzZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bH(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    ScrollLabelTabHost.this.gAo.bI(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.bJ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i2) {
                if (ScrollLabelTabHost.this.gAo != null) {
                    return ScrollLabelTabHost.this.gAo.tq(i2);
                }
                return null;
            }
        };
        this.gAa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzO, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.gAj = new FrsGameTabPagerAdapter(context, this.gzZ, this.gAa);
        this.gAi = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.gAi.setAdapter(this.gAj);
        this.gAf = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.gAf.setViewPager(this.gAi);
        this.gAf.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.gzQ = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.gzR = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.gAg.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.gAg.setVisibility(8);
                    }
                }
            }
        });
        this.gAh = new d(getContext());
        this.gAg = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.gAg.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.gAg.setNumColumns(5);
        this.gAg.setFoldAdapter(this.gAh);
        this.gAg.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.gAg.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.gzR = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bHA = ScrollLabelTabHost.this.gAj.bHA();
                    bHA.bN(ScrollLabelTabHost.this.gzQ, ScrollLabelTabHost.this.gzR);
                    if (ScrollLabelTabHost.this.gzZ != null && !ScrollLabelTabHost.this.gzZ.bJ(ScrollLabelTabHost.this.gzQ, ScrollLabelTabHost.this.gzR)) {
                        bHA.pullToRefresh();
                    }
                }
            }
        });
        this.gAk = findViewById(R.id.frs_game_tab_line);
        this.gAl = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gAj != null) {
            this.gAj.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gAm || this.gzO == null) {
                this.gAm = z;
                this.gzO = list;
                this.gAj.setCount(this.gzO == null ? 0 : this.gzO.size());
                this.gAf.setData(list);
                if (v.isEmpty(list)) {
                    this.gAf.setVisibility(8);
                    this.gAk.setVisibility(8);
                    return;
                }
                this.gAf.setVisibility(0);
                this.gAk.setVisibility(0);
                this.gAf.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.gAg.setVisibility(0);
                    this.gAl.setVisibility(0);
                    return;
                }
                this.gAg.setVisibility(8);
                this.gAl.setVisibility(8);
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
        this.gAh.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bM = this.gAj.bM(i, i2);
        if (bM != null) {
            bM.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tu(i3);
            }
        }
    }

    public void tu(int i) {
        if (this.gAn != null && this.gAn.isShowing()) {
            this.gAn.bFQ();
        }
        this.gAn = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bHJ = this.gAn.bHJ();
        if (i == 0) {
            bHJ.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bHJ.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bHJ, layoutParams);
        this.gAn.bHK();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bM = this.gAj.bM(i, i2);
        if (bM != null) {
            bM.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gAo = aVar;
    }

    public void onChangeSkinType(int i) {
        this.gAf.onChangeSkinType(i);
        this.gAg.onChangeSkinType(i);
        this.gAj.onChangeSkinType(i);
        am.setBackgroundColor(this.gAk, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gAl, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gAn != null) {
            this.gAn.bFQ();
        }
        this.gAj.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.gAj.bHA();
    }

    public void bdo() {
        FrsGameStrategyItemListView bHA = this.gAj.bHA();
        if (bHA != null) {
            bHA.pullToRefresh();
        }
    }
}
