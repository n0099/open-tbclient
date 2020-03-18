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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout fId;
    protected TextView fIe;
    public TextView fIf;
    public TextView fIg;
    private View fIh;
    private View fIi;
    private View fIj;
    public ImageView fIk;
    public LinearLayout fIl;
    public View fIm;
    public View fIn;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fId = null;
        this.fIe = null;
        this.fIf = null;
        this.fIg = null;
        this.fIh = null;
        this.fIi = null;
        this.fIj = null;
        this.fIl = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fId = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fIe = (TextView) view.findViewById(R.id.item_group_title);
        this.fIf = (TextView) view.findViewById(R.id.item_right_tv);
        this.fIg = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fIh = view.findViewById(R.id.divider_line_top);
        this.fIi = view.findViewById(R.id.divider_line_middle);
        this.fIj = view.findViewById(R.id.divider_line_bottom);
        this.fIl = (LinearLayout) view.findViewById(R.id.card_container);
        this.fIm = view.findViewById(R.id.divider_card);
        this.fIn = view.findViewById(R.id.divider_card_top);
        this.fIk = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void buN() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fIe, R.color.cp_cont_d, 1);
            this.fIk.setVisibility(8);
        } else {
            am.setViewTextColor(this.fIe, R.color.cp_cont_f, 1);
            am.setImageResource(this.fIk, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fIf, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fIg, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fIh, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fIi, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fIj, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fIm, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fIn, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            buN();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fIe.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fIf.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fIn.setVisibility(0);
        } else {
            this.fIn.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fIm.setVisibility(0);
        } else {
            this.fIm.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fIg.setVisibility(0);
            this.fIj.setVisibility(0);
            this.fIi.setVisibility(0);
            this.fIg.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fIg.setTag(str);
                this.fIg.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fIg.setVisibility(8);
        this.fIj.setVisibility(8);
        this.fIi.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fIg == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aGK().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void rn(int i) {
        if (this.fIh != null && this.fIh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fIh.getLayoutParams();
            layoutParams.height = i;
            this.fIh.setLayoutParams(layoutParams);
        }
        if (this.fIi != null && this.fIi.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fIi.getLayoutParams();
            layoutParams2.height = i;
            this.fIi.setLayoutParams(layoutParams2);
        }
        if (this.fIj != null && this.fIj.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fIj.getLayoutParams();
            layoutParams3.height = i;
            this.fIj.setLayoutParams(layoutParams3);
        }
    }

    public void km(boolean z) {
        if (this.fIm != null) {
            this.fIm.setVisibility(z ? 0 : 8);
        }
    }
}
