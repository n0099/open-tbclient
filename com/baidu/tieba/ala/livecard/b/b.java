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
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<bj> implements x {
    private bj Kn;
    private View bVN;
    private TbPageContext<?> cRe;
    private View eJT;
    private TextView eJU;
    private TextView eJV;
    private TextView eJW;
    private RelativeLayout eJX;
    private final View.OnClickListener eJY;
    private RelativeLayout eJp;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Kn != null && b.this.bta() != null) {
                    b.this.bta().a(view, b.this.Kn);
                    TiebaStatic.log(new an("c11844").cp("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.Kn.getFid()));
                }
            }
        };
        this.cRe = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eJT = view.findViewById(R.id.recommend_left_line);
        this.bVN = view.findViewById(R.id.recommend_right_line);
        this.eJp = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eJU = (TextView) view.findViewById(R.id.ala_live_title);
        this.eJV = (TextView) view.findViewById(R.id.start_live_btn);
        this.eJX = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eJW = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJV, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eJV, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eJp, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eJT, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bVN, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eJU, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eJW, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eJX, R.color.cp_bg_line_d);
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
        this.Kn = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.Kn.cPC) {
            this.eJW.setVisibility(8);
            this.eJT.setVisibility(8);
            this.bVN.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eJX.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cRe.getPageActivity()) / 4;
            this.eJX.setLayoutParams(layoutParams);
        } else {
            this.eJW.setVisibility(0);
            this.eJT.setVisibility(0);
            this.bVN.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eJX.getLayoutParams();
            layoutParams2.height = this.cRe.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eJX.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eJV.setOnClickListener(this.eJY);
    }
}
