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
    private View cVv;
    private AlaBannerRecyclerView eoZ;
    private com.baidu.tieba.ala.alasquare.widget.banner.a epa;
    private int epb;
    private int epc;
    private int[] epd;
    private boolean epe;
    private com.baidu.tieba.ala.alasquare.widget.banner.c epf;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.epe = false;
        this.epf = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View eph;
                    private View epi;
                    private TabLiveStageLiveView epj;
                    private int epk;
                    private int epl;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.epj = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.eph = view.findViewById(R.id.recom_live_item_left_space);
                        this.epi = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.epj.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eph.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.epi.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.epe) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.epi.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.epi.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.epa.getItemCount() - 1 == i2) {
                                this.epi.setVisibility(0);
                            } else {
                                this.epi.setVisibility(8);
                            }
                        }
                        this.eph.setLayoutParams(layoutParams);
                        this.epi.setLayoutParams(layoutParams2);
                        bcV();
                        an anVar = new an("c13558");
                        anVar.cy("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.epj.onChangeSkinType();
                    }

                    private void bcV() {
                        this.epk = b.this.getRealWidth();
                        this.epl = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epj.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.epk, this.epl);
                        } else {
                            layoutParams.width = this.epk;
                            layoutParams.height = this.epl;
                        }
                        layoutParams.gravity = 1;
                        this.epj.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.epe = false;
        this.epb = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.epc = (int) ((this.epb * 9.0d) / 16.0d);
        this.epd = com.baidu.tieba.ala.alasquare.live_tab.c.eF(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cVv = getView().findViewById(R.id.recom_live_bottom_divider);
        this.eoZ = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.eoZ.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bcU();
        this.epa = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.epf, false);
        this.eoZ.setAdapter(this.epa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.epe ? this.epd[0] : this.epb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.epe ? this.epd[1] : this.epc;
    }

    private void bcU() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoZ.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.eoZ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cVv, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.elU != null) {
            this.epe = v.getCount(cVar.elU.elS) == 1;
            bcU();
            this.epa.setData(cVar.elU.elS);
            this.epa.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
