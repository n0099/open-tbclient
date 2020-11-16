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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<bx> implements z {
    private bx agB;
    private View dEn;
    private TbPageContext<?> eGu;
    private View gSZ;
    private RelativeLayout gSw;
    private TextView gTa;
    private TextView gTb;
    private TextView gTc;
    private RelativeLayout gTd;
    private final View.OnClickListener gTe;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agB != null && b.this.cnv() != null) {
                    b.this.cnv().a(view, b.this.agB);
                    TiebaStatic.log(new ar("c11844").dR("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.agB.getFid()));
                }
            }
        };
        this.eGu = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gSZ = view.findViewById(R.id.recommend_left_line);
        this.dEn = view.findViewById(R.id.recommend_right_line);
        this.gSw = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gTa = (TextView) view.findViewById(R.id.ala_live_title);
        this.gTb = (TextView) view.findViewById(R.id.start_live_btn);
        this.gTd = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gTc = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gTb, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gTb, R.color.CAM_X0101);
            ap.setBackgroundColor(this.gSw, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            ap.setBackgroundColor(this.gSZ, R.color.CAM_X0204);
            ap.setBackgroundColor(this.dEn, R.color.CAM_X0204);
            ap.setViewTextColor(this.gTa, R.color.CAM_X0109);
            ap.setViewTextColor(this.gTc, R.color.CAM_X0108);
            ap.setBackgroundColor(this.gTd, R.color.CAM_X0201);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        this.agB = bxVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.agB.eEu) {
            this.gTc.setVisibility(8);
            this.gSZ.setVisibility(8);
            this.dEn.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gTd.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eGu.getPageActivity()) / 4;
            this.gTd.setLayoutParams(layoutParams);
        } else {
            this.gTc.setVisibility(0);
            this.gSZ.setVisibility(0);
            this.dEn.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gTd.getLayoutParams();
            layoutParams2.height = this.eGu.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gTd.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gTb.setOnClickListener(this.gTe);
    }
}
