package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class r extends b<com.baidu.tieba.card.data.o> {
    private View gEG;
    private String gEJ;
    private HeadImageView gFH;
    private TextView gFI;
    private TextView gFJ;
    private TbImageView gFK;
    private TextView gFL;
    private com.baidu.tieba.card.data.o gFM;
    private int gFN;
    private String gFO;
    private String gFP;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gFN = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void al(String str, String str2, String str3) {
        this.gEJ = str;
        this.gFO = str2;
        this.gFP = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gFH = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gFI = (TextView) view.findViewById(R.id.promotion_name);
        this.gFJ = (TextView) view.findViewById(R.id.promotion_desc);
        this.gFK = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gFL = (TextView) view.findViewById(R.id.promotion_icon);
        this.gEG = view.findViewById(R.id.top_line);
        this.gFH.setOnClickListener(this);
        this.gFI.setOnClickListener(this);
        this.gFL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gFH.setDefaultResource(17170445);
        this.gFH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gFH.setPlaceHolder(1);
        this.gFH.setRadius(this.gFN);
        this.gFK.setDrawBorder(true);
        this.gFK.setBorderWidth(1);
        this.gFK.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gFH || view == this.gFI || view == this.gFL) && !StringUtils.isNull(this.gFM.gIq)) {
            TiebaStatic.log(new an(this.gFO).dh("obj_id", String.valueOf(this.gFM.gIo)));
            ba.aUZ().b(getTbPageContext(), new String[]{this.gFM.gIq});
        } else if ((view == this.mRootView || view == this.gFJ || view == this.gFK) && !StringUtils.isNull(this.gFM.gIt)) {
            TiebaStatic.log(new an(this.gFP).dh("obj_id", String.valueOf(this.gFM.gIo)));
            ba.aUZ().b(getTbPageContext(), new String[]{this.gFM.gIt});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.gFL, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.gEG, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gFI, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gFL, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gFJ, R.color.cp_cont_b, 1);
            this.gFH.setPlaceHolder(1);
            this.gFK.setPlaceHolder(2);
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
        this.gFM = oVar;
        this.gFH.startLoad(oVar.gIp, 10, false);
        this.gFI.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.gIv)) {
            this.gFL.setVisibility(8);
        } else {
            this.gFL.setVisibility(0);
            this.gFL.setText(oVar.gIv);
        }
        this.gFJ.setText(oVar.gIr);
        if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
            this.gFK.setVisibility(0);
            this.gFK.startLoad(oVar.gIs, 10, false);
            return;
        }
        this.gFK.setVisibility(8);
    }
}
