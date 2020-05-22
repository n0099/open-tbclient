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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<bk> implements y {
    private bk aee;
    private View cMe;
    private TbPageContext<?> dIF;
    private View fGP;
    private TextView fGQ;
    private TextView fGR;
    private TextView fGS;
    private RelativeLayout fGT;
    private final View.OnClickListener fGU;
    private RelativeLayout fGm;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aee != null && b.this.bKS() != null) {
                    b.this.bKS().a(view, b.this.aee);
                    TiebaStatic.log(new an("c11844").dh("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.aee.getFid()));
                }
            }
        };
        this.dIF = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fGP = view.findViewById(R.id.recommend_left_line);
        this.cMe = view.findViewById(R.id.recommend_right_line);
        this.fGm = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fGQ = (TextView) view.findViewById(R.id.ala_live_title);
        this.fGR = (TextView) view.findViewById(R.id.start_live_btn);
        this.fGT = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fGS = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGR, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.fGR, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fGm, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fGP, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cMe, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fGQ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fGS, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.fGT, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        this.aee = bkVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aee.dHb) {
            this.fGS.setVisibility(8);
            this.fGP.setVisibility(8);
            this.cMe.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fGT.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.dIF.getPageActivity()) / 4;
            this.fGT.setLayoutParams(layoutParams);
        } else {
            this.fGS.setVisibility(0);
            this.fGP.setVisibility(0);
            this.cMe.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.fGT.getLayoutParams();
            layoutParams2.height = this.dIF.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.fGT.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.fGR.setOnClickListener(this.fGU);
    }
}
