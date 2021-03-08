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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dCC;
    private View eWL;
    private AlaBannerRecyclerView gFT;
    private AlaBannerRecyclerAdapter gFU;
    private int gFV;
    private int gFW;
    private int[] gFX;
    private boolean gFY;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gFZ;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFY = false;
        this.gFZ = new com.baidu.tieba.ala.alasquare.widget.banner.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup2, int i) {
                return new AlaBannerViewHolder<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gGb;
                    private View gGc;
                    private TabLiveStageLiveView gGd;
                    private int gGe;
                    private int gGf;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gGd = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gGb = view.findViewById(R.id.recom_live_item_left_space);
                        this.gGc = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gGd.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGb.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gGc.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gFY) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gGc.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gGc.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gFU.getItemCount() - 1 == i2) {
                                this.gGc.setVisibility(0);
                            } else {
                                this.gGc.setVisibility(8);
                            }
                        }
                        this.gGb.setLayoutParams(layoutParams);
                        this.gGc.setLayoutParams(layoutParams2);
                        bSe();
                        ar arVar = new ar("c13558");
                        arVar.dR("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                        this.gGd.onChangeSkinType();
                    }

                    private void bSe() {
                        this.gGe = b.this.getRealWidth();
                        this.gGf = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGd.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gGe, this.gGf);
                        } else {
                            layoutParams.width = this.gGe;
                            layoutParams.height = this.gGf;
                        }
                        layoutParams.gravity = 1;
                        this.gGd.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gFY = false;
        this.gFV = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.gFW = (int) ((this.gFV * 9.0d) / 16.0d);
        this.gFX = com.baidu.tieba.ala.alasquare.live_tab.c.fT(this.mContext);
        initView();
    }

    private void initView() {
        this.dCC = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eWL = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gFT = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gFT.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bSd();
        this.gFU = new AlaBannerRecyclerAdapter(getContext(), this.gFZ, false);
        this.gFT.setAdapter(this.gFU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gFY ? this.gFX[0] : this.gFV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gFY ? this.gFX[1] : this.gFW;
    }

    private void bSd() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFT.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gFT.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eWL, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gCH != null) {
            this.gFY = y.getCount(cVar.gCH.gCF) == 1;
            bSd();
            this.gFU.setData(cVar.gCH.gCF);
            this.gFU.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
