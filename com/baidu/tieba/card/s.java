package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class s extends b<com.baidu.tieba.card.data.o> {
    private View hZa;
    private String hZd;
    private HeadImageView iaf;
    private TextView iag;
    private TextView iah;
    private TbImageView iai;
    private TextView iaj;
    private com.baidu.tieba.card.data.o iak;
    private int ial;
    private String iam;
    private String ian;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ial = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ax(String str, String str2, String str3) {
        this.hZd = str;
        this.iam = str2;
        this.ian = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.iaf = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.iag = (TextView) view.findViewById(R.id.promotion_name);
        this.iah = (TextView) view.findViewById(R.id.promotion_desc);
        this.iai = (TbImageView) view.findViewById(R.id.promotion_img);
        this.iaj = (TextView) view.findViewById(R.id.promotion_icon);
        this.hZa = view.findViewById(R.id.top_line);
        this.iaf.setOnClickListener(this);
        this.iag.setOnClickListener(this);
        this.iaj.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.iaf.setDefaultResource(17170445);
        this.iaf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iaf.setPlaceHolder(1);
        this.iaf.setRadius(this.ial);
        this.iai.setDrawBorder(true);
        this.iai.setBorderWidth(1);
        this.iai.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iaf || view == this.iag || view == this.iaj) && !StringUtils.isNull(this.iak.idi)) {
            TiebaStatic.log(new ar(this.iam).dR("obj_id", String.valueOf(this.iak.idg)));
            bf.bqF().b(getTbPageContext(), new String[]{this.iak.idi});
        } else if ((view == this.mRootView || view == this.iah || view == this.iai) && !StringUtils.isNull(this.iak.idm)) {
            TiebaStatic.log(new ar(this.ian).dR("obj_id", String.valueOf(this.iak.idg)));
            bf.bqF().b(getTbPageContext(), new String[]{this.iak.idm});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.iaj, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hZa, R.color.CAM_X0204);
            ap.setViewTextColor(this.iag, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iaj, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iah, R.color.CAM_X0105, 1);
            this.iaf.setPlaceHolder(1);
            this.iai.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.iak = oVar;
        this.iaf.startLoad(oVar.idh, 10, false);
        this.iag.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.ido)) {
            this.iaj.setVisibility(8);
        } else {
            this.iaj.setVisibility(0);
            this.iaj.setText(oVar.ido);
        }
        this.iah.setText(oVar.idj);
        if (com.baidu.tbadk.core.k.biL().isShowImages()) {
            this.iai.setVisibility(0);
            this.iai.startLoad(oVar.idk, 10, false);
            return;
        }
        this.iai.setVisibility(8);
    }
}
