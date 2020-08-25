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
    private View efA;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fHA;
    private int fHB;
    private int fHC;
    private int[] fHD;
    private boolean fHE;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fHF;
    private AlaBannerRecyclerView fHz;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fHE = false;
        this.fHF = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b l(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View fHH;
                    private View fHI;
                    private TabLiveStageLiveView fHJ;
                    private int fHK;
                    private int fHL;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ak(View view) {
                        this.fHJ = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.fHH = view.findViewById(R.id.recom_live_item_left_space);
                        this.fHI = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fHJ.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHH.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHI.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.fHE) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fHI.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fHI.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fHA.getItemCount() - 1 == i2) {
                                this.fHI.setVisibility(0);
                            } else {
                                this.fHI.setVisibility(8);
                            }
                        }
                        this.fHH.setLayoutParams(layoutParams);
                        this.fHI.setLayoutParams(layoutParams2);
                        bGt();
                        aq aqVar = new aq("c13558");
                        aqVar.dD("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fHJ.onChangeSkinType();
                    }

                    private void bGt() {
                        this.fHK = b.this.getRealWidth();
                        this.fHL = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHJ.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.fHK, this.fHL);
                        } else {
                            layoutParams.width = this.fHK;
                            layoutParams.height = this.fHL;
                        }
                        layoutParams.gravity = 1;
                        this.fHJ.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.fHE = false;
        this.fHB = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fHC = (int) ((this.fHB * 9.0d) / 16.0d);
        this.fHD = com.baidu.tieba.ala.alasquare.live_tab.c.eJ(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.efA = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fHz = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fHz.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bGs();
        this.fHA = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fHF, false);
        this.fHz.setAdapter(this.fHA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.fHE ? this.fHD[0] : this.fHB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.fHE ? this.fHD[1] : this.fHC;
    }

    private void bGs() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHz.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fHz.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.efA, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fEx != null) {
            this.fHE = y.getCount(cVar.fEx.fEv) == 1;
            bGs();
            this.fHA.setData(cVar.fEx.fEv);
            this.fHA.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
