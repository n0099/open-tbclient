package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View cRr;
    private AlaBannerRecyclerView ekA;
    private com.baidu.tieba.ala.alasquare.widget.banner.a ekB;
    private int ekC;
    private int ekD;
    private int[] ekE;
    private boolean ekF;
    private com.baidu.tieba.ala.alasquare.widget.banner.c ekG;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ekF = false;
        this.ekG = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<bj>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View ekI;
                    private View ekJ;
                    private TabLiveStageLiveView ekK;
                    private int ekL;
                    private int ekM;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.ekK = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.ekI = view.findViewById(R.id.recom_live_item_left_space);
                        this.ekJ = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, bj bjVar) {
                        this.ekK.setData(bjVar, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ekI.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ekJ.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.ekF) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ekJ.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.ekJ.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.ekB.getItemCount() - 1 == i2) {
                                this.ekJ.setVisibility(0);
                            } else {
                                this.ekJ.setVisibility(8);
                            }
                        }
                        this.ekI.setLayoutParams(layoutParams);
                        this.ekJ.setLayoutParams(layoutParams2);
                        baD();
                        an anVar = new an("c13558");
                        anVar.cp("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.ekK.onChangeSkinType();
                    }

                    private void baD() {
                        this.ekL = b.this.getRealWidth();
                        this.ekM = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ekK.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.ekL, this.ekM);
                        } else {
                            layoutParams.width = this.ekL;
                            layoutParams.height = this.ekM;
                        }
                        layoutParams.gravity = 1;
                        this.ekK.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.ekF = false;
        this.ekC = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.ekD = (int) ((this.ekC * 9.0d) / 16.0d);
        this.ekE = com.baidu.tieba.ala.alasquare.live_tab.c.eC(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cRr = getView().findViewById(R.id.recom_live_bottom_divider);
        this.ekA = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.ekA.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        baC();
        this.ekB = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.ekG, false);
        this.ekA.setAdapter(this.ekB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.ekF ? this.ekE[0] : this.ekC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.ekF ? this.ekE[1] : this.ekD;
    }

    private void baC() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ekA.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.ekA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cRr, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.ehA != null) {
            this.ekF = v.getCount(cVar.ehA.ehy) == 1;
            baC();
            this.ekB.setData(cVar.ehA.ehy);
            this.ekB.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
