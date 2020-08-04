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
    private ScrollHorizontalTabView hTD;
    private FoldedGridView hTE;
    private d hTF;
    private CustomViewPager hTG;
    private FrsGameTabPagerAdapter hTH;
    private View hTI;
    private View hTJ;
    private boolean hTK;
    private g hTL;
    private a hTM;
    private List<e> hTm;
    private int hTo;
    private int hTp;
    private a hTx;
    private c hTy;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.hTo = 0;
        this.hTp = 0;
        this.hTK = false;
        this.hTx = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cc(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cd(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.ce(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.vy(i);
                }
                return null;
            }
        };
        this.hTy = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTm, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTo = 0;
        this.hTp = 0;
        this.hTK = false;
        this.hTx = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cc(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cd(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i, int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.ce(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.vy(i);
                }
                return null;
            }
        };
        this.hTy = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTm, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTo = 0;
        this.hTp = 0;
        this.hTK = false;
        this.hTx = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cc(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cc(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cd(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    ScrollLabelTabHost.this.hTM.cd(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ce(int i2, int i22) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.ce(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e vy(int i2) {
                if (ScrollLabelTabHost.this.hTM != null) {
                    return ScrollLabelTabHost.this.hTM.vy(i2);
                }
                return null;
            }
        };
        this.hTy = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e vB(int i2) {
                return (e) x.getItem(ScrollLabelTabHost.this.hTm, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.hTH = new FrsGameTabPagerAdapter(context, this.hTx, this.hTy);
        this.hTG = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.hTG.setAdapter(this.hTH);
        this.hTD = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.hTD.setViewPager(this.hTG);
        this.hTD.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.hTo = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.hTp = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.hTE.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.hTE.setVisibility(8);
                    }
                }
            }
        });
        this.hTF = new d(getContext());
        this.hTE = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.hTE.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.hTE.setNumColumns(5);
        this.hTE.setFoldAdapter(this.hTF);
        this.hTE.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.hTE.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.hTp = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cfF = ScrollLabelTabHost.this.hTH.cfF();
                    cfF.ci(ScrollLabelTabHost.this.hTo, ScrollLabelTabHost.this.hTp);
                    if (ScrollLabelTabHost.this.hTx != null && !ScrollLabelTabHost.this.hTx.ce(ScrollLabelTabHost.this.hTo, ScrollLabelTabHost.this.hTp)) {
                        cfF.pullToRefresh();
                    }
                }
            }
        });
        this.hTI = findViewById(R.id.frs_game_tab_line);
        this.hTJ = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hTH != null) {
            this.hTH.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (this.hTK || this.hTm == null) {
                this.hTK = z;
                this.hTm = list;
                this.hTH.setCount(this.hTm == null ? 0 : this.hTm.size());
                this.hTD.setData(list);
                if (x.isEmpty(list)) {
                    this.hTD.setVisibility(8);
                    this.hTI.setVisibility(8);
                    return;
                }
                this.hTD.setVisibility(0);
                this.hTI.setVisibility(0);
                this.hTD.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.hTE.setVisibility(0);
                    this.hTJ.setVisibility(0);
                    return;
                }
                this.hTE.setVisibility(8);
                this.hTJ.setVisibility(8);
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
        this.hTF.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView ch = this.hTH.ch(i, i2);
        if (ch != null) {
            ch.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                vC(i3);
            }
        }
    }

    public void vC(int i) {
        if (this.hTL != null && this.hTL.isShowing()) {
            this.hTL.cdN();
        }
        this.hTL = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cfO = this.hTL.cfO();
        if (i == 0) {
            cfO.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cfO.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cfO, layoutParams);
        this.hTL.cfP();
    }

    public void l(int i, int i2, String str) {
        FrsGameStrategyItemListView ch = this.hTH.ch(i, i2);
        if (ch != null) {
            ch.k(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.hTM = aVar;
    }

    public void onChangeSkinType(int i) {
        this.hTD.onChangeSkinType(i);
        this.hTE.onChangeSkinType(i);
        this.hTH.onChangeSkinType(i);
        ao.setBackgroundColor(this.hTI, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.hTJ, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.hTL != null) {
            this.hTL.cdN();
        }
        this.hTH.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.hTH.cfF();
    }

    public void bxR() {
        FrsGameStrategyItemListView cfF = this.hTH.cfF();
        if (cfF != null) {
            cfF.pullToRefresh();
        }
    }
}
