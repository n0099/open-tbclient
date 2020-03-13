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
    private View bZT;
    private TbPageContext<?> cVi;
    private RelativeLayout eNx;
    private View eOa;
    private TextView eOb;
    private TextView eOc;
    private TextView eOd;
    private RelativeLayout eOe;
    private final View.OnClickListener eOf;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eOf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.buH() != null) {
                    b.this.buH().a(view, b.this.KJ);
                    TiebaStatic.log(new an("c11844").cy("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.KJ.getFid()));
                }
            }
        };
        this.cVi = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eOa = view.findViewById(R.id.recommend_left_line);
        this.bZT = view.findViewById(R.id.recommend_right_line);
        this.eNx = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eOb = (TextView) view.findViewById(R.id.ala_live_title);
        this.eOc = (TextView) view.findViewById(R.id.start_live_btn);
        this.eOe = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eOd = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eOc, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eOc, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eNx, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOa, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eOb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOd, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eOe, R.color.cp_bg_line_d);
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
        if (!this.KJ.cTG) {
            this.eOd.setVisibility(8);
            this.eOa.setVisibility(8);
            this.bZT.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eOe.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cVi.getPageActivity()) / 4;
            this.eOe.setLayoutParams(layoutParams);
        } else {
            this.eOd.setVisibility(0);
            this.eOa.setVisibility(0);
            this.bZT.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eOe.getLayoutParams();
            layoutParams2.height = this.cVi.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eOe.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eOc.setOnClickListener(this.eOf);
    }
}
