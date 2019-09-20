package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eEX;
    private String eEZ;
    private HeadImageView eFY;
    private TextView eFZ;
    private TextView eGa;
    private TbImageView eGb;
    private TextView eGc;
    private o eGd;
    private int eGe;
    private String eGf;
    private String eGg;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eGe = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void S(String str, String str2, String str3) {
        this.eEZ = str;
        this.eGf = str2;
        this.eGg = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.eFY = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.eFZ = (TextView) view.findViewById(R.id.promotion_name);
        this.eGa = (TextView) view.findViewById(R.id.promotion_desc);
        this.eGb = (TbImageView) view.findViewById(R.id.promotion_img);
        this.eGc = (TextView) view.findViewById(R.id.promotion_icon);
        this.eEX = view.findViewById(R.id.top_line);
        this.eFY.setOnClickListener(this);
        this.eFZ.setOnClickListener(this);
        this.eGc.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eFY.setDefaultResource(17170445);
        this.eFY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eFY.setRadius(this.eGe);
        this.eGb.setDrawBorder(true);
        this.eGb.setBorderWidth(1);
        this.eGb.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.eFY || view == this.eFZ || view == this.eGc) && !StringUtils.isNull(this.eGd.eIF)) {
            TiebaStatic.log(new an(this.eGf).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eGd.eID)));
            ba.ajK().c(getTbPageContext(), new String[]{this.eGd.eIF});
        } else if ((view == this.mRootView || view == this.eGa || view == this.eGb) && !StringUtils.isNull(this.eGd.eII)) {
            TiebaStatic.log(new an(this.eGg).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eGd.eID)));
            ba.ajK().c(getTbPageContext(), new String[]{this.eGd.eII});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.k(this.eGc, R.drawable.label_bg_gray);
            am.k(this.eEX, R.color.cp_bg_line_c);
            am.f(this.eFZ, R.color.cp_cont_b, 1);
            am.f(this.eGc, R.color.cp_cont_d, 1);
            am.f(this.eGa, R.color.cp_cont_b, 1);
            this.eFY.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.eGb.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eGd = oVar;
        this.eFY.startLoad(oVar.eIE, 10, false);
        this.eFZ.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eIK)) {
            this.eGc.setVisibility(8);
        } else {
            this.eGc.setVisibility(0);
            this.eGc.setText(oVar.eIK);
        }
        this.eGa.setText(oVar.eIG);
        if (com.baidu.tbadk.core.i.ace().aci()) {
            this.eGb.setVisibility(0);
            this.eGb.startLoad(oVar.eIH, 10, false);
            return;
        }
        this.eGb.setVisibility(8);
    }
}
