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
    private TbPageContext<?> cVv;
    private View cae;
    private RelativeLayout eNV;
    private TextView eOA;
    private TextView eOB;
    private RelativeLayout eOC;
    private final View.OnClickListener eOD;
    private View eOy;
    private TextView eOz;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eOD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.buM() != null) {
                    b.this.buM().a(view, b.this.KJ);
                    TiebaStatic.log(new an("c11844").cx("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.KJ.getFid()));
                }
            }
        };
        this.cVv = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eOy = view.findViewById(R.id.recommend_left_line);
        this.cae = view.findViewById(R.id.recommend_right_line);
        this.eNV = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eOz = (TextView) view.findViewById(R.id.ala_live_title);
        this.eOA = (TextView) view.findViewById(R.id.start_live_btn);
        this.eOC = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eOB = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eOA, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eOA, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eNV, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOy, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cae, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eOz, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOB, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eOC, R.color.cp_bg_line_d);
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
    public void pB(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.KJ.cTT) {
            this.eOB.setVisibility(8);
            this.eOy.setVisibility(8);
            this.cae.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eOC.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cVv.getPageActivity()) / 4;
            this.eOC.setLayoutParams(layoutParams);
        } else {
            this.eOB.setVisibility(0);
            this.eOy.setVisibility(0);
            this.cae.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eOC.getLayoutParams();
            layoutParams2.height = this.cVv.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eOC.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eOA.setOnClickListener(this.eOD);
    }
}
