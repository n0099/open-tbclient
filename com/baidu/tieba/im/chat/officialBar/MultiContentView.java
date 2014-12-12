package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout Mg;
    private View aNd;
    private com.baidu.adp.lib.e.b<f> aSB;
    private com.baidu.adp.lib.e.b<c> aSC;
    private com.baidu.adp.lib.e.b<ar> aSD;
    private boolean aSE;
    private String aSF;
    private Context mContext;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.mItemViewLongClickListener = null;
        this.aSE = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemViewLongClickListener = null;
        this.aSE = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aNd = View.inflate(this.mContext, com.baidu.tieba.x.msg_multi_pic_text_content_view, this);
        this.Mg = (LinearLayout) this.aNd.findViewById(com.baidu.tieba.w.view_container);
        this.aSB = i.Kz().an(this.mContext);
        this.aSC = i.Kz().ao(this.mContext);
        this.aSD = i.Kz().ap(this.mContext);
        this.Mg.setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.Mg.addView(view);
    }

    public void a(TbPageContext<?> tbPageContext, List<p> list, View view) {
        this.Mg.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            if (size == 1) {
                a(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    a(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    a(tbPageContext, list.get(i), getBottomView(), view);
                } else {
                    a(tbPageContext, list.get(i), getMidView(), view);
                }
            }
        }
    }

    private f getTopView() {
        f fVar = null;
        if (this.aSB != null) {
            fVar = this.aSB.ec();
        }
        if (fVar == null || fVar.getParent() != null) {
            fVar = new f(this.mContext);
        }
        fVar.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
        fVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aSE) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ax.c(fVar, com.baidu.tieba.v.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            ax.c(fVar, com.baidu.tieba.v.selector_history_multi_top_bg, skinType);
        }
        fVar.cu(false);
        return fVar;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, f fVar, View view) {
        if (pVar != null && fVar != null) {
            fVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            fVar.setTime(this.aSF);
            fVar.a(tbPageContext, pVar, view, this.mType);
            this.Mg.addView(fVar);
        }
    }

    private c getCommonBottomView() {
        c cVar = null;
        if (this.aSC != null) {
            cVar = this.aSC.ec();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new c(this.mContext);
        }
        cVar.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
        cVar.setPosition(this.mPosition);
        return cVar;
    }

    private c getMidView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aSE) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ax.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            ax.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.cu(false);
        return commonBottomView;
    }

    private c getBottomView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aSE) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ax.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            ax.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.cu(false);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, c cVar, View view) {
        if (pVar != null && cVar != null) {
            cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_bottom_height)));
            cVar.a(tbPageContext, pVar, view, this.mType);
            this.Mg.addView(cVar);
        }
    }

    private ar getSingleView() {
        ar arVar = null;
        if (this.aSD != null) {
            arVar = this.aSD.ec();
        }
        if (arVar == null || arVar.getParent() == null) {
            arVar = new ar(this.mContext);
        }
        arVar.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
        arVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aSE) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ax.c(arVar, com.baidu.tieba.v.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            ax.c(arVar, com.baidu.tieba.v.selector_history_multi_single_bg, skinType);
        }
        arVar.cu(false);
        return arVar;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, ar arVar, View view) {
        if (pVar != null && arVar != null) {
            arVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            arVar.setTime(this.aSF);
            arVar.a(tbPageContext, pVar, view, this.mType);
            this.Mg.addView(arVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.aSE = z;
    }

    public void setTime(String str) {
        this.aSF = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
