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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.b<by> implements z {
    private by ahA;
    private View dLl;
    private TbPageContext<?> eNx;
    private RelativeLayout hbJ;
    private View hcm;
    private TextView hcn;
    private TextView hco;
    private TextView hcp;
    private RelativeLayout hcq;
    private final View.OnClickListener hcr;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahA != null && b.this.crI() != null) {
                    b.this.crI().a(view, b.this.ahA);
                    TiebaStatic.log(new ar("c11844").dY("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.ahA.getFid()));
                }
            }
        };
        this.eNx = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.hcm = view.findViewById(R.id.recommend_left_line);
        this.dLl = view.findViewById(R.id.recommend_right_line);
        this.hbJ = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.hcn = (TextView) view.findViewById(R.id.ala_live_title);
        this.hco = (TextView) view.findViewById(R.id.start_live_btn);
        this.hcq = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.hcp = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hco, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.hco, R.color.CAM_X0101);
            ap.setBackgroundColor(this.hbJ, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hcm, R.color.CAM_X0204);
            ap.setBackgroundColor(this.dLl, R.color.CAM_X0204);
            ap.setViewTextColor(this.hcn, R.color.CAM_X0109);
            ap.setViewTextColor(this.hcp, R.color.CAM_X0108);
            ap.setBackgroundColor(this.hcq, R.color.CAM_X0201);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        this.ahA = byVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.ahA.eLw) {
            this.hcp.setVisibility(8);
            this.hcm.setVisibility(8);
            this.dLl.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.hcq.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eNx.getPageActivity()) / 4;
            this.hcq.setLayoutParams(layoutParams);
        } else {
            this.hcp.setVisibility(0);
            this.hcm.setVisibility(0);
            this.dLl.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.hcq.getLayoutParams();
            layoutParams2.height = this.eNx.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hcq.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hco.setOnClickListener(this.hcr);
    }
}
