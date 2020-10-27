package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView ghB;
    private int mLastScreenWidth;
    private View mRootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] eX = com.baidu.tieba.ala.alasquare.live_tab.c.eX(getContext());
        int i = eX[0];
        int i2 = eX[1];
        this.ghB = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghB.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.ghB.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        if (this.ghB != null) {
            this.ghB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.gef != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] eX = com.baidu.tieba.ala.alasquare.live_tab.c.eX(getContext());
                int i = eX[0];
                int i2 = eX[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghB.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.ghB.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.ghB.setData(fVar.gef.geg, 101);
            aq aqVar = new aq("c13551");
            aqVar.dR("entryname", "推荐");
            TiebaStatic.log(aqVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
