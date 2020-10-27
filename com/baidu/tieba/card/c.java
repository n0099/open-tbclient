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
    protected RelativeLayout hPG;
    protected TextView hPH;
    public TextView hPI;
    public TextView hPJ;
    private View hPK;
    private View hPL;
    private View hPM;
    public ImageView hPN;
    public LinearLayout hPO;
    public View hPP;
    public View hPQ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hPG = null;
        this.hPH = null;
        this.hPI = null;
        this.hPJ = null;
        this.hPK = null;
        this.hPL = null;
        this.hPM = null;
        this.hPO = null;
        ah(getView());
    }

    private void ah(View view) {
        this.hPG = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hPH = (TextView) view.findViewById(R.id.item_group_title);
        this.hPI = (TextView) view.findViewById(R.id.item_right_tv);
        this.hPJ = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hPK = view.findViewById(R.id.divider_line_top);
        this.hPL = view.findViewById(R.id.divider_line_middle);
        this.hPM = view.findViewById(R.id.divider_line_bottom);
        this.hPO = (LinearLayout) view.findViewById(R.id.card_container);
        this.hPP = view.findViewById(R.id.divider_card);
        this.hPQ = view.findViewById(R.id.divider_card_top);
        this.hPN = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void clt() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hPH, R.color.cp_cont_d, 1);
            this.hPN.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hPH, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hPN, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hPI, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hPJ, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hPK, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hPL, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hPM, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hPP, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hPQ, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            clt();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hPH.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hPI.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hPQ.setVisibility(0);
        } else {
            this.hPQ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hPP.setVisibility(0);
        } else {
            this.hPP.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hPJ.setVisibility(0);
            this.hPM.setVisibility(0);
            this.hPL.setVisibility(0);
            this.hPJ.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hPJ.setTag(str);
                this.hPJ.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hPJ.setVisibility(8);
        this.hPM.setVisibility(8);
        this.hPL.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hPJ == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.boR().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wO(int i) {
        if (this.hPK != null && this.hPK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hPK.getLayoutParams();
            layoutParams.height = i;
            this.hPK.setLayoutParams(layoutParams);
        }
        if (this.hPL != null && this.hPL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hPL.getLayoutParams();
            layoutParams2.height = i;
            this.hPL.setLayoutParams(layoutParams2);
        }
        if (this.hPM != null && this.hPM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hPM.getLayoutParams();
            layoutParams3.height = i;
            this.hPM.setLayoutParams(layoutParams3);
        }
    }

    public void oh(boolean z) {
        if (this.hPP != null) {
            this.hPP.setVisibility(z ? 0 : 8);
        }
    }
}
