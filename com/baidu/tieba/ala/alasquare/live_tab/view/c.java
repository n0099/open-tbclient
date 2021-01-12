package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView gBA;
    private int mLastScreenWidth;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] fV = com.baidu.tieba.ala.alasquare.live_tab.c.fV(getContext());
        int i = fV[0];
        int i2 = fV[1];
        this.gBA = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBA.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.gBA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(getView(), R.color.CAM_X0201);
        if (this.gBA != null) {
            this.gBA.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.gyf != null) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] fV = com.baidu.tieba.ala.alasquare.live_tab.c.fV(getContext());
                int i = fV[0];
                int i2 = fV[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBA.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.gBA.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.gBA.setData(fVar.gyf.gyg, 101);
            aq aqVar = new aq("c13551");
            aqVar.dW("entryname", "推荐");
            TiebaStatic.log(aqVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
