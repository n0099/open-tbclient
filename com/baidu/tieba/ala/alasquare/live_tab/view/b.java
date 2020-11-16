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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View eGI;
    private AlaBannerRecyclerView gmI;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gmJ;
    private int gmK;
    private int gmL;
    private int[] gmM;
    private boolean gmN;
    private com.baidu.tieba.ala.alasquare.widget.banner.c gmO;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gmN = false;
        this.gmO = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gmQ;
                    private View gmR;
                    private TabLiveStageLiveView gmS;
                    private int gmT;
                    private int gmU;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gmS = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gmQ = view.findViewById(R.id.recom_live_item_left_space);
                        this.gmR = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gmS.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmQ.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gmR.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gmN) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gmR.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gmR.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gmJ.getItemCount() - 1 == i2) {
                                this.gmR.setVisibility(0);
                            } else {
                                this.gmR.setVisibility(8);
                            }
                        }
                        this.gmQ.setLayoutParams(layoutParams);
                        this.gmR.setLayoutParams(layoutParams2);
                        bOR();
                        ar arVar = new ar("c13558");
                        arVar.dR("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.gmS.onChangeSkinType();
                    }

                    private void bOR() {
                        this.gmT = b.this.getRealWidth();
                        this.gmU = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmS.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gmT, this.gmU);
                        } else {
                            layoutParams.width = this.gmT;
                            layoutParams.height = this.gmU;
                        }
                        layoutParams.gravity = 1;
                        this.gmS.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gmN = false;
        this.gmK = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.gmL = (int) ((this.gmK * 9.0d) / 16.0d);
        this.gmM = com.baidu.tieba.ala.alasquare.live_tab.c.eX(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eGI = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gmI = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gmI.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bOQ();
        this.gmJ = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.gmO, false);
        this.gmI.setAdapter(this.gmJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gmN ? this.gmM[0] : this.gmK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gmN ? this.gmM[1] : this.gmL;
    }

    private void bOQ() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmI.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gmI.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eGI, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gjx != null) {
            this.gmN = y.getCount(cVar.gjx.gjv) == 1;
            bOQ();
            this.gmJ.setData(cVar.gjx.gjv);
            this.gmJ.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
