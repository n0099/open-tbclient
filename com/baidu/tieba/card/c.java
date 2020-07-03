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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes8.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout gOK;
    protected TextView gOL;
    public TextView gOM;
    public TextView gON;
    private View gOO;
    private View gOP;
    private View gOQ;
    public ImageView gOR;
    public LinearLayout gOS;
    public View gOT;
    public View gOU;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gOK = null;
        this.gOL = null;
        this.gOM = null;
        this.gON = null;
        this.gOO = null;
        this.gOP = null;
        this.gOQ = null;
        this.gOS = null;
        ag(getView());
    }

    private void ag(View view) {
        this.gOK = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gOL = (TextView) view.findViewById(R.id.item_group_title);
        this.gOM = (TextView) view.findViewById(R.id.item_right_tv);
        this.gON = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gOO = view.findViewById(R.id.divider_line_top);
        this.gOP = view.findViewById(R.id.divider_line_middle);
        this.gOQ = view.findViewById(R.id.divider_line_bottom);
        this.gOS = (LinearLayout) view.findViewById(R.id.card_container);
        this.gOT = view.findViewById(R.id.divider_card);
        this.gOU = view.findViewById(R.id.divider_card_top);
        this.gOR = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bOd() {
        if (getFrom() != null && getFrom().equals("home")) {
            an.setViewTextColor(this.gOL, R.color.cp_cont_d, 1);
            this.gOR.setVisibility(8);
        } else {
            an.setViewTextColor(this.gOL, R.color.cp_cont_f, 1);
            an.setImageResource(this.gOR, R.drawable.icon_arrow_tab);
        }
        an.setViewTextColor(this.gOM, R.color.cp_link_tip_c, 1);
        an.setViewTextColor(this.gON, R.color.cp_cont_d, 1);
        an.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        an.setBackgroundColor(this.gOO, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.gOP, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.gOQ, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.gOT, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.gOU, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bOd();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gOL.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gOM.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gOU.setVisibility(0);
        } else {
            this.gOU.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gOT.setVisibility(0);
        } else {
            this.gOT.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gON.setVisibility(0);
            this.gOQ.setVisibility(0);
            this.gOP.setVisibility(0);
            this.gON.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gON.setTag(str);
                this.gON.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gON.setVisibility(8);
        this.gOQ.setVisibility(8);
        this.gOP.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gON == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bc.aWU().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void sJ(int i) {
        if (this.gOO != null && this.gOO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gOO.getLayoutParams();
            layoutParams.height = i;
            this.gOO.setLayoutParams(layoutParams);
        }
        if (this.gOP != null && this.gOP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gOP.getLayoutParams();
            layoutParams2.height = i;
            this.gOP.setLayoutParams(layoutParams2);
        }
        if (this.gOQ != null && this.gOQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gOQ.getLayoutParams();
            layoutParams3.height = i;
            this.gOQ.setLayoutParams(layoutParams3);
        }
    }

    public void lU(boolean z) {
        if (this.gOT != null) {
            this.gOT.setVisibility(z ? 0 : 8);
        }
    }
}
