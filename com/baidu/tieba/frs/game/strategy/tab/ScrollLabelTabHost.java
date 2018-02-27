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
    private int bZI;
    private List<f> dNQ;
    private int dNS;
    private b dOb;
    private d dOc;
    private ScrollHorizontalTabView dOh;
    private FoldedGridView dOi;
    private e dOj;
    private a dOk;
    private View dOl;
    private View dOm;
    private boolean dOn;
    private h dOo;
    private b dOp;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bZI = 0;
        this.dNS = 0;
        this.dOn = false;
        this.dOb = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.no(i);
                }
                return null;
            }
        };
        this.dOc = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dNQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZI = 0;
        this.dNS = 0;
        this.dOn = false;
        this.dOb = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.no(i);
                }
                return null;
            }
        };
        this.dOc = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dNQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZI = 0;
        this.dNS = 0;
        this.dOn = false;
        this.dOb = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.bx(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    ScrollLabelTabHost.this.dOp.by(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.bz(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i2) {
                if (ScrollLabelTabHost.this.dOp != null) {
                    return ScrollLabelTabHost.this.dOp.no(i2);
                }
                return null;
            }
        };
        this.dOc = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i2) {
                return (f) v.f(ScrollLabelTabHost.this.dNQ, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.dOk = new a(context, this.dOb, this.dOc);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dOk);
        this.dOh = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dOh.setViewPager(this.mPager);
        this.dOh.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, f fVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, f fVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (fVar != null) {
                    ScrollLabelTabHost.this.bZI = fVar.tabId;
                    if (fVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) fVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dNS = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(fVar)) {
                        ScrollLabelTabHost.this.dOi.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dOi.setVisibility(8);
                    }
                }
            }
        });
        this.dOj = new e(getContext());
        this.dOi = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dOi.bD(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dOi.setNumColumns(5);
        this.dOi.setFoldAdapter(this.dOj);
        this.dOi.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dOi.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void e(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dNS = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    com.baidu.tieba.frs.game.strategy.view.d axS = ScrollLabelTabHost.this.dOk.axS();
                    axS.bE(ScrollLabelTabHost.this.bZI, ScrollLabelTabHost.this.dNS);
                    if (ScrollLabelTabHost.this.dOb != null && !ScrollLabelTabHost.this.dOb.bz(ScrollLabelTabHost.this.bZI, ScrollLabelTabHost.this.dNS)) {
                        axS.sU();
                    }
                }
            }
        });
        this.dOl = findViewById(d.g.frs_game_tab_line);
        this.dOm = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dOk != null) {
            this.dOk.setPageId(bdUniqueId);
        }
    }

    public void h(List<f> list, boolean z) {
        if (!v.E(list)) {
            if (this.dOn || this.dNQ == null) {
                this.dOn = z;
                this.dNQ = list;
                this.dOk.setCount(this.dNQ == null ? 0 : this.dNQ.size());
                this.dOh.setData(list);
                if (v.E(list)) {
                    this.dOh.setVisibility(8);
                    this.dOl.setVisibility(8);
                    return;
                }
                this.dOh.setVisibility(0);
                this.dOl.setVisibility(0);
                this.dOh.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dOi.setVisibility(0);
                    this.dOm.setVisibility(0);
                    return;
                }
                this.dOi.setVisibility(8);
                this.dOm.setVisibility(8);
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
        this.dOj.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<i> list, List<f> list2, boolean z, boolean z2, int i3) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOk.bC(i, i2);
        if (bC != null) {
            bC.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                ns(i3);
            }
        }
    }

    public void ns(int i) {
        if (this.dOo != null && this.dOo.isShowing()) {
            this.dOo.awu();
        }
        this.dOo = new h(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView ayb = this.dOo.ayb();
        if (i == 0) {
            ayb.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            ayb.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(ayb, layoutParams);
        this.dOo.ayc();
    }

    public void f(int i, int i2, String str) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOk.bC(i, i2);
        if (bC != null) {
            bC.e(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(b bVar) {
        this.dOp = bVar;
    }

    public void onChangeSkinType(int i) {
        this.dOh.onChangeSkinType(i);
        this.dOi.onChangeSkinType(i);
        this.dOk.onChangeSkinType(i);
        aj.t(this.dOl, d.C0141d.cp_bg_line_b);
        aj.t(this.dOm, d.C0141d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dOo != null) {
            this.dOo.awu();
        }
        this.dOk.onDestory();
    }

    public com.baidu.tieba.frs.game.strategy.view.d getCurrentPageView() {
        return this.dOk.axS();
    }

    public void XK() {
        com.baidu.tieba.frs.game.strategy.view.d axS = this.dOk.axS();
        if (axS != null) {
            axS.sU();
        }
    }
}
