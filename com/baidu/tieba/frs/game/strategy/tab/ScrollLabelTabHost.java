package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> jrU;
    private int jrW;
    private int jrX;
    private a jsf;
    private c jsg;
    private ScrollHorizontalTabView jsl;
    private FoldedGridView jsm;
    private d jsn;
    private CustomViewPager jso;
    private FrsGameTabPagerAdapter jsp;
    private View jsq;
    private View jsr;
    private boolean jss;
    private f jst;
    private a jsu;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jrW = 0;
        this.jrX = 0;
        this.jss = false;
        this.jsf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.ct(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.cu(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.cv(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zu(int i) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.zu(i);
                }
                return null;
            }
        };
        this.jsg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zx(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.jrU, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jrW = 0;
        this.jrX = 0;
        this.jss = false;
        this.jsf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.ct(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.cu(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i, int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.cv(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zu(int i) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.zu(i);
                }
                return null;
            }
        };
        this.jsg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zx(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.jrU, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jrW = 0;
        this.jrX = 0;
        this.jss = false;
        this.jsf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.ct(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i2, int i22) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    ScrollLabelTabHost.this.jsu.cu(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i2, int i22) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.cv(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zu(int i2) {
                if (ScrollLabelTabHost.this.jsu != null) {
                    return ScrollLabelTabHost.this.jsu.zu(i2);
                }
                return null;
            }
        };
        this.jsg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zx(int i2) {
                return (e) x.getItem(ScrollLabelTabHost.this.jrU, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jsp = new FrsGameTabPagerAdapter(context, this.jsf, this.jsg);
        this.jso = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jso.setAdapter(this.jsp);
        this.jsl = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jsl.setViewPager(this.jso);
        this.jsl.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jrW = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jrX = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jsm.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jsm.setVisibility(8);
                    }
                }
            }
        });
        this.jsn = new d(getContext());
        this.jsm = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jsm.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jsm.setNumColumns(5);
        this.jsm.setFoldAdapter(this.jsn);
        this.jsm.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jsm.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jrX = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cGC = ScrollLabelTabHost.this.jsp.cGC();
                    cGC.cz(ScrollLabelTabHost.this.jrW, ScrollLabelTabHost.this.jrX);
                    if (ScrollLabelTabHost.this.jsf != null && !ScrollLabelTabHost.this.jsf.cv(ScrollLabelTabHost.this.jrW, ScrollLabelTabHost.this.jrX)) {
                        cGC.pullToRefresh();
                    }
                }
            }
        });
        this.jsq = findViewById(R.id.frs_game_tab_line);
        this.jsr = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jsp != null) {
            this.jsp.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (this.jss || this.jrU == null) {
                this.jss = z;
                this.jrU = list;
                this.jsp.setCount(this.jrU == null ? 0 : this.jrU.size());
                this.jsl.setData(list);
                if (x.isEmpty(list)) {
                    this.jsl.setVisibility(8);
                    this.jsq.setVisibility(8);
                    return;
                }
                this.jsl.setVisibility(0);
                this.jsq.setVisibility(0);
                this.jsl.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jsm.setVisibility(0);
                    this.jsr.setVisibility(0);
                    return;
                }
                this.jsm.setVisibility(8);
                this.jsr.setVisibility(8);
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
        this.jsn.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cy = this.jsp.cy(i, i2);
        if (cy != null) {
            cy.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zy(i3);
            }
        }
    }

    public void zy(int i) {
        if (this.jst != null && this.jst.isShowing()) {
            this.jst.cDE();
        }
        this.jst = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cGL = this.jst.cGL();
        if (i == 0) {
            cGL.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cGL.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cGL, layoutParams);
        this.jst.cGM();
    }

    public void o(int i, int i2, String str) {
        FrsGameStrategyItemListView cy = this.jsp.cy(i, i2);
        if (cy != null) {
            cy.n(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jsu = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jsl.onChangeSkinType(i);
        this.jsm.onChangeSkinType(i);
        this.jsp.onChangeSkinType(i);
        ao.setBackgroundColor(this.jsq, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jsr, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jst != null) {
            this.jst.cDE();
        }
        this.jsp.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jsp.cGC();
    }

    public void bRN() {
        FrsGameStrategyItemListView cGC = this.jsp.cGC();
        if (cGC != null) {
            cGC.pullToRefresh();
        }
    }
}
