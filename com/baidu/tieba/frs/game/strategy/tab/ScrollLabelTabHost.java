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
    private a gAb;
    private c gAc;
    private ScrollHorizontalTabView gAh;
    private FoldedGridView gAi;
    private d gAj;
    private CustomViewPager gAk;
    private FrsGameTabPagerAdapter gAl;
    private View gAm;
    private View gAn;
    private boolean gAo;
    private g gAp;
    private a gAq;
    private List<e> gzQ;
    private int gzS;
    private int gzT;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.gzS = 0;
        this.gzT = 0;
        this.gAo = false;
        this.gAb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.tq(i);
                }
                return null;
            }
        };
        this.gAc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzS = 0;
        this.gzT = 0;
        this.gAo = false;
        this.gAb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.tq(i);
                }
                return null;
            }
        };
        this.gAc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzS = 0;
        this.gzT = 0;
        this.gAo = false;
        this.gAb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bH(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    ScrollLabelTabHost.this.gAq.bI(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.bJ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tq(int i2) {
                if (ScrollLabelTabHost.this.gAq != null) {
                    return ScrollLabelTabHost.this.gAq.tq(i2);
                }
                return null;
            }
        };
        this.gAc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tt(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.gzQ, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.gAl = new FrsGameTabPagerAdapter(context, this.gAb, this.gAc);
        this.gAk = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.gAk.setAdapter(this.gAl);
        this.gAh = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.gAh.setViewPager(this.gAk);
        this.gAh.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.gzS = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.gzT = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.gAi.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.gAi.setVisibility(8);
                    }
                }
            }
        });
        this.gAj = new d(getContext());
        this.gAi = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.gAi.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.gAi.setNumColumns(5);
        this.gAi.setFoldAdapter(this.gAj);
        this.gAi.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.gAi.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.gzT = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bHC = ScrollLabelTabHost.this.gAl.bHC();
                    bHC.bN(ScrollLabelTabHost.this.gzS, ScrollLabelTabHost.this.gzT);
                    if (ScrollLabelTabHost.this.gAb != null && !ScrollLabelTabHost.this.gAb.bJ(ScrollLabelTabHost.this.gzS, ScrollLabelTabHost.this.gzT)) {
                        bHC.pullToRefresh();
                    }
                }
            }
        });
        this.gAm = findViewById(R.id.frs_game_tab_line);
        this.gAn = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gAl != null) {
            this.gAl.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gAo || this.gzQ == null) {
                this.gAo = z;
                this.gzQ = list;
                this.gAl.setCount(this.gzQ == null ? 0 : this.gzQ.size());
                this.gAh.setData(list);
                if (v.isEmpty(list)) {
                    this.gAh.setVisibility(8);
                    this.gAm.setVisibility(8);
                    return;
                }
                this.gAh.setVisibility(0);
                this.gAm.setVisibility(0);
                this.gAh.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.gAi.setVisibility(0);
                    this.gAn.setVisibility(0);
                    return;
                }
                this.gAi.setVisibility(8);
                this.gAn.setVisibility(8);
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
        this.gAj.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bM = this.gAl.bM(i, i2);
        if (bM != null) {
            bM.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tu(i3);
            }
        }
    }

    public void tu(int i) {
        if (this.gAp != null && this.gAp.isShowing()) {
            this.gAp.bFS();
        }
        this.gAp = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bHL = this.gAp.bHL();
        if (i == 0) {
            bHL.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bHL.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bHL, layoutParams);
        this.gAp.bHM();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bM = this.gAl.bM(i, i2);
        if (bM != null) {
            bM.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gAq = aVar;
    }

    public void onChangeSkinType(int i) {
        this.gAh.onChangeSkinType(i);
        this.gAi.onChangeSkinType(i);
        this.gAl.onChangeSkinType(i);
        am.setBackgroundColor(this.gAm, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gAn, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gAp != null) {
            this.gAp.bFS();
        }
        this.gAl.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.gAl.bHC();
    }

    public void bdq() {
        FrsGameStrategyItemListView bHC = this.gAl.bHC();
        if (bHC != null) {
            bHC.pullToRefresh();
        }
    }
}
