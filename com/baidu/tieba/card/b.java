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
    private View fHA;
    private View fHB;
    public ImageView fHC;
    public LinearLayout fHD;
    public View fHE;
    public View fHF;
    protected RelativeLayout fHv;
    protected TextView fHw;
    public TextView fHx;
    public TextView fHy;
    private View fHz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fHv = null;
        this.fHw = null;
        this.fHx = null;
        this.fHy = null;
        this.fHz = null;
        this.fHA = null;
        this.fHB = null;
        this.fHD = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fHv = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fHw = (TextView) view.findViewById(R.id.item_group_title);
        this.fHx = (TextView) view.findViewById(R.id.item_right_tv);
        this.fHy = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fHz = view.findViewById(R.id.divider_line_top);
        this.fHA = view.findViewById(R.id.divider_line_middle);
        this.fHB = view.findViewById(R.id.divider_line_bottom);
        this.fHD = (LinearLayout) view.findViewById(R.id.card_container);
        this.fHE = view.findViewById(R.id.divider_card);
        this.fHF = view.findViewById(R.id.divider_card_top);
        this.fHC = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void buI() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fHw, R.color.cp_cont_d, 1);
            this.fHC.setVisibility(8);
        } else {
            am.setViewTextColor(this.fHw, R.color.cp_cont_f, 1);
            am.setImageResource(this.fHC, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fHx, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fHy, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fHz, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHA, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHB, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHE, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHF, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            buI();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fHw.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fHx.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fHF.setVisibility(0);
        } else {
            this.fHF.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fHE.setVisibility(0);
        } else {
            this.fHE.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fHy.setVisibility(0);
            this.fHB.setVisibility(0);
            this.fHA.setVisibility(0);
            this.fHy.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fHy.setTag(str);
                this.fHy.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fHy.setVisibility(8);
        this.fHB.setVisibility(8);
        this.fHA.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fHy == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aGG().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void rl(int i) {
        if (this.fHz != null && this.fHz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fHz.getLayoutParams();
            layoutParams.height = i;
            this.fHz.setLayoutParams(layoutParams);
        }
        if (this.fHA != null && this.fHA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fHA.getLayoutParams();
            layoutParams2.height = i;
            this.fHA.setLayoutParams(layoutParams2);
        }
        if (this.fHB != null && this.fHB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fHB.getLayoutParams();
            layoutParams3.height = i;
            this.fHB.setLayoutParams(layoutParams3);
        }
    }

    public void kh(boolean z) {
        if (this.fHE != null) {
            this.fHE.setVisibility(z ? 0 : 8);
        }
    }
}
