package com.baidu.tieba.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.a.a.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.a.a.a> extends a<T> {
    protected RelativeLayout aLN;
    protected TextView aLO;
    public TextView aLP;
    public TextView aLQ;
    private View aLR;
    private View aLS;
    private View aLT;
    public ImageView aLU;
    public LinearLayout aLV;
    public View aLW;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aLN = null;
        this.aLO = null;
        this.aLP = null;
        this.aLQ = null;
        this.aLR = null;
        this.aLS = null;
        this.aLT = null;
        this.aLV = null;
        j(getView());
    }

    private void j(View view) {
        this.aLN = (RelativeLayout) view.findViewById(n.f.item_layout_group_title);
        this.aLO = (TextView) view.findViewById(n.f.item_group_title);
        this.aLP = (TextView) view.findViewById(n.f.item_right_tv);
        this.aLQ = (TextView) view.findViewById(n.f.item_bottom_more_tv);
        this.aLR = view.findViewById(n.f.divider_line_top);
        this.aLS = view.findViewById(n.f.divider_line_middle);
        this.aLT = view.findViewById(n.f.divider_line_bottom);
        this.aLV = (LinearLayout) view.findViewById(n.f.card_container);
        this.aLW = view.findViewById(n.f.divider_card);
        this.aLU = (ImageView) view.findViewById(n.f.item_right_arrow);
    }

    private void Iq() {
        as.b(this.aLO, n.c.cp_cont_f, 1);
        as.b(this.aLP, n.c.cp_link_tip_c, 1);
        as.b(this.aLQ, n.c.cp_cont_d, 1);
        as.j(getView(), n.c.cp_bg_line_d);
        as.j(this.aLR, n.c.cp_bg_line_c);
        as.j(this.aLS, n.c.cp_bg_line_c);
        as.j(this.aLT, n.c.cp_bg_line_c);
        as.j(this.aLW, n.c.cp_bg_line_c);
        as.c(this.aLU, n.e.icon_arrow_tab);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Iq();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aLO.setText(t.aMH);
        if (t.aMI > 0) {
            this.aLP.setBackgroundResource(t.aMI);
        }
        if (!StringUtils.isNull(t.aMJ)) {
            this.aLQ.setVisibility(0);
            this.aLT.setVisibility(0);
            this.aLS.setVisibility(0);
            this.aLQ.setText(t.aMJ);
            String str = t.aMK;
            if (!StringUtils.isNull(str)) {
                this.aLQ.setTag(str);
                this.aLQ.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aLQ.setVisibility(8);
        this.aLT.setVisibility(8);
        this.aLS.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLQ == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.vD().b(Io(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.a.a
    public final int Ip() {
        return n.g.card_group;
    }
}
