package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<bj> implements x {
    private bj KJ;
    private View bZS;
    private TbPageContext<?> cVh;
    private View eNN;
    private TextView eNO;
    private TextView eNP;
    private TextView eNQ;
    private RelativeLayout eNR;
    private final View.OnClickListener eNS;
    private RelativeLayout eNk;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.buG() != null) {
                    b.this.buG().a(view, b.this.KJ);
                    TiebaStatic.log(new an("c11844").cy("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.KJ.getFid()));
                }
            }
        };
        this.cVh = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eNN = view.findViewById(R.id.recommend_left_line);
        this.bZS = view.findViewById(R.id.recommend_right_line);
        this.eNk = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eNO = (TextView) view.findViewById(R.id.ala_live_title);
        this.eNP = (TextView) view.findViewById(R.id.start_live_btn);
        this.eNR = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eNQ = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNP, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eNP, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eNk, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNN, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bZS, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eNO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNQ, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eNR, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.KJ = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.KJ.cTF) {
            this.eNQ.setVisibility(8);
            this.eNN.setVisibility(8);
            this.bZS.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eNR.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cVh.getPageActivity()) / 4;
            this.eNR.setLayoutParams(layoutParams);
        } else {
            this.eNQ.setVisibility(0);
            this.eNN.setVisibility(0);
            this.bZS.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eNR.getLayoutParams();
            layoutParams2.height = this.cVh.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eNR.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eNP.setOnClickListener(this.eNS);
    }
}
