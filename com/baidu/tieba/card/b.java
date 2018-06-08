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
import com.baidu.tieba.d;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cvB;
    protected TextView cvC;
    public TextView cvD;
    public TextView cvE;
    private View cvF;
    private View cvG;
    private View cvH;
    public ImageView cvI;
    public LinearLayout cvJ;
    public View cvK;
    public View cvL;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cvB = null;
        this.cvC = null;
        this.cvD = null;
        this.cvE = null;
        this.cvF = null;
        this.cvG = null;
        this.cvH = null;
        this.cvJ = null;
        Y(getView());
    }

    private void Y(View view) {
        this.cvB = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cvC = (TextView) view.findViewById(d.g.item_group_title);
        this.cvD = (TextView) view.findViewById(d.g.item_right_tv);
        this.cvE = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cvF = view.findViewById(d.g.divider_line_top);
        this.cvG = view.findViewById(d.g.divider_line_middle);
        this.cvH = view.findViewById(d.g.divider_line_bottom);
        this.cvJ = (LinearLayout) view.findViewById(d.g.card_container);
        this.cvK = view.findViewById(d.g.divider_card);
        this.cvL = view.findViewById(d.g.divider_card_top);
        this.cvI = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aiJ() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            al.c(this.cvC, d.C0141d.cp_cont_d, 1);
            this.cvI.setVisibility(8);
        } else {
            al.c(this.cvC, d.C0141d.cp_cont_f, 1);
            al.c(this.cvI, d.f.icon_arrow_tab);
        }
        al.c(this.cvD, d.C0141d.cp_link_tip_c, 1);
        al.c(this.cvE, d.C0141d.cp_cont_d, 1);
        al.j(getView(), d.C0141d.cp_bg_line_d);
        al.j(this.cvF, d.C0141d.cp_bg_line_c);
        al.j(this.cvG, d.C0141d.cp_bg_line_c);
        al.j(this.cvH, d.C0141d.cp_bg_line_c);
        al.j(this.cvK, d.C0141d.cp_bg_line_c);
        al.j(this.cvL, d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aiJ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cvC.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cvD.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cvL.setVisibility(0);
        } else {
            this.cvL.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cvK.setVisibility(0);
        } else {
            this.cvK.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cvE.setVisibility(0);
            this.cvH.setVisibility(0);
            this.cvG.setVisibility(0);
            this.cvE.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cvE.setTag(str);
                this.cvE.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cvE.setVisibility(8);
        this.cvH.setVisibility(8);
        this.cvG.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cvE == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.zG().c(aiH(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.i.card_group;
    }

    public void iH(int i) {
        if (this.cvF != null && this.cvF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cvF.getLayoutParams();
            layoutParams.height = i;
            this.cvF.setLayoutParams(layoutParams);
        }
        if (this.cvG != null && this.cvG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cvG.getLayoutParams();
            layoutParams2.height = i;
            this.cvG.setLayoutParams(layoutParams2);
        }
        if (this.cvH != null && this.cvH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cvH.getLayoutParams();
            layoutParams3.height = i;
            this.cvH.setLayoutParams(layoutParams3);
        }
    }

    public void er(boolean z) {
        if (this.cvK != null) {
            this.cvK.setVisibility(z ? 0 : 8);
        }
    }
}
