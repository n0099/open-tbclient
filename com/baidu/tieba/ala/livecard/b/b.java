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
    private bw afJ;
    private View ddq;
    private TbPageContext<?> efn;
    private RelativeLayout giY;
    private View gjB;
    private TextView gjC;
    private TextView gjD;
    private TextView gjE;
    private RelativeLayout gjF;
    private final View.OnClickListener gjG;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.afJ != null && b.this.cbz() != null) {
                    b.this.cbz().a(view, b.this.afJ);
                    TiebaStatic.log(new aq("c11844").dD("uid", TbadkCoreApplication.getCurrentAccount()).u("fid", b.this.afJ.getFid()));
                }
            }
        };
        this.efn = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gjB = view.findViewById(R.id.recommend_left_line);
        this.ddq = view.findViewById(R.id.recommend_right_line);
        this.giY = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gjC = (TextView) view.findViewById(R.id.ala_live_title);
        this.gjD = (TextView) view.findViewById(R.id.start_live_btn);
        this.gjF = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gjE = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjD, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gjD, (int) R.color.cp_cont_a);
            ap.setBackgroundColor(this.giY, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gjB, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.ddq, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gjC, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjE, (int) R.color.cp_cont_c);
            ap.setBackgroundColor(this.gjF, R.color.cp_bg_line_d);
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
        this.afJ = bwVar;
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
        if (!this.afJ.edt) {
            this.gjE.setVisibility(8);
            this.gjB.setVisibility(8);
            this.ddq.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gjF.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.efn.getPageActivity()) / 4;
            this.gjF.setLayoutParams(layoutParams);
        } else {
            this.gjE.setVisibility(0);
            this.gjB.setVisibility(0);
            this.ddq.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gjF.getLayoutParams();
            layoutParams2.height = this.efn.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gjF.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(BdUniqueId bdUniqueId) {
        this.gjD.setOnClickListener(this.gjG);
    }
}
