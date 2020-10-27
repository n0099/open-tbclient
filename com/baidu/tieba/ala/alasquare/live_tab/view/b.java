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
    private View eCA;
    private AlaBannerRecyclerView ghn;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gho;
    private int ghp;
    private int ghq;
    private int[] ghr;
    private boolean ghs;
    private com.baidu.tieba.ala.alasquare.widget.banner.c ght;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ghs = false;
        this.ght = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View ghv;
                    private View ghw;
                    private TabLiveStageLiveView ghx;
                    private int ghy;
                    private int ghz;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ah(View view) {
                        this.ghx = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.ghv = view.findViewById(R.id.recom_live_item_left_space);
                        this.ghw = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void l(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.ghx.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghv.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ghw.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.ghs) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ghw.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ghw.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gho.getItemCount() - 1 == i2) {
                                this.ghw.setVisibility(0);
                            } else {
                                this.ghw.setVisibility(8);
                            }
                        }
                        this.ghv.setLayoutParams(layoutParams);
                        this.ghw.setLayoutParams(layoutParams2);
                        bMY();
                        aq aqVar = new aq("c13558");
                        aqVar.dR("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.ghx.onChangeSkinType();
                    }

                    private void bMY() {
                        this.ghy = b.this.getRealWidth();
                        this.ghz = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghx.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.ghy, this.ghz);
                        } else {
                            layoutParams.width = this.ghy;
                            layoutParams.height = this.ghz;
                        }
                        layoutParams.gravity = 1;
                        this.ghx.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.ghs = false;
        this.ghp = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.ghq = (int) ((this.ghp * 9.0d) / 16.0d);
        this.ghr = com.baidu.tieba.ala.alasquare.live_tab.c.eX(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eCA = getView().findViewById(R.id.recom_live_bottom_divider);
        this.ghn = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.ghn.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bMX();
        this.gho = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.ght, false);
        this.ghn.setAdapter(this.gho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.ghs ? this.ghr[0] : this.ghp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.ghs ? this.ghr[1] : this.ghq;
    }

    private void bMX() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghn.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.ghn.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.eCA, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gea != null) {
            this.ghs = y.getCount(cVar.gea.gdY) == 1;
            bMX();
            this.gho.setData(cVar.gea.gdY);
            this.gho.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
