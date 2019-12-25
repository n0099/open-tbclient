package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.d> {
    private TabLiveStageLiveView ejX;
    private int mLastScreenWidth;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] eC = com.baidu.tieba.ala.alasquare.live_tab.b.eC(getContext());
        int i = eC[0];
        int i2 = eC[1];
        this.ejX = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ejX.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.ejX.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        if (this.ejX != null) {
            this.ejX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.d dVar) {
        if (dVar != null && dVar.eht != null) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] eC = com.baidu.tieba.ala.alasquare.live_tab.b.eC(getContext());
                int i = eC[0];
                int i2 = eC[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ejX.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.ejX.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.ejX.setData(dVar.eht.ehu, 101);
            TiebaStatic.log("c13551");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
