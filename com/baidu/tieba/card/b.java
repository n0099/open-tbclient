package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cwk;
    protected TextView cwl;
    public TextView cwm;
    public TextView cwn;
    private View cwo;
    private View cwp;
    private View cwq;
    public ImageView cwr;
    public LinearLayout cws;
    public View cwt;
    public View cwu;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cwk = null;
        this.cwl = null;
        this.cwm = null;
        this.cwn = null;
        this.cwo = null;
        this.cwp = null;
        this.cwq = null;
        this.cws = null;
        Y(getView());
    }

    private void Y(View view) {
        this.cwk = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cwl = (TextView) view.findViewById(d.g.item_group_title);
        this.cwm = (TextView) view.findViewById(d.g.item_right_tv);
        this.cwn = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cwo = view.findViewById(d.g.divider_line_top);
        this.cwp = view.findViewById(d.g.divider_line_middle);
        this.cwq = view.findViewById(d.g.divider_line_bottom);
        this.cws = (LinearLayout) view.findViewById(d.g.card_container);
        this.cwt = view.findViewById(d.g.divider_card);
        this.cwu = view.findViewById(d.g.divider_card_top);
        this.cwr = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aiA() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.c(this.cwl, d.C0140d.cp_cont_d, 1);
            this.cwr.setVisibility(8);
        } else {
            am.c(this.cwl, d.C0140d.cp_cont_f, 1);
            am.c(this.cwr, d.f.icon_arrow_tab);
        }
        am.c(this.cwm, d.C0140d.cp_link_tip_c, 1);
        am.c(this.cwn, d.C0140d.cp_cont_d, 1);
        am.j(getView(), d.C0140d.cp_bg_line_d);
        am.j(this.cwo, d.C0140d.cp_bg_line_c);
        am.j(this.cwp, d.C0140d.cp_bg_line_c);
        am.j(this.cwq, d.C0140d.cp_bg_line_c);
        am.j(this.cwt, d.C0140d.cp_bg_line_c);
        am.j(this.cwu, d.C0140d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aiA();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cwl.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cwm.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cwu.setVisibility(0);
        } else {
            this.cwu.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cwt.setVisibility(0);
        } else {
            this.cwt.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cwn.setVisibility(0);
            this.cwq.setVisibility(0);
            this.cwp.setVisibility(0);
            this.cwn.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cwn.setTag(str);
                this.cwn.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cwn.setVisibility(8);
        this.cwq.setVisibility(8);
        this.cwp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwn == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.zK().c(aiy(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void iP(int i) {
        if (this.cwo != null && this.cwo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cwo.getLayoutParams();
            layoutParams.height = i;
            this.cwo.setLayoutParams(layoutParams);
        }
        if (this.cwp != null && this.cwp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cwp.getLayoutParams();
            layoutParams2.height = i;
            this.cwp.setLayoutParams(layoutParams2);
        }
        if (this.cwq != null && this.cwq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cwq.getLayoutParams();
            layoutParams3.height = i;
            this.cwq.setLayoutParams(layoutParams3);
        }
    }

    public void er(boolean z) {
        if (this.cwt != null) {
            this.cwt.setVisibility(z ? 0 : 8);
        }
    }
}
