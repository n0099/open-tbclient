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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<bw> implements y {
    private bw agf;
    private View dfw;
    private TbPageContext<?> ehG;
    private View gmM;
    private TextView gmN;
    private TextView gmO;
    private TextView gmP;
    private RelativeLayout gmQ;
    private final View.OnClickListener gmR;
    private RelativeLayout gmj;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agf != null && b.this.ceP() != null) {
                    b.this.ceP().a(view, b.this.agf);
                    TiebaStatic.log(new aq("c11844").dF("uid", TbadkCoreApplication.getCurrentAccount()).u("fid", b.this.agf.getFid()));
                }
            }
        };
        this.ehG = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gmM = view.findViewById(R.id.recommend_left_line);
        this.dfw = view.findViewById(R.id.recommend_right_line);
        this.gmj = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gmN = (TextView) view.findViewById(R.id.ala_live_title);
        this.gmO = (TextView) view.findViewById(R.id.start_live_btn);
        this.gmQ = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gmP = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmO, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gmO, R.color.cp_cont_a);
            ap.setBackgroundColor(this.gmj, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gmM, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.dfw, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gmN, R.color.cp_cont_d);
            ap.setViewTextColor(this.gmP, R.color.cp_cont_c);
            ap.setBackgroundColor(this.gmQ, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.agf = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.agf.efH) {
            this.gmP.setVisibility(8);
            this.gmM.setVisibility(8);
            this.dfw.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gmQ.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.ehG.getPageActivity()) / 4;
            this.gmQ.setLayoutParams(layoutParams);
        } else {
            this.gmP.setVisibility(0);
            this.gmM.setVisibility(0);
            this.dfw.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gmQ.getLayoutParams();
            layoutParams2.height = this.ehG.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gmQ.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gmO.setOnClickListener(this.gmR);
    }
}
