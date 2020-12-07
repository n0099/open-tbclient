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
/* loaded from: classes22.dex */
public class s extends b<com.baidu.tieba.card.data.o> {
    private View ijX;
    private String ika;
    private HeadImageView ilb;
    private TextView ilc;
    private TextView ild;
    private TbImageView ile;
    private TextView ilf;
    private com.baidu.tieba.card.data.o ilg;
    private int ilh;
    private String ili;
    private String ilj;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ilh = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void az(String str, String str2, String str3) {
        this.ika = str;
        this.ili = str2;
        this.ilj = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.ilb = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.ilc = (TextView) view.findViewById(R.id.promotion_name);
        this.ild = (TextView) view.findViewById(R.id.promotion_desc);
        this.ile = (TbImageView) view.findViewById(R.id.promotion_img);
        this.ilf = (TextView) view.findViewById(R.id.promotion_icon);
        this.ijX = view.findViewById(R.id.top_line);
        this.ilb.setOnClickListener(this);
        this.ilc.setOnClickListener(this);
        this.ilf.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ilb.setDefaultResource(17170445);
        this.ilb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ilb.setPlaceHolder(1);
        this.ilb.setRadius(this.ilh);
        this.ile.setDrawBorder(true);
        this.ile.setBorderWidth(1);
        this.ile.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ilb || view == this.ilc || view == this.ilf) && !StringUtils.isNull(this.ilg.iog)) {
            TiebaStatic.log(new ar(this.ili).dY("obj_id", String.valueOf(this.ilg.ioe)));
            bf.bua().b(getTbPageContext(), new String[]{this.ilg.iog});
        } else if ((view == this.mRootView || view == this.ild || view == this.ile) && !StringUtils.isNull(this.ilg.ioj)) {
            TiebaStatic.log(new ar(this.ilj).dY("obj_id", String.valueOf(this.ilg.ioe)));
            bf.bua().b(getTbPageContext(), new String[]{this.ilg.ioj});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.ilf, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.ijX, R.color.CAM_X0204);
            ap.setViewTextColor(this.ilc, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ilf, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ild, R.color.CAM_X0105, 1);
            this.ilb.setPlaceHolder(1);
            this.ile.setPlaceHolder(2);
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
        this.ilg = oVar;
        this.ilb.startLoad(oVar.iof, 10, false);
        this.ilc.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iol)) {
            this.ilf.setVisibility(8);
        } else {
            this.ilf.setVisibility(0);
            this.ilf.setText(oVar.iol);
        }
        this.ild.setText(oVar.ioh);
        if (com.baidu.tbadk.core.k.blV().isShowImages()) {
            this.ile.setVisibility(0);
            this.ile.startLoad(oVar.ioi, 10, false);
            return;
        }
        this.ile.setVisibility(8);
    }
}
