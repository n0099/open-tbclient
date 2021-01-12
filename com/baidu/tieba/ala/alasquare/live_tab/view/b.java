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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dyW;
    private View eSX;
    private AlaBannerRecyclerView gBm;
    private AlaBannerRecyclerAdapter gBn;
    private int gBo;
    private int gBp;
    private int[] gBq;
    private boolean gBr;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gBs;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gBr = false;
        this.gBs = new com.baidu.tieba.ala.alasquare.widget.banner.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup2, int i) {
                return new AlaBannerViewHolder<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gBu;
                    private View gBv;
                    private TabLiveStageLiveView gBw;
                    private int gBx;
                    private int gBy;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void ap(View view) {
                        this.gBw = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gBu = view.findViewById(R.id.recom_live_item_left_space);
                        this.gBv = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gBw.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBu.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gBv.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gBr) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gBv.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gBv.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gBn.getItemCount() - 1 == i2) {
                                this.gBv.setVisibility(0);
                            } else {
                                this.gBv.setVisibility(8);
                            }
                        }
                        this.gBu.setLayoutParams(layoutParams);
                        this.gBv.setLayoutParams(layoutParams2);
                        bRo();
                        aq aqVar = new aq("c13558");
                        aqVar.dW("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                        this.gBw.onChangeSkinType();
                    }

                    private void bRo() {
                        this.gBx = b.this.getRealWidth();
                        this.gBy = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBw.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gBx, this.gBy);
                        } else {
                            layoutParams.width = this.gBx;
                            layoutParams.height = this.gBy;
                        }
                        layoutParams.gravity = 1;
                        this.gBw.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gBr = false;
        this.gBo = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.gBp = (int) ((this.gBo * 9.0d) / 16.0d);
        this.gBq = com.baidu.tieba.ala.alasquare.live_tab.c.fV(this.mContext);
        initView();
    }

    private void initView() {
        this.dyW = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eSX = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gBm = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gBm.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bRn();
        this.gBn = new AlaBannerRecyclerAdapter(getContext(), this.gBs, false);
        this.gBm.setAdapter(this.gBn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gBr ? this.gBq[0] : this.gBo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gBr ? this.gBq[1] : this.gBp;
    }

    private void bRn() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBm.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gBm.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
        ao.setBackgroundColor(this.eSX, R.color.CAM_X0204);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gya != null) {
            this.gBr = x.getCount(cVar.gya.gxY) == 1;
            bRn();
            this.gBn.setData(cVar.gya.gxY);
            this.gBn.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
