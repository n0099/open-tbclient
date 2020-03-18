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
    private a gBA;
    private List<e> gBa;
    private int gBc;
    private int gBd;
    private a gBl;
    private c gBm;
    private ScrollHorizontalTabView gBr;
    private FoldedGridView gBs;
    private d gBt;
    private CustomViewPager gBu;
    private FrsGameTabPagerAdapter gBv;
    private View gBw;
    private View gBx;
    private boolean gBy;
    private g gBz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.gBc = 0;
        this.gBd = 0;
        this.gBy = false;
        this.gBl = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bJ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bK(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.bK(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tw(int i) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.tw(i);
                }
                return null;
            }
        };
        this.gBm = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tz(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gBa, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBc = 0;
        this.gBd = 0;
        this.gBy = false;
        this.gBl = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bJ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bK(int i, int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.bK(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tw(int i) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.tw(i);
                }
                return null;
            }
        };
        this.gBm = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tz(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gBa, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBc = 0;
        this.gBd = 0;
        this.gBy = false;
        this.gBl = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bI(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    ScrollLabelTabHost.this.gBA.bJ(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bK(int i2, int i22) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.bK(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tw(int i2) {
                if (ScrollLabelTabHost.this.gBA != null) {
                    return ScrollLabelTabHost.this.gBA.tw(i2);
                }
                return null;
            }
        };
        this.gBm = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tz(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.gBa, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.gBv = new FrsGameTabPagerAdapter(context, this.gBl, this.gBm);
        this.gBu = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.gBu.setAdapter(this.gBv);
        this.gBr = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.gBr.setViewPager(this.gBu);
        this.gBr.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.gBc = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.gBd = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.gBs.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.gBs.setVisibility(8);
                    }
                }
            }
        });
        this.gBt = new d(getContext());
        this.gBs = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.gBs.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.gBs.setNumColumns(5);
        this.gBs.setFoldAdapter(this.gBt);
        this.gBs.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.gBs.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.gBd = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bHP = ScrollLabelTabHost.this.gBv.bHP();
                    bHP.bO(ScrollLabelTabHost.this.gBc, ScrollLabelTabHost.this.gBd);
                    if (ScrollLabelTabHost.this.gBl != null && !ScrollLabelTabHost.this.gBl.bK(ScrollLabelTabHost.this.gBc, ScrollLabelTabHost.this.gBd)) {
                        bHP.pullToRefresh();
                    }
                }
            }
        });
        this.gBw = findViewById(R.id.frs_game_tab_line);
        this.gBx = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gBv != null) {
            this.gBv.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gBy || this.gBa == null) {
                this.gBy = z;
                this.gBa = list;
                this.gBv.setCount(this.gBa == null ? 0 : this.gBa.size());
                this.gBr.setData(list);
                if (v.isEmpty(list)) {
                    this.gBr.setVisibility(8);
                    this.gBw.setVisibility(8);
                    return;
                }
                this.gBr.setVisibility(0);
                this.gBw.setVisibility(0);
                this.gBr.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.gBs.setVisibility(0);
                    this.gBx.setVisibility(0);
                    return;
                }
                this.gBs.setVisibility(8);
                this.gBx.setVisibility(8);
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
        this.gBt.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bN = this.gBv.bN(i, i2);
        if (bN != null) {
            bN.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tA(i3);
            }
        }
    }

    public void tA(int i) {
        if (this.gBz != null && this.gBz.isShowing()) {
            this.gBz.bGe();
        }
        this.gBz = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bHY = this.gBz.bHY();
        if (i == 0) {
            bHY.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bHY.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bHY, layoutParams);
        this.gBz.bHZ();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bN = this.gBv.bN(i, i2);
        if (bN != null) {
            bN.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gBA = aVar;
    }

    public void onChangeSkinType(int i) {
        this.gBr.onChangeSkinType(i);
        this.gBs.onChangeSkinType(i);
        this.gBv.onChangeSkinType(i);
        am.setBackgroundColor(this.gBw, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBx, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gBz != null) {
            this.gBz.bGe();
        }
        this.gBv.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.gBv.bHP();
    }

    public void bdw() {
        FrsGameStrategyItemListView bHP = this.gBv.bHP();
        if (bHP != null) {
            bHP.pullToRefresh();
        }
    }
}
