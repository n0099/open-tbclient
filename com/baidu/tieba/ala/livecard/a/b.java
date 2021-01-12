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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<bz> implements y {
    private bz ahu;
    private View dPq;
    private View dyW;
    private TbPageContext<?> eSJ;
    private RelativeLayout hiR;
    private View hju;
    private TextView hjv;
    private TextView hjw;
    private TextView hjx;
    private RelativeLayout hjy;
    private final View.OnClickListener hjz;
    private String mForumName;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hjz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahu != null && b.this.cqL() != null) {
                    b.this.cqL().a(view, b.this.ahu);
                    TiebaStatic.log(new aq("c11844").dW("uid", TbadkCoreApplication.getCurrentAccount()).w("fid", b.this.ahu.getFid()));
                }
            }
        };
        this.eSJ = tbPageContext;
        View view = getView();
        this.dyW = view.findViewById(R.id.divider);
        this.hju = view.findViewById(R.id.recommend_left_line);
        this.dPq = view.findViewById(R.id.recommend_right_line);
        this.hiR = (RelativeLayout) view.findViewById(R.id.ala_live_empty_layout_root);
        this.hjv = (TextView) view.findViewById(R.id.ala_live_title);
        this.hjw = (TextView) view.findViewById(R.id.start_live_btn);
        this.hjy = (RelativeLayout) view.findViewById(R.id.ala_bottom_container);
        this.hjx = (TextView) view.findViewById(R.id.ala_recommend_live);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hjw, R.drawable.ala_live_card_start_live_selector);
            ao.setViewTextColor(this.hjw, R.color.CAM_X0101);
            ao.setBackgroundColor(this.hiR, R.color.CAM_X0201);
            ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
            ao.setBackgroundColor(this.hju, R.color.CAM_X0204);
            ao.setBackgroundColor(this.dPq, R.color.CAM_X0204);
            ao.setViewTextColor(this.hjv, R.color.CAM_X0109);
            ao.setViewTextColor(this.hjx, R.color.CAM_X0108);
            ao.setBackgroundColor(this.hjy, R.color.CAM_X0201);
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
        this.ahu = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void refreshView() {
        if (!this.ahu.eQF) {
            this.hjx.setVisibility(8);
            this.hju.setVisibility(8);
            this.dPq.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.hjy.getLayoutParams();
            layoutParams.height = l.getEquipmentHeight(this.eSJ.getPageActivity()) / 4;
            this.hjy.setLayoutParams(layoutParams);
        } else {
            this.hjx.setVisibility(0);
            this.hju.setVisibility(0);
            this.dPq.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.hjy.getLayoutParams();
            layoutParams2.height = this.eSJ.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hjy.setLayoutParams(layoutParams2);
        }
        onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hjw.setOnClickListener(this.hjz);
    }
}
