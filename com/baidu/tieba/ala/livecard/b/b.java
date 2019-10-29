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
    private bh FT;
    private View bhm;
    private View bvc;
    private TbPageContext<?> cfl;
    private View dTT;
    private TextView dTU;
    private TextView dTV;
    private TextView dTW;
    private RelativeLayout dTX;
    private final View.OnClickListener dTY;
    private RelativeLayout dTp;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.FT != null && b.this.aZX() != null) {
                    b.this.aZX().a(view, b.this.FT);
                    TiebaStatic.log(new an("c11844").bS("uid", TbadkCoreApplication.getCurrentAccount()).p("fid", b.this.FT.getFid()));
                }
            }
        };
        this.cfl = tbPageContext;
        View view = getView();
        this.bhm = view.findViewById(R.id.divider);
        this.dTT = view.findViewById(R.id.recommend_left_line);
        this.bvc = view.findViewById(R.id.recommend_right_line);
        this.dTp = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.dTU = (TextView) view.findViewById(R.id.ala_live_title);
        this.dTV = (TextView) view.findViewById(R.id.start_live_btn);
        this.dTX = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.dTW = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTV, R.drawable.ala_live_card_start_live_selector);
            am.setViewTextColor(this.dTV, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dTp, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dTT, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.bvc, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dTU, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dTW, (int) R.color.cp_cont_c);
            am.setBackgroundColor(this.dTX, R.color.cp_bg_line_d);
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
        this.FT = bhVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.FT.cdN) {
            this.dTW.setVisibility(8);
            this.dTT.setVisibility(8);
            this.bvc.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.dTX.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.cfl.getPageActivity()) / 4;
            this.dTX.setLayoutParams(layoutParams);
        } else {
            this.dTW.setVisibility(0);
            this.dTT.setVisibility(0);
            this.bvc.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.dTX.getLayoutParams();
            layoutParams2.height = this.cfl.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.dTX.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dTV.setOnClickListener(this.dTY);
    }
}
