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
    private bw afL;
    private View ddv;
    private TbPageContext<?> efr;
    private View gjF;
    private TextView gjG;
    private TextView gjH;
    private TextView gjI;
    private RelativeLayout gjJ;
    private final View.OnClickListener gjK;
    private RelativeLayout gjc;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.afL != null && b.this.cbA() != null) {
                    b.this.cbA().a(view, b.this.afL);
                    TiebaStatic.log(new aq("c11844").dD("uid", TbadkCoreApplication.getCurrentAccount()).u("fid", b.this.afL.getFid()));
                }
            }
        };
        this.efr = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gjF = view.findViewById(R.id.recommend_left_line);
        this.ddv = view.findViewById(R.id.recommend_right_line);
        this.gjc = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gjG = (TextView) view.findViewById(R.id.ala_live_title);
        this.gjH = (TextView) view.findViewById(R.id.start_live_btn);
        this.gjJ = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gjI = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjH, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gjH, (int) R.color.cp_cont_a);
            ap.setBackgroundColor(this.gjc, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gjF, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.ddv, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gjG, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjI, (int) R.color.cp_cont_c);
            ap.setBackgroundColor(this.gjJ, R.color.cp_bg_line_d);
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
        this.afL = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.afL.edx) {
            this.gjI.setVisibility(8);
            this.gjF.setVisibility(8);
            this.ddv.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gjJ.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.efr.getPageActivity()) / 4;
            this.gjJ.setLayoutParams(layoutParams);
        } else {
            this.gjI.setVisibility(0);
            this.gjF.setVisibility(0);
            this.ddv.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gjJ.getLayoutParams();
            layoutParams2.height = this.efr.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gjJ.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(BdUniqueId bdUniqueId) {
        this.gjH.setOnClickListener(this.gjK);
    }
}
