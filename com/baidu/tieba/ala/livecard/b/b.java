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
    private View dFU;
    private TbPageContext<?> eIc;
    private RelativeLayout gSP;
    private View gTs;
    private TextView gTt;
    private TextView gTu;
    private TextView gTv;
    private RelativeLayout gTw;
    private final View.OnClickListener gTx;
    private View mDivider;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agx != null && b.this.cnT() != null) {
                    b.this.cnT().a(view, b.this.agx);
                    TiebaStatic.log(new aq("c11844").dR("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.agx.getFid()));
                }
            }
        };
        this.eIc = tbPageContext;
        View view = getView();
        this.mDivider = view.findViewById(R.id.divider);
        this.gTs = view.findViewById(R.id.recommend_left_line);
        this.dFU = view.findViewById(R.id.recommend_right_line);
        this.gSP = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.gTt = (TextView) view.findViewById(R.id.ala_live_title);
        this.gTu = (TextView) view.findViewById(R.id.start_live_btn);
        this.gTw = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.gTv = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gTu, R.drawable.ala_live_card_start_live_selector);
            ap.setViewTextColor(this.gTu, (int) R.color.cp_cont_a);
            ap.setBackgroundColor(this.gSP, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gTs, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.dFU, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gTt, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gTv, (int) R.color.cp_cont_c);
            ap.setBackgroundColor(this.gTw, R.color.cp_bg_line_d);
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
    public void vd(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.agx.eGc) {
            this.gTv.setVisibility(8);
            this.gTs.setVisibility(8);
            this.dFU.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gTw.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eIc.getPageActivity()) / 4;
            this.gTw.setLayoutParams(layoutParams);
        } else {
            this.gTv.setVisibility(0);
            this.gTs.setVisibility(0);
            this.dFU.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.gTw.getLayoutParams();
            layoutParams2.height = this.eIc.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.gTw.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gTu.setOnClickListener(this.gTx);
    }
}
