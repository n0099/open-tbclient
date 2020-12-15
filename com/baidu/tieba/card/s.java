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
    private View ijZ;
    private String ikc;
    private HeadImageView ild;
    private TextView ile;
    private TextView ilf;
    private TbImageView ilg;
    private TextView ilh;
    private com.baidu.tieba.card.data.o ili;
    private int ilj;
    private String ilk;
    private String ill;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ilj = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void az(String str, String str2, String str3) {
        this.ikc = str;
        this.ilk = str2;
        this.ill = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.ild = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.ile = (TextView) view.findViewById(R.id.promotion_name);
        this.ilf = (TextView) view.findViewById(R.id.promotion_desc);
        this.ilg = (TbImageView) view.findViewById(R.id.promotion_img);
        this.ilh = (TextView) view.findViewById(R.id.promotion_icon);
        this.ijZ = view.findViewById(R.id.top_line);
        this.ild.setOnClickListener(this);
        this.ile.setOnClickListener(this);
        this.ilh.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ild.setDefaultResource(17170445);
        this.ild.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ild.setPlaceHolder(1);
        this.ild.setRadius(this.ilj);
        this.ilg.setDrawBorder(true);
        this.ilg.setBorderWidth(1);
        this.ilg.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ild || view == this.ile || view == this.ilh) && !StringUtils.isNull(this.ili.ioi)) {
            TiebaStatic.log(new ar(this.ilk).dY("obj_id", String.valueOf(this.ili.iog)));
            bf.bua().b(getTbPageContext(), new String[]{this.ili.ioi});
        } else if ((view == this.mRootView || view == this.ilf || view == this.ilg) && !StringUtils.isNull(this.ili.iol)) {
            TiebaStatic.log(new ar(this.ill).dY("obj_id", String.valueOf(this.ili.iog)));
            bf.bua().b(getTbPageContext(), new String[]{this.ili.iol});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.ilh, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.ijZ, R.color.CAM_X0204);
            ap.setViewTextColor(this.ile, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ilh, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ilf, R.color.CAM_X0105, 1);
            this.ild.setPlaceHolder(1);
            this.ilg.setPlaceHolder(2);
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
        this.ili = oVar;
        this.ild.startLoad(oVar.ioh, 10, false);
        this.ile.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.ion)) {
            this.ilh.setVisibility(8);
        } else {
            this.ilh.setVisibility(0);
            this.ilh.setText(oVar.ion);
        }
        this.ilf.setText(oVar.ioj);
        if (com.baidu.tbadk.core.k.blV().isShowImages()) {
            this.ilg.setVisibility(0);
            this.ilg.startLoad(oVar.iok, 10, false);
            return;
        }
        this.ilg.setVisibility(8);
    }
}
