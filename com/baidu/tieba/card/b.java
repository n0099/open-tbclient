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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bQE;
    protected TextView bQF;
    public TextView bQG;
    public TextView bQH;
    private View bQI;
    private View bQJ;
    private View bQK;
    public ImageView bQL;
    public LinearLayout bQM;
    public View bQN;
    public View bQO;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQE = null;
        this.bQF = null;
        this.bQG = null;
        this.bQH = null;
        this.bQI = null;
        this.bQJ = null;
        this.bQK = null;
        this.bQM = null;
        Z(getView());
    }

    private void Z(View view) {
        this.bQE = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.bQF = (TextView) view.findViewById(d.g.item_group_title);
        this.bQG = (TextView) view.findViewById(d.g.item_right_tv);
        this.bQH = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.bQI = view.findViewById(d.g.divider_line_top);
        this.bQJ = view.findViewById(d.g.divider_line_middle);
        this.bQK = view.findViewById(d.g.divider_line_bottom);
        this.bQM = (LinearLayout) view.findViewById(d.g.card_container);
        this.bQN = view.findViewById(d.g.divider_card);
        this.bQO = view.findViewById(d.g.divider_card_top);
        this.bQL = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Zy() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bQF, d.C0080d.cp_cont_d, 1);
            this.bQL.setVisibility(8);
        } else {
            aj.c(this.bQF, d.C0080d.cp_cont_f, 1);
            aj.c(this.bQL, d.f.icon_arrow_tab);
        }
        aj.c(this.bQG, d.C0080d.cp_link_tip_c, 1);
        aj.c(this.bQH, d.C0080d.cp_cont_d, 1);
        aj.k(getView(), d.C0080d.cp_bg_line_d);
        aj.k(this.bQI, d.C0080d.cp_bg_line_c);
        aj.k(this.bQJ, d.C0080d.cp_bg_line_c);
        aj.k(this.bQK, d.C0080d.cp_bg_line_c);
        aj.k(this.bQN, d.C0080d.cp_bg_line_c);
        aj.k(this.bQO, d.C0080d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Zy();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bQF.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bQG.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bQO.setVisibility(0);
        } else {
            this.bQO.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bQN.setVisibility(0);
        } else {
            this.bQN.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bQH.setVisibility(0);
            this.bQK.setVisibility(0);
            this.bQJ.setVisibility(0);
            this.bQH.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bQH.setTag(str);
                this.bQH.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bQH.setVisibility(8);
        this.bQK.setVisibility(8);
        this.bQJ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQH == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vI().c(Zw(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void ih(int i) {
        if (this.bQI != null && this.bQI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bQI.getLayoutParams();
            layoutParams.height = i;
            this.bQI.setLayoutParams(layoutParams);
        }
        if (this.bQJ != null && this.bQJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bQJ.getLayoutParams();
            layoutParams2.height = i;
            this.bQJ.setLayoutParams(layoutParams2);
        }
        if (this.bQK != null && this.bQK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bQK.getLayoutParams();
            layoutParams3.height = i;
            this.bQK.setLayoutParams(layoutParams3);
        }
    }

    public void dx(boolean z) {
        if (this.bQN != null) {
            this.bQN.setVisibility(z ? 0 : 8);
        }
    }
}
