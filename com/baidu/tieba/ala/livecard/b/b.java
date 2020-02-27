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
    private View bZR;
    private TbPageContext<?> cVg;
    private View eNM;
    private TextView eNN;
    private TextView eNO;
    private TextView eNP;
    private RelativeLayout eNQ;
    private final View.OnClickListener eNR;
    private RelativeLayout eNj;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.buE() != null) {
                    b.this.buE().a(view, b.this.KJ);
                    TiebaStatic.log(new an("c11844").cy("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.KJ.getFid()));
                }
            }
        };
        this.cVg = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eNM = view.findViewById(R.id.recommend_left_line);
        this.bZR = view.findViewById(R.id.recommend_right_line);
        this.eNj = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eNN = (TextView) view.findViewById(R.id.ala_live_title);
        this.eNO = (TextView) view.findViewById(R.id.start_live_btn);
        this.eNQ = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eNP = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNO, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eNO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eNj, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNM, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bZR, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eNN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNP, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eNQ, R.color.cp_bg_line_d);
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
        if (!this.KJ.cTE) {
            this.eNP.setVisibility(8);
            this.eNM.setVisibility(8);
            this.bZR.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eNQ.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cVg.getPageActivity()) / 4;
            this.eNQ.setLayoutParams(layoutParams);
        } else {
            this.eNP.setVisibility(0);
            this.eNM.setVisibility(0);
            this.bZR.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eNQ.getLayoutParams();
            layoutParams2.height = this.cVg.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eNQ.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eNO.setOnClickListener(this.eNR);
    }
}
