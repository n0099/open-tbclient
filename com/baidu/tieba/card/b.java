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
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout fEJ;
    protected TextView fEK;
    public TextView fEL;
    public TextView fEM;
    private View fEN;
    private View fEO;
    private View fEP;
    public ImageView fEQ;
    public LinearLayout fER;
    public View fES;
    public View fET;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fEJ = null;
        this.fEK = null;
        this.fEL = null;
        this.fEM = null;
        this.fEN = null;
        this.fEO = null;
        this.fEP = null;
        this.fER = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fEJ = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fEK = (TextView) view.findViewById(R.id.item_group_title);
        this.fEL = (TextView) view.findViewById(R.id.item_right_tv);
        this.fEM = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fEN = view.findViewById(R.id.divider_line_top);
        this.fEO = view.findViewById(R.id.divider_line_middle);
        this.fEP = view.findViewById(R.id.divider_line_bottom);
        this.fER = (LinearLayout) view.findViewById(R.id.card_container);
        this.fES = view.findViewById(R.id.divider_card);
        this.fET = view.findViewById(R.id.divider_card_top);
        this.fEQ = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void btb() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fEK, R.color.cp_cont_d, 1);
            this.fEQ.setVisibility(8);
        } else {
            am.setViewTextColor(this.fEK, R.color.cp_cont_f, 1);
            am.setImageResource(this.fEQ, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fEL, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fEM, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fEN, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fEO, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fEP, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fES, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fET, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            btb();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fEK.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fEL.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fET.setVisibility(0);
        } else {
            this.fET.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fES.setVisibility(0);
        } else {
            this.fES.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fEM.setVisibility(0);
            this.fEP.setVisibility(0);
            this.fEO.setVisibility(0);
            this.fEM.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fEM.setTag(str);
                this.fEM.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fEM.setVisibility(8);
        this.fEP.setVisibility(8);
        this.fEO.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fEM == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aEt().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void re(int i) {
        if (this.fEN != null && this.fEN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fEN.getLayoutParams();
            layoutParams.height = i;
            this.fEN.setLayoutParams(layoutParams);
        }
        if (this.fEO != null && this.fEO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fEO.getLayoutParams();
            layoutParams2.height = i;
            this.fEO.setLayoutParams(layoutParams2);
        }
        if (this.fEP != null && this.fEP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fEP.getLayoutParams();
            layoutParams3.height = i;
            this.fEP.setLayoutParams(layoutParams3);
        }
    }

    public void kf(boolean z) {
        if (this.fES != null) {
            this.fES.setVisibility(z ? 0 : 8);
        }
    }
}
