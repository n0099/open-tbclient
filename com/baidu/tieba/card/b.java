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
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout eJB;
    protected TextView eJC;
    public TextView eJD;
    public TextView eJE;
    private View eJF;
    private View eJG;
    private View eJH;
    public ImageView eJI;
    public LinearLayout eJJ;
    public View eJK;
    public View eJL;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJB = null;
        this.eJC = null;
        this.eJD = null;
        this.eJE = null;
        this.eJF = null;
        this.eJG = null;
        this.eJH = null;
        this.eJJ = null;
        W(getView());
    }

    private void W(View view) {
        this.eJB = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.eJC = (TextView) view.findViewById(R.id.item_group_title);
        this.eJD = (TextView) view.findViewById(R.id.item_right_tv);
        this.eJE = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.eJF = view.findViewById(R.id.divider_line_top);
        this.eJG = view.findViewById(R.id.divider_line_middle);
        this.eJH = view.findViewById(R.id.divider_line_bottom);
        this.eJJ = (LinearLayout) view.findViewById(R.id.card_container);
        this.eJK = view.findViewById(R.id.divider_card);
        this.eJL = view.findViewById(R.id.divider_card_top);
        this.eJI = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aZW() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.eJC, R.color.cp_cont_d, 1);
            this.eJI.setVisibility(8);
        } else {
            am.setViewTextColor(this.eJC, R.color.cp_cont_f, 1);
            am.setImageResource(this.eJI, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.eJD, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.eJE, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.eJF, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eJG, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eJH, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eJK, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eJL, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aZW();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.eJC.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.eJD.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eJL.setVisibility(0);
        } else {
            this.eJL.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eJK.setVisibility(0);
        } else {
            this.eJK.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.eJE.setVisibility(0);
            this.eJH.setVisibility(0);
            this.eJG.setVisibility(0);
            this.eJE.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.eJE.setTag(str);
                this.eJE.setOnClickListener(this);
                return;
            }
            return;
        }
        this.eJE.setVisibility(8);
        this.eJH.setVisibility(8);
        this.eJG.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eJE == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.amO().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void oG(int i) {
        if (this.eJF != null && this.eJF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eJF.getLayoutParams();
            layoutParams.height = i;
            this.eJF.setLayoutParams(layoutParams);
        }
        if (this.eJG != null && this.eJG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.eJG.getLayoutParams();
            layoutParams2.height = i;
            this.eJG.setLayoutParams(layoutParams2);
        }
        if (this.eJH != null && this.eJH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eJH.getLayoutParams();
            layoutParams3.height = i;
            this.eJH.setLayoutParams(layoutParams3);
        }
    }

    public void iD(boolean z) {
        if (this.eJK != null) {
            this.eJK.setVisibility(z ? 0 : 8);
        }
    }
}
