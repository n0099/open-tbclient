package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
    private List<e> jxA;
    private int jxC;
    private int jxD;
    private a jxL;
    private c jxM;
    private ScrollHorizontalTabView jxR;
    private FoldedGridView jxS;
    private d jxT;
    private CustomViewPager jxU;
    private FrsGameTabPagerAdapter jxV;
    private View jxW;
    private View jxX;
    private boolean jxY;
    private f jxZ;
    private a jya;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jxC = 0;
        this.jxD = 0;
        this.jxY = false;
        this.jxL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.cs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.zE(i);
                }
                return null;
            }
        };
        this.jxM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxC = 0;
        this.jxD = 0;
        this.jxY = false;
        this.jxL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.cs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.zE(i);
                }
                return null;
            }
        };
        this.jxM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxA, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxC = 0;
        this.jxD = 0;
        this.jxY = false;
        this.jxL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cq(int i2, int i22) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cq(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.jya != null) {
                    ScrollLabelTabHost.this.jya.cr(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cs(int i2, int i22) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.cs(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i2) {
                if (ScrollLabelTabHost.this.jya != null) {
                    return ScrollLabelTabHost.this.jya.zE(i2);
                }
                return null;
            }
        };
        this.jxM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxA, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jxV = new FrsGameTabPagerAdapter(context, this.jxL, this.jxM);
        this.jxU = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jxU.setAdapter(this.jxV);
        this.jxR = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jxR.setViewPager(this.jxU);
        this.jxR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jxC = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jxD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jxS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jxS.setVisibility(8);
                    }
                }
            }
        });
        this.jxT = new d(getContext());
        this.jxS = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jxS.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jxS.setNumColumns(5);
        this.jxS.setFoldAdapter(this.jxT);
        this.jxS.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jxS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jxD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cHP = ScrollLabelTabHost.this.jxV.cHP();
                    cHP.cw(ScrollLabelTabHost.this.jxC, ScrollLabelTabHost.this.jxD);
                    if (ScrollLabelTabHost.this.jxL != null && !ScrollLabelTabHost.this.jxL.cs(ScrollLabelTabHost.this.jxC, ScrollLabelTabHost.this.jxD)) {
                        cHP.pullToRefresh();
                    }
                }
            }
        });
        this.jxW = findViewById(R.id.frs_game_tab_line);
        this.jxX = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jxV != null) {
            this.jxV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.jxY || this.jxA == null) {
                this.jxY = z;
                this.jxA = list;
                this.jxV.setCount(this.jxA == null ? 0 : this.jxA.size());
                this.jxR.setData(list);
                if (y.isEmpty(list)) {
                    this.jxR.setVisibility(8);
                    this.jxW.setVisibility(8);
                    return;
                }
                this.jxR.setVisibility(0);
                this.jxW.setVisibility(0);
                this.jxR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jxS.setVisibility(0);
                    this.jxX.setVisibility(0);
                    return;
                }
                this.jxS.setVisibility(8);
                this.jxX.setVisibility(8);
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
        this.jxT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cv = this.jxV.cv(i, i2);
        if (cv != null) {
            cv.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zI(i3);
            }
        }
    }

    public void zI(int i) {
        if (this.jxZ != null && this.jxZ.isShowing()) {
            this.jxZ.cEQ();
        }
        this.jxZ = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cHY = this.jxZ.cHY();
        if (i == 0) {
            cHY.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cHY.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cHY, layoutParams);
        this.jxZ.cHZ();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cv = this.jxV.cv(i, i2);
        if (cv != null) {
            cv.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jya = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jxR.onChangeSkinType(i);
        this.jxS.onChangeSkinType(i);
        this.jxV.onChangeSkinType(i);
        ap.setBackgroundColor(this.jxW, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jxX, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jxZ != null) {
            this.jxZ.cEQ();
        }
        this.jxV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jxV.cHP();
    }

    public void bSq() {
        FrsGameStrategyItemListView cHP = this.jxV.cHP();
        if (cHP != null) {
            cHP.pullToRefresh();
        }
    }
}
