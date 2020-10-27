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
import com.baidu.tieba.card.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<bw> implements z {
    private bw agx;
    private View dAc;
    private TbPageContext<?> eCn;
    private View gMT;
    private TextView gMU;
    private TextView gMV;
    private TextView gMW;
    private RelativeLayout gMX;
    private final View.OnClickListener gMY;
    private RelativeLayout gMq;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gMY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agx != null && b.this.cls() != null) {
                    b.this.cls().a(view, b.this.agx);
                    TiebaStatic.log(new aq("c11844").dR("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.agx.getFid()));
                }
            }
        };
        this.eCn = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gMT = view.findViewById(R.id.recommend_left_line);
        this.dAc = view.findViewById(R.id.recommend_right_line);
        this.gMq = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gMU = (TextView) view.findViewById(R.id.ala_live_title);
        this.gMV = (TextView) view.findViewById(R.id.start_live_btn);
        this.gMX = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gMW = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMV, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gMV, R.color.cp_cont_a);
            ap.setBackgroundColor(this.gMq, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gMT, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.dAc, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gMU, R.color.cp_cont_d);
            ap.setViewTextColor(this.gMW, R.color.cp_cont_c);
            ap.setBackgroundColor(this.gMX, R.color.cp_bg_line_d);
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
        this.agx = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.agx.eAn) {
            this.gMW.setVisibility(8);
            this.gMT.setVisibility(8);
            this.dAc.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gMX.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eCn.getPageActivity()) / 4;
            this.gMX.setLayoutParams(layoutParams);
        } else {
            this.gMW.setVisibility(0);
            this.gMT.setVisibility(0);
            this.dAc.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gMX.getLayoutParams();
            layoutParams2.height = this.eCn.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gMX.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gMV.setOnClickListener(this.gMY);
    }
}
