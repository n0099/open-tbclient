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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<bz> implements y {
    private bz aim;
    private View dDI;
    private View dUc;
    private TbPageContext<?> eXu;
    private RelativeLayout hnx;
    private View hoa;
    private TextView hob;
    private TextView hoc;
    private TextView hod;
    private RelativeLayout hoe;
    private final View.OnClickListener hof;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hof = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aim != null && b.this.cuD() != null) {
                    b.this.cuD().a(view, b.this.aim);
                    TiebaStatic.log(new aq("c11844").dX("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.aim.getFid()));
                }
            }
        };
        this.eXu = tbPageContext;
        View view = getView();
        this.dDI = view.findViewById(R.id.divider);
        this.hoa = view.findViewById(R.id.recommend_left_line);
        this.dUc = view.findViewById(R.id.recommend_right_line);
        this.hnx = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.hob = (TextView) view.findViewById(R.id.ala_live_title);
        this.hoc = (TextView) view.findViewById(R.id.start_live_btn);
        this.hoe = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.hod = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hoc, R.drawable.ala_live_card_start_live_selector);
            ao.setViewTextColor(this.hoc, R.color.CAM_X0101);
            ao.setBackgroundColor(this.hnx, R.color.CAM_X0201);
            ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
            ao.setBackgroundColor(this.hoa, R.color.CAM_X0204);
            ao.setBackgroundColor(this.dUc, R.color.CAM_X0204);
            ao.setViewTextColor(this.hob, R.color.CAM_X0109);
            ao.setViewTextColor(this.hod, R.color.CAM_X0108);
            ao.setBackgroundColor(this.hoe, R.color.CAM_X0201);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_empty_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.aim = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.aim.eVq) {
            this.hod.setVisibility(8);
            this.hoa.setVisibility(8);
            this.dUc.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.hoe.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eXu.getPageActivity()) / 4;
            this.hoe.setLayoutParams(layoutParams);
        } else {
            this.hod.setVisibility(0);
            this.hoa.setVisibility(0);
            this.dUc.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.hoe.getLayoutParams();
            layoutParams2.height = this.eXu.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hoe.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hoc.setOnClickListener(this.hof);
    }
}
