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
    protected RelativeLayout hhm;
    protected TextView hhn;
    public TextView hho;
    public TextView hhp;
    private View hhq;
    private View hhr;
    private View hhs;
    public ImageView hht;
    public LinearLayout hhu;
    public View hhv;
    public View hhw;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hhm = null;
        this.hhn = null;
        this.hho = null;
        this.hhp = null;
        this.hhq = null;
        this.hhr = null;
        this.hhs = null;
        this.hhu = null;
        ak(getView());
    }

    private void ak(View view) {
        this.hhm = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hhn = (TextView) view.findViewById(R.id.item_group_title);
        this.hho = (TextView) view.findViewById(R.id.item_right_tv);
        this.hhp = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hhq = view.findViewById(R.id.divider_line_top);
        this.hhr = view.findViewById(R.id.divider_line_middle);
        this.hhs = view.findViewById(R.id.divider_line_bottom);
        this.hhu = (LinearLayout) view.findViewById(R.id.card_container);
        this.hhv = view.findViewById(R.id.divider_card);
        this.hhw = view.findViewById(R.id.divider_card_top);
        this.hht = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cbB() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hhn, R.color.cp_cont_d, 1);
            this.hht.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hhn, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hht, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hho, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hhp, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hhq, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhr, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhs, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhv, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hhw, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cbB();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hhn.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hho.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hhw.setVisibility(0);
        } else {
            this.hhw.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hhv.setVisibility(0);
        } else {
            this.hhv.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hhp.setVisibility(0);
            this.hhs.setVisibility(0);
            this.hhr.setVisibility(0);
            this.hhp.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hhp.setTag(str);
                this.hhp.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hhp.setVisibility(8);
        this.hhs.setVisibility(8);
        this.hhr.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhp == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.hhq != null && this.hhq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hhq.getLayoutParams();
            layoutParams.height = i;
            this.hhq.setLayoutParams(layoutParams);
        }
        if (this.hhr != null && this.hhr.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hhr.getLayoutParams();
            layoutParams2.height = i;
            this.hhr.setLayoutParams(layoutParams2);
        }
        if (this.hhs != null && this.hhs.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hhs.getLayoutParams();
            layoutParams3.height = i;
            this.hhs.setLayoutParams(layoutParams3);
        }
    }

    public void ne(boolean z) {
        if (this.hhv != null) {
            this.hhv.setVisibility(z ? 0 : 8);
        }
    }
}
