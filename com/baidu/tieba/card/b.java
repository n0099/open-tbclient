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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cmW;
    protected TextView cmX;
    public TextView cmY;
    public TextView cmZ;
    private View cna;
    private View cnb;
    private View cnc;
    public ImageView cnd;
    public LinearLayout cne;
    public View cnf;
    public View cng;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmW = null;
        this.cmX = null;
        this.cmY = null;
        this.cmZ = null;
        this.cna = null;
        this.cnb = null;
        this.cnc = null;
        this.cne = null;
        Y(getView());
    }

    private void Y(View view2) {
        this.cmW = (RelativeLayout) view2.findViewById(d.g.item_layout_group_title);
        this.cmX = (TextView) view2.findViewById(d.g.item_group_title);
        this.cmY = (TextView) view2.findViewById(d.g.item_right_tv);
        this.cmZ = (TextView) view2.findViewById(d.g.item_bottom_more_tv);
        this.cna = view2.findViewById(d.g.divider_line_top);
        this.cnb = view2.findViewById(d.g.divider_line_middle);
        this.cnc = view2.findViewById(d.g.divider_line_bottom);
        this.cne = (LinearLayout) view2.findViewById(d.g.card_container);
        this.cnf = view2.findViewById(d.g.divider_card);
        this.cng = view2.findViewById(d.g.divider_card_top);
        this.cnd = (ImageView) view2.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void afa() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            ak.c(this.cmX, d.C0126d.cp_cont_d, 1);
            this.cnd.setVisibility(8);
        } else {
            ak.c(this.cmX, d.C0126d.cp_cont_f, 1);
            ak.c(this.cnd, d.f.icon_arrow_tab);
        }
        ak.c(this.cmY, d.C0126d.cp_link_tip_c, 1);
        ak.c(this.cmZ, d.C0126d.cp_cont_d, 1);
        ak.j(getView(), d.C0126d.cp_bg_line_d);
        ak.j(this.cna, d.C0126d.cp_bg_line_c);
        ak.j(this.cnb, d.C0126d.cp_bg_line_c);
        ak.j(this.cnc, d.C0126d.cp_bg_line_c);
        ak.j(this.cnf, d.C0126d.cp_bg_line_c);
        ak.j(this.cng, d.C0126d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            afa();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cmX.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cmY.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cng.setVisibility(0);
        } else {
            this.cng.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cnf.setVisibility(0);
        } else {
            this.cnf.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cmZ.setVisibility(0);
            this.cnc.setVisibility(0);
            this.cnb.setVisibility(0);
            this.cmZ.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cmZ.setTag(str);
                this.cmZ.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cmZ.setVisibility(8);
        this.cnc.setVisibility(8);
        this.cnb.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.cmZ == view2 && view2 != null && (view2.getTag() instanceof String)) {
            String str = (String) view2.getTag();
            if (!StringUtils.isNull(str)) {
                ax.wf().c(aeY(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.i.card_group;
    }

    public void iG(int i) {
        if (this.cna != null && this.cna.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cna.getLayoutParams();
            layoutParams.height = i;
            this.cna.setLayoutParams(layoutParams);
        }
        if (this.cnb != null && this.cnb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cnb.getLayoutParams();
            layoutParams2.height = i;
            this.cnb.setLayoutParams(layoutParams2);
        }
        if (this.cnc != null && this.cnc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cnc.getLayoutParams();
            layoutParams3.height = i;
            this.cnc.setLayoutParams(layoutParams3);
        }
    }

    public void en(boolean z) {
        if (this.cnf != null) {
            this.cnf.setVisibility(z ? 0 : 8);
        }
    }
}
