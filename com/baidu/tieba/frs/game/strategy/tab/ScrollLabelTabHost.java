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
/* loaded from: classes21.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> iWA;
    private int iWC;
    private int iWD;
    private a iWL;
    private c iWM;
    private ScrollHorizontalTabView iWR;
    private FoldedGridView iWS;
    private d iWT;
    private CustomViewPager iWU;
    private FrsGameTabPagerAdapter iWV;
    private View iWW;
    private View iWX;
    private boolean iWY;
    private g iWZ;
    private a iXa;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.iWC = 0;
        this.iWD = 0;
        this.iWY = false;
        this.iWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Aa(int i) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.Aa(i);
                }
                return null;
            }
        };
        this.iWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Ad(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iWA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iWC = 0;
        this.iWD = 0;
        this.iWY = false;
        this.iWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Aa(int i) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.Aa(i);
                }
                return null;
            }
        };
        this.iWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Ad(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.iWA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iWC = 0;
        this.iWD = 0;
        this.iWY = false;
        this.iWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cr(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i2, int i22) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    ScrollLabelTabHost.this.iXa.cs(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.ct(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e Aa(int i2) {
                if (ScrollLabelTabHost.this.iXa != null) {
                    return ScrollLabelTabHost.this.iXa.Aa(i2);
                }
                return null;
            }
        };
        this.iWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e Ad(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.iWA, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.iWV = new FrsGameTabPagerAdapter(context, this.iWL, this.iWM);
        this.iWU = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.iWU.setAdapter(this.iWV);
        this.iWR = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.iWR.setViewPager(this.iWU);
        this.iWR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.iWC = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.iWD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.iWS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.iWS.setVisibility(8);
                    }
                }
            }
        });
        this.iWT = new d(getContext());
        this.iWS = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.iWS.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.iWS.setNumColumns(5);
        this.iWS.setFoldAdapter(this.iWT);
        this.iWS.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.iWS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.iWD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cCh = ScrollLabelTabHost.this.iWV.cCh();
                    cCh.cx(ScrollLabelTabHost.this.iWC, ScrollLabelTabHost.this.iWD);
                    if (ScrollLabelTabHost.this.iWL != null && !ScrollLabelTabHost.this.iWL.ct(ScrollLabelTabHost.this.iWC, ScrollLabelTabHost.this.iWD)) {
                        cCh.pullToRefresh();
                    }
                }
            }
        });
        this.iWW = findViewById(R.id.frs_game_tab_line);
        this.iWX = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iWV != null) {
            this.iWV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.iWY || this.iWA == null) {
                this.iWY = z;
                this.iWA = list;
                this.iWV.setCount(this.iWA == null ? 0 : this.iWA.size());
                this.iWR.setData(list);
                if (y.isEmpty(list)) {
                    this.iWR.setVisibility(8);
                    this.iWW.setVisibility(8);
                    return;
                }
                this.iWR.setVisibility(0);
                this.iWW.setVisibility(0);
                this.iWR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.iWS.setVisibility(0);
                    this.iWX.setVisibility(0);
                    return;
                }
                this.iWS.setVisibility(8);
                this.iWX.setVisibility(8);
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
        this.iWT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cw = this.iWV.cw(i, i2);
        if (cw != null) {
            cw.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                Ae(i3);
            }
        }
    }

    public void Ae(int i) {
        if (this.iWZ != null && this.iWZ.isShowing()) {
            this.iWZ.cAj();
        }
        this.iWZ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cCq = this.iWZ.cCq();
        if (i == 0) {
            cCq.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cCq.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cCq, layoutParams);
        this.iWZ.cCr();
    }

    public void m(int i, int i2, String str) {
        FrsGameStrategyItemListView cw = this.iWV.cw(i, i2);
        if (cw != null) {
            cw.l(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.iXa = aVar;
    }

    public void onChangeSkinType(int i) {
        this.iWR.onChangeSkinType(i);
        this.iWS.onChangeSkinType(i);
        this.iWV.onChangeSkinType(i);
        ap.setBackgroundColor(this.iWW, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iWX, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.iWZ != null) {
            this.iWZ.cAj();
        }
        this.iWV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.iWV.cCh();
    }

    public void bPo() {
        FrsGameStrategyItemListView cCh = this.iWV.cCh();
        if (cCh != null) {
            cCh.pullToRefresh();
        }
    }
}
