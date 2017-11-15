package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private View bTG;
    private String bTI;
    private HeadImageView bUi;
    private TextView bUj;
    private TextView bUk;
    private TbImageView bUl;
    private TextView bUm;
    private q bUn;
    private int bUo;
    private String bUp;
    private String bUq;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bUo = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void u(String str, String str2, String str3) {
        this.bTI = str;
        this.bUp = str2;
        this.bUq = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.bUi = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.bUj = (TextView) view.findViewById(d.g.promotion_name);
        this.bUk = (TextView) view.findViewById(d.g.promotion_desc);
        this.bUl = (TbImageView) view.findViewById(d.g.promotion_img);
        this.bUm = (TextView) view.findViewById(d.g.promotion_icon);
        this.bTG = view.findViewById(d.g.top_line);
        this.bUi.setOnClickListener(this);
        this.bUj.setOnClickListener(this);
        this.bUm.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bUi.setDefaultResource(17170445);
        this.bUi.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bUi.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.bUi.setRadius(this.bUo);
        this.bUl.setDrawBorder(true);
        this.bUl.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bUi || view == this.bUj || view == this.bUm) && !StringUtils.isNull(this.bUn.bWa)) {
            TiebaStatic.log(new ak(this.bUp).ac("obj_id", String.valueOf(this.bUn.bVY)));
            av.vI().c(ZI(), new String[]{this.bUn.bWa});
        } else if ((view == this.mRootView || view == this.bUk || view == this.bUl) && !StringUtils.isNull(this.bUn.bWd)) {
            TiebaStatic.log(new ak(this.bUq).ac("obj_id", String.valueOf(this.bUn.bVY)));
            av.vI().c(ZI(), new String[]{this.bUn.bWd});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.addresslist_item_bg);
            aj.j(this.bUm, d.f.label_bg_gray);
            aj.j(this.bTG, d.C0080d.cp_bg_line_b);
            aj.c(this.bUj, d.C0080d.cp_cont_b, 1);
            aj.c(this.bUm, d.C0080d.cp_cont_d, 1);
            aj.c(this.bUk, d.C0080d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bUn = qVar;
        this.bUi.startLoad(qVar.bVZ, 10, false);
        this.bUj.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bWf)) {
            this.bUm.setVisibility(8);
        } else {
            this.bUm.setVisibility(0);
            this.bUm.setText(qVar.bWf);
        }
        this.bUk.setText(qVar.bWb);
        if (com.baidu.tbadk.core.h.oT().oZ()) {
            this.bUl.setVisibility(0);
            this.bUl.startLoad(qVar.bWc, 10, false);
            return;
        }
        this.bUl.setVisibility(8);
    }
}
