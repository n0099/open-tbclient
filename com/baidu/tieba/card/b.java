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
/* loaded from: classes5.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public TextView fBA;
    public TextView fBB;
    private View fBC;
    private View fBD;
    private View fBE;
    public ImageView fBF;
    public LinearLayout fBG;
    public View fBH;
    public View fBI;
    protected RelativeLayout fBy;
    protected TextView fBz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fBy = null;
        this.fBz = null;
        this.fBA = null;
        this.fBB = null;
        this.fBC = null;
        this.fBD = null;
        this.fBE = null;
        this.fBG = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fBy = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fBz = (TextView) view.findViewById(R.id.item_group_title);
        this.fBA = (TextView) view.findViewById(R.id.item_right_tv);
        this.fBB = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fBC = view.findViewById(R.id.divider_line_top);
        this.fBD = view.findViewById(R.id.divider_line_middle);
        this.fBE = view.findViewById(R.id.divider_line_bottom);
        this.fBG = (LinearLayout) view.findViewById(R.id.card_container);
        this.fBH = view.findViewById(R.id.divider_card);
        this.fBI = view.findViewById(R.id.divider_card_top);
        this.fBF = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void brZ() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fBz, R.color.cp_cont_d, 1);
            this.fBF.setVisibility(8);
        } else {
            am.setViewTextColor(this.fBz, R.color.cp_cont_f, 1);
            am.setImageResource(this.fBF, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fBA, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fBB, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fBC, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fBD, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fBE, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fBH, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fBI, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            brZ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fBz.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fBA.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fBI.setVisibility(0);
        } else {
            this.fBI.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fBH.setVisibility(0);
        } else {
            this.fBH.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fBB.setVisibility(0);
            this.fBE.setVisibility(0);
            this.fBD.setVisibility(0);
            this.fBB.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fBB.setTag(str);
                this.fBB.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fBB.setVisibility(8);
        this.fBE.setVisibility(8);
        this.fBD.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fBB == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aEa().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void qZ(int i) {
        if (this.fBC != null && this.fBC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fBC.getLayoutParams();
            layoutParams.height = i;
            this.fBC.setLayoutParams(layoutParams);
        }
        if (this.fBD != null && this.fBD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fBD.getLayoutParams();
            layoutParams2.height = i;
            this.fBD.setLayoutParams(layoutParams2);
        }
        if (this.fBE != null && this.fBE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fBE.getLayoutParams();
            layoutParams3.height = i;
            this.fBE.setLayoutParams(layoutParams3);
        }
    }

    public void jU(boolean z) {
        if (this.fBH != null) {
            this.fBH.setVisibility(z ? 0 : 8);
        }
    }
}
