package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    private View bbA;
    private View bbB;
    private View bbC;
    public ImageView bbD;
    public LinearLayout bbE;
    public View bbF;
    public View bbG;
    protected RelativeLayout bbw;
    protected TextView bbx;
    public TextView bby;
    public TextView bbz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbw = null;
        this.bbx = null;
        this.bby = null;
        this.bbz = null;
        this.bbA = null;
        this.bbB = null;
        this.bbC = null;
        this.bbE = null;
        S(getView());
    }

    private void S(View view) {
        this.bbw = (RelativeLayout) view.findViewById(r.g.item_layout_group_title);
        this.bbx = (TextView) view.findViewById(r.g.item_group_title);
        this.bby = (TextView) view.findViewById(r.g.item_right_tv);
        this.bbz = (TextView) view.findViewById(r.g.item_bottom_more_tv);
        this.bbA = view.findViewById(r.g.divider_line_top);
        this.bbB = view.findViewById(r.g.divider_line_middle);
        this.bbC = view.findViewById(r.g.divider_line_bottom);
        this.bbE = (LinearLayout) view.findViewById(r.g.card_container);
        this.bbF = view.findViewById(r.g.divider_card);
        this.bbG = view.findViewById(r.g.divider_card_top);
        this.bbD = (ImageView) view.findViewById(r.g.item_right_arrow);
    }

    private void OV() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.at.c(this.bbx, r.d.cp_cont_d, 1);
            this.bbD.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.at.c(this.bbx, r.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(this.bbD, r.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.at.c(this.bby, r.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.at.c(this.bbz, r.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.l(getView(), r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.bbA, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.bbB, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.bbC, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.bbF, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.bbG, r.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            OV();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bbx.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bby.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bbG.setVisibility(0);
        } else {
            this.bbG.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bbF.setVisibility(0);
        } else {
            this.bbF.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bbz.setVisibility(0);
            this.bbC.setVisibility(0);
            this.bbB.setVisibility(0);
            this.bbz.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bbz.setTag(str);
                this.bbz.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bbz.setVisibility(8);
        this.bbC.setVisibility(8);
        this.bbB.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbz == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bf.vP().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return r.h.card_group;
    }

    public void gg(int i) {
        if (this.bbA != null && this.bbA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bbA.getLayoutParams();
            layoutParams.height = i;
            this.bbA.setLayoutParams(layoutParams);
        }
        if (this.bbB != null && this.bbB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bbB.getLayoutParams();
            layoutParams2.height = i;
            this.bbB.setLayoutParams(layoutParams2);
        }
        if (this.bbC != null && this.bbC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bbC.getLayoutParams();
            layoutParams3.height = i;
            this.bbC.setLayoutParams(layoutParams3);
        }
    }

    public void cv(boolean z) {
        if (this.bbF != null) {
            this.bbF.setVisibility(z ? 0 : 8);
        }
    }
}
