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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes15.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout hhi;
    protected TextView hhj;
    public TextView hhk;
    public TextView hhl;
    private View hhm;
    private View hhn;
    private View hho;
    public ImageView hhp;
    public LinearLayout hhq;
    public View hhr;
    public View hhs;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hhi = null;
        this.hhj = null;
        this.hhk = null;
        this.hhl = null;
        this.hhm = null;
        this.hhn = null;
        this.hho = null;
        this.hhq = null;
        ak(getView());
    }

    private void ak(View view) {
        this.hhi = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hhj = (TextView) view.findViewById(R.id.item_group_title);
        this.hhk = (TextView) view.findViewById(R.id.item_right_tv);
        this.hhl = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hhm = view.findViewById(R.id.divider_line_top);
        this.hhn = view.findViewById(R.id.divider_line_middle);
        this.hho = view.findViewById(R.id.divider_line_bottom);
        this.hhq = (LinearLayout) view.findViewById(R.id.card_container);
        this.hhr = view.findViewById(R.id.divider_card);
        this.hhs = view.findViewById(R.id.divider_card_top);
        this.hhp = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cbA() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hhj, R.color.cp_cont_d, 1);
            this.hhp.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hhj, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hhp, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hhk, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hhl, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hhm, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhn, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hho, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhr, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhs, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cbA();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hhj.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hhk.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hhs.setVisibility(0);
        } else {
            this.hhs.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hhr.setVisibility(0);
        } else {
            this.hhr.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hhl.setVisibility(0);
            this.hho.setVisibility(0);
            this.hhn.setVisibility(0);
            this.hhl.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hhl.setTag(str);
                this.hhl.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hhl.setVisibility(8);
        this.hho.setVisibility(8);
        this.hhn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhl == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.bju().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void vq(int i) {
        if (this.hhm != null && this.hhm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hhm.getLayoutParams();
            layoutParams.height = i;
            this.hhm.setLayoutParams(layoutParams);
        }
        if (this.hhn != null && this.hhn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hhn.getLayoutParams();
            layoutParams2.height = i;
            this.hhn.setLayoutParams(layoutParams2);
        }
        if (this.hho != null && this.hho.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hho.getLayoutParams();
            layoutParams3.height = i;
            this.hho.setLayoutParams(layoutParams3);
        }
    }

    public void nc(boolean z) {
        if (this.hhr != null) {
            this.hhr.setVisibility(z ? 0 : 8);
        }
    }
}
