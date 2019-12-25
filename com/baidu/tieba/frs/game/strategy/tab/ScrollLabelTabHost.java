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
/* loaded from: classes6.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> guE;
    private int guG;
    private int guH;
    private a guP;
    private c guQ;
    private ScrollHorizontalTabView guV;
    private FoldedGridView guW;
    private d guX;
    private CustomViewPager guY;
    private FrsGameTabPagerAdapter guZ;
    private View gva;
    private View gvb;
    private boolean gvc;
    private g gvd;
    private a gve;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.guG = 0;
        this.guH = 0;
        this.gvc = false;
        this.guP = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tf(int i) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.tf(i);
                }
                return null;
            }
        };
        this.guQ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ti(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.guE, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guG = 0;
        this.guH = 0;
        this.gvc = false;
        this.guP = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bI(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i, int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.bJ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tf(int i) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.tf(i);
                }
                return null;
            }
        };
        this.guQ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ti(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.guE, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.guG = 0;
        this.guH = 0;
        this.gvc = false;
        this.guP = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i2, int i22) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bH(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gve != null) {
                    ScrollLabelTabHost.this.gve.bI(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.bJ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tf(int i2) {
                if (ScrollLabelTabHost.this.gve != null) {
                    return ScrollLabelTabHost.this.gve.tf(i2);
                }
                return null;
            }
        };
        this.guQ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e ti(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.guE, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.guZ = new FrsGameTabPagerAdapter(context, this.guP, this.guQ);
        this.guY = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.guY.setAdapter(this.guZ);
        this.guV = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.guV.setViewPager(this.guY);
        this.guV.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.guG = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.guH = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.guW.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.guW.setVisibility(8);
                    }
                }
            }
        });
        this.guX = new d(getContext());
        this.guW = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.guW.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.guW.setNumColumns(5);
        this.guW.setFoldAdapter(this.guX);
        this.guW.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.guW.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.guH = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bEW = ScrollLabelTabHost.this.guZ.bEW();
                    bEW.bN(ScrollLabelTabHost.this.guG, ScrollLabelTabHost.this.guH);
                    if (ScrollLabelTabHost.this.guP != null && !ScrollLabelTabHost.this.guP.bJ(ScrollLabelTabHost.this.guG, ScrollLabelTabHost.this.guH)) {
                        bEW.pullToRefresh();
                    }
                }
            }
        });
        this.gva = findViewById(R.id.frs_game_tab_line);
        this.gvb = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.guZ != null) {
            this.guZ.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gvc || this.guE == null) {
                this.gvc = z;
                this.guE = list;
                this.guZ.setCount(this.guE == null ? 0 : this.guE.size());
                this.guV.setData(list);
                if (v.isEmpty(list)) {
                    this.guV.setVisibility(8);
                    this.gva.setVisibility(8);
                    return;
                }
                this.guV.setVisibility(0);
                this.gva.setVisibility(0);
                this.guV.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.guW.setVisibility(0);
                    this.gvb.setVisibility(0);
                    return;
                }
                this.guW.setVisibility(8);
                this.gvb.setVisibility(8);
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
        this.guX.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bM = this.guZ.bM(i, i2);
        if (bM != null) {
            bM.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                tj(i3);
            }
        }
    }

    public void tj(int i) {
        if (this.gvd != null && this.gvd.isShowing()) {
            this.gvd.bDm();
        }
        this.gvd = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bFf = this.gvd.bFf();
        if (i == 0) {
            bFf.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bFf.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bFf, layoutParams);
        this.gvd.bFg();
    }

    public void i(int i, int i2, String str) {
        FrsGameStrategyItemListView bM = this.guZ.bM(i, i2);
        if (bM != null) {
            bM.h(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gve = aVar;
    }

    public void onChangeSkinType(int i) {
        this.guV.onChangeSkinType(i);
        this.guW.onChangeSkinType(i);
        this.guZ.onChangeSkinType(i);
        am.setBackgroundColor(this.gva, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gvb, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gvd != null) {
            this.gvd.bDm();
        }
        this.guZ.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.guZ.bEW();
    }

    public void baE() {
        FrsGameStrategyItemListView bEW = this.guZ.bEW();
        if (bEW != null) {
            bEW.pullToRefresh();
        }
    }
}
