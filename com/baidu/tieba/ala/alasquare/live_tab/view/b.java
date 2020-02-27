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
    private View cVt;
    private AlaBannerRecyclerView eoL;
    private com.baidu.tieba.ala.alasquare.widget.banner.a eoM;
    private int eoN;
    private int eoO;
    private int[] eoP;
    private boolean eoQ;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eoR;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eoQ = false;
        this.eoR = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View eoT;
                    private View eoU;
                    private TabLiveStageLiveView eoV;
                    private int eoW;
                    private int eoX;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.eoV = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.eoT = view.findViewById(R.id.recom_live_item_left_space);
                        this.eoU = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.eoV.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoT.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoU.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.eoQ) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eoU.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.eoU.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.eoM.getItemCount() - 1 == i2) {
                                this.eoU.setVisibility(0);
                            } else {
                                this.eoU.setVisibility(8);
                            }
                        }
                        this.eoT.setLayoutParams(layoutParams);
                        this.eoU.setLayoutParams(layoutParams2);
                        bcS();
                        an anVar = new an("c13558");
                        anVar.cy("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.eoV.onChangeSkinType();
                    }

                    private void bcS() {
                        this.eoW = b.this.getRealWidth();
                        this.eoX = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoV.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.eoW, this.eoX);
                        } else {
                            layoutParams.width = this.eoW;
                            layoutParams.height = this.eoX;
                        }
                        layoutParams.gravity = 1;
                        this.eoV.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.eoQ = false;
        this.eoN = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.eoO = (int) ((this.eoN * 9.0d) / 16.0d);
        this.eoP = com.baidu.tieba.ala.alasquare.live_tab.c.eF(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cVt = getView().findViewById(R.id.recom_live_bottom_divider);
        this.eoL = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.eoL.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bcR();
        this.eoM = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.eoR, false);
        this.eoL.setAdapter(this.eoM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.eoQ ? this.eoP[0] : this.eoN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.eoQ ? this.eoP[1] : this.eoO;
    }

    private void bcR() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoL.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.eoL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cVt, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.elG != null) {
            this.eoQ = v.getCount(cVar.elG.elE) == 1;
            bcR();
            this.eoM.setData(cVar.elG.elE);
            this.eoM.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
