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
    private int jzA;
    private a jzI;
    private c jzJ;
    private ScrollHorizontalTabView jzO;
    private FoldedGridView jzP;
    private d jzQ;
    private CustomViewPager jzR;
    private FrsGameTabPagerAdapter jzS;
    private View jzT;
    private View jzU;
    private boolean jzV;
    private f jzW;
    private a jzX;
    private List<e> jzx;
    private int jzz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jzz = 0;
        this.jzA = 0;
        this.jzV = false;
        this.jzI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zF(int i) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.zF(i);
                }
                return null;
            }
        };
        this.jzJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zI(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jzx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jzz = 0;
        this.jzA = 0;
        this.jzV = false;
        this.jzI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zF(int i) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.zF(i);
                }
                return null;
            }
        };
        this.jzJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zI(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jzx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jzz = 0;
        this.jzA = 0;
        this.jzV = false;
        this.jzI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cr(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i2, int i22) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    ScrollLabelTabHost.this.jzX.cs(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.ct(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zF(int i2) {
                if (ScrollLabelTabHost.this.jzX != null) {
                    return ScrollLabelTabHost.this.jzX.zF(i2);
                }
                return null;
            }
        };
        this.jzJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zI(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.jzx, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jzS = new FrsGameTabPagerAdapter(context, this.jzI, this.jzJ);
        this.jzR = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jzR.setAdapter(this.jzS);
        this.jzO = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jzO.setViewPager(this.jzR);
        this.jzO.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jzz = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jzA = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jzP.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jzP.setVisibility(8);
                    }
                }
            }
        });
        this.jzQ = new d(getContext());
        this.jzP = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jzP.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jzP.setNumColumns(5);
        this.jzP.setFoldAdapter(this.jzQ);
        this.jzP.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jzP.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jzA = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cIc = ScrollLabelTabHost.this.jzS.cIc();
                    cIc.cx(ScrollLabelTabHost.this.jzz, ScrollLabelTabHost.this.jzA);
                    if (ScrollLabelTabHost.this.jzI != null && !ScrollLabelTabHost.this.jzI.ct(ScrollLabelTabHost.this.jzz, ScrollLabelTabHost.this.jzA)) {
                        cIc.pullToRefresh();
                    }
                }
            }
        });
        this.jzT = findViewById(R.id.frs_game_tab_line);
        this.jzU = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jzS != null) {
            this.jzS.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.jzV || this.jzx == null) {
                this.jzV = z;
                this.jzx = list;
                this.jzS.setCount(this.jzx == null ? 0 : this.jzx.size());
                this.jzO.setData(list);
                if (y.isEmpty(list)) {
                    this.jzO.setVisibility(8);
                    this.jzT.setVisibility(8);
                    return;
                }
                this.jzO.setVisibility(0);
                this.jzT.setVisibility(0);
                this.jzO.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jzP.setVisibility(0);
                    this.jzU.setVisibility(0);
                    return;
                }
                this.jzP.setVisibility(8);
                this.jzU.setVisibility(8);
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
        this.jzQ.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cw = this.jzS.cw(i, i2);
        if (cw != null) {
            cw.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zJ(i3);
            }
        }
    }

    public void zJ(int i) {
        if (this.jzW != null && this.jzW.isShowing()) {
            this.jzW.cFd();
        }
        this.jzW = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cIl = this.jzW.cIl();
        if (i == 0) {
            cIl.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cIl.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cIl, layoutParams);
        this.jzW.cIm();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cw = this.jzS.cw(i, i2);
        if (cw != null) {
            cw.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jzX = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jzO.onChangeSkinType(i);
        this.jzP.onChangeSkinType(i);
        this.jzS.onChangeSkinType(i);
        ap.setBackgroundColor(this.jzT, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jzU, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jzW != null) {
            this.jzW.cFd();
        }
        this.jzS.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jzS.cIc();
    }

    public void bSD() {
        FrsGameStrategyItemListView cIc = this.jzS.cIc();
        if (cIc != null) {
            cIc.pullToRefresh();
        }
    }
}
