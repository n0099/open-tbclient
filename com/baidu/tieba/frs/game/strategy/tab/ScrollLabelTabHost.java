package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private ScrollHorizontalTabView hNC;
    private FoldedGridView hND;
    private d hNE;
    private CustomViewPager hNF;
    private FrsGameTabPagerAdapter hNG;
    private View hNH;
    private View hNI;
    private boolean hNJ;
    private g hNK;
    private a hNL;
    private List<e> hNl;
    private int hNn;
    private int hNo;
    private a hNw;
    private c hNx;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hNn = 0;
        this.hNo = 0;
        this.hNJ = false;
        this.hNw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bZ(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.bZ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ca(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.ca(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cb(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.cb(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vg(int i) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.vg(i);
                }
                return null;
            }
        };
        this.hNx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vj(int i) {
                return (e) w.getItem(ScrollLabelTabHost.this.hNl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNn = 0;
        this.hNo = 0;
        this.hNJ = false;
        this.hNw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bZ(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.bZ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ca(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.ca(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cb(int i, int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.cb(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vg(int i) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.vg(i);
                }
                return null;
            }
        };
        this.hNx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vj(int i) {
                return (e) w.getItem(ScrollLabelTabHost.this.hNl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNn = 0;
        this.hNo = 0;
        this.hNJ = false;
        this.hNw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bZ(int i2, int i22) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.bZ(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ca(int i2, int i22) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    ScrollLabelTabHost.this.hNL.ca(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cb(int i2, int i22) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.cb(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vg(int i2) {
                if (ScrollLabelTabHost.this.hNL != null) {
                    return ScrollLabelTabHost.this.hNL.vg(i2);
                }
                return null;
            }
        };
        this.hNx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vj(int i2) {
                return (e) w.getItem(ScrollLabelTabHost.this.hNl, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hNG = new FrsGameTabPagerAdapter(context, this.hNw, this.hNx);
        this.hNF = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hNF.setAdapter(this.hNG);
        this.hNC = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hNC.setViewPager(this.hNF);
        this.hNC.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hNn = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hNo = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hND.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hND.setVisibility(8);
                    }
                }
            }
        });
        this.hNE = new d(getContext());
        this.hND = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hND.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hND.setNumColumns(5);
        this.hND.setFoldAdapter(this.hNE);
        this.hND.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hND.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hNo = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView ccg = ScrollLabelTabHost.this.hNG.ccg();
                    ccg.cf(ScrollLabelTabHost.this.hNn, ScrollLabelTabHost.this.hNo);
                    if (ScrollLabelTabHost.this.hNw != null && !ScrollLabelTabHost.this.hNw.cb(ScrollLabelTabHost.this.hNn, ScrollLabelTabHost.this.hNo)) {
                        ccg.pullToRefresh();
                    }
                }
            }
        });
        this.hNH = findViewById(R.id.frs_game_tab_line);
        this.hNI = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hNG != null) {
            this.hNG.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!w.isEmpty(list)) {
            if (this.hNJ || this.hNl == null) {
                this.hNJ = z;
                this.hNl = list;
                this.hNG.setCount(this.hNl == null ? 0 : this.hNl.size());
                this.hNC.setData(list);
                if (w.isEmpty(list)) {
                    this.hNC.setVisibility(8);
                    this.hNH.setVisibility(8);
                    return;
                }
                this.hNC.setVisibility(0);
                this.hNH.setVisibility(0);
                this.hNC.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hND.setVisibility(0);
                    this.hNI.setVisibility(0);
                    return;
                }
                this.hND.setVisibility(8);
                this.hNI.setVisibility(8);
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
        this.hNE.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView ce = this.hNG.ce(i, i2);
        if (ce != null) {
            ce.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                vk(i3);
            }
        }
    }

    public void vk(int i) {
        if (this.hNK != null && this.hNK.isShowing()) {
            this.hNK.cao();
        }
        this.hNK = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView ccp = this.hNK.ccp();
        if (i == 0) {
            ccp.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            ccp.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(ccp, layoutParams);
        this.hNK.ccq();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView ce = this.hNG.ce(i, i2);
        if (ce != null) {
            ce.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hNL = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hNC.onChangeSkinType(i);
        this.hND.onChangeSkinType(i);
        this.hNG.onChangeSkinType(i);
        an.setBackgroundColor(this.hNH, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.hNI, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hNK != null) {
            this.hNK.cao();
        }
        this.hNG.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hNG.ccg();
    }

    public void buH() {
        FrsGameStrategyItemListView ccg = this.hNG.ccg();
        if (ccg != null) {
            ccg.pullToRefresh();
        }
    }
}
