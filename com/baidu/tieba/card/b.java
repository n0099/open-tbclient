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
    protected RelativeLayout clP;
    protected TextView clQ;
    public TextView clR;
    public TextView clS;
    private View clT;
    private View clU;
    private View clV;
    public ImageView clW;
    public LinearLayout clX;
    public View clY;
    public View clZ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.clP = null;
        this.clQ = null;
        this.clR = null;
        this.clS = null;
        this.clT = null;
        this.clU = null;
        this.clV = null;
        this.clX = null;
        Y(getView());
    }

    private void Y(View view2) {
        this.clP = (RelativeLayout) view2.findViewById(d.g.item_layout_group_title);
        this.clQ = (TextView) view2.findViewById(d.g.item_group_title);
        this.clR = (TextView) view2.findViewById(d.g.item_right_tv);
        this.clS = (TextView) view2.findViewById(d.g.item_bottom_more_tv);
        this.clT = view2.findViewById(d.g.divider_line_top);
        this.clU = view2.findViewById(d.g.divider_line_middle);
        this.clV = view2.findViewById(d.g.divider_line_bottom);
        this.clX = (LinearLayout) view2.findViewById(d.g.card_container);
        this.clY = view2.findViewById(d.g.divider_card);
        this.clZ = view2.findViewById(d.g.divider_card_top);
        this.clW = (ImageView) view2.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void afa() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            ak.c(this.clQ, d.C0126d.cp_cont_d, 1);
            this.clW.setVisibility(8);
        } else {
            ak.c(this.clQ, d.C0126d.cp_cont_f, 1);
            ak.c(this.clW, d.f.icon_arrow_tab);
        }
        ak.c(this.clR, d.C0126d.cp_link_tip_c, 1);
        ak.c(this.clS, d.C0126d.cp_cont_d, 1);
        ak.j(getView(), d.C0126d.cp_bg_line_d);
        ak.j(this.clT, d.C0126d.cp_bg_line_c);
        ak.j(this.clU, d.C0126d.cp_bg_line_c);
        ak.j(this.clV, d.C0126d.cp_bg_line_c);
        ak.j(this.clY, d.C0126d.cp_bg_line_c);
        ak.j(this.clZ, d.C0126d.cp_bg_line_c);
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
        this.clQ.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.clR.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.clZ.setVisibility(0);
        } else {
            this.clZ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.clY.setVisibility(0);
        } else {
            this.clY.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.clS.setVisibility(0);
            this.clV.setVisibility(0);
            this.clU.setVisibility(0);
            this.clS.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.clS.setTag(str);
                this.clS.setOnClickListener(this);
                return;
            }
            return;
        }
        this.clS.setVisibility(8);
        this.clV.setVisibility(8);
        this.clU.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.clS == view2 && view2 != null && (view2.getTag() instanceof String)) {
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
        if (this.clT != null && this.clT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.clT.getLayoutParams();
            layoutParams.height = i;
            this.clT.setLayoutParams(layoutParams);
        }
        if (this.clU != null && this.clU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.clU.getLayoutParams();
            layoutParams2.height = i;
            this.clU.setLayoutParams(layoutParams2);
        }
        if (this.clV != null && this.clV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.clV.getLayoutParams();
            layoutParams3.height = i;
            this.clV.setLayoutParams(layoutParams3);
        }
    }

    public void em(boolean z) {
        if (this.clY != null) {
            this.clY.setVisibility(z ? 0 : 8);
        }
    }
}
