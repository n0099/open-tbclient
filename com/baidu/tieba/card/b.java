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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cBX;
    protected TextView cBY;
    public TextView cBZ;
    public TextView cCa;
    private View cCb;
    private View cCc;
    private View cCd;
    public ImageView cCe;
    public LinearLayout cCf;
    public View cCg;
    public View cCh;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cBX = null;
        this.cBY = null;
        this.cBZ = null;
        this.cCa = null;
        this.cCb = null;
        this.cCc = null;
        this.cCd = null;
        this.cCf = null;
        am(getView());
    }

    private void am(View view) {
        this.cBX = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cBY = (TextView) view.findViewById(e.g.item_group_title);
        this.cBZ = (TextView) view.findViewById(e.g.item_right_tv);
        this.cCa = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cCb = view.findViewById(e.g.divider_line_top);
        this.cCc = view.findViewById(e.g.divider_line_middle);
        this.cCd = view.findViewById(e.g.divider_line_bottom);
        this.cCf = (LinearLayout) view.findViewById(e.g.card_container);
        this.cCg = view.findViewById(e.g.divider_card);
        this.cCh = view.findViewById(e.g.divider_card_top);
        this.cCe = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akn() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cBY, e.d.cp_cont_d, 1);
            this.cCe.setVisibility(8);
        } else {
            al.c(this.cBY, e.d.cp_cont_f, 1);
            al.c(this.cCe, e.f.icon_arrow_tab);
        }
        al.c(this.cBZ, e.d.cp_link_tip_c, 1);
        al.c(this.cCa, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cCb, e.d.cp_bg_line_c);
        al.j(this.cCc, e.d.cp_bg_line_c);
        al.j(this.cCd, e.d.cp_bg_line_c);
        al.j(this.cCg, e.d.cp_bg_line_c);
        al.j(this.cCh, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akn();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cBY.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cBZ.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cCh.setVisibility(0);
        } else {
            this.cCh.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cCg.setVisibility(0);
        } else {
            this.cCg.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cCa.setVisibility(0);
            this.cCd.setVisibility(0);
            this.cCc.setVisibility(0);
            this.cCa.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cCa.setTag(str);
                this.cCa.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cCa.setVisibility(8);
        this.cCd.setVisibility(8);
        this.cCc.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cCa == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.AN().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void jn(int i) {
        if (this.cCb != null && this.cCb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cCb.getLayoutParams();
            layoutParams.height = i;
            this.cCb.setLayoutParams(layoutParams);
        }
        if (this.cCc != null && this.cCc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cCc.getLayoutParams();
            layoutParams2.height = i;
            this.cCc.setLayoutParams(layoutParams2);
        }
        if (this.cCd != null && this.cCd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cCd.getLayoutParams();
            layoutParams3.height = i;
            this.cCd.setLayoutParams(layoutParams3);
        }
    }

    public void eI(boolean z) {
        if (this.cCg != null) {
            this.cCg.setVisibility(z ? 0 : 8);
        }
    }
}
