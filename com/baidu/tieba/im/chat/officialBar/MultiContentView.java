package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout Hl;
    private int UC;
    private View aGj;
    private com.baidu.adp.lib.c.b aOZ;
    private com.baidu.adp.lib.e.b<f> aQX;
    private com.baidu.adp.lib.e.b<c> aQY;
    private com.baidu.adp.lib.e.b<ba> aQZ;
    private boolean aRa;
    private String aRb;
    private Context mContext;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.aOZ = null;
        this.aRa = true;
        this.mType = 2;
        this.mContext = context;
        nu();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOZ = null;
        this.aRa = true;
        this.mType = 2;
        this.mContext = context;
        nu();
    }

    private void nu() {
        this.aGj = View.inflate(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_content_view, this);
        this.Hl = (LinearLayout) this.aGj.findViewById(com.baidu.tieba.v.view_container);
        this.aQX = i.Kq().Z(this.mContext);
        this.aQY = i.Kq().aa(this.mContext);
        this.aQZ = i.Kq().ab(this.mContext);
        this.Hl.setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.Hl.addView(view);
    }

    public void a(List<p> list, View view) {
        this.Hl.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            if (size == 1) {
                a(list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    a(list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    a(list.get(i), getBottomView(), view);
                } else {
                    a(list.get(i), getMidView(), view);
                }
            }
        }
    }

    private f getTopView() {
        f fVar = null;
        if (this.aQX != null) {
            fVar = this.aQX.ed();
        }
        if (fVar == null || fVar.getParent() != null) {
            fVar = new f(this.mContext);
        }
        fVar.setOnItemViewLongClickListener(this.aOZ);
        fVar.setPosition(this.UC);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType == 1 && !this.aRa) {
            skinType = 0;
        }
        if (this.mType == 2) {
            com.baidu.tbadk.core.util.aw.c(fVar, com.baidu.tieba.u.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            com.baidu.tbadk.core.util.aw.c(fVar, com.baidu.tieba.u.selector_msg_multi_top_bg, skinType);
        }
        fVar.cG(false);
        return fVar;
    }

    private void a(p pVar, f fVar, View view) {
        if (pVar != null && fVar != null) {
            fVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            fVar.setTime(this.aRb);
            fVar.a(pVar, view);
            this.Hl.addView(fVar);
        }
    }

    private c getCommonBottomView() {
        c cVar = null;
        if (this.aQY != null) {
            cVar = this.aQY.ed();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new c(this.mContext);
        }
        cVar.setOnItemViewLongClickListener(this.aOZ);
        cVar.setPosition(this.UC);
        return cVar;
    }

    private c getMidView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType == 1 && !this.aRa) {
            skinType = 0;
        }
        if (this.mType == 2) {
            com.baidu.tbadk.core.util.aw.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            com.baidu.tbadk.core.util.aw.c(commonBottomView, com.baidu.tieba.u.selector_msg_multi_mid_bg, skinType);
        }
        commonBottomView.cG(false);
        return commonBottomView;
    }

    private c getBottomView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType == 1 && !this.aRa) {
            skinType = 0;
        }
        if (this.mType == 2) {
            com.baidu.tbadk.core.util.aw.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            com.baidu.tbadk.core.util.aw.c(commonBottomView, com.baidu.tieba.u.selector_msg_multi_bottom_bg, skinType);
        }
        commonBottomView.cG(false);
        return commonBottomView;
    }

    private void a(p pVar, c cVar, View view) {
        if (pVar != null && cVar != null) {
            cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_bottom_height)));
            cVar.a(pVar, view);
            this.Hl.addView(cVar);
        }
    }

    private ba getSingleView() {
        ba baVar = null;
        if (this.aQZ != null) {
            baVar = this.aQZ.ed();
        }
        if (baVar == null || baVar.getParent() == null) {
            baVar = new ba(this.mContext);
        }
        baVar.setOnItemViewLongClickListener(this.aOZ);
        baVar.setPosition(this.UC);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType == 1 && !this.aRa) {
            skinType = 0;
        }
        if (this.mType == 2) {
            com.baidu.tbadk.core.util.aw.c(baVar, com.baidu.tieba.u.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            com.baidu.tbadk.core.util.aw.c(baVar, com.baidu.tieba.u.selector_msg_multi_single_bg, skinType);
        }
        baVar.cG(false);
        return baVar;
    }

    private void a(p pVar, ba baVar, View view) {
        if (pVar != null && baVar != null) {
            baVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            baVar.setTime(this.aRb);
            baVar.a(pVar, view);
            this.Hl.addView(baVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    public void setPosition(int i) {
        this.UC = i;
    }

    public void setNeedNightMode(boolean z) {
        this.aRa = z;
    }

    public void setTime(String str) {
        this.aRb = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
