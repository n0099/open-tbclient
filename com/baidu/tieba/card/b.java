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
    protected RelativeLayout cVm;
    protected TextView cVn;
    public TextView cVo;
    public TextView cVp;
    private View cVq;
    private View cVr;
    private View cVs;
    public ImageView cVt;
    public LinearLayout cVu;
    public View cVv;
    public View cVw;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVm = null;
        this.cVn = null;
        this.cVo = null;
        this.cVp = null;
        this.cVq = null;
        this.cVr = null;
        this.cVs = null;
        this.cVu = null;
        bu(getView());
    }

    private void bu(View view) {
        this.cVm = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cVn = (TextView) view.findViewById(d.g.item_group_title);
        this.cVo = (TextView) view.findViewById(d.g.item_right_tv);
        this.cVp = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cVq = view.findViewById(d.g.divider_line_top);
        this.cVr = view.findViewById(d.g.divider_line_middle);
        this.cVs = view.findViewById(d.g.divider_line_bottom);
        this.cVu = (LinearLayout) view.findViewById(d.g.card_container);
        this.cVv = view.findViewById(d.g.divider_card);
        this.cVw = view.findViewById(d.g.divider_card_top);
        this.cVt = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akQ() {
        if (getFrom() != null && getFrom().equals(CmdObject.CMD_HOME)) {
            aj.e(this.cVn, d.C0141d.cp_cont_d, 1);
            this.cVt.setVisibility(8);
        } else {
            aj.e(this.cVn, d.C0141d.cp_cont_f, 1);
            aj.c(this.cVt, d.f.icon_arrow_tab);
        }
        aj.e(this.cVo, d.C0141d.cp_link_tip_c, 1);
        aj.e(this.cVp, d.C0141d.cp_cont_d, 1);
        aj.t(getView(), d.C0141d.cp_bg_line_d);
        aj.t(this.cVq, d.C0141d.cp_bg_line_c);
        aj.t(this.cVr, d.C0141d.cp_bg_line_c);
        aj.t(this.cVs, d.C0141d.cp_bg_line_c);
        aj.t(this.cVv, d.C0141d.cp_bg_line_c);
        aj.t(this.cVw, d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akQ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cVn.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cVo.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVw.setVisibility(0);
        } else {
            this.cVw.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVv.setVisibility(0);
        } else {
            this.cVv.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cVp.setVisibility(0);
            this.cVs.setVisibility(0);
            this.cVr.setVisibility(0);
            this.cVp.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cVp.setTag(str);
                this.cVp.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cVp.setVisibility(8);
        this.cVs.setVisibility(8);
        this.cVr.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVp == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                aw.Du().c(akO(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lz(int i) {
        if (this.cVq != null && this.cVq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVq.getLayoutParams();
            layoutParams.height = i;
            this.cVq.setLayoutParams(layoutParams);
        }
        if (this.cVr != null && this.cVr.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVr.getLayoutParams();
            layoutParams2.height = i;
            this.cVr.setLayoutParams(layoutParams2);
        }
        if (this.cVs != null && this.cVs.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVs.getLayoutParams();
            layoutParams3.height = i;
            this.cVs.setLayoutParams(layoutParams3);
        }
    }

    public void eH(boolean z) {
        if (this.cVv != null) {
            this.cVv.setVisibility(z ? 0 : 8);
        }
    }
}
