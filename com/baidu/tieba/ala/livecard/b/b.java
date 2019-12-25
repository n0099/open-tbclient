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
    private bj Ki;
    private View bVB;
    private TbPageContext<?> cQU;
    private View eIJ;
    private TextView eIK;
    private TextView eIL;
    private TextView eIM;
    private RelativeLayout eIN;
    private final View.OnClickListener eIO;
    private RelativeLayout eIf;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eIO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Ki != null && b.this.brY() != null) {
                    b.this.brY().a(view, b.this.Ki);
                    TiebaStatic.log(new an("c11844").cp("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.Ki.getFid()));
                }
            }
        };
        this.cQU = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.eIJ = view.findViewById(R.id.recommend_left_line);
        this.bVB = view.findViewById(R.id.recommend_right_line);
        this.eIf = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.eIK = (TextView) view.findViewById(R.id.ala_live_title);
        this.eIL = (TextView) view.findViewById(R.id.start_live_btn);
        this.eIN = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.eIM = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIL, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.eIL, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eIf, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eIJ, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bVB, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eIK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eIM, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.eIN, R.color.cp_bg_line_d);
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
        this.Ki = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.Ki.cPs) {
            this.eIM.setVisibility(8);
            this.eIJ.setVisibility(8);
            this.bVB.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eIN.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cQU.getPageActivity()) / 4;
            this.eIN.setLayoutParams(layoutParams);
        } else {
            this.eIM.setVisibility(0);
            this.eIJ.setVisibility(0);
            this.bVB.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.eIN.getLayoutParams();
            layoutParams2.height = this.cQU.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.eIN.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eIL.setOnClickListener(this.eIO);
    }
}
