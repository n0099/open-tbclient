package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class q extends a<com.baidu.tieba.card.data.p> {
    private View cXJ;
    private String cXL;
    private HeadImageView cYL;
    private TextView cYM;
    private TextView cYN;
    private TbImageView cYO;
    private TextView cYP;
    private com.baidu.tieba.card.data.p cYQ;
    private int cYR;
    private String cYS;
    private String cYT;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cYR = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void z(String str, String str2, String str3) {
        this.cXL = str;
        this.cYS = str2;
        this.cYT = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cYL = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cYM = (TextView) view.findViewById(d.g.promotion_name);
        this.cYN = (TextView) view.findViewById(d.g.promotion_desc);
        this.cYO = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cYP = (TextView) view.findViewById(d.g.promotion_icon);
        this.cXJ = view.findViewById(d.g.top_line);
        this.cYL.setOnClickListener(this);
        this.cYM.setOnClickListener(this);
        this.cYP.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cYL.setDefaultResource(17170445);
        this.cYL.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cYL.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cYL.setRadius(this.cYR);
        this.cYO.setDrawBorder(true);
        this.cYO.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cYL || view == this.cYM || view == this.cYP) && !StringUtils.isNull(this.cYQ.dbd)) {
            TiebaStatic.log(new ak(this.cYS).ab("obj_id", String.valueOf(this.cYQ.dbb)));
            aw.Du().c(akO(), new String[]{this.cYQ.dbd});
        } else if ((view == this.mRootView || view == this.cYN || view == this.cYO) && !StringUtils.isNull(this.cYQ.dbg)) {
            TiebaStatic.log(new ak(this.cYT).ab("obj_id", String.valueOf(this.cYQ.dbb)));
            aw.Du().c(akO(), new String[]{this.cYQ.dbg});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cYP, d.f.label_bg_gray);
            aj.s(this.cXJ, d.C0140d.cp_bg_line_b);
            aj.e(this.cYM, d.C0140d.cp_cont_b, 1);
            aj.e(this.cYP, d.C0140d.cp_cont_d, 1);
            aj.e(this.cYN, d.C0140d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cYQ = pVar;
        this.cYL.startLoad(pVar.dbc, 10, false);
        this.cYM.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.dbi)) {
            this.cYP.setVisibility(8);
        } else {
            this.cYP.setVisibility(0);
            this.cYP.setText(pVar.dbi);
        }
        this.cYN.setText(pVar.dbe);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            this.cYO.setVisibility(0);
            this.cYO.startLoad(pVar.dbf, 10, false);
            return;
        }
        this.cYO.setVisibility(8);
    }
}
