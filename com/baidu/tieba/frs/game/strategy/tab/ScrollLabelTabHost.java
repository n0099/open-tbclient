package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes22.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private a iDG;
    private c iDH;
    private ScrollHorizontalTabView iDM;
    private FoldedGridView iDN;
    private d iDO;
    private CustomViewPager iDP;
    private FrsGameTabPagerAdapter iDQ;
    private View iDR;
    private View iDS;
    private boolean iDT;
    private g iDU;
    private a iDV;
    private List<e> iDv;
    private int iDx;
    private int iDy;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.iDx = 0;
        this.iDy = 0;
        this.iDT = false;
        this.iDG = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.cn(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.co(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.cp(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yW(int i) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.yW(i);
                }
                return null;
            }
        };
        this.iDH = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yZ(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iDv, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDx = 0;
        this.iDy = 0;
        this.iDT = false;
        this.iDG = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.cn(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.co(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i, int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.cp(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yW(int i) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.yW(i);
                }
                return null;
            }
        };
        this.iDH = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yZ(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iDv, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDx = 0;
        this.iDy = 0;
        this.iDT = false;
        this.iDG = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i2, int i22) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.cn(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i2, int i22) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    ScrollLabelTabHost.this.iDV.co(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i2, int i22) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.cp(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yW(int i2) {
                if (ScrollLabelTabHost.this.iDV != null) {
                    return ScrollLabelTabHost.this.iDV.yW(i2);
                }
                return null;
            }
        };
        this.iDH = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yZ(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.iDv, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.iDQ = new FrsGameTabPagerAdapter(context, this.iDG, this.iDH);
        this.iDP = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.iDP.setAdapter(this.iDQ);
        this.iDM = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.iDM.setViewPager(this.iDP);
        this.iDM.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.iDx = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.iDy = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.iDN.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.iDN.setVisibility(8);
                    }
                }
            }
        });
        this.iDO = new d(getContext());
        this.iDN = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.iDN.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.iDN.setNumColumns(5);
        this.iDN.setFoldAdapter(this.iDO);
        this.iDN.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.iDN.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void j(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.iDy = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cwV = ScrollLabelTabHost.this.iDQ.cwV();
                    cwV.ct(ScrollLabelTabHost.this.iDx, ScrollLabelTabHost.this.iDy);
                    if (ScrollLabelTabHost.this.iDG != null && !ScrollLabelTabHost.this.iDG.cp(ScrollLabelTabHost.this.iDx, ScrollLabelTabHost.this.iDy)) {
                        cwV.pullToRefresh();
                    }
                }
            }
        });
        this.iDR = findViewById(R.id.frs_game_tab_line);
        this.iDS = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iDQ != null) {
            this.iDQ.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.iDT || this.iDv == null) {
                this.iDT = z;
                this.iDv = list;
                this.iDQ.setCount(this.iDv == null ? 0 : this.iDv.size());
                this.iDM.setData(list);
                if (y.isEmpty(list)) {
                    this.iDM.setVisibility(8);
                    this.iDR.setVisibility(8);
                    return;
                }
                this.iDM.setVisibility(0);
                this.iDR.setVisibility(0);
                this.iDM.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.iDN.setVisibility(0);
                    this.iDS.setVisibility(0);
                    return;
                }
                this.iDN.setVisibility(8);
                this.iDS.setVisibility(8);
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
        this.iDO.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cs = this.iDQ.cs(i, i2);
        if (cs != null) {
            cs.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                za(i3);
            }
        }
    }

    public void za(int i) {
        if (this.iDU != null && this.iDU.isShowing()) {
            this.iDU.cuY();
        }
        this.iDU = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cxe = this.iDU.cxe();
        if (i == 0) {
            cxe.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cxe.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cxe, layoutParams);
        this.iDU.cxf();
    }

    public void m(int i, int i2, String str) {
        FrsGameStrategyItemListView cs = this.iDQ.cs(i, i2);
        if (cs != null) {
            cs.l(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.iDV = aVar;
    }

    public void onChangeSkinType(int i) {
        this.iDM.onChangeSkinType(i);
        this.iDN.onChangeSkinType(i);
        this.iDQ.onChangeSkinType(i);
        ap.setBackgroundColor(this.iDR, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iDS, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.iDU != null) {
            this.iDU.cuY();
        }
        this.iDQ.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.iDQ.cwV();
    }

    public void bKT() {
        FrsGameStrategyItemListView cwV = this.iDQ.cwV();
        if (cwV != null) {
            cwV.pullToRefresh();
        }
    }
}
