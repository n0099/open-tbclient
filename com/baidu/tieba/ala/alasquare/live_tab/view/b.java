package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.b> {
    private View bhm;
    private View cfA;
    private int dzA;
    private int dzB;
    private int[] dzC;
    private boolean dzD;
    private com.baidu.tieba.ala.alasquare.widget.banner.c dzE;
    private AlaBannerRecyclerView dzy;
    private com.baidu.tieba.ala.alasquare.widget.banner.a dzz;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dzD = false;
        this.dzE = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b j(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<bh>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View dzG;
                    private View dzH;
                    private TabLiveStageLiveView dzI;
                    private int dzJ;
                    private int dzK;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dzI = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.dzG = view.findViewById(R.id.recom_live_item_left_space);
                        this.dzH = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: b */
                    public void h(int i2, bh bhVar) {
                        this.dzI.setData(bhVar, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dzG.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dzH.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.dzD) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.dzH.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.dzH.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.dzz.getItemCount() - 1 == i2) {
                                this.dzH.setVisibility(0);
                            } else {
                                this.dzH.setVisibility(8);
                            }
                        }
                        this.dzG.setLayoutParams(layoutParams);
                        this.dzH.setLayoutParams(layoutParams2);
                        aJL();
                        TiebaStatic.log("c13558");
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.dzI.onChangeSkinType();
                    }

                    private void aJL() {
                        this.dzJ = b.this.getRealWidth();
                        this.dzK = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dzI.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.dzJ, this.dzK);
                        } else {
                            layoutParams.width = this.dzJ;
                            layoutParams.height = this.dzK;
                        }
                        layoutParams.gravity = 1;
                        this.dzI.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.dzD = false;
        this.dzA = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.dzB = (int) ((this.dzA * 9.0d) / 16.0d);
        this.dzC = com.baidu.tieba.ala.alasquare.live_tab.b.dj(this.mContext);
        initView();
    }

    private void initView() {
        this.bhm = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cfA = getView().findViewById(R.id.recom_live_bottom_divider);
        this.dzy = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.dzy.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        aJK();
        this.dzz = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.dzE, false);
        this.dzy.setAdapter(this.dzz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.dzD ? this.dzC[0] : this.dzA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.dzD ? this.dzC[1] : this.dzB;
    }

    private void aJK() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dzy.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.dzy.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cfA, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.b bVar) {
        if (bVar != null && bVar.dxf != null) {
            this.dzD = v.getCount(bVar.dxf.dxd) == 1;
            aJK();
            this.dzz.setData(bVar.dxf.dxd);
            this.dzz.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
