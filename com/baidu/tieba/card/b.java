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
    protected RelativeLayout cSe;
    protected TextView cSf;
    public TextView cSg;
    public TextView cSh;
    private View cSi;
    private View cSj;
    private View cSk;
    public ImageView cSl;
    public LinearLayout cSm;
    public View cSn;
    public View cSo;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cSe = null;
        this.cSf = null;
        this.cSg = null;
        this.cSh = null;
        this.cSi = null;
        this.cSj = null;
        this.cSk = null;
        this.cSm = null;
        bv(getView());
    }

    private void bv(View view) {
        this.cSe = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cSf = (TextView) view.findViewById(d.g.item_group_title);
        this.cSg = (TextView) view.findViewById(d.g.item_right_tv);
        this.cSh = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cSi = view.findViewById(d.g.divider_line_top);
        this.cSj = view.findViewById(d.g.divider_line_middle);
        this.cSk = view.findViewById(d.g.divider_line_bottom);
        this.cSm = (LinearLayout) view.findViewById(d.g.card_container);
        this.cSn = view.findViewById(d.g.divider_card);
        this.cSo = view.findViewById(d.g.divider_card_top);
        this.cSl = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akc() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.e(this.cSf, d.C0107d.cp_cont_d, 1);
            this.cSl.setVisibility(8);
        } else {
            aj.e(this.cSf, d.C0107d.cp_cont_f, 1);
            aj.c(this.cSl, d.f.icon_arrow_tab);
        }
        aj.e(this.cSg, d.C0107d.cp_link_tip_c, 1);
        aj.e(this.cSh, d.C0107d.cp_cont_d, 1);
        aj.t(getView(), d.C0107d.cp_bg_line_d);
        aj.t(this.cSi, d.C0107d.cp_bg_line_c);
        aj.t(this.cSj, d.C0107d.cp_bg_line_c);
        aj.t(this.cSk, d.C0107d.cp_bg_line_c);
        aj.t(this.cSn, d.C0107d.cp_bg_line_c);
        aj.t(this.cSo, d.C0107d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akc();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cSf.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cSg.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cSo.setVisibility(0);
        } else {
            this.cSo.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cSn.setVisibility(0);
        } else {
            this.cSn.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cSh.setVisibility(0);
            this.cSk.setVisibility(0);
            this.cSj.setVisibility(0);
            this.cSh.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cSh.setTag(str);
                this.cSh.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cSh.setVisibility(8);
        this.cSk.setVisibility(8);
        this.cSj.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cSh == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.CZ().c(aka(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lC(int i) {
        if (this.cSi != null && this.cSi.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cSi.getLayoutParams();
            layoutParams.height = i;
            this.cSi.setLayoutParams(layoutParams);
        }
        if (this.cSj != null && this.cSj.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cSj.getLayoutParams();
            layoutParams2.height = i;
            this.cSj.setLayoutParams(layoutParams2);
        }
        if (this.cSk != null && this.cSk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cSk.getLayoutParams();
            layoutParams3.height = i;
            this.cSk.setLayoutParams(layoutParams3);
        }
    }

    public void ey(boolean z) {
        if (this.cSn != null) {
            this.cSn.setVisibility(z ? 0 : 8);
        }
    }
}
