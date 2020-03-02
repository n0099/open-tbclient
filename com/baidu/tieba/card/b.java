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
    protected RelativeLayout fHi;
    protected TextView fHj;
    public TextView fHk;
    public TextView fHl;
    private View fHm;
    private View fHn;
    private View fHo;
    public ImageView fHp;
    public LinearLayout fHq;
    public View fHr;
    public View fHs;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fHi = null;
        this.fHj = null;
        this.fHk = null;
        this.fHl = null;
        this.fHm = null;
        this.fHn = null;
        this.fHo = null;
        this.fHq = null;
        initView(getView());
    }

    private void initView(View view) {
        this.fHi = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.fHj = (TextView) view.findViewById(R.id.item_group_title);
        this.fHk = (TextView) view.findViewById(R.id.item_right_tv);
        this.fHl = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.fHm = view.findViewById(R.id.divider_line_top);
        this.fHn = view.findViewById(R.id.divider_line_middle);
        this.fHo = view.findViewById(R.id.divider_line_bottom);
        this.fHq = (LinearLayout) view.findViewById(R.id.card_container);
        this.fHr = view.findViewById(R.id.divider_card);
        this.fHs = view.findViewById(R.id.divider_card_top);
        this.fHp = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void buH() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.fHj, R.color.cp_cont_d, 1);
            this.fHp.setVisibility(8);
        } else {
            am.setViewTextColor(this.fHj, R.color.cp_cont_f, 1);
            am.setImageResource(this.fHp, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.fHk, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.fHl, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fHm, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHn, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHo, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHr, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fHs, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            buH();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.fHj.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.fHk.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.fHs.setVisibility(0);
        } else {
            this.fHs.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.fHr.setVisibility(0);
        } else {
            this.fHr.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.fHl.setVisibility(0);
            this.fHo.setVisibility(0);
            this.fHn.setVisibility(0);
            this.fHl.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.fHl.setTag(str);
                this.fHl.setOnClickListener(this);
                return;
            }
            return;
        }
        this.fHl.setVisibility(8);
        this.fHo.setVisibility(8);
        this.fHn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fHl == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.fHm != null && this.fHm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fHm.getLayoutParams();
            layoutParams.height = i;
            this.fHm.setLayoutParams(layoutParams);
        }
        if (this.fHn != null && this.fHn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.fHn.getLayoutParams();
            layoutParams2.height = i;
            this.fHn.setLayoutParams(layoutParams2);
        }
        if (this.fHo != null && this.fHo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.fHo.getLayoutParams();
            layoutParams3.height = i;
            this.fHo.setLayoutParams(layoutParams3);
        }
    }

    public void kh(boolean z) {
        if (this.fHr != null) {
            this.fHr.setVisibility(z ? 0 : 8);
        }
    }
}
