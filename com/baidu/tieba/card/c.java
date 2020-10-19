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
/* loaded from: classes21.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout hDk;
    protected TextView hDl;
    public TextView hDm;
    public TextView hDn;
    private View hDo;
    private View hDp;
    private View hDq;
    public ImageView hDr;
    public LinearLayout hDs;
    public View hDt;
    public View hDu;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hDk = null;
        this.hDl = null;
        this.hDm = null;
        this.hDn = null;
        this.hDo = null;
        this.hDp = null;
        this.hDq = null;
        this.hDs = null;
        an(getView());
    }

    private void an(View view) {
        this.hDk = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hDl = (TextView) view.findViewById(R.id.item_group_title);
        this.hDm = (TextView) view.findViewById(R.id.item_right_tv);
        this.hDn = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hDo = view.findViewById(R.id.divider_line_top);
        this.hDp = view.findViewById(R.id.divider_line_middle);
        this.hDq = view.findViewById(R.id.divider_line_bottom);
        this.hDs = (LinearLayout) view.findViewById(R.id.card_container);
        this.hDt = view.findViewById(R.id.divider_card);
        this.hDu = view.findViewById(R.id.divider_card_top);
        this.hDr = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cim() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hDl, R.color.cp_cont_d, 1);
            this.hDr.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hDl, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hDr, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hDm, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hDn, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hDo, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hDp, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hDq, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hDt, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hDu, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cim();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hDl.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hDm.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hDu.setVisibility(0);
        } else {
            this.hDu.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hDt.setVisibility(0);
        } else {
            this.hDt.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hDn.setVisibility(0);
            this.hDq.setVisibility(0);
            this.hDp.setVisibility(0);
            this.hDn.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hDn.setTag(str);
                this.hDn.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hDn.setVisibility(8);
        this.hDq.setVisibility(8);
        this.hDp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hDn == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.bmY().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wv(int i) {
        if (this.hDo != null && this.hDo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hDo.getLayoutParams();
            layoutParams.height = i;
            this.hDo.setLayoutParams(layoutParams);
        }
        if (this.hDp != null && this.hDp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hDp.getLayoutParams();
            layoutParams2.height = i;
            this.hDp.setLayoutParams(layoutParams2);
        }
        if (this.hDq != null && this.hDq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hDq.getLayoutParams();
            layoutParams3.height = i;
            this.hDq.setLayoutParams(layoutParams3);
        }
    }

    public void nP(boolean z) {
        if (this.hDt != null) {
            this.hDt.setVisibility(z ? 0 : 8);
        }
    }
}
