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
/* loaded from: classes7.dex */
public class q extends a<com.baidu.tieba.card.data.o> {
    private View fHK;
    private String fHN;
    private HeadImageView fIL;
    private TextView fIM;
    private TextView fIN;
    private TbImageView fIO;
    private TextView fIP;
    private com.baidu.tieba.card.data.o fIQ;
    private int fIR;
    private String fIS;
    private String fIT;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fIR = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ai(String str, String str2, String str3) {
        this.fHN = str;
        this.fIS = str2;
        this.fIT = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fIL = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fIM = (TextView) view.findViewById(R.id.promotion_name);
        this.fIN = (TextView) view.findViewById(R.id.promotion_desc);
        this.fIO = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fIP = (TextView) view.findViewById(R.id.promotion_icon);
        this.fHK = view.findViewById(R.id.top_line);
        this.fIL.setOnClickListener(this);
        this.fIM.setOnClickListener(this);
        this.fIP.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fIL.setDefaultResource(17170445);
        this.fIL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIL.setPlaceHolder(1);
        this.fIL.setRadius(this.fIR);
        this.fIO.setDrawBorder(true);
        this.fIO.setBorderWidth(1);
        this.fIO.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fIL || view == this.fIM || view == this.fIP) && !StringUtils.isNull(this.fIQ.fLz)) {
            TiebaStatic.log(new an(this.fIS).cp("obj_id", String.valueOf(this.fIQ.fLx)));
            ba.aEt().b(getTbPageContext(), new String[]{this.fIQ.fLz});
        } else if ((view == this.mRootView || view == this.fIN || view == this.fIO) && !StringUtils.isNull(this.fIQ.fLC)) {
            TiebaStatic.log(new an(this.fIT).cp("obj_id", String.valueOf(this.fIQ.fLx)));
            ba.aEt().b(getTbPageContext(), new String[]{this.fIQ.fLC});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fIP, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fHK, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fIM, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fIP, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fIN, R.color.cp_cont_b, 1);
            this.fIL.setPlaceHolder(1);
            this.fIO.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
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
        this.fIQ = oVar;
        this.fIL.startLoad(oVar.fLy, 10, false);
        this.fIM.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fLE)) {
            this.fIP.setVisibility(8);
        } else {
            this.fIP.setVisibility(0);
            this.fIP.setText(oVar.fLE);
        }
        this.fIN.setText(oVar.fLA);
        if (com.baidu.tbadk.core.i.axy().isShowImages()) {
            this.fIO.setVisibility(0);
            this.fIO.startLoad(oVar.fLB, 10, false);
            return;
        }
        this.fIO.setVisibility(8);
    }
}
