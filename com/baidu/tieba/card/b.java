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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout euU;
    protected TextView euV;
    public TextView euW;
    public TextView euX;
    private View euY;
    private View euZ;
    private View eva;
    public ImageView evb;
    public LinearLayout evc;
    public View evd;
    public View eve;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.euU = null;
        this.euV = null;
        this.euW = null;
        this.euX = null;
        this.euY = null;
        this.euZ = null;
        this.eva = null;
        this.evc = null;
        O(getView());
    }

    private void O(View view) {
        this.euU = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.euV = (TextView) view.findViewById(R.id.item_group_title);
        this.euW = (TextView) view.findViewById(R.id.item_right_tv);
        this.euX = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.euY = view.findViewById(R.id.divider_line_top);
        this.euZ = view.findViewById(R.id.divider_line_middle);
        this.eva = view.findViewById(R.id.divider_line_bottom);
        this.evc = (LinearLayout) view.findViewById(R.id.card_container);
        this.evd = view.findViewById(R.id.divider_card);
        this.eve = view.findViewById(R.id.divider_card_top);
        this.evb = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aXp() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.f(this.euV, R.color.cp_cont_d, 1);
            this.evb.setVisibility(8);
        } else {
            al.f(this.euV, R.color.cp_cont_f, 1);
            al.c(this.evb, (int) R.drawable.icon_arrow_tab);
        }
        al.f(this.euW, R.color.cp_link_tip_c, 1);
        al.f(this.euX, R.color.cp_cont_d, 1);
        al.l(getView(), R.color.cp_bg_line_d);
        al.l(this.euY, R.color.cp_bg_line_c);
        al.l(this.euZ, R.color.cp_bg_line_c);
        al.l(this.eva, R.color.cp_bg_line_c);
        al.l(this.evd, R.color.cp_bg_line_c);
        al.l(this.eve, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aXp();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.euV.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.euW.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eve.setVisibility(0);
        } else {
            this.eve.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.evd.setVisibility(0);
        } else {
            this.evd.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.euX.setVisibility(0);
            this.eva.setVisibility(0);
            this.euZ.setVisibility(0);
            this.euX.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.euX.setTag(str);
                this.euX.setOnClickListener(this);
                return;
            }
            return;
        }
        this.euX.setVisibility(8);
        this.eva.setVisibility(8);
        this.euZ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.euX == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aiz().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void pj(int i) {
        if (this.euY != null && this.euY.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.euY.getLayoutParams();
            layoutParams.height = i;
            this.euY.setLayoutParams(layoutParams);
        }
        if (this.euZ != null && this.euZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.euZ.getLayoutParams();
            layoutParams2.height = i;
            this.euZ.setLayoutParams(layoutParams2);
        }
        if (this.eva != null && this.eva.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eva.getLayoutParams();
            layoutParams3.height = i;
            this.eva.setLayoutParams(layoutParams3);
        }
    }

    public void io(boolean z) {
        if (this.evd != null) {
            this.evd.setVisibility(z ? 0 : 8);
        }
    }
}
