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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<cb> implements z {
    private cb ahi;
    private View dBb;
    private View dRw;
    private TbPageContext<?> eUY;
    private View hnH;
    private TextView hnI;
    private TextView hnJ;
    private TextView hnK;
    private RelativeLayout hnL;
    private final View.OnClickListener hnM;
    private RelativeLayout hne;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahi != null && b.this.crV() != null) {
                    b.this.crV().a(view, b.this.ahi);
                    TiebaStatic.log(new ar("c11844").dR("uid", TbadkCoreApplication.getCurrentAccount()).v("fid", b.this.ahi.getFid()));
                }
            }
        };
        this.eUY = tbPageContext;
        View view = getView();
        this.dBb = view.findViewById(R.id.divider);
        this.hnH = view.findViewById(R.id.recommend_left_line);
        this.dRw = view.findViewById(R.id.recommend_right_line);
        this.hne = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.hnI = (TextView) view.findViewById(R.id.ala_live_title);
        this.hnJ = (TextView) view.findViewById(R.id.start_live_btn);
        this.hnL = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.hnK = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hnJ, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.hnJ, R.color.CAM_X0101);
            ap.setBackgroundColor(this.hne, R.color.CAM_X0201);
            ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hnH, R.color.CAM_X0204);
            ap.setBackgroundColor(this.dRw, R.color.CAM_X0204);
            ap.setViewTextColor(this.hnI, R.color.CAM_X0109);
            ap.setViewTextColor(this.hnK, R.color.CAM_X0108);
            ap.setBackgroundColor(this.hnL, R.color.CAM_X0201);
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
        this.ahi = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.ahi.eSR) {
            this.hnK.setVisibility(8);
            this.hnH.setVisibility(8);
            this.dRw.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.hnL.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eUY.getPageActivity()) / 4;
            this.hnL.setLayoutParams(layoutParams);
        } else {
            this.hnK.setVisibility(0);
            this.hnH.setVisibility(0);
            this.dRw.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.hnL.getLayoutParams();
            layoutParams2.height = this.eUY.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hnL.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hnJ.setOnClickListener(this.hnM);
    }
}
