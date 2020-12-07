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
    private AlaBannerRecyclerView guR;
    private com.baidu.tieba.ala.alasquare.widget.banner.a guS;
    private int guT;
    private int guU;
    private int[] guV;
    private boolean guW;
    private com.baidu.tieba.ala.alasquare.widget.banner.c guX;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.guW = false;
        this.guX = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View guZ;
                    private View gva;
                    private TabLiveStageLiveView gvb;
                    private int gvc;
                    private int gvd;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.gvb = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.guZ = view.findViewById(R.id.recom_live_item_left_space);
                        this.gva = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gvb.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guZ.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gva.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.guW) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gva.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gva.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.guS.getItemCount() - 1 == i2) {
                                this.gva.setVisibility(0);
                            } else {
                                this.gva.setVisibility(8);
                            }
                        }
                        this.guZ.setLayoutParams(layoutParams);
                        this.gva.setLayoutParams(layoutParams2);
                        bSC();
                        ar arVar = new ar("c13558");
                        arVar.dY("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.gvb.onChangeSkinType();
                    }

                    private void bSC() {
                        this.gvc = b.this.getRealWidth();
                        this.gvd = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gvb.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gvc, this.gvd);
                        } else {
                            layoutParams.width = this.gvc;
                            layoutParams.height = this.gvd;
                        }
                        layoutParams.gravity = 1;
                        this.gvb.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.guW = false;
        this.guT = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.guU = (int) ((this.guT * 9.0d) / 16.0d);
        this.guV = com.baidu.tieba.ala.alasquare.live_tab.c.fD(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eNL = getView().findViewById(R.id.recom_live_bottom_divider);
        this.guR = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.guR.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bSB();
        this.guS = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.guX, false);
        this.guR.setAdapter(this.guS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.guW ? this.guV[0] : this.guT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.guW ? this.guV[1] : this.guU;
    }

    private void bSB() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guR.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.guR.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.grG != null) {
            this.guW = y.getCount(cVar.grG.grE) == 1;
            bSB();
            this.guS.setData(cVar.grG.grE);
            this.guS.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
