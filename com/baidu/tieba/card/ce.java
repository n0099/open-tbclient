package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ce extends a<com.baidu.tieba.card.data.q> {
    private View bCT;
    private String bCV;
    private HeadImageView bDm;
    private TextView bDn;
    private TextView bDo;
    private TbImageView bDp;
    private TextView bDq;
    private com.baidu.tieba.card.data.q bDr;
    private int bDs;
    private String bDt;
    private String bDu;
    private View mRootView;

    public ce(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bDs = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        S(getView());
    }

    public void x(String str, String str2, String str3) {
        this.bCV = str;
        this.bDt = str2;
        this.bDu = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.bDm = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.bDn = (TextView) view.findViewById(w.h.promotion_name);
        this.bDo = (TextView) view.findViewById(w.h.promotion_desc);
        this.bDp = (TbImageView) view.findViewById(w.h.promotion_img);
        this.bDq = (TextView) view.findViewById(w.h.promotion_icon);
        this.bCT = view.findViewById(w.h.top_line);
        this.bDm.setOnClickListener(this);
        this.bDn.setOnClickListener(this);
        this.bDq.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bDm.setDefaultResource(17170445);
        this.bDm.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bDm.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bDm.setRadius(this.bDs);
        this.bDp.setDrawBorder(true);
        this.bDp.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bDm || view == this.bDn || view == this.bDq) && !StringUtils.isNull(this.bDr.bEY)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.bDt).Z("obj_id", String.valueOf(this.bDr.bEW)));
            com.baidu.tbadk.core.util.be.vP().c(Vr(), new String[]{this.bDr.bEY});
        } else if ((view == this.mRootView || view == this.bDo || view == this.bDp) && !StringUtils.isNull(this.bDr.bFb)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.bDu).Z("obj_id", String.valueOf(this.bDr.bEW)));
            com.baidu.tbadk.core.util.be.vP().c(Vr(), new String[]{this.bDr.bFb});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.as.j(this.bDq, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.as.j(this.bCT, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.c(this.bDn, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.c(this.bDq, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.as.c(this.bDo, w.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bDr = qVar;
        this.bDm.c(qVar.bEX, 10, false);
        this.bDn.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bFd)) {
            this.bDq.setVisibility(8);
        } else {
            this.bDq.setVisibility(0);
            this.bDq.setText(qVar.bFd);
        }
        this.bDo.setText(qVar.bEZ);
        if (com.baidu.tbadk.core.r.oK().oQ()) {
            this.bDp.setVisibility(0);
            this.bDp.c(qVar.bFa, 10, false);
            return;
        }
        this.bDp.setVisibility(8);
    }
}
