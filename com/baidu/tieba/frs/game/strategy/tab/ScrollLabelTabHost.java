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
    private List<e> iVO;
    private int iVQ;
    private int iVR;
    private a iVZ;
    private c iWa;
    private ScrollHorizontalTabView iWf;
    private FoldedGridView iWg;
    private d iWh;
    private CustomViewPager iWi;
    private FrsGameTabPagerAdapter iWj;
    private View iWk;
    private View iWl;
    private boolean iWm;
    private g iWn;
    private a iWo;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.iVQ = 0;
        this.iVR = 0;
        this.iWm = false;
        this.iVZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zC(int i) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.zC(i);
                }
                return null;
            }
        };
        this.iWa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zF(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iVO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVQ = 0;
        this.iVR = 0;
        this.iWm = false;
        this.iVZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zC(int i) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.zC(i);
                }
                return null;
            }
        };
        this.iWa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zF(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iVO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVQ = 0;
        this.iVR = 0;
        this.iWm = false;
        this.iVZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cr(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i2, int i22) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    ScrollLabelTabHost.this.iWo.cs(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.ct(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zC(int i2) {
                if (ScrollLabelTabHost.this.iWo != null) {
                    return ScrollLabelTabHost.this.iWo.zC(i2);
                }
                return null;
            }
        };
        this.iWa = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zF(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.iVO, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.iWj = new FrsGameTabPagerAdapter(context, this.iVZ, this.iWa);
        this.iWi = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.iWi.setAdapter(this.iWj);
        this.iWf = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.iWf.setViewPager(this.iWi);
        this.iWf.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.iVQ = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.iVR = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.iWg.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.iWg.setVisibility(8);
                    }
                }
            }
        });
        this.iWh = new d(getContext());
        this.iWg = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.iWg.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.iWg.setNumColumns(5);
        this.iWg.setFoldAdapter(this.iWh);
        this.iWg.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.iWg.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.iVR = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cCD = ScrollLabelTabHost.this.iWj.cCD();
                    cCD.cx(ScrollLabelTabHost.this.iVQ, ScrollLabelTabHost.this.iVR);
                    if (ScrollLabelTabHost.this.iVZ != null && !ScrollLabelTabHost.this.iVZ.ct(ScrollLabelTabHost.this.iVQ, ScrollLabelTabHost.this.iVR)) {
                        cCD.pullToRefresh();
                    }
                }
            }
        });
        this.iWk = findViewById(R.id.frs_game_tab_line);
        this.iWl = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iWj != null) {
            this.iWj.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.iWm || this.iVO == null) {
                this.iWm = z;
                this.iVO = list;
                this.iWj.setCount(this.iVO == null ? 0 : this.iVO.size());
                this.iWf.setData(list);
                if (y.isEmpty(list)) {
                    this.iWf.setVisibility(8);
                    this.iWk.setVisibility(8);
                    return;
                }
                this.iWf.setVisibility(0);
                this.iWk.setVisibility(0);
                this.iWf.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.iWg.setVisibility(0);
                    this.iWl.setVisibility(0);
                    return;
                }
                this.iWg.setVisibility(8);
                this.iWl.setVisibility(8);
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
        this.iWh.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cw = this.iWj.cw(i, i2);
        if (cw != null) {
            cw.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zG(i3);
            }
        }
    }

    public void zG(int i) {
        if (this.iWn != null && this.iWn.isShowing()) {
            this.iWn.cAG();
        }
        this.iWn = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cCM = this.iWn.cCM();
        if (i == 0) {
            cCM.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cCM.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cCM, layoutParams);
        this.iWn.cCN();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cw = this.iWj.cw(i, i2);
        if (cw != null) {
            cw.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.iWo = aVar;
    }

    public void onChangeSkinType(int i) {
        this.iWf.onChangeSkinType(i);
        this.iWg.onChangeSkinType(i);
        this.iWj.onChangeSkinType(i);
        ap.setBackgroundColor(this.iWk, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iWl, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.iWn != null) {
            this.iWn.cAG();
        }
        this.iWj.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.iWj.cCD();
    }

    public void bPV() {
        FrsGameStrategyItemListView cCD = this.iWj.cCD();
        if (cCD != null) {
            cCD.pullToRefresh();
        }
    }
}
