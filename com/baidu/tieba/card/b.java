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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout eAb;
    protected TextView eAc;
    public TextView eAd;
    public TextView eAe;
    private View eAf;
    private View eAg;
    private View eAh;
    public ImageView eAi;
    public LinearLayout eAj;
    public View eAk;
    public View eAl;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eAb = null;
        this.eAc = null;
        this.eAd = null;
        this.eAe = null;
        this.eAf = null;
        this.eAg = null;
        this.eAh = null;
        this.eAj = null;
        Q(getView());
    }

    private void Q(View view) {
        this.eAb = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.eAc = (TextView) view.findViewById(R.id.item_group_title);
        this.eAd = (TextView) view.findViewById(R.id.item_right_tv);
        this.eAe = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.eAf = view.findViewById(R.id.divider_line_top);
        this.eAg = view.findViewById(R.id.divider_line_middle);
        this.eAh = view.findViewById(R.id.divider_line_bottom);
        this.eAj = (LinearLayout) view.findViewById(R.id.card_container);
        this.eAk = view.findViewById(R.id.divider_card);
        this.eAl = view.findViewById(R.id.divider_card_top);
        this.eAi = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aZr() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.f(this.eAc, R.color.cp_cont_d, 1);
            this.eAi.setVisibility(8);
        } else {
            am.f(this.eAc, R.color.cp_cont_f, 1);
            am.c(this.eAi, (int) R.drawable.icon_arrow_tab);
        }
        am.f(this.eAd, R.color.cp_link_tip_c, 1);
        am.f(this.eAe, R.color.cp_cont_d, 1);
        am.l(getView(), R.color.cp_bg_line_d);
        am.l(this.eAf, R.color.cp_bg_line_c);
        am.l(this.eAg, R.color.cp_bg_line_c);
        am.l(this.eAh, R.color.cp_bg_line_c);
        am.l(this.eAk, R.color.cp_bg_line_c);
        am.l(this.eAl, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aZr();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.eAc.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.eAd.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eAl.setVisibility(0);
        } else {
            this.eAl.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eAk.setVisibility(0);
        } else {
            this.eAk.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.eAe.setVisibility(0);
            this.eAh.setVisibility(0);
            this.eAg.setVisibility(0);
            this.eAe.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.eAe.setTag(str);
                this.eAe.setOnClickListener(this);
                return;
            }
            return;
        }
        this.eAe.setVisibility(8);
        this.eAh.setVisibility(8);
        this.eAg.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eAe == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bb.ajE().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void pB(int i) {
        if (this.eAf != null && this.eAf.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eAf.getLayoutParams();
            layoutParams.height = i;
            this.eAf.setLayoutParams(layoutParams);
        }
        if (this.eAg != null && this.eAg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.eAg.getLayoutParams();
            layoutParams2.height = i;
            this.eAg.setLayoutParams(layoutParams2);
        }
        if (this.eAh != null && this.eAh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eAh.getLayoutParams();
            layoutParams3.height = i;
            this.eAh.setLayoutParams(layoutParams3);
        }
    }

    public void ix(boolean z) {
        if (this.eAk != null) {
            this.eAk.setVisibility(z ? 0 : 8);
        }
    }
}
