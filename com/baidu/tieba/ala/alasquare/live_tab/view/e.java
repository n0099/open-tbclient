package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.f> {
    private TabLiveStageLiveView eTb;
    private int mLastScreenWidth;
    private View mRootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mLastScreenWidth = 0;
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        int[] es = com.baidu.tieba.ala.alasquare.live_tab.c.es(getContext());
        int i = es[0];
        int i2 = es[1];
        this.eTb = (TabLiveStageLiveView) this.mRootView.findViewById(R.id.stage_live_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTb.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.eTb.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        if (this.eTb != null) {
            this.eTb.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_stage_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.f fVar) {
        if (fVar != null && fVar.ePQ != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (equipmentWidth != this.mLastScreenWidth) {
                int[] es = com.baidu.tieba.ala.alasquare.live_tab.c.es(getContext());
                int i = es[0];
                int i2 = es[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTb.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.eTb.setLayoutParams(layoutParams);
                this.mLastScreenWidth = equipmentWidth;
            }
            this.eTb.setData(fVar.ePQ.ePR, 101);
            an anVar = new an("c13551");
            anVar.cI("entryname", "推荐");
            TiebaStatic.log(anVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
