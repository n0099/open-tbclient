package com.baidu.tieba.ala.livecard.a;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<cb> implements z {
    private cb aiB;
    private View dCC;
    private View dSX;
    private TbPageContext<?> eWx;
    private View hpF;
    private TextView hpG;
    private TextView hpH;
    private TextView hpI;
    private RelativeLayout hpJ;
    private final View.OnClickListener hpK;
    private RelativeLayout hpc;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hpK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiB != null && b.this.csi() != null) {
                    b.this.csi().a(view, b.this.aiB);
                    TiebaStatic.log(new ar("c11844").dR("uid", TbadkCoreApplication.getCurrentAccount()).v("fid", b.this.aiB.getFid()));
                }
            }
        };
        this.eWx = tbPageContext;
        View view = getView();
        this.dCC = view.findViewById(R.id.divider);
        this.hpF = view.findViewById(R.id.recommend_left_line);
        this.dSX = view.findViewById(R.id.recommend_right_line);
        this.hpc = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.hpG = (TextView) view.findViewById(R.id.ala_live_title);
        this.hpH = (TextView) view.findViewById(R.id.start_live_btn);
        this.hpJ = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.hpI = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hpH, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.hpH, R.color.CAM_X0101);
            ap.setBackgroundColor(this.hpc, R.color.CAM_X0201);
            ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hpF, R.color.CAM_X0204);
            ap.setBackgroundColor(this.dSX, R.color.CAM_X0204);
            ap.setViewTextColor(this.hpG, R.color.CAM_X0109);
            ap.setViewTextColor(this.hpI, R.color.CAM_X0108);
            ap.setBackgroundColor(this.hpJ, R.color.CAM_X0201);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.aiB = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aiB.eUs) {
            this.hpI.setVisibility(8);
            this.hpF.setVisibility(8);
            this.dSX.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.hpJ.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eWx.getPageActivity()) / 4;
            this.hpJ.setLayoutParams(layoutParams);
        } else {
            this.hpI.setVisibility(0);
            this.hpF.setVisibility(0);
            this.dSX.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.hpJ.getLayoutParams();
            layoutParams2.height = this.eWx.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hpJ.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hpH.setOnClickListener(this.hpK);
    }
}
