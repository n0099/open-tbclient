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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View eNL;
    private AlaBannerRecyclerView guT;
    private com.baidu.tieba.ala.alasquare.widget.banner.a guU;
    private int guV;
    private int guW;
    private int[] guX;
    private boolean guY;
    private com.baidu.tieba.ala.alasquare.widget.banner.c guZ;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.guY = false;
        this.guZ = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gvb;
                    private View gvc;
                    private TabLiveStageLiveView gvd;
                    private int gve;
                    private int gvf;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gvd = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gvb = view.findViewById(R.id.recom_live_item_left_space);
                        this.gvc = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gvd.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gvb.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gvc.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.guY) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gvc.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gvc.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.guU.getItemCount() - 1 == i2) {
                                this.gvc.setVisibility(0);
                            } else {
                                this.gvc.setVisibility(8);
                            }
                        }
                        this.gvb.setLayoutParams(layoutParams);
                        this.gvc.setLayoutParams(layoutParams2);
                        bSD();
                        ar arVar = new ar("c13558");
                        arVar.dY("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.gvd.onChangeSkinType();
                    }

                    private void bSD() {
                        this.gve = b.this.getRealWidth();
                        this.gvf = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gvd.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gve, this.gvf);
                        } else {
                            layoutParams.width = this.gve;
                            layoutParams.height = this.gvf;
                        }
                        layoutParams.gravity = 1;
                        this.gvd.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.guY = false;
        this.guV = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.guW = (int) ((this.guV * 9.0d) / 16.0d);
        this.guX = com.baidu.tieba.ala.alasquare.live_tab.c.fD(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eNL = getView().findViewById(R.id.recom_live_bottom_divider);
        this.guT = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.guT.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bSC();
        this.guU = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.guZ, false);
        this.guT.setAdapter(this.guU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.guY ? this.guX[0] : this.guV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.guY ? this.guX[1] : this.guW;
    }

    private void bSC() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guT.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.guT.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.grI != null) {
            this.guY = y.getCount(cVar.grI.grG) == 1;
            bSC();
            this.guU.setData(cVar.grI.grG);
            this.guU.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
