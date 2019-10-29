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
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private boolean fHA;
    private g fHB;
    private a fHC;
    private List<e> fHc;
    private int fHe;
    private int fHf;
    private a fHn;
    private c fHo;
    private ScrollHorizontalTabView fHt;
    private FoldedGridView fHu;
    private d fHv;
    private CustomViewPager fHw;
    private FrsGameTabPagerAdapter fHx;
    private View fHy;
    private View fHz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.fHe = 0;
        this.fHf = 0;
        this.fHA = false;
        this.fHn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.bs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bt(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.bt(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e ra(int i) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.ra(i);
                }
                return null;
            }
        };
        this.fHo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rd(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.fHc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fHe = 0;
        this.fHf = 0;
        this.fHA = false;
        this.fHn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.bs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bt(int i, int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.bt(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e ra(int i) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.ra(i);
                }
                return null;
            }
        };
        this.fHo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rd(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.fHc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fHe = 0;
        this.fHf = 0;
        this.fHA = false;
        this.fHn = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i2, int i22) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.br(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bs(int i2, int i22) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    ScrollLabelTabHost.this.fHC.bs(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bt(int i2, int i22) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.bt(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e ra(int i2) {
                if (ScrollLabelTabHost.this.fHC != null) {
                    return ScrollLabelTabHost.this.fHC.ra(i2);
                }
                return null;
            }
        };
        this.fHo = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rd(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.fHc, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fHx = new FrsGameTabPagerAdapter(context, this.fHn, this.fHo);
        this.fHw = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.fHw.setAdapter(this.fHx);
        this.fHt = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fHt.setViewPager(this.fHw);
        this.fHt.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.fHe = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fHf = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fHu.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fHu.setVisibility(8);
                    }
                }
            }
        });
        this.fHv = new d(getContext());
        this.fHu = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fHu.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fHu.setNumColumns(5);
        this.fHu.setFoldAdapter(this.fHv);
        this.fHu.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fHu.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fHf = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bnB = ScrollLabelTabHost.this.fHx.bnB();
                    bnB.bx(ScrollLabelTabHost.this.fHe, ScrollLabelTabHost.this.fHf);
                    if (ScrollLabelTabHost.this.fHn != null && !ScrollLabelTabHost.this.fHn.bt(ScrollLabelTabHost.this.fHe, ScrollLabelTabHost.this.fHf)) {
                        bnB.pullToRefresh();
                    }
                }
            }
        });
        this.fHy = findViewById(R.id.frs_game_tab_line);
        this.fHz = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fHx != null) {
            this.fHx.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.fHA || this.fHc == null) {
                this.fHA = z;
                this.fHc = list;
                this.fHx.setCount(this.fHc == null ? 0 : this.fHc.size());
                this.fHt.setData(list);
                if (v.isEmpty(list)) {
                    this.fHt.setVisibility(8);
                    this.fHy.setVisibility(8);
                    return;
                }
                this.fHt.setVisibility(0);
                this.fHy.setVisibility(0);
                this.fHt.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fHu.setVisibility(0);
                    this.fHz.setVisibility(0);
                    return;
                }
                this.fHu.setVisibility(8);
                this.fHz.setVisibility(8);
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
        this.fHv.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bw = this.fHx.bw(i, i2);
        if (bw != null) {
            bw.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                re(i3);
            }
        }
    }

    public void re(int i) {
        if (this.fHB != null && this.fHB.isShowing()) {
            this.fHB.blS();
        }
        this.fHB = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bnK = this.fHB.bnK();
        if (i == 0) {
            bnK.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bnK.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bnK, layoutParams);
        this.fHB.bnL();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bw = this.fHx.bw(i, i2);
        if (bw != null) {
            bw.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fHC = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fHt.onChangeSkinType(i);
        this.fHu.onChangeSkinType(i);
        this.fHx.onChangeSkinType(i);
        am.setBackgroundColor(this.fHy, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHz, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.fHB != null) {
            this.fHB.blS();
        }
        this.fHx.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fHx.bnB();
    }

    public void aKh() {
        FrsGameStrategyItemListView bnB = this.fHx.bnB();
        if (bnB != null) {
            bnB.pullToRefresh();
        }
    }
}
