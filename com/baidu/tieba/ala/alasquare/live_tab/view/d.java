package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.d> {
    private TabLiveStageLiveView dzM;
    private int mLastScreenWidth;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] dj = com.baidu.tieba.ala.alasquare.live_tab.b.dj(getContext());
        int i = dj[0];
        int i2 = dj[1];
        this.dzM = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dzM.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.dzM.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        if (this.dzM != null) {
            this.dzM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.d dVar) {
        if (dVar != null && dVar.dxi != null) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] dj = com.baidu.tieba.ala.alasquare.live_tab.b.dj(getContext());
                int i = dj[0];
                int i2 = dj[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dzM.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.dzM.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.dzM.setData(dVar.dxi.dxj, 101);
            TiebaStatic.log("c13551");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
