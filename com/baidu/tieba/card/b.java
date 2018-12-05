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
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cSf;
    protected TextView cSg;
    public TextView cSh;
    public TextView cSi;
    private View cSj;
    private View cSk;
    private View cSl;
    public ImageView cSm;
    public LinearLayout cSn;
    public View cSo;
    public View cSp;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cSf = null;
        this.cSg = null;
        this.cSh = null;
        this.cSi = null;
        this.cSj = null;
        this.cSk = null;
        this.cSl = null;
        this.cSn = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cSf = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cSg = (TextView) view.findViewById(e.g.item_group_title);
        this.cSh = (TextView) view.findViewById(e.g.item_right_tv);
        this.cSi = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cSj = view.findViewById(e.g.divider_line_top);
        this.cSk = view.findViewById(e.g.divider_line_middle);
        this.cSl = view.findViewById(e.g.divider_line_bottom);
        this.cSn = (LinearLayout) view.findViewById(e.g.card_container);
        this.cSo = view.findViewById(e.g.divider_card);
        this.cSp = view.findViewById(e.g.divider_card_top);
        this.cSm = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void apd() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cSg, e.d.cp_cont_d, 1);
            this.cSm.setVisibility(8);
        } else {
            al.c(this.cSg, e.d.cp_cont_f, 1);
            al.c(this.cSm, e.f.icon_arrow_tab);
        }
        al.c(this.cSh, e.d.cp_link_tip_c, 1);
        al.c(this.cSi, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cSj, e.d.cp_bg_line_c);
        al.j(this.cSk, e.d.cp_bg_line_c);
        al.j(this.cSl, e.d.cp_bg_line_c);
        al.j(this.cSo, e.d.cp_bg_line_c);
        al.j(this.cSp, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            apd();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cSg.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cSh.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cSp.setVisibility(0);
        } else {
            this.cSp.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cSo.setVisibility(0);
        } else {
            this.cSo.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cSi.setVisibility(0);
            this.cSl.setVisibility(0);
            this.cSk.setVisibility(0);
            this.cSi.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cSi.setTag(str);
                this.cSi.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cSi.setVisibility(8);
        this.cSl.setVisibility(8);
        this.cSk.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cSi == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.Ef().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void kv(int i) {
        if (this.cSj != null && this.cSj.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cSj.getLayoutParams();
            layoutParams.height = i;
            this.cSj.setLayoutParams(layoutParams);
        }
        if (this.cSk != null && this.cSk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cSk.getLayoutParams();
            layoutParams2.height = i;
            this.cSk.setLayoutParams(layoutParams2);
        }
        if (this.cSl != null && this.cSl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cSl.getLayoutParams();
            layoutParams3.height = i;
            this.cSl.setLayoutParams(layoutParams3);
        }
    }

    public void fm(boolean z) {
        if (this.cSo != null) {
            this.cSo.setVisibility(z ? 0 : 8);
        }
    }
}
