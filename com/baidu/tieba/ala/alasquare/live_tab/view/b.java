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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dBb;
    private View eVm;
    private AlaBannerRecyclerView gDW;
    private AlaBannerRecyclerAdapter gDX;
    private int gDY;
    private int gDZ;
    private int[] gEa;
    private boolean gEb;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gEc;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gEb = false;
        this.gEc = new com.baidu.tieba.ala.alasquare.widget.banner.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup2, int i) {
                return new AlaBannerViewHolder<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gEe;
                    private View gEf;
                    private TabLiveStageLiveView gEg;
                    private int gEh;
                    private int gEi;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gEg = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gEe = view.findViewById(R.id.recom_live_item_left_space);
                        this.gEf = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gEg.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEe.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEf.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gEb) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gEf.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gEf.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gDX.getItemCount() - 1 == i2) {
                                this.gEf.setVisibility(0);
                            } else {
                                this.gEf.setVisibility(8);
                            }
                        }
                        this.gEe.setLayoutParams(layoutParams);
                        this.gEf.setLayoutParams(layoutParams2);
                        bRR();
                        ar arVar = new ar("c13558");
                        arVar.dR("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                        this.gEg.onChangeSkinType();
                    }

                    private void bRR() {
                        this.gEh = b.this.getRealWidth();
                        this.gEi = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEg.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gEh, this.gEi);
                        } else {
                            layoutParams.width = this.gEh;
                            layoutParams.height = this.gEi;
                        }
                        layoutParams.gravity = 1;
                        this.gEg.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gEb = false;
        this.gDY = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.gDZ = (int) ((this.gDY * 9.0d) / 16.0d);
        this.gEa = com.baidu.tieba.ala.alasquare.live_tab.c.fU(this.mContext);
        initView();
    }

    private void initView() {
        this.dBb = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eVm = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gDW = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gDW.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bRQ();
        this.gDX = new AlaBannerRecyclerAdapter(getContext(), this.gEc, false);
        this.gDW.setAdapter(this.gDX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gEb ? this.gEa[0] : this.gDY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gEb ? this.gEa[1] : this.gDZ;
    }

    private void bRQ() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDW.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gDW.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gAK != null) {
            this.gEb = y.getCount(cVar.gAK.gAI) == 1;
            bRQ();
            this.gDX.setData(cVar.gAK.gAI);
            this.gDX.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
