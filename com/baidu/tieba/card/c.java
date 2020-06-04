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
    protected RelativeLayout gBU;
    protected TextView gBV;
    public TextView gBW;
    public TextView gBX;
    private View gBY;
    private View gBZ;
    private View gCa;
    public ImageView gCb;
    public LinearLayout gCc;
    public View gCd;
    public View gCe;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gBU = null;
        this.gBV = null;
        this.gBW = null;
        this.gBX = null;
        this.gBY = null;
        this.gBZ = null;
        this.gCa = null;
        this.gCc = null;
        ag(getView());
    }

    private void ag(View view) {
        this.gBU = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gBV = (TextView) view.findViewById(R.id.item_group_title);
        this.gBW = (TextView) view.findViewById(R.id.item_right_tv);
        this.gBX = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gBY = view.findViewById(R.id.divider_line_top);
        this.gBZ = view.findViewById(R.id.divider_line_middle);
        this.gCa = view.findViewById(R.id.divider_line_bottom);
        this.gCc = (LinearLayout) view.findViewById(R.id.card_container);
        this.gCd = view.findViewById(R.id.divider_card);
        this.gCe = view.findViewById(R.id.divider_card_top);
        this.gCb = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bKV() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.gBV, R.color.cp_cont_d, 1);
            this.gCb.setVisibility(8);
        } else {
            am.setViewTextColor(this.gBV, R.color.cp_cont_f, 1);
            am.setImageResource(this.gCb, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.gBW, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.gBX, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gBY, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gBZ, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gCa, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gCd, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gCe, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bKV();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gBV.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gBW.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gCe.setVisibility(0);
        } else {
            this.gCe.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gCd.setVisibility(0);
        } else {
            this.gCd.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gBX.setVisibility(0);
            this.gCa.setVisibility(0);
            this.gBZ.setVisibility(0);
            this.gBX.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gBX.setTag(str);
                this.gBX.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gBX.setVisibility(8);
        this.gCa.setVisibility(8);
        this.gBZ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBX == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aVa().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void sl(int i) {
        if (this.gBY != null && this.gBY.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gBY.getLayoutParams();
            layoutParams.height = i;
            this.gBY.setLayoutParams(layoutParams);
        }
        if (this.gBZ != null && this.gBZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gBZ.getLayoutParams();
            layoutParams2.height = i;
            this.gBZ.setLayoutParams(layoutParams2);
        }
        if (this.gCa != null && this.gCa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gCa.getLayoutParams();
            layoutParams3.height = i;
            this.gCa.setLayoutParams(layoutParams3);
        }
    }

    public void lL(boolean z) {
        if (this.gCd != null) {
            this.gCd.setVisibility(z ? 0 : 8);
        }
    }
}
