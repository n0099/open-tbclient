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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View duT;
    private AlaBannerRecyclerView eSN;
    private com.baidu.tieba.ala.alasquare.widget.banner.a eSO;
    private int eSP;
    private int eSQ;
    private int[] eSR;
    private boolean eSS;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eST;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eSS = false;
        this.eST = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View eSV;
                    private View eSW;
                    private TabLiveStageLiveView eSX;
                    private int eSY;
                    private int eSZ;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.eSX = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.eSV = view.findViewById(R.id.recom_live_item_left_space);
                        this.eSW = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.eSX.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSV.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSW.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.eSS) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eSW.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eSW.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.eSO.getItemCount() - 1 == i2) {
                                this.eSW.setVisibility(0);
                            } else {
                                this.eSW.setVisibility(8);
                            }
                        }
                        this.eSV.setLayoutParams(layoutParams);
                        this.eSW.setLayoutParams(layoutParams2);
                        blQ();
                        an anVar = new an("c13558");
                        anVar.cI("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.eSX.onChangeSkinType();
                    }

                    private void blQ() {
                        this.eSY = b.this.getRealWidth();
                        this.eSZ = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSX.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.eSY, this.eSZ);
                        } else {
                            layoutParams.width = this.eSY;
                            layoutParams.height = this.eSZ;
                        }
                        layoutParams.gravity = 1;
                        this.eSX.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.eSS = false;
        this.eSP = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.eSQ = (int) ((this.eSP * 9.0d) / 16.0d);
        this.eSR = com.baidu.tieba.ala.alasquare.live_tab.c.es(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.duT = getView().findViewById(R.id.recom_live_bottom_divider);
        this.eSN = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.eSN.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        blP();
        this.eSO = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.eST, false);
        this.eSN.setAdapter(this.eSO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.eSS ? this.eSR[0] : this.eSP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.eSS ? this.eSR[1] : this.eSQ;
    }

    private void blP() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSN.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.eSN.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.duT, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.ePL != null) {
            this.eSS = v.getCount(cVar.ePL.ePJ) == 1;
            blP();
            this.eSO.setData(cVar.ePL.ePJ);
            this.eSO.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
