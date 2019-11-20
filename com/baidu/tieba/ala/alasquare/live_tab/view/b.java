package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.b> {
    private View bgU;
    private View ceJ;
    private AlaBannerRecyclerView dyH;
    private com.baidu.tieba.ala.alasquare.widget.banner.a dyI;
    private int dyJ;
    private int dyK;
    private int[] dyL;
    private boolean dyM;
    private com.baidu.tieba.ala.alasquare.widget.banner.c dyN;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dyM = false;
        this.dyN = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b j(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<bh>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View dyP;
                    private View dyQ;
                    private TabLiveStageLiveView dyR;
                    private int dyS;
                    private int dyT;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void W(View view) {
                        this.dyR = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.dyP = view.findViewById(R.id.recom_live_item_left_space);
                        this.dyQ = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: b */
                    public void h(int i2, bh bhVar) {
                        this.dyR.setData(bhVar, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyP.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dyQ.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.dyM) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.dyQ.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.dyQ.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.dyI.getItemCount() - 1 == i2) {
                                this.dyQ.setVisibility(0);
                            } else {
                                this.dyQ.setVisibility(8);
                            }
                        }
                        this.dyP.setLayoutParams(layoutParams);
                        this.dyQ.setLayoutParams(layoutParams2);
                        aJJ();
                        TiebaStatic.log("c13558");
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.dyR.onChangeSkinType();
                    }

                    private void aJJ() {
                        this.dyS = b.this.getRealWidth();
                        this.dyT = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyR.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.dyS, this.dyT);
                        } else {
                            layoutParams.width = this.dyS;
                            layoutParams.height = this.dyT;
                        }
                        layoutParams.gravity = 1;
                        this.dyR.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.dyM = false;
        this.dyJ = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.dyK = (int) ((this.dyJ * 9.0d) / 16.0d);
        this.dyL = com.baidu.tieba.ala.alasquare.live_tab.b.dj(this.mContext);
        initView();
    }

    private void initView() {
        this.bgU = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.ceJ = getView().findViewById(R.id.recom_live_bottom_divider);
        this.dyH = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.dyH.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        aJI();
        this.dyI = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.dyN, false);
        this.dyH.setAdapter(this.dyI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.dyM ? this.dyL[0] : this.dyJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.dyM ? this.dyL[1] : this.dyK;
    }

    private void aJI() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyH.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.dyH.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.b bVar) {
        if (bVar != null && bVar.dwo != null) {
            this.dyM = v.getCount(bVar.dwo.dwm) == 1;
            aJI();
            this.dyI.setData(bVar.dwo.dwm);
            this.dyI.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
