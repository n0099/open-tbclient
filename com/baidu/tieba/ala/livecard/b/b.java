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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<bh> implements z {
    private bh Fs;
    private View bgU;
    private View bul;
    private TbPageContext<?> ceu;
    private RelativeLayout dSy;
    private View dTc;
    private TextView dTd;
    private TextView dTe;
    private TextView dTf;
    private RelativeLayout dTg;
    private final View.OnClickListener dTh;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Fs != null && b.this.aZV() != null) {
                    b.this.aZV().a(view, b.this.Fs);
                    TiebaStatic.log(new an("c11844").bS("uid", TbadkCoreApplication.getCurrentAccount()).p("fid", b.this.Fs.getFid()));
                }
            }
        };
        this.ceu = tbPageContext;
        View view = getView();
        this.bgU = view.findViewById(R.id.divider);
        this.dTc = view.findViewById(R.id.recommend_left_line);
        this.bul = view.findViewById(R.id.recommend_right_line);
        this.dSy = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.dTd = (TextView) view.findViewById(R.id.ala_live_title);
        this.dTe = (TextView) view.findViewById(R.id.start_live_btn);
        this.dTg = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.dTf = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTe, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.dTe, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dSy, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dTc, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bul, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dTd, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dTf, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.dTg, R.color.cp_bg_line_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.Fs = bhVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.Fs.ccW) {
            this.dTf.setVisibility(8);
            this.dTc.setVisibility(8);
            this.bul.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.dTg.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.ceu.getPageActivity()) / 4;
            this.dTg.setLayoutParams(layoutParams);
        } else {
            this.dTf.setVisibility(0);
            this.dTc.setVisibility(0);
            this.bul.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.dTg.getLayoutParams();
            layoutParams2.height = this.ceu.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.dTg.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dTe.setOnClickListener(this.dTh);
    }
}
