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
    protected RelativeLayout clM;
    protected TextView clN;
    public TextView clO;
    public TextView clP;
    private View clQ;
    private View clR;
    private View clS;
    public ImageView clT;
    public LinearLayout clU;
    public View clV;
    public View clW;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.clM = null;
        this.clN = null;
        this.clO = null;
        this.clP = null;
        this.clQ = null;
        this.clR = null;
        this.clS = null;
        this.clU = null;
        Y(getView());
    }

    private void Y(View view2) {
        this.clM = (RelativeLayout) view2.findViewById(d.g.item_layout_group_title);
        this.clN = (TextView) view2.findViewById(d.g.item_group_title);
        this.clO = (TextView) view2.findViewById(d.g.item_right_tv);
        this.clP = (TextView) view2.findViewById(d.g.item_bottom_more_tv);
        this.clQ = view2.findViewById(d.g.divider_line_top);
        this.clR = view2.findViewById(d.g.divider_line_middle);
        this.clS = view2.findViewById(d.g.divider_line_bottom);
        this.clU = (LinearLayout) view2.findViewById(d.g.card_container);
        this.clV = view2.findViewById(d.g.divider_card);
        this.clW = view2.findViewById(d.g.divider_card_top);
        this.clT = (ImageView) view2.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void afa() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            ak.c(this.clN, d.C0126d.cp_cont_d, 1);
            this.clT.setVisibility(8);
        } else {
            ak.c(this.clN, d.C0126d.cp_cont_f, 1);
            ak.c(this.clT, d.f.icon_arrow_tab);
        }
        ak.c(this.clO, d.C0126d.cp_link_tip_c, 1);
        ak.c(this.clP, d.C0126d.cp_cont_d, 1);
        ak.j(getView(), d.C0126d.cp_bg_line_d);
        ak.j(this.clQ, d.C0126d.cp_bg_line_c);
        ak.j(this.clR, d.C0126d.cp_bg_line_c);
        ak.j(this.clS, d.C0126d.cp_bg_line_c);
        ak.j(this.clV, d.C0126d.cp_bg_line_c);
        ak.j(this.clW, d.C0126d.cp_bg_line_c);
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
        this.clN.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.clO.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.clW.setVisibility(0);
        } else {
            this.clW.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.clV.setVisibility(0);
        } else {
            this.clV.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.clP.setVisibility(0);
            this.clS.setVisibility(0);
            this.clR.setVisibility(0);
            this.clP.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.clP.setTag(str);
                this.clP.setOnClickListener(this);
                return;
            }
            return;
        }
        this.clP.setVisibility(8);
        this.clS.setVisibility(8);
        this.clR.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.clP == view2 && view2 != null && (view2.getTag() instanceof String)) {
            String str = (String) view2.getTag();
            if (!StringUtils.isNull(str)) {
                ax.wg().c(aeY(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.i.card_group;
    }

    public void iH(int i) {
        if (this.clQ != null && this.clQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.clQ.getLayoutParams();
            layoutParams.height = i;
            this.clQ.setLayoutParams(layoutParams);
        }
        if (this.clR != null && this.clR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.clR.getLayoutParams();
            layoutParams2.height = i;
            this.clR.setLayoutParams(layoutParams2);
        }
        if (this.clS != null && this.clS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.clS.getLayoutParams();
            layoutParams3.height = i;
            this.clS.setLayoutParams(layoutParams3);
        }
    }

    public void em(boolean z) {
        if (this.clV != null) {
            this.clV.setVisibility(z ? 0 : 8);
        }
    }
}
