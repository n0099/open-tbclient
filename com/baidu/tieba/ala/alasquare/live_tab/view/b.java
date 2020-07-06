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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dPI;
    private AlaBannerRecyclerView fqX;
    private com.baidu.tieba.ala.alasquare.widget.banner.a fqY;
    private int fqZ;
    private int fra;
    private int[] frb;
    private boolean frd;
    private com.baidu.tieba.ala.alasquare.widget.banner.c fre;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.frd = false;
        this.fre = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b l(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View frg;
                    private View frh;
                    private TabLiveStageLiveView fri;
                    private int frj;
                    private int frk;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.fri = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.frg = view.findViewById(R.id.recom_live_item_left_space);
                        this.frh = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.fri.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.frg.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.frh.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.frd) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.frh.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.frh.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.fqY.getItemCount() - 1 == i2) {
                                this.frh.setVisibility(0);
                            } else {
                                this.frh.setVisibility(8);
                            }
                        }
                        this.frg.setLayoutParams(layoutParams);
                        this.frh.setLayoutParams(layoutParams2);
                        bul();
                        ao aoVar = new ao("c13558");
                        aoVar.dk("entryname", "推荐");
                        TiebaStatic.log(aoVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.fri.onChangeSkinType();
                    }

                    private void bul() {
                        this.frj = b.this.getRealWidth();
                        this.frk = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fri.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.frj, this.frk);
                        } else {
                            layoutParams.width = this.frj;
                            layoutParams.height = this.frk;
                        }
                        layoutParams.gravity = 1;
                        this.fri.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.frd = false;
        this.fqZ = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.fra = (int) ((this.fqZ * 9.0d) / 16.0d);
        this.frb = com.baidu.tieba.ala.alasquare.live_tab.c.ew(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.dPI = getView().findViewById(R.id.recom_live_bottom_divider);
        this.fqX = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.fqX.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        buk();
        this.fqY = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.fre, false);
        this.fqX.setAdapter(this.fqY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.frd ? this.frb[0] : this.fqZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.frd ? this.frb[1] : this.fra;
    }

    private void buk() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fqX.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.fqX.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        an.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.dPI, R.color.cp_bg_line_c);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.fnU != null) {
            this.frd = w.getCount(cVar.fnU.fnS) == 1;
            buk();
            this.fqY.setData(cVar.fnU.fnS);
            this.fqY.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
