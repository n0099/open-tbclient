package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.g;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout bcD;
    private View ceJ;
    private com.baidu.adp.lib.c.b evQ;
    private com.baidu.adp.lib.e.b<k> exA;
    private boolean exB;
    private com.baidu.adp.lib.e.b<e> exy;
    private com.baidu.adp.lib.e.b<d> exz;
    private Context mContext;
    private int mPosition;
    private String mTime;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.evQ = null;
        this.exB = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evQ = null;
        this.exB = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ceJ = View.inflate(this.mContext, d.h.msg_multi_pic_text_content_view, this);
        this.bcD = (LinearLayout) this.ceJ.findViewById(d.g.view_container);
        f fVar = new f();
        this.exy = fVar.bI(this.mContext);
        this.exz = fVar.bJ(this.mContext);
        this.exA = fVar.bK(this.mContext);
        this.bcD.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof e) {
                    MultiContentView.this.exy.ar((e) view2);
                } else if (view2 instanceof d) {
                    MultiContentView.this.exz.ar((d) view2);
                } else if (view2 instanceof k) {
                    MultiContentView.this.exA.ar((k) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.bcD.addView(view);
    }

    public void a(TbPageContext<?> tbPageContext, List<g.a> list, View view) {
        this.bcD.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            String str = "";
            if (size == 1) {
                a(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (list.get(i) != null) {
                        str = list.get(i).exF;
                    }
                    a(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    d bottomView = getBottomView();
                    if (bottomView != null) {
                        bottomView.setStPosition(i);
                        bottomView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), bottomView, view);
                } else {
                    d midView = getMidView();
                    if (midView != null) {
                        midView.setStPosition(i);
                        midView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), midView, view);
                }
            }
        }
    }

    private e getTopView() {
        e eVar = null;
        if (this.exy != null) {
            eVar = this.exy.nk();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new e(this.mContext);
        }
        eVar.setOnItemViewLongClickListener(this.evQ);
        eVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exB) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(eVar, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(eVar, d.f.selector_history_multi_top_bg, skinType);
        }
        eVar.hg(this.exB);
        return eVar;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, e eVar, View view) {
        if (aVar != null && eVar != null) {
            eVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            eVar.setTime(this.mTime);
            eVar.a(tbPageContext, aVar, view, this.mType);
            this.bcD.addView(eVar);
        }
    }

    private d getCommonBottomView() {
        d dVar = null;
        if (this.exz != null) {
            dVar = this.exz.nk();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new d(this.mContext);
        }
        dVar.setOnItemViewLongClickListener(this.evQ);
        dVar.setPosition(this.mPosition);
        return dVar;
    }

    private d getMidView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exB) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.hg(this.exB);
        return commonBottomView;
    }

    private d getBottomView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exB) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.hg(this.exB);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, d dVar, View view) {
        if (aVar != null && dVar != null) {
            dVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            dVar.a(tbPageContext, aVar, view, this.mType);
            this.bcD.addView(dVar);
        }
    }

    private k getSingleView() {
        k kVar = null;
        if (this.exA != null) {
            kVar = this.exA.nk();
        }
        if (kVar == null || kVar.getParent() == null) {
            kVar = new k(this.mContext);
        }
        kVar.setOnItemViewLongClickListener(this.evQ);
        kVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exB) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(kVar, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(kVar, d.f.selector_history_multi_single_bg, skinType);
        }
        kVar.hg(this.exB);
        return kVar;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, k kVar, View view) {
        if (aVar != null && kVar != null) {
            kVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            kVar.setTime(this.mTime);
            kVar.a(tbPageContext, aVar, view, this.mType);
            this.bcD.addView(kVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evQ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.exB = z;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
