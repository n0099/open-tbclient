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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public TextView cLA;
    public TextView cLB;
    private View cLC;
    private View cLD;
    private View cLE;
    public ImageView cLF;
    public LinearLayout cLG;
    public View cLH;
    public View cLI;
    protected RelativeLayout cLy;
    protected TextView cLz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cLy = null;
        this.cLz = null;
        this.cLA = null;
        this.cLB = null;
        this.cLC = null;
        this.cLD = null;
        this.cLE = null;
        this.cLG = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cLy = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cLz = (TextView) view.findViewById(e.g.item_group_title);
        this.cLA = (TextView) view.findViewById(e.g.item_right_tv);
        this.cLB = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cLC = view.findViewById(e.g.divider_line_top);
        this.cLD = view.findViewById(e.g.divider_line_middle);
        this.cLE = view.findViewById(e.g.divider_line_bottom);
        this.cLG = (LinearLayout) view.findViewById(e.g.card_container);
        this.cLH = view.findViewById(e.g.divider_card);
        this.cLI = view.findViewById(e.g.divider_card_top);
        this.cLF = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void anr() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cLz, e.d.cp_cont_d, 1);
            this.cLF.setVisibility(8);
        } else {
            al.c(this.cLz, e.d.cp_cont_f, 1);
            al.c(this.cLF, e.f.icon_arrow_tab);
        }
        al.c(this.cLA, e.d.cp_link_tip_c, 1);
        al.c(this.cLB, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cLC, e.d.cp_bg_line_c);
        al.j(this.cLD, e.d.cp_bg_line_c);
        al.j(this.cLE, e.d.cp_bg_line_c);
        al.j(this.cLH, e.d.cp_bg_line_c);
        al.j(this.cLI, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            anr();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cLz.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cLA.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cLI.setVisibility(0);
        } else {
            this.cLI.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cLH.setVisibility(0);
        } else {
            this.cLH.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cLB.setVisibility(0);
            this.cLE.setVisibility(0);
            this.cLD.setVisibility(0);
            this.cLB.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cLB.setTag(str);
                this.cLB.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cLB.setVisibility(8);
        this.cLE.setVisibility(8);
        this.cLD.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cLB == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.Db().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void kf(int i) {
        if (this.cLC != null && this.cLC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cLC.getLayoutParams();
            layoutParams.height = i;
            this.cLC.setLayoutParams(layoutParams);
        }
        if (this.cLD != null && this.cLD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cLD.getLayoutParams();
            layoutParams2.height = i;
            this.cLD.setLayoutParams(layoutParams2);
        }
        if (this.cLE != null && this.cLE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cLE.getLayoutParams();
            layoutParams3.height = i;
            this.cLE.setLayoutParams(layoutParams3);
        }
    }

    public void fl(boolean z) {
        if (this.cLH != null) {
            this.cLH.setVisibility(z ? 0 : 8);
        }
    }
}
