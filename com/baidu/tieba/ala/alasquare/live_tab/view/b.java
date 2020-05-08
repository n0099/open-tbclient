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
    private View duX;
    private AlaBannerRecyclerView eSS;
    private com.baidu.tieba.ala.alasquare.widget.banner.a eST;
    private int eSU;
    private int eSV;
    private int[] eSW;
    private boolean eSX;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eSY;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eSX = false;
        this.eSY = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View eTa;
                    private View eTb;
                    private TabLiveStageLiveView eTc;
                    private int eTd;
                    private int eTe;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.eTc = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.eTa = view.findViewById(R.id.recom_live_item_left_space);
                        this.eTb = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.eTc.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTa.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eTb.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.eSX) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eTb.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eTb.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.eST.getItemCount() - 1 == i2) {
                                this.eTb.setVisibility(0);
                            } else {
                                this.eTb.setVisibility(8);
                            }
                        }
                        this.eTa.setLayoutParams(layoutParams);
                        this.eTb.setLayoutParams(layoutParams2);
                        blO();
                        an anVar = new an("c13558");
                        anVar.cI("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.eTc.onChangeSkinType();
                    }

                    private void blO() {
                        this.eTd = b.this.getRealWidth();
                        this.eTe = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTc.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.eTd, this.eTe);
                        } else {
                            layoutParams.width = this.eTd;
                            layoutParams.height = this.eTe;
                        }
                        layoutParams.gravity = 1;
                        this.eTc.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.eSX = false;
        this.eSU = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.eSV = (int) ((this.eSU * 9.0d) / 16.0d);
        this.eSW = com.baidu.tieba.ala.alasquare.live_tab.c.eg(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.duX = getView().findViewById(R.id.recom_live_bottom_divider);
        this.eSS = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.eSS.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        blN();
        this.eST = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.eSY, false);
        this.eSS.setAdapter(this.eST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.eSX ? this.eSW[0] : this.eSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.eSX ? this.eSW[1] : this.eSV;
    }

    private void blN() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSS.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.eSS.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.duX, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.ePQ != null) {
            this.eSX = v.getCount(cVar.ePQ.ePO) == 1;
            blN();
            this.eST.setData(cVar.ePQ.ePO);
            this.eST.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
