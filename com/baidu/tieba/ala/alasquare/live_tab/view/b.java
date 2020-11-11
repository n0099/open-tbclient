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
    private View eIp;
    private AlaBannerRecyclerView gnb;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gnc;
    private int gnd;
    private int gne;
    private int[] gnf;
    private boolean gng;
    private com.baidu.tieba.ala.alasquare.widget.banner.c gnh;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gng = false;
        this.gnh = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b p(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gnj;
                    private View gnk;
                    private TabLiveStageLiveView gnl;
                    private int gnm;
                    private int gnn;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void al(View view) {
                        this.gnl = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gnj = view.findViewById(R.id.recom_live_item_left_space);
                        this.gnk = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gnl.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnj.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gnk.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gng) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gnk.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gnk.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gnc.getItemCount() - 1 == i2) {
                                this.gnk.setVisibility(0);
                            } else {
                                this.gnk.setVisibility(8);
                            }
                        }
                        this.gnj.setLayoutParams(layoutParams);
                        this.gnk.setLayoutParams(layoutParams2);
                        bPy();
                        aq aqVar = new aq("c13558");
                        aqVar.dR("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.gnl.onChangeSkinType();
                    }

                    private void bPy() {
                        this.gnm = b.this.getRealWidth();
                        this.gnn = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnl.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gnm, this.gnn);
                        } else {
                            layoutParams.width = this.gnm;
                            layoutParams.height = this.gnn;
                        }
                        layoutParams.gravity = 1;
                        this.gnl.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gng = false;
        this.gnd = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.gne = (int) ((this.gnd * 9.0d) / 16.0d);
        this.gnf = com.baidu.tieba.ala.alasquare.live_tab.c.eX(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eIp = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gnb = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gnb.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bPx();
        this.gnc = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.gnh, false);
        this.gnb.setAdapter(this.gnc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gng ? this.gnf[0] : this.gnd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gng ? this.gnf[1] : this.gne;
    }

    private void bPx() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnb.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gnb.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.eIp, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gjQ != null) {
            this.gng = y.getCount(cVar.gjQ.gjO) == 1;
            bPx();
            this.gnc.setData(cVar.gjQ.gjO);
            this.gnc.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
