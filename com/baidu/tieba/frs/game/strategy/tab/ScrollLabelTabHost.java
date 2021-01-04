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
    private List<e> jwA;
    private int jwC;
    private int jwD;
    private a jwL;
    private c jwM;
    private ScrollHorizontalTabView jwR;
    private FoldedGridView jwS;
    private d jwT;
    private CustomViewPager jwU;
    private FrsGameTabPagerAdapter jwV;
    private View jwW;
    private View jwX;
    private boolean jwY;
    private f jwZ;
    private a jxa;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jwC = 0;
        this.jwD = 0;
        this.jwY = false;
        this.jwL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.ct(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.cu(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.cv(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Ba(int i) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.Ba(i);
                }
                return null;
            }
        };
        this.jwM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Bd(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.jwA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwC = 0;
        this.jwD = 0;
        this.jwY = false;
        this.jwL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.ct(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.cu(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i, int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.cv(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Ba(int i) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.Ba(i);
                }
                return null;
            }
        };
        this.jwM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Bd(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.jwA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwC = 0;
        this.jwD = 0;
        this.jwY = false;
        this.jwL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.ct(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cu(int i2, int i22) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    ScrollLabelTabHost.this.jxa.cu(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cv(int i2, int i22) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.cv(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Ba(int i2) {
                if (ScrollLabelTabHost.this.jxa != null) {
                    return ScrollLabelTabHost.this.jxa.Ba(i2);
                }
                return null;
            }
        };
        this.jwM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Bd(int i2) {
                return (e) x.getItem(ScrollLabelTabHost.this.jwA, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jwV = new FrsGameTabPagerAdapter(context, this.jwL, this.jwM);
        this.jwU = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jwU.setAdapter(this.jwV);
        this.jwR = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jwR.setViewPager(this.jwU);
        this.jwR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jwC = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jwD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jwS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jwS.setVisibility(8);
                    }
                }
            }
        });
        this.jwT = new d(getContext());
        this.jwS = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jwS.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jwS.setNumColumns(5);
        this.jwS.setFoldAdapter(this.jwT);
        this.jwS.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jwS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jwD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cKt = ScrollLabelTabHost.this.jwV.cKt();
                    cKt.cz(ScrollLabelTabHost.this.jwC, ScrollLabelTabHost.this.jwD);
                    if (ScrollLabelTabHost.this.jwL != null && !ScrollLabelTabHost.this.jwL.cv(ScrollLabelTabHost.this.jwC, ScrollLabelTabHost.this.jwD)) {
                        cKt.pullToRefresh();
                    }
                }
            }
        });
        this.jwW = findViewById(R.id.frs_game_tab_line);
        this.jwX = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jwV != null) {
            this.jwV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (this.jwY || this.jwA == null) {
                this.jwY = z;
                this.jwA = list;
                this.jwV.setCount(this.jwA == null ? 0 : this.jwA.size());
                this.jwR.setData(list);
                if (x.isEmpty(list)) {
                    this.jwR.setVisibility(8);
                    this.jwW.setVisibility(8);
                    return;
                }
                this.jwR.setVisibility(0);
                this.jwW.setVisibility(0);
                this.jwR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jwS.setVisibility(0);
                    this.jwX.setVisibility(0);
                    return;
                }
                this.jwS.setVisibility(8);
                this.jwX.setVisibility(8);
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
        this.jwT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cy = this.jwV.cy(i, i2);
        if (cy != null) {
            cy.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                Be(i3);
            }
        }
    }

    public void Be(int i) {
        if (this.jwZ != null && this.jwZ.isShowing()) {
            this.jwZ.cHv();
        }
        this.jwZ = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cKC = this.jwZ.cKC();
        if (i == 0) {
            cKC.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cKC.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cKC, layoutParams);
        this.jwZ.cKD();
    }

    public void o(int i, int i2, String str) {
        FrsGameStrategyItemListView cy = this.jwV.cy(i, i2);
        if (cy != null) {
            cy.n(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jxa = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jwR.onChangeSkinType(i);
        this.jwS.onChangeSkinType(i);
        this.jwV.onChangeSkinType(i);
        ao.setBackgroundColor(this.jwW, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jwX, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jwZ != null) {
            this.jwZ.cHv();
        }
        this.jwV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jwV.cKt();
    }

    public void bVE() {
        FrsGameStrategyItemListView cKt = this.jwV.cKt();
        if (cKt != null) {
            cKt.pullToRefresh();
        }
    }
}
