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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<bv> implements y {
    private bv aeA;
    private View cUp;
    private TbPageContext<?> dVN;
    private RelativeLayout fWZ;
    private View fXC;
    private TextView fXD;
    private TextView fXE;
    private TextView fXF;
    private RelativeLayout fXG;
    private final View.OnClickListener fXH;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aeA != null && b.this.bRn() != null) {
                    b.this.bRn().a(view, b.this.aeA);
                    TiebaStatic.log(new ap("c11844").dn("uid", TbadkCoreApplication.getCurrentAccount()).t("fid", b.this.aeA.getFid()));
                }
            }
        };
        this.dVN = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fXC = view.findViewById(R.id.recommend_left_line);
        this.cUp = view.findViewById(R.id.recommend_right_line);
        this.fWZ = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fXD = (TextView) view.findViewById(R.id.ala_live_title);
        this.fXE = (TextView) view.findViewById(R.id.start_live_btn);
        this.fXG = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fXF = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fXE, R.drawable.ala_live_card_start_live_selector);
            ao.setViewTextColor(this.fXE, R.color.cp_cont_a);
            ao.setBackgroundColor(this.fWZ, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.fXC, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.cUp, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.fXD, R.color.cp_cont_d);
            ao.setViewTextColor(this.fXF, R.color.cp_cont_c);
            ao.setBackgroundColor(this.fXG, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        this.aeA = bvVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aeA.dTX) {
            this.fXF.setVisibility(8);
            this.fXC.setVisibility(8);
            this.cUp.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fXG.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.dVN.getPageActivity()) / 4;
            this.fXG.setLayoutParams(layoutParams);
        } else {
            this.fXF.setVisibility(0);
            this.fXC.setVisibility(0);
            this.cUp.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.fXG.getLayoutParams();
            layoutParams2.height = this.dVN.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.fXG.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(BdUniqueId bdUniqueId) {
        this.fXE.setOnClickListener(this.fXH);
    }
}
