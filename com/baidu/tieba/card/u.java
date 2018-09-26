package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private View cFm;
    private String cFo;
    private HeadImageView cGn;
    private TextView cGo;
    private TextView cGp;
    private TbImageView cGq;
    private TextView cGr;
    private com.baidu.tieba.card.data.o cGs;
    private int cGt;
    private String cGu;
    private String cGv;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cGt = tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds70);
        init(getView());
    }

    public void x(String str, String str2, String str3) {
        this.cFo = str;
        this.cGu = str2;
        this.cGv = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cGn = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cGo = (TextView) view.findViewById(e.g.promotion_name);
        this.cGp = (TextView) view.findViewById(e.g.promotion_desc);
        this.cGq = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cGr = (TextView) view.findViewById(e.g.promotion_icon);
        this.cFm = view.findViewById(e.g.top_line);
        this.cGn.setOnClickListener(this);
        this.cGo.setOnClickListener(this);
        this.cGr.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cGn.setDefaultResource(17170445);
        this.cGn.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cGn.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cGn.setRadius(this.cGt);
        this.cGq.setDrawBorder(true);
        this.cGq.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cGn || view == this.cGo || view == this.cGr) && !StringUtils.isNull(this.cGs.cIK)) {
            TiebaStatic.log(new am(this.cGu).al(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cGs.cII)));
            ay.AN().c(getTbPageContext(), new String[]{this.cGs.cIK});
        } else if ((view == this.mRootView || view == this.cGp || view == this.cGq) && !StringUtils.isNull(this.cGs.cIN)) {
            TiebaStatic.log(new am(this.cGv).al(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cGs.cII)));
            ay.AN().c(getTbPageContext(), new String[]{this.cGs.cIN});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cGr, e.f.label_bg_gray);
            al.i(this.cFm, e.d.cp_bg_line_b);
            al.c(this.cGo, e.d.cp_cont_b, 1);
            al.c(this.cGr, e.d.cp_cont_d, 1);
            al.c(this.cGp, e.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cGs = oVar;
        this.cGn.startLoad(oVar.cIJ, 10, false);
        this.cGo.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cIP)) {
            this.cGr.setVisibility(8);
        } else {
            this.cGr.setVisibility(0);
            this.cGr.setText(oVar.cIP);
        }
        this.cGp.setText(oVar.cIL);
        if (com.baidu.tbadk.core.i.uj().un()) {
            this.cGq.setVisibility(0);
            this.cGq.startLoad(oVar.cIM, 10, false);
            return;
        }
        this.cGq.setVisibility(8);
    }
}
