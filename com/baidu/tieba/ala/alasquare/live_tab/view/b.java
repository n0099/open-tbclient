package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.b> {
    private View cRh;
    private AlaBannerRecyclerView ejJ;
    private com.baidu.tieba.ala.alasquare.widget.banner.a ejK;
    private int ejL;
    private int ejM;
    private int[] ejN;
    private boolean ejO;
    private com.baidu.tieba.ala.alasquare.widget.banner.c ejP;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ejO = false;
        this.ejP = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<bj>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View ejR;
                    private View ejS;
                    private TabLiveStageLiveView ejT;
                    private int ejU;
                    private int ejV;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.ejT = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.ejR = view.findViewById(R.id.recom_live_item_left_space);
                        this.ejS = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, bj bjVar) {
                        this.ejT.setData(bjVar, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejR.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ejS.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.ejO) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ejS.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ejS.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.ejK.getItemCount() - 1 == i2) {
                                this.ejS.setVisibility(0);
                            } else {
                                this.ejS.setVisibility(8);
                            }
                        }
                        this.ejR.setLayoutParams(layoutParams);
                        this.ejS.setLayoutParams(layoutParams2);
                        bai();
                        TiebaStatic.log("c13558");
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.ejT.onChangeSkinType();
                    }

                    private void bai() {
                        this.ejU = b.this.getRealWidth();
                        this.ejV = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejT.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.ejU, this.ejV);
                        } else {
                            layoutParams.width = this.ejU;
                            layoutParams.height = this.ejV;
                        }
                        layoutParams.gravity = 1;
                        this.ejT.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.ejO = false;
        this.ejL = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.ejM = (int) ((this.ejL * 9.0d) / 16.0d);
        this.ejN = com.baidu.tieba.ala.alasquare.live_tab.b.eC(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cRh = getView().findViewById(R.id.recom_live_bottom_divider);
        this.ejJ = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.ejJ.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bah();
        this.ejK = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.ejP, false);
        this.ejJ.setAdapter(this.ejK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.ejO ? this.ejN[0] : this.ejL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.ejO ? this.ejN[1] : this.ejM;
    }

    private void bah() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejJ.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.ejJ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cRh, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.b bVar) {
        if (bVar != null && bVar.ehq != null) {
            this.ejO = v.getCount(bVar.ehq.eho) == 1;
            bah();
            this.ejK.setData(bVar.ehq.eho);
            this.ejK.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
