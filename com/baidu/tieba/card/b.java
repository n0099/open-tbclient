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
    protected RelativeLayout eBK;
    protected TextView eBL;
    public TextView eBM;
    public TextView eBN;
    private View eBO;
    private View eBP;
    private View eBQ;
    public ImageView eBR;
    public LinearLayout eBS;
    public View eBT;
    public View eBU;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eBK = null;
        this.eBL = null;
        this.eBM = null;
        this.eBN = null;
        this.eBO = null;
        this.eBP = null;
        this.eBQ = null;
        this.eBS = null;
        Q(getView());
    }

    private void Q(View view) {
        this.eBK = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.eBL = (TextView) view.findViewById(R.id.item_group_title);
        this.eBM = (TextView) view.findViewById(R.id.item_right_tv);
        this.eBN = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.eBO = view.findViewById(R.id.divider_line_top);
        this.eBP = view.findViewById(R.id.divider_line_middle);
        this.eBQ = view.findViewById(R.id.divider_line_bottom);
        this.eBS = (LinearLayout) view.findViewById(R.id.card_container);
        this.eBT = view.findViewById(R.id.divider_card);
        this.eBU = view.findViewById(R.id.divider_card_top);
        this.eBR = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aZV() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.f(this.eBL, R.color.cp_cont_d, 1);
            this.eBR.setVisibility(8);
        } else {
            am.f(this.eBL, R.color.cp_cont_f, 1);
            am.c(this.eBR, (int) R.drawable.icon_arrow_tab);
        }
        am.f(this.eBM, R.color.cp_link_tip_c, 1);
        am.f(this.eBN, R.color.cp_cont_d, 1);
        am.l(getView(), R.color.cp_bg_line_d);
        am.l(this.eBO, R.color.cp_bg_line_c);
        am.l(this.eBP, R.color.cp_bg_line_c);
        am.l(this.eBQ, R.color.cp_bg_line_c);
        am.l(this.eBT, R.color.cp_bg_line_c);
        am.l(this.eBU, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aZV();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.eBL.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.eBM.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eBU.setVisibility(0);
        } else {
            this.eBU.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eBT.setVisibility(0);
        } else {
            this.eBT.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.eBN.setVisibility(0);
            this.eBQ.setVisibility(0);
            this.eBP.setVisibility(0);
            this.eBN.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.eBN.setTag(str);
                this.eBN.setOnClickListener(this);
                return;
            }
            return;
        }
        this.eBN.setVisibility(8);
        this.eBQ.setVisibility(8);
        this.eBP.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eBN == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.ajK().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void pF(int i) {
        if (this.eBO != null && this.eBO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eBO.getLayoutParams();
            layoutParams.height = i;
            this.eBO.setLayoutParams(layoutParams);
        }
        if (this.eBP != null && this.eBP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.eBP.getLayoutParams();
            layoutParams2.height = i;
            this.eBP.setLayoutParams(layoutParams2);
        }
        if (this.eBQ != null && this.eBQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eBQ.getLayoutParams();
            layoutParams3.height = i;
            this.eBQ.setLayoutParams(layoutParams3);
        }
    }

    public void iA(boolean z) {
        if (this.eBT != null) {
            this.eBT.setVisibility(z ? 0 : 8);
        }
    }
}
