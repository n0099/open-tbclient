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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public TextView efA;
    public TextView efB;
    private View efC;
    private View efD;
    private View efE;
    public ImageView efF;
    public LinearLayout efG;
    public View efH;
    public View efI;
    protected RelativeLayout efy;
    protected TextView efz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.efy = null;
        this.efz = null;
        this.efA = null;
        this.efB = null;
        this.efC = null;
        this.efD = null;
        this.efE = null;
        this.efG = null;
        O(getView());
    }

    private void O(View view) {
        this.efy = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.efz = (TextView) view.findViewById(d.g.item_group_title);
        this.efA = (TextView) view.findViewById(d.g.item_right_tv);
        this.efB = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.efC = view.findViewById(d.g.divider_line_top);
        this.efD = view.findViewById(d.g.divider_line_middle);
        this.efE = view.findViewById(d.g.divider_line_bottom);
        this.efG = (LinearLayout) view.findViewById(d.g.card_container);
        this.efH = view.findViewById(d.g.divider_card);
        this.efI = view.findViewById(d.g.divider_card_top);
        this.efF = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aQj() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.d(this.efz, d.C0236d.cp_cont_d, 1);
            this.efF.setVisibility(8);
        } else {
            al.d(this.efz, d.C0236d.cp_cont_f, 1);
            al.c(this.efF, d.f.icon_arrow_tab);
        }
        al.d(this.efA, d.C0236d.cp_link_tip_c, 1);
        al.d(this.efB, d.C0236d.cp_cont_d, 1);
        al.l(getView(), d.C0236d.cp_bg_line_d);
        al.l(this.efC, d.C0236d.cp_bg_line_c);
        al.l(this.efD, d.C0236d.cp_bg_line_c);
        al.l(this.efE, d.C0236d.cp_bg_line_c);
        al.l(this.efH, d.C0236d.cp_bg_line_c);
        al.l(this.efI, d.C0236d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aQj();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.efz.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.efA.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.efI.setVisibility(0);
        } else {
            this.efI.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.efH.setVisibility(0);
        } else {
            this.efH.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.efB.setVisibility(0);
            this.efE.setVisibility(0);
            this.efD.setVisibility(0);
            this.efB.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.efB.setTag(str);
                this.efB.setOnClickListener(this);
                return;
            }
            return;
        }
        this.efB.setVisibility(8);
        this.efE.setVisibility(8);
        this.efD.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.efB == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.adD().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void ok(int i) {
        if (this.efC != null && this.efC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.efC.getLayoutParams();
            layoutParams.height = i;
            this.efC.setLayoutParams(layoutParams);
        }
        if (this.efD != null && this.efD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.efD.getLayoutParams();
            layoutParams2.height = i;
            this.efD.setLayoutParams(layoutParams2);
        }
        if (this.efE != null && this.efE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.efE.getLayoutParams();
            layoutParams3.height = i;
            this.efE.setLayoutParams(layoutParams3);
        }
    }

    public void hJ(boolean z) {
        if (this.efH != null) {
            this.efH.setVisibility(z ? 0 : 8);
        }
    }
}
