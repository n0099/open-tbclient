package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.card.a.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.a.a> extends a<T> {
    protected RelativeLayout aNm;
    protected TextView aNn;
    public TextView aNo;
    public TextView aNp;
    private View aNq;
    private View aNr;
    private View aNs;
    public ImageView aNt;
    public LinearLayout aNu;
    public View aNv;
    public View aNw;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aNm = null;
        this.aNn = null;
        this.aNo = null;
        this.aNp = null;
        this.aNq = null;
        this.aNr = null;
        this.aNs = null;
        this.aNu = null;
        j(getView());
    }

    private void j(View view) {
        this.aNm = (RelativeLayout) view.findViewById(n.g.item_layout_group_title);
        this.aNn = (TextView) view.findViewById(n.g.item_group_title);
        this.aNo = (TextView) view.findViewById(n.g.item_right_tv);
        this.aNp = (TextView) view.findViewById(n.g.item_bottom_more_tv);
        this.aNq = view.findViewById(n.g.divider_line_top);
        this.aNr = view.findViewById(n.g.divider_line_middle);
        this.aNs = view.findViewById(n.g.divider_line_bottom);
        this.aNu = (LinearLayout) view.findViewById(n.g.card_container);
        this.aNv = view.findViewById(n.g.divider_card);
        this.aNw = view.findViewById(n.g.divider_card_top);
        this.aNt = (ImageView) view.findViewById(n.g.item_right_arrow);
    }

    private void Ih() {
        if (getFrom() != null && getFrom().equals("home")) {
            as.b(this.aNn, n.d.cp_cont_d, 1);
            this.aNt.setVisibility(8);
        } else {
            as.b(this.aNn, n.d.cp_cont_f, 1);
            as.c(this.aNt, n.f.icon_arrow_tab);
        }
        as.b(this.aNo, n.d.cp_link_tip_c, 1);
        as.b(this.aNp, n.d.cp_cont_d, 1);
        as.j(getView(), n.d.cp_bg_line_d);
        as.j(this.aNq, n.d.cp_bg_line_c);
        as.j(this.aNr, n.d.cp_bg_line_c);
        as.j(this.aNs, n.d.cp_bg_line_c);
        as.j(this.aNv, n.d.cp_bg_line_c);
        as.j(this.aNw, n.d.cp_bg_line_c);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Ih();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aNn.setText(t.aPH);
        if (t.aPI > 0) {
            this.aNo.setBackgroundResource(t.aPI);
        }
        if (t.aPL) {
            this.aNw.setVisibility(0);
        } else {
            this.aNw.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aPJ)) {
            this.aNp.setVisibility(0);
            this.aNs.setVisibility(0);
            this.aNr.setVisibility(0);
            this.aNp.setText(t.aPJ);
            String str = t.aPK;
            if (!StringUtils.isNull(str)) {
                this.aNp.setTag(str);
                this.aNp.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aNp.setVisibility(8);
        this.aNs.setVisibility(8);
        this.aNr.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aNp == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.vn().b(Ie(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int Ig() {
        return n.h.card_group;
    }
}
