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
    private View cVu;
    private AlaBannerRecyclerView eoM;
    private com.baidu.tieba.ala.alasquare.widget.banner.a eoN;
    private int eoO;
    private int eoP;
    private int[] eoQ;
    private boolean eoR;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eoS;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eoR = false;
        this.eoS = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View eoU;
                    private View eoV;
                    private TabLiveStageLiveView eoW;
                    private int eoX;
                    private int eoY;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.eoW = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.eoU = view.findViewById(R.id.recom_live_item_left_space);
                        this.eoV = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.eoW.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoU.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoV.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.eoR) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eoV.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eoV.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.eoN.getItemCount() - 1 == i2) {
                                this.eoV.setVisibility(0);
                            } else {
                                this.eoV.setVisibility(8);
                            }
                        }
                        this.eoU.setLayoutParams(layoutParams);
                        this.eoV.setLayoutParams(layoutParams2);
                        bcU();
                        an anVar = new an("c13558");
                        anVar.cy("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.eoW.onChangeSkinType();
                    }

                    private void bcU() {
                        this.eoX = b.this.getRealWidth();
                        this.eoY = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoW.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.eoX, this.eoY);
                        } else {
                            layoutParams.width = this.eoX;
                            layoutParams.height = this.eoY;
                        }
                        layoutParams.gravity = 1;
                        this.eoW.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.eoR = false;
        this.eoO = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.eoP = (int) ((this.eoO * 9.0d) / 16.0d);
        this.eoQ = com.baidu.tieba.ala.alasquare.live_tab.c.eF(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cVu = getView().findViewById(R.id.recom_live_bottom_divider);
        this.eoM = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.eoM.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bcT();
        this.eoN = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.eoS, false);
        this.eoM.setAdapter(this.eoN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.eoR ? this.eoQ[0] : this.eoO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.eoR ? this.eoQ[1] : this.eoP;
    }

    private void bcT() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoM.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.eoM.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cVu, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.elH != null) {
            this.eoR = v.getCount(cVar.elH.elF) == 1;
            bcT();
            this.eoN.setData(cVar.elH.elF);
            this.eoN.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
