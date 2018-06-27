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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout ctH;
    protected TextView ctI;
    public TextView ctJ;
    public TextView ctK;
    private View ctL;
    private View ctM;
    private View ctN;
    public ImageView ctO;
    public LinearLayout ctP;
    public View ctQ;
    public View ctR;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ctH = null;
        this.ctI = null;
        this.ctJ = null;
        this.ctK = null;
        this.ctL = null;
        this.ctM = null;
        this.ctN = null;
        this.ctP = null;
        W(getView());
    }

    private void W(View view) {
        this.ctH = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.ctI = (TextView) view.findViewById(d.g.item_group_title);
        this.ctJ = (TextView) view.findViewById(d.g.item_right_tv);
        this.ctK = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.ctL = view.findViewById(d.g.divider_line_top);
        this.ctM = view.findViewById(d.g.divider_line_middle);
        this.ctN = view.findViewById(d.g.divider_line_bottom);
        this.ctP = (LinearLayout) view.findViewById(d.g.card_container);
        this.ctQ = view.findViewById(d.g.divider_card);
        this.ctR = view.findViewById(d.g.divider_card_top);
        this.ctO = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aib() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.c(this.ctI, d.C0142d.cp_cont_d, 1);
            this.ctO.setVisibility(8);
        } else {
            am.c(this.ctI, d.C0142d.cp_cont_f, 1);
            am.c(this.ctO, d.f.icon_arrow_tab);
        }
        am.c(this.ctJ, d.C0142d.cp_link_tip_c, 1);
        am.c(this.ctK, d.C0142d.cp_cont_d, 1);
        am.j(getView(), d.C0142d.cp_bg_line_d);
        am.j(this.ctL, d.C0142d.cp_bg_line_c);
        am.j(this.ctM, d.C0142d.cp_bg_line_c);
        am.j(this.ctN, d.C0142d.cp_bg_line_c);
        am.j(this.ctQ, d.C0142d.cp_bg_line_c);
        am.j(this.ctR, d.C0142d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aib();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ctI.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.ctJ.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.ctR.setVisibility(0);
        } else {
            this.ctR.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.ctQ.setVisibility(0);
        } else {
            this.ctQ.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.ctK.setVisibility(0);
            this.ctN.setVisibility(0);
            this.ctM.setVisibility(0);
            this.ctK.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.ctK.setTag(str);
                this.ctK.setOnClickListener(this);
                return;
            }
            return;
        }
        this.ctK.setVisibility(8);
        this.ctN.setVisibility(8);
        this.ctM.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ctK == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                az.zV().c(ahZ(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.i.card_group;
    }

    public void iE(int i) {
        if (this.ctL != null && this.ctL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ctL.getLayoutParams();
            layoutParams.height = i;
            this.ctL.setLayoutParams(layoutParams);
        }
        if (this.ctM != null && this.ctM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ctM.getLayoutParams();
            layoutParams2.height = i;
            this.ctM.setLayoutParams(layoutParams2);
        }
        if (this.ctN != null && this.ctN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.ctN.getLayoutParams();
            layoutParams3.height = i;
            this.ctN.setLayoutParams(layoutParams3);
        }
    }

    public void eq(boolean z) {
        if (this.ctQ != null) {
            this.ctQ.setVisibility(z ? 0 : 8);
        }
    }
}
