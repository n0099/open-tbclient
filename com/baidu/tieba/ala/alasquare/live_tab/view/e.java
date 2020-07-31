package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView fwv;
    private int mLastScreenWidth;
    private View mRootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] eB = com.baidu.tieba.ala.alasquare.live_tab.c.eB(getContext());
        int i = eB[0];
        int i2 = eB[1];
        this.fwv = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fwv.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.fwv.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        if (this.fwv != null) {
            this.fwv.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.fti != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] eB = com.baidu.tieba.ala.alasquare.live_tab.c.eB(getContext());
                int i = eB[0];
                int i2 = eB[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fwv.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.fwv.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.fwv.setData(fVar.fti.ftj, 101);
            ap apVar = new ap("c13551");
            apVar.dn("entryname", "推荐");
            TiebaStatic.log(apVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
