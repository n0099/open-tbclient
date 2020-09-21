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
    private View ehT;
    private AlaBannerRecyclerView fKS;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fKT;
    private int fKU;
    private int fKV;
    private int[] fKW;
    private boolean fKX;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fKY;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fKX = false;
        this.fKY = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b n(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View fLa;
                    private View fLb;
                    private TabLiveStageLiveView fLc;
                    private int fLd;
                    private int fLe;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void am(View view) {
                        this.fLc = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.fLa = view.findViewById(R.id.recom_live_item_left_space);
                        this.fLb = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fLc.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLa.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fLb.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.fKX) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fLb.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fLb.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fKT.getItemCount() - 1 == i2) {
                                this.fLb.setVisibility(0);
                            } else {
                                this.fLb.setVisibility(8);
                            }
                        }
                        this.fLa.setLayoutParams(layoutParams);
                        this.fLb.setLayoutParams(layoutParams2);
                        bHK();
                        aq aqVar = new aq("c13558");
                        aqVar.dF("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fLc.onChangeSkinType();
                    }

                    private void bHK() {
                        this.fLd = b.this.getRealWidth();
                        this.fLe = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLc.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.fLd, this.fLe);
                        } else {
                            layoutParams.width = this.fLd;
                            layoutParams.height = this.fLe;
                        }
                        layoutParams.gravity = 1;
                        this.fLc.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.fKX = false;
        this.fKU = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fKV = (int) ((this.fKU * 9.0d) / 16.0d);
        this.fKW = com.baidu.tieba.ala.alasquare.live_tab.c.eP(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.ehT = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fKS = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fKS.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bHJ();
        this.fKT = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fKY, false);
        this.fKS.setAdapter(this.fKT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.fKX ? this.fKW[0] : this.fKU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.fKX ? this.fKW[1] : this.fKV;
    }

    private void bHJ() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKS.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fKS.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fHN != null) {
            this.fKX = y.getCount(cVar.fHN.fHL) == 1;
            bHJ();
            this.fKT.setData(cVar.fHN.fHL);
            this.fKT.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
