package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bZL;
    private List<f> dNV;
    private int dNX;
    private b dOg;
    private d dOh;
    private ScrollHorizontalTabView dOm;
    private FoldedGridView dOn;
    private e dOo;
    private a dOp;
    private View dOq;
    private View dOr;
    private boolean dOs;
    private h dOt;
    private b dOu;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bZL = 0;
        this.dNX = 0;
        this.dOs = false;
        this.dOg = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.no(i);
                }
                return null;
            }
        };
        this.dOh = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dNV, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZL = 0;
        this.dNX = 0;
        this.dOs = false;
        this.dOg = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.no(i);
                }
                return null;
            }
        };
        this.dOh = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dNV, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZL = 0;
        this.dNX = 0;
        this.dOs = false;
        this.dOg = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.bx(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    ScrollLabelTabHost.this.dOu.by(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.bz(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i2) {
                if (ScrollLabelTabHost.this.dOu != null) {
                    return ScrollLabelTabHost.this.dOu.no(i2);
                }
                return null;
            }
        };
        this.dOh = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i2) {
                return (f) v.f(ScrollLabelTabHost.this.dNV, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.dOp = new a(context, this.dOg, this.dOh);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dOp);
        this.dOm = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dOm.setViewPager(this.mPager);
        this.dOm.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, f fVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, f fVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (fVar != null) {
                    ScrollLabelTabHost.this.bZL = fVar.tabId;
                    if (fVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) fVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dNX = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(fVar)) {
                        ScrollLabelTabHost.this.dOn.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dOn.setVisibility(8);
                    }
                }
            }
        });
        this.dOo = new e(getContext());
        this.dOn = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dOn.bD(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dOn.setNumColumns(5);
        this.dOn.setFoldAdapter(this.dOo);
        this.dOn.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dOn.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void e(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dNX = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    com.baidu.tieba.frs.game.strategy.view.d axU = ScrollLabelTabHost.this.dOp.axU();
                    axU.bE(ScrollLabelTabHost.this.bZL, ScrollLabelTabHost.this.dNX);
                    if (ScrollLabelTabHost.this.dOg != null && !ScrollLabelTabHost.this.dOg.bz(ScrollLabelTabHost.this.bZL, ScrollLabelTabHost.this.dNX)) {
                        axU.sU();
                    }
                }
            }
        });
        this.dOq = findViewById(d.g.frs_game_tab_line);
        this.dOr = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dOp != null) {
            this.dOp.setPageId(bdUniqueId);
        }
    }

    public void h(List<f> list, boolean z) {
        if (!v.E(list)) {
            if (this.dOs || this.dNV == null) {
                this.dOs = z;
                this.dNV = list;
                this.dOp.setCount(this.dNV == null ? 0 : this.dNV.size());
                this.dOm.setData(list);
                if (v.E(list)) {
                    this.dOm.setVisibility(8);
                    this.dOq.setVisibility(8);
                    return;
                }
                this.dOm.setVisibility(0);
                this.dOq.setVisibility(0);
                this.dOm.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dOn.setVisibility(0);
                    this.dOr.setVisibility(0);
                    return;
                }
                this.dOn.setVisibility(8);
                this.dOr.setVisibility(8);
            }
        }
    }

    public boolean a(f fVar) {
        if (fVar == null || !(fVar.extra instanceof LabelDataList)) {
            return false;
        }
        LabelDataList labelDataList = (LabelDataList) fVar.extra;
        if (labelDataList.isEmpty()) {
            return false;
        }
        this.dOo.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<i> list, List<f> list2, boolean z, boolean z2, int i3) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOp.bC(i, i2);
        if (bC != null) {
            bC.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                ns(i3);
            }
        }
    }

    public void ns(int i) {
        if (this.dOt != null && this.dOt.isShowing()) {
            this.dOt.aww();
        }
        this.dOt = new h(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView ayd = this.dOt.ayd();
        if (i == 0) {
            ayd.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            ayd.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(ayd, layoutParams);
        this.dOt.aye();
    }

    public void f(int i, int i2, String str) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOp.bC(i, i2);
        if (bC != null) {
            bC.e(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(b bVar) {
        this.dOu = bVar;
    }

    public void onChangeSkinType(int i) {
        this.dOm.onChangeSkinType(i);
        this.dOn.onChangeSkinType(i);
        this.dOp.onChangeSkinType(i);
        aj.t(this.dOq, d.C0141d.cp_bg_line_b);
        aj.t(this.dOr, d.C0141d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dOt != null) {
            this.dOt.aww();
        }
        this.dOp.onDestory();
    }

    public com.baidu.tieba.frs.game.strategy.view.d getCurrentPageView() {
        return this.dOp.axU();
    }

    public void XL() {
        com.baidu.tieba.frs.game.strategy.view.d axU = this.dOp.axU();
        if (axU != null) {
            axU.sU();
        }
    }
}
