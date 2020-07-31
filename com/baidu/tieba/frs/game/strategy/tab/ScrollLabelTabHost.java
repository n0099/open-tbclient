package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes16.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private ScrollHorizontalTabView hTB;
    private FoldedGridView hTC;
    private d hTD;
    private CustomViewPager hTE;
    private FrsGameTabPagerAdapter hTF;
    private View hTG;
    private View hTH;
    private boolean hTI;
    private g hTJ;
    private a hTK;
    private List<e> hTk;
    private int hTm;
    private int hTn;
    private a hTv;
    private c hTw;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hTm = 0;
        this.hTn = 0;
        this.hTI = false;
        this.hTv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cc(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cd(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.ce(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.vy(i);
                }
                return null;
            }
        };
        this.hTw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTk, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTm = 0;
        this.hTn = 0;
        this.hTI = false;
        this.hTv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cc(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cd(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i, int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.ce(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.vy(i);
                }
                return null;
            }
        };
        this.hTw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTk, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTm = 0;
        this.hTn = 0;
        this.hTI = false;
        this.hTv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cc(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    ScrollLabelTabHost.this.hTK.cd(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.ce(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i2) {
                if (ScrollLabelTabHost.this.hTK != null) {
                    return ScrollLabelTabHost.this.hTK.vy(i2);
                }
                return null;
            }
        };
        this.hTw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i2) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTk, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hTF = new FrsGameTabPagerAdapter(context, this.hTv, this.hTw);
        this.hTE = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hTE.setAdapter(this.hTF);
        this.hTB = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hTB.setViewPager(this.hTE);
        this.hTB.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hTm = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hTn = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hTC.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hTC.setVisibility(8);
                    }
                }
            }
        });
        this.hTD = new d(getContext());
        this.hTC = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hTC.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hTC.setNumColumns(5);
        this.hTC.setFoldAdapter(this.hTD);
        this.hTC.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hTC.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hTn = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cfF = ScrollLabelTabHost.this.hTF.cfF();
                    cfF.ci(ScrollLabelTabHost.this.hTm, ScrollLabelTabHost.this.hTn);
                    if (ScrollLabelTabHost.this.hTv != null && !ScrollLabelTabHost.this.hTv.ce(ScrollLabelTabHost.this.hTm, ScrollLabelTabHost.this.hTn)) {
                        cfF.pullToRefresh();
                    }
                }
            }
        });
        this.hTG = findViewById(R.id.frs_game_tab_line);
        this.hTH = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hTF != null) {
            this.hTF.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (this.hTI || this.hTk == null) {
                this.hTI = z;
                this.hTk = list;
                this.hTF.setCount(this.hTk == null ? 0 : this.hTk.size());
                this.hTB.setData(list);
                if (x.isEmpty(list)) {
                    this.hTB.setVisibility(8);
                    this.hTG.setVisibility(8);
                    return;
                }
                this.hTB.setVisibility(0);
                this.hTG.setVisibility(0);
                this.hTB.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hTC.setVisibility(0);
                    this.hTH.setVisibility(0);
                    return;
                }
                this.hTC.setVisibility(8);
                this.hTH.setVisibility(8);
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
        this.hTD.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView ch = this.hTF.ch(i, i2);
        if (ch != null) {
            ch.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                vC(i3);
            }
        }
    }

    public void vC(int i) {
        if (this.hTJ != null && this.hTJ.isShowing()) {
            this.hTJ.cdN();
        }
        this.hTJ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cfO = this.hTJ.cfO();
        if (i == 0) {
            cfO.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cfO.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cfO, layoutParams);
        this.hTJ.cfP();
    }

    public void l(int i, int i2, String str) {
        FrsGameStrategyItemListView ch = this.hTF.ch(i, i2);
        if (ch != null) {
            ch.k(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hTK = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hTB.onChangeSkinType(i);
        this.hTC.onChangeSkinType(i);
        this.hTF.onChangeSkinType(i);
        ao.setBackgroundColor(this.hTG, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.hTH, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hTJ != null) {
            this.hTJ.cdN();
        }
        this.hTF.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hTF.cfF();
    }

    public void bxR() {
        FrsGameStrategyItemListView cfF = this.hTF.cfF();
        if (cfF != null) {
            cfF.pullToRefresh();
        }
    }
}
