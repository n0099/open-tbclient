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
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dIS;
    private AlaBannerRecyclerView ffL;
    private com.baidu.tieba.ala.alasquare.widget.banner.a ffM;
    private int ffN;
    private int ffO;
    private int[] ffP;
    private boolean ffQ;
    private com.baidu.tieba.ala.alasquare.widget.banner.c ffR;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ffQ = false;
        this.ffR = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b k(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View ffT;
                    private View ffU;
                    private TabLiveStageLiveView ffV;
                    private int ffW;
                    private int ffX;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.ffV = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.ffT = view.findViewById(R.id.recom_live_item_left_space);
                        this.ffU = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.ffV.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffT.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ffU.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.ffQ) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ffU.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ffU.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.ffM.getItemCount() - 1 == i2) {
                                this.ffU.setVisibility(0);
                            } else {
                                this.ffU.setVisibility(8);
                            }
                        }
                        this.ffT.setLayoutParams(layoutParams);
                        this.ffU.setLayoutParams(layoutParams2);
                        bro();
                        an anVar = new an("c13558");
                        anVar.dh("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.ffV.onChangeSkinType();
                    }

                    private void bro() {
                        this.ffW = b.this.getRealWidth();
                        this.ffX = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffV.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.ffW, this.ffX);
                        } else {
                            layoutParams.width = this.ffW;
                            layoutParams.height = this.ffX;
                        }
                        layoutParams.gravity = 1;
                        this.ffV.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.ffQ = false;
        this.ffN = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.ffO = (int) ((this.ffN * 9.0d) / 16.0d);
        this.ffP = com.baidu.tieba.ala.alasquare.live_tab.c.ev(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.dIS = getView().findViewById(R.id.recom_live_bottom_divider);
        this.ffL = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.ffL.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        brn();
        this.ffM = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.ffR, false);
        this.ffL.setAdapter(this.ffM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.ffQ ? this.ffP[0] : this.ffN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.ffQ ? this.ffP[1] : this.ffO;
    }

    private void brn() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffL.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.ffL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fcK != null) {
            this.ffQ = v.getCount(cVar.fcK.fcI) == 1;
            brn();
            this.ffM.setData(cVar.fcK.fcI);
            this.ffM.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
