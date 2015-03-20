package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout XG;
    private View aVn;
    private com.baidu.adp.lib.c.b aXd;
    private com.baidu.adp.lib.e.b<g> aYr;
    private com.baidu.adp.lib.e.b<d> aYs;
    private com.baidu.adp.lib.e.b<av> aYt;
    private boolean aYu;
    private String aYv;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.aXd = null;
        this.aYu = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXd = null;
        this.aYu = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aVn = View.inflate(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_content_view, this);
        this.XG = (LinearLayout) this.aVn.findViewById(com.baidu.tieba.v.view_container);
        this.aYr = j.NV().ar(this.mContext);
        this.aYs = j.NV().as(this.mContext);
        this.aYt = j.NV().at(this.mContext);
        this.XG.setOnHierarchyChangeListener(new c(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.XG.addView(view);
    }

    public void a(TbPageContext<?> tbPageContext, List<q> list, View view) {
        this.XG.removeAllViews();
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
                        str = list.get(i).aYz;
                    }
                    a(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    if (cVar.isShow()) {
                        d midView = getMidView();
                        if (midView != null) {
                            midView.setStPosition(i);
                            midView.setTaskInfo(str);
                        }
                        a(tbPageContext, list.get(i), midView, view);
                        View inflate = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getPageActivity(), com.baidu.tieba.w.office_msg_praise_layout, null);
                        cVar.E(inflate);
                        B(inflate);
                    } else {
                        d bottomView = getBottomView();
                        if (bottomView != null) {
                            bottomView.setStPosition(i);
                            bottomView.setTaskInfo(str);
                        }
                        a(tbPageContext, list.get(i), bottomView, view);
                    }
                } else {
                    d midView2 = getMidView();
                    if (midView2 != null) {
                        midView2.setStPosition(i);
                        midView2.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), midView2, view);
                }
            }
        }
    }

    private g getTopView() {
        g gVar = null;
        if (this.aYr != null) {
            gVar = this.aYr.hz();
        }
        if (gVar == null || gVar.getParent() != null) {
            gVar = new g(this.mContext);
        }
        gVar.setOnItemViewLongClickListener(this.aXd);
        gVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !this.aYu) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ba.c(gVar, com.baidu.tieba.u.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            ba.c(gVar, com.baidu.tieba.u.selector_history_multi_top_bg, skinType);
        }
        gVar.ct(this.aYu);
        return gVar;
    }

    private void B(View view) {
        if (view != null) {
            ba.c(view, com.baidu.tieba.u.selector_history_multi_bottom_bg, 0);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds70)));
            view.setEnabled(false);
            this.XG.addView(view);
        }
    }

    private void a(TbPageContext<?> tbPageContext, q qVar, g gVar, View view) {
        if (qVar != null && gVar != null) {
            gVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            gVar.setTime(this.aYv);
            gVar.a(tbPageContext, qVar, view, this.mType);
            this.XG.addView(gVar);
        }
    }

    private d getCommonBottomView() {
        d dVar = null;
        if (this.aYs != null) {
            dVar = this.aYs.hz();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new d(this.mContext);
        }
        dVar.setOnItemViewLongClickListener(this.aXd);
        dVar.setPosition(this.mPosition);
        return dVar;
    }

    private d getMidView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !this.aYu) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ba.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            ba.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.ct(this.aYu);
        return commonBottomView;
    }

    private d getBottomView() {
        d commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !this.aYu) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ba.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            ba.c(commonBottomView, com.baidu.tieba.u.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.ct(this.aYu);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, q qVar, d dVar, View view) {
        if (qVar != null && dVar != null) {
            dVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_bottom_height)));
            dVar.a(tbPageContext, qVar, view, this.mType);
            this.XG.addView(dVar);
        }
    }

    private av getSingleView() {
        av avVar = null;
        if (this.aYt != null) {
            avVar = this.aYt.hz();
        }
        if (avVar == null || avVar.getParent() == null) {
            avVar = new av(this.mContext);
        }
        avVar.setOnItemViewLongClickListener(this.aXd);
        avVar.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !this.aYu) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ba.c(avVar, com.baidu.tieba.u.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            ba.c(avVar, com.baidu.tieba.u.selector_history_multi_single_bg, skinType);
        }
        avVar.ct(this.aYu);
        return avVar;
    }

    private void a(TbPageContext<?> tbPageContext, q qVar, av avVar, View view) {
        if (qVar != null && avVar != null) {
            avVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            avVar.setTime(this.aYv);
            avVar.a(tbPageContext, qVar, view, this.mType);
            this.XG.addView(avVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXd = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.aYu = z;
    }

    public void setTime(String str) {
        this.aYv = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
