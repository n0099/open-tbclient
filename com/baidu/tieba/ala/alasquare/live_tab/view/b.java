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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View eub;
    private AlaBannerRecyclerView fXj;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fXk;
    private int fXl;
    private int fXm;
    private int[] fXn;
    private boolean fXo;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fXp;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fXo = false;
        this.fXp = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View fXr;
                    private View fXs;
                    private TabLiveStageLiveView fXt;
                    private int fXu;
                    private int fXv;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void an(View view) {
                        this.fXt = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.fXr = view.findViewById(R.id.recom_live_item_left_space);
                        this.fXs = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void i(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fXt.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXr.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fXs.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.fXo) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fXs.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.fXs.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fXk.getItemCount() - 1 == i2) {
                                this.fXs.setVisibility(0);
                            } else {
                                this.fXs.setVisibility(8);
                            }
                        }
                        this.fXr.setLayoutParams(layoutParams);
                        this.fXs.setLayoutParams(layoutParams2);
                        bKw();
                        aq aqVar = new aq("c13558");
                        aqVar.dK("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fXt.onChangeSkinType();
                    }

                    private void bKw() {
                        this.fXu = b.this.getRealWidth();
                        this.fXv = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXt.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.fXu, this.fXv);
                        } else {
                            layoutParams.width = this.fXu;
                            layoutParams.height = this.fXv;
                        }
                        layoutParams.gravity = 1;
                        this.fXt.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.fXo = false;
        this.fXl = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fXm = (int) ((this.fXl * 9.0d) / 16.0d);
        this.fXn = com.baidu.tieba.ala.alasquare.live_tab.c.eW(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eub = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fXj = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fXj.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bKv();
        this.fXk = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fXp, false);
        this.fXj.setAdapter(this.fXk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.fXo ? this.fXn[0] : this.fXl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.fXo ? this.fXn[1] : this.fXm;
    }

    private void bKv() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXj.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fXj.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.eub, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fTX != null) {
            this.fXo = y.getCount(cVar.fTX.fTV) == 1;
            bKv();
            this.fXk.setData(cVar.fTX.fTV);
            this.fXk.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
