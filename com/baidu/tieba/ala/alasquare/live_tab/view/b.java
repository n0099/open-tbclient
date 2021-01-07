package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dDI;
    private View eXI;
    private AlaBannerRecyclerView gFS;
    private AlaBannerRecyclerAdapter gFT;
    private int gFU;
    private int gFV;
    private int[] gFW;
    private boolean gFX;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gFY;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFX = false;
        this.gFY = new com.baidu.tieba.ala.alasquare.widget.banner.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup2, int i) {
                return new AlaBannerViewHolder<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gGa;
                    private View gGb;
                    private TabLiveStageLiveView gGc;
                    private int gGd;
                    private int gGe;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gGc = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gGa = view.findViewById(R.id.recom_live_item_left_space);
                        this.gGb = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gGc.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGa.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gGb.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gFX) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gGb.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gGb.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gFT.getItemCount() - 1 == i2) {
                                this.gGb.setVisibility(0);
                            } else {
                                this.gGb.setVisibility(8);
                            }
                        }
                        this.gGa.setLayoutParams(layoutParams);
                        this.gGb.setLayoutParams(layoutParams2);
                        bVg();
                        aq aqVar = new aq("c13558");
                        aqVar.dX("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                        this.gGc.onChangeSkinType();
                    }

                    private void bVg() {
                        this.gGd = b.this.getRealWidth();
                        this.gGe = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGc.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gGd, this.gGe);
                        } else {
                            layoutParams.width = this.gGd;
                            layoutParams.height = this.gGe;
                        }
                        layoutParams.gravity = 1;
                        this.gGc.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gFX = false;
        this.gFU = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.gFV = (int) ((this.gFU * 9.0d) / 16.0d);
        this.gFW = com.baidu.tieba.ala.alasquare.live_tab.c.fX(this.mContext);
        initView();
    }

    private void initView() {
        this.dDI = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eXI = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gFS = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gFS.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bVf();
        this.gFT = new AlaBannerRecyclerAdapter(getContext(), this.gFY, false);
        this.gFS.setAdapter(this.gFT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gFX ? this.gFW[0] : this.gFU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gFX ? this.gFW[1] : this.gFV;
    }

    private void bVf() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFS.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gFS.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
        ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gCH != null) {
            this.gFX = x.getCount(cVar.gCH.gCF) == 1;
            bVf();
            this.gFT.setData(cVar.gCH.gCF);
            this.gFT.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
