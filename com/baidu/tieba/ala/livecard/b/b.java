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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<bu> implements y {
    private bu aeK;
    private View cQO;
    private TbPageContext<?> dPv;
    private RelativeLayout fRG;
    private View fSj;
    private TextView fSk;
    private TextView fSl;
    private TextView fSm;
    private RelativeLayout fSn;
    private final View.OnClickListener fSo;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fSo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aeK != null && b.this.bOc() != null) {
                    b.this.bOc().a(view, b.this.aeK);
                    TiebaStatic.log(new ao("c11844").dk("uid", TbadkCoreApplication.getCurrentAccount()).s("fid", b.this.aeK.getFid()));
                }
            }
        };
        this.dPv = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.fSj = view.findViewById(R.id.recommend_left_line);
        this.cQO = view.findViewById(R.id.recommend_right_line);
        this.fRG = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.fSk = (TextView) view.findViewById(R.id.ala_live_title);
        this.fSl = (TextView) view.findViewById(R.id.start_live_btn);
        this.fSn = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.fSm = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fSl, R.drawable.ala_live_card_start_live_selector);
            an.setViewTextColor(this.fSl, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.fRG, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.fSj, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.cQO, R.color.cp_bg_line_c);
            an.setViewTextColor(this.fSk, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fSm, (int) R.color.cp_cont_c);
            an.setBackgroundColor(this.fSn, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        this.aeK = buVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aeK.dNM) {
            this.fSm.setVisibility(8);
            this.fSj.setVisibility(8);
            this.cQO.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fSn.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.dPv.getPageActivity()) / 4;
            this.fSn.setLayoutParams(layoutParams);
        } else {
            this.fSm.setVisibility(0);
            this.fSj.setVisibility(0);
            this.cQO.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.fSn.getLayoutParams();
            layoutParams2.height = this.dPv.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.fSn.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.fSl.setOnClickListener(this.fSo);
    }
}
