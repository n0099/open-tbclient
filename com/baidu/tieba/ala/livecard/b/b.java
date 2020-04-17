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
    private bj adG;
    private View czf;
    private TbPageContext<?> duG;
    private View fsS;
    private TextView fsT;
    private TextView fsU;
    private TextView fsV;
    private RelativeLayout fsW;
    private final View.OnClickListener fsX;
    private RelativeLayout fsp;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.adG != null && b.this.bEy() != null) {
                    b.this.bEy().a(view, b.this.adG);
                    TiebaStatic.log(new an("c11844").cI("uid", TbadkCoreApplication.getCurrentAccount()).t("fid", b.this.adG.getFid()));
                }
            }
        };
        this.duG = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fsS = view.findViewById(R.id.recommend_left_line);
        this.czf = view.findViewById(R.id.recommend_right_line);
        this.fsp = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fsT = (TextView) view.findViewById(R.id.ala_live_title);
        this.fsU = (TextView) view.findViewById(R.id.start_live_btn);
        this.fsW = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fsV = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsU, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.fsU, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fsp, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fsS, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.czf, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fsT, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fsV, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.fsW, R.color.cp_bg_line_d);
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
        this.adG = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.adG.dtd) {
            this.fsV.setVisibility(8);
            this.fsS.setVisibility(8);
            this.czf.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fsW.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.duG.getPageActivity()) / 4;
            this.fsW.setLayoutParams(layoutParams);
        } else {
            this.fsV.setVisibility(0);
            this.fsS.setVisibility(0);
            this.czf.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.fsW.getLayoutParams();
            layoutParams2.height = this.duG.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.fsW.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.fsU.setOnClickListener(this.fsX);
    }
}
