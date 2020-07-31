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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dWa;
    private AlaBannerRecyclerView fwh;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fwi;
    private int fwj;
    private int fwk;
    private int[] fwl;
    private boolean fwm;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fwn;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fwm = false;
        this.fwn = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b l(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View fwp;
                    private View fwq;
                    private TabLiveStageLiveView fwr;
                    private int fws;
                    private int fwt;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void aj(View view) {
                        this.fwr = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.fwp = view.findViewById(R.id.recom_live_item_left_space);
                        this.fwq = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fwr.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwp.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fwq.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.fwm) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fwq.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fwq.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fwi.getItemCount() - 1 == i2) {
                                this.fwq.setVisibility(0);
                            } else {
                                this.fwq.setVisibility(8);
                            }
                        }
                        this.fwp.setLayoutParams(layoutParams);
                        this.fwq.setLayoutParams(layoutParams2);
                        bxu();
                        ap apVar = new ap("c13558");
                        apVar.dn("entryname", "推荐");
                        TiebaStatic.log(apVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fwr.onChangeSkinType();
                    }

                    private void bxu() {
                        this.fws = b.this.getRealWidth();
                        this.fwt = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwr.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.fws, this.fwt);
                        } else {
                            layoutParams.width = this.fws;
                            layoutParams.height = this.fwt;
                        }
                        layoutParams.gravity = 1;
                        this.fwr.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.fwm = false;
        this.fwj = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fwk = (int) ((this.fwj * 9.0d) / 16.0d);
        this.fwl = com.baidu.tieba.ala.alasquare.live_tab.c.eB(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.dWa = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fwh = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fwh.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bxt();
        this.fwi = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fwn, false);
        this.fwh.setAdapter(this.fwi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.fwm ? this.fwl[0] : this.fwj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.fwm ? this.fwl[1] : this.fwk;
    }

    private void bxt() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwh.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fwh.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.ftd != null) {
            this.fwm = x.getCount(cVar.ftd.ftb) == 1;
            bxt();
            this.fwi.setData(cVar.ftd.ftb);
            this.fwi.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
