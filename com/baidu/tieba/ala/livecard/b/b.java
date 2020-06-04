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
    private RelativeLayout fGx;
    private View fHa;
    private TextView fHb;
    private TextView fHc;
    private TextView fHd;
    private RelativeLayout fHe;
    private final View.OnClickListener fHf;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fHf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aee != null && b.this.bKU() != null) {
                    b.this.bKU().a(view, b.this.aee);
                    TiebaStatic.log(new an("c11844").dh("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.aee.getFid()));
                }
            }
        };
        this.dIF = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fHa = view.findViewById(R.id.recommend_left_line);
        this.cMe = view.findViewById(R.id.recommend_right_line);
        this.fGx = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fHb = (TextView) view.findViewById(R.id.ala_live_title);
        this.fHc = (TextView) view.findViewById(R.id.start_live_btn);
        this.fHe = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fHd = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fHc, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.fHc, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fGx, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fHa, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cMe, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fHb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fHd, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.fHe, R.color.cp_bg_line_d);
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
    public void qy(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aee.dHb) {
            this.fHd.setVisibility(8);
            this.fHa.setVisibility(8);
            this.cMe.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fHe.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.dIF.getPageActivity()) / 4;
            this.fHe.setLayoutParams(layoutParams);
        } else {
            this.fHd.setVisibility(0);
            this.fHa.setVisibility(0);
            this.cMe.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.fHe.getLayoutParams();
            layoutParams2.height = this.dIF.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.fHe.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.fHc.setOnClickListener(this.fHf);
    }
}
