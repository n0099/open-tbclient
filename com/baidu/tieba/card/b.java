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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout aXJ;
    protected TextView aXK;
    public TextView aXL;
    public TextView aXM;
    private View aXN;
    private View aXO;
    private View aXP;
    public ImageView aXQ;
    public LinearLayout aXR;
    public View aXS;
    public View aXT;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aXJ = null;
        this.aXK = null;
        this.aXL = null;
        this.aXM = null;
        this.aXN = null;
        this.aXO = null;
        this.aXP = null;
        this.aXR = null;
        R(getView());
    }

    private void R(View view) {
        this.aXJ = (RelativeLayout) view.findViewById(t.g.item_layout_group_title);
        this.aXK = (TextView) view.findViewById(t.g.item_group_title);
        this.aXL = (TextView) view.findViewById(t.g.item_right_tv);
        this.aXM = (TextView) view.findViewById(t.g.item_bottom_more_tv);
        this.aXN = view.findViewById(t.g.divider_line_top);
        this.aXO = view.findViewById(t.g.divider_line_middle);
        this.aXP = view.findViewById(t.g.divider_line_bottom);
        this.aXR = (LinearLayout) view.findViewById(t.g.card_container);
        this.aXS = view.findViewById(t.g.divider_card);
        this.aXT = view.findViewById(t.g.divider_card_top);
        this.aXQ = (ImageView) view.findViewById(t.g.item_right_arrow);
    }

    private void Nr() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.av.c(this.aXK, t.d.cp_cont_d, 1);
            this.aXQ.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aXK, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(this.aXQ, t.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.av.c(this.aXL, t.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.av.c(this.aXM, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.av.l(getView(), t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.aXN, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aXO, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aXP, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aXS, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aXT, t.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Nr();
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
        this.aXK.setText(t.bbo);
        if (t.bbp > 0) {
            this.aXL.setBackgroundResource(t.bbp);
        }
        if (t.bbs) {
            this.aXT.setVisibility(0);
        } else {
            this.aXT.setVisibility(8);
        }
        if (!StringUtils.isNull(t.bbq)) {
            this.aXM.setVisibility(0);
            this.aXP.setVisibility(0);
            this.aXO.setVisibility(0);
            this.aXM.setText(t.bbq);
            String str = t.bbr;
            if (!StringUtils.isNull(str)) {
                this.aXM.setTag(str);
                this.aXM.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aXM.setVisibility(8);
        this.aXP.setVisibility(8);
        this.aXO.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aXM == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bi.vx().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return t.h.card_group;
    }

    public void gb(int i) {
        if (this.aXN != null && this.aXN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aXN.getLayoutParams();
            layoutParams.height = i;
            this.aXN.setLayoutParams(layoutParams);
        }
        if (this.aXO != null && this.aXO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aXO.getLayoutParams();
            layoutParams2.height = i;
            this.aXO.setLayoutParams(layoutParams2);
        }
        if (this.aXP != null && this.aXP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aXP.getLayoutParams();
            layoutParams3.height = i;
            this.aXP.setLayoutParams(layoutParams3);
        }
    }

    public void cq(boolean z) {
        if (this.aXS != null) {
            this.aXS.setVisibility(z ? 0 : 8);
        }
    }
}
