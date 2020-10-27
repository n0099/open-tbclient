package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class s extends b<com.baidu.tieba.card.data.p> {
    private View hSD;
    private String hSG;
    private HeadImageView hTH;
    private TextView hTI;
    private TextView hTJ;
    private TbImageView hTK;
    private TextView hTL;
    private com.baidu.tieba.card.data.p hTM;
    private int hTN;
    private String hTO;
    private String hTP;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hTN = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aw(String str, String str2, String str3) {
        this.hSG = str;
        this.hTO = str2;
        this.hTP = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hTH = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hTI = (TextView) view.findViewById(R.id.promotion_name);
        this.hTJ = (TextView) view.findViewById(R.id.promotion_desc);
        this.hTK = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hTL = (TextView) view.findViewById(R.id.promotion_icon);
        this.hSD = view.findViewById(R.id.top_line);
        this.hTH.setOnClickListener(this);
        this.hTI.setOnClickListener(this);
        this.hTL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hTH.setDefaultResource(17170445);
        this.hTH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hTH.setPlaceHolder(1);
        this.hTH.setRadius(this.hTN);
        this.hTK.setDrawBorder(true);
        this.hTK.setBorderWidth(1);
        this.hTK.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hTH || view == this.hTI || view == this.hTL) && !StringUtils.isNull(this.hTM.hWw)) {
            TiebaStatic.log(new aq(this.hTO).dR("obj_id", String.valueOf(this.hTM.hWu)));
            be.boR().b(getTbPageContext(), new String[]{this.hTM.hWw});
        } else if ((view == this.mRootView || view == this.hTJ || view == this.hTK) && !StringUtils.isNull(this.hTM.hWz)) {
            TiebaStatic.log(new aq(this.hTP).dR("obj_id", String.valueOf(this.hTM.hWu)));
            be.boR().b(getTbPageContext(), new String[]{this.hTM.hWz});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hTL, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hSD, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hTI, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hTL, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hTJ, R.color.cp_cont_b, 1);
            this.hTH.setPlaceHolder(1);
            this.hTK.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hTM = pVar;
        this.hTH.startLoad(pVar.hWv, 10, false);
        this.hTI.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.hWB)) {
            this.hTL.setVisibility(8);
        } else {
            this.hTL.setVisibility(0);
            this.hTL.setText(pVar.hWB);
        }
        this.hTJ.setText(pVar.hWx);
        if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
            this.hTK.setVisibility(0);
            this.hTK.startLoad(pVar.hWy, 10, false);
            return;
        }
        this.hTK.setVisibility(8);
    }
}
