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
    private HeadImageView bTV;
    private TextView bTW;
    private TextView bTX;
    private TbImageView bTY;
    private TextView bTZ;
    private View bTt;
    private String bTv;
    private q bUa;
    private int bUb;
    private String bUc;
    private String bUd;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bUb = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void u(String str, String str2, String str3) {
        this.bTv = str;
        this.bUc = str2;
        this.bUd = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.bTV = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.bTW = (TextView) view.findViewById(d.g.promotion_name);
        this.bTX = (TextView) view.findViewById(d.g.promotion_desc);
        this.bTY = (TbImageView) view.findViewById(d.g.promotion_img);
        this.bTZ = (TextView) view.findViewById(d.g.promotion_icon);
        this.bTt = view.findViewById(d.g.top_line);
        this.bTV.setOnClickListener(this);
        this.bTW.setOnClickListener(this);
        this.bTZ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bTV.setDefaultResource(17170445);
        this.bTV.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bTV.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.bTV.setRadius(this.bUb);
        this.bTY.setDrawBorder(true);
        this.bTY.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bTV || view == this.bTW || view == this.bTZ) && !StringUtils.isNull(this.bUa.bVN)) {
            TiebaStatic.log(new ak(this.bUc).ac("obj_id", String.valueOf(this.bUa.bVL)));
            av.vI().c(Zw(), new String[]{this.bUa.bVN});
        } else if ((view == this.mRootView || view == this.bTX || view == this.bTY) && !StringUtils.isNull(this.bUa.bVQ)) {
            TiebaStatic.log(new ak(this.bUd).ac("obj_id", String.valueOf(this.bUa.bVL)));
            av.vI().c(Zw(), new String[]{this.bUa.bVQ});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.addresslist_item_bg);
            aj.j(this.bTZ, d.f.label_bg_gray);
            aj.j(this.bTt, d.C0080d.cp_bg_line_b);
            aj.c(this.bTW, d.C0080d.cp_cont_b, 1);
            aj.c(this.bTZ, d.C0080d.cp_cont_d, 1);
            aj.c(this.bTX, d.C0080d.cp_cont_b, 1);
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
        this.bUa = qVar;
        this.bTV.startLoad(qVar.bVM, 10, false);
        this.bTW.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bVS)) {
            this.bTZ.setVisibility(8);
        } else {
            this.bTZ.setVisibility(0);
            this.bTZ.setText(qVar.bVS);
        }
        this.bTX.setText(qVar.bVO);
        if (com.baidu.tbadk.core.h.oT().oZ()) {
            this.bTY.setVisibility(0);
            this.bTY.startLoad(qVar.bVP, 10, false);
            return;
        }
        this.bTY.setVisibility(8);
    }
}
