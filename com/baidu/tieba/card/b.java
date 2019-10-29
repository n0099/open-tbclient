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
    public LinearLayout eKA;
    public View eKB;
    public View eKC;
    protected RelativeLayout eKs;
    protected TextView eKt;
    public TextView eKu;
    public TextView eKv;
    private View eKw;
    private View eKx;
    private View eKy;
    public ImageView eKz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eKs = null;
        this.eKt = null;
        this.eKu = null;
        this.eKv = null;
        this.eKw = null;
        this.eKx = null;
        this.eKy = null;
        this.eKA = null;
        W(getView());
    }

    private void W(View view) {
        this.eKs = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.eKt = (TextView) view.findViewById(R.id.item_group_title);
        this.eKu = (TextView) view.findViewById(R.id.item_right_tv);
        this.eKv = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.eKw = view.findViewById(R.id.divider_line_top);
        this.eKx = view.findViewById(R.id.divider_line_middle);
        this.eKy = view.findViewById(R.id.divider_line_bottom);
        this.eKA = (LinearLayout) view.findViewById(R.id.card_container);
        this.eKB = view.findViewById(R.id.divider_card);
        this.eKC = view.findViewById(R.id.divider_card_top);
        this.eKz = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aZY() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.eKt, R.color.cp_cont_d, 1);
            this.eKz.setVisibility(8);
        } else {
            am.setViewTextColor(this.eKt, R.color.cp_cont_f, 1);
            am.setImageResource(this.eKz, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.eKu, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.eKv, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.eKw, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eKx, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eKy, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eKB, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.eKC, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aZY();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.eKt.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.eKu.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eKC.setVisibility(0);
        } else {
            this.eKC.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eKB.setVisibility(0);
        } else {
            this.eKB.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.eKv.setVisibility(0);
            this.eKy.setVisibility(0);
            this.eKx.setVisibility(0);
            this.eKv.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.eKv.setTag(str);
                this.eKv.setOnClickListener(this);
                return;
            }
            return;
        }
        this.eKv.setVisibility(8);
        this.eKy.setVisibility(8);
        this.eKx.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKv == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.amQ().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void oH(int i) {
        if (this.eKw != null && this.eKw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eKw.getLayoutParams();
            layoutParams.height = i;
            this.eKw.setLayoutParams(layoutParams);
        }
        if (this.eKx != null && this.eKx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.eKx.getLayoutParams();
            layoutParams2.height = i;
            this.eKx.setLayoutParams(layoutParams2);
        }
        if (this.eKy != null && this.eKy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eKy.getLayoutParams();
            layoutParams3.height = i;
            this.eKy.setLayoutParams(layoutParams3);
        }
    }

    public void iD(boolean z) {
        if (this.eKB != null) {
            this.eKB.setVisibility(z ? 0 : 8);
        }
    }
}
