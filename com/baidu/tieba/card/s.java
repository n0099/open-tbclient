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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eDh;
    private String eDj;
    private HeadImageView eEi;
    private TextView eEj;
    private TextView eEk;
    private TbImageView eEl;
    private TextView eEm;
    private o eEn;
    private int eEo;
    private String eEp;
    private String eEq;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eEo = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eDj = str;
        this.eEp = str2;
        this.eEq = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.eEi = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.eEj = (TextView) view.findViewById(R.id.promotion_name);
        this.eEk = (TextView) view.findViewById(R.id.promotion_desc);
        this.eEl = (TbImageView) view.findViewById(R.id.promotion_img);
        this.eEm = (TextView) view.findViewById(R.id.promotion_icon);
        this.eDh = view.findViewById(R.id.top_line);
        this.eEi.setOnClickListener(this);
        this.eEj.setOnClickListener(this);
        this.eEm.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eEi.setDefaultResource(17170445);
        this.eEi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eEi.setRadius(this.eEo);
        this.eEl.setDrawBorder(true);
        this.eEl.setBorderWidth(1);
        this.eEl.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.eEi || view == this.eEj || view == this.eEm) && !StringUtils.isNull(this.eEn.eGP)) {
            TiebaStatic.log(new an(this.eEp).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eEn.eGN)));
            bb.ajC().c(getTbPageContext(), new String[]{this.eEn.eGP});
        } else if ((view == this.mRootView || view == this.eEk || view == this.eEl) && !StringUtils.isNull(this.eEn.eGS)) {
            TiebaStatic.log(new an(this.eEq).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eEn.eGN)));
            bb.ajC().c(getTbPageContext(), new String[]{this.eEn.eGS});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.k(this.eEm, R.drawable.label_bg_gray);
            am.k(this.eDh, R.color.cp_bg_line_b);
            am.f(this.eEj, R.color.cp_cont_b, 1);
            am.f(this.eEm, R.color.cp_cont_d, 1);
            am.f(this.eEk, R.color.cp_cont_b, 1);
            this.eEi.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.eEl.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
        this.eEn = oVar;
        this.eEi.startLoad(oVar.eGO, 10, false);
        this.eEj.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eGU)) {
            this.eEm.setVisibility(8);
        } else {
            this.eEm.setVisibility(0);
            this.eEm.setText(oVar.eGU);
        }
        this.eEk.setText(oVar.eGQ);
        if (com.baidu.tbadk.core.i.aca().ace()) {
            this.eEl.setVisibility(0);
            this.eEl.startLoad(oVar.eGR, 10, false);
            return;
        }
        this.eEl.setVisibility(8);
    }
}
