package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class al extends a<com.baidu.tieba.card.a.s> {
    private View aPe;
    private String aPh;
    private HeadImageView aPj;
    private TextView aPk;
    private TextView aPl;
    private TbImageView aPm;
    private TextView aPn;
    private com.baidu.tieba.card.a.s aPo;
    private int aPp;
    private String aPq;
    private String aPr;
    private View mRootView;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPp = tbPageContext.getResources().getDimensionPixelSize(n.e.ds70);
        z(getView());
    }

    public void n(String str, String str2, String str3) {
        this.aPh = str;
        this.aPq = str2;
        this.aPr = str3;
    }

    private void z(View view) {
        this.mRootView = view.findViewById(n.g.root_view);
        this.aPj = (HeadImageView) view.findViewById(n.g.promotion_head_img);
        this.aPk = (TextView) view.findViewById(n.g.promotion_name);
        this.aPl = (TextView) view.findViewById(n.g.promotion_desc);
        this.aPm = (TbImageView) view.findViewById(n.g.promotion_img);
        this.aPn = (TextView) view.findViewById(n.g.promotion_icon);
        this.aPe = view.findViewById(n.g.top_line);
        this.aPj.setOnClickListener(this);
        this.aPk.setOnClickListener(this);
        this.aPn.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aPj.setDefaultResource(17170445);
        this.aPj.setDefaultBgResource(n.f.icon_default_avatar_round);
        this.aPj.setRadius(this.aPp);
        this.aPm.setDrawBorder(true);
        this.aPm.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aPj || view == this.aPk || view == this.aPn) && !StringUtils.isNull(this.aPo.aQL)) {
            TiebaStatic.log(new av(this.aPq).aa("obj_id", String.valueOf(this.aPo.aQJ)));
            bf.vn().b(Ie(), new String[]{this.aPo.aQL});
        } else if ((view == this.mRootView || view == this.aPl || view == this.aPm) && !StringUtils.isNull(this.aPo.aQO)) {
            TiebaStatic.log(new av(this.aPr).aa("obj_id", String.valueOf(this.aPo.aQJ)));
            bf.vn().b(Ie(), new String[]{this.aPo.aQO});
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.i(this.mRootView, n.f.addresslist_item_bg);
            as.i((View) this.aPn, n.f.label_bg_gray);
            as.i(this.aPe, n.d.cp_bg_line_b);
            as.b(this.aPk, n.d.cp_cont_b, 1);
            as.b(this.aPn, n.d.cp_cont_d, 1);
            as.b(this.aPl, n.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.s sVar) {
        if (sVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aPo = sVar;
        am.Iq().a(new av(this.aPh).aa("obj_id", String.valueOf(this.aPo.aQJ)));
        this.aPj.d(sVar.aQK, 10, false);
        this.aPk.setText(UtilHelper.getFixedText(sVar.userName, 7, true));
        if (StringUtils.isNull(sVar.aQQ)) {
            this.aPn.setVisibility(8);
        } else {
            this.aPn.setVisibility(0);
            this.aPn.setText(sVar.aQQ);
        }
        this.aPl.setText(sVar.aQM);
        if (com.baidu.tbadk.core.m.qQ().qW()) {
            this.aPm.setVisibility(0);
            this.aPm.d(sVar.aQN, 10, false);
            return;
        }
        this.aPm.setVisibility(8);
    }
}
