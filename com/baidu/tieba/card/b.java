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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cVj;
    protected TextView cVk;
    public TextView cVl;
    public TextView cVm;
    private View cVn;
    private View cVo;
    private View cVp;
    public ImageView cVq;
    public LinearLayout cVr;
    public View cVs;
    public View cVt;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVj = null;
        this.cVk = null;
        this.cVl = null;
        this.cVm = null;
        this.cVn = null;
        this.cVo = null;
        this.cVp = null;
        this.cVr = null;
        bu(getView());
    }

    private void bu(View view) {
        this.cVj = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cVk = (TextView) view.findViewById(d.g.item_group_title);
        this.cVl = (TextView) view.findViewById(d.g.item_right_tv);
        this.cVm = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cVn = view.findViewById(d.g.divider_line_top);
        this.cVo = view.findViewById(d.g.divider_line_middle);
        this.cVp = view.findViewById(d.g.divider_line_bottom);
        this.cVr = (LinearLayout) view.findViewById(d.g.card_container);
        this.cVs = view.findViewById(d.g.divider_card);
        this.cVt = view.findViewById(d.g.divider_card_top);
        this.cVq = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akP() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            aj.e(this.cVk, d.C0141d.cp_cont_d, 1);
            this.cVq.setVisibility(8);
        } else {
            aj.e(this.cVk, d.C0141d.cp_cont_f, 1);
            aj.c(this.cVq, d.f.icon_arrow_tab);
        }
        aj.e(this.cVl, d.C0141d.cp_link_tip_c, 1);
        aj.e(this.cVm, d.C0141d.cp_cont_d, 1);
        aj.t(getView(), d.C0141d.cp_bg_line_d);
        aj.t(this.cVn, d.C0141d.cp_bg_line_c);
        aj.t(this.cVo, d.C0141d.cp_bg_line_c);
        aj.t(this.cVp, d.C0141d.cp_bg_line_c);
        aj.t(this.cVs, d.C0141d.cp_bg_line_c);
        aj.t(this.cVt, d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akP();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cVk.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cVl.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVt.setVisibility(0);
        } else {
            this.cVt.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVs.setVisibility(0);
        } else {
            this.cVs.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cVm.setVisibility(0);
            this.cVp.setVisibility(0);
            this.cVo.setVisibility(0);
            this.cVm.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cVm.setTag(str);
                this.cVm.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cVm.setVisibility(8);
        this.cVp.setVisibility(8);
        this.cVo.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVm == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                aw.Dt().c(akN(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lz(int i) {
        if (this.cVn != null && this.cVn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVn.getLayoutParams();
            layoutParams.height = i;
            this.cVn.setLayoutParams(layoutParams);
        }
        if (this.cVo != null && this.cVo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVo.getLayoutParams();
            layoutParams2.height = i;
            this.cVo.setLayoutParams(layoutParams2);
        }
        if (this.cVp != null && this.cVp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVp.getLayoutParams();
            layoutParams3.height = i;
            this.cVp.setLayoutParams(layoutParams3);
        }
    }

    public void eH(boolean z) {
        if (this.cVs != null) {
            this.cVs.setVisibility(z ? 0 : 8);
        }
    }
}
