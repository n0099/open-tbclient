package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout Mz;
    private View aOl;
    private com.baidu.adp.lib.e.b<f> aTK;
    private com.baidu.adp.lib.e.b<c> aTL;
    private com.baidu.adp.lib.e.b<ar> aTM;
    private boolean aTN;
    private String aTO;
    private Context mContext;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.mItemViewLongClickListener = null;
        this.aTN = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemViewLongClickListener = null;
        this.aTN = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aOl = View.inflate(this.mContext, com.baidu.tieba.x.msg_multi_pic_text_content_view, this);
        this.Mz = (LinearLayout) this.aOl.findViewById(com.baidu.tieba.w.view_container);
        this.aTK = i.KP().an(this.mContext);
        this.aTL = i.KP().ao(this.mContext);
        this.aTM = i.KP().ap(this.mContext);
        this.Mz.setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.Mz.addView(view);
    }

    public void a(TbPageContext<?> tbPageContext, List<p> list, View view) {
        this.Mz.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            String str = "";
            if (size == 1) {
                a(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            com.baidu.tieba.im.data.c cVar = new com.baidu.tieba.im.data.c(list);
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (list.get(i) != null) {
                        str = list.get(i).aTS;
                    }
                    a(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    if (cVar.isShow()) {
                        c midView = getMidView();
                        if (midView != null) {
                            midView.setStPosition(i);
                            midView.setTaskInfo(str);
                        }
                        a(tbPageContext, list.get(i), midView, view);
                        View inflate = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getPageActivity(), com.baidu.tieba.x.office_msg_praise_layout, null);
                        cVar.G(inflate);
                        D(inflate);
                    } else {
                        c bottomView = getBottomView();
                        if (bottomView != null) {
                            bottomView.setStPosition(i);
                            bottomView.setTaskInfo(str);
                        }
                        a(tbPageContext, list.get(i), bottomView, view);
                    }
                } else {
                    c midView2 = getMidView();
                    if (midView2 != null) {
                        midView2.setStPosition(i);
                        midView2.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), midView2, view);
                }
            }
        }
    }

    private void D(View view) {
        if (view != null) {
            bc.c(view, com.baidu.tieba.v.selector_history_multi_bottom_bg, 0);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds70)));
            view.setEnabled(false);
            this.Mz.addView(view);
        }
    }

    private f getTopView() {
        f fVar = null;
        if (this.aTK != null) {
            fVar = this.aTK.ea();
        }
        if (fVar == null || fVar.getParent() != null) {
            fVar = new f(this.mContext);
        }
        fVar.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
        fVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aTN) {
            skinType = 0;
        }
        if (this.mType == 2) {
            bc.c(fVar, com.baidu.tieba.v.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            bc.c(fVar, com.baidu.tieba.v.selector_history_multi_top_bg, skinType);
        }
        fVar.cy(this.aTN);
        return fVar;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, f fVar, View view) {
        if (pVar != null && fVar != null) {
            fVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            fVar.setTime(this.aTO);
            fVar.a(tbPageContext, pVar, view, this.mType);
            this.Mz.addView(fVar);
        }
    }

    private c getCommonBottomView() {
        c cVar = null;
        if (this.aTL != null) {
            cVar = this.aTL.ea();
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
        if (skinType == 1 && !this.aTN) {
            skinType = 0;
        }
        if (this.mType == 2) {
            bc.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            bc.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.cy(this.aTN);
        return commonBottomView;
    }

    private c getBottomView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aTN) {
            skinType = 0;
        }
        if (this.mType == 2) {
            bc.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            bc.c(commonBottomView, com.baidu.tieba.v.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.cy(this.aTN);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, c cVar, View view) {
        if (pVar != null && cVar != null) {
            cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_bottom_height)));
            cVar.a(tbPageContext, pVar, view, this.mType);
            this.Mz.addView(cVar);
        }
    }

    private ar getSingleView() {
        ar arVar = null;
        if (this.aTM != null) {
            arVar = this.aTM.ea();
        }
        if (arVar == null || arVar.getParent() == null) {
            arVar = new ar(this.mContext);
        }
        arVar.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
        arVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !this.aTN) {
            skinType = 0;
        }
        if (this.mType == 2) {
            bc.c(arVar, com.baidu.tieba.v.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            bc.c(arVar, com.baidu.tieba.v.selector_history_multi_single_bg, skinType);
        }
        arVar.cy(this.aTN);
        return arVar;
    }

    private void a(TbPageContext<?> tbPageContext, p pVar, ar arVar, View view) {
        if (pVar != null && arVar != null) {
            arVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            arVar.setTime(this.aTO);
            arVar.a(tbPageContext, pVar, view, this.mType);
            this.Mz.addView(arVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.aTN = z;
    }

    public void setTime(String str) {
        this.aTO = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
