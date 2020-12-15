package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView gvh;
    private int mLastScreenWidth;
    private View mRootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] fD = com.baidu.tieba.ala.alasquare.live_tab.c.fD(getContext());
        int i = fD[0];
        int i2 = fD[1];
        this.gvh = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvh.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.gvh.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        if (this.gvh != null) {
            this.gvh.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.grN != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] fD = com.baidu.tieba.ala.alasquare.live_tab.c.fD(getContext());
                int i = fD[0];
                int i2 = fD[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvh.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.gvh.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.gvh.setData(fVar.grN.grO, 101);
            ar arVar = new ar("c13551");
            arVar.dY("entryname", "推荐");
            TiebaStatic.log(arVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
