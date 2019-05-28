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
    protected RelativeLayout euV;
    protected TextView euW;
    public TextView euX;
    public TextView euY;
    private View euZ;
    private View eva;
    private View evb;
    public ImageView evc;
    public LinearLayout evd;
    public View eve;
    public View evf;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.euV = null;
        this.euW = null;
        this.euX = null;
        this.euY = null;
        this.euZ = null;
        this.eva = null;
        this.evb = null;
        this.evd = null;
        O(getView());
    }

    private void O(View view) {
        this.euV = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.euW = (TextView) view.findViewById(R.id.item_group_title);
        this.euX = (TextView) view.findViewById(R.id.item_right_tv);
        this.euY = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.euZ = view.findViewById(R.id.divider_line_top);
        this.eva = view.findViewById(R.id.divider_line_middle);
        this.evb = view.findViewById(R.id.divider_line_bottom);
        this.evd = (LinearLayout) view.findViewById(R.id.card_container);
        this.eve = view.findViewById(R.id.divider_card);
        this.evf = view.findViewById(R.id.divider_card_top);
        this.evc = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aXs() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.f(this.euW, R.color.cp_cont_d, 1);
            this.evc.setVisibility(8);
        } else {
            al.f(this.euW, R.color.cp_cont_f, 1);
            al.c(this.evc, (int) R.drawable.icon_arrow_tab);
        }
        al.f(this.euX, R.color.cp_link_tip_c, 1);
        al.f(this.euY, R.color.cp_cont_d, 1);
        al.l(getView(), R.color.cp_bg_line_d);
        al.l(this.euZ, R.color.cp_bg_line_c);
        al.l(this.eva, R.color.cp_bg_line_c);
        al.l(this.evb, R.color.cp_bg_line_c);
        al.l(this.eve, R.color.cp_bg_line_c);
        al.l(this.evf, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aXs();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.euW.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.euX.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.evf.setVisibility(0);
        } else {
            this.evf.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eve.setVisibility(0);
        } else {
            this.eve.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.euY.setVisibility(0);
            this.evb.setVisibility(0);
            this.eva.setVisibility(0);
            this.euY.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.euY.setTag(str);
                this.euY.setOnClickListener(this);
                return;
            }
            return;
        }
        this.euY.setVisibility(8);
        this.evb.setVisibility(8);
        this.eva.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.euY == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.euZ != null && this.euZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.euZ.getLayoutParams();
            layoutParams.height = i;
            this.euZ.setLayoutParams(layoutParams);
        }
        if (this.eva != null && this.eva.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.eva.getLayoutParams();
            layoutParams2.height = i;
            this.eva.setLayoutParams(layoutParams2);
        }
        if (this.evb != null && this.evb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.evb.getLayoutParams();
            layoutParams3.height = i;
            this.evb.setLayoutParams(layoutParams3);
        }
    }

    public void io(boolean z) {
        if (this.eve != null) {
            this.eve.setVisibility(z ? 0 : 8);
        }
    }
}
