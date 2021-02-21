package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView gEy;
    private int mLastScreenWidth;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] fU = com.baidu.tieba.ala.alasquare.live_tab.c.fU(getContext());
        int i = fU[0];
        int i2 = fU[1];
        this.gEy = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEy.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.gEy.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        if (this.gEy != null) {
            this.gEy.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.gBd != null) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] fU = com.baidu.tieba.ala.alasquare.live_tab.c.fU(getContext());
                int i = fU[0];
                int i2 = fU[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEy.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.gEy.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.gEy.setData(fVar.gBd.gBe, 101);
            ar arVar = new ar("c13551");
            arVar.dR("entryname", "推荐");
            TiebaStatic.log(arVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
