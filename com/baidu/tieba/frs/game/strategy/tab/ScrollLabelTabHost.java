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
    private List<e> iPR;
    private int iPT;
    private int iPU;
    private a iQc;
    private c iQd;
    private ScrollHorizontalTabView iQi;
    private FoldedGridView iQj;
    private d iQk;
    private CustomViewPager iQl;
    private FrsGameTabPagerAdapter iQm;
    private View iQn;
    private View iQo;
    private boolean iQp;
    private g iQq;
    private a iQr;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.iPT = 0;
        this.iPU = 0;
        this.iQp = false;
        this.iQc = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cp(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cp(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.cr(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zp(int i) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.zp(i);
                }
                return null;
            }
        };
        this.iQd = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zs(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iPR, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iPT = 0;
        this.iPU = 0;
        this.iQp = false;
        this.iQc = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cp(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cp(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.cr(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zp(int i) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.zp(i);
                }
                return null;
            }
        };
        this.iQd = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zs(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iPR, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPT = 0;
        this.iPU = 0;
        this.iQp = false;
        this.iQc = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cp(int i2, int i22) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cp(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i2, int i22) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    ScrollLabelTabHost.this.iQr.cq(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.cr(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zp(int i2) {
                if (ScrollLabelTabHost.this.iQr != null) {
                    return ScrollLabelTabHost.this.iQr.zp(i2);
                }
                return null;
            }
        };
        this.iQd = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zs(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.iPR, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.iQm = new FrsGameTabPagerAdapter(context, this.iQc, this.iQd);
        this.iQl = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.iQl.setAdapter(this.iQm);
        this.iQi = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.iQi.setViewPager(this.iQl);
        this.iQi.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.iPT = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.iPU = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.iQj.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.iQj.setVisibility(8);
                    }
                }
            }
        });
        this.iQk = new d(getContext());
        this.iQj = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.iQj.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.iQj.setNumColumns(5);
        this.iQj.setFoldAdapter(this.iQk);
        this.iQj.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.iQj.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void m(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.iPU = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cAc = ScrollLabelTabHost.this.iQm.cAc();
                    cAc.cv(ScrollLabelTabHost.this.iPT, ScrollLabelTabHost.this.iPU);
                    if (ScrollLabelTabHost.this.iQc != null && !ScrollLabelTabHost.this.iQc.cr(ScrollLabelTabHost.this.iPT, ScrollLabelTabHost.this.iPU)) {
                        cAc.pullToRefresh();
                    }
                }
            }
        });
        this.iQn = findViewById(R.id.frs_game_tab_line);
        this.iQo = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iQm != null) {
            this.iQm.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.iQp || this.iPR == null) {
                this.iQp = z;
                this.iPR = list;
                this.iQm.setCount(this.iPR == null ? 0 : this.iPR.size());
                this.iQi.setData(list);
                if (y.isEmpty(list)) {
                    this.iQi.setVisibility(8);
                    this.iQn.setVisibility(8);
                    return;
                }
                this.iQi.setVisibility(0);
                this.iQn.setVisibility(0);
                this.iQi.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.iQj.setVisibility(0);
                    this.iQo.setVisibility(0);
                    return;
                }
                this.iQj.setVisibility(8);
                this.iQo.setVisibility(8);
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
        this.iQk.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cu = this.iQm.cu(i, i2);
        if (cu != null) {
            cu.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zt(i3);
            }
        }
    }

    public void zt(int i) {
        if (this.iQq != null && this.iQq.isShowing()) {
            this.iQq.cyf();
        }
        this.iQq = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cAl = this.iQq.cAl();
        if (i == 0) {
            cAl.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cAl.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cAl, layoutParams);
        this.iQq.cAm();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cu = this.iQm.cu(i, i2);
        if (cu != null) {
            cu.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.iQr = aVar;
    }

    public void onChangeSkinType(int i) {
        this.iQi.onChangeSkinType(i);
        this.iQj.onChangeSkinType(i);
        this.iQm.onChangeSkinType(i);
        ap.setBackgroundColor(this.iQn, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iQo, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.iQq != null) {
            this.iQq.cyf();
        }
        this.iQm.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.iQm.cAc();
    }

    public void bNv() {
        FrsGameStrategyItemListView cAc = this.iQm.cAc();
        if (cAc != null) {
            cAc.pullToRefresh();
        }
    }
}
