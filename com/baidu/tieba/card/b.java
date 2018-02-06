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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    private View cVA;
    private View cVB;
    public ImageView cVC;
    public LinearLayout cVD;
    public View cVE;
    public View cVF;
    protected RelativeLayout cVv;
    protected TextView cVw;
    public TextView cVx;
    public TextView cVy;
    private View cVz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVv = null;
        this.cVw = null;
        this.cVx = null;
        this.cVy = null;
        this.cVz = null;
        this.cVA = null;
        this.cVB = null;
        this.cVD = null;
        bu(getView());
    }

    private void bu(View view) {
        this.cVv = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cVw = (TextView) view.findViewById(d.g.item_group_title);
        this.cVx = (TextView) view.findViewById(d.g.item_right_tv);
        this.cVy = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cVz = view.findViewById(d.g.divider_line_top);
        this.cVA = view.findViewById(d.g.divider_line_middle);
        this.cVB = view.findViewById(d.g.divider_line_bottom);
        this.cVD = (LinearLayout) view.findViewById(d.g.card_container);
        this.cVE = view.findViewById(d.g.divider_card);
        this.cVF = view.findViewById(d.g.divider_card_top);
        this.cVC = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akQ() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            aj.e(this.cVw, d.C0140d.cp_cont_d, 1);
            this.cVC.setVisibility(8);
        } else {
            aj.e(this.cVw, d.C0140d.cp_cont_f, 1);
            aj.c(this.cVC, d.f.icon_arrow_tab);
        }
        aj.e(this.cVx, d.C0140d.cp_link_tip_c, 1);
        aj.e(this.cVy, d.C0140d.cp_cont_d, 1);
        aj.t(getView(), d.C0140d.cp_bg_line_d);
        aj.t(this.cVz, d.C0140d.cp_bg_line_c);
        aj.t(this.cVA, d.C0140d.cp_bg_line_c);
        aj.t(this.cVB, d.C0140d.cp_bg_line_c);
        aj.t(this.cVE, d.C0140d.cp_bg_line_c);
        aj.t(this.cVF, d.C0140d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akQ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cVw.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cVx.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVF.setVisibility(0);
        } else {
            this.cVF.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVE.setVisibility(0);
        } else {
            this.cVE.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cVy.setVisibility(0);
            this.cVB.setVisibility(0);
            this.cVA.setVisibility(0);
            this.cVy.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cVy.setTag(str);
                this.cVy.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cVy.setVisibility(8);
        this.cVB.setVisibility(8);
        this.cVA.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVy == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                aw.Du().c(akO(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lz(int i) {
        if (this.cVz != null && this.cVz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVz.getLayoutParams();
            layoutParams.height = i;
            this.cVz.setLayoutParams(layoutParams);
        }
        if (this.cVA != null && this.cVA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVA.getLayoutParams();
            layoutParams2.height = i;
            this.cVA.setLayoutParams(layoutParams2);
        }
        if (this.cVB != null && this.cVB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVB.getLayoutParams();
            layoutParams3.height = i;
            this.cVB.setLayoutParams(layoutParams3);
        }
    }

    public void eH(boolean z) {
        if (this.cVE != null) {
            this.cVE.setVisibility(z ? 0 : 8);
        }
    }
}
