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
    private LinearLayout bct;
    private View ceA;
    private com.baidu.adp.lib.c.b evU;
    private com.baidu.adp.lib.e.b<e> exC;
    private com.baidu.adp.lib.e.b<d> exD;
    private com.baidu.adp.lib.e.b<k> exE;
    private boolean exF;
    private Context mContext;
    private int mPosition;
    private String mTime;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.evU = null;
        this.exF = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evU = null;
        this.exF = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ceA = View.inflate(this.mContext, d.h.msg_multi_pic_text_content_view, this);
        this.bct = (LinearLayout) this.ceA.findViewById(d.g.view_container);
        f fVar = new f();
        this.exC = fVar.bI(this.mContext);
        this.exD = fVar.bJ(this.mContext);
        this.exE = fVar.bK(this.mContext);
        this.bct.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof e) {
                    MultiContentView.this.exC.ar((e) view2);
                } else if (view2 instanceof d) {
                    MultiContentView.this.exD.ar((d) view2);
                } else if (view2 instanceof k) {
                    MultiContentView.this.exE.ar((k) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.bct.addView(view);
    }

    public void a(TbPageContext<?> tbPageContext, List<g.a> list, View view) {
        this.bct.removeAllViews();
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
                        str = list.get(i).exJ;
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
        if (this.exC != null) {
            eVar = this.exC.nk();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new e(this.mContext);
        }
        eVar.setOnItemViewLongClickListener(this.evU);
        eVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exF) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(eVar, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(eVar, d.f.selector_history_multi_top_bg, skinType);
        }
        eVar.hl(this.exF);
        return eVar;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, e eVar, View view) {
        if (aVar != null && eVar != null) {
            eVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            eVar.setTime(this.mTime);
            eVar.a(tbPageContext, aVar, view, this.mType);
            this.bct.addView(eVar);
        }
    }

    private d getCommonBottomView() {
        d dVar = null;
        if (this.exD != null) {
            dVar = this.exD.nk();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new d(this.mContext);
        }
        dVar.setOnItemViewLongClickListener(this.evU);
        dVar.setPosition(this.mPosition);
        return dVar;
    }

    private d getMidView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exF) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.hl(this.exF);
        return commonBottomView;
    }

    private d getBottomView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exF) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.hl(this.exF);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, d dVar, View view) {
        if (aVar != null && dVar != null) {
            dVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            dVar.a(tbPageContext, aVar, view, this.mType);
            this.bct.addView(dVar);
        }
    }

    private k getSingleView() {
        k kVar = null;
        if (this.exE != null) {
            kVar = this.exE.nk();
        }
        if (kVar == null || kVar.getParent() == null) {
            kVar = new k(this.mContext);
        }
        kVar.setOnItemViewLongClickListener(this.evU);
        kVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.exF) {
            skinType = 0;
        }
        if (this.mType == 2) {
            aj.f(kVar, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            aj.f(kVar, d.f.selector_history_multi_single_bg, skinType);
        }
        kVar.hl(this.exF);
        return kVar;
    }

    private void a(TbPageContext<?> tbPageContext, g.a aVar, k kVar, View view) {
        if (aVar != null && kVar != null) {
            kVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            kVar.setTime(this.mTime);
            kVar.a(tbPageContext, aVar, view, this.mType);
            this.bct.addView(kVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evU = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.exF = z;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
