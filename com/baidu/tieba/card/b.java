package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout btL;
    protected TextView btM;
    public TextView btN;
    public TextView btO;
    private View btP;
    private View btQ;
    private View btR;
    public ImageView btS;
    public LinearLayout btT;
    public View btU;
    public View btV;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btL = null;
        this.btM = null;
        this.btN = null;
        this.btO = null;
        this.btP = null;
        this.btQ = null;
        this.btR = null;
        this.btT = null;
        O(getView());
    }

    private void O(View view) {
        this.btL = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.btM = (TextView) view.findViewById(w.h.item_group_title);
        this.btN = (TextView) view.findViewById(w.h.item_right_tv);
        this.btO = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.btP = view.findViewById(w.h.divider_line_top);
        this.btQ = view.findViewById(w.h.divider_line_middle);
        this.btR = view.findViewById(w.h.divider_line_bottom);
        this.btT = (LinearLayout) view.findViewById(w.h.card_container);
        this.btU = view.findViewById(w.h.divider_card);
        this.btV = view.findViewById(w.h.divider_card_top);
        this.btS = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void Tb() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.aq.c(this.btM, w.e.cp_cont_d, 1);
            this.btS.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.btM, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.aq.c(this.btS, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.aq.c(this.btN, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.aq.c(this.btO, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.btP, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btQ, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btR, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btU, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btV, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Tb();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.btM.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.btN.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.btV.setVisibility(0);
        } else {
            this.btV.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.btU.setVisibility(0);
        } else {
            this.btU.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.btO.setVisibility(0);
            this.btR.setVisibility(0);
            this.btQ.setVisibility(0);
            this.btO.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.btO.setTag(str);
                this.btO.setOnClickListener(this);
                return;
            }
            return;
        }
        this.btO.setVisibility(8);
        this.btR.setVisibility(8);
        this.btQ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.btO == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bb.vB().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void gK(int i) {
        if (this.btP != null && this.btP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.btP.getLayoutParams();
            layoutParams.height = i;
            this.btP.setLayoutParams(layoutParams);
        }
        if (this.btQ != null && this.btQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.btQ.getLayoutParams();
            layoutParams2.height = i;
            this.btQ.setLayoutParams(layoutParams2);
        }
        if (this.btR != null && this.btR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.btR.getLayoutParams();
            layoutParams3.height = i;
            this.btR.setLayoutParams(layoutParams3);
        }
    }

    public void cZ(boolean z) {
        if (this.btU != null) {
            this.btU.setVisibility(z ? 0 : 8);
        }
    }
}
