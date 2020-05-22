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
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout gBJ;
    protected TextView gBK;
    public TextView gBL;
    public TextView gBM;
    private View gBN;
    private View gBO;
    private View gBP;
    public ImageView gBQ;
    public LinearLayout gBR;
    public View gBS;
    public View gBT;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gBJ = null;
        this.gBK = null;
        this.gBL = null;
        this.gBM = null;
        this.gBN = null;
        this.gBO = null;
        this.gBP = null;
        this.gBR = null;
        ag(getView());
    }

    private void ag(View view) {
        this.gBJ = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gBK = (TextView) view.findViewById(R.id.item_group_title);
        this.gBL = (TextView) view.findViewById(R.id.item_right_tv);
        this.gBM = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gBN = view.findViewById(R.id.divider_line_top);
        this.gBO = view.findViewById(R.id.divider_line_middle);
        this.gBP = view.findViewById(R.id.divider_line_bottom);
        this.gBR = (LinearLayout) view.findViewById(R.id.card_container);
        this.gBS = view.findViewById(R.id.divider_card);
        this.gBT = view.findViewById(R.id.divider_card_top);
        this.gBQ = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bKT() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.gBK, R.color.cp_cont_d, 1);
            this.gBQ.setVisibility(8);
        } else {
            am.setViewTextColor(this.gBK, R.color.cp_cont_f, 1);
            am.setImageResource(this.gBQ, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.gBL, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.gBM, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gBN, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBO, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBP, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBS, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBT, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bKT();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gBK.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gBL.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gBT.setVisibility(0);
        } else {
            this.gBT.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gBS.setVisibility(0);
        } else {
            this.gBS.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gBM.setVisibility(0);
            this.gBP.setVisibility(0);
            this.gBO.setVisibility(0);
            this.gBM.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gBM.setTag(str);
                this.gBM.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gBM.setVisibility(8);
        this.gBP.setVisibility(8);
        this.gBO.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBM == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aUZ().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void sj(int i) {
        if (this.gBN != null && this.gBN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gBN.getLayoutParams();
            layoutParams.height = i;
            this.gBN.setLayoutParams(layoutParams);
        }
        if (this.gBO != null && this.gBO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gBO.getLayoutParams();
            layoutParams2.height = i;
            this.gBO.setLayoutParams(layoutParams2);
        }
        if (this.gBP != null && this.gBP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gBP.getLayoutParams();
            layoutParams3.height = i;
            this.gBP.setLayoutParams(layoutParams3);
        }
    }

    public void lL(boolean z) {
        if (this.gBS != null) {
            this.gBS.setVisibility(z ? 0 : 8);
        }
    }
}
