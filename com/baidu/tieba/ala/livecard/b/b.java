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
    private bw agw;
    private View drD;
    private TbPageContext<?> etO;
    private RelativeLayout gAC;
    private View gBf;
    private TextView gBg;
    private TextView gBh;
    private TextView gBi;
    private RelativeLayout gBj;
    private final View.OnClickListener gBk;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gBk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agw != null && b.this.cil() != null) {
                    b.this.cil().a(view, b.this.agw);
                    TiebaStatic.log(new aq("c11844").dK("uid", TbadkCoreApplication.getCurrentAccount()).u("fid", b.this.agw.getFid()));
                }
            }
        };
        this.etO = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gBf = view.findViewById(R.id.recommend_left_line);
        this.drD = view.findViewById(R.id.recommend_right_line);
        this.gAC = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gBg = (TextView) view.findViewById(R.id.ala_live_title);
        this.gBh = (TextView) view.findViewById(R.id.start_live_btn);
        this.gBj = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gBi = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gBh, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gBh, R.color.cp_cont_a);
            ap.setBackgroundColor(this.gAC, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gBf, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.drD, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gBg, R.color.cp_cont_d);
            ap.setViewTextColor(this.gBi, R.color.cp_cont_c);
            ap.setBackgroundColor(this.gBj, R.color.cp_bg_line_d);
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
        this.agw = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.agw.erN) {
            this.gBi.setVisibility(8);
            this.gBf.setVisibility(8);
            this.drD.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gBj.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.etO.getPageActivity()) / 4;
            this.gBj.setLayoutParams(layoutParams);
        } else {
            this.gBi.setVisibility(0);
            this.gBf.setVisibility(0);
            this.drD.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gBj.getLayoutParams();
            layoutParams2.height = this.etO.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gBj.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gBh.setOnClickListener(this.gBk);
    }
}
