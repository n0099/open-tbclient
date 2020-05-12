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
    private bj adJ;
    private View czl;
    private TbPageContext<?> duK;
    private View fsX;
    private TextView fsY;
    private TextView fsZ;
    private RelativeLayout fsu;
    private TextView fta;
    private RelativeLayout ftb;
    private final View.OnClickListener ftc;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ftc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.adJ != null && b.this.bEx() != null) {
                    b.this.bEx().a(view, b.this.adJ);
                    TiebaStatic.log(new an("c11844").cI("uid", TbadkCoreApplication.getCurrentAccount()).t("fid", b.this.adJ.getFid()));
                }
            }
        };
        this.duK = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fsX = view.findViewById(R.id.recommend_left_line);
        this.czl = view.findViewById(R.id.recommend_right_line);
        this.fsu = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fsY = (TextView) view.findViewById(R.id.ala_live_title);
        this.fsZ = (TextView) view.findViewById(R.id.start_live_btn);
        this.ftb = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fta = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsZ, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.fsZ, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fsu, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fsX, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.czl, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fsY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fta, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.ftb, R.color.cp_bg_line_d);
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
        this.adJ = bjVar;
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
        if (!this.adJ.dth) {
            this.fta.setVisibility(8);
            this.fsX.setVisibility(8);
            this.czl.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.ftb.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.duK.getPageActivity()) / 4;
            this.ftb.setLayoutParams(layoutParams);
        } else {
            this.fta.setVisibility(0);
            this.fsX.setVisibility(0);
            this.czl.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.ftb.getLayoutParams();
            layoutParams2.height = this.duK.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ftb.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.fsZ.setOnClickListener(this.ftc);
    }
}
