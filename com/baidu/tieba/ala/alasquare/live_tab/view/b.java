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
    private AlaBannerRecyclerView ffA;
    private com.baidu.tieba.ala.alasquare.widget.banner.a ffB;
    private int ffC;
    private int ffD;
    private int[] ffE;
    private boolean ffF;
    private com.baidu.tieba.ala.alasquare.widget.banner.c ffG;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ffF = false;
        this.ffG = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b k(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View ffI;
                    private View ffJ;
                    private TabLiveStageLiveView ffK;
                    private int ffL;
                    private int ffM;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.ffK = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.ffI = view.findViewById(R.id.recom_live_item_left_space);
                        this.ffJ = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.ffK.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffI.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ffJ.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.ffF) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ffJ.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ffJ.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.ffB.getItemCount() - 1 == i2) {
                                this.ffJ.setVisibility(0);
                            } else {
                                this.ffJ.setVisibility(8);
                            }
                        }
                        this.ffI.setLayoutParams(layoutParams);
                        this.ffJ.setLayoutParams(layoutParams2);
                        brm();
                        an anVar = new an("c13558");
                        anVar.dh("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.ffK.onChangeSkinType();
                    }

                    private void brm() {
                        this.ffL = b.this.getRealWidth();
                        this.ffM = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffK.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.ffL, this.ffM);
                        } else {
                            layoutParams.width = this.ffL;
                            layoutParams.height = this.ffM;
                        }
                        layoutParams.gravity = 1;
                        this.ffK.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.ffF = false;
        this.ffC = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.ffD = (int) ((this.ffC * 9.0d) / 16.0d);
        this.ffE = com.baidu.tieba.ala.alasquare.live_tab.c.ev(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.dIS = getView().findViewById(R.id.recom_live_bottom_divider);
        this.ffA = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.ffA.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        brl();
        this.ffB = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.ffG, false);
        this.ffA.setAdapter(this.ffB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.ffF ? this.ffE[0] : this.ffC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.ffF ? this.ffE[1] : this.ffD;
    }

    private void brl() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffA.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.ffA.setLayoutParams(layoutParams);
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
        if (cVar != null && cVar.fcz != null) {
            this.ffF = v.getCount(cVar.fcz.fcx) == 1;
            brl();
            this.ffB.setData(cVar.fcz.fcx);
            this.ffB.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
