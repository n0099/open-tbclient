package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View efE;
    private AlaBannerRecyclerView fHD;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fHE;
    private int fHF;
    private int fHG;
    private int[] fHH;
    private boolean fHI;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fHJ;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fHI = false;
        this.fHJ = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b l(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View fHL;
                    private View fHM;
                    private TabLiveStageLiveView fHN;
                    private int fHO;
                    private int fHP;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fHN = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.fHL = view.findViewById(R.id.recom_live_item_left_space);
                        this.fHM = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fHN.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHL.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHM.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.fHI) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fHM.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fHM.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fHE.getItemCount() - 1 == i2) {
                                this.fHM.setVisibility(0);
                            } else {
                                this.fHM.setVisibility(8);
                            }
                        }
                        this.fHL.setLayoutParams(layoutParams);
                        this.fHM.setLayoutParams(layoutParams2);
                        bGu();
                        aq aqVar = new aq("c13558");
                        aqVar.dD("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fHN.onChangeSkinType();
                    }

                    private void bGu() {
                        this.fHO = b.this.getRealWidth();
                        this.fHP = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHN.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.fHO, this.fHP);
                        } else {
                            layoutParams.width = this.fHO;
                            layoutParams.height = this.fHP;
                        }
                        layoutParams.gravity = 1;
                        this.fHN.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.fHI = false;
        this.fHF = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fHG = (int) ((this.fHF * 9.0d) / 16.0d);
        this.fHH = com.baidu.tieba.ala.alasquare.live_tab.c.eJ(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.efE = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fHD = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fHD.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bGt();
        this.fHE = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fHJ, false);
        this.fHD.setAdapter(this.fHE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.fHI ? this.fHH[0] : this.fHF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.fHI ? this.fHH[1] : this.fHG;
    }

    private void bGt() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHD.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fHD.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.efE, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fEB != null) {
            this.fHI = y.getCount(cVar.fEB.fEz) == 1;
            bGt();
            this.fHE.setData(cVar.fEB.fEz);
            this.fHE.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
