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
    protected RelativeLayout fHg;
    protected TextView fHh;
    public TextView fHi;
    public TextView fHj;
    private View fHk;
    private View fHl;
    private View fHm;
    public ImageView fHn;
    public LinearLayout fHo;
    public View fHp;
    public View fHq;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fHg = null;
        this.fHh = null;
        this.fHi = null;
        this.fHj = null;
        this.fHk = null;
        this.fHl = null;
        this.fHm = null;
        this.fHo = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fHg = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fHh = (TextView) view.findViewById(R.id.item_group_title);
        this.fHi = (TextView) view.findViewById(R.id.item_right_tv);
        this.fHj = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fHk = view.findViewById(R.id.divider_line_top);
        this.fHl = view.findViewById(R.id.divider_line_middle);
        this.fHm = view.findViewById(R.id.divider_line_bottom);
        this.fHo = (LinearLayout) view.findViewById(R.id.card_container);
        this.fHp = view.findViewById(R.id.divider_card);
        this.fHq = view.findViewById(R.id.divider_card_top);
        this.fHn = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void buF() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fHh, R.color.cp_cont_d, 1);
            this.fHn.setVisibility(8);
        } else {
            am.setViewTextColor(this.fHh, R.color.cp_cont_f, 1);
            am.setImageResource(this.fHn, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fHi, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fHj, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fHk, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHl, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHm, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHp, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHq, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            buF();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fHh.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fHi.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fHq.setVisibility(0);
        } else {
            this.fHq.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fHp.setVisibility(0);
        } else {
            this.fHp.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fHj.setVisibility(0);
            this.fHm.setVisibility(0);
            this.fHl.setVisibility(0);
            this.fHj.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fHj.setTag(str);
                this.fHj.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fHj.setVisibility(8);
        this.fHm.setVisibility(8);
        this.fHl.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fHj == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aGE().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void rl(int i) {
        if (this.fHk != null && this.fHk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fHk.getLayoutParams();
            layoutParams.height = i;
            this.fHk.setLayoutParams(layoutParams);
        }
        if (this.fHl != null && this.fHl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fHl.getLayoutParams();
            layoutParams2.height = i;
            this.fHl.setLayoutParams(layoutParams2);
        }
        if (this.fHm != null && this.fHm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fHm.getLayoutParams();
            layoutParams3.height = i;
            this.fHm.setLayoutParams(layoutParams3);
        }
    }

    public void kh(boolean z) {
        if (this.fHp != null) {
            this.fHp.setVisibility(z ? 0 : 8);
        }
    }
}
