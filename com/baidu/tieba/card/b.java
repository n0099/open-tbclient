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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout aYn;
    protected TextView aYo;
    public TextView aYp;
    public TextView aYq;
    private View aYr;
    private View aYs;
    private View aYt;
    public ImageView aYu;
    public LinearLayout aYv;
    public View aYw;
    public View aYx;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aYn = null;
        this.aYo = null;
        this.aYp = null;
        this.aYq = null;
        this.aYr = null;
        this.aYs = null;
        this.aYt = null;
        this.aYv = null;
        R(getView());
    }

    private void R(View view) {
        this.aYn = (RelativeLayout) view.findViewById(r.g.item_layout_group_title);
        this.aYo = (TextView) view.findViewById(r.g.item_group_title);
        this.aYp = (TextView) view.findViewById(r.g.item_right_tv);
        this.aYq = (TextView) view.findViewById(r.g.item_bottom_more_tv);
        this.aYr = view.findViewById(r.g.divider_line_top);
        this.aYs = view.findViewById(r.g.divider_line_middle);
        this.aYt = view.findViewById(r.g.divider_line_bottom);
        this.aYv = (LinearLayout) view.findViewById(r.g.card_container);
        this.aYw = view.findViewById(r.g.divider_card);
        this.aYx = view.findViewById(r.g.divider_card_top);
        this.aYu = (ImageView) view.findViewById(r.g.item_right_arrow);
    }

    private void NS() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.av.c(this.aYo, r.d.cp_cont_d, 1);
            this.aYu.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aYo, r.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(this.aYu, r.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.av.c(this.aYp, r.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.av.c(this.aYq, r.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.av.l(getView(), r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.aYr, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aYs, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aYt, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aYw, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aYx, r.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            NS();
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
        this.aYo.setText(t.bbF);
        if (t.bbG > 0) {
            this.aYp.setBackgroundResource(t.bbG);
        }
        if (t.bbJ) {
            this.aYx.setVisibility(0);
        } else {
            this.aYx.setVisibility(8);
        }
        if (t.bbK) {
            this.aYw.setVisibility(0);
        } else {
            this.aYw.setVisibility(8);
        }
        if (!StringUtils.isNull(t.bbH)) {
            this.aYq.setVisibility(0);
            this.aYt.setVisibility(0);
            this.aYs.setVisibility(0);
            this.aYq.setText(t.bbH);
            String str = t.bbI;
            if (!StringUtils.isNull(str)) {
                this.aYq.setTag(str);
                this.aYq.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aYq.setVisibility(8);
        this.aYt.setVisibility(8);
        this.aYs.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aYq == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bh.vL().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return r.h.card_group;
    }

    public void gg(int i) {
        if (this.aYr != null && this.aYr.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aYr.getLayoutParams();
            layoutParams.height = i;
            this.aYr.setLayoutParams(layoutParams);
        }
        if (this.aYs != null && this.aYs.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aYs.getLayoutParams();
            layoutParams2.height = i;
            this.aYs.setLayoutParams(layoutParams2);
        }
        if (this.aYt != null && this.aYt.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aYt.getLayoutParams();
            layoutParams3.height = i;
            this.aYt.setLayoutParams(layoutParams3);
        }
    }

    public void cq(boolean z) {
        if (this.aYw != null) {
            this.aYw.setVisibility(z ? 0 : 8);
        }
    }
}
