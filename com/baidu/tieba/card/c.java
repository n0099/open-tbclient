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
/* loaded from: classes20.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    public View hoA;
    protected RelativeLayout hoq;
    protected TextView hor;
    public TextView hos;
    public TextView hot;
    private View hou;
    private View hov;
    private View how;
    public ImageView hox;
    public LinearLayout hoy;
    public View hoz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hoq = null;
        this.hor = null;
        this.hos = null;
        this.hot = null;
        this.hou = null;
        this.hov = null;
        this.how = null;
        this.hoy = null;
        am(getView());
    }

    private void am(View view) {
        this.hoq = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hor = (TextView) view.findViewById(R.id.item_group_title);
        this.hos = (TextView) view.findViewById(R.id.item_right_tv);
        this.hot = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hou = view.findViewById(R.id.divider_line_top);
        this.hov = view.findViewById(R.id.divider_line_middle);
        this.how = view.findViewById(R.id.divider_line_bottom);
        this.hoy = (LinearLayout) view.findViewById(R.id.card_container);
        this.hoz = view.findViewById(R.id.divider_card);
        this.hoA = view.findViewById(R.id.divider_card_top);
        this.hox = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void ceQ() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hor, R.color.cp_cont_d, 1);
            this.hox.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hor, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hox, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hos, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hot, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hou, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hov, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.how, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hoz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hoA, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ceQ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hor.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hos.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hoA.setVisibility(0);
        } else {
            this.hoA.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hoz.setVisibility(0);
        } else {
            this.hoz.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hot.setVisibility(0);
            this.how.setVisibility(0);
            this.hov.setVisibility(0);
            this.hot.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hot.setTag(str);
                this.hot.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hot.setVisibility(8);
        this.how.setVisibility(8);
        this.hov.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hot == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.bkp().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void vP(int i) {
        if (this.hou != null && this.hou.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hou.getLayoutParams();
            layoutParams.height = i;
            this.hou.setLayoutParams(layoutParams);
        }
        if (this.hov != null && this.hov.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hov.getLayoutParams();
            layoutParams2.height = i;
            this.hov.setLayoutParams(layoutParams2);
        }
        if (this.how != null && this.how.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.how.getLayoutParams();
            layoutParams3.height = i;
            this.how.setLayoutParams(layoutParams3);
        }
    }

    public void nk(boolean z) {
        if (this.hoz != null) {
            this.hoz.setVisibility(z ? 0 : 8);
        }
    }
}
